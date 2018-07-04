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

#include <boost/filesystem.hpp>

#include <fmilib.h>

#include "../common/Util.h"
#include "../common/FmuWrapper.h"
#include "../common/thrift-gen/definitions_types.h"

using namespace std;
using namespace fmuproxy;
using namespace boost::filesystem;



int main(int argc, char **argv) {

    string fmu_path = string(string(getenv("TEST_FMUs")))
                      + "/FMI_2.0/CoSimulation/" + getOs() + "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    FmuWrapper fmu = FmuWrapper(fmu_path.c_str());

    auto md = fmu.getModelDescription();
    cout << md->defaultExperiment << endl;

    for (auto var : md->modelVariables) {
        cout << var.attribute.realAttribute << endl;
    }

    shared_ptr<FmuInstance> instance1 = fmu.newInstance();
    shared_ptr<FmuInstance> instance2 = fmu.newInstance();

    instance1->init(0.0, -1);
    instance2->init(0.0, -1);

    RealRead read;

    instance1->getReal("Temperature_Room", read);
    cout << "Temperature_Room=" << read.value << endl;
    double dt = 1.0/100;

    StepResult result;
    instance1->step(dt, result);

    instance1->getReal("Temperature_Room", read);
    cout << "Temperature_Room=" << read.value << endl;

    instance1->terminate();

    instance2->getReal("Temperature_Room", read);
    cout << "Temperature_Room=" << read.value << endl;

    instance2->terminate();

    return 0;

}
