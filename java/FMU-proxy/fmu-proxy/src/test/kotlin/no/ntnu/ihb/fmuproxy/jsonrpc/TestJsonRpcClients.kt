package no.ntnu.ihb.fmuproxy.jsonrpc

import info.laht.yajrpc.net.RpcClient
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmi4j.read
import no.ntnu.ihb.fmuproxy.FmuProxyBuilder
import no.ntnu.ihb.fmuproxy.jsonrpc.service.RpcFmuService
import no.ntnu.ihb.fmuproxy.runSlave
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.time.Duration

class TestJsonRpcClients {

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(TestJsonRpcClients::class.java)

        const val stop = 1.0
        const val stepSize = 1E-4

        val timeout: Duration = Duration.ofSeconds(40)

        val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

        val temperatureVariable = fmu.modelDescription.modelVariables
                .getByName("Temperature_Room").asRealVariable()

        val service = RpcFmuService().apply { addFmu(fmu) }

        @AfterAll
        fun cleanup() {
            fmu.close()
        }

    }


    @Test
    fun testTcpClient() {

        Assertions.assertTimeout(timeout) {
            val proxy = FmuProxyBuilder(fmu).apply {
                addServer(FmuProxyJsonTcpServer(service), 9090)
            }.build().also { it.start() }

            RpcTcpClient("localhost", proxy.getPortFor<FmuProxyJsonTcpServer>()!!).also {
                testClient(it)
            }
            proxy.stop()
        }

    }

    @Test
    @DisabledOnOs(OS.LINUX)
    fun testHttpClient() {

        Assertions.assertTimeout(timeout) {
            val proxy = FmuProxyBuilder(fmu).apply {
                addServer(FmuProxyJsonHttpServer(service), 9091)
            }.build().also { it.start() }
            RpcHttpClient("localhost", proxy.getPortFor<FmuProxyJsonHttpServer>()!!).also {
                testClient(it)
            }
            proxy.stop()
        }

    }

    @Test
    @Disabled
    fun testWsClient() {

        Assertions.assertTimeout(timeout) {
            val proxy = FmuProxyBuilder(fmu).apply {
                addServer(FmuProxyJsonWsServer(service), 9092)
            }.build().also { it.start() }

            RpcWebSocketClient("localhost", proxy.getPortFor<FmuProxyJsonWsServer>()!!).also {
                testClient(it)
            }
            proxy.stop()
        }

    }

    private fun testClient(client: RpcClient) {

        JsonRpcFmuClient(client).use {
            it.load(fmu.guid).also { fmu ->
                LOG.info("Testing client of type ${fmu.implementationName}")
                Assertions.assertEquals(fmu.modelDescription.modelName, fmu.modelDescription.modelName)
                Assertions.assertEquals(fmu.modelDescription.guid, fmu.modelDescription.guid)

                fmu.newInstance().use { slave ->
                    val duration = runSlave(slave, stepSize, stop) {
                        temperatureVariable.read(slave)
                    }
                    LOG.info(" ${fmu.implementationName} duration: ${duration}ms")
                }
            }
        }

    }

}
