package no.mechatronics.sfi.grpc_fmu.utils

import org.apache.commons.io.IOUtils
import java.io.InputStream
import java.nio.charset.Charset
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


fun exctractModelDescriptionXml(stream: InputStream): String {

    ZipInputStream(stream).use {

        var nextEntry: ZipEntry? = it.nextEntry
        while (nextEntry != null) {

            val name = nextEntry.name
            if (name == "modelDescription.xml") {
                return IOUtils.toString(it, Charset.forName("UTF-8"))
            }

            nextEntry = it.nextEntry
        }

    }

    throw IllegalArgumentException("Input is not an valid FMU! No modelDescription.xml present!")

}

fun isArray(name: String) : Boolean {
    return "[" in name && "]" in name
}

fun convertName1(str: String): String {
    return str.substring(0, 1).toUpperCase() + str.substring(1).replace(".", "_")
}

fun convertName2(str: String): String {

    val split = str.replace("_".toRegex(), ".").split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val sb = StringBuilder()

    for (s in split) {
        sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1))
    }
    return sb.toString()

}


fun toRPCType1(typeName: String): String {

    when (typeName) {
        "Integer" -> return "Int"
        "Real" -> return "Real"
        "String" -> return "Str"
        "Boolean" -> return "Bool"
    }

    throw RuntimeException()

}

fun toRPCType2(typeName: String): String {

    when (typeName) {
        "Integer" -> return "int"
        "Real" -> return "double"
        "String" -> return "String"
        "Boolean" -> return "bool"
    }

    throw RuntimeException(typeName)

}

