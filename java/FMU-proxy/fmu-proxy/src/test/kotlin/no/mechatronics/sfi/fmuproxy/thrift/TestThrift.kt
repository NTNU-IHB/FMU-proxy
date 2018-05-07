package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Duration
import java.time.Instant
import kotlin.system.measureTimeMillis

class TestThrift {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestThrift::class.java)

        private lateinit var server: ThriftFmuServer
        private lateinit var client: ThriftFmuClient
        private lateinit var modelDescription: CommonModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestThrift::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)

            val fmu = Fmu.from(url)
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

           Assert.assertEquals(FmiStatus.OK, instance.init())

            val dt = 1.0/100
            measureTimeMillis {
                while (instance.currentTime < 10) {
                    val status = instance.step(dt)
                    Assert.assertEquals(FmiStatus.OK, status)
                }
            }.also { LOG.info("Duration=${it}ms") }

        }

    }


}