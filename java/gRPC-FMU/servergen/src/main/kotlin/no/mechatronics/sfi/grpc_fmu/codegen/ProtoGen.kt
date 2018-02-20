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
import no.mechatronics.sfi.fmi4j.modeldescription.variables.ScalarVariable
import no.mechatronics.sfi.grpc_fmu.utils.FileFuture
import no.mechatronics.sfi.grpc_fmu.utils.getProtoType
import no.mechatronics.sfi.grpc_fmu.utils.isArray
import java.io.File
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory

//private const val PROTOC_EXE = "protoc-3.5.1-win32.exe"

///**
// *
// * @author Lars Ivar Hatledal
// */
//class ProtoCode(
//         val uniqueService: FileFuture
//) {
//
//    private companion object {
//        val LOG: Logger = LoggerFactory.getLogger(ProtoCode::class.java)
//    }
//
//    private fun writeToDir(dir: File) {
//        if (!dir.exists()) {
//            dir.mkdirs()
//        }
//
//        uniqueService.create(dir)
//
//    }
//
//    fun compile(baseDir: File, protoOut: String, javaOut: String) : Boolean {
//
//        LOG.debug("Compiling proto..")
//
//        File(javaOut).apply {
//            if (!exists()) {
//                mkdirs()
//            }
//        }
//
//        writeToDir(File(protoOut))
//
//        val cmd = arrayOf(
//                "${baseDir.absolutePath}/$PROTOC_EXE/",
//                "--java_out=\"$javaOut\"",
//                "--grpc-java_out=\"$javaOut\"",
//                "--proto_path=\"$protoOut\"",
//                "\"$protoOut/${definitions.name}\"",
//                "\"$protoOut/${service.name}\"",
//                "\"$protoOut/${uniqueService.name}\"")
//
//        return ProcessBuilder()
//                .command(*cmd)
//                .redirectError(ProcessBuilder.Redirect.INHERIT)
//                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
//                .start()
//                .waitFor().let { status ->
//
//            if (status == 0) {
//                LOG.debug("Compiling done!")
//                return true
//            } else {
//                LOG.warn("Process exited with status: {}", status)
//                return false
//            }
//
//        }
//
//    }
//
//    override fun toString(): String {
//        return "ProtoCode(definitions=$definitions, service=$service)"
//    }
//
//}

object ProtoGen {

    private val LOG: Logger = LoggerFactory.getLogger(ProtoGen::class.java)

    fun generateProtoCode(modelDescription: SimpleModelDescription): FileFuture {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({
            val isArray = isArray(it.name)
            if (!isArray) {

                sb.append("""
                    rpc Read_${convertName(it.name)} (UInt) returns (${getProtoType(it.typeName)});

                    rpc Write_${convertName(it.name)} (${getProtoType(it.typeName)}Write) returns (Status);

                    """)

            }

        })

        return FileFuture(
                name = "unique_service.proto",
                text = JtwigTemplate.classpathTemplate("templates/proto/unique_service.proto").let { template ->
                    template.render(JtwigModel.newModel()
                            //   .with("packageName", GrpcFmu.PACKAGE_NAME)
                            .with("fmuName", modelDescription.modelName)
                            .with("instanceServices", sb.toString())!!)
                }
        )

    }

    private fun convertName(str: String): String {
        return str.substring(0, 1).toUpperCase() + str.substring(1).replace(".", "_")
    }


}


