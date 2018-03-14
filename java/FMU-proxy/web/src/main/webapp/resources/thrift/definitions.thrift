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

namespace java no.mechatronics.sfi.fmu_proxy.thrift

typedef list<ScalarVariable> ModelVariables


exception NoSuchFmuException {
    1: string message
}

exception NoSuchVariableException {
    1: string message
}

exception UnsupportedOperationException {
    1: string message
}

struct ModelDescription {
    1: string fmiVersion,
    2: string modelName,
    3: string guid,
    4: optional string license,
    5: optional string copyright,
    6: optional string authour,
    7: optional string version,
    8: optional string description,
    9: optional string generation_tool,
    10: optional DefaultExperiment default_experiment,
    11: optional VariableNamingConvention variable_naming_convention,
    12: ModelVariables model_variables,
    13: ModelStructure model_structure
}

struct ScalarVariable {
    1: i32 value_reference,
    2: string name,
    3: string description,
    4: VariableType variable_type,
    5: Initial inital,
    6: Causality causality,
    7: Variability variability,
    8: optional AnyPrimitive start
}

union AnyPrimitive {
    1: i32 int_value,
    2: double real_value,
    3: string str_value,
    4: bool bool_value
}

struct Unknown {
    1: i32 index,
    2: list<i32> dependencies,
    3: DependenciesKind dependencies_kind
}

struct ModelStructure {
    1: list<i32> outputs,
    2: list<Unknown> derivatives,
    3: list<Unknown> initial_unknowns
}

struct DefaultExperiment {
    1: double startTime,
    2: double endTime,
    3: double tolerance,
    4: double stepSize
}

struct IntRead {
    1: i32 value,
    2: StatusCode code
}

struct RealRead {
    1: double value,
    2: StatusCode code
}

struct StringRead {
    1: string value,
    2: StatusCode code
}

struct BoolRead {
    1: bool value,
    2: StatusCode code
}



enum VariableType {
    INTEGER_VARIABLE = 0,
    REAL_VARIABLE = 1,
    STRING_VARIABLE = 2,
    BOOLEAN_VARIABLE = 3,
    ENUMERATION_VARIABLE = 4
}

enum StatusCode {
    OK_STATUS = 0,
    WARNING_STATUS = 1,
    DISCARD_STATUS = 2,
    ERROR_STATUS = 3,
    FATAL_STATUS = 4,
    PENDING_STATUS = 5
}

enum Causality {
    UNDEFINED_CAUSALITY = 0,
    INPUT_CAUSALITY = 1,
    OUTPUT_CAUSALITY = 2,
    PARAMETER_CAUSALITY = 3,
    CALCULATED_PARAMETER_CAUSALITY = 4,
    LOCAL_CAUSALITY = 5,
    INDEPENDENT_CAUSALITY = 6
}

enum Variability {
    UNDEFINED_VARIABILITY = 0,
    CONSTANT_VARIABILITY =  1,
    FIXED_VARIABILITY = 2,
    CONTINUOUS_VARIABILITY = 3,
    DISCRETE_VARIABILITY = 4,
    TUNABLE_VARIABILITY = 5
}

enum Initial {
    UNDEFINED_INITIAL = 0,
    EXACT_INITIAL = 1,
    APPROX_INITIAL = 2,
    CALCULATED_INITIAL = 3
}

enum DependenciesKind {
    DEPENDENT_KIND = 0,
    CONSTANT_KIND = 1,
    TUNABLE_KIND = 2,
    DISCRETE_KIND = 4
}

enum VariableNamingConvention {
    FLAT = 0,
    STRUCTURED = 1
}

union Integrator {
    1: EulerIntegrator euler
    2: ClassicalRungeKuttaIntegrator runge_kutta
    3: MidpointIntegrator mid_point
    4: GillIntegrator gill
    5: AdamsBashforthIntegrator adams_bashforth
    6: DormandPrince54Integrator dormand_prince54
}

struct EulerIntegrator {
	1: double step_size
}

struct ClassicalRungeKuttaIntegrator {
	1: double step_size
}

struct MidpointIntegrator {
	1: double step_size
}

struct GillIntegrator {
	1: double step_size
}

struct AdamsBashforthIntegrator {
	1: i32 n_steps
	2: double min_Step
	3: double max_step
	4: double scal_absolute_tolerance
	5: double scal_relative_tolerance
}

struct DormandPrince54Integrator {
    1: double min_Step
    2: double max_step
    3: double scal_absolute_tolerance
    4: double scal_relative_tolerance
}
