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

#include <unordered_map>
#include <fmuproxy/thrift/server/thrift_fmu_server.hpp>

#include "../example_util.hpp"

using namespace std;
using namespace fmi4cpp::fmi2;
using namespace fmuproxy::thrift::server;

int main(int argc, char **argv) {

    auto fmu1 = make_shared<fmi2Fmu>("../fmus/2.0/cs/20sim/4.6.4.8004/"
                                                   "ControlledTemperature/ControlledTemperature.fmu");

    auto fmu2 = make_shared<fmi2Fmu>("../fmus/2.0/me/Test-FMUs/0.0.1/"
                                                    "VanDerPol/VanDerPol.fmu");

    unordered_map<string, shared_ptr<fmi2Fmu>> fmus = {
            {fmu1->getModelDescription()->guid, fmu1},
            {fmu2->getModelDescription()->guid, fmu2}
    };

    thrift_fmu_server socket_server(fmus, 9090, false, true);
    socket_server.start();

    thrift_fmu_server http_server(fmus, 9091, true);
    http_server.start();

    wait_for_input();

    socket_server.stop();
    http_server.stop();

    return 0;
}
