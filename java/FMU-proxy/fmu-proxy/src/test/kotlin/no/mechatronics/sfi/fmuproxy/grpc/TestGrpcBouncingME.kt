package no.mechatronics.sfi.fmuproxy.grpc

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.Solver
import no.mechatronics.sfi.fmuproxy.TEST_FMUs
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class TestGrpcBouncingME {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TestGrpcBouncingME::class.java)


        private lateinit var server: GrpcFmuServer
        private lateinit var client: GrpcFmuClient
        private lateinit var modelDescription: CommonModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val fmu = Fmu.from(File(TEST_FMUs, "FMI_2.0/ModelExchange/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
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

        val solver = Solver("Euler").apply {
            addProperty("step_size", 1E-3)
        }

        client.newInstance(solver).use { instance ->

            instance.init()
            Assert.assertEquals(FmiStatus.OK, instance.lastStatus)

            val h = instance.getVariableByName("h").asRealVariable()

            h.read().also {
                LOG.info("h=${it.value}")
                Assert.assertEquals(1.0, it.value, 0.0)
            }

            val dt = 1.0/100
            for (i in 0 until  10) {
                val step = instance.doStep(dt)
                Assert.assertTrue(step)

                LOG.info("h=${h.read()}")

            }

        }

    }

}