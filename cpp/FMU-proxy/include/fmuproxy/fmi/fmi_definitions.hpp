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

#ifndef FMU_PROXY_FMI_DEFINITIONS_HPP
#define FMU_PROXY_FMI_DEFINITIONS_HPP

#include <iostream>
#include <vector>

#include <fmilib.h>
#include "ScalarVariableAttributes.hpp"

namespace fmuproxy::fmi {

    struct DefaultExperiment {
        double startTime;
        double stopTime;
        double tolerance;
        double stepSize;
    };

    struct Unknown {
        int index;
        std::vector<int> dependencies;
        fmi2_dependency_factor_kind_enu_t dependenciesKind;
    };

    struct ModelStructure {
        std::vector<Unknown> outputs;
        std::vector<Unknown> derivatives;
        std::vector<Unknown> initialUnknowns;
    };

    struct ScalarVariable {
        fmi2_value_reference_t valueReference;
        std::string name;
        std::string description;
        std::string declaredType;
        fmi2_initial_enu_t initial;
        fmi2_causality_enu_t causality;
        fmi2_variability_enu_t variability;
        ScalarVariableAttribute attribute;
    };

    typedef std::vector<ScalarVariable> ModelVariables;

    struct ModelDescription {
        std::string fmiVersion;
        std::string modelName;
        std::string guid;
        std::string license;
        std::string copyright;
        std::string author;
        std::string version;
        std::string description;
        std::string generationTool;
        std::string generationDateAndTime;
        DefaultExperiment defaultExperiment;
        fmi2_variable_naming_convension_enu_t variableNamingConvention;
        ModelVariables modelVariables;
        ModelStructure modelStructure;
        bool supportsCoSimulation;
        bool supportsModelExchange;

        fmi2_value_reference_t get_value_reference(std::string name) {
            for (auto var : modelVariables) {
                if (var.name == name) {
                    return var.valueReference;
                }
            }
            throw std::runtime_error("No such variable: '" + name + "'");
        }

    };


}


#endif //FMU_PROXY_FMI_DEFINITIONS_HPP
