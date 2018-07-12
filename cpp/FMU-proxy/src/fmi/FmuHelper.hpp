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

#ifndef FMU_PROXY_FMIHELPER_HPP
#define FMU_PROXY_FMIHELPER_HPP

#include <cfloat>
#include "FmiDefinitions.hpp"

namespace fmuproxy::fmi {

    IntegerAttribute toIntegerAttribute(fmi2_import_variable_t *variable, fmi2_xml_integer_variable_t *integer_variable) {
        IntegerAttribute attribute;
        if (fmi2_import_get_variable_has_start(variable)) {
            attribute.setStart(fmi2_import_get_integer_variable_start(integer_variable));
        }
        const auto min = fmi2_import_get_integer_variable_min(integer_variable);
        const auto max = fmi2_import_get_integer_variable_max(integer_variable);
        if (min != max) {
            attribute.setMin(min);
            attribute.setMax(max);
        }
        return attribute;
    }

    RealAttribute toRealAttribute(fmi2_import_variable_t *variable, fmi2_xml_real_variable_t *real_variable) {
        auto attribute = RealAttribute();
        if (fmi2_import_get_variable_has_start(variable)) {
            attribute.setStart(fmi2_import_get_real_variable_start(real_variable));
        }

        const auto min = fmi2_import_get_real_variable_min(real_variable);
        if (min != -DBL_MAX) {
            attribute.setMin(min);
        }

        const auto max = fmi2_import_get_real_variable_max(real_variable);
        if (max != DBL_MAX) {
            attribute.setMax(max);
        }
        return attribute;
    }

    StringAttribute toStringAttribute(fmi2_import_variable_t *variable, fmi2_import_string_variable_t *string_variable) {
        StringAttribute attribute;
        if (fmi2_import_get_variable_has_start(variable)) {
            attribute.setStart(fmi2_import_get_string_variable_start(string_variable));
        }
        return attribute;
    }

    BooleanAttribute toBooleanAttribute(fmi2_import_variable_t *variable, fmi2_import_bool_variable_t *bool_variable) {
        BooleanAttribute attribute;
        if (fmi2_import_get_variable_has_start(variable)) {
            attribute.setStart(fmi2_import_get_boolean_variable_start(bool_variable));
        }
        return attribute;
    }

    EnumerationAttribute toEnumerationAttribute(fmi2_import_variable_t *variable, fmi2_xml_enum_variable_t *enum_variable) {
        EnumerationAttribute attribute;
        if (fmi2_import_get_variable_has_start(variable)) {
            attribute.setStart(fmi2_import_get_enum_variable_start(enum_variable));
        }
        const auto min = fmi2_import_get_enum_variable_min(enum_variable);
        const auto max = fmi2_import_get_enum_variable_max(enum_variable);
        if (min != max) {
            attribute.setMin(min);
            attribute.setMax(max);
        }
        return attribute;
    }


    void populate_scalar_variable(fmi2_import_variable_t *v, ScalarVariable &var) {

        var.name = fmi2_import_get_variable_name(v);
        var.valueReference = fmi2_import_get_variable_vr(v);

        const char *description = fmi2_import_get_variable_description(v);
        if (description != nullptr) {
            var.description = description;
        }

        var.causality = fmi2_import_get_causality(v);
        var.variability = fmi2_import_get_variability(v);
        var.initial = fmi2_import_get_initial(v);

        fmi2_base_type_enu_t type = fmi2_import_get_variable_base_type(v);
        switch (type) {
            case fmi2_base_type_int:
                var.attribute.setIntegerAttribute(toIntegerAttribute(v, fmi2_import_get_variable_as_integer(v)));
                break;
            case fmi2_base_type_real:
                var.attribute.setRealAttribute(toRealAttribute(v, fmi2_import_get_variable_as_real(v)));
                break;
            case fmi2_base_type_str:
                var.attribute.setStringAttribute(toStringAttribute(v, fmi2_import_get_variable_as_string(v)));
                break;
            case fmi2_base_type_bool:
                var.attribute.setBooleanAttribute(toBooleanAttribute(v, fmi2_import_get_variable_as_boolean(v)));
                break;
            case fmi2_base_type_enum:
                var.attribute.setEnumerationAttribute(toEnumerationAttribute(v, fmi2_import_get_variable_as_enum(v)));
                break;
        }

    }


    void populate_model_variables(fmi2_import_t *xml, ModelVariables &modelVariables) {

        const auto list = fmi2_import_get_variable_list(xml, 0);
        size_t size = fmi2_import_get_variable_list_size(list);

        for (unsigned int i = 0; i < size; ++i) {
            fmi2_import_variable_t *v = fmi2_import_get_variable(list, i);
            ScalarVariable var;
            populate_scalar_variable(v, var);
            modelVariables.push_back(var);
        }

        fmi2_import_free_variable_list(list);

    }


    void populate_model_description(fmi_version_enu_t fmi_version, fmi2_import_t *xml, ModelDescription &md) {

        md.guid = (fmi2_import_get_GUID(xml));
        md.version = (fmi2_import_get_model_standard_version(xml));
        md.fmiVersion = (fmi_version_to_string(fmi_version));
        md.modelName = (fmi2_import_get_model_name(xml));
        md.author = (fmi2_import_get_author(xml));
        md.copyright = (fmi2_import_get_copyright(xml));
        md.description = (fmi2_import_get_description(xml));
        md.generationTool = (fmi2_import_get_generation_tool(xml));
        md.generationDateAndTime = (fmi2_import_get_generation_date_and_time(xml));
        md.license = (fmi2_import_get_license(xml));

        DefaultExperiment ex;
        ex.startTime = fmi2_import_get_default_experiment_start(xml);
        ex.stopTime = fmi2_import_get_default_experiment_stop(xml);
        ex.tolerance = fmi2_import_get_default_experiment_tolerance(xml);
        ex.stepSize = fmi2_import_get_default_experiment_step(xml);
        md.defaultExperiment = (ex);

        ModelVariables modelVariables;
        populate_model_variables(xml, modelVariables);
        md.modelVariables = (modelVariables);

    }

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

    fmi2_import_t *load_model_description(std::string tmp_path, fmi_xml_context_t *ctx, jm_callbacks callbacks) {

        fmi2_import_t *xml = fmi2_import_parse_xml(ctx, tmp_path.c_str(), nullptr);

        if (!xml) {
            throw std::runtime_error("Error parsing XML, exiting");
        }

        if (fmi2_import_get_fmu_kind(xml) == fmi2_fmu_kind_me) {
            throw std::runtime_error("Only CS 2.0 is supported by this code");
        }

        return xml;

    }

}

#endif //FMU_PROXY_FMIHELPER_HPP
