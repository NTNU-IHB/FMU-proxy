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

#include "ThriftHelper.hpp"
#include "FmuHelper.hpp"
#include "FmuWrapper.hpp"

const double RELATIVE_TOLERANCE = 1E-4;

using namespace ::fmuproxy;
using namespace ::fmuproxy::thrift;
using namespace ::fmuproxy::thrift_helper;
using namespace boost::filesystem;


FmuWrapper::FmuWrapper (string fmu_path) {

    this->tmp_path = temp_directory_path() /= path(fmu_path).stem();
    create_directories(tmp_path);

    this->callbacks = create_callbacks(jm_log_level_nothing);

    this->ctx = fmi_import_allocate_context(&callbacks);
    this->version = fmi_import_get_fmi_version(ctx, fmu_path.c_str(), tmp_path.c_str());

    this->xml = load_model_description(tmp_path.c_str(), ctx, callbacks);

    this->modelDescription = shared_ptr<ModelDescription>(new ModelDescription());
    populate_model_description(version, xml, *modelDescription);

}

ModelDescription &FmuWrapper::getModelDescription() {
    return *modelDescription;
}

unique_ptr<FmuInstance> FmuWrapper::newInstance() {

    fmi2_callback_functions_t callBackFunctions;
    callBackFunctions.logger = fmi2_log_forwarding;
    callBackFunctions.allocateMemory = std::calloc;
    callBackFunctions.freeMemory = std::free;
    callBackFunctions.componentEnvironment = nullptr;

    const char* model_identifier = fmi2_import_get_model_identifier_CS(xml);
    fmi2_import_t* fmu = load_model_description(tmp_path.c_str(), ctx, callbacks);

    jm_status_enu_t status = fmi2_import_create_dllfmu(fmu, fmi2_fmu_kind_cs, &callBackFunctions);
    if (status == jm_status_error) {
        string error_msg = "Could not create the DLL loading mechanism(C-API) (error: "  + string(fmi2_import_get_last_error(fmu)) + ")";
        throw runtime_error(error_msg.c_str());
    }

    jm_status_enu_t jmstatus = fmi2_import_instantiate(
            fmu, model_identifier, fmi2_cosimulation, nullptr, false);
    if (jmstatus == jm_status_error) {
        throw runtime_error("fmi2_import_instantiate failed!");
    }

    return unique_ptr<FmuInstance>(new FmuInstance(fmu));

}

FmuWrapper::~FmuWrapper() {

    cout << "FmuWrapper destructor called" << endl;
    
    fmi_import_free_context(this->ctx);
    remove_all(this->tmp_path);

}

FmuInstance::FmuInstance(fmi2_import_t *fmu) {
    this->instance = fmu;
}

void FmuInstance::init(double start, double stop) {

    fmi2_boolean_t stop_time_defined = start < stop;
    fmi2_status_t status = fmi2_import_setup_experiment(instance, fmi2_true,
                                                        RELATIVE_TOLERANCE, start, stop_time_defined, stop);
    if(status != fmi2_status_ok) {
        throw runtime_error("fmi2_import_setup_experiment failed");
    }

    status = fmi2_import_enter_initialization_mode(instance);
    if(status != fmi2_status_ok) {
        throw runtime_error("fmi2_import_enter_initialization_mode failed");
    }

    status = fmi2_import_exit_initialization_mode(instance);
    if(status != fmi2_status_ok) {
        throw runtime_error("fmi2_import_exit_initialization_mode failed");
    }

}

void FmuInstance::step(double step_size, StepResult& result) {
    fmi2_status_t status = fmi2_import_do_step(
            instance, current_time, step_size, fmi2_true);
    current_time += step_size;

    result.status = thriftType(status);
    result.simulationTime = current_time;
}

Status::type FmuInstance::reset() {
    fmi2_status_t status = fmi2_import_reset(instance);
    return thriftType(status);
}

Status::type FmuInstance::terminate() {
    if (!terminated) {
        terminated = true;
        fmi2_status_t status = fmi2_import_terminate(instance);
        return thriftType(status);
    }
    return Status::type::OK_STATUS;
}

void FmuInstance::getInteger(unsigned int vr, IntegerRead& read) {
    int value;
    fmi2_status_t status = fmi2_import_get_integer(instance, &vr, 1, &value);
    read.value = value;
    read.status = thriftType(status);
}

void FmuInstance::getInteger(string name, IntegerRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getInteger(vr, read);
}

void FmuInstance::getReal(unsigned int vr, RealRead& read) {
    double value;
    fmi2_status_t status = fmi2_import_get_real(instance, &vr, 1, &value);
    read.value = value;
    read.status = thriftType(status);
}

void FmuInstance::getReal(string name, RealRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getReal(vr, read);
}

void FmuInstance::getString(unsigned int vr, StringRead& read) {
    const char* value;
    fmi2_status_t status = fmi2_import_get_string(instance, &vr, 1, &value);
    read.value = value;
    read.status = thriftType(status);
}

void FmuInstance::getString(string name, StringRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getString(vr, read);
}

void FmuInstance::getBoolean(unsigned int vr, BooleanRead& read) {
    int value;
    fmi2_status_t status = fmi2_import_get_boolean(instance, &vr, 1, &value);
    read.value == value;
    read.status = thriftType(status);
}

void FmuInstance::getBoolean(string name, BooleanRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getBoolean(vr, read);
}

FmuInstance::~FmuInstance() {

    cout << "FmuInstance destructor called" << endl;

    terminate();
    fmi2_import_destroy_dllfmu(instance);
    fmi2_import_free(instance);

}





