package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.StringArray
import no.ntnu.ihb.fmi4j.modeldescription.stringArrayOf
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

                val vr = longArrayOf(0)
                val realValue = 123.0
                val strValue = "Hello world!"
                val doubleRef = DoubleArray(1)
                val strRef = StringArray(1) { "" }

                slave.writeAll(
                        null, null,
                        vr, doubleArrayOf(realValue),
                        vr, stringArrayOf(strValue),
                        null, null
                )

                Assertions.assertTrue(slave.doStep(0.1))

                slave.readAll(
                        null, null,
                        vr, doubleRef,
                        vr, strRef,
                        null, null
                )

                Assertions.assertEquals(realValue, doubleRef.first())
                Assertions.assertEquals(strValue, strRef.first())

                Assertions.assertTrue(slave.terminate())

            }

        }

    }

    @Test
    fun testControlledTemperature() {

        val generatedFmusDir = File("build/generatedFmus")

        val fmuToProxify = File("../test/fmus/2.0/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")
        Assertions.assertTrue(fmuToProxify.exists())

        val proxyFmu = FmuProxifier(fmuToProxify).build(generatedFmusDir)
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
