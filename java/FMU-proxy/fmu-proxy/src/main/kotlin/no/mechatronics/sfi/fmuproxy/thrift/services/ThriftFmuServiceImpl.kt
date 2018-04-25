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

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import no.mechatronics.sfi.fmuproxy.thrift.*
import org.apache.commons.math3.ode.FirstOrderIntegrator
import org.apache.commons.math3.ode.nonstiff.AdamsBashforthIntegrator
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator
import org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator
import org.apache.commons.math3.ode.nonstiff.GillIntegrator
import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ThriftFmuServiceImpl(
        private val fmu: Fmu
): FmuService.Iface {

    override fun supportsCoSimulation(): Boolean {
        return fmu.supportsCoSimulation
    }

    override fun supportsModelExchange(): Boolean {
        return fmu.supportsCoSimulation
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

    override fun createInstanceFromME(i: Integrator): Int {

        fun selectDefaultIntegrator(): FirstOrderIntegrator {
            val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No integrator specified.. Defaulting to Euler with $stepSize stepSize")
            return org.apache.commons.math3.ode.nonstiff.EulerIntegrator(stepSize)
        }

        val integrator: FirstOrderIntegrator = when {
            i.isSetEuler -> org.apache.commons.math3.ode.nonstiff.EulerIntegrator(i.euler.step_size)
            i.isSetRunge_kutta -> ClassicalRungeKuttaIntegrator(i.runge_kutta.step_size)
            i.isSetGill -> GillIntegrator(i.gill.step_size)
            i.isSetMid_point -> MidpointIntegrator(i.mid_point.step_size)
            i.isSetAdams_bashforth -> i.adams_bashforth.let {
                AdamsBashforthIntegrator(it.n_steps, it.min_Step, it.max_step, it.scal_absolute_tolerance, it.scal_relative_tolerance)
            }
            i.isSetDormand_prince54 -> i.dormand_prince54.let {
                DormandPrince54Integrator(it.min_Step, it.max_step, it.scal_absolute_tolerance, it.scal_relative_tolerance)
            }
            else -> selectDefaultIntegrator()
        }

        return Fmus.put(fmu.asModelExchangeFmu().newInstance(integrator))
    }

    override fun getCurrentTime(fmuId: Int): Double {
        return Fmus.get(fmuId)?.let {
            it.currentTime
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun isTerminated(fmuId: Int): Boolean {
        return Fmus.get(fmuId)?.let {
            it.isTerminated
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun canGetAndSetFMUstate(fmuId: Int): Boolean {
        return Fmus.get(fmuId)?.let {
            return it.modelDescription.canGetAndSetFMUstate
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun init(fmuId: Int, startTime: Double, endTime: Double): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.init()
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun step(fmuId: Int, p1: Double): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.doStep(p1)
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun terminate(fmuId: Int): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.terminate()
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun reset(fmuId: Int): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.reset()
            it.lastStatus.thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun readInt(fmuId: Int, vr: Int): IntRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readInteger(vr).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun readReal(fmuId: Int, vr: Int): RealRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readReal(vr).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun readString(fmuId: Int, vr: Int): StringRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readString(vr).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun readBoolen(fmuId: Int, vr: Int): BoolRead {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.readBoolean(vr).thriftType()
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun writeInt(fmuId: Int, vr: Int, value: Int): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeInteger(vr, value).let {
                StatusCode.findByValue(it.code)
            }
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun writeReal(fmuId: Int, vr: Int, value: Double): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeReal(vr, value).let {
                StatusCode.findByValue(it.code)
            }
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    override fun writeString(fmuId: Int, vr: Int, value: String): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeString(vr, value).let {
                StatusCode.findByValue(it.code)
            }
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }


    override fun writeBoolen(fmuId: Int, vr: Int, value: Boolean): StatusCode {
        return Fmus.get(fmuId)?.let {
            it.variableAccessor.writeBoolean(vr, value).let {
                StatusCode.findByValue(it.code)
            }
        } ?: throw NoSuchFmuException("No such FMU with id=$fmuId")
    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServiceImpl::class.java)
    }

}

