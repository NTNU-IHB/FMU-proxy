package no.mechatronics.sfi.grpc_fmu.web.fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.grpc_fmu.IRemoteFmu
import no.mechatronics.sfi.grpc_fmu.RemoteFmu

class FmuBean(
        private val remoteFmu: RemoteFmu
): IRemoteFmu by remoteFmu {

    fun getModelDescription() = ModelDescriptionParser.parse(modelDescriptionXml)

}

