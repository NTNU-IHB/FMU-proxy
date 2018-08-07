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
#include "grpc_server_helper.cpp"

using namespace std;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::server;

using grpc::ServerContext;

FmuServiceImpl::FmuServiceImpl(fmuproxy::fmi::Fmu &fmu) : m_fmu(fmu) {}

::grpc::Status FmuServiceImpl::GetModelDescriptionXml(ServerContext *context, const Void *request, Str *response) {
    response->set_value(m_fmu.get_model_description_xml());
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::GetModelDescription(ServerContext *context, const Void *request, ModelDescription *response) {
    grpcType(*response, m_fmu.get_model_description());
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::CreateInstanceFromCS(ServerContext *context, const Void *request, UInt *response) {
    int instance_id = ID_GEN++;
    instances[instance_id] = m_fmu.new_instance();
    response->set_value(instance_id);
    cout << "Created new FMU instance with id=" << instance_id << endl;
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::CreateInstanceFromME(ServerContext *context, const Solver *request, UInt *response) {
    return ::grpc::Status::CANCELLED;
}

::grpc::Status FmuServiceImpl::GetSimulationTime(ServerContext *context, const UInt *request, Real *response) {
    auto& fmu = instances[request->value()];
    response->set_value(fmu->getCurrentTime());
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::IsTerminated(ServerContext *context, const UInt *request, Bool *response) {
    auto& fmu = instances[request->value()];
    response->set_value(fmu->isTerminated());
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::Init(ServerContext *context, const InitRequest *request, StatusResponse *response) {
    auto& instance = instances[request->instance_id()];
    instance->init(request->start(), request->stop());
    response->set_status(Status::OK_STATUS);
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::Step(ServerContext *context, const StepRequest *request, StepResult *response) {
    auto& instance = instances[request->instance_id()];
    response->set_status(grpcType(instance->step(request->step_size())));
    response->set_simulation_time(instance->getCurrentTime());
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::Terminate(ServerContext *context, const UInt *request, StatusResponse *response) {
    int instance_id = request->value();
    auto& fmu = instances[instance_id];
    response->set_status(grpcType(fmu->terminate()));
    instances.erase(instance_id);
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::Reset(ServerContext *context, const UInt *request, StatusResponse *response) {
    auto& instance = instances[request->value()];
    response->set_status(grpcType(instance->reset()));
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::ReadInteger(ServerContext *context, const ReadRequest *request, IntegerRead *response) {
    auto& instance = instances[request->instance_id()];
    auto _vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    auto read = vector<fmi2_integer_t >(_vr.size());
    response->set_status(grpcType(instance->readInteger(_vr, read)));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::ReadReal(ServerContext *context, const ReadRequest *request, RealRead *response) {
    auto& instance = instances[request->instance_id()];
    auto _vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    auto read = vector<fmi2_real_t >(_vr.size());
    response->set_status(grpcType(instance->readReal(_vr, read)));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::ReadString(ServerContext *context, const ReadRequest *request, StringRead *response) {
    auto& instance = instances[request->instance_id()];
    //TODO
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::ReadBoolean(ServerContext *context, const ReadRequest *request, BooleanRead *response) {
    auto& instance = instances[request->instance_id()];
    //TODO
    return ::grpc::Status::OK;
}



::grpc::Status FmuServiceImpl::WriteInteger(ServerContext *context, const WriteIntegerRequest *request, StatusResponse *response) {
    auto& instance = instances[request->instance_id()];
    auto _vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    auto _values = vector<fmi2_integer_t >(request->values().begin(), request->values().end());
    response->set_status(grpcType(instance->writeInteger(_vr, _values)));
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::WriteReal(ServerContext *context, const WriteRealRequest *request, StatusResponse *response) {
    auto& fmu = instances[request->instance_id()];
    auto _vr = vector<fmi2_value_reference_t>(request->value_references().begin(), request->value_references().end());
    auto _values = vector<fmi2_real_t >(request->values().begin(), request->values().end());
    response->set_status(grpcType(fmu->writeReal(_vr, _values)));
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::WriteString(ServerContext *context, const WriteStringRequest *request, StatusResponse *response) {
    auto& instance = instances[request->instance_id()];
    //TODO
    return ::grpc::Status::OK;
}

::grpc::Status FmuServiceImpl::WriteBoolean(ServerContext *context, const WriteBooleanRequest *request, StatusResponse *response) {
    auto& instance = instances[request->instance_id()];
    //TODO
    return ::grpc::Status::OK;
}
