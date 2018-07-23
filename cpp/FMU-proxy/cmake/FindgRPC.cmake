# Find gRPC
#
# Find the native Thrift headers and libraries.
#
#   GRPC_INCLUDE_DIRS   - where to find grpc/grpc.h etc..
#   GRPC_LIBRARIES      - List of libraries when using GRPC.
#   GRPC_FOUND          - True if gRPC found.

cmake_minimum_required(VERSION 3.10)

find_path(GRPC_INCLUDE_DIR NAMES grpc/grpc.h)
mark_as_advanced(GRPC_INCLUDE_DIR)

find_library(PROTOBUF_LIBRARY NAMES libprotobuf.a PATH_SUFFIXES protobuf)
mark_as_advanced(PROTOBUF_LIBRARY)

find_library(GRPC_LIBRARY NAMES grpc++_unsecure)
mark_as_advanced(GRPC_LIBRARY)

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(GRPC
        REQUIRED_VARS GRPC_LIBRARY PROTOBUF_LIBRARY GRPC_INCLUDE_DIR)

if (GRPC_FOUND)
    set(GRPC_LIBRARIES ${GRPC_LIBRARY} ${PROTOBUF_LIBRARY})
    set(GRPC_INCLUDE_DIRS ${GRPC_INCLUDE_DIR})
endif ()

if (GRPC_PRINT_VARS)
    message("GRPC find script variables:")
    message("  GRPC_INCLUDE_DIRS   = ${GRPC_INCLUDE_DIRS}")
    message("  GRPC_LIBRARIES      = ${GRPC_LIBRARIES}")
endif ()