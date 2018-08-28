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
#include <fmuproxy/fmi/LocalFmuSlave.hpp>

using namespace std;
using namespace fmuproxy::fmi;

namespace {

    static int64_t STATE_GENERATOR = 0;

    static const double RELATIVE_TOLERANCE = 1E-4;

    template<typename A, typename B>
    inline void checkSize(vector<A> v1, vector<B> v2) {
        if (v1.size() != v2.size()) {
            throw runtime_error("Vector sizes not equal!");
        }
    }

}

LocalFmuSlave::LocalFmuSlave(fmi2_import_t *instance, ModelDescription &modelDescription)
    : FmuSlave(modelDescription), instance_(instance) {}


bool LocalFmuSlave::canGetAndSetFMUstate() const {
    return fmi2_import_get_capability(instance_, fmi2_cs_canGetAndSetFMUstate);
}

bool LocalFmuSlave::canSerializeFMUstate() const {
    return fmi2_import_get_capability(instance_, fmi2_cs_canSerializeFMUstate);
}

bool LocalFmuSlave::providesDirectionalDerivatives() const {
    return fmi2_import_get_capability(instance_, fmi2_cs_providesDirectionalDerivatives);
}

void LocalFmuSlave::init(double start, double stop) {

    fmi2_boolean_t stop_time_defined = start < stop;
    fmi2_status_t status = fmi2_import_setup_experiment(instance_, fmi2_true,
                                                        RELATIVE_TOLERANCE, start, stop_time_defined, stop);

    if(status != fmi2_status_ok) {
        throw runtime_error("fmi2_import_setup_experiment failed");
    }

    status = fmi2_import_enter_initialization_mode(instance_);
    if(status != fmi2_status_ok) {
        throw runtime_error("fmi2_import_enter_initialization_mode failed");
    }

    status = fmi2_import_exit_initialization_mode(instance_);
    if(status != fmi2_status_ok) {
        throw runtime_error("fmi2_import_exit_initialization_mode failed");
    }

    simulationTime_ = start;

}

fmi2_status_t LocalFmuSlave::step(double step_size) {
    fmi2_status_t status = fmi2_import_do_step(
            instance_, simulationTime_, step_size, fmi2_true);
    if (status == fmi2_status_ok) {
        simulationTime_ += step_size;
    }
    return status;
}

fmi2_status_t LocalFmuSlave::cancelStep() {
    return fmi2_import_cancel_step(instance_);
}

fmi2_status_t LocalFmuSlave::reset() {
    return fmi2_import_reset(instance_);
}

fmi2_status_t LocalFmuSlave::terminate() {
    if (!isTerminated_) {
        isTerminated_ = true;
        return fmi2_import_terminate(instance_);
    }
    return fmi2_status_ok;
}

fmi2_status_t LocalFmuSlave::readInteger(const fmi2_value_reference_t vr, fmi2_integer_t &ref) {
    return fmi2_import_get_integer(instance_, &vr, 1, &ref);
}

fmi2_status_t LocalFmuSlave::readInteger(const vector<fmi2_value_reference_t> &vr, vector<fmi2_integer_t> &ref) {
    if (vr.size() != ref.size()) {
        throw runtime_error("vr.size() != ref.size()!");
    }
    return fmi2_import_get_integer(instance_, vr.data(), vr.size(), ref.data());
}

fmi2_status_t LocalFmuSlave::readReal(const fmi2_value_reference_t vr, fmi2_real_t &ref) {
    return fmi2_import_get_real(instance_, &vr, 1, &ref);
}

fmi2_status_t LocalFmuSlave::readReal(const vector<fmi2_value_reference_t> &vr, vector<fmi2_real_t> &ref) {
    checkSize(vr, ref);
    return fmi2_import_get_real(instance_, vr.data(), vr.size(), ref.data());
}

fmi2_status_t LocalFmuSlave::readString(const fmi2_value_reference_t vr, fmi2_string_t &ref) {
    return fmi2_import_get_string(instance_, &vr, 1, &ref);
}

fmi2_status_t LocalFmuSlave::readString(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_string_t> &ref) {
    checkSize(vr, ref);
    return fmi2_import_get_string(instance_, vr.data(), vr.size(), ref.data());
}

fmi2_status_t LocalFmuSlave::readBoolean(const fmi2_value_reference_t vr, fmi2_boolean_t &ref) {
    return fmi2_import_get_boolean(instance_, &vr, 1, &ref);
}

fmi2_status_t LocalFmuSlave::readBoolean(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_boolean_t> &ref) {
    checkSize(vr, ref);
    return fmi2_import_get_boolean(instance_, vr.data(), vr.size(), ref.data());
}

fmi2_status_t LocalFmuSlave::writeInteger(const fmi2_value_reference_t vr, const fmi2_integer_t value) {
    return fmi2_import_set_integer(instance_, &vr, 1, &value);
}

fmi2_status_t LocalFmuSlave::writeInteger(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_integer_t> &value) {
    checkSize(vr, value);
    return fmi2_import_set_integer(instance_, vr.data(), vr.size(), value.data());
}

fmi2_status_t LocalFmuSlave::writeReal(const fmi2_value_reference_t vr, const fmi2_real_t value) {
    return fmi2_import_set_real(instance_, &vr, 1, &value);
}

fmi2_status_t LocalFmuSlave::writeReal(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_real_t> &value) {
    checkSize(vr, value);
    return fmi2_import_set_real(instance_, vr.data(), vr.size(), value.data());
}

fmi2_status_t LocalFmuSlave::writeString(const fmi2_value_reference_t vr, const fmi2_string_t value) {
    return fmi2_import_set_string(instance_, &vr, 1, &value);
}

fmi2_status_t LocalFmuSlave::writeString(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_string_t> &value) {
    checkSize(vr, value);
    return fmi2_import_set_string(instance_, vr.data(), vr.size(), value.data());
}

fmi2_status_t LocalFmuSlave::writeBoolean(const fmi2_value_reference_t vr, const fmi2_boolean_t value) {
    return fmi2_import_set_boolean(instance_, &vr, 1, &value);
}

fmi2_status_t LocalFmuSlave::writeBoolean(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_boolean_t> &value) {
    checkSize(vr, value);
    return fmi2_import_set_boolean(instance_, vr.data(), vr.size(), value.data());
}

fmi2_status_t LocalFmuSlave::getFMUstate(int64_t &state) {
    fmi2_FMU_state_t *_state = nullptr;
    fmi2_status_t status = fmi2_import_get_fmu_state(instance_, _state);
    state = ++STATE_GENERATOR;
    states[state] = _state;
    return status;
}

fmi2_status_t LocalFmuSlave::setFMUstate(const int64_t state) {
    fmi2_FMU_state_t _state = states[state];
    return fmi2_import_set_fmu_state(instance_, _state);
}

fmi2_status_t LocalFmuSlave::freeFMUstate(int64_t &state) {
    fmi2_FMU_state_t _state = states[state];
    state = -1; //invalidate state
    return fmi2_import_free_fmu_state(instance_, &_state);
}

fmi2_status_t LocalFmuSlave::serializeFMUstate(const int64_t state, string &serializedState) {
    fmi2_FMU_state_t _state = states[state];

    size_t size;
    fmi2_import_serialized_fmu_state_size(instance_, _state, &size);

    return fmi2_import_serialize_fmu_state(instance_, _state, serializedState.data(), size);
}

fmi2_status_t LocalFmuSlave::deSerializeFMUstate(const std::string serializedState, int64_t &state) {

    fmi2_FMU_state_t *_state = nullptr;
    fmi2_status_t status = fmi2_import_de_serialize_fmu_state(instance_,
            serializedState.data(), serializedState.size(), _state);

    state = ++STATE_GENERATOR;
    states[state] = _state;

    return status;
}

fmi2_status_t LocalFmuSlave::getDirectionalDerivative(const std::vector<fmi2_value_reference_t> vUnknownRef,
                                                      const std::vector<fmi2_value_reference_t> vKnownRef,
                                                      const std::vector<fmi2_real_t> dvKnownRef,
                                                      std::vector<fmi2_real_t> dvUnknownRef) {
    return fmi2_import_get_directional_derivative(instance_, vUnknownRef.data(), vUnknownRef.size(),
            vKnownRef.data(), vKnownRef.size(), dvKnownRef.data(), dvUnknownRef.data());
}

LocalFmuSlave::~LocalFmuSlave()  {

    std::cout << "FmuInstance destructor called" << std::endl;

    terminate();
    fmi2_import_destroy_dllfmu(instance_);
    fmi2_import_free(instance_);
    instance_ = nullptr;

}

