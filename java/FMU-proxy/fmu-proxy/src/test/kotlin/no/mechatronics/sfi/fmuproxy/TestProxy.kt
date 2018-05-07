package no.mechatronics.sfi.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpClient
import info.laht.yajrpc.net.tcp.RpcTcpClient
import info.laht.yajrpc.net.ws.RpcWebSocketClient
import info.laht.yajrpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuClient
import no.mechatronics.sfi.fmuproxy.avro.AvroFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuClient
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.Proto
import no.mechatronics.sfi.fmuproxy.jsonrpc.*
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.net.FmuProxyServer
import no.mechatronics.sfi.fmuproxy.thrift.StatusCode
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuClient
import no.mechatronics.sfi.fmuproxy.thrift.ThriftFmuServer
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.time.Duration
import java.time.Instant

class TestProxy {

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(TestProxy::class.java)

        const val stepSize: Double = 1.0/100
        const val stopTime: Double = 5.0

        lateinit var fmu: Fmu
        lateinit var proxy: FmuProxy

        lateinit var grpcServer: FmuProxyServer
        lateinit var avroServer: FmuProxyServer
        lateinit var thriftServer: FmuProxyServer

        const val httpPort: Int = 8003
        const val wsPort: Int = 8004
        const val tcpPort: Int = 8005
        const val zmqPort: Int = 8006

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestProxy::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)
            fmu = Fmu.from(File(url.file))

            grpcServer = GrpcFmuServer(fmu)
            avroServer = AvroFmuServer(fmu)
            thriftServer = ThriftFmuServer(fmu)


            proxy = FmuProxyBuilder(fmu).apply {
                addServer(grpcServer)
                addServer(thriftServer)
                addServer(avroServer)
                RpcHandler(RpcFmuService(fmu)).also { handler ->
                    addServer(FmuProxyJsonHttpServer(handler), httpPort)
                    addServer(FmuProxyJsonWsServer(handler), wsPort)
                    addServer(FmuProxyJsonTcpServer(handler), tcpPort)
                    addServer(FmuProxyJsonZmqServer(handler), zmqPort)
                }

            }.build()

            proxy.start()
            LOG.info("${proxy.networkInfo}")

        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            proxy.stop()
        }

    }

    @Test
    fun testGetPort() {
        Assert.assertEquals(httpPort, proxy.getPortFor(FmuProxyJsonHttpServer::class.java))
        Assert.assertEquals(wsPort, proxy.getPortFor(FmuProxyJsonWsServer::class.java))
        Assert.assertEquals(tcpPort, proxy.getPortFor(FmuProxyJsonTcpServer::class.java))
        Assert.assertEquals(zmqPort, proxy.getPortFor(FmuProxyJsonZmqServer::class.java))
    }

    @Test
    fun getServer() {
        Assert.assertEquals(grpcServer, proxy.getServer(GrpcFmuServer::class.java))
        Assert.assertEquals(avroServer, proxy.getServer(AvroFmuServer::class.java))
        Assert.assertEquals(thriftServer, proxy.getServer(ThriftFmuServer::class.java))
    }

    @Test
    fun testGrpc() {

        proxy.getPortFor(GrpcFmuServer::class.java)?.also { port ->

            GrpcFmuClient("localhost", port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assert.assertEquals(mdLocal.guid, mdRemote.guid)
                Assert.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assert.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    Assert.assertEquals(FmiStatus.OK, instance.init())

                    val start = Instant.now()
                    while (instance.currentTime < stopTime) {
                        val status = instance.step(stepSize)
                        Assert.assertEquals(Proto.StatusCode.OK_STATUS, status.code)
                    }

                    val end = Instant.now()
                    val duration = Duration.between(start, end)
                    LOG.info("gRPC duration: ${duration.toMillis()}ms")

                }
            }
        }

    }

    @Test
    fun testThrift() {

        proxy.getPortFor(ThriftFmuServer::class.java)?.also { port ->
            ThriftFmuClient("localhost", port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assert.assertEquals(mdLocal.guid, mdRemote.guid)
                Assert.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assert.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    Assert.assertTrue(instance.init() == StatusCode.OK_STATUS)
                    val start = Instant.now()
                    while (instance.currentTime < stopTime) {
                        val status = instance.step(stepSize)
                        Assert.assertEquals(no.mechatronics.sfi.fmuproxy.thrift.StatusCode.OK_STATUS, status)
                    }

                    val end = Instant.now()
                    val duration = Duration.between(start, end)
                    LOG.info("Thrift duration: ${duration.toMillis()}ms")

                }
            }
        }

    }

    @Test
    fun testAvro() {

        proxy.getPortFor(AvroFmuServer::class.java)?.also { port ->
            AvroFmuClient("localhost", port).use { client ->

                val mdLocal = fmu.modelDescription
                val mdRemote = client.modelDescription

                Assert.assertEquals(mdLocal.guid, mdRemote.guid)
                Assert.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assert.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.newInstance().use { instance ->

                    Assert.assertTrue(instance.init() == no.mechatronics.sfi.fmuproxy.avro.StatusCode.OK_STATUS)
                    val start = Instant.now()
                    while (instance.currentTime < stopTime) {
                        val status = instance.step(stepSize)
                        Assert.assertEquals(no.mechatronics.sfi.fmuproxy.avro.StatusCode.OK_STATUS, status)
                    }

                    val end = Instant.now()
                    val duration = Duration.between(start, end)
                    LOG.info("Avro duration: ${duration.toMillis()}ms")

                }
            }
        }

    }

    @Test
    fun testJsonRpc() {

        val host = "localhost"
        val clients = listOf(
                RpcHttpClient(host, proxy.getPortFor(FmuProxyJsonHttpServer::class.java)!!),
                RpcWebSocketClient(host, proxy.getPortFor(FmuProxyJsonWsServer::class.java)!!),
                RpcTcpClient(host, proxy.getPortFor(FmuProxyJsonTcpServer::class.java)!!),
                RpcZmqClient(host, proxy.getPortFor(FmuProxyJsonZmqServer::class.java)!!)
        ).map { JsonRpcFmuClient(it) }


        val md = fmu.modelDescription

        clients.forEach { client ->

            LOG.info("Testing client of type ${client.javaClass.simpleName}")

            Assert.assertEquals(md.guid, client.guid)
            Assert.assertEquals(md.modelName, client.modelName)
            Assert.assertEquals(md.fmiVersion, client.fmiVersion)

            client.newInstance().use { instance ->

                Assert.assertTrue(instance.init() == FmiStatus.OK)

                val dt = 1.0/100
                val start = Instant.now()
                while (instance.currentTime < 10) {
                    val status = instance.step(dt)
                    Assert.assertTrue(status == FmiStatus.OK)
                }
                val end = Instant.now()
                val duration = Duration.between(start, end)
                LOG.info("Duration: ${duration.toMillis()}ms")

            }

        }

    }

}