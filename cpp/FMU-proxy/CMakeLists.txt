
if (WIN32)
    OPTION(USE_VCPKG "per" ON)
else()
    OPTION(USE_VCPKG "per" OFF)
endif()

if (USE_VCPKG)

    cmake_minimum_required(VERSION 3.11)

    SET(VCPKG_ROOT $ENV{VCPKG_ROOT} CACHE STRING "VCPKG_ROOT")
    if(NOT DEFINED VCPKG_ROOT)
            message(FATAL_ERROR "USE_VCPKG=ON, but VCPKG_ROOT is not set!")
    endif()

    if(NOT DEFINED CMAKE_TOOLCHAIN_FILE)
        set(CMAKE_TOOLCHAIN_FILE "${VCPKG_ROOT}/scripts/buildsystems/vcpkg.cmake"
                CACHE STRING "")
    endif()

else()
    cmake_minimum_required(VERSION 3.10)
endif()

project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

option(BUILD_EXAMPLES "Build examples" ON)
option(BUILD_TESTS "Build tests" ON)
option(FMILIB_USE_SHARED_LIB "Use shared fmilib" ON)

set(FMILIB_HOME $ENV{FMILIB_HOME} CACHE STRING "FMI Library home")

if(MSVC)
    add_definitions(-DNOMINMAX)
    add_definitions(-DCURL_STATICLIB)
    add_definitions(-D_WIN32_WINNT=0x600)
    set(Boost_USE_STATIC_LIBS ON)
endif()

find_package(Boost 1.65.1 COMPONENTS system filesystem program_options atomic REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(FMILIB REQUIRED)
find_package(CURL REQUIRED)
find_package(OpenSSL REQUIRED)
find_package(Thrift REQUIRED)
find_package(Protobuf REQUIRED)
if (USE_VCPKG)
    find_package(gRPC CONFIG REQUIRED)
else()
    find_package(gRPC REQUIRED)
endif()

set(tool_dest "bin")

# add subdiretories
add_subdirectory(src)
add_subdirectory(tool)
if (BUILD_EXAMPLES)
    add_subdirectory(examples)
endif()
if (BUILD_TESTS)
    add_subdirectory(test)
endif()
