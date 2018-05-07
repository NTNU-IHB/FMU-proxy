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
import no.mechatronics.sfi.fmi4j.modeldescription.log.LogCategories
import no.mechatronics.sfi.fmi4j.modeldescription.structure.ModelStructure
import no.mechatronics.sfi.fmi4j.modeldescription.variables.ModelVariables
import no.mechatronics.sfi.fmuproxy.IntegratorSettings


internal fun StatusCode.convert(): FmiStatus {
    return when(this) {
        StatusCode.OK_STATUS -> FmiStatus.OK
        StatusCode.DISCARD_STATUS -> FmiStatus.Discard
        StatusCode.ERROR_STATUS -> FmiStatus.Error
        StatusCode.WARNING_STATUS -> FmiStatus.Warning
        StatusCode.PENDING_STATUS -> FmiStatus.Pending
        StatusCode.FATAL_STATUS -> FmiStatus.Fatal
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

internal fun IntegratorSettings.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Integrator {
    return when(this) {
        is no.mechatronics.sfi.fmuproxy.EulerIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.euler(EulerIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.ClassicalRungeKuttaIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.runge_kutta(ClassicalRungeKuttaIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.GillIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.gill(no.mechatronics.sfi.fmuproxy.thrift.GillIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.MidPointIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.mid_point(MidpointIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.AdamsBashforthIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.adams_bashforth(AdamsBashforthIntegrator(n_steps, min_Step, max_step, scal_absolute_tolerance, scal_relative_tolerance))
        is no.mechatronics.sfi.fmuproxy.DormandPrince54Integrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.dormand_prince54(DormandPrince54Integrator(min_Step, max_step, scal_absolute_tolerance, scal_relative_tolerance))
    }
}


internal fun IntRead.convert(): FmuIntegerRead {
    return FmuIntegerRead(value, code.convert())
}

internal fun IntArrayRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(value.toIntArray(), code.convert())
}

internal fun RealRead.convert(): FmuRealRead {
    return FmuRealRead(value, code.convert())
}

internal fun RealArrayRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(value.toDoubleArray(), code.convert())
}

internal fun StringRead.convert(): FmuStringRead {
    return FmuStringRead(value, code.convert())
}

internal fun StringArrayRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(value.toTypedArray(), code.convert())
}

internal fun BoolRead.convert(): FmuBooleanRead {
    return FmuBooleanRead(isValue, code.convert())
}

internal fun BoolArrayRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(value.toBooleanArray(), code.convert())
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
    override val defaultExperiment: no.mechatronics.sfi.fmi4j.modeldescription.misc.DefaultExperiment?
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
        get() = modelDescription.isSupportsCoSimulation
    override val supportsModelExchange: Boolean
        get() = modelDescription.isSupportsModelExchange
    override val variableNamingConvention: no.mechatronics.sfi.fmi4j.modeldescription.misc.VariableNamingConvention?
        get() = modelDescription.variableNamingConvention?.convert()
    override val version: String?
        get() = modelDescription.version
}