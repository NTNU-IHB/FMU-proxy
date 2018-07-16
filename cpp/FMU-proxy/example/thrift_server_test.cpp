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
#include <thread>

#include <fmuproxy/fmi/Fmu.hpp>
#include <fmuproxy/thrift/server/ThriftServer.hpp>

#include "test_util.cpp"

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::thrift::server;

void wait_for_input(ThriftServer* server) {
    do {
        cout << '\n' << "Press a key to continue...\n";
    } while (cin.get() != '\n');
    cout << "Done." << endl;
    server->stop();
}

int main(int argc, char **argv) {

    int port = 9090;
    string fmu_path = string(getenv("TEST_FMUs"))
                      + "/FMI_2.0/CoSimulation/" + getOs() + "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    Fmu fmu = Fmu(fmu_path);
    ThriftServer server = ThriftServer(fmu, port);

    thread t(wait_for_input, &server);

    cout << "Starting the server..." << endl;
    server.serve();

    t.join();

    return 0;
}

