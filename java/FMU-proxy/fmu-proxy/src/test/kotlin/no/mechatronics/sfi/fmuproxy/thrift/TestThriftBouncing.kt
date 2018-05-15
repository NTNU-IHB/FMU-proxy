package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.TEST_FMUs
import no.mechatronics.sfi.fmuproxy.runInstance
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class TestThriftBouncing {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestThriftBouncing::class.java)

        private lateinit var server: ThriftFmuServer
        private lateinit var client: ThriftFmuClient
        private lateinit var modelDescription: CommonModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val fmu = Fmu.from(File(TEST_FMUs, "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
            modelDescription = fmu.modelDescription

            server = ThriftFmuServer(fmu)
            val port = server.start()

            client = ThriftFmuClient("localhost", port)
        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            client.close()
            server.stop()
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

            val h = client.modelDescription.modelVariables
                    .getByName("h").asRealVariable()

            val dt = 1.0/100
            val stop = 100.0
            runInstance(instance, dt, stop, {
                h.read()
            }).also {
                LOG.info("Duration: ${it}ms")
            }

        }

    }


}