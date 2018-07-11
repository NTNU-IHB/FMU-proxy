
from service import FmuService
from definitions.ttypes import *

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol


class VariableReader:

    def __init__(self, fmu_id: int, value_reference: int, client: FmuService.Client):
        self.client = client

        self.fmu_id = fmu_id
        self.value_reference = value_reference

    def read_int(self) -> IntegerRead:
        return self.client.readInteger(self.fmu_id, self.value_reference)

    def read_real(self) -> RealRead:
        return self.client.readReal(self.fmu_id, self.value_reference)

    def read_string(self) -> StringRead:
        return self.client.readString(self.fmu_id, self.value_reference)

    def read_boolean(self) -> BooleanRead:
        return self.client.readBoolean(self.fmu_id, self.value_reference)


class VariableWriter:

    def __init__(self, fmu_id: int, value_reference: int, client: FmuService.Client):
        self.client = client

        self.fmu_id = fmu_id
        self.value_reference = value_reference

    def write_int(self, value: int) -> Status:
        return self.client.writeInteger(self.fmu_id, self.value_reference, value)

    def write_real(self, value: float) -> Status:
        return self.client.writeReal(self.fmu_id, self.value_reference, value)

    def write_string(self, value: str) -> Status:
        return self.client.writeString(self.fmu_id, self.value_reference, value)

    def write_boolean(self, value: bool) -> Status:
        return self.client.writeBoolean(self.fmu_id, self.value_reference, value)


class RemoteFmuInstance:

    def __init__(self, remote_fmu, solver=None):

        self.remote_fmu = remote_fmu
        self.client = remote_fmu.client  # type: FmuService.Client
        self.model_description = remote_fmu.model_description  # type: ModelDescription

        self.fmu_id = None  # type: int
        if solver is None:
            self.fmu_id = self.client.createInstanceFromCS()
        else:
            self.fmu_id = self.client.createInstanceFromME(solver)

        self.current_time = self.client.getCurrentTime(self.fmu_id)

    def init(self, start: float = 0.0, stop: float = 0.0) -> Status:
        return self.client.init(self.fmu_id, start, stop)

    def step(self, step_size: float) -> Status:
        response = self.client.step(self.fmu_id, step_size)  # type: StepResult
        self.current_time = response.simulationTime
        return response.status

    def terminate(self) -> Status:
        return self.client.terminate(self.fmu_id)

    def reset(self) -> Status:
        return self.client.reset(self.fmu_id)

    def get_reader(self, identifier) -> VariableReader:
        if isinstance(identifier, int):
            return VariableReader(self.fmu_id, identifier, self.client)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableReader(self.fmu_id, value_reference, self.client)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_writer(self, identifier) -> VariableWriter:
        if isinstance(identifier, int):
            return VariableWriter(self.fmu_id, identifier, self.client)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableWriter(self.fmu_id, value_reference, self.client)
        else:
            raise ValueError('not a valid identifier: ' + identifier)


class RemoteFmu:

    def __init__(self, host_address, port):
        # Make socket
        self.transport = TSocket.TSocket(host_address, port)

        # Buffering is critical. Raw sockets are very slow
        self.transport = TTransport.TBufferedTransport(self.transport)

        # Wrap in a protocol
        self.protocol = TBinaryProtocol.TBinaryProtocol(self.transport)

        self.client = FmuService.Client(self.protocol)

        self.transport.open()

        self.model_description = self.client.getModelDescription()  # type: ModelDescription

        self.model_variables = dict()
        for var in self.model_description.modelVariables:  # type: List<ScalarVariable>
            self.model_variables[var.valueReference] = var

    def get_value_reference(self, var_name) -> int:
        for key in self.model_variables:
            if self.model_variables[key].name == var_name:
                return key
        return None

    def create_instance(self, solver: Solver=None) -> RemoteFmuInstance:
        return RemoteFmuInstance(self, solver)



