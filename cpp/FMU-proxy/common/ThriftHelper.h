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

#ifndef FMU_PROXY_THRIFTHELPER_H
#define FMU_PROXY_THRIFTHELPER_H

#endif //FMU_PROXY_THRIFTHELPER_H


#include <cfloat>
#include <fmilib.h>
#include "thrift-gen/definitions_types.h"

using namespace ::fmuproxy::thrift;

namespace fmuproxy {
    namespace thrift_helper {

        Status::type thriftType(fmi2_status_t status) {
            switch (status) {
                case fmi2_status_ok:
                    return Status::type::OK_STATUS;
                case fmi2_status_warning:
                    return Status::type::WARNING_STATUS;
                case fmi2_status_pending:
                    return Status::type::PENDING_STATUS;
                case fmi2_status_discard:
                    return Status::type::DISCARD_STATUS;
                case fmi2_status_error:
                    return Status::type::ERROR_STATUS;
                case fmi2_status_fatal:
                    return Status::type::FATAL_STATUS;
            }
        }

        Causality::type thriftType(fmi2_causality_enu_t causality) {
            switch (causality) {
                case fmi2_causality_enu_input:
                    return Causality::type::INPUT_CAUSALITY;
                case fmi2_causality_enu_output:
                    return Causality::type::OUTPUT_CAUSALITY;
                case fmi2_causality_enu_parameter:
                    return Causality::type::PARAMETER_CAUSALITY;
                case fmi2_causality_enu_local:
                    return Causality::type::LOCAL_CAUSALITY;
                case fmi2_causality_enu_independent:
                    return Causality::type::INDEPENDENT_CAUSALITY;
                case fmi2_causality_enu_calculated_parameter:
                    return Causality::type::CALCULATED_PARAMETER_CAUSALITY;
                case fmi2_causality_enu_unknown:
                    return Causality::type::LOCAL_CAUSALITY;
            }
        }

        Variability::type thriftType(fmi2_variability_enu_t variability) {
            switch (variability) {
                case fmi2_variability_enu_constant:
                    return Variability::type::CONSTANT_VARIABILITY;
                case fmi2_variability_enu_continuous:
                    return Variability::type::CONTINUOUS_VARIABILITY;
                case fmi2_variability_enu_discrete:
                    return Variability::type::DISCRETE_VARIABILITY;
                case fmi2_variability_enu_fixed:
                    return Variability::type::FIXED_VARIABILITY;;
                case fmi2_variability_enu_unknown:
                    return Variability::type::CONTINUOUS_VARIABILITY;
            }
        }

        Initial::type thriftType(fmi2_initial_enu_t initial) {
            switch (initial) {
                case fmi2_initial_enu_approx:
                    return Initial::type::APPROX_INITIAL;
                case fmi2_initial_enu_calculated:
                    return Initial::type::CALCULATED_INITIAL;
                case fmi2_initial_enu_exact:
                    return Initial::type::EXACT_INITIAL;
                case fmi2_initial_enu_unknown:
                    return Initial::type::APPROX_INITIAL;
            }
        }

        IntegerAttribute
        thriftType(fmi2_import_variable_t *variable, fmi2_import_integer_variable_t *integer_variable) {
            IntegerAttribute attribute;

            if (fmi2_import_get_variable_has_start(variable)) {
                attribute.start = fmi2_import_get_integer_variable_start(integer_variable);
            }
            const auto min = fmi2_import_get_integer_variable_min(integer_variable);
            attribute.__set_min(min);

            const auto max = fmi2_import_get_integer_variable_max(integer_variable);
            attribute.__set_max(max);

            return attribute;
        }

        RealAttribute thriftType(fmi2_import_variable_t *variable, fmi2_import_real_variable_t *real_variable) {
            RealAttribute attribute;
            if (fmi2_import_get_variable_has_start(variable)) {
                attribute.__set_start(fmi2_import_get_real_variable_start(real_variable));
            }
            fmi2_real_t min = fmi2_import_get_real_variable_min(real_variable);
            if (min != -DBL_MAX) {
                attribute.__set_min(min);
            }
            fmi2_real_t max = fmi2_import_get_real_variable_max(real_variable);
            if (max != DBL_MAX) {
                attribute.__set_max(max);
            }
            return attribute;
        }

        StringAttribute thriftType(fmi2_import_variable_t *variable, fmi2_import_string_variable_t *string_variable) {
            StringAttribute attribute;
            if (fmi2_import_get_variable_has_start(variable)) {
                attribute.__set_start(fmi2_import_get_string_variable_start(string_variable));
            }
            return attribute;
        }

        BooleanAttribute thriftType(fmi2_import_variable_t *variable, fmi2_import_bool_variable_t *bool_variable) {
            BooleanAttribute attribute;
            if (fmi2_import_get_variable_has_start(variable)) {
                attribute.__set_start(fmi2_import_get_boolean_variable_start(bool_variable));
            }
            return attribute;
        }


        void get_scalar_variable(fmi2_import_variable_t *v, ScalarVariable &var) {

            var.__set_name(fmi2_import_get_variable_name(v));
            var.__set_valueReference(fmi2_import_get_variable_vr(v));

            const char *description = fmi2_import_get_variable_description(v);
            if (description != nullptr) {
                var.__set_description(description);
            }

            var.__set_causality(thriftType(fmi2_import_get_causality(v)));
            var.__set_variability(thriftType(fmi2_import_get_variability(v)));
            var.__set_initial(thriftType(fmi2_import_get_initial(v)));

            fmi2_base_type_enu_t type = fmi2_import_get_variable_base_type(v);
            switch (type) {
                case fmi2_base_type_int:
                    var.attribute.__set_integerAttribute(thriftType(v, fmi2_import_get_variable_as_integer(v)));
                    break;
                case fmi2_base_type_real:
                    var.attribute.__set_realAttribute(thriftType(v, fmi2_import_get_variable_as_real(v)));
                    break;
                case fmi2_base_type_str:
                    var.attribute.__set_stringAttribute(thriftType(v, fmi2_import_get_variable_as_string(v)));
                    break;
                case fmi2_base_type_bool:
                    var.attribute.__set_booleanAttribute(thriftType(v, fmi2_import_get_variable_as_boolean(v)));
                    break;
            }

        }

        void get_model_variables(fmi2_import_t *xml, ModelVariables &modelVariables) {

            const auto list = fmi2_import_get_variable_list(xml, 0);
            unsigned int size = fmi2_import_get_variable_list_size(list);

            for (unsigned int i = 0; i < size; ++i) {
                fmi2_import_variable_t *v = fmi2_import_get_variable(list, i);
                ScalarVariable var;
                get_scalar_variable(v, var);
                modelVariables.push_back(var);
            }

            fmi2_import_free_variable_list(list);

        }

        void get_model_description(fmi_version_enu_t fmi_version, fmi2_import_t *xml, ModelDescription &md) {

            md.__set_guid(fmi2_import_get_GUID(xml));
            md.__set_version(fmi2_import_get_model_standard_version(xml));
            md.__set_fmiVersion(fmi_version_to_string(fmi_version));
            md.__set_modelName(fmi2_import_get_model_name(xml));
            md.__set_author(fmi2_import_get_author(xml));
            md.__set_copyright(fmi2_import_get_copyright(xml));
            md.__set_description(fmi2_import_get_description(xml));
            md.__set_generationTool(fmi2_import_get_generation_tool(xml));
            md.__set_generationDateAndTime(fmi2_import_get_generation_date_and_time(xml));
            md.__set_license(fmi2_import_get_license(xml));

            DefaultExperiment ex;
            ex.startTime = fmi2_import_get_default_experiment_start(xml);
            ex.stopTime = fmi2_import_get_default_experiment_stop(xml);
            ex.tolerance = fmi2_import_get_default_experiment_tolerance(xml);
            ex.stepSize = fmi2_import_get_default_experiment_step(xml);
            md.__set_defaultExperiment(ex);

            ModelVariables modelVariables;
            get_model_variables(xml, modelVariables);
            md.__set_modelVariables(modelVariables);

        }

    }
}
