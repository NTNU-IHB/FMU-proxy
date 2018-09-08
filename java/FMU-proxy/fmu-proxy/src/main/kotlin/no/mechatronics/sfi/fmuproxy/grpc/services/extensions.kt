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

package no.mechatronics.sfi.fmuproxy.grpc.services

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmuproxy.grpc.Proto

internal fun FmiStatus.protoType(): Proto.Status {
    return when (this) {
        FmiStatus.OK -> Proto.Status.OK_STATUS
        FmiStatus.Warning -> Proto.Status.WARNING_STATUS
        FmiStatus.Discard -> Proto.Status.DISCARD_STATUS
        FmiStatus.Error -> Proto.Status.ERROR_STATUS
        FmiStatus.Fatal -> Proto.Status.FATAL_STATUS
        FmiStatus.Pending -> Proto.Status.PENDING_STATUS
        FmiStatus.NONE -> Proto.Status.UNRECOGNIZED
    }
}

internal fun ModelDescription.protoType(): Proto.ModelDescription {

    return Proto.ModelDescription.newBuilder().also { md ->

        md.guid = guid
        md.modelName = modelName
        md.fmiVersion = fmiVersion
        md.modelStructure = modelStructure.protoType()
        md.addAllModelVariables(modelVariables.map { it.protoType() })
        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.author = it }
        version?.also { md.version = it }
        license?.also { md.license = it }
        generationTool?.also { md.generationTool = it }
        generationDateAndTime?.also { md.generationDateAndTime = it }

        md.supportsCoSimulation = supportsCoSimulation
        md.supportsModelExchange = supportsModelExchange

    }.build()

}

internal fun IntegerVariable.protoType(): Proto.IntegerAttribute {
    return Proto.IntegerAttribute.newBuilder().also {builder ->
        min?.also { builder.min = it }
        max?.also { builder.max = it }
        start?.also { builder.start = it }
    }.build()
}

internal fun RealVariable.protoType(): Proto.RealAttribute {
    return Proto.RealAttribute.newBuilder().also {builder ->
        min?.also { builder.min = it }
        max?.also { builder.max = it }
        start?.also { builder.start = it }
    }.build()
}

internal fun StringVariable.protoType(): Proto.StringAttribute {
    return Proto.StringAttribute.newBuilder().also {builder ->
        start?.also { builder.start = it }
    }.build()
}

internal fun BooleanVariable.protoType(): Proto.BooleanAttribute {
    return Proto.BooleanAttribute.newBuilder().also {builder ->
        start?.also { builder.start = it }
    }.build()
}

internal fun EnumerationVariable.protoType(): Proto.EnumerationAttribute {
    return Proto.EnumerationAttribute.newBuilder().also {builder ->
        min?.also { builder.min = it }
        max?.also { builder.max = it }
        start?.also { builder.start = it }
    }.build()
}

internal fun TypedScalarVariable<*>.protoType() : Proto.ScalarVariable {
    return Proto.ScalarVariable.newBuilder().also { builder ->

        builder.name = name
        builder.valueReference = valueReference

        declaredType?.also { builder.declaredType = it }
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

internal fun ModelStructure.protoType(): Proto.ModelStructure {
    return Proto.ModelStructure.newBuilder()
            .addAllOutputs(outputs.map { it.protoType() })
            .addAllDerivatives(derivatives.map { it.protoType() })
            .addAllInitialUnknowns(initialUnknowns.map { it.protoType() })
            .build()
}

internal fun Unknown.protoType(): Proto.Unknown {
    return Proto.Unknown.newBuilder().also { builder ->
        builder.index = index
        builder.addAllDependencies(dependencies)

        dependenciesKind?.also { builder.dependenciesKind = it.protoType() }

    }.build()
}

internal fun String.protoType(): Proto.DependenciesKind {

    return when (this.toLowerCase()) {
        "constant" -> Proto.DependenciesKind.CONSTANT_KIND
        "dependent" -> Proto.DependenciesKind.DEPENDENT_KIND
        "discrete" -> Proto.DependenciesKind.DISCRETE_KIND
        "tunable" -> Proto.DependenciesKind.TUNABLE_KIND
        else -> Proto.DependenciesKind.UNRECOGNIZED
    }

}

internal fun Causality.protoType(): Proto.Causality {

    return when (this) {
        Causality.INPUT -> Proto.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> Proto.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> Proto.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> Proto.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> Proto.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> Proto.Causality.INDEPENDENT_CAUSALITY
        else -> Proto.Causality.UNRECOGNIZED
    }

}

internal fun Variability.protoType(): Proto.Variability {

    return when (this) {
        Variability.CONSTANT -> Proto.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> Proto.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> Proto.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> Proto.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> Proto.Variability.TUNABLE_VARIABILITY
        else -> Proto.Variability.UNRECOGNIZED
    }

}

internal fun Initial.protoType(): Proto.Initial {

    return when (this) {
        Initial.CALCULATED ->  Proto.Initial.CALCULATED_INITIAL
        Initial.EXACT ->  Proto.Initial.EXACT_INITIAL
        Initial.APPROX ->  Proto.Initial.APPROX_INITIAL
        else ->  Proto.Initial.UNRECOGNIZED
    }

}
