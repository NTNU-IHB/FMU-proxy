cmake_minimum_required(VERSION 3.10)

INCLUDE_DIRECTORIES(${FMU_PROXY_SOURCE_DIR}/include/)

#set headers
SET(HEADER_ROOT_PATH ${FMU_PROXY_SOURCE_DIR}/include/fmuproxy)
SET(FMI_HEADER_DIR ${HEADER_ROOT_PATH}/fmi)
SET(THRIFT_HEADER_DIR ${HEADER_ROOT_PATH}/thrift)
SET(HEARTBEAT_HEADER_DIR ${HEADER_ROOT_PATH}/heartbeat)

SET(FMI_HEADERS
        ${FMI_HEADER_DIR}/Fmu.hpp
        ${FMI_HEADER_DIR}/FmuInstance.hpp
        ${FMI_HEADER_DIR}/FmiSimulation.hpp
        ${FMI_HEADER_DIR}/fmi_definitions.hpp
        ${FMI_HEADER_DIR}/ScalarVariableAttributes.hpp)

SET(HEARTBEAT_HEADERS
        ${HEARTBEAT_HEADER_DIR}/Heartbeat.hpp)

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


#set source files
SET(FMI_SRC
        fmuproxy/fmi/Fmu.cpp
        fmuproxy/fmi/fmu_helper.cpp
        fmuproxy/fmi/FmuInstance.cpp)

SET(HEARTBEAT_SRC
        fmuproxy/heartbeat/Heartbeat.cpp
        fmuproxy/heartbeat/heartbeat_helper.cpp)

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

add_library(fmi ${FMI_HEADERS} ${FMI_SRC})
target_link_libraries(fmi ${FMILIB_LIBRARIES} Boost::filesystem Boost::system)

add_library(heartbeat ${HEARTBEAT_HEADERS} ${HEARTBEAT_SRC})
target_link_libraries(heartbeat ${CURL_LIBRARIES} Boost::system)
if(UNIX)
    target_link_libraries(heartbeat pthread)
elseif(MSVC)
    target_link_libraries(heartbeat wldap32 crypt32 Ws2_32 Normaliz)
endif()

add_library(thrift-common ${THRIFT_COMMON_HEADERS} ${THRIFT_COMMON_SRC})
target_link_libraries(thrift-common thrift)

add_library(thrift-client ${FMI_HEADERS} ${THRIFT_CLIENT_HEADERS} ${THRIFT_CLIENT_SRC})
target_link_libraries(thrift-client thrift-common fmi)

add_library(thrift-server ${FMI_HEADERS} ${THRIFT_SERVER_HEADERS} ${THRIFT_SERVER_SRC})
target_link_libraries(thrift-server thrift-common fmi)
if(UNIX)
    target_link_libraries(thrift-server pthread)
endif()
