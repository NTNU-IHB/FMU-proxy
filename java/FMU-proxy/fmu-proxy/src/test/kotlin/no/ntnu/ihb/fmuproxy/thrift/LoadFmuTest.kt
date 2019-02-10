package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.sfi.fmuproxy.TestUtils
import org.apache.thrift.transport.TTransportException
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.net.URL

class LoadFmuTest {

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(LoadFmuTest::class.java)
    }

    @Test
    fun test() {

        val url = File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/" +
                        "ControlledTemperature.fmu").toURI().toURL()

        ThriftFmuSocketServer().use { server ->
            val port = server.start()
            ThriftFmuClient.socketClient("localhost", port).load(url).use {
                it.newInstance().use { slave ->
                    slave.simpleSetup()
                }
            }

        }

    }

    @Test
    fun testRemote() {

        val url = URL("http://folk.ntnu.no/laht/files/ControlledTemperature.fmu")

        try {
            ThriftFmuClient.socketClient("localhost", 9090).load(url).use {
                it.newInstance().use { slave ->
                    slave.simpleSetup()
                }
            }
        } catch (ex: TTransportException) {
            LOG.warn("Could not connect to remote server..")
        }

    }

}

