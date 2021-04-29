package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.FmiStatus

internal fun FmiStatus.thriftType(): Status {
    return when (this) {
        FmiStatus.OK -> Status.OK_STATUS
        FmiStatus.Warning -> Status.WARNING_STATUS
        FmiStatus.Discard -> Status.DISCARD_STATUS
        FmiStatus.Error -> Status.ERROR_STATUS
        FmiStatus.Fatal -> Status.FATAL_STATUS
        FmiStatus.Pending -> Status.PENDING_STATUS
        FmiStatus.NONE -> throw RuntimeException("Not a valid status: $this")
    }
}
