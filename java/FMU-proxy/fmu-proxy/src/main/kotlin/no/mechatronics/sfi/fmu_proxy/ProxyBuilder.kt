package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmi4j.fmu.FmuFile

class ProxyBuilder(
        private val fmuFile: FmuFile
) {

    private var remote: SimpleSocketAddress? = null
    private val servers = mutableListOf<FmuProxyServer>()

    fun setRemote(remote: SimpleSocketAddress?): ProxyBuilder {
        this.remote = remote
        return this
    }

    fun addServer(server: FmuProxyServer): ProxyBuilder {
        servers.add(server)
        return this
    }

    fun build(): FmuProxy2 {
        return FmuProxy2(fmuFile, remote, servers)
    }

}