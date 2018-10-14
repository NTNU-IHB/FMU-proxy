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
#include "grpc_client_helper.hpp"

using namespace std;
using namespace grpc;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::client;

GrpcClient::GrpcClient(const string fmu_id, const std::string host, const unsigned int port) : fmuId_(fmu_id) {
    const auto channel = CreateChannel(host + ":" + to_string(port), InsecureChannelCredentials());
    stub_ = move(FmuService::NewStub(channel));
}

fmuproxy::fmi::ModelDescription &GrpcClient::getModelDescription() {
    if(!modelDescription_) {
        ClientContext ctx;
        GetModelDescriptionRequest request;
        request.set_fmu_id(fmuId_);
        fmuproxy::grpc::ModelDescription md;
        stub_->GetModelDescription(&ctx, request, &md);
        modelDescription_ = std::make_shared<fmuproxy::fmi::ModelDescription>();
        copyToFrom(*modelDescription_, md);
    }
    return *modelDescription_;
}

unique_ptr<RemoteFmuSlave> GrpcClient::newInstance() {
    ClientContext ctx;
    InstanceId instance_id;
    CreateInstanceFromCSRequest request;
    request.set_fmu_id(fmuId_);
    stub_->CreateInstanceFromCS(&ctx, request, &instance_id);
    return make_unique<RemoteFmuSlave>(instance_id.value(), *stub_, getModelDescription());
}

void GrpcClient::close() {
    //nothing to do?
}
