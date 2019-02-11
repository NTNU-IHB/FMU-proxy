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

#include <fmuproxy/thrift/client/RemoteFmuSlave.hpp>

#include "thrift_client_helper.hpp"

using namespace fmuproxy::thrift::client;

RemoteFmuSlave::RemoteFmuSlave(const InstanceId &instanceId, FmuServiceClient &client,
                               const fmi4cpp::fmi2::ModelDescriptionBase &modelDescription)
        : instanceId_(instanceId), client_(client) {

    CoSimulationAttributes attributes;
    client_.getCoSimulationAttributes(attributes, instanceId_);
    csModelDescription_ = std::make_shared<fmi4cpp::fmi2::CoSimulationModelDescription>(modelDescription,
                                                                                       convert(attributes));
}

bool RemoteFmuSlave::updateStatusAndReturnTrueOnOK(Status::type status) {
    lastStatus_ = status;
    return status == Status::type ::OK_STATUS;
}

fmi4cpp::Status RemoteFmuSlave::getLastStatus() const {
    return convert(lastStatus_);
}

std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> RemoteFmuSlave::getModelDescription() const {
    return csModelDescription_;
}


bool RemoteFmuSlave::setupExperiment(double startTime, double stopTime, double tolerance) {
    return updateStatusAndReturnTrueOnOK(client_.setupExperiment(instanceId_, startTime, stopTime, tolerance));
}

bool RemoteFmuSlave::enterInitializationMode() {
    return updateStatusAndReturnTrueOnOK(client_.enterInitializationMode(instanceId_));
}

bool RemoteFmuSlave::exitInitializationMode() {
    return updateStatusAndReturnTrueOnOK(client_.exitInitializationMode(instanceId_));
}

bool RemoteFmuSlave::doStep(const double step_size) {
    StepResult stepResult;
    client_.step(stepResult, instanceId_, step_size);
    simulationTime_ = stepResult.simulationTime;
    return updateStatusAndReturnTrueOnOK(stepResult.status);
}

bool RemoteFmuSlave::cancelStep() {
    return updateStatusAndReturnTrueOnOK(Status::type::DISCARD_STATUS);
}

bool RemoteFmuSlave::terminate() {
    return updateStatusAndReturnTrueOnOK(client_.terminate(instanceId_));
}

bool RemoteFmuSlave::reset() {
    return updateStatusAndReturnTrueOnOK(client_.reset(instanceId_));
}

bool RemoteFmuSlave::readInteger(const fmi2ValueReference vr, fmi2Integer &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Integer> _ref(1);
    const auto status = this->readInteger(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool RemoteFmuSlave::readInteger(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Integer> &ref) {
    IntegerRead integerRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.readInteger(integerRead, instanceId_, _vr);
    ref = integerRead.value;
    return updateStatusAndReturnTrueOnOK(integerRead.status);
}

bool RemoteFmuSlave::readReal(const fmi2ValueReference vr, fmi2Real &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Real> _ref(1);
    const auto status = this->readReal(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool RemoteFmuSlave::readReal(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Real> &ref) {
    RealRead realRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.readReal(realRead, instanceId_, _vr);
    ref = realRead.value;
    return updateStatusAndReturnTrueOnOK(realRead.status);
}

bool RemoteFmuSlave::readString(const fmi2ValueReference vr, fmi2String &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2String> _ref(1);
    const auto status = this->readString(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool RemoteFmuSlave::readString(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2String> &ref) {
    StringRead stringRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.readString(stringRead, instanceId_, _vr);
    const std::vector<std::string> read = stringRead.value;
    std::transform(read.begin(), read.end(), ref.begin(), [](std::string str) -> const char* {
        return str.c_str();
    });
    return updateStatusAndReturnTrueOnOK(stringRead.status);
}

bool RemoteFmuSlave::readBoolean(const fmi2ValueReference vr, fmi2Boolean &ref) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Boolean> _ref(1);
    const auto status = this->readBoolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool RemoteFmuSlave::readBoolean(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Boolean> &ref) {
    BooleanRead booleanRead;
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    client_.readBoolean(booleanRead, instanceId_, _vr);
    const std::vector<bool> read = booleanRead.value;
    ref = std::vector<fmi2Boolean>(read.begin(), read.end());
    return updateStatusAndReturnTrueOnOK(booleanRead.status);
}

bool RemoteFmuSlave::writeInteger(const fmi2ValueReference vr, const fmi2Integer value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Integer> _value = {value};
    return writeInteger(_vr, _value);
}

bool RemoteFmuSlave::writeInteger(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Integer> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    return updateStatusAndReturnTrueOnOK(client_.writeInteger(instanceId_, _vr, value));
}

bool RemoteFmuSlave::writeReal(const fmi2ValueReference vr, const fmi2Real value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Real> _value = {value};
    return writeReal(_vr, _value);
}

bool RemoteFmuSlave::writeReal(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Real> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    return updateStatusAndReturnTrueOnOK(client_.writeReal(instanceId_, _vr, value));
}

bool RemoteFmuSlave::writeString(const fmi2ValueReference vr, const fmi2String value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2String> _value = {value};
    return writeString(_vr, _value);
}

bool RemoteFmuSlave::writeString(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2String> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    const StringArray _value = std::vector<std::string>(value.begin(), value.end());
    return updateStatusAndReturnTrueOnOK(client_.writeString(instanceId_, _vr, _value));
}

bool RemoteFmuSlave::writeBoolean(const fmi2ValueReference vr, const fmi2Boolean value) {
    std::vector<fmi2ValueReference> _vr = {vr};
    std::vector<fmi2Boolean> _value = {value};
    return writeBoolean(_vr, _value);
}

bool RemoteFmuSlave::writeBoolean(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Boolean> &value) {
    const ValueReferences _vr = std::vector<int64_t>(vr.begin(), vr.end());
    const BooleanArray _value = std::vector<bool>(value.begin(), value.end());
    return updateStatusAndReturnTrueOnOK(client_.writeBoolean(instanceId_, _vr, _value));
}

bool RemoteFmuSlave::getDirectionalDerivative(const std::vector<fmi2ValueReference> &vUnknownRef,
                                                    const std::vector<fmi2ValueReference> &vKnownRef,
                                                    const std::vector<fmi2Real> &dvKnownRef,
                                                    std::vector<fmi2Real> &dvUnknown) {
    return updateStatusAndReturnTrueOnOK(Status::type::ERROR_STATUS);
}

bool RemoteFmuSlave::getFMUstate(fmi2FMUstate &state) {
    return updateStatusAndReturnTrueOnOK(Status::type::ERROR_STATUS);
}

bool RemoteFmuSlave::setFMUstate(const fmi2FMUstate state) {
    return updateStatusAndReturnTrueOnOK(Status::type::ERROR_STATUS);
}

bool RemoteFmuSlave::freeFMUstate(fmi2FMUstate &state) {
    return updateStatusAndReturnTrueOnOK(Status::type::ERROR_STATUS);
}

bool RemoteFmuSlave::serializeFMUstate(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) {
    return updateStatusAndReturnTrueOnOK(Status::type::ERROR_STATUS);
}

bool RemoteFmuSlave::deSerializeFMUstate(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) {
    return updateStatusAndReturnTrueOnOK(Status::type::ERROR_STATUS);
}


//bool RemoteFmuSlave::getFMUstate(int64_t &state) {
//    GetFmuStateResult _return;
//    client_.getFMUstate(_return, instanceId_);
//    state = _return.state;
//    return convert(_return.status);
//}
//
//bool RemoteFmuSlave::setFMUstate(int64_t state) {
//    return convert(client_.setFMUstate(instanceId_, state));
//}
//
//bool RemoteFmuSlave::freeFMUstate(int64_t &state) {
//    return convert(client_.freeFMUstate(instanceId_, state));
//}
//
//bool RemoteFmuSlave::serializeFMUstate(const int64_t state, std::string &serializedState) {
//    SerializeFmuStateResult result;
//    client_.serializeFMUstate(result, instanceId_, state);
//    serializedState = result.state;
//    return convert(result.status);
//}
//
//bool RemoteFmuSlave::deSerializeFMUstate(const std::string serializedState, int64_t &state) {
//    DeSerializeFmuStateResult result;
//    client_.deSerializeFMUstate(result, instanceId_, serializedState.data());
//    state = result.state;
//    return convert(result.status);
//}

