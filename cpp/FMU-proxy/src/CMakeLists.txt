

add_executable(FmuTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/FmuWrapper.cpp
        common/FmuWrapper.h
        test/FmuTest.cpp)
target_link_libraries(FmuTest ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY})


add_executable(ThriftServerTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        common/ThriftHelper.h
        common/FmuWrapper.cpp
        common/FmuWrapper.h
        common/FmuHelper.h
        server/FmuServiceHandler.h
        server/FmuServiceHandler.cpp
        server/ThriftServer.h
        server/ThriftServer.cpp
        test/ThriftServerTest.cpp)
target_link_libraries(ThriftServerTest thrift ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY} pthread)

add_executable(ThriftClientTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        client/ThriftClient.cpp
        client/ThriftClient.h
        test/ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest thrift ${FMILIB_LIBRARIES})