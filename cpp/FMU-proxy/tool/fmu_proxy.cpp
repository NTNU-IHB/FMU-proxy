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
#include <fmuproxy/heartbeat/RemoteAddress.hpp>
#include <fmuproxy/grpc/server/GrpcServer.hpp>
#include <fmuproxy/thrift/server/ThriftServer.hpp>

#include <boost/program_options.hpp>

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::heartbeat;

using fmuproxy::RemoteAddress;
using fmuproxy::grpc::server::GrpcServer;
using fmuproxy::thrift::server::ThriftServer;

namespace {

    const int SUCCESS = 0;
    const int COMMANDLINE_ERROR = 1;
    const int UNHANDLED_ERROR = 2;

    const string THRIFT_TCP = "thrift/tcp";
    const string THRIFT_HTTP = "thrift/http";
    const string GRPC_HTTP2 = "grpc/http2";

    void wait_for_input() {
        do {
            cout << '\n' << "Press a key to continue...\n";
        } while (cin.get() != '\n');
        cout << "Done." << endl;
    }

    int run_application(
            const vector<string> &fmu_paths,
            std::map<string, unsigned int> ports,
            const shared_ptr<RemoteAddress> &remote) {

        map<string, shared_ptr<Fmu>> fmu_map;
        vector<string> modelDescriptionXml;
        for (unsigned int i = 0; i < fmu_paths.size(); i++) {
            const auto fmu_path = fmu_paths[i];
            shared_ptr<Fmu> fmu = make_shared<Fmu>(fmu_path);
            fmu_map[fmu->getModelDescription().guid] = fmu;
            modelDescriptionXml.push_back(fmu->getModelDescriptionXml());
        }
        bool has_remote = remote != nullptr;
        bool enable_grpc = ports.count(GRPC_HTTP2);
        bool enable_thrift_tcp = ports.count(THRIFT_TCP);
        bool enable_thrift_http = ports.count(THRIFT_HTTP);

        map<string, unsigned int> servers;

        unique_ptr<ThriftServer> thrift_socket_server = nullptr;
        if (enable_thrift_tcp) {
            const unsigned int port = ports[THRIFT_TCP];
            thrift_socket_server = make_unique<ThriftServer>(fmu_map, port);
            thrift_socket_server->start();
            servers[THRIFT_TCP] = port;
        }

        unique_ptr<ThriftServer> thrift_http_server = nullptr;
        if (enable_thrift_http) {
            const unsigned int port = ports[THRIFT_HTTP];
            thrift_http_server = make_unique<ThriftServer>(fmu_map, port, true);
            thrift_http_server->start();
            servers[THRIFT_HTTP] = port;
        }

        unique_ptr<GrpcServer> grpc_server = nullptr;
        if (enable_grpc) {
            const unsigned int port = ports[GRPC_HTTP2];
            grpc_server = make_unique<GrpcServer>(fmu_map, port);
            grpc_server->start();
            servers[GRPC_HTTP2] = port;
        }

        unique_ptr<Heartbeat> beat = nullptr;
        if (has_remote) {
            shared_ptr<Heartbeat> beat (new Heartbeat(*remote, servers, modelDescriptionXml));
            beat->start();
        }

        wait_for_input();

        if (has_remote) {
            beat->stop();
        }

        if (enable_grpc) {
            grpc_server->stop();
        }
        if (enable_thrift_tcp) {
            thrift_socket_server->stop();
        }
        if (enable_thrift_tcp) {
            thrift_http_server->stop();
        }

        return 0;

    }

}

int main(int argc, char** argv) {

    try {

        namespace po = boost::program_options;

        po::options_description desc("Options");
        desc.add_options()
                ("help,h", "Print this help message and quits.")
                ("fmu,", po::value<vector<string>>()->multitoken(), "Path to FMUs.")
                ("remote,r", po::value<string>(), "IP address of the remote tracking server.")

                ("thrift/tcp,", po::value<unsigned int>(), "Specify the network port to be used by the Thrift (TCP/IP) server.")
                ("thrift/http,", po::value<unsigned int>(), "Specify the network port to be used by the Thrift (HTTP) server.")
                ("grpc,", po::value<unsigned int>(), "Specify the network port to be used by the gRPC server.");

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

        const vector<string> fmu_paths = vm["fmu"].as<vector<string>>();

        auto ports = std::map<string, unsigned int>();
        const char* thrift_tcp = "thrift/tcp";
        if (vm.count(thrift_tcp)) {
            ports[thrift_tcp] = vm[thrift_tcp].as<unsigned int>();
        }

        const char* thrift_http = "thrift/http";
        if (vm.count(thrift_http)) {
            ports[thrift_http] = vm[thrift_http].as<unsigned int>();
        }

        const char* grpc = "grpc";
        if (vm.count(grpc)) {
            ports[grpc] = vm[grpc].as<unsigned int>();
        }

        shared_ptr<RemoteAddress> remote = nullptr;
        if (vm.count("remote")) {
            string str = vm["remote"].as<string>();
            remote = make_shared<RemoteAddress>(RemoteAddress::parse (str));
        }

        return run_application(fmu_paths, ports, remote);

    } catch(std::exception& e) {
        std::cerr << "Unhandled Exception reached the top of main: " << e.what() << ", application will now exit" << std::endl;
        return UNHANDLED_ERROR;
    }

}
