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
#include <fmuproxy/thrift/common/definitions_types.h>
#include <fmuproxy/thrift/client/ThriftClient.hpp>

#include "ThriftClientHelper.cpp"

using namespace std;
using namespace fmuproxy::thrift::client;

ThriftClient::ThriftClient(const string host, const unsigned int port) {
    shared_ptr<TTransport> socket(new TSocket(host, port));
    this->transport = shared_ptr<TBufferedTransport>(new TBufferedTransport(socket));
    shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
    this->client = shared_ptr<FmuServiceClient>(new FmuServiceClient(protocol));
    this->transport->open();
}

void ThriftClient::get_model_description_xml(std::string &_return) {
    client->getModelDescriptionXml(_return);
}

fmuproxy::fmi::ModelDescription &ThriftClient::get_model_description() {
    if (!modelDescription) {
        fmuproxy::thrift::ModelDescription md = ModelDescription();
        client->getModelDescription(md);
        modelDescription = shared_ptr<fmuproxy::fmi::ModelDescription>(new fmuproxy::fmi::ModelDescription());
        convert(*modelDescription, md);
    }
    return *modelDescription;
}

unique_ptr<RemoteFmuInstance> ThriftClient::new_instance() {
    FmuId fmu_id = client->createInstanceFromCS();
    return unique_ptr<RemoteFmuInstance>(new RemoteFmuInstance(fmu_id, *client, *modelDescription));
}


void ThriftClient::close() {
    this->transport->close();
}



