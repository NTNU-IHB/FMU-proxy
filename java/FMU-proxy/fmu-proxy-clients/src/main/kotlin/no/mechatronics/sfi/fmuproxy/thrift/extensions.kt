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

package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.logging.LogCategories
import no.mechatronics.sfi.fmi4j.modeldescription.misc.SimpleType
import no.mechatronics.sfi.fmi4j.modeldescription.misc.Unit
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.BooleanAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Causality
import no.mechatronics.sfi.fmi4j.modeldescription.variables.EnumerationAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Initial
import no.mechatronics.sfi.fmi4j.modeldescription.variables.IntegerAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.RealAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.StringAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Variability
import no.mechatronics.sfi.fmuproxy.Solver

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

internal fun no.mechatronics.sfi.fmuproxy.thrift.Causality.convert(): Causality {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.thrift.Causality.CALCULATED_PARAMETER_CAUSALITY -> Causality.CALCULATED_PARAMETER
        no.mechatronics.sfi.fmuproxy.thrift.Causality.INDEPENDENT_CAUSALITY -> Causality.INDEPENDENT
        no.mechatronics.sfi.fmuproxy.thrift.Causality.INPUT_CAUSALITY -> Causality.INPUT
        no.mechatronics.sfi.fmuproxy.thrift.Causality.LOCAL_CAUSALITY -> Causality.LOCAL
        no.mechatronics.sfi.fmuproxy.thrift.Causality.OUTPUT_CAUSALITY -> Causality.OUTPUT
        no.mechatronics.sfi.fmuproxy.thrift.Causality.PARAMETER_CAUSALITY -> Causality.PARAMETER
    }
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.Variability.convert(): Variability {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.thrift.Variability.CONSTANT_VARIABILITY -> Variability.CONSTANT
        no.mechatronics.sfi.fmuproxy.thrift.Variability.CONTINUOUS_VARIABILITY -> Variability.CONTINUOUS
        no.mechatronics.sfi.fmuproxy.thrift.Variability.DISCRETE_VARIABILITY -> Variability.DISCRETE
        no.mechatronics.sfi.fmuproxy.thrift.Variability.FIXED_VARIABILITY -> Variability.FIXED
        no.mechatronics.sfi.fmuproxy.thrift.Variability.TUNABLE_VARIABILITY -> Variability.TUNABLE
    }
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.Initial.convert(): Initial {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.thrift.Initial.APPROX_INITIAL -> Initial.APPROX
        no.mechatronics.sfi.fmuproxy.thrift.Initial.CALCULATED_INITIAL -> Initial.CALCULATED
        no.mechatronics.sfi.fmuproxy.thrift.Initial.EXACT_INITIAL -> Initial.EXACT
    }
}

internal fun DependenciesKind.convert(): no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.CONSTANT_KIND -> no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind.CONSTANT
        no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.DEPENDENT_KIND -> no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind.DEPENDENT
        no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.DISCRETE_KIND -> no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind.DISCRETE
        no.mechatronics.sfi.fmuproxy.thrift.DependenciesKind.TUNABLE_KIND ->no.mechatronics.sfi.fmi4j.modeldescription.structure. DependenciesKind.TUNABLE
    }
}

internal fun VariableNamingConvention.convert(): no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention {
    return when(this) {
        VariableNamingConvention.FLAT -> no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention.FLAT
        VariableNamingConvention.STRUCTURED -> no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention.STRUCTURED
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

internal fun DefaultExperiment.convert(): no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment {
    return no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment(
            startTime = startTime,
            stopTime = stopTime,
            tolerance = tolerance,
            stepSize = stepSize
    )
}

internal fun Unknown.convert(): no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown {
    return object: no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown {
        override val dependencies: List<Int>
            get() = getDependencies() ?: emptyList()
        override val dependenciesKind: no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind?
            get() = getDependenciesKind()?.convert()
        override val index: Int
            get() = getIndex()
    }
}


internal fun no.mechatronics.sfi.fmuproxy.thrift.ModelStructure.convert(): ModelStructure {
    return object: ModelStructure {
        override val derivatives: List<no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown>
            get() = getDerivatives()?.map { it.convert() } ?: emptyList()
        override val initialUnknowns: List<no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown>
            get() = getInitialUnknowns()?.map { it.convert() } ?: emptyList()
        override val outputs: List<no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown>
            get() = getOutputs()?.map { it.convert() } ?: emptyList()
    }
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.IntegerAttribute.convert(): IntegerAttribute {
    return IntegerAttribute(
            min = min,
            max = max,
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.RealAttribute.convert(): RealAttribute {
    return RealAttribute(
            min = min,
            max = max,
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.StringAttribute.convert(): StringAttribute {
    return StringAttribute(
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.BooleanAttribute.convert(): BooleanAttribute {
    return BooleanAttribute(
            start = isStart
    )
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.EnumerationAttribute.convert(): EnumerationAttribute {
    return EnumerationAttribute(
            min = min,
            max = max,
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.thrift.ScalarVariable.convert(): TypedScalarVariable<*> {

    val v = ScalarVariableImpl(
            name = name,
            description = description,
            valueReference = valueReference,
            declaredType = declaredType,
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
        vars: List<no.mechatronics.sfi.fmuproxy.thrift.ScalarVariable>
) : ModelVariables {

    private val variables = vars.map { it.convert() }

    override fun getVariables(): List<TypedScalarVariable<*>> {
        return variables
    }

}

internal fun List<no.mechatronics.sfi.fmuproxy.thrift.ScalarVariable>.convert(): ModelVariables {
    return MyModelVariables(this)
}

internal fun ModelDescription.convert(): CommonModelDescription {
    return ThriftModelDescription(this)
}

class ThriftModelDescription(
        val modelDescription: ModelDescription
): CommonModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment? = modelDescription.defaultExperiment?.convert()
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
    override val modelVariables: ModelVariables = modelDescription.modelVariables.convert()
    override val supportsCoSimulation: Boolean
        get() = modelDescription.isSupportsCoSimulation
    override val supportsModelExchange: Boolean
        get() = modelDescription.isSupportsModelExchange
    override val variableNamingConvention: no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention? = modelDescription.variableNamingConvention?.convert()
    override val version: String?
        get() = modelDescription.version
}

fun Solver.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Solver {
    return no.mechatronics.sfi.fmuproxy.thrift.Solver(name, settings)
}