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

package no.mechatronics.sfi.fmuproxy.thrift.services

import no.mechatronics.sfi.fmi4j.common.FmuSlave
import no.mechatronics.sfi.fmi4j.common.RealArray
import no.mechatronics.sfi.fmi4j.common.StringArray
import no.mechatronics.sfi.fmi4j.common.ValueReference
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.cs.CoSimulationModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.me.ModelExchangeModelDescription
import no.mechatronics.sfi.fmuproxy.fmu.FmuSlaves
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.mechatronics.sfi.fmuproxy.thrift.*
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.ByteBuffer

class ThriftFmuServiceImpl(
        private val fmus: Map<String, Fmu>
): FmuService.Iface {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServiceImpl::class.java)
    }
    
    private fun getFmu(fmuId: String): Fmu {
        return fmus[fmuId] ?: throw NoSuchFmuException("No such FMU with guid: '$fmuId'")
    }
    
    private fun getSlave(instanceId: String): FmuSlave {
        return FmuSlaves[instanceId] ?: throw NoSuchInstanceException("No such slave with id: '$instanceId'")
    }

    override fun getModelDescriptionXml(fmuId: String): String {
        return getFmu(fmuId).modelDescriptionXml
    }

    override fun getModelDescription(fmuId: String): ModelDescription {
        return getFmu(fmuId).modelDescription.thriftType()
    }

    override fun createInstanceFromCS(fmuId: String): String {
        return getFmu(fmuId).let {fmu ->
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
            fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.solvers.Solver {
                val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
                LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
                return ApacheSolvers.euler(stepSize)
            }

            val _solver = parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()
            FmuSlaves.put(fmu.asModelExchangeFmu().newInstance(_solver))
        }
    }

    override fun init(instanceId: String, startTime: Double, endTime: Double): Status {
        return getSlave(instanceId).let {
            it.init()
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
            val status = it.readInteger(vr.toIntArray(), values).thriftType()
            IntegerRead(values.toList(), status)
        }
    }

    override fun readReal(instanceId: String, vr: List<ValueReference>): RealRead {
        val values = RealArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.readReal(vr.toIntArray(), values).thriftType()
            RealRead(values.asList(), status)
        }
    }

    override fun readString(instanceId: String, vr: List<ValueReference>): StringRead {
        val values = StringArray(vr.size) {""}
        return getSlave(instanceId).let {
            val status = it.readString(vr.toIntArray(), values).thriftType()
            StringRead(values.toList(), status)
        }
    }

    override fun readBoolean(instanceId: String, vr: List<ValueReference>): BooleanRead {
        val values = BooleanArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.readBoolean(vr.toIntArray(), values).thriftType()
            BooleanRead(values.toList(), status)
        }
    }


    override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): Status {
        return getSlave(instanceId).let {
            it.writeInteger(vr.toIntArray(), value.toIntArray()).thriftType()
        }
    }

    override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Double>): Status {
        return getSlave(instanceId).let {
            it.writeReal(vr.toIntArray(), value.toDoubleArray()).thriftType()
        } 
    }

    override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): Status {
        return getSlave(instanceId).let {
            it.writeString(vr.toIntArray(), value.toTypedArray()).thriftType()
        } 
    }

    override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): Status {
        return getSlave(instanceId).let {
            it.writeBoolean(vr.toIntArray(), value.toBooleanArray()).thriftType()
        } 
    }
    
    override fun canGetAndSetFMUstate(instanceId: String): Boolean {
        return getSlave(instanceId).canGetAndSetFMUstate
    }
    
    override fun canSerializeFMUstate(instanceId: String): Boolean {
        return getSlave(instanceId).canSerializeFMUstate
    }

    override fun getFMUstate(instanceId: String): GetFmuStateResult {
        return getSlave(instanceId).let {
            if (!it.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance dos not have capability canGetAndSetFMUstate!")
            }
            GetFmuStateResult(it.getFMUstate(), it.lastStatus.thriftType())
        }
    }

    override fun setFMUstate(instanceId: String, state: Long): Status {
        return getSlave(instanceId).let {
            if (!it.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance dos not have capability canGetAndSetFMUstate!")
            }
            it.setFMUstate(state)
            it.lastStatus.thriftType()
        }
    }

    override fun freeFMUstate(instanceId: String, state: Long): Status {
        return getSlave(instanceId).let {
            if (!it.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance dos not have capability canGetAndSetFMUstate!")
            }
            it.freeFMUstate(state)
            it.lastStatus.thriftType()
        }
    }

    override fun serializeFMUstate(instanceId: String, state: Long): SerializeFmuStateResult {
        return getSlave(instanceId).let {
            if (!it.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance dos not have capability canGetAndSetFMUstate!")
            }
            val bytes = ByteBuffer.wrap(it.serializeFMUstate(state))
            SerializeFmuStateResult(bytes, it.lastStatus.thriftType())
        }
    }

    override fun deSerializeFMUstate(instanceId: String, state: ByteBuffer): DeSerializeFmuStateResult {
        return getSlave(instanceId).let {
            if (!it.canGetAndSetFMUstate) {
                throw UnsupportedOperationException("FMU instance dos not have capability canGetAndSetFMUstate!")
            }
            DeSerializeFmuStateResult(it.deSerializeFMUstate(state.array()), it.lastStatus.thriftType())
        }
    }

}

