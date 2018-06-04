/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

#include <iostream>

#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

#include "gen-cpp/FmuService.h"

using namespace std;
using namespace ::apache::thrift;
using namespace ::apache::thrift::server;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;

using namespace ::fmuproxy::thrift;

class FmuServiceHandler : virtual public FmuServiceIf {
public:
    FmuServiceHandler() {
      // Your initialization goes here
    }

    void getModelDescriptionXml(std::string& _return) {
        _return = "this is a test";
      // Your implementation goes here
      printf("getModelDescriptionXml\n");
    }

    void getModelDescription( ::ModelDescription& _return) {
      // Your implementation goes here
      printf("getModelDescription\n");
    }

    FmuId createInstanceFromCS() {
      // Your implementation goes here
      printf("createInstanceFromCS\n");
    }

    FmuId createInstanceFromME(const  ::Solver& solver) {
      // Your implementation goes here
      printf("createInstanceFromME\n");
    }

    bool canGetAndSetFMUstate(const FmuId fmu_id) {
      // Your implementation goes here
      printf("canGetAndSetFMUstate\n");
    }

    double getCurrentTime(const FmuId fmu_id) {
      // Your implementation goes here
      printf("getCurrentTime\n");
    }

    bool isTerminated(const FmuId fmu_id) {
      // Your implementation goes here
      printf("isTerminated\n");
    }

    ::Status::type init(const FmuId fmu_id, const double start, const double stop) {
      // Your implementation goes here
      printf("init\n");
    }

    void step( ::StepResult& _return, const FmuId fmu_id, const double step_size) {
      // Your implementation goes here
      printf("step\n");
    }

    ::Status::type terminate(const FmuId fmu_id) {
      // Your implementation goes here
      printf("terminate\n");
    }

    ::Status::type reset(const FmuId fmu_id) {
      // Your implementation goes here
      printf("reset\n");
    }

    void readInteger( ::IntegerRead& _return, const FmuId fmu_id, const ValueReference vr) {
      // Your implementation goes here
      printf("readInteger\n");
    }

    void bulkReadInteger( ::IntegerArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
      // Your implementation goes here
      printf("bulkReadInteger\n");
    }

    void readReal( ::RealRead& _return, const FmuId fmu_id, const ValueReference vr) {
      // Your implementation goes here
      printf("readReal\n");
    }

    void bulkReadReal( ::RealArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
      // Your implementation goes here
      printf("bulkReadReal\n");
    }

    void readString( ::StringRead& _return, const FmuId fmu_id, const ValueReference vr) {
      // Your implementation goes here
      printf("readString\n");
    }

    void bulkReadString( ::StringArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
      // Your implementation goes here
      printf("bulkReadString\n");
    }

    void readBoolean( ::BooleanRead& _return, const FmuId fmu_id, const ValueReference vr) {
      // Your implementation goes here
      printf("readBoolean\n");
    }

    void bulkReadBoolean( ::BooleanArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
      // Your implementation goes here
      printf("bulkReadBoolean\n");
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

};

int main(int argc, char **argv) {
  int port = 9090;
  ::apache::thrift::stdcxx::shared_ptr<FmuServiceHandler> handler(new FmuServiceHandler());
  ::apache::thrift::stdcxx::shared_ptr<TProcessor> processor(new FmuServiceProcessor(handler));
  ::apache::thrift::stdcxx::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  ::apache::thrift::stdcxx::shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  ::apache::thrift::stdcxx::shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  cout << "Starting the server..." << endl;
  server.serve();
  cout << "Done." << endl;
  return 0;
}

