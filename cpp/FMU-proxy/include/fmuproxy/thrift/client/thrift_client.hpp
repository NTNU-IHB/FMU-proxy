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

#include "remote_fmu_slave.hpp"

namespace fmuproxy::thrift::client {

    class remote_thrift_fmu {

    private:

        const FmuId fmuId_;
        std::shared_ptr<FmuServiceClient> client_;
        std::shared_ptr<const fmi4cpp::fmi2::model_description_base> modelDescription_;

    public:

        remote_thrift_fmu(const FmuId &fmuId, std::shared_ptr<FmuServiceClient> client);

        std::shared_ptr<const fmi4cpp::fmi2::model_description_base> &getModelDescription();

        std::unique_ptr<remote_fmu_slave> newInstance();

    };

    class thrift_client {

    private:

        std::shared_ptr<FmuServiceClient> client_;
        std::shared_ptr<apache::thrift::transport::TTransport> transport_;


    public:

        thrift_client(const std::string &host, unsigned int port);

        remote_thrift_fmu from_url(const std::string &url);

        remote_thrift_fmu from_file(const std::string &file);

        remote_thrift_fmu from_guid(const std::string &guid);

        void close();

        virtual ~thrift_client();

    };

}

#endif //FMU_PROXY_THRIFTCLIENT_H
