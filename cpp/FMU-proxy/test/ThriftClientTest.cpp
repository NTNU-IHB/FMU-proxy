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

#include "../client/ThriftClient.h"

using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using namespace fmuproxy::thrift;
using namespace fmuproxy::client;

const double stop = 20;
const double step_size = 1E-4;

int main() {

    try {

        ThriftClient client = ThriftClient("localhost", 9090);

        shared_ptr<ModelDescription> modelDescription = client.getModelDescription();
        cout << "GUID=" << modelDescription->guid << endl;
        cout << "modelName=" << modelDescription->modelName << endl;
        cout << "license=" << modelDescription->license << endl;

        for (auto var : modelDescription->modelVariables) {
            cout << "name= " << var.name << endl;
        }

        shared_ptr<RemoteFmuInstance> instance = client.newInstance();
        instance->init(0.0, 0.0);

        RealRead read;
        StepResult result;
        while (result.simulationTime < 10) {
            instance->step(result, step_size);
            instance->readReal(read, 47);
        }

        auto status = instance->terminate();
        cout << "terminated FMU with status " << status << endl;

        client.close();

    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }
}
