/*
 * The MIT License
 *
 * * Copyright 2017-2018 Norwegian University of Technology
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

package no.mechatronics.sfi.grpc_fmu.codegen

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.GrpcFmu
import no.mechatronics.sfi.grpc_fmu.convertName2
import no.mechatronics.sfi.grpc_fmu.isArray
import no.mechatronics.sfi.grpc_fmu.templates.ServerTemplate
import org.apache.commons.io.FileUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files

object ServerGen {

    private val LOG: Logger = LoggerFactory.getLogger(ServerGen::class.java)

    fun generateServerCode(modelDescription: ModelDescription) : ServerTemplate.ServerCode {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            if (!isArray(it.name)) {

                sb.append(ServerTemplate.generateRead(
                        varName1 = it.name,
                        varName2 = convertName2(it.name),
                        primitive1 = toRPCType2(it.typeName),
                        primitive2 = it.typeName,
                        returnType = toRPCType1(it.typeName)
                ))

                sb.append(ServerTemplate.generateWrite(
                        varName1 = it.name,
                        varName2 = convertName2(it.name),
                        dataType = toRPCType1(it.typeName)
                ))

            }

        })

        return ServerTemplate.generateClass(
                packageName = GrpcFmu.PACKAGE_NAME,
                fmuName = modelDescription.modelName,
                dynamicMethods = sb.toString())

    }

    fun generateServerCodeFiles(modelDescription: ModelDescription, outputFolder: File)  {

        LOG.info("Generating server code for source FMU '{}'", modelDescription.modelName)

        generateServerCode(modelDescription).apply {

            outputFolder.mkdirs()
            println(outputFolder.absolutePath)

            File(outputFolder, "Main.java").also { file ->
                FileUtils.writeStringToFile(file, main, Charset.forName("UTF-8"))
            }
            File(outputFolder, "${modelDescription.modelName}Server.java").also { file ->
                FileUtils.writeStringToFile(file, server, Charset.forName("UTF-8"))
            }

        }

    }

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
