package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.FmiStatus
import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment
import no.ntnu.ihb.fmi4j.modeldescription.ModelStructure
import no.ntnu.ihb.fmi4j.modeldescription.Unknown
import no.ntnu.ihb.fmi4j.modeldescription.variables.*

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

internal fun no.ntnu.ihb.fmi4j.modeldescription.CoSimulationModelDescription.thriftType(): ModelDescription {
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

        md.isCanHandleVariableCommunicationStepSize = attributes.canHandleVariableCommunicationStepSize
        md.isCanInterpolateInputs = attributes.canInterpolateInputs
        md.maxOutputDerivativeOrder = attributes.maxOutputDerivativeOrder

        md.modelIdentifier = attributes.modelIdentifier
        md.isCanGetAndSetFmuState = attributes.canGetAndSetFMUstate
        md.isCanSerializeFmuState = attributes.canSerializeFMUstate
        md.isProvidesDirectionalDerivative = attributes.providesDirectionalDerivative

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
