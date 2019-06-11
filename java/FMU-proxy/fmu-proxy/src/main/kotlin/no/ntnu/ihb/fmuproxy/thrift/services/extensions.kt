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

import no.ntnu.ihb.fmi4j.FmiStatus
import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment
import no.ntnu.ihb.fmi4j.modeldescription.ModelStructure
import no.ntnu.ihb.fmi4j.modeldescription.Unknown
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
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
        causality?.also { v.causality = it.name.toLowerCase() }
        variability?.also { v.variability = it.name.toLowerCase() }
        initial?.also { v.initial = it.name.toLowerCase() }

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
        u.dependenciesKind = dependenciesKind
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
        a.isCanGetAndSetFmuState = canGetAndSetFMUstate
        a.isCanSerializeFmuState = canSerializeFMUstate
        a.isProvidesDirectionalDerivative = providesDirectionalDerivative
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
