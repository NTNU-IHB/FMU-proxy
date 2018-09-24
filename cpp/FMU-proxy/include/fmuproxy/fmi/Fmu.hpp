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

#ifndef FMU_PROXY_FMU_H
#define FMU_PROXY_FMU_H

#include <experimental/filesystem>

#include "fmi_definitions.hpp"
#include "LocalFmuSlave.hpp"

namespace fs = std::experimental::filesystem;

namespace fmuproxy::fmi {

    class Fmu {

    private:

        fmi2_import_t* xml_;
        fmi_xml_context_t* ctx_;
        jm_callbacks callbacks_;
        fmi_version_enu_t version_;

        fs::path tmp_path_;
        std::string model_description_xml_;
        std::shared_ptr<ModelDescription> modelDescription_;

    public:
        explicit Fmu(const std::string &fmu_path);

        const std::string &getModelDescriptionXml() const;

        const ModelDescription &getModelDescription() const;

        std::unique_ptr<LocalFmuSlave> newInstance();

        ~Fmu();

    };

}

#endif //FMU_PROXY_FMU_H

