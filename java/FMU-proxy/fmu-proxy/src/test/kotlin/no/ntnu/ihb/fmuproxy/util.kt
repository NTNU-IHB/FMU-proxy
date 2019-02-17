package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.common.FmuSlave
import org.apache.log4j.Level
import org.apache.log4j.LogManager
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


internal fun disableLog4jLoggers() {

    val loggers = LogManager.getCurrentLoggers().toList().toMutableList().apply {
        add(LogManager.getRootLogger())
    }
    for (logger in loggers) {
        (logger as org.apache.log4j.Logger).apply {
            if (name.contains("root")) {
                level = Level.INFO
            }
        }
    }

}