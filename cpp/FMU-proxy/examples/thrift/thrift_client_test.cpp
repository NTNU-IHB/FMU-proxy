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

#include <fmi4cpp/fmi2/fmi2.hpp>

#include <fmuproxy/thrift/common/fmu_service.h>
#include <fmuproxy/thrift/client/thrift_client.hpp>

#include "../example_util.hpp"

using namespace std;
using namespace apache::thrift;

using namespace fmuproxy::thrift;
using namespace fmuproxy::thrift::client;

const double stop = 2;
const double step_size = 1E-2;

void run_slave(unique_ptr<fmi4cpp::FmuSlave<fmi4cpp::fmi2::CoSimulationModelDescription>> slave) {

    auto md = slave->getModelDescription();

    cout << "GUID=" << md->guid << endl;
    cout << "modelName=" << md->modelName << endl;
    cout << "license=" << md->license.value_or("-") << endl;

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
}

int main() {

    try {

        thrift_client client("localhost", 9090);

        auto fmu = client.fromGuid("{06c2700b-b39c-4895-9151-304ddde28443}");
        run_slave(fmu.newInstance());


        auto remote_fmu = client.fromFile("../fmus/2.0/cs/20sim/4.6.4.8004/"
                                          "ControlledTemperature/ControlledTemperature.fmu");
        run_slave(remote_fmu.newInstance());

        client.close();

    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }

}
