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
#include <fmuproxy/thrift/client/RemoteFmuSlave.hpp>
#include "thrift_client_helper.cpp"

using namespace std;
using namespace fmuproxy::thrift::client;

RemoteFmuSlave::RemoteFmuSlave(const InstanceId fmu_id, FmuServiceClient &client, fmuproxy::fmi::ModelDescription &md)
        : FmuSlave(md), instanceId_(fmu_id), client_(client){
}

void RemoteFmuSlave::init(const double start, const double stop) {
    simulationTime_ = start;
    convert(client_.init(instanceId_, start, stop));
}

fmi2_status_t RemoteFmuSlave::step(const double step_size) {
    StepResult stepResult;
    client_.step(stepResult, instanceId_, step_size);
    simulationTime_ = stepResult.simulationTime;
    return convert(stepResult.status);
}

fmi2_status_t RemoteFmuSlave::cancelStep() {
    return convert(Status::DISCARD_STATUS);
}

fmi2_status_t RemoteFmuSlave::terminate() {
    return convert(client_.terminate(instanceId_));
}

fmi2_status_t RemoteFmuSlave::reset() {
    return convert(client_.reset(instanceId_));
}

fmi2_status_t RemoteFmuSlave::readInteger(fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _ref(1);
    const auto status = this->readInteger(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readInteger(const vector<fmi2_value_reference_t> &vr, vector<fmi2_integer_t> &ref) {
    IntegerRead integerRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client_.readInteger(integerRead, instanceId_, _vr);
    ref = integerRead.value;
    return convert(integerRead.status);
}

fmi2_status_t RemoteFmuSlave::readReal(fmi2_value_reference_t vr, fmi2_real_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _ref(1);
    const auto status = this->readReal(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readReal(const vector<fmi2_value_reference_t> &vr, vector<fmi2_real_t> &ref) {
    RealRead realRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client_.readReal(realRead, instanceId_, _vr);
    ref = realRead.value;
    return convert(realRead.status);
}

fmi2_status_t RemoteFmuSlave::readString(fmi2_value_reference_t vr, fmi2_string_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_string_t > _ref(1);
    const auto status = this->readString(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readString(const vector<fmi2_value_reference_t> &vr, vector<fmi2_string_t > &ref) {
    StringRead stringRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client_.readString(stringRead, instanceId_, _vr);
    const vector<string> read = stringRead.value;
    std::transform(read.begin(), read.end(), std::back_inserter(ref), convert_string);
    return convert(stringRead.status);
}

fmi2_status_t RemoteFmuSlave::readBoolean(fmi2_value_reference_t vr, fmi2_boolean_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_boolean_t > _ref(1);
    const auto status = this->readBoolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readBoolean(const vector<fmi2_value_reference_t> &vr, vector<fmi2_boolean_t> &ref) {
    BooleanRead booleanRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client_.readBoolean(booleanRead, instanceId_, _vr);
    const vector<bool> read = booleanRead.value;
    ref = vector<fmi2_boolean_t>(read.begin(), read.end());
    return convert(booleanRead.status);
}

fmi2_status_t RemoteFmuSlave::writeInteger(const fmi2_value_reference_t vr, const fmi2_integer_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _value = {value};
    return writeInteger(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeInteger(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_integer_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    return convert(client_.writeInteger(instanceId_, _vr, value));
}

fmi2_status_t RemoteFmuSlave::writeReal(const fmi2_value_reference_t vr, const fmi2_real_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _value = {value};
    return writeReal(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeReal(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_real_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    return convert(client_.writeReal(instanceId_, _vr, value));
}

fmi2_status_t RemoteFmuSlave::writeString(const fmi2_value_reference_t vr, const fmi2_string_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_string_t > _value = {value};
    return writeString(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeString(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_string_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    const StringArray _value = vector<string>(value.begin(), value.end());
    return convert(client_.writeString(instanceId_, _vr, _value));
}

fmi2_status_t RemoteFmuSlave::writeBoolean(const fmi2_value_reference_t vr, const fmi2_boolean_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_boolean_t > _value = {value};
    return writeBoolean(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeBoolean(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_boolean_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    const BooleanArray _value = vector<bool>(value.begin(), value.end());
    return convert(client_.writeBoolean(instanceId_, _vr, _value));
}

bool RemoteFmuSlave::canGetAndSetFMUstate() const {
    return client_.canGetAndSetFMUstate(instanceId_);
}

bool RemoteFmuSlave::canSerializeFMUstate() const {
    return client_.canSerializeFMUstate(instanceId_);
}

fmi2_status_t RemoteFmuSlave::getFMUstate(int64_t &state) {
    GetFmuStateResult _return;
    client_.getFMUstate(_return, instanceId_);
    state = _return.state;
    return convert(_return.status);
}

fmi2_status_t RemoteFmuSlave::setFMUstate(int64_t state) {
    return convert(client_.setFMUstate(instanceId_, state));
}

fmi2_status_t RemoteFmuSlave::freeFMUstate(int64_t &state) {
    return convert(client_.freeFMUstate(instanceId_, state));
}

fmi2_status_t RemoteFmuSlave::serializeFMUstate(const int64_t state, string &serializedState) {
    SerializeFmuStateResult result;
    client_.serializeFMUstate(result, instanceId_, state);
    serializedState = result.state;
    return convert(result.status);
}

fmi2_status_t RemoteFmuSlave::deSerializeFMUstate(const string serializedState, int64_t &state) {
    DeSerializeFmuStateResult result;
    client_.deSerializeFMUstate(result, instanceId_, serializedState.data());
    state = result.state;
    return convert(result.status);
}

