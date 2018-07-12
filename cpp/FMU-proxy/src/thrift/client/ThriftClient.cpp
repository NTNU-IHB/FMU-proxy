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

#include "../thrift-gen/FmuService.h"
#include "../thrift-gen/definitions_types.h"

#include "ThriftClient.hpp"

using namespace std;
using namespace fmuproxy::thrift::client;

ThriftClient::ThriftClient(string host, int port) {
    shared_ptr<TTransport> socket(new TSocket("localhost", 9090));
    this->transport = shared_ptr<TBufferedTransport>(new TBufferedTransport(socket));
    shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
    this->client = shared_ptr<FmuServiceClient>(new FmuServiceClient(protocol));
    this->transport->open();
}

void ThriftClient::close() {
    this->transport->close();
}

ModelDescription &ThriftClient::getModelDescription() {
    if (!modelDescription) {
        modelDescription = shared_ptr<ModelDescription>(new ModelDescription());
        client->getModelDescription(*modelDescription);
    }
    return *modelDescription;
}

unique_ptr<RemoteFmuInstance> ThriftClient::newInstance() {
    FmuId fmu_id = client->createInstanceFromCS();
    return unique_ptr<RemoteFmuInstance>(new RemoteFmuInstance(fmu_id, *client));
}

unsigned int ThriftClient::getValueReference(std::string variableName) {

    for (ScalarVariable var : modelDescription->modelVariables) {
        if (var.name == variableName) {
            return var.valueReference;
        }
    }
    throw std::runtime_error("No such variable: '" + variableName + "'");

}

