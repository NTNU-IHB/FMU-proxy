package no.mechatronics.sfi.fmu_proxy

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.http.RpcHttpClient
import info.laht.yaj_rpc.net.tcp.RpcTcpClient
import info.laht.yaj_rpc.net.ws.RpcWebSocketClient
import info.laht.yaj_rpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuClient
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.Proto
import no.mechatronics.sfi.fmu_proxy.grpc.services.GrpcFmuServiceImpl
import no.mechatronics.sfi.fmu_proxy.json_rpc.*
import no.mechatronics.sfi.fmu_proxy.thrift.StatusCode
import no.mechatronics.sfi.fmu_proxy.thrift.ThriftFmuClient
import no.mechatronics.sfi.fmu_proxy.thrift.ThriftFmuServer
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
        const val stopTime: Double = 10.0

        lateinit var fmuFile: FmuFile
        lateinit var proxy: FmuProxy

        @JvmStatic
        @BeforeClass
        fun setup() {
            val url = TestInputParser::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)
            fmuFile = FmuFile(File(url.file))


            proxy = ProxyBuilder(fmuFile).apply {
                addServer(ThriftFmuServer(fmuFile))
                addServer(GrpcFmuServer(listOf(GrpcFmuServiceImpl(fmuFile))))
                RpcHandler(RpcFmuService(fmuFile)).also { handler ->
                    addServer(FmuProxyJsonHttpServer(handler))
                    addServer(FmuProxyJsonWsServer(handler))
                    addServer(FmuProxyJsonTcpServer(handler))
                    addServer(FmuProxyJsonZmqServer(handler))
                }

            }.build().apply { start() }.also { println(it.networkInfo) }

        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            proxy.stop()
        }

    }

    @Test
    fun testGrpc() {

        proxy.getPortFor(GrpcFmuServer::class.java)?.also { port ->

            GrpcFmuClient("localhost", port).use { client ->

                val mdLocal = fmuFile.modelDescription
                val mdRemote = client.modelDescription

                Assert.assertEquals(mdLocal.guid, mdRemote.guid)
                Assert.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assert.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.createInstance().use { fmu ->

                    Assert.assertTrue(fmu.init())

                    val start = Instant.now()
                    while (fmu.currentTime < stopTime) {
                        val status = fmu.step(stepSize)
                        Assert.assertEquals(Proto.StatusCode.OK_STATUS, status.code)
                    }

                    val end = Instant.now()
                    val duration = Duration.between(start, end)
                    LOG.info("Duration: ${duration.toMillis()}ms")

                }
            }
        }

    }

    @Test
    fun testThrift() {

        proxy.getPortFor(ThriftFmuServer::class.java)?.also { port ->
            ThriftFmuClient("localhost", port).use { client ->

                val mdLocal = fmuFile.modelDescription
                val mdRemote = client.modelDescription

                Assert.assertEquals(mdLocal.guid, mdRemote.guid)
                Assert.assertEquals(mdLocal.modelName, mdRemote.modelName)
                Assert.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                client.createInstance().use { fmu ->

                    Assert.assertTrue(fmu.init())
                    val start = Instant.now()
                    while (fmu.currentTime < stopTime) {
                        val status = fmu.step(stepSize)
                        Assert.assertEquals(StatusCode.OK_STATUS, status)
                    }

                    val end = Instant.now()
                    val duration = Duration.between(start, end)
                    LOG.info("Duration: ${duration.toMillis()}ms")

                }
            }
        }

    }

    @Test
    fun testJsonRpc() {

        val clients = listOf(
                RpcHttpClient("localhost", proxy.getPortFor(FmuProxyJsonHttpServer::class.java)!!),
                RpcWebSocketClient("localhost", proxy.getPortFor(FmuProxyJsonWsServer::class.java)!!),
                RpcTcpClient("localhost", proxy.getPortFor(FmuProxyJsonTcpServer::class.java)!!),
                RpcZmqClient("localhost", proxy.getPortFor(FmuProxyJsonZmqServer::class.java)!!)
        ).map { TestJsonRpcClients.FmuRpcClient(it) }


        val md = fmuFile.modelDescription

        clients.forEach {
            it.use { fmu ->

                LOG.info("Testing client of type ${fmu.client.javaClass.simpleName}")

                Assert.assertEquals(md.guid, fmu.guid)
                Assert.assertEquals(md.modelName, fmu.modelName)

                Assert.assertTrue(fmu.init())

                val dt = 1.0/100
                val start = Instant.now()
                while (fmu.currentTime < 10) {
                    val status = fmu.step(dt)
                    Assert.assertTrue(status)
                }
                val end = Instant.now()
                val duration = Duration.between(start, end)
                LOG.info("Duration: ${duration.toMillis()}ms")

            }

        }

    }

}