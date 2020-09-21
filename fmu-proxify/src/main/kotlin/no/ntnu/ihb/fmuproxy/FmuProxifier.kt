package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.FmuBuilder
import picocli.CommandLine
import java.io.File
import java.nio.file.Files

class FmuProxifier(
        private val host: String,
        private val port: Int,
        private val fmu: File
) {

    init {
        require(fmu.exists()) { "No such file: $fmu" }
        require(fmu.extension == "fmu") { "Invalid extension: ${fmu.extension}" }
    }

    fun build(dest: File? = null) {

        val tmpSettingsFolder = Files.createTempDirectory("fmu-proxifier").toFile()
        val tmpSettingsFile = File(tmpSettingsFolder, "proxy-settings.txt").apply {
            writeText("""
                $host:$port
                ${fmu.name}
            """.trimIndent())
        }

        val jarFile = File(FmuProxifier::class.java.classLoader.getResource("fmu-wrapper.jar")!!.file)

        FmuBuilder(
                mainClass = "no.ntnu.ihb.fmuproxy.FmuWrapper",
                jarFile = jarFile,
                resources = arrayOf(fmu, tmpSettingsFile)
        ).build(dest)

        tmpSettingsFile.deleteRecursively()

    }

    @CommandLine.Command(name = "fmu-proxifier")
    class Args : Runnable {

        @CommandLine.Option(names = ["-h", "--help"], description = ["Print this message and quits."], usageHelp = true)
        var showHelp = false

        @CommandLine.Option(names = ["--port"], description = ["Port."])
        var port: Int = 9090

        @CommandLine.Option(names = ["--host"], description = ["Host."])
        var host: String = "localhost"

        @CommandLine.Option(names = ["-f", "--file"], description = ["Path to the FMU to proxify."], required = true)
        lateinit var jarFile: File

        @CommandLine.Option(names = ["-d", "--dest"], description = ["Where to save the FMU."], required = false)
        var destFile: File? = null

        override fun run() {
            FmuProxifier(host, port, jarFile).build(destFile)
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CommandLine(Args()).execute(*args)
        }
    }

}
