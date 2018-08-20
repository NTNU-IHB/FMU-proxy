package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.common.FmuSlave
import org.junit.jupiter.api.Assertions
import kotlin.system.measureTimeMillis

internal inline fun runInstance(instance: FmuSlave, dt: Double, stop: Double, callback: () -> Unit = {}) : Long {

    if (!instance.isInitialized) {
        instance.init()
        Assertions.assertEquals(FmiStatus.OK, instance.lastStatus)
    }

    return measureTimeMillis {
        while (instance.currentTime <= stop) {
            val status = instance.doStep(dt)
            Assertions.assertTrue(status)
            callback()
        }
    }

}