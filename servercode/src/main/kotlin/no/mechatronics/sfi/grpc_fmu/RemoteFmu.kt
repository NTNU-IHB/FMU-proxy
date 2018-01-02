package no.mechatronics.sfi.grpc_fmu

import com.google.gson.Gson
import java.util.*

class RemoteFmu(
        val hostAddress: String,
        val port: Int,
        val guid: String,
        val modelDescriptionXml: String
) {

    companion object {
        fun toJson(info: RemoteFmu) = Gson().toJson(info)
        fun fromJson(json: String) = Gson().fromJson(json, RemoteFmu::class.java)
    }

    val protoDefinition: String

    init {
        this.protoDefinition = Scanner(javaClass.classLoader
                .getResourceAsStream("protoDefinition.proto"), "UTF-8")
                .useDelimiter("\\A").next();
    }

    override fun toString(): String {
        return "RemoteFmu(hostAddress='$hostAddress', port=$port, guid='$guid', modelDescriptionXml='$modelDescriptionXml', protoDefinition='$protoDefinition')"
    }

}