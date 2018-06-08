cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 17)

add_executable(FmuTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/FmuWrapper.cpp
        common/FmuWrapper.h
        test/FmuTest.cpp)
target_link_libraries(FmuTest fmilib)
target_link_libraries(FmuTest boost_system)
target_link_libraries(FmuTest boost_filesystem)
target_link_libraries(FmuTest dl)


add_executable(ThriftServerTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        common/ThriftHelper.h
        common/FmuWrapper.cpp
        common/FmuWrapper.h
        common/FmuHelper.h
        server/FmuServiceHandler.h
        server/FmuServiceHandler.cpp
        server/ThriftServer.h
        server/ThriftServer.cpp
        test/ThriftServerTest.cpp)
target_link_libraries(ThriftServerTest thrift)
target_link_libraries(ThriftServerTest fmilib)
target_link_libraries(ThriftServerTest pthread)
target_link_libraries(ThriftServerTest boost_system)
target_link_libraries(ThriftServerTest boost_filesystem)
target_link_libraries(ThriftServerTest dl)

add_executable(ThriftClientTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        client/ThriftClient.cpp
        client/ThriftClient.h
        test/ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest thrift)
target_link_libraries(ThriftClientTest fmilib)



