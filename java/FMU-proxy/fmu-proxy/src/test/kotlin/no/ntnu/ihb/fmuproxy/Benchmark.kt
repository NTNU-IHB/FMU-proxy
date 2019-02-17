package no.ntnu.ihb.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.common.FmuSlave
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.importer.cs.CoSimulationSlave
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuClient
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuServer
import no.ntnu.ihb.fmuproxy.jsonrpc.*
import no.ntnu.ihb.fmuproxy.jsonrpc.service.RpcFmuService
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServlet
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import no.ntnu.sfi.fmuproxy.TestUtils
import org.apache.log4j.Level
import org.apache.log4j.LogManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
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

        private const val stop = 1.0
        private const val stepSize = 1E-4
        private const val host = "localhost"

        private val testTimeout = Duration.ofSeconds(15)

    }

    private fun testSlave(slave: FmuSlave): Long {
        return runSlave(slave, stepSize, stop) {
            slave.variableAccessor.readReal("Temperature_Room").also { read ->
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
    fun measureTimeJson() {

        var httpPort: Int = -1
        var wsPort: Int
        var tcpPort: Int
        var zmqPort: Int


        val handler = RpcHandler(RpcFmuService().apply {
            addFmu(fmu)
        })

        val servers = mutableListOf(
                FmuProxyJsonWsServer(handler).apply { wsPort = start() },
                FmuProxyJsonTcpServer(handler).apply { tcpPort = start() },
                FmuProxyJsonZmqServer(handler).apply { zmqPort = start() }
        ).apply {
            if (!OS.LINUX.isCurrentOs) {
                add(FmuProxyJsonHttpServer(handler).apply { httpPort = start() })
            } else {
                LOG.warn("HTTP is disabled on Linux due to performance reasons..")
            }
        }

        val clients = mutableListOf(
                RpcWebSocketClient(host, wsPort),
                RpcTcpClient(host, tcpPort),
                RpcZmqClient(host, zmqPort)
        ).apply {
            if (!OS.LINUX.isCurrentOs) {
                add(RpcHttpClient(host, httpPort))
            }
        }.map { JsonRpcFmuClient(fmu.guid, it) }

        Assertions.assertTimeout(testTimeout.multipliedBy(4)) {

            clients.forEach {

                it.use { client ->
                    client.newInstance().use { slave ->
                        testSlave(slave).also {
                            LOG.info("${client.implementationName} duration=${it}ms")
                        }
                    }
                }

            }

            servers.forEach { it.close() }
        }

    }

}