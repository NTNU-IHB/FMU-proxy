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

#include <grpcpp/grpcpp.h>

#include <fmuproxy/grpc/server/GrpcServer.hpp>
#include <memory>

using grpc::Server;
using grpc::ServerBuilder;

using namespace std;
using namespace fmuproxy::grpc::server;

GrpcServer::GrpcServer(fmuproxy::fmi::Fmu &fmu, const unsigned int port)
        : m_port(port) {

    m_service = make_shared<FmuServiceImpl>(fmu);
}

void GrpcServer::wait() {
    m_server->Wait();
}

void GrpcServer::start() {

    cout << "Grpc server listening to connections on port: " << m_port << endl;
    ServerBuilder builder;
    builder.AddListeningPort("localhost:" + to_string(m_port), ::grpc::InsecureServerCredentials());
    builder.RegisterService(m_service.get());
    m_server = move(builder.BuildAndStart());
    m_thread = make_unique<thread>(&GrpcServer::wait, this);
}

void GrpcServer::stop() {
    m_server->Shutdown();
    m_thread->join();
}
