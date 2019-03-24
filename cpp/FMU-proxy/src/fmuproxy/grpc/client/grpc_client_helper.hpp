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

#ifndef FMU_PROXY_GRPC_CLIENT_HELPER_HPP
#define FMU_PROXY_GRPC_CLIENT_HELPER_HPP

#include <string>
#include <fmi4cpp/fmi2/fmi2.hpp>
#include <fmuproxy/grpc/common/service.pb.h>

namespace {

    fmi4cpp::status convert(const fmuproxy::grpc::Status status) {
        switch (status) {
            case fmuproxy::grpc::Status::OK_STATUS:
                return fmi4cpp::status::OK;
            case fmuproxy::grpc::Status::WARNING_STATUS:
                return fmi4cpp::status::Warning;
            case fmuproxy::grpc::Status::DISCARD_STATUS:
                return fmi4cpp::status::Discard;
            case fmuproxy::grpc::Status::ERROR_STATUS:
                return fmi4cpp::status::Error;
            case fmuproxy::grpc::Status::FATAL_STATUS:
                return fmi4cpp::status::Fatal;
            case fmuproxy::grpc::Status::PENDING_STATUS:
                return fmi4cpp::status::Pending;
            default:
                return fmi4cpp::status::Unknown;
        }
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::scalar_variable_attribute<T> to_scalar_variable_attributes(const U &a) {
        fmi4cpp::fmi2::scalar_variable_attribute<T> attribute;
        attribute.start = a.start();
        return attribute;
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::bounded_scalar_variable_attribute<T> to_bounded_scalar_variable_attributes(const U &a) {

        fmi4cpp::fmi2::bounded_scalar_variable_attribute bounded(to_scalar_variable_attributes<T, U>(a));

        if (a.max() > a.min()) {
            bounded.min = a.min();
            bounded.max = a.max();
        }

        if (!a.quantity().empty()) {
            bounded.quantity = a.quantity();
        }

        return bounded;

    }

    fmi4cpp::fmi2::integer_attribute convert(const fmuproxy::grpc::IntegerAttribute &a) {
        return fmi4cpp::fmi2::integer_attribute(
                to_bounded_scalar_variable_attributes<int, fmuproxy::grpc::IntegerAttribute>(a));
    }

    fmi4cpp::fmi2::real_attribute convert(const fmuproxy::grpc::RealAttribute &a) {
        return fmi4cpp::fmi2::real_attribute (
                to_bounded_scalar_variable_attributes<double, fmuproxy::grpc::RealAttribute>(a));
    }

    fmi4cpp::fmi2::string_attribute convert(const fmuproxy::grpc::StringAttribute &a) {
        return fmi4cpp::fmi2::string_attribute(
                to_scalar_variable_attributes<std::string, fmuproxy::grpc::StringAttribute>(a));
    }

    fmi4cpp::fmi2::boolean_attribute convert(const fmuproxy::grpc::BooleanAttribute &a) {
        return fmi4cpp::fmi2::boolean_attribute(to_scalar_variable_attributes<bool, fmuproxy::grpc::BooleanAttribute>(a));
    }

    fmi4cpp::fmi2::enumeration_attribute convert(const fmuproxy::grpc::EnumerationAttribute &a) {
        return fmi4cpp::fmi2::enumeration_attribute(
                to_bounded_scalar_variable_attributes<int, fmuproxy::grpc::EnumerationAttribute>(a));
    }

    fmi4cpp::fmi2::scalar_variable convert(const fmuproxy::grpc::ScalarVariable &v) {

        fmi4cpp::fmi2::scalar_variable_base base;
        base.name = v.name();
        base.description = v.description();
        base.value_reference = (fmi2ValueReference) v.value_reference();
        base.variability = fmi4cpp::fmi2::parse_variability(v.variability());
        base.causality = fmi4cpp::fmi2::parse_causality(v.causality());
        base.initial = fmi4cpp::fmi2::parse_initial(v.initial());

        switch (v.attribute_case()) {
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kIntegerAttribute:
                return {base, convert(v.integer_attribute())};
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kRealAttribute:
                return {base, convert(v.real_attribute())};
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kStringAttribute:
                return {base, convert(v.string_attribute())};
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kBooleanAttribute:
                return {base, convert(v.boolean_attribute())};
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kEnumerationAttribute:
                return {base, convert(v.enumeration_attribute())};
            default:
                throw std::runtime_error("Fatal: no attribute set!");
        }

    }

    fmi4cpp::fmi2::default_experiment convert(const fmuproxy::grpc::DefaultExperiment &from) {
        return {from.start_time(), from.stop_time(), from.step_size(), from.tolerance()};
    }

    std::unique_ptr<const fmi4cpp::fmi2::model_variables>
    convert(const google::protobuf::RepeatedPtrField<fmuproxy::grpc::ScalarVariable> m) {
        std::vector<fmi4cpp::fmi2::scalar_variable> variables;
        for (const auto &var : m) {
            variables.push_back(convert(var));
        }
        return std::make_unique<const fmi4cpp::fmi2::model_variables>(variables);
    }

    const fmi4cpp::fmi2::cs_attributes convert(const fmuproxy::grpc::CoSimulationAttributes &a) {

        fmi4cpp::fmi2::cs_attributes attributes;
        attributes.model_identifier = a.model_identifier();
        attributes.can_get_and_set_fmu_state = a.can_get_and_set_fmu_state();
        attributes.can_serialize_fmu_state = a.can_serialize_fmu_state();
        attributes.provides_directional_derivative = a.provides_directional_derivative();

        attributes.can_interpolate_inputs = a.can_interpolate_inputs();
        attributes.can_handle_variable_communication_step_size = a.can_handle_variable_communication_step_size();
        attributes.max_output_derivative_order = a.max_output_derivative_order();

        return attributes;

    }

    std::unique_ptr<const fmi4cpp::fmi2::model_description_base> convert(const fmuproxy::grpc::ModelDescription &from) {

        auto base = std::make_unique<fmi4cpp::fmi2::model_description_base>();
        base->guid = from.guid();
        base-> fmi_version = from.fmi_version();
        base->description = from.description();
        base->model_name = from.model_name();
        base->model_variables = std::move(convert(from.model_variables()));
        base->variable_naming_convention = from.variable_naming_convention();
        base->default_experiment = convert(from.default_experiment());
        base->generation_date_and_time = from.generation_date_and_time();
        base->generation_tool = from.generation_tool();
        base->license = from.license();
        base->version = from.version();
        base->copyright = from.copyright();
        base->author = from.author();
        base->model_structure = nullptr;
        return base;

    }

}

#endif //FMU_PROXY_GRPC_CLIENT_HELPER_HPP
