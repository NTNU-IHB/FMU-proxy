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
#include <ctime>

#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/transport/TSocket.h>
#include <thrift/transport/TTransportUtils.h>

#include "../common/thrift-gen/FmuService.h"
#include "../common/thrift-gen/definitions_types.h"

#include "../client/thrift/ThriftClient.hpp"

using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using namespace fmuproxy::thrift;
using namespace fmuproxy::client;

const double stop = 10;
const double step_size = 1E-4;

int main() {

    try {

        ThriftClient fmu = ThriftClient("localhost", 9090);

        const auto md = fmu.getModelDescription();
        cout << "GUID=" << md.guid << endl;
        cout << "modelName=" << md.modelName << endl;
        cout << "license=" << md.license << endl;

        int value_reference = fmu.getValueReference("Temperature_Room");

        const auto instance = fmu.newInstance();
        instance->init(0.0, 0.0);

        clock_t begin = clock();

        RealRead read;
        StepResult result;
        while (result.simulationTime < stop) {
            instance->step(result, step_size);
            instance->readReal(read, value_reference);
        }

        clock_t end = clock();

        double elapsed_secs = double(end-begin) / CLOCKS_PER_SEC;
        cout << "elapsed=" << elapsed_secs << "s" << endl;

        auto status = instance->terminate();
        cout << "terminated FMU with status " << status << endl;

        fmu.close();

    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }

}
