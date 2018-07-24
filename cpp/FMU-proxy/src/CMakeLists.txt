
cmake_minimum_required(VERSION ${CMAKE_MINIMUM_REQUIRED_VERSION})

INCLUDE_DIRECTORIES(${FMU_PROXY_SOURCE_DIR}/include/)

#set headers
SET(HEADER_ROOT_PATH ${FMU_PROXY_SOURCE_DIR}/include/fmuproxy)

#########################FMI############################
SET(FMI_HEADER_DIR ${HEADER_ROOT_PATH}/fmi)
SET(FMI_HEADERS
        ${FMI_HEADER_DIR}/Fmu.hpp
        ${FMI_HEADER_DIR}/FmuInstance.hpp
        ${FMI_HEADER_DIR}/FmiSimulation.hpp
        ${FMI_HEADER_DIR}/fmi_definitions.hpp
        ${FMI_HEADER_DIR}/ScalarVariableAttributes.hpp)

SET(FMI_SRC
        fmuproxy/fmi/Fmu.cpp
        fmuproxy/fmi/fmu_helper.cpp
        fmuproxy/fmi/FmuInstance.cpp)

add_library(fmi ${FMI_HEADERS} ${FMI_SRC})
target_link_libraries(fmi ${FMILIB_LIBRARIES} Boost::filesystem Boost::system)
target_include_directories(fmi PUBLIC ${FMILIB_INCLUDE_DIRS})
if (UNIX)
    target_link_libraries(fmi dl)
endif()

##################################################################
#########################HEARTBEATING############################

SET(HEARTBEAT_HEADER_DIR ${HEADER_ROOT_PATH}/heartbeat)

SET(HEARTBEAT_HEADERS
        ${HEARTBEAT_HEADER_DIR}/Heartbeat.hpp)

SET(HEARTBEAT_SRC
        fmuproxy/heartbeat/Heartbeat.cpp
        fmuproxy/heartbeat/heartbeat_helper.cpp)

add_library(heartbeat ${HEARTBEAT_HEADERS} ${HEARTBEAT_SRC})
target_link_libraries(heartbeat ${CURL_LIBRARIES} Boost::system)
target_include_directories(heartbeat PRIVATE ${CURL_INCLUDE_DIRS})
if (UNIX)
    target_link_libraries(heartbeat pthread)
elseif (MSVC)
    target_link_libraries(heartbeat bcrypt) #wldap32 crypt32 Ws2_32 Normaliz
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
        ${GRPC_HEADER_DIR}/client/RemoteFmuInstance.hpp)

SET(GRPC_SERVER_HEADERS
        ${GRPC_HEADER_DIR}/server/GrpcServer.hpp
        ${GRPC_HEADER_DIR}/server/FmuServiceImpl.hpp)

SET(GRPC_COMMON_SRC
        fmuproxy/grpc/common/definitions.pb.cc
        fmuproxy/grpc/common/service.pb.cc
        fmuproxy/grpc/common/service.grpc.pb.cc)

SET(GRPC_CLIENT_SRC
        fmuproxy/grpc/client/GrpcClient.cpp
        fmuproxy/grpc/client/RemoteFmuInstance.cpp
        fmuproxy/grpc/client/grpc_client_helper.cpp)

SET(GRPC_SERVER_SRC
        fmuproxy/grpc/server/GrpcServer.cpp
        fmuproxy/grpc/server/FmuServiceImpl.cpp
        fmuproxy/grpc/server/grpc_server_helper.cpp)

add_library(grpc-common ${GRPC_COMMON_HEADERS} ${GRPC_COMMON_SRC})
if (WIN32)
    target_link_libraries(grpc-common PRIVATE gRPC::gpr gRPC::grpc gRPC::grpc++ gRPC::grpc_cronet ${Protobuf_LIBRARIES})
    target_include_directories(grpc-common PRIVATE ${Protobuf_INCLUDE_DIRS})
else()
    target_link_libraries(grpc-common PRIVATE ${GRPC_LIBRARIES})
    target_include_directories(grpc-common PRIVATE ${GRPC_INCLUDE_DIRS})
endif()


add_library(grpc-client ${GRPC_CLIENT_HEADERS} ${GRPC_CLIENT_SRC})
target_link_libraries(grpc-client grpc-common fmi)

add_library(grpc-server ${FMI_HEADERS} ${GRPC_SERVER_HEADERS} ${GRPC_SERVER_SRC})
target_link_libraries(grpc-server grpc-common fmi)
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
        ${THRIFT_HEADER_DIR}/client/RemoteFmuInstance.hpp
        ${THRIFT_HEADER_DIR}/client/ThriftClient.hpp)

SET(THRIFT_SERVER_HEADERS
        ${THRIFT_HEADER_DIR}/server/FmuServiceHandler.hpp
        ${THRIFT_HEADER_DIR}/server/ThriftServer.hpp)

SET(THRIFT_COMMON_SRC
        fmuproxy/thrift/common/definitions_types.cpp
        fmuproxy/thrift/common/FmuService.cpp)

SET(THRIFT_CLIENT_SRC
        fmuproxy/thrift/client/thrift_client_helper.cpp
        fmuproxy/thrift/client/RemoteFmuInstance.cpp
        fmuproxy/thrift/client/ThriftClient.cpp)

SET(THRIFT_SERVER_SRC
        fmuproxy/thrift/server/FmuServiceHandler.cpp
        fmuproxy/thrift/server/thrift_server_helper.cpp
        fmuproxy/thrift/server/ThriftServer.cpp)

add_library(thrift-common ${THRIFT_COMMON_HEADERS} ${THRIFT_COMMON_SRC})
target_link_libraries(thrift-common ${THRIFT_LIBRARIES} ${OPENSSL_LIBRARIES})
target_include_directories(thrift-common PRIVATE ${THRIFT_INCLUDE_DIRS} ${OpenSSL_INCLUDE_DIRS})

add_library(thrift-client ${FMI_HEADERS} ${THRIFT_CLIENT_HEADERS} ${THRIFT_CLIENT_SRC})
target_link_libraries(thrift-client thrift-common fmi)

add_library(thrift-server ${FMI_HEADERS} ${THRIFT_SERVER_HEADERS} ${THRIFT_SERVER_SRC})
target_link_libraries(thrift-server thrift-common fmi)
if (UNIX)
    target_link_libraries(thrift-server pthread)
endif()

##################################################################