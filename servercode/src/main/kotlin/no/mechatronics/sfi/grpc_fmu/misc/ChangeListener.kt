package no.mechatronics.sfi.grpc_fmu.misc

import no.mechatronics.sfi.grpc_fmu.RemoteFmu

interface ChangeListener {

    fun onAdd(fmu: RemoteFmu)
    fun onRemove(fmu: RemoteFmu)

}