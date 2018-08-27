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

#include <fmuproxy/grpc/client/RemoteFmuSlave.hpp>

using namespace std;
using namespace grpc;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::client;

RemoteFmuSlave::RemoteFmuSlave(const string instance_id, FmuService::Stub &stub, fmuproxy::fmi::ModelDescription &modelDescription)
        : FmuSlave(modelDescription), instanceId_(instance_id), stub_(stub) {}

void RemoteFmuSlave::init(const double start, const double stop) {

    ClientContext ctx;
    StatusResponse response;
    
    InitRequest request;
    request.set_instance_id(instanceId_);
    request.set_start(start);
    request.set_stop(stop);

    stub_.Init(&ctx, request, &response);
    simulationTime_ = start;
}

fmi2_status_t RemoteFmuSlave::step(const double step_size) {

    ClientContext ctx;
    StepResponse response;
    
    StepRequest request;
    request.set_instance_id(instanceId_);
    request.set_step_size(step_size);

    stub_.Step(&ctx, request, &response);
    simulationTime_ = response.simulation_time();
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::cancelStep() {
    return convert(DISCARD_STATUS);
}

fmi2_status_t RemoteFmuSlave::terminate() {

    ClientContext ctx;
    StatusResponse response;
    
    TerminateRequest request;
    request.set_instance_id(instanceId_);

    stub_.Terminate(&ctx, request, &response);
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::reset() {
    
    ClientContext ctx;
    StatusResponse response;
    
    ResetRequest request;
    request.set_instance_id(instanceId_);

    stub_.Reset(&ctx, request, &response);
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::readInteger(const fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _ref(1);
    const auto status = this->readInteger(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readInteger(const vector<fmi2_value_reference_t> &vr, vector<fmi2_integer_t> &ref) {

    ClientContext ctx;
    IntegerRead response;
    
    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }

    stub_.ReadInteger(&ctx, request, &response);
    ref.clear();
    for (const auto v : response.values()) {
        ref.push_back(v);
    }
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::readReal(const fmi2_value_reference_t vr, fmi2_real_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _ref(1);
    const auto status = this->readReal(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readReal(const vector<fmi2_value_reference_t> &vr, vector<fmi2_real_t> &ref) {

    ClientContext ctx;
    RealRead response;
    
    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
       _vr->Add(v);
    }

    stub_.ReadReal(&ctx, request, &response);
    ref.clear();
    for (const auto v : response.values()) {
        ref.push_back(v);
    }
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::readString(const fmi2_value_reference_t vr, fmi2_string_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_string_t > _ref(1);
    const auto status = this->readString(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readString(const vector<fmi2_value_reference_t> &vr, vector<fmi2_string_t> &ref) {
    
    ClientContext ctx;
    StringRead response;
    
    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }

    stub_.ReadString(&ctx, request, &response);
    ref.clear();
    for (const auto v : response.values()) {
        ref.push_back(v.c_str());
    }
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::readBoolean(const fmi2_value_reference_t vr, fmi2_boolean_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_boolean_t > _ref(1);
    const auto status = this->readBoolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readBoolean(const vector<fmi2_value_reference_t> &vr, vector<fmi2_boolean_t> &ref) {

    ClientContext ctx;
    BooleanRead response;
    
    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }

    stub_.ReadBoolean(&ctx, request, &response);
    ref.clear();
    for (const auto v : response.values()) {
        ref.push_back(v ? 1 : 0);
    }
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::writeInteger(const fmi2_value_reference_t vr, const fmi2_integer_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _value = {value};
    return writeInteger(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeInteger(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_integer_t> &value) {

    ClientContext ctx;
    StatusResponse response;
    
    WriteIntegerRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto v : value) {
        _values->Add(v);
    }

    stub_.WriteInteger(&ctx, request, &response);
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::writeReal(const fmi2_value_reference_t vr, const fmi2_real_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _value = {value};
    return writeReal(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeReal(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_real_t> &value) {
    
    ClientContext ctx;
    StatusResponse response;
    
    WriteRealRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto v : value) {
        _values->Add(v);
    }
   
    stub_.WriteReal(&ctx, request, &response);
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::writeString(const fmi2_value_reference_t vr, const fmi2_string_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_string_t > _value = {value};
    return writeString(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeString(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_string_t> &value) {

    ClientContext ctx;
    StatusResponse response;
    
    WriteStringRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto v : value) {
        _values->Add(v);
    }

    stub_.WriteString(&ctx, request, &response);
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::writeBoolean(const fmi2_value_reference_t vr, const fmi2_boolean_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_boolean_t > _value = {value};
    return writeBoolean(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeBoolean(const vector<fmi2_value_reference_t> &vr, const vector<fmi2_boolean_t> &value) {

    ClientContext ctx;
    StatusResponse response;
    
    WriteBooleanRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto v : value) {
        _values->Add(v != 0);
    }
   
    stub_.WriteBoolean(&ctx, request, &response);
    return convert(response.status());
}

bool RemoteFmuSlave::canGetAndSetFMUstate() const {

    ClientContext ctx;
    Bool response;

    CanGetAndSetFMUstateRequest request;
    request.set_instance_id(instanceId_);
    stub_.CanGetAndSetFMUstate(&ctx, request, &response);
    return response.value();
}

bool RemoteFmuSlave::canSerializeFMUstate() const {

    ClientContext ctx;
    Bool response;

    CanSerializeFMUstateRequest request;
    request.set_instance_id(instanceId_);
    stub_.CanSerializeFMUstate(&ctx, request, &response);
    return response.value();
}

fmi2_status_t RemoteFmuSlave::getFMUstate(int64_t &state) {

    ClientContext ctx;
    GetFMUstateResponse response;

    GetFMUstateRequest request;
    request.set_instance_id(instanceId_);
    stub_.GetFMUstate(&ctx, request, &response);

    state = response.state();
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::setFMUstate(const int64_t state) {

    ClientContext ctx;
    StatusResponse response;

    SetFMUstateRequest request;
    request.set_state(state);
    request.set_instance_id(instanceId_);
    stub_.SetFMUstate(&ctx, request, &response);

    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::freeFMUstate(int64_t &state) {

    ClientContext ctx;
    StatusResponse response;

    FreeFMUstateRequest request;
    request.set_state(state);
    request.set_instance_id(instanceId_);

    stub_.FreeFMUstate(&ctx, request, &response);
    state = -1; //invalidate state
    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::serializeFMUstate(const int64_t state, string &serializedState) {

    ClientContext ctx;
    SerializeFMUstateResponse response;

    SerializeFMUstateRequest request;
    request.set_instance_id(instanceId_);
    request.set_state(state);

    serializedState = response.state();

    return convert(response.status());
}

fmi2_status_t RemoteFmuSlave::deSerializeFMUstate(const string serializedState, int64_t &state) {
    ClientContext ctx;
    DeSerializeFMUstateResponse response;

    DeSerializeFMUstateRequest request;
    request.set_instance_id(instanceId_);
    request.set_state(serializedState);

    state = response.state();

    return convert(response.status());
}
