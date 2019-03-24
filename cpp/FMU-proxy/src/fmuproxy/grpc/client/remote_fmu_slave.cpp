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

#include <fmuproxy/grpc/client/remote_fmu_slave.hpp>

#include "grpc_client_helper.hpp"

using namespace std;
using namespace grpc;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::client;

remote_fmu_slave::remote_fmu_slave(const string &instance_id, FmuService::Stub &stub,
                               const fmi4cpp::fmi2::model_description_base &modelDescription)
        : instanceId_(instance_id), stub_(stub) {

    ClientContext ctx;
    CoSimulationAttributes response;

    GetCoSimulationAttributesRequest request;
    request.set_instance_id(instance_id);
    stub.GetCoSimulationAttributes(&ctx, request, &response);

    csModelDescription_ = std::make_shared<const fmi4cpp::fmi2::cs_model_description>(modelDescription,
                                                                                              convert(response));

}

fmi4cpp::status remote_fmu_slave::last_status() const {
    return convert(lastStatus_);
}

shared_ptr<const fmi4cpp::fmi2::cs_model_description> remote_fmu_slave::get_model_description() const {
    return csModelDescription_;
}

bool remote_fmu_slave::updateStatusAndReturnTrueOnOK(fmuproxy::grpc::Status status) {
    lastStatus_ = status;
    return status == fmuproxy::grpc::Status::OK_STATUS;
}

bool remote_fmu_slave::setup_experiment(double startTime, double stopTime, double tolerance) {
    ClientContext ctx;
    StatusResponse response;

    SetupExperimentRequest request;
    request.set_instance_id(instanceId_);
    request.set_start(startTime);
    request.set_stop(stopTime);
    request.set_tolerance(tolerance);

    stub_.SetupExperiment(&ctx, request, &response);
    simulationTime_ = startTime;
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::enter_initialization_mode() {
    ClientContext ctx;
    StatusResponse response;

    EnterInitializationModeRequest request;
    request.set_instance_id(instanceId_);

    stub_.EnterInitializationMode(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::exit_initialization_mode() {
    ClientContext ctx;
    StatusResponse response;

    ExitInitializationModeRequest request;
    request.set_instance_id(instanceId_);

    stub_.ExitInitializationMode(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}


bool remote_fmu_slave::step(const double step_size) {

    ClientContext ctx;
    StepResponse response;

    StepRequest request;
    request.set_instance_id(instanceId_);
    request.set_step_size(step_size);

    stub_.Step(&ctx, request, &response);
    simulationTime_ = response.simulation_time();
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::terminate() {

    if (!terminated_) {
        terminated_ = true;
        ClientContext ctx;
        StatusResponse response;

        TerminateRequest request;
        request.set_instance_id(instanceId_);

        stub_.Terminate(&ctx, request, &response);
        return updateStatusAndReturnTrueOnOK(response.status());
    } else {
        return true;
    }

}

bool remote_fmu_slave::cancel_step() {
    return false;
}

bool remote_fmu_slave::reset() {

    ClientContext ctx;
    StatusResponse response;

    ResetRequest request;
    request.set_instance_id(instanceId_);

    stub_.Reset(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::read_integer(const fmi2ValueReference vr, fmi2Integer &ref) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2Integer> _ref(1);
    const auto status = this->read_integer(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_integer(const vector<fmi2ValueReference> &vr, vector<fmi2Integer> &ref) {

    ClientContext ctx;
    IntegerRead response;

    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }

    stub_.ReadInteger(&ctx, request, &response);
    ref.clear();
    for (const auto v : response.values()) {
        ref.push_back(v);
    }
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::read_real(const fmi2ValueReference vr, fmi2Real &ref) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2Real> _ref(1);
    const auto status = this->read_real(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_real(const vector<fmi2ValueReference> &vr, vector<fmi2Real> &ref) {

    ClientContext ctx;
    RealRead response;

    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }

    stub_.ReadReal(&ctx, request, &response);
    ref.clear();
    for (const auto &v : response.values()) {
        ref.push_back(v);
    }
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::read_string(const fmi2ValueReference vr, fmi2String &ref) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2String> _ref(1);
    const auto status = this->read_string(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_string(const vector<fmi2ValueReference> &vr, vector<fmi2String> &ref) {

    ClientContext ctx;
    StringRead response;

    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto v : vr) {
        _vr->Add(v);
    }

    stub_.ReadString(&ctx, request, &response);
    ref.clear();
    for (const auto &v : response.values()) {
        ref.push_back(v.c_str());
    }
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::read_boolean(const fmi2ValueReference vr, fmi2Boolean &ref) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2Boolean> _ref(1);
    const auto status = this->read_boolean(_vr, _ref);
    ref = _ref[0];
    return status;
}

bool remote_fmu_slave::read_boolean(const vector<fmi2ValueReference> &vr, vector<fmi2Boolean> &ref) {

    ClientContext ctx;
    BooleanRead response;

    ReadRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto &v : vr) {
        _vr->Add(v);
    }

    stub_.ReadBoolean(&ctx, request, &response);
    ref.clear();
    for (const auto v : response.values()) {
        ref.push_back(v ? 1 : 0);
    }
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::write_integer(const fmi2ValueReference vr, fmi2Integer value) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2Integer> _value = {value};
    return write_integer(_vr, _value);
}

bool remote_fmu_slave::write_integer(const vector<fmi2ValueReference> &vr, const vector<fmi2Integer> &value) {

    ClientContext ctx;
    StatusResponse response;

    WriteIntegerRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto &v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto &v : value) {
        _values->Add(v);
    }

    stub_.WriteInteger(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::write_real(const fmi2ValueReference vr, fmi2Real value) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2Real> _value = {value};
    return write_real(_vr, _value);
}

bool remote_fmu_slave::write_real(const vector<fmi2ValueReference> &vr, const vector<fmi2Real> &value) {

    ClientContext ctx;
    StatusResponse response;

    WriteRealRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto &v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto &v : value) {
        _values->Add(v);
    }

    stub_.WriteReal(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::write_string(const fmi2ValueReference vr, fmi2String value) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2String> _value = {value};
    return write_string(_vr, _value);
}

bool remote_fmu_slave::write_string(const vector<fmi2ValueReference> &vr, const vector<fmi2String> &value) {

    ClientContext ctx;
    StatusResponse response;

    WriteStringRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto &v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto &v : value) {
        _values->Add(v);
    }

    stub_.WriteString(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}

bool remote_fmu_slave::write_boolean(const fmi2ValueReference vr, fmi2Boolean value) {
    vector<fmi2ValueReference> _vr = {vr};
    vector<fmi2Boolean> _value = {value};
    return write_boolean(_vr, _value);
}

bool remote_fmu_slave::write_boolean(const vector<fmi2ValueReference> &vr, const vector<fmi2Boolean> &value) {

    ClientContext ctx;
    StatusResponse response;

    WriteBooleanRequest request;
    request.set_instance_id(instanceId_);
    auto _vr = request.mutable_value_references();
    for (const auto &v : vr) {
        _vr->Add(v);
    }
    auto _values = request.mutable_values();
    for (const auto &v : value) {
        _values->Add(v != 0);
    }

    stub_.WriteBoolean(&ctx, request, &response);
    return updateStatusAndReturnTrueOnOK(response.status());
}


//bool remote_fmu_slave::getFMUstate(int64_t &state) {
//
//    ClientContext ctx;
//    GetFMUstateResponse response;
//
//    GetFMUstateRequest request;
//    request.set_instance_id(instanceId_);
//    stub_.GetFMUstate(&ctx, request, &response);
//
//    state = response.state();
//    return convert(response.status());
//}
//
//bool remote_fmu_slave::setFMUstate(const int64_t state) {
//
//    ClientContext ctx;
//    StatusResponse response;
//
//    SetFMUstateRequest request;
//    request.set_state(state);
//    request.set_instance_id(instanceId_);
//    stub_.SetFMUstate(&ctx, request, &response);
//
//    return convert(response.status());
//}
//
//bool remote_fmu_slave::freeFMUstate(int64_t &state) {
//
//    ClientContext ctx;
//    StatusResponse response;
//
//    FreeFMUstateRequest request;
//    request.set_state(state);
//    request.set_instance_id(instanceId_);
//
//    stub_.FreeFMUstate(&ctx, request, &response);
//    state = -1; //invalidate state
//    return convert(response.status());
//}
//
//bool remote_fmu_slave::serializeFMUstate(const int64_t state, string &serializedState) {
//
//    ClientContext ctx;
//    SerializeFMUstateResponse response;
//
//    SerializeFMUstateRequest request;
//    request.set_instance_id(instanceId_);
//    request.set_state(state);
//
//    serializedState = response.state();
//
//    return convert(response.status());
//}
//
//bool remote_fmu_slave::deSerializeFMUstate(const string serializedState, int64_t &state) {
//    ClientContext ctx;
//    DeSerializeFMUstateResponse response;
//
//    DeSerializeFMUstateRequest request;
//    request.set_instance_id(instanceId_);
//    request.set_state(serializedState);
//
//    state = response.state();
//
//    return convert(response.status());
//}

bool remote_fmu_slave::get_directional_derivative(const std::vector<fmi2ValueReference> &vUnknownRef,
                                              const std::vector<fmi2ValueReference> &vKnownRef,
                                              const std::vector<fmi2Real> &dvKnownRef,
                                              std::vector<fmi2Real> &dvUnknown) {
    return updateStatusAndReturnTrueOnOK(grpc::Status::ERROR_STATUS);
}


bool remote_fmu_slave::get_fmu_state(fmi2FMUstate &state) {
    return updateStatusAndReturnTrueOnOK(grpc::Status::ERROR_STATUS);
}

bool remote_fmu_slave::set_fmu_state(fmi2FMUstate state) {
    return updateStatusAndReturnTrueOnOK(grpc::Status::ERROR_STATUS);
}

bool remote_fmu_slave::free_fmu_state(fmi2FMUstate &state) {
    return updateStatusAndReturnTrueOnOK(grpc::Status::ERROR_STATUS);
}

bool remote_fmu_slave::serialize_fmu_state(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) {
    return updateStatusAndReturnTrueOnOK(grpc::Status::ERROR_STATUS);
}

bool remote_fmu_slave::de_serialize_fmu_state(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) {
    return updateStatusAndReturnTrueOnOK(grpc::Status::ERROR_STATUS);
}

remote_fmu_slave::~remote_fmu_slave() {
    terminate();
}


