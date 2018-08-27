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

#ifndef FMU_PROXY_FMISIMULATION_HPP
#define FMU_PROXY_FMISIMULATION_HPP

#include <vector>
#include <memory>
#include <cstdint>
#include <fmilib.h>
#include "fmi_definitions.hpp"

namespace fmuproxy::fmi {

    class FmuInstance {

    protected:

        bool isTerminated_ = false;
        double simulationTime_ = 0.0;
        ModelDescription &modelDescription_;

    public:
        
        explicit FmuInstance(ModelDescription &modelDescription): modelDescription_(modelDescription) {}

        virtual fmi2_real_t getSimulationTime() const {
            return simulationTime_;
        }

        virtual bool isTerminated() const {
            return isTerminated_;
        }

        virtual ModelDescription &getModelDescription() const {
            return modelDescription_;
        }

        fmi2_value_reference_t getValueReference(const std::string &name) const {
            return getModelDescription().getValueReference(name);
        }

        virtual void init(double start = 0, double stop = 0) = 0;

        virtual fmi2_status_t reset() = 0;

        virtual fmi2_status_t terminate() = 0;

        virtual fmi2_status_t readInteger(const fmi2_value_reference_t vr, fmi2_integer_t &ref) = 0;
        virtual fmi2_status_t readInteger(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_integer_t > &ref) = 0;

        virtual fmi2_status_t readReal(const fmi2_value_reference_t vr, fmi2_real_t &ref) = 0;
        virtual fmi2_status_t readReal(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_real_t > &ref) = 0;

        virtual fmi2_status_t readString(const fmi2_value_reference_t vr, fmi2_string_t &ref) = 0;
        virtual fmi2_status_t readString(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_string_t > &ref) = 0;

        virtual fmi2_status_t readBoolean(const fmi2_value_reference_t vr, fmi2_boolean_t &ref) = 0;
        virtual fmi2_status_t readBoolean(const std::vector<fmi2_value_reference_t> &vr, std::vector<fmi2_boolean_t > &ref) = 0;

        virtual fmi2_status_t writeInteger(const fmi2_value_reference_t vr, const fmi2_integer_t value) = 0;
        virtual fmi2_status_t writeInteger(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_integer_t> &value) = 0;

        virtual fmi2_status_t writeReal(const fmi2_value_reference_t vr, const fmi2_real_t value) = 0;
        virtual fmi2_status_t writeReal(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_real_t> &value) = 0;

        virtual fmi2_status_t writeString(const fmi2_value_reference_t vr, const fmi2_string_t value) = 0;
        virtual fmi2_status_t writeString(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_string_t> &value) = 0;

        virtual fmi2_status_t writeBoolean(const fmi2_value_reference_t vr, const fmi2_boolean_t value) = 0;
        virtual fmi2_status_t writeBoolean(const std::vector<fmi2_value_reference_t> &vr, const std::vector<fmi2_boolean_t> &value) = 0;

        virtual bool canGetAndSetFMUstate() const = 0;

        virtual bool canSerializeFMUstate() const = 0;

        virtual fmi2_status_t getFMUstate(int64_t &state) = 0;

        virtual fmi2_status_t setFMUstate(const int64_t state) = 0;

        virtual fmi2_status_t freeFMUstate(int64_t &state) = 0;

        virtual fmi2_status_t serializeFMUstate(const int64_t state, std::string &serializedState) = 0;

        virtual fmi2_status_t deSerializeFMUstate(const std::string serializedState, int64_t &state) = 0;

        virtual ~FmuInstance(){}

    };

}

#endif //FMU_PROXY_FMISIMULATION_HPP
