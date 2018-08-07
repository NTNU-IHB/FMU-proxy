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
#include <fmuproxy/fmi/Fmu.hpp>

#include "../test_util.cpp"

using namespace std;
using namespace fmuproxy::fmi;

int main(int argc, char **argv) {

    string fmu_path = string(getenv("TEST_FMUs"))
                      + "/FMI_2.0/CoSimulation/" + getOs() + "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    const double step_size = 1.0/100;
    Fmu fmu = Fmu(fmu_path);

    cout << fmu.get_model_description_xml() << endl;

    const auto md = fmu.get_model_description();
    for (auto var : md.modelVariables) {
        cout << var.attribute << endl;
    }

    const auto instance1 = fmu.new_instance();
    const auto instance2 = fmu.new_instance();

    instance1->init();
    instance2->init();

    auto temperature_room = vector<fmi2_real_t> (1);
    vector<fmi2_value_reference_t > vr = {instance1->get_value_reference("Temperature_Room")};

    instance1->readReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room[0] << endl;

    instance1->step(step_size);

    instance1->readReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room[0] << endl;

    instance1->terminate();

    instance2->readReal(vr, temperature_room);
    cout << "Temperature_Room=" << temperature_room[0] << endl;

    instance2->terminate();

    return 0;

}
