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

#include <optional>
#include <iostream>
#include <unordered_map>
#include <boost/program_options.hpp>

#include <fmuproxy/heartbeat/heartbeat.hpp>
#include <fmuproxy/heartbeat/remote_address.hpp>

#include <fmi4cpp/fmi2/fmi2.hpp>

#ifdef FMU_PROXY_WITH_GRPC
#include <fmuproxy/grpc/server/grpc_fmu_server.hpp>
using fmuproxy::grpc::server::grpc_fmu_server;
#endif

#ifdef FMU_PROXY_WITH_THRIFT
#include <fmuproxy/thrift/server/thrift_fmu_server.hpp>
using fmuproxy::thrift::server::thrift_fmu_server;
#endif

using namespace std;
using namespace fmuproxy;

namespace {

    const int SUCCESS = 0;
    const int COMMANDLINE_ERROR = 1;
    const int UNHANDLED_ERROR = 2;

    const char* THRIFT_TCP = "thrift/tcp";
    const char* THRIFT_HTTP = "thrift/http";
    const char* GRPC = "grpc";

    void wait_for_input() {
        do {
            cout << '\n' << "Press a key to continue...\n";
        } while (cin.get() != '\n');
        cout << "Done." << endl;
    }

    int run_application(
            vector<shared_ptr<fmi4cpp::fmi2::fmi2Fmu>> fmus,
            unordered_map<string, unsigned int> ports,
            const optional<remote_address> remote) {

        unordered_map<string, shared_ptr<fmi4cpp::fmi2::fmi2Fmu>> fmu_map;
        vector<string> modelDescriptions;
        for (const auto fmu : fmus) {
            fmu_map[fmu->getModelDescription()->guid] = fmu;
            modelDescriptions.push_back(fmu->getModelDescriptionXml());
        }

        bool enable_grpc = ports.count(GRPC) == 1;
        bool enable_thrift_tcp = ports.count(THRIFT_TCP) == 1;
        bool enable_thrift_http = ports.count(THRIFT_HTTP) == 1;

        unordered_map<string, unsigned int> servers;

#ifdef FMU_PROXY_WITH_THRIFT
        unique_ptr<thrift_fmu_server> thrift_socket_server = nullptr;
        if (enable_thrift_tcp) {
            const unsigned int port = ports[THRIFT_TCP];
            thrift_socket_server = make_unique<thrift_fmu_server>(fmu_map, port, false, true);
            thrift_socket_server->start();
            servers[THRIFT_TCP] = port;
        }

        unique_ptr<thrift_fmu_server> thrift_http_server = nullptr;
        if (enable_thrift_http) {
            const unsigned int port = ports[THRIFT_HTTP];
            thrift_http_server = make_unique<thrift_fmu_server>(fmu_map, port, true);
            thrift_http_server->start();
            servers[THRIFT_HTTP] = port;
        }
#endif

#ifdef FMU_PROXY_WITH_GRPC
        unique_ptr<grpc_fmu_server> grpc_server = nullptr;
        if (enable_grpc) {
            const unsigned int port = ports[GRPC];
            grpc_server = make_unique<grpc_fmu_server>(fmu_map, port);
            grpc_server->start();
            servers[GRPC] = port;
        }
#endif
        unique_ptr<heartbeat> beat = nullptr;
        if (remote) {
            beat = make_unique<heartbeat>(*remote, servers, modelDescriptions);
            beat->start();
        }

        wait_for_input();

        if (remote) {
            beat->stop();
        }
#ifdef FMU_PROXY_WITH_GRPC
        if (enable_grpc) {
            grpc_server->stop();
        }
#endif
#ifdef FMU_PROXY_WITH_THRIFT
        if (enable_thrift_tcp) {
            thrift_socket_server->stop();
        }
        if (enable_thrift_http) {
            thrift_http_server->stop();
        }
#endif
        return 0;

    }

}

int main(int argc, char** argv) {

    try {

        namespace po = boost::program_options;

        po::options_description desc("Options");
        desc.add_options()
                ("help,h", "Print this help message and quits.")
                ("fmu,f", po::value<vector<string>>()->multitoken(), "Path to FMUs.")
                ("remote,r", po::value<string>(), "IP address of the remote tracking server.");

#ifdef FMU_PROXY_WITH_THRIFT
        desc.add_options()
                (THRIFT_TCP, po::value<unsigned int>(), "Specify the network port to be used by the Thrift (TCP/IP) server.")
                (THRIFT_HTTP, po::value<unsigned int>(), "Specify the network port to be used by the Thrift (HTTP) server.");
#endif

#ifdef FMU_PROXY_WITH_GRPC
        desc.add_options()
                (GRPC, po::value<unsigned int>(), "Specify the network port to be used by the gRPC server.");
#endif

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


        vector<shared_ptr<fmi4cpp::fmi2::fmi2Fmu>> fmus;
        if (vm.count("fmu")) {
            const vector<string> fmu_paths = vm["fmu"].as<vector<string>>();
            for (const auto fmu_path : fmu_paths) {
                fmus.push_back(make_shared<fmi4cpp::fmi2::fmi2Fmu>(fmu_path));
            }
        }

        auto ports = unordered_map<string, unsigned int>();

        if (vm.count(THRIFT_TCP)) {
            ports[THRIFT_TCP] = vm[THRIFT_TCP].as<unsigned int>();
        }

        if (vm.count(THRIFT_HTTP)) {
            ports[THRIFT_HTTP] = vm[THRIFT_HTTP].as<unsigned int>();
        }

        if (vm.count(GRPC)) {
            ports[GRPC] = vm[GRPC].as<unsigned int>();
        }

        optional<fmuproxy::remote_address> remote;
        if (vm.count("remote")) {
            string str = vm["remote"].as<string>();
            remote = fmuproxy::remote_address(fmuproxy::remote_address::parse (str));
        }

        return run_application(fmus, ports, remote);

    } catch(std::exception& e) {
        std::cerr << "Unhandled Exception reached the top of main: " << e.what() << ", application will now exit" << std::endl;
        return UNHANDLED_ERROR;
    }

}
