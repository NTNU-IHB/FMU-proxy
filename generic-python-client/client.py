import grpc
from definitions_pb2 import Empty
from definitions_pb2 import Int
from definitions_pb2 import InitRequest
from definitions_pb2 import StepRequest
from definitions_pb2 import TerminateRequest
from definitions_pb2 import ResetRequest
from definitions_pb2 import VarRead
from definitions_pb2 import VarWrite
import service_pb2_grpc


class FmuInstance:

    def __init__(self, stub):
        self.stub = stub
        self.__model_variables = None
        self.fmu_id = self.stub.CreateInstance(Empty()).fmu_id

    def get_current_time(self):
        ref = Int()
        ref.value = self.fmu_id
        return self.stub.GetCurrentTime(ref).value

    def init(self):
        request = InitRequest()
        request.fmu_id = self.fmu_id
        return self.stub.Init(request).value

    def step(self, dt):
        request = StepRequest()
        request.fmu_id = self.fmu_id
        request.dt = dt
        return self.stub.Step(request)

    def terminate(self):
        request = TerminateRequest()
        request.fmu_id = self.fmu_id
        self.stub.Terminate(request)

    def reset(self):
        request = ResetRequest()
        request.fmu_id = self.fmu_id
        self.stub.Terminate(request)

    def get_model_variables(self):
        if self.__model_variables is None:
            self.__model_variables = self.stub.GetModelVariables(Empty()).values
        return self.__model_variables
    
    def read(self, var_name):
        var = self.get_variable_by_name(var_name)
        request = VarRead()
        request.fmu_id = self.fmu_id
        request.valueReference = var.valueReference
        read = self.stub.Read(request)
        if read.WhichOneof("value") == "intValue":
            return read.intValue
        elif read.WhichOneof("value") == "realValue":
            return read.realValue
        elif read.WhichOneof("value") == "strValue":
            return read.strValue
        elif read.WhichOneof("value") == "boolValue":
            return read.boolValue
        else:
            raise ValueError('value is not a supported type!')

    def write(self, var_name, value):
        var = self.get_variable_by_name(var_name)
        request = VarWrite()
        request.fmu_id = self.fmu_id
        request.valueReference = var.valueReference

        if isinstance(value, int):
            request.intValue = value
        elif isinstance(value, float):
            request.realValue = value
        elif isinstance(value, str):
            request.strValue = value
        elif isinstance(value, bool):
            request.boolValue = value
        else:
            raise ValueError('value is not a supported type!')

        self.stub.Write(request)
    
    def get_variable_by_name(self, var_name):
        var = None
        for v in self.get_model_variables():
            if v.varName == var_name:
                var = v
                break
        return var


class GenericFmuClient:

    def __init__(self, host_address, port):
        self._channel = grpc.insecure_channel(host_address + ':' + str(port))
        self._stub = service_pb2_grpc.GenericFmuServiceStub(self._channel)

    def get_model_name(self):
        return self._stub.GetModelName(Empty())

    def create_instance(self):
        return FmuInstance(self._stub)










