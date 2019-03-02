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

#include <utility>
#include <cstring>
#include <iostream>

#include <fmuproxy/thrift/server/FmuServiceHandler.hpp>

#include "../../util/simple_id.hpp"
#include "../../util/file_util.hpp"
#include "thrift_server_helper.hpp"

using namespace std;
using namespace fmuproxy;
using namespace fmuproxy::thrift::server;

namespace {

    const char* strToChar(const std::string &s) {
        char *pc = new char[s.size()+1];
        std::strcpy(pc, s.c_str());
        return pc;
    }

}

FmuServiceHandler::FmuServiceHandler(unordered_map<FmuId, shared_ptr<fmi4cpp::fmi2::fmi2Fmu>> &fmus) : fmus_(fmus) {}

void FmuServiceHandler::getCoSimulationAttributes(::fmuproxy::thrift::CoSimulationAttributes &_return,
                                                  const InstanceId &instanceId) {}

bool FmuServiceHandler::canCreateInstanceFromCS(const FmuId &fmuId) {
    const auto &fmu = fmus_.at(fmuId);
    return fmu->supportsCoSimulation();
}

bool FmuServiceHandler::canCreateInstanceFromME(const FmuId &fmuId) {
    const auto &fmu = fmus_.at(fmuId);
    return fmu->supportsModelExchange();
}

void FmuServiceHandler::getModelDescription(fmuproxy::thrift::ModelDescription &_return, const FmuId &id) {
    const auto &fmu = fmus_.at(id);
    thriftType(_return, *fmu->getModelDescription());
}

void FmuServiceHandler::loadFromUrl(FmuId &_return, const std::string &url) {
    cout << "Loading FMU from url " << url << endl;
    auto fmu = fmi4cpp::fmi2::fmi2Fmu::fromUrl(url);
    auto guid = fmu->getModelDescription()->guid;
    if (!fmus_.count(guid)) {
        fmus_[guid] = move(fmu);
    }
    _return = guid;
}

void FmuServiceHandler::loadFromFile(FmuId &_return, const std::string &name, const std::string &data) {

    //TODO implement LoadFromFile
    
  //  writeData(name, data);

}

void FmuServiceHandler::createInstanceFromCS(InstanceId &_return, const FmuId &id) {
    auto &fmu = fmus_.at(id);
    _return = generate_simple_id(10);
    slaves_[_return] = fmu->asCoSimulationFmu()->newInstance();
    cout << "Created new FMU slave with id=" << _return << endl;
}

void FmuServiceHandler::createInstanceFromME(InstanceId &_return, const FmuId &id, const fmuproxy::thrift::Solver &solver) {
    throw UnsupportedOperationException();
}


Status::type FmuServiceHandler::setupExperiment(const InstanceId &instanceId, const double start, const double stop,
                                                const double tolerance) {
    auto &slave = slaves_[instanceId];
    bool success = slave->setupExperiment(start, stop, tolerance);
    return thriftType(slave->getLastStatus());
}

Status::type FmuServiceHandler::enterInitializationMode(const InstanceId &instanceId) {
    auto &slave = slaves_[instanceId];
    bool success = slave->enterInitializationMode();
    return thriftType(slave->getLastStatus());
}

Status::type FmuServiceHandler::exitInitializationMode(const InstanceId &instanceId) {
    auto &slave = slaves_[instanceId];
    bool success = slave->exitInitializationMode();
    return thriftType(slave->getLastStatus());
}


void FmuServiceHandler::step(StepResult &_return, const InstanceId &slave_id, const double step_size) {
    auto &slave = slaves_[slave_id];
    bool success = slave->doStep(step_size);
    _return.simulationTime = slave->getSimulationTime();
    _return.status = thriftType(slave->getLastStatus());
}

Status::type FmuServiceHandler::terminate(const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    bool success = slave->terminate();
    auto status = thriftType(slave->getLastStatus());
    slaves_.erase(slave_id);
    cout << "Terminated FMU slave with id=" << slave_id << endl;
    return status;
}

Status::type FmuServiceHandler::reset(const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    bool success = slave->reset();
    return thriftType(slave->getLastStatus());
}

void FmuServiceHandler::readInteger(IntegerRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Integer> _value(vr.size());
    bool success = slave->readInteger(_vr, _value);
    _return.status = thriftType(slave->getLastStatus());
    _return.value = _value;
}

void FmuServiceHandler::readReal(RealRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Real> _value(vr.size());
    bool success = slave->readReal(_vr, _value);
    _return.status = thriftType(slave->getLastStatus());
    _return.value = _value;
}


void FmuServiceHandler::readString(StringRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2String> _value(vr.size());
    bool success = slave->readString(_vr, _value);
    _return.status = thriftType(slave->getLastStatus());
    _return.value = vector<string>(_value.begin(), _value.end());
}

void FmuServiceHandler::readBoolean(BooleanRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Boolean> _value(vr.size());
    bool success = slave->readBoolean(_vr, _value);
    _return.status = thriftType(slave->getLastStatus());
    _return.value = vector<bool>(_value.begin(), _value.end());
}

Status::type
FmuServiceHandler::writeInteger(const InstanceId &slave_id, const ValueReferences &vr, const IntArray &value) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    bool success = slave->writeInteger(_vr, value);
    return thriftType(slave->getLastStatus());
}


Status::type
FmuServiceHandler::writeReal(const InstanceId &slave_id, const ValueReferences &vr, const RealArray &value) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    bool success = slave->writeReal(_vr, value);
    return thriftType(slave->getLastStatus());
}


Status::type
FmuServiceHandler::writeString(const InstanceId &slave_id, const ValueReferences &vr, const StringArray &values) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2String > _values(_vr.size());
    std::transform(values.begin(), values.end(), std::back_inserter(_values), strToChar);
    bool success = slave->writeString(_vr, _values);
    return thriftType(slave->getLastStatus());
}


Status::type
FmuServiceHandler::writeBoolean(const InstanceId &slave_id, const ValueReferences &vr, const BooleanArray &value) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    const vector<int> _value(value.begin(), value.end());
    bool success = slave->writeBoolean(_vr, _value);
    return thriftType(slave->getLastStatus());
}

void FmuServiceHandler::getFMUstate(GetFmuStateResult &_return, const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

    //TODO

//    bool success = slave->getFMUstate(_return.state);
//    _return.status = thriftType(status);
    _return.__set_status(Status::type::ERROR_STATUS);
}

Status::type FmuServiceHandler::setFMUstate(const InstanceId &slave_id, const FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

    //TODO

//    return thriftType(slave->setFMUstate(state));
    return Status::type::ERROR_STATUS;
}

Status::type FmuServiceHandler::freeFMUstate(const InstanceId &slave_id, FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

    //TODO

//    return thriftType(slave->freeFMUstate(state));
    return Status::type::ERROR_STATUS;
}

void FmuServiceHandler::serializeFMUstate(SerializeFmuStateResult &_return, const InstanceId &slave_id,
                                          const FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canSerializeFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'SerializeFMUstate'";
        throw ex;
    }

    //TODO

//    string serializedState;
//    bool success = thriftType(slave->serializeFMUstate(state, serializedState));
//
//    _return.__set_status(status);
//    _return.__set_state(serializedState.data());
    _return.__set_status(Status::type::ERROR_STATUS);
}

void FmuServiceHandler::deSerializeFMUstate(DeSerializeFmuStateResult &_return, const InstanceId &slave_id,
                                            const string &serializedState) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canSerializeFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'deSerializeFMUstate'";
        throw ex;
    }

    //TODO

//    int64_t state;
//    bool success = thriftType(slave->deSerializeFMUstate(serializedState, state));
//
//    _return.__set_state(state);
//    _return.__set_status(status);
    _return.__set_status(Status::type::ERROR_STATUS);

}

void FmuServiceHandler::getDirectionalDerivative(DirectionalDerivativeResult &_return, const InstanceId &slave_id,
                                                 const ValueReferences &vUnknownRef, const ValueReferences &vKnownRef,
                                                 const std::vector<double> &dvKnownRef) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->providesDirectionalDerivative) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'getDirectionalDerivative'";
        throw ex;
    }

    vector<fmi2ValueReference> _vUnknownRef(vUnknownRef.begin(), vUnknownRef.end());
    vector<fmi2ValueReference> _vKnownRef(vKnownRef.begin(), vKnownRef.end());

    std::vector<double> dvUnknownRef(vUnknownRef.size());
    bool success = slave->getDirectionalDerivative(_vUnknownRef, _vKnownRef, dvKnownRef, dvUnknownRef);

    _return.status = thriftType(slave->getLastStatus());
    _return.dvUnknownRef = dvUnknownRef;

}
