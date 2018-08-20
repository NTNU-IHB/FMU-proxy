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

import no.mechatronics.sfi.fmi4j.common.ValueReference
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.mechatronics.sfi.fmuproxy.thrift.*
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ThriftFmuServiceImpl(
        private val fmu: Fmu
): FmuService.Iface {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServiceImpl::class.java)
    }
    
    override fun getModelDescriptionXml(): String {
        return fmu.modelDescriptionXml
    }

    override fun getModelDescription(): ModelDescription {
        return fmu.modelDescription.thriftType()
    }

    override fun createInstanceFromCS(): Int {
        return Fmus.put(fmu.asCoSimulationFmu().newInstance())
    }

    override fun createInstanceFromME(solver: Solver): Int {

        fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.solvers.Solver {
            val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
            return ApacheSolvers.euler(stepSize)
        }

        val integrator = parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()
        return Fmus.put(fmu.asModelExchangeFmu().newInstance(integrator))

    }

    override fun getSimulationTime(instanceId: Int): Double {
        return Fmus.get(instanceId)?.let {
            it.currentTime
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun isTerminated(instanceId: Int): Boolean {
        return Fmus.get(instanceId)?.let {
            it.isTerminated
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun init(instanceId: Int, startTime: Double, endTime: Double): Status {
        return Fmus.get(instanceId)?.let {
            it.init()
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun step(instanceId: Int, vr: Double): StepResult {
        return Fmus.get(instanceId)?.let {
            it.doStep(vr)
            StepResult().apply {
                simulationTime = it.currentTime
                status = it.lastStatus.thriftType()
            }
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun terminate(instanceId: Int): Status {
        return Fmus.get(instanceId)?.let {
            it.terminate()
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun reset(instanceId: Int): Status {
        return Fmus.get(instanceId)?.let {
            it.reset()
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun writeReal(instanceId: Int, vr: List<ValueReference>, value: List<Double>): Status {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.writeReal(vr.toIntArray(), value.toDoubleArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun readBoolean(instanceId: Int, vr: List<ValueReference>): BooleanRead {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.readBoolean(vr.toIntArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun writeString(instanceId: Int, vr: List<ValueReference>, value: List<String>): Status {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.writeString(vr.toIntArray(), value.toTypedArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun writeInteger(instanceId: Int, vr: List<ValueReference>, value: List<Int>): Status {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.writeInteger(vr.toIntArray(), value.toIntArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun readInteger(instanceId: Int, vr: List<ValueReference>): IntegerRead {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.readInteger(vr.toIntArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun readReal(instanceId: Int, vr: List<ValueReference>): RealRead {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.readReal(vr.toIntArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun readString(instanceId: Int, vr: List<ValueReference>): StringRead {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.readString(vr.toIntArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }

    override fun writeBoolean(instanceId: Int, vr: List<ValueReference>, value: List<Boolean>): Status {
        return Fmus.get(instanceId)?.let {
            it.variableAccessor.writeBoolean(vr.toIntArray(), value.toBooleanArray()).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
    }
    
//    override fun canGetAndSetFMUstate(instanceId: Int): Boolean {
//        return Fmus.get(instanceId)?.let {
//            val md = it.modelDescription
//            when (md) {
//                is CoSimulationModelDescription -> md.canGetAndSetFMUstate
//                is ModelExchangeModelDescription -> md.canGetAndSetFMUstate
//                else -> throw AssertionError("ModelDescription is not of type CS or ME?")
//            }
//        } ?: throw NoSuchFmuException("No such FMU with id=$instanceId")
//    }
    
}

