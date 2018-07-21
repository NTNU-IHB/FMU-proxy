# Find Thrift
#
# Find the native Thrift headers and libraries.
#
#   GRPC_INCLUDE_DIRS   - where to find thrift/thrift.h
#   GRPC_LIBRARIES      - List of libraries when using Thrift.
#   GRPC_FOUND          - True if Thrift found.

cmake_minimum_required(VERSION 3.10)

find_path(GRPC_INCLUDE_DIR NAMES
        grpc/grpc.h
        PATHS
        ${GRPC_HOME}/include)
mark_as_advanced(GRPC_INCLUDE_DIR)

find_path(GRPCPP_INCLUDE_DIR NAMES
        grpcpp/grpcpp.h
        PATHS
        ${GRPC_HOME}/include)
mark_as_advanced(GRPCPP_INCLUDE_DIR)

find_library(PROTOBUF_LIBRARY NAMES libprotobuf.a PATHS ${GRPC_HOME}/lib PATH_SUFFIXES protobuf)
mark_as_advanced(PROTOBUF_LIBRARY)

find_library(GRPC_LIBRARY NAMES grpc++_unsecure PATHS ${GRPC_HOME}/lib)
mark_as_advanced(GRPC_LIBRARY)

message(${GRPC_LIBRARY})

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(GRPC
        REQUIRED_VARS GRPC_LIBRARY PROTOBUF_LIBRARY GRPC_INCLUDE_DIR GRPCPP_INCLUDE_DIR)

if (GRPC_FOUND)
    set(GRPC_LIBRARIES ${GRPC_LIBRARY} ${PROTOBUF_LIBRARY})
    set(GRPC_INCLUDE_DIRS ${GRPC_INCLUDE_DIR} ${GRPCPP_INCLUDE_DIR})
endif ()

if (GRPC_PRINT_VARS)
    message("GRPC find script variables:")
    message("  GRPC_INCLUDE_DIRS   = ${GRPC_INCLUDE_DIRS}")
    message("  GRPC_LIBRARIES      = ${GRPC_LIBRARIES}")
endif ()