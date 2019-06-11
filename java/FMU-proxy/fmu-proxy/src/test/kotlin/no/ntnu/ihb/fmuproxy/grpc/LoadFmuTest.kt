package no.ntnu.ihb.fmuproxy.grpc

import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileOutputStream

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
        GrpcFmuServer().use { server ->
            GrpcFmuClient("localhost", server.start()).load(url).use {
                assert(it)
            }
        }

    }

    @Test
    fun loadFromFile() {
        GrpcFmuServer().use { server ->
            GrpcFmuClient("localhost", server.start()).load(fmuFile).use {
                assert(it)
            }
        }
    }

}
