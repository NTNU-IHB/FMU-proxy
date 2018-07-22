cmake_minimum_required(VERSION 3.10)

include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(fmu_proxy
        extra/RemoteAddress.hpp
        fmu_proxy.cpp)
target_link_libraries(fmu_proxy fmi heartbeat Boost::program_options)

if (GRPC_FOUND)
    target_link_libraries(fmu_proxy grpc-server)
    target_compile_definitions(fmu_proxy PRIVATE GRPC_FOUND=1)
endif ()

if (THRIFT_FOUND)
    target_link_libraries(fmu_proxy thrift-server)
    target_compile_definitions(fmu_proxy PRIVATE THRIFT_FOUND=1)
endif ()

if (UNIX)
    target_link_libraries(fmu_proxy pthread)
endif()

install(TARGETS fmu_proxy DESTINATION "${tool_dest}")
