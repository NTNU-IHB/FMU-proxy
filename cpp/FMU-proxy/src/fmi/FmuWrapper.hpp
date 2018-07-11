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

#ifndef FMU_PROXY_FMUWRAPPER_H
#define FMU_PROXY_FMUWRAPPER_H

#include <iostream>
#include <vector>

#include <boost/filesystem.hpp>

#include "FmiDefinitions.hpp"

namespace fs = boost::filesystem;

namespace fmi {


    class VariableReader {

    private:
        fmi2_import_t *instance;
        const fmi2_value_reference_t vr;

    public:
        VariableReader(fmi2_import_t *instance, fmi2_value_reference_t vr): instance(instance), vr(vr){}

        fmi2_status_t readInteger(fmi2_integer_t &value) {
            return fmi2_import_get_integer(instance, &vr, 1, &value);
        }

        fmi2_status_t readReal(fmi2_real_t &value) {
            return fmi2_import_get_real(instance, &vr, 1, &value);
        }

        fmi2_status_t readString(fmi2_string_t &value) {
            return fmi2_import_get_string(instance, &vr, 1, &value);
        }

        fmi2_status_t readBoolean(fmi2_boolean_t &value) {
            return fmi2_import_get_boolean(instance, &vr, 1, &value);
        }

    };

    class VariableWriter {

    private:
        fmi2_import_t *instance;
        const fmi2_value_reference_t vr;

    public:
        VariableWriter(fmi2_import_t *instance, fmi2_value_reference_t vr): instance(instance), vr(vr){}

        fmi2_status_t writeInteger(fmi2_integer_t value) {
            return fmi2_import_set_integer(instance, &vr, 1, &value);
        }

        fmi2_status_t writeReal(fmi2_real_t value) {
            return fmi2_import_set_real(instance, &vr, 1, &value);
        }

        fmi2_status_t writeString(fmi2_string_t value) {
            return fmi2_import_set_string(instance, &vr, 1, &value);
        }

        fmi2_status_t writeBoolean(fmi2_boolean_t value) {
            return fmi2_import_set_boolean(instance, &vr, 1, &value);
        }

    };

    class FmuInstance {

    private:

        fmi2_import_t *instance;

        double current_time = 0.0;
        bool terminated = false;


    public:
        FmuInstance(fmi2_import_t* instance);

        void init(double start, double end);

        fmi2_status_t step(double step_size);

        fmi2_status_t reset();

        fmi2_status_t terminate();

        double getCurrentTime();

        bool isTerminated();

        fmi2_status_t getInteger(fmi2_value_reference_t vr, fmi2_integer_t &ref);
        fmi2_status_t getInteger(std::string name, fmi2_integer_t &ref);

        fmi2_status_t getReal(fmi2_value_reference_t vr, fmi2_real_t &ref);
        fmi2_status_t getReal(std::string name, fmi2_real_t &ref);

        fmi2_status_t getString(fmi2_value_reference_t vr, fmi2_string_t &ref);
        fmi2_status_t getString(std::string name, fmi2_string_t &ref);

        fmi2_status_t getBoolean(fmi2_value_reference_t vr, fmi2_boolean_t &ref);
        fmi2_status_t getBoolean(std::string name, fmi2_boolean_t &ref);

        VariableReader getReader(fmi2_value_reference_t vr);

        VariableReader getReader(std::string name);

        VariableWriter getWriter(fmi2_value_reference_t vr);

        VariableWriter getWriter(std::string name);

        fmi2_value_reference_t get_value_reference(std::string name);

        ~FmuInstance() {

            std::cout << "FmuInstance destructor called" << std::endl;

            terminate();
            fmi2_import_destroy_dllfmu(instance);
            fmi2_import_free(instance);

        }

    };

    class FmuWrapper {

    private:

        fs::path tmp_path;
        fmi2_import_t* xml;
        fmi_xml_context_t* ctx;
        jm_callbacks callbacks;
        fmi_version_enu_t version;

        std::shared_ptr<ModelDescription> modelDescription;

    public:
        FmuWrapper(std::string fmu_path);

        std::string getModelDescriptionXml();

        ModelDescription &getModelDescription();

        std::unique_ptr<FmuInstance> newInstance();

        ~FmuWrapper() {

            std::cout << "FmuWrapper destructor called" << std::endl;

            fmi_import_free_context(this->ctx);
            remove_all(this->tmp_path);

        }

    };

}


#endif //FMU_PROXY_FMUWRAPPER_H

