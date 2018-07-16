//
// Created by laht on 16.07.18.
//
#include <iostream>
#include <fmuproxy/fmi/Fmu.hpp>
#include <fmuproxy/heartbeat/Heartbeat.hpp>
#include "test_util.cpp"

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::heartbeat;

int main() {

    const unsigned int port = 8080;
    const string host = "localhost";

    string fmu_path = string(getenv("TEST_FMUs"))
                          + "/FMI_2.0/CoSimulation/" + getOs() +
                          "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    Fmu fmu = Fmu(fmu_path);
    string xml = fmu.get_model_description_xml();

    auto beat = Heartbeat(host, port, xml);
    beat.start();

    usleep(1 * 5000000);

    beat.stop();

    return 0;

}