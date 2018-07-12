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

    class RemoteFmuInstance {

    private:
        FmuId fmu_id;
        double current_time;
        FmuServiceClient &client;

    public:
        RemoteFmuInstance(FmuId fmu_id, FmuServiceClient &client);

        double getCurrentTime();

        fmi2_status_t init();

        fmi2_status_t init(double start);

        fmi2_status_t init(double start, double stop);

        fmi2_status_t step(StepResult& result, double step_size);

        fmi2_status_t terminate();

        fmi2_status_t reset();

        fmi2_status_t readInteger(IntegerRead& read, unsigned int vr);

        void readInteger(BulkIntegerRead& read, ValueReferences vr);

        void readReal(RealRead &read, ValueReference vr);

        void readReal(BulkRealRead& read, ValueReferences vr);

        void readString(StringRead &read, ValueReference vr);

        void readString(BulkStringRead &read, ValueReferences vr);

        void readBoolean(BooleanRead &read, ValueReference vr);

        void readBoolean(BulkBooleanRead &read, ValueReferences vr);

        fmi2_status_t writeInteger(ValueReference vr, int value);

        fmi2_status_t writeInteger(ValueReferences vr, IntArray value);

        fmi2_status_t writeReal(ValueReference vr, double value);

        fmi2_status_t writeReal(ValueReferences vr, RealArray value);

        fmi2_status_t writeString(ValueReference vr, std::string value);

        fmi2_status_t writeString(ValueReferences vr, StringArray value);

        fmi2_status_t writeBoolean(ValueReference vr, bool value);

        fmi2_status_t writeBoolean(ValueReferences vr, BooleanArray value);

        ~RemoteFmuInstance() {
            std::cout << "RemoteFmuInstance destructor called" << std::endl;
        }

    };

}


#endif //FMU_PROXY_REMOTEFMUINSTANCE_HPP
