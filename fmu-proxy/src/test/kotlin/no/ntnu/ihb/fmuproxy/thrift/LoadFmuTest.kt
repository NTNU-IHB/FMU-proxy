package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.sfi.fmuproxy.TestUtils
import org.apache.thrift.transport.TTransportException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.net.URL

class LoadFmuTest {

    companion object {
        const val fmuName = "ControlledTemperature"
        val fmuFile = File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/" +
                        "$fmuName.fmu")
    }

    private fun assert(client: AbstractRpcFmuClient) {
        client.newInstance().use { slave ->
            client.modelDescription.also {
                Assertions.assertEquals("2.0", it.fmiVersion)
                Assertions.assertEquals(fmuName, it.modelName)
            }
            Assertions.assertTrue(slave.simpleSetup())
        }
    }

    @Test
    fun loadFromUrl() {
        val url = fmuFile.toURI().toURL()
        ThriftFmuSocketServer().use { server ->
            ThriftFmuClient.socketClient("localhost", server.start()).load(url).use {
                assert(it)
            }
        }
    }

    @Test
    fun loadFromFile() {
        ThriftFmuSocketServer().use { server ->
            ThriftFmuClient.socketClient("localhost", server.start()).load(fmuFile).use {
                assert(it)
            }
        }
    }

}
