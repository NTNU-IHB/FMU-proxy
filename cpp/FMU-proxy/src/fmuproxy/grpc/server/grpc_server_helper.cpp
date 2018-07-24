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

#include <grpcpp/grpcpp.h>
#include <fmuproxy/fmi/fmi_definitions.hpp>
#include <fmuproxy/grpc/common/definitions.pb.h>
#include <fmuproxy/thrift/common/definitions_types.h>

using namespace fmuproxy::grpc;

namespace {

    int ID_GEN = 0;

    Status grpcType(fmi2_status_t status) {
        switch (status) {
            case fmi2_status_ok:
                return Status::OK_STATUS;
            case fmi2_status_warning:
                return Status::WARNING_STATUS;
            case fmi2_status_pending:
                return Status::PENDING_STATUS;
            case fmi2_status_discard:
                return Status::DISCARD_STATUS;
            case fmi2_status_error:
                return Status::ERROR_STATUS;
            case fmi2_status_fatal:
                return Status::FATAL_STATUS;
            default:
                throw std::runtime_error("Invalid status: " + status);
        }
    }

    Causality grpcType(fmi2_causality_enu_t causality) {
        switch (causality) {
            case fmi2_causality_enu_input:
                return Causality::INPUT_CAUSALITY;
            case fmi2_causality_enu_output:
                return Causality::OUTPUT_CAUSALITY;
            case fmi2_causality_enu_parameter:
                return Causality::PARAMETER_CAUSALITY;
            case fmi2_causality_enu_local:
                return Causality::LOCAL_CAUSALITY;
            case fmi2_causality_enu_independent:
                return Causality::INDEPENDENT_CAUSALITY;
            case fmi2_causality_enu_calculated_parameter:
                return Causality::CALCULATED_PARAMETER_CAUSALITY;
            case fmi2_causality_enu_unknown:
                return Causality::LOCAL_CAUSALITY;
            default:
                throw std::runtime_error("Invalid status: " + causality);
        }
    }

    Variability grpcType(fmi2_variability_enu_t variability) {
        switch (variability) {
            case fmi2_variability_enu_constant:
                return Variability::CONSTANT_VARIABILITY;
            case fmi2_variability_enu_continuous:
                return Variability::CONTINUOUS_VARIABILITY;
            case fmi2_variability_enu_discrete:
                return Variability::DISCRETE_VARIABILITY;
            case fmi2_variability_enu_fixed:
                return Variability::FIXED_VARIABILITY;
            case fmi2_variability_enu_tunable:
                return Variability::TUNABLE_VARIABILITY;;
            case fmi2_variability_enu_unknown:
                return Variability::CONTINUOUS_VARIABILITY;
            default:
                throw std::runtime_error("Invalid status: " + variability);
        }
    }

    Initial grpcType(fmi2_initial_enu_t initial) {
        switch (initial) {
            case fmi2_initial_enu_approx:
                return Initial::APPROX_INITIAL;
            case fmi2_initial_enu_calculated:
                return Initial::CALCULATED_INITIAL;
            case fmi2_initial_enu_exact:
                return Initial::EXACT_INITIAL;
            case fmi2_initial_enu_unknown:
                return Initial::APPROX_INITIAL;
            default:
                throw std::runtime_error("Invalid status: " + initial);
        }
    }

    VariableNamingConvention grpcType(fmi2_variable_naming_convension_enu_t convention) {
        switch (convention) {
            case fmi2_naming_enu_flat:
                return VariableNamingConvention::FLAT;
            case fmi2_naming_enu_structured:
                return VariableNamingConvention::STRUCTURED;
            case fmi2_naming_enu_unknown:
                throw std::runtime_error("TODO handle unknown naming convention!");
            default:
                throw std::runtime_error("Invalid status: " + convention);
        }
    }

    void grpcType(IntegerAttribute &attribute, const fmuproxy::fmi::IntegerAttribute &a) {
        if (a.isStart_set()) {
            attribute.set_start(a.getStart());
        }
        if (a.isMin_set()) {
            attribute.set_min(a.getMin());
        }
        if (a.isMax_set()) {
            attribute.set_max(a.getMax());
        }
    }

    void grpcType(RealAttribute &attribute, const fmuproxy::fmi::RealAttribute &a) {
        if (a.isStart_set()) {
            attribute.set_start(a.getStart());
        }
        if (a.isMin_set()) {
            attribute.set_min(a.getMin());
        }
        if (a.isMax_set()) {
            attribute.set_max(a.getMax());
        }
    }

    void grpcType(StringAttribute &attribute, const fmuproxy::fmi::StringAttribute &a) {
        if (a.isStart_set()) {
            attribute.set_start(a.getStart());
        }
    }

    void grpcType( BooleanAttribute &attribute, const fmuproxy::fmi::BooleanAttribute &a) {
        if (a.isStart_set()) {
            attribute.set_start(a.getStart());
        }
    }

    void grpcType(EnumerationAttribute &attribute, const fmuproxy::fmi::EnumerationAttribute &a) {
        if (a.isStart_set()) {
            attribute.set_start(a.getStart());
        }
        if (a.isMin_set()) {
            attribute.set_min(a.getMin());
        }
        if (a.isMax_set()) {
            attribute.set_max(a.getMax());
        }
    }

    void grpcType(ScalarVariable &var, const fmuproxy::fmi::ScalarVariable &v) {

        var.set_name(v.name);
        var.set_value_reference(v.valueReference);

        std::string description = v.description;
        if (!description.empty()) {
            var.set_description(description);
        }

        var.set_causality(grpcType(v.causality));
        var.set_variability(grpcType(v.variability));
        var.set_initial(grpcType(v.initial));

        auto attribute = v.attribute;
        if (attribute.isIntegerAttribute()) {
            grpcType(*var.mutable_integer_attribute(), attribute.getIntegerAttribute());
        } else if (attribute.isRealAttribute()) {
            grpcType(*var.mutable_real_attribute(), attribute.getRealAttribute());
        } else if (attribute.isStringAttribute()) {
            grpcType(*var.mutable_string_attribute(), attribute.getStringAttribute());
        } else if (attribute.isBooleanAttribute()) {
            grpcType(*var.mutable_boolean_attribute(), attribute.getBooleanAttribute());
        } else if (attribute.isEnumerationAttribute()) {
            grpcType(*var.mutable_enumeration_attribute(), attribute.getEnumerationAttribute());
        } else {
            throw std::runtime_error("No valid attribute found..");
        }

    }

    void grpcType(ModelDescription &md, const fmuproxy::fmi::ModelDescription &m) {

        md.set_guid(m.guid);
        md.set_version(m.version);
        md.set_fmi_version(m.fmiVersion);
        md.set_model_name(m.modelName);
        md.set_author(m.author);
        md.set_license(m.license);
        md.set_copyright(m.copyright);
        md.set_description(m.description);
        md.set_generation_tool(m.generationTool);
        md.set_generation_date_and_time(m.generationDateAndTime);
        md.set_variable_naming_convention(grpcType(m.variableNamingConvention));
        md.set_supports_co_simulation(true);
        md.set_supports_model_exchange(false);

        auto ex = md.default_experiment();
        ex.set_start_time(m.defaultExperiment.startTime);
        ex.set_stop_time(m.defaultExperiment.stopTime);
        ex.set_tolerance(m.defaultExperiment.tolerance);
        ex.set_step_size(m.defaultExperiment.stepSize);

        for (const fmuproxy::fmi::ScalarVariable &var : m.modelVariables) {
            auto v = md.add_model_variables();
            grpcType(*v, var);
        }

    }

}