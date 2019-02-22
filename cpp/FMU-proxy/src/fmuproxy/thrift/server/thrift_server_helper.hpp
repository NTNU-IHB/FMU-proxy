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

#ifndef FMU_PROXY_THRIFT_SERVER_HELPER_HPP
#define FMU_PROXY_THRIFT_SERVER_HELPER_HPP

#include <cfloat>
#include <fmuproxy/thrift/common/service_types.h>

#include <fmi4cpp/fmi2/fmi2.hpp>
#include <fmi4cpp/fmi2/xml/ScalarVariableAttribute.hpp>

using namespace fmuproxy::thrift;
using namespace fmi4cpp::fmi2;

namespace {

    const Status::type thriftType(fmi4cpp::Status status) {
        switch (status) {
            case fmi4cpp::Status::OK:
                return Status::type::OK_STATUS;
            case fmi4cpp::Status::Warning:
                return Status::type::WARNING_STATUS;
            case fmi4cpp::Status::Pending:
                return Status::type::PENDING_STATUS;
            case fmi4cpp::Status::Discard:
                return Status::type::DISCARD_STATUS;
            case fmi4cpp::Status::Error:
                return Status::type::ERROR_STATUS;
            case fmi4cpp::Status::Fatal:
                return Status::type::FATAL_STATUS;
            default:
                throw std::runtime_error("Fatal: Unknown status type!");
        }
    }

    const fmuproxy::thrift::Causality::type thriftType(fmi4cpp::fmi2::Causality causality) {
        switch (causality) {
            case fmi4cpp::fmi2::Causality ::input:
                return fmuproxy::thrift::Causality::type::INPUT_CAUSALITY;
            case fmi4cpp::fmi2::Causality ::output:
                return fmuproxy::thrift::Causality::type::OUTPUT_CAUSALITY;
            case fmi4cpp::fmi2::Causality ::parameter:
                return fmuproxy::thrift::Causality::type::PARAMETER_CAUSALITY;
            case fmi4cpp::fmi2::Causality ::local:
                return fmuproxy::thrift::Causality::type::LOCAL_CAUSALITY;
            case fmi4cpp::fmi2::Causality ::independent:
                return fmuproxy::thrift::Causality::type::INDEPENDENT_CAUSALITY;
            case fmi4cpp::fmi2::Causality ::calculatedParameter:
                return fmuproxy::thrift::Causality::type::CALCULATED_PARAMETER_CAUSALITY;
            default:
                return fmuproxy::thrift::Causality::type::LOCAL_CAUSALITY;
        }
    }

    const fmuproxy::thrift::Variability::type thriftType(fmi4cpp::fmi2::Variability variability) {
        switch (variability) {
            case fmi4cpp::fmi2::Variability ::constant:
                return fmuproxy::thrift::Variability::type::CONSTANT_VARIABILITY;
            case fmi4cpp::fmi2::Variability ::continuous:
                return fmuproxy::thrift::Variability::type::CONTINUOUS_VARIABILITY;
            case fmi4cpp::fmi2::Variability ::discrete:
                return fmuproxy::thrift::Variability::type::DISCRETE_VARIABILITY;
            case fmi4cpp::fmi2::Variability ::fixed:
                return fmuproxy::thrift::Variability::type::FIXED_VARIABILITY;
            case fmi4cpp::fmi2::Variability ::tunable:
                return fmuproxy::thrift::Variability::type::TUNABLE_VARIABILITY;;
            default:
                return fmuproxy::thrift::Variability::type::CONTINUOUS_VARIABILITY;
        }
    }

    const fmuproxy::thrift::Initial::type thriftType(fmi4cpp::fmi2::Initial initial) {
        switch (initial) {
            case fmi4cpp::fmi2::Initial ::approx:
                return fmuproxy::thrift::Initial::type::APPROX_INITIAL;
            case fmi4cpp::fmi2::Initial ::calculated:
                return fmuproxy::thrift::Initial::type::CALCULATED_INITIAL;
            case fmi4cpp::fmi2::Initial ::exact:
                return fmuproxy::thrift::Initial::type::EXACT_INITIAL;
            case fmi4cpp::fmi2::Initial ::unknown:
            default:
                return fmuproxy::thrift::Initial::type::UNKNOWN_INITIAL;
        }
    }

    template <typename T, typename U>
    void setScalarVariableAttributes(T t, const fmi4cpp::fmi2::ScalarVariableAttribute<U> &a) {
        if (a.start) {
            t.__set_start(*a.start);
        }
    }

    template <typename T, typename U>
    void setBoundedScalarVariableAttributes(T t, const fmi4cpp::fmi2::BoundedScalarVariableAttribute<U> &a) {
        setScalarVariableAttributes<T, U>(t, a);
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

    fmuproxy::thrift::IntegerAttribute thriftType(const fmi4cpp::fmi2::IntegerAttribute &a) {
        fmuproxy::thrift::IntegerAttribute attribute;
        setBoundedScalarVariableAttributes<fmuproxy::thrift::IntegerAttribute, int>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::RealAttribute thriftType(const fmi4cpp::fmi2::RealAttribute &a) {
        fmuproxy::thrift::RealAttribute attribute;
        setBoundedScalarVariableAttributes<fmuproxy::thrift::RealAttribute, double>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::StringAttribute thriftType(const fmi4cpp::fmi2::StringAttribute &a) {
        fmuproxy::thrift::StringAttribute attribute;
        setScalarVariableAttributes<fmuproxy::thrift::StringAttribute, std::string >(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::BooleanAttribute thriftType(const fmi4cpp::fmi2::BooleanAttribute &a) {
        fmuproxy::thrift::BooleanAttribute attribute;
        setScalarVariableAttributes<fmuproxy::thrift::BooleanAttribute, bool >(attribute, a);
        return attribute;
    }

    fmuproxy::thrift:: EnumerationAttribute thriftType(const fmi4cpp::fmi2::EnumerationAttribute &a) {
        fmuproxy::thrift::EnumerationAttribute attribute;
        setBoundedScalarVariableAttributes<fmuproxy::thrift::EnumerationAttribute, int>(attribute, a);
        return attribute;
    }

    fmuproxy::thrift::ScalarVariable thriftType(const fmi4cpp::fmi2::ScalarVariable &v) {

        fmuproxy::thrift::ScalarVariable var;
        var.__set_name(v.name);
        var.__set_valueReference(v.valueReference);

        std::string description = v.description;
        if (!description.empty()) {
            var.__set_description(description);
        }

        var.__set_causality(thriftType(v.causality));
        var.__set_variability(thriftType(v.variability));
        var.__set_initial(thriftType(v.initial));

        if (v.isInteger()) {
            var.attribute.__set_integerAttribute(thriftType(v.asInteger().attribute()));
        } else if (v.isReal()) {
            var.attribute.__set_realAttribute(thriftType(v.asReal().attribute()));
        } else if (v.isString()) {
            var.attribute.__set_stringAttribute(thriftType(v.asString().attribute()));
        } else if (v.isBoolean()) {
            var.attribute.__set_booleanAttribute(thriftType(v.asBoolean().attribute()));
        } else if (v.isEnumeration()) {
            var.attribute.__set_enumerationAttribute(thriftType(v.asEnumeration().attribute()));
        } else {
            throw std::runtime_error("Fatal: No valid attribute found..");
        }

        return var;

    }

    void copy(fmuproxy::thrift::ModelVariables &variables, const fmi4cpp::fmi2::ModelVariables &mv) {
        for (const auto &var : mv) {
            variables.push_back(thriftType(var));
        }
    }

    void copy(fmuproxy::thrift::DefaultExperiment &to, const fmi4cpp::fmi2::DefaultExperiment &from) {
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

    void thriftType(fmuproxy::thrift::ModelDescription &md, const fmi4cpp::fmi2::ModelDescriptionBase &m) {

        md.__set_guid(m.guid);
        md.__set_fmiVersion(m.fmiVersion);
        md.__set_modelName(m.modelName);

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
        if (m.generationTool) {
            md.__set_generationTool(*m.generationTool);
        }
        if (m.generationDateAndTime) {
            md.__set_generationDateAndTime(*m.generationDateAndTime);
        }
        if (m.variableNamingConvention) {
            md.__set_variableNamingConvention(*m.variableNamingConvention);
        }

        if (m.defaultExperiment) {
            fmuproxy::thrift::DefaultExperiment ex;
            copy(ex, *m.defaultExperiment);
            md.__set_defaultExperiment(ex);
        }

        fmuproxy::thrift::ModelVariables modelVariables;
        copy(modelVariables, *m.modelVariables);
        md.__set_modelVariables(modelVariables);

    }
    
}

#endif //FMU_PROXY_THRIFT_SERVER_HELPER_HPP
