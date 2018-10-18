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

#include <iostream>

#include <fmuproxy/thrift/server/FmuServiceHandler.hpp>

#include "../../util/simple_id.hpp"
#include "thrift_server_helper.hpp"

using namespace std;
using namespace fmuproxy;
using namespace fmuproxy::thrift::server;

namespace {

    fmi2String strToChar(const std::string &s) {
        char *pc = new char[s.size()+1];
        std::strcpy(pc, s.c_str());
        return pc;
    }

}

FmuServiceHandler::FmuServiceHandler(unordered_map<FmuId, shared_ptr<fmi4cpp::fmi2::Fmu>> &fmus) : fmus_(fmus) {}

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

void FmuServiceHandler::createInstanceFromCS(InstanceId &_return, const FmuId &id) {
    auto &fmu = fmus_.at(id);
    _return = generate_simple_id(10);
    slaves_[_return] = fmu->asCoSimulationFmu()->newInstance();
    cout << "Created new FMU slave with id=" << _return << endl;
}

void FmuServiceHandler::createInstanceFromME(InstanceId &_return, const FmuId &id, const Solver &solver) {
    throw UnsupportedOperationException();
}

Status::type FmuServiceHandler::init(const InstanceId &slave_id, const double start, const double stop) {
    auto &slave = slaves_[slave_id];
    slave->init(start, stop);
    return ::Status::OK_STATUS;
}

void FmuServiceHandler::step(StepResult &_return, const InstanceId &slave_id, const double step_size) {
    auto &slave = slaves_[slave_id];
    fmi2Status status = slave->doStep(step_size);
    _return.simulationTime = slave->getSimulationTime();
    _return.status = thriftType(status);
}

Status::type FmuServiceHandler::terminate(const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    Status::type status = thriftType(slave->terminate());
    slaves_.erase(slave_id);
    return status;
}

Status::type FmuServiceHandler::reset(const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    return thriftType(slave->reset());
}

void FmuServiceHandler::readInteger(IntegerRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    auto _value = vector<fmi2Integer>(vr.size());
    _return.status = thriftType(slave->readInteger(_vr, _value));
    _return.value = _value;
}

void FmuServiceHandler::readReal(RealRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    auto _value = vector<fmi2Real>(vr.size());
    _return.status = thriftType(slave->readReal(_vr, _value));
    _return.value = _value;
}


void FmuServiceHandler::readString(StringRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    auto _value = vector<fmi2String>(vr.size());
    _return.status = thriftType(slave->readString(_vr, _value));
    _return.value = vector<string>(_value.begin(), _value.end());
}

void FmuServiceHandler::readBoolean(BooleanRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    auto _value = vector<fmi2Boolean>(vr.size());
    _return.status = thriftType(slave->readBoolean(_vr, _value));
    _return.value = vector<bool>(_value.begin(), _value.end());
}

Status::type
FmuServiceHandler::writeInteger(const InstanceId &slave_id, const ValueReferences &vr, const IntArray &value) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    const auto status = slave->writeInteger(_vr, value);
    return thriftType(status);
}


Status::type
FmuServiceHandler::writeReal(const InstanceId &slave_id, const ValueReferences &vr, const RealArray &value) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    const auto status = slave->writeReal(_vr, value);
    return thriftType(status);
}


Status::type
FmuServiceHandler::writeString(const InstanceId &slave_id, const ValueReferences &vr, const StringArray &values) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    vector<fmi2String > _values;
    std::transform(values.begin(), values.end(), std::back_inserter(_values), strToChar);
    const auto status = slave->writeString(_vr, _values);
    return thriftType(status);
}


Status::type
FmuServiceHandler::writeBoolean(const InstanceId &slave_id, const ValueReferences &vr, const BooleanArray &value) {
    auto &slave = slaves_[slave_id];
    const auto _vr = vector<fmi2ValueReference>(vr.begin(), vr.end());
    const auto _value = vector<int>(value.begin(), value.end());
    const auto status = slave->writeBoolean(_vr, _value);
    return thriftType(status);
}

void FmuServiceHandler::getFMUstate(GetFmuStateResult &_return, const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

//    const auto status = slave->getFMUstate(_return.state);
//    _return.status = thriftType(status);
    _return.__set_status(Status::type::ERROR_STATUS);
}

Status::type FmuServiceHandler::setFMUstate(const InstanceId &slave_id, const FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

//    return thriftType(slave->setFMUstate(state));
    return Status::type::ERROR_STATUS;
}

Status::type FmuServiceHandler::freeFMUstate(const InstanceId &slave_id, FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

//    return thriftType(slave->freeFMUstate(state));
    return Status::type::ERROR_STATUS;
}

void FmuServiceHandler::serializeFMUstate(SerializeFmuStateResult &_return, const InstanceId &slave_id,
                                          const FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canSerializeFMUstate()) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'SerializeFMUstate'";
        throw ex;
    }

//    string serializedState;
//    const auto status = thriftType(slave->serializeFMUstate(state, serializedState));
//
//    _return.__set_status(status);
//    _return.__set_state(serializedState.data());
    _return.__set_status(Status::type::ERROR_STATUS);
}

void FmuServiceHandler::deSerializeFMUstate(DeSerializeFmuStateResult &_return, const InstanceId &slave_id,
                                            const string &serializedState) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canSerializeFMUstate()) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'SerializeFMUstate'";
        throw ex;
    }

//    int64_t state;
//    const auto status = thriftType(slave->deSerializeFMUstate(serializedState, state));
//
//    _return.__set_state(state);
//    _return.__set_status(status);
    _return.__set_status(Status::type::ERROR_STATUS);

}
