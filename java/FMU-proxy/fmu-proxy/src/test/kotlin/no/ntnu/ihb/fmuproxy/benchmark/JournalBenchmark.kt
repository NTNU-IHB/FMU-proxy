package no.ntnu.ihb.fmuproxy.benchmark

import no.ntnu.ihb.fmi4j.common.FmuSlave
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment
import no.ntnu.ihb.fmi4j.modeldescription.jaxb.JaxbModelDescriptionParser
import no.ntnu.ihb.fmi4j.util.OsUtil
import no.ntnu.ihb.fmuproxy.FmuId
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuClient
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuServer
import no.ntnu.ihb.fmuproxy.net.FmuProxyServer
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import java.io.File
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun filter(fmuDir: File): Pair<Fmu, DefaultExperiment>? {

    val fmuFile = fmuDir.listFiles().find {
        it.name.endsWith(".fmu")
    } ?: return null

    val refData = fmuDir.listFiles().find {
        it.name.endsWith("ref.csv")
    } ?: return null

    val defaultsData = fmuDir.listFiles().find {
        it.name.endsWith(".opt")
    } ?: return null

    val defaults = DefaultExperimentImpl.parse(defaultsData.readText())

    val inputData = fmuDir.listFiles().find {
        it.name.endsWith("in.csv")
    }

    if (refData.length() > 1E6) {
        println("FMU Rejected, reason: Reference data > 1MB")
        return null
    } else if (OsUtil.isLinux && "JModelica.org" in fmuDir.absolutePath) {
        println("FMU Rejected, reason: JModelica.org FMUs makes Linux crash.")
        return null
    } else if ("FMUSDK" in fmuDir.absolutePath || "Easy5" in fmuDir.absolutePath && fmuDir.absolutePath.contains("vanderpol", ignoreCase = true)) {
        println("FMU Rejected, reason: FMUSDK/vanDerPol.")
        return null
    } else if (defaults.stepSize == 0.0) {
        println("FMU Rejected, reason: stepSize == 0.0")
        return null
    } else if (inputData != null) {
        println("FMU Rejected, reason: Requires input data.")
        return null
    } else if (JaxbModelDescriptionParser.parse(fmuFile).asCoSimulationModelDescription().attributes.needsExecutionTool) {
        println("FMU Rejected, reason: FMU requires execution tool.")
        return null
    } else if (defaults.stepSize < 1e-4) {
        println("FMU Rejected, reason: StepSize to small.")
        return null
    } else if (defaults.stopTime > 20) {
        println("FMU Rejected, reason: stopTime to large.")
        return null
    }

    return Fmu.from(fmuFile) to defaults

}

fun assembleFmus(xcDir: String): List<Pair<Fmu, DefaultExperiment>> {
    val fmus = mutableListOf<Pair<Fmu, DefaultExperiment>>()
    File(xcDir, "fmus/2.0/cs/${OsUtil.currentOS}").listFiles().forEach { vendor ->
        vendor.listFiles().forEach { version ->
            version.listFiles().forEach { fmuDir ->
                filter(fmuDir)?.also {
                    println("Loading fmu $fmuDir")
                    fmus.add(it)
                }
            }
        }

    }
    return fmus.also {
        println("Assembled ${it.size} fmus, with a total simulation time of ${it.map { it.second.stopTime }.sum()}")
    }
}

fun runSlave(slave: FmuSlave, options: DefaultExperiment): Long {

    fun assert(flag: Boolean) {
        if (!flag) {
            throw IllegalStateException()
        }
    }

    val v = slave.modelDescription.modelVariables.find { it.isReal }!!.asRealVariable()

    val vr = longArrayOf(v.valueReference)
    val ref = DoubleArray(vr.size)

    return measureTimeMillis {

        assert(slave.setup(options.startTime, options.stopTime))
        assert(slave.enterInitializationMode())
        assert(slave.exitInitializationMode())
        while (slave.simulationTime <= (options.stopTime - options.stepSize)) {
            assert(slave.doStep(options.stepSize))
            slave.read(vr, ref)
        }
        assert(slave.terminate())
    }
}

object RunLocal {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
        }

        measureTimeMillis {
            assembleFmus(args[0]).parallelStream().mapToLong { pair ->
                runSlave(pair.first.asCoSimulationFmu().newInstance(), pair.second)
            }.sum().also {
                println("Accumulated time local: ${it}ms")
            }
        }.also {
            println("Total time local: ${it}ms")
        }

    }
}

fun runServer(xcDir: String, server: FmuProxyServer, port: Int) {

    server.use {
        val xcDefaults = mutableMapOf<FmuId, DefaultExperiment>()
        assembleFmus(xcDir).forEach {
            server.addFmu(it.first)
            xcDefaults[it.first.guid] = it.second
        }
        if (server is ThriftFmuSocketServer) {
            server.xcDefaults = xcDefaults
        } else if (server is GrpcFmuServer) {
            server.xcDefaults = xcDefaults
        }
        server.start(port)

        println("Press eny key to exit..")
        if (Scanner(System.`in`).hasNext()) {
            println("Exiting..")
        }
    }

}

object ThriftServer {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
        }

        runServer(args[0], ThriftFmuSocketServer(), 9090)
        System.exit(0)

    }

}

object ThriftClient {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing host and port!")
        }

        val availableFmus = ThriftFmuClient.socketClient(args[0], args[1].toInt()).use { it.availableFmus }

        val clients = List(availableFmus.size) { ThriftFmuClient.socketClient(args[0], args[1].toInt()) }
        val slaves = clients.mapIndexed { i, client ->
            val (fmuId, de) = availableFmus[i]
            client.load(fmuId).newInstance() to de
        }

        val elapsed = measureTimeMillis {

            val count = AtomicInteger()
            slaves.parallelStream().mapToLong {
                runSlave(it.first, it.second).also {
                    println("${count.incrementAndGet()} of ${availableFmus.size} finished. Took ${it}ms")
                }
            }.sum().also {
                println("Accumulated time elapsed: ${it}ms")
            }

        }

        println("Total time elapsed: ${elapsed}ms")

        clients.forEach {
            it.close()
        }

    }
}


object GrpcServer {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
        }

        runServer(args[0], GrpcFmuServer(), 9091)
        System.exit(0)

    }

}


object GrpcClient {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.isEmpty()) {
            throw IllegalArgumentException("Missing host and port!")
        }

        GrpcFmuClient(args[0], args[1].toInt()).use { client ->

            client.availableFmus.parallelStream().mapToLong { avail ->
                client.load(avail.first.fmuId).use {
                    runSlave(it.newInstance(), avail.second)
                }
            }.sum().also {
                println("Elapsed remote: ${TimeUnit.MILLISECONDS.toSeconds(it)}s")
            }

        }

    }
}


class DefaultExperimentImpl : DefaultExperiment {

    override var startTime: Double = 0.0
    override var stepSize: Double = 1.0 / 100
    override var stopTime: Double = 1.0
    override var tolerance: Double = 0.0

    companion object {

        fun parse(txt: String): DefaultExperiment {

            return DefaultExperimentImpl().apply {
                txt.trim().split("\n").forEach { line ->

                    val split = line.split(",")
                    if (split.isNotEmpty()) {
                        val (fst, snd) = split
                        when (fst) {
                            "StartTime" -> startTime = snd.toDouble()
                            "StopTime" -> stopTime = snd.toDouble()
                            "StepSize" -> stepSize = snd.toDouble()
                            "RelTol" -> tolerance = snd.toDouble()
                        }
                    }

                }
            }

        }

    }

}


