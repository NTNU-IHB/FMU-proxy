import grpc
from definitions_pb2 import Empty
from definitions_pb2 import Int
from definitions_pb2 import InitRequest
from definitions_pb2 import StepRequest
from definitions_pb2 import TerminateRequest
import service_pb2_grpc


class FmuInstance:

    def __init__(self, stub):
        self._stub = stub
        self._id = self._stub.CreateInstance(Empty()).fmu_id

    def get_current_time(self):
        ref = Int()
        ref.value = self._id
        return self._stub.GetCurrentTime(ref).value

    def init(self):
        request = InitRequest()
        request.fmu_id = self._id
        return self._stub.Init(request).value

    def step(self, dt):
        request = StepRequest()
        request.fmu_id = self._id
        request.dt = dt
        return self._stub.Step(request)

    def terminate(self):
        request = TerminateRequest()
        request.fmu_id = self._id
        self._stub.Terminate(request)

    def get_model_variables(self):
        return self._stub.GetModelVariables(Empty()).values


class GenericFmuClient:

    def __init__(self, host_address, port):
        self._channel = grpc.insecure_channel(host_address + ':' + str(port))
        self._stub = service_pb2_grpc.GenericFmuServiceStub(self._channel)

    def get_model_name(self):
        return self._stub.GetModelName(Empty())

    def create_instance(self):
        return FmuInstance(self._stub)










