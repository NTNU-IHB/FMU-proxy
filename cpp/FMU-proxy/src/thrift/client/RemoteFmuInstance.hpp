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

#ifndef FMU_PROXY_REMOTEFMUINSTANCE_HPP
#define FMU_PROXY_REMOTEFMUINSTANCE_HPP

#include <iostream>
#include <fmilib.h>
#include "../thrift-gen/FmuService.h"
#include "../../fmi/FmiSimulation.hpp"

using namespace fmuproxy::thrift;

namespace fmuproxy::thrift::client {

    class RemoteFmuInstance: public fmuproxy::fmi::FmiSimulation {

    private:
        FmuId fmu_id;
        double current_time;
        FmuServiceClient &client;
        fmuproxy::fmi::ModelDescription &modelDescription;

        IntegerRead integerRead;
        RealRead realRead;
        StringRead stringRead;
        BooleanRead booleanRead;
        StepResult stepResult;

    public:
        RemoteFmuInstance(FmuId fmu_id, FmuServiceClient &client, fmuproxy::fmi::ModelDescription &modelDescription);

        double getCurrentTime() const override;

        fmuproxy::fmi::ModelDescription &getModelDescription() const override;

        void init() override;

        void init(double start) override;

        void init(double start, double stop) override;

        fmi2_status_t step(double step_size) override;

        fmi2_status_t terminate() override;

        fmi2_status_t reset() override;

        fmi2_status_t readInteger(unsigned int vr, int &ref) override;

        fmi2_status_t readReal(unsigned int vr, double &ref) override;

        fmi2_status_t readString(unsigned int vr, const char* &ref) override;

        fmi2_status_t readBoolean(unsigned int vr, int &ref) override;

        fmi2_status_t writeInteger(unsigned int vr, int value) override;

        fmi2_status_t writeReal(unsigned int vr, double value) override;

        fmi2_status_t writeString(unsigned int vr, const char* value) override;

        fmi2_status_t writeBoolean(unsigned int vr, int value) override;

        ~RemoteFmuInstance() {
            std::cout << "RemoteFmuInstance destructor called" << std::endl;
        }

    };

}

#endif //FMU_PROXY_REMOTEFMUINSTANCE_HPP
