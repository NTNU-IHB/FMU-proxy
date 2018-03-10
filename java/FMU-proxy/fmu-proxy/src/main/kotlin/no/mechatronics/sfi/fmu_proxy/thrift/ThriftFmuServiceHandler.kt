package no.mechatronics.sfi.fmu_proxy.thrift

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription

class ThriftFmuServiceHandler(
        private val fmuFile: FmuFile
): ThriftFmuService.Iface {

    private val modelDescription: SimpleModelDescription
            = fmuFile.modelDescription

    override fun getGuid(): String {
        return modelDescription.guid
    }

    override fun getModelName(): String {
        return modelDescription.modelName
    }
}