cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 17)

#find cppzmq wrapper, installed by make of cppzmq
find_package(cppzmq)
if(cppzmq_FOUND)
    include_directories(${cppzmq_INCLUDE_DIR})
endif()

add_executable(FmuTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/FmuWrapper.cpp
        common/FmuWrapper.h
        test/FmuTest.cpp)
target_link_libraries(FmuTest fmilib boost_system boost_filesystem dl)


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
target_link_libraries(ThriftServerTest thrift fmilib pthread boost_system boost_filesystem dl ${cppzmq_LIBRARY})

add_executable(ThriftClientTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        client/ThriftClient.cpp
        client/ThriftClient.h
        test/ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest thrift fmilib)



