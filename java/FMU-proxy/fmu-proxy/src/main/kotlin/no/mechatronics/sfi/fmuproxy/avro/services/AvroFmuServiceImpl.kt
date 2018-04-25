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

    override fun supportsCosimulation(): Boolean {
       return fmu.supportsCoSimulation
    }

    override fun supportsModelExchange(): Boolean {
        return fmu.supportsModelExchange
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

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(AvroFmuServiceImpl::class.java)
    }

}