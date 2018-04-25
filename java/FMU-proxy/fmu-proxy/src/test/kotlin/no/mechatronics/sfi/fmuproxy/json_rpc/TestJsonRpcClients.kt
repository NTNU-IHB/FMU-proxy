package no.mechatronics.sfi.fmuproxy.json_rpc

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.http.RpcHttpClient
import info.laht.yaj_rpc.net.tcp.RpcTcpClient
import info.laht.yaj_rpc.net.ws.RpcWebSocketClient
import info.laht.yaj_rpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.jsonrpc.JsonRpcFmuClient
import no.mechatronics.sfi.fmuproxy.FmuProxy
import no.mechatronics.sfi.fmuproxy.FmuProxyBuilder
import no.mechatronics.sfi.fmuproxy.json_rpc.service.RpcFmuService
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
        private lateinit var modelDescription: CommonModelDescription

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestJsonRpcClients::class.java.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)
            val fmu = Fmu.from(File(url.file))
            modelDescription = fmu.modelDescription

            val handler = RpcHandler(RpcFmuService(fmu))
            proxy = FmuProxyBuilder(fmu).apply {
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
        ).map { JsonRpcFmuClient(it) }

        clients.forEach { client ->

            client.use { fmu ->
                LOG.info("Testing client of type ${fmu.client.javaClass.simpleName}")
                Assert.assertEquals(modelDescription.modelName, fmu.modelName)
                Assert.assertEquals(modelDescription.guid, fmu.guid)

                Assert.assertTrue(fmu.init() == FmiStatus.OK)

                val dt = 1.0/100
                val start = Instant.now()
                while (fmu.currentTime < 10) {
                    val status = fmu.step(dt)
                    Assert.assertTrue(status == FmiStatus.OK)

                    // val read = fmu.readReal("wire.v").value
                    //LOG.info("wire.v=${read}")

                }
                val end = Instant.now()
                val duration = Duration.between(start, end)
                LOG.info("Duration: ${duration.toMillis()}ms")
            }

        }

    }

}