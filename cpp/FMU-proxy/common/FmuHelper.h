//
// Created by laht on 08.06.18.
//

#ifndef FMU_PROXY_FMUHELPER_H
#define FMU_PROXY_FMUHELPER_H

#endif //FMU_PROXY_FMUHELPER_H

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

    fmi2_import_t *load_model_description(const char *tmp_path, fmi_xml_context_t *ctx, jm_callbacks callbacks) {

        fmi2_import_t *xml = fmi2_import_parse_xml(ctx, tmp_path, nullptr);

        if (!xml) {
            __throw_runtime_error("Error parsing XML, exiting");
        }

        if (fmi2_import_get_fmu_kind(xml) == fmi2_fmu_kind_me) {
            __throw_runtime_error("Only CS 2.0 is supported by this code");
        }

        return xml;

    }
    
}