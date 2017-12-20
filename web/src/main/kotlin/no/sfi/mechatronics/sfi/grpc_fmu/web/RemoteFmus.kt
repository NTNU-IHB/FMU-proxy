package no.sfi.mechatronics.sfi.grpc_fmu.web

import com.google.gson.GsonBuilder
import java.util.*
import kotlin.collections.HashSet

object RemoteFmus {

    private val fmus: MutableSet<RemoteFmu> = Collections.synchronizedSet(HashSet())

    fun add(fmu: RemoteFmu) {
        synchronized(fmus) {
            fmus.add(fmu)
        }
    }

    fun remove(guid: String): Boolean {
        synchronized(fmus) {
            for (fmu in fmus) {
                if (fmu.guid == guid) {
                    return fmus.remove(fmu)
                }
            }
        }
        return false
    }

}


class RemoteFmu private constructor()  {

    companion object {

        fun parse(json: String): RemoteFmu {
            return GsonBuilder().create().let {
                it.fromJson(json, RemoteFmu::class.java)
            }
        }
    }

    var port = -1

    lateinit var guid: String
    lateinit var modelName: String
    lateinit var hostAddress: String

    lateinit var modelDescription: String
    lateinit var protoDescription: String


    override fun toString(): String {
        return "RemoteFmu(modelName='$modelName', hostAddress='$hostAddress', port=$port, guid='$guid')"
    }


}