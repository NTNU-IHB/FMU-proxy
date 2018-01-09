package no.mechatronics.sfi.grpc_fmu.web

import javax.faces.bean.ManagedBean
import org.primefaces.model.StreamedContent
import org.primefaces.model.DefaultStreamedContent
import javax.faces.context.FacesContext



@ManagedBean
class ProtoDownload {

    val file: StreamedContent

    init{
        val name = "GRPC-FMU_GenericProto.zip"
        val stream = FacesContext.getCurrentInstance().externalContext.getResourceAsStream("/resources/proto/$name")
        file = DefaultStreamedContent(stream, "application/octet-stream", name)
    }

}