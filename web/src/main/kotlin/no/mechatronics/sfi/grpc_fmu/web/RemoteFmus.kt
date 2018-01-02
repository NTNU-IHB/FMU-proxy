package no.mechatronics.sfi.grpc_fmu.web

import com.google.gson.GsonBuilder
import no.mechatronics.sfi.grpc_fmu.RemoteFmu
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
