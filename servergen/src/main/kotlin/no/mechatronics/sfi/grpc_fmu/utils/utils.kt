/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology (NTNU)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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

