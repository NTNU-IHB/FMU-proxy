python -m grpc_tools.protoc --proto_path=../../../rpc-definitions/proto --python_out=. --grpc_python_out=. ../../../rpc-definitions/proto/service.proto
if not exist "service" mkdir service
move service_pb2.py service/service_pb2.py
move service_pb2_grpc.py service/service_pb2_grpc.py
