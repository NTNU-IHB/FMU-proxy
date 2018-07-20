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

RemoteFmuInstance::RemoteFmuInstance(const FmuId fmu_id, FmuServiceClient &client, fmuproxy::fmi::ModelDescription &md)
        : fmu_id(fmu_id), client(client), modelDescription(md) {
    current_time = client.getCurrentTime(fmu_id);
}

double RemoteFmuInstance::getCurrentTime() const {
    return current_time;
}

fmuproxy::fmi::ModelDescription &RemoteFmuInstance::getModelDescription() const {
    return modelDescription;
}

void RemoteFmuInstance::init() {
    init(0.0, 0.0);
}

void RemoteFmuInstance::init(double start) {
    init(start, 0.0);
}

void RemoteFmuInstance::init(double start, double stop) {
    convert(client.init(fmu_id, start, stop));
}

fmi2_status_t RemoteFmuInstance::step(double step_size) {
    client.step(stepResult, fmu_id, step_size);
    current_time = stepResult.simulationTime;
    return convert(stepResult.status);
}

fmi2_status_t RemoteFmuInstance::terminate() {
    return convert(client.terminate(fmu_id));
}

fmi2_status_t RemoteFmuInstance::reset() {
    return convert(client.reset(fmu_id));
}

fmi2_status_t RemoteFmuInstance::readInteger(fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    client.readInteger(integerRead, fmu_id, vr);
    ref = integerRead.value;
    return convert(integerRead.status);
}

fmi2_status_t RemoteFmuInstance::readInteger(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_integer_t> &ref) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.bulkReadInteger(bulkIntegerRead, fmu_id, _vr);
    ref = bulkIntegerRead.value;
    return convert(bulkIntegerRead.status);
}

fmi2_status_t RemoteFmuInstance::readReal(fmi2_value_reference_t vr, fmi2_real_t &ref) {
    client.readReal(realRead, fmu_id, vr);
    ref = realRead.value;
    return convert(realRead.status);
}

fmi2_status_t RemoteFmuInstance::readReal(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_real_t> &ref) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.bulkReadReal(bulkRealRead, fmu_id, _vr);
    ref = bulkRealRead.value;
    return convert(bulkRealRead.status);
}

fmi2_status_t RemoteFmuInstance::readString(fmi2_value_reference_t vr, fmi2_string_t &ref) {
    client.readString(stringRead, fmu_id, vr);
    ref = stringRead.value.c_str();
    return convert(stringRead.status);
}

fmi2_status_t RemoteFmuInstance::readString(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_string_t > &ref) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.bulkReadString(bulkStringRead, fmu_id, _vr);
    const vector<string> read = bulkStringRead.value;
    std::transform(read.begin(), read.end(), std::back_inserter(ref), convert_string);
    return convert(bulkStringRead.status);
}

fmi2_status_t RemoteFmuInstance::readBoolean(fmi2_value_reference_t vr, fmi2_boolean_t &ref){
    client.readBoolean(booleanRead, fmu_id, vr);
    ref = booleanRead.value;
    return convert(booleanRead.status);
}

fmi2_status_t RemoteFmuInstance::readBoolean(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_boolean_t> &ref) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    client.bulkReadBoolean(bulkBooleanRead, fmu_id, _vr);
    const vector<bool> read = bulkBooleanRead.value;
    ref = vector<fmi2_boolean_t>(read.begin(), read.end());
    return convert(bulkBooleanRead.status);
}

fmi2_status_t RemoteFmuInstance::writeInteger(fmi2_value_reference_t vr, const fmi2_integer_t value) {
    return convert(client.writeInteger(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeInteger(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_integer_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    return convert(client.bulkWriteInteger(fmu_id, _vr, value));
}

fmi2_status_t RemoteFmuInstance::writeReal(fmi2_value_reference_t vr, const fmi2_real_t value) {
    return convert(client.writeReal(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeReal(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_real_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    return convert(client.bulkWriteReal(fmu_id, _vr, value));
}

fmi2_status_t RemoteFmuInstance::writeString(fmi2_value_reference_t vr, const fmi2_string_t value) {
    return convert(client.writeString(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeString(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_string_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    const StringArray _value = vector<string>(value.begin(), value.end());
    return convert(client.bulkWriteString(fmu_id, _vr, _value));
}

fmi2_status_t RemoteFmuInstance::writeBoolean(fmi2_value_reference_t vr, const fmi2_boolean_t value) {
    return convert(client.writeBoolean(fmu_id, vr, value != 0));
}

fmi2_status_t RemoteFmuInstance::writeBoolean(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_boolean_t> &value) {
    const ValueReferences _vr = vector<int>(vr.begin(), vr.end());
    const BooleanArray _value = vector<bool>(value.begin(), value.end());
    return convert(client.bulkWriteBoolean(fmu_id, _vr, _value));
}


