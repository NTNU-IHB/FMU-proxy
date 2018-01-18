package no.mechatronics.sfi.grpc_fmu.web.fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.grpc_fmu.IRemoteFmu
import no.mechatronics.sfi.grpc_fmu.RemoteFmu

class FmuBean(
        remoteFmu: RemoteFmu
): IRemoteFmu by remoteFmu {

    val modelName = modelDescription.modelName

    val modelDescription: ModelDescription
            get() = ModelDescriptionParser.parse(modelDescriptionXml)

}

