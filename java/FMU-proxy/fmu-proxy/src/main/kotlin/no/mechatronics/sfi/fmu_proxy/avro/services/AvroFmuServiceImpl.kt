package no.mechatronics.sfi.fmu_proxy.avro.services

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.avro.*
import no.mechatronics.sfi.fmu_proxy.fmu.Fmus
import org.apache.commons.math3.ode.FirstOrderIntegrator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AvroFmuServiceImpl(
        private val fmuFile: FmuFile
): AvroFmuService {

    override fun getCurrentTime(fmu_id: Int): Double {
        return Fmus.get(fmu_id)?.let {
            it.currentTime
        } ?: throw NoSuchFmuException()
    }

    override fun createInstanceFromCS(): Int {
        if (!fmuFile.supportsCoSimulation) {
            throw UnsupportedOperationException("FMU does not support CoSimulation!")
        }
       return Fmus.put(fmuFile.asCoSimulationFmu().newInstance())
    }


    override fun createInstanceFromME(i: Integrator): Int {

        fun selectDefaultIntegrator(): FirstOrderIntegrator {
            val stepSize = fmuFile.modelDescription.defaultExperiment?.stepSize ?: 1E-3
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

        return Fmus.put(fmuFile.asModelExchangeFmu().newInstance(integrator))
    }

    override fun isTerminated(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.isTerminated
        } ?: throw NoSuchFmuException()
    }

    override fun supportsCosimulation(): Boolean {
       return fmuFile.supportsCoSimulation
    }

    override fun supportsModelExchange(): Boolean {
        return fmuFile.supportsModelExchange
    }

    override fun getModelDescriptionXml(): String {
        return fmuFile.modelDescriptionXml
    }

    override fun init(fmu_id: Int, start: Double, stop: Double): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.init(start, stop).avroType()
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
            it.terminate().avroType()
        } ?: throw NoSuchFmuException()
    }

    override fun reset(fmu_id: Int): StatusCode {
        return Fmus.get(fmu_id)?.let {
            it.reset().avroType()
        } ?: throw NoSuchFmuException()
    }


    override fun canGetAndSetFMUstate(fmu_id: Int): Boolean {
        return Fmus.get(fmu_id)?.let {
            it.modelDescription.canGetAndSetFMUstate
        } ?: throw NoSuchFmuException()
    }


    override fun getModelDescription(): ModelDescription {
        return fmuFile.modelDescription.avroType()
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(AvroFmuServiceImpl::class.java)
    }

}