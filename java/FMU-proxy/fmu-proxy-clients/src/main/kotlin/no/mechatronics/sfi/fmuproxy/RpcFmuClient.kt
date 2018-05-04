package no.mechatronics.sfi.fmuproxy

import java.io.Closeable

interface RpcFmuClient: Closeable {

    @JvmDefault
    fun stop() = close()

}
