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

#include "../../util/file_util.hpp"
#include "../../util/simple_id.hpp"
#include "grpc_server_helper.hpp"

#include <fmuproxy/grpc/server/fmu_service_impl.hpp>

#include <boost/filesystem.hpp>

#include <utility>
#include <vector>

using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::server;

using ::grpc::ServerContext;
using ::grpc::Status;

namespace fs = boost::filesystem;

namespace
{

const char* str_to_char(const std::string& s)
{
    auto* pc = new char[s.size() + 1];
    std::strcpy(pc, s.c_str());
    return pc;
}

} // namespace

fmu_service_impl::fmu_service_impl(std::unordered_map<std::string, std::shared_ptr<fmi4cpp::fmi2::cs_fmu>>& fmus)
    : fmus_(fmus)
{}

::Status fmu_service_impl::LoadFromUrl(ServerContext* context, const ::fmuproxy::grpc::Url* request,
    ::fmuproxy::grpc::FmuId* response)
{
    return ::Status::CANCELLED;
}

::Status fmu_service_impl::LoadFromFile(::grpc::ServerContext* context, const ::fmuproxy::grpc::File* request,
    ::fmuproxy::grpc::FmuId* response)
{
    fs::path tmp(fs::temp_directory_path() /= fs::path(request->name() + ".fmu"));
    const std::string fmuPath = tmp.string();
    write_data(fmuPath, request->data());

    auto fmu = fmi4cpp::fmi2::fmu(fmuPath).as_cs_fmu();

    fs::remove_all(tmp);

    auto guid = fmu->get_model_description()->guid;
    if (!fmus_.count(guid)) {
        fmus_[guid] = move(fmu);
    }
    response->set_value(guid);
    return ::Status::OK;
}

::Status fmu_service_impl::GetModelDescription(ServerContext* context, const GetModelDescriptionRequest* request,
    ModelDescription* response)
{
    const auto& fmu = fmus_[request->fmu_id()];
    grpc_type(*response, *fmu->get_model_description());
    return ::Status::OK;
}

::Status fmu_service_impl::CreateInstance(ServerContext* context, const CreateInstanceRequest* request,
    InstanceId* response)
{
    auto& fmu = fmus_[request->fmu_id()];

    const std::string instance_id = generate_simple_id(10);
    slaves_[instance_id] = fmu->new_instance();
    response->set_value(instance_id);
    std::cout << "Created new FMU instance with id=" << instance_id << std::endl;
    return ::Status::OK;
}

::Status
fmu_service_impl::SetupExperiment(::grpc::ServerContext* context, const ::fmuproxy::grpc::SetupExperimentRequest* request,
    ::fmuproxy::grpc::StatusResponse* response)
{
    auto& slave = slaves_[request->instance_id()];
    bool status = slave->setup_experiment(request->start(), request->stop(), request->tolerance());
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::EnterInitializationMode(::grpc::ServerContext* context,
    const ::fmuproxy::grpc::EnterInitializationModeRequest* request,
    ::fmuproxy::grpc::StatusResponse* response)
{
    const auto& instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    bool status = slave->enter_initialization_mode();
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::ExitInitializationMode(::grpc::ServerContext* context,
    const ::fmuproxy::grpc::ExitInitializationModeRequest* request,
    ::fmuproxy::grpc::StatusResponse* response)
{
    const auto& instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    bool status = slave->exit_initialization_mode();
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::Step(ServerContext* context, const StepRequest* request, StepResponse* response)
{
    const auto& instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    bool status = slave->step(request->step_size());
    response->set_status(grpc_type(slave->last_status()));
    response->set_simulation_time(slave->get_simulation_time());
    return ::Status::OK;
}

::Status fmu_service_impl::Reset(ServerContext* context, const ResetRequest* request, StatusResponse* response)
{
    const auto& instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    bool status = slave->reset();
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::Terminate(ServerContext* context, const TerminateRequest* request, StatusResponse* response)
{
    const auto& instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    bool status = slave->terminate();
    response->set_status(grpc_type(slave->last_status()));
    std::cout << "Terminated FMU instance with id=" << instance_id << std::endl;
    return ::Status::OK;
}

::Status fmu_service_impl::FreeInstance(::grpc::ServerContext* context, const ::fmuproxy::grpc::FreeRequest* request, ::fmuproxy::grpc::Void* response)
{
    const auto& instance_id = request->instance_id();
    auto& slave = slaves_[instance_id];
    slaves_.erase(instance_id);
    std::cout << "Freed FMU instance with id=" << instance_id << std::endl;
    return ::Status::OK;
}

::Status fmu_service_impl::ReadInteger(ServerContext* context, const ReadRequest* request, IntegerRead* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2Integer> read(vr.size());
    bool status = slave->read_integer(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status fmu_service_impl::ReadReal(ServerContext* context, const ReadRequest* request, RealRead* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2Real> read(vr.size());
    bool status = slave->read_real(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status fmu_service_impl::ReadString(ServerContext* context, const ReadRequest* request, StringRead* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2String> read(vr.size());
    bool status = slave->read_string(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status fmu_service_impl::ReadBoolean(ServerContext* context, const ReadRequest* request, BooleanRead* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2Boolean> read(vr.size());
    bool status = slave->read_boolean(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add((const bool&)value);
    }
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteInteger(ServerContext* context, const WriteIntegerRequest* request, StatusResponse* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2Integer> values(request->values().begin(), request->values().end());
    bool status = slave->write_integer(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteReal(ServerContext* context, const WriteRealRequest* request, StatusResponse* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2Real> values(request->values().begin(), request->values().end());
    bool status = slave->write_real(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteString(ServerContext* context, const WriteStringRequest* request, StatusResponse* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2String> values(vr.size());
    std::transform(request->values().begin(), request->values().end(), std::back_inserter(values), str_to_char);
    bool status = slave->write_string(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteBoolean(ServerContext* context, const WriteBooleanRequest* request, StatusResponse* response)
{
    auto& slave = slaves_[request->instance_id()];
    std::vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    std::vector<fmi2Boolean> values(request->values().begin(), request->values().end());
    bool status = slave->write_boolean(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::GetDirectionalDerivative(ServerContext* context,
    const ::fmuproxy::grpc::GetDirectionalDerivativeRequest* request,
    GetDirectionalDerivativeResponse* response)
{

    auto& slave = slaves_[request->instance_id()];

    if (!slave->get_model_description()->provides_directional_derivative) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetDirectionalDerivative'!");
    }

    std::vector<fmi2ValueReference> vKnownRef = std::vector<fmi2ValueReference>(request->v_known_ref().begin(),
        request->v_known_ref().end());
    std::vector<fmi2ValueReference> vUnknownRef = std::vector<fmi2ValueReference>(request->v_unknown_ref().begin(),
        request->v_unknown_ref().end());
    std::vector<fmi2Real> dvKnownRef = std::vector<fmi2Real>(request->dv_known_ref().begin(), request->dv_known_ref().end());
    std::vector<fmi2Real> dvUnknownRef(vUnknownRef.size());
    bool status = slave->get_directional_derivative(vKnownRef, vUnknownRef, dvKnownRef, dvUnknownRef);

    for (const auto& ref : dvUnknownRef) {
        response->add_dv_unknown_ref(ref);
    }
    response->set_status(grpc_type(slave->last_status()));

    return ::Status::OK;
}


//::Status
//fmu_service_impl::GetFMUstate(ServerContext *context, const GetFMUstateRequest *request, GetFMUstateResponse *response) {
//    auto &slave = slaves_[request->instance_id()];
//
//    if (!slave->get_model_description()->can_get_and_set_fmu_state) {
//        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
//    }
//
//    return ::Status::CANCELLED;
//}
//
//::Status
//fmu_service_impl::SetFMUstate(ServerContext *context, const SetFMUstateRequest *request, StatusResponse *response) {
//    auto &slave = slaves_[request->instance_id()];
//
//    if (!slave->get_model_description()->can_get_and_set_fmu_state) {
//        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
//    }
//
//    return ::Status::CANCELLED;
//}
//
//::Status
//fmu_service_impl::FreeFMUstate(ServerContext *context, const FreeFMUstateRequest *request, StatusResponse *response) {
//
//    auto &slave = slaves_[request->instance_id()];
//
//    if (!slave->get_model_description()->can_get_and_set_fmu_state) {
//        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
//    }
//
//    return ::Status::CANCELLED;
//}
//
//::Status
//fmu_service_impl::SerializeFMUstate(ServerContext *context, const SerializeFMUstateRequest *request,
//                                  SerializeFMUstateResponse *response) {
//
//    auto &slave = slaves_[request->instance_id()];
//
//    if (!slave->get_model_description()->can_serialize_fmu_state) {
//        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'SerializeFMUstate'!");
//    }
//
//    return ::Status::CANCELLED;
//}
//
//::Status
//fmu_service_impl::DeSerializeFMUstate(ServerContext *context, const DeSerializeFMUstateRequest *request,
//                                    DeSerializeFMUstateResponse *response) {
//
//    auto &slave = slaves_[request->instance_id()];
//
//    if (!slave->get_model_description()->can_serialize_fmu_state) {
//        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'deSerializeFMUstate'!");
//    }
//
//    return ::Status::CANCELLED;
//}
