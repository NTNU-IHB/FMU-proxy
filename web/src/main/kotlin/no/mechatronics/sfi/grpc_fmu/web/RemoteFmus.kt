package no.mechatronics.sfi.grpc_fmu.web

import no.mechatronics.sfi.grpc_fmu.RemoteFmu
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

interface ChangeListener {

    fun onAdd(fmu: RemoteFmu)
    fun onRemove(fmu: RemoteFmu)

}

object RemoteFmus {

    private val fmus: MutableSet<RemoteFmu> = Collections.synchronizedSet(HashSet())
    private val changeListeners: MutableList<ChangeListener> = ArrayList()

    fun get(): Set<RemoteFmu> = fmus

    fun addListener(changeListener: ChangeListener) {
        changeListeners.add(changeListener)
    }

    fun add(fmu: RemoteFmu) {
        synchronized(fmus) {
            fmus.add(fmu)
            changeListeners.forEach({it.onAdd(fmu)})
        }
    }

    fun remove(guid: String): Boolean {
        synchronized(fmus) {
            for (fmu in fmus) {
                if (fmu.guid == guid) {

                    return fmus.remove(fmu).also { success ->
                        if (success) {
                            changeListeners.forEach({it.onRemove(fmu)})
                        }
                    }

                }
            }
        }
        return false

    }

}
