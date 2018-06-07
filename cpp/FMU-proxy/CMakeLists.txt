cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 17)

include_directories(thrift-gen)

add_executable(FmuTest
        thrift-gen/definitions_types.cpp
        thrift-gen/definitions_types.h
        thrift-gen/service_types.h
        ThriftHelper.h
        FmuWrapper.cpp
        FmuWrapper.h
        FmuTest.cpp)

target_link_libraries(FmuTest fmilib)
target_link_libraries(FmuTest boost_system)
target_link_libraries(FmuTest boost_filesystem)
target_link_libraries(FmuTest dl)

add_executable(ThriftServer
        thrift-gen/definitions_types.cpp
        thrift-gen/definitions_types.h
        thrift-gen/service_types.h
        thrift-gen/FmuService.cpp
        thrift-gen/FmuService.h
        ThriftHelper.h
        FmuWrapper.cpp
        FmuWrapper.h
        ThriftServer.cpp)

target_link_libraries(ThriftServer thrift)
target_link_libraries(ThriftServer fmilib)
target_link_libraries(ThriftServer pthread)
target_link_libraries(ThriftServer boost_system)
target_link_libraries(ThriftServer boost_filesystem)
target_link_libraries(ThriftServer dl)


add_executable(ThriftClient
        thrift-gen/definitions_types.cpp
        thrift-gen/definitions_types.h
        thrift-gen/service_types.h
        thrift-gen/FmuService.cpp
        thrift-gen/FmuService.h
        ThriftClient.cpp)
target_link_libraries(ThriftClient thrift)




