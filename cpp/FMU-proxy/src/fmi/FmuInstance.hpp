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

#ifndef FMU_PROXY_FMUINSTANCE_HPP
#define FMU_PROXY_FMUINSTANCE_HPP

#include <iostream>
#include <fmilib.h>
#include "FmiSimulation.hpp"
#include "FmuVariableAccess.hpp"

namespace fmuproxy::fmi {

    class FmuInstance: public FmiSimulation {

    private:

        fmi2_import_t *instance;
        ModelDescription &modelDescription;

        double current_time = 0.0;
        bool terminated = false;

    public:
        FmuInstance(fmi2_import_t* instance, ModelDescription &md);

        bool isTerminated();

        double getCurrentTime() const override;

        ModelDescription &getModelDescription() const override;

        void init() override;

        void init(double start) override;

        void init(double start, double stop) override;

        fmi2_status_t step(double step_size) override;

        fmi2_status_t reset() override;

        fmi2_status_t terminate() override;

        fmi2_status_t readInteger(fmi2_value_reference_t vr, fmi2_integer_t &ref) override;
        fmi2_status_t readInteger(std::string name, fmi2_integer_t &ref);

        fmi2_status_t writeInteger(fmi2_value_reference_t vr, fmi2_integer_t value) override;

        fmi2_status_t readReal(fmi2_value_reference_t vr, fmi2_real_t &ref) override;
        fmi2_status_t readReal(std::string name, fmi2_real_t &ref);

        fmi2_status_t writeReal(fmi2_value_reference_t vr, fmi2_real_t value) override;

        fmi2_status_t readString(fmi2_value_reference_t vr, fmi2_string_t &ref) override;
        fmi2_status_t readString(std::string name, fmi2_string_t &ref);

        fmi2_status_t writeString(fmi2_value_reference_t vr, fmi2_string_t value) override;

        fmi2_status_t readBoolean(fmi2_value_reference_t vr, fmi2_boolean_t &ref) override;
        fmi2_status_t readBoolean(std::string name, fmi2_boolean_t &ref);

        fmi2_status_t writeBoolean(fmi2_value_reference_t vr, fmi2_boolean_t value) override;

        VariableReader getReader(fmi2_value_reference_t vr) const;

        VariableReader getReader(std::string name) const;

        VariableWriter getWriter(fmi2_value_reference_t vr) const;

        VariableWriter getWriter(std::string name) const;

        fmi2_value_reference_t get_value_reference(std::string name) const;

        ~FmuInstance();

    };

}

#endif //FMU_PROXY_FMUINSTANCE_HPP
