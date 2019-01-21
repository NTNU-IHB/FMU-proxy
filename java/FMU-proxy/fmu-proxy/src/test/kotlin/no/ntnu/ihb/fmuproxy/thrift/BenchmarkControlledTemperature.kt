package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmuproxy.runSlave
import no.ntnu.ihb.fmuproxy.thrift.client.LightThriftClient
import no.ntnu.sfi.fmuproxy.TestUtils
import org.apache.thrift.transport.TTransportException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import kotlin.system.measureTimeMillis

class BenchmarkControlledTemperature {

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(BenchmarkControlledTemperature::class.java)

        private const val stop = 1.0
        private const val stepSize = 1E-4

    }

    private fun runLightInstance(slave: LightThriftClient.FmuInstance,
                                 stepSize: Double, stop: Double, callback: () -> Unit = {}) : Long {

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
    fun benchmark() {

       Fmu.from(File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")).use { fmu ->

           ThriftFmuSocketServer(fmu).use { server ->
               val port = server.start()
               for (i in 0..2) {
                   LightThriftClient(fmu.guid, "localhost", port).use { client ->

                       client.newInstance().use { slave ->
                           runLightInstance(slave, stepSize, stop) {
                               val read = slave.readReal(listOf(46))
                               Assertions.assertTrue(read.value[0] > 0)
                           }.also {
                               LOG.info("Thrift duration=${it}ms")
                           }
                       }

                   }
               }
           }

       }

    }

    @Test
    fun benchmarkRemote() {

        val port = 9090
        val host = "localhost"
        val guid = "{06c2700b-b39c-4895-9151-304ddde28443}" //20Sim ControlledTemperature FMU

        for (i in 0..2) {
            try {

                ThriftFmuClient.socketClient(guid, host, port).use { client ->
                    client.newInstance().use { instance ->
                        runSlave(instance, stepSize, stop) {
                            val read = instance.variableAccessor.readReal(46)
                            Assertions.assertTrue(read.value > 0)
                        }.also {
                            LOG.info("Thrift remote duration=${it}ms")
                        }
                    }
                }

            } catch (ex: TTransportException) {
                LOG.warn("Could not connect to remote server..")
                break
            }

        }

    }

    @Test
    fun benchmarkRemoteLight() {

        val port = 9090
        val host = "localhost"
        val guid = "{06c2700b-b39c-4895-9151-304ddde28443}" //20Sim ControlledTemperature FMU

        for (i in 0..2) {
            try {

               LightThriftClient(guid, host, port).use { client ->
                   client.newInstance().use { instance ->
                       runLightInstance(instance, stepSize, stop) {
                           val read = instance.readReal(listOf(46))
                           Assertions.assertTrue(read.value[0] > 0)
                       }.also {
                           LOG.info("Thrift remote duration=${it}ms")
                       }
                   }
               }

            } catch (ex: TTransportException) {
                LOG.warn("Could not connect to remote server..")
                break
            }

        }

    }

}