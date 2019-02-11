
from service import FmuService
from service.ttypes import *

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol


class VariableReader:

    def __init__(self, instance_id: int, value_reference: int, client: FmuService.Client):
        self.client = client  # type: FmuService.Client
        self.instance_id = instance_id  # type: str
        self.value_reference = [value_reference]  # type: [int]

    def read_int(self) -> IntegerRead:
        return self.client.readInteger(self.instance_id, self.value_reference)

    def read_real(self) -> RealRead:
        return self.client.readReal(self.instance_id, self.value_reference)

    def read_string(self) -> StringRead:
        return self.client.readString(self.instance_id, self.value_reference)

    def read_boolean(self) -> BooleanRead:
        return self.client.readBoolean(self.instance_id, self.value_reference)


class VariableWriter:

    def __init__(self, instance_id: int, value_reference: int, client: FmuService.Client):
        self.client = client  # type: FmuService.Client
        self.instance_id = instance_id  # type: str
        self.value_reference = [value_reference]  # type: [int]

    def write_int(self, value: int) -> Status:
        return self.client.writeInteger(self.instance_id, self.value_reference, [value])

    def write_real(self, value: float) -> Status:
        return self.client.writeReal(self.instance_id, self.value_reference, [value])

    def write_string(self, value: str) -> Status:
        return self.client.writeString(self.instance_id, self.value_reference, [value])

    def write_boolean(self, value: bool) -> Status:
        return self.client.writeBoolean(self.instance_id, self.value_reference, [value])


class RemoteFmuInstance:

    def __init__(self, remote_fmu, instance_id: str):
        self.instance_id = instance_id
        self.remote_fmu = remote_fmu
        self.client = remote_fmu.client  # type: FmuService.Client
        self.model_description = remote_fmu.model_description  # type: ModelDescription
        self.simulation_time = None  # type: float

    def setup_experiment(self, start: float = 0.0, stop: float = 0.0, tolerance: float = 0.0) -> Status:
        self.simulation_time = start
        return self.client.setupExperiment(self.instance_id, start, stop, tolerance)

    def enter_initialization_mode(self) -> Status:
        return self.client.enterInitializationMode(self.instance_id)

    def exit_initialization_mode(self) -> Status:
        return self.client.exitInitializationMode(self.instance_id)

    def step(self, step_size: float) -> Status:
        response = self.client.step(self.instance_id, step_size)  # type: StepResult
        self.simulation_time = response.simulationTime
        return response.status

    def terminate(self) -> Status:
        return self.client.terminate(self.instance_id)

    def reset(self) -> Status:
        return self.client.reset(self.instance_id)

    def get_reader(self, identifier) -> VariableReader:
        if isinstance(identifier, int):
            return VariableReader(self.instance_id, identifier, self.client)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableReader(self.instance_id, value_reference, self.client)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_writer(self, identifier) -> VariableWriter:
        if isinstance(identifier, int):
            return VariableWriter(self.instance_id, identifier, self.client)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableWriter(self.instance_id, value_reference, self.client)
        else:
            raise ValueError('not a valid identifier: ' + identifier)


class RemoteFmu:

    def __init__(self, fmu_id: str, host_address: str, port: int):

        self.transport = TSocket.TSocket(host_address, port)
        self.transport = TTransport.TFramedTransport(self.transport)
        self.protocol = TBinaryProtocol.TBinaryProtocol(self.transport)

        self.client = FmuService.Client(self.protocol)

        self.transport.open()

        self.fmu_id = fmu_id
        self.model_description = self.client.getModelDescription(fmu_id)  # type: ModelDescription

        self.model_variables = dict()
        for var in self.model_description.modelVariables:  # type: [ScalarVariable]
            self.model_variables[var.valueReference] = var

    def get_value_reference(self, var_name) -> int:
        for key in self.model_variables:
            if self.model_variables[key].name == var_name:
                return key
        return None

    def create_instance(self, solver: Solver=None) -> RemoteFmuInstance:
        if solver is None:
            instance_id = self.client.createInstanceFromCS(self.fmu_id)
        else:
            instance_id = self.client.createInstanceFromME(self.fmu_id, solver)
        return RemoteFmuInstance(self, instance_id)
