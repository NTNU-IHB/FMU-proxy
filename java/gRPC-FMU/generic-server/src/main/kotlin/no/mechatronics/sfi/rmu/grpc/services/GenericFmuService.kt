/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
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

package no.mechatronics.sfi.rmu.grpc.services

import io.grpc.stub.StreamObserver

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.FmuBuilder
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.rmu.FmiDefinitions
import no.mechatronics.sfi.rmu.GenericFmuServiceGrpc
import no.mechatronics.sfi.rmu.Fmus
import no.mechatronics.sfi.rmu.grpc.FmuServer

import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator
import org.apache.commons.math3.ode.nonstiff.GillIntegrator
import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicInteger

class GenericFmuService(
        private val fmuFile: FmuFile
): GenericFmuServiceGrpc.GenericFmuServiceImplBase(), FmuService {

    private val idGenerator = AtomicInteger(0)

    private val builder: FmuBuilder
            = FmuBuilder(this.fmuFile)

    private val modelDescription: SimpleModelDescription
            = fmuFile.modelDescription

    override fun createInstanceFromCS(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

        val id = idGenerator.incrementAndGet()
        Fmus[id] = builder.asCoSimulationFmu().newInstance()

        FmiDefinitions.UInt.newBuilder().setValue(id).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun createInstanceFromME(req: FmiDefinitions.Integrator, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

        fun selectDefaultIntegrator(): EulerIntegrator {
            val stepSize = fmuFile.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No integrator specified.. Defaulting to Euler with $stepSize stepsize")
            return EulerIntegrator(stepSize)
        }

        val integrator = when (req.integratorsCase) {
            FmiDefinitions.Integrator.IntegratorsCase.EULER -> EulerIntegrator(req.euler.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.RUNGE_KUTTA -> ClassicalRungeKuttaIntegrator(req.rungeKutta.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.GILL -> GillIntegrator(req.gill.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.MID_POINT -> MidpointIntegrator(req.midPoint.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.INTEGRATORS_NOT_SET -> selectDefaultIntegrator()
            null -> selectDefaultIntegrator()
        }

        val id = idGenerator.incrementAndGet()
        Fmus[id] = builder.asModelExchangeFmu().newInstance(integrator)

        FmiDefinitions.UInt.newBuilder().setValue(id).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getGuid(request: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.Str>) {

        FmiDefinitions.Str.newBuilder().setValue(modelDescription.guid).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getModelName(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.Str>) {

        val modelName = modelDescription.modelName
        FmiDefinitions.Str.newBuilder().setValue(modelName).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getModelDescriptionXml(request: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.Str>) {

        val xml = fmuFile.modelDescriptionXml
        FmiDefinitions.Str.newBuilder().setValue(xml).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getCurrentTime(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Real>) {

        val id = req.value
        val fmu = Fmus[id]
        if (fmu != null) {
            responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(fmu.currentTime).build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }

        responseObserver.onCompleted()

    }

    override fun isTerminated(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

        val id = req.value
        val fmu = Fmus[id]
        if (fmu != null) {
            responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(fmu.isTerminated).build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }

        responseObserver.onCompleted()

    }

    override fun getModelVariables(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.ScalarVariable>) {

        for (variable in modelDescription.modelVariables) {
            responseObserver.onNext(variable.protoType())
        }
        responseObserver.onCompleted()

    }

    override fun getModelStructure(request: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.ModelStructure>) {

        val modelStructure = modelDescription.modelStructure.let {
            FmiDefinitions.ModelStructure.newBuilder().apply {
                addAllOutputs(it.outputs)
                addAllDerivatives(it.derivatives.map { it.protoType() })
                addAllInitialUnknowns(it.initialUnknowns.map { it.protoType() })
            }.build()
        }

        responseObserver.onNext(modelStructure)
        responseObserver.onCompleted()

    }

    override fun readInteger(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.IntRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val valueReference = req.valueReference
            val read = fmu.variableAccessor.readInteger(valueReference)
            responseObserver.onNext(FmiDefinitions.IntRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }


    override fun bulkReadInteger(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.IntListRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val builder = FmiDefinitions.IntListRead.newBuilder()
            val read = fmu.variableAccessor.readInteger(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun readReal(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val valueReference = req.valueReference
            val read = fmu.variableAccessor.readReal(valueReference)
            responseObserver.onNext(FmiDefinitions.RealRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun bulkReadReal(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealListRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val builder = FmiDefinitions.RealListRead.newBuilder()
            val read = fmu.variableAccessor.readReal(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun readString(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val read = fmu.variableAccessor.readString(req.valueReference)
            responseObserver.onNext(FmiDefinitions.StrRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun bulkReadString(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrListRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val builder = FmiDefinitions.StrListRead.newBuilder()
            val read = fmu.variableAccessor.readString(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun readBoolean(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val read = fmu.variableAccessor.readBoolean(req.valueReference)
            responseObserver.onNext(FmiDefinitions.BoolRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun bulkReadBoolean(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolListRead>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val builder = FmiDefinitions.BoolListRead.newBuilder()
            val read = fmu.variableAccessor.readBoolean(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        } else {
            LOG.warn("No fmu with id: {}", id)
        }
        responseObserver.onCompleted()

    }

    override fun writeInteger(req: FmiDefinitions.WriteIntegerRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeInteger(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }

    }

    override fun bulkWriteInteger(req: FmiDefinitions.BulkWriteIntegerRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {
        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeInteger(req.valueReferencesList.toIntArray(), req.valuesList.toIntArray())
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }
    }

    override fun writeReal(req: FmiDefinitions.WriteRealRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeReal(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }

    }

    override fun bulkWriteReal(req: FmiDefinitions.BulkWriteRealRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {
        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeReal(req.valueReferencesList.toIntArray(), req.valuesList.toDoubleArray())
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }
    }

    override fun writeString(req: FmiDefinitions.WriteStringRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeString(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }

    }

    override fun bulkWriteString(req: FmiDefinitions.BulkWriteStringRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {
        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeString(req.valueReferencesList.toIntArray(), req.valuesList.toTypedArray())
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }
    }

    override fun writeBoolean(req: FmiDefinitions.WriteBooleanRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeBoolean(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }

    }

    override fun bulkWriteBoolean(req: FmiDefinitions.BulkWriteBooleanRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {
        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val status = fmu.variableAccessor.writeBoolean(req.valueReferencesList.toIntArray(), req.valuesList.toBooleanArray())
            statusReply(status, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }
    }

    override fun init(req: FmiDefinitions.InitRequest, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

        var init = false
        val id = req.fmuId
        val fmu = Fmus[id]
        if (fmu != null) {
            val start = req.start
            val stop = req.stop
            val hasStart = start > 0
            val hasStop = stop > 0 && stop > start
            init = if (hasStart && hasStop) {
                fmu.init(start, stop)
            } else if (hasStart && hasStop) {
                fmu.init(start)
            } else {
                fmu.init()
            }
        } else {
            LOG.warn("No fmu with id: {}", id)
        }

        FmiDefinitions.Bool.newBuilder().setValue(init).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun step(req: FmiDefinitions.StepRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        val id = req.fmuId
        val dt = req.dt
        val fmu = Fmus[id]
        if (fmu != null) {
            fmu.doStep(dt)
            statusReply(fmu.lastStatus, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }

    }

    override fun terminate(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

        var flag = false
        val id = req.value
        val fmu = Fmus.remove(id)
        if (fmu != null) {
            flag = fmu.terminate()
            LOG.debug("Terminated fmu with success: {}", flag)
        } else {
            LOG.warn("No fmu with id: {}", id)
        }

        FmiDefinitions.Bool.newBuilder().setValue(flag).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun reset(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        val id = req.value
        val fmu = Fmus.remove(id)
        if (fmu != null) {
            fmu.reset()
            statusReply(fmu.lastStatus, responseObserver)
        } else {
            LOG.warn("No fmu with id: {}", id)
            statusReply(FmiStatus.Error, responseObserver)
        }

    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(FmuServer::class.java)
    }

}

private fun getCausality(variable: TypedScalarVariable<*>): FmiDefinitions.Causality {

    return when (variable.causality) {
        Causality.INPUT -> FmiDefinitions.Causality.INPUT
        Causality.OUTPUT -> FmiDefinitions.Causality.OUTPUT
        Causality.CALCULATED_PARAMETER -> FmiDefinitions.Causality.CALCULATED_PARAMETER
        Causality.PARAMETER -> FmiDefinitions.Causality.PARAMETER
        Causality.LOCAL -> FmiDefinitions.Causality.LOCAL
        Causality.INDEPENDENT -> FmiDefinitions.Causality.INDEPENDENT
        else -> FmiDefinitions.Causality.UNDEFINED_CAUSALITY
    }

}

private fun getVariability(variable: TypedScalarVariable<*>): FmiDefinitions.Variability {

    return when (variable.variability) {
        Variability.CONSTANT -> FmiDefinitions.Variability.CONSTANT
        Variability.CONTINUOUS -> FmiDefinitions.Variability.CONTINUOUS
        Variability.DISCRETE -> FmiDefinitions.Variability.DISCRETE
        Variability.FIXED -> FmiDefinitions.Variability.FIXED
        Variability.TUNABLE -> FmiDefinitions.Variability.TUNABLE
        else -> FmiDefinitions.Variability.UNDEFINED_VARIABILITY
    }

}

private fun getInitial(variable: TypedScalarVariable<*>): FmiDefinitions.Initial {

    return when (variable.initial) {
        Initial.CALCULATED -> FmiDefinitions.Initial.CALCULATED
        Initial.EXACT -> FmiDefinitions.Initial.EXACT
        Initial.APPROX -> FmiDefinitions.Initial.APPROX
        else -> FmiDefinitions.Initial.UNDEFINED_INITIAL
    }

}

private fun getStart(variable: TypedScalarVariable<*>): FmiDefinitions.AnyPrimitive {

    if (variable.start == null) {
        return FmiDefinitions.AnyPrimitive.getDefaultInstance()
    }

    return FmiDefinitions.AnyPrimitive.newBuilder().apply {
        if (variable is IntegerVariable) {
            intValue = (variable.start!!)
        } else if (variable is RealVariable) {
            realValue = (variable.start!!)
        } else if (variable is StringVariable) {
            strValue = (variable.start)
        } else if (variable is BooleanVariable) {
            boolValue = (variable.start!!)
        } else {
            throw UnsupportedOperationException("Variable type not supported: " + variable.javaClass.simpleName)
        }
    }.build()

}

private fun TypedScalarVariable<*>.getType(): FmiDefinitions.VariableType {
    return when (typeName) {
        "Integer" -> FmiDefinitions.VariableType.INTEGER
        "Real" -> FmiDefinitions.VariableType.REAL
        "String" -> FmiDefinitions.VariableType.STRING
        "Boolean" -> FmiDefinitions.VariableType.BOOLEAN
        else -> throw UnsupportedOperationException("Variable type not supported: " + typeName)
    }

}

private fun TypedScalarVariable<*>.protoType() : FmiDefinitions.ScalarVariable {
    return FmiDefinitions.ScalarVariable.newBuilder()
            .setValueReference(valueReference)
            .setName(name)
            .setDescription(description)
            .setVariableType(getType())
            .setCausality(getCausality(this))
            .setVariability(getVariability(this))
            .setStart(getStart(this))
            .build()
}

private fun Unknown.protoType() : FmiDefinitions.Unknown {
    return FmiDefinitions.Unknown.newBuilder().also { builder ->
        builder.index = index
        dependencies?.also { dependencies ->
            builder.addAllDependencies(dependencies.toList())
        }
        dependenciesKind?.also {
            builder.dependenciesKind = when(dependenciesKind) {
                DependenciesKind.CONSTANT -> FmiDefinitions.DependenciesKind.CONSTANT_KIND
                DependenciesKind.DEPENDENT -> FmiDefinitions.DependenciesKind.DEPENDENT_KIND
                DependenciesKind.DISCRETE -> FmiDefinitions.DependenciesKind.DISCRETE_KIND
                DependenciesKind.TUNABLE -> FmiDefinitions.DependenciesKind.TUNABLE_KIND
                else -> FmiDefinitions.DependenciesKind.UNRECOGNIZED
            }
        }
    }.build()
}

