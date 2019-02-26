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

package no.ntnu.ihb.fmuproxy.grpc

import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.modeldescription.*
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonScalarVariable
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
import no.ntnu.ihb.fmuproxy.Solver


internal fun Service.StatusResponse.convert(): FmiStatus {
    return status.convert()
}

internal fun Service.Status.convert(): FmiStatus {
    return when(this) {
        Service.Status.OK_STATUS -> FmiStatus.OK
        Service.Status.DISCARD_STATUS -> FmiStatus.Discard
        Service.Status.ERROR_STATUS -> FmiStatus.Error
        Service.Status.WARNING_STATUS -> FmiStatus.Warning
        Service.Status.PENDING_STATUS -> FmiStatus.Pending
        Service.Status.FATAL_STATUS -> FmiStatus.Fatal
        Service.Status.UNRECOGNIZED -> throw AssertionError("Fatal: Unrecognized status type: $this")
    }
}
internal fun Service.IntegerRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(valuesList.toIntArray(), status.convert())
}

internal fun Service.RealRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(valuesList.toDoubleArray(), status.convert())
}

internal fun Service.StringRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(valuesList.toTypedArray(), status.convert())
}

internal fun Service.BooleanRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(valuesList.toBooleanArray(), status.convert())
}

internal fun Service.DefaultExperiment.convert(): DefaultExperiment {
    return object: DefaultExperiment{
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


internal fun Service.Unknown.convert(): Unknown {
    return object: Unknown {
        override val index: Int
            get() = getIndex()
        override val dependencies: List<Int>
            get() = dependenciesList
        override val dependenciesKind: List<String>
            get() = dependenciesKindList
    }
}

internal fun Service.ModelStructure.convert(): ModelStructure {
    return object: ModelStructure {
        override val derivatives: List<Unknown>
            get() = derivativesList?.map { it.convert() } ?: emptyList()
        override val initialUnknowns: List<Unknown>
            get() = initialUnknownsList?.map { it.convert() } ?: emptyList()
        override val outputs: List<Unknown>
            get() = outputsList?.map { it.convert() } ?: emptyList()
    }
}

internal fun Service.IntegerAttribute.convert(): IntegerAttribute {
    return object: IntegerAttribute {
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

internal fun Service.RealAttribute.convert(): RealAttribute {
    return object: RealAttribute {
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

internal fun Service.StringAttribute.convert(): StringAttribute {
    return object: StringAttribute {
        override val declaredType: String?
            get() = null
        override val start: String?
            get() = this@convert.start
    }
}

internal fun Service.BooleanAttribute.convert(): BooleanAttribute {
    return object: BooleanAttribute {
        override val declaredType: String?
            get() = null
        override val start: Boolean?
            get() = this@convert.start
    }
}

internal fun Service.EnumerationAttribute.convert(): EnumerationAttribute {
    return object: EnumerationAttribute {
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

internal fun Service.ScalarVariable.convert(): TypedScalarVariable<*> {

    val v = object: ScalarVariable {
        override val causality: Causality?
            get() = this@convert.causality?.let { Causality.valueOf(it.toUpperCase()) }
        override val description: String?
            get() = this@convert.description
        override val initial: Initial?
            get() = this@convert.initial?.let { Initial.valueOf(it.toUpperCase()) }
        override val name: String
            get() = this@convert.name
        override val valueReference: Long
            get() = this@convert.valueReference
        override val variability: Variability?
            get() = this@convert.variability?.let { Variability.valueOf(it.toUpperCase()) }
    }

    return when(attributeCase) {
        Service.ScalarVariable.AttributeCase.INTEGER_ATTRIBUTE -> integerAttribute.convert().let { IntegerVariable(v, it) }
        Service.ScalarVariable.AttributeCase.REAL_ATTRIBUTE -> realAttribute.convert().let { RealVariable(v, it) }
        Service.ScalarVariable.AttributeCase.STRING_ATTRIBUTE -> stringAttribute.convert().let { StringVariable(v, it) }
        Service.ScalarVariable.AttributeCase.BOOLEAN_ATTRIBUTE -> booleanAttribute.convert().let { BooleanVariable(v, it) }
        Service.ScalarVariable.AttributeCase.ENUMERATION_ATTRIBUTE -> enumerationAttribute.convert().let { EnumerationVariable(v, it) }
        else -> throw AssertionError("Fatal: Not a valid attribute: $attributeCase")
    }

}

class MyModelVariables(
        vars: List<Service.ScalarVariable>
) : ModelVariables {

    private val variables = vars.map { it.convert() }

    override fun getVariables(): List<TypedScalarVariable<*>> {
        return variables
    }

}

internal fun List<Service.ScalarVariable>.convert(): ModelVariables {
    return MyModelVariables(this)
}

internal fun Service.ModelDescription.convert(): ModelDescription {
    return GrpcModelDescription(this)
}

internal fun Service.CoSimulationAttributes.convert(): CoSimulationAttributes {

    return object: CoSimulationAttributes {

        override val canBeInstantiatedOnlyOncePerProcess: Boolean
            get() = false
        override val canGetAndSetFMUstate: Boolean
            get() = this@convert.canGetAndSetFMUstate
        override val canNotUseMemoryManagementFunctions: Boolean
            get() = false
        override val canSerializeFMUstate: Boolean
            get() = this@convert.canSerializeFMUstate
        override val modelIdentifier: String
            get() = this@convert.modelIdentifier
        override val needsExecutionTool: Boolean
            get() = false
        override val providesDirectionalDerivative: Boolean
            get() = this@convert.providesDirectionalDerivative
        override val sourceFiles: SourceFiles
            get() = emptyList()

        override val canHandleVariableCommunicationStepSize: Boolean
            get() = this@convert.canHandleVariableCommunicationStepSize
        override val canInterpolateInputs: Boolean
            get() = this@convert.canInterpolateInputs
        override val canRunAsynchronuously: Boolean
            get() = false
        override val maxOutputDerivativeOrder: Int
            get() = this@convert.maxOutputDerivativeOrder
    }

}

class GrpcModelDescription(
        private val modelDescription: Service.ModelDescription
): ModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: DefaultExperiment? =  modelDescription.defaultExperiment?.convert()
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
    override val modelStructure: ModelStructure = modelDescription.modelStructure.convert()
    override val modelVariables: ModelVariables = modelDescription.modelVariablesList.convert()
    override val variableNamingConvention: String? = modelDescription.variableNamingConvention
    override val version: String?
        get() = modelDescription.version
}

fun Solver.protoType(): Service.Solver {
    return Service.Solver.newBuilder()
            .setName(name)
            .setSettings(settings)
            .build()
}