
include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(fmu_proxy fmu_proxy.cpp)
target_link_libraries(fmu_proxy PRIVATE heartbeat grpc-server thrift-server Boost::program_options)
if (UNIX)
    target_link_libraries(fmu_proxy PRIVATE pthread)
endif()

install(TARGETS fmu_proxy DESTINATION bin)
