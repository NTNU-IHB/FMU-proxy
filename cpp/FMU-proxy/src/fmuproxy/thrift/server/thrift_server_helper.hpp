/*
 * The MIT License
 *
 * Copyright 2017-2019 Norwegian University of Technology
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

#ifndef FMU_PROXY_THRIFT_SERVER_HELPER_HPP
#define FMU_PROXY_THRIFT_SERVER_HELPER_HPP

#include <fmi4cpp/fmi4cpp.hpp>
#include <fmuproxy/thrift/common/service_types.h>

using namespace fmi4cpp::fmi2;
using namespace fmuproxy::thrift;

namespace {

    const Status::type thrift_type(fmi4cpp::status status) {
        switch (status) {
            case fmi4cpp::status::OK:
                return Status::type::OK_STATUS;
            case fmi4cpp::status::Warning:
                return Status::type::WARNING_STATUS;
            case fmi4cpp::status::Pending:
                return Status::type::PENDING_STATUS;
            case fmi4cpp::status::Discard:
                return Status::type::DISCARD_STATUS;
            case fmi4cpp::status::Error:
                return Status::type::ERROR_STATUS;
            case fmi4cpp::status::Fatal:
                return Status::type::FATAL_STATUS;
            default:
                throw std::runtime_error("Fatal: Unknown status type!");
        }
    }

    template <typename T, typename U>
    void set_scalar_variable_attributes(T t, const fmi4cpp::fmi2::scalar_variable_attribute<U> &a) {
        if (a.start) {
            t.__set_start(*a.start);
        }
    }

    template <typename T, typename U>
    void set_bounded_scalar_variable_attributes(T t, const fmi4cpp::fmi2::bounded_scalar_variable_attribute<U> &a) {
        set_scalar_variable_attributes<T, U>(t, a);
        if (a.min) {
            t.__set_min(*a.min);
        }
        if (a.max) {
            t.__set_max(*a.max);
        }
        if (a.quantity) {
            t.__set_quantity(*a.quantity);
        }
    }

    fmuproxy::thrift::IntegerAttribute thrift_type(const fmi4cpp::fmi2::integer_attribute &a) {
        fmuproxy::thrift::IntegerAttribute attribute;
        set_bounded_scalar_variable_attributes<fmuproxy::thrift::IntegerAttribute, int>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::RealAttribute thrift_type(const fmi4cpp::fmi2::real_attribute &a) {
        fmuproxy::thrift::RealAttribute attribute;
        set_bounded_scalar_variable_attributes<fmuproxy::thrift::RealAttribute, double>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::StringAttribute thrift_type(const fmi4cpp::fmi2::string_attribute &a) {
        fmuproxy::thrift::StringAttribute attribute;
        set_scalar_variable_attributes<fmuproxy::thrift::StringAttribute, std::string>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::BooleanAttribute thrift_type(const fmi4cpp::fmi2::boolean_attribute &a) {
        fmuproxy::thrift::BooleanAttribute attribute;
        set_scalar_variable_attributes<fmuproxy::thrift::BooleanAttribute, bool>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift:: EnumerationAttribute thrift_type(const fmi4cpp::fmi2::enumeration_attribute &a) {
        fmuproxy::thrift::EnumerationAttribute attribute;
        set_bounded_scalar_variable_attributes<fmuproxy::thrift::EnumerationAttribute, int>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::ScalarVariable thrift_type(const fmi4cpp::fmi2::scalar_variable &v) {

        fmuproxy::thrift::ScalarVariable var;
        var.__set_name(v.name);
        var.__set_valueReference(v.value_reference);

        std::string description = v.description;
        if (!description.empty()) {
            var.__set_description(description);
        }

        var.__set_causality(fmi4cpp::fmi2::to_string(v.causality));
        var.__set_variability(fmi4cpp::fmi2::to_string(v.variability));
        var.__set_initial(fmi4cpp::fmi2::to_string(v.initial));

        if (v.is_integer()) {
            var.attribute.__set_integerAttribute(thrift_type(v.as_integer().attribute()));
        } else if (v.is_real()) {
            var.attribute.__set_realAttribute(thrift_type(v.as_real().attribute()));
        } else if (v.is_string()) {
            var.attribute.__set_stringAttribute(thrift_type(v.as_string().attribute()));
        } else if (v.is_boolean()) {
            var.attribute.__set_booleanAttribute(thrift_type(v.as_boolean().attribute()));
        } else if (v.is_enumeration()) {
            var.attribute.__set_enumerationAttribute(thrift_type(v.as_enumeration().attribute()));
        } else {
            throw std::runtime_error("Fatal: No valid attribute found..");
        }

        return var;

    }

    void copy(fmuproxy::thrift::ModelVariables &variables, const fmi4cpp::fmi2::model_variables &mv) {
        for (const auto &var : mv) {
            variables.push_back(thrift_type(var));
        }
    }

    void copy(fmuproxy::thrift::DefaultExperiment &to, const fmi4cpp::fmi2::default_experiment &from) {
        if (from.startTime) {
            to.startTime = *from.startTime;
        }
        if (from.stopTime) {
            to.stopTime = *from.stopTime;
        }
        if (from.stepSize) {
            to.stepSize = *from.stepSize;
        }
        if (from.tolerance) {
            to.tolerance = *from.tolerance;
        }
    }

    void thrift_type(fmuproxy::thrift::ModelDescription &md, const fmi4cpp::fmi2::model_description_base &m) {

        md.__set_guid(m.guid);
        md.__set_fmiVersion(m.fmi_version);
        md.__set_modelName(m.model_name);

        if (m.version) {
            md.__set_version(*m.version);
        }
        if (m.author) {
            md.__set_author(*m.author);
        }
        if (m.license) {
            md.__set_license(*m.license);
        }
        if (m.copyright) {
            md.__set_copyright(*m.copyright);
        }
        if (m.description) {
            md.__set_description(*m.description);
        }
        if (m.generation_tool) {
            md.__set_generationTool(*m.generation_tool);
        }
        if (m.generation_date_and_time) {
            md.__set_generationDateAndTime(*m.generation_date_and_time);
        }
        if (m.variable_naming_convention) {
            md.__set_variableNamingConvention(*m.variable_naming_convention);
        }

        if (m.default_experiment) {
            fmuproxy::thrift::DefaultExperiment ex;
            copy(ex, *m.default_experiment);
            md.__set_defaultExperiment(ex);
        }

        fmuproxy::thrift::ModelVariables modelVariables;
        copy(modelVariables, *m.model_variables);
        md.__set_modelVariables(modelVariables);

    }
    
}

#endif //FMU_PROXY_THRIFT_SERVER_HELPER_HPP
