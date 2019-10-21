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


#include "../../util/file_util.hpp"
#include "grpc_client_helper.hpp"

#include <fmuproxy/grpc/client/grpc_fmu_client.hpp>

#include <boost/filesystem.hpp>
#include <utility>

using namespace grpc;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::client;

namespace fs = boost::filesystem;

grpc_fmu_client::grpc_fmu_client(const std::string& host, const unsigned int port)
{
    const auto channel = CreateChannel(host + ":" + to_string(port), InsecureChannelCredentials());
    stub_ = move(FmuService::NewStub(channel));
}

remote_grpc_fmu grpc_fmu_client::from_url(const std::string& url)
{
    ClientContext ctx;
    Url url_;
    FmuId fmuId;
    url_.set_url(url);
    stub_->LoadFromUrl(&ctx, url_, &fmuId);
    return from_guid(fmuId.value());
}

remote_grpc_fmu grpc_fmu_client::from_file(const std::string& file)
{
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
    return from_guid(fmuId.value());
}

remote_grpc_fmu grpc_fmu_client::from_guid(const std::string& guid)
{
    return remote_grpc_fmu(guid, stub_);
}

remote_grpc_fmu::remote_grpc_fmu(string  fmuId, std::shared_ptr<FmuService::Stub> stub)
    : fmuId_(std::move(fmuId))
    , stub_(std::move(stub))
{}

std::shared_ptr<const fmi4cpp::fmi2::cs_model_description>& remote_grpc_fmu::getModelDescription()
{
    if (modelDescription_ == nullptr) {
        ClientContext ctx;
        GetModelDescriptionRequest request;
        request.set_fmu_id(fmuId_);
        fmuproxy::grpc::ModelDescription md;
        stub_->GetModelDescription(&ctx, request, &md);
        modelDescription_ = std::move(convert(md));
    }
    return modelDescription_;
}

std::unique_ptr<remote_fmu_slave> remote_grpc_fmu::newInstance()
{
    ClientContext ctx;
    InstanceId instance_id;
    CreateInstanceRequest request;
    request.set_fmu_id(fmuId_);
    stub_->CreateInstance(&ctx, request, &instance_id);
    return std::make_unique<remote_fmu_slave>(instance_id.value(), *stub_, getModelDescription());
}
