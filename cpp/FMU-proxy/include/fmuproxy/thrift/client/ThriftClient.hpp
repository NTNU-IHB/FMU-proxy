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

#include "RemoteFmuSlave.hpp"

namespace fmuproxy::thrift::client {

    class RemoteThriftFmu {

    private:

        const FmuId fmuId_;
        std::shared_ptr<FmuServiceClient> client_;
        std::shared_ptr<fmi4cpp::fmi2::ModelDescriptionBase> modelDescription_;

    public:

        RemoteThriftFmu(const FmuId &fmuId, std::shared_ptr<FmuServiceClient> client);

        std::shared_ptr<fmi4cpp::fmi2::ModelDescriptionBase> &getModelDescription();

        std::unique_ptr<RemoteFmuSlave> newInstance();

    };

    class ThriftClient {

    private:

        std::shared_ptr<FmuServiceClient> client_;
        std::shared_ptr<apache::thrift::transport::TTransport> transport_;


    public:
        ThriftClient(const std::string &host, unsigned int port);

        RemoteThriftFmu fromUrl(const std::string &url);

        RemoteThriftFmu fromGuid(const std::string &guid);

        void close();

        virtual ~ThriftClient();

    };

}

#endif //FMU_PROXY_THRIFTCLIENT_H
