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
#include <streambuf>
#include <fmuproxy/fmi/Fmu.hpp>
#include <boost/filesystem.hpp>


#include "FmuHelper.cpp"

using namespace std;
using namespace fmuproxy::fmi;

namespace fs = boost::filesystem;

Fmu::Fmu (const string fmu_path) {

    this->tmp_path = fs::temp_directory_path() /= fs::path(fmu_path).stem();
    create_directories(tmp_path);

    this->callbacks = create_callbacks(jm_log_level_nothing);

    this->ctx = fmi_import_allocate_context(&callbacks);
    this->version = fmi_import_get_fmi_version(ctx, fmu_path.c_str(), tmp_path.c_str());

    this->xml = load_model_description(tmp_path.c_str(), ctx, callbacks);

    this->modelDescription = shared_ptr<ModelDescription>(new ModelDescription());
    populate_model_description(version, xml, *modelDescription);

    cout << tmp_path.string() + "/modelDescription.xml" << endl;

    std::ifstream t(tmp_path.string() + "/modelDescription.xml");
    model_description_xml = string((istreambuf_iterator<char>(t)),
                    istreambuf_iterator<char>());

}

const ModelDescription &Fmu::get_model_description() const {
    return *modelDescription;
}

const std::string &Fmu::get_model_description_xml() {
    return model_description_xml;
}

unique_ptr<FmuInstance> Fmu::new_instance() {

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

    return unique_ptr<FmuInstance>(new FmuInstance(fmu, *modelDescription));

}

Fmu::~Fmu() {

    std::cout << "Fmu destructor called" << std::endl;

    fmi2_import_free(xml);
    fmi_import_free_context(this->ctx);
    remove_all(this->tmp_path);

}
