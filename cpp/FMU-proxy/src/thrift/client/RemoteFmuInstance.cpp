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
#include "RemoteFmuInstance.hpp"
#include "Helper.cpp"

using namespace std;
using namespace fmuproxy::thrift::client;

RemoteFmuInstance::RemoteFmuInstance(FmuId fmu_id, FmuServiceClient &client): fmu_id(fmu_id), client(client) {
    current_time = client.getCurrentTime(fmu_id);
}

double RemoteFmuInstance::getCurrentTime() {
    return current_time;
}

fmi2_status_t RemoteFmuInstance::init() {
    return init(0.0, 0.0);
}

fmi2_status_t RemoteFmuInstance::init(double start) {
    return init(start, 0.0);
}

fmi2_status_t RemoteFmuInstance::init(double start, double stop) {
    return convert(client.init(fmu_id, start, stop));
}

fmi2_status_t RemoteFmuInstance::step(StepResult& result, double step_size) {
    client.step(result, fmu_id, step_size);
    current_time = result.simulationTime;
    return convert(result.status);
}

fmi2_status_t RemoteFmuInstance::terminate() {
    return convert(client.terminate(fmu_id));
}

fmi2_status_t RemoteFmuInstance::reset() {
    return convert(client.reset(fmu_id));
}

void RemoteFmuInstance::readInteger(IntegerRead& read, ValueReference vr) {
    return client.readInteger(read, fmu_id, vr);
}

void RemoteFmuInstance::readInteger(BulkIntegerRead& read, ValueReferences vr) {
    return client.bulkReadInteger(read, fmu_id, vr);
}

void RemoteFmuInstance::readReal(RealRead &read, ValueReference vr) {
    return client.readReal(read, fmu_id, vr);
}

void RemoteFmuInstance::readReal(BulkRealRead &read, ValueReferences vr) {
    return client.bulkReadReal(read, fmu_id, vr);
}

void RemoteFmuInstance::readString(StringRead &read, ValueReference vr) {
    return client.readString(read, fmu_id, vr);
}

void RemoteFmuInstance::readString(BulkStringRead &read, ValueReferences vr) {
    return client.bulkReadString(read, fmu_id, vr);
}

void RemoteFmuInstance::readBoolean(BooleanRead &read, ValueReference vr) {
    return client.readBoolean(read, fmu_id, vr);
}

void RemoteFmuInstance::readBoolean(BulkBooleanRead &read, ValueReferences vr) {
    return client.bulkReadBoolean(read, fmu_id, vr);
}

fmi2_status_t RemoteFmuInstance::writeInteger(ValueReference vr, int value) {
    return convert(client.writeInteger(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeInteger(ValueReferences vr, vector<int> value) {
    return convert(client.bulkWriteInteger(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeReal(ValueReference vr, double value) {
    return convert(client.writeReal(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeString(ValueReference vr, string value) {
    return convert(client.writeString(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeBoolean(ValueReference vr, bool value) {
    return convert(client.writeBoolean(fmu_id, vr, value));
}
