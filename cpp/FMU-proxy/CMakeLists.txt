cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 14)

include_directories(gen-cpp)

add_executable(ThriftServer
        gen-cpp/definitions_constants.cpp
        gen-cpp/definitions_constants.h
        gen-cpp/definitions_types.cpp
        gen-cpp/definitions_types.h
        gen-cpp/service_constants.cpp
        gen-cpp/service_constants.h
        gen-cpp/service_types.cpp
        gen-cpp/service_types.h
        gen-cpp/FmuService.cpp
        gen-cpp/FmuService.h
        CppServer.cpp)
target_link_libraries(ThriftServer thrift)

add_executable(ThriftClient
        gen-cpp/definitions_constants.cpp
        gen-cpp/definitions_constants.h
        gen-cpp/definitions_types.cpp
        gen-cpp/definitions_types.h
        gen-cpp/service_constants.cpp
        gen-cpp/service_constants.h
        gen-cpp/service_types.cpp
        gen-cpp/service_types.h
        gen-cpp/FmuService.cpp
        gen-cpp/FmuService.h
        CppClient.cpp)
target_link_libraries(ThriftClient thrift)




