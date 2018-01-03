package no.mechatronics.sfi.grpc_fmu.web


import no.mechatronics.sfi.grpc_fmu.RemoteFmu
import org.primefaces.context.RequestContext
import java.io.Serializable
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped

@ManagedBean
@ViewScoped
class FmuOverview: Serializable {

    init {

        RemoteFmus.addListener(object: ChangeListener {
            override fun onAdd(fmu: RemoteFmu) {

            }

            override fun onRemove(fmu: RemoteFmu) {

            }
        })

    }

    fun getFmus() = RemoteFmus.get()


}