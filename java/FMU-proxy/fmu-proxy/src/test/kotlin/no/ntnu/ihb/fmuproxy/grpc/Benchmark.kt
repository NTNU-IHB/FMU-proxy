package no.ntnu.ihb.fmuproxy.grpc

import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.common.RealArray
import no.ntnu.ihb.fmi4j.common.readReal
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmuproxy.runSlave
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.concurrent.ExecutionException


class Benchmark {

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Benchmark::class.java)

        private const val stop = 1.0
        private const val stepSize = 1E-4

    }

    @Test
    fun benchmark() {

        Fmu.from(File(TestUtils.getTEST_FMUs(), "2.0/cs/20sim/4.6.4.8004/" +
                "ControlledTemperature/ControlledTemperature.fmu")).use { fmu ->

            val vr = longArrayOf(46)
            val buffer = RealArray(vr.size)
            GrpcFmuServer().apply { addFmu(fmu) }.use { server ->
                val port = server.start()
                for (i in 0..2) {
                    GrpcFmuClient("localhost", port).load(fmu.guid).use { client ->

                        client.newInstance().use { slave ->
                            runSlave(slave, stepSize, stop) {
                                val status = slave.readReal(vr, buffer)
                                Assertions.assertEquals(FmiStatus.OK, status)
                                Assertions.assertTrue(buffer[0] > 0)
                            }.also {
                                LOG.info("gRPC duration=${it}ms")
                            }
                        }

                    }
                }
            }

        }

    }

    @Test
    fun benchmarkRemote() {

        val port = 9080
        val host = "localhost"
        val guid = "{06c2700b-b39c-4895-9151-304ddde28443}" //20Sim ControlledTemperature FMU

        for (i in 0..2) {
            try {

                GrpcFmuClient(host, port).load(guid).use { client ->
                    client.newInstance().use { slave ->
                        runSlave(slave, stepSize, stop) {
                            val read = slave.readReal(46)
                            Assertions.assertTrue(read.value > 0)
                        }.also {
                            LOG.info("gRPC remote duration=${it}ms")
                        }
                    }
                }

            } catch (ex: ExecutionException) {
                LOG.warn("Could not connect to remote server..")
                break
            }

        }

    }

}