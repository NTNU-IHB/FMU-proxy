
add_executable(Benchmark
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/FmuWrapper.cpp
        common/FmuWrapper.hpp
        common/Util.hpp
        test/Benchmark.cpp)
target_link_libraries(Benchmark thrift ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY})


add_executable(FmuTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/FmuWrapper.cpp
        common/FmuWrapper.hpp
        common/Util.hpp
        test/FmuTest.cpp)
target_link_libraries(FmuTest thrift ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY})


add_executable(ThriftServerTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        common/ThriftHelper.hpp
        common/FmuWrapper.cpp
        common/FmuWrapper.hpp
        common/FmuHelper.hpp
        common/Util.hpp
        server/FmuServiceHandler.hpp
        server/FmuServiceHandler.cpp
        server/ThriftServer.hpp
        server/ThriftServer.cpp
        test/ThriftServerTest.cpp)
target_link_libraries(ThriftServerTest thrift ${FMILIB_LIBRARIES} ${Boost_FILESYSTEM_LIBRARY} ${Boost_SYSTEM_LIBRARY} pthread)

add_executable(ThriftClientTest
        common/thrift-gen/definitions_types.cpp
        common/thrift-gen/definitions_types.h
        common/thrift-gen/service_types.h
        common/thrift-gen/FmuService.cpp
        common/thrift-gen/FmuService.h
        client/thrift/ThriftClient.cpp
        client/thrift/ThriftClient.hpp
        test/ThriftClientTest.cpp)
target_link_libraries(ThriftClientTest thrift ${FMILIB_LIBRARIES})