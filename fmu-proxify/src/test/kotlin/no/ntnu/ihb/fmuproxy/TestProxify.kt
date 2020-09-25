package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File


internal class TestProxify {

    @Test
    fun testIdentity() {

        val generatedFmusDir = File("build/generatedFmus")

        val fmuToProxify = File("../test/fmus/1.0/identity.fmu")
        Assertions.assertTrue(fmuToProxify.exists())

        val proxyFmu = FmuProxifier(fmuToProxify).build(generatedFmusDir)
        Assertions.assertTrue(proxyFmu.exists())
        Assertions.assertEquals("identity-proxy.fmu", proxyFmu.name)

        Fmu.from(proxyFmu).asCoSimulationFmu().use { fmu ->

            val md = fmu.modelDescription
            Assertions.assertEquals("no.viproma.demo.identity-proxy", md.modelName)

            fmu.newInstance().use { slave ->

                Assertions.assertTrue(slave.simpleSetup())
                Assertions.assertTrue(slave.doStep(0.1))
                Assertions.assertTrue(slave.terminate())

            }

        }

    }

    @Test
    fun testControlledTemperature() {

        val fmuToProxify = File("../test/fmus/2.0/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")
        Assertions.assertTrue(fmuToProxify.exists())

        val proxyFmu = FmuProxifier(fmuToProxify).build()
        Assertions.assertTrue(proxyFmu.exists())
        Assertions.assertEquals("ControlledTemperature-proxy.fmu", proxyFmu.name)

        Fmu.from(proxyFmu).asCoSimulationFmu().use { fmu ->

            val md = fmu.modelDescription
            Assertions.assertEquals("ControlledTemperature-proxy", md.modelName)

            val dt = 0.01
            fmu.newInstance().use { slave ->

                Assertions.assertTrue(slave.simpleSetup())
                for (i in 0 until 10) {
                    Assertions.assertTrue(slave.doStep(dt))
                }
                Assertions.assertTrue(slave.terminate())

            }

        }

    }

}
