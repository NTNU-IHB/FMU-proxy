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

#ifndef FMU_PROXY_THRIFTSERVER_H
#define FMU_PROXY_THRIFTSERVER_H

#include <unordered_map>
#include <thread>
#include <thrift/server/TSimpleServer.h>
#include "../common/service_types.h"
#include "../../fmi/Fmu.hpp"
#include "FmuServiceHandler.hpp"

namespace fmuproxy::thrift::server {
        
    class ThriftServer {

    private:
        const bool http_;
        const unsigned int port_;
        std::unique_ptr<std::thread> thread_;
        std::unique_ptr<apache::thrift::server::TSimpleServer> server_;

        void serve();

    public:
        ThriftServer(std::unordered_map<fmuproxy::thrift::FmuId,
                std::shared_ptr<fmuproxy::fmi::Fmu>> &fmus,
                const unsigned int port, const bool http=false);

        void start();

        void stop();

    };

}

#endif //FMU_PROXY_THRIFTSERVER_H
