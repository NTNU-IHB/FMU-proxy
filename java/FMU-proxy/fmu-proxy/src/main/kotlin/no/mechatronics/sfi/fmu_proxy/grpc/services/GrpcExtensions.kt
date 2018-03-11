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

package no.mechatronics.sfi.fmu_proxy.grpc.services

import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import no.mechatronics.sfi.fmu_proxy.grpc.*

internal fun SimpleModelDescription.protoType(): Proto.ModelDescription {

    return Proto.ModelDescription.newBuilder().also { builder ->
        builder.fmiVersion = fmiVersion
        builder.guid = guid
        builder.modelName = modelName
        builder.modelStructure = modelStructure.protoType()
        builder.addAllModelVariables(modelVariables.map { it.protoType() })
        license?.also { builder.license = it }
        copyright?.also { builder.copyright = it }
        author?.also { builder.author = it }
        version?.also { builder.version = it }
        license?.also { builder.license = it }
    }.build()

}

internal fun TypedScalarVariable<*>.protoType() : Proto.ScalarVariable {
    return Proto.ScalarVariable.newBuilder()
            .setValueReference(valueReference)
            .setName(name)
            .setDescription(description)
            .setVariableType(protoVariableType(this))
            .setCausality(protoType(causality))
            .setVariability(protoType(variability))
            .setInitial(protoType(initial))
            .setStart(getStartProto())
            .build()
}


internal fun Double.protoType(): Proto.Real {
    return Proto.Real.newBuilder().setValue(this).build()
}

internal fun Boolean.protoType(): Proto.Bool {
    return Proto.Bool.newBuilder().setValue(this).build()
}

internal fun ModelStructure.protoType(): Proto.ModelStructure {
    return Proto.ModelStructure.newBuilder()
            .addAllOutputs(outputs)
            .addAllDerivatives(derivatives.map { it.protoType() })
            .addAllInitialUnknowns(initialUnknowns.map { it.protoType() })
            .build()
}

internal fun Unknown.protoType(): Proto.Unknown {
    return Proto.Unknown.newBuilder().also { builder ->
        builder.index = index
        builder.addAllDependencies(dependencies)

        dependenciesKind?.also {
            builder.dependenciesKind = when(dependenciesKind) {
                DependenciesKind.CONSTANT -> Proto.DependenciesKind.CONSTANT_KIND
                DependenciesKind.DEPENDENT -> Proto.DependenciesKind.DEPENDENT_KIND
                DependenciesKind.DISCRETE -> Proto.DependenciesKind.DISCRETE_KIND
                DependenciesKind.TUNABLE -> Proto.DependenciesKind.TUNABLE_KIND
                else -> Proto.DependenciesKind.UNRECOGNIZED
            }
        }
    }.build()
}

internal fun protoType(causality: Causality?): Proto.Causality {

    return when (causality) {
        Causality.INPUT -> Proto.Causality.INPUT_CAUSALITY
        Causality.OUTPUT -> Proto.Causality.OUTPUT_CAUSALITY
        Causality.CALCULATED_PARAMETER -> Proto.Causality.CALCULATED_PARAMETER_CAUSALITY
        Causality.PARAMETER -> Proto.Causality.PARAMETER_CAUSALITY
        Causality.LOCAL -> Proto.Causality.LOCAL_CAUSALITY
        Causality.INDEPENDENT -> Proto.Causality.INDEPENDENT_CAUSALITY
        else -> Proto.Causality.UNDEFINED_CAUSALITY
    }

}

internal fun protoType(variability: Variability?): Proto.Variability {

    return when (variability) {
        Variability.CONSTANT -> Proto.Variability.CONSTANT_VARIABILITY
        Variability.CONTINUOUS -> Proto.Variability.CONTINUOUS_VARIABILITY
        Variability.DISCRETE -> Proto.Variability.DISCRETE_VARIABILITY
        Variability.FIXED -> Proto.Variability.FIXED_VARIABILITY
        Variability.TUNABLE -> Proto.Variability.TUNABLE_VARIABILITY
        else -> Proto.Variability.UNDEFINED_VARIABILITY
    }

}

internal fun protoType(initial: Initial?): Proto.Initial {

    return when (initial) {
        Initial.CALCULATED ->  Proto.Initial.CALCULATED_INITIAL
        Initial.EXACT ->  Proto.Initial.EXACT_INITIAL
        Initial.APPROX ->  Proto.Initial.APPROX_INITIAL
        else ->  Proto.Initial.UNDEFINED_INITIAL
    }

}

internal fun TypedScalarVariable<*>.getStartProto(): Proto.AnyPrimitive {
    return if (start != null) {
        Proto.AnyPrimitive.newBuilder().also { builder ->
            when (this) {
                is IntegerVariable -> builder.intValue = start!!
                is RealVariable -> builder.realValue = start!!
                is StringVariable -> builder.strValue = start
                is BooleanVariable -> builder.boolValue = start!!
                is EnumerationVariable -> builder.enumValue = start!!
                else -> throw UnsupportedOperationException("Variable type not supported: ${this::class.java.simpleName}")
            }
        }.build()

    } else {
        Proto.AnyPrimitive.getDefaultInstance()
    }
}

internal fun protoVariableType(variable: TypedScalarVariable<*>): Proto.VariableType {
    return when(variable) {
        is IntegerVariable -> Proto.VariableType.INTEGER_VARIABLE
        is RealVariable -> Proto.VariableType.REAL_VARIABLE
        is StringVariable -> Proto.VariableType.STRING_VARIABLE
        is BooleanVariable -> Proto.VariableType.BOOLEAN_VARIABLE
        is EnumerationVariable -> Proto.VariableType.ENUMERATION_VARIABLE
        else -> throw UnsupportedOperationException("Variable type not supported: ${variable.typeName}")
    }

}

