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
#include "../thrift-gen/FmuService.h"

using namespace fmuproxy::thrift;

namespace fmuproxy::thrift::client {

    class RemoteFmuInstance {

    private:
        FmuId fmu_id;
        double current_time;
        FmuServiceClient &client;

    public:
        RemoteFmuInstance(FmuId fmu_id, FmuServiceClient &client): fmu_id(fmu_id), client(client) {
            current_time = client.getCurrentTime(fmu_id);
        }

        double getCurrentTime() {
            return current_time;
        }

        Status::type init() {
            return init(0.0, 0.0);
        }

        Status::type init(double start) {
            return init(start, 0.0);
        }

        Status::type init(double start, double stop);

        Status::type step(StepResult& result, double step_size);

        Status::type terminate();

        Status::type reset();

        void readInteger(IntegerRead& read, ValueReference vr);

        void readInteger(BulkIntegerRead& read, ValueReferences vr);

        void readReal(RealRead &read, ValueReference vr);

        void readReal(BulkRealRead& read, ValueReferences vr);

        void readString(StringRead &read, ValueReference vr);

        void readString(BulkStringRead &read, ValueReferences vr);

        void readBoolean(BooleanRead &read, ValueReference vr);

        void readBoolean(BulkBooleanRead &read, ValueReferences vr);

        Status::type writeInteger(ValueReference vr, int value);

        Status::type writeInteger(ValueReferences vr, IntArray value);

        Status::type writeReal(ValueReference vr, double value);

        Status::type writeReal(ValueReferences vr, RealArray value);

        Status::type writeString(ValueReference vr, std::string value);

        Status::type writeString(ValueReferences vr, StringArray value);

        Status::type writeBoolean(ValueReference vr, bool value);

        Status::type writeBoolean(ValueReferences vr, BooleanArray value);

        ~RemoteFmuInstance() {
            std::cout << "RemoteFmuInstance destructor called" << std::endl;
        }

    };

}


#endif //FMU_PROXY_REMOTEFMUINSTANCE_HPP
