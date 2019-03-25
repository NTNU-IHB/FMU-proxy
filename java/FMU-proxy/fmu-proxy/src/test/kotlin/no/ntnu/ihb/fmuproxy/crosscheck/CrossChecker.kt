package no.ntnu.ihb.fmuproxy.crosscheck

import no.ntnu.ihb.fmi4j.driver.DriverOptions
import no.ntnu.ihb.fmi4j.driver.Failure
import no.ntnu.ihb.fmi4j.driver.Rejection
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionProvider
import no.ntnu.ihb.fmi4j.modeldescription.jaxb.JaxbModelDescriptionParser
import no.ntnu.ihb.fmi4j.util.OsUtil
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*

fun filter(fmuDir: File): Fmu? {

    val fmuFile = fmuDir.listFiles().find {
        it.name.endsWith(".fmu")
    } ?: return null

    val refData = fmuDir.listFiles().find {
        it.name.endsWith("ref.csv")
    } ?: return null

    val defaultsData = fmuDir.listFiles().find {
        it.name.endsWith(".opt")
    } ?: return null

    val defaults = CrossCheckOptions.parse(defaultsData.readText())

    val inputData = fmuDir.listFiles().find {
        it.name.endsWith("in.csv")
    }

    if (refData.length() > 1E6) {
        println("FMU Rejected, reason: Reference data > 1MB")
        return null
    } else if ( OsUtil.isLinux && "JModelica.org" in fmuDir.absolutePath) {
        println("FMU Rejected, reason: JModelica.org FMUs makes Linux crash.")
        return null
    } else if (defaults.stepSize == 0.0) {
        println("FMU Rejected, reason: Invalid start and or stop time (startTime >= stopTime).")
        return null
    } else if (inputData != null) {
        println("FMU Rejected, reason: FMU requires execution tool.")
        return null
    }else if (JaxbModelDescriptionParser.parse(fmuFile).asCoSimulationModelDescription().attributes.needsExecutionTool) {
        println("FMU Rejected, reason: FMU requires execution tool.")
        return null
    }

    return Fmu.from(fmuFile)

}


object ThriftServer {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
        }

        val fmus = mutableListOf<Fmu>()
        File(args[0], "fmus/2.0/cs/${OsUtil.currentOS}").listFiles().forEach { vendor ->
            vendor.listFiles().forEach { version ->
                version.listFiles().forEach { fmuDir ->
                    filter(fmuDir)?.also {
                        println("Loading fmu $it")
                        fmus.add(it)
                    }
                }
            }

        }

        val server = ThriftFmuSocketServer().apply {
            fmus.forEach {
                addFmu(it)
            }
            start(9090)
        }

        println("Press eny key to exit..")
        if (Scanner(System.`in`).hasNext()) {
            println("Exiting..")
        }
        server.stop()
        cleanup()

    }

}

object ThriftClient {

    @JvmStatic
    fun main(args: Array<String>) {

    }

}

object RemoteTest {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
        }

        val server = ThriftFmuSocketServer()
        File(args[0], "fmus/2.0/cs/${OsUtil.currentOS}").listFiles().forEach { vendor ->
            vendor.listFiles().forEach { version ->
                version.listFiles().forEach { fmuFile ->
                    server.addFmu(Fmu.from(fmuFile))
                }
            }

        }

    }

}

private fun cleanup() {

    listOf(
            "startvalues.txt",
            "vanDerPol.simulation.ezanl",
            "vanDerPol.simulation.ezapl",
            "vanDerPol.simulation.ezrpd",
            "vanDerPol.simulation_old.ezapl",
            "vanDerPol.simulation_old.ezrpd"
    ).forEach {
        File(it).apply {
            if (exists()) {
                delete()
            }
        }
    }

}
