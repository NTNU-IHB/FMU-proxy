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

#include <iostream>

#include <thrift/transport/TSocket.h>
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/transport/TTransportUtils.h>

#include <fmuproxy/thrift/common/FmuService.h>
#include <fmuproxy/thrift/client/ThriftClient.hpp>
#include "thrift_client_helper.hpp"

using namespace std;
using namespace apache::thrift::transport;
using namespace apache::thrift::protocol;
using namespace fmuproxy::thrift::client;

ThriftClient::ThriftClient(const string fmu_id, const string host, const unsigned int port) : fmuId_(fmu_id) {
    shared_ptr<TTransport> socket(new TSocket(host, port));
    this->transport_ = std::make_shared<TBufferedTransport>(socket);
    shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport_));
    this->client_ = std::make_shared<FmuServiceClient>(protocol);
    this->transport_->open();
}


fmuproxy::fmi::ModelDescription &ThriftClient::getModelDescription() {
    if (!modelDescription_) {
        fmuproxy::thrift::ModelDescription md = ModelDescription();
        client_->getModelDescription(md, fmuId_);
        modelDescription_ = std::make_shared<fmuproxy::fmi::ModelDescription>();
        copyToFrom(*modelDescription_, md);
    }
    return *modelDescription_;
}

unique_ptr<RemoteFmuSlave> ThriftClient::newInstance() {
    InstanceId instance_id;
    client_->createInstanceFromCS(instance_id, fmuId_);
    return std::make_unique<RemoteFmuSlave>(instance_id, *client_, *modelDescription_);
}

void ThriftClient::close() {
    this->transport_->close();
}
