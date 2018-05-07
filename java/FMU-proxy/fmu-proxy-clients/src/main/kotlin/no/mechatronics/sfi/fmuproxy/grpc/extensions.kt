package no.mechatronics.sfi.fmuproxy.grpc

import no.mechatronics.sfi.fmi4j.common.*


internal fun Proto.Status.convert(): FmiStatus {
    return code.convert()
}

internal fun Proto.StatusCode.convert(): FmiStatus {
    return when(this) {
        Proto.StatusCode.OK_STATUS -> FmiStatus.OK
        Proto.StatusCode.DISCARD_STATUS -> FmiStatus.Discard
        Proto.StatusCode.ERROR_STATUS -> FmiStatus.Error
        Proto.StatusCode.WARNING_STATUS -> FmiStatus.Warning
        Proto.StatusCode.PENDING_STATUS -> FmiStatus.Pending
        Proto.StatusCode.FATAL_STATUS -> FmiStatus.Fatal
        Proto.StatusCode.UNRECOGNIZED -> throw AssertionError()
    }
}

internal fun Int.asProtoUInt(): Proto.UInt {
    return Proto.UInt.newBuilder()
            .setValue(this)
            .build()
}

internal fun Int.asProtoInt(): Proto.UInt {
    return Proto.UInt.newBuilder()
            .setValue(this)
            .build()
}

internal fun Proto.IntRead.convert(): FmuIntegerRead {
    return FmuIntegerRead(value, status.convert())
}

internal fun Proto.IntListRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(valuesList.toIntArray(), status.convert())
}

internal fun Proto.RealRead.convert(): FmuRealRead {
    return FmuRealRead(value, status.convert())
}

internal fun Proto.RealListRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(valuesList.toDoubleArray(), status.convert())
}

internal fun Proto.StrRead.convert(): FmuStringRead {
    return FmuStringRead(value, status.convert())
}

internal fun Proto.StrListRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(valuesList.toTypedArray(), status.convert())
}

internal fun Proto.BoolRead.convert(): FmuBooleanRead {
    return FmuBooleanRead(value, status.convert())
}

internal fun Proto.BoolListRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(valuesList.toBooleanArray(), status.convert())
}