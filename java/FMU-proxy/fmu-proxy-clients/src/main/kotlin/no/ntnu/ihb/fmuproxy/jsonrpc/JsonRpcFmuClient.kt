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

package no.ntnu.ihb.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcParams
import info.laht.yajrpc.net.RpcClient
import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonCoSimulationAttributes
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonModelDescription
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.Solver

/**
 * @author Lars Ivar Hatledal
 */
class JsonRpcFmuClient(
        fmuId: String,
        private val client: RpcClient
): AbstractRpcFmuClient(fmuId) {

    override val implementationName: String = client.javaClass.simpleName

    override val modelDescription: ModelDescription by lazy {
        client.write("getModelDescription", RpcParams.listParams(fmuId)).get()
                .getResult<JacksonModelDescription>()!!
    }

    override val canCreateInstanceFromCS: Boolean
        get() = client.write("canCreateInstanceFromCS", RpcParams.listParams(fmuId)).get()
                .getResult<Boolean>()!!

    override val canCreateInstanceFromME: Boolean
        get() = client.write("canCreateInstanceFromME", RpcParams.listParams(fmuId)).get()
                .getResult<Boolean>()!!

    override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
        return client.write("getCoSimulationAttributes", RpcParams.listParams(instanceId)).get()
                .getResult<JacksonCoSimulationAttributes>()!!
    }

    override fun createInstanceFromCS(): String {
        return client.write("createInstanceFromCS", RpcParams.listParams(fmuId), timeOut = 2500L).get()
                .getResult<String>()!!
    }

    override fun createInstanceFromME(solver: Solver): String {
        return client.write("createInstanceFromME", RpcParams.listParams(fmuId, solver), timeOut = 2500L).get()
                .getResult<String>()!!
    }

    override fun setup(instanceId: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus {
        return client.write("setupExperiment", RpcParams.listParams(instanceId, start, stop, tolerance)).get()
                .getResult<FmiStatus>()!!
    }

    override fun enterInitializationMode(instanceId: InstanceId): FmiStatus {
        return client.write("enterInitializationMode", RpcParams.listParams(instanceId)).get()
                .getResult<FmiStatus>()!!
    }

    override fun exitInitializationMode(instanceId: InstanceId): FmiStatus {
        return client.write("exitInitializationMode", RpcParams.listParams(instanceId)).get()
                .getResult<FmiStatus>()!!
    }

    override fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus> {
        return client.write("doStep", RpcParams.listParams(instanceId, stepSize)).get()
                .getResult<StepResult>()!!.let { it.asPair() }
    }

    /**
     * Resets the FMU
     */
    override fun reset(instanceId: String): FmiStatus {
        return client.write("reset", RpcParams.listParams(instanceId)).get()
                .getResult<FmiStatus>()!!
    }

    /**
     * Terminates the FMU
     */
    override fun terminate(instanceId: String): FmiStatus {
        return client.write("terminate", RpcParams.listParams(instanceId)).get()
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
        return client.write("readInteger", RpcParams.listParams(instanceId, vr)).get()
                .getResult<FmuIntegerArrayRead>()!!
    }

    override fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead {
        return client.write("readReal", RpcParams.listParams(instanceId, vr)).get()
                .getResult<FmuRealArrayRead>()!!
    }

    override fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead {
        return client.write("readString", RpcParams.listParams(instanceId, vr)).get()
                .getResult<FmuStringArrayRead>()!!
    }

    override fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead {
        return client.write("readBoolean", RpcParams.listParams(instanceId, vr)).get()
                .getResult<FmuBooleanArrayRead>()!!
    }


    override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
        return client.write("writeInteger", RpcParams.listParams(instanceId, vr, value)).get()
                .getResult<FmiStatus>()!!
    }

    override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return client.write("writeReal", RpcParams.listParams(instanceId, vr, value)).get()
                .getResult<FmiStatus>()!!
    }

    override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
        return client.write("writeString", RpcParams.listParams(instanceId, vr, value)).get()
                .getResult<FmiStatus>()!!
    }

    override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return client.write("writeBoolean", RpcParams.listParams(instanceId, vr, value)).get()
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

    override fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): Pair<List<Double>, FmiStatus> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal class StepResult(
            var simulationTime: Double,
            var status: FmiStatus
    ) {
        fun asPair() = simulationTime to status
    }

}