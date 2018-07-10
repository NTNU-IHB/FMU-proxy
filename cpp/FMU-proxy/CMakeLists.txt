cmake_minimum_required(VERSION 3.10)
project(FMU-proxy)

set(CMAKE_CXX_STANDARD 14)

SET(FMILIB_HOME $ENV{FMILIB_HOME})

list (APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

find_package(Boost 1.63.0 COMPONENTS system filesystem REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

SET(FMILIB_USE_SHARED_LIB true)
find_package(FMILIB REQUIRED)
IF(FMILIB_FOUND)
    MESSAGE(STATUS "FMI library found")
ELSE(FMILIB_FOUND)
    MESSAGE(FATAL_ERROR "FMI library not found but required. Set FMILIB_HOME to the location containing lib and include folder of FMI library.")
ENDIF(FMILIB_FOUND)

add_subdirectory(src)




