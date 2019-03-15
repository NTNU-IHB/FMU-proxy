/*
 * The MIT License
 *
 * Copyright 2017-2019 Norwegian University of Technology
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

#ifndef FMU_PROXY_SOLVER_HPP
#define FMU_PROXY_SOLVER_HPP

#include <memory>
#include <stdexcept>

#include <nlohmann/json.hpp>
#include <fmi4cpp/fmi4cpp.hpp>

namespace {

    const char* STEP_SIZE = "step_size";

    double parse_step_size(const std::string &data) {
        using json = nlohmann::json;
        auto parse = json::parse(data);
        return parse[STEP_SIZE].get<double>();
    }

    std::unique_ptr<fmi4cpp::solver::ModelExchangeSolver> parse_solver(const std::string &name, const std::string &settings) {

        using namespace fmi4cpp::solver;

        if (name == "euler") {
            return make_solver<EulerSolver>(parse_step_size(settings));
        } else if (name == "rk4") {
            return make_solver<RK4Solver>(parse_step_size(settings));
        } else {
            const auto err = "Unknown solver name=" + name;
            throw std::runtime_error(err);
        }

    }

}


#endif //FMU_PROXY_SOLVER_HPP
