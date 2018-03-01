package no.mechatronics.sfi.rmu

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.rmu.client.GenericFmuClient
import no.mechatronics.sfi.rmu.grpc.GrpcFmuServer
import no.mechatronics.sfi.rmu.grpc.services.GenericFmuServiceImpl
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.net.ServerSocket


class TestClient2 {

    private var port: Int = -1
    private lateinit var server: GrpcFmuServer
    private lateinit var modelDescription: SimpleModelDescription

    @Before
    fun setup() {

        port = ServerSocket(0).use { it.localPort }

        val fmuFile = FmuFile(javaClass.classLoader.getResource("fmus/me/BouncingBall/bouncingBall.fmu"))
        modelDescription = fmuFile.modelDescription

        server = GrpcFmuServer(GenericFmuServiceImpl(fmuFile))
        server.start(port)
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
                    println("h=${it.value}")
                    Assert.assertEquals(1.0, it.value, 0.0)
                }

                val dt = 1.0/100
                for (i in 0 .. 10) {
                    val step: FmiDefinitions.Status = fmu.step(dt)
                    Assert.assertTrue(step.code == FmiDefinitions.StatusCode.OK_STATUS)
                }

            }
        }
    }

}