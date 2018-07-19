cmake_minimum_required(VERSION 3.10)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 14)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

if(MSVC)
    add_definitions(-DNOMINMAX)
    add_definitions(-DCURL_STATICLIB)
    set(Boost_USE_STATIC_LIBS ON)
endif()

find_package(Boost 1.65.1 COMPONENTS system filesystem program_options REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(FMILIB REQUIRED)
include_directories(${FMILIB_INCLUDE_DIRS})

find_package(CURL REQUIRED)
include_directories(${CURL_INCLUDE_DIRS})

find_package(THRIFT REQUIRED)
include_directories(${THRIFT_INCLUDE_DIRS})

# add subdiretories
add_subdirectory(src)
add_subdirectory(tool)
add_subdirectory(example)
