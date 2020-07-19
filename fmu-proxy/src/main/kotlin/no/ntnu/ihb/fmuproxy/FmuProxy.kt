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

package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.cli.CommandLineParser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

class FmuProxy(
    private val servers: Map<FmuProxyServer, Int>
) : Closeable {

    private var hasStarted = AtomicBoolean(false)

    /**
     * Start proxy
     */
    fun start() {
        if (!hasStarted.getAndSet(true)) {
            servers.forEach { (server, port) ->
                server.start(port) { stop() }
            }
        }
    }

    /**
     * Stop proxy
     */
    fun stop() {
        if (hasStarted.get()) {
            servers.forEach {
                it.key.stop()
            }
            LOG.debug("FMU-proxy stopped!")
        } else {
            LOG.warn("Calling stop, but FMU-proxy has not started..")
        }
    }

    /**
     * Same as Stop()
     */
    override fun close() {
        stop()
    }

    fun <T : FmuProxyServer> getServer(server: Class<T>): T? {
        @Suppress("UNCHECKED_CAST")
        return servers.keys.firstOrNull { server.isAssignableFrom(it.javaClass) } as T
    }

    inline fun <reified T : FmuProxyServer> getServer(): T? {
        return getServer(T::class.java)
    }

    fun getPortFor(server: Class<out FmuProxyServer>): Int? {
        return servers.keys.firstOrNull { server.isAssignableFrom(it.javaClass) }?.port
    }

    inline fun <reified T : FmuProxyServer> getPortFor(): Int? {
        return getPortFor(T::class.java)
    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(FmuProxy::class.java)

        @JvmStatic
        fun main(args: Array<String>) {

            CommandLineParser.parse(args).also {
                it?.apply {
                    start()
                    println("Press any key to exit..")
                    if (Scanner(System.`in`).hasNext()) {
                        println("Exiting..")
                    }
                    stop()
                }
            }
        }

    }

}

class FmuProxyBuilder {

    private val servers = mutableMapOf<FmuProxyServer, Int>()

    fun addServer(server: FmuProxyServer, port: Int): FmuProxyBuilder {
        servers[server] = port
        return this
    }

    fun build(): FmuProxy {
        return FmuProxy(servers)
    }

}
