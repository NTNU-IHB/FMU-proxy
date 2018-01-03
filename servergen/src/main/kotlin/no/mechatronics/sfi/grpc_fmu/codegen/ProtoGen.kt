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

package no.mechatronics.sfi.grpc_fmu.codegen

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.GrpcFmu
import no.mechatronics.sfi.grpc_fmu.convertName1
import no.mechatronics.sfi.grpc_fmu.isArray
import no.mechatronics.sfi.grpc_fmu.templates.ProtoTemplate
import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.charset.Charset
import org.apache.commons.io.FilenameUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ProtoGen {

    private val LOG: Logger = LoggerFactory.getLogger(ProtoGen::class.java)

    fun generateProtoString(modelDescription: ModelDescription): String {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            val isArray = isArray(it.name)
            if (!isArray) {

                sb.append(ProtoTemplate.generateRead(
                        varName = convertName1(it.name),
                        typeName = it.typeName
                ))

                sb.append(ProtoTemplate.generateWrite(
                        varName = convertName1(it.name),
                        typeName = it.typeName
                ))

            }

        })

        return ProtoTemplate.generateBody(
                packageName = GrpcFmu.PACKAGE_NAME,
                fmuName = modelDescription.modelName,
                instanceServices = sb.toString()
        )

    }

    fun generateProtoFile(modelDescription: ModelDescription, outputFolder: String): Pair<String, File> {

        val protoFile = File(outputFolder + modelDescription.modelName + ".proto")
        val protoString = generateProtoString(modelDescription)
        FileUtils.writeStringToFile(protoFile, protoString, Charset.forName("UTF-8"))
        return Pair(protoString,  protoFile)

    }

    fun compileProto(protocDir: File, protoFile: File, protoSrc: String, javaOut: String) {

        LOG.info("Compiling proto..")

        File(javaOut).apply {
            if (!exists()) {
                mkdirs()
            }
        }

        val baseName = FilenameUtils.getBaseName(protoFile.absolutePath)
        val cmd = arrayOf("${protocDir.absolutePath}/protoc.exe/", "--java_out=\"$javaOut\"", "--grpc-java_out=\"$javaOut\"", "--proto_path=\".\"", "\"$protoSrc$baseName.proto\"")
        ProcessBuilder()
                .command(*cmd)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .start()
                .waitFor()

        LOG.info("Compiling done!")

    }

}


