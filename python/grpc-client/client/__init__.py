import grpc
from google.protobuf.empty_pb2 import Empty
from definitions.definitions_pb2 import *
from definitions.service_pb2_grpc import FmuServiceStub

def uint(value: int) -> UInt:
    var = UInt()
    var.value = value
    return var


class VariableReader:

    def __init__(self, fmu_id, value_reference, stub):
        self.stub = stub
        self.request = ReadRequest()
        self.request.fmu_id = fmu_id
        self.request.value_reference = value_reference

    def read_int(self) -> IntegerRead:
        return self.stub.ReadInteger(self.request)

    def read_real(self) -> RealRead:
        return self.stub.ReadReal(self.request)

    def read_string(self) -> StringRead:
        return self.stub.ReadString(self.request)

    def read_boolean(self) -> BooleanRead:
        return self.stub.ReadBoolean(self.request)


class VariableWriter:

    def __init__(self, fmu_id, value_reference, stub):
        self.stub = stub
        self.fmu_id = fmu_id
        self.value_reference = value_reference

    def write_int(self, value: int):
        request = WriteIntegerRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteInt(request)

    def write_real(self, value: float):
        request = WriteRealRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteReal(request)

    def write_string(self, value: str):
        request = WriteStringRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteString(request)

    def write_boolean(self, value: bool):
        request = WriteBooleanRequest()
        request.fmu_id = self.fmu_id
        request.value_reference = self.value_reference
        request.value = value
        return self.stub.WriteBoolean(request)


class RemoteFmuInstance:

    def __init__(self, remote_fmu, solver=None):
        self.stub = remote_fmu.stub
        self.remote_fmu = remote_fmu
        self.model_description = remote_fmu.model_description  # type: ModelDescription

        self.fmu_id = None  # type: int
        if solver is None:
            self.fmu_id = self.stub.CreateInstanceFromCS(Empty()).value
        else:
            self.fmu_id = self.stub.CreateInstanceFromME(solver).value

        self.current_time = self.get_simulation_time()  # type: float

    def get_simulation_time(self) -> float:
        return self.stub.GetSimulationTime(uint(self.fmu_id)).value

    def init(self, start=0.0, stop=0.0) -> Status:
        request = InitRequest()
        request.fmu_id = self.fmu_id
        request.start = start
        request.stop = stop
        return self.stub.Init(request).status

    def step(self, step_size) -> Status:
        request = StepRequest()
        request.fmu_id = self.fmu_id
        request.step_size = step_size
        result = self.stub.Step(request)  # type: StepResult
        self.current_time = result.simulation_time
        return result.status

    def terminate(self) -> Status:
        return self.stub.Terminate(uint(self.fmu_id)).status

    def reset(self) -> Status:
        self.stub.Reset(uint(self.fmu_id))

    def get_reader(self, identifier) -> VariableReader:
        if isinstance(identifier, int):
            return VariableReader(self.fmu_id, identifier, self.stub)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableReader(self.fmu_id, value_reference, self.stub)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_writer(self, identifier) -> VariableWriter:
        if isinstance(identifier, int):
            return VariableWriter(self.fmu_id, identifier)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableWriter(self.fmu_id, value_reference)
        else:
            raise ValueError('not a valid identifier: ' + identifier)


class RemoteFmu:

    def __init__(self, host_address, port):
        self.channel = grpc.insecure_channel(host_address + ':' + str(port))
        self.stub = FmuServiceStub(self.channel)

        self.model_description = self.stub.GetModelDescription(Empty()) # type: ModelDescription

        self.model_variables = dict()
        for var in self.model_description.model_variables:
            self.model_variables[var.value_reference] = var

    def get_value_reference(self, var_name) -> int:
        for key in self.model_variables:
            if self.model_variables[key].name == var_name:
                return key
        return None

    def create_instance(self, solver=None) -> RemoteFmuInstance:
        return RemoteFmuInstance(self, solver)

