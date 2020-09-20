package no.ntnu.ihb.fmuproxy

import java.io.InputStream
import java.io.StringReader
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.xml.bind.JAXB
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

internal fun String.isLoopback(): Boolean {
    return this == "localhost" || this == "127.0.0.1"
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


fun extractFmiVersion(xml: String): String {
    return JAXB.unmarshal(StringReader(xml), MockupModelDescription::class.java).fmiVersion
}

@XmlRootElement(name = "fmiModelDescription")
internal class MockupModelDescription {

    @XmlAttribute(name = "fmiVersion", required = true)
    private val fmiVersion_: String? = null

    @XmlAttribute(name = "guid", required = true)
    private val guid_: String? = null

    val fmiVersion: String
        get() = fmiVersion_!!

    val guid: String
        get() = guid_!!

}
