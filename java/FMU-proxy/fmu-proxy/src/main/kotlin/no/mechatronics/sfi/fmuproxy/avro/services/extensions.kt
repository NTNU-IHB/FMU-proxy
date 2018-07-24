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

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Causality
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Initial
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Variability
import no.mechatronics.sfi.fmuproxy.avro.*
import no.mechatronics.sfi.fmuproxy.avro.ScalarVariable

internal fun FmuIntegerRead.avroType()
        = IntegerRead(value, status.avroType())

internal fun FmuRealRead.avroType()
        = RealRead(value, status.avroType())

internal fun FmuStringRead.avroType()
        = StringRead(value, status.avroType())

internal fun FmuBooleanRead.avroType()
        = BooleanRead(value, status.avroType())

internal fun FmuIntegerArrayRead.avroType()
        = BulkIntegerRead(value.toList(), status.avroType())

internal fun FmuRealArrayRead.avroType()
        = BulkRealRead(value.toList(), status.avroType())

internal fun FmuStringArrayRead.avroType()
        = BulkStringRead(value.toList(), status.avroType())

internal fun FmuBooleanArrayRead.avroType()
        = BulkBooleanRead(value.toList(), status.avroType())

internal fun IntegerVariable.avroType(): no.mechatronics.sfi.fmuproxy.avro.IntegerAttribute {
    return no.mechatronics.sfi.fmuproxy.avro.IntegerAttribute().also { attribute ->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
    }
}

internal fun RealVariable.avroType(): no.mechatronics.sfi.fmuproxy.avro.RealAttribute {
    return no.mechatronics.sfi.fmuproxy.avro.RealAttribute().also { attribute ->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
    }
}

internal fun StringVariable.avroType(): no.mechatronics.sfi.fmuproxy.avro.StringAttribute {
    return no.mechatronics.sfi.fmuproxy.avro.StringAttribute().also { attribute ->
        start?.also { attribute.start = it }
    }
}

internal fun BooleanVariable.avroType(): no.mechatronics.sfi.fmuproxy.avro.BooleanAttribute {
    return no.mechatronics.sfi.fmuproxy.avro.BooleanAttribute().also { attribute ->
        start?.also { attribute.start = it }
    }
}

internal fun EnumerationVariable.avroType(): no.mechatronics.sfi.fmuproxy.avro.EnumerationAttribute {
    return no.mechatronics.sfi.fmuproxy.avro.EnumerationAttribute().also { attribute ->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
    }
}

internal fun TypedScalarVariable<*>.avroType(): ScalarVariable {
    return no.mechatronics.sfi.fmuproxy.avro.ScalarVariable().also { v ->
        v.name = name
        v.valueReference = valueReference
        v.declaredType = declaredType
        description?.also { v.description = it }
        causality?.also { v.causality = it.avroType() }
        variability?.also { v.variability = it.avroType() }
        initial?.also { v.initial = it.avroType() }

        when (this) {
            is IntegerVariable -> v.attribute = this.avroType()
            is RealVariable -> v.attribute = this.avroType()
            is StringVariable -> v.attribute = this.avroType()
            is BooleanVariable -> v.attribute = this.avroType()
            is EnumerationVariable -> v.attribute = this.avroType()
            else -> throw AssertionError()
        }

    }
}

internal fun ModelVariables.avroType(): List<ScalarVariable> {
    return map { it.avroType() }
}

internal fun Unknown.avroType(): no.mechatronics.sfi.fmuproxy.avro.Unknown {
    return no.mechatronics.sfi.fmuproxy.avro.Unknown().also { u ->
        u.index = index
        u.dependencies = dependencies
        dependenciesKind?.also { u.dependenciesKind = it.avroType() }
    }
}

internal fun ModelStructure.avroType(): no.mechatronics.sfi.fmuproxy.avro.ModelStructure {
    return no.mechatronics.sfi.fmuproxy.avro.ModelStructure().also { ms ->
        ms.outputs = outputs.map { it.avroType() }
        ms.derivatives = derivatives.map { it.avroType() }
        ms.initialUnknowns = initialUnknowns.map { it.avroType() }
    }
}

fun DefaultExperiment.avroType(): no.mechatronics.sfi.fmuproxy.avro.DefaultExperiment {
    return no.mechatronics.sfi.fmuproxy.avro.DefaultExperiment().also {
        it.startTime = startTime
        it.stopTime = stopTime
        it.tolerance = tolerance
        it.stepSize = stepSize
    }
}

internal fun CommonModelDescription.avroType(): ModelDescription {
    return ModelDescription().also { md ->

        md.guid = guid
        md.modelName = modelName
        md.fmiVersion = fmiVersion
        md.modelVariables = modelVariables.avroType()
        md.modelStructure = modelStructure.avroType()

        version?.also { md.version = it }
        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.author = it }
        description?.also { md.description = it }
        generationTool?.also { md.generationTool = it }
        generationDateAndTime?.also { md.generationDateAndTime = it }
        defaultExperiment?.also { md.defaultExperiment = it.avroType() }

    }
}

internal fun Causality.avroType(): no.mechatronics.sfi.fmuproxy.avro.Causality {
    return when(this) {
        Causality.INPUT -> no.mechatronics.sfi.fmuproxy.avro.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> no.mechatronics.sfi.fmuproxy.avro.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> no.mechatronics.sfi.fmuproxy.avro.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> no.mechatronics.sfi.fmuproxy.avro.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> no.mechatronics.sfi.fmuproxy.avro.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> no.mechatronics.sfi.fmuproxy.avro.Causality.INDEPENDENT_CAUSALITY
        else -> throw IllegalArgumentException()
    }
}

internal fun Variability.avroType(): no.mechatronics.sfi.fmuproxy.avro.Variability {
    return when(this) {
        Variability.CONSTANT -> no.mechatronics.sfi.fmuproxy.avro.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> no.mechatronics.sfi.fmuproxy.avro.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> no.mechatronics.sfi.fmuproxy.avro.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> no.mechatronics.sfi.fmuproxy.avro.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> no.mechatronics.sfi.fmuproxy.avro.Variability.TUNABLE_VARIABILITY
        else -> throw IllegalArgumentException()
    }
}

internal fun Initial.avroType(): no.mechatronics.sfi.fmuproxy.avro.Initial {
    return when(this) {
        Initial.CALCULATED -> no.mechatronics.sfi.fmuproxy.avro.Initial.CALCULATED_INITIAL
        Initial.EXACT -> no.mechatronics.sfi.fmuproxy.avro.Initial.EXACT_INITIAL
        Initial.APPROX -> no.mechatronics.sfi.fmuproxy.avro.Initial.APPROX_INITIAL
        else -> throw IllegalArgumentException()
    }
}

internal fun DependenciesKind.avroType(): no.mechatronics.sfi.fmuproxy.avro.DependenciesKind {
    return when(this) {
        DependenciesKind.DEPENDENT -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.DEPENDENT_KIND
        DependenciesKind.CONSTANT -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.CONSTANT_KIND
        DependenciesKind.TUNABLE -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.TUNABLE_KIND
        DependenciesKind.DISCRETE -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.DISCRETE_KIND
        else -> throw IllegalArgumentException()
    }
}

internal fun FmiStatus.avroType(): Status {
    return when (this) {
        FmiStatus.OK -> Status.OK_STATUS
        FmiStatus.Warning -> Status.WARNING_STATUS
        FmiStatus.Discard -> Status.DISCARD_STATUS
        FmiStatus.Error -> Status.ERROR_STATUS
        FmiStatus.Fatal -> Status.FATAL_STATUS
        FmiStatus.Pending -> Status.PENDING_STATUS
        FmiStatus.NONE -> throw RuntimeException()
    }
}
