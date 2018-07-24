
cmake_minimum_required(VERSION ${CMAKE_MINIMUM_REQUIRED_VERSION})

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

##########################################################
#########################FMI##############################

add_executable(benchmark
        fmi/benchmark.cpp
        test_util.cpp)
target_link_libraries(benchmark fmi)

add_executable(fmu_test
        fmi/fmu_test.cpp
        test_util.cpp)
target_link_libraries(fmu_test fmi)

###########################################################
#########################Heartbetaing######################

add_executable(heartbeat_test
        heartbeat/heartbeat_test.cpp
        test_util.cpp)
target_link_libraries(heartbeat_test heartbeat fmi)

###########################################################
#########################Thrift############################

add_executable(thrift_client_test
        thrift/thrift_client_test.cpp)
target_link_libraries(thrift_client_test thrift-client)

add_executable(thrift_server_test
        thrift/thrift_server_test.cpp)
target_link_libraries(thrift_server_test thrift-server)

###########################################################
#########################gRPC##############################

add_executable(grpc_client_test
        grpc/grpc_client_test.cpp)
target_link_libraries(grpc_client_test grpc-client)

add_executable(grpc_server_test
        grpc/grpc_server_test.cpp)
target_link_libraries(grpc_server_test grpc-server)

###########################################################