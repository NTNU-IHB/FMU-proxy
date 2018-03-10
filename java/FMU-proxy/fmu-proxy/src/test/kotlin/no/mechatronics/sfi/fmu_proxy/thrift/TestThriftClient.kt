package no.mechatronics.sfi.fmu_proxy.thrift

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import java.net.ServerSocket

class TestThriftClient {

    companion object {

        private lateinit var server: ThriftFmuServer
        private lateinit var client: ThriftFmuClient
        private lateinit var modelDescription: SimpleModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestThriftClient::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)

            val fmuFile = FmuFile(url)
            modelDescription = fmuFile.modelDescription

            val port = ServerSocket(0).use { it.localPort }
            server = ThriftFmuServer(fmuFile).apply {
                start(port)
            }
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
        val guid = client.guid.also { println("guid=$it") }
        Assert.assertEquals(modelDescription.guid, guid)
    }

    @Test
    fun testModelName() {
        val modelName = client.modelName.also { println("modelName=$it") }
        Assert.assertEquals(modelDescription.modelName, modelName)
    }

}