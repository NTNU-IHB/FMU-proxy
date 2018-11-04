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

#include <fmi4cpp/fmi2/fmi4cpp.hpp>

using namespace fmuproxy::thrift;

namespace {

    const char *convert_string(const std::string &str) {
        return str.c_str();
    }

    fmi4cpp::Status convert(const Status::type status) {
        switch (status) {
            case Status::OK_STATUS:
                return fmi4cpp::Status::OK;
            case Status::WARNING_STATUS:
                return fmi4cpp::Status::Warning;
            case Status::DISCARD_STATUS:
                return fmi4cpp::Status::Discard;
            case Status::ERROR_STATUS:
                return fmi4cpp::Status::Error;
            case Status::FATAL_STATUS:
                return fmi4cpp::Status::Fatal;
            case Status::PENDING_STATUS:
                return fmi4cpp::Status::Pending;
            default:
                return fmi4cpp::Status::Unknown;
        }
    }

    fmi4cpp::fmi2::Causality convert(const Causality::type causality) {
        switch (causality) {
            case Causality::LOCAL_CAUSALITY:
                return fmi4cpp::fmi2::Causality::local;
            case Causality::INDEPENDENT_CAUSALITY:
                return fmi4cpp::fmi2::Causality::independent;
            case Causality::INPUT_CAUSALITY:
                return fmi4cpp::fmi2::Causality::input;
            case Causality::OUTPUT_CAUSALITY:
                return fmi4cpp::fmi2::Causality::output;
            case Causality::CALCULATED_PARAMETER_CAUSALITY:
                return fmi4cpp::fmi2::Causality::calculatedParameter;
            case Causality::PARAMETER_CAUSALITY:
                return fmi4cpp::fmi2::Causality::parameter;
            default:
                return fmi4cpp::fmi2::Causality::local;
        }
    }

    fmi4cpp::fmi2::Variability convert(const Variability::type variability) {
        switch (variability) {
            case Variability::CONSTANT_VARIABILITY:
                return fmi4cpp::fmi2::Variability::constant;
            case Variability::CONTINUOUS_VARIABILITY:
                return fmi4cpp::fmi2::Variability::continuous;
            case Variability::FIXED_VARIABILITY:
                return fmi4cpp::fmi2::Variability::fixed;
            case Variability::DISCRETE_VARIABILITY:
                return fmi4cpp::fmi2::Variability::discrete;
            case Variability::TUNABLE_VARIABILITY:
                return fmi4cpp::fmi2::Variability::tunable;
            default:
                return fmi4cpp::fmi2::Variability::continuous;
        }
    }

    fmi4cpp::fmi2::Initial convert(const Initial::type initial) {
        switch (initial) {
            case Initial::APPROX_INITIAL:
                return fmi4cpp::fmi2::Initial::approx;
            case Initial::CALCULATED_INITIAL:
                return fmi4cpp::fmi2::Initial::calculated;
            case Initial::EXACT_INITIAL:
                return fmi4cpp::fmi2::Initial::exact;
            default:
                return fmi4cpp::fmi2::Initial::unknown;
        }
    }

    fmi4cpp::fmi2::DefaultExperiment convert(const fmuproxy::thrift::DefaultExperiment &d) {
        return {d.startTime, d.stopTime, d.stepSize, d.tolerance};
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::ScalarVariableAttribute<T> toScalarVariableAttributes(const U &a) {
        if (a.__isset.start) {
            return fmi4cpp::fmi2::ScalarVariableAttribute<T>(a.start);
        } else {
            return {};
        }
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::BoundedScalarVariableAttribute<T> toBoundedScalarVariableAttributes(const U &a) {

        fmi4cpp::fmi2::BoundedScalarVariableAttribute<T> bounded(toScalarVariableAttributes<T, U>(a));
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

    fmi4cpp::fmi2::IntegerAttribute convert(const fmuproxy::thrift::IntegerAttribute &a) {
        return fmi4cpp::fmi2::IntegerAttribute(
                toBoundedScalarVariableAttributes<int, fmuproxy::thrift::IntegerAttribute>(a));
    }

    fmi4cpp::fmi2::RealAttribute convert(const fmuproxy::thrift::RealAttribute &a) {
        fmi4cpp::fmi2::RealAttribute real(
                toBoundedScalarVariableAttributes<double, fmuproxy::thrift::RealAttribute>(a));
        return real;
    }

    fmi4cpp::fmi2::StringAttribute convert(const fmuproxy::thrift::StringAttribute &a) {
        return fmi4cpp::fmi2::StringAttribute(
                toScalarVariableAttributes<std::string, fmuproxy::thrift::StringAttribute>(a));
    }

    fmi4cpp::fmi2::BooleanAttribute convert(const fmuproxy::thrift::BooleanAttribute &a) {
        return fmi4cpp::fmi2::BooleanAttribute(toScalarVariableAttributes<bool, fmuproxy::thrift::BooleanAttribute>(a));
    }

    fmi4cpp::fmi2::EnumerationAttribute convert(const fmuproxy::thrift::EnumerationAttribute &a) {
        return fmi4cpp::fmi2::EnumerationAttribute(
                toBoundedScalarVariableAttributes<int, fmuproxy::thrift::EnumerationAttribute>(a));
    }

    fmi4cpp::fmi2::ScalarVariable convert(const fmuproxy::thrift::ScalarVariable &v) {

        auto variability = convert(v.variability);
        auto causality = convert(v.causality);
        auto initial = convert(v.initial);

        fmi4cpp::fmi2::ScalarVariableBase base(v.name, v.description, (fmi2ValueReference) v.valueReference,
                                               false, causality, variability, initial);

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

    fmi4cpp::fmi2::CoSimulationAttributes convert(const fmuproxy::thrift::CoSimulationAttributes &a) {

        fmi4cpp::fmi2::FmuAttributes attributes(a.modelIdentifier, a.canGetAndSetFMUstate, a.canSerializeFMUstate,
                                                false, false, false,
                                                a.providesDirectionalDerivative, {});

        return {attributes, a.canInterpolateInputs, false, a.canHandleVariableCommunicationStepSize,
                static_cast<unsigned int>(a.maxOutputDerivativeOrder)};

    }

    std::unique_ptr<fmi4cpp::fmi2::ModelVariables> convert(const fmuproxy::thrift::ModelVariables &m) {
        std::vector<fmi4cpp::fmi2::ScalarVariable> variables;
        for (const auto &var : m) {
            variables.push_back(convert(var));
        }
        return std::make_unique<fmi4cpp::fmi2::ModelVariables>(variables);
    }

    std::unique_ptr<fmi4cpp::fmi2::ModelDescriptionBase> convert(const fmuproxy::thrift::ModelDescription &from) {

        std::shared_ptr<fmi4cpp::fmi2::ModelVariables> mv = std::move(convert(from.modelVariables));

        return std::make_unique<fmi4cpp::fmi2::ModelDescriptionBase>(
                from.guid, from.fmiVersion,
                from.modelName, from.description,
                from.version, from.author, from.license,
                from.copyright, from.generationTool,
                from.generationDateAndTime,
                from.variableNamingConvention, 0, mv,
                nullptr, convert(from.defaultExperiment));


    }

}

#endif //FMU_PROXY_THRIFT_CLIENT_HELPER_HPP
