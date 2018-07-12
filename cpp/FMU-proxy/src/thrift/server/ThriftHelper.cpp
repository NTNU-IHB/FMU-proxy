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

#ifndef FMU_PROXY_THRIFTHELPER_H
#define FMU_PROXY_THRIFTHELPER_H

#include <cfloat>
#include <fmilib.h>
#include "../../fmi/FmiDefinitions.hpp"
#include "../thrift-gen/definitions_types.h"
#include "../../fmi/FmiDefinitions.hpp"

using namespace fmuproxy::thrift;

namespace {

    Status::type thriftType(fmi2_status_t status) {
        switch (status) {
            case fmi2_status_ok:
                return Status::type::OK_STATUS;
            case fmi2_status_warning:
                return Status::type::WARNING_STATUS;
            case fmi2_status_pending:
                return Status::type::PENDING_STATUS;
            case fmi2_status_discard:
                return Status::type::DISCARD_STATUS;
            case fmi2_status_error:
                return Status::type::ERROR_STATUS;
            case fmi2_status_fatal:
                return Status::type::FATAL_STATUS;
        }
    }

    Causality::type thriftType(fmi2_causality_enu_t causality) {
        switch (causality) {
            case fmi2_causality_enu_input:
                return Causality::type::INPUT_CAUSALITY;
            case fmi2_causality_enu_output:
                return Causality::type::OUTPUT_CAUSALITY;
            case fmi2_causality_enu_parameter:
                return Causality::type::PARAMETER_CAUSALITY;
            case fmi2_causality_enu_local:
                return Causality::type::LOCAL_CAUSALITY;
            case fmi2_causality_enu_independent:
                return Causality::type::INDEPENDENT_CAUSALITY;
            case fmi2_causality_enu_calculated_parameter:
                return Causality::type::CALCULATED_PARAMETER_CAUSALITY;
            case fmi2_causality_enu_unknown:
                return Causality::type::LOCAL_CAUSALITY;
        }
    }

    Variability::type thriftType(fmi2_variability_enu_t variability) {
        switch (variability) {
            case fmi2_variability_enu_constant:
                return Variability::type::CONSTANT_VARIABILITY;
            case fmi2_variability_enu_continuous:
                return Variability::type::CONTINUOUS_VARIABILITY;
            case fmi2_variability_enu_discrete:
                return Variability::type::DISCRETE_VARIABILITY;
            case fmi2_variability_enu_fixed:
                return Variability::type::FIXED_VARIABILITY;
            case fmi2_variability_enu_tunable:
                return Variability::type::TUNABLE_VARIABILITY;;
            case fmi2_variability_enu_unknown:
                return Variability::type::CONTINUOUS_VARIABILITY;
        }
    }

    Initial::type thriftType(fmi2_initial_enu_t initial) {
        switch (initial) {
            case fmi2_initial_enu_approx:
                return Initial::type::APPROX_INITIAL;
            case fmi2_initial_enu_calculated:
                return Initial::type::CALCULATED_INITIAL;
            case fmi2_initial_enu_exact:
                return Initial::type::EXACT_INITIAL;
            case fmi2_initial_enu_unknown:
                return Initial::type::APPROX_INITIAL;
        }
    }

    VariableNamingConvention::type thriftType(fmi2_variable_naming_convension_enu_t convention) {
        switch (convention) {
            case fmi2_naming_enu_flat:
                return VariableNamingConvention::FLAT;
            case fmi2_naming_enu_structured:
                return VariableNamingConvention::STRUCTURED;
            case fmi2_naming_enu_unknown:
               throw std::runtime_error("TODO handle unknown naming convention!");
        }
    }

    IntegerAttribute thriftType(const fmuproxy::fmi::IntegerAttribute &a) {
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

    RealAttribute thriftType(const fmuproxy::fmi::RealAttribute &a) {
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

    StringAttribute thriftType(const fmuproxy::fmi::StringAttribute &a) {
        StringAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        return attribute;
    }

    BooleanAttribute thriftType(const fmuproxy::fmi::BooleanAttribute &a) {
        BooleanAttribute attribute;
        if (a.isStart_set()) {
            attribute.__set_start(a.getStart());
        }
        return attribute;
    }

    EnumerationAttribute thriftType(const fmuproxy::fmi::EnumerationAttribute &a) {
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

    ScalarVariable thriftType(const fmuproxy::fmi::ScalarVariable &v) {

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

    void thriftType(ModelVariables &variables, const fmuproxy::fmi::ModelVariables &mv) {
        for (fmuproxy::fmi::ScalarVariable var : mv) {
            variables.push_back(thriftType(var));
        }
    }

    void thriftType(ModelDescription &md, const fmuproxy::fmi::ModelDescription &m) {

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
        md.__set_variableNamingConvention(thriftType(m.variableNamingConvention));
        md.__set_supportsCoSimulation(true);
        md.__set_supportsModelExchange(false);

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

#endif //FMU_PROXY_THRIFTHELPER_H

