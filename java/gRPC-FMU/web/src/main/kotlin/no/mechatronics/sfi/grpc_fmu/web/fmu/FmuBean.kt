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

package no.mechatronics.sfi.grpc_fmu.web.fmu

import com.google.gson.Gson
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.variables.TypedScalarVariable
import java.io.Serializable
import java.util.*
import javax.faces.bean.ManagedBean

@ManagedBean
class FmuBean(
        remoteFmu: RemoteFmu
): IRemoteFmu by remoteFmu, Serializable {

    val modelDescription: SimpleModelDescription
    val modelName: String
    val description:String
    val modelVariables: List<TypedScalarVariable<*>>

    init {
        modelDescription =  ModelDescriptionParser.parse(modelDescriptionXml)
        modelName = modelDescription.modelName
        description = modelDescription.description ?: "-"
        modelVariables = modelDescription.modelVariables.variables
    }

}


/**
 *
 * @author Lars Ivar Hatledal
 */
interface IRemoteFmu: Serializable {
    val guid: String
    val address: SimpleSocketAddress
    val modelDescriptionXml: String
}

/**
 *
 * @author Lars Ivar Hatledal
 */
class ProtoDefinitions(
        val definitions: String,
        val service: String
)

class SimpleSocketAddress(
        val hostAddress: String,
        val port: Int
)

/**
 *
 * @author Lars Ivar Hatledal
 */
class RemoteFmu(
        override val guid: String,
        override val address: SimpleSocketAddress,
        override val modelDescriptionXml: String
): IRemoteFmu {

    companion object {

        fun toJson(info: RemoteFmu) = Gson().toJson(info)
        fun fromJson(json: String) = Gson().fromJson(json, RemoteFmu::class.java)

    }

    val protoDefinition: ProtoDefinitions

    init {
        val definitions = Scanner(javaClass.classLoader
                .getResourceAsStream("definitions.proto"), "UTF-8")
                .useDelimiter("\\A").next()
        val service = Scanner(javaClass.classLoader
                .getResourceAsStream("service.proto"), "UTF-8")
                .useDelimiter("\\A").next()

        protoDefinition = ProtoDefinitions(definitions, service)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RemoteFmu

        if (guid != other.guid) return false

        return true
    }

    override fun hashCode(): Int {
        return guid.hashCode()
    }

    override fun toString(): String {
        return "RemoteFmu(guid='$guid', address='$address')"
    }



}
