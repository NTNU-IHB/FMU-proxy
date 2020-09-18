package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS
import java.io.File
import kotlin.time.ExperimentalTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class FmuProxyStarterTest {

    private val port = 9091
    private val fmuFile = File(TestUtils.getTEST_FMUs(), "2.0/cs/20sim/" +
            "4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"
    )

    init {
        Assertions.assertTrue(fmuFile.exists())
        FmuProxyStarter.debugMain(arrayOf("$port"))
    }

    @Test
    fun testLoadFromLocalFile() {
        ThriftFmuClient.socketClient("localhost", port).use { client ->
            client.loadFromLocalFile(fmuFile).use { fmu ->
                Assertions.assertEquals("ControlledTemperature", fmu.modelDescription.modelName)
                fmu.newInstance().use { instance ->
                    Assertions.assertTrue(instance.simpleSetup())
                }
            }
        }
    }

    @Test
    fun testLoadFromRemoteFile() {
        ThriftFmuClient.socketClient("localhost", port).use { client ->
            client.loadFromRemoteFile(fmuFile).use { fmu ->
                Assertions.assertEquals("ControlledTemperature", fmu.modelDescription.modelName)
                fmu.newInstance().use { instance ->
                    Assertions.assertTrue(instance.simpleSetup())
                }
            }
        }
    }

    @Test
    fun testLoadFromUrl() {
        ThriftFmuClient.socketClient("localhost", port).use { client ->
            client.loadFromUrl(fmuFile.toURI().toURL()).use { fmu ->
                Assertions.assertEquals("ControlledTemperature", fmu.modelDescription.modelName)
                fmu.newInstance().use { instance ->
                    Assertions.assertTrue(instance.simpleSetup())
                }
            }
        }
    }

    @Test
    @ExperimentalTime
    fun testRun() {
        val dt = 1e-2
        val stop = 10.0
        ThriftFmuClient.socketClient("localhost", port).use { client ->
            client.loadFromLocalFile(fmuFile).use { fmu ->
                fmu.newInstance().use {
                    val elapsed = runSlave(it, dt, stop)
                    println("Simulated ${stop}s in ${elapsed.inSeconds}s")
                }
            }
        }
    }

}
