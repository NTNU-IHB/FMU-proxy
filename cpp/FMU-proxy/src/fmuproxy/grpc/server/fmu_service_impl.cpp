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
#include <vector>

#include <fmuproxy/grpc/server/fmu_service_impl.hpp>

#include "../../util/simple_id.hpp"
#include "../../util/file_util.hpp"
#include "grpc_server_helper.hpp"
#include "../../util/solver_util.hpp"

using namespace std;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::server;

using ::grpc::Status;
using ::grpc::ServerContext;

namespace {

    const char* str_to_char(const std::string &s) {
        auto *pc = new char[s.size() + 1];
        std::strcpy(pc, s.c_str());
        return pc;
    }

}

fmu_service_impl::fmu_service_impl(unordered_map<string, shared_ptr<fmi4cpp::fmi2::fmu>> &fmus) : fmus_(fmus) {}

::Status fmu_service_impl::LoadFromUrl(ServerContext *context, const ::fmuproxy::grpc::Url *request,
                            ::fmuproxy::grpc::FmuId *response) {

    return ::Status::CANCELLED;
}


::Status fmu_service_impl::LoadFromFile(::grpc::ServerContext *context, const ::fmuproxy::grpc::File *request,
                                    ::fmuproxy::grpc::FmuId *response) {
    fs::path tmp(fs::temp_directory_path() /= fs::path(request->name() + ".fmu"));
    const std::string fmuPath = tmp.string();
    write_data(fmuPath, request->data());

    auto fmu = std::make_shared<fmi4cpp::fmi2::fmu>(fmuPath);

    fs::remove_all(tmp);

    auto guid = fmu->get_model_description()->guid;
    if (!fmus_.count(guid)) {
        fmus_[guid] = move(fmu);
    }
    response->set_value(guid);
    return ::Status::OK;
}


::Status fmu_service_impl::CanCreateInstanceFromCS(ServerContext *context,
                                                 const ::fmuproxy::grpc::CanCreateInstanceFromCSRequest *request,
                                                 Bool *response) {
    auto &fmu = fmus_[request->fmu_id()];
    response->set_value(fmu->supports_cs());
    return ::Status::OK;
}

::Status fmu_service_impl::CanCreateInstanceFromME(ServerContext *context,
                                                 const CanCreateInstanceFromMERequest *request, Bool *response) {
    auto &fmu = fmus_[request->fmu_id()];
    response->set_value(fmu->supports_me());
    return ::Status::OK;
}

::Status fmu_service_impl::GetModelDescription(ServerContext *context, const GetModelDescriptionRequest *request,
                                             ModelDescription *response) {
    const auto &fmu = fmus_[request->fmu_id()];
    grpc_type(*response, *fmu->get_model_description());
    return ::Status::OK;
}

::Status fmu_service_impl::CreateInstanceFromCS(ServerContext *context, const CreateInstanceFromCSRequest *request,
                                              InstanceId *response) {
    auto &fmu = fmus_[request->fmu_id()];

    const string instance_id = generate_simple_id(10);
    slaves_[instance_id] = fmu->as_cs_fmu()->new_instance();
    response->set_value(instance_id);
    cout << "Created new FMU instance with id=" << instance_id << endl;
    return ::Status::OK;
}

::Status fmu_service_impl::CreateInstanceFromME(ServerContext *context, const CreateInstanceFromMERequest *request,
                                              InstanceId *response) {
    auto &fmu = fmus_[request->fmu_id()];

    const auto solver = request->solver();
    std::unique_ptr<fmi4cpp::solver::me_solver> solver_ = parse_solver(solver.name(), solver.settings());
    const string instance_id = generate_simple_id(10);
    slaves_[instance_id] = fmu->as_me_fmu()->new_instance(solver_);
    response->set_value(instance_id);
    cout << "Created new FMU slave from me with id=" << instance_id << endl;
    return ::Status::OK;
}


::Status
fmu_service_impl::SetupExperiment(::grpc::ServerContext *context, const ::fmuproxy::grpc::SetupExperimentRequest *request,
                                ::fmuproxy::grpc::StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->setup_experiment(request->start(), request->stop(), request->tolerance());
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::EnterInitializationMode(::grpc::ServerContext *context,
                                                 const ::fmuproxy::grpc::EnterInitializationModeRequest *request,
                                                 ::fmuproxy::grpc::StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->enter_initialization_mode();
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::ExitInitializationMode(::grpc::ServerContext *context,
                                                const ::fmuproxy::grpc::ExitInitializationModeRequest *request,
                                                ::fmuproxy::grpc::StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->exit_initialization_mode();
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::Step(ServerContext *context, const StepRequest *request, StepResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->step(request->step_size());
    response->set_status(grpc_type(slave->last_status()));
    response->set_simulation_time(slave->get_simulation_time());
    return ::Status::OK;
}

::Status fmu_service_impl::Terminate(ServerContext *context, const TerminateRequest *request, StatusResponse *response) {
    const auto instance_id = request->instance_id();
    auto &slave = slaves_[instance_id];
    bool status = slave->terminate();
    response->set_status(grpc_type(slave->last_status()));
    slaves_.erase(instance_id);
    cout << "Terminated FMU instance with id=" << instance_id << endl;
    return ::Status::OK;
}

::Status fmu_service_impl::Reset(ServerContext *context, const ResetRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->reset();
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status fmu_service_impl::ReadInteger(ServerContext *context, const ReadRequest *request, IntegerRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Integer> read(vr.size());
    bool status = slave->read_integer(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status fmu_service_impl::ReadReal(ServerContext *context, const ReadRequest *request, RealRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Real> read(vr.size());
    bool status = slave->read_real(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status fmu_service_impl::ReadString(ServerContext *context, const ReadRequest *request, StringRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2String> read(vr.size());
    bool status = slave->read_string(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status fmu_service_impl::ReadBoolean(ServerContext *context, const ReadRequest *request, BooleanRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference>vr (request->value_references().begin(), request->value_references().end());
    vector<fmi2Boolean> read(vr.size());
    bool status = slave->read_boolean(vr, read);
    response->set_status(grpc_type(slave->last_status()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add((const bool &) value);
    }
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteInteger(ServerContext *context, const WriteIntegerRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Integer> values(request->values().begin(), request->values().end());
    bool status = slave->write_integer(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteReal(ServerContext *context, const WriteRealRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Real> values(request->values().begin(), request->values().end());
    bool status = slave->write_real(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteString(ServerContext *context, const WriteStringRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2String> values(vr.size());
    std::transform(request->values().begin(), request->values().end(), std::back_inserter(values), str_to_char);
    bool status = slave->write_string(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}

::Status
fmu_service_impl::WriteBoolean(ServerContext *context, const WriteBooleanRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Boolean> values(request->values().begin(), request->values().end());
    bool status = slave->write_boolean(vr, values);
    response->set_status(grpc_type(slave->last_status()));
    return ::Status::OK;
}


::Status fmu_service_impl::GetCoSimulationAttributes(ServerContext *context,
                                                     const GetCoSimulationAttributesRequest *request,
                                                     CoSimulationAttributes *response) {
    auto &slave = slaves_[request->instance_id()];
    auto md = slave->get_model_description();

    response->set_model_identifier(md->model_identifier);
    response->set_can_get_and_set_fmu_state(md->can_get_and_set_fmu_state);
    response->set_can_serialize_fmu_state(md->can_serialize_fmu_state);
    response->set_can_handle_variable_communication_step_size(md->can_handle_variable_communication_step_size);
    response->set_max_output_derivative_order(md->max_output_derivative_order);
    response->set_provides_directional_derivative(md->provides_directional_derivative);

    return ::Status::OK;
}


::Status fmu_service_impl::GetDirectionalDerivative(ServerContext *context,
                                                    const ::fmuproxy::grpc::GetDirectionalDerivativeRequest *request,
                                                    GetDirectionalDerivativeResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->get_model_description()->provides_directional_derivative) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetDirectionalDerivative'!");
    }

    vector<fmi2ValueReference> vKnownRef = vector<fmi2ValueReference>(request->v_known_ref().begin(),
                                                                      request->v_known_ref().end());
    vector<fmi2ValueReference> vUnknownRef = vector<fmi2ValueReference>(request->v_unknown_ref().begin(),
                                                                        request->v_unknown_ref().end());
    vector<fmi2Real> dvKnownRef = vector<fmi2Real>(request->dv_known_ref().begin(), request->dv_known_ref().end());
    vector<fmi2Real> dvUnknownRef(vUnknownRef.size());
    bool status = slave->get_directional_derivative(vKnownRef, vUnknownRef, dvKnownRef, dvUnknownRef);

    for (const auto &ref : dvUnknownRef) {
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
