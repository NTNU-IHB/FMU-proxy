
add_library(thrift-gen STATIC
        thrift-gen/definitions_types.cpp
        thrift-gen/definitions_types.h
        thrift-gen/service_types.h
        thrift-gen/FmuService.h
        thrift-gen/FmuService.cpp)
target_link_libraries(thrift-gen thrift)


add_library(common STATIC
        common/FmuHelper.hpp
        common/FmuWrapper.cpp
        common/FmuWrapper.hpp
        common/ThriftHelper.hpp
        common/Util.hpp)
target_link_libraries(common thrift-gen ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY})

add_library(server STATIC
        server/FmuServiceHandler.hpp
        server/FmuServiceHandler.cpp
        server/ThriftServer.hpp
        server/ThriftServer.cpp)
target_link_libraries(server common)

add_library(client STATIC
        client/thrift/ThriftClient.cpp
        client/thrift/ThriftClient.hpp)
target_link_libraries(client common)

add_executable(Benchmark
        test/Benchmark.cpp)
target_link_libraries(Benchmark common)


add_executable(FmuTest
        test/FmuTest.cpp)
target_link_libraries(FmuTest common)


add_executable(ThriftServerTest
        test/ThriftServerTest.cpp)
target_link_libraries(ThriftServerTest common server pthread)

add_executable(ThriftClientTest
        test/ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest common client)