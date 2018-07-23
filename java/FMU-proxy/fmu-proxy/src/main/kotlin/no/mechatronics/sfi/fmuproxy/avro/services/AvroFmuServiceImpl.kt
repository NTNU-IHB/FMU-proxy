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

package no.mechatronics.sfi.fmuproxy.avro.services

import no.mechatronics.sfi.fmi4j.common.ValueReference
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelExchangeModelDescription
import no.mechatronics.sfi.fmuproxy.avro.*
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AvroFmuServiceImpl(
        private val fmu: Fmu
): AvroFmuService {

    override fun getSimulationTime(fmuId: Int): Double {
        return Fmus.get(fmuId)?.let {
            it.currentTime
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun createInstanceFromCS(): Int {
        if (!fmu.supportsCoSimulation) {
            throw UnsupportedOperationException("FMU does not support CoSimulation!")
        }
       return Fmus.put(fmu.asCoSimulationFmu().newInstance())
    }

    override fun createInstanceFromME(solver: Solver): Int {

        fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.importer.me.Solver {
            val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
            return ApacheSolvers.euler(stepSize)
        }

        val integrator = parseSolver(solver.name, solver.settings) ?: selectDefaultIntegrator()
        return Fmus.put(fmu.asModelExchangeFmu().newInstance(integrator))

    }

    override fun isTerminated(fmuId: Int): Boolean {
        return Fmus.get(fmuId)?.let {
            it.isTerminated
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun getModelDescriptionXml(): String {
        return fmu.modelDescriptionXml
    }

    override fun init(fmuId: Int, start: Double, stop: Double): Status {
        return Fmus.get(fmuId)?.let {
            it.init(start, stop)
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun step(fmuId: Int, step_size: Double): StepResult {
        return Fmus.get(fmuId)?.let {
            it.doStep(step_size)
            StepResult().apply {
                simulationTime = it.currentTime
                status = it.lastStatus.avroType()
            }
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun terminate(fmuId: Int): Status {
        return Fmus.get(fmuId)?.let {
            it.terminate()
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun reset(fmuId: Int): Status {
        return Fmus.get(fmuId)?.let {
            it.reset()
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun canGetAndSetFMUstate(fmuId: Int): Boolean {
        return Fmus.get(fmuId)?.let {
            val md = it.modelDescription
            when (md) {
                is CoSimulationModelDescription -> md.canGetAndSetFMUstate
                is ModelExchangeModelDescription -> md.canGetAndSetFMUstate
                else -> throw AssertionError("ModelDescription is not of type CS or ME?")
            }
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun getModelDescription(): ModelDescription {
        return fmu.modelDescription.avroType()
    }

    override fun readInteger(fmuId: Int, vr: ValueReference): IntegerRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readInteger(vr).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun readReal(fmuId: Int, vr: ValueReference): RealRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readReal(vr).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun readString(fmuId: Int, vr: ValueReference): StringRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readString(vr).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun readBoolean(fmuId: Int, vr: ValueReference): BooleanRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readBoolean(vr).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun writeInteger(fmuId: Int, vr: ValueReference, value: Int): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeInteger(vr, value).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun writeReal(fmuId: Int, vr: ValueReference, value: Double): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeReal(vr, value).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun writeString(fmuId: Int, vr: ValueReference, value: String): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeString(vr, value).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun writeBoolean(fmuId: Int, vr: ValueReference, value: Boolean): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeBoolean(vr, value).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkReadInteger(fmuId: Int, vr: List<ValueReference>): BulkIntegerRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readInteger(vr.toIntArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkReadReal(fmuId: Int, vr: List<ValueReference>): BulkRealRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readReal(vr.toIntArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkReadString(fmuId: Int, vr: List<ValueReference>): BulkStringRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readString(vr.toIntArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkReadBoolean(fmuId: Int, vr: List<ValueReference>): BulkBooleanRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readBoolean(vr.toIntArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkWriteInteger(fmuId: Int, vr: List<ValueReference>, value: List<Int>): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeInteger(vr.toIntArray(), value.toIntArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkWriteReal(fmuId: Int, vr: List<ValueReference>, value: List<Double>): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeReal(vr.toIntArray(), value.toDoubleArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkWriteString(fmuId: Int, vr: List<ValueReference>, value: List<String>): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeString(vr.toIntArray(), value.toTypedArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    override fun bulkWriteBoolean(fmuId: Int, vr: List<ValueReference>, value: List<Boolean>): Status {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeBoolean(vr.toIntArray(), value.toBooleanArray()).avroType()
        } ?: throw NoSuchFmuException("No fmu with id=$fmuId")
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(AvroFmuServiceImpl::class.java)
    }

}