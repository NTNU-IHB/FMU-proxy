package no.mechatronics.sfi.grpc_fmu.web.fmu

import java.util.*

interface ChangeListener {

    fun onAdd(fmu: FmuBean)
    fun onRemove(fmu: FmuBean)

}

object Fmus {

    private val fmus: MutableSet<FmuBean> = Collections.synchronizedSet(HashSet())
    private val changeListeners: MutableList<ChangeListener> = ArrayList()

    fun get(): Set<FmuBean> = fmus

    fun addListener(changeListener: ChangeListener) {
        changeListeners.add(changeListener)
    }

    fun add(fmu: FmuBean): Boolean {
        synchronized(fmus) {
            val success = fmus.add(fmu)
            if (success) {
                changeListeners.forEach({ it.onAdd(fmu) })
            }
            return success
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