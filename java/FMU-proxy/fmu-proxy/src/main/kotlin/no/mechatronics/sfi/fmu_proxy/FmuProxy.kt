/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.fmu.RemoteFmu
import no.mechatronics.sfi.fmu_proxy.heartbeat.Heartbeat
import no.mechatronics.sfi.fmu_proxy.net.FmuProxyServer
import no.mechatronics.sfi.fmu_proxy.net.NetworkInfo
import no.mechatronics.sfi.fmu_proxy.net.SimpleSocketAddress
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.net.InetAddress
import java.net.UnknownHostException

/**
 * @author Lars Ivar Hatledal
 */
class FmuProxy(
        private val fmuFile: FmuFile,
        private val remote: SimpleSocketAddress? = null,
        private val servers: Map<FmuProxyServer, Int?>
): Closeable {

    private var beat: Heartbeat? = null
    private var hasStarted = false

    private val hostAddress: String
        get() {
            return try {
                InetAddress.getLocalHost().hostAddress
            } catch (ex: UnknownHostException) {
                "127.0.0.1"
            }
        }

    val networkInfo: NetworkInfo
        get() {
            return NetworkInfo(
                    host = hostAddress,
                    ports = servers.keys.associate { it.simpleName to (servers[it] ?: it.port ?: -1) }
            )
        }

    private val remoteFmu: RemoteFmu
        get() {
            return RemoteFmu(
                    guid = fmuFile.modelDescription.guid,
                    networkInfo = networkInfo,
                    modelDescriptionXml = fmuFile.modelDescriptionXml)
        }


    /**
     * Start proxy
     */
    fun start() {
        if (!hasStarted.also { hasStarted = true }) {
            servers.forEach {
                val (server, port) = it
                if (port == null) server.start() else server.start(port)
            }
            beat = remote?.let {
                Heartbeat(remote, remoteFmu).apply {
                    start()
                }
            }
        }
    }

    /**
     * Stop proxy
     */
    fun stop() {
        if (hasStarted) {
            beat?.stop()
            servers.forEach {
                it.key.stop()
            }
        }
    }

    /**
     * Same as Stop()
     */
    override fun close() {
        stop()
    }

    fun <E: FmuProxyServer> getServer(server: Class<E>): E? {
        return servers.keys.firstOrNull{ server.isAssignableFrom(it.javaClass) } as E
    }

    fun getPortFor(server: Class<out FmuProxyServer>): Int? {
        return servers.keys.firstOrNull { server.isAssignableFrom(it.javaClass) }?.port
    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(FmuProxy::class.java)
    }

}

/**
 * @author Lars Ivar Hatledal
 */
class FmuProxyBuilder(
        private val fmuFile: FmuFile
) {

    private var remote: SimpleSocketAddress? = null
    private val servers = mutableMapOf<FmuProxyServer, Int?>()

    fun setRemote(remote: SimpleSocketAddress?): FmuProxyBuilder {
        this.remote = remote
        return this
    }

    @JvmOverloads
    fun addServer(server: FmuProxyServer, port: Int? = null): FmuProxyBuilder {
        servers[server] = port
        return this
    }

    fun build(): FmuProxy {
        return FmuProxy(fmuFile, remote, servers)
    }

}