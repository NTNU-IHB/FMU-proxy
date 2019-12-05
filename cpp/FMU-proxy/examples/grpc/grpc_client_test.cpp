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


#include <fmuproxy/grpc/client/grpc_fmu_client.hpp>

#include "../example_util.hpp"

using namespace fmuproxy::grpc::client;

int main() {

    auto client = grpc_fmu_client("localhost", 9080);

    auto fmu = client.from_guid("{06c2700b-b39c-4895-9151-304ddde28443}");
    fmuproxy::run_slave(fmu.newInstance());


    auto remote_fmu = client.from_file("../fmus/2.0/cs/20sim/4.6.4.8004/"
                                       "ControlledTemperature/ControlledTemperature.fmu");
    fmuproxy::run_slave(remote_fmu.newInstance());

    return 0;

}
