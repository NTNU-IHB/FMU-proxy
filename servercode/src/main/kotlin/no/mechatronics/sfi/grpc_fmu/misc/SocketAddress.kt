package no.mechatronics.sfi.grpc_fmu.misc

/**
 * Represents a hostAddress and port
 *
 * @author Lars Ivar Hatledal
 */
data class SocketAddress(
        val hostAddress: String,
        val port: Int
)