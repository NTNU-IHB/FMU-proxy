/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
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

package no.mechatronics.sfi.fmuproxy.jsonrpc.service

import info.laht.yajrpc.RpcMethod
import info.laht.yajrpc.RpcService
import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private fun getFmu(id: Int): FmiSimulation {
    val fmu = Fmus.get(id)
    if (fmu != null) {
        return fmu
    }
    throw IllegalArgumentException("No fmu with id=$id")
}

/**
 * @author Lars Ivar Hatledal
 */
class RpcFmuService(
        private val fmu: Fmu
) : RpcService {

    override val serviceName = "FmuService"

    val modelDescription: CommonModelDescription
        @RpcMethod
        get() = fmu.modelDescription

    val fmiVersion: String
        @RpcMethod
        get() = modelDescription.fmiVersion

    val guid: String
        @RpcMethod
        get() = modelDescription.guid

    val modelName: String
        @RpcMethod
        get() = modelDescription.modelName

    val modelDescriptionXml: String
        @RpcMethod
        get() = fmu.modelDescriptionXml


    @RpcMethod
    fun createInstanceFromCS(): Int {
        return Fmus.put(fmu.asCoSimulationFmu().newInstance())
    }

    @RpcMethod
    fun createInstanceFromME(solver: Solver): Int {

        fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.solvers.Solver {
            val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
            return ApacheSolvers.euler(stepSize)
        }

        val integrator = parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()
        return Fmus.put(fmu.asModelExchangeFmu().newInstance(integrator))
    }

    @RpcMethod
    fun isTerminated(instanceId: Int): Boolean {
        return getFmu(instanceId).isTerminated
    }

    @RpcMethod
    fun getSimulationTime(instanceId: Int): Double {
        return getFmu(instanceId).currentTime
    }

    @RpcMethod
    fun init(instanceId: Int): FmiStatus {
        return getFmu(instanceId).let {
            it.init()
            it.lastStatus
        }
    }

    @RpcMethod
    fun init(instanceId: Int, startTime: Double): FmiStatus {
        return getFmu(instanceId).let {
            it.init(startTime)
            it.lastStatus
        }
    }

    @RpcMethod
    fun init(instanceId: Int, startTime: Double, stopTime: Double): FmiStatus {
        return getFmu(instanceId).let {
            it.init(startTime, stopTime)
            it.lastStatus
        }
    }

    @RpcMethod
    fun step(instanceId: Int, stepSize: Double): StepResult {
        return getFmu(instanceId).let {
            it.doStep(stepSize)
            StepResult(
                    simulationTime = it.currentTime,
                    status = it.lastStatus
            )
        }
    }

    @RpcMethod
    fun terminate(instanceId: Int): FmiStatus {
        return getFmu(instanceId).let {
            it.terminate()
            it.lastStatus
        }
    }

    @RpcMethod
    fun reset(instanceId: Int): FmiStatus {
        return getFmu(instanceId).let {
            it.reset()
            it.lastStatus
        }
    }

    @RpcMethod
    fun readInteger(instanceId: Int, vr: ValueReference): FmuIntegerRead {
        return getFmu(instanceId).variableAccessor.readInteger(vr)
    }

    @RpcMethod
    fun bulkReadInteger(instanceId: Int, vr: ValueReferences): FmuIntegerArrayRead {
        return getFmu(instanceId).variableAccessor.readInteger(vr)
    }

    @RpcMethod
    fun readReal(instanceId: Int, vr: ValueReference): FmuRealRead {
        return getFmu(instanceId).variableAccessor.readReal(vr)
    }

    @RpcMethod
    fun bulkReadReal(instanceId: Int, vr: ValueReferences): FmuRealArrayRead {
        return getFmu(instanceId).variableAccessor.readReal(vr)
    }

    @RpcMethod
    fun readString(instanceId: Int, vr: ValueReference): FmuStringRead {
        return getFmu(instanceId).variableAccessor.readString(vr)
    }

    @RpcMethod
    fun bulkReadString(instanceId: Int, vr: ValueReferences): FmuStringArrayRead {
        return getFmu(instanceId).variableAccessor.readString(vr)
    }

    @RpcMethod
    fun readBoolean(instanceId: Int, vr: ValueReference): FmuBooleanRead {
        return getFmu(instanceId).variableAccessor.readBoolean(vr)
    }

    @RpcMethod
    fun bulkReadBoolean(instanceId: Int, vr: ValueReferences): FmuBooleanArrayRead {
        return getFmu(instanceId).variableAccessor.readBoolean(vr)
    }

    @RpcMethod
    fun writeInteger(instanceId: Int, vr: ValueReference, value: Int): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeInteger(vr, value)
    }

    @RpcMethod
    fun bulkWriteInteger(instanceId: Int, vr: ValueReferences, value: IntArray): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeInteger(vr, value)
    }

    @RpcMethod
    fun writeReal(instanceId: Int, vr: ValueReference, value: Double): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeReal(vr, value)
    }

    @RpcMethod
    fun bulkWriteReal(instanceId: Int, vr: ValueReferences, value: DoubleArray): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeReal(vr, value)
    }

    @RpcMethod
    fun writeString(instanceId: Int, vr: ValueReference, value: String): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeString(vr, value)
    }

    @RpcMethod
    fun bulkWriteString(instanceId: Int, vr: ValueReferences, value: StringArray): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeString(vr, value)
    }

    @RpcMethod
    fun writeBoolean(instanceId: Int, vr: ValueReference, value: Boolean): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeBoolean(vr, value)
    }

    @RpcMethod
    fun bulkWriteBoolean(instanceId: Int, vr: ValueReferences, value: BooleanArray): FmiStatus {
        return getFmu(instanceId).variableAccessor.writeBoolean(vr, value)
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(RpcFmuService::class.java)
    }

}

class StepResult(
        val status: FmiStatus,
        val simulationTime: Double
)

class Solver(
        val name: String,
        val settings: String
)