import grpc

from service.service_pb2 import *
from service.service_pb2_grpc import FmuServiceStub


class VariableReader:

    def __init__(self, instance_id: int, value_reference: int, stub: FmuServiceStub):
        self.stub = stub  # type: FmuServiceStub
        self.request = ReadRequest()
        self.request.instance_id = instance_id  # type: int
        self.request.value_references.append(value_reference)  # type [int]

    def read_int(self) -> IntegerRead:
        return self.stub.ReadInteger(self.request)

    def read_real(self) -> RealRead:
        return self.stub.ReadReal(self.request)

    def read_string(self) -> StringRead:
        return self.stub.ReadString(self.request)

    def read_boolean(self) -> BooleanRead:
        return self.stub.ReadBoolean(self.request)


class VariableWriter:

    def __init__(self, instance_id, value_reference, stub: FmuServiceStub):
        self.stub = stub  # type: FmuServiceStub
        self.instance_id = instance_id  # type: int
        self.value_reference = value_reference  # type: int

    def write_int(self, value: int):
        request = WriteIntegerRequest()
        request.instance_id = self.instance_id
        request.value_references.append(self.value_reference)
        request.values.append(value)
        return self.stub.WriteInt(request)

    def write_real(self, value: float):
        request = WriteRealRequest()
        request.instance_id = self.instance_id
        request.value_references.append(self.value_reference)
        request.values.append(value)
        return self.stub.WriteReal(request)

    def write_string(self, value: str):
        request = WriteStringRequest()
        request.instance_id = self.instance_id
        request.value_references.append(self.value_reference)
        request.values.append(value)
        return self.stub.WriteString(request)

    def write_boolean(self, value: bool):
        request = WriteBooleanRequest()
        request.instance_id = self.instance_id
        request.value_references.append(self.value_reference)
        request.values.append(value)
        return self.stub.WriteBoolean(request)


class RemoteFmuInstance:

    def __init__(self, remote_fmu, instance_id: str):
        self.stub = remote_fmu.stub
        self.remote_fmu = remote_fmu
        self.instance_id = instance_id  # type: str
        self.model_description = remote_fmu.model_description  # type: ModelDescription
        self.simulation_time = None  # type: float

    def setup_experiment(self, start=0.0, stop=0.0, tolerance=0.0) -> Status:
        self.simulation_time = start
        request = SetupExperimentRequest()
        request.instance_id = self.instance_id
        request.start = start
        request.stop = stop
        request.tolerance = tolerance
        return self.stub.SetupExperiment(request).status

    def enter_initialization_mode(self) -> Status:
        request = EnterInitializationModeRequest()
        request.instance_id = self.instance_id
        return self.stub.EnterInitializationMode(request).status

    def exit_initialization_mode(self) -> Status:
        request = ExitInitializationModeRequest()
        request.instance_id = self.instance_id
        return self.stub.ExitInitializationMode(request).status

    def step(self, step_size) -> Status:
        request = StepRequest()
        request.instance_id = self.instance_id
        request.step_size = step_size
        result = self.stub.Step(request)  # type: StepResult
        self.simulation_time = result.simulation_time
        return result.status

    def terminate(self) -> Status:
        request = TerminateRequest()
        request.instance_id = self.instance_id
        return self.stub.Terminate(request).status

    def reset(self) -> Status:
        request = ResetRequest()
        request.instance_id = self.instance_id
        self.stub.Reset(request)

    def get_reader(self, identifier) -> VariableReader:
        if isinstance(identifier, int):
            return VariableReader(self.instance_id, identifier, self.stub)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableReader(self.instance_id, value_reference, self.stub)
        else:
            raise ValueError('not a valid identifier: ' + identifier)

    def get_writer(self, identifier) -> VariableWriter:
        if isinstance(identifier, int):
            return VariableWriter(self.instance_id, identifier)
        elif isinstance(identifier, str):
            value_reference = self.remote_fmu.get_value_reference(identifier)
            return VariableWriter(self.instance_id, value_reference)
        else:
            raise ValueError('not a valid identifier: ' + identifier)


class RemoteFmu:

    def __init__(self, fmu_id: str, host_address: str, port: int):

        self.channel = grpc.insecure_channel(host_address + ':' + str(port))
        self.stub = FmuServiceStub(self.channel)

        self.fmu_id = fmu_id  # type: str
        get_model_description_request = GetModelDescriptionRequest()
        get_model_description_request.fmu_id = fmu_id
        self.model_description = self.stub.GetModelDescription(get_model_description_request)  # type: ModelDescription

        self.model_variables = dict()
        for var in self.model_description.model_variables:
            self.model_variables[var.value_reference] = var

    def get_value_reference(self, var_name) -> int:
        for key in self.model_variables:
            if self.model_variables[key].name == var_name:
                return key
        raise Exception("No variable with name '" + var_name + "' found!")

    def create_instance(self, solver: Solver=None) -> RemoteFmuInstance:
        if solver is None:
            request = CreateInstanceFromCSRequest()
            request.fmu_id = self.fmu_id
            instance_id = self.stub.CreateInstanceFromCS(request).value
        else:
            request = CreateInstanceFromMERequest()
            request.fmu_id = self.fmu_id
            request.solver = solver
            instance_id = self.stub.CreateInstanceFromME(solver).value
        return RemoteFmuInstance(self, instance_id)

