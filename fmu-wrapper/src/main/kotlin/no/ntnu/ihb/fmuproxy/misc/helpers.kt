package no.ntnu.ihb.fmuproxy.misc

import no.ntnu.ihb.fmi4j.modeldescription.fmi1.FmiCausality
import no.ntnu.ihb.fmi4j.modeldescription.fmi1.FmiModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.fmi1.FmiScalarVariable
import no.ntnu.ihb.fmi4j.modeldescription.fmi1.FmiVariability
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2Causality
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2Variability
import no.ntnu.ihb.fmuproxy.thrift.FmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket
import java.io.File
import java.io.InputStream
import java.io.StringReader
import java.net.ServerSocket
import java.nio.ByteBuffer
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

internal fun startRemoteProxy(fmuFile: File, host: String, port: Int): Int {
    //with 150 MB max message size
    val transport = TFramedTransport.Factory(150000000)
        .getTransport(TSocket(host, port))
    val protocol = TBinaryProtocol(transport)
    val client = FmuService.Client(protocol)
    transport.open()

    return if (host.isLoopback()) {
        client.loadFromLocalFile(fmuFile.absolutePath)
    } else {
        val data = fmuFile.readBytes().let {
            ByteBuffer.wrap(it)
        }
        client.loadFromRemoteFile(fmuFile.name, data)
    }
}

internal fun startLocalProxy(proxyFile: File, fmuFile: File): Int {

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

internal fun FmiCausality?.fmi2Type(v: FmiVariability?): Fmi2Causality? {

    return when (this) {
        FmiCausality.input -> if (v == FmiVariability.parameter) Fmi2Causality.parameter else Fmi2Causality.input
        FmiCausality.output -> Fmi2Causality.output
        FmiCausality.internal, FmiCausality.none -> Fmi2Causality.local
        else -> null
    }

}

internal fun FmiVariability?.fmi2Type(): Fmi2Variability? {
    return when (this) {
        FmiVariability.constant -> Fmi2Variability.constant
        FmiVariability.parameter -> Fmi2Variability.fixed
        FmiVariability.discrete -> Fmi2Variability.discrete
        FmiVariability.continuous -> Fmi2Variability.continuous
        else -> null
    }
}

internal fun FmiModelDescription.DefaultExperiment?.fmi2Type(): Fmi2ModelDescription.DefaultExperiment? {
    if (this == null) return null
    return Fmi2ModelDescription.DefaultExperiment().apply {
        this.startTime = this@fmi2Type.startTime
        this.stopTime = this@fmi2Type.stopTime
        this.tolerance = this@fmi2Type.tolerance
    }
}

