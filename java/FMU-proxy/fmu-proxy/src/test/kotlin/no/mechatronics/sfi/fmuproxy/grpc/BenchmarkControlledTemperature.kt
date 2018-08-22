package no.mechatronics.sfi.fmuproxy.grpc

import io.grpc.StatusRuntimeException
import no.mechatronics.sfi.fmi4j.common.FmuSlave
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.importer.misc.currentOS
import no.mechatronics.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis
import java.io.File


class BenchmarkControlledTemperature {

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(BenchmarkControlledTemperature::class.java)

        private const val stop = 1.0
        private const val stepSize = 1E-4

    }

    private fun runInstance(slave: FmuSlave, stepSize: Double, stop: Double, callback: () -> Unit = {}) : Long {

        slave.init()
        return measureTimeMillis {
            while (slave.simulationTime < stop) {
                val status = slave.doStep(stepSize)
                Assertions.assertTrue(status)
                callback()
            }
        }

    }


    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
    fun benchmark() {

        Fmu.from(File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/$currentOS" +
                        "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")).use { fmu ->


            GrpcFmuServer(fmu).use { server ->
                val port = server.start()
                for (i in 0..2) {
                    GrpcFmuClient(fmu.guid,"localhost", port).use { client ->

                        client.newInstance().use { slave ->
                            runInstance(slave, stepSize, stop) {
                                val read = slave.readReal(intArrayOf(46))
                                Assertions.assertTrue(read.value[0] > 0)
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

                GrpcFmuClient(guid, host, port).use { client ->
                    client.newInstance().use { slave ->
                        runInstance(slave, stepSize, stop) {
                            val read = slave.readReal(46)
                            Assertions.assertTrue(read.value > 0)
                        }.also {
                            LOG.info("gRPC remote duration=${it}ms")
                        }
                    }
                }

            } catch (ex: StatusRuntimeException) {
                LOG.warn("Could not connect to remote server..")
                break
            }

        }

    }

}