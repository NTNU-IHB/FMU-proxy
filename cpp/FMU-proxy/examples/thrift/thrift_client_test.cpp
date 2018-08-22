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

#include <fmuproxy/thrift/common/FmuService.h>

#include <fmuproxy/thrift/client/ThriftClient.hpp>

using namespace std;
using namespace apache::thrift;

using namespace fmuproxy::thrift;
using namespace fmuproxy::thrift::client;

const double stop = 2;
const double step_size = 1E-2;

int main() {

    try {

        ThriftClient fmu("{06c2700b-b39c-4895-9151-304ddde28443}", "localhost", 9090);

        const auto md = fmu.getModelDescription();
        cout << "GUID=" << md.guid << endl;
        cout << "modelName=" << md.modelName << endl;
        cout << "license=" << md.license << endl;

        for (const auto var : md.modelVariables) {
            cout << "Name=" << var.name << ", " << var.attribute << endl;
        }

        auto instance = fmu.newInstance();
        instance->init();

        auto begin = clock();

        vector<fmi2_real_t> ref(2);
        vector<fmi2_value_reference_t> vr = {instance->getValueReference("Temperature_Reference"),
                                             instance->getValueReference("Temperature_Room")};

        double t;
        while ( (t=instance->getSimulationTime() ) < stop) {
            instance->step(step_size);
            instance->readReal(vr, ref);
            cout << "t=" << t << ", Temperature_Reference=" << ref[0] <<  ", Temperature_Room=" << ref[1] << endl;
        }

        auto end = clock();

        double elapsed_secs = double(end-begin) / CLOCKS_PER_SEC;
        cout << "elapsed=" << elapsed_secs << "s" << endl;

        auto status = instance->terminate();
        cout << "terminated FMU with status " << fmi2_status_to_string(status) << endl;

        fmu.close();

    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }

}
