package no.mechatronics.sfi.grpc_fmu.misc

/**
 * Represents a hostAddress and port
 *
 * @author Lars Ivar Hatledal
 */
data class SimpleSocketAddress(
        val hostAddress: String,
        val port: Int
) {

    override fun toString(): String {
        return "SimpleSocketAddress(hostAddress='$hostAddress', port=$port)"
    }
}