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

#include <boost/uuid/uuid.hpp>            // uuid class
#include <boost/uuid/uuid_generators.hpp> // generators
#include <boost/uuid/uuid_io.hpp>         // streaming operators etc.

#include <fmuproxy/grpc/server/FmuServiceImpl.hpp>
#include "grpc_server_helper.cpp"

using namespace std;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::server;
using namespace boost::uuids;

using ::grpc::Status;
using ::grpc::ServerContext;

namespace {

    fmi2_string_t strToChar(const std::string & s)
    {
        char *pc = new char[s.size()+1];
        std::strcpy(pc, s.c_str());
        return pc;
    }

}

FmuServiceImpl::FmuServiceImpl(map<string, shared_ptr<fmuproxy::fmi::Fmu>> &fmus) : fmus_(fmus) {}

::Status FmuServiceImpl::GetModelDescriptionXml(ServerContext *context, const GetModelDescriptionXmlRequest *request, ModelDescriptionXml *response) {
    const auto &fmu = fmus_[request->fmu_id()];
    response->set_xml(fmu->getModelDescriptionXml());
    return ::Status::OK;
}

::Status FmuServiceImpl::GetModelDescription(ServerContext *context, const GetModelDescriptionRequest *request, ModelDescription *response) {
    const auto &fmu = fmus_[request->fmu_id()];
    grpcType(*response, fmu->getModelDescription());
    return ::Status::OK;
}

::Status FmuServiceImpl::CreateInstanceFromCS(ServerContext *context, const CreateInstanceFromCSRequest *request, InstanceId *response) {
    auto &fmu = fmus_[request->fmu_id()];
    uuid uuid = random_generator()();
    const string instance_id = to_string(uuid);
    slaves_[instance_id] = fmu->newInstance();
    response->set_value(instance_id);
    cout << "Created new FMU instance with id=" << instance_id << endl;
    return ::Status::OK;
}

::Status FmuServiceImpl::CreateInstanceFromME(ServerContext *context, const CreateInstanceFromMERequest *request, InstanceId *response) {
    //TODO implement from Model Exchange
    auto status = ::Status(::grpc::StatusCode::UNIMPLEMENTED, "Model Exchange wrapper not available!");
    return status;
}

::Status FmuServiceImpl::Init(ServerContext *context, const InitRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    slave->init(request->start(), request->stop());
    response->set_status(Status::OK_STATUS);
    return ::Status::OK;
}

::Status FmuServiceImpl::Step(ServerContext *context, const StepRequest *request, StepResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    response->set_status(grpcType(slave->step(request->step_size())));
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
    const auto vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    auto read = vector<fmi2_integer_t >(vr.size());
    response->set_status(grpcType(slave->readInteger(vr, read)));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadReal(ServerContext *context, const ReadRequest *request, RealRead *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    auto read = vector<fmi2_real_t >(vr.size());
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
    const auto vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    const auto values = vector<fmi2_integer_t >(request->values().begin(), request->values().end());
    response->set_status(grpcType(slave->writeInteger(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteReal(ServerContext *context, const WriteRealRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    const auto values = vector<fmi2_real_t >(request->values().begin(), request->values().end());
    response->set_status(grpcType(slave->writeReal(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteString(ServerContext *context, const WriteStringRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    vector<fmi2_string_t > values;
    std::transform(request->values().begin(), request->values().end(), std::back_inserter(values), strToChar);
    response->set_status(grpcType(slave->writeString(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteBoolean(ServerContext *context, const WriteBooleanRequest *request, StatusResponse *response) {
    auto& slave = slaves_[request->instance_id()];
    const auto vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    const auto values = vector<fmi2_boolean_t >(request->values().begin(), request->values().end());
    response->set_status(grpcType(slave->writeBoolean(vr, values)));
    return ::Status::OK;
}

::Status
FmuServiceImpl::CanGetAndSetFMUstate(ServerContext *context, const CanGetAndSetFMUstateRequest *request, Bool *response) {
    auto& slave = slaves_[request->instance_id()];
    response->set_value(slave->canGetAndSetFMUstate());
    return ::Status::OK;
}

::Status
FmuServiceImpl::CanSerializeFMUstate(ServerContext *context, const CanSerializeFMUstateRequest *request, Bool *response) {
    auto& slave = slaves_[request->instance_id()];
    response->set_value(slave->canSerializeFMUstate());
    return ::Status::OK;
}

::Status
FmuServiceImpl::GetFMUstate(ServerContext *context, const GetFMUstateRequest *request, GetFMUstateResponse *response) {
    return Service::GetFMUstate(context, request, response);
}

::Status
FmuServiceImpl::SetFMUstate(ServerContext *context, const SetFMUstateRequest *request, StatusResponse *response) {
    return Service::SetFMUstate(context, request, response);
}

::Status
FmuServiceImpl::FreeFMUstate(ServerContext *context, const FreeFMUstateRequest *request, StatusResponse *response) {
    return Service::FreeFMUstate(context, request, response);
}

::Status
FmuServiceImpl::SerializeFMUstate(ServerContext *context, const SerializeFMUstateRequest *request, 
        SerializeFMUstateResponse *response) {
    return Service::SerializeFMUstate(context, request, response);
}

::Status
FmuServiceImpl::DeSerializeFMUstate(ServerContext *context, const DeSerializeFMUstateRequest *request,
        DeSerializeFMUstateResponse *response) {
    return Service::DeSerializeFMUstate(context, request, response);
}
