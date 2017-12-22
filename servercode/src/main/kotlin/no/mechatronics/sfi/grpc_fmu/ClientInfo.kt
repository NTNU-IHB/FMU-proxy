package no.mechatronics.sfi.grpc_fmu

import com.google.gson.GsonBuilder
import java.util.*

class ClientInfo(
        val hostAddress: String,
        val port: Int,
        val guid: String,
        val modelDescriptionXml: String
) {

    val protoDefinition: String

    init {
        this.protoDefinition = Scanner(javaClass.classLoader
                .getResourceAsStream("protoDefinition.proto"), "UTF-8")
                .useDelimiter("\\A").next();
    }

    fun toJson() = GsonBuilder()
                .create()
                .toJson(this);

}