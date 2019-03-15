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


#include <experimental/filesystem>

#include <fmuproxy/grpc/client/grpc_fmu_client.hpp>
#include <google/protobuf/empty.pb.h>

#include "grpc_client_helper.hpp"
#include "../../util/file_util.hpp"

using namespace std;
using namespace grpc;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::client;

namespace fs = std::experimental::filesystem;

grpc_fmu_client::grpc_fmu_client(const std::string &host, const unsigned int port){
    const auto channel = CreateChannel(host + ":" + to_string(port), InsecureChannelCredentials());
    stub_ = move(FmuService::NewStub(channel));
}

remote_grpc_fmu grpc_fmu_client::fromUrl(const std::string &url) {
    ClientContext ctx;
    Url url_;
    FmuId fmuId;
    url_.set_url(url);
    stub_->LoadFromUrl(&ctx, url_, &fmuId);
    return fromGuid(fmuId.value());
}

remote_grpc_fmu grpc_fmu_client::fromFile(const std::string &file) {

    fs::path p(file);
    std::string name = p.stem().string();

    std::string data;
    read_data(file, data);

    ClientContext ctx;
    File file_;
    FmuId fmuId;
    file_.set_name(name);
    file_.set_data(data);

    stub_->LoadFromFile(&ctx, file_, &fmuId);
    return fromGuid(fmuId.value());
}

remote_grpc_fmu grpc_fmu_client::fromGuid(const std::string &guid) {
    return remote_grpc_fmu(guid, stub_);
}

remote_grpc_fmu::remote_grpc_fmu(const string &fmuId, shared_ptr<FmuService::Stub> stub) : fmuId_(fmuId), stub_(stub) {}

std::shared_ptr<const fmi4cpp::fmi2::ModelDescriptionBase> &remote_grpc_fmu::getModelDescription() {
    if(!modelDescription_) {
        ClientContext ctx;
        GetModelDescriptionRequest request;
        request.set_fmu_id(fmuId_);
        fmuproxy::grpc::ModelDescription md;
        stub_->GetModelDescription(&ctx, request, &md);
        modelDescription_ = std::move(convert(md));
    }
    return modelDescription_;
}

unique_ptr<remote_fmu_slave> remote_grpc_fmu::newInstance() {
    ClientContext ctx;
    InstanceId instance_id;
    CreateInstanceFromCSRequest request;
    request.set_fmu_id(fmuId_);
    stub_->CreateInstanceFromCS(&ctx, request, &instance_id);
    return make_unique<remote_fmu_slave>(instance_id.value(), *stub_, *getModelDescription());
}

