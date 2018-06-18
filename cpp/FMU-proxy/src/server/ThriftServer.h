//
// Created by laht on 08.06.18.
//

#ifndef FMU_PROXY_THRIFTSERVER_H
#define FMU_PROXY_THRIFTSERVER_H


#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

#include "../common/FmuWrapper.h"
#include "FmuServiceHandler.h"


using namespace ::apache::thrift;
using namespace ::apache::thrift::server;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;

namespace fmuproxy {
    
    namespace server {
        
        class ThriftServer {

        private:
            shared_ptr<TSimpleServer> server;

        public:
            ThriftServer(std::shared_ptr<FmuWrapper> fmu, int port);
            
            void serve();
            
            void stop();

        };
        
    }
    
}


#endif //FMU_PROXY_THRIFTSERVER_H
