package no.ntnu.ihb.fmi4j.crosscheck

import no.ntnu.ihb.fmi4j.driver.*
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionProvider
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonModelDescriptionParser
import no.ntnu.ihb.fmi4j.util.OsUtil
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServer
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.concurrent.atomic.AtomicInteger

private const val FMU_PROXY_VERSION = "0.1.0"

private const val README = """
        The cross-check results have been generated with FMI4j's FmuDriver.
        To get more information download the 'fmu-driver' tool from https://github.com/NTNU-IHB/FMI4j/releases and run:

        ```
        java -jar fmu-driver.jar -h
        ```
        """

class CrossChecker(
        private val server: ThriftFmuSocketServer,
        private val fmuDir: File,
        resultDir: File
) {

    private var failedOrRejected = false

    private val fmuPath = fmuDir.listFiles().find {
        it.name.endsWith(".fmu")
    } ?: throw IllegalArgumentException("No .fmu file present in the FMU dir!")

    private val refData = fmuDir.listFiles().find {
        it.name.endsWith("ref.csv")
    } ?: throw IllegalArgumentException("No *_ref.csv file present in FMU dir!")

    private val defaultsData = fmuDir.listFiles().find {
        it.name.endsWith(".opt")
    } ?: throw IllegalArgumentException("No .opt file present in FMU dir!")

    private val outputFolder = File(resultDir, getDefaultOutputDir(fmuDir)).apply {
        if (!exists()) {
            mkdirs()
        }
    }.absolutePath

    private val options: DriverOptions by lazy {

        val variables = parseVariables(refData)
        val defaults = CrossCheckOptions.parse(defaultsData.readText())

        DriverOptions(
                startTime = defaults.startTime,
                stopTime = defaults.stopTime,
                stepSize = defaults.stepSize,

                outputVariables = variables,
                outputFolder = outputFolder,

                failOnLargeSize = true
        )
    }

    private fun reject(reason: String) {
        File(outputFolder, "rejected").apply {
            createNewFile()
            writeText(reason)
        }
        LOG.warn("Rejected FMU '$fmuPath'. Reason: $reason")
        failedOrRejected = true
    }

    private fun fail(reason: String) {
        File(outputFolder, "failed").apply {
            createNewFile()
            writeText(reason)
        }
        LOG.warn("Failed to handle FMU '$fmuPath'. Reason: $reason")
        failedOrRejected = true
    }

    private fun pass() {
        File(outputFolder, "passed").apply {
            createNewFile()
        }
        LOG.info("FMU '$fmuPath' passed crosscheck")
    }

    private fun run(): Boolean {

        val inputData = fmuDir.listFiles().find {
            it.name.endsWith("in.csv")
        }

        var md: ModelDescriptionProvider? = null
        try {
            md = JacksonModelDescriptionParser.parse(fmuPath)
        } catch (ex: Exception) {
            LOG.error("Failed to parse model description!", ex)
            fail("Failed to parse model description!")
        }

        try {

            when {
                refData.length() > 1E6 -> reject("Reference data > 1MB")
                OsUtil.isLinux && "JModelica.org" in fmuDir.absolutePath -> reject("JModelica.org FMUs makes Linux crash.")
                options.stepSize < 0 -> reject("Invalid stepSize (stepSize < 0).")
                options.startTime >= options.stopTime -> reject("Invalid start and or stop time (startTime >= stopTime).")
                options.stepSize == 0.0 -> fail("Don't know how to handle variable step solver (stepsize=0.0).")
                inputData != null -> fail("Unable to handle input files yet.")
                md!!.asCoSimulationModelDescription().attributes.needsExecutionTool -> reject("FMU requires execution tool.")

            }

            if (!failedOrRejected) {

                Fmu.from(fmuPath).use { fmu ->
                    server.addFmu(fmu)

                    ThriftFmuClient.socketClient("localhost", server.port!!)
                            .load(fmu.modelDescription.guid).newInstance().use { slave ->

                        SlaveDriver(slave, options).run()
                        pass()

                    }

                    server.removeFmu(fmu)

                }


            }

        } catch (ex: Exception) {

            when (ex) {
                is Rejection -> reject(ex.reason)
                is Failure -> fail(ex.reason)
                else -> fail("Program error: $ex")
            }
        }

        File(outputFolder, "README.md").apply {
            writeText(README)
        }

        return !failedOrRejected

    }

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(CrossChecker::class.java)

        private fun parseVariables(refData: File): List<String> {
            val txt = refData.reader().buffered().readLine()
            return txt.split(",").let {
                it.subList(1, it.size).map { it.replace("^\"|\"$".toRegex(), "").trim() }
            }
        }

        fun run(crossCheckDir: String) {

            LOG.info("Path to cross-check dir: $crossCheckDir")

            val platform = OsUtil.currentOS
            val csPath = File("$crossCheckDir/fmus/2.0/cs/$platform")

            File("$crossCheckDir/results/2.0/cs/$platform/FMU-proxy/$FMU_PROXY_VERSION").apply {
                if (exists()) deleteRecursively()
            }

            File("$crossCheckDir/results/2.0/me/$platform/FMU-proxy/$FMU_PROXY_VERSION").apply {
                if (exists()) deleteRecursively()
            }

            fun crosscheck(dir: File): Int {

                val numPassed = AtomicInteger(0)

                val fmus = mutableListOf<File>();
                dir.listFiles().forEach { vendor ->
                    vendor.listFiles().forEach { version ->
                        version.listFiles().forEach { fmu ->
                            fmus.add(fmu)

                        }
                    }

                }

                ThriftFmuSocketServer().use {
                    it.start()
                    fmus.parallelStream().forEach { fmu ->
                        if (CrossChecker(it, fmu, File(crossCheckDir, "results")).run()) {
                            numPassed.incrementAndGet()
                        }
                    }
                }

                return numPassed.get()
            }

            LOG.info("${crosscheck(csPath)} Co-simulation FMUs passed cross-check")

            cleanup()
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

        private fun getDefaultOutputDir(fmuFile: File): String {
            var currentFile = fmuFile
            var names = mutableListOf<String>()
            for (i in 0..2) {
                names.add(currentFile.name)
                currentFile = currentFile.parentFile
            }

            names.addAll(listOf(FMU_PROXY_VERSION, "FMU-proxy"))

            for (i in 0..2) {
                names.add(currentFile.name)
                currentFile = currentFile.parentFile
            }
            return names.reverse().let { names.joinToString("/") }
        }

    }

}

fun main(args: Array<String>) {

    if (args.size != 1) {
        throw IllegalArgumentException("Missing path to fmi-cross-check folder!")
    }

    CrossChecker.run(args[0])

}