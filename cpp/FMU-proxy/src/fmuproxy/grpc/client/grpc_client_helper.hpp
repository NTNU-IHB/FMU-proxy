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
#include <fmi4cpp/fmi2/fmi4cpp.hpp>
#include <fmuproxy/grpc/common/service.pb.h>

namespace {

    fmi4cpp::Status convert(const fmuproxy::grpc::Status status) {
        switch (status) {
            case fmuproxy::grpc::Status::OK_STATUS:
                return fmi4cpp::Status::OK;
            case fmuproxy::grpc::Status::WARNING_STATUS:
                return fmi4cpp::Status::Warning;
            case fmuproxy::grpc::Status::DISCARD_STATUS:
                return fmi4cpp::Status::Discard;
            case fmuproxy::grpc::Status::ERROR_STATUS:
                return fmi4cpp::Status::Error;
            case fmuproxy::grpc::Status::FATAL_STATUS:
                return fmi4cpp::Status::Fatal;
            case fmuproxy::grpc::Status::PENDING_STATUS:
                return fmi4cpp::Status::Pending;
            default:
                return fmi4cpp::Status::Unknown;
        }
    }

    fmi4cpp::fmi2::Causality convert(const fmuproxy::grpc::Causality causality) {
        switch (causality) {
            case fmuproxy::grpc::Causality::LOCAL_CAUSALITY:
                return fmi4cpp::fmi2::Causality::local;
            case fmuproxy::grpc::Causality::INDEPENDENT_CAUSALITY:
                return fmi4cpp::fmi2::Causality::independent;
            case fmuproxy::grpc::Causality::INPUT_CAUSALITY:
                return fmi4cpp::fmi2::Causality::input;
            case fmuproxy::grpc::Causality::OUTPUT_CAUSALITY:
                return fmi4cpp::fmi2::Causality::output;
            case fmuproxy::grpc::Causality::CALCULATED_PARAMETER_CAUSALITY:
                return fmi4cpp::fmi2::Causality::calculatedParameter;
            case fmuproxy::grpc::Causality::PARAMETER_CAUSALITY:
                return fmi4cpp::fmi2::Causality::parameter;
            default:
                return fmi4cpp::fmi2::Causality::local;
        }
    }

    fmi4cpp::fmi2::Variability convert(const fmuproxy::grpc::Variability variability) {
        switch (variability) {
            case fmuproxy::grpc::Variability::CONSTANT_VARIABILITY:
                return fmi4cpp::fmi2::Variability::constant;
            case fmuproxy::grpc::Variability::CONTINUOUS_VARIABILITY:
                return fmi4cpp::fmi2::Variability::continuous;
            case fmuproxy::grpc::Variability::FIXED_VARIABILITY:
                return fmi4cpp::fmi2::Variability::fixed;
            case fmuproxy::grpc::Variability::DISCRETE_VARIABILITY:
                return fmi4cpp::fmi2::Variability::discrete;
            case fmuproxy::grpc::Variability::TUNABLE_VARIABILITY:
                return fmi4cpp::fmi2::Variability::tunable;
            default:
                return fmi4cpp::fmi2::Variability::continuous;
        }
    }

    fmi4cpp::fmi2::Initial convert(const fmuproxy::grpc::Initial initial) {
        switch (initial) {
            case fmuproxy::grpc::Initial::APPROX_INITIAL:
                return fmi4cpp::fmi2::Initial::approx;
            case fmuproxy::grpc::Initial::CALCULATED_INITIAL:
                return fmi4cpp::fmi2::Initial::calculated;
            case fmuproxy::grpc::Initial::EXACT_INITIAL:
                return fmi4cpp::fmi2::Initial::exact;
            default:
                return fmi4cpp::fmi2::Initial::unknown;
        }
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::ScalarVariableAttribute<T> toScalarVariableAttributes(const U &a) {
        return fmi4cpp::fmi2::ScalarVariableAttribute<T>(a.start());
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::BoundedScalarVariableAttribute<T> toBoundedScalarVariableAttributes(const U &a) {

        fmi4cpp::fmi2::BoundedScalarVariableAttribute bounded(toScalarVariableAttributes<T, U>(a));

        if (a.max() > a.min()) {
            bounded.min = a.min();
            bounded.max = a.max();
        }

        if (!a.quantity().empty()) {
            bounded.quantity = a.quantity();
        }

        return bounded;

    }

    fmi4cpp::fmi2::IntegerAttribute convert(const fmuproxy::grpc::IntegerAttribute &a) {
        return fmi4cpp::fmi2::IntegerAttribute(
                toBoundedScalarVariableAttributes<int, fmuproxy::grpc::IntegerAttribute>(a));
    }

    fmi4cpp::fmi2::RealAttribute convert(const fmuproxy::grpc::RealAttribute &a) {
        fmi4cpp::fmi2::RealAttribute real(toBoundedScalarVariableAttributes<double, fmuproxy::grpc::RealAttribute>(a));
        return real;
    }

    fmi4cpp::fmi2::StringAttribute convert(const fmuproxy::grpc::StringAttribute &a) {
        return fmi4cpp::fmi2::StringAttribute(
                toScalarVariableAttributes<std::string, fmuproxy::grpc::StringAttribute>(a));
    }

    fmi4cpp::fmi2::BooleanAttribute convert(const fmuproxy::grpc::BooleanAttribute &a) {
        return fmi4cpp::fmi2::BooleanAttribute(toScalarVariableAttributes<bool, fmuproxy::grpc::BooleanAttribute>(a));
    }

    fmi4cpp::fmi2::EnumerationAttribute convert(const fmuproxy::grpc::EnumerationAttribute &a) {
        return fmi4cpp::fmi2::EnumerationAttribute(
                toBoundedScalarVariableAttributes<int, fmuproxy::grpc::EnumerationAttribute>(a));
    }

    fmi4cpp::fmi2::ScalarVariable convert(const fmuproxy::grpc::ScalarVariable &v) {

        fmi4cpp::fmi2::ScalarVariableBase base(v.name(), v.description(), (fmi2ValueReference) v.value_reference(),
                                               false, convert(v.causality()), convert(v.variability()),
                                               convert(v.initial()));

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

    fmi4cpp::fmi2::DefaultExperiment convert(const fmuproxy::grpc::DefaultExperiment &from) {
        return {from.start_time(), from.stop_time(), from.step_size(), from.tolerance()};
    }

    std::unique_ptr<fmi4cpp::fmi2::ModelVariables>
    convert(const google::protobuf::RepeatedPtrField<fmuproxy::grpc::ScalarVariable> m) {
        std::vector<fmi4cpp::fmi2::ScalarVariable> variables;
        for (const auto &var : m) {
            variables.push_back(convert(var));
        }
        return std::make_unique<fmi4cpp::fmi2::ModelVariables>(variables);
    }

    fmi4cpp::fmi2::CoSimulationAttributes convert(const fmuproxy::grpc::CoSimulationAttributes &a) {

        fmi4cpp::fmi2::FmuAttributes attributes(a.model_identifier(), a.can_get_and_set_fmustate(),
                                                a.can_serialize_fmustate(), false, false, false,
                                                a.provides_directional_derivative(), {});

        return {attributes, a.can_interpolate_inputs(), false, a.can_handle_variable_communication_step_size(),
                a.max_output_derivative_order()};

    }

    std::unique_ptr<fmi4cpp::fmi2::ModelDescriptionBase> convert(const fmuproxy::grpc::ModelDescription &from) {

        std::shared_ptr<fmi4cpp::fmi2::ModelVariables> mv = std::move(convert(from.model_variables()));

        return std::make_unique<fmi4cpp::fmi2::ModelDescriptionBase>(
                from.guid(), from.fmi_version(),
                from.model_name(), from.description(),
                from.version(), from.author(), from.license(),
                from.copyright(), from.generation_tool(),
                from.generation_date_and_time(),
                from.variable_naming_convention(), 0, mv,
                nullptr, convert(from.default_experiment()));

    }

}

#endif //FMU_PROXY_GRPC_CLIENT_HELPER_HPP
