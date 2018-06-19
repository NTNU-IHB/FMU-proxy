package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
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

//    @Test
//    fun test() {
//
//        for (i in 0..5) {
//            val client = ThriftTestClient("localhost", 9090)
//            client.newInstance().use { instance ->
//                runInstance(instance, dt, stop, {
//                    val read = instance.readReal(46)
//                    Assertions.assertTrue(read.value > 0)
//                }).also {
//                    LOG.info("Thrift duration=${it}ms")
//                }
//            }
//            client.close()
//        }
//
//    }


    @Test
    fun benchmark() {

       fmu.use {
           val server = ThriftFmuServer(fmu)
           val port = server.start()

           val client = ThriftTestClient("localhost", 9090)
           client.newInstance().use { instance ->
               runInstance(instance, dt, stop, {
                   val read = instance.readReal(46)
                   Assertions.assertTrue(read.value > 0)
               }).also {
                   LOG.info("Thrift duration=${it}ms")
               }
           }

           client.close()
           server.close()
       }

    }

}