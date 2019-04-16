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

#include <memory>
#include <vector>
#include <string>
#include <chrono>
#include <iostream>

#include <fmi4cpp/fmi4cpp.hpp>

namespace fmuproxy {

    std::string getOs() {
#if _WIN32 || _WIN64
        #if _WIN64
        return "win64";
#else
        return "win32";
#endif
#elif __linux__
        return "linux64";
#endif
    }

    void wait_for_input() {
        do {
            std::cout << '\n' << "Press a key to continue...\n";
        } while (std::cin.get() != '\n');
        std::cout << "Done." << std::endl;
    }

    template <typename function>
    inline float measure_time_sec(function &&fun) {
        auto t_start =  std::chrono::high_resolution_clock::now();
        fun();
        auto t_stop =  std::chrono::high_resolution_clock::now();
        return std::chrono::duration<float>(t_stop - t_start).count();
    }

    const double stop = 2;
    const double step_size = 1E-2;

    void run_slave(std::unique_ptr<fmi4cpp::fmu_slave<fmi4cpp::fmi2::cs_model_description>> slave) {

        auto md = slave->get_model_description();

        std::cout << "GUID=" << md->guid << std::endl;
        std::cout << "modelName=" << md->model_name << std::endl;
        std::cout << "license=" << md->license.value_or("-") << std::endl;

        slave->setup_experiment();
        slave->enter_initialization_mode();
        slave->exit_initialization_mode();

        auto elapsed = measure_time_sec([&slave, &md]{
            std::vector<fmi2Real > ref(2);
            std::vector<fmi2ValueReference > vr = {md->get_value_reference("Temperature_Reference"),
                                              md->get_value_reference("Temperature_Room")};

            while ( (slave->get_simulation_time() ) < stop) {
                slave->step(step_size);
                slave->read_real(vr, ref);
            }
        });

        std::cout << "elapsed=" << elapsed << "s" << std::endl;

        bool status = slave->terminate();
        std::cout << "terminated FMU with success: " << (status ? "true" : "false") << std::endl;
    }


}
