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
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver

private const val SERVICE = "FmuService"

/**
 * @author Lars Ivar Hatledal
 */
class JsonRpcFmuClient(
        private val client: RpcClient
): AbstractRpcFmuClient() {

    val implementationName: String = client::class.java.simpleName

    val fmiVersion: String by lazy {
        client.write("$SERVICE.getFmiVersion")
                .getResult(String::class.java)!!
    }

    val modelName: String by lazy {
        client.write("$SERVICE.getModelName")
                .getResult<String>()!!
    }

    val guid: String by lazy {
        client.write("$SERVICE.getGuid")
                .getResult(String::class.java)!!
    }

    override val modelDescription: CommonModelDescription by lazy {
        client.write("$SERVICE.getModelDescription")
                .getResult(ModelDescriptionImpl::class.java)!!
    }

    override val modelDescriptionXml: String by lazy {
        client.write("$SERVICE.getModelDescriptionXml")
                .getResult(String::class.java)!!
    }


    override fun isTerminated(instanceId: Int): Boolean {
        return client.write("$SERVICE.getGuid", RpcParams.listParams(instanceId))
                .getResult<Boolean>()!!
    }

    override fun getSimulationTime(instanceId: Int): Double {
        return client.write("$SERVICE.getSimulationTime", RpcParams.listParams(instanceId))
                .getResult<Double>()!!
    }

    override fun init(instanceId: Int, start: Double, stop: Double): FmiStatus {
        return client.write("$SERVICE.init", RpcParams.listParams(instanceId, start))
                .getResult<FmiStatus>()!!
    }

    override fun step(instanceId: Int, stepSize: Double): Pair<Double, FmiStatus> {
        return client.write("$SERVICE.step", RpcParams.listParams(instanceId, stepSize))
                .getResult<StepResult>()!!.let { it.asPair() }
    }

    /**
     * Resets the FMU
     */
    override fun reset(instanceId: Int): FmiStatus {
        return client.write("$SERVICE.reset", RpcParams.listParams(instanceId))
                .getResult<FmiStatus>()!!
    }

    /**
     * Terminates the FMU
     */
    override fun terminate(instanceId: Int): FmiStatus {
        return client.write("$SERVICE.terminate", RpcParams.listParams(instanceId))
                .getResult<FmiStatus>()!!
    }

    override fun createInstanceFromCS(): ValueReference {
        return client.write("$SERVICE.createInstanceFromCS", RpcParams.noParams(), 2500L)
                .getResult<ValueReference>()!!
    }

    override fun createInstanceFromME(solver: Solver): Int {
        return client.write("$SERVICE.createInstanceFromME", RpcParams.listParams(solver))
                .getResult<ValueReference>()!!
    }

    /**
     * Terminates the FMU and closes the client connection
     */
    override fun close() {
        super.close()
        client.close()
    }

    override fun readInteger(instanceId: Int, vr: List<ValueReference>): FmuIntegerArrayRead {
        return client.write("$SERVICE.readInteger", RpcParams.listParams(instanceId, vr))
                .getResult<FmuIntegerArrayRead>()!!
    }

    override fun readReal(instanceId: Int, vr: List<ValueReference>): FmuRealArrayRead {
        return client.write("$SERVICE.readReal", RpcParams.listParams(instanceId, vr))
                .getResult<FmuRealArrayRead>()!!
    }

    override fun readString(instanceId: Int, vr: List<ValueReference>): FmuStringArrayRead {
        return client.write("$SERVICE.readString", RpcParams.listParams(instanceId, vr))
                .getResult<FmuStringArrayRead>()!!
    }

    override fun readBoolean(instanceId: Int, vr: List<ValueReference>): FmuBooleanArrayRead {
        return client.write("$SERVICE.readBoolean", RpcParams.listParams(instanceId, vr))
                .getResult<FmuBooleanArrayRead>()!!
    }


    override fun writeInteger(instanceId: Int, vr: List<ValueReference>, value: List<Int>): FmiStatus {
        return client.write("$SERVICE.writeInteger", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun writeReal(instanceId: Int, vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return client.write("$SERVICE.writeReal", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun writeString(instanceId: Int, vr: List<ValueReference>, value: List<String>): FmiStatus {
        return client.write("$SERVICE.writeString", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }

    override fun writeBoolean(instanceId: Int, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return client.write("$SERVICE.writeBoolean", RpcParams.listParams(instanceId, vr, value))
                .getResult<FmiStatus>()!!
    }


    internal class StepResult(
            var simulationTime: Double,
            var status: FmiStatus
    ) {
        fun asPair() = simulationTime to status
    }

}