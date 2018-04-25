/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
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

package no.mechatronics.sfi.fmuproxy.codegen

import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmuproxy.KOTLIN_SRC_OUTPUT_FOLDER
import no.mechatronics.sfi.fmuproxy.PACKAGE_NAME
import no.mechatronics.sfi.fmuproxy.utils.FileFuture
import no.mechatronics.sfi.fmuproxy.utils.getProtoType
import no.mechatronics.sfi.fmuproxy.utils.isArray
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File


private val TypedScalarVariable<*>.typeName: String
    get() = when(this) {
        is IntegerVariable -> INTEGER_TYPE
        is RealVariable -> REAL_TYPE
        is StringVariable -> STRING_TYPE
        is BooleanVariable -> BOOLEAN_TYPE
        is EnumerationVariable -> ENUMERATION_TYPE
        else -> throw IllegalStateException("$this is not a valid variable type..")
    }

/**
 *
 * @author Lars Ivar Hatledal
 */
object ServerGen {

    private val LOG: Logger = LoggerFactory.getLogger(ServerGen::class.java)

    fun generateServerCode(modelDescription: CommonModelDescription, baseFile: File) {

        val packageName = PACKAGE_NAME.replace(".", "/")
        val ktOut = File(baseFile, "${KOTLIN_SRC_OUTPUT_FOLDER}/$packageName")

        val dynamicMethods = StringBuilder().apply {
            modelDescription.modelVariables.forEach {

                if (!isArray(it.name)) {

                    append(JtwigTemplate.classpathTemplate("templates/server/Read.kt").let { template ->
                        template.render(JtwigModel.newModel()
                                .with("valueReference", it.valueReference)
                                .with("varName", convertName2(it.name))
                                .with("typeName", it.typeName)
                                .with("returnType", "${getProtoType(it)}Read"))!!
                    }).append("\n")

                    append(JtwigTemplate.classpathTemplate("templates/server/Write.kt").let { template ->
                        template.render(JtwigModel.newModel()
                                .with("valueReference", it.valueReference)
                                .with("varName", convertName2(it.name))
                                .with("typeName", it.typeName)
                                .with("dataType", getProtoType(it)))!!
                    })

                }

            }
        }

        FileFuture(
                name = "Main.kt",
                text = JtwigTemplate.classpathTemplate("templates/server/Main.kt").let { template ->
                    template.render(JtwigModel.newModel()
                            .with("fmuName", modelDescription.modelName))!!
                }
        ).create(ktOut)

        FileFuture(
                name = "${modelDescription.modelName}Service.kt",
                text = JtwigTemplate.classpathTemplate("templates/server/Service.kt").let { template ->
                    template.render(JtwigModel.newModel()
                            .with("fmuName", modelDescription.modelName)
                            .with("dynamicMethods", dynamicMethods))!!
                }
        ).create(ktOut)

    }

    private fun convertName2(str: String): String {
        val split = str.replace("_".toRegex(), ".").split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return StringBuilder().apply {
            for (s in split) {
                append(s.substring(0, 1).toUpperCase()).append(s.substring(1))
            }
        }.toString()
    }

}
