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

package no.ntnu.ihb.fmuproxy.thrift.services

import no.ntnu.ihb.fmi4j.common.FmuSlave
import no.ntnu.ihb.fmi4j.common.RealArray
import no.ntnu.ihb.fmi4j.common.StringArray
import no.ntnu.ihb.fmi4j.common.ValueReference
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.me.ApacheSolvers
import no.ntnu.ihb.fmuproxy.fmu.FmuSlaves
import no.ntnu.ihb.fmuproxy.solver.parseSolver
import no.ntnu.ihb.fmuproxy.thrift.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.ByteBuffer

class ThriftFmuServiceImpl(
        private val fmus: Map<String, Fmu>
) : FmuService.Iface {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServiceImpl::class.java)
    }

    private fun getFmu(fmuId: String): Fmu {
        return fmus[fmuId] ?: throw NoSuchFmuException("No such FMU with guid: '$fmuId'")
    }

    private fun getSlave(instanceId: String): FmuSlave {
        return FmuSlaves[instanceId] ?: throw NoSuchInstanceException("No such slave with id: '$instanceId'")
    }

    override fun getModelDescription(fmuId: String): ModelDescription {
        return getFmu(fmuId).modelDescription.thriftType()
    }

    override fun canCreateInstanceFromCS(fmuId: String): Boolean {
        return getFmu(fmuId).supportsCoSimulation
    }

    override fun canCreateInstanceFromME(fmuId: String): Boolean {
        return getFmu(fmuId).supportsModelExchange
    }

    override fun createInstanceFromCS(fmuId: String): String {
        return getFmu(fmuId).let { fmu ->
            if (!fmu.supportsCoSimulation) {
                throw UnsupportedOperationException("FMU does not support Co-simulation!")
            }
            FmuSlaves.put(fmu.asCoSimulationFmu().newInstance())
        }
    }

    override fun createInstanceFromME(fmuId: String, solver: Solver): String {
        return getFmu(fmuId).let { fmu ->
            if (!fmu.supportsModelExchange) {
                throw UnsupportedOperationException("FMU does not support Model Exchange!")
            }
            fun selectDefaultIntegrator(): no.ntnu.ihb.fmi4j.solvers.Solver {
                val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
                LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
                return ApacheSolvers.euler(stepSize)
            }

            (parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()).let {
                FmuSlaves.put(fmu.asModelExchangeFmu().newInstance(it))
            }

        }
    }

    override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
        val attributes = getSlave(instanceId).modelDescription
                as no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
        return attributes.thriftType()
    }

    override fun setupExperiment(instanceId: String, start: Double, stop: Double, tolerance: Double): Status {
        return getSlave(instanceId).let { slave ->
            slave.setup(start, stop, tolerance)
            slave.lastStatus.thriftType()
        }
    }

    override fun enterInitializationMode(instanceId: String): Status {
        return getSlave(instanceId).let { slave ->
            slave.enterInitializationMode()
            slave.lastStatus.thriftType()
        }
    }

    override fun exitInitializationMode(instanceId: String): Status {
        return getSlave(instanceId).let {
            it.exitInitializationMode()
            it.lastStatus.thriftType()
        }
    }

    override fun step(instanceId: String, vr: Double): StepResult {
        return getSlave(instanceId).let {
            it.doStep(vr)
            StepResult().apply {
                simulationTime = it.simulationTime
                status = it.lastStatus.thriftType()
            }
        }
    }

    override fun terminate(instanceId: String): Status {
        return getSlave(instanceId).let {
            it.terminate()
            it.lastStatus.thriftType()
        }
    }

    override fun reset(instanceId: String): Status {
        return getSlave(instanceId).let {
            it.reset()
            it.lastStatus.thriftType()
        }
    }

    override fun readInteger(instanceId: String, vr: List<ValueReference>): IntegerRead {
        val values = IntArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.variableAccessor.readInteger(vr.toLongArray(), values).thriftType()
            IntegerRead(values.toList(), status)
        }
    }

    override fun readReal(instanceId: String, vr: List<ValueReference>): RealRead {
        val values = RealArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.variableAccessor.readReal(vr.toLongArray(), values).thriftType()
            RealRead(values.asList(), status)
        }
    }

    override fun readString(instanceId: String, vr: List<ValueReference>): StringRead {
        val values = StringArray(vr.size) { "" }
        return getSlave(instanceId).let {
            val status = it.variableAccessor.readString(vr.toLongArray(), values).thriftType()
            StringRead(values.toList(), status)
        }
    }

    override fun readBoolean(instanceId: String, vr: List<ValueReference>): BooleanRead {
        val values = BooleanArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.variableAccessor.readBoolean(vr.toLongArray(), values).thriftType()
            BooleanRead(values.toList(), status)
        }
    }


    override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): Status {
        return getSlave(instanceId).let {
            it.variableAccessor.writeInteger(vr.toLongArray(), value.toIntArray()).thriftType()
        }
    }

    override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Double>): Status {
        return getSlave(instanceId).let {
            it.variableAccessor.writeReal(vr.toLongArray(), value.toDoubleArray()).thriftType()
        }
    }

    override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): Status {
        return getSlave(instanceId).let {
            it.variableAccessor.writeString(vr.toLongArray(), value.toTypedArray()).thriftType()
        }
    }

    override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): Status {
        return getSlave(instanceId).let {
            it.variableAccessor.writeBoolean(vr.toLongArray(), value.toBooleanArray()).thriftType()
        }
    }

    override fun getFMUstate(instanceId: String): GetFmuStateResult {
        return getSlave(instanceId).let {
            if (!it.modelDescription.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
            }
            GetFmuStateResult(it.getFMUstate(), it.lastStatus.thriftType())
        }
    }

    override fun setFMUstate(instanceId: String, state: Long): Status {
        return getSlave(instanceId).let {
            if (!it.modelDescription.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
            }
            it.setFMUstate(state)
            it.lastStatus.thriftType()
        }
    }

    override fun freeFMUstate(instanceId: String, state: Long): Status {
        return getSlave(instanceId).let {
            if (!it.modelDescription.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
            }
            it.freeFMUstate(state)
            it.lastStatus.thriftType()
        }
    }

    override fun serializeFMUstate(instanceId: String, state: Long): SerializeFmuStateResult {
        return getSlave(instanceId).let {
            if (!it.modelDescription.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
            }
            val bytes = ByteBuffer.wrap(it.serializeFMUstate(state))
            SerializeFmuStateResult(bytes, it.lastStatus.thriftType())
        }
    }

    override fun deSerializeFMUstate(instanceId: String, state: ByteBuffer): DeSerializeFmuStateResult {
        return getSlave(instanceId).let {
            if (!it.modelDescription.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
            }
            DeSerializeFmuStateResult(it.deSerializeFMUstate(state.array()), it.lastStatus.thriftType())
        }
    }

    override fun getDirectionalDerivative(instanceId: String, vUnkownRef: List<Long>, vKnownRef: List<Long>, dvUnkownRef: List<Double>): DirectionalDerivativeResult {
        return getSlave(instanceId).let {
            if (!it.modelDescription.providesDirectionalDerivative) {
                throw UnsupportedOperationException("FMU instance does not provide DirectionalDerivative!")
            }
            val dvUnknown = it.getDirectionalDerivative(vUnkownRef.toLongArray(), vKnownRef.toLongArray(), dvUnkownRef.toDoubleArray()).toList()
            DirectionalDerivativeResult(dvUnknown, it.lastStatus.thriftType())
        }
    }

}

