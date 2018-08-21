
cmake_minimum_required(VERSION 3.12)

SET(VCPKG_ROOT $ENV{VCPKG_ROOT} CACHE STRING "VCPKG_ROOT")
if(NOT DEFINED VCPKG_ROOT)
    message(FATAL_ERROR "VCPKG_ROOT is not set!")
endif()

if(NOT DEFINED CMAKE_TOOLCHAIN_FILE)
    set(CMAKE_TOOLCHAIN_FILE "${VCPKG_ROOT}/scripts/buildsystems/vcpkg.cmake"
            CACHE STRING "")
endif()

project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

option(BUILD_TESTS "Build tests" OFF)
option(BUILD_EXAMPLES "Build examples" ON)

if(MSVC)
    add_definitions(-DNOMINMAX)
    add_definitions(-D_WIN32_WINNT=0x600)
endif()

SET(BOOST_COMPONENTS atomic system filesystem program_options)
if (BUILD_TESTS)
    SET(BOOST_COMPONENTS ${BOOST_COMPONENTS} unit_test_framework)
endif()

find_package(Boost 1.67 COMPONENTS ${BOOST_COMPONENTS} REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(JSON REQUIRED)
find_package(FMILIB REQUIRED)
find_package(CURL REQUIRED)
find_package(OpenSSL REQUIRED)
find_package(Thrift REQUIRED)
find_package(Protobuf REQUIRED)
find_package(gRPC CONFIG REQUIRED)

set(tool_dest "bin")

# add subdiretories
add_subdirectory(src)
add_subdirectory(tool)

if (BUILD_TESTS)
    add_subdirectory(tests)
endif()

if (BUILD_EXAMPLES)
    add_subdirectory(examples)
endif()

