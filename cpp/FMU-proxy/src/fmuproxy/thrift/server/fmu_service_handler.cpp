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
#include "thrift_server_helper.hpp"

#include <fmuproxy/thrift/server/fmu_service_handler.hpp>

#include <boost/filesystem.hpp>

#include <cstring>
#include <iostream>
#include <utility>

using namespace std;
using namespace fmuproxy;
using namespace fmuproxy::thrift::server;

namespace fs = boost::filesystem;

namespace
{

const char* str_to_char(const std::string& s)
{
    char* pc = new char[s.size() + 1];
    std::strcpy(pc, s.c_str());
    return pc;
}

} // namespace

fmu_service_handler::fmu_service_handler(unordered_map<FmuId, shared_ptr<fmi4cpp::fmi2::cs_fmu>>& fmus)
    : fmus_(fmus)
{}

void fmu_service_handler::get_model_description(fmuproxy::thrift::ModelDescription& _return, const FmuId& id)
{
    const auto& fmu = fmus_.at(id);
    thrift_type(_return, *fmu->get_model_description());
}

void fmu_service_handler::load_from_url(FmuId& _return, const std::string& url)
{
    auto ex = UnsupportedOperationException();
    ex.message = "load_from_url is unsupported!";
    throw ex;
}

void fmu_service_handler::load_from_file(FmuId& _return, const std::string& name, const std::string& data)
{
    fs::path tmp(fs::temp_directory_path() /= fs::path(name + "_" + generate_simple_id(8) + ".fmu"));
    const std::string fmuPath = tmp.string();
    write_data(fmuPath, data);

    auto fmu = fmi4cpp::fmi2::fmu(fmuPath).as_cs_fmu();

    fs::remove_all(tmp);

    auto guid = fmu->get_model_description()->guid;
    if (!fmus_.count(guid)) {
        fmus_[guid] = move(fmu);
    }
    _return = guid;
}

void fmu_service_handler::create_instance(InstanceId& _return, const FmuId& id)
{
    auto& fmu = fmus_.at(id);
    _return = generate_simple_id(10);
    slaves_[_return] = fmu->new_instance();
    cout << "Created new FMU slave from cs with id=" << _return << endl;
}

Status::type fmu_service_handler::setup_experiment(const InstanceId& instanceId, const double start, const double stop,
    const double tolerance)
{
    auto& slave = slaves_[instanceId];
    bool success = slave->setup_experiment(start, stop, tolerance);
    return thrift_type(slave->last_status());
}

Status::type fmu_service_handler::enter_initialization_mode(const InstanceId& instanceId)
{
    auto& slave = slaves_[instanceId];
    bool success = slave->enter_initialization_mode();
    return thrift_type(slave->last_status());
}

Status::type fmu_service_handler::exit_initialization_mode(const InstanceId& instanceId)
{
    auto& slave = slaves_[instanceId];
    bool success = slave->exit_initialization_mode();
    return thrift_type(slave->last_status());
}


void fmu_service_handler::step(StepResult& _return, const InstanceId& slave_id, const double step_size)
{
    auto& slave = slaves_[slave_id];
    bool success = slave->step(step_size);
    _return.simulation_time = slave->get_simulation_time();
    _return.status = thrift_type(slave->last_status());
}

Status::type fmu_service_handler::terminate(const InstanceId& slave_id)
{
    auto& slave = slaves_[slave_id];
    bool success = slave->terminate();
    auto status = thrift_type(slave->last_status());
    slaves_.erase(slave_id);
    cout << "Terminated FMU slave with id=" << slave_id << endl;
    return status;
}

Status::type fmu_service_handler::reset(const InstanceId& slave_id)
{
    auto& slave = slaves_[slave_id];
    bool success = slave->reset();
    return thrift_type(slave->last_status());
}

void fmu_service_handler::read_integer(IntegerRead& _return, const InstanceId& slave_id, const ValueReferences& vr)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Integer> _value(vr.size());
    bool success = slave->read_integer(_vr, _value);
    _return.status = thrift_type(slave->last_status());
    _return.value = _value;
}

void fmu_service_handler::read_real(RealRead& _return, const InstanceId& slave_id, const ValueReferences& vr)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Real> _value(vr.size());
    bool success = slave->read_real(_vr, _value);
    _return.status = thrift_type(slave->last_status());
    _return.value = _value;
}


void fmu_service_handler::read_string(StringRead& _return, const InstanceId& slave_id, const ValueReferences& vr)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2String> _value(vr.size());
    bool success = slave->read_string(_vr, _value);
    _return.status = thrift_type(slave->last_status());
    _return.value = vector<string>(_value.begin(), _value.end());
}

void fmu_service_handler::read_boolean(BooleanRead& _return, const InstanceId& slave_id, const ValueReferences& vr)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2Boolean> _value(vr.size());
    bool success = slave->read_boolean(_vr, _value);
    _return.status = thrift_type(slave->last_status());
    _return.value = vector<bool>(_value.begin(), _value.end());
}

Status::type
fmu_service_handler::write_integer(const InstanceId& slave_id, const ValueReferences& vr, const IntArray& value)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    bool success = slave->write_integer(_vr, value);
    return thrift_type(slave->last_status());
}


Status::type
fmu_service_handler::write_real(const InstanceId& slave_id, const ValueReferences& vr, const RealArray& value)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    bool success = slave->write_real(_vr, value);
    return thrift_type(slave->last_status());
}


Status::type
fmu_service_handler::write_string(const InstanceId& slave_id, const ValueReferences& vr, const StringArray& values)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    vector<fmi2String> _values(_vr.size());
    std::transform(values.begin(), values.end(), std::back_inserter(_values), str_to_char);
    bool success = slave->write_string(_vr, _values);
    return thrift_type(slave->last_status());
}


Status::type
fmu_service_handler::write_boolean(const InstanceId& slave_id, const ValueReferences& vr, const BooleanArray& value)
{
    auto& slave = slaves_[slave_id];
    const vector<fmi2ValueReference> _vr(vr.begin(), vr.end());
    const vector<int> _value(value.begin(), value.end());
    bool success = slave->write_boolean(_vr, _value);
    return thrift_type(slave->last_status());
}

void fmu_service_handler::get_directional_derivative(DirectionalDerivativeResult& _return, const InstanceId& slave_id,
    const ValueReferences& vUnknownRef, const ValueReferences& vKnownRef,
    const std::vector<double>& dvKnownRef)
{
    auto& slave = slaves_[slave_id];
    if (!slave->get_model_description()->provides_directional_derivative) {
        auto ex = UnsupportedOperationException();
        ex.message = "FMU does not have capability 'getDirectionalDerivative'";
        throw ex;
    }

    vector<fmi2ValueReference> _vUnknownRef(vUnknownRef.begin(), vUnknownRef.end());
    vector<fmi2ValueReference> _vKnownRef(vKnownRef.begin(), vKnownRef.end());

    std::vector<double> dvUnknownRef(vUnknownRef.size());
    bool success = slave->get_directional_derivative(_vUnknownRef, _vKnownRef, dvKnownRef, dvUnknownRef);

    _return.status = thrift_type(slave->last_status());
    _return.dv_unknown_ref = dvUnknownRef;
}

//void fmu_service_handler::getFMUstate(get_fmu_state_result &_return, const InstanceId &slave_id) {
//    auto &slave = slaves_[slave_id];
//    if (!slave->get_model_description()->can_get_and_set_fmu_state) {
//        auto ex = UnsupportedOperationException();
//        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
//        throw ex;
//    }
//    _return.__set_status(Status::type::ERROR_STATUS);
//}
//
//Status::type fmu_service_handler::setFMUstate(const InstanceId &slave_id, const FmuState state) {
//    auto &slave = slaves_[slave_id];
//    if (!slave->get_model_description()->can_get_and_set_fmu_state) {
//        auto ex = UnsupportedOperationException();
//        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
//        throw ex;
//    }
//    return Status::type::ERROR_STATUS;
//}
//
//Status::type fmu_service_handler::freeFMUstate(const InstanceId &slave_id, FmuState state) {
//    auto &slave = slaves_[slave_id];
//    if (!slave->get_model_description()->can_get_and_set_fmu_state) {
//        auto ex = UnsupportedOperationException();
//        ex.message = "FMU does not have capability 'GetAndSetFMUstate'";
//        throw ex;
//    }
//    return Status::type::ERROR_STATUS;
//}
//
//void fmu_service_handler::serializeFMUstate(SerializeFmuStateResult &_return, const InstanceId &slave_id,
//                                          const FmuState state) {
//    auto &slave = slaves_[slave_id];
//    if (!slave->get_model_description()->can_serialize_fmu_state) {
//        auto ex = UnsupportedOperationException();
//        ex.message = "FMU does not have capability 'SerializeFMUstate'";
//        throw ex;
//    }
//    _return.__set_status(Status::type::ERROR_STATUS);
//}
//
//void fmu_service_handler::deSerializeFMUstate(DeSerializeFmuStateResult &_return, const InstanceId &slave_id,
//                                            const string &serializedState) {
//    auto &slave = slaves_[slave_id];
//    if (!slave->get_model_description()->can_serialize_fmu_state) {
//        auto ex = UnsupportedOperationException();
//        ex.message = "FMU does not have capability 'deSerializeFMUstate'";
//        throw ex;
//    }
//    _return.__set_status(Status::type::ERROR_STATUS);
//
//}
