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
#include "Helper.cpp"
#include "RemoteFmuInstance.hpp"

using namespace std;
using namespace fmuproxy::thrift::client;

RemoteFmuInstance::RemoteFmuInstance(FmuId fmu_id, FmuServiceClient &client, fmuproxy::fmi::ModelDescription &md)
        : fmu_id(fmu_id), client(client), modelDescription(md) {
    current_time = client.getCurrentTime(fmu_id);
}

double RemoteFmuInstance::getCurrentTime() const {
    return current_time;
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

fmi2_status_t RemoteFmuInstance::readInteger(unsigned int vr, int &ref) {
    client.readInteger(integerRead, fmu_id, vr);
    ref = integerRead.value;
    return convert(integerRead.status);
}

fmi2_status_t RemoteFmuInstance::readReal(unsigned int vr, double &ref) {
    client.readReal(realRead, fmu_id, vr);
    ref = realRead.value;
    return convert(realRead.status);
}

fmi2_status_t RemoteFmuInstance::readString(unsigned int vr, const char* &ref) {
    client.readString(stringRead, fmu_id, vr);
    ref = stringRead.value.c_str();
    return convert(stringRead.status);
}

fmi2_status_t RemoteFmuInstance::readBoolean(unsigned int vr, int &ref) {
    client.readBoolean(booleanRead, fmu_id, vr);
    ref = booleanRead.value;
    return convert(booleanRead.status);
}

fmi2_status_t RemoteFmuInstance::writeInteger(unsigned int vr, int value) {
    return convert(client.writeInteger(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeReal(unsigned int vr, double value) {
    return convert(client.writeReal(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeString(unsigned int vr, const char* value) {
    return convert(client.writeString(fmu_id, vr, value));
}

fmi2_status_t RemoteFmuInstance::writeBoolean(unsigned int vr, int value) {
    return convert(client.writeBoolean(fmu_id, vr, value == 0 ? false : true));
}

fmuproxy::fmi::ModelDescription &RemoteFmuInstance::getModelDescription() const {
    return modelDescription;
}
