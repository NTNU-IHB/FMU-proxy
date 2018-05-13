package no.mechatronics.sfi.fmuproxy.avro

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.TEST_FMUs
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import kotlin.system.measureTimeMillis

class TestAvro {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestAvro::class.java)

        private lateinit var server: AvroFmuServer
        private lateinit var client: AvroFmuClient

        private lateinit var modelDescription: CommonModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val fmu = Fmu.from(File(TEST_FMUs, "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
            modelDescription = fmu.modelDescription

            server = AvroFmuServer(fmu)
            val port = server.start()

            client = AvroFmuClient("localhost", port)

        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            client.close()
            server.close()
        }

    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assert.assertEquals(modelDescription.guid, guid)
    }

    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assert.assertEquals(modelDescription.modelName, modelName)
    }

    @Test
    fun testInstance() {

        client.newInstance().use { instance ->

            instance.init()
            Assert.assertEquals(FmiStatus.OK, instance.lastStatus)

            val h = client.modelDescription.modelVariables
                    .getByName("h").asRealVariable()

            val dt = 1.0/100
            measureTimeMillis {
                while (instance.currentTime < 10) {
                    val status = instance.doStep(dt)
                    Assert.assertTrue(status)

                    LOG.info("h=${h.read()}")

                }
            }.also { LOG.info("Duration=${it}ms") }

        }

    }

}