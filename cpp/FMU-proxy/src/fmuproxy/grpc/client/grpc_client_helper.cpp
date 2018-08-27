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

#include <fmilib.h>
#include <fmuproxy/grpc/common/definitions.pb.h>
#include <fmuproxy/fmi/fmi_definitions.hpp>


namespace {

    fmi2_status_t convert(const fmuproxy::grpc::Status status) {
        switch (status) {
            case fmuproxy::grpc::Status::OK_STATUS:
                return fmi2_status_ok;
            case fmuproxy::grpc::Status::WARNING_STATUS:
                return fmi2_status_warning;
            case fmuproxy::grpc::Status::DISCARD_STATUS:
                return fmi2_status_discard;
            case fmuproxy::grpc::Status::ERROR_STATUS:
                return fmi2_status_error;
            case fmuproxy::grpc::Status::FATAL_STATUS:
                return fmi2_status_fatal;
            case fmuproxy::grpc::Status::PENDING_STATUS:
                return fmi2_status_pending;
            default:
                throw std::runtime_error("not a valid status: " + status);
        }
    }

    fmi2_causality_enu_t convert(const fmuproxy::grpc::Causality causality) {
        switch (causality) {
            case fmuproxy::grpc::Causality::LOCAL_CAUSALITY:
                return fmi2_causality_enu_local;
            case fmuproxy::grpc::Causality::INDEPENDENT_CAUSALITY:
                return fmi2_causality_enu_independent;
            case fmuproxy::grpc::Causality::INPUT_CAUSALITY:
                return fmi2_causality_enu_input;
            case fmuproxy::grpc::Causality::OUTPUT_CAUSALITY:
                return fmi2_causality_enu_output;
            case fmuproxy::grpc::Causality::CALCULATED_PARAMETER_CAUSALITY:
                return fmi2_causality_enu_calculated_parameter;
            case fmuproxy::grpc::Causality::PARAMETER_CAUSALITY:
                return fmi2_causality_enu_parameter;
            default:
                return fmi2_causality_enu_unknown;
        }
    }

    fmi2_variability_enu_t convert(const fmuproxy::grpc::Variability variability) {
        switch (variability) {
            case fmuproxy::grpc::Variability::CONSTANT_VARIABILITY:
                return fmi2_variability_enu_constant;
            case fmuproxy::grpc::Variability::CONTINUOUS_VARIABILITY:
                return fmi2_variability_enu_continuous;
            case fmuproxy::grpc::Variability::FIXED_VARIABILITY:
                return fmi2_variability_enu_fixed;
            case fmuproxy::grpc::Variability::DISCRETE_VARIABILITY:
                return fmi2_variability_enu_discrete;
            case fmuproxy::grpc::Variability::TUNABLE_VARIABILITY:
                return fmi2_variability_enu_tunable;
            default:
                return fmi2_variability_enu_unknown;
        }
    }

    fmi2_initial_enu_t convert(const fmuproxy::grpc::Initial initial) {
        switch (initial) {
            case fmuproxy::grpc::Initial::APPROX_INITIAL:
                return fmi2_initial_enu_approx;
            case fmuproxy::grpc::Initial::CALCULATED_INITIAL:
                return fmi2_initial_enu_calculated;
            case fmuproxy::grpc::Initial::EXACT_INITIAL:
                return fmi2_initial_enu_exact;
            default:
                return fmi2_initial_enu_unknown;
        }
    }

    fmi2_variable_naming_convension_enu_t convert(const fmuproxy::grpc::VariableNamingConvention convention) {
        switch (convention) {
            case fmuproxy::grpc::VariableNamingConvention::FLAT:
                return fmi2_naming_enu_flat;
            case fmuproxy::grpc::VariableNamingConvention::STRUCTURED:
                return fmi2_naming_enu_structured;
            default:
                throw std::runtime_error("not a valid convention: " + convention);
        }
    }

    fmuproxy::fmi::IntegerAttribute convert(const fmuproxy::grpc::IntegerAttribute &a1) {
        fmuproxy::fmi::IntegerAttribute a0;

        const auto min = a1.min();
        const auto max = a1.max();

        if (min < max) {
            a0.setMin(a1.min());
            a0.setMax(a1.max());
        }

        a0.setStart(a1.start());

        return a0;
    }

    fmuproxy::fmi::RealAttribute convert(const fmuproxy::grpc::RealAttribute &a1) {
        fmuproxy::fmi::RealAttribute a0;
        const auto min = a1.min();
        const auto max = a1.max();

        if (min < max) {
            a0.setMin(a1.min());
            a0.setMax(a1.max());
        }

        a0.setStart(a1.start());

        return a0;
    }

    fmuproxy::fmi::StringAttribute convert(const fmuproxy::grpc::StringAttribute &a1) {
        fmuproxy::fmi::StringAttribute a0;
        a0.setStart(a1.start());
        return a0;
    }

    fmuproxy::fmi::BooleanAttribute convert(const fmuproxy::grpc::BooleanAttribute &a1) {
        fmuproxy::fmi::BooleanAttribute a0;
        a0.setStart(a1.start());
        return a0;
    }

    fmuproxy::fmi::EnumerationAttribute convert(const fmuproxy::grpc::EnumerationAttribute &a1) {
        fmuproxy::fmi::EnumerationAttribute a0;
        const auto min = a1.min();
        const auto max = a1.max();

        if (min < max) {
            a0.setMin(a1.min());
            a0.setMax(a1.max());
        }

        a0.setStart(a1.start());

        return a0;
    }

    fmuproxy::fmi::ScalarVariable convert(const fmuproxy::grpc::ScalarVariable &v1) {
        fmuproxy::fmi::ScalarVariable v0;
        v0.name = v1.name();
        v0.valueReference = v1.value_reference();
        v0.description = v1.description();
        v0.variability = convert(v1.variability());
        v0.causality = convert(v1.causality());
        v0.initial = convert(v1.initial());
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

        return v0;
    }
    
    void copyToFrom(fmuproxy::fmi::DefaultExperiment &to, const fmuproxy::grpc::DefaultExperiment &from) {
        to.startTime = from.start_time();
        to.stopTime = from.stop_time();
        to.tolerance = from.tolerance();
        to.stepSize = from.step_size();
    }

    void copyToFrom(fmuproxy::fmi::ModelDescription &to, const fmuproxy::grpc::ModelDescription &from) {
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
