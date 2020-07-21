namespace cpp fmuproxy.thrift
namespace java no.ntnu.ihb.fmuproxy.thrift

include "defs.thrift"

typedef i32 FmuId

exception NoSuchFileException {
    1: string message
}

exception NoSuchFmuException {
    1: string message
}

service FmuService {

    FmuId load_from_url(1: string url)
    FmuId load_from_local_file(1: string fileName) throws (1: NoSuchFileException ex)
    FmuId load_from_remote_file(1: string name, 2: binary data)

    defs.ModelDescription get_model_description(1: FmuId fmuId) throws (1: NoSuchFmuException ex)

    void instantiate(1: FmuId fmuId) throws (1: NoSuchFmuException ex)

    defs.Status setup_experiment(1: FmuId fmuId, 2: double start, 3: double stop, 4: double tolerance) throws (1: NoSuchFmuException ex)
    defs.Status enter_initialization_mode(1: FmuId fmuId) throws (1: NoSuchFmuException ex)
    defs.Status exit_initialization_mode(1: FmuId fmuId) throws (1: NoSuchFmuException ex)
    
    defs.StepResult step(1: FmuId fmuId, 2: double stepSize) throws (1: NoSuchFmuException ex)
    defs.Status reset(1: FmuId fmuId) throws (1: NoSuchFmuException ex)
    defs.Status terminate(1: FmuId fmuId) throws (1: NoSuchFmuException ex)
    void close(1: FmuId fmuId) throws (1: NoSuchFmuException ex)

    defs.IntegerRead read_integer(1: FmuId fmuId, 2: defs.ValueReferences vr) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)
    defs.RealRead read_real(1: FmuId fmuId, 2: defs.ValueReferences vr) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)
    defs.StringRead read_string(1: FmuId fmuId, 2: defs.ValueReferences vr) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)
    defs.BooleanRead read_boolean(1: FmuId fmuId, 2: defs.ValueReferences vr) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)

    defs.Status write_integer(1: FmuId fmuId, 2: defs.ValueReferences vr, 3: defs.IntArray value) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)
    defs.Status write_real(1: FmuId fmuId, 2: defs.ValueReferences vr, 3: defs.RealArray value) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)
    defs.Status write_string(1: FmuId fmuId, 2: defs.ValueReferences vr, 3: defs.StringArray value) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)
    defs.Status write_boolean(1: FmuId fmuId, 2: defs.ValueReferences vr, 3: defs.BooleanArray value) throws (1: NoSuchFmuException ex1, 2: defs.NoSuchVariableException ex2)

    defs.DirectionalDerivativeResult get_directional_derivative(1: FmuId fmuId, 2: defs.ValueReferences vUnknownRef, 3: defs.ValueReferences vKnownRef, 4: list<double> dvKnownRef) throws (1: NoSuchFmuException ex1, 2: defs.UnsupportedOperationException ex2)
    
}
