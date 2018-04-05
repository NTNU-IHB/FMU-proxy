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

package no.mechatronics.sfi.fmu_proxy.utils

import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


internal fun isArray(name: String) : Boolean {
    return "[" in name && "]" in name
}

internal fun getProtoType(variable: TypedScalarVariable<*>): String {

    return when (variable) {
        is IntegerVariable -> "Int"
        is RealVariable -> "Real"
        is StringVariable -> "Str"
        is BooleanVariable -> "Bool"
        is EnumerationVariable -> "Int"
        else ->  throw RuntimeException()
    }

}

internal fun copyZippedContent(baseFile: File, content: InputStream) {

    ZipInputStream(content).use { zis ->
        var nextEntry: ZipEntry? = zis.nextEntry
        while (nextEntry != null) {
            if (!nextEntry.isDirectory) {
                File(baseFile, nextEntry.name).also { file ->
                    if (!file.exists()) {
                        if (!file.parentFile.exists()) {
                            file.parentFile.mkdirs()
                        }
                        FileOutputStream(file).use { fis ->
                            zis.copyTo(fis)
                        }
                    }
                }
            }
            nextEntry = zis.nextEntry
        }
    }

}



