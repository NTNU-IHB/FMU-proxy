package no.ntnu.ihb.fmuproxy.misc

import java.io.File
import java.io.InputStream
import java.io.StringReader
import java.net.ServerSocket
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.xml.bind.JAXB

internal fun String.isLoopback(): Boolean {
    return this == "localhost" || this == "127.0.0.1"
}

private fun getAvailablePort(): Int {
    return ServerSocket(0).use {
        it.localPort
    }
}

internal fun startProxy(proxyFile: File, fmuFile: File): Int {

    require(fmuFile.exists()) { "No such file: $fmuFile" }
    require(proxyFile.exists()) { "No such file: $proxyFile" }

    val port = getAvailablePort()
    val cmd = arrayOf(
        "java", "-jar",
        proxyFile.absolutePath,
        "$port", fmuFile.absolutePath
    )

    ProcessBuilder().apply {
        command(*cmd)
        start()
    }

    return port
}

internal fun extractModelDescriptionXml(stream: InputStream): String {
    val xmlFile = "modelDescription.xml"
    ZipInputStream(stream).use { zis ->
        var nextEntry: ZipEntry? = zis.nextEntry
        while (nextEntry != null) {
            if (nextEntry.name == xmlFile) {
                return zis.bufferedReader().use { it.readText() }
            }
            nextEntry = zis.nextEntry
        }
    }
    throw IllegalArgumentException("Input is not an valid FMU! No $xmlFile present!")
}


internal fun extractFmiVersion(xml: String): String {
    return JAXB.unmarshal(StringReader(xml), MockupModelDescription::class.java).fmiVersion
}

internal fun parseSettings(settings: File): ProxySettings {
    require(settings.exists()) { "No such file: $settings" }
    return parseSettings(settings.readText())
}

internal fun parseSettings(str: String): ProxySettings {

    val fmuRegex = "fmu\\s*=\\s*(.*)".toRegex()
    val remoteRegex = "remote\\s*=\\s*(.*)".toRegex()

    val fmu = fmuRegex.find(str)?.groupValues?.get(1)!!
    val remote = remoteRegex.find(str)?.groupValues?.get(1)

    return ProxySettings(fmu, remote)

}
