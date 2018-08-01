package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.TestUtils
import org.apache.thrift.transport.TTransportException
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*
import kotlin.system.measureTimeMillis

class BenchmarkControlledTemperature {

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(BenchmarkControlledTemperature::class.java)

        private const val dt = 1E-4
        private const val stop = 1.0

    }

    private fun runInstance(instance: ThriftTestClient.FmuInstance,
                            dt: Double, stop: Double, callback: () -> Unit = {}) : Long {

        instance.init()
        return measureTimeMillis {
            while (instance.currentTime < stop) {
                val status = instance.doStep(dt)
                Assertions.assertTrue(status)
                callback()
            }
        }

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
    fun benchmark() {

       Fmu.from(File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/${TestUtils.getOs()}" +
                        "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")).use { fmu ->

           ThriftFmuServer(fmu).use { server ->
               val port = server.start()
               for (i in 0..2) {
                   ThriftTestClient("localhost", port).use { client ->

                       client.newInstance().use { instance ->
                           runInstance(instance, dt, stop) {
                               val read = instance.readReal(46)
                               Assertions.assertTrue(read.value > 0)
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

        for (i in 0..2) {
            try {

               ThriftTestClient("localhost", 9090).use { client ->
                   client.newInstance().use { instance ->
                       runInstance(instance, dt, stop) {
                           val read = instance.readReal(46)
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

}