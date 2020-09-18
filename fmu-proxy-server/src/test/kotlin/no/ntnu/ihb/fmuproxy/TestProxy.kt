package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmuproxy.thrift.InternalFmuServiceImpl
import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import no.ntnu.sfi.fmuproxy.TestUtils
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestProxy {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestProxy::class.java)

        private val fmu = Fmu.from(
            File(TestUtils.getTEST_FMUs(), "2.0/cs/20sim/4.6.4.8004/" +
                    "ControlledTemperature/ControlledTemperature.fmu")
        )

        private const val stepSize: Double = 1.0 / 100
        private const val stopTime: Double = 1.0
        private const val host = "localhost"
        private const val port = 9090

        private val testTimeout = Duration.ofSeconds(10)

    }

    private val proxy = InternalFmuServiceImpl(port, fmu).also {
        it.start()
    }

    @AfterAll
    fun tearDown() {
        Assertions.assertTimeout(Duration.ofSeconds(10)) {
            proxy.close()
            fmu.close()
        }
    }

    @Test
    fun testThriftSocket() {

        Assertions.assertTimeout(testTimeout) {

            val transport = TFramedTransport.Factory().getTransport(TSocket(host, port))
            val protocol = TBinaryProtocol(transport)
            transport.open()
            val client = InternalFmuService.Client(protocol)

            val mdLocal = fmu.modelDescription
            val mdRemote = client.modelDescription

            Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
            Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
            Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

            runSlave(client, stepSize, stopTime).also {
                LOG.info("Thrift (socket) duration: ${it}ms")
            }

            transport.close()

        }

    }

}
