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

package no.mechatronics.sfi.fmu_proxy.grpc.services


import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions
import no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuServiceGrpc
import no.mechatronics.sfi.fmu_proxy.fmu.Fmus
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer

import io.grpc.stub.StreamObserver
import org.apache.commons.math3.ode.nonstiff.*

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.util.concurrent.atomic.AtomicInteger

class GenericFmuServiceImpl(
        private val fmuFile: FmuFile
): GenericFmuServiceGrpc.GenericFmuServiceImplBase(), GrpcFmuService {

    private val idGenerator = AtomicInteger(0)

    private val modelDescription: SimpleModelDescription
            = fmuFile.modelDescription

    override fun createInstanceFromCS(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

        val id = idGenerator.incrementAndGet()
        Fmus.put(id, fmuFile.asCoSimulationFmu().newInstance())

        FmiDefinitions.UInt.newBuilder().setValue(id).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun createInstanceFromME(req: FmiDefinitions.Integrator, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

        fun selectDefaultIntegrator(): EulerIntegrator {
            val stepSize = fmuFile.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No integrator specified.. Defaulting to Euler with $stepSize stepSize")
            return EulerIntegrator(stepSize)
        }

        val integrator = when (req.integratorsCase) {

            FmiDefinitions.Integrator.IntegratorsCase.GILL -> GillIntegrator(req.gill.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.EULER -> EulerIntegrator(req.euler.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.MID_POINT -> MidpointIntegrator(req.midPoint.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.RUNGE_KUTTA -> ClassicalRungeKuttaIntegrator(req.rungeKutta.stepSize)
            FmiDefinitions.Integrator.IntegratorsCase.ADAMS_BASHFORTH -> req.adamsBashforth.let { AdamsBashforthIntegrator(it.nSteps, it.minStep, it.maxStep, it.scalAbsoluteTolerance, it.scalRelativeTolerance) }
            FmiDefinitions.Integrator.IntegratorsCase.DORMAND_PRINCE54 -> req.dormandPrince54.let { DormandPrince54Integrator(it.minStep, it.maxStep, it.scalAbsoluteTolerance, it.scalRelativeTolerance) }
            FmiDefinitions.Integrator.IntegratorsCase.INTEGRATORS_NOT_SET -> selectDefaultIntegrator()
            null -> selectDefaultIntegrator()
        }

        val id = idGenerator.incrementAndGet()
        Fmus.put(id, fmuFile.asModelExchangeFmu().newInstance(integrator))

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

        Fmus.get(req.value)?.apply {
            responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(currentTime).build())
        }

        responseObserver.onCompleted()

    }

    override fun isTerminated(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

        Fmus.get(req.value)?.apply {
            responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(isTerminated).build())
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

        Fmus.get(req.fmuId)?.apply {
        val valueReference = req.valueReference
            val read = variableAccessor.readInteger(valueReference)
            responseObserver.onNext(FmiDefinitions.IntRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }
        responseObserver.onCompleted()

    }


    override fun bulkReadInteger(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.IntListRead>) {

        Fmus.get(req.fmuId)?.apply {
        val builder = FmiDefinitions.IntListRead.newBuilder()
            val read = variableAccessor.readInteger(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }
        responseObserver.onCompleted()

    }

    override fun readReal(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealRead>) {

        Fmus.get(req.fmuId)?.apply {
        val valueReference = req.valueReference
            val read = variableAccessor.readReal(valueReference)
            responseObserver.onNext(FmiDefinitions.RealRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }

        responseObserver.onCompleted()

    }

    override fun bulkReadReal(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealListRead>) {

        Fmus.get(req.fmuId)?.apply {
        val builder = FmiDefinitions.RealListRead.newBuilder()
            val read = variableAccessor.readReal(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }

        responseObserver.onCompleted()

    }

    override fun readString(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrRead>) {

        Fmus.get(req.fmuId)?.apply {
            val read = variableAccessor.readString(req.valueReference)
            responseObserver.onNext(FmiDefinitions.StrRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }

        responseObserver.onCompleted()

    }

    override fun bulkReadString(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrListRead>) {

        Fmus.get(req.fmuId)?.apply {
            val builder = FmiDefinitions.StrListRead.newBuilder()
            val read = variableAccessor.readString(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }

        responseObserver.onCompleted()

    }

    override fun readBoolean(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolRead>) {

        Fmus.get(req.fmuId)?.apply {
            val read = variableAccessor.readBoolean(req.valueReference)
            responseObserver.onNext(FmiDefinitions.BoolRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }

        responseObserver.onCompleted()

    }

    override fun bulkReadBoolean(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolListRead>) {

        Fmus.get(req.fmuId)?.apply {
            val builder = FmiDefinitions.BoolListRead.newBuilder()
            val read = variableAccessor.readBoolean(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }

        responseObserver.onCompleted()

    }

    override fun writeInteger(req: FmiDefinitions.WriteIntegerRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeInteger(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun bulkWriteInteger(req: FmiDefinitions.BulkWriteIntegerRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeInteger(req.valueReferencesList.toIntArray(), req.valuesList.toIntArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeReal(req: FmiDefinitions.WriteRealRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeReal(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)


    }

    override fun bulkWriteReal(req: FmiDefinitions.BulkWriteRealRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeReal(req.valueReferencesList.toIntArray(), req.valuesList.toDoubleArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeString(req: FmiDefinitions.WriteStringRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeString(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)


    }

    override fun bulkWriteString(req: FmiDefinitions.BulkWriteStringRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeString(req.valueReferencesList.toIntArray(), req.valuesList.toTypedArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeBoolean(req: FmiDefinitions.WriteBooleanRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeBoolean(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)


    }

    override fun bulkWriteBoolean(req: FmiDefinitions.BulkWriteBooleanRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeBoolean(req.valueReferencesList.toIntArray(), req.valuesList.toBooleanArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun init(req: FmiDefinitions.InitRequest, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

        var init = false
        Fmus.get(req.fmuId)?.apply {
            val start = req.start
            val stop = req.stop
            val hasStart = start > 0
            val hasStop = stop > 0 && stop > start
            init = if (hasStart && hasStop) {
                init(start, stop)
            } else if (hasStart && hasStop) {
                init(start)
            } else {
                init()
            }
        }

        FmiDefinitions.Bool.newBuilder().setValue(init).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun step(req: FmiDefinitions.StepRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.fmuId)?.apply {
            doStep(req.stepSize)
            statusReply(lastStatus, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun terminate(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

        var success = false
        val fmuId = req.value
        Fmus.remove(fmuId)?.apply {
            success = terminate()
            LOG.debug("Terminated fmu with success: $success")
        }
        FmiDefinitions.Bool.newBuilder().setValue(success).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun reset(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Status>) {

        Fmus.get(req.value)?.apply {
            reset()
            statusReply(lastStatus, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuServer::class.java)
    }

}

private fun getCausality(variable: TypedScalarVariable<*>): FmiDefinitions.Causality {

    return when (variable.causality) {
        Causality.INPUT -> FmiDefinitions.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> FmiDefinitions.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> FmiDefinitions.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> FmiDefinitions.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> FmiDefinitions.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> FmiDefinitions.Causality.INDEPENDENT_CAUSALITY
        else -> FmiDefinitions.Causality.UNDEFINED_CAUSALITY
    }

}

private fun getVariability(variable: TypedScalarVariable<*>): FmiDefinitions.Variability {

    return when (variable.variability) {
        Variability.CONSTANT -> FmiDefinitions.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> FmiDefinitions.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> FmiDefinitions.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> FmiDefinitions.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> FmiDefinitions.Variability.TUNABLE_VARIABILITY
        else -> FmiDefinitions.Variability.UNDEFINED_VARIABILITY
    }

}

private fun getInitial(variable: TypedScalarVariable<*>): FmiDefinitions.Initial {

    return when (variable.initial) {
        Initial.CALCULATED -> FmiDefinitions.Initial.CALCULATED_INITIAL
        Initial.EXACT -> FmiDefinitions.Initial.EXACT_INITIAL
        Initial.APPROX -> FmiDefinitions.Initial.APPROX_INITIAL
        else -> FmiDefinitions.Initial.UNDEFINED_INITIAL
    }

}

private fun getStart(variable: TypedScalarVariable<*>): FmiDefinitions.AnyPrimitive {

    return if (variable.start != null) {
         FmiDefinitions.AnyPrimitive.newBuilder().apply {
            when (variable) {
                is IntegerVariable -> intValue = variable.start!!
                is RealVariable -> realValue = variable.start!!
                is StringVariable -> strValue = variable.start
                is BooleanVariable -> boolValue = variable.start!!
                is EnumerationVariable -> enumerationValue = variable.start!!
                else -> throw UnsupportedOperationException("Variable type not supported: " + variable.javaClass.simpleName)
            }
        }.build()
        
    } else {
         FmiDefinitions.AnyPrimitive.getDefaultInstance()
    }
    
}

private fun TypedScalarVariable<*>.getType(): FmiDefinitions.VariableType {
    return when(this) {
        is IntegerVariable -> FmiDefinitions.VariableType.INTEGER_VARIABLE
        is RealVariable -> FmiDefinitions.VariableType.REAL_VARIABLE
        is StringVariable -> FmiDefinitions.VariableType.STRING_VARIABLE
        is BooleanVariable -> FmiDefinitions.VariableType.BOOLEAN_VARIABLE
        is EnumerationVariable -> FmiDefinitions.VariableType.ENUMERATION_VARIABLE
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
        builder.addAllDependencies(dependencies)

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

