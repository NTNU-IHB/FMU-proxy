package no.mechatronics.sfi.grpc_fmu

interface ChangeListener {

    fun onAdd(fmu: RemoteFmu)
    fun onRemove(fmu: RemoteFmu)

}