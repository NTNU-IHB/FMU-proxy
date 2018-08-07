thrift -r --gen py ../../rpc-definitions/thrift/service.thrift
move gen-py/definitions definitions
move gen-py/service service
rmdir gen-py