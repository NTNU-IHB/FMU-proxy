
include_directories(${FMU_PROXY_SOURCE_DIR}/include)

##########################################################
#########################FMI##############################

add_executable(benchmark
        fmi/benchmark.cpp
        example_util.cpp)
target_link_libraries(benchmark PUBLIC FMI4cpp::FMI4cpp)

add_executable(fmu_test
        fmi/fmu_test.cpp
        example_util.cpp)
target_link_libraries(fmu_test PUBLIC FMI4cpp::FMI4cpp)

###########################################################
#########################Heartbetaing######################

add_executable(heartbeat_test
        heartbeat/heartbeat_test.cpp
        example_util.cpp)
target_link_libraries(heartbeat_test PUBLIC heartbeat FMI4cpp::FMI4cpp)

###########################################################
#########################Thrift############################

add_executable(thrift_client_test
        thrift/thrift_client_test.cpp)
target_link_libraries(thrift_client_test PUBLIC thrift-client)

add_executable(thrift_server_test
        thrift/thrift_server_test.cpp)
target_link_libraries(thrift_server_test PUBLIC thrift-server)

###########################################################
#########################gRPC##############################

add_executable(grpc_client_test
        grpc/grpc_client_test.cpp)
target_link_libraries(grpc_client_test PUBLIC grpc-client)

add_executable(grpc_server_test
        grpc/grpc_server_test.cpp)
target_link_libraries(grpc_server_test PUBLIC grpc-server)

###########################################################