cmake_minimum_required(VERSION 3.10)

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(fmu_proxy
        RemoteAddress.hpp
        fmu_proxy.cpp)
target_link_libraries(fmu_proxy fmi heartbeat thrift-server Boost::program_options pthread)