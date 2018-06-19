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

#include "../common/thrift-gen/FmuService.h"
#include "../common/thrift-gen/definitions_types.h"

#include "ThriftClient.h"

using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using namespace fmuproxy::thrift;
using namespace fmuproxy::client;

::ThriftClient::ThriftClient(const char* host, int port) {
    shared_ptr<TTransport> socket(new TSocket("localhost", 9090));
    transport = shared_ptr<TBufferedTransport>(new TBufferedTransport(socket));
    shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
    this->client = shared_ptr<FmuServiceClient>(new FmuServiceClient(protocol));
    transport->open();
}

shared_ptr<ModelDescription> ThriftClient::getModelDescription() {
    if (!modelDescription) {
        modelDescription = shared_ptr<ModelDescription>(new ModelDescription());
        client->getModelDescription(*modelDescription);
    }
    return modelDescription;
}

shared_ptr<RemoteFmuInstance> ThriftClient::newInstance() {
    FmuId fmu_id = client->createInstanceFromCS();
    shared_ptr<RemoteFmuInstance> instance(new RemoteFmuInstance(fmu_id, client));
    return instance;
}