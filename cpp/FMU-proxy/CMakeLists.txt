cmake_minimum_required(VERSION 3.10)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 14)

list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

find_package(Boost 1.63.0 COMPONENTS system filesystem REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

set(FMILIB_USE_SHARED_LIB true)
find_package(FMILIB REQUIRED)
IF(FMILIB_FOUND)
    MESSAGE(STATUS "FMI library found")
ELSE(FMILIB_FOUND)
    MESSAGE(FATAL_ERROR "FMI library not found but required. Set FMILIB_HOME to the location containing lib and include folder of FMI library.")
ENDIF(FMILIB_FOUND)

find_package(CURL REQUIRED)
include_directories(${CURL_INCLUDE_DIRS})

# add subdiretories
add_subdirectory(src)
add_subdirectory(example)






