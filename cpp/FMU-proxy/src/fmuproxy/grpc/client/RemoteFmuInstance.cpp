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

#include <fmuproxy/grpc/client/RemoteFmuInstance.hpp>

using namespace std;
using namespace fmuproxy::grpc::client;

RemoteFmuInstance::RemoteFmuInstance(int fmu_id, fmuproxy::grpc::FmuService::Stub &stub, fmuproxy::fmi::ModelDescription &modelDescription)
        : fmu_id(fmu_id), stub(stub), modelDescription(modelDescription) {

}

double RemoteFmuInstance::getCurrentTime() const {
    return current_time;
}

fmuproxy::fmi::ModelDescription &RemoteFmuInstance::getModelDescription() const {
    return modelDescription;
}

void RemoteFmuInstance::init() {
    init(0.0);
}

void RemoteFmuInstance::init(double start) {
    init(start, 0.0);
}

void RemoteFmuInstance::init(double start, double stop) {
    InitRequest req;
    req.set_start(start);
    req.set_stop(stop);
    StatusResponse response;
    stub.Init(nullptr, req, &response);
}

fmi2_status_t RemoteFmuInstance::step(double step_size) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::terminate() {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::reset() {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::readInteger(fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    return fmi2_status_error;
}

fmi2_status_t
RemoteFmuInstance::readInteger(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_integer_t> &ref) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::writeInteger(fmi2_value_reference_t vr, fmi2_integer_t value) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::writeInteger(const std::vector<fmi2_value_reference_t> &vr,
                                              const std::vector<fmi2_integer_t> &value) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::readReal(fmi2_value_reference_t vr, fmi2_real_t &ref) {
    return fmi2_status_error;
}

fmi2_status_t
RemoteFmuInstance::readReal(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_real_t> &ref) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::writeReal(fmi2_value_reference_t vr, fmi2_real_t value) {
    return fmi2_status_error;
}

fmi2_status_t
RemoteFmuInstance::writeReal(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_real_t> &value) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::readString(fmi2_value_reference_t vr, fmi2_string_t &ref) {
    return fmi2_status_error;
}

fmi2_status_t
RemoteFmuInstance::readString(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_string_t> &ref) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::writeString(fmi2_value_reference_t vr, fmi2_string_t value) {
    return fmi2_status_error;
}

fmi2_status_t
RemoteFmuInstance::writeString(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_string_t> &value) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::readBoolean(fmi2_value_reference_t vr, fmi2_boolean_t &ref) {
    return fmi2_status_error;
}

fmi2_status_t
RemoteFmuInstance::readBoolean(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_boolean_t> &ref) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::writeBoolean(fmi2_value_reference_t vr, fmi2_boolean_t value) {
    return fmi2_status_error;
}

fmi2_status_t RemoteFmuInstance::writeBoolean(const std::vector<fmi2_value_reference_t> &vr,
                                              const std::vector<fmi2_boolean_t> &value) {
    return fmi2_status_error;
}
