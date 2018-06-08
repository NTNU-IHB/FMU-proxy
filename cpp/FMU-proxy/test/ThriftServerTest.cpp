//
// Created by laht on 08.06.18.
//


#include <iostream>
#include <thread>

#include "../common/FmuWrapper.h"
#include "../server/ThriftServer.h"

using namespace std;
using namespace fmuproxy;
using namespace fmuproxy::server;

void wait_for_input(::ThriftServer* server) {
    do {
        cout << '\n' << "Press a key to continue...\n";
    } while (cin.get() != '\n');
    cout << "Done." << endl;
    server->stop();
}

string getOs() {
    #ifdef _WIN32
        return "win64";
    #elif __linux__
        return "linux64";
    #endif
}

int main(int argc, char **argv) {

    int port = 9090;
    string fmu_path = string(string(getenv("TEST_FMUs")))
                      + "/FMI_2.0/CoSimulation/" + getOs() + "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    FmuWrapper fmu = FmuWrapper(fmu_path.c_str());
    ThriftServer server = ThriftServer(&fmu, port);

    thread t(wait_for_input, &server);

    cout << "Starting the server..." << endl;
    server.serve();

    t.join();


    return 0;
}

