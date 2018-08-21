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

#ifndef FMU_PROXY_GRPCSERVER_HPP
#define FMU_PROXY_GRPCSERVER_HPP

#include <thread>
#include <memory>

#include "../../fmi/Fmu.hpp"
#include "../common/service.grpc.pb.h"
#include "FmuServiceImpl.hpp"

using grpc::Server;

namespace fmuproxy:: grpc::server {

    class GrpcServer {

    private:
        const unsigned int m_port;
        std::shared_ptr<Server> m_server;
        std::unique_ptr<std::thread> m_thread;
        std::shared_ptr<FmuServiceImpl> m_service;

        void wait();

    public:
        GrpcServer(fmuproxy::fmi::Fmu &fmu, unsigned int port);

        void start();

        void stop();

    };

}

#endif //FMU_PROXY_GRPCSERVER_HPP
