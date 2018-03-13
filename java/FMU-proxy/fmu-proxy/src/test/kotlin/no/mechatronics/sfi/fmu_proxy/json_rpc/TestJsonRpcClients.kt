package no.mechatronics.sfi.fmu_proxy.json_rpc

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.RpcParams
import info.laht.yaj_rpc.net.RpcClient
import info.laht.yaj_rpc.net.http.RpcHttpClient
import info.laht.yaj_rpc.net.tcp.RpcTcpClient
import info.laht.yaj_rpc.net.ws.RpcWebSocketClient
import info.laht.yaj_rpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.FmuRealRead
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmu_proxy.FmuProxy
import no.mechatronics.sfi.fmu_proxy.FmuProxyBuilder
import org.junit.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.File
import java.time.Duration
import java.time.Instant

class TestJsonRpcClients {

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(TestJsonRpcClients::class.java)

        private const val wsPort = 8001
        private const val tcpPort = 8002
        private const val zmqPort = 8003
        private const val httpPort = 8004

        private lateinit var proxy: FmuProxy
        private lateinit var modelDescription: SimpleModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestJsonRpcClients::class.java.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)
            val fmuFile = FmuFile(File(url.file))
            modelDescription = fmuFile.modelDescription

            val handler = RpcHandler(RpcFmuService(fmuFile))
            proxy = FmuProxyBuilder(fmuFile).apply {
                addServer(FmuProxyJsonHttpServer(handler), httpPort)
                addServer(FmuProxyJsonWsServer(handler), wsPort)
                addServer(FmuProxyJsonTcpServer(handler), tcpPort)
                addServer(FmuProxyJsonZmqServer(handler), zmqPort)
            }.build().also { it.start() }



        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            proxy.stop()
        }

    }

    @Test
    fun testClients() {

        val clients = listOf(
                RpcWebSocketClient("localhost", wsPort),
                RpcTcpClient("localhost", tcpPort),
                RpcHttpClient("localhost", httpPort),
                RpcZmqClient("localhost", zmqPort)
        ).map { FmuRpcClient(it) }

        clients.forEach { fmu ->

            LOG.info("Testing client of type ${fmu.client.javaClass.simpleName}")
            Assert.assertEquals(modelDescription.modelName, fmu.modelName)
            Assert.assertEquals(modelDescription.guid, fmu.guid)

            Assert.assertTrue(fmu.init())

            val dt = 1.0/100
            val start = Instant.now()
            while (fmu.currentTime < 10) {
                val status = fmu.step(dt)
                Assert.assertTrue(status)

               // val read = fmu.readReal("wire.v").value
                //LOG.info("wire.v=${read}")

            }
            val end = Instant.now()
            val duration = Duration.between(start, end)
            LOG.info("Duration: ${duration.toMillis()}ms")

            fmu.close()
        }

    }

    class FmuRpcClient(
            val client: RpcClient
    ): Closeable {

        private val fmuId: Int

        init {
            fmuId = client.write("FmuService.createInstanceFromCS").getResult(Int::class.java)!!
        }

        val modelName: String
            get() = client.write("FmuService.getModelName").getResult(String::class.java)!!


        val guid: String
            get() = client.write("FmuService.getGuid").getResult(String::class.java)!!


        val currentTime: Double
            get() = client.write("FmuService.getCurrentTime", RpcParams.listParams(fmuId)).getResult(Double::class.java)!!


        fun init(): Boolean {
            return client.write("FmuService.init", RpcParams.listParams(fmuId)).getResult(Boolean::class.java)!!
        }

        fun step(dt: Double): Boolean {
            return client.write("FmuService.step", RpcParams.listParams(fmuId, dt)).getResult(Boolean::class.java)!!
        }

        fun terminate() {
            client.write("FmuService.terminate", RpcParams.listParams(fmuId))
        }

        fun readReal(name: String): FmuRealRead {
            return client.write("FmuService.readReal", RpcParams.listParams(fmuId, name)).getResult(FmuRealRead::class.java)!!
        }

        override fun close() {
            terminate()
            client.close()
        }

    }

}