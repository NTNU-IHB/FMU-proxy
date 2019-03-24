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

package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.modeldescription.LogCategories
import no.ntnu.ihb.fmi4j.modeldescription.SourceFiles
import no.ntnu.ihb.fmi4j.modeldescription.TypeDefinitions
import no.ntnu.ihb.fmi4j.modeldescription.UnitDefinitions
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonScalarVariable
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
import no.ntnu.ihb.fmi4j.modeldescription.variables.Causality
import no.ntnu.ihb.fmi4j.modeldescription.variables.Initial
import no.ntnu.ihb.fmi4j.modeldescription.variables.Variability
import no.ntnu.ihb.fmuproxy.Solver

internal fun Status.convert(): FmiStatus {
    return when (this) {
        Status.OK_STATUS -> FmiStatus.OK
        Status.DISCARD_STATUS -> FmiStatus.Discard
        Status.ERROR_STATUS -> FmiStatus.Error
        Status.WARNING_STATUS -> FmiStatus.Warning
        Status.PENDING_STATUS -> FmiStatus.Pending
        Status.FATAL_STATUS -> FmiStatus.Fatal
    }
}

internal fun IntegerRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(value.toIntArray(), status.convert())
}

internal fun RealRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(value.toDoubleArray(), status.convert())
}

internal fun StringRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(value.toTypedArray(), status.convert())
}


internal fun BooleanRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(value.toBooleanArray(), status.convert())
}

internal fun DefaultExperiment.convert(): no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment {
    return object : no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment {
        override val startTime: Double
            get() = this@convert.startTime
        override val stepSize: Double
            get() = this@convert.stepSize
        override val stopTime: Double
            get() = this@convert.stopTime
        override val tolerance: Double
            get() = this@convert.tolerance
    }
}

internal fun Unknown.convert(): no.ntnu.ihb.fmi4j.modeldescription.Unknown {
    return object : no.ntnu.ihb.fmi4j.modeldescription.Unknown {
        override val dependencies: List<Int>
            get() = getDependencies() ?: emptyList()
        override val dependenciesKind: List<String>
            get() = getDependenciesKind()
        override val index: Int
            get() = getIndex()
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.ModelStructure.convert(): no.ntnu.ihb.fmi4j.modeldescription.ModelStructure {
    return object : no.ntnu.ihb.fmi4j.modeldescription.ModelStructure {
        override val derivatives: List<no.ntnu.ihb.fmi4j.modeldescription.Unknown>
            get() = getDerivatives()?.map { it.convert() } ?: emptyList()
        override val initialUnknowns: List<no.ntnu.ihb.fmi4j.modeldescription.Unknown>
            get() = getInitialUnknowns()?.map { it.convert() } ?: emptyList()
        override val outputs: List<no.ntnu.ihb.fmi4j.modeldescription.Unknown>
            get() = getOutputs()?.map { it.convert() } ?: emptyList()
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.IntegerAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.IntegerAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.IntegerAttribute {
        override val declaredType: String?
            get() = null
        override val max: Int?
            get() = this@convert.max
        override val min: Int?
            get() = this@convert.min
        override val quantity: String?
            get() = this@convert.quantity
        override val start: Int?
            get() = this@convert.start
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.RealAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.RealAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.RealAttribute {
        override val declaredType: String?
            get() = null
        override val max: Double?
            get() = this@convert.max
        override val min: Double?
            get() = this@convert.min
        override val quantity: String?
            get() = this@convert.quantity
        override val start: Double?
            get() = this@convert.start
        override val derivative: Int?
            get() = null
        override val displayUnit: String?
            get() = null
        override val nominal: Double?
            get() = null
        override val reinit: Boolean
            get() = false
        override val relativeQuantity: Boolean?
            get() = null
        override val unbounded: Boolean?
            get() = null
        override val unit: String?
            get() = null
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.StringAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.StringAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.StringAttribute {
        override val declaredType: String?
            get() = null
        override val start: String?
            get() = this@convert.start
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.BooleanAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.BooleanAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.BooleanAttribute {
        override val declaredType: String?
            get() = null
        override val start: Boolean?
            get() = this@convert.isStart
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.EnumerationAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.EnumerationAttribute {
    return object: no.ntnu.ihb.fmi4j.modeldescription.variables.EnumerationAttribute {
        override val declaredType: String?
            get() = null
        override val max: Int?
            get() = this@convert.max
        override val min: Int?
            get() = this@convert.min
        override val quantity: String?
            get() = this@convert.quantity
        override val start: Int?
            get() = this@convert.start
    }
}

internal fun ScalarVariable.convert(): TypedScalarVariable<*> {

    val v = JacksonScalarVariable(
            name = name,
            description = description,
            valueReference = valueReference,
            causality = causality?.let { Causality.valueOf(it.toUpperCase()) },
            variability = variability?.let { Variability.valueOf(it.toUpperCase()) },
            initial = initial?.let { Initial.valueOf(it.toUpperCase()) }
    )

    return when {
        attribute.isSetIntegerAttribute -> attribute.integerAttribute.convert().let { IntegerVariable(v, it) }
        attribute.isSetRealAttribute ->  attribute.realAttribute.convert().let { RealVariable(v, it) }
        attribute.isSetStringAttribute -> attribute.stringAttribute.convert().let { StringVariable(v, it) }
        attribute.isSetBooleanAttribute -> attribute.booleanAttribute.convert().let { BooleanVariable(v, it) }
        attribute.isSetEnumerationAttribute -> attribute.enumerationAttribute.convert().let { EnumerationVariable(v, it) }
        else -> throw AssertionError("All attributes are null!")
    }

}

class MyModelVariables(
        vars: List<ScalarVariable>
) : ModelVariables {

    private val variables = vars.map { it.convert() }

    override fun getVariables(): List<TypedScalarVariable<*>> {
        return variables
    }

}

internal fun List<ScalarVariable>.convert(): ModelVariables {
    return MyModelVariables(this)
}

internal fun ModelDescription.convert(): no.ntnu.ihb.fmi4j.modeldescription.ModelDescription {
    return ThriftModelDescription(this)
}

internal fun CoSimulationAttributes.convert(): no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes {

    return object : no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes {

        override val canBeInstantiatedOnlyOncePerProcess: Boolean
            get() = false
        override val canGetAndSetFMUstate: Boolean
            get() = this@convert.isCanGetAndSetFmuState
        override val canNotUseMemoryManagementFunctions: Boolean
            get() = false
        override val canSerializeFMUstate: Boolean
            get() = this@convert.isSetCanSerializeFmuState
        override val modelIdentifier: String
            get() = this@convert.modelIdentifier
        override val needsExecutionTool: Boolean
            get() = false
        override val providesDirectionalDerivative: Boolean
            get() = this@convert.isProvidesDirectionalDerivative
        override val sourceFiles: SourceFiles
            get() = emptyList()

        override val canHandleVariableCommunicationStepSize: Boolean
            get() = this@convert.isCanHandleVariableCommunicationStepSize
        override val canInterpolateInputs: Boolean
            get() = this@convert.isCanInterpolateInputs
        override val canRunAsynchronuously: Boolean
            get() = false
        override val maxOutputDerivativeOrder: Int
            get() = this@convert.maxOutputDerivativeOrder

    }
}

class ThriftModelDescription(
        private val modelDescription: ModelDescription
) : no.ntnu.ihb.fmi4j.modeldescription.ModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment?
            = modelDescription.defaultExperiment?.convert()
    override val description: String?
        get() = modelDescription.description
    override val fmiVersion: String
        get() = modelDescription.fmiVersion
    override val generationDateAndTime: String?
        get() = modelDescription.generationDateAndTime
    override val generationTool: String?
        get() = modelDescription.generationTool
    override val guid: String
        get() = modelDescription.guid
    override val license: String?
        get() = modelDescription.license
    override val logCategories: LogCategories?
        get() = null
    override val typeDefinitions: TypeDefinitions?
        get() = null
    override val unitDefinitions: UnitDefinitions?
        get() = null
    override val modelName: String
        get() = modelDescription.modelName
    override val modelStructure: no.ntnu.ihb.fmi4j.modeldescription.ModelStructure
            = modelDescription.modelStructure.convert()
    override val modelVariables: ModelVariables
            = modelDescription.modelVariables.convert()
    override val variableNamingConvention: String?
            = modelDescription.variableNamingConvention
    override val version: String?
        get() = modelDescription.version

}

fun Solver.thriftType(): no.ntnu.ihb.fmuproxy.thrift.Solver {
    return no.ntnu.ihb.fmuproxy.thrift.Solver(name, settings)
}