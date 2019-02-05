
cmake_minimum_required(VERSION 3.10)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

option(FMU_PROXY_BUILD_TESTS "Build tests" OFF)
option(FMU_PROXY_BUILD_EXAMPLES "Build examples" ON)
option(FMU_PROXY_BUILD_TOOL "Build the server executable" ON)
option(FMU_PROXY_WITH_GRPC "Build with gRPC support" ON)
option(FMU_PROXY_WITH_THRIFT "Build with Trift support" ON)

if(MSVC)
    set(CMAKE_DEBUG_POSTFIX "d")
    add_definitions("-DNOMINMAX" "-D_WIN32_WINNT=0x600" "-D_CRT_SECURE_NO_WARNINGS")
endif()

set(BOOST_COMPONENTS atomic)
if (FMU_PROXY_BUILD_TESTS)
    list(APPEND BOOST_COMPONENTS unit_test_framework)
endif()
if (FMU_PROXY_BUILD_TOOL)
    list(APPEND BOOST_COMPONENTS program_options)
endif()

find_package(Boost 1.65 COMPONENTS ${BOOST_COMPONENTS} REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(JSON REQUIRED)
find_package(CURL REQUIRED)

if (FMU_PROXY_WITH_THRIFT)
    find_package(Thrift REQUIRED)
    add_definitions(-DFMU_PROXY_WITH_THRIFT)
endif()

if (FMU_PROXY_WITH_GRPC)
    find_package(Protobuf REQUIRED)
    find_package(gRPC CONFIG REQUIRED)
    add_definitions(-DFMU_PROXY_WITH_GRPC)
endif()

# add subdiretories
option(FMI4CPP_BUILD_EXAMPLES "" OFF)
option(FMI4CPP_BUILD_TESTS "" OFF)
option(FMI4CPP_BUILD_TOOL "" OFF)
add_subdirectory(FMI4cpp)

add_subdirectory(src)
add_subdirectory(tool)

if (FMU_PROXY_BUILD_TESTS OR FMU_PROXY_BUILD_EXAMPLES)
    file(COPY resources DESTINATION ${CMAKE_CURRENT_BINARY_DIR})

    if (FMU_PROXY_BUILD_TESTS)
        add_subdirectory(tests)
    endif()

    if (FMU_PROXY_BUILD_EXAMPLES)
        add_subdirectory(examples)
    endif()

endif()