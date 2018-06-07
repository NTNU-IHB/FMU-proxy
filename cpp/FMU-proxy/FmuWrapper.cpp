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
#include <cfloat>

#include "FmuWrapper.h"
#include "ThriftHelper.h"

#define RELTOL 1E-4

using namespace std;
using namespace ::fmuproxy::thrift;
using namespace thrift_helper;
using namespace boost::filesystem;

void import_logger(jm_callbacks *c, jm_string module, jm_log_level_enu_t log_level, jm_string message)
{
    printf("module = %s, log level = %s: %s\n", module, jm_log_level_to_string(log_level), message);
}


jm_callbacks create_callbacks(jm_log_level_enu_t log_level = jm_log_level_debug) {
    jm_callbacks callbacks;
    callbacks.malloc = std::malloc;
    callbacks.calloc = std::calloc;
    callbacks.realloc = std::realloc;
    callbacks.free = std::free;
    callbacks.logger = import_logger;
    callbacks.log_level = log_level;
    callbacks.context = nullptr;
    return callbacks;
}

fmi2_import_t* load_model_description(const char* tmp_path,  fmi_xml_context_t* ctx, jm_callbacks callbacks) {

    fmi2_import_t* xml = fmi2_import_parse_xml(ctx, tmp_path, nullptr);

    if(!xml) {
        __throw_runtime_error("Error parsing XML, exiting");
    }

    if(fmi2_import_get_fmu_kind(xml) == fmi2_fmu_kind_me) {
        __throw_runtime_error("Only CS 2.0 is supported by this code");
    }

    return xml;

}

fmuproxy::FmuWrapper::FmuWrapper (const char* fmu_path) {

    tmp_path = temp_directory_path() /= path(fmu_path).stem();
    create_directories(tmp_path);

    callbacks = create_callbacks(jm_log_level_nothing);

    ctx = fmi_import_allocate_context(&callbacks);
    version = fmi_import_get_fmi_version(ctx, fmu_path, tmp_path.c_str());

    xml = load_model_description(tmp_path.c_str(), ctx, callbacks);

    modelDescription = new ModelDescription();
    get_model_description(version, xml, *modelDescription);

}

ModelDescription* fmuproxy::FmuWrapper::getModelDescription() {
    return modelDescription;
}

fmuproxy::FmuInstance* fmuproxy::FmuWrapper::newInstance() {

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
        __throw_runtime_error(error_msg.c_str());
    }

    jm_status_enu_t jmstatus = fmi2_import_instantiate(
            fmu, model_identifier, fmi2_cosimulation, nullptr, false);
    if (jmstatus == jm_status_error) {
        __throw_runtime_error("fmi2_import_instantiate failed!");
    }

    return new FmuInstance(fmu);

}

fmuproxy::FmuWrapper::~FmuWrapper() {

    cout << "FmuWrapper destructor called" << endl;

    delete modelDescription;
    fmi_import_free_context(ctx);
    remove_all(tmp_path);

}

fmuproxy::FmuInstance::FmuInstance(fmi2_import_t *fmu) {
    this->instance = fmu;
}

void fmuproxy::FmuInstance::init(double start, double stop) {

    fmi2_boolean_t stop_time_defined = start < stop;
    fmi2_status_t status = fmi2_import_setup_experiment(instance, fmi2_true,
                                                        RELTOL, start, stop_time_defined, stop);
    if(status != fmi2_status_ok) {
        __throw_runtime_error("fmi2_import_setup_experiment failed");
    }

    status = fmi2_import_enter_initialization_mode(instance);
    if(status != fmi2_status_ok) {
        __throw_runtime_error("fmi2_import_enter_initialization_mode failed");
    }

    status = fmi2_import_exit_initialization_mode(instance);
    if(status != fmi2_status_ok) {
        __throw_runtime_error("fmi2_import_exit_initialization_mode failed");
    }

}

void fmuproxy::FmuInstance::step(double step_size, StepResult& result) {
    fmi2_status_t status = fmi2_import_do_step(
            instance, current_time, step_size, fmi2_true);
    current_time += step_size;

    result.status = thriftType(status);
    result.simulationTime = current_time;
}

Status::type fmuproxy::FmuInstance::reset() {
    fmi2_status_t status = fmi2_import_reset(instance);
    return thriftType(status);
}

Status::type fmuproxy::FmuInstance::terminate() {
    if (!terminated) {
        terminated = true;
        fmi2_status_t status = fmi2_import_terminate(instance);
        return thriftType(status);
    }
}

void fmuproxy::FmuInstance::getInteger(unsigned int vr, IntegerRead& read) {
    int value;
    fmi2_status_t status = fmi2_import_get_integer(instance, &vr, 1, &value);
    read.value = value;
    read.status = thriftType(status);
}

void fmuproxy::FmuInstance::getInteger(const char* name, IntegerRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name);
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getInteger(vr, read);
}

void fmuproxy::FmuInstance::getReal(unsigned int vr, RealRead& read) {
    double value;
    fmi2_status_t status = fmi2_import_get_real(instance, &vr, 1, &value);
    read.value = value;
    read.status = thriftType(status);
}

void fmuproxy::FmuInstance::getReal(const char* name, RealRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name);
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getReal(vr, read);
}

void fmuproxy::FmuInstance::getString(unsigned int vr, StringRead& read) {
    const char* value;
    fmi2_status_t status = fmi2_import_get_string(instance, &vr, 1, &value);
    read.value = value;
    read.status = thriftType(status);
}

void fmuproxy::FmuInstance::getString(const char* name, StringRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name);
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getString(vr, read);
}

void fmuproxy::FmuInstance::getBoolean(unsigned int vr, BooleanRead& read) {
    int value;
    fmi2_status_t status = fmi2_import_get_boolean(instance, &vr, 1, &value);
    read.value == value;
    read.status = thriftType(status);
}

void fmuproxy::FmuInstance::getBoolean(const char* name, BooleanRead& read) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name);
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    getBoolean(vr, read);
}

fmuproxy::FmuInstance::~FmuInstance() {

    cout << "FmuInstance destructor called" << endl;

    terminate();
    fmi2_import_destroy_dllfmu(instance);
    fmi2_import_free(instance);

}





