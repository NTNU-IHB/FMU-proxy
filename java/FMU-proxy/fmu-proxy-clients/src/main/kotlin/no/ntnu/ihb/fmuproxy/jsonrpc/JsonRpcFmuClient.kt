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
import no.ntnu.ihb.fmi4j.modeldescription.*
import no.ntnu.ihb.fmi4j.modeldescription.jaxb.FmiModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.jaxb.JaxbModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.jaxb.convert
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.Solver
import java.io.Closeable

/**
 * @author Lars Ivar Hatledal
 */
class JsonRpcFmuClient(
        private val client: RpcClient
): Closeable {

    fun load(fmuId: String): RemoteFmu {
        return RemoteFmu(fmuId)
    }

    override fun close() {
        client.close()
    }

    inner class RemoteFmu(
            fmuId: String
    ): AbstractRpcFmuClient(fmuId) {

        override val implementationName: String = client.javaClass.simpleName

        override val modelDescription: ModelDescription by lazy {
            client.write("getModelDescription", RpcParams.listParams(fmuId)).get()
                    .getResult<JaxbModelDescription>()!!
        }

        override val canCreateInstanceFromCS: Boolean
            get() = client.write("canCreateInstanceFromCS", RpcParams.listParams(fmuId)).get()
                    .getResult<Boolean>()!!

        override val canCreateInstanceFromME: Boolean
            get() = client.write("canCreateInstanceFromME", RpcParams.listParams(fmuId)).get()
                    .getResult<Boolean>()!!

        override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
            return client.write("getCoSimulationAttributes", RpcParams.listParams(instanceId)).get()
                    .getResult<CoSimulationAttributes>()!!
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

        override fun step(instanceId: String, stepSize: Double): StepResult {
            return client.write("doStep", RpcParams.listParams(instanceId, stepSize)).get()
                    .getResult<StepResult>()!!
        }

        override fun reset(instanceId: String): FmiStatus {
            return client.write("reset", RpcParams.listParams(instanceId)).get()
                    .getResult<FmiStatus>()!!
        }

        override fun terminate(instanceId: String): FmiStatus {
            return client.write("terminate", RpcParams.listParams(instanceId)).get()
                    .getResult<FmiStatus>()!!
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

        override fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Real>): DirectionalDerivativeResult {
            return client.write("getDirectionalDerivative", RpcParams.listParams(instanceId, vUnknownRef, vKnownRef, dvKnownRef)).get()
                    .getResult<DirectionalDerivativeResult>()!!
        }

    }

}

