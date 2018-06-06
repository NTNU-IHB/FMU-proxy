cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 17)

include_directories(gen-cpp)

add_executable(FmuTest
        gen-cpp/definitions_types.cpp
        gen-cpp/definitions_types.h
        FmuWrapper.cpp
        FmuWrapper.h
        FmuTest.cpp)
target_link_libraries(FmuTest fmilib)
target_link_libraries(FmuTest boost_system)
target_link_libraries(FmuTest boost_filesystem)
target_link_libraries(FmuTest dl)


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
        FmuWrapper.cpp
        FmuWrapper.h
        CppServer.cpp)
target_link_libraries(ThriftServer thrift)
target_link_libraries(ThriftServer fmilib)
target_link_libraries(ThriftServer boost_system)
target_link_libraries(ThriftServer boost_filesystem)
target_link_libraries(ThriftServer dl)
target_link_libraries(ThriftServer pthread)


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




