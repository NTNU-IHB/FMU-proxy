package no.mechatronics.sfi.grpc_fmu.web.fmu


import no.mechatronics.sfi.grpc_fmu.IRemoteFmu
import java.io.Serializable
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped

@ManagedBean
@ViewScoped
class FmuOverview: Serializable {

    init {

        Fmus.addListener(object : ChangeListener {
            override fun onAdd(fmu: IRemoteFmu) {

            }

            override fun onRemove(fmu: IRemoteFmu) {

            }
        })

    }

    fun getFmus() = Fmus.get()


}