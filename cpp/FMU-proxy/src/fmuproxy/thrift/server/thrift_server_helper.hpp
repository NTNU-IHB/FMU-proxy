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
#include <fmuproxy/thrift/common/definitions_types.h>

#include <fmi4cpp/fmi2/fmi4cpp.hpp>

using namespace fmuproxy::thrift;

namespace {

    const Status::type thriftType(fmi2Status status) {
        switch (status) {
            case fmi2OK:
                return Status::type::OK_STATUS;
            case fmi2Warning:
                return Status::type::WARNING_STATUS;
            case fmi2Pending:
                return Status::type::PENDING_STATUS;
            case fmi2Discard:
                return Status::type::DISCARD_STATUS;
            case fmi2Error:
                return Status::type::ERROR_STATUS;
            case fmi2Fatal:
                return Status::type::FATAL_STATUS;
            default:
                throw std::runtime_error("Fatal: Unknown status type!");
        }
    }

    const Causality::type thriftType(fmi2Causality causality) {
        switch (causality) {
            case fmi2Causality ::input:
                return Causality::type::INPUT_CAUSALITY;
            case fmi2Causality ::output:
                return Causality::type::OUTPUT_CAUSALITY;
            case fmi2Causality ::parameter:
                return Causality::type::PARAMETER_CAUSALITY;
            case fmi2Causality ::local:
                return Causality::type::LOCAL_CAUSALITY;
            case fmi2Causality ::independent:
                return Causality::type::INDEPENDENT_CAUSALITY;
            case fmi2Causality ::calculatedParameter:
                return Causality::type::CALCULATED_PARAMETER_CAUSALITY;
            default:
                return Causality::type::LOCAL_CAUSALITY;
        }
    }

    const Variability::type thriftType(fmi2Variability variability) {
        switch (variability) {
            case fmi2Variability ::constant:
                return Variability::type::CONSTANT_VARIABILITY;
            case fmi2Variability ::continuous:
                return Variability::type::CONTINUOUS_VARIABILITY;
            case fmi2Variability ::discrete:
                return Variability::type::DISCRETE_VARIABILITY;
            case fmi2Variability ::fixed:
                return Variability::type::FIXED_VARIABILITY;
            case fmi2Variability ::tunable:
                return Variability::type::TUNABLE_VARIABILITY;;
            default:
                return Variability::type::CONTINUOUS_VARIABILITY;
        }
    }

    const Initial::type thriftType(fmi2Initial initial) {
        switch (initial) {
            case fmi2Initial ::approx:
                return Initial::type::APPROX_INITIAL;
            case fmi2Initial ::calculated:
                return Initial::type::CALCULATED_INITIAL;
            case fmi2Initial ::exact:
                return Initial::type::EXACT_INITIAL;
            case fmi2Initial ::unknown:
            default:
                return Initial::type::UNKNOWN_INITIAL;
        }
    }

    IntegerAttribute thriftType(const fmi4cpp::fmi2::xml::IntegerAttribute &a) {
        IntegerAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        if (a.isMin_set()) {
            attribute.__set_min(a.getMin());
        }
        if (a.isMax_set()) {
            attribute.__set_max(a.getMax());
        }
        return attribute;
    }

    RealAttribute thriftType(const fmi4cpp::fmi2::xml::RealAttribute &a) {
        RealAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        if (a.isMin_set()) {
            attribute.__set_min(a.getMin());
        }
        if (a.isMax_set()) {
            attribute.__set_max(a.getMax());
        }
        return attribute;
    }

    StringAttribute thriftType(const fmi4cpp::fmi2::xml::StringAttribute &a) {
        StringAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        return attribute;
    }

    BooleanAttribute thriftType(const fmi4cpp::fmi2::xml::BooleanAttribute &a) {
        BooleanAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        return attribute;
    }

    EnumerationAttribute thriftType(const fmi4cpp::fmi2::xml::EnumerationAttribute &a) {
        EnumerationAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        if (a.isMin_set()) {
            attribute.__set_min(a.getMin());
        }
        if (a.isMax_set()) {
            attribute.__set_max(a.getMax());
        }
        return attribute;
    }

    ScalarVariable thriftType(const fmi4cpp::fmi2::xml::ScalarVariable &v) {

        ScalarVariable var;
        var.__set_name(v.name);
        var.__set_valueReference(v.valueReference);

        std::string description = v.description;
        if (!description.empty()) {
            var.__set_description(description);
        }

        var.__set_causality(thriftType(v.causality));
        var.__set_variability(thriftType(v.variability));
        var.__set_initial(thriftType(v.initial));

        auto attribute = v.attribute;

        if (attribute.isIntegerAttribute()) {
            var.attribute.__set_integerAttribute(thriftType(attribute.getIntegerAttribute()));
        } else if (attribute.isRealAttribute()) {
            var.attribute.__set_realAttribute(thriftType(attribute.getRealAttribute()));
        } else if (attribute.isStringAttribute()) {
            var.attribute.__set_stringAttribute(thriftType(attribute.getStringAttribute()));
        } else if (attribute.isBooleanAttribute()) {
            var.attribute.__set_booleanAttribute(thriftType(attribute.getBooleanAttribute()));
        } else if (attribute.isEnumerationAttribute()) {
            var.attribute.__set_enumerationAttribute(thriftType(attribute.getEnumerationAttribute()));
        } else {
            throw std::runtime_error("No valid attribute found..");
        }

        return var;

    }

    void thriftType(ModelVariables &variables, const fmi4cpp::fmi2::xml::ModelVariables &mv) {
        for (const fmi4cpp::fmi2::xml::ScalarVariable &var : mv) {
            variables.push_back(thriftType(var));
        }
    }

    void thriftType(ModelDescription &md, const fmi4cpp::fmi2::xml::ModelDescription &m) {

        md.__set_guid(m.guid);
        md.__set_version(m.version);
        md.__set_fmiVersion(m.fmiVersion);
        md.__set_modelName(m.modelName);
        md.__set_author(m.author);
        md.__set_license(m.license);
        md.__set_copyright(m.copyright);
        md.__set_description(m.description);
        md.__set_generationTool(m.generationTool);
        md.__set_generationDateAndTime(m.generationDateAndTime);
        md.__set_variableNamingConvention(m.variableNamingConvention);

        DefaultExperiment ex;
        ex.startTime = m.defaultExperiment.startTime;
        ex.stopTime = m.defaultExperiment.stopTime;
        ex.tolerance = m.defaultExperiment.tolerance;
        ex.stepSize = m.defaultExperiment.stepSize;
        md.__set_defaultExperiment(ex);

        ModelVariables modelVariables;
        thriftType(modelVariables, m.modelVariables);
        md.__set_modelVariables(modelVariables);

    }
    
}

#endif //FMU_PROXY_THRIFT_SERVER_HELPER_HPP
