cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 17)

include_directories(common/thrift-gen)

add_executable(FmuTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/ThriftHelper.h
        server/FmuWrapper.cpp
        server/FmuWrapper.h
        test/FmuTest.cpp)

target_link_libraries(FmuTest fmilib)
target_link_libraries(FmuTest boost_system)
target_link_libraries(FmuTest boost_filesystem)
target_link_libraries(FmuTest dl)

add_executable(ThriftServer
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        common/ThriftHelper.h
        server/FmuWrapper.cpp
        server/FmuWrapper.h
        server/ThriftServer.cpp server/FmuServiceHandler.h)

target_link_libraries(ThriftServer thrift)
target_link_libraries(ThriftServer fmilib)
target_link_libraries(ThriftServer pthread)
target_link_libraries(ThriftServer boost_system)
target_link_libraries(ThriftServer boost_filesystem)
target_link_libraries(ThriftServer dl)


add_executable(ThriftClient
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        client/ThriftClient.cpp)
target_link_libraries(ThriftClient thrift)




