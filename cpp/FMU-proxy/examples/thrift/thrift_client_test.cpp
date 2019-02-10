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

#include <ctime>
#include <iostream>

#include <fmuproxy/thrift/common/FmuService.h>
#include <fmuproxy/thrift/client/ThriftClient.hpp>

#include "../example_util.hpp"

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
        cout << "GUID=" << md->guid() << endl;
        cout << "modelName=" << md->modelName() << endl;
        cout << "license=" << md->license().value_or("") << endl;

        for (const auto &var : *md->modelVariables()) {
            cout << "Name=" << var.name() << endl;
        }

        auto slave = fmu.newInstance();
        slave->setupExperiment();
        slave->enterInitializationMode();
        slave->exitInitializationMode();
        
        auto elapsed = measure_time_sec([&slave, &md]{
            vector<fmi2Real > ref(2);
            vector<fmi2ValueReference > vr = {md->getValueReference("Temperature_Reference"),
                                              md->getValueReference("Temperature_Room")};

            while ( (slave->getSimulationTime() ) < stop) {
                slave->doStep(step_size);
                slave->readReal(vr, ref);
            }
        });
        
        cout << "elapsed=" << elapsed << "s" << endl;

        bool status = slave->terminate();
        cout << "terminated FMU with success: " << (status ? "true" : "false") << endl;

        fmu.close();

    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }

}
