import grpc
from definitions_pb2 import Empty
from definitions_pb2 import UInt
from definitions_pb2 import InitRequest
from definitions_pb2 import StepRequest
from definitions_pb2 import ReadRequest
from definitions_pb2 import WriteIntegerRequest
from definitions_pb2 import WriteRealRequest
from definitions_pb2 import WriteStringRequest
from definitions_pb2 import WriteBooleanRequest
from service_pb2_grpc import GenericFmuServiceStub


class FmuInstance:

    def __init__(self, stub: GenericFmuServiceStub, integrator=None):
        self.stub = stub

        if integrator is None:
            self.fmu_id = self.stub.CreateInstanceFromCS(Empty()).value
        else:
            self.fmu_id = self.stub.CreateInstanceFromME(integrator).value

        self.model_variables = dict()
        for v in self.stub.GetModelVariables(Empty()):
            self.model_variables[v.value_reference] = v

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

    def step(self, step_size):
        request = StepRequest()
        request.fmu_id = self.fmu_id
        request.step_size = step_size
        return self.stub.Step(request)

    def terminate(self):
        request = UInt()
        request.value = self.fmu_id
        return self.stub.Terminate(request)

    def reset(self):
        request = UInt()
        request.value = self.fmu_id
        self.stub.Reset(request)

    def get_reader(self, identifier):
        if isinstance(identifier, int):
            return VariableReader(self.fmu_id, identifier, self.stub)
        elif isinstance(identifier, str):
            value_reference = self.get_value_reference(identifier)
            return VariableReader(self.fmu_id, value_reference, self.stub)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_writer(self, identifier):
        if isinstance(identifier, int):
            return VariableWriter(self.fmu_id, identifier)
        elif isinstance(identifier, str):
            value_reference = self.get_value_reference(identifier)
            return VariableWriter(self.fmu_id, value_reference)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_value_reference(self, var_name) -> int:
        for key in self.model_variables:
            if self.model_variables[key].name == var_name:
                return key
        return None


class GenericFmuClient:

    def __init__(self, host_address, port):
        self._channel = grpc.insecure_channel(host_address + ':' + str(port))
        self._stub = GenericFmuServiceStub(self._channel)

    def get_model_name(self):
        return self._stub.GetModelName(Empty())

    def create_instance(self, integrator=None):
        return FmuInstance(self._stub, integrator)


class VariableReader:

    def __init__(self, fmu_id, value_reference, stub):
        self.stub = stub
        self.request = ReadRequest()
        self.request.fmu_id = fmu_id
        self.request.value_reference = value_reference

    def read_int(self):
        return self.stub.ReadInteger(self.request)

    def read_real(self):
        return self.stub.ReadReal(self.request)

    def read_string(self):
        return self.stub.ReadString(self.request)

    def read_boolean(self):
        return self.stub.ReadBoolean(self.request)


class VariableWriter:

    def __init__(self, fmu_id, value_reference, stub):
        self.stub = stub
        self.fmu_id = fmu_id
        self.value_reference = value_reference

    def write_int(self, value):
        request = WriteIntegerRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteInt(request)

    def write_real(self, value):
        request = WriteRealRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteReal(request)

    def write_string(self, value):
        request = WriteStringRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteString(request)

    def write_boolean(self, value):
        request = WriteBooleanRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteBoolean(request)







