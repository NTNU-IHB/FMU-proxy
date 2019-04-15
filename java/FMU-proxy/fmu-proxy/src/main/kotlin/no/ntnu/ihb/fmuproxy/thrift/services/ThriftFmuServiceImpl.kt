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
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment
import no.ntnu.ihb.fmi4j.modeldescription.RealArray
import no.ntnu.ihb.fmi4j.modeldescription.StringArray
import no.ntnu.ihb.fmi4j.modeldescription.ValueReference
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonModelDescriptionParser
import no.ntnu.ihb.fmi4j.solvers.apache.ApacheSolvers
import no.ntnu.ihb.fmuproxy.FmuId
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.fmu.FmuSlaves
import no.ntnu.ihb.fmuproxy.solver.parseSolver
import no.ntnu.ihb.fmuproxy.thrift.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URL
import java.nio.ByteBuffer

/**
 *
 * @author Lars Ivar Hatledal
 */
class ThriftFmuServiceImpl(
        private val fmus: MutableMap<FmuId, Fmu>,
        private var xcDefaults: Map<FmuId, DefaultExperiment>? = null
) : FmuService.Iface {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServiceImpl::class.java)
    }

    private fun getFmu(fmuId: FmuId): Fmu {
        synchronized(fmus) {
            return fmus[fmuId] ?: throw NoSuchFmuException("No such FMU with guid: '$fmuId'")
        }
    }

    private fun getSlave(instanceId: InstanceId): FmuSlave {
        return FmuSlaves[instanceId] ?: throw NoSuchInstanceException("No such slave with id: '$instanceId'")
    }

    override fun loadFromUrl(url: String): String {
        @Suppress("NAME_SHADOWING") val url = URL(url)
        val md = JacksonModelDescriptionParser.parse(url)
        val guid = md.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                val fmu = Fmu.from(url)
                fmus[guid] = fmu
                LOG.info("Loaded new FMU with guid=$guid!")
            } else {
                LOG.debug("FMU with guid=$guid already loaded, re-using it!")
            }
            return guid
        }
    }

    override fun loadFromFile(name: String, data: ByteBuffer): String {
        val fmu = Fmu.from(name, data.compact().array())
        val guid = fmu.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                fmus[guid] = fmu
                LOG.info("Loaded new FMU with guid=$guid!")
            } else {
                fmu.close()
                LOG.debug("FMU with guid=$guid already loaded, re-using it!")
            }
            return guid
        }
    }

    override fun getModelDescription(fmuId: FmuId): ModelDescription {
        return getFmu(fmuId).modelDescription.thriftType()
    }

    override fun canCreateInstanceFromCs(fmuId: FmuId): Boolean {
        return getFmu(fmuId).supportsCoSimulation
    }

    override fun canCreateInstanceFromMe(fmuId: FmuId): Boolean {
        return getFmu(fmuId).supportsModelExchange
    }

    override fun createInstanceFromCs(fmuId: FmuId): InstanceId {
        return getFmu(fmuId).let { fmu ->
            if (!fmu.supportsCoSimulation) {
                throw UnsupportedOperationException("FMU does not support Co-simulation!")
            }
            FmuSlaves.put(fmu.asCoSimulationFmu().newInstance())
        }
    }

    override fun createInstanceFromMe(fmuId: FmuId, solver: Solver): InstanceId {
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

    override fun getCoSimulationAttributes(instanceId: InstanceId): CoSimulationAttributes {
        val attributes = getSlave(instanceId).modelDescription
                as no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
        return attributes.thriftType()
    }

    override fun setupExperiment(instanceId: InstanceId, start: Double, stop: Double, tolerance: Double): Status {
        return getSlave(instanceId).let { slave ->
            slave.setup(start, stop, tolerance)
            slave.lastStatus.thriftType()
        }
    }

    override fun enterInitializationMode(instanceId: InstanceId): Status {
        return getSlave(instanceId).let { slave ->
            slave.enterInitializationMode()
            slave.lastStatus.thriftType()
        }
    }

    override fun exitInitializationMode(instanceId: InstanceId): Status {
        return getSlave(instanceId).let {
            it.exitInitializationMode()
            it.lastStatus.thriftType()
        }
    }

    override fun step(instanceId: InstanceId, vr: Double): StepResult {
        return getSlave(instanceId).let {
            it.doStep(vr)
            StepResult().apply {
                simulationTime = it.simulationTime
                status = it.lastStatus.thriftType()
            }
        }
    }

    override fun terminate(instanceId: InstanceId): Status {
        return getSlave(instanceId).let {
            it.terminate()
            it.lastStatus.thriftType()
        }
    }

    override fun reset(instanceId: InstanceId): Status {
        return getSlave(instanceId).let {
            it.reset()
            it.lastStatus.thriftType()
        }
    }

    override fun readInteger(instanceId: InstanceId, vr: List<ValueReference>): IntegerRead {
        val values = IntArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.read(vr.toLongArray(), values).thriftType()
            IntegerRead(values.toList(), status)
        }
    }

    override fun readReal(instanceId: InstanceId, vr: List<ValueReference>): RealRead {
        val values = RealArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.read(vr.toLongArray(), values).thriftType()
            RealRead(values.asList(), status)
        }
    }

    override fun readString(instanceId: InstanceId, vr: List<ValueReference>): StringRead {
        val values = StringArray(vr.size) { "" }
        return getSlave(instanceId).let {
            val status = it.read(vr.toLongArray(), values).thriftType()
            StringRead(values.toList(), status)
        }
    }

    override fun readBoolean(instanceId: InstanceId, vr: List<ValueReference>): BooleanRead {
        val values = BooleanArray(vr.size)
        return getSlave(instanceId).let {
            val status = it.read(vr.toLongArray(), values).thriftType()
            BooleanRead(values.toList(), status)
        }
    }


    override fun writeInteger(instanceId: InstanceId, vr: List<ValueReference>, value: List<Int>): Status {
        return getSlave(instanceId).let {
            it.write(vr.toLongArray(), value.toIntArray()).thriftType()
        }
    }

    override fun writeReal(instanceId: InstanceId, vr: List<ValueReference>, value: List<Double>): Status {
        return getSlave(instanceId).let {
            it.write(vr.toLongArray(), value.toDoubleArray()).thriftType()
        }
    }

    override fun writeString(instanceId: InstanceId, vr: List<ValueReference>, value: List<String>): Status {
        return getSlave(instanceId).let {
            it.write(vr.toLongArray(), value.toTypedArray()).thriftType()
        }
    }

    override fun writeBoolean(instanceId: InstanceId, vr: List<ValueReference>, value: List<Boolean>): Status {
        return getSlave(instanceId).let {
            it.write(vr.toLongArray(), value.toBooleanArray()).thriftType()
        }
    }

    override fun getDirectionalDerivative(instanceId: InstanceId, vUnkownRef: List<Long>, vKnownRef: List<Long>, dvUnkownRef: List<Double>): DirectionalDerivativeResult {
        return getSlave(instanceId).let {
            if (!it.modelDescription.attributes.providesDirectionalDerivative) {
                throw UnsupportedOperationException("FMU instance does not provide DirectionalDerivative!")
            }
            val dvUnknown = it.getDirectionalDerivative(vUnkownRef.toLongArray(), vKnownRef.toLongArray(), dvUnkownRef.toDoubleArray()).toList()
            DirectionalDerivativeResult(dvUnknown, it.lastStatus.thriftType())
        }
    }

//    override fun getFMUstate(instanceId: InstanceId): GetFmuStateResult {
//        return getSlave(instanceId).let {
//            if (!it.modelDescription.attributes.canGetAndSetFMUstate) {
//                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
//            }
//            GetFmuStateResult(it.getFMUstate(), it.lastStatus.thriftType())
//        }
//    }
//
//    override fun setFMUstate(instanceId: InstanceId, state: Long): Status {
//        return getSlave(instanceId).let {
//            if (!it.modelDescription.attributes.canGetAndSetFMUstate) {
//                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
//            }
//            it.setFMUstate(state)
//            it.lastStatus.thriftType()
//        }
//    }
//
//    override fun freeFMUstate(instanceId: InstanceId, state: Long): Status {
//        return getSlave(instanceId).let {
//            if (!it.modelDescription.attributes.canGetAndSetFMUstate) {
//                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
//            }
//            it.freeFMUstate(state)
//            it.lastStatus.thriftType()
//        }
//    }
//
//    override fun serializeFMUstate(instanceId: InstanceId, state: Long): SerializeFmuStateResult {
//        return getSlave(instanceId).let {
//            if (!it.modelDescription.attributes.canGetAndSetFMUstate) {
//                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
//            }
//            val bytes = ByteBuffer.wrap(it.serializeFMUstate(state))
//            SerializeFmuStateResult(bytes, it.lastStatus.thriftType())
//        }
//    }
//
//    override fun deSerializeFMUstate(instanceId: InstanceId, state: ByteBuffer): DeSerializeFmuStateResult {
//        return getSlave(instanceId).let {
//            if (!it.modelDescription.attributes.canGetAndSetFMUstate) {
//                throw UnsupportedOperationException("FMU instance does not have capability canGetAndSetFMUstate!")
//            }
//            DeSerializeFmuStateResult(it.deSerializeFMUstate(state.array()), it.lastStatus.thriftType())
//        }
//    }

}

