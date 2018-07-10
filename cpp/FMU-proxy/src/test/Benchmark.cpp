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

#include "../common/Util.hpp"
#include "../common/FmuWrapper.hpp"
#include "../common/thrift-gen/definitions_types.h"

using namespace std;
using namespace fmuproxy;
using namespace boost::filesystem;

const double stop = 10;
const double step_size = 1E-4;

int main(int argc, char **argv) {

    string fmu_path = string(string(getenv("TEST_FMUs")))
                      + "/FMI_2.0/CoSimulation/" + getOs() +
                      "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    FmuWrapper fmu = FmuWrapper(fmu_path.c_str());

    shared_ptr<FmuInstance> instance = fmu.newInstance();

    instance->init(0.0, 0.0);

    clock_t begin = clock();

    RealRead read;
    StepResult result;
    while (result.simulationTime <= stop) {
        instance->step(step_size, result);
        instance->getReal("Temperature_Room", read);
    }

    clock_t end = clock();

    double elapsed_secs = double(end-begin) / CLOCKS_PER_SEC;
    cout << "elapsed=" << elapsed_secs << "s" << endl;

    instance->terminate();

    return 0;

}