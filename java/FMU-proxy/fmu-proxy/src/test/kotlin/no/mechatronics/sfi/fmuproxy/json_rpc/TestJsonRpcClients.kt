package no.mechatronics.sfi.fmuproxy.json_rpc

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.FmuProxy
import no.mechatronics.sfi.fmuproxy.FmuProxyBuilder
import no.mechatronics.sfi.fmuproxy.TEST_FMUs
import no.mechatronics.sfi.fmuproxy.jsonrpc.*
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import kotlin.system.measureTimeMillis

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

            val fmu = Fmu.from(File(TEST_FMUs, "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
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

            LOG.info("Testing client of type ${client.client.javaClass.simpleName}")
            Assert.assertEquals(modelDescription.modelName, client.modelName)
            Assert.assertEquals(modelDescription.guid, client.guid)

            println(client.modelDescription)

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
                }.also { LOG.info("Duration: ${it}ms") }

            }

        }

    }

}