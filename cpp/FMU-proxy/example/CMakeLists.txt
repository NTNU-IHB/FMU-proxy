cmake_minimum_required(VERSION 3.10)

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(Benchmark
        benchmark.cpp
        test_util.cpp)
target_link_libraries(Benchmark fmi)

add_executable(FmuTest
        fmu_test.cpp
        test_util.cpp)
target_link_libraries(FmuTest fmi)

add_executable(HeartBeatTest
        heartbeat_test.cpp
        test_util.cpp)
target_link_libraries(HeartBeatTest heartbeat fmi)

add_executable(ThriftClientTest
        thrift_client_test.cpp)
target_link_libraries(ThriftClientTest thrift-client)

add_executable(ThriftServerTest
        thrift_server_test.cpp)
target_link_libraries(ThriftServerTest thrift-server)
