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

#include <fstream>
#include <fmuproxy/fmi/Fmu.hpp>
#include "fmu_helper.hpp"

using namespace std;
using namespace fmuproxy::fmi;

Fmu::Fmu (const string &fmu_path) {

    this->tmp_path_ = fs::temp_directory_path() /= fs::path(fmu_path).stem();
    create_directories(tmp_path_);

    this->callbacks_ = create_callbacks(jm_log_level_nothing);

    this->ctx_ = fmi_import_allocate_context(&callbacks_);
    this->version_ = fmi_import_get_fmi_version(ctx_, fmu_path.c_str(), tmp_path_.string().c_str());

    this->xml_ = load_model_description(tmp_path_.string(), ctx_);

    this->modelDescription_ = make_shared<ModelDescription>();
    populate_model_description(version_, xml_, *modelDescription_);

    ifstream t(tmp_path_.string() + "/modelDescription.xml");
    this->model_description_xml_ = string((istreambuf_iterator<char>(t)),
                    istreambuf_iterator<char>());

}

const ModelDescription &Fmu::getModelDescription() const {
    return *modelDescription_;
}

const string &Fmu::getModelDescriptionXml() const {
    return model_description_xml_;
}

unique_ptr<LocalFmuSlave> Fmu::newInstance() {

    fmi2_callback_functions_t callBackFunctions;
    callBackFunctions.logger = fmi2_log_forwarding;
    callBackFunctions.allocateMemory = calloc;
    callBackFunctions.freeMemory = free;
    callBackFunctions.componentEnvironment = nullptr;

    const char* model_identifier = fmi2_import_get_model_identifier_CS(xml_);
    fmi2_import_t* fmu = load_model_description(tmp_path_.string(), ctx_);

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

    return make_unique<LocalFmuSlave>(fmu, *modelDescription_);

}

Fmu::~Fmu() {

    cout << "Fmu destructor called" << endl;

    fmi2_import_free(xml_);
    fmi_import_free_context(this->ctx_);
    remove_all(this->tmp_path_);

    xml_ = nullptr;
    ctx_ = nullptr;

}
