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

package no.ntnu.ihb.fmuproxy.jsonrpc.service

import info.laht.yajrpc.RpcMethod
import info.laht.yajrpc.RpcService
import no.ntnu.ihb.fmi4j.*
import no.ntnu.ihb.fmi4j.importer.AbstractFmu
import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.*
import no.ntnu.ihb.fmi4j.solvers.apache.ApacheSolvers
import no.ntnu.ihb.fmuproxy.FmuId
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.fmu.FmuSlaves
import no.ntnu.ihb.fmuproxy.jsonrpc.DirectionalDerivativeResult
import no.ntnu.ihb.fmuproxy.jsonrpc.StepResult
import no.ntnu.ihb.fmuproxy.solver.parseSolver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URL
import java.util.*

class Solver(
        val name: String,
        val settings: String
)

/**
 * @author Lars Ivar Hatledal
 */
class RpcFmuService(
        private val fmus: MutableMap<FmuId, AbstractFmu> = Collections.synchronizedMap(mutableMapOf())
) : RpcService {

    override val serviceName = "FmuService"

    fun addFmu(fmu: AbstractFmu) {
        synchronized(fmus) {
            fmus[fmu.guid] = fmu
        }
    }

    fun removeFmu(fmu: AbstractFmu) {
        synchronized(fmus) {
            fmus.remove(fmu.guid)
        }
    }

    private fun getFmu(id: String): AbstractFmu {
        synchronized(fmus) {
            return fmus[id] ?: throw IllegalArgumentException("No FMU with id=$id")
        }
    }

    private fun getSlave(id: InstanceId): SlaveInstance {
        return FmuSlaves[id] ?: throw IllegalArgumentException("No slave with id=$id")
    }

    @RpcMethod
    fun loadFromUrl(url: String): FmuId {
        @Suppress("NAME_SHADOWING") val url = URL(url)
        val md = ModelDescriptionParser.parseModelDescription(url)
        val guid = md.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                val fmu = AbstractFmu.from(url)
                fmus[guid] = fmu
            }
        }
        return guid
    }

    @RpcMethod
    fun getModelDescription(fmuId: FmuId): ModelDescription {
        return getFmu(fmuId).modelDescription
    }

    @RpcMethod
    fun canCreateInstanceFromCS(fmuId: FmuId): Boolean {
        return getFmu(fmuId).supportsCoSimulation
    }

    @RpcMethod
    fun canCreateInstanceFromME(fmuId: FmuId): Boolean {
        return getFmu(fmuId).supportsModelExchange
    }

    @RpcMethod
    fun createInstanceFromCS(fmuId: FmuId): String {
        LOG.trace("createInstanceFromCS $fmuId")
        return getFmu(fmuId).let { fmu ->
            FmuSlaves.put(fmu.asCoSimulationFmu().newInstance())
        }
    }

    @RpcMethod
    fun createInstanceFromME(fmuId: FmuId, solver: Solver): String {
        LOG.trace("createInstanceFromME $fmuId")
        return getFmu(fmuId).let { fmu ->

            if (!fmu.supportsModelExchange) {
                throw UnsupportedOperationException("FMU does not support Model Exchange!")
            }
            if (fmu.modelDescription.fmiVersion != "2.0") {
                throw UnsupportedOperationException("Feature only available for FMI 2.0")
            }

            fun selectDefaultIntegrator(): no.ntnu.ihb.fmi4j.solvers.Solver {
                val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
                LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
                return ApacheSolvers.euler(stepSize)
            }

            @Suppress("NAME_SHADOWING")
            val fmu = fmu as Fmu
            (parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()).let {
                FmuSlaves.put(fmu.asModelExchangeFmu().newInstance(it))
            }
        }
    }

    @RpcMethod
    fun getCoSimulationAttributes(instanceId: InstanceId): CoSimulationAttributes {
        LOG.trace("getCoSimulationAttributes $instanceId")
        return getSlave(instanceId).modelDescription.attributes
    }

    @RpcMethod
    fun simpleSetup(instanceId: InstanceId): FmiStatus {
        LOG.trace("simpleSetup $instanceId")
        return getSlave(instanceId).let {
            it.simpleSetup()
            it.lastStatus
        }
    }

    @RpcMethod
    fun setupExperiment(instanceId: InstanceId): FmiStatus {
        LOG.trace("setupExperiment $instanceId")
        return getSlave(instanceId).let {
            it.setup()
            it.lastStatus
        }
    }

    @RpcMethod
    fun setupExperiment(instanceId: InstanceId, startTime: Double, stopTime: Double, tolerance: Double): FmiStatus {
        LOG.trace("setupExperiment $instanceId")
        return getSlave(instanceId).let {
            it.setup(startTime, stopTime, tolerance)
            it.lastStatus
        }
    }

    @RpcMethod
    fun enterInitializationMode(instanceId: InstanceId): FmiStatus {
        LOG.trace("enterInitializationMode $instanceId")
        return getSlave(instanceId).let {
            it.enterInitializationMode()
            it.lastStatus
        }
    }

    @RpcMethod
    fun exitInitializationMode(instanceId: InstanceId): FmiStatus {
        LOG.trace("exitInitializationMode $instanceId")
        return getSlave(instanceId).let {
            it.exitInitializationMode()
            it.lastStatus
        }
    }

    @RpcMethod
    fun doStep(instanceId: InstanceId, stepSize: Double): StepResult {
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
        LOG.trace("reset $instanceId")
        return getSlave(instanceId).let {
            it.reset()
            it.lastStatus
        }
    }

    @RpcMethod
    fun terminate(instanceId: InstanceId): FmiStatus {
        LOG.trace("terminate $instanceId")
        return getSlave(instanceId).let {
            it.terminate()
            it.lastStatus
        }
    }

    @RpcMethod
    fun readInteger(instanceId: InstanceId, vr: ValueReferences): IntegerArrayRead {
        val values = IntArray(vr.size)
        return getSlave(instanceId).read(vr, values).let {
            IntegerArrayRead(values, it)
        }
    }

    @RpcMethod
    fun readReal(instanceId: InstanceId, vr: ValueReferences): RealArrayRead {
        val values = RealArray(vr.size)
        return getSlave(instanceId).read(vr, values).let {
            RealArrayRead(values, it)
        }
    }

    @RpcMethod
    fun readString(instanceId: InstanceId, vr: ValueReferences): StringArrayRead {
        val values = StringArray(vr.size) { "" }
        return getSlave(instanceId).read(vr, values).let {
            StringArrayRead(values, it)
        }
    }

    @RpcMethod
    fun readBoolean(instanceId: InstanceId, vr: ValueReferences): BooleanArrayRead {
        val values = BooleanArray(vr.size)
        return getSlave(instanceId).read(vr, values).let {
            BooleanArrayRead(values, it)
        }
    }

    @RpcMethod
    fun writeInteger(instanceId: InstanceId, vr: ValueReferences, value: IntArray): FmiStatus {
        return getSlave(instanceId).write(vr, value)
    }

    @RpcMethod
    fun writeReal(instanceId: InstanceId, vr: ValueReferences, value: DoubleArray): FmiStatus {
        return getSlave(instanceId).write(vr, value)
    }

    @RpcMethod
    fun writeString(instanceId: InstanceId, vr: ValueReferences, value: StringArray): FmiStatus {
        return getSlave(instanceId).write(vr, value)
    }

    @RpcMethod
    fun writeBoolean(instanceId: InstanceId, vr: ValueReferences, value: BooleanArray): FmiStatus {
        return getSlave(instanceId).write(vr, value)
    }

    @RpcMethod
    fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: ValueReferences, vKnownRef: ValueReferences, dvKnownRef: RealArray): DirectionalDerivativeResult {
        return getSlave(instanceId).let {
            val result = it.getDirectionalDerivative(vUnknownRef, vKnownRef, dvKnownRef)
                DirectionalDerivativeResult(result, it.lastStatus)
        }
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(RpcFmuService::class.java)
    }

}
