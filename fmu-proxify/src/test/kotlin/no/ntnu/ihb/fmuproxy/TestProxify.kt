package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.StringArray
import no.ntnu.ihb.fmi4j.modeldescription.stringArrayOf
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File


internal class TestProxify {

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

            var t = 0.0
            val dt = 0.01
            fmu.newInstance().use { slave ->

                Assertions.assertTrue(slave.simpleSetup())
                for (i in 0 until 10) {
                    Assertions.assertTrue(slave.doStep(t, dt)).also {
                        t += dt
                    }
                }
                Assertions.assertTrue(slave.terminate())

            }

        }

    }

    @Test
    fun testIdentity() {
        val generatedFmusDir = File("build/generatedFmus")

        val fmuToProxify = File("../test/fmus/1.0/identity.fmu")
        Assertions.assertTrue(fmuToProxify.exists())

        val proxyFmu = FmuProxifier(fmuToProxify).build(generatedFmusDir)
        Assertions.assertTrue(proxyFmu.exists())
        Assertions.assertEquals("identity-proxy.fmu", proxyFmu.name)

        val vrs = longArrayOf(0)

        val intValue = intArrayOf(99)
        val realValue = doubleArrayOf(12.3)
        val boolValue = booleanArrayOf(true)
        val strValue = stringArrayOf("Hello identity")

        val intRef = IntArray(1)
        val realRef = DoubleArray(1)
        val boolRef = BooleanArray(1)
        val strRef = StringArray(1)

        Fmu.from(proxyFmu).asCoSimulationFmu().use { fmu ->

            val md = fmu.modelDescription
            Assertions.assertEquals("no.viproma.demo.identity-proxy", md.modelName)

            fmu.newInstance().use { slave ->

                Assertions.assertTrue(slave.simpleSetup())

                for (i in 0..100) {
                    slave.writeInteger(vrs, intValue)
                    slave.writeReal(vrs, realValue)
                    slave.writeBoolean(vrs, boolValue)
                    slave.writeString(vrs, strValue)

                    Assertions.assertTrue(slave.doStep(0.0,0.1))

                    slave.readInteger(vrs, intRef)
                    slave.readReal(vrs, realRef)
                    slave.readBoolean(vrs, boolRef)
                    slave.readString(vrs, strRef)
                }

                Assertions.assertEquals(intRef.first(), intValue.first())
                Assertions.assertEquals(realRef.first(), realValue.first())
                Assertions.assertEquals(boolRef.first(), boolValue.first())
                Assertions.assertEquals(strRef.first(), strValue.first())

                Assertions.assertTrue(slave.terminate())

            }

        }

        Fmu.from(proxyFmu).asCoSimulationFmu().use { fmu ->

            fmu.newInstance().use { slave ->

                Assertions.assertTrue(slave.simpleSetup())

                for (i in 0..100) {
                    slave.writeAll(
                        vrs, intValue,
                        vrs, realValue,
                        vrs, boolValue,
                        vrs, strValue
                    )

                    slave.doStep(0.0, 0.1)

                    slave.readAll(
                        vrs, intRef,
                        vrs, realRef,
                        vrs, boolRef,
                        vrs, strRef
                    )
                }

                Assertions.assertEquals(intRef.first(), intValue.first())
                Assertions.assertEquals(realRef.first(), realValue.first())
                Assertions.assertEquals(boolRef.first(), boolValue.first())
                Assertions.assertEquals(strRef.first(), strValue.first())

            }

        }

    }

}
