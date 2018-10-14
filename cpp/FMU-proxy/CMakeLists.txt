
cmake_minimum_required(VERSION 3.10)

SET(VCPKG_ROOT $ENV{VCPKG_ROOT} CACHE STRING "VCPKG_ROOT")
if (DEFINED VCPKG_ROOT AND NOT DEFINED CMAKE_TOOLCHAIN_FILE AND EXISTS "${VCPKG_ROOT}/scripts/buildsystems/vcpkg.cmake")
    set(CMAKE_TOOLCHAIN_FILE "${VCPKG_ROOT}/scripts/buildsystems/vcpkg.cmake" CACHE STRING "")
endif ()

project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

option(FMU_PROXY_BUILD_TESTS "Build tests" OFF)
option(FMU_PROXY_BUILD_EXAMPLES "Build examples" ON)

if(MSVC)
    add_definitions(-DNOMINMAX)
    add_definitions(-D_WIN32_WINNT=0x600)
    add_definitions(-D_CRT_SECURE_NO_WARNINGS)
endif()

SET(BOOST_COMPONENTS atomic program_options)
if (FMU_PROXY_BUILD_TESTS)
    SET(BOOST_COMPONENTS ${BOOST_COMPONENTS} unit_test_framework)
endif()

find_package(Boost 1.65 COMPONENTS ${BOOST_COMPONENTS} REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(JSON REQUIRED)
find_package(FMI4cpp CONFIG REQUIRED)
find_package(CURL REQUIRED)
find_package(OpenSSL REQUIRED)
find_package(Thrift REQUIRED)
find_package(Protobuf REQUIRED)
find_package(gRPC CONFIG REQUIRED)


# add subdiretories
add_subdirectory(src)
add_subdirectory(tool)

if (FMU_PROXY_BUILD_TESTS)
    add_subdirectory(tests)
endif()

if (FMU_PROXY_BUILD_EXAMPLES)
    add_subdirectory(examples)
endif()

