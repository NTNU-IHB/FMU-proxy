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

namespace java no.mechatronics.sfi.fmuproxy.thrift

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
    6: optional string author,
    7: optional string version,
    8: optional string description,
    9: optional string generationTool,
    10: optional string generationDateAndTime,
    11: optional DefaultExperiment defaultExperiment,
    12: optional VariableNamingConvention variableNamingConvention,
    13: ModelVariables modelVariables,
    14: ModelStructure modelStructure,
    15: bool supportsCoSimulation,
    16: bool supportsModelExchange
}

struct IntegerAttribute {
    1: i32 min,
    2: i32 max,
    3: i32 start
}

struct RealAttribute {
    1: double min,
    2: double max,
    3: double start
}

struct StringAttribute {
    1: string start
}

struct BooleanAttribute {
    1: bool start
}

struct EnumerationAttribute {
    1: i32 min,
    2: i32 max,
    3: i32 start
}

union ScalarVariableAttribute {
    1: IntegerAttribute integerAttribute,
    2: RealAttribute realAttribute,
    3: StringAttribute stringAttribute,
    4: BooleanAttribute booleanAttribute,
    5: EnumerationAttribute enumerationAttribute
}

struct ScalarVariable {
    1: i32 valueReference,
    2: string name,
    3: optional string description,
    4: optional string declaredType,
    5: optional Initial initial,
    6: optional Causality causality,
    7: optional Variability variability,
    8: ScalarVariableAttribute attribute
}

struct Unknown {
    1: i32 index,
    2: list<i32> dependencies,
    3: DependenciesKind dependenciesKind
}

struct ModelStructure {
    1: list<Unknown> outputs,
    2: list<Unknown> derivatives,
    3: list<Unknown> initialUnknowns
}

struct DefaultExperiment {
    1: double startTime,
    2: double stopTime,
    3: double tolerance,
    4: double stepSize
}

struct IntegerRead {
    1: i32 value,
    2: StatusCode code
}

struct IntegerArrayRead {
    1: list<i32> value,
    2: StatusCode code
}

struct RealRead {
    1: double value,
    2: StatusCode code
}

struct RealArrayRead {
    1: list<double> value,
    2: StatusCode code
}

struct StringRead {
    1: string value,
    2: StatusCode code
}

struct StringArrayRead {
    1: list<string> value,
    2: StatusCode code
}

struct BooleanRead {
    1: bool value,
    2: StatusCode code
}

struct BooleanArrayRead {
    1: list<bool> value,
    2: StatusCode code
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
    INPUT_CAUSALITY = 0,
    OUTPUT_CAUSALITY = 1,
    PARAMETER_CAUSALITY = 2,
    CALCULATED_PARAMETER_CAUSALITY = 3,
    LOCAL_CAUSALITY = 4,
    INDEPENDENT_CAUSALITY = 5
}

enum Variability {
    CONSTANT_VARIABILITY =  0,
    FIXED_VARIABILITY = 1,
    CONTINUOUS_VARIABILITY = 2,
    DISCRETE_VARIABILITY = 3,
    TUNABLE_VARIABILITY = 4
}

enum Initial {
    EXACT_INITIAL = 0,
    APPROX_INITIAL = 1,
    CALCULATED_INITIAL = 2
}

enum DependenciesKind {
    DEPENDENT_KIND = 0,
    CONSTANT_KIND = 1,
    TUNABLE_KIND = 2,
    DISCRETE_KIND = 3
}

enum VariableNamingConvention {
    FLAT = 0,
    STRUCTURED = 1
}

struct Solver {
    1: string name,
    2: string settings
}
