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

#include <iostream>
#include <fmilib.h>
#include <fmuproxy/fmi/FmiDefinitions.hpp>
#include <fmuproxy/thrift/common/definitions_types.h>

using namespace fmuproxy::thrift;

namespace {

    fmi2_status_t convert(const Status::type status) {
        switch (status) {
            case Status::OK_STATUS:
                return fmi2_status_ok;
            case Status::WARNING_STATUS:
                return fmi2_status_warning;
            case Status::DISCARD_STATUS:
                return fmi2_status_discard;
            case Status::ERROR_STATUS:
                return fmi2_status_error;
            case Status::FATAL_STATUS:
                return fmi2_status_fatal;
            case Status::PENDING_STATUS:
                return fmi2_status_pending;
            default:
                throw std::runtime_error("not a valid status: " + status);
        }
    }

    fmi2_causality_enu_t convert(const Causality::type causality) {
        switch (causality) {
            case Causality::LOCAL_CAUSALITY:
                return fmi2_causality_enu_local;
            case Causality::INDEPENDENT_CAUSALITY:
                return fmi2_causality_enu_independent;
            case Causality::INPUT_CAUSALITY:
                return fmi2_causality_enu_input;
            case Causality::OUTPUT_CAUSALITY:
                return fmi2_causality_enu_output;
            case Causality::CALCULATED_PARAMETER_CAUSALITY:
                return fmi2_causality_enu_calculated_parameter;
            case Causality::PARAMETER_CAUSALITY:
                return fmi2_causality_enu_parameter;
            default:
                return fmi2_causality_enu_unknown;
        }
    }

    fmi2_variability_enu_t convert(const Variability::type variability) {
        switch (variability) {
            case Variability::CONSTANT_VARIABILITY:
                return fmi2_variability_enu_constant;
            case Variability::CONTINUOUS_VARIABILITY:
                return fmi2_variability_enu_continuous;
            case Variability::FIXED_VARIABILITY:
                return fmi2_variability_enu_fixed;
            case Variability::DISCRETE_VARIABILITY:
                return fmi2_variability_enu_discrete;
            case Variability::TUNABLE_VARIABILITY:
                return fmi2_variability_enu_tunable;
            default:
                return fmi2_variability_enu_unknown;
        }
    }

    fmi2_initial_enu_t convert(const Initial::type initial) {
        switch (initial) {
            case Initial::APPROX_INITIAL:
                return fmi2_initial_enu_approx;
            case Initial::CALCULATED_INITIAL:
                return fmi2_initial_enu_calculated;
            case Initial::EXACT_INITIAL:
                return fmi2_initial_enu_exact;
            default:
                return fmi2_initial_enu_unknown;
        }
    }

    fmi2_variable_naming_convension_enu_t convert(const VariableNamingConvention::type convention) {
        switch (convention) {
            case VariableNamingConvention::FLAT:
                return fmi2_naming_enu_flat;
            case VariableNamingConvention::STRUCTURED:
                return fmi2_naming_enu_structured;
            default:
                throw std::runtime_error("not a valid convention: " + convention);
        }
    }

    void convert(fmuproxy::fmi::DefaultExperiment &d0, const fmuproxy::thrift::DefaultExperiment &d1) {
        d0.startTime = d1.startTime;
        d0.stopTime = d1.stopTime;
        d0.tolerance = d1.tolerance;
        d0.stepSize = d1.stepSize;
    }

    fmuproxy::fmi::IntegerAttribute convert(const fmuproxy::thrift::IntegerAttribute &a1) {
        fmuproxy::fmi::IntegerAttribute a0;
        if (a1.__isset.min) {
            a0.setMin(a1.min);
        }
        if (a1.__isset.max) {
            a0.setMax(a1.max);
        }
        if (a1.__isset.start) {
            a0.setStart(a1.start);
        }
        return a0;
    }

    fmuproxy::fmi::RealAttribute convert(const fmuproxy::thrift::RealAttribute &a1) {
        fmuproxy::fmi::RealAttribute a0;
        if (a1.__isset.min) {
            a0.setMin(a1.min);
        }
        if (a1.__isset.max) {
            a0.setMax(a1.max);
        }
        if (a1.__isset.start) {
            a0.setStart(a1.start);
        }
        return a0;
    }

    fmuproxy::fmi::StringAttribute convert(const fmuproxy::thrift::StringAttribute &a1) {
        fmuproxy::fmi::StringAttribute a0;
        a0.setStart(a1.start);
        return a0;
    }

    fmuproxy::fmi::BooleanAttribute convert(const fmuproxy::thrift::BooleanAttribute &a1) {
        fmuproxy::fmi::BooleanAttribute a0;
        if (a1.__isset.start) {
            a0.setStart(a1.start);
        }
        return a0;
    }

    fmuproxy::fmi::EnumerationAttribute convert(const fmuproxy::thrift::EnumerationAttribute &a1) {
        fmuproxy::fmi::EnumerationAttribute a0;
        if (a1.__isset.min) {
            a0.setMin(a1.min);
        }
        if (a1.__isset.max) {
            a0.setMax(a1.max);
        }
        if (a1.__isset.start) {
            a0.setStart(a1.start);
        }
        return a0;
    }

    fmuproxy::fmi::ScalarVariableAttribute convert(const fmuproxy::thrift::ScalarVariableAttribute &a1) {
        fmuproxy::fmi::ScalarVariableAttribute a0;
        if (a1.__isset.integerAttribute) {
            a0.setIntegerAttribute(convert(a1.integerAttribute));
        } else if (a1.__isset.realAttribute) {
            a0.setRealAttribute(convert(a1.realAttribute));
        } else if (a1.__isset.stringAttribute) {
            a0.setStringAttribute(convert(a1.stringAttribute));
        } else if (a1.__isset.booleanAttribute) {
            a0.setBooleanAttribute(convert(a1.booleanAttribute));
        } else if (a1.__isset.enumerationAttribute) {
            a0.setEnumerationAttribute(convert(a1.enumerationAttribute));
        } else {
            throw std::runtime_error("no attribute set!");
        }
        return a0;
    }

    fmuproxy::fmi::ScalarVariable convert(const fmuproxy::thrift::ScalarVariable &v1) {
        fmuproxy::fmi::ScalarVariable v0;
        v0.name = v1.name;
        v0.valueReference = v1.valueReference;
        v0.description = v1.description;
        v0.declaredType = v1.declaredType;
        v0.variability = convert(v1.variability);
        v0.causality = convert(v1.causality);
        v0.initial = convert(v1.initial);
        v0.attribute = convert(v1.attribute);
        return v0;
    }

    void convert(fmuproxy::fmi::ModelVariables &m0, const fmuproxy::thrift::ModelVariables &m1) {
        for (fmuproxy::thrift::ScalarVariable var : m1) {
            m0.push_back(convert(var));
        }
    }

    void convert(fmuproxy::fmi::ModelDescription &m0, const fmuproxy::thrift::ModelDescription &m1) {
        m0.guid = m1.guid;
        m0.modelName = m1.modelName;
        m0.version = m1.version;
        m0.fmiVersion = m1.fmiVersion;
        m0.license = m1.license;
        m0.copyright = m1.copyright;
        m0.generationTool = m1.generationTool;
        m0.generationDateAndTime = m1.generationDateAndTime;
        m0.variableNamingConvention = convert(m1.variableNamingConvention);
        convert(m0.modelVariables, m1.modelVariables);
        convert(m0.defaultExperiment, m1.defaultExperiment);
    }

}