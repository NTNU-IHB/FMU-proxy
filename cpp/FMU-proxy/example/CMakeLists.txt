cmake_minimum_required(VERSION 3.10)

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(Benchmark
        Benchmark.cpp
        TestUtil.cpp)
target_link_libraries(Benchmark fmi)

add_executable(FmuTest
        FmuTest.cpp
        TestUtil.cpp)
target_link_libraries(FmuTest fmi)


add_executable(ThriftClientTest
        ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest thrift-client)


add_executable(ThriftServerTest
        ThriftServerTest.cpp)
target_link_libraries(ThriftServerTest thrift-server pthread)
