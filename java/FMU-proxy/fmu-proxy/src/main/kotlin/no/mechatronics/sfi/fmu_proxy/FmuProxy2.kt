package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.heartbeat.Heartbeat
import java.io.Closeable
import java.net.InetAddress
import java.net.UnknownHostException

data class SimpleSocketAddress(
        val host: String,
        val port: Int
)

class FmuProxy2(
        private val fmuFile: FmuFile,
        private val remote: SimpleSocketAddress? = null,
        private val servers: List<FmuProxyServer>
): Closeable {

    private var beat: Heartbeat? = null

    fun start() {
        servers.forEach { it.start() }
        beat = remote?.let {
            Heartbeat(remote, remoteFmu).apply {
                start()
            }
        }
    }

    fun stop() {
        beat?.stopBlocking()
        servers.forEach { it.stop() }
    }

    override fun close() = stop()


    private val hostAddress: String
        get() {
            return try {
                InetAddress.getLocalHost().hostAddress
            } catch (ex: UnknownHostException) {
                "127.0.0.1"
            }
        }

    private val remoteFmu: RemoteFmu
    get() {
        return RemoteFmu(
                guid = fmuFile.modelDescription.guid,
                networkInfo = networkInfo,
                modelDescriptionXml = fmuFile.modelDescriptionXml)
    }

    private val networkInfo: NetworkInfo
        get() {
            return NetworkInfo(
                host = hostAddress,
                ports = servers.associate { it.simpleName to it.port!! }
            )
        }



}