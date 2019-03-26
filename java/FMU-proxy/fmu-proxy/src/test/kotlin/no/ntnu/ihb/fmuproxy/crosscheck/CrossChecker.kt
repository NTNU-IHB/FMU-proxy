package no.ntnu.ihb.fmuproxy.crosscheck

import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.jaxb.JaxbModelDescriptionParser
import no.ntnu.ihb.fmi4j.util.OsUtil
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import java.io.File
import java.util.*
import kotlin.system.measureTimeMillis

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

        ThriftFmuSocketServer().use { server ->
            fmus.forEach {
                server.addFmu(it)
            }
            server.start(9090)

            println("Press eny key to exit..")
            if (Scanner(System.`in`).hasNext()) {
                println("Exiting..")
            }

        }

        cleanup()
        System.exit(0)

    }

}

object ThriftClient {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing host and port!")
        }

        val host = args[0]
        val port = args[1].toInt()

        println("$host:$port")

        ThriftFmuClient.socketClient(host, port).use { client1 ->

            val elapsed = measureTimeMillis {
                client1.availableFmus.parallelStream().forEach { avail ->

                    ThriftFmuClient.socketClient(host, port).use { client2 ->
                        client2.load(avail.fmuId).use {
                            it.newInstance().use { slave ->
                                slave.setup()
                                slave.enterInitializationMode()
                                slave.exitInitializationMode()
                                while (slave.simulationTime < 1.0) {
                                    slave.doStep(1.0/100)
                                }
                                slave.terminate()
                            }
                        }
                    }

                }
            }

            println("Elapsed=${elapsed}ms")

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
