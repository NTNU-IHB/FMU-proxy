#!/usr/bin/env bash
python -m grpc_tools.protoc --proto_path=../../rpc-definitions/proto --python_out=. --grpc_python_out=. ../../rpc-definitions/proto/service.proto
mkdir -p service
mv service_pb2.py service/service_pb2.py
mv service_pb2_grpc.py service/service_pb2_grpc.py

touch service/__init__.py
echo "__all__= ['service_pb2_grpc', 'service_pb2']" > service/__init__.py

sed -i 's/service_pb2/service.service_pb2/' service/service_pb2_grpc.py