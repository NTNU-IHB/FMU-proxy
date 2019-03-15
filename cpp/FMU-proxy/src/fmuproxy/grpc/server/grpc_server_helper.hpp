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

#ifndef FMU_PROXY_GRPC_SERVER_HELPER_HPP
#define FMU_PROXY_GRPC_SERVER_HELPER_HPP

#include <grpcpp/grpcpp.h>

#include <fmi4cpp/fmi2/fmi2.hpp>
#include <fmuproxy/grpc/common/service.pb.h>

using namespace fmuproxy::grpc;

namespace {

    const Status grpc_type(fmi4cpp::Status status) {
        switch (status) {
            case fmi4cpp::Status::OK:
                return Status::OK_STATUS;
            case fmi4cpp::Status::Warning:
                return Status::WARNING_STATUS;
            case fmi4cpp::Status::Pending:
                return Status::PENDING_STATUS;
            case fmi4cpp::Status::Discard:
                return Status::DISCARD_STATUS;
            case fmi4cpp::Status::Error:
                return Status::ERROR_STATUS;
            case fmi4cpp::Status::Fatal:
                return Status::FATAL_STATUS;
            default:
                throw std::runtime_error("Invalid status!");
        }
    }

    template <typename T, typename U>
    void set_scalar_variable_attributes(T t, const fmi4cpp::fmi2::ScalarVariableAttribute<U> &a) {
        if (a.start) {
            t.set_start(*a.start);
        }
    }

    template <typename T, typename U>
    void set_bounded_scalar_variable_attributes(T t, const fmi4cpp::fmi2::BoundedScalarVariableAttribute<U> &a) {
        set_scalar_variable_attributes<T, U>(t, a);
        if (a.min) {
            t.set_min(*a.min);
        }
        if (a.max) {
            t.set_max(*a.max);
        }
        if (a.quantity) {
            t.set_quantity(*a.quantity);
        }
    }

    void grpc_type(IntegerAttribute &attribute, const fmi4cpp::fmi2::IntegerAttribute &a) {
        set_bounded_scalar_variable_attributes<IntegerAttribute, int>(attribute, a);
    }

    void grpc_type(RealAttribute &attribute, const fmi4cpp::fmi2::RealAttribute &a) {
        set_bounded_scalar_variable_attributes<RealAttribute, double>(attribute, a);
    }

    void grpc_type(StringAttribute &attribute, const fmi4cpp::fmi2::StringAttribute &a) {
        set_scalar_variable_attributes<StringAttribute, std::string>(attribute, a);
    }

    void grpc_type(BooleanAttribute &attribute, const fmi4cpp::fmi2::BooleanAttribute &a) {
        set_scalar_variable_attributes<BooleanAttribute, bool>(attribute, a);
    }

    void grpc_type(EnumerationAttribute &attribute, const fmi4cpp::fmi2::EnumerationAttribute &a) {
        set_bounded_scalar_variable_attributes<EnumerationAttribute, int>(attribute, a);
    }

    void grpc_type(ScalarVariable &var, const fmi4cpp::fmi2::ScalarVariable &v) {

        var.set_name(v.name);
        var.set_value_reference(v.valueReference);

        std::string description = v.description;
        if (!description.empty()) {
            var.set_description(description);
        }

        var.set_causality(fmi4cpp::fmi2::to_string(v.causality));
        var.set_variability(fmi4cpp::fmi2::to_string(v.variability));
        var.set_initial(fmi4cpp::fmi2::to_string(v.initial));

        if (v.isInteger()) {
            grpc_type(*var.mutable_integer_attribute(), v.asInteger().attribute());
        } else if (v.isReal()) {
            grpc_type(*var.mutable_real_attribute(), v.asReal().attribute());
        } else if (v.isString()) {
            grpc_type(*var.mutable_string_attribute(), v.asString().attribute());
        } else if (v.isBoolean()) {
            grpc_type(*var.mutable_boolean_attribute(), v.asBoolean().attribute());
        } else if (v.isEnumeration()) {
            grpc_type(*var.mutable_enumeration_attribute(), v.asEnumeration().attribute());
        } else {
            throw std::runtime_error("Fatal: No valid attribute found..");
        }

    }

    void grpc_type(ModelDescription &md, const fmi4cpp::fmi2::ModelDescriptionBase &m) {

        md.set_guid(m.guid.c_str());
        md.set_fmi_version(m.fmiVersion);
        md.set_model_name(m.modelName);

        if (m.license) {
            md.set_license(*m.license);
        }
        if (m.version) {
            md.set_version(*m.version);
        }
        if (m.author) {
            md.set_author(*m.author);
        }
        if (m.copyright) {
            md.set_copyright(*m.copyright);
        }
        if (m.description) {
            md.set_description(*m.description);
        }
        if (m.generationDateAndTime) {
            md.set_generation_date_and_time(*m.generationDateAndTime);
        }
        if (m.generationTool) {
            md.set_generation_tool(*m.generationTool);
        }
        if (m.variableNamingConvention) {
            md.set_variable_naming_convention(*m.variableNamingConvention);
        }

        if (m.defaultExperiment) {
            auto to = md.default_experiment();
            auto from = *m.defaultExperiment;
            if (from.startTime) {
                to.set_start_time(*from.startTime);
            }
            if (from.stopTime) {
                to.set_stop_time(*from.stopTime);
            }
            if (from.stepSize) {
                to.set_step_size(*from.stepSize);
            }
            if (from.tolerance) {
                to.set_tolerance(*from.tolerance);
            }
        }

        for (const auto &var : *m.modelVariables) {
            auto v = md.add_model_variables();
            grpc_type(*v, var);
        }

    }

}

#endif //FMU_PROXY_GRPC_CLIENT_HELPER_HPP
