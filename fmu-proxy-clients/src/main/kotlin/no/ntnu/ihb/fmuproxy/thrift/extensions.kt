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

import no.ntnu.ihb.fmi4j.*
import no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
import no.ntnu.ihb.fmi4j.modeldescription.LogCategories
import no.ntnu.ihb.fmi4j.modeldescription.TypeDefinitions
import no.ntnu.ihb.fmi4j.modeldescription.UnitDefinitions
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
import no.ntnu.ihb.fmi4j.modeldescription.variables.Causality
import no.ntnu.ihb.fmi4j.modeldescription.variables.Variability

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

internal fun IntegerRead.convert(): IntegerArrayRead {
    return IntegerArrayRead(value.toIntArray(), status.convert())
}

internal fun RealRead.convert(): RealArrayRead {
    return RealArrayRead(value.toDoubleArray(), status.convert())
}

internal fun StringRead.convert(): StringArrayRead {
    return StringArrayRead(value.toTypedArray(), status.convert())
}

internal fun BooleanRead.convert(): BooleanArrayRead {
    return BooleanArrayRead(value.toBooleanArray(), status.convert())
}

internal fun DefaultExperiment.convert(): no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment {
    return no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment(
            startTime = this@convert.startTime,
            stepSize = this@convert.stepSize,
            stopTime = this@convert.stopTime,
            tolerance = this@convert.tolerance
    )
}

internal fun Unknown.convert(): no.ntnu.ihb.fmi4j.modeldescription.Unknown {
    return no.ntnu.ihb.fmi4j.modeldescription.Unknown(
            index = index,
            dependencies = dependencies ?: emptyList(),
            dependenciesKind = dependenciesKind ?: emptyList()
    )
}

internal fun ModelStructure.convert(): no.ntnu.ihb.fmi4j.modeldescription.ModelStructure {
    return no.ntnu.ihb.fmi4j.modeldescription.ModelStructure(
            outputs = outputs?.map { it.convert() } ?: emptyList(),
            derivatives = derivatives?.map { it.convert() } ?: emptyList(),
            initialUnknowns = initialUnknowns?.map { it.convert() } ?: emptyList()

    )
}

internal fun IntegerAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.IntegerAttribute {
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

internal fun RealAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.RealAttribute {
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
        override val relativeQuantity: Boolean
            get() = false
        override val unbounded: Boolean
            get() = false
        override val unit: String?
            get() = null
    }
}

internal fun StringAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.StringAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.StringAttribute {
        override val declaredType: String?
            get() = null
        override val start: String?
            get() = this@convert.start
    }
}

internal fun BooleanAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.BooleanAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.BooleanAttribute {
        override val declaredType: String?
            get() = null
        override val start: Boolean?
            get() = this@convert.isStart
    }
}

internal fun EnumerationAttribute.convert(): no.ntnu.ihb.fmi4j.modeldescription.variables.EnumerationAttribute {
    return object : no.ntnu.ihb.fmi4j.modeldescription.variables.EnumerationAttribute {
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

    val v = object : no.ntnu.ihb.fmi4j.modeldescription.variables.ScalarVariable {
        override val name: String
            get() = this@convert.name
        override val valueReference: Long
            get() = this@convert.valueReference
        override val description: String?
            get() = this@convert.description
        override val causality: Causality?
            get() = this@convert.causality?.let { Causality.valueOf(it.toUpperCase()) }
        override val variability: Variability?
            get() = this@convert.variability?.let { Variability.valueOf(it.toUpperCase()) }
        override val initial: Initial?
            get() = this@convert.initial?.let { Initial.valueOf(it.toUpperCase()) }
        override val type: VariableType
            get() = when {
                attribute.isSetIntegerAttribute -> VariableType.INTEGER
                attribute.isSetRealAttribute -> VariableType.REAL
                attribute.isSetStringAttribute -> VariableType.STRING
                attribute.isSetBooleanAttribute -> VariableType.BOOLEAN
                attribute.isSetEnumerationAttribute -> VariableType.ENUMERATION
                else -> throw AssertionError("All attributes are null!")
            }
    }

    return when (v.type) {
        VariableType.INTEGER -> attribute.integerAttribute.convert().let { IntegerVariable(v, it) }
        VariableType.REAL -> attribute.realAttribute.convert().let { RealVariable(v, it) }
        VariableType.STRING -> attribute.stringAttribute.convert().let { StringVariable(v, it) }
        VariableType.BOOLEAN -> attribute.booleanAttribute.convert().let { BooleanVariable(v, it) }
        VariableType.ENUMERATION -> attribute.enumerationAttribute.convert().let { EnumerationVariable(v, it) }
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

internal fun ModelDescription.convert(): no.ntnu.ihb.fmi4j.modeldescription.CoSimulationModelDescription {
    return ThriftModelDescription(this)
}


class ThriftModelDescription(
        private val modelDescription: ModelDescription
) : no.ntnu.ihb.fmi4j.modeldescription.CoSimulationModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment? = modelDescription.defaultExperiment?.convert()
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
    override val modelStructure: no.ntnu.ihb.fmi4j.modeldescription.ModelStructure = modelDescription.modelStructure.convert()
    override val modelVariables: ModelVariables = modelDescription.modelVariables.convert()
    override val variableNamingConvention: String? = modelDescription.variableNamingConvention
    override val version: String?
        get() = modelDescription.version

    override val attributes: CoSimulationAttributes
        get() = CoSimulationAttributes(
                needsExecutionTool = false,
                canRunAsynchronuously = false,
                maxOutputDerivativeOrder = 0,
                canNotUseMemoryManagementFunctions = false,
                canBeInstantiatedOnlyOncePerProcess = false,

                sourceFiles = emptyList(),
                modelIdentifier = modelDescription.modelIdentifier,
                canGetAndSetFMUstate = modelDescription.isCanGetAndSetFmuState,
                canSerializeFMUstate = modelDescription.isCanSerializeFmuState,
                canInterpolateInputs = modelDescription.isCanInterpolateInputs,
                providesDirectionalDerivative = modelDescription.isProvidesDirectionalDerivative,
                canHandleVariableCommunicationStepSize = modelDescription.isCanHandleVariableCommunicationStepSize

        )

}
