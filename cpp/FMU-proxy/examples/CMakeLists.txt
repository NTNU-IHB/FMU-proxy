
include_directories(${FMU_PROXY_SOURCE_DIR}/include)

##########################################################
#########################FMI##############################

add_executable(benchmark
        fmi/benchmark.cpp
        example_util.hpp)
target_link_libraries(benchmark PRIVATE FMI4cpp::fmi4cpp ${CURL_LIBRARIES} ${OPENSSL_LIBRARIES})

###########################################################
#########################Heartbeating######################

add_executable(heartbeat_test
        heartbeat/heartbeat_test.cpp
        example_util.hpp)
target_link_libraries(heartbeat_test PRIVATE heartbeat FMI4cpp::fmi4cpp ${CURL_LIBRARIES} ${OPENSSL_LIBRARIES})

###########################################################
#########################Thrift############################

if (FMU_PROXY_WITH_THRIFT)
    add_executable(thrift_client_test
            thrift/thrift_client_test.cpp)
    target_link_libraries(thrift_client_test PRIVATE thrift-client FMI4cpp::fmi4cpp)

    add_executable(thrift_server_test
            thrift/thrift_server_test.cpp)
    target_link_libraries(thrift_server_test PRIVATE FMI4cpp::fmi4cpp thrift-server thrift::thriftnb)
endif ()

###########################################################
#########################gRPC##############################

if (FMU_PROXY_WITH_GRPC)
    add_executable(grpc_client_test
            grpc/grpc_client_test.cpp)
    target_link_libraries(grpc_client_test PRIVATE grpc-client FMI4cpp::fmi4cpp)

    add_executable(grpc_server_test
            grpc/grpc_server_test.cpp)
    target_link_libraries(grpc_server_test PRIVATE grpc-server FMI4cpp::fmi4cpp)
endif ()

###########################################################