package no.mechatronics.sfi.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuClient
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuClient
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmuproxy.jsonrpc.*
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.net.FmuProxyServer
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuClient
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestProxy {

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(TestProxy::class.java)

        private const val stepSize: Double = 1.0 / 100
        private const val stopTime: Double = 5.0

//        private const val httpPort: Int = 8003
        private const val wsPort: Int = 8004
        private const val tcpPort: Int = 8005
        private const val zmqPort: Int = 8006

    }

    private val proxy: FmuProxy
    private val grpcServer: FmuProxyServer
    private val avroServer: FmuProxyServer
    private val thriftServer: FmuProxyServer

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/${TestUtils.getOs()}/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

    init {

        grpcServer = GrpcFmuServer(fmu)
        avroServer = AvroFmuServer(fmu)
        thriftServer = ThriftFmuServer(fmu)

        proxy = FmuProxyBuilder(fmu).apply {
            addServer(grpcServer)
            addServer(thriftServer)
            addServer(avroServer)
            RpcHandler(RpcFmuService(fmu)).also { handler ->
//                addServer(FmuProxyJsonHttpServer(handler), httpPort)
                addServer(FmuProxyJsonWsServer(handler), wsPort)
                addServer(FmuProxyJsonTcpServer(handler), tcpPort)
                addServer(FmuProxyJsonZmqServer(handler), zmqPort)
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
    fun testGetPort() {
//        Assertions.assertEquals(httpPort, proxy.getPortFor<FmuProxyJsonHttpServer>())
        Assertions.assertEquals(wsPort, proxy.getPortFor<FmuProxyJsonWsServer>())
        Assertions.assertEquals(tcpPort, proxy.getPortFor<FmuProxyJsonTcpServer>())
        Assertions.assertEquals(zmqPort, proxy.getPortFor<FmuProxyJsonZmqServer>())
    }

    @Test
    fun getServer() {
        Assertions.assertEquals(grpcServer, proxy.getServer<GrpcFmuServer>())
        Assertions.assertEquals(avroServer, proxy.getServer<AvroFmuServer>())
        Assertions.assertEquals(thriftServer, proxy.getServer<ThriftFmuServer>())
    }

    @Test
    fun testGrpc() {

        proxy.getPortFor<GrpcFmuServer>()?.also { port ->

            GrpcFmuClient("localhost", port).use { client ->

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
    fun testThrift() {

        proxy.getPortFor<ThriftFmuServer>()?.also { port ->
            ThriftFmuClient("localhost", port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    runInstance(instance, stepSize, stopTime).also {
                        LOG.info("Thrift duration: ${it}ms")
                    }

                }
            }
        }

    }

    @Test
    fun testAvro() {

        proxy.getPortFor<AvroFmuServer>()?.also { port ->
            AvroFmuClient("localhost", port).use { client ->

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

        val host = "localhost"
        val clients = listOf(
//                RpcHttpClient(host, proxy.getPortFor<FmuProxyJsonHttpServer>()!!)
                RpcWebSocketClient(host, proxy.getPortFor<FmuProxyJsonWsServer>()!!),
                RpcTcpClient(host, proxy.getPortFor<FmuProxyJsonTcpServer>()!!),
                RpcZmqClient(host, proxy.getPortFor<FmuProxyJsonZmqServer>()!!)
        ).map { JsonRpcFmuClient(it) }


        val mdLocal = fmu.modelDescription

        clients.forEach { client ->

            LOG.info("Testing client of type ${client.client.javaClass.simpleName}")

            Assertions.assertEquals(mdLocal.guid, client.guid)
            Assertions.assertEquals(mdLocal.modelName, client.modelName)
            Assertions.assertEquals(mdLocal.fmiVersion, client.fmiVersion)

            client.newInstance().use { instance ->

                runInstance(instance, stepSize, stopTime).also {
                    LOG.info("${client.client.javaClass.simpleName} duration: ${it}ms")
                }

            }

        }

    }

}