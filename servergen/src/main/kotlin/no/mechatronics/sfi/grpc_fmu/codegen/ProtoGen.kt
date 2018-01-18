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

import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.grpc_fmu.utils.FileFuture
import no.mechatronics.sfi.grpc_fmu.utils.convertName1
import no.mechatronics.sfi.grpc_fmu.utils.isArray
import java.io.File
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private const val PROTOC_EXE = "protoc-3.5.1-win32.exe"

class ProtoCode(
         val definitions: FileFuture,
         val service: FileFuture
) {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ProtoCode::class.java)
    }

    fun writeToDir(dir: File) {
        if (!dir.exists()) {
            dir.mkdirs()
        }

        definitions.create(dir)
        service.create(dir)

    }

    fun compile(baseDir: File, protoOut: String, javaOut: String) : Boolean {

        LOG.info("Compiling proto..")

        File(javaOut).apply {
            if (!exists()) {
                mkdirs()
            }
        }

        writeToDir(File(protoOut))

        val cmd = arrayOf(
                "${baseDir.absolutePath}/$PROTOC_EXE/",
                "--java_out=\"$javaOut\"",
                "--grpc-java_out=\"$javaOut\"",
                "--proto_path=\"$protoOut\"",
                "\"$protoOut/${definitions.name}\"",
                "\"$protoOut/${service.name}\"")

        val status = ProcessBuilder()
                .command(*cmd)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .start()
                .waitFor()

        return if (status == 0) {
            LOG.info("Compiling done!")
            true
        } else {
            LOG.warn("Process exited with status: {}", status)
            false
        }

    }

    override fun toString(): String {
        return "ProtoCode(definitions=$definitions, service=$service)"
    }

}

object ProtoGen {

    private val LOG: Logger = LoggerFactory.getLogger(ProtoGen::class.java)

    fun generateProtoCode(modelDescription: SimpleModelDescription): ProtoCode {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            val isArray = isArray(it.name)
            if (!isArray) {

                sb.append(JtwigTemplate.classpathTemplate("templates/proto/read.proto").let { template ->
                    template.render(JtwigModel.newModel()
                            .with("varName", convertName1(it.name))
                            .with("typeName", it.typeName))!!
                })

                sb.append(JtwigTemplate.classpathTemplate("templates/proto/write.proto").let { template ->
                    template.render(JtwigModel.newModel()
                            .with("varName", convertName1(it.name))
                            .with("typeName", it.typeName))!!
                })

            }

        })


        val definitions = FileFuture(
                name = "definitions.proto",
                text = JtwigTemplate.classpathTemplate("templates/proto/definitions.proto").let { template ->
                    template.render(JtwigModel.newModel()
                            //.with("packageName", GrpcFmu.PACKAGE_NAME)
                    )!!
                }
        )

        val service = FileFuture(
                name = "service.proto",
                text = JtwigTemplate.classpathTemplate("templates/proto/service.proto").let { template ->
                    template.render(JtwigModel.newModel()
                         //   .with("packageName", GrpcFmu.PACKAGE_NAME)
                            .with("fmuName", modelDescription.modelName)
                            .with("instanceServices", sb.toString())!!)
                }
        )

        return ProtoCode(definitions, service)


    }


}


