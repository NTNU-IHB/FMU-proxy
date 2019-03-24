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
#include <utility>

#include <fmuproxy/thrift/server/thrift_fmu_server.hpp>

#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TNonblockingServerSocket.h>
#include <thrift/transport/THttpTransport.h>
#include <thrift/transport/TTransportUtils.h>
#include <thrift/transport/THttpServer.h>
#include <thrift/protocol/TJSONProtocol.h>
#include <thrift/protocol/TCompactProtocol.h>
#include <thrift/concurrency/ThreadManager.h>
#include <thrift/server/TThreadedServer.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/server/TNonblockingServer.h>

using namespace fmuproxy::thrift;
using namespace fmuproxy::thrift::server;

using namespace ::apache::thrift;
using namespace ::apache::thrift::server;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::concurrency;

thrift_fmu_server::thrift_fmu_server(std::unordered_map<FmuId, std::shared_ptr<fmi4cpp::fmi2::fmu>> &fmus,
                           unsigned int port, bool http, bool multiThreaded) : port_(port), http_(http) {

    std::shared_ptr<fmu_service_handler> handler(new fmu_service_handler(fmus));
    std::shared_ptr<TProcessor> processor(new fmu_serviceProcessor(handler));

    if (http) {

        std::shared_ptr<TTransportFactory> transportFactory(new THttpServerTransportFactory());
        std::shared_ptr<TProtocolFactory> protocolFactory(new TJSONProtocolFactory());
        if (multiThreaded) {
            std::shared_ptr<TNonblockingServerTransport> serverTransport(new TNonblockingServerSocket(port));
            server_= std::make_unique<TNonblockingServer>(processor, protocolFactory, serverTransport);
        } else {
            std::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
            server_ = std::make_unique<TSimpleServer>(processor, serverTransport, transportFactory, protocolFactory);
        }

    } else {

        std::shared_ptr<TTransportFactory> transportFactory(new TFramedTransportFactory());
        std::shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());
        if (multiThreaded) {
            std::shared_ptr<TNonblockingServerTransport> serverTransport(new TNonblockingServerSocket(port));
            auto server = std::make_unique<TNonblockingServer>(processor, protocolFactory, serverTransport);
            server->setNumIOThreads(15);
            server_ = std::move(server);
        } else {
            std::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
            server_ = std::make_unique<TSimpleServer>(processor, serverTransport, transportFactory, protocolFactory);
        }

    }

}

void thrift_fmu_server::serve() {
    server_->serve();
}

void thrift_fmu_server::start() {
    std::cout << "Thrift " << (http_ ? "HTTP" : "TCP/IP") << " server listening to connections on port: " << std::to_string(port_) << std::endl;
    thread_ = std::make_unique<std::thread>(&thrift_fmu_server::serve, this);
}

void thrift_fmu_server::stop() {
    server_->stop();
    thread_->join();
    std::cout << "Thrift " << (http_ ? "HTTP" : "TCP/IP") << " server stopped.." << std::endl;
}
