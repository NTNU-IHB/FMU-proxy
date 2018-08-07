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
#include <fmuproxy/thrift/client/RemoteFmuInstance.hpp>

#include "thrift_client_helper.cpp"

using namespace std;
using namespace fmuproxy::thrift::client;

RemoteFmuInstance::RemoteFmuInstance(const InstanceId fmu_id, FmuServiceClient &client, fmuproxy::fmi::ModelDescription &md)
        : instance_id(fmu_id), client(client), modelDescription(md) {
    simulation_time = client.getSimulationTime(fmu_id);
}

double RemoteFmuInstance::getCurrentTime() const {
    return simulation_time;
}

fmuproxy::fmi::ModelDescription &RemoteFmuInstance::getModelDescription() const {
    return modelDescription;
}

void RemoteFmuInstance::init(const double start, const double stop) {
    convert(client.init(instance_id, start, stop));
}

fmi2_status_t RemoteFmuInstance::step(const double step_size) {
    StepResult stepResult;
    client.step(stepResult, instance_id, step_size);
    simulation_time = stepResult.simulationTime;
    return convert(stepResult.status);
}

fmi2_status_t RemoteFmuInstance::terminate() {
    return convert(client.terminate(instance_id));
}

fmi2_status_t RemoteFmuInstance::reset() {
    return convert(client.reset(instance_id));
}

fmi2_status_t RemoteFmuInstance::readInteger(fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_integer_t > _ref(1);
    const auto status = this->readInteger(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuInstance::readInteger(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_integer_t> &ref) {
    IntegerRead integerRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.readInteger(integerRead, instance_id, _vr);
    ref = integerRead.value;
    return convert(integerRead.status);
}

fmi2_status_t RemoteFmuInstance::readReal(fmi2_value_reference_t vr, fmi2_real_t &ref) {
    vector<fmi2_value_reference_t > _vr = {vr};
    vector<fmi2_real_t > _ref(1);
    const auto status = this->readReal(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2_status_t RemoteFmuInstance::readReal(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_real_t> &ref) {
    RealRead realRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.readReal(realRead, instance_id, _vr);
    ref = realRead.value;
    return convert(realRead.status);
}

fmi2_status_t RemoteFmuInstance::readString(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_string_t > &ref) {
    StringRead stringRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.readString(stringRead, instance_id, _vr);
    const vector<string> read = stringRead.value;
    std::transform(read.begin(), read.end(), std::back_inserter(ref), convert_string);
    return convert(stringRead.status);
}


fmi2_status_t RemoteFmuInstance::readBoolean(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_boolean_t> &ref) {
    BooleanRead booleanRead;
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.readBoolean(booleanRead, instance_id, _vr);
    const vector<bool> read = booleanRead.value;
    ref = vector<fmi2_boolean_t>(read.begin(), read.end());
    return convert(booleanRead.status);
}

fmi2_status_t RemoteFmuInstance::writeInteger(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_integer_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    return convert(client.writeInteger(instance_id, _vr, value));
}


fmi2_status_t RemoteFmuInstance::writeReal(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_real_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    return convert(client.writeReal(instance_id, _vr, value));
}

fmi2_status_t RemoteFmuInstance::writeString(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_string_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    const StringArray _value = vector<string>(value.begin(), value.end());
    return convert(client.writeString(instance_id, _vr, _value));
}

fmi2_status_t RemoteFmuInstance::writeBoolean(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_boolean_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    const BooleanArray _value = vector<bool>(value.begin(), value.end());
    return convert(client.writeBoolean(instance_id, _vr, _value));
}


