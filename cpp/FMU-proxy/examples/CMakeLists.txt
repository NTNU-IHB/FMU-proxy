cmake_minimum_required(VERSION 3.10)

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(Benchmark
        fmi/benchmark.cpp
        test_util.cpp)
target_link_libraries(Benchmark fmi)

add_executable(FmuTest
        fmi/fmu_test.cpp
        test_util.cpp)
target_link_libraries(FmuTest fmi)

add_executable(HeartBeatTest
        heartbeat/heartbeat_test.cpp
        test_util.cpp)
target_link_libraries(HeartBeatTest heartbeat fmi)

add_executable(ThriftClientTest
        thrift/thrift_client_test.cpp)
target_link_libraries(ThriftClientTest thrift-client)

add_executable(ThriftServerTest
        thrift/thrift_server_test.cpp)
target_link_libraries(ThriftServerTest thrift-server)
