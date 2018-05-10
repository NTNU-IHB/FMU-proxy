package no.mechatronics.sfi.fmuproxy


data class Solver(
        val name: String,
        private val settings: String
) {

    @Transient
    private var map: Map<String, *>? = null

    override fun toString(): String {
        return "Solver(name='$name', map=$map)"
    }

}