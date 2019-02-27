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

    fmi4cpp::fmi2::DefaultExperiment convert(const fmuproxy::thrift::DefaultExperiment &d) {
        return {d.startTime, d.stopTime, d.stepSize, d.tolerance};
    }

    template<typename T, typename U>
    fmi4cpp::fmi2::ScalarVariableAttribute<T> toScalarVariableAttributes(const U &a) {
        if (a.__isset.start) {
             auto attribute = fmi4cpp::fmi2::ScalarVariableAttribute<T>();
             attribute.start = a.start;
             return attribute;
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

        fmi4cpp::fmi2::ScalarVariableBase base;
        base.name = v.name;
        base.description = v.description;
        base.valueReference = (fmi2ValueReference) v.valueReference;
        base.variability = fmi4cpp::fmi2::parseVariability(v.variability);
        base.causality = fmi4cpp::fmi2::parseCausality(v.causality);
        base.initial = fmi4cpp::fmi2::parseInitial(v.initial);

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

        fmi4cpp::fmi2::CoSimulationAttributes attributes;
        attributes.modelIdentifier = a.modelIdentifier;
        attributes.canGetAndSetFMUstate = a.canGetAndSetFMUstate;
        attributes.canSerializeFMUstate = a.canSerializeFMUstate;
        attributes.providesDirectionalDerivative = a.providesDirectionalDerivative;

        attributes.canInterpolateInputs = a.canInterpolateInputs;
        attributes.canHandleVariableCommunicationStepSize = a.canHandleVariableCommunicationStepSize;
        attributes.maxOutputDerivativeOrder = static_cast<unsigned int>(a.maxOutputDerivativeOrder);

        return attributes;

    }

    std::unique_ptr<fmi4cpp::fmi2::ModelVariables> convert(const fmuproxy::thrift::ModelVariables &m) {
        std::vector<fmi4cpp::fmi2::ScalarVariable> variables;
        for (const auto &var : m) {
            variables.push_back(convert(var));
        }
        return std::make_unique<fmi4cpp::fmi2::ModelVariables>(variables);
    }

    std::unique_ptr<fmi4cpp::fmi2::ModelDescriptionBase> convert(const fmuproxy::thrift::ModelDescription &from) {

        auto base = std::make_unique<fmi4cpp::fmi2::ModelDescriptionBase>();
        base->guid = from.guid;
        base-> fmiVersion = from.fmiVersion;
        base->description = from.description;
        base->modelName = from.modelName;
        base->modelVariables = std::move(convert(from.modelVariables));
        base->variableNamingConvention = from.variableNamingConvention;
        base->defaultExperiment = convert(from.defaultExperiment);
        base->generationDateAndTime = from.generationDateAndTime;
        base->generationTool = from.generationTool;
        base->license = from.license;
        base->version = from.version;
        base->copyright = from.copyright;
        base->author = from.author;
        base->modelStructure = nullptr;
        return base;

    }

}

#endif //FMU_PROXY_THRIFT_CLIENT_HELPER_HPP
