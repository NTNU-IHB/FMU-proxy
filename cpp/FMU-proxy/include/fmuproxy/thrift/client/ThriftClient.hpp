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

#include "RemoteFmuInstance.hpp"

using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

namespace fmuproxy::thrift::client {

    class ThriftClient {

    private:

        std::shared_ptr<TTransport> transport;
        std::shared_ptr<FmuServiceClient> client;
        std::shared_ptr<fmuproxy::fmi::ModelDescription> modelDescription;

    public:
        ThriftClient(const std::string host, const unsigned int port);

        fmuproxy::fmi::ModelDescription &get_model_description();

        void get_model_description_xml(std::string &_return);

        std::unique_ptr<RemoteFmuInstance> new_instance();

        void close();

        ~ThriftClient() {
            std::cout << "ThriftClient destructor called" << std::endl;
        }

    };

}

#endif //FMU_PROXY_THRIFTCLIENT_H
