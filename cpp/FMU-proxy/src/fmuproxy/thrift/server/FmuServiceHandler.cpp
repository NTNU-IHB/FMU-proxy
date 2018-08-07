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

#include <fmuproxy/fmi/Fmu.hpp>
#include <fmuproxy/thrift/server/FmuServiceHandler.hpp>

#include "thrift_server_helper.cpp"

using namespace std;
using namespace fmuproxy;
using namespace fmuproxy::thrift::server;

FmuServiceHandler::FmuServiceHandler(fmi::Fmu &fmu): fmu(fmu) {}

void FmuServiceHandler::getModelDescriptionXml(std::string &_return) {
    _return = fmu.get_model_description_xml();
}

void FmuServiceHandler::getModelDescription(ModelDescription &_return) {
    thriftType(_return, fmu.get_model_description());
}

InstanceId FmuServiceHandler::createInstanceFromCS() {
    InstanceId my_id = ID_GEN++;
    instances[my_id] = fmu.new_instance();
    cout << "Created new FMU instance with id=" << my_id << endl;
    return my_id;
}

InstanceId FmuServiceHandler::createInstanceFromME(const Solver &solver) {
    return 0;
}

double FmuServiceHandler::getSimulationTime(const InstanceId instance_id) {
    auto& instance = instances[instance_id];
    return instance->getCurrentTime();
}

bool FmuServiceHandler::isTerminated(const InstanceId instance_id) {
    auto& instance = instances[instance_id];
    return instance->isTerminated();
}

Status::type FmuServiceHandler::init(const InstanceId instance_id, const double start, const double stop) {
    auto& instance = instances[instance_id];
    instance->init(start, stop);
    return ::Status::OK_STATUS;
}

void FmuServiceHandler::step(StepResult &_return, const InstanceId instance_id, const double step_size) {
    auto& instance = instances[instance_id];
    fmi2_status_t status = instance->step(step_size);
    _return.simulationTime = instance->getCurrentTime();
    _return.status = thriftType(status);
}

Status::type FmuServiceHandler::terminate(const InstanceId instance_id) {
    auto& instance = instances[instance_id];
    Status::type status = thriftType(instance->terminate());
    instances.erase(instance_id);
    return status;
}

Status::type FmuServiceHandler::reset(const InstanceId instance_id) {
    auto& instance = instances[instance_id];
    return thriftType(instance->reset());
}

void FmuServiceHandler::readInteger(IntegerRead &_return, const InstanceId instance_id, const ValueReferences &vr) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_integer_t >(vr.size());
    _return.status = thriftType(instance->readInteger(_vr, _value));
    _return.value = _value;
}

void FmuServiceHandler::readReal(RealRead &_return, const InstanceId instance_id, const ValueReferences &vr) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_real_t >(vr.size());
    _return.status = thriftType(instance->readReal(_vr, _value));
    _return.value = _value;
}


void FmuServiceHandler::readString(StringRead &_return, const InstanceId instance_id, const ValueReferences &vr) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_string_t>(vr.size());
    _return.status = thriftType(instance->readString(_vr, _value));
    _return.value = vector<string>(_value.begin(), _value.end());
}

void FmuServiceHandler::readBoolean(BooleanRead &_return, const InstanceId instance_id, const ValueReferences &vr) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_boolean_t >(vr.size());
    _return.status = thriftType(instance->readBoolean(_vr, _value));
    _return.value = vector<bool>(_value.begin(), _value.end());
}

Status::type FmuServiceHandler::writeInteger(const InstanceId instance_id, const ValueReferences &vr, const IntArray &value) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    const auto status = instance->writeInteger(_vr, value);
    return thriftType(status);
}


Status::type FmuServiceHandler::writeReal(const InstanceId instance_id, const ValueReferences &vr, const RealArray &value) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    const auto status = instance->writeReal(_vr, value);
    return thriftType(status);
}


Status::type FmuServiceHandler::writeString(const InstanceId instance_id, const ValueReferences &vr, const StringArray &value) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    return Status::type::DISCARD_STATUS;
}


Status::type FmuServiceHandler::writeBoolean(const InstanceId instance_id, const ValueReferences &vr, const BooleanArray &value) {
    auto& instance = instances[instance_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    return Status::type::DISCARD_STATUS;
}
