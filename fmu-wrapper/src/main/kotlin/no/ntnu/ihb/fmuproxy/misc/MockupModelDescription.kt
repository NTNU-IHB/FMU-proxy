package no.ntnu.ihb.fmuproxy.misc

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

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
