/*
 * The MIT License
 *
 * Copyright 2017. Norwegian University of Technology
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

package no.mechatronics.sfi.grpc_fmu

import com.google.gson.Gson
import no.mechatronics.sfi.grpc_fmu.misc.SimpleSocketAddress
import java.io.Serializable
import java.util.*

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

/**
 *
 * @author Lars Ivar Hatledal
 */
class RemoteFmu(
        override val guid: String,
        override val address: SimpleSocketAddress,
        override val modelDescriptionXml: String
) : IRemoteFmu {

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


    override fun toString(): String {
        return "RemoteFmu(guid='$guid', address='$address')"
    }

}

