package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.grpc_fmu.client.GenericFmuClient
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TestClient2 {

    lateinit var server: GenericTestServer
    lateinit var modelDescription: SimpleModelDescription

    @Before
    fun setup() {

        val fmuFile = FmuFile(javaClass.classLoader.getResource("fmus/me/BouncingBall/bouncingBall.fmu"))
        modelDescription = fmuFile.modelDescription

        server = GenericTestServer(fmuFile)
        server.start()
    }

    @After
    fun tearDown() {
        server.stop()
    }

    @Test
    fun testClient() {
        GenericFmuClient("127.0.0.1", server.port!!).use {

            Assert.assertEquals(modelDescription.modelName, it.modelName)

            val integrator = FmiDefinitions.Integrator.newBuilder()
                    .setEuler(FmiDefinitions.EulerIntegrator.newBuilder().setStepSize(1E-3)).build()
            it.createInstance(integrator).use { fmu ->

                Assert.assertTrue(fmu.init())

                fmu.read("h").asReal().also {
                    println(it)
                    Assert.assertEquals(1.0, it,0.0)
                }

                val dt = 1.0/100
                for (i in 0 .. 10) {
                    val step: FmiDefinitions.Status = fmu.step(dt)
                    Assert.assertTrue(step.code == FmiDefinitions.StatusCode.OK)
                }

            }
        }
    }

}