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
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.log.LogCategories
import no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment
import no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention
import no.mechatronics.sfi.fmi4j.modeldescription.structure.DependenciesKind
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.structure.Unknown
import no.mechatronics.sfi.fmi4j.modeldescription.variables.ModelVariables


internal fun Proto.Status.convert(): FmiStatus {
    return code.convert()
}

internal fun Proto.StatusCode.convert(): FmiStatus {
    return when(this) {
        Proto.StatusCode.OK_STATUS -> FmiStatus.OK
        Proto.StatusCode.DISCARD_STATUS -> FmiStatus.Discard
        Proto.StatusCode.ERROR_STATUS -> FmiStatus.Error
        Proto.StatusCode.WARNING_STATUS -> FmiStatus.Warning
        Proto.StatusCode.PENDING_STATUS -> FmiStatus.Pending
        Proto.StatusCode.FATAL_STATUS -> FmiStatus.Fatal
        Proto.StatusCode.UNRECOGNIZED -> throw AssertionError()
    }
}

internal fun Proto.DependenciesKind.convert(): DependenciesKind {
    return when(this) {
        Proto.DependenciesKind.CONSTANT_KIND -> DependenciesKind.CONSTANT
        Proto.DependenciesKind.DEPENDENT_KIND -> DependenciesKind.DEPENDENT
        Proto.DependenciesKind.DISCRETE_KIND -> DependenciesKind.DISCRETE
        Proto.DependenciesKind.TUNABLE_KIND -> DependenciesKind.TUNABLE
        Proto.DependenciesKind.UNRECOGNIZED -> throw AssertionError()
    }
}

internal fun Proto.VariableNamingConvention.convert(): VariableNamingConvention {
    return when(this) {
        Proto.VariableNamingConvention.FLAT -> VariableNamingConvention.FLAT
        Proto.VariableNamingConvention.STRUCTURED -> VariableNamingConvention.STRUCTURED
        Proto.VariableNamingConvention.UNRECOGNIZED -> throw AssertionError()
    }
}

internal fun Int.asProtoUInt(): Proto.UInt {
    return Proto.UInt.newBuilder()
            .setValue(this)
            .build()
}

internal fun Int.asProtoInt(): Proto.UInt {
    return Proto.UInt.newBuilder()
            .setValue(this)
            .build()
}

internal fun Proto.IntRead.convert(): FmuIntegerRead {
    return FmuIntegerRead(value, status.convert())
}

internal fun Proto.IntListRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(valuesList.toIntArray(), status.convert())
}

internal fun Proto.RealRead.convert(): FmuRealRead {
    return FmuRealRead(value, status.convert())
}

internal fun Proto.RealListRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(valuesList.toDoubleArray(), status.convert())
}

internal fun Proto.StrRead.convert(): FmuStringRead {
    return FmuStringRead(value, status.convert())
}

internal fun Proto.StrListRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(valuesList.toTypedArray(), status.convert())
}

internal fun Proto.BoolRead.convert(): FmuBooleanRead {
    return FmuBooleanRead(value, status.convert())
}

internal fun Proto.BoolListRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(valuesList.toBooleanArray(), status.convert())
}

internal fun Proto.DefaultExperiment.convert(): DefaultExperiment {
    return DefaultExperiment(
            startTime = startTime,
            stopTime = stopTime,
            tolerance = tolerance,
            stepSize = stepSize
    )
}

internal fun Proto.Unknown.convert(): Unknown {
    return object: Unknown {
        override val dependencies: List<Int>
            get() = dependenciesList
        override val dependenciesKind: DependenciesKind?
            get() = getDependenciesKind()?.convert()
        override val index: Int
            get() = getIndex()
    }
}

internal fun Proto.ModelStructure.convert(): ModelStructure {
    return object: ModelStructure {
        override val derivatives: List<Unknown>
            get() = derivativesList?.map { it.convert() } ?: emptyList()
        override val initialUnknowns: List<Unknown>
            get() = initialUnknownsList?.map { it.convert() } ?: emptyList()
        override val outputs: List<Unknown>
            get() = outputsList?.map { it.convert() } ?: emptyList()
    }
}

internal fun Proto.ModelDescription.convert(): CommonModelDescription {
    return GrpcModelDescription(this)
}

class GrpcModelDescription(
        val modelDescription: Proto.ModelDescription
): CommonModelDescription {

    override val author: String?
        get() = modelDescription.author
    override val copyright: String?
        get() = modelDescription.copyright
    override val defaultExperiment: DefaultExperiment?
        get() = modelDescription.defaultExperiment.convert()
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
    override val modelName: String
        get() = modelDescription.modelName
    override val modelStructure: ModelStructure
        get() = modelDescription.modelStructure.convert()
    override val modelVariables: ModelVariables
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val supportsCoSimulation: Boolean
        get() = modelDescription.supportsCoSimulation
    override val supportsModelExchange: Boolean
        get() = modelDescription.supportsModelExchange
    override val variableNamingConvention: VariableNamingConvention?
        get() = modelDescription.variableNamingConvention?.convert()
    override val version: String?
        get() = modelDescription.version
}