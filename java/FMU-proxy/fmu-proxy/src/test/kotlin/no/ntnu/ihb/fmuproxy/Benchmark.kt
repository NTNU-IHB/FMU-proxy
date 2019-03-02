package no.ntnu.ihb.fmuproxy

import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.common.FmuSlave
import no.ntnu.ihb.fmi4j.common.readReal
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuClient
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuServer
import no.ntnu.ihb.fmuproxy.jsonrpc.*
import no.ntnu.ihb.fmuproxy.jsonrpc.service.RpcFmuService
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServlet
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Benchmark {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Benchmark::class.java)

        private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

        private const val stop = 0.1
        private const val stepSize = 1E-4
        private const val host = "localhost"

        private val testTimeout = Duration.ofSeconds(15)

    }

    private fun testSlave(slave: FmuSlave): Long {
        return runSlave(slave, stepSize, stop) {
            slave.readReal("Temperature_Room").also { read ->
                Assertions.assertEquals(FmiStatus.OK, read.status)
                Assertions.assertTrue(read.value > 0)
            }
        }
    }

    @AfterAll
    fun tearDown() {
        fmu.close()
    }

    @Test
    fun measureTimeLocal() {

        fmu.asCoSimulationFmu().newInstance().use { slave ->
            testSlave(slave).also {
                LOG.info("Local duration=${it}ms")
            }
        }

    }

    @Test
    fun measureTimeThriftSocket() {

        Assertions.assertTimeout(testTimeout) {
            ThriftFmuSocketServer().use { server ->
                server.addFmu(fmu)
                val port = server.start()
                ThriftFmuClient.socketClient(host, port).load(fmu.guid).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("Thrift/tcp duration=${it}ms")
                        }
                    }
                }
            }
        }

    }

    @Test
    @DisabledOnOs(OS.LINUX)
    fun measureTimeThriftServlet() {

        disableLog4jLoggers()

        Assertions.assertTimeout(testTimeout) {
            ThriftFmuServlet().use { server ->
                server.addFmu(fmu)
                val port = server.start()
                ThriftFmuClient.servletClient(host, port).load(fmu.guid).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("Thrift/http duration=${it}ms")
                        }
                    }
                }
            }
        }

    }

    @Test
    fun measureTimeGrpc() {
        Assertions.assertTimeout(testTimeout) {
            GrpcFmuServer().use { server ->
                server.addFmu(fmu)
                val port = server.start()
                GrpcFmuClient(host, port).load(fmu.guid).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("gRPC duration=${it}ms")
                        }
                    }
                }
            }
        }
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    fun measureTimeJsonHttp() {

        val service = RpcFmuService().apply {
            addFmu(fmu)
        }

        Assertions.assertTimeout(testTimeout) {
            FmuProxyJsonHttpServer(service).use { server ->
                JsonRpcFmuClient(fmu.guid, RpcHttpClient(host, server.start())).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("${client.implementationName} duration=${it}ms")
                        }
                    }
                }
            }

        }
    }

    @Test
    fun measureTimeJsonWs() {

        val service = RpcFmuService().apply {
            addFmu(fmu)
        }

        Assertions.assertTimeout(testTimeout) {
            FmuProxyJsonWsServer(service).use { server ->
                JsonRpcFmuClient(fmu.guid, RpcWebSocketClient(host, server.start())).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("${client.implementationName} duration=${it}ms")
                        }
                    }
                }
            }

        }
    }

    @Test
    fun measureTimeJsonZmq() {

        val service = RpcFmuService().apply {
            addFmu(fmu)
        }

        Assertions.assertTimeout(testTimeout) {
            FmuProxyJsonZmqServer(service).use { server ->
                JsonRpcFmuClient(fmu.guid, RpcZmqClient(host, server.start())).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("${client.implementationName} duration=${it}ms")
                        }
                    }
                }
            }

        }
    }

    @Test
    fun measureTimeJsonTcp() {

        val service = RpcFmuService().apply {
            addFmu(fmu)
        }

        Assertions.assertTimeout(testTimeout) {
            FmuProxyJsonTcpServer(service).use { server ->
                JsonRpcFmuClient(fmu.guid, RpcTcpClient(host, server.start())).use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("${client.implementationName} duration=${it}ms")
                        }
                    }
                }
            }

        }
    }

}