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
#include <fmuproxy/heartbeat/Heartbeat.hpp>
#include <fmuproxy/thrift/server/ThriftServer.hpp>
#include "boost/program_options.hpp"

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::heartbeat;
using namespace fmuproxy::thrift::server;

namespace {

    const int SUCCESS = 0;
    const int ERROR_IN_COMMAND_LINE = 1;
    const int ERROR_UNHANDLED_EXCEPTION = 2;

    void wait_for_input() {
        do {
            cout << '\n' << "Press a key to continue...\n";
        } while (cin.get() != '\n');
        cout << "Done." << endl;
    }

    int run_application(string &fmu_path) {

        Fmu fmu(fmu_path);

        ThriftServer server(fmu, 9090);
        server.start();

        Heartbeat beat("localhost", 8080, fmu.get_model_description_xml());
        beat.start();

        wait_for_input();
        server.stop();
        beat.stop();

        return 0;

    }

}


int main(int argc, char** argv) {

    try {

        namespace po = boost::program_options;

        po::options_description desc("Options");
        desc.add_options()
                ("help,h", "Print this help message and quits.")
                ("fmu,f", po::value<string>()->required(), "Path to FMU")
                ("remote,r", po::value<string>(), "IP address of the remote tracking server");
                ("thriftPort,", po::value<unsigned int>(), "Thrift port");

        po::variables_map vm;
        try {

            po::store(po::parse_command_line(argc, argv, desc), vm);

            if ( vm.count("help") ) {
                cout << "FMU-proxy" << endl << desc << endl;
                return SUCCESS;
            }

            po::notify(vm);

        } catch(po::error& e) {
            std::cerr << "ERROR: " << e.what() << std::endl << std::endl;
            std::cerr << desc << std::endl;
            return ERROR_IN_COMMAND_LINE;
        }

        if (vm.count("fmu")) {
            string fmu_path = vm["fmu"].as<string>();

            if (vm.count("remote")) {
                string address = vm["remote"].as<string>();
                //TODO split address into host and port
            }

            return run_application(fmu_path);
        }


    } catch(std::exception& e) {
        std::cerr << "Unhandled Exception reached the top of main: " << e.what() << ", application will now exit" << std::endl;
        return ERROR_UNHANDLED_EXCEPTION;
    }

    return SUCCESS;

}
