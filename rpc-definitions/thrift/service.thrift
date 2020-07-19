/*
 * The MIT License
 *
 * Copyright 2017-2019 Norwegian University of Technology (NTNU)
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

namespace cpp fmuproxy.thrift
namespace java no.ntnu.ihb.fmuproxy.thrift

typedef string FmuId
typedef string InstanceId
typedef i64 ValueReference
typedef i64 FmuState
typedef list<double> DirectionalDerivative
typedef list<ValueReference> ValueReferences
typedef list<i32> IntArray
typedef list<double> RealArray
typedef list<string> StringArray
typedef list<bool> BooleanArray


enum Status {
    OK_STATUS = 0,
    WARNING_STATUS = 1,
    DISCARD_STATUS = 2,
    ERROR_STATUS = 3,
    FATAL_STATUS = 4,
    PENDING_STATUS = 5
}

struct IntegerAttribute {
    1: i32 min,
    2: i32 max,
    3: i32 start,
    4: string quantity
}

struct RealAttribute {
    1: double min,
    2: double max,
    3: double start,
    4: string quantity
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
    3: i32 start,
    4: string quantity
}

union ScalarVariableAttribute {
    1: IntegerAttribute integer_attribute,
    2: RealAttribute real_attribute,
    3: StringAttribute string_attribute,
    4: BooleanAttribute boolean_attribute,
    5: EnumerationAttribute enumeration_attribute
}

struct ScalarVariable {
    1: string name,
    2: ValueReference value_reference,
    3: optional string description,
    4: optional string initial,
    5: optional string causality,
    6: optional string variability,
    7: ScalarVariableAttribute attribute
}

typedef list<ScalarVariable> ModelVariables

struct Unknown {
    1: i32 index,
    2: list<i32> dependencies,
    3: list<string> dependencies_kind
}

struct ModelStructure {
    1: list<Unknown> outputs,
    2: list<Unknown> derivatives,
    3: list<Unknown> initial_unknowns
}

struct DefaultExperiment {
    1: double startTime,
    2: double stopTime,
    3: double tolerance,
    4: double stepSize
}

struct StepResult {
    1: Status status,
    2: double simulation_time
}

struct IntegerRead {
    1: list<i32> value,
    2: Status status
}

struct RealRead {
    1: list<double> value,
    2: Status status
}

struct StringRead {
    1: list<string> value,
    2: Status status
}

struct BooleanRead {
    1: list<bool> value,
    2: Status status
}

struct ModelDescription {
    1: string guid,
    2: string fmi_version,
    3: string modelName,
    4: optional string license,
    5: optional string copyright,
    6: optional string author,
    7: optional string version,
    8: optional string description,
    9: optional string generation_tool,
    10: optional string generation_date_and_time,
    11: optional DefaultExperiment default_experiment,
    12: optional string variable_naming_convention,
    13: ModelVariables model_variables,
    14: ModelStructure model_structure,
	
    15: string model_identifier,
    16: bool can_get_and_set_fmu_state,
    17: bool can_serialize_fmu_state,
    18: bool provides_directional_derivative,
    19: bool can_handle_variable_communication_step_size,
    20: bool can_interpolate_inputs,
    21: i32 max_output_derivative_order
}

exception NoSuchVariableException {
    1: string message
}

exception UnsupportedOperationException {
    1: string message
}

struct DirectionalDerivativeResult {
    1: DirectionalDerivative dv_unknown_ref
    2: Status status
}

service FmuService {

    ModelDescription get_model_description()

    void instantiate()

    Status setup_experiment(1: double start, 2: double stop, 3: double tolerance)
    Status enter_initialization_mode()
    Status exit_initialization_mode()
    
    StepResult step(1: double stepSize)
    Status reset()
    Status terminate()
    void close()

    IntegerRead read_integer(1: ValueReferences vr) throws (1: NoSuchVariableException ex)
    RealRead read_real(1: ValueReferences vr) throws (1: NoSuchVariableException ex)
    StringRead read_string(1: ValueReferences vr) throws (1: NoSuchVariableException ex)
    BooleanRead read_boolean(1: ValueReferences vr) throws (1: NoSuchVariableException ex)

    Status write_integer(1: ValueReferences vr, 2: IntArray value) throws (1: NoSuchVariableException ex)
    Status write_real(1: ValueReferences vr, 2: RealArray value) throws (1: NoSuchVariableException ex)
    Status write_string(1: ValueReferences vr, 2: StringArray value) throws (1: NoSuchVariableException ex)
    Status write_boolean(1: ValueReferences vr, 2: BooleanArray value) throws (1: NoSuchVariableException ex)

    DirectionalDerivativeResult get_directional_derivative(1: ValueReferences vUnknownRef, 2: ValueReferences vKnownRef, 3: list<double> dvKnownRef) throws (1: UnsupportedOperationException ex)
    
}
