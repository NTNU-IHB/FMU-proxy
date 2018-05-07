package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmuproxy.IntegratorSettings


internal fun StatusCode.convert(): FmiStatus {
    return when(this) {
        StatusCode.OK_STATUS -> FmiStatus.OK
        StatusCode.DISCARD_STATUS -> FmiStatus.Discard
        StatusCode.ERROR_STATUS -> FmiStatus.Error
        StatusCode.WARNING_STATUS -> FmiStatus.Warning
        StatusCode.PENDING_STATUS -> FmiStatus.Pending
        StatusCode.FATAL_STATUS -> FmiStatus.Fatal
    }
}

internal fun IntegratorSettings.thriftType(): no.mechatronics.sfi.fmuproxy.thrift.Integrator {
    return when(this) {
        is no.mechatronics.sfi.fmuproxy.EulerIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.euler(EulerIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.ClassicalRungeKuttaIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.runge_kutta(ClassicalRungeKuttaIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.GillIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.gill(no.mechatronics.sfi.fmuproxy.thrift.GillIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.MidPointIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.mid_point(MidpointIntegrator(stepSize))
        is no.mechatronics.sfi.fmuproxy.AdamsBashforthIntegrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.adams_bashforth(AdamsBashforthIntegrator(n_steps, min_Step, max_step, scal_absolute_tolerance, scal_relative_tolerance))
        is no.mechatronics.sfi.fmuproxy.DormandPrince54Integrator -> no.mechatronics.sfi.fmuproxy.thrift.Integrator.dormand_prince54(DormandPrince54Integrator(min_Step, max_step, scal_absolute_tolerance, scal_relative_tolerance))
    }
}


internal fun IntRead.convert(): FmuIntegerRead {
    return FmuIntegerRead(value, code.convert())
}

internal fun IntArrayRead.convert(): FmuIntegerArrayRead {
    return FmuIntegerArrayRead(value.toIntArray(), code.convert())
}

internal fun RealRead.convert(): FmuRealRead {
    return FmuRealRead(value, code.convert())
}

internal fun RealArrayRead.convert(): FmuRealArrayRead {
    return FmuRealArrayRead(value.toDoubleArray(), code.convert())
}

internal fun StringRead.convert(): FmuStringRead {
    return FmuStringRead(value, code.convert())
}

internal fun StringArrayRead.convert(): FmuStringArrayRead {
    return FmuStringArrayRead(value.toTypedArray(), code.convert())
}

internal fun BoolRead.convert(): FmuBooleanRead {
    return FmuBooleanRead(isValue, code.convert())
}

internal fun BoolArrayRead.convert(): FmuBooleanArrayRead {
    return FmuBooleanArrayRead(value.toBooleanArray(), code.convert())
}