package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.TestUtils
import org.apache.thrift.transport.TTransportException
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*
import kotlin.system.measureTimeMillis

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BenchmarkControlledTemperature {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(BenchmarkControlledTemperature::class.java)

        private const val dt = 1E-4
        private const val stop = 10.0

        private val fmuPath = File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/${TestUtils.getOs()}/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    }

    private val fmu = Fmu.from(fmuPath)

    internal fun runInstance(instance: ThriftTestClient.FmuInstance, dt: Double, stop: Double, callback: () -> Unit = {}) : Long {

        instance.init()
        return measureTimeMillis {
            while (instance.currentTime < stop) {
                val status = instance.doStep(dt)
                Assertions.assertTrue(status)
                callback()
            }
        }

    }

    @AfterAll
    fun cleanup() {
        fmu.close()
    }

    @Test
    fun benchmark() {

        val server = ThriftFmuServer(fmu)
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

        server.close()

    }


    @Test
    fun benchmarkRemote1() {


        for (i in 0..2) {
            try {

               ThriftTestClient("localhost", 9090).use { client ->
                   client.newInstance().use { instance ->
                       runInstance(instance, dt, stop) {
                           val read = instance.readReal(46)
                           Assertions.assertTrue(read.value > 0)
                       }.also {
                           LOG.info("Thrift duration=${it}ms")
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