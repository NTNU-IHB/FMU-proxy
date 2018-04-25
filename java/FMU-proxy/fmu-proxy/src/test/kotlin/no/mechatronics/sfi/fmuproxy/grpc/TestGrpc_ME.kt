package no.mechatronics.sfi.fmuproxy.grpc

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestGrpc_ME {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TestGrpc_ME::class.java)


        private lateinit var server: GrpcFmuServer
        private lateinit var client: GrpcFmuClient
        private lateinit var modelDescription: CommonModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestGrpc_ME::class.java.classLoader
                    .getResource("fmus/me/BouncingBall/bouncingBall.fmu")
            Assert.assertNotNull(url)

            val fmu = Fmu.from(url)
            modelDescription = fmu.modelDescription

            server = GrpcFmuServer(fmu)
            val port = server.start()

            client = GrpcFmuClient("127.0.0.1", port)

        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            server.stop()
            client.stop()
        }

    }

    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assert.assertEquals(modelDescription.modelName, modelName)
    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assert.assertEquals(modelDescription.guid, guid)
    }

    @Test
    fun testInstance() {

        val integrator = Proto.Integrator.newBuilder()
                .setEuler(Proto.Integrator.Euler.newBuilder().setStepSize(1E-3)).build()

        client.createInstance(integrator).use { fmu ->

            Assert.assertTrue(fmu.init().code == Proto.StatusCode.OK_STATUS)

            fmu.read("h").asReal().also {
                LOG.info("h=${it.value}")
                Assert.assertEquals(1.0, it.value, 0.0)
            }

            val dt = 1.0/100
            for (i in 0 until  10) {
                val step = fmu.step(dt)
                Assert.assertTrue(step.code == Proto.StatusCode.OK_STATUS)
            }

        }
    }

}