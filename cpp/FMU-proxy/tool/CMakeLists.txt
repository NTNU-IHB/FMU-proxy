
include_directories(${FMU_PROXY_SOURCE_DIR}/include)

add_executable(fmu_proxy fmu_proxy.cpp)
target_link_libraries(fmu_proxy PRIVATE FMI4cpp::fmi4cpp heartbeat Boost::program_options)

if(FMU_PROXY_WITH_THRIFT)
    target_link_libraries(fmu_proxy PRIVATE thrift-server thrift::thriftnb)
    target_compile_definitions(fmu_proxy PUBLIC FMU_PROXY_WITH_THRIFT)
endif()

if(FMU_PROXY_WITH_GRPC)
    target_link_libraries(fmu_proxy PRIVATE grpc-server)
    target_compile_definitions(fmu_proxy PUBLIC FMU_PROXY_WITH_GRPC)
endif()

if (UNIX)
    target_link_libraries(fmu_proxy PRIVATE pthread)
endif()

install(TARGETS fmu_proxy DESTINATION bin)
