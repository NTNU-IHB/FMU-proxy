
INCLUDE_DIRECTORIES(${FMU_PROXY_SOURCE_DIR}/include/)

#set headers
SET(HEADER_ROOT_PATH ${FMU_PROXY_SOURCE_DIR}/include/fmuproxy)


##################################################################
#########################HEARTBEATING############################

SET(HEARTBEAT_HEADER_DIR ${HEADER_ROOT_PATH}/heartbeat)

SET(HEARTBEAT_HEADERS
        ${HEARTBEAT_HEADER_DIR}/RemoteAddress.hpp
        ${HEARTBEAT_HEADER_DIR}/Heartbeat.hpp)

SET(HEARTBEAT_SRC
        fmuproxy/heartbeat/Heartbeat.cpp)

add_library(heartbeat ${HEARTBEAT_HEADERS} ${HEARTBEAT_SRC})
target_link_libraries(heartbeat ${CURL_LIBRARIES} ${OPENSSL_LIBRARIES})
target_include_directories(heartbeat PRIVATE ${CURL_INCLUDE_DIRS} ${JSON_INCLUDE_DIRS})
if (UNIX)
    target_link_libraries(heartbeat pthread)
endif()

##################################################################
#########################GRPC#####################################

SET(GRPC_HEADER_DIR ${HEADER_ROOT_PATH}/grpc)

SET(GRPC_COMMON_HEADERS
        ${GRPC_HEADER_DIR}/common/definitions.pb.h
        ${GRPC_HEADER_DIR}/common/service.pb.h
        ${GRPC_HEADER_DIR}/common/service.grpc.pb.h)

SET(GRPC_CLIENT_HEADERS
        ${GRPC_HEADER_DIR}/client/GrpcClient.hpp
        ${GRPC_HEADER_DIR}/client/RemoteFmuSlave.hpp)

SET(GRPC_SERVER_HEADERS
        ${GRPC_HEADER_DIR}/server/GrpcServer.hpp
        ${GRPC_HEADER_DIR}/server/FmuServiceImpl.hpp)

SET(GRPC_COMMON_SRC
        fmuproxy/grpc/common/definitions.pb.cc
        fmuproxy/grpc/common/service.pb.cc
        fmuproxy/grpc/common/service.grpc.pb.cc)

SET(GRPC_CLIENT_SRC
        fmuproxy/grpc/client/GrpcClient.cpp
        fmuproxy/grpc/client/RemoteFmuSlave.cpp)

SET(GRPC_SERVER_SRC
        fmuproxy/grpc/server/GrpcServer.cpp
        fmuproxy/grpc/server/FmuServiceImpl.cpp)

add_library(grpc-common ${GRPC_COMMON_HEADERS} ${GRPC_COMMON_SRC})
target_link_libraries(grpc-common gRPC::grpc gRPC::grpc++ ${Protobuf_LIBRARIES} ${OPENSSL_LIBRARIES})
if (MSVC)
    target_link_libraries(grpc-common bcrypt)
endif()

add_library(grpc-client ${GRPC_CLIENT_HEADERS} ${GRPC_CLIENT_SRC})
target_link_libraries(grpc-client grpc-common FMI4cpp::FMI4cpp)

add_library(grpc-server ${FMI_HEADERS} ${GRPC_SERVER_HEADERS} ${GRPC_SERVER_SRC})
target_link_libraries(grpc-server grpc-common FMI4cpp::FMI4cpp)
if (UNIX)
    target_link_libraries(grpc-server pthread)
endif()


##################################################################
#########################THRIFT###################################

SET(THRIFT_HEADER_DIR ${HEADER_ROOT_PATH}/thrift)

SET(THRIFT_COMMON_HEADERS
        ${THRIFT_HEADER_DIR}/common/definitions_types.h
        ${THRIFT_HEADER_DIR}/common/FmuService.h
        ${THRIFT_HEADER_DIR}/common/service_types.h)

SET(THRIFT_CLIENT_HEADERS
        ${THRIFT_HEADER_DIR}/client/RemoteFmuSlave.hpp
        ${THRIFT_HEADER_DIR}/client/ThriftClient.hpp)

SET(THRIFT_SERVER_HEADERS
        ${THRIFT_HEADER_DIR}/server/FmuServiceHandler.hpp
        ${THRIFT_HEADER_DIR}/server/ThriftServer.hpp)

SET(THRIFT_COMMON_SRC
        fmuproxy/thrift/common/service_types.cpp
        fmuproxy/thrift/common/definitions_types.cpp
        fmuproxy/thrift/common/FmuService.cpp)

SET(THRIFT_CLIENT_SRC
        fmuproxy/thrift/client/thrift_client_helper.hpp
        fmuproxy/thrift/client/RemoteFmuSlave.cpp
        fmuproxy/thrift/client/ThriftClient.cpp)

SET(THRIFT_SERVER_SRC
        fmuproxy/thrift/server/FmuServiceHandler.cpp
        fmuproxy/thrift/server/ThriftServer.cpp)

add_library(thrift-common ${THRIFT_COMMON_HEADERS} ${THRIFT_COMMON_SRC})
target_link_libraries(thrift-common ${THRIFT_LIBRARIES} ${OPENSSL_LIBRARIES})
target_include_directories(thrift-common PUBLIC ${THRIFT_INCLUDE_DIRS})
if (MSVC)
    target_link_libraries(thrift-common bcrypt)
endif()

add_library(thrift-client ${FMI_HEADERS} ${THRIFT_CLIENT_HEADERS} ${THRIFT_CLIENT_SRC})
target_link_libraries(thrift-client thrift-common FMI4cpp::FMI4cpp)

add_library(thrift-server ${FMI_HEADERS} ${THRIFT_SERVER_HEADERS} ${THRIFT_SERVER_SRC})
target_link_libraries(thrift-server thrift-common FMI4cpp::FMI4cpp)
if (UNIX)
    target_link_libraries(thrift-server pthread)
endif()

##################################################################