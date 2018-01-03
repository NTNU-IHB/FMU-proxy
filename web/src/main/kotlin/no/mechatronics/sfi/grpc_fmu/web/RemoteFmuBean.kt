package no.mechatronics.sfi.grpc_fmu.web

import no.mechatronics.sfi.grpc_fmu.RemoteFmu
import javax.faces.bean.ManagedBean

@ManagedBean
class RemoteFmuBean(private val remoteFmu: RemoteFmu) {

    val guid = remoteFmu.guid
    //val name = remoteFmu.modelDescription.modelName

}