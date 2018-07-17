package no.mechatronics.sfi.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.RpcClient
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.FmuProxy
import no.mechatronics.sfi.fmuproxy.FmuProxyBuilder
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.runInstance
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@EnabledOnOs(OS.WINDOWS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestJsonRpcClients {

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestJsonRpcClients::class.java)

        private const val wsPort = 8001
        private const val tcpPort = 8002
        private const val zmqPort = 8003
        private const val httpPort = 8004

    }

    private var proxy: FmuProxy
    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
    private var modelDescription: CommonModelDescription = fmu.modelDescription

    init {

        val handler = RpcHandler(RpcFmuService(fmu))
        proxy = FmuProxyBuilder(fmu).apply {
            addServer(FmuProxyJsonHttpServer(handler), httpPort)
            addServer(FmuProxyJsonWsServer(handler), wsPort)
            addServer(FmuProxyJsonTcpServer(handler), tcpPort)
            addServer(FmuProxyJsonZmqServer(handler), zmqPort)
        }.build().also { it.start() }

    }

    @AfterAll
    fun tearDown() {
        proxy.stop()
        fmu.close()
    }

    @Test
    fun testClients() {

        val clients = listOf(
                RpcWebSocketClient("localhost", wsPort),
                RpcTcpClient("localhost", tcpPort),
                RpcHttpClient("localhost", httpPort),
                RpcZmqClient("localhost", zmqPort)
        ).map { JsonRpcFmuClient(it) }

        try {

            clients.forEach { client ->

                LOG.info("Testing client of type ${client.client.javaClass.simpleName}")
                Assertions.assertEquals(modelDescription.modelName, client.modelName)
                Assertions.assertEquals(modelDescription.guid, client.guid)

                client.newInstance().use { instance ->

                    instance.init()
                    Assertions.assertEquals(FmiStatus.OK, instance.lastStatus)

                    val h = client.modelDescription.modelVariables
                            .getByName("h").asRealVariable()

                    val dt = 1.0/100
                    val stop = 10.0
                    runInstance(instance, dt, stop) {
                        h.read()
                    }.also { LOG.info("Duration: ${it}ms") }

                }

            }

        } finally {
            clients.forEach {it.close()}
        }

    }

}