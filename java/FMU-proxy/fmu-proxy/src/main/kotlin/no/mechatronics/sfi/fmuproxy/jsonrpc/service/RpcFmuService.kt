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
import no.mechatronics.sfi.fmuproxy.fmu.FmuSlaves
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class StepResult(
        val status: FmiStatus,
        val simulationTime: Double
)

class Solver(
        val name: String,
        val settings: String
)

/**
 * @author Lars Ivar Hatledal
 */
class RpcFmuService(
        private val fmus: Map<String, Fmu>
) : RpcService {

    constructor(fmu: Fmu): this(mapOf(fmu.guid to fmu))

    override val serviceName = "FmuService"

    private fun getFmu(id: String): Fmu {
        return fmus[id] ?: throw IllegalArgumentException("No FMU with id=$id")
    }

    private fun getSlave(id: String): FmuSlave {
        return FmuSlaves[id] ?: throw IllegalArgumentException("No slave with id=$id")
    }

    @RpcMethod
    fun getModelDescription(fmuId: String): CommonModelDescription {
        return getFmu(fmuId).modelDescription
    }

    @RpcMethod
    fun getModelDescriptionXml(fmuId: String): String {
        return getFmu(fmuId).modelDescriptionXml
    }

    
    @RpcMethod
    fun createInstanceFromCS(fmuId: String): String {
        return getFmu(fmuId).let { fmu ->
            FmuSlaves.put(fmu.asCoSimulationFmu().newInstance())
        }
    }

    @RpcMethod
    fun createInstanceFromME(fmuId: String, solver: Solver): String {

        return getFmu(fmuId).let { fmu ->
            fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.solvers.Solver {
                val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
                LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
                return ApacheSolvers.euler(stepSize)
            }

            val _solver = parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()
            FmuSlaves.put(fmu.asModelExchangeFmu().newInstance(_solver))
        }

        
    }

    @RpcMethod
    @JvmOverloads
    fun init(instanceId: String, startTime: Double = 0.0, stopTime: Double = 0.0): FmiStatus {
        return getSlave(instanceId).let {
            it.init(startTime, stopTime)
            it.lastStatus
        }
    }

    @RpcMethod
    fun step(instanceId: String, stepSize: Double): StepResult {
        return getSlave(instanceId).let {
            it.doStep(stepSize)
            StepResult(
                    simulationTime = it.simulationTime,
                    status = it.lastStatus
            )
        }
    }

    @RpcMethod
    fun reset(instanceId: String): FmiStatus {
        return getSlave(instanceId).let {
            it.reset()
            it.lastStatus
        }
    }

    @RpcMethod
    fun terminate(instanceId: String): FmiStatus {
        return getSlave(instanceId).let {
            it.terminate()
            it.lastStatus
        }
    }

    @RpcMethod
    fun readInteger(instanceId: String, vr: ValueReferences): FmuIntegerArrayRead {
        return getSlave(instanceId).variableAccessor.readInteger(vr)
    }
    
    @RpcMethod
    fun readReal(instanceId: String, vr: ValueReferences): FmuRealArrayRead {
        return getSlave(instanceId).variableAccessor.readReal(vr)
    }
    
    @RpcMethod
    fun readString(instanceId: String, vr: ValueReferences): FmuStringArrayRead {
        return getSlave(instanceId).variableAccessor.readString(vr)
    }
    
    @RpcMethod
    fun readBoolean(instanceId: String, vr: ValueReferences): FmuBooleanArrayRead {
        return getSlave(instanceId).variableAccessor.readBoolean(vr)
    }
    
    @RpcMethod
    fun writeInteger(instanceId: String, vr: ValueReferences, value: IntArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeInteger(vr, value)
    }

    @RpcMethod
    fun writeReal(instanceId: String, vr: ValueReferences, value: DoubleArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeReal(vr, value)
    }
    

    @RpcMethod
    fun writeString(instanceId: String, vr: ValueReferences, value: StringArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeString(vr, value)
    }

    @RpcMethod
    fun writeBoolean(instanceId: String, vr: ValueReference, value: Boolean): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeBoolean(vr, value)
    }

    @RpcMethod
    fun writeBoolean(instanceId: String, vr: ValueReferences, value: BooleanArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeBoolean(vr, value)
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(RpcFmuService::class.java)
    }

}
