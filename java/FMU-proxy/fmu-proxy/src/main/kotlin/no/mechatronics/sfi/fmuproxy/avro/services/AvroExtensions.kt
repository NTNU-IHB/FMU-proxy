package no.mechatronics.sfi.fmuproxy.avro.services

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Causality
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Initial
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Variability
import no.mechatronics.sfi.fmuproxy.avro.*
import no.mechatronics.sfi.fmuproxy.avro.ScalarVariable

internal fun TypedScalarVariable<*>.avroType(): ScalarVariable {
    return no.mechatronics.sfi.fmuproxy.avro.ScalarVariable().also { v ->
        v.name = name
        v.valueReference = valueReference
        v.variableType = avroVariableType()
        description?.also { v.description = it }
        start?.also { v.start = AnyPrimitive().apply { value = it } }
        causality?.also { v.causality = it.avroType() }
        variability?.also { v.variability = it.avroType() }
        initial?.also { v.initial = it.avroType() }
    }
}

internal fun TypedScalarVariable<*>.avroVariableType(): VariableType {
    return when(this) {
        is IntegerVariable -> VariableType.INTEGER_VARIABLE
        is RealVariable -> VariableType.REAL_VARIABLE
        is StringVariable -> VariableType.STRING_VARIABLE
        is BooleanVariable -> VariableType.BOOLEAN_VARIABLE
        is EnumerationVariable -> VariableType.ENUMERATION_VARIABLE
        else -> throw IllegalStateException()
    }
}

internal fun ModelVariables.avroType(): List<ScalarVariable> {
    return map { it.avroType() }
}

internal fun Unknown.avroType(): no.mechatronics.sfi.fmuproxy.avro.Unknown {
    return no.mechatronics.sfi.fmuproxy.avro.Unknown().also { u ->
        u.index = index
        u.dependencies = dependencies
        dependenciesKind?.also { u.dependenciesKind = it.avroType() }
    }
}

internal fun ModelStructure.avroType(): no.mechatronics.sfi.fmuproxy.avro.ModelStructure {
    return no.mechatronics.sfi.fmuproxy.avro.ModelStructure().also { ms ->
        ms.outputs = outputs.map { it.avroType() }
        ms.derivatives = derivatives.map { it.avroType() }
        ms.initialUnknowns = initialUnknowns.map { it.avroType() }
    }
}

fun DefaultExperiment.avroType(): no.mechatronics.sfi.fmuproxy.avro.DefaultExperiment {
    return no.mechatronics.sfi.fmuproxy.avro.DefaultExperiment().also {
        it.startTime = startTime
        it.stopTime = stopTime
        it.tolerance = tolerance
        it.stepSize = stepSize
    }
}

internal fun CommonModelDescription.avroType(): ModelDescription {
    return ModelDescription().also { md ->

        md.guid = guid
        md.modelName = modelName
        md.fmiVersion = fmiVersion
        md.modelVariables = modelVariables.avroType()
        md.modelStructure = modelStructure.avroType()

        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.author = it }
        description?.also { md.description = it }
        generationTool?.also { md.generationTool = it }
        defaultExperiment?.also { md.defaultExperiment = it.avroType() }


    }
}

internal fun Causality.avroType(): no.mechatronics.sfi.fmuproxy.avro.Causality {
    return when(this) {
        Causality.INPUT -> no.mechatronics.sfi.fmuproxy.avro.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> no.mechatronics.sfi.fmuproxy.avro.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> no.mechatronics.sfi.fmuproxy.avro.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> no.mechatronics.sfi.fmuproxy.avro.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> no.mechatronics.sfi.fmuproxy.avro.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> no.mechatronics.sfi.fmuproxy.avro.Causality.INDEPENDENT_CAUSALITY
        else -> throw IllegalArgumentException()
    }
}

internal fun Variability.avroType(): no.mechatronics.sfi.fmuproxy.avro.Variability {
    return when(this) {
        Variability.CONSTANT -> no.mechatronics.sfi.fmuproxy.avro.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> no.mechatronics.sfi.fmuproxy.avro.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> no.mechatronics.sfi.fmuproxy.avro.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> no.mechatronics.sfi.fmuproxy.avro.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> no.mechatronics.sfi.fmuproxy.avro.Variability.TUNABLE_VARIABILITY
        else -> throw IllegalArgumentException()
    }
}

internal fun Initial.avroType(): no.mechatronics.sfi.fmuproxy.avro.Initial {
    return when(this) {
        Initial.CALCULATED -> no.mechatronics.sfi.fmuproxy.avro.Initial.CALCULATED_INITIAL
        Initial.EXACT -> no.mechatronics.sfi.fmuproxy.avro.Initial.EXACT_INITIAL
        Initial.APPROX -> no.mechatronics.sfi.fmuproxy.avro.Initial.APPROX_INITIAL
        else -> throw IllegalArgumentException()
    }
}

internal fun DependenciesKind.avroType(): no.mechatronics.sfi.fmuproxy.avro.DependenciesKind {
    return when(this) {
        DependenciesKind.DEPENDENT -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.DEPENDENT_KIND
        DependenciesKind.CONSTANT -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.CONSTANT_KIND
        DependenciesKind.TUNABLE -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.TUNABLE_KIND
        DependenciesKind.DISCRETE -> no.mechatronics.sfi.fmuproxy.avro.DependenciesKind.DISCRETE_KIND
        else -> throw IllegalArgumentException()
    }
}

internal fun FmiStatus.avroType(): StatusCode {
    return when (this) {
        FmiStatus.OK -> StatusCode.OK_STATUS
        FmiStatus.Warning -> StatusCode.WARNING_STATUS
        FmiStatus.Discard -> StatusCode.DISCARD_STATUS
        FmiStatus.Error -> StatusCode.ERROR_STATUS
        FmiStatus.Fatal -> StatusCode.FATAL_STATUS
        FmiStatus.Pending -> StatusCode.PENDING_STATUS
        FmiStatus.NONE -> throw RuntimeException()
    }
}