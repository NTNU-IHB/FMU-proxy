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

package no.mechatronics.sfi.fmuproxy.avro

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.misc.LogCategories
import no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment
import no.mechatronics.sfi.fmi4j.modeldescription.misc.SimpleType
import no.mechatronics.sfi.fmi4j.modeldescription.misc.Unit
import no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.BooleanAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Causality
import no.mechatronics.sfi.fmi4j.modeldescription.variables.EnumerationAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Initial
import no.mechatronics.sfi.fmi4j.modeldescription.variables.IntegerAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.RealAttribute
import no.mechatronics.sfi.fmi4j.modeldescription.variables.ScalarVariable
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

internal fun no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.convert(): DependenciesKind {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.CONSTANT_KIND -> DependenciesKind.CONSTANT
        no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.DEPENDENT_KIND -> DependenciesKind.DEPENDENT
        no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.DISCRETE_KIND -> DependenciesKind.DISCRETE
        no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.TUNABLE_KIND -> DependenciesKind.TUNABLE
    }
}

internal fun no.mechatronics.sfi.fmuproxy.avro.VariableNamingConvention.convert(): VariableNamingConvention {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.avro.VariableNamingConvention.FLAT -> VariableNamingConvention.FLAT
        no.mechatronics.sfi.fmuproxy.avro.VariableNamingConvention.STRUCTURED -> VariableNamingConvention.STRUCTURED
    }
}

internal fun no.mechatronics.sfi.fmuproxy.avro.Causality.convert(): Causality {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.avro.Causality.CALCULATED_PARAMETER_CAUSALITY -> Causality.CALCULATED_PARAMETER
        no.mechatronics.sfi.fmuproxy.avro.Causality.INDEPENDENT_CAUSALITY -> Causality.INDEPENDENT
        no.mechatronics.sfi.fmuproxy.avro.Causality.INPUT_CAUSALITY -> Causality.INPUT
        no.mechatronics.sfi.fmuproxy.avro.Causality.LOCAL_CAUSALITY -> Causality.LOCAL
        no.mechatronics.sfi.fmuproxy.avro.Causality.OUTPUT_CAUSALITY -> Causality.OUTPUT
        no.mechatronics.sfi.fmuproxy.avro.Causality.PARAMETER_CAUSALITY -> Causality.PARAMETER
    }
}


internal fun no.mechatronics.sfi.fmuproxy.avro.Variability.convert(): Variability {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.avro.Variability.CONSTANT_VARIABILITY -> Variability.CONSTANT
        no.mechatronics.sfi.fmuproxy.avro.Variability.CONTINUOUS_VARIABILITY -> Variability.CONTINUOUS
        no.mechatronics.sfi.fmuproxy.avro.Variability.DISCRETE_VARIABILITY -> Variability.DISCRETE
        no.mechatronics.sfi.fmuproxy.avro.Variability.FIXED_VARIABILITY -> Variability.FIXED
        no.mechatronics.sfi.fmuproxy.avro.Variability.TUNABLE_VARIABILITY -> Variability.TUNABLE
    }
}

internal fun no.mechatronics.sfi.fmuproxy.avro.Initial.convert(): Initial {
    return when(this) {
        no.mechatronics.sfi.fmuproxy.avro.Initial.APPROX_INITIAL -> Initial.APPROX
        no.mechatronics.sfi.fmuproxy.avro.Initial.CALCULATED_INITIAL -> Initial.CALCULATED
        no.mechatronics.sfi.fmuproxy.avro.Initial.EXACT_INITIAL -> Initial.EXACT
    }
}

internal fun IntegerRead.convert(): FmuIntegerRead {
    return FmuIntegerRead(value, status.convert())
}

internal fun IntegerArrayRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(value.toIntArray(), status.convert())
}

internal fun RealRead.convert(): FmuRealRead {
    return FmuRealRead(value, status.convert())
}

internal fun RealArrayRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(value.toDoubleArray(), status.convert())
}

internal fun StringRead.convert(): FmuStringRead {
    return FmuStringRead(value, status.convert())
}

internal fun StringArrayRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(value.toTypedArray(), status.convert())
}

internal fun BooleanRead.convert(): FmuBooleanRead {
    return FmuBooleanRead(value, status.convert())
}

internal fun BooleanArrayRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(value.toBooleanArray(), status.convert())
}

internal fun no.mechatronics.sfi.fmuproxy.avro.DefaultExperiment.convert(): DefaultExperiment {
    return DefaultExperiment(
            startTime = startTime,
            stopTime = stopTime,
            tolerance = tolerance,
            stepSize = stepSize
    )
}

internal fun no.mechatronics.sfi.fmuproxy.avro.Unknown.convert(): Unknown {
    return object: Unknown {
        override val dependencies: List<Int>
            get() = getDependencies() ?: emptyList()
        override val dependenciesKind: DependenciesKind?
            get() = getDependenciesKind()?.convert()
        override val index: Int
            get() = getIndex()
    }
}

internal fun no.mechatronics.sfi.fmuproxy.avro.ModelStructure.convert(): ModelStructure {
    return object: ModelStructure {
        override val derivatives: List<Unknown>
            get() = getDerivatives()?.map { it.convert() } ?: emptyList()
        override val initialUnknowns: List<Unknown>
            get() = getInitialUnknowns()?.map { it.convert() } ?: emptyList()
        override val outputs: List<Unknown>
            get() = getOutputs()?.map { it.convert() } ?: emptyList()
    }
}

internal fun no.mechatronics.sfi.fmuproxy.avro.IntegerAttribute.convert(): IntegerAttribute {
    return IntegerAttribute(
            min = min,
            max = max,
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.avro.RealAttribute.convert(): RealAttribute {
    return RealAttribute(
            min = min,
            max = max,
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.avro.StringAttribute.convert(): StringAttribute {
    return StringAttribute(
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.avro.BooleanAttribute.convert(): BooleanAttribute {
    return BooleanAttribute(
            start = start
    )
}

internal fun no.mechatronics.sfi.fmuproxy.avro.EnumerationAttribute.convert(): EnumerationAttribute {
    return EnumerationAttribute(
            min = min,
            max = max,
            start = start
    )
}


internal fun no.mechatronics.sfi.fmuproxy.avro.ScalarVariable.convert(): TypedScalarVariable<*> {

    val v = ScalarVariableImpl(
            name = name,
            description = description,
            valueReference = valueReference,
            declaredType = declaredType,
            causality = causality?.convert(),
            variability = variability?.convert(),
            initial = initial?.convert()
    )

    val attribute = attribute
    when (attribute) {
        is no.mechatronics.sfi.fmuproxy.avro.IntegerAttribute -> v.integerAttribute = attribute.convert()
        is no.mechatronics.sfi.fmuproxy.avro.RealAttribute -> v.realAttribute = attribute.convert()
        is no.mechatronics.sfi.fmuproxy.avro.StringAttribute -> v.stringAttribute = attribute.convert()
        is no.mechatronics.sfi.fmuproxy.avro.BooleanAttribute -> v.booleanAttribute = attribute.convert()
        is no.mechatronics.sfi.fmuproxy.avro.EnumerationAttribute -> v.enumerationAttribute = attribute.convert()
        else -> throw AssertionError()
    }

    return v.toTyped()

}

private var variables: List<TypedScalarVariable<*>>? = null

internal fun List<no.mechatronics.sfi.fmuproxy.avro.ScalarVariable>.convert(): ModelVariables {
    return object : ModelVariables {
        override fun getVariables(): List<TypedScalarVariable<*>> {
            if (variables == null) {
                variables = this@convert.map { it.convert() }
            }
            return variables!!
        }
    }
}

internal fun ModelDescription.convert(): CommonModelDescription {
    return AvroModelDescription(this)
}

class AvroModelDescription(
        val modelDescription: ModelDescription
): CommonModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: DefaultExperiment? = modelDescription.defaultExperiment?.convert()
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
        get() = modelDescription.supportsCoSimulation
    override val supportsModelExchange: Boolean
        get() = modelDescription.supportsModelExchange
    override val variableNamingConvention: VariableNamingConvention? = modelDescription.variableNamingConvention?.convert()
    override val version: String?
        get() = modelDescription.version
}

fun Solver.avroType(): no.mechatronics.sfi.fmuproxy.avro.Solver {
    return no.mechatronics.sfi.fmuproxy.avro.Solver(name, settings)
}