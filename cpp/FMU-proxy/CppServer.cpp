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
#include <thread>

#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

#include "gen-cpp/FmuService.h"
#include "FmuWrapper.h"


using namespace std;
using namespace ::apache::thrift;
using namespace ::apache::thrift::server;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;

using namespace fmuproxy;
using namespace ::fmuproxy::thrift;

int id_gen = 0;

class FmuServiceHandler : virtual public FmuServiceIf {

private:
    FmuWrapper* fmu;
    map<FmuId, FmuInstance*> fmus;

public:
    FmuServiceHandler(const char* fmu_path)
            : fmu(new FmuWrapper(fmu_path)) {}

    void getModelDescriptionXml(std::string& _return) {
        _return = "XML placeholder";
    }

    void getModelDescription( ::ModelDescription& _return) {
        _return = *fmu-> getModelDescription();
    }

    FmuId createInstanceFromCS() {
      FmuInstance* instance = fmu->newInstance();
      FmuId my_id = id_gen++;
      fmus[my_id] = instance;
      cout << "create instance with id=" << my_id << endl;
      return my_id;
    }

    FmuId createInstanceFromME(const  ::Solver& solver) {
      // Your implementation goes here
      printf("createInstanceFromME\n");
    }

    bool canGetAndSetFMUstate(const FmuId fmu_id) {
      return false;
    }

    double getCurrentTime(const FmuId fmu_id) {
        FmuInstance* instance = fmus[fmu_id];
        return instance->getCurrentTime();
    }

    bool isTerminated(const FmuId fmu_id) {
        FmuInstance* instance = fmus[fmu_id];
        return instance->isTerminated();
    }

    ::Status::type init(const FmuId fmu_id, const double start, const double stop) {
        FmuInstance* instance = fmus[fmu_id];
        instance->init(start, stop);
        return ::Status::OK_STATUS;
    }

    void step( ::StepResult& _return, const FmuId fmu_id, const double step_size) {
        FmuInstance* instance = fmus[fmu_id];
        instance->step(step_size, _return);
    }

    ::Status::type terminate(const FmuId fmu_id) {
        FmuInstance *instance = fmus[fmu_id];
        Status::type status = instance->terminate();
        delete instance;
        return status;
    }

    ::Status::type reset(const FmuId fmu_id) {
        FmuInstance* instance = fmus[fmu_id];
        return instance->reset();
    }

    void readInteger( ::IntegerRead& _return, const FmuId fmu_id, const ValueReference vr) {
        FmuInstance* instance = fmus[fmu_id];
        instance->getInteger(vr, _return);
    }

    void bulkReadInteger( ::IntegerArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
        FmuInstance* instance = fmus[fmu_id];
    }

    void readReal( ::RealRead& _return, const FmuId fmu_id, const ValueReference vr) {
        FmuInstance* instance = fmus[fmu_id];
        instance->getReal(vr, _return);
    }

    void bulkReadReal( ::RealArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
        FmuInstance* instance = fmus[fmu_id];
    }

    void readString( ::StringRead& _return, const FmuId fmu_id, const ValueReference vr) {
        FmuInstance* instance = fmus[fmu_id];
        instance->getString(vr, _return);
    }

    void bulkReadString( ::StringArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
        FmuInstance* instance = fmus[fmu_id];
    }

    void readBoolean( ::BooleanRead& _return, const FmuId fmu_id, const ValueReference vr) {
        FmuInstance* instance = fmus[fmu_id];
        instance->getBoolean(vr, _return);
    }

    void bulkReadBoolean( ::BooleanArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
        FmuInstance* instance = fmus[fmu_id];
    }

    ::Status::type writeInteger(const FmuId fmu_id, const ValueReference vr, const int32_t value) {
      // Your implementation goes here
      printf("writeInteger\n");
    }

    ::Status::type bulkWriteInteger(const FmuId fmu_id, const ValueReferences& vr, const IntArray& value) {
      // Your implementation goes here
      printf("bulkWriteInteger\n");
    }

    ::Status::type writeReal(const FmuId fmu_id, const ValueReference vr, const double value) {
      // Your implementation goes here
      printf("writeReal\n");
    }

    ::Status::type bulkWriteReal(const FmuId fmu_id, const ValueReferences& vr, const RealArray& value) {
      // Your implementation goes here
      printf("bulkWriteReal\n");
    }

    ::Status::type writeString(const FmuId fmu_id, const ValueReference vr, const std::string& value) {
      // Your implementation goes here
      printf("writeString\n");
    }

    ::Status::type bulkWriteString(const FmuId fmu_id, const ValueReferences& vr, const StringArray& value) {
      // Your implementation goes here
      printf("bulkWriteString\n");
    }

    ::Status::type writeBoolean(const FmuId fmu_id, const ValueReference vr, const bool value) {
      // Your implementation goes here
      printf("writeBoolean\n");
    }

    ::Status::type bulkWriteBoolean(const FmuId fmu_id, const ValueReferences& vr, const BooleanArray& value) {
      // Your implementation goes here
      printf("bulkWriteBoolean\n");
    }

    ~FmuServiceHandler() {
        delete fmu;
    }

};

void wait_for_input(TSimpleServer* server) {
    do {
        cout << '\n' << "Press a key to continue...";
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

    shared_ptr<FmuServiceHandler> handler(new FmuServiceHandler(fmu_path.c_str()));
    shared_ptr<TProcessor> processor(new FmuServiceProcessor(handler));
    shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
    shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
    shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

    TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);

    thread t(wait_for_input, &server);

    cout << "Starting the server..." << endl;
    server.serve();

    t.join();

    return 0;
}

