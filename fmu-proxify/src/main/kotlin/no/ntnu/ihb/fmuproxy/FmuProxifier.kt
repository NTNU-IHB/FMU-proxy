package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.FmuBuilder
import picocli.CommandLine
import java.io.File
import java.nio.file.Files

class FmuProxifier(
    private val fmu: File,
    private val remote: RemoteAddress? = null
) {

    init {
        require(fmu.exists()) { "No such file: $fmu" }
        require(fmu.extension == "fmu") { "Invalid extension: ${fmu.extension}" }
    }

    fun build(dest: File? = null): File {

        var settingsText = "fmu=${fmu.name}\n"
        remote?.also {
            settingsText += "remote=${it.strRepr}"
        }

        val tmpSettingsFolder = Files.createTempDirectory("fmu-proxifier").toFile()
        val tmpSettingsFile = File(tmpSettingsFolder, "proxy-settings.txt").apply {
            writeText(settingsText)
        }

        val fmuJar = File(FmuProxifier::class.java.classLoader.getResource("fmu-wrapper.jar")!!.file)
        val serverJar = File(FmuProxifier::class.java.classLoader.getResource("fmu-proxy-server.jar")!!.file)

        val proxyFmu = FmuBuilder(
            mainClass = "no.ntnu.ihb.fmuproxy.FmuWrapper",
            jarFile = fmuJar,
            resources = arrayOf(fmu, serverJar, tmpSettingsFile)
        ).build(dest)

        tmpSettingsFile.deleteRecursively()

        return proxyFmu

    }

    @CommandLine.Command(name = "fmu-proxify")
    class Args : Runnable {

        @CommandLine.Option(names = ["-h", "--help"], description = ["Print this message and quits."], usageHelp = true)
        var showHelp = false

        @CommandLine.Option(names = ["-r", "--remote"], description = ["Optional host to connect to. e.g. 127.0.0.1:9090"])
        var remoteAddress: String? = null

        @CommandLine.Option(names = ["-f", "--file"], description = ["Path to the FMU to proxify."], required = true)
        lateinit var fmuFile: File

        @CommandLine.Option(names = ["-d", "--dest"], description = ["Where to save the FMU."])
        var destFile: File? = null

        override fun run() {
            val remote = remoteAddress?.let { RemoteAddress.parse(it) }
            FmuProxifier(fmuFile, remote).build(destFile)
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CommandLine(Args()).execute(*args)
        }
    }

}

data class RemoteAddress(
    val host: String,
    val port: Int
) {

    val strRepr = "$host:$port"

    companion object {

        fun parse(str: String): RemoteAddress {
            val (host, port) = str.split(":")
            return RemoteAddress(host, port.toInt())
        }

    }

}

