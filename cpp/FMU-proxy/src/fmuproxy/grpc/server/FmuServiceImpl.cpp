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

#include <fmuproxy/grpc/server/FmuServiceImpl.hpp>

#include "../../util/simple_id.hpp"
#include "grpc_server_helper.hpp"

using namespace std;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::server;

using ::grpc::Status;
using ::grpc::ServerContext;

namespace {

    fmi2String strToChar(const std::string &s) {
        char *pc = new char[s.size()+1];
        std::strcpy(pc, s.c_str());
        return pc;
    }

}

FmuServiceImpl::FmuServiceImpl(unordered_map<string, shared_ptr<fmi4cpp::fmi2::Fmu>> &fmus) : fmus_(fmus) {}


::Status FmuServiceImpl::GetModelDescription(ServerContext *context, const GetModelDescriptionRequest *request, ModelDescription *response) {
    const auto &fmu = fmus_[request->fmu_id()];
    grpcType(*response, *fmu->getModelDescription());
    return ::Status::OK;
}

::Status FmuServiceImpl::CreateInstanceFromCS(ServerContext *context, const CreateInstanceFromCSRequest *request, InstanceId *response) {
    auto &fmu = fmus_[request->fmu_id()];

    const string instance_id = generate_simple_id(10);
    slaves_[instance_id] = fmu->asCoSimulationFmu()->newInstance();
    response->set_value(instance_id);
    cout << "Created new FMU instance with id=" << instance_id << endl;
    return ::Status::OK;
}

::Status FmuServiceImpl::CreateInstanceFromME(ServerContext *context, const CreateInstanceFromMERequest *request, InstanceId *response) {
    //TODO implement from Model Exchange
    return ::Status(::grpc::StatusCode::UNIMPLEMENTED, "Model Exchange wrapper not available!");
}

::Status FmuServiceImpl::Init(ServerContext *context, const InitRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    slave->init(request->start(), request->stop());
    response->set_status(Status::OK_STATUS);
    return ::Status::OK;
}

::Status FmuServiceImpl::Step(ServerContext *context, const StepRequest *request, StepResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    response->set_status(grpcType(slave->doStep(request->step_size())));
    response->set_simulation_time(slave->getSimulationTime());
    return ::Status::OK;
}

::Status FmuServiceImpl::Terminate(ServerContext *context, const TerminateRequest *request, StatusResponse *response) {
    const auto instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    response->set_status(grpcType(slave->terminate()));
    slaves_.erase(instance_id);
    return ::Status::OK;
}

::Status FmuServiceImpl::Reset(ServerContext *context, const ResetRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    response->set_status(grpcType(slave->reset()));
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadInteger(ServerContext *context, const ReadRequest *request, IntegerRead *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2ValueReference>(request->value_references().begin(), request->value_references().end());
    auto read = vector<fmi2Integer >(vr.size());
    response->set_status(grpcType(slave->readInteger(vr, read)));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadReal(ServerContext *context, const ReadRequest *request, RealRead *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2ValueReference>(request->value_references().begin(), request->value_references().end());
    auto read = vector<fmi2Real >(vr.size());
    response->set_status(grpcType(slave->readReal(vr, read)));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadString(ServerContext *context, const ReadRequest *request, StringRead *response) {
    auto& slave = slaves_[request->instance_id()];
    //TODO
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadBoolean(ServerContext *context, const ReadRequest *request, BooleanRead *response) {
    auto& slave = slaves_[request->instance_id()];
    //TODO
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteInteger(ServerContext *context, const WriteIntegerRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2ValueReference>(request->value_references().begin(), request->value_references().end());
    const auto values = vector<fmi2Integer >(request->values().begin(), request->values().end());
    response->set_status(grpcType(slave->writeInteger(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteReal(ServerContext *context, const WriteRealRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2ValueReference>(request->value_references().begin(), request->value_references().end());
    const auto values = vector<fmi2Real >(request->values().begin(), request->values().end());
    response->set_status(grpcType(slave->writeReal(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteString(ServerContext *context, const WriteStringRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2ValueReference>(request->value_references().begin(), request->value_references().end());
    vector<fmi2String > values;
    std::transform(request->values().begin(), request->values().end(), std::back_inserter(values), strToChar);
    response->set_status(grpcType(slave->writeString(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteBoolean(ServerContext *context, const WriteBooleanRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2ValueReference>(request->value_references().begin(), request->value_references().end());
    const auto values = vector<fmi2Boolean >(request->values().begin(), request->values().end());
    response->set_status(grpcType(slave->writeBoolean(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::GetFMUstate(ServerContext *context, const GetFMUstateRequest *request, GetFMUstateResponse *response) {
    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
    }

//    int64_t state;
//    auto status = grpcType(slave->getFMUstate(state));
//
//    response->set_state(state);
//    response->set_status(status);

    return ::Status::OK;
}

::Status
FmuServiceImpl::SetFMUstate(ServerContext *context, const SetFMUstateRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
    }

//    auto status = grpcType(slave->setFMUstate(request->state()));
//    response->set_status(status);

    return ::Status::OK;
}

::Status
FmuServiceImpl::FreeFMUstate(ServerContext *context, const FreeFMUstateRequest *request, StatusResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
    }

//    int64_t _state = request->state();
//    auto status = grpcType(slave->freeFMUstate(_state));
//    response->set_status(status);

    return ::Status::OK;
}

::Status
FmuServiceImpl::SerializeFMUstate(ServerContext *context, const SerializeFMUstateRequest *request,
        SerializeFMUstateResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canSerializeFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'SerializeFMUstate'!");
    }

//    int64_t state = 0;
//    string serializedState;
//    const auto status = grpcType(slave->serializeFMUstate(state, serializedState));
//
//    response->set_status(status);
//    response->set_state(serializedState);

    return ::Status::OK;
}

::Status
FmuServiceImpl::DeSerializeFMUstate(ServerContext *context, const DeSerializeFMUstateRequest *request,
        DeSerializeFMUstateResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canSerializeFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'SerializeFMUstate'!");
    }

//    int64_t state;
//    const auto status = grpcType(slave->deSerializeFMUstate(request->state(), state));
//
//    response->set_state(state);
//    response->set_status(status);

    return ::Status::OK;
}

::Status FmuServiceImpl::GetCoSimulationAttributes(ServerContext *context,
                                                 const GetCoSimulationAttributesRequest *request,
                                                 CoSimulationAttributes *response) {
    auto &slave = slaves_[request->instance_id()];
    auto md = slave->getModelDescription();

    response->set_modelidentifier(md->modelIdentifier());
    response->set_cangetandsetfmustate(md->canGetAndSetFMUstate());
    response->set_canserializefmustate(md->canSerializeFMUstate());
    response->set_canhandlevariablecommunicationstepsize(md->canHandleVariableCommunicationStepSize());
    response->set_maxoutputderivativeorder(md->maxOutputDerivativeOrder());
    response->set_providesdirectionalderivative(md->providesDirectionalDerivative());
    
    return ::Status::OK;
}

::Status FmuServiceImpl::CanCreateInstanceFromCS(ServerContext *context,
                                               const ::fmuproxy::grpc::CanCreateInstanceFromCSRequest *request,
                                               Bool *response) {
    auto &fmu = fmus_[request->fmu_id()];
    response->set_value(fmu->supportsCoSimulation());
    return ::Status::OK;
}

::Status FmuServiceImpl::CanCreateInstanceFromME(ServerContext *context,
                                               const CanCreateInstanceFromMERequest *request, Bool *response) {
    auto &fmu = fmus_[request->fmu_id()];
    response->set_value(fmu->supportsModelExchange());
    return ::Status::OK;
}
