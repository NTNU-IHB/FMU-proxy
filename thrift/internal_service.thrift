namespace java no.ntnu.ihb.fmuproxy.thrift.internal

include "defs.thrift"

service InternalFmuService {

    defs.ModelDescription get_model_description()

    void instantiate()

    defs.Status setup_experiment(1: double start, 2: double stop, 3: double tolerance)
    defs.Status enter_initialization_mode()
    defs.Status exit_initialization_mode()
    
    defs.StepResult step(1: double stepSize)
    defs.Status reset()
    defs.Status terminate()
    void close()

    defs.IntegerRead read_integer(1: defs.ValueReferences vr) throws (1: defs.NoSuchVariableException ex)
    defs.RealRead read_real(1: defs.ValueReferences vr) throws (1: defs.NoSuchVariableException ex)
    defs.StringRead read_string(1: defs.ValueReferences vr) throws (1: defs.NoSuchVariableException ex)
    defs.BooleanRead read_boolean(1: defs.ValueReferences vr) throws (1: defs.NoSuchVariableException ex)

    defs.Status write_integer(1: defs.ValueReferences vr, 2: defs.IntArray value) throws (1: defs.NoSuchVariableException ex)
    defs.Status write_real(1: defs.ValueReferences vr, 2: defs.RealArray value) throws (1: defs.NoSuchVariableException ex)
    defs.Status write_string(1: defs.ValueReferences vr, 2: defs.StringArray value) throws (1: defs.NoSuchVariableException ex)
    defs.Status write_boolean(1: defs.ValueReferences vr, 2: defs.BooleanArray value) throws (1: defs.NoSuchVariableException ex)

    defs.DirectionalDerivativeResult get_directional_derivative(1: defs.ValueReferences vUnknownRef, 2: defs.ValueReferences vKnownRef, 3: list<double> dvKnownRef) throws (1: defs.UnsupportedOperationException ex)
    
}
