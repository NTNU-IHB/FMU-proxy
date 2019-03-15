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

#include <fmuproxy/thrift/server/fmu_service_handler.hpp>

#include "../../util/simple_id.hpp"
#include "../../util/file_util.hpp"
#include "../../util/solver_util.hpp"

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

fmu_service_handler::fmu_service_handler(unordered_map<FmuId, shared_ptr<fmi4cpp::fmi2::fmi2Fmu>> &fmus) : fmus_(fmus) {}

void fmu_service_handler::getCoSimulationAttributes(::fmuproxy::thrift::CoSimulationAttributes &_return,
                                                  const InstanceId &instanceId) {}

bool fmu_service_handler::canCreateInstanceFromCS(const FmuId &fmuId) {
    const auto &fmu = fmus_.at(fmuId);
    return fmu->supportsCoSimulation();
}

bool fmu_service_handler::canCreateInstanceFromME(const FmuId &fmuId) {
    const auto &fmu = fmus_.at(fmuId);
    return fmu->supportsModelExchange();
}

void fmu_service_handler::getModelDescription(fmuproxy::thrift::ModelDescription &_return, const FmuId &id) {
    const auto &fmu = fmus_.at(id);
    thrift_type(_return, *fmu->getModelDescription());
}

void fmu_service_handler::loadFromUrl(FmuId &_return, const std::string &url) {
    cout << "Loading FMU from url " << url << endl;
    auto fmu = fmi4cpp::fmi2::fmi2Fmu::fromUrl(url);
    auto guid = fmu->getModelDescription()->guid;
    if (!fmus_.count(guid)) {
        fmus_[guid] = move(fmu);
    }
    _return = guid;
}

void fmu_service_handler::loadFromFile(FmuId &_return, const std::string &name, const std::string &data) {

    fs::path tmp(fs::temp_directory_path() /= fs::path(name + "_" + generate_simple_id(8) + ".fmu"));
    const std::string fmuPath = tmp.string();
    write_data(fmuPath, data);

    auto fmu = std::make_shared<fmi4cpp::fmi2::fmi2Fmu>(fmuPath);

    fs::remove_all(tmp);

    auto guid = fmu->getModelDescription()->guid;
    if (!fmus_.count(guid)) {
        fmus_[guid] = move(fmu);
    }
    _return = guid;
}

void fmu_service_handler::createInstanceFromCS(InstanceId &_return, const FmuId &id) {
    auto &fmu = fmus_.at(id);
    _return = generate_simple_id(10);
    slaves_[_return] = fmu->asCoSimulationFmu()->newInstance();
    cout << "Created new FMU slave from cs with id=" << _return << endl;
}

void fmu_service_handler::createInstanceFromME(InstanceId &_return, const FmuId &id, const fmuproxy::thrift::Solver &solver) {
    auto &fmu = fmus_.at(id);

    std::unique_ptr<fmi4cpp::solver::ModelExchangeSolver> solver_ = parse_solver(solver);
    _return = generate_simple_id(10);
    slaves_[_return] = fmu->asModelExchangeFmu()->newInstance(solver_);
    cout << "Created new FMU slave from me with id=" << _return << endl;

}


Status::type fmu_service_handler::setupExperiment(const InstanceId &instanceId, const double start, const double stop,
                                                const double tolerance) {
    auto &slave = slaves_[instanceId];
    bool success = slave->setupExperiment(start, stop, tolerance);
    return thrift_type(slave->getLastStatus());
}

Status::type fmu_service_handler::enterInitializationMode(const InstanceId &instanceId) {
    auto &slave = slaves_[instanceId];
    bool success = slave->enterInitializationMode();
    return thrift_type(slave->getLastStatus());
}

Status::type fmu_service_handler::exitInitializationMode(const InstanceId &instanceId) {
    auto &slave = slaves_[instanceId];
    bool success = slave->exitInitializationMode();
    return thrift_type(slave->getLastStatus());
}


void fmu_service_handler::step(StepResult &_return, const InstanceId &slave_id, const double step_size) {
    auto &slave = slaves_[slave_id];
    bool success = slave->doStep(step_size);
    _return.simulationTime = slave->getSimulationTime();
    _return.status = thrift_type(slave->getLastStatus());
}

Status::type fmu_service_handler::terminate(const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    bool success = slave->terminate();
    auto status = thrift_type(slave->getLastStatus());
    slaves_.erase(slave_id);
    cout << "Terminated FMU slave with id=" << slave_id << endl;
    return status;
}

Status::type fmu_service_handler::reset(const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    bool success = slave->reset();
    return thrift_type(slave->getLastStatus());
}

void fmu_service_handler::readInteger(IntegerRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Integer> _value(vr.size());
    bool success = slave->readInteger(_vr, _value);
    _return.status = thrift_type(slave->getLastStatus());
    _return.value = _value;
}

void fmu_service_handler::readReal(RealRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Real> _value(vr.size());
    bool success = slave->readReal(_vr, _value);
    _return.status = thrift_type(slave->getLastStatus());
    _return.value = _value;
}


void fmu_service_handler::readString(StringRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2String> _value(vr.size());
    bool success = slave->readString(_vr, _value);
    _return.status = thrift_type(slave->getLastStatus());
    _return.value = vector<string>(_value.begin(), _value.end());
}

void fmu_service_handler::readBoolean(BooleanRead &_return, const InstanceId &slave_id, const ValueReferences &vr) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Boolean> _value(vr.size());
    bool success = slave->readBoolean(_vr, _value);
    _return.status = thrift_type(slave->getLastStatus());
    _return.value = vector<bool>(_value.begin(), _value.end());
}

Status::type
fmu_service_handler::writeInteger(const InstanceId &slave_id, const ValueReferences &vr, const IntArray &value) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    bool success = slave->writeInteger(_vr, value);
    return thrift_type(slave->getLastStatus());
}


Status::type
fmu_service_handler::writeReal(const InstanceId &slave_id, const ValueReferences &vr, const RealArray &value) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    bool success = slave->writeReal(_vr, value);
    return thrift_type(slave->getLastStatus());
}


Status::type
fmu_service_handler::writeString(const InstanceId &slave_id, const ValueReferences &vr, const StringArray &values) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2String > _values(_vr.size());
    std::transform(values.begin(), values.end(), std::back_inserter(_values), strToChar);
    bool success = slave->writeString(_vr, _values);
    return thrift_type(slave->getLastStatus());
}


Status::type
fmu_service_handler::writeBoolean(const InstanceId &slave_id, const ValueReferences &vr, const BooleanArray &value) {
    auto &slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    const vector<int> _value(value.begin(), value.end());
    bool success = slave->writeBoolean(_vr, _value);
    return thrift_type(slave->getLastStatus());
}

void fmu_service_handler::getFMUstate(GetFmuStateResult &_return, const InstanceId &slave_id) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

    //TODO

//    bool success = slave->getFMUstate(_return.state);
//    _return.status = thrift_type(status);
    _return.__set_status(Status::type::ERROR_STATUS);
}

Status::type fmu_service_handler::setFMUstate(const InstanceId &slave_id, const FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

    //TODO

//    return thrift_type(slave->setFMUstate(state));
    return Status::type::ERROR_STATUS;
}

Status::type fmu_service_handler::freeFMUstate(const InstanceId &slave_id, FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canGetAndSetFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
        throw ex;
    }

    //TODO

//    return thrift_type(slave->freeFMUstate(state));
    return Status::type::ERROR_STATUS;
}

void fmu_service_handler::serializeFMUstate(SerializeFmuStateResult &_return, const InstanceId &slave_id,
                                          const FmuState state) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canSerializeFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'SerializeFMUstate'";
        throw ex;
    }

    //TODO

//    string serializedState;
//    bool success = thrift_type(slave->serializeFMUstate(state, serializedState));
//
//    _return.__set_status(status);
//    _return.__set_state(serializedState.data());
    _return.__set_status(Status::type::ERROR_STATUS);
}

void fmu_service_handler::deSerializeFMUstate(DeSerializeFmuStateResult &_return, const InstanceId &slave_id,
                                            const string &serializedState) {
    auto &slave = slaves_[slave_id];
    if (!slave->getModelDescription()->canSerializeFMUstate) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'deSerializeFMUstate'";
        throw ex;
    }

    //TODO

//    int64_t state;
//    bool success = thrift_type(slave->deSerializeFMUstate(serializedState, state));
//
//    _return.__set_state(state);
//    _return.__set_status(status);
    _return.__set_status(Status::type::ERROR_STATUS);

}

void fmu_service_handler::getDirectionalDerivative(DirectionalDerivativeResult &_return, const InstanceId &slave_id,
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

    _return.status = thrift_type(slave->getLastStatus());
    _return.dvUnknownRef = dvUnknownRef;

}
