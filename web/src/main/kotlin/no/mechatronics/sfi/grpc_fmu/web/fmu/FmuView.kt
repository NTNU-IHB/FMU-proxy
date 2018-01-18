package no.mechatronics.sfi.grpc_fmu.web.fmu


import no.mechatronics.sfi.grpc_fmu.IRemoteFmu
import java.io.Serializable
import javax.faces.bean.ManagedBean
import javax.faces.bean.ManagedProperty
import javax.faces.bean.ViewScoped

@ManagedBean
@ViewScoped
class FmuView: Serializable {

    @ManagedProperty("#{fmuService}")
    lateinit var service: FmuService

    var selectedFmu: FmuBean? = null


}