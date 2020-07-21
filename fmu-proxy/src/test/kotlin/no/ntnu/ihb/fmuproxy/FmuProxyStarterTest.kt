package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class FmuProxyStarterTest {

    @Test
    fun test() {

        val fmuFile = File(
            "../test/fmus/2.0/cs/20sim/" +
                    "4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"
        )
        assert(fmuFile.exists())

        val port = 9091
        FmuProxyStarter.debugMain(arrayOf(
            "$port"
        ))

        ThriftFmuClient.socketClient("localhost", port).use { client ->

            client.loadFromLocalFile(fmuFile).use { fmu ->

                Assertions.assertEquals("ControlledTemperature", fmu.modelDescription.modelName)

                fmu.newInstance().use { instance ->

                    Assertions.assertTrue(instance.simpleSetup())

                }

            }

        }

    }

}
