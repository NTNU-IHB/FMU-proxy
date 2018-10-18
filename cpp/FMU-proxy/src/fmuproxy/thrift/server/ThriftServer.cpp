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

#include <fmuproxy/thrift/server/ThriftServer.hpp>

#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/THttpTransport.h>
#include <thrift/transport/TBufferTransports.h>
#include <thrift/transport/THttpServer.h>
#include <thrift/protocol/TJSONProtocol.h>

using namespace std;
using namespace fmuproxy::thrift;
using namespace fmuproxy::thrift::server;

using namespace ::apache::thrift;
using namespace ::apache::thrift::server;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;

ThriftServer::ThriftServer(unordered_map<FmuId, std::shared_ptr<fmi4cpp::fmi2::Fmu>> &fmus, const unsigned int port, const bool http): port_(port), http_(http) {

    shared_ptr<FmuServiceHandler> handler(new FmuServiceHandler(fmus));
    shared_ptr<TProcessor> processor(new FmuServiceProcessor(handler));
    shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));

    shared_ptr<TTransportFactory> transportFactory;
    shared_ptr<TProtocolFactory> protocolFactory;
    if (http) {
        shared_ptr<TTransportFactory> transportFactory(new THttpServerTransportFactory());
        shared_ptr<TProtocolFactory> protocolFactory(new TJSONProtocolFactory());
        server_ = std::make_unique<TSimpleServer>(processor, serverTransport, transportFactory, protocolFactory);
    } else {
        shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
        shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());
        server_ = std::make_unique<TSimpleServer>(processor, serverTransport, transportFactory, protocolFactory);
    }

}

void ThriftServer::serve() {
    server_->serve();
}

void ThriftServer::start() {
    cout << "Thrift server listening to connections on port: " << port_ << endl;
    thread_ = std::make_unique<thread>(&ThriftServer::serve, this);
}

void ThriftServer::stop() {
    server_->stop();
    thread_->join();
    cout << "Thrift " << (http_ ? "HTTP" : "TCP/IP") << " server stopped.." << endl;
}
