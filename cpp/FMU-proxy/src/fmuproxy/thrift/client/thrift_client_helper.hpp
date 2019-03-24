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

#ifndef FMU_PROXY_THRIFT_CLIENT_HELPER_HPP
#define FMU_PROXY_THRIFT_CLIENT_HELPER_HPP

#include <iostream>
#include <optional>
#include <memory>

#include <fmuproxy/thrift/common/service_types.h>

#include <fmi4cpp/fmi2/fmi2.hpp>

using namespace fmuproxy::thrift;

namespace {

    fmi4cpp::status convert(const Status::type status) {
        switch (status) {
            case Status::OK_STATUS:
                return fmi4cpp::status::OK;
            case Status::WARNING_STATUS:
                return fmi4cpp::status::Warning;
            case Status::DISCARD_STATUS:
                return fmi4cpp::status::Discard;
            case Status::ERROR_STATUS:
                return fmi4cpp::status::Error;
            case Status::FATAL_STATUS:
                return fmi4cpp::status::Fatal;
            case Status::PENDING_STATUS:
                return fmi4cpp::status::Pending;
            default:
                return fmi4cpp::status::Unknown;
        }
    }

    fmi4cpp::fmi2::default_experiment convert(const fmuproxy::thrift::DefaultExperiment &d) {
        return {d.startTime, d.stopTime, d.stepSize, d.tolerance};
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::scalar_variable_attribute<T> to_scalar_variable_attributes(const U &a) {
        if (a.__isset.start) {
             auto attribute = fmi4cpp::fmi2::scalar_variable_attribute<T>();
             attribute.start = a.start;
             return attribute;
        } else {
            return {};
        }
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::bounded_scalar_variable_attribute<T> to_bounded_scalar_variable_attributes(const U &a) {

        fmi4cpp::fmi2::bounded_scalar_variable_attribute<T> bounded(to_scalar_variable_attributes<T, U>(a));
        if (a.__isset.min) {
            bounded.min = a.min;
        }
        if (a.__isset.max) {
            bounded.max = a.max;
        }
        if (a.__isset.quantity) {
            bounded.quantity = a.quantity;
        }

        return bounded;
    }

    fmi4cpp::fmi2::integer_attribute convert(const fmuproxy::thrift::IntegerAttribute &a) {
        return fmi4cpp::fmi2::integer_attribute(
                to_bounded_scalar_variable_attributes<int, fmuproxy::thrift::IntegerAttribute>(a));
    }

    fmi4cpp::fmi2::real_attribute convert(const fmuproxy::thrift::RealAttribute &a) {
        return fmi4cpp::fmi2::real_attribute(
                to_bounded_scalar_variable_attributes<double, fmuproxy::thrift::RealAttribute>(a));
    }

    fmi4cpp::fmi2::string_attribute convert(const fmuproxy::thrift::StringAttribute &a) {
        return fmi4cpp::fmi2::string_attribute(
                to_scalar_variable_attributes<std::string, fmuproxy::thrift::StringAttribute>(a));
    }

    fmi4cpp::fmi2::boolean_attribute convert(const fmuproxy::thrift::BooleanAttribute &a) {
        return fmi4cpp::fmi2::boolean_attribute(
                to_scalar_variable_attributes<bool, fmuproxy::thrift::BooleanAttribute>(a));
    }

    fmi4cpp::fmi2::enumeration_attribute convert(const fmuproxy::thrift::EnumerationAttribute &a) {
        return fmi4cpp::fmi2::enumeration_attribute(
                to_bounded_scalar_variable_attributes<int, fmuproxy::thrift::EnumerationAttribute>(a));
    }

    fmi4cpp::fmi2::scalar_variable convert(const fmuproxy::thrift::ScalarVariable &v) {

        fmi4cpp::fmi2::scalar_variable_base base;
        base.name = v.name;
        base.description = v.description;
        base.value_reference = (fmi2ValueReference) v.valueReference;
        base.variability = fmi4cpp::fmi2::parse_variability(v.variability);
        base.causality = fmi4cpp::fmi2::parse_causality(v.causality);
        base.initial = fmi4cpp::fmi2::parse_initial(v.initial);

        if (v.attribute.__isset.integerAttribute) {
            return {base, convert(v.attribute.integerAttribute)};
        } else if (v.attribute.__isset.realAttribute) {
            return {base, convert(v.attribute.realAttribute)};
        } else if (v.attribute.__isset.stringAttribute) {
            return {base, convert(v.attribute.stringAttribute)};
        } else if (v.attribute.__isset.booleanAttribute) {
            return {base, convert(v.attribute.booleanAttribute)};
        } else if (v.attribute.__isset.enumerationAttribute) {
            return {base, convert(v.attribute.enumerationAttribute)};
        } else {
            throw std::runtime_error("Fatal: no attribute set!");
        }

    }

    fmi4cpp::fmi2::cs_attributes convert(const fmuproxy::thrift::CoSimulationAttributes &a) {

        fmi4cpp::fmi2::cs_attributes attributes;
        attributes.model_identifier = a.modelIdentifier;
        attributes.can_get_and_set_fmu_state = a.canGetAndSetFMUstate;
        attributes.can_serialize_fmu_state = a.canSerializeFMUstate;
        attributes.provides_directional_derivative = a.providesDirectionalDerivative;

        attributes.can_interpolate_inputs = a.canInterpolateInputs;
        attributes.can_handle_variable_communication_step_size = a.canHandleVariableCommunicationStepSize;
        attributes.max_output_derivative_order = static_cast<unsigned int>(a.maxOutputDerivativeOrder);

        return attributes;

    }

    std::unique_ptr<fmi4cpp::fmi2::model_variables> convert(const fmuproxy::thrift::ModelVariables &m) {
        std::vector<fmi4cpp::fmi2::scalar_variable> variables;
        for (const auto &var : m) {
            variables.push_back(convert(var));
        }
        return std::make_unique<fmi4cpp::fmi2::model_variables>(variables);
    }

    std::unique_ptr<fmi4cpp::fmi2::model_description_base> convert(const fmuproxy::thrift::ModelDescription &from) {

        auto base = std::make_unique<fmi4cpp::fmi2::model_description_base>();
        base->guid = from.guid;
        base-> fmi_version = from.fmiVersion;
        base->description = from.description;
        base->model_name = from.modelName;
        base->model_variables = std::move(convert(from.modelVariables));
        base->variable_naming_convention = from.variableNamingConvention;
        base->default_experiment = convert(from.defaultExperiment);
        base->generation_date_and_time = from.generationDateAndTime;
        base->generation_tool = from.generationTool;
        base->license = from.license;
        base->version = from.version;
        base->copyright = from.copyright;
        base->author = from.author;
        base->model_structure = nullptr;
        return base;

    }

}

#endif //FMU_PROXY_THRIFT_CLIENT_HELPER_HPP
