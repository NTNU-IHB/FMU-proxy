namespace cpp fmuproxy.thrift
namespace java no.ntnu.ihb.fmuproxy.thrift

typedef i64 ValueReference
typedef i64 FmuState
typedef list<double> DirectionalDerivative
typedef list<ValueReference> ValueReferences
typedef list<i32> IntArray
typedef list<double> RealArray
typedef list<string> StringArray
typedef list<bool> BooleanArray

enum Status {
    OK_STATUS = 0,
    WARNING_STATUS = 1,
    DISCARD_STATUS = 2,
    ERROR_STATUS = 3,
    FATAL_STATUS = 4,
    PENDING_STATUS = 5
}

struct IntegerRead {
    1: IntArray value,
    2: Status status
}

struct RealRead {
    1: RealArray value,
    2: Status status
}

struct StringRead {
    1: StringArray value,
    2: Status status
}

struct BooleanRead {
    1: BooleanArray value,
    2: Status status
}

struct BulkRead {
    1: IntArray intValue,
    2: RealArray realValue,
    3: BooleanArray booleanValue,
    4: StringArray stringValue
    5: Status status
}

exception NoSuchVariableException {
    1: string message
}

exception UnsupportedOperationException {
    1: string message
}
