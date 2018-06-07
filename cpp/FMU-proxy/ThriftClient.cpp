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
#include <thrift/stdcxx.h>

#include "thrift-gen/FmuService.h"
#include "thrift-gen/definitions_types.h"


using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using namespace fmuproxy::thrift;

const double stop = 1;
const double step_size = 1E-4;

int main() {
  stdcxx::shared_ptr<TTransport> socket(new TSocket("localhost", 9090));
  stdcxx::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
  stdcxx::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
  FmuServiceClient client(protocol);

  try {
    transport->open();

    ModelDescription modelDescription;
    client.getModelDescription(modelDescription);
    cout << "GUID=" << modelDescription.guid << endl;
    cout << "modelName=" << modelDescription.modelName << endl;
    cout << "license=" << modelDescription.license << endl;
    cout << "license=" << modelDescription << endl;

    ModelVariables modelVariables = modelDescription.modelVariables;
    cout << modelVariables.size() << endl;

    cout << modelVariables[0] << endl;

    cout << modelDescription.defaultExperiment << endl;

    FmuId id = client.createInstanceFromCS();
    client.init(id, 0.0, 0.0);

    clock_t begin = clock();

    StepResult result;
    while (result.simulationTime < stop) {
        client.step(result, id, step_size);
        RealRead read;
        client.readReal(read, id, 47);
//        cout << "read=" << read.value << endl;
    }

    clock_t end = clock();

    double elapsed_secs = double(end-begin) / CLOCKS_PER_SEC;
    cout << "elapsed=" << elapsed_secs << "s" << endl;

    client.terminate(id);

    transport->close();
  } catch (TException& tx) {
    cout << "ERROR: " << tx.what() << endl;
  }
}
