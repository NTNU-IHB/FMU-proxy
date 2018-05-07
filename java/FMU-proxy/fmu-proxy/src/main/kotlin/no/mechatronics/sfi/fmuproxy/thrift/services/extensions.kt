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
import no.mechatronics.sfi.fmuproxy.thrift.*
import no.mechatronics.sfi.fmuproxy.thrift.ScalarVariable

internal fun FmuIntegerRead.thriftType()
        = IntRead(value, StatusCode.findByValue(status.code))

internal fun FmuRealRead.thriftType()
        = RealRead(value, StatusCode.findByValue(status.code))

internal fun FmuStringRead.thriftType()
        = StringRead(value, StatusCode.findByValue(status.code))

internal fun FmuBooleanRead.thriftType()
        = BoolRead(value, StatusCode.findByValue(status.code))

internal fun IntegerVariable.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.IntegerAttribute {
    return no.mechatronics.sfi.fmuproxy.thrift.IntegerAttribute().also { attribute->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
    }
}

internal fun RealVariable.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.RealAttribute {
    return no.mechatronics.sfi.fmuproxy.thrift.RealAttribute().also { attribute->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
    }
}

internal fun StringVariable.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.StringAttribute {
    return no.mechatronics.sfi.fmuproxy.thrift.StringAttribute().also { attribute ->
        start?.also { attribute.start = it }
    }
}

internal fun BooleanVariable.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.BooleanAttribute {
    return no.mechatronics.sfi.fmuproxy.thrift.BooleanAttribute().also { attribute ->
        start?.also { attribute.isStart = it }
    }
}

internal fun EnumerationVariable.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.EnumerationAttribute {
    return no.mechatronics.sfi.fmuproxy.thrift.EnumerationAttribute().also { attribute->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
    }
}

internal fun TypedScalarVariable<*>.thriftType(): ScalarVariable {
    return ScalarVariable().also { v ->

        v.name = name
        v.valueReference = valueReference
        description?.also { v.description = it }
        causality?.also { v.causality = it.thriftType() }
        variability?.also { v.variability = it.thriftType() }
        initial?.also { v.initial = it.thriftType() }

        v.attribute = ScalarVariableAttribute().also { attribute ->

            when (this) {
                is IntegerVariable -> attribute.integerAttribute = this.thriftType()
                is RealVariable -> attribute.realAttribute = this.thriftType()
                is StringVariable -> attribute.stringAttribute = this.thriftType()
                is BooleanVariable -> attribute.booleanAttribute = this.thriftType()
                is EnumerationVariable -> attribute.enumerationAttribute = this.thriftType()
                else -> throw AssertionError()
            }

        }


    }
}

internal fun ModelVariables.thriftType(): List<ScalarVariable> {
    return map { it.thriftType() }
}

internal fun DefaultExperiment.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.DefaultExperiment {
    return no.mechatronics.sfi.fmuproxy.thrift.DefaultExperiment(startTime, stopTime, tolerance, stepSize)
}

internal fun Unknown.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Unknown {
    return no.mechatronics.sfi.fmuproxy.thrift.Unknown().also { u ->
        u.index = index
        u.dependencies = dependencies
        dependenciesKind?.also { u.dependenciesKind = it.thriftType() }
    }
}

internal fun ModelStructure.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.ModelStructure {
    return no.mechatronics.sfi.fmuproxy.thrift.ModelStructure().also { ms ->
        ms.outputs = outputs.map { it.thriftType() }
        ms.derivatives = derivatives.map { it.thriftType() }
        ms.initialUnknowns = initialUnknowns.map { it.thriftType() }
    }
}

internal fun CommonModelDescription.thriftType(): ModelDescription {
    return ModelDescription().also { md ->

        md.guid = guid
        md.modelName = modelName
        md.fmiVersion = fmiVersion
        md.modelVariables = modelVariables.thriftType()
        md.modelStructure = modelStructure.thriftType()

        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.author = it }
        description?.also { md.description = it }
        generationTool?.also { md.generationTool = it }
        generationDateAndTime?.also { md.generationDateAndTime = it }
        defaultExperiment?.also { md.defaultExperiment = it.thriftType() }

    }
}

internal fun Causality.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Causality {
    return when(this) {
        Causality.INPUT -> no.mechatronics.sfi.fmuproxy.thrift.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> no.mechatronics.sfi.fmuproxy.thrift.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> no.mechatronics.sfi.fmuproxy.thrift.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> no.mechatronics.sfi.fmuproxy.thrift.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> no.mechatronics.sfi.fmuproxy.thrift.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> no.mechatronics.sfi.fmuproxy.thrift.Causality.INDEPENDENT_CAUSALITY
        else -> throw IllegalArgumentException()
    }
}

internal fun Variability.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Variability {
    return when(this) {
        Variability.CONSTANT -> no.mechatronics.sfi.fmuproxy.thrift.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> no.mechatronics.sfi.fmuproxy.thrift.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> no.mechatronics.sfi.fmuproxy.thrift.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> no.mechatronics.sfi.fmuproxy.thrift.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> no.mechatronics.sfi.fmuproxy.thrift.Variability.TUNABLE_VARIABILITY
        else -> throw IllegalArgumentException()
    }
}

internal fun Initial.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Initial {
    return when(this) {
        Initial.CALCULATED -> no.mechatronics.sfi.fmuproxy.thrift.Initial.CALCULATED_INITIAL
        Initial.EXACT -> no.mechatronics.sfi.fmuproxy.thrift.Initial.EXACT_INITIAL
        Initial.APPROX -> no.mechatronics.sfi.fmuproxy.thrift.Initial.APPROX_INITIAL
        else -> throw IllegalArgumentException()
    }
}

internal fun DependenciesKind.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind {
    return when(this) {
        DependenciesKind.DEPENDENT -> no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.DEPENDENT_KIND
        DependenciesKind.CONSTANT -> no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.CONSTANT_KIND
        DependenciesKind.TUNABLE -> no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.TUNABLE_KIND
        DependenciesKind.DISCRETE -> no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.DISCRETE_KIND
        else -> throw IllegalArgumentException()
    }
}

internal fun FmiStatus.thriftType(): StatusCode {
    return when (this) {
        FmiStatus.OK -> StatusCode.OK_STATUS
        FmiStatus.Warning -> StatusCode.WARNING_STATUS
        FmiStatus.Discard -> StatusCode.DISCARD_STATUS
        FmiStatus.Error -> StatusCode.ERROR_STATUS
        FmiStatus.Fatal -> StatusCode.FATAL_STATUS
        FmiStatus.Pending -> StatusCode.PENDING_STATUS
        FmiStatus.NONE -> throw RuntimeException()
    }
}

