/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
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

#include <vector>
#include <algorithm>
#include <iostream>
#include <fmuproxy/thrift/client/remote_fmu_slave.hpp>

#include "thrift_client_helper.hpp"

using namespace fmuproxy::thrift::client;

remote_fmu_slave::remote_fmu_slave(const InstanceId &instanceId, fmu_service_client &client,
                               const fmi4cpp::fmi2::model_description_base &modelDescription)
        : instanceId_(instanceId), client_(client) {

    CoSimulationAttributes attributes;
    client_.get_co_simulation_attributes(attributes, instanceId_);
    csModelDescription_ = std::make_shared<const fmi4cpp::fmi2::cs_model_description>(modelDescription,
                                                                                              convert(attributes));
}

bool remote_fmu_slave::update_status_and_return_true_on_ok(Status::type status) {
    lastStatus_ = status;
    return status == Status::type::OK_STATUS;
}

fmi4cpp::status remote_fmu_slave::last_status() const {
    return convert(lastStatus_);
}

std::shared_ptr<const fmi4cpp::fmi2::cs_model_description> remote_fmu_slave::get_model_description() const {
    return csModelDescription_;
}


bool remote_fmu_slave::setup_experiment(double startTime, double stopTime, double tolerance) {
    return update_status_and_return_true_on_ok(client_.setup_experiment(instanceId_, startTime, stopTime, tolerance));
}

bool remote_fmu_slave::enter_initialization_mode() {
    return update_status_and_return_true_on_ok(client_.enter_initialization_mode(instanceId_));
}

bool remote_fmu_slave::exit_initialization_mode() {
    return update_status_and_return_true_on_ok(client_.exit_initialization_mode(instanceId_));
}

bool remote_fmu_slave::step(const double step_size) {
    StepResult stepResult;
    client_.step(stepResult, instanceId_, step_size);
    simulationTime_ = stepResult.simulation_time;
    return update_status_and_return_true_on_ok(stepResult.status);
}

bool remote_fmu_slave::cancel_step() {
    return update_status_and_return_true_on_ok(Status::type::DISCARD_STATUS);
}

bool remote_fmu_slave::terminate() {
    if (!terminated_) {
        terminated_ = true;
        return update_status_and_return_true_on_ok(client_.terminate(instanceId_));
    } else {
        return true;
    }
}

bool remote_fmu_slave::reset() {
    return update_status_and_return_true_on_ok(client_.reset(instanceId_));
}

bool remote_fmu_slave::read_integer(const fmi2ValueReference vr, fmi2Integer &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Integer> _ref(1);
    const auto status = this->read_integer(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_integer(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Integer> &ref) {
    IntegerRead integerRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.read_integer(integerRead, instanceId_, _vr);
    ref = integerRead.value;
    return update_status_and_return_true_on_ok(integerRead.status);
}

bool remote_fmu_slave::read_real(const fmi2ValueReference vr, fmi2Real &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Real> _ref(1);
    const auto status = this->read_real(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_real(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Real> &ref) {
    RealRead realRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.read_real(realRead, instanceId_, _vr);
    ref = realRead.value;
    return update_status_and_return_true_on_ok(realRead.status);
}

bool remote_fmu_slave::read_string(const fmi2ValueReference vr, fmi2String &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2String> _ref(1);
    const auto status = this->read_string(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_string(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2String> &ref) {
    StringRead stringRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.read_string(stringRead, instanceId_, _vr);
    const std::vector<std::string> read = stringRead.value;
    std::transform(read.begin(), read.end(), std::back_inserter(ref), [](std::string str) -> const char * {
        return str.c_str();
    });
    return update_status_and_return_true_on_ok(stringRead.status);
}

bool remote_fmu_slave::read_boolean(const fmi2ValueReference vr, fmi2Boolean &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Boolean> _ref(1);
    const auto status = this->read_boolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_boolean(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Boolean> &ref) {
    BooleanRead booleanRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.read_boolean(booleanRead, instanceId_, _vr);
    const std::vector<bool> read = booleanRead.value;
    ref = std::vector<fmi2Boolean>(read.begin(), read.end());
    return update_status_and_return_true_on_ok(booleanRead.status);
}

bool remote_fmu_slave::write_integer(const fmi2ValueReference vr, const fmi2Integer value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Integer> _value = {value};
    return write_integer(_vr, _value);
}

bool remote_fmu_slave::write_integer(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Integer> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    return update_status_and_return_true_on_ok(client_.write_integer(instanceId_, _vr, value));
}

bool remote_fmu_slave::write_real(const fmi2ValueReference vr, const fmi2Real value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Real> _value = {value};
    return write_real(_vr, _value);
}

bool remote_fmu_slave::write_real(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Real> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    return update_status_and_return_true_on_ok(client_.write_real(instanceId_, _vr, value));
}

bool remote_fmu_slave::write_string(const fmi2ValueReference vr, const fmi2String value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2String> _value = {value};
    return write_string(_vr, _value);
}

bool remote_fmu_slave::write_string(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2String> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    const StringArray _value = std::vector<std::string>(value.begin(), value.end());
    return update_status_and_return_true_on_ok(client_.write_string(instanceId_, _vr, _value));
}

bool remote_fmu_slave::write_boolean(const fmi2ValueReference vr, const fmi2Boolean value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Boolean> _value = {value};
    return write_boolean(_vr, _value);
}

bool remote_fmu_slave::write_boolean(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Boolean> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    const BooleanArray _value = std::vector<bool>(value.begin(), value.end());
    return update_status_and_return_true_on_ok(client_.write_boolean(instanceId_, _vr, _value));
}

bool remote_fmu_slave::get_directional_derivative(const std::vector<fmi2ValueReference> &vUnknownRef,
                                              const std::vector<fmi2ValueReference> &vKnownRef,
                                              const std::vector<fmi2Real> &dvKnownRef,
                                              std::vector<fmi2Real> &dvUnknown) {
    return update_status_and_return_true_on_ok(Status::type::ERROR_STATUS);
}

bool remote_fmu_slave::get_fmu_state(fmi2FMUstate &state) {
    return update_status_and_return_true_on_ok(Status::type::ERROR_STATUS);
}

bool remote_fmu_slave::set_fmu_state(const fmi2FMUstate state) {
    return update_status_and_return_true_on_ok(Status::type::ERROR_STATUS);
}

bool remote_fmu_slave::free_fmu_state(fmi2FMUstate &state) {
    return update_status_and_return_true_on_ok(Status::type::ERROR_STATUS);
}

bool remote_fmu_slave::serialize_fmu_state(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) {
    return update_status_and_return_true_on_ok(Status::type::ERROR_STATUS);
}

bool remote_fmu_slave::de_serialize_fmu_state(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) {
    return update_status_and_return_true_on_ok(Status::type::ERROR_STATUS);
}

remote_fmu_slave::~remote_fmu_slave() {
    terminate();
}


//bool remote_fmu_slave::getFMUstate(int64_t &state) {
//    GetFmuStateResult _return;
//    client_.getFMUstate(_return, instanceId_);
//    state = _return.state;
//    return convert(_return.status);
//}
//
//bool remote_fmu_slave::setFMUstate(int64_t state) {
//    return convert(client_.setFMUstate(instanceId_, state));
//}
//
//bool remote_fmu_slave::freeFMUstate(int64_t &state) {
//    return convert(client_.freeFMUstate(instanceId_, state));
//}
//
//bool remote_fmu_slave::serializeFMUstate(const int64_t state, std::string &serializedState) {
//    SerializeFmuStateResult result;
//    client_.serializeFMUstate(result, instanceId_, state);
//    serializedState = result.state;
//    return convert(result.status);
//}
//
//bool remote_fmu_slave::deSerializeFMUstate(const std::string serializedState, int64_t &state) {
//    DeSerializeFmuStateResult result;
//    client_.deSerializeFMUstate(result, instanceId_, serializedState.data());
//    state = result.state;
//    return convert(result.status);
//}

