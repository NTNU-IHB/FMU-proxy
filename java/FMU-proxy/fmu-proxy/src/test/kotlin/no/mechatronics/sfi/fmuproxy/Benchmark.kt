package no.mechatronics.sfi.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.FmiSimulation
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuClient
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuClient
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmuproxy.jsonrpc.*
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuClient
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuServer
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


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class Benchmark {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Benchmark::class.java)

        private const val dt = 1E-4
        private const val stop = 20.0

        private val fmuPath = File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/${TestUtils.getOs()}/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    }

    private val fmu = Fmu.from(fmuPath)

    @AfterAll
    fun tearDown() {
        fmu.close()
    }

    @Test
    fun measureTimeLocal() {

        fmu.asCoSimulationFmu().newInstance().use { instance ->
            runInstance(instance, dt, stop).also {
                val read = instance.variableAccessor.readReal("Temperature_Room")
                Assertions.assertTrue(read.value > 0)
                LOG.info("Local duration=${it}ms")
            }
        }

    }


    @Test
    fun measureTimeThrift() {

        val server = ThriftFmuServer(fmu)
        val port = server.start()

        val client = ThriftFmuClient("localhost", port)
        client.newInstance().use { instance ->
            runInstance(instance, dt, stop).also {
                val read = instance.readReal("Temperature_Room")
                Assertions.assertTrue(read.value > 0)
                LOG.info("Thrift duration=${it}ms")
            }
        }

        client.close()
        server.close()

    }

    @Test
    fun measureTimeAvro() {

        val server = AvroFmuServer(fmu)
        val port = server.start()

        val client = AvroFmuClient("localhost", port)
        client.newInstance().use { instance ->
            runInstance(instance, dt, stop).also {
                val read = instance.readReal("Temperature_Room")
                Assertions.assertTrue(read.value > 0)
                LOG.info("Avro duration=${it}ms")
            }
        }

        client.close()
        server.close()

    }

    @Test
    fun measureTimeGrpc() {

        val server = GrpcFmuServer(fmu)
        val port = server.start()

        val client = GrpcFmuClient("localhost", port)
        client.newInstance().use { instance ->
            runInstance(instance, dt, stop).also {
                val read = instance.readReal("Temperature_Room")
                Assertions.assertTrue(read.value > 0)
                LOG.info("gRPC duration=${it}ms")
            }
        }

        client.close()
        server.close()

    }

    @Test
    fun measureTimeJson() {

        val wsPort = 8001
        val tcpPort = 8002
        val zmqPort = 8003
        val httpPort = 8004

        val handler = RpcHandler(RpcFmuService(fmu))

        val servers = listOf(
                FmuProxyJsonHttpServer(handler).apply { start(httpPort) },
                FmuProxyJsonWsServer(handler).apply { start(wsPort) },
                FmuProxyJsonTcpServer(handler).apply { start(tcpPort) },
                FmuProxyJsonZmqServer(handler).apply { start(zmqPort) }
        )

        val host = "localhost"
        val clients = listOf(
                RpcHttpClient(host, httpPort),
                RpcWebSocketClient(host, wsPort),
                RpcTcpClient(host, tcpPort),
                RpcZmqClient(host, zmqPort)
        ).map { JsonRpcFmuClient(it) }

        clients.forEach { client ->

            client.newInstance().use { instance ->
                runInstance(instance, dt, stop).also {
                    val read = instance.readReal("Temperature_Room")
                    Assertions.assertTrue(read.value > 0)
                    LOG.info("${client.client.javaClass.simpleName} duration=${it}ms")
                }
            }

            client.close()

        }

        servers.forEach { it.close() }

    }

}