
INCLUDE_DIRECTORIES(${FMU_PROXY_SOURCE_DIR}/include/)

##################################################################
#########################HEARTBEATING############################

SET(HEARTBEAT_SRC
        fmuproxy/heartbeat/Heartbeat.cpp)

add_library(heartbeat ${HEARTBEAT_SRC})
target_link_libraries(heartbeat PRIVATE ${CURL_LIBRARIES} ${OPENSSL_LIBRARIES})
target_include_directories(heartbeat PRIVATE ${CURL_INCLUDE_DIRS} ${JSON_INCLUDE_DIRS})
if (UNIX)
    target_link_libraries(heartbeat PRIVATE pthread)
endif()

##################################################################
#########################GRPC#####################################

if(FMU_PROXY_WITH_GRPC)
    SET(GRPC_COMMON_SRC
            fmuproxy/grpc/common/service.pb.cc
            fmuproxy/grpc/common/service.grpc.pb.cc)

    SET(GRPC_CLIENT_SRC
            fmuproxy/grpc/client/GrpcClient.cpp
            fmuproxy/grpc/client/RemoteFmuSlave.cpp)

    SET(GRPC_SERVER_SRC
            fmuproxy/grpc/server/GrpcServer.cpp
            fmuproxy/grpc/server/FmuServiceImpl.cpp)

    add_library(grpc-common ${GRPC_COMMON_SRC})
    target_link_libraries(grpc-common PUBLIC gRPC::grpc gRPC::grpc++ PRIVATE ${Protobuf_LIBRARIES} ${OPENSSL_LIBRARIES})

    add_library(grpc-client ${GRPC_CLIENT_SRC})
    target_link_libraries(grpc-client PUBLIC grpc-common FMI4cpp::fmi4cpp)

    add_library(grpc-server ${GRPC_SERVER_SRC})
    target_link_libraries(grpc-server PUBLIC grpc-common FMI4cpp::fmi4cpp)
    if (UNIX)
        target_link_libraries(grpc-server PRIVATE pthread)
    endif()
endif()


##################################################################
#########################THRIFT###################################

if (FMU_PROXY_WITH_THRIFT)
    SET(THRIFT_COMMON_SRC
            fmuproxy/thrift/common/service_types.cpp
            fmuproxy/thrift/common/FmuService.cpp)

    SET(THRIFT_CLIENT_SRC
            fmuproxy/thrift/client/thrift_client_helper.hpp
            fmuproxy/thrift/client/RemoteFmuSlave.cpp
            fmuproxy/thrift/client/ThriftClient.cpp)

    SET(THRIFT_SERVER_SRC
            fmuproxy/thrift/server/FmuServiceHandler.cpp
            fmuproxy/thrift/server/ThriftServer.cpp)

    add_library(thrift-common ${THRIFT_COMMON_SRC})
    target_link_libraries(thrift-common PUBLIC thrift::thrift PRIVATE ${OPENSSL_LIBRARIES})

    add_library(thrift-client ${THRIFT_CLIENT_SRC})
    target_link_libraries(thrift-client PUBLIC thrift-common FMI4cpp::fmi4cpp)

    add_library(thrift-server ${THRIFT_SERVER_SRC})
    target_link_libraries(thrift-server PUBLIC thrift-common FMI4cpp::fmi4cpp PRIVATE thrift::thriftnb event)
    if (UNIX)
        target_link_libraries(thrift-server PRIVATE pthread)
    endif()
endif()

##################################################################