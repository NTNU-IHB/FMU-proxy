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

#include <vector>
#include <unordered_map>

#include <fmi4cpp/fmi2/fmi2.hpp>
#include <fmuproxy/heartbeat/heartbeat.hpp>
#include <fmuproxy/heartbeat/remote_address.hpp>
#include "../example_util.hpp"

using namespace std;
using namespace fmuproxy;

int main() {

    const string fmu_path = "../fmus/2.0/cs/20sim/4.6.4.8004/"
                            "ControlledTemperature/ControlledTemperature.fmu";

    auto fmu = fmi4cpp::fmi2::fmi2Fmu(fmu_path);
    const remote_address remote("localhost", 8080);
    
    const unordered_map<string, unsigned int> servers = {{"thrift/tcp", 9090}};
    const vector<string> modelDescriptions = {fmu.getModelDescriptionXml()};
    
    heartbeat beat(remote, servers, modelDescriptions);
    beat.start();

    wait_for_input();
    beat.stop();

    return 0;

}