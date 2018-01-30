import grpc
from definitions_pb2 import Empty
from definitions_pb2 import ModelReference
from definitions_pb2 import InitRequest
from definitions_pb2 import StepRequest
from definitions_pb2 import TerminateRequest
import service_pb2_grpc


class FmuInstance:

    def __init__(self, stub):
        self._stub = stub
        self._id = self._stub.CreateInstance(Empty()).fmu_id

    def getCurrentTime(self):
        ref = ModelReference()
        ref.fmu_id = self._id
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

class GenericFmuClient:

    def __init__(self, hostAddress, port):
        self._channel = grpc.insecure_channel(hostAddress + ':' + str(port))
        self._stub = service_pb2_grpc.GenericFmuServiceStub(self._channel)

    def getModelName(self):
        return self._stub.GetModelName(Empty())

    def createInstance(self):
        return FmuInstance(self._stub)










