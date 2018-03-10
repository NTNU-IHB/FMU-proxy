import grpc
from google.protobuf.empty_pb2 import Empty
from definitions_pb2 import UIntProto
from definitions_pb2 import InitRequestProto
from definitions_pb2 import StepRequestProto
from definitions_pb2 import ReadRequestProto
from definitions_pb2 import IntReadProto
from definitions_pb2 import RealReadProto
from definitions_pb2 import StrReadProto
from definitions_pb2 import BoolReadProto
from definitions_pb2 import WriteIntegerRequestProto
from definitions_pb2 import WriteRealRequestProto
from definitions_pb2 import WriteStringRequestProto
from definitions_pb2 import WriteBooleanRequestProto
from definitions_pb2 import StatusProto
from service_pb2_grpc import FmuServiceStub


class VariableReader:

    def __init__(self, fmu_id, value_reference, stub):
        self.stub = stub
        self.request = ReadRequestProto()
        self.request.fmu_id = fmu_id
        self.request.value_reference = value_reference

    def read_int(self) -> IntReadProto:
        return self.stub.ReadInteger(self.request)

    def read_real(self) -> RealReadProto:
        return self.stub.ReadReal(self.request)

    def read_string(self) -> StrReadProto:
        return self.stub.ReadString(self.request)

    def read_boolean(self) -> BoolReadProto:
        return self.stub.ReadBoolean(self.request)


class VariableWriter:

    def __init__(self, fmu_id, value_reference, stub):
        self.stub = stub
        self.fmu_id = fmu_id
        self.value_reference = value_reference

    def write_int(self, value: int):
        request = WriteIntegerRequestProto()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteInt(request)

    def write_real(self, value: float):
        request = WriteRealRequestProto()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteReal(request)

    def write_string(self, value: str):
        request = WriteStringRequestProto()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteString(request)

    def write_boolean(self, value: bool):
        request = WriteBooleanRequestProto()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteBoolean(request)


class FmuInstance:

    def __init__(self, stub: FmuServiceStub, integrator=None):
        self.stub = stub

        if integrator is None:
            self.fmu_id = self.stub.CreateInstanceFromCS(Empty()).value
        else:
            self.fmu_id = self.stub.CreateInstanceFromME(integrator).value

        self.model_variables = dict()
        for v in self.stub.GetModelVariables(Empty()):
            self.model_variables[v.value_reference] = v

    def get_current_time(self) -> float:
        ref = UIntProto()
        ref.value = self.fmu_id
        return self.stub.GetCurrentTime(ref).value

    def init(self, start=0.0, stop=0.0) -> bool:
        request = InitRequestProto()
        request.fmu_id = self.fmu_id
        request.start = start
        request.stop = stop
        return self.stub.Init(request).value

    def step(self, step_size) -> StatusProto:
        request = StepRequestProto()
        request.fmu_id = self.fmu_id
        request.step_size = step_size
        return self.stub.Step(request)

    def terminate(self) -> bool:
        request = UIntProto()
        request.value = self.fmu_id
        return self.stub.Terminate(request).value

    def reset(self) -> StatusProto:
        request = UIntProto()
        request.value = self.fmu_id
        self.stub.Reset(request)

    def get_reader(self, identifier) -> VariableReader:
        if isinstance(identifier, int):
            return VariableReader(self.fmu_id, identifier, self.stub)
        elif isinstance(identifier, str):
            value_reference = self.get_value_reference(identifier)
            return VariableReader(self.fmu_id, value_reference, self.stub)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_writer(self, identifier) -> VariableWriter:
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


class FmuClient:

    def __init__(self, host_address, port):
        self._channel = grpc.insecure_channel(host_address + ':' + str(port))
        self._stub = FmuServiceStub(self._channel)

    def get_model_name(self) -> str:
        return self._stub.GetModelName(Empty())

    def create_instance(self, integrator=None) -> FmuInstance:
        return FmuInstance(self._stub, integrator)








