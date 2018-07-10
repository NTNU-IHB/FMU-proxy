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

#ifndef FMU_PROXY_FMUHELPER_H
#define FMU_PROXY_FMUHELPER_H

#include <fmilib.h>
#include "thrift-gen/definitions_types.h"

using namespace std;

namespace fmuproxy {

    void import_logger(jm_callbacks *c, jm_string module, jm_log_level_enu_t log_level, jm_string message) {
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

    fmi2_import_t *load_model_description(string tmp_path, fmi_xml_context_t *ctx, jm_callbacks callbacks) {

        fmi2_import_t *xml = fmi2_import_parse_xml(ctx, tmp_path.c_str(), nullptr);

        if (!xml) {
            __throw_runtime_error("Error parsing XML, exiting");
        }

        if (fmi2_import_get_fmu_kind(xml) == fmi2_fmu_kind_me) {
            __throw_runtime_error("Only CS 2.0 is supported by this code");
        }

        return xml;

    }
    
}


#endif //FMU_PROXY_FMUHELPER_H
