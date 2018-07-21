//
// Created by laht on 21.07.18.
//

#include <fmuproxy/grpc/server/GrpcServer.hpp>

#include "../test_util.cpp"

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::grpc::server;

int main(int argc, char **argv) {

    const unsigned int port = 9090;
    string fmu_path = string(getenv("TEST_FMUs"))
                      + "/FMI_2.0/CoSimulation/" + getOs() +
                      "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    Fmu fmu = Fmu(fmu_path);
    GrpcServer server = GrpcServer(fmu, port);
    server.start();

    wait_for_input();

    server.stop();

    return 0;
}
