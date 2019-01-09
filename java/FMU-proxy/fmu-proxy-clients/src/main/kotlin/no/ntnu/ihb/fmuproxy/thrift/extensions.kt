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
import no.ntnu.ihb.fmi4j.modeldescription.logging.LogCategories
import no.ntnu.ihb.fmi4j.modeldescription.misc.*
import no.ntnu.ihb.fmi4j.modeldescription.structure.ModelStructure
import no.ntnu.ihb.fmi4j.modeldescription.variables.*
import no.ntnu.ihb.fmi4j.modeldescription.variables.Causality
import no.ntnu.ihb.fmi4j.modeldescription.variables.Initial
import no.ntnu.ihb.fmi4j.modeldescription.variables.Variability
import no.ntnu.ihb.fmuproxy.Solver

internal fun Status.convert(): FmiStatus {
    return when(this) {
        Status.OK_STATUS -> FmiStatus.OK
        Status.DISCARD_STATUS -> FmiStatus.Discard
        Status.ERROR_STATUS -> FmiStatus.Error
        Status.WARNING_STATUS -> FmiStatus.Warning
        Status.PENDING_STATUS -> FmiStatus.Pending
        Status.FATAL_STATUS -> FmiStatus.Fatal
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.Causality.convert(): Causality? {
    return when(this) {
        no.ntnu.ihb.fmuproxy.thrift.Causality.CALCULATED_PARAMETER_CAUSALITY -> Causality.CALCULATED_PARAMETER
        no.ntnu.ihb.fmuproxy.thrift.Causality.INDEPENDENT_CAUSALITY -> Causality.INDEPENDENT
        no.ntnu.ihb.fmuproxy.thrift.Causality.INPUT_CAUSALITY -> Causality.INPUT
        no.ntnu.ihb.fmuproxy.thrift.Causality.LOCAL_CAUSALITY -> Causality.LOCAL
        no.ntnu.ihb.fmuproxy.thrift.Causality.OUTPUT_CAUSALITY -> Causality.OUTPUT
        no.ntnu.ihb.fmuproxy.thrift.Causality.PARAMETER_CAUSALITY -> Causality.PARAMETER
        else -> null
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.Variability.convert(): Variability? {
    return when(this) {
        no.ntnu.ihb.fmuproxy.thrift.Variability.CONSTANT_VARIABILITY -> Variability.CONSTANT
        no.ntnu.ihb.fmuproxy.thrift.Variability.CONTINUOUS_VARIABILITY -> Variability.CONTINUOUS
        no.ntnu.ihb.fmuproxy.thrift.Variability.DISCRETE_VARIABILITY -> Variability.DISCRETE
        no.ntnu.ihb.fmuproxy.thrift.Variability.FIXED_VARIABILITY -> Variability.FIXED
        no.ntnu.ihb.fmuproxy.thrift.Variability.TUNABLE_VARIABILITY -> Variability.TUNABLE
        else -> null
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.Initial.convert(): Initial? {
    return when(this) {
        no.ntnu.ihb.fmuproxy.thrift.Initial.APPROX_INITIAL -> Initial.APPROX
        no.ntnu.ihb.fmuproxy.thrift.Initial.CALCULATED_INITIAL -> Initial.CALCULATED
        no.ntnu.ihb.fmuproxy.thrift.Initial.EXACT_INITIAL -> Initial.EXACT
        else -> null
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

internal fun DefaultExperiment.convert(): no.ntnu.ihb.fmi4j.modeldescription.misc.DefaultExperiment {
    return DefaultExperimentImpl(
            startTime = startTime,
            stopTime = stopTime,
            tolerance = tolerance,
            stepSize = stepSize
    )
}

internal fun Unknown.convert(): no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown {
    return object: no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown {
        override val dependencies: List<Int>
            get() = getDependencies() ?: emptyList()
        override val dependenciesKind: String?
            get() = getDependenciesKind()
        override val index: Int
            get() = getIndex()
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.ModelStructure.convert(): ModelStructure {
    return object: ModelStructure {
        override val derivatives: List<no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown>
            get() = getDerivatives()?.map { it.convert() } ?: emptyList()
        override val initialUnknowns: List<no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown>
            get() = getInitialUnknowns()?.map { it.convert() } ?: emptyList()
        override val outputs: List<no.ntnu.ihb.fmi4j.modeldescription.structure.Unknown>
            get() = getOutputs()?.map { it.convert() } ?: emptyList()
    }
}

internal fun no.ntnu.ihb.fmuproxy.thrift.IntegerAttribute.convert(): IntegerAttributeImpl {
    return IntegerAttributeImpl(
            min = min,
            max = max,
            start = start,
            quantity = quantity
    )
}

internal fun no.ntnu.ihb.fmuproxy.thrift.RealAttribute.convert(): RealAttributeImpl {
    return RealAttributeImpl(
            min = min,
            max = max,
            start = start,
            quantity = quantity
    )
}

internal fun no.ntnu.ihb.fmuproxy.thrift.StringAttribute.convert(): StringAttributeImpl {
    return StringAttributeImpl(
            start = start
    )
}

internal fun no.ntnu.ihb.fmuproxy.thrift.BooleanAttribute.convert(): BooleanAttributeImpl {
    return BooleanAttributeImpl(
            start = isStart
    )
}

internal fun no.ntnu.ihb.fmuproxy.thrift.EnumerationAttribute.convert(): EnumerationAttributeImpl {
    return EnumerationAttributeImpl(
            min = min,
            max = max,
            start = start,
            quantity = quantity
    )
}

internal fun ScalarVariable.convert(): TypedScalarVariable<*> {

    val v = ScalarVariableImpl(
            name = name,
            description = description,
            valueReference = valueReference,
            causality = causality?.convert(),
            variability = variability?.convert(),
            initial = initial?.convert()
    )

    when {
        attribute.isSetIntegerAttribute -> v.integerAttribute = attribute.integerAttribute.convert()
        attribute.isSetRealAttribute -> v.realAttribute = attribute.realAttribute.convert()
        attribute.isSetStringAttribute -> v.stringAttribute = attribute.stringAttribute.convert()
        attribute.isSetBooleanAttribute -> v.booleanAttribute = attribute.booleanAttribute.convert()
        attribute.isSetEnumerationAttribute -> v.enumerationAttribute = attribute.enumerationAttribute.convert()
        else -> throw AssertionError("All attributes are null!")
    }

    return v.toTyped()

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

    return object :no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes {

        override val canBeInstantiatedOnlyOncePerProcess: Boolean
            get() = false
        override val canGetAndSetFMUstate: Boolean
            get() =  this@convert.isCanGetAndSetFMUstate
        override val canNotUseMemoryManagementFunctions: Boolean
            get() =  false
        override val canSerializeFMUstate: Boolean
            get() =  this@convert.isSetCanSerializeFMUstate
        override val modelIdentifier: String
            get() = this@convert.modelIdentifier
        override val needsExecutionTool: Boolean
            get() = false
        override val providesDirectionalDerivative: Boolean
            get() = this@convert.isProvidesDirectionalDerivative
        override val sourceFiles: List<SourceFile>
            get() = emptyList()

        override val canHandleVariableCommunicationStepSize: Boolean
            get() = this@convert.isCanHandleVariableCommunicationStepSize
        override val canInterpolateInputs: Boolean
            get() = this@convert.isCanInterpolateInputs
        override val canRunAsynchronuously: Boolean
            get() = false
        override val maxOutputDerivativeOrder: Int
            get() = this@convert.maxOutputDerivativeOrder
        override val canProvideMaxStepSize: Boolean
            get() = false
    }
}

class ThriftModelDescription(
        private val modelDescription: ModelDescription
): no.ntnu.ihb.fmi4j.modeldescription.ModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: no.ntnu.ihb.fmi4j.modeldescription.misc.DefaultExperiment? = modelDescription.defaultExperiment?.convert()
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
    override val modelVariables: ModelVariables = modelDescription.modelVariables.convert()
    override val variableNamingConvention: String? = modelDescription.variableNamingConvention
    override val version: String?
        get() = modelDescription.version

}

fun Solver.thriftType(): no.ntnu.ihb.fmuproxy.thrift.Solver {
    return no.ntnu.ihb.fmuproxy.thrift.Solver(name, settings)
}