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
#include "grpc_client_helper.cpp"

using namespace std;
using namespace grpc;
using namespace fmuproxy::fmi;
using namespace fmuproxy::grpc::client;

RemoteFmuSlave::RemoteFmuSlave(const unsigned int instance_id, fmuproxy::grpc::FmuService::Stub &stub, fmuproxy::fmi::ModelDescription &modelDescription)
        : FmuSlave(modelDescription), instanceId_(instance_id), stub_(stub) {}

void RemoteFmuSlave::init(const double start, const double stop) {
    InitRequest req;
    req.set_instance_id(instanceId_);
    req.set_start(start);
    req.set_stop(stop);
    StatusResponse response;
    ClientContext ctx;
    stub_.Init(&ctx, req, &response);
    simulationTime_ = start;
}

fmi2_status_t RemoteFmuSlave::step(const double step_size) {
    StepRequest req;
    req.set_instance_id(instanceId_);
    req.set_step_size(step_size);
    StepResult resp;
    ClientContext ctx;
    stub_.Step(&ctx, req, &resp);
    simulationTime_ = resp.simulation_time();
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::cancelStep() {
    return convert(DISCARD_STATUS);
}

fmi2_status_t RemoteFmuSlave::terminate() {
    UInt req;
    req.set_value(instanceId_);
    ClientContext ctx;
    StatusResponse resp;
    stub_.Terminate(&ctx, req, &resp);
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::reset() {
    UInt req;
    req.set_value(instanceId_);
    ClientContext ctx;
    StatusResponse resp;
    stub_.Reset(&ctx, req, &resp);
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::readInteger(const fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _ref(1);
    const auto status = this->readInteger(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readInteger(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_integer_t> &ref) {
    ReadRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    ClientContext ctx;
    IntegerRead resp;
    stub_.ReadInteger(&ctx, req, &resp);
    ref.clear();
    for (const auto v : resp.values()) {
        ref.push_back(v);
    }
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::readReal(const fmi2_value_reference_t vr, fmi2_real_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _ref(1);
    const auto status = this->readReal(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readReal(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_real_t> &ref) {
    ReadRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
       _vr->Add(v);
    }
    ClientContext ctx;
    RealRead resp;
    stub_.ReadReal(&ctx, req, &resp);
    ref.clear();
    for (const auto v : resp.values()) {
        ref.push_back(v);
    }
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::readString(const fmi2_value_reference_t vr, fmi2_string_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_string_t > _ref(1);
    const auto status = this->readString(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readString(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_string_t> &ref) {
    ReadRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    ClientContext ctx;
    StringRead resp;
    stub_.ReadString(&ctx, req, &resp);
    ref.clear();
    for (const auto v : resp.values()) {
        ref.push_back(v.c_str());
    }
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::readBoolean(const fmi2_value_reference_t vr, fmi2_boolean_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_boolean_t > _ref(1);
    const auto status = this->readBoolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuSlave::readBoolean(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_boolean_t> &ref) {
    ReadRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    ClientContext ctx;
    BooleanRead resp;
    stub_.ReadBoolean(&ctx, req, &resp);
    ref.clear();
    for (const auto v : resp.values()) {
        ref.push_back(v ? 1 : 0);
    }
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::writeInteger(const fmi2_value_reference_t vr, const fmi2_integer_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _value = {value};
    return writeInteger(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeInteger(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_integer_t> &value) {
    WriteIntegerRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = req.mutable_values();
    for (const auto v : value) {
        _values->Add(v);
    }
    ClientContext ctx;
    StatusResponse resp;
    stub_.WriteInteger(&ctx, req, &resp);
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::writeReal(const fmi2_value_reference_t vr, const fmi2_real_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _value = {value};
    return writeReal(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeReal(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_real_t> &value) {
    WriteRealRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = req.mutable_values();
    for (const auto v : value) {
        _values->Add(v);
    }
    ClientContext ctx;
    StatusResponse resp;
    stub_.WriteReal(&ctx, req, &resp);
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::writeString(const fmi2_value_reference_t vr, const fmi2_string_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_string_t > _value = {value};
    return writeString(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeString(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_string_t> &value) {
    WriteStringRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = req.mutable_values();
    for (const auto v : value) {
        _values->Add(v);
    }
    ClientContext ctx;
    StatusResponse resp;
    stub_.WriteString(&ctx, req, &resp);
    return convert(resp.status());
}

fmi2_status_t RemoteFmuSlave::writeBoolean(const fmi2_value_reference_t vr, const fmi2_boolean_t value) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_boolean_t > _value = {value};
    return writeBoolean(_vr, _value);
}

fmi2_status_t RemoteFmuSlave::writeBoolean(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_boolean_t> &value) {
    WriteBooleanRequest req;
    req.set_instance_id(instanceId_);
    auto _vr = req.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }
    auto _values = req.mutable_values();
    for (const auto v : value) {
        _values->Add(v != 0);
    }
    ClientContext ctx;
    StatusResponse resp;
    stub_.WriteBoolean(&ctx, req, &resp);
    return convert(resp.status());
}
