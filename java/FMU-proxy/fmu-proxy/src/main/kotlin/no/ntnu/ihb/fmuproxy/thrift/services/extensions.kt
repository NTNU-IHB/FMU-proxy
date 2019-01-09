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

package no.ntnu.ihb.fmuproxy.thrift.services

import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.modeldescription.misc.DefaultExperiment
import no.ntnu.ihb.fmi4j.modeldescription.structure.ModelStructure
import no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
import no.ntnu.ihb.fmi4j.modeldescription.variables.Causality
import no.ntnu.ihb.fmi4j.modeldescription.variables.Initial
import no.ntnu.ihb.fmi4j.modeldescription.variables.Variability
import no.ntnu.ihb.fmuproxy.thrift.*
import no.ntnu.ihb.fmuproxy.thrift.ScalarVariable

internal fun IntegerVariable.thriftType(): no.ntnu.ihb.fmuproxy.thrift.IntegerAttribute {
    return no.ntnu.ihb.fmuproxy.thrift.IntegerAttribute().also { attribute->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
        quantity?.also { attribute.quantity = quantity }
    }
}

internal fun RealVariable.thriftType(): no.ntnu.ihb.fmuproxy.thrift.RealAttribute {
    return no.ntnu.ihb.fmuproxy.thrift.RealAttribute().also { attribute->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
        quantity?.also { attribute.quantity = quantity }
    }
}

internal fun StringVariable.thriftType(): no.ntnu.ihb.fmuproxy.thrift.StringAttribute {
    return no.ntnu.ihb.fmuproxy.thrift.StringAttribute().also { attribute ->
        start?.also { attribute.start = it }
    }
}

internal fun BooleanVariable.thriftType(): no.ntnu.ihb.fmuproxy.thrift.BooleanAttribute {
    return no.ntnu.ihb.fmuproxy.thrift.BooleanAttribute().also { attribute ->
        start?.also { attribute.isStart = it }
    }
}

internal fun EnumerationVariable.thriftType(): no.ntnu.ihb.fmuproxy.thrift.EnumerationAttribute {
    return no.ntnu.ihb.fmuproxy.thrift.EnumerationAttribute().also { attribute->
        min?.also { attribute.min = it }
        max?.also { attribute.max = it }
        start?.also { attribute.start = it }
        quantity?.also { attribute.quantity = quantity }
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

internal fun DefaultExperiment.thriftType(): no.ntnu.ihb.fmuproxy.thrift.DefaultExperiment {
    return no.ntnu.ihb.fmuproxy.thrift.DefaultExperiment(startTime, stopTime, tolerance, stepSize)
}

internal fun Unknown.thriftType(): no.ntnu.ihb.fmuproxy.thrift.Unknown {
    return no.ntnu.ihb.fmuproxy.thrift.Unknown().also { u ->
        u.index = index
        u.dependencies = dependencies
        dependenciesKind?.also { u.dependenciesKind = it }
    }
}

internal fun ModelStructure.thriftType(): no.ntnu.ihb.fmuproxy.thrift.ModelStructure {
    return no.ntnu.ihb.fmuproxy.thrift.ModelStructure().also { ms ->
        ms.outputs = outputs.map { it.thriftType() }
        ms.derivatives = derivatives.map { it.thriftType() }
        ms.initialUnknowns = initialUnknowns.map { it.thriftType() }
    }
}

internal fun no.ntnu.ihb.fmi4j.modeldescription.ModelDescription.thriftType(): ModelDescription {
    return ModelDescription().also { md ->

        md.guid = guid
        md.modelName = modelName
        md.fmiVersion = fmiVersion
        md.modelVariables = modelVariables.thriftType()
        md.modelStructure = modelStructure.thriftType()

        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.author = it }
        version?.also { md.version = it }
        description?.also { md.description = it }
        generationTool?.also { md.generationTool = it }
        generationDateAndTime?.also { md.generationDateAndTime = it }
        defaultExperiment?.also { md.defaultExperiment = it.thriftType() }
        variableNamingConvention?.also { md.variableNamingConvention = it }

    }
}

internal fun no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes.thriftType(): CoSimulationAttributes {
    return CoSimulationAttributes().also { a ->

        a.isCanHandleVariableCommunicationStepSize = canHandleVariableCommunicationStepSize
        a.isCanInterpolateInputs = canInterpolateInputs
        a.maxOutputDerivativeOrder = maxOutputDerivativeOrder

        a.modelIdentifier = modelIdentifier
        a.isCanGetAndSetFMUstate = canGetAndSetFMUstate
        a.isCanSerializeFMUstate = canSerializeFMUstate
        a.isProvidesDirectionalDerivative = providesDirectionalDerivative
    }
}

internal fun Causality.thriftType(): no.ntnu.ihb.fmuproxy.thrift.Causality {
    return when(this) {
        Causality.INPUT -> no.ntnu.ihb.fmuproxy.thrift.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> no.ntnu.ihb.fmuproxy.thrift.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> no.ntnu.ihb.fmuproxy.thrift.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> no.ntnu.ihb.fmuproxy.thrift.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> no.ntnu.ihb.fmuproxy.thrift.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> no.ntnu.ihb.fmuproxy.thrift.Causality.INDEPENDENT_CAUSALITY
        else ->  no.ntnu.ihb.fmuproxy.thrift.Causality.UNKNOWN_CAUSALITY
    }
}

internal fun Variability.thriftType(): no.ntnu.ihb.fmuproxy.thrift.Variability {
    return when(this) {
        Variability.CONSTANT -> no.ntnu.ihb.fmuproxy.thrift.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> no.ntnu.ihb.fmuproxy.thrift.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> no.ntnu.ihb.fmuproxy.thrift.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> no.ntnu.ihb.fmuproxy.thrift.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> no.ntnu.ihb.fmuproxy.thrift.Variability.TUNABLE_VARIABILITY
        else -> no.ntnu.ihb.fmuproxy.thrift.Variability.UNKNOWN_VARIABILITY
    }
}

internal fun Initial.thriftType(): no.ntnu.ihb.fmuproxy.thrift.Initial {
    return when(this) {
        Initial.CALCULATED -> no.ntnu.ihb.fmuproxy.thrift.Initial.CALCULATED_INITIAL
        Initial.EXACT -> no.ntnu.ihb.fmuproxy.thrift.Initial.EXACT_INITIAL
        Initial.APPROX -> no.ntnu.ihb.fmuproxy.thrift.Initial.APPROX_INITIAL
        else ->no.ntnu.ihb.fmuproxy.thrift.Initial.UNKNOWN_INITIAL
    }
}

internal fun FmiStatus.thriftType(): Status {
    return when (this) {
        FmiStatus.OK -> Status.OK_STATUS
        FmiStatus.Warning -> Status.WARNING_STATUS
        FmiStatus.Discard -> Status.DISCARD_STATUS
        FmiStatus.Error -> Status.ERROR_STATUS
        FmiStatus.Fatal -> Status.FATAL_STATUS
        FmiStatus.Pending -> Status.PENDING_STATUS
        FmiStatus.NONE -> throw RuntimeException("Not a valid status: $this")
    }
}
