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
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationAttributes
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmuproxy.InstanceId
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

    private fun getSlave(id: InstanceId): FmuSlave {
        return FmuSlaves[id] ?: throw IllegalArgumentException("No slave with id=$id")
    }

    @RpcMethod
    fun getModelDescription(fmuId: String): ModelDescription {
        return getFmu(fmuId).modelDescription
    }

    @RpcMethod
    fun getModelDescriptionXml(fmuId: String): String {
        return getFmu(fmuId).modelDescriptionXml
    }

    @RpcMethod
    fun canCreateInstanceFromCS(fmuId: String): Boolean {
        return getFmu(fmuId).supportsCoSimulation
    }

    @RpcMethod
    fun canCreateInstanceFromME(fmuId: String): Boolean {
        return getFmu(fmuId).supportsModelExchange
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

            (parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()).let {
                FmuSlaves.put(fmu.asModelExchangeFmu().newInstance(it))
            }
        }
    }

    @RpcMethod
    fun getCoSimulationAttributes(instanceId: InstanceId): CoSimulationAttributes {
        return getSlave(instanceId).let {
            it.modelDescription.attributes
        }
    }

    @RpcMethod
    @JvmOverloads
    fun setupExperiment(instanceId: InstanceId, startTime: Double = 0.0, stopTime: Double = 0.0, tolerance: Double = 0.0): FmiStatus {
        return getSlave(instanceId).let {
            it.setup(startTime, stopTime, tolerance)
            it.lastStatus
        }
    }

    @RpcMethod
    fun enterInitializationMode(instanceId: InstanceId): FmiStatus {
        return getSlave(instanceId).let {
            it.enterInitializationMode()
            it.lastStatus
        }
    }

    @RpcMethod
    fun exitInitializationMode(instanceId: InstanceId): FmiStatus {
        return getSlave(instanceId).let {
            it.exitInitializationMode()
            it.lastStatus
        }
    }

    @RpcMethod
    fun step(instanceId: InstanceId, stepSize: Double): StepResult {
        return getSlave(instanceId).let {
            it.doStep(stepSize)
            StepResult(
                    simulationTime = it.simulationTime,
                    status = it.lastStatus
            )
        }
    }

    @RpcMethod
    fun reset(instanceId: InstanceId): FmiStatus {
        return getSlave(instanceId).let {
            it.reset()
            it.lastStatus
        }
    }

    @RpcMethod
    fun terminate(instanceId: InstanceId): FmiStatus {
        return getSlave(instanceId).let {
            it.terminate()
            it.lastStatus
        }
    }

    @RpcMethod
    fun readInteger(instanceId: InstanceId, vr: ValueReferences): FmuIntegerArrayRead {
        val values = IntArray(vr.size)
        return getSlave(instanceId).variableAccessor.readInteger(vr, values).let {
            FmuIntegerArrayRead(values, it)
        }
    }
    
    @RpcMethod
    fun readReal(instanceId: InstanceId, vr: ValueReferences): FmuRealArrayRead {
        val values = RealArray(vr.size)
        return getSlave(instanceId).variableAccessor.readReal(vr, values).let {
            FmuRealArrayRead(values, it)
        }
    }
    
    @RpcMethod
    fun readString(instanceId: InstanceId, vr: ValueReferences): FmuStringArrayRead {
        val values = StringArray(vr.size) {""}
        return getSlave(instanceId).variableAccessor.readString(vr, values).let {
            FmuStringArrayRead(values, it)
        }
    }
    
    @RpcMethod
    fun readBoolean(instanceId: InstanceId, vr: ValueReferences): FmuBooleanArrayRead {
        val values = BooleanArray(vr.size)
        return getSlave(instanceId).variableAccessor.readBoolean(vr, values).let {
            FmuBooleanArrayRead(values, it)
        }
    }
    
    @RpcMethod
    fun writeInteger(instanceId: InstanceId, vr: ValueReferences, value: IntArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeInteger(vr, value)
    }

    @RpcMethod
    fun writeReal(instanceId: InstanceId, vr: ValueReferences, value: DoubleArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeReal(vr, value)
    }
    

    @RpcMethod
    fun writeString(instanceId: InstanceId, vr: ValueReferences, value: StringArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeString(vr, value)
    }

    @RpcMethod
    fun writeBoolean(instanceId: InstanceId, vr: ValueReference, value: Boolean): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeBoolean(vr, value)
    }

    @RpcMethod
    fun writeBoolean(instanceId: InstanceId, vr: ValueReferences, value: BooleanArray): FmiStatus {
        return getSlave(instanceId).variableAccessor.writeBoolean(vr, value)
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(RpcFmuService::class.java)
    }

}
