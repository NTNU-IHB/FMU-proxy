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
import org.junit.Assert
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import kotlin.system.measureTimeMillis

class Benchmark {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Benchmark::class.java)

        private val fmuPath = File(System.getenv("TEST_FMUs"), "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu")

        private const val dt = 1E-2
        private const val stop = 100.0

    }

    @Test
    fun measureTimeLocal() {
        Fmu.from(fmuPath).use {
            it.asCoSimulationFmu().newInstance().use { instance ->
                runInstance(instance, dt, stop).also {
                    LOG.info("Local duration=${it}ms")
                }
            }
        }
    }


    @Test
    fun measureTimeThrift() {

        Fmu.from(fmuPath).use {

            val server = ThriftFmuServer(it)
            val port = server.start()

            val client = ThriftFmuClient("localhost", port)
            client.newInstance().use { instance ->
                runInstance(instance, dt, stop).also {
                    LOG.info("Thrift duration=${it}ms")
                }
            }

            client.close()
            server.close()

        }

    }

    @Test
    fun measureTimeAvro() {

        Fmu.from(fmuPath).use {

            val server = AvroFmuServer(it)
            val port = server.start()

            val client = AvroFmuClient("localhost", port)
            client.newInstance().use { instance ->
                runInstance(instance, dt, stop).also {
                    LOG.info("Avro duration=${it}ms")
                }
            }

            client.close()
            server.close()

        }

    }

    @Test
    fun measureTimeGrpc() {

        Fmu.from(fmuPath).use {

            val server = GrpcFmuServer(it)
            val port = server.start()

            val client = GrpcFmuClient("localhost", port)
            client.newInstance().use { instance ->
                runInstance(instance, dt, stop).also {
                    LOG.info("gRPC duration=${it}ms")
                }
            }

            client.close()
            server.close()

        }

    }

    @Test
    fun measureTimeJson() {

        val wsPort = 8001
        val tcpPort = 8002
        val zmqPort = 8003
        val httpPort = 8004

        Fmu.from(fmuPath).use {

            val handler = RpcHandler(RpcFmuService(it))

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
                        LOG.info("${client.client.javaClass.simpleName} duration=${it}ms")
                    }
                }

                client.close()
            }
            servers.forEach { it.close() }

        }

    }

}