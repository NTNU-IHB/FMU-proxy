thrift --gen py ../../rpc-definitions/thrift/service.thrift
move gen-py/service service
rmdir /Q /S gen-py