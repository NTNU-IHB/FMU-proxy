
cmake_minimum_required(VERSION ${CMAKE_MINIMUM_REQUIRED_VERSION})

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

##########################################################
#########################FMI##############################

add_executable(Benchmark
        fmi/benchmark.cpp
        test_util.cpp)
target_link_libraries(Benchmark fmi)

add_executable(FmuTest
        fmi/fmu_test.cpp
        test_util.cpp)
target_link_libraries(FmuTest fmi)

###########################################################
#########################Heartbetaing######################

add_executable(HeartBeatTest
        heartbeat/heartbeat_test.cpp
        test_util.cpp)
target_link_libraries(HeartBeatTest heartbeat fmi)

###########################################################
#########################Thrift############################

add_executable(ThriftClientTest
        thrift/thrift_client_test.cpp)
target_link_libraries(ThriftClientTest thrift-client)

add_executable(ThriftServerTest
        thrift/thrift_server_test.cpp)
target_link_libraries(ThriftServerTest thrift-server)

###########################################################
#########################gRPC##############################

add_executable(GrpcClientTest
        grpc/grpc_client_test.cpp)
target_link_libraries(GrpcClientTest grpc-client)

add_executable(GrpcServerTest
        grpc/grpc_server_test.cpp)
target_link_libraries(GrpcServerTest grpc-server)

###########################################################