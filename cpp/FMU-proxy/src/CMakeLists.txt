

add_library(fmi
        fmi/Fmu.cpp
        fmi/Fmu.hpp
        fmi/FmuHelper.cpp
        fmi/FmuInstance.cpp
        fmi/FmuInstance.hpp
        fmi/FmiSimulation.hpp
        fmi/FmiDefinitions.hpp
        fmi/ScalarVariableAttributes.hpp fmi/FmuVariableAccess.hpp)
target_link_libraries(fmi ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY})


add_library(thrift-gen
        thrift/thrift-gen/FmuService.h
        thrift/thrift-gen/FmuService.cpp
        thrift/thrift-gen/service_types.h
        thrift/thrift-gen/definitions_types.cpp
        thrift/thrift-gen/definitions_types.h)
target_link_libraries(thrift-gen thrift)


add_library(thrift-client
        thrift/client/ThriftClient.cpp
        thrift/client/ThriftClient.hpp
        thrift/client/RemoteFmuInstance.hpp
        thrift/client/RemoteFmuInstance.cpp thrift/client/Helper.cpp)
target_link_libraries(thrift-client thrift-gen fmi)


add_library(thrift-server STATIC
        thrift/server/ThriftHelper.cpp
        thrift/server/ThriftServer.hpp
        thrift/server/ThriftServer.cpp
        thrift/server/FmuServiceHandler.hpp
        thrift/server/FmuServiceHandler.cpp)
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

