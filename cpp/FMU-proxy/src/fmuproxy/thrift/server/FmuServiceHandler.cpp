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

#include "ThriftServerHelper.cpp"

int id_gen = 0;

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

FmuId FmuServiceHandler::createInstanceFromCS() {
    FmuId my_id = id_gen++;
    fmus[my_id] = fmu.new_instance();
    cout << "created new FMU instance with id=" << my_id << endl;
    return my_id;
}

FmuId FmuServiceHandler::createInstanceFromME(const Solver &solver) {
    return 0;
}

bool FmuServiceHandler::canGetAndSetFMUstate(const FmuId fmu_id) {
    return false;
}

double FmuServiceHandler::getCurrentTime(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    return instance->getCurrentTime();
}

bool FmuServiceHandler::isTerminated(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    return instance->isTerminated();
}

Status::type FmuServiceHandler::init(const FmuId fmu_id, const double start, const double stop) {
    auto& instance = fmus[fmu_id];
    instance->init(start, stop);
    return ::Status::OK_STATUS;
}

void FmuServiceHandler::step(StepResult &_return, const FmuId fmu_id, const double step_size) {
    auto& instance = fmus[fmu_id];
    fmi2_status_t status = instance->step(step_size);
    _return.simulationTime = instance->getCurrentTime();
    _return.status = thriftType(status);
}

Status::type FmuServiceHandler::terminate(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    Status::type status = thriftType(instance->terminate());
    fmus.erase(fmu_id);
    return status;
}

Status::type FmuServiceHandler::reset(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    return thriftType(instance->reset());
}

void FmuServiceHandler::readInteger(IntegerRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    fmi2_status_t status = instance->readInteger(vr, _return.value);
    _return.status = thriftType(status);
}

void FmuServiceHandler::bulkReadInteger(BulkIntegerRead &_return, const FmuId fmu_id, const ValueReferences &vr) {
    auto& instance = fmus[fmu_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_integer_t >(vr.size());
    _return.status = thriftType(instance->readInteger(_vr, _value));
    _return.value = _value;
}

void FmuServiceHandler::readReal(RealRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    fmi2_status_t status = instance->readReal(vr, _return.value);
    _return.status = thriftType(status);
}

void FmuServiceHandler::bulkReadReal(BulkRealRead &_return, const FmuId fmu_id, const ValueReferences &vr) {
    auto& instance = fmus[fmu_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_real_t >(vr.size());
    _return.status = thriftType(instance->readReal(_vr, _value));
    _return.value = _value;
}

void FmuServiceHandler::readString(StringRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    fmi2_string_t str;
    fmi2_status_t status = instance->readString(vr, str);
    _return.status = thriftType(status);
    _return.value = str;
}

void FmuServiceHandler::bulkReadString(BulkStringRead &_return, const FmuId fmu_id, const ValueReferences &vr) {
    auto& instance = fmus[fmu_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_string_t>(vr.size());
    _return.status = thriftType(instance->readString(_vr, _value));
    _return.value = vector<string>(_value.begin(), _value.end());
}

void FmuServiceHandler::readBoolean(BooleanRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    fmi2_boolean_t value;
    fmi2_status_t status = instance->readBoolean(vr, value);
    _return.status = thriftType(status);
    _return.value = value;
}

void FmuServiceHandler::bulkReadBoolean(BulkBooleanRead &_return, const FmuId fmu_id, const ValueReferences &vr) {
    auto& instance = fmus[fmu_id];
    const auto _vr = vector<fmi2_value_reference_t>(vr.begin(), vr.end());
    auto _value = vector<fmi2_boolean_t >(vr.size());
    _return.status = thriftType(instance->readBoolean(_vr, _value));
    _return.value = vector<bool>(_value.begin(), _value.end());
}

Status::type FmuServiceHandler::writeInteger(const FmuId fmu_id, const ValueReference vr, const int32_t value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteInteger(const FmuId fmu_id, const ValueReferences &vr, const IntArray &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::writeReal(const FmuId fmu_id, const ValueReference vr, const double value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteReal(const FmuId fmu_id, const ValueReferences &vr, const RealArray &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::writeString(const FmuId fmu_id, const ValueReference vr, const std::string &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteString(const FmuId fmu_id, const ValueReferences &vr, const StringArray &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::writeBoolean(const FmuId fmu_id, const ValueReference vr, const bool value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteBoolean(const FmuId fmu_id, const ValueReferences &vr, const BooleanArray &value) {
    return Status::type::DISCARD_STATUS;
}
