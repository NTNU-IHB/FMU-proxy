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
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationAttributes
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationAttributesImpl
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionImpl
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver

private const val SERVICE = "FmuService"

/**
 * @author Lars Ivar Hatledal
 */
class JsonRpcFmuClient(
        fmuId: String,
        private val client: RpcClient
): AbstractRpcFmuClient(fmuId) {

    val implementationName: String = client::class.java.simpleName

    override val modelDescription: ModelDescription by lazy {
        client.write("$SERVICE.getModelDescription", RpcParams.listParams(fmuId))
                .getResult<ModelDescriptionImpl>()!!
    }

    val modelDescriptionXml: String by lazy {
        client.write("$SERVICE.getModelDescriptionXml", RpcParams.listParams(fmuId))
                .getResult<String>()!!
    }

    override val canCreateInstanceFromCS: Boolean
        get() = client.write("$SERVICE.canCreateInstanceFromCS", RpcParams.listParams(fmuId))
                .getResult<Boolean>()!!

    override val canCreateInstanceFromME: Boolean
        get() = client.write("$SERVICE.canCreateInstanceFromME", RpcParams.listParams(fmuId))
                .getResult<Boolean>()!!

    override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
        return client.write("$SERVICE.getCoSimulationAttributes", RpcParams.listParams(instanceId))
                .getResult<CoSimulationAttributesImpl>()!!
    }

    override fun createInstanceFromCS(): String {
        return client.write("$SERVICE.createInstanceFromCS", RpcParams.listParams(fmuId), timeOut = 2500L)
                .getResult<String>()!!
    }

    override fun createInstanceFromME(solver: Solver): String {
        return client.write("$SERVICE.createInstanceFromME", RpcParams.listParams(fmuId, solver), timeOut = 2500L)
                .getResult<String>()!!
    }


    override fun init(instanceId: String, start: Double, stop: Double): FmiStatus {
        return client.write("$SERVICE.init", RpcParams.listParams(instanceId, start))
                .getResult<FmiStatus>()!!
    }

    override fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus> {
        return client.write("$SERVICE.step", RpcParams.listParams(instanceId, stepSize))
                .getResult<StepResult>()!!.let { it.asPair() }
    }

    /**
     * Resets the FMU
     */
    override fun reset(instanceId: String): FmiStatus {
        return client.write("$SERVICE.reset", RpcParams.listParams(instanceId))
                .getResult<FmiStatus>()!!
    }

    /**
     * Terminates the FMU
     */
    override fun terminate(instanceId: String): FmiStatus {
        return client.write("$SERVICE.terminate", RpcParams.listParams(instanceId))
                .getResult<FmiStatus>()!!
    }

    /**
     * Terminates the FMU and closes the client connection
     */
    override fun close() {
        super.close()
        client.close()
    }

    override fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead {
        return client.write("$SERVICE.readInteger", RpcParams.listParams(instanceId, vr))
                .getResult<FmuIntegerArrayRead>()!!
    }

    override fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead {
        return client.write("$SERVICE.readReal", RpcParams.listParams(instanceId, vr))
                .getResult<FmuRealArrayRead>()!!
    }

    override fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead {
        return client.write("$SERVICE.readString", RpcParams.listParams(instanceId, vr))
                .getResult<FmuStringArrayRead>()!!
    }

    override fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead {
        return client.write("$SERVICE.readBoolean", RpcParams.listParams(instanceId, vr))
                .getResult<FmuBooleanArrayRead>()!!
    }


    override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
        return client.write("$SERVICE.writeInteger", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return client.write("$SERVICE.writeReal", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
        return client.write("$SERVICE.writeString", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return client.write("$SERVICE.writeBoolean", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun deSerializeFMUstate(instanceId: String, state: ByteArray): Pair<FmuState, FmiStatus> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun freeFMUstate(instanceId: String, state: FmuState): FmiStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFMUstate(instanceId: String): Pair<FmuState, FmiStatus> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun serializeFMUstate(instanceId: String, state: FmuState): Pair<ByteArray, FmiStatus> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFMUstate(instanceId: String, state: FmuState): FmiStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal class StepResult(
            var simulationTime: Double,
            var status: FmiStatus
    ) {
        fun asPair() = simulationTime to status
    }

}