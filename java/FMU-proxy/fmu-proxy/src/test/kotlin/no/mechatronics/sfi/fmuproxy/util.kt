package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.common.FmiSimulation
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import org.junit.Assert
import kotlin.system.measureTimeMillis


internal inline fun runInstance(instance: FmiSimulation, dt: Double, stop: Double, callback: () -> Unit = {}) : Long {

    instance.init()
    Assert.assertEquals(FmiStatus.OK, instance.lastStatus)

    return measureTimeMillis {
        while (instance.currentTime < stop) {
            val status = instance.doStep(dt)
            Assert.assertTrue(status)
            callback()
        }
    }

}