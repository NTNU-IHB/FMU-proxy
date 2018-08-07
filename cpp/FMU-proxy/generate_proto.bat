
if not exist "gen" mkdir gen
protoc -I="../../rpc-definitions/proto" --plugin=protoc-gen-grpc=grpc_cpp_plugin --cpp_out="gen" --grpc_out="gen" definitions.proto service.proto

move gen/service.pb.h include/fmuproxy/grpc/common/
move gen/service.grpc.pb.h include/fmuproxy/grpc/common/
move gen/definitions.pb.h include/fmuproxy/grpc/common/

move gen/service.pb.cc src/fmuproxy/grpc/common/
move gen/service.grpc.pb.cc src/fmuproxy/grpc/common/
move gen/definitions.pb.cc src/fmuproxy/grpc/common/

rmdir gen