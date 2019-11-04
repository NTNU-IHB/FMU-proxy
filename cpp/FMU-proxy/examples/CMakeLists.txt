
include_directories(${FMU_PROXY_SOURCE_DIR}/include)
include_directories(${FMU_PROXY_SOURCE_DIR}/src)

##########################################################
#########################FMI##############################

add_executable(benchmark
        fmi/benchmark.cpp
        example_util.hpp)
target_link_libraries(benchmark PRIVATE fmi4cpp::fmi4cpp)

###########################################################
#########################Thrift############################

if (FMU_PROXY_WITH_THRIFT)
    add_executable(thrift_client_test
            thrift/thrift_client_test.cpp)
    target_link_libraries(thrift_client_test PRIVATE thrift-client fmi4cpp::fmi4cpp)

    add_executable(thrift_server_test
            thrift/thrift_server_test.cpp)
    target_link_libraries(thrift_server_test PRIVATE fmi4cpp::fmi4cpp thrift-server thrift::thriftnb)
endif ()

###########################################################
#########################gRPC##############################

if (FMU_PROXY_WITH_GRPC)
    add_executable(grpc_client_test
            grpc/grpc_client_test.cpp)
    target_link_libraries(grpc_client_test PRIVATE grpc-client fmi4cpp::fmi4cpp)

    add_executable(grpc_server_test
            grpc/grpc_server_test.cpp)
    target_link_libraries(grpc_server_test PRIVATE grpc-server fmi4cpp::fmi4cpp)
endif ()

###########################################################