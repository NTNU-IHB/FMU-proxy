# Find Thrift
#
# Find the native Thrift headers and libraries.
#
#   THRIFT_INCLUDE_DIRS   - where to find thrift/thrift.h
#   THRIFT_LIBRARIES      - List of libraries when using Thrift.
#   THRIFT_FOUND          - True if Thrift found.

cmake_minimum_required (VERSION 3.10)

find_path(THRIFT_INCLUDE_DIR NAMES
        thrift/Thrift.h
        PATHS
        ${THRIFT_HOME}/include)
mark_as_advanced(THRIFT_INCLUDE_DIR)

find_library(THRIFT_LIBRARY NAMES THRIFT thrift thriftmd PATHS ${THRIFT_HOME}/lib)
mark_as_advanced(THRIFT_LIBRARY)

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(THRIFT
        REQUIRED_VARS THRIFT_LIBRARY THRIFT_INCLUDE_DIR)

if(THRIFT_FOUND)
    set(THRIFT_LIBRARIES ${THRIFT_LIBRARY})
    set(THRIFT_INCLUDE_DIRS ${THRIFT_INCLUDE_DIR})
endif()

if (THRIFT_PRINT_VARS)
    message ("THRIFT find script variables:")
    message ("  THRIFT_INCLUDE_DIRS   = ${THRIFT_INCLUDE_DIRS}")
    message ("  THRIFT_LIBRARIES      = ${THRIFT_LIBRARIES}")
endif ()