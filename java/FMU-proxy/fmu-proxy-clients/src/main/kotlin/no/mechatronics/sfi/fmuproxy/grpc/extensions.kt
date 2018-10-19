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

package no.mechatronics.sfi.fmuproxy.grpc

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationAttributes
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.logging.LogCategories
import no.mechatronics.sfi.fmi4j.modeldescription.misc.*
import no.mechatronics.sfi.fmi4j.modeldescription.misc.Unit
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmuproxy.Solver


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

internal fun Service.Causality.convert(): Causality? {
    return when(this) {
        Service.Causality.CALCULATED_PARAMETER_CAUSALITY -> Causality.CALCULATED_PARAMETER
        Service.Causality.INDEPENDENT_CAUSALITY -> Causality.INDEPENDENT
        Service.Causality.INPUT_CAUSALITY -> Causality.INPUT
        Service.Causality.LOCAL_CAUSALITY -> Causality.LOCAL
        Service.Causality.OUTPUT_CAUSALITY -> Causality.OUTPUT
        Service.Causality.PARAMETER_CAUSALITY -> Causality.PARAMETER
        else -> null
    }
}

internal fun Service.Variability.convert(): Variability? {
    return when(this) {
        Service.Variability.CONSTANT_VARIABILITY -> Variability.CONSTANT
        Service.Variability.CONTINUOUS_VARIABILITY -> Variability.CONTINUOUS
        Service.Variability.DISCRETE_VARIABILITY -> Variability.DISCRETE
        Service.Variability.FIXED_VARIABILITY -> Variability.FIXED
        Service.Variability.TUNABLE_VARIABILITY -> Variability.TUNABLE
        else -> null
    }
}

internal fun Service.Initial.convert(): Initial? {
    return when(this) {
        Service.Initial.APPROX_INITIAL -> Initial.APPROX
        Service.Initial.CALCULATED_INITIAL -> Initial.CALCULATED
        Service.Initial.EXACT_INITIAL -> Initial.EXACT
        else -> null
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
    return DefaultExperiment(
            startTime = startTime,
            stopTime = stopTime,
            tolerance = tolerance,
            stepSize = stepSize
    )
}


internal fun Service.Unknown.convert(): Unknown {
    return object: Unknown {
        override val index: Int
            get() = getIndex()
        override val dependencies: List<Int>
            get() = dependenciesList
        override val dependenciesKind: String?
            get() = getDependenciesKind()
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

internal fun Service.IntegerAttribute.convert(): IntegerAttributeImpl {
    return IntegerAttributeImpl(
            min = min,
            max = max,
            start = start,
            quantity = quantity
    )
}

internal fun Service.RealAttribute.convert(): RealAttributeImpl {
    return RealAttributeImpl(
            min = min,
            max = max,
            start = start,
            quantity = quantity
    )
}

internal fun Service.StringAttribute.convert(): StringAttributeImpl {
    return StringAttributeImpl(
            start = start
    )
}

internal fun Service.BooleanAttribute.convert(): BooleanAttributeImpl {
    return BooleanAttributeImpl(
            start = start
    )
}

internal fun Service.EnumerationAttribute.convert(): EnumerationAttributeImpl {
    return EnumerationAttributeImpl(
            min = min,
            max = max,
            start = start,
            quantity = quantity
    )
}

internal fun Service.ScalarVariable.convert(): TypedScalarVariable<*> {

    val v = ScalarVariableImpl(
            name = name,
            description = description,
            valueReference = valueReference,
            causality = causality?.convert(),
            variability = variability?.convert(),
            initial = initial?.convert()
    )

    when(attributeCase) {
        Service.ScalarVariable.AttributeCase.INTEGER_ATTRIBUTE -> v.integerAttribute = integerAttribute.convert()
        Service.ScalarVariable.AttributeCase.REAL_ATTRIBUTE -> v.realAttribute = realAttribute.convert()
        Service.ScalarVariable.AttributeCase.STRING_ATTRIBUTE -> v.stringAttribute = stringAttribute.convert()
        Service.ScalarVariable.AttributeCase.BOOLEAN_ATTRIBUTE -> v.booleanAttribute = booleanAttribute.convert()
        Service.ScalarVariable.AttributeCase.ENUMERATION_ATTRIBUTE -> v.enumerationAttribute = enumerationAttribute.convert()
        else -> throw AssertionError("Fatal: Not a valid attribute: $attributeCase")
    }

    return v.toTyped()

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
        override val sourceFiles: List<SourceFile>
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
    override val typeDefinitions: List<SimpleType>?
        get() = null
    override val unitDefinitions: List<Unit>?
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