import grpc
from definitions_pb2 import Empty
from definitions_pb2 import UInt
from definitions_pb2 import InitRequest
from definitions_pb2 import StepRequest
from definitions_pb2 import VarRead
from definitions_pb2 import VarWrite
import service_pb2_grpc


class FmuInstance:

    def __init__(self, stub):
        self.stub = stub
        self.fmu_id = self.stub.CreateInstance(Empty()).value

        self.model_variables = dict()
        for v in self.stub.GetModelVariables(Empty()):
            self.model_variables[v.valueReference] = v

    def get_current_time(self):
        ref = UInt()
        ref.value = self.fmu_id
        return self.stub.GetCurrentTime(ref).value

    def init(self, start = 0.0, stop = 0.0):
        request = InitRequest()
        request.fmu_id = self.fmu_id
        request.start = start
        request.stop = stop
        return self.stub.Init(request).value

    def step(self, dt):
        request = StepRequest()
        request.fmu_id = self.fmu_id
        request.dt = dt
        return self.stub.Step(request)

    def terminate(self):
        request = UInt()
        request.value = self.fmu_id
        self.stub.Terminate(request)

    def reset(self):
        request = UInt()
        request.value = self.fmu_id
        self.stub.Terminate(request)
    
    def read(self, identifier):
        if isinstance(identifier, int):
            return self.__read_given_value_reference__(identifier)
        elif isinstance(identifier, str):
            value_reference = self.get_value_reference(identifier)
            return self.__read_given_value_reference__(value_reference)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def __read_given_value_reference__(self, value_reference):
        request = VarRead()
        request.fmu_id = self.fmu_id
        request.valueReference = value_reference
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

    def write(self, identifier, value):
        if isinstance(identifier, int):
            return self.__write_given_value_reference__(identifier, value)
        elif isinstance(identifier, str):
            value_reference = self.get_value_reference(identifier)
            return self.__write_given_value_reference__(value_reference, value)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def __write_given_value_reference__(self, value_reference, value):
        request = VarWrite()
        request.fmu_id = self.fmu_id
        request.valueReference = value_reference
        if isinstance(value, int) and self.model_variables[value_reference].type == 0:
            request.intValue = value
        elif isinstance(value, int) and self.model_variables[value_reference].type == 1:
            request.realValue = value
        elif isinstance(value, float) and self.model_variables[value_reference].type == 0:
            request.intValue = int(value)
        elif isinstance(value, float) and self.model_variables[value_reference].type == 1:
            request.realValue = value
        elif isinstance(value, str):
            request.strValue = value
        elif isinstance(value, bool):
            request.boolValue = value
        else:
            raise ValueError('value is not a supported type!')
        print(request)
        return self.stub.Write(request)

    def get_value_reference(self, var_name):
        for key in self.model_variables:
            if self.model_variables[key].varName == var_name:
                return key
        return None


class GenericFmuClient:

    def __init__(self, host_address, port):
        self._channel = grpc.insecure_channel(host_address + ':' + str(port))
        self._stub = service_pb2_grpc.GenericFmuServiceStub(self._channel)

    def get_model_name(self):
        return self._stub.GetModelName(Empty())

    def create_instance(self):
        return FmuInstance(self._stub)










