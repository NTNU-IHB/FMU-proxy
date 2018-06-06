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
#include <JM/jm_portability.h>

#include "FmuWrapper.h"


using namespace std;
using namespace fmuproxy;
using namespace boost::filesystem;


int main(int argc, char **argv) {

    const char* fmu_path = "/home/laht/Downloads/ControlledTemperature.fmu";

    FmuWrapper fmu = FmuWrapper(fmu_path);

    FmuInstance instance1 = fmu.newInstance();
    FmuInstance instance2 = fmu.newInstance();

    map<int, FmuInstance*> my_map;
    my_map[0] = &instance1;

    FmuInstance* instance = my_map[0];

    RealRead read;

    instance->init(0.0, -1);
    instance2.init(0.0, -1);

    instance->getReal("Temperature_Room", read);
    cout << "Temperature_Room=" << read.value << endl;
    double dt = 1.0/100;

    StepResult result;
    instance1.step(dt, result);


    instance1.getReal("Temperature_Room", read);
    cout << "Temperature_Room=" << read.value << endl;

    instance1.terminate();

    instance2.getReal("Temperature_Room", read);
    cout << "Temperature_Room=" << read.value << endl;

    instance2.terminate();

    printf("Everything seems to be OK since you got this far=)!\n");

    return 0;

}

