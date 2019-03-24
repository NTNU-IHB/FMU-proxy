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
#include <thrift/protocol/TCompactProtocol.h>
#include <thrift/transport/TTransportUtils.h>

#include <fmuproxy/thrift/common/fmu_service.h>
#include <fmuproxy/thrift/client/thrift_client.hpp>

#include "thrift_client_helper.hpp"
#include "../../util/file_util.hpp"

using namespace std;
using namespace apache::thrift::transport;
using namespace apache::thrift::protocol;
using namespace fmuproxy::thrift::client;

thrift_client::thrift_client(const string &host, const unsigned int port) {
    shared_ptr<TTransport> socket(new TSocket(host, port));
    transport_ = std::make_shared<TFramedTransport>(socket);
    shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport_));
    client_ = std::make_shared<fmu_serviceClient>(protocol);
    transport_->open();
}

remote_thrift_fmu thrift_client::from_url(const std::string &url) {
    FmuId guid;
    client_->load_from_url(guid, url);
    return remote_thrift_fmu(guid, client_);
}

remote_thrift_fmu thrift_client::from_file(const std::string &file) {

    fs::path p(file);
    std::string name = p.stem().string();

    std::string data;
    read_data(file, data);

    FmuId guid;
    client_->load_from_file(guid, name, data);
    return remote_thrift_fmu(guid, client_);
}

remote_thrift_fmu thrift_client::from_guid(const std::string &guid) {
    return remote_thrift_fmu(guid, client_);
}

void thrift_client::close() {
    if (transport_->isOpen()) {
       transport_->close();
    }
}

thrift_client::~thrift_client() {
    close();
}

remote_thrift_fmu::remote_thrift_fmu(const FmuId &fmuId, shared_ptr<fmu_serviceClient> client) : fmuId_(fmuId),
                                                                                            client_(std::move(client)) {}

shared_ptr<const fmi4cpp::fmi2::model_description_base> &remote_thrift_fmu::getModelDescription() {
    if (!modelDescription_) {
        fmuproxy::thrift::ModelDescription md = ModelDescription();
        client_->get_model_description(md, fmuId_);
        modelDescription_ = std::move(convert(md));
    }
    return modelDescription_;
}

unique_ptr<remote_fmu_slave> remote_thrift_fmu::newInstance() {
    InstanceId instance_id;
    client_->create_instance_from_cs(instance_id, fmuId_);
    return std::make_unique<remote_fmu_slave>(instance_id, *client_, *getModelDescription());
}
