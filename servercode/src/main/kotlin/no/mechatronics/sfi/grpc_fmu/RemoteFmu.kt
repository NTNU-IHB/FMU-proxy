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
import no.mechatronics.sfi.fmi4j.modeldescription.IModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.grpc_fmu.misc.ChangeListener
import no.mechatronics.sfi.grpc_fmu.misc.ProtoDefinitions
import no.mechatronics.sfi.grpc_fmu.misc.SocketAddress
import java.util.*

class RemoteFmu(
        val guid: String,
        val address: SocketAddress,
        val modelDescriptionXml: String
) {

    companion object {

        fun toJson(info: RemoteFmu) = Gson().toJson(info)
        fun fromJson(json: String) = Gson().fromJson(json, RemoteFmu::class.java)
    }



    @delegate: Transient
    val modelDescription: IModelDescription by lazy {
        ModelDescriptionParser.parse(modelDescriptionXml)
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



object RemoteFmus {

    private val fmus: MutableSet<RemoteFmu> = Collections.synchronizedSet(HashSet())
    private val changeListeners: MutableList<ChangeListener> = ArrayList()

    fun get(): Set<RemoteFmu> = fmus

    fun addListener(changeListener: ChangeListener) {
        changeListeners.add(changeListener)
    }

    fun add(fmu: RemoteFmu): Boolean {
        synchronized(fmus) {
            val success = fmus.add(fmu)
            if (success) {
                changeListeners.forEach({ it.onAdd(fmu) })
            }
            return success
        }
    }

    fun remove(guid: String): Boolean {
        synchronized(fmus) {
            for (fmu in fmus) {
                if (fmu.guid == guid) {

                    return fmus.remove(fmu).also { success ->
                        if (success) {
                            changeListeners.forEach({it.onRemove(fmu)})
                        }
                    }

                }
            }
        }
        return false

    }

}
