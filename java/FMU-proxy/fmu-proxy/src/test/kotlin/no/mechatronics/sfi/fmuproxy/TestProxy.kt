package no.mechatronics.sfi.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.importer.misc.currentOS
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuClient
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuClient
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmuproxy.jsonrpc.*
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuClient
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuServlet
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
class TestProxy {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestProxy::class.java)

        private const val stepSize: Double = 1.0 / 100
        private const val stopTime: Double = 5.0
        private const val host = "localhost"

    }

    private val proxy: FmuProxy

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/$currentOS" +
                    "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

    init {

        proxy = FmuProxyBuilder(fmu).apply {
            addServer(GrpcFmuServer(fmu))
            addServer(AvroFmuServer(fmu))
            addServer(ThriftFmuSocketServer(fmu))
            addServer(ThriftFmuServlet(fmu))
            RpcHandler(RpcFmuService(fmu)).also { handler ->
                addServer(FmuProxyJsonWsServer(handler))
                addServer(FmuProxyJsonTcpServer(handler))
                addServer(FmuProxyJsonZmqServer(handler))
                if (!OS.LINUX.isCurrentOs) {
                    addServer(FmuProxyJsonHttpServer(handler))
                }
            }

        }.build()

        proxy.start()
        LOG.info("${proxy.networkInfo}")

    }

    @AfterAll
    fun tearDown() {
        proxy.stop()
        fmu.close()
    }

    @Test
    fun testGrpc() {

        proxy.getPortFor<GrpcFmuServer>()?.also { port ->

            GrpcFmuClient(fmu.guid, host, port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    runInstance(instance, stepSize, stopTime).also {
                        LOG.info("gRPC duration: ${it}ms")
                    }

                }
            }
        }

    }

    @Test
    fun testThriftSocket() {

        proxy.getPortFor<ThriftFmuSocketServer>()?.also { port ->
            ThriftFmuClient.socketClient(fmu.guid, host, port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    runInstance(instance, stepSize, stopTime).also {
                        LOG.info("Thrift (socket) duration: ${it}ms")
                    }

                }
            }
        }

    }

    @Test
    fun testThriftServlet() {

        proxy.getPortFor<ThriftFmuServlet>()?.also { port ->
            ThriftFmuClient.servletClient(fmu.guid, host, port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    runInstance(instance, stepSize, stopTime).also {
                        LOG.info("Thrift (servlet) duration: ${it}ms")
                    }

                }
            }
        }

    }

    @Test
    fun testAvro() {

        proxy.getPortFor<AvroFmuServer>()?.also { port ->
            AvroFmuClient(fmu.guid, host, port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    runInstance(instance, stepSize, stopTime).also {
                        LOG.info("Avro duration: ${it}ms")
                    }

                }
            }
        }

    }

    @Test
    fun testJsonRpc() {

        val clients = mutableListOf(
                RpcWebSocketClient(host, proxy.getPortFor<FmuProxyJsonWsServer>()!!),
                RpcTcpClient(host, proxy.getPortFor<FmuProxyJsonTcpServer>()!!),
                RpcZmqClient(host, proxy.getPortFor<FmuProxyJsonZmqServer>()!!)
        ).apply {
            if (!OS.LINUX.isCurrentOs) {
                add(RpcHttpClient(host, proxy.getPortFor<FmuProxyJsonHttpServer>()!!))
            }
        }.map { JsonRpcFmuClient(fmu.guid, it) }

        val mdLocal = fmu.modelDescription

        clients.forEach {

            it.use { client ->

                LOG.info("Testing client of type ${client.implementationName}")

                Assertions.assertEquals(mdLocal.guid, client.guid)
                Assertions.assertEquals(mdLocal.modelName, client.modelName)
                Assertions.assertEquals(mdLocal.fmiVersion, client.fmiVersion)

                client.newInstance().use { instance ->
                    runInstance(instance, stepSize, stopTime).also {
                        LOG.info("${client.implementationName} duration: ${it}ms")
                    }
                }

            }

        }

    }

}