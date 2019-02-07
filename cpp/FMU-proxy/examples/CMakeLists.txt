
include_directories(${FMU_PROXY_SOURCE_DIR}/include)

##########################################################
#########################FMI##############################

add_executable(benchmark
        fmi/benchmark.cpp
        example_util.hpp)
target_link_libraries(benchmark PUBLIC FMI4cpp::fmi4cpp)

###########################################################
#########################Heartbetaing######################

add_executable(heartbeat_test
        heartbeat/heartbeat_test.cpp
        example_util.hpp)
target_link_libraries(heartbeat_test PUBLIC heartbeat FMI4cpp::fmi4cpp)

###########################################################
#########################Thrift############################

if (FMU_PROXY_WITH_THRIFT)
    add_executable(thrift_client_test
            thrift/thrift_client_test.cpp)
    target_link_libraries(thrift_client_test PUBLIC thrift-client)

    add_executable(thrift_server_test
            thrift/thrift_server_test.cpp)
    target_link_libraries(thrift_server_test PUBLIC thrift-server)
endif ()

###########################################################
#########################gRPC##############################

if (FMU_PROXY_WITH_THRIFT)
    add_executable(grpc_client_test
            grpc/grpc_client_test.cpp)
    target_link_libraries(grpc_client_test PUBLIC grpc-client)

    add_executable(grpc_server_test
            grpc/grpc_server_test.cpp)
    target_link_libraries(grpc_server_test PUBLIC grpc-server)
endif ()

###########################################################