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

package no.mechatronics.sfi.fmu_proxy.thrift

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmu_proxy.fmu.Fmus
import org.apache.commons.math3.ode.FirstOrderIntegrator
import org.apache.commons.math3.ode.nonstiff.AdamsBashforthIntegrator
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator
import org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator
import org.apache.commons.math3.ode.nonstiff.GillIntegrator
import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ThriftFmuServiceHandler(
        private val fmuFile: FmuFile
): ThriftFmuService.Iface {

    private val modelDescription: SimpleModelDescription
            = fmuFile.modelDescription

    override fun getGuid(): String {
        return modelDescription.guid
    }

    override fun getModelName(): String {
        return modelDescription.modelName
    }

    override fun getModelDescriptionXml(): String {
        return fmuFile.modelDescriptionXml
    }

    override fun getModelVariables(): MutableList<ScalarVariable> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInstanceFromCS(): Int {
        return Fmus.put(fmuFile.asCoSimulationFmu().newInstance())
    }

    override fun createInstanceFromME(p0: Integrator): Int {

        fun selectDefaultIntegrator(): FirstOrderIntegrator {
            val stepSize = fmuFile.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No integrator specified.. Defaulting to Euler with $stepSize stepSize")
            return org.apache.commons.math3.ode.nonstiff.EulerIntegrator(stepSize)
        }

        val integrator: FirstOrderIntegrator = when {
            p0.isSetEuler -> org.apache.commons.math3.ode.nonstiff.EulerIntegrator(p0.euler.step_size)
            p0.isSetRunge_kutta -> ClassicalRungeKuttaIntegrator(p0.runge_kutta.step_size)
            p0.isSetGill -> GillIntegrator(p0.gill.step_size)
            p0.isSetMid_point -> MidpointIntegrator(p0.mid_point.step_size)
            p0.isSetAdams_bashforth -> p0.adams_bashforth.let {
                AdamsBashforthIntegrator(it.n_steps, it.min_Step, it.max_step, it.scal_absolute_tolerance, it.scal_relative_tolerance)
            }
            p0.isSetDormand_prince54 -> p0.dormand_prince54.let {
                DormandPrince54Integrator(it.min_Step, it.max_step, it.scal_absolute_tolerance, it.scal_relative_tolerance)
            }
            else -> selectDefaultIntegrator()

        }

        return Fmus.put(fmuFile.asModelExchangeFmu().newInstance(integrator))
    }

    override fun getCurrentTime(fmu_id: Int): Double {
        return Fmus.get(fmu_id)?.let {
            it.currentTime
        } ?: throw NoSuchFmuException("No such FMU with id=$fmu_id")
    }

    override fun isTerminated(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.isTerminated
        } ?: throw NoSuchFmuException("No such FMU with id=$fmu_id")
    }

    override fun init(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.init()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmu_id")
    }

    override fun step(fmu_id: Int, p1: Double): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.doStep(p1)
            convertStatus(it.lastStatus)
        } ?: throw NoSuchFmuException("No such FMU with id=$fmu_id")
    }

    override fun terminate(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.terminate()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmu_id")
    }


    companion object {

        val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServiceHandler::class.java)


        fun convertStatus(status: FmiStatus): StatusCode {
            return when (status) {
                FmiStatus.OK -> StatusCode.OK_STATUS
                FmiStatus.Warning -> StatusCode.WARNING_STATUS
                FmiStatus.Discard -> StatusCode.DISCARD_STATUS
                FmiStatus.Error -> StatusCode.ERROR_STATUS
                FmiStatus.Fatal -> StatusCode.FATAL_STATUS
                FmiStatus.Pending -> StatusCode.PENDING_STATUS
                FmiStatus.NONE -> throw RuntimeException()
            }
        }

    }

}