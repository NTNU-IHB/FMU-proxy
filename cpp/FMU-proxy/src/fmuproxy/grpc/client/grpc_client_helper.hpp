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
                return fmi2Causality ::local;
            case fmuproxy::grpc::Causality::INDEPENDENT_CAUSALITY:
                return fmi2Causality ::independent;
            case fmuproxy::grpc::Causality::INPUT_CAUSALITY:
                return fmi2Causality ::input;
            case fmuproxy::grpc::Causality::OUTPUT_CAUSALITY:
                return fmi2Causality ::output;
            case fmuproxy::grpc::Causality::CALCULATED_PARAMETER_CAUSALITY:
                return fmi2Causality ::calculatedParameter;
            case fmuproxy::grpc::Causality::PARAMETER_CAUSALITY:
                return fmi2Causality ::parameter;
            default:
                return fmi2Causality ::local;
        }
    }

    fmi2Variability convert(const fmuproxy::grpc::Variability variability) {
        switch (variability) {
            case fmuproxy::grpc::Variability::CONSTANT_VARIABILITY:
                return fmi2Variability ::constant;
            case fmuproxy::grpc::Variability::CONTINUOUS_VARIABILITY:
                return fmi2Variability ::continuous;
            case fmuproxy::grpc::Variability::FIXED_VARIABILITY:
                return fmi2Variability ::fixed;
            case fmuproxy::grpc::Variability::DISCRETE_VARIABILITY:
                return fmi2Variability ::discrete;
            case fmuproxy::grpc::Variability::TUNABLE_VARIABILITY:
                return fmi2Variability ::tunable;
            default:
                return fmi2Variability ::continuous;
        }
    }

    fmi2Initial convert(const fmuproxy::grpc::Initial initial) {
        switch (initial) {
            case fmuproxy::grpc::Initial::APPROX_INITIAL:
                return fmi2Initial ::approx;
            case fmuproxy::grpc::Initial::CALCULATED_INITIAL:
                return fmi2Initial ::calculated;
            case fmuproxy::grpc::Initial::EXACT_INITIAL:
                return fmi2Initial ::exact;
            default:
                return fmi2Initial ::unknown;
        }
    }

    std::string convert(const fmuproxy::grpc::VariableNamingConvention convention) {
        switch (convention) {
            case fmuproxy::grpc::VariableNamingConvention::FLAT:
                return "flat";
            case fmuproxy::grpc::VariableNamingConvention::STRUCTURED:
                return "structured";
            default:
                throw std::runtime_error("not a valid convention: " + convention);
        }
    }

    fmi4cpp::fmi2::xml::IntegerAttribute convert(const fmuproxy::grpc::IntegerAttribute &a1) {

        const auto min = a1.min();
        const auto max = a1.max();

        if (min < max) {
            a0.setMin(a1.min());
            a0.setMax(a1.max());
        }

        a0.setStart(a1.start());

        ScalarVariableAttributes attributes(std::make_optional(0), {});

        return IntegerAttribute(BoundedScalarVariableAttributes());
    }

    fmi4cpp::fmi2::xml::RealAttribute convert(const fmuproxy::grpc::RealAttribute &a1) {
        fmi4cpp::fmi2::xml::RealAttribute a0;
        const auto min = a1.min();
        const auto max = a1.max();

        if (min < max) {
            a0.setMin(a1.min());
            a0.setMax(a1.max());
        }

        a0.setStart(a1.start());

        return a0;
    }

    fmi4cpp::fmi2::xml::StringAttribute convert(const fmuproxy::grpc::StringAttribute &a1) {
        return
        fmi4cpp::fmi2::xml::StringAttribute a0;
        a0.setStart(a1.start());
        return a0;
    }

    fmi4cpp::fmi2::xml::BooleanAttribute convert(const fmuproxy::grpc::BooleanAttribute &a1) {
        fmi4cpp::fmi2::xml::BooleanAttribute a0;
        a0.setStart(a1.start());
        return a0;
    }

    fmi4cpp::fmi2::xml::EnumerationAttribute convert(const fmuproxy::grpc::EnumerationAttribute &a1) {
        fmi4cpp::fmi2::xml::EnumerationAttribute a0;
        const auto min = a1.min();
        const auto max = a1.max();

        if (min < max) {
            a0.setMin(a1.min());
            a0.setMax(a1.max());
        }

        a0.setStart(a1.start());

        return a0;
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
    
    void copyToFrom(fmi4cpp::fmi2::xml::DefaultExperiment &to, const fmuproxy::grpc::DefaultExperiment &from) {
        to.startTime = from.start_time();
        to.stopTime = from.stop_time();
        to.tolerance = from.tolerance();
        to.stepSize = from.step_size();
    }

    void copyToFrom(fmi4cpp::fmi2::xml::ModelDescription &to, const fmuproxy::grpc::ModelDescription &from) {
        to.guid = from.guid();
        to.modelName = from.model_name();
        to.version = from.version();
        to.fmiVersion = from.fmi_version();
        to.license = from.license();
        to.copyright = from.copyright();
        to.generationTool = from.generation_tool();
        to.generationDateAndTime = from.generation_date_and_time();
        to.variableNamingConvention = convert(from.variable_naming_convention());

        copyToFrom(to.defaultExperiment, from.default_experiment());

        for (const auto &var : from.model_variables()) {
            to.modelVariables.push_back(convert(var));
        }

        to.supportsCoSimulation = from.supports_co_simulation();
        to.supportsModelExchange = from.supports_model_exchange();

    }
    
}

#endif //FMU_PROXY_GRPC_CLIENT_HELPER_HPP
