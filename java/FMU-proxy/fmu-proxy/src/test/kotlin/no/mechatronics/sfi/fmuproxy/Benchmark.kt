package no.mechatronics.sfi.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.common.currentOS
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuClient
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuClient
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmuproxy.jsonrpc.*
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuClient
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuSocketServer
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
class Benchmark {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Benchmark::class.java)

        private const val stop = 1.0
        private const val stepSize = 1E-4
        private const val host = "localhost"

    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/$currentOS/20sim/4.6.4.8004/" +
                    "ControlledTemperature/ControlledTemperature.fmu"))

    @AfterAll
    fun tearDown() {
        fmu.close()
    }

    @Test
    fun measureTimeLocal() {

        fmu.asCoSimulationFmu().newInstance().use { instance ->
            runInstance(instance, stepSize, stop) {
                val read = instance.variableAccessor.readReal("Temperature_Room")
                Assertions.assertTrue(read.value > 0)
            }.also {
                LOG.info("Local duration=${it}ms")
            }
        }

    }

    @Test
    fun measureTimeThriftSocket() {

        ThriftFmuSocketServer(fmu).use { server ->
            val port = server.start()
            val client = ThriftFmuClient.socketClient(fmu.guid, host, port)
            client.newInstance().use { instance ->
                runInstance(instance, stepSize, stop) {
                    val read = instance.readReal("Temperature_Room")
                    Assertions.assertTrue(read.value > 0)
                }.also {
                    LOG.info("Thrift duration=${it}ms")
                }
            }
            client.close()
        }

    }

    @Test
    fun measureTimeAvro() {

        AvroFmuServer(fmu).use { server ->
            val port = server.start()
            val client = AvroFmuClient(fmu.guid, host, port)
            client.newInstance().use { instance ->
                runInstance(instance, stepSize, stop) {
                    val read = instance.readReal("Temperature_Room")
                    Assertions.assertTrue(read.value > 0)
                }.also {
                    LOG.info("Avro duration=${it}ms")
                }
            }
            client.close()
        }

    }

    @Test
    fun measureTimeGrpc() {

        GrpcFmuServer(fmu).use { server ->
            val port = server.start()
            val client = GrpcFmuClient(fmu.guid, host, port)
            client.newInstance().use { instance ->
                runInstance(instance, stepSize, stop) {
                    val read = instance.readReal("Temperature_Room")
                    Assertions.assertTrue(read.value > 0)
                }.also {
                    LOG.info("gRPC duration=${it}ms")
                }
            }
            client.close()
        }

    }

    @Test
    fun measureTimeJson() {

        var httpPort: Int = -1
        var wsPort: Int = -1
        var tcpPort: Int = -1
        var zmqPort: Int = -1
        val handler = RpcHandler(RpcFmuService(fmu))

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

        clients.forEach {

            it.use { client ->
                client.newInstance().use { instance ->
                    runInstance(instance, stepSize, stop) {
                        val read = instance.readReal("Temperature_Room")
                        Assertions.assertTrue(read.value > 0)
                    }.also {
                        LOG.info("${client.implementationName} duration=${it}ms")
                    }
                }
            }

        }

        servers.forEach { it.close() }

    }

}