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

#include <fmuproxy/grpc/client/GrpcClient.hpp>
#include <google/protobuf/empty.pb.h>
#include "grpc_client_helper.cpp"

using namespace std;
using namespace grpc;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::client;

GrpcClient::GrpcClient(std::string host, unsigned int port) {
    const auto channel = CreateChannel(host + ":" + to_string(port), InsecureChannelCredentials());
    m_stub = move(FmuService::NewStub(channel));
}

fmuproxy::fmi::ModelDescription &GrpcClient::get_model_description() {
    
    if(!m_modelDescription) {
        ClientContext ctx;
        Void empty;
        fmuproxy::grpc::ModelDescription md;
        m_stub->GetModelDescription(&ctx, empty, &md);
        m_modelDescription = std::make_shared<fmuproxy::fmi::ModelDescription>();
        convert(*m_modelDescription, md);
    }
    
    return *m_modelDescription;
}

void GrpcClient::get_model_description_xml(std::string &_return) {
    Str response;
    ClientContext ctx;
    Void empty;
    ::grpc::Status status = m_stub->GetModelDescriptionXml(&ctx, empty, &response);
    _return = response.value();
}

unique_ptr<RemoteFmuInstance> GrpcClient::new_instance() {
    UInt instance_id;
    ClientContext ctx;
    Void empty;
    m_stub->CreateInstanceFromCS(&ctx, empty, &instance_id);
    return make_unique<RemoteFmuInstance>(instance_id.value(), *m_stub, get_model_description());
}

void GrpcClient::close() {
    //nothing to do?
}
