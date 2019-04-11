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
import java.util.concurrent.atomic.AtomicInteger
import kotlin.streams.toList
import kotlin.system.measureTimeMillis

class BenchmarkData(
        val fmuFile: File,
        val defaults: DefaultExperiment
) {

    val fmu = Fmu.from(fmuFile)

    val version: String
        get() {
            return fmuFile.parentFile.parentFile.name
        }

    val vendor: String
        get() {
            return fmuFile.parentFile.parentFile.parentFile.name
        }

}

fun filter(fmuDir: File): BenchmarkData? {

    val fmuFile = fmuDir.listFiles().find {
        it.name.endsWith(".fmu")
    } ?: return null

    val defaultsData = fmuDir.listFiles().find {
        it.name.endsWith(".opt")
    } ?: return null

    val defaults = DefaultExperimentImpl.parse(defaultsData.readText())

    val md = JaxbModelDescriptionParser.parse(fmuFile).asCoSimulationModelDescription()

    if (OsUtil.isLinux && "JModelica.org" in fmuDir.absolutePath) {
//        println("FMU Rejected, reason: JModelica.org FMUs makes Linux crash.")
        return null
    } else if (listOf("FMUSDK", "Easy5", "Silver").any { fmuDir.absolutePath.contains(it) }) {
//        println("FMU Rejected, reason: FMUSDK/vanDerPol.")
        return null
    } else if (defaults.stepSize == 0.0) {
//        println("FMU Rejected, reason: stepSize == 0.0")
        return null
    } else if (md.attributes.needsExecutionTool) {
//        println("FMU Rejected, reason: FMU requires execution tool.")
        return null
    } else if (defaults.stepSize < 1e-4) {
//        println("FMU Rejected, reason: StepSize to small.")
        return null
    } else if (defaults.stopTime > 20) {
//        println("FMU Rejected, reason: stopTime to large.")
        return null
    } else if ("DS_FMU_Export_from_Simulink" in fmuDir.absolutePath && listOf("2.1.1", "2.1.2", "2.2.0").any { fmuDir.absolutePath.contains(it) }) {
        return null
    } else if ("MapleSim" in fmuDir.absolutePath && listOf("2015.2", "2016.1", "2016.2").any { fmuDir.absolutePath.contains(it) }) {
        return null
    }

    return BenchmarkData(fmuFile, defaults)

}

fun assembleFmus(xcDir: String): List<BenchmarkData> {
    val totalFmuCount = AtomicInteger()
    val fmus = mutableListOf<BenchmarkData>()
    File(xcDir, "fmus/2.0/cs/${OsUtil.currentOS}").listFiles().forEach { vendor ->
        vendor.listFiles().forEach { version ->
            version.listFiles().forEach { fmuDir ->
                totalFmuCount.getAndIncrement()
                filter(fmuDir)?.also {
                    println("Loading fmu $fmuDir, stopTime=${it.defaults.stopTime}, stepSize=${it.defaults.stepSize}")
                    fmus.add(it)
                }
            }
        }

    }
    return fmus.also {
        println("Assembled ${it.size} of ${totalFmuCount.get()} fmus, with a total simulation time of ${it.map { it.defaults.stopTime }.sum()}")
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

        val count = AtomicInteger()
        val availableFmus =  assembleFmus(args[0])
        val slaves = availableFmus.parallelStream().map { it.fmu.asCoSimulationFmu().newInstance() to it.defaults }.toList()
        measureTimeMillis {
            slaves.parallelStream().mapToLong { data ->
                runSlave(data.first, data.second).also { elapsed ->
                    val md = data.first.modelDescription
                    println("${count.incrementAndGet()} of ${availableFmus.size} finished. ${md.generationTool}/${md.modelName} took ${elapsed}ms")
                }
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
            server.addFmu(it.fmu)
            xcDefaults[it.fmu.guid] = it.defaults
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

        measureTimeMillis {

            val count = AtomicInteger()
            slaves.parallelStream().mapToLong { (instance, defaults) ->
                runSlave(instance, defaults).also { elapsed ->
                    val md = instance.modelDescription
                    println("${count.incrementAndGet()} of ${availableFmus.size} finished. ${md.generationTool}/${md.modelName} took ${elapsed}ms")
                }
            }.sum().also {
                println("Accumulated time elapsed: ${it}ms")
            }

        }.also {
            println("Total time elapsed: ${it}ms")
        }

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

        val availableFmus = GrpcFmuClient(args[0], args[1].toInt()).use { it.availableFmus }

        val clients = List(availableFmus.size) { GrpcFmuClient(args[0], args[1].toInt()) }
        val slaves = clients.mapIndexed { i, client ->
            val (fmuId, de) = availableFmus[i]
            client.load(fmuId).newInstance() to de
        }

        val elapsed = measureTimeMillis {

            val count = AtomicInteger()
            slaves.parallelStream().mapToLong { (instance, defaults) ->
                runSlave(instance, defaults).also { elapsed ->
                    val md = instance.modelDescription
                    println("${count.incrementAndGet()} of ${availableFmus.size} finished. ${md.generationTool}/${md.modelName} took ${elapsed}ms")
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


//object JsonServer {
//
//    @JvmStatic
//    fun main(args: Array<String>) {
//
//        if (args.isEmpty()) {
//            throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
//        }
//
//        runServer(args[0], FmuProxyJsonTcpServer(RpcFmuService()), 9092)
//        System.exit(0)
//
//    }
//
//}
//
//object JsonClient {
//
//    @JvmStatic
//    fun main(args: Array<String>) {
//
//        if (args.isEmpty()) {
//            throw IllegalArgumentException("Missing host and port!")
//        }
//
//        val availableFmus = JsonRpcFmuClient(RpcTcpClient(args[0], args[1].toInt())).use { it.availableFmus }
//
//        val clients = List(availableFmus.size) { GrpcFmuClient(args[0], args[1].toInt()) }
//        val slaves = clients.mapIndexed { i, client ->
//            val avail = availableFmus[i]
//            client.load(avail.fmuId).newInstance() to avail.defaultExperiment
//        }
//
//        val elapsed = measureTimeMillis {
//
//            val count = AtomicInteger()
//            slaves.parallelStream().mapToLong { (instance, defaults) ->
//                runSlave(instance, defaults!!).also { elapsed ->
//                    val md = instance.modelDescription
//                    println("${count.incrementAndGet()} of ${availableFmus.size} finished. ${md.generationTool}/${md.modelName} took ${elapsed}ms")
//                }
//            }.sum().also {
//                println("Accumulated time elapsed: ${it}ms")
//            }
//
//        }
//
//        println("Total time elapsed: ${elapsed}ms")
//
//        clients.forEach {
//            it.close()
//        }
//
//
//    }
//}


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


