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

        val tmpDir = Files.createTempDirectory("fmu_proxy").toFile()
        val tmpSettingsFile = File(tmpDir, "proxy-settings.txt").apply {
            writeText(settingsText)
        }

        val fmuJarResource = FmuProxifier::class.java.classLoader.getResource("fmu-wrapper.jar")!!
        val serverJarResource = FmuProxifier::class.java.classLoader.getResource("fmu-proxy-server.jar")!!

        val fmuJar = File(tmpDir, "fmu-wrapper.jar").apply {
            writeBytes(fmuJarResource.readBytes())
        }

        val serverJar = File(tmpDir, "fmu-proxy-server.jar").apply {
            writeBytes(serverJarResource.readBytes())
        }

        val proxyFmu = FmuBuilder(
            mainClass = "no.ntnu.ihb.fmuproxy.FmuWrapper",
            jarFile = fmuJar,
            resources = arrayOf(fmu, serverJar, tmpSettingsFile)
        ).build(dest)

        tmpDir.deleteRecursively()

        return proxyFmu

    }

    @CommandLine.Command(name = "fmu-proxify")
    class Args : Runnable {

        @CommandLine.Option(names = ["-h", "--help"], description = ["Print this message and quits."], usageHelp = true)
        var showHelp = false

        @CommandLine.Option(names = ["-r", "--remote"], description = ["Optional host to connect to. e.g. 127.0.0.1:9090"])
        var remoteAddress: String? = null

        @CommandLine.Option(names = ["-d", "--dest"], description = ["Where to save the FMU (defaults to current folder)."])
        var destFile: File? = null

        @CommandLine.Parameters(
                arity = "1",
                paramLabel = "FMU-FILE",
                description = ["Path to the FMU to proxify."],
        )
        lateinit var fmuFile: File

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

