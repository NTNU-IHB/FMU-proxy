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

package no.mechatronics.sfi.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcParams
import info.laht.yajrpc.net.RpcClient
import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionImpl
import no.mechatronics.sfi.fmuproxy.RpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver


class JsonRpcFmuClient(
        val client: RpcClient
): RpcFmuClient() {

    val fmiVersion: String by lazy {
        client.write("FmuService.getFmiVersion")
                .getResult(String::class.java)!!
    }

    val modelName: String by lazy {
        client.write("FmuService.getModelName")
                .getResult(String::class.java)!!
    }

    val guid: String by lazy {
        client.write("FmuService.getGuid")
                .getResult(String::class.java)!!
    }

    override val modelDescription: CommonModelDescription by lazy {
        client.write("FmuService.getModelDescription")
                .getResult(ModelDescriptionImpl::class.java)!!
    }

    override val modelDescriptionXml: String by lazy {
        client.write("FmuService.getModelDescriptionXml")
                .getResult(String::class.java)!!
    }

    override var lastStatus: FmiStatus = FmiStatus.NONE
        private set

    /**
     * Terminates the FMU and closes the client connection
     */
    override fun close() {
        super.close()
        client.close()
    }

    override fun isTerminated(fmuId: Int): Boolean {
        return client.write("FmuService.getGuid", RpcParams.listParams(fmuId))
                .getResult(Boolean::class.java)!!
    }

    override fun readInteger(fmuId: Int, vr: ValueReference): FmuIntegerRead {
        return client.write("FmuService.readInteger", RpcParams.listParams(fmuId, vr))
                .getResult(FmuIntegerRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun bulkReadInteger(fmuId: Int, vr: List<Int>): FmuIntegerArrayRead {
        return client.write("FmuService.readInteger", RpcParams.listParams(fmuId, vr))
                .getResult(FmuIntegerArrayRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun readReal(fmuId: Int, vr: ValueReference): FmuRealRead {
        return client.write("FmuService.readReal", RpcParams.listParams(fmuId, vr))
                .getResult(FmuRealRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun bulkReadReal(fmuId: Int, vr: List<Int>): FmuRealArrayRead {
        return client.write("FmuService.readReal", RpcParams.listParams(fmuId, vr))
                .getResult(FmuRealArrayRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun readString(fmuId: Int, vr: ValueReference): FmuStringRead {
        return client.write("FmuService.readString", RpcParams.listParams(fmuId, vr))
                .getResult(FmuStringRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun bulkReadString(fmuId: Int, vr: List<Int>): FmuStringArrayRead {
        return client.write("FmuService.readString", RpcParams.listParams(fmuId, vr))
                .getResult(FmuStringArrayRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun readBoolean(fmuId: Int, vr: ValueReference): FmuBooleanRead {
        return client.write("FmuService.readBoolean", RpcParams.listParams(fmuId, vr))
                .getResult(FmuBooleanRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun bulkReadBoolean(fmuId: Int, vr: List<Int>): FmuBooleanArrayRead {
        return client.write("FmuService.readBoolean", RpcParams.listParams(fmuId, vr))
                .getResult(FmuBooleanArrayRead::class.java)!!.also {
            lastStatus = it.status
        }
    }

    override fun writeInteger(fmuId: Int, vr: ValueReference, value: Int): FmiStatus {
        return client.write("FmuService.writeInteger", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun bulkWriteInteger(fmuId: Int, vr: List<Int>, value: List<Int>): FmiStatus {
        return client.write("FmuService.bulkWriteInteger", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun writeReal(fmuId: Int, vr: ValueReference, value: Real): FmiStatus {
        return client.write("FmuService.writeReal", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun bulkWriteReal(fmuId: Int, vr: List<Int>, value: List<Real>): FmiStatus {
        return client.write("FmuService.bulkWriteReal", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun writeString(fmuId: Int, vr: ValueReference, value: String): FmiStatus {
        return client.write("FmuService.writeString", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun bulkWriteString(fmuId: Int, vr: List<Int>, value: List<String>): FmiStatus {
        return client.write("FmuService.bulkWriteString", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun writeBoolean(fmuId: Int, vr: ValueReference, value: Boolean): FmiStatus {
        return client.write("FmuService.writeBoolean", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun bulkWriteBoolean(fmuId: Int, vr: List<Int>, value: List<Boolean>): FmiStatus {
        return client.write("FmuService.bulkWriteBoolean", RpcParams.listParams(fmuId, vr, value))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun getCurrentTime(fmuId: Int): Double {
        return client.write("FmuService.getCurrentTime", RpcParams.listParams(fmuId))
                .getResult(Double::class.java)!!
    }

    override fun init(fmuId: Int, start: Double, stop: Double): FmiStatus {
        return client.write("FmuService.init", RpcParams.listParams(fmuId, start))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun step(fmuId: Int, stepSize: Double): FmiStatus {
        return client.write("FmuService.step", RpcParams.listParams(fmuId, stepSize))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    /**
     * Resets the FMU
     */
    override fun reset(fmuId: Int): FmiStatus {
        return client.write("FmuService.reset", RpcParams.listParams(fmuId))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    /**
     * Terminates the FMU
     */
    override fun terminate(fmuId: Int): FmiStatus {
        return client.write("FmuService.terminate", RpcParams.listParams(fmuId))
                .getResult(FmiStatus::class.java)!!.also {
            lastStatus = it
        }
    }

    override fun createInstanceFromCS(): ValueReference {
        return client.write("FmuService.createInstanceFromCS")
                .getResult(ValueReference::class.java)!!
    }

    override fun createInstanceFromME(solver: Solver): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}