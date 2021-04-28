package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.Status
import no.ntnu.ihb.fmuproxy.thrift.internal.FmuService
import org.junit.jupiter.api.Assertions
import kotlin.system.measureTimeMillis

internal inline fun runSlave(slave: FmuService.Client, dt: Double, stop: Double, callback: () -> Unit = {}): Long {

    slave.setupExperiment(0.0, 0.0, 0.0)
    slave.enterInitializationMode()
    slave.exitInitializationMode()

    var simulationTime = 0.0

    return measureTimeMillis {
        while (simulationTime <= stop) {
            Assertions.assertTrue( slave.step(simulationTime, dt) == Status.OK_STATUS )
            simulationTime += dt
            callback()
        }
    }

}
