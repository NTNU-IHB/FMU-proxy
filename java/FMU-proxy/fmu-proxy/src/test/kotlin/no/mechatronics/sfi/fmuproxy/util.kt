package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.common.FmuSlave
import org.junit.jupiter.api.Assertions
import kotlin.system.measureTimeMillis

internal inline fun runSlave(slave: FmuSlave, dt: Double, stop: Double, callback: () -> Unit = {}): Long {

    slave.setup()
    slave.enterInitializationMode()
    slave.exitInitializationMode()

    return measureTimeMillis {
        while (slave.simulationTime <= stop) {
            Assertions.assertTrue( slave.doStep(dt))
            callback()
        }
    }

}