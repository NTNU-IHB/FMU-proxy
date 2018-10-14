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

using namespace std;
using namespace fmuproxy::thrift::client;

RemoteFmuSlave::RemoteFmuSlave(const InstanceId fmu_id, FmuServiceClient &client)
        : instanceId_(fmu_id), client_(client){
}

void RemoteFmuSlave::init(const double start, const double stop) {
    simulationTime_ = start;
    convert(client_.init(instanceId_, start, stop));
}

fmi2Status RemoteFmuSlave::doStep(const double step_size) {
    StepResult stepResult;
    client_.step(stepResult, instanceId_, step_size);
    simulationTime_ = stepResult.simulationTime;
    return convert(stepResult.status);
}

fmi2Status RemoteFmuSlave::cancelStep() {
    return convert(Status::DISCARD_STATUS);
}

fmi2Status RemoteFmuSlave::terminate() {
    return convert(client_.terminate(instanceId_));
}

fmi2Status RemoteFmuSlave::reset() {
    return convert(client_.reset(instanceId_));
}

fmi2Status RemoteFmuSlave::readInteger(fmi2ValueReference vr, fmi2Integer &ref) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2Integer > _ref(1);
    const auto status = this->readInteger(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2Status RemoteFmuSlave::readInteger(const vector<fmi2ValueReference> &vr, vector<fmi2Integer> &ref) {
    IntegerRead integerRead;
    const ValueReferences _vr = vector<int64_t >(vr.begin(), vr.end());
    client_.readInteger(integerRead, instanceId_, _vr);
    ref = integerRead.value;
    return convert(integerRead.status);
}

fmi2Status RemoteFmuSlave::readReal(fmi2ValueReference vr, fmi2Real &ref) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2Real > _ref(1);
    const auto status = this->readReal(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2Status RemoteFmuSlave::readReal(const vector<fmi2ValueReference> &vr, vector<fmi2Real> &ref) {
    RealRead realRead;
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    client_.readReal(realRead, instanceId_, _vr);
    ref = realRead.value;
    return convert(realRead.status);
}

fmi2Status RemoteFmuSlave::readString(fmi2ValueReference vr, fmi2String &ref) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2String > _ref(1);
    const auto status = this->readString(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2Status RemoteFmuSlave::readString(const vector<fmi2ValueReference> &vr, vector<fmi2String > &ref) {
    StringRead stringRead;
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    client_.readString(stringRead, instanceId_, _vr);
    const vector<string> read = stringRead.value;
    std::transform(read.begin(), read.end(), std::back_inserter(ref), convert_string);
    return convert(stringRead.status);
}

fmi2Status RemoteFmuSlave::readBoolean(fmi2ValueReference vr, fmi2Boolean &ref) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2Boolean > _ref(1);
    const auto status = this->readBoolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

fmi2Status RemoteFmuSlave::readBoolean(const vector<fmi2ValueReference> &vr, vector<fmi2Boolean> &ref) {
    BooleanRead booleanRead;
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    client_.readBoolean(booleanRead, instanceId_, _vr);
    const vector<bool> read = booleanRead.value;
    ref = vector<fmi2Boolean>(read.begin(), read.end());
    return convert(booleanRead.status);
}

fmi2Status RemoteFmuSlave::writeInteger(const fmi2ValueReference vr, const fmi2Integer value) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2Integer > _value = {value};
    return writeInteger(_vr, _value);
}

fmi2Status RemoteFmuSlave::writeInteger(const vector<fmi2ValueReference> &vr, const vector<fmi2Integer> &value) {
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    return convert(client_.writeInteger(instanceId_, _vr, value));
}

fmi2Status RemoteFmuSlave::writeReal(const fmi2ValueReference vr, const fmi2Real value) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2Real > _value = {value};
    return writeReal(_vr, _value);
}

fmi2Status RemoteFmuSlave::writeReal(const vector<fmi2ValueReference> &vr, const vector<fmi2Real> &value) {
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    return convert(client_.writeReal(instanceId_, _vr, value));
}

fmi2Status RemoteFmuSlave::writeString(const fmi2ValueReference vr, const fmi2String value) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2String > _value = {value};
    return writeString(_vr, _value);
}

fmi2Status RemoteFmuSlave::writeString(const vector<fmi2ValueReference> &vr, const vector<fmi2String> &value) {
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    const StringArray _value = vector<string>(value.begin(), value.end());
    return convert(client_.writeString(instanceId_, _vr, _value));
}

fmi2Status RemoteFmuSlave::writeBoolean(const fmi2ValueReference vr, const fmi2Boolean value) {
    vector<fmi2ValueReference > _vr = {vr};
    vector<fmi2Boolean > _value = {value};
    return writeBoolean(_vr, _value);
}

fmi2Status RemoteFmuSlave::writeBoolean(const vector<fmi2ValueReference> &vr, const vector<fmi2Boolean> &value) {
    const ValueReferences _vr = vector<int64_t>(vr.begin(), vr.end());
    const BooleanArray _value = vector<bool>(value.begin(), value.end());
    return convert(client_.writeBoolean(instanceId_, _vr, _value));
}


fmi2Status RemoteFmuSlave::getFMUstate(int64_t &state) {
    GetFmuStateResult _return;
    client_.getFMUstate(_return, instanceId_);
    state = _return.state;
    return convert(_return.status);
}

fmi2Status RemoteFmuSlave::setFMUstate(int64_t state) {
    return convert(client_.setFMUstate(instanceId_, state));
}

fmi2Status RemoteFmuSlave::freeFMUstate(int64_t &state) {
    return convert(client_.freeFMUstate(instanceId_, state));
}

fmi2Status RemoteFmuSlave::serializeFMUstate(const int64_t state, string &serializedState) {
    SerializeFmuStateResult result;
    client_.serializeFMUstate(result, instanceId_, state);
    serializedState = result.state;
    return convert(result.status);
}

fmi2Status RemoteFmuSlave::deSerializeFMUstate(const string serializedState, int64_t &state) {
    DeSerializeFmuStateResult result;
    client_.deSerializeFMUstate(result, instanceId_, serializedState.data());
    state = result.state;
    return convert(result.status);
}

fmi2Status RemoteFmuSlave::getDirectionalDerivative(const std::vector<fmi2ValueReference> &vUnknownRef,
                                                       const std::vector<fmi2ValueReference> &vKnownRef,
                                                       const std::vector<fmi2Real> &dvKnownRef,
                                                       std::vector<fmi2Real> &dvUnknown) {
    return fmi2_status_error;
}

shared_ptr<CoSimulationModelDescription> RemoteFmuSlave::getModelDescription() const {
    return std::shared_ptr<CoSimulationModelDescription>();
}

//void RemoteFmuSlave::init(double start, double stop) {
//
//}
//
//fmi2Status RemoteFmuSlave::reset() {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::terminate() {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::getFMUstate(fmi2FMUstate &state) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::setFMUstate(fmi2FMUstate state) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::freeFMUstate(fmi2FMUstate &state) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::serializeFMUstate(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::deSerializeFMUstate(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::getDirectionalDerivative(const std::vector<fmi2ValueReference> &vUnkownRef,
//                                                    const std::vector<fmi2ValueReference> &vKnownRef,
//                                                    const std::vector<fmi2Real> &dvKnownRef,
//                                                    std::vector<fmi2Real> &dvUnknownRef) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::doStep(double stepSize) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::cancelStep() {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readInteger(fmi2ValueReference vr, fmi2Integer &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readInteger(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Integer> &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readReal(fmi2ValueReference vr, fmi2Real &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readReal(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Real> &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readString(fmi2ValueReference vr, fmi2String &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readString(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2String> &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readBoolean(fmi2ValueReference vr, fmi2Boolean &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::readBoolean(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Boolean> &ref) const {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::writeInteger(fmi2ValueReference vr, fmi2Integer value) {
//    return fmi2Error;
//}
//
//fmi2Status
//RemoteFmuSlave::writeInteger(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Integer> &values) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::writeReal(fmi2ValueReference vr, fmi2Real value) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::writeReal(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Real> &values) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::writeString(fmi2ValueReference vr, fmi2String value) {
//    return fmi2Error;
//}
//
//fmi2Status
//RemoteFmuSlave::writeString(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2String> &values) {
//    return fmi2Error;
//}
//
//fmi2Status RemoteFmuSlave::writeBoolean(fmi2ValueReference vr, fmi2Boolean value) {
//    return fmi2Error;
//}
//
//fmi2Status
//RemoteFmuSlave::writeBoolean(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Boolean> &values) {
//    return fmi2Error;
//}
