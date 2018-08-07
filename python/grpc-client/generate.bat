python -m grpc_tools.protoc --proto_path=../../rpc-definitions/proto --python_out=. --grpc_python_out=. ../../rpc-definitions/proto/definitions.proto ../../rpc-definitions/proto/service.proto
move definitions_pb2.py definitions/definitions_pb2.py
move service_pb2.py definitions/service_pb2.py
move service_pb2_grpc.py definitions/service_pb2_grpc.py
del definitions_pb2_grpc.py