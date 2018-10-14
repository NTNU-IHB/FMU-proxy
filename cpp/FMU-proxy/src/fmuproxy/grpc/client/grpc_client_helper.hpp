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
#include <fmuproxy/grpc/common/definitions.pb.h>

namespace {

    fmi2Status convert(const fmuproxy::grpc::Status status) {
        switch (status) {
            case fmuproxy::grpc::Status::OK_STATUS:
                return fmi2OK;
            case fmuproxy::grpc::Status::WARNING_STATUS:
                return fmi2Warning;
            case fmuproxy::grpc::Status::DISCARD_STATUS:
                return fmi2Discard;
            case fmuproxy::grpc::Status::ERROR_STATUS:
                return fmi2Error;
            case fmuproxy::grpc::Status::FATAL_STATUS:
                return fmi2Fatal;
            case fmuproxy::grpc::Status::PENDING_STATUS:
                return fmi2Pending;
            default:
                throw std::runtime_error("not a valid status: " + status);
        }
    }

    fmi2Causality convert(const fmuproxy::grpc::Causality causality) {
        switch (causality) {
            case fmuproxy::grpc::Causality::LOCAL_CAUSALITY:
                return fmi2Causality::local;
            case fmuproxy::grpc::Causality::INDEPENDENT_CAUSALITY:
                return fmi2Causality::independent;
            case fmuproxy::grpc::Causality::INPUT_CAUSALITY:
                return fmi2Causality::input;
            case fmuproxy::grpc::Causality::OUTPUT_CAUSALITY:
                return fmi2Causality::output;
            case fmuproxy::grpc::Causality::CALCULATED_PARAMETER_CAUSALITY:
                return fmi2Causality::calculatedParameter;
            case fmuproxy::grpc::Causality::PARAMETER_CAUSALITY:
                return fmi2Causality::parameter;
            default:
                return fmi2Causality::local;
        }
    }

    fmi2Variability convert(const fmuproxy::grpc::Variability variability) {
        switch (variability) {
            case fmuproxy::grpc::Variability::CONSTANT_VARIABILITY:
                return fmi2Variability::constant;
            case fmuproxy::grpc::Variability::CONTINUOUS_VARIABILITY:
                return fmi2Variability::continuous;
            case fmuproxy::grpc::Variability::FIXED_VARIABILITY:
                return fmi2Variability::fixed;
            case fmuproxy::grpc::Variability::DISCRETE_VARIABILITY:
                return fmi2Variability::discrete;
            case fmuproxy::grpc::Variability::TUNABLE_VARIABILITY:
                return fmi2Variability::tunable;
            default:
                return fmi2Variability::continuous;
        }
    }

    fmi2Initial convert(const fmuproxy::grpc::Initial initial) {
        switch (initial) {
            case fmuproxy::grpc::Initial::APPROX_INITIAL:
                return fmi2Initial::approx;
            case fmuproxy::grpc::Initial::CALCULATED_INITIAL:
                return fmi2Initial::calculated;
            case fmuproxy::grpc::Initial::EXACT_INITIAL:
                return fmi2Initial::exact;
            default:
                return fmi2Initial::unknown;
        }
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::xml::ScalarVariableAttributes<T> toScalarVariableAttributes(U a) {
        return {a.start()};
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::xml::BoundedScalarVariableAttributes<T> toBoundedScalarVariableAttributes(U a) {

        auto attributes = toScalarVariableAttributes<T>(a);

        fmi4cpp::fmi2::xml::BoundedScalarVariableAttributes bounded(attributes);

        if (a.max() > a.min()) {
            bounded.min = a.min();
            bounded.max = a.max();
        }

        if (!a.quantity().empty()) {
            bounded.quantity = a.quantity();
        }

        return bounded;

    }

    fmi4cpp::fmi2::xml::IntegerAttribute convert(const fmuproxy::grpc::IntegerAttribute &a) {
        return {toBoundedScalarVariableAttributes<int, fmuproxy::grpc::IntegerAttribute>(a)};
    }

    fmi4cpp::fmi2::xml::RealAttribute convert(const fmuproxy::grpc::RealAttribute &a) {
        auto bounded = toBoundedScalarVariableAttributes<double, fmuproxy::grpc::RealAttribute>(a);

        fmi4cpp::fmi2::xml::RealAttribute real(bounded);

        return real;
    }

    fmi4cpp::fmi2::xml::StringAttribute convert(const fmuproxy::grpc::StringAttribute &a) {
        return {toScalarVariableAttributes<std::string, fmuproxy::grpc::StringAttribute>(a)};
    }

    fmi4cpp::fmi2::xml::BooleanAttribute convert(const fmuproxy::grpc::BooleanAttribute &a) {
        return {toScalarVariableAttributes<bool, fmuproxy::grpc::BooleanAttribute>(a)};
    }

    fmi4cpp::fmi2::xml::EnumerationAttribute convert(const fmuproxy::grpc::EnumerationAttribute &a) {
        return {toBoundedScalarVariableAttributes<int, fmuproxy::grpc::EnumerationAttribute>(a)};
    }

    fmi4cpp::fmi2::xml::ScalarVariable convert(const fmuproxy::grpc::ScalarVariable &v1) {

        switch (v1.attribute_case()) {
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kIntegerAttribute:
                v0.attribute.setIntegerAttribute(convert(v1.integer_attribute()));
                break;
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kRealAttribute:
                v0.attribute.setRealAttribute(convert(v1.real_attribute()));
                break;
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kStringAttribute:
                v0.attribute.setStringAttribute(convert(v1.string_attribute()));
                break;
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kBooleanAttribute:
                v0.attribute.setBooleanAttribute(convert(v1.boolean_attribute()));
                break;
            case fmuproxy::grpc::ScalarVariable::AttributeCase::kEnumerationAttribute:
                v0.attribute.setEnumerationAttribute(convert(v1.enumeration_attribute()));
                break;
            default:
                throw std::runtime_error("no attribute set!");
        }

        v0.name = v1.name();
        v0.valueReference = v1.value_reference();
        v0.description = v1.description();
        v0.variability = convert(v1.variability());
        v0.causality = convert(v1.causality());
        v0.initial = convert(v1.initial());
    }

    fmi4cpp::fmi2::xml::DefaultExperiment convert(const fmuproxy::grpc::DefaultExperiment &from) {
        return {from.start_time(), from.stop_time(), from.step_size(), from.tolerance()};
    }

    std::unique_ptr<fmi4cpp::fmi2::xml::ModelVariables>
    convert(const google::protobuf::RepeatedPtrField<fmuproxy::grpc::ScalarVariable> m) {
        std::vector<fmi4cpp::fmi2::xml::ScalarVariable> variables;
        for (const auto &var : m) {
            variables.push_back(convert(var));
        }
        return std::make_unique<fmi4cpp::fmi2::xml::ModelVariables>(variables);
    }

    std::unique_ptr<fmi4cpp::fmi2::xml::ModelDescriptionBase> convert(const fmuproxy::grpc::ModelDescription &from) {


        std::shared_ptr<fmi4cpp::fmi2::xml::ModelVariables> mv = std::move(convert(from.model_variables()));

        return std::make_unique<fmi4cpp::fmi2::xml::ModelDescriptionBase>(from.guid(), from.fmi_version(),
                                                                          from.model_name(), from.description(),
                                                                          from.version(), from.author(), from.license(),
                                                                          from.copyright(), from.generation_tool(),
                                                                          from.generation_date_and_time(),
                                                                          from.variable_naming_convention(), 0, mv,
                                                                          nullptr, convert(from.default_experiment()));

    }

}

#endif //FMU_PROXY_GRPC_CLIENT_HELPER_HPP
