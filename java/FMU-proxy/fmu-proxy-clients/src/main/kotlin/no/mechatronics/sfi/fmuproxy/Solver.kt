package no.mechatronics.sfi.fmuproxy

import com.google.gson.Gson


data class Solver(
        val name: String,
        private val settings: String
) {


    @Transient
    private var map: Map<String, *>? = null

    fun <T> getProperty(property: String, type: Class<T>): T? {

        if (map == null) {
            map = Gson().fromJson(settings, Map::class.java) as Map<String, *>
        }

         return map!![property]?.let {
             it as T
         }

    }

    override fun toString(): String {
        return "Solver(name='$name', map=$map)"
    }

}