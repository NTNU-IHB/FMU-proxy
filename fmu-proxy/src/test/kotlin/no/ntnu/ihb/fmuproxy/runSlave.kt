package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.SlaveInstance
import org.junit.jupiter.api.Assertions
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
internal inline fun runSlave(slave: SlaveInstance, dt: Double, stop: Double, callback: () -> Unit = {}): Duration {

    slave.setupExperiment(0.0, 0.0, 0.0)
    slave.enterInitializationMode()
    slave.exitInitializationMode()

    return measureTime {
        while (slave.simulationTime <= stop) {
            Assertions.assertTrue(slave.doStep(dt))
            callback()
        }
    }

}
