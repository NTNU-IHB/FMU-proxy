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
#include <vector>
#include <iostream>

#include "../example_util.hpp"
#include <fmi4cpp/fmi2/fmi2.hpp>

using namespace std;
using namespace fmi4cpp::fmi2;

const double start = 0.0;
const double stop = 10.0;
const double step_size = 1E-4;

int main(int argc, char **argv) {

    const string fmu_path = "../fmus/2.0/cs/20sim/4.6.4.8004/"
                            "ControlledTemperature/ControlledTemperature.fmu";

    auto fmu = fmi2Fmu(fmu_path).asCoSimulationFmu();
    auto slave = fmu->newInstance();
    auto md = slave->getModelDescription();
    slave->setupExperiment();
    slave->enterInitializationMode();
    slave->exitInitializationMode();

    clock_t begin = clock();

    vector<fmi2Real > ref(2);
    vector<fmi2ValueReference > vr = {md->getValueReference("Temperature_Reference"),
                                      md->getValueReference("Temperature_Room")};

    double t;
    while ( (t = slave->getSimulationTime() ) <= (stop-step_size) ) {
        if (!slave->doStep(step_size)) {
            cout << "Error! doStep returned with status: " << to_string(slave->getLastStatus()) << endl;
            break;
        }
        slave->readReal(vr, ref);
//        cout << "t=" << t << ", Temperature_Reference=" << ref[0] << ", Temperature_Room=" << ref[1] << endl;
    }

    clock_t end = clock();

    double elapsed_secs = double(end-begin) / CLOCKS_PER_SEC;
    cout << "elapsed=" << elapsed_secs << "s" << endl;

    slave->terminate();

    return 0;

}