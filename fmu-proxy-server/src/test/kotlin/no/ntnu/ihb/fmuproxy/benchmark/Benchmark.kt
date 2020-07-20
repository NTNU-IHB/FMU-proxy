package no.ntnu.ihb.fmuproxy.benchmark

import no.ntnu.ihb.fmi4j.FmiStatus
import no.ntnu.ihb.fmi4j.SlaveInstance
import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmi4j.readReal
import no.ntnu.ihb.fmuproxy.disableLog4jLoggers
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServlet
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.time.Duration
import java.util.concurrent.ExecutionException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Benchmark {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Benchmark::class.java)

        private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

        private const val stop = 0.1
        private const val stepSize = 1E-4
        private const val host = "localhost"

        private val testTimeout = Duration.ofSeconds(15)

    }

    private fun testSlave(slave: SlaveInstance): Long {
        return no.ntnu.ihb.fmuproxy.runSlave(slave, stepSize, stop) {
            slave.readReal("Temperature_Room").also { read ->
                Assertions.assertEquals(FmiStatus.OK, read.status)
                Assertions.assertTrue(read.value > 0)
            }
        }
    }

    @AfterAll
    fun tearDown() {
        fmu.close()
    }

    @Test
    fun measureTimeLocal() {

        fmu.asCoSimulationFmu().newInstance().use { slave ->
            testSlave(slave).also {
                LOG.info("Local duration=${it}ms")
            }
        }

    }

    @Test
    fun measureTimeThriftSocket() {

        Assertions.assertTimeout(testTimeout) {
            ThriftFmuSocketServer{ fmu }.use { server ->
                val port = server.start()
                ThriftFmuClient.socketClient(host, port).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("Thrift/tcp duration=${it}ms")
                        }
                    }
                }
            }
        }

    }

    @Test
    @DisabledOnOs(OS.LINUX)
    fun measureTimeThriftServlet() {

        disableLog4jLoggers()

        Assertions.assertTimeout(testTimeout) {
            ThriftFmuServlet{ fmu }.use { server ->
                val port = server.start()
                ThriftFmuClient.servletClient(host, port).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("Thrift/http duration=${it}ms")
                        }
                    }
                }
            }
        }

    }

}
