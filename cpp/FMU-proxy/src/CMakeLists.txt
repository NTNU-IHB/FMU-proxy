

add_library(fmi STATIC
        fmi/FmiDefinitions.hpp
        fmi/FmiHelper.hpp
        fmi/FmuWrapper.cpp
        fmi/FmuWrapper.hpp
        fmi/ScalarVariableAttribute.hpp)
target_link_libraries(fmi ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY})


add_library(thrift-gen STATIC
        thrift/thrift-gen/definitions_types.cpp
        thrift/thrift-gen/definitions_types.h
        thrift/thrift-gen/service_types.h
        thrift/thrift-gen/FmuService.h
        thrift/thrift-gen/FmuService.cpp)
target_link_libraries(thrift-gen thrift)


add_library(thrift-client STATIC
        thrift/client/ThriftClient.cpp
        thrift/client/ThriftClient.hpp)
target_link_libraries(thrift-client thrift-gen)


add_library(thrift-server STATIC
        thrift/server/ThriftHelper.hpp
        thrift/server/FmuServiceHandler.hpp
        thrift/server/FmuServiceHandler.cpp
        thrift/server/ThriftServer.hpp
        thrift/server/ThriftServer.cpp)
target_link_libraries(thrift-server thrift-gen fmi)


add_executable(Benchmark
        test/Benchmark.cpp
        test/TestUtil.hpp)
target_link_libraries(Benchmark fmi)


add_executable(FmuTest
        test/FmuTest.cpp
        test/TestUtil.hpp)
target_link_libraries(FmuTest fmi)


add_executable(ThriftClientTest
        test/ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest thrift-client)

add_executable(ThriftServerTest
        test/ThriftServerTest.cpp)
target_link_libraries(ThriftServerTest thrift-server pthread)

