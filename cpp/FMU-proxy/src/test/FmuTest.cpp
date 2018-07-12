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

#include "TestUtil.hpp"
#include "../fmi/FmuWrapper.hpp"

using namespace std;
using namespace fmuproxy::fmi;

int main(int argc, char **argv) {

    string fmu_path = string(getenv("TEST_FMUs"))
                      + "/FMI_2.0/CoSimulation/" + getOs() + "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    double step_size = 1.0/100;
    FmuWrapper fmu = FmuWrapper(fmu_path);

    const auto md = fmu.getModelDescription();
    cout << md.defaultExperiment.stopTime << endl;

    for (auto var : md.modelVariables) {
        RealAttribute r = var.attribute.getRealAttribute();
        cout << r << endl;
    }

    const auto instance1 = fmu.newInstance();
    const auto instance2 = fmu.newInstance();

    instance1->init(0.0, -1);
    instance2->init(0.0, -1);


    double temperature_room;
    fmi2_value_reference_t vr = instance1->get_value_reference("Temperature_Room");

    instance1->getReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room << endl;

    instance1->step(step_size);

    instance1->getReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room << endl;

    instance1->terminate();

    instance2->getReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room << endl;

    instance2->terminate();

    return 0;

}
