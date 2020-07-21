package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.Status
import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.junit.jupiter.api.Assertions
import kotlin.system.measureTimeMillis

internal inline fun runSlave(slave: InternalFmuService.Client, dt: Double, stop: Double, callback: () -> Unit = {}): Long {

    slave.createInstance()
    slave.setupExperiment(0.0, 0.0, 0.0)
    slave.enterInitializationMode()
    slave.exitInitializationMode()

    var simulationTime = 0.0
    slave.step(dt)

    return measureTimeMillis {
        while (simulationTime <= stop) {
            Assertions.assertTrue( slave.step(dt).status == Status.OK_STATUS )
            simulationTime += dt
            callback()
        }
    }

}
