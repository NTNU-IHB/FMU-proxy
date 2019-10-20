package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuClient
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuServer
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServlet
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestProxy {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestProxy::class.java)

        private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

        private const val stepSize: Double = 1.0 / 100
        private const val stopTime: Double = 1.0
        private const val host = "localhost"

        private val testTimeout = Duration.ofSeconds(10)

    }

    private val proxy = FmuProxyBuilder(fmu).apply {
        addServer(GrpcFmuServer().apply { addFmu(fmu) }, 9090)
        addServer(ThriftFmuSocketServer().apply { addFmu(fmu) }, 9091)
        addServer(ThriftFmuServlet().apply { addFmu(fmu) }, 9092)

    }.build().apply {
        start()
    }


    @AfterAll
    fun tearDown() {
        Assertions.assertTimeout(Duration.ofSeconds(10)){
            proxy.stop()
            fmu.close()
        }
    }

    @Test
    fun testGrpc() {

        Assertions.assertTimeout(testTimeout) {
            proxy.getPortFor<GrpcFmuServer>()?.also { port ->

                GrpcFmuClient(host, port).load(fmu.guid).use { client ->

                    val mdLocal = fmu.modelDescription
                    val mdRemote = client.modelDescription

                    Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                    Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                    Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                    client.newInstance().use { instance ->

                        runSlave(instance, stepSize, stopTime).also {
                            LOG.info("gRPC duration: ${it}ms")
                        }

                    }
                }
            }
        }

    }

    @Test
    fun testThriftSocket() {

        Assertions.assertTimeout(testTimeout) {
            proxy.getPortFor<ThriftFmuSocketServer>()?.also { port ->
                ThriftFmuClient.socketClient(host, port).load(fmu.guid).use { client ->

                    val mdLocal = fmu.modelDescription
                    val mdRemote = client.modelDescription

                    Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                    Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                    Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                    client.newInstance().use { instance ->

                        runSlave(instance, stepSize, stopTime).also {
                            LOG.info("Thrift (socket) duration: ${it}ms")
                        }

                    }
                }
            }
        }

    }

    @Test
    fun testThriftServlet() {

        disableLog4jLoggers()

        Assertions.assertTimeout(testTimeout) {
            proxy.getPortFor<ThriftFmuServlet>()?.also { port ->
                ThriftFmuClient.servletClient(host, port).load(fmu.guid).use { client ->

                    val mdLocal = fmu.modelDescription
                    val mdRemote = client.modelDescription

                    Assertions.assertEquals(mdLocal.guid, mdRemote.guid)
                    Assertions.assertEquals(mdLocal.modelName, mdRemote.modelName)
                    Assertions.assertEquals(mdLocal.fmiVersion, mdRemote.fmiVersion)

                    client.newInstance().use { instance ->

                        runSlave(instance, stepSize, stopTime).also {
                            LOG.info("Thrift (servlet) duration: ${it}ms")
                        }

                    }
                }
            }
        }

    }

}
