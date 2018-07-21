cmake_minimum_required(VERSION 3.10)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 14)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

option(BUILD_EXAMPLES "Build examples" ON)
option(BUILD_TESTS "Build tests" ON)
option(FMILIB_USE_SHARED_LIB "Use shared fmilib" ON)

set(FMILIB_HOME $ENV{FMILIB_HOME} CACHE STRING "FMI Library home")
set(CURL_HOME $ENV{CURL_HOME} CACHE STRING "Curl home")
set(THRIFT_HOME $ENV{THRIFT_HOME} CACHE STRING "Thrift home")

if(MSVC)
    add_definitions(-DNOMINMAX)
    add_definitions(-DCURL_STATICLIB)
    set(Boost_USE_STATIC_LIBS ON)
endif()

find_package(Boost 1.65.1 COMPONENTS system filesystem program_options atomic REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(FMILIB REQUIRED)
include_directories(${FMILIB_INCLUDE_DIRS})

find_package(CURL REQUIRED)
include_directories(${CURL_INCLUDE_DIRS})

find_package(THRIFT REQUIRED)
include_directories(${THRIFT_INCLUDE_DIRS})

set(tool_dest "bin")

# add subdiretories
add_subdirectory(src)
add_subdirectory(tool)
if (BUILD_EXAMPLES)
    add_subdirectory(examples)
endif ()
if (BUILD_TESTS)
    add_subdirectory(test)
endif ()
