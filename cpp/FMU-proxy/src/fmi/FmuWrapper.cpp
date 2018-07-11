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

#include "FmuWrapper.hpp"
#include "FmiHelper.hpp"

const double RELATIVE_TOLERANCE = 1E-4;

using namespace std;
using namespace fmi;



FmuWrapper::FmuWrapper (string fmu_path) {

    this->tmp_path = fs::temp_directory_path() /= fs::path(fmu_path).stem();
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
        string error_msg = "Could not create the DLL loading mechanism(C-API) (error: " + string(fmi2_import_get_last_error(fmu)) + ")";
        throw runtime_error(error_msg.c_str());
    }

    jm_status_enu_t jmstatus = fmi2_import_instantiate(
            fmu, model_identifier, fmi2_cosimulation, nullptr, false);
    if (jmstatus == jm_status_error) {
        throw runtime_error("fmi2_import_instantiate failed!");
    }

    return unique_ptr<FmuInstance>(new FmuInstance(fmu));

}

//###################################################################################################################################

FmuInstance::FmuInstance(fmi2_import_t *instance) {
    this->instance = instance;
}

double FmuInstance::getCurrentTime() {
    return current_time;
}

bool FmuInstance::isTerminated() {
    return terminated;
}


fmi2_value_reference_t FmuInstance::get_value_reference(std::string name) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    return fmi2_import_get_variable_vr(var);
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

fmi2_status_t FmuInstance::step(double step_size) {
    fmi2_status_t status = fmi2_import_do_step(
            instance, current_time, step_size, fmi2_true);
    if (status == fmi2_status_ok) {
        current_time += step_size;
    }
    return status;
}

fmi2_status_t FmuInstance::reset() {
    return fmi2_import_reset(instance);
}

fmi2_status_t FmuInstance::terminate() {
    if (!terminated) {
        terminated = true;
        return fmi2_import_terminate(instance);
    }
    return fmi2_status_ok;
}


fmi2_status_t FmuInstance::getInteger(fmi2_value_reference_t vr, fmi2_integer_t  &ref) {
    return fmi2_import_get_integer(instance, &vr, 1, &ref);
}

fmi2_status_t FmuInstance::getInteger(string name, fmi2_integer_t  &ref) {
    return getInteger(get_value_reference(name.c_str()), ref);
}

fmi2_status_t FmuInstance::getReal(fmi2_value_reference_t vr, fmi2_real_t &ref) {
    return fmi2_import_get_real(instance, &vr, 1, &ref);
}

fmi2_status_t FmuInstance::getReal(string name, fmi2_real_t &ref) {
    return getReal(get_value_reference(name.c_str()), ref);
}

fmi2_status_t FmuInstance::getString(fmi2_value_reference_t vr, fmi2_string_t &ref) {
    return fmi2_import_get_string(instance, &vr, 1, &ref);
}

fmi2_status_t FmuInstance::getString(string name, fmi2_string_t &ref) {
    return getString(get_value_reference(name.c_str()), ref);
}

fmi2_status_t FmuInstance::getBoolean(fmi2_value_reference_t vr, fmi2_boolean_t &ref) {
    return fmi2_import_get_boolean(instance, &vr, 1, &ref);
}

fmi2_status_t FmuInstance::getBoolean(string name, fmi2_boolean_t &ref) {
    return getBoolean(get_value_reference(name.c_str()), ref);
}

VariableReader FmuInstance::getReader(fmi2_value_reference_t vr) {
    return VariableReader(instance, vr);
}

VariableReader FmuInstance::getReader(std::string name) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    return getReader(vr);
}

VariableWriter FmuInstance::getWriter(fmi2_value_reference_t vr) {
    return VariableWriter(instance, vr);
}

VariableWriter FmuInstance::getWriter(std::string name) {
    fmi2_import_variable_t* var = fmi2_import_get_variable_by_name(instance, name.c_str());
    fmi2_value_reference_t vr = fmi2_import_get_variable_vr(var);
    return getWriter(vr);
}




