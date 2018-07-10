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

#ifndef FMU_PROXY_THRIFTCLIENT_H
#define FMU_PROXY_THRIFTCLIENT_H


#include <thrift/transport/TSocket.h>
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/transport/TTransportUtils.h>

#include "../../common/thrift-gen/FmuService.h"

using namespace apache::thrift;
using namespace fmuproxy::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

namespace fmuproxy {
    namespace client {

        class RemoteFmuInstance {

        private:
            FmuId fmu_id;
            double current_time;
            std::shared_ptr<FmuServiceClient> client;

        public:
            RemoteFmuInstance(FmuId fmu_id, std::shared_ptr<FmuServiceClient> client) {
                this->fmu_id = fmu_id;
                this->client = client;

                current_time = client->getCurrentTime(fmu_id);

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

            void readInteger(IntegerArrayRead& read, ValueReferences vr);

            void readReal(RealRead &read, ValueReference vr);

            void readReal(RealArrayRead& read, ValueReferences vr);

            void readString(StringRead &read, ValueReference vr);

            void readString(StringArrayRead &read, ValueReferences vr);

            void readBoolean(BooleanRead &read, ValueReference vr);

            void readBoolean(BooleanArrayRead &read, ValueReferences vr);

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

        class ThriftClient {

        private:

            std::shared_ptr<TTransport> transport;
            std::shared_ptr<FmuServiceClient> client;

            std::shared_ptr<ModelDescription> modelDescription;

        public:
            ThriftClient(const char* host, int port);

            std::shared_ptr<ModelDescription> getModelDescription();

            std::shared_ptr<RemoteFmuInstance> newInstance();

            void close() {
                transport->close();
            }

            int getValueReference(std::string variableName) {

                for (ScalarVariable var : getModelDescription()->modelVariables) {
                    if (var.name == variableName) {
                        return var.valueReference;
                    }
                }
                throw std::runtime_error("No such variable: '" + variableName + "'");

            }

            ~ThriftClient() {
                std::cout << "ThriftClient destructor called" << std::endl;
            }

        };

    }
}

#endif //FMU_PROXY_THRIFTCLIENT_H
