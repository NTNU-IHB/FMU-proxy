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


import com.google.protobuf.Empty
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmu_proxy.fmu.Fmus

import io.grpc.stub.StreamObserver
import no.mechatronics.sfi.fmu_proxy.grpc.*
import org.apache.commons.math3.ode.FirstOrderIntegrator
import org.apache.commons.math3.ode.nonstiff.*
import org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class GrpcFmuServiceImpl(
        private val fmuFile: FmuFile
): FmuServiceGrpc.FmuServiceImplBase(), GrpcFmuService {

    private val modelDescription: SimpleModelDescription
            = fmuFile.modelDescription

    override fun createInstanceFromCS(req: Empty, responseObserver: StreamObserver<UIntProto>) {

        val id = Fmus.put(fmuFile.asCoSimulationFmu().newInstance())

        UIntProto.newBuilder().setValue(id).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun createInstanceFromME(req: IntegratorProto, responseObserver: StreamObserver<UIntProto>) {

        fun selectDefaultIntegrator(): FirstOrderIntegrator {
            val stepSize = fmuFile.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No integrator specified.. Defaulting to Euler with $stepSize stepSize")
            return EulerIntegrator(stepSize)
        }

        val integrator = when (req.integratorsCase) {
            IntegratorProto.IntegratorsCase.GILL -> GillIntegrator(req.gill.stepSize)
            IntegratorProto.IntegratorsCase.EULER -> EulerIntegrator(req.euler.stepSize)
            IntegratorProto.IntegratorsCase.MID_POINT -> MidpointIntegrator(req.midPoint.stepSize)
            IntegratorProto.IntegratorsCase.RUNGE_KUTTA -> ClassicalRungeKuttaIntegrator(req.rungeKutta.stepSize)
            IntegratorProto.IntegratorsCase.ADAMS_BASHFORTH -> req.adamsBashforth.let { AdamsBashforthIntegrator(it.nSteps, it.minStep, it.maxStep, it.scalAbsoluteTolerance, it.scalRelativeTolerance) }
            IntegratorProto.IntegratorsCase.DORMAND_PRINCE54 -> req.dormandPrince54.let { DormandPrince54Integrator(it.minStep, it.maxStep, it.scalAbsoluteTolerance, it.scalRelativeTolerance) }
            IntegratorProto.IntegratorsCase.INTEGRATORS_NOT_SET -> selectDefaultIntegrator()
            null -> selectDefaultIntegrator()
        }

        Fmus.put(fmuFile.asModelExchangeFmu().newInstance(integrator)).also { id ->
            UIntProto.newBuilder().setValue(id).build().also {
                responseObserver.onNext(it)
                responseObserver.onCompleted()
            }
        }
        
    }

    override fun getGuid(request: Empty, responseObserver: StreamObserver<StrProto>) {

        StrProto.newBuilder().setValue(modelDescription.guid).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getModelName(req: Empty, responseObserver: StreamObserver<StrProto>) {

        val modelName = modelDescription.modelName
        StrProto.newBuilder().setValue(modelName).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getModelDescriptionXml(request: Empty, responseObserver: StreamObserver<StrProto>) {

        val xml = fmuFile.modelDescriptionXml
        StrProto.newBuilder().setValue(xml).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun getCurrentTime(req: UIntProto, responseObserver: StreamObserver<RealProto>) {

        Fmus.get(req.value)?.apply {
            responseObserver.onNext(RealProto.newBuilder().setValue(currentTime).build())
        }
        responseObserver.onCompleted()

    }

    override fun isTerminated(req: UIntProto, responseObserver: StreamObserver<BoolProto>) {

        Fmus.get(req.value)?.apply {
            responseObserver.onNext(BoolProto.newBuilder().setValue(isTerminated).build())
        }
        responseObserver.onCompleted()

    }

    override fun getModelVariables(req: Empty, responseObserver: StreamObserver<ScalarVariableProto>) {

        for (variable in modelDescription.modelVariables) {
            responseObserver.onNext(variable.protoType())
        }
        responseObserver.onCompleted()

    }

    override fun getModelStructure(request: Empty, responseObserver: StreamObserver<ModelStructureProto>) {

        val modelStructure = modelDescription.modelStructure.let {
            ModelStructureProto.newBuilder().apply {
                addAllOutputs(it.outputs)
                addAllDerivatives(it.derivatives.map { it.protoType() })
                addAllInitialUnknowns(it.initialUnknowns.map { it.protoType() })
            }.build()
        }

        responseObserver.onNext(modelStructure)
        responseObserver.onCompleted()

    }

    override fun readInteger(req: ReadRequestProto, responseObserver: StreamObserver<IntReadProto>) {

        Fmus.get(req.fmuId)?.apply {
        val valueReference = req.valueReference
            val read = variableAccessor.readInteger(valueReference)
            responseObserver.onNext(IntReadProto.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }
        responseObserver.onCompleted()

    }


    override fun bulkReadInteger(req: BulkReadRequestProto, responseObserver: StreamObserver<IntListReadProto>) {

        Fmus.get(req.fmuId)?.apply {
        val builder = IntListReadProto.newBuilder()
            val read = variableAccessor.readInteger(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }
        responseObserver.onCompleted()

    }

    override fun readReal(req: ReadRequestProto, responseObserver: StreamObserver<RealReadProto>) {

        Fmus.get(req.fmuId)?.apply {
        val valueReference = req.valueReference
            val read = variableAccessor.readReal(valueReference)
            responseObserver.onNext(RealReadProto.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }

        responseObserver.onCompleted()

    }

    override fun bulkReadReal(req: BulkReadRequestProto, responseObserver: StreamObserver<RealListReadProto>) {

        Fmus.get(req.fmuId)?.apply {
        val builder = RealListReadProto.newBuilder()
            val read = variableAccessor.readReal(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }
        responseObserver.onCompleted()

    }

    override fun readString(req: ReadRequestProto, responseObserver: StreamObserver<StrReadProto>) {

        Fmus.get(req.fmuId)?.apply {
            val read = variableAccessor.readString(req.valueReference)
            responseObserver.onNext(StrReadProto.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }

        responseObserver.onCompleted()

    }

    override fun bulkReadString(req: BulkReadRequestProto, responseObserver: StreamObserver<StrListReadProto>) {

        Fmus.get(req.fmuId)?.apply {
            val builder = StrListReadProto.newBuilder()
            val read = variableAccessor.readString(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }
        responseObserver.onCompleted()

    }

    override fun readBoolean(req: ReadRequestProto, responseObserver: StreamObserver<BoolReadProto>) {

        Fmus.get(req.fmuId)?.apply {
            val read = variableAccessor.readBoolean(req.valueReference)
            responseObserver.onNext(BoolReadProto.newBuilder()
                    .setValue(read.value)
                    .setStatus(convert(read.status))
                    .build())
        }

        responseObserver.onCompleted()

    }

    override fun bulkReadBoolean(req: BulkReadRequestProto, responseObserver: StreamObserver<BoolListReadProto>) {

        Fmus.get(req.fmuId)?.apply {
            val builder = BoolListReadProto.newBuilder()
            val read = variableAccessor.readBoolean(req.valueReferencesList.toIntArray())
            builder.status = convert(read.status)
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
        }
        responseObserver.onCompleted()

    }

    override fun writeInteger(req: WriteIntegerRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeInteger(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun bulkWriteInteger(req: BulkWriteIntegerRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeInteger(req.valueReferencesList.toIntArray(), req.valuesList.toIntArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeReal(req: WriteRealRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeReal(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)


    }

    override fun bulkWriteReal(req: BulkWriteRealRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeReal(req.valueReferencesList.toIntArray(), req.valuesList.toDoubleArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeString(req: WriteStringRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeString(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)


    }

    override fun bulkWriteString(req: BulkWriteStringRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeString(req.valueReferencesList.toIntArray(), req.valuesList.toTypedArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeBoolean(req: WriteBooleanRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeBoolean(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)


    }

    override fun bulkWriteBoolean(req: BulkWriteBooleanRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeBoolean(req.valueReferencesList.toIntArray(), req.valuesList.toBooleanArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun init(req: InitRequestProto, responseObserver: StreamObserver<BoolProto>) {

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

        BoolProto.newBuilder().setValue(init).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun step(req: StepRequestProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.fmuId)?.apply {
            doStep(req.stepSize)
            statusReply(lastStatus, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun terminate(req: UIntProto, responseObserver: StreamObserver<BoolProto>) {

        var success = false
        val fmuId = req.value
        Fmus.remove(fmuId)?.apply {
            success = terminate()
            LOG.debug("Terminated fmu with success: $success")
        }
        BoolProto.newBuilder().setValue(success).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun reset(req: UIntProto, responseObserver: StreamObserver<StatusProto>) {

        Fmus.get(req.value)?.apply {
            reset()
            statusReply(lastStatus, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuServer::class.java)
    }

}

private fun TypedScalarVariable<*>.getCausalityProto(): CausalityProto {

    return when (causality) {
        Causality.INPUT -> CausalityProto.INPUT_CAUSALITY
        Causality.OUTPUT -> CausalityProto.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> CausalityProto.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> CausalityProto.PARAMETER_CAUSALITY
        Causality.LOCAL -> CausalityProto.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> CausalityProto.INDEPENDENT_CAUSALITY
        else -> CausalityProto.UNDEFINED_CAUSALITY
    }

}

private fun TypedScalarVariable<*>.getVariabilityProto(): VariabilityProto {

    return when (variability) {
        Variability.CONSTANT -> VariabilityProto.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> VariabilityProto.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> VariabilityProto.DISCRETE_VARIABILITY
        Variability.FIXED -> VariabilityProto.FIXED_VARIABILITY
        Variability.TUNABLE -> VariabilityProto.TUNABLE_VARIABILITY
        else -> VariabilityProto.UNDEFINED_VARIABILITY
    }

}

private fun TypedScalarVariable<*>.getInitialProto(): InitialProto {

    return when (initial) {
        Initial.CALCULATED -> InitialProto.CALCULATED_INITIAL
        Initial.EXACT -> InitialProto.EXACT_INITIAL
        Initial.APPROX -> InitialProto.APPROX_INITIAL
        else -> InitialProto.UNDEFINED_INITIAL
    }

}

private fun TypedScalarVariable<*>.getStartProto(): AnyPrimitiveProto {
    return if (start != null) {
        AnyPrimitiveProto.newBuilder().also { builder ->
            when (this) {
                is IntegerVariable -> builder.intValue = start!!
                is RealVariable -> builder.realValue = start!!
                is StringVariable -> builder.strValue = start
                is BooleanVariable -> builder.boolValue = start!!
                is EnumerationVariable -> builder.enumValue = start!!
                else -> throw UnsupportedOperationException("Variable type not supported: ${this::class.java.simpleName}")
            }
        }.build()

    } else {
        AnyPrimitiveProto.getDefaultInstance()
    }
}

private fun TypedScalarVariable<*>.getVariableTypeProto(): VariableTypeProto {
    return when(this) {
        is IntegerVariable -> VariableTypeProto.INTEGER_VARIABLE
        is RealVariable -> VariableTypeProto.REAL_VARIABLE
        is StringVariable -> VariableTypeProto.STRING_VARIABLE
        is BooleanVariable -> VariableTypeProto.BOOLEAN_VARIABLE
        is EnumerationVariable -> VariableTypeProto.ENUMERATION_VARIABLE
        else -> throw UnsupportedOperationException("Variable type not supported: $typeName")
    }

}

private fun TypedScalarVariable<*>.protoType() : ScalarVariableProto {
    return ScalarVariableProto.newBuilder()
            .setValueReference(valueReference)
            .setName(name)
            .setDescription(description)
            .setVariableType(getVariableTypeProto())
            .setCausality(this.getCausalityProto())
            .setVariability(this.getVariabilityProto())
            .setStart(getStartProto())
            .build()
}

private fun Unknown.protoType() : UnknownProto {
    return UnknownProto.newBuilder().also { builder ->
        builder.index = index
        builder.addAllDependencies(dependencies)

        dependenciesKind?.also {
            builder.dependenciesKind = when(dependenciesKind) {
                DependenciesKind.CONSTANT -> DependenciesKindProto.CONSTANT_KIND
                DependenciesKind.DEPENDENT -> DependenciesKindProto.DEPENDENT_KIND
                DependenciesKind.DISCRETE -> DependenciesKindProto.DISCRETE_KIND
                DependenciesKind.TUNABLE -> DependenciesKindProto.TUNABLE_KIND
                else -> DependenciesKindProto.UNRECOGNIZED
            }
        }
    }.build()
}

