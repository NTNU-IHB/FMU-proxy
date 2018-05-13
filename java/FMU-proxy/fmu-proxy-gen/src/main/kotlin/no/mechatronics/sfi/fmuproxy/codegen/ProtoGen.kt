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
import no.mechatronics.sfi.fmuproxy.PROTO_SRC_OUTPUT_FOLDER
import no.mechatronics.sfi.fmuproxy.utils.FileFuture
import no.mechatronics.sfi.fmuproxy.utils.getProtoType
import no.mechatronics.sfi.fmuproxy.utils.isArray
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File


/**
 *
 * @author Lars Ivar Hatledal
 */
object ProtoGen {

    private val LOG: Logger = LoggerFactory.getLogger(ProtoGen::class.java)

    fun generateProtoCode(modelDescription: CommonModelDescription, baseFile: File) {

        val instanceServices = StringBuilder().apply {

            modelDescription.modelVariables.forEach({
                val isArray = isArray(it.name)
                if (!isArray) {

                    append("""
    rpc Read_${convertName(it.name)} (UInt) returns (${getProtoType(it)}Read);

    rpc Write_${convertName(it.name)} (Instance${getProtoType(it)}Write) returns (StatusResponse);
                    """)

                }

            })
        }.toString()

         FileFuture(
                 name = "unique_service.proto",
                 text = JtwigTemplate.classpathTemplate("templates/proto/unique_service.proto").let { template ->
                     template.render(JtwigModel.newModel()
                             .with("fmuName", modelDescription.modelName)
                             .with("instanceServices", instanceServices))
                 }
         ).create(File(baseFile, "${PROTO_SRC_OUTPUT_FOLDER}"))

    }

    private fun convertName(str: String) =
            str.substring(0, 1)
                    .toUpperCase() + str.substring(1)
                    .replace(".", "_")
}
