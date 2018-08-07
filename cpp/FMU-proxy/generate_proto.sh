#!/usr/bin/env bash

mkdir -p gen
./protoc -I="../../rpc-definitions/proto" --plugin=protoc-gen-grpc=grpc_cpp_plugin --cpp_out="gen" --grpc_out="gen" definitions.proto service.proto

sed -i 's/"service.pb.h"/<fmuproxy\/grpc\/common\/service.pb.h>/' gen/service.pb.cc
sed -i 's/"service.pb.h"/<fmuproxy\/grpc\/common\/service.pb.h>/' gen/service.grpc.pb.cc
sed -i 's/"service.grpc.pb.h"/<fmuproxy\/grpc\/common\/service.grpc.pb.h>/' gen/service.grpc.pb.cc
sed -i 's/"definitions.pb.h"/<fmuproxy\/grpc\/common\/definitions.pb.h>/' gen/definitions.pb.cc

mv gen/service.pb.h include/fmuproxy/grpc/common/
mv gen/service.grpc.pb.h include/fmuproxy/grpc/common/
mv gen/definitions.pb.h include/fmuproxy/grpc/common/

mv gen/service.pb.cc src/fmuproxy/grpc/common/
mv gen/service.grpc.pb.cc src/fmuproxy/grpc/common/
mv gen/definitions.pb.cc src/fmuproxy/grpc/common/

rm -r gen