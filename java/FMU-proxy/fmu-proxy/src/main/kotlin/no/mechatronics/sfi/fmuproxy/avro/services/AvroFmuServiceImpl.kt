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

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.avro.*
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import org.apache.commons.math3.ode.FirstOrderIntegrator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AvroFmuServiceImpl(
        private val fmu: Fmu
): AvroFmuService {

    override fun getCurrentTime(fmu_id: Int): Double {
        return Fmus.get(fmu_id)?.let {
            it.currentTime
        } ?: throw NoSuchFmuException()
    }

    override fun createInstanceFromCS(): Int {
        if (!fmu.supportsCoSimulation) {
            throw UnsupportedOperationException("FMU does not support CoSimulation!")
        }
       return Fmus.put(fmu.asCoSimulationFmu().newInstance())
    }


    override fun createInstanceFromME(i: Integrator): Int {

        fun selectDefaultIntegrator(): FirstOrderIntegrator {
            val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No integrator specified.. Defaulting to Euler with $stepSize stepSize")
            return org.apache.commons.math3.ode.nonstiff.EulerIntegrator(stepSize)
        }

        val it = i.integrator
        val integrator: FirstOrderIntegrator = when(it) {
            is EulerIntegrator -> org.apache.commons.math3.ode.nonstiff.EulerIntegrator(it.stepSize)
            is ClassicalRungeKuttaIntegrator -> org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator(it.stepSize)
            is GillIntegrator-> org.apache.commons.math3.ode.nonstiff.GillIntegrator(it.stepSize)
            else -> selectDefaultIntegrator()

        }

        return Fmus.put(fmu.asModelExchangeFmu().newInstance(integrator))
    }

    override fun isTerminated(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.isTerminated
        } ?: throw NoSuchFmuException()
    }

    override fun getModelDescriptionXml(): String {
        return fmu.modelDescriptionXml
    }

    override fun init(fmu_id: Int, start: Double, stop: Double): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.init(start, stop)
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException()
    }

    override fun step(fmu_id: Int, step_size: Double): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.doStep(step_size)
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException()
    }


    override fun terminate(fmu_id: Int): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.terminate()
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException()
    }

    override fun reset(fmu_id: Int): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.reset()
            it.lastStatus.avroType()
        } ?: throw NoSuchFmuException()
    }


    override fun canGetAndSetFMUstate(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.modelDescription.canGetAndSetFMUstate
        } ?: throw NoSuchFmuException()
    }


    override fun getModelDescription(): ModelDescription {
        return fmu.modelDescription.avroType()
    }

    override fun writeString(p0: Int, p1: Int, p2: String?): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readReal(p0: Int, p1: Int): RealRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkWriteReal(p0: Int, p1: MutableList<Int>?, p2: MutableList<Double>?): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkReadBoolean(p0: Int, p1: MutableList<Int>?): BooleanArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkWriteString(p0: Int, p1: MutableList<Int>?, p2: MutableList<String>?): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeBoolean(p0: Int, p1: Int, p2: Boolean): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeReal(p0: Int, p1: Int, p2: Double): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeInt(p0: Int, p1: Int, p2: Int): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readString(p0: Int, p1: Int): StringRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readBoolean(p0: Int, p1: Int): BooleanRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkWriteInt(p0: Int, p1: MutableList<Int>?, p2: MutableList<Int>?): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readInt(p0: Int, p1: Int): IntegerRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkReadInt(p0: Int, p1: MutableList<Int>?): IntegerArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkReadReal(p0: Int, p1: MutableList<Int>?): RealArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkReadString(p0: Int, p1: MutableList<Int>?): StringArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bulkWriteBoolean(p0: Int, p1: MutableList<Int>?, p2: MutableList<Boolean>?): StatusCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(AvroFmuServiceImpl::class.java)
    }

}