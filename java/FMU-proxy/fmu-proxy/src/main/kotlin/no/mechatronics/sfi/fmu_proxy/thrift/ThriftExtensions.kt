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

package no.mechatronics.sfi.fmu_proxy.thrift

import no.mechatronics.sfi.fmi4j.common.FmuBooleanRead
import no.mechatronics.sfi.fmi4j.common.FmuIntegerRead
import no.mechatronics.sfi.fmi4j.common.FmuRealRead
import no.mechatronics.sfi.fmi4j.common.FmuStringRead
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Causality
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Initial
import no.mechatronics.sfi.fmi4j.modeldescription.variables.Variability

fun FmuIntegerRead.thriftType()
        = IntRead(value, StatusCode.findByValue(status.code))

fun FmuRealRead.thriftType()
        = RealRead(value, StatusCode.findByValue(status.code))

fun FmuStringRead.thriftType()
        = StringRead(value, StatusCode.findByValue(status.code))

fun FmuBooleanRead.thriftType()
        = BoolRead(value, StatusCode.findByValue(status.code))

fun TypedScalarVariable<*>.thriftType(): ScalarVariable {
    return ScalarVariable().also { v ->
        v.name = name
        v.value_reference = valueReference
        causality?.also { v.causality = thriftCausality(it) }
        variability?.also { v.variability = thriftVariability(it) }
        initial?.also { v.inital = thriftInitial(it) }
        start?.also {
            when(it) {
                is IntegerVariable -> v.start.int_value = it as Int
                is RealVariable -> v.start.real_value = it as Real
                is StringVariable -> v.start.str_value = it as String
                is BooleanVariable -> v.start.bool_value = it as Boolean
                is EnumerationVariable -> v.start.int_value = it as Int
            }
        }
    }
}

fun ModelVariables.thriftType() = map { it.thriftType() }

fun no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment.thriftType()
        = DefaultExperiment(startTime, stopTime, tolerance, stepSize)

fun no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown.thriftType(): Unknown {
    return Unknown().also {u ->
        u.index = index
        u.dependencies = dependencies
        dependenciesKind?.also { u.dependencies_kind = thriftDependenciesKind(it) }
    }
}

fun no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure.thriftType(): ModelStructure {
    return ModelStructure().also { ms ->
        ms.outputs = outputs
        ms.derivatives = derivatives.map { it.thriftType() }
        ms.initial_unknowns = initialUnknowns.map { it.thriftType() }
    }
}

fun SimpleModelDescription.thriftType(): ModelDescription {
    return ModelDescription().also { md ->

        md.fmiVersion = fmiVersion
        md.modelName = modelName
        md.guid = guid
        license?.also { md.license = it }
        copyright?.also { md.copyright = it }
        author?.also { md.authour = it }
        description?.also { md.description = it }
        generationTool?.also { md.generation_tool = it }
        defaultExperiment?.also { md.default_experiment = it.thriftType() }
        md.model_variables = modelVariables.thriftType()
        md.model_structure = modelStructure.thriftType()

    }
}

private fun thriftCausality(causality: Causality): no.mechatronics.sfi.fmu_proxy.thrift.Causality {
    return when(causality) {
        Causality.INPUT -> no.mechatronics.sfi.fmu_proxy.thrift.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> no.mechatronics.sfi.fmu_proxy.thrift.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> no.mechatronics.sfi.fmu_proxy.thrift.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> no.mechatronics.sfi.fmu_proxy.thrift.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> no.mechatronics.sfi.fmu_proxy.thrift.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> no.mechatronics.sfi.fmu_proxy.thrift.Causality.INDEPENDENT_CAUSALITY
        else -> throw IllegalArgumentException()
    }
}

private fun thriftVariability(variability: Variability): no.mechatronics.sfi.fmu_proxy.thrift.Variability {
    return when(variability) {
        Variability.CONSTANT -> no.mechatronics.sfi.fmu_proxy.thrift.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> no.mechatronics.sfi.fmu_proxy.thrift.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> no.mechatronics.sfi.fmu_proxy.thrift.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> no.mechatronics.sfi.fmu_proxy.thrift.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> no.mechatronics.sfi.fmu_proxy.thrift.Variability.TUNABLE_VARIABILITY
        else -> throw IllegalArgumentException()
    }
}

private fun thriftInitial(initial: Initial): no.mechatronics.sfi.fmu_proxy.thrift.Initial {
    return when(initial) {
        Initial.CALCULATED -> no.mechatronics.sfi.fmu_proxy.thrift.Initial.CALCULATED_INITIAL
        Initial.EXACT -> no.mechatronics.sfi.fmu_proxy.thrift.Initial.EXACT_INITIAL
        Initial.APPROX -> no.mechatronics.sfi.fmu_proxy.thrift.Initial.APPROX_INITIAL
        else -> throw IllegalArgumentException()
    }
}

private fun thriftDependenciesKind(dependenciesKind: DependenciesKind): no.mechatronics.sfi.fmu_proxy.thrift.DependenciesKind {
    return when(dependenciesKind) {
        DependenciesKind.DEPENDENT -> no.mechatronics.sfi.fmu_proxy.thrift.DependenciesKind.DEPENDENT_KIND
        DependenciesKind.CONSTANT -> no.mechatronics.sfi.fmu_proxy.thrift.DependenciesKind.CONSTANT_KIND
        DependenciesKind.TUNABLE -> no.mechatronics.sfi.fmu_proxy.thrift.DependenciesKind.TUNABLE_KIND
        DependenciesKind.DISCRETE -> no.mechatronics.sfi.fmu_proxy.thrift.DependenciesKind.DISCRETE_KIND
        else -> throw IllegalArgumentException()
    }
}

