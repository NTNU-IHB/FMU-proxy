package no.mechatronics.sfi.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.currentOS
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.FmuProxyBuilder
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.runInstance
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestJsonRpcClients {

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestJsonRpcClients::class.java)

    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/$currentOS/20sim/4.6.4.8004/" +
                    "ControlledTemperature/ControlledTemperature.fmu"))

    private  val handler = RpcHandler(RpcFmuService(fmu))

    private var proxy = FmuProxyBuilder(fmu).apply {
            if (!OS.LINUX.isCurrentOs) {
                addServer(FmuProxyJsonHttpServer(handler))
            } else {
                LOG.warn("HTTP is disabled on Linux due to performance issues!")
            }
            addServer(FmuProxyJsonWsServer(handler))
            addServer(FmuProxyJsonTcpServer(handler))
            addServer(FmuProxyJsonZmqServer(handler))
        }.build().also { it.start() }


    @AfterAll
    fun tearDown() {
        proxy.stop()
        fmu.close()
    }

    @Test
    fun testClients() {

        val clients = mutableListOf(
                RpcWebSocketClient("localhost", proxy.getPortFor<FmuProxyJsonWsServer>()!!),
                RpcTcpClient("localhost", proxy.getPortFor<FmuProxyJsonTcpServer>()!!),
                RpcZmqClient("localhost", proxy.getPortFor<FmuProxyJsonZmqServer>()!!)
        ).apply {
            if (!OS.LINUX.isCurrentOs) {
                add(RpcHttpClient("localhost", proxy.getPortFor<FmuProxyJsonHttpServer>()!!))
            }
        }.map { JsonRpcFmuClient(fmu.guid, it) }


        clients.forEach {

            it.use { client ->
                LOG.info("Testing client of type ${client.implementationName}")
                Assertions.assertEquals(fmu.modelDescription.modelName, client.modelName)
                Assertions.assertEquals(fmu.modelDescription.guid, client.guid)

                client.newInstance().use { slave ->

                    val temp = client.modelDescription.modelVariables
                            .getByName("Temperature_Room").asRealVariable()

                    val stop = 1.0
                    val stepSize = 1E-4
                    runInstance(slave, stepSize, stop) {
                        temp.read(slave)
                    }.also { LOG.info(" ${client.implementationName} duration: ${it}ms") }

                }
            }

        }

    }

}