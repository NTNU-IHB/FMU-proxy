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

#include <map>
#include <iostream>
#include <fmuproxy/fmi/Fmu.hpp>
#include <fmuproxy/heartbeat/Heartbeat.hpp>
#include "boost/program_options.hpp"
#include "extra/RemoteAddress.hpp"
#include <fmuproxy/grpc/server/GrpcServer.hpp>
#include <fmuproxy/thrift/server/ThriftServer.hpp>

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::heartbeat;
using namespace fmuproxy::grpc::server;
using namespace fmuproxy::thrift::server;

namespace po = boost::program_options;

namespace {

    const int SUCCESS = 0;
    const int COMMANDLINE_ERROR = 1;
    const int UNHANDLED_ERROR = 2;

    void wait_for_input() {
        do {
            cout << '\n' << "Press a key to continue...\n";
        } while (cin.get() != '\n');
        cout << "Done." << endl;
    }

    int run_application(
            const string &fmu_path,
            std::map<string, unsigned int> ports,
            const shared_ptr<RemoteAddress> &remote) {

        Fmu fmu(fmu_path);

        ThriftServer thrift_server(fmu, ports["thrift"]);
        thrift_server.start();

        GrpcServer grpc_server(fmu, ports["grpc"]);
        grpc_server.start();

        bool has_remote = remote != nullptr;
        unique_ptr<Heartbeat> beat = nullptr;
        if (has_remote) {
            beat = make_unique<Heartbeat>(remote->host, remote->port, fmu.get_model_description_xml());
            beat->start();
        }

        wait_for_input();

        if (has_remote) {
            beat->stop();
        }

        thrift_server.stop();
        grpc_server.stop();

        return 0;

    }

}

int main(int argc, char** argv) {

    try {

        po::options_description desc("Options");
        desc.add_options()
                ("help,h", "Print this help message and quits.")
                ("fmu,f", po::value<string>()->required(), "Path to FMU.")
                ("remote,r", po::value<string>(), "IP address of the remote tracking server.")
#if THRIFT_FOUND
                ("thrift_port,t", po::value<unsigned int>()->required(),
                 "Specify the network port to be used by the Thrift server")
#endif
#if GRPC_FOUND
            ("grpc_port,g", po::value<unsigned int>()->required(), "Specify the network port to be used by the gRPC server.")
#endif
                ; //<- keep it there

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
            return COMMANDLINE_ERROR;
        }

        const string fmu_path = vm["fmu"].as<string>();

        auto ports = std::map<string, unsigned int>();
#if THRIFT_FOUND
        ports["thrift"] = vm["thrift_port"].as<unsigned int>();
#endif
#if GRPC_FOUND
        ports["grpc"] = vm["grpc_port"].as<unsigned int>();

        shared_ptr<RemoteAddress> remote = nullptr;
        if (vm.count("remote")) {
            string str = vm["remote"].as<string>();
            auto parse = RemoteAddress::parse (str);
            remote = shared_ptr<RemoteAddress>(&parse);
        }

        return run_application(fmu_path, ports, remote);

    } catch(std::exception& e) {
        std::cerr << "Unhandled Exception reached the top of main: " << e.what() << ", application will now exit" << std::endl;
        return UNHANDLED_ERROR;
    }

}
