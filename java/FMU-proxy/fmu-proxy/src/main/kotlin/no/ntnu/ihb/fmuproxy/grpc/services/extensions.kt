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

package no.ntnu.ihb.fmuproxy.grpc.services

import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.misc.DefaultExperiment
import no.ntnu.ihb.fmi4j.modeldescription.structure.ModelStructure
import no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
import no.ntnu.ihb.fmuproxy.grpc.Service

internal fun Boolean.protoType(): Service.Bool {
    return Service.Bool.newBuilder().setValue(this).build()
}

internal fun FmiStatus.protoType(): Service.Status {
    return when (this) {
        FmiStatus.OK -> Service.Status.OK_STATUS
        FmiStatus.Warning -> Service.Status.WARNING_STATUS
        FmiStatus.Discard -> Service.Status.DISCARD_STATUS
        FmiStatus.Error -> Service.Status.ERROR_STATUS
        FmiStatus.Fatal -> Service.Status.FATAL_STATUS
        FmiStatus.Pending -> Service.Status.PENDING_STATUS
        FmiStatus.NONE -> Service.Status.UNRECOGNIZED
    }
}

internal fun ModelDescription.protoType(): Service.ModelDescription {

    return Service.ModelDescription.newBuilder().also { md ->

        md.guid = guid
        md.modelName = modelName
        md.fmiVersion = fmiVersion
        md.modelStructure = modelStructure.protoType()
        md.addAllModelVariables(modelVariables.map { it.protoType() })

        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.author = it }
        version?.also { md.version = it }
        description?.also { md.description = it }
        generationTool?.also { md.generationTool = it }
        generationDateAndTime?.also { md.generationDateAndTime = it }
        defaultExperiment?.also { md.defaultExperiment = it.protoType() }
        variableNamingConvention?.also { md.variableNamingConvention = it }

    }.build()

}

internal fun DefaultExperiment.protoType(): Service.DefaultExperiment {

    return Service.DefaultExperiment.newBuilder().also {
        it.startTime = startTime
        it.stopTime = stopTime
        it.stepSize = stepSize
        it.tolerance = tolerance
    }.build()

}

internal fun CoSimulationAttributes.protoType(): Service.CoSimulationAttributes {

    return Service.CoSimulationAttributes.newBuilder().also { a ->

        a.canHandleVariableCommunicationStepSize = canHandleVariableCommunicationStepSize
        a.canInterpolateInputs = canInterpolateInputs
        a.maxOutputDerivativeOrder = maxOutputDerivativeOrder

        a.modelIdentifier = modelIdentifier
        a.canGetAndSetFMUstate = canGetAndSetFMUstate
        a.canSerializeFMUstate = canSerializeFMUstate
        a.providesDirectionalDerivative = providesDirectionalDerivative

    }.build()

}

internal fun IntegerVariable.protoType(): Service.IntegerAttribute {
    return Service.IntegerAttribute.newBuilder().also {builder ->
        min?.also { builder.min = it }
        max?.also { builder.max = it }
        start?.also { builder.start = it }
        quantity?.also { builder.quantity = it }
    }.build()
}

internal fun RealVariable.protoType(): Service.RealAttribute {
    return Service.RealAttribute.newBuilder().also {builder ->
        min?.also { builder.min = it }
        max?.also { builder.max = it }
        start?.also { builder.start = it }
        quantity?.also { builder.quantity = it }
    }.build()
}

internal fun StringVariable.protoType(): Service.StringAttribute {
    return Service.StringAttribute.newBuilder().also {builder ->
        start?.also { builder.start = it }
    }.build()
}

internal fun BooleanVariable.protoType(): Service.BooleanAttribute {
    return Service.BooleanAttribute.newBuilder().also {builder ->
        start?.also { builder.start = it }
    }.build()
}

internal fun EnumerationVariable.protoType(): Service.EnumerationAttribute {
    return Service.EnumerationAttribute.newBuilder().also {builder ->
        min?.also { builder.min = it }
        max?.also { builder.max = it }
        start?.also { builder.start = it }
        quantity?.also { builder.quantity = it }
    }.build()
}

internal fun TypedScalarVariable<*>.protoType() : Service.ScalarVariable {
    return Service.ScalarVariable.newBuilder().also { builder ->

        builder.name = name
        builder.valueReference = valueReference

        description?.also { builder.description = it }
        causality?.also { builder.causality = it.protoType() }
        variability?.also { builder.variability = it.protoType() }
        initial?.also { builder.initial = it.protoType() }

        when (this) {
            is IntegerVariable -> builder.integerAttribute = this.protoType()
            is RealVariable -> builder.realAttribute = this.protoType()
            is StringVariable -> builder.stringAttribute = this.protoType()
            is BooleanVariable -> builder.booleanAttribute = this.protoType()
            is EnumerationVariable -> builder.enumerationAttribute = this.protoType()
            else -> throw AssertionError()
        }

    }.build()

}

internal fun ModelStructure.protoType(): Service.ModelStructure {
    return Service.ModelStructure.newBuilder()
            .addAllOutputs(outputs.map { it.protoType() })
            .addAllDerivatives(derivatives.map { it.protoType() })
            .addAllInitialUnknowns(initialUnknowns.map { it.protoType() })
            .build()
}

internal fun Unknown.protoType(): Service.Unknown {
    return Service.Unknown.newBuilder().also { builder ->
        builder.index = index
        builder.addAllDependencies(dependencies)

        dependenciesKind?.also { builder.dependenciesKind = it }

    }.build()
}

internal fun Causality.protoType(): Service.Causality {

    return when (this) {
        Causality.INPUT -> Service.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> Service.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> Service.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> Service.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> Service.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> Service.Causality.INDEPENDENT_CAUSALITY
        else -> Service.Causality.UNKNOWN_CAUSALITY
    }

}

internal fun Variability.protoType(): Service.Variability {

    return when (this) {
        Variability.CONSTANT -> Service.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> Service.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> Service.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> Service.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> Service.Variability.TUNABLE_VARIABILITY
        else -> Service.Variability.UNKNOWN_VARIABILITY
    }

}

internal fun Initial.protoType(): Service.Initial {

    return when (this) {
        Initial.CALCULATED ->  Service.Initial.CALCULATED_INITIAL
        Initial.EXACT ->  Service.Initial.EXACT_INITIAL
        Initial.APPROX ->  Service.Initial.APPROX_INITIAL
        else ->  Service.Initial.UNKNOWN_INITIAL
    }

}
