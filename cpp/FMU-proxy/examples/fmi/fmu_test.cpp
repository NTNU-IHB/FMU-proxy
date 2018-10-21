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
#include <fmi4cpp/fmi2/fmi4cpp.hpp>

#include "../test_util.cpp"

using namespace std;
using namespace fmi4cpp::fmi2;

int main(int argc, char **argv) {

    const string fmu_path = string(getenv("TEST_FMUs"))
                      + "/FMI_2.0/CoSimulation/" + getOs() +
                      "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    const double step_size = 1.0/100;
    auto fmu = Fmu(fmu_path).asCoSimulationFmu();
    auto md = fmu->getModelDescription();

    for (const auto &v : *md->modelVariables()) {
        if (v.causality() == fmi2Causality::output) {
            cout << v.name() << endl;
        }
    }

    const auto slave1 = fmu->newInstance();
    const auto slave2 = fmu->newInstance();

    slave1->setupExperiment();
    slave1->enterInitializationMode();
    slave1->exitInitializationMode();

    slave2->setupExperiment();
    slave2->enterInitializationMode();
    slave2->exitInitializationMode();

    double temperature_room;
    int vr = md->getValueReference("Temperature_Room");

    slave1->readReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room << endl;

    slave1->doStep(step_size);

    slave1->readReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room << endl;

    slave1->terminate();

    slave2->readReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room << endl;

    slave2->terminate();

    return 0;

}
