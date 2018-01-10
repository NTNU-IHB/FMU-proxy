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
import no.mechatronics.sfi.grpc_fmu.utils.*
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class ServerCode(
        val main: FileFuture,
        val server: FileFuture
) {

    fun writeToDirectory(dir: File) {
        main.create(dir)
        server.create(dir)
    }

}

object ServerGen {

    private val LOG: Logger = LoggerFactory.getLogger(ServerGen::class.java)

    fun generateServerCode(modelDescription: ModelDescription) : ServerCode {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            if (!isArray(it.name)) {

                sb.append(JtwigTemplate.classpathTemplate("templates/server/Read.java").let { template ->
                    template.render(JtwigModel.newModel()
                            .with("valueReference", it.valueReference)
                            .with("varName2", convertName2(it.name))
                            //.with("primitive1", toRPCType2(it.typeName))
                            .with("primitive2", it.typeName)
                            .with("returnType", toRPCType1(it.typeName)))!!
                })

                sb.append(JtwigTemplate.classpathTemplate("templates/server/Write.java").let { template ->
                    template.render(JtwigModel.newModel()
                            .with("valueReference", it.valueReference)
                            .with("varName2", convertName2(it.name))
                            .with("dataType", toRPCType1(it.typeName)))!!
                })

            }

        })

        val main = FileFuture(
                name = "Main.java",
                text = JtwigTemplate.classpathTemplate("templates/server/Main.java").let { template ->
                    template.render(JtwigModel.newModel()
                            //.with("packageName", GrpcFmu.PACKAGE_NAME)
                            .with("fmuName", modelDescription.modelName))!!
                }
        )

        val server = FileFuture(
                name = "${modelDescription.modelName}Server.java",
                text = JtwigTemplate.classpathTemplate("templates/server/Server.java").let { template ->
                    template.render(JtwigModel.newModel()
                            //.with("packageName", GrpcFmu.PACKAGE_NAME)
                            .with("fmuName", modelDescription.modelName)
                            .with("dynamicMethods", sb.toString()))!!
                }
        )

        return ServerCode(main, server)

    }


}
