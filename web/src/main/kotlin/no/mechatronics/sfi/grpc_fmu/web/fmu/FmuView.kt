package no.mechatronics.sfi.grpc_fmu.web.fmu


import java.io.Serializable
import javax.annotation.PostConstruct
import javax.faces.bean.ManagedBean
import javax.faces.bean.ManagedProperty
import javax.faces.bean.ViewScoped

@ManagedBean
@ViewScoped
class FmuView: Serializable {

    @ManagedProperty("#{fmuService}")
    lateinit var service: FmuService

    lateinit var fmus: Set<FmuBean>

    var selectedFmu: FmuBean? = null


    @PostConstruct
    fun init() {
        fmus = service.fmus
    }


}