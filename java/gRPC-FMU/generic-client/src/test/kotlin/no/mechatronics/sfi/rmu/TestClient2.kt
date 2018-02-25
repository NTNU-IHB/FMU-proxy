package no.mechatronics.sfi.rmu

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.rmu.FmiDefinitions
import no.mechatronics.sfi.rmu.client.GenericFmuClient
import no.mechatronics.sfi.rmu.grpc.FmuServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TestClient2 {

    private var port: Int = -1
    private lateinit var server: FmuServer
    private lateinit var modelDescription: SimpleModelDescription

    @Before
    fun setup() {

        val fmuFile = FmuFile(javaClass.classLoader.getResource("fmus/me/BouncingBall/bouncingBall.fmu"))
        modelDescription = fmuFile.modelDescription

        server = FmuServer(fmuFile)
        port = server.start()
    }

    @After
    fun tearDown() {
        server.stop()
    }

    @Test
    fun testClient() {
        GenericFmuClient("127.0.0.1", port).use {

            Assert.assertEquals(modelDescription.modelName, it.modelName)
            Assert.assertEquals(modelDescription.guid, it.guid)

            val integrator = FmiDefinitions.Integrator.newBuilder()
                    .setEuler(FmiDefinitions.EulerIntegrator.newBuilder().setStepSize(1E-3)).build()
            it.createInstance(integrator).use { fmu ->

                Assert.assertTrue(fmu.init())

                fmu.read("h").asReal().also {
                    println(it)
                    Assert.assertEquals(1.0, it.value, 0.0)
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