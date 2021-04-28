/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology (NTNU)
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

package no.ntnu.ihb.fmuproxy.thrift

import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.server.TNonblockingServer
import org.apache.thrift.transport.TNonblockingServerSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.File
import java.io.FileOutputStream
import java.net.ServerSocket
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

class BootServiceImpl(
    port: Int,
) : BootService.Iface, Closeable {

    private val server: TNonblockingServer

    private val started = AtomicBoolean(false)
    internal val stopped = AtomicBoolean(false)

    init {

        val transport = TNonblockingServerSocket(port)
        val processor = BootService.Processor(this)
        this.server = TNonblockingServer(
            TNonblockingServer.Args(transport)
                .processor(processor)
                .protocolFactory(TBinaryProtocol.Factory())
        )
    }

    fun start() {
        if (!started.getAndSet(true)) {
            thread(start = true) {
                server.serve()
            }
        }
    }


    override fun loadFromLocalFile(fileName: String, instanceName: String): Int {
        val proxyFile = File(PROXY_JAR)
        if (!proxyFile.exists()) {
            FileOutputStream(proxyFile).buffered().use {
                val resource = BootServiceImpl::class.java.classLoader.getResource(PROXY_JAR)!!
                it.write(resource.readBytes())
            }
        }
        val fmuFile = File(fileName)
        require(fmuFile.exists())
        val start = startLocalProxy(proxyFile, fmuFile, instanceName)
        return start.second
    }

    override fun loadFromBinaryData(name: String, instanceName: String, data: ByteBuffer): Int {
        TODO()
    }

    override fun close() {
        if (started.get() && !stopped.get()) {
            server.stop()
            stopped.set(true)
            LOG.info("FMU-proxy-booter stopped!")
        }
    }

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(BootServiceImpl::class.java)

        private const val PROXY_JAR = "fmu-proxy-server.jar"

        private fun getAvailablePort(): Int {
            return ServerSocket(0).use {
                it.localPort
            }
        }

        private fun startLocalProxy(proxyFile: File, fmuFile: File, instanceName: String): Pair<Process, Int> {

            require(fmuFile.exists()) { "No such file: ${fmuFile.absolutePath}" }
            require(proxyFile.exists()) { "No such file: ${proxyFile.absolutePath}" }

            val port = getAvailablePort()
            val cmd = arrayOf(
                "java", "-jar",
                proxyFile.absolutePath,
                "$port",
                fmuFile.absolutePath,
                instanceName
            )

            val pb = ProcessBuilder().apply {
                command(*cmd)
            }

            val process = pb.start()
            thread(true) {
                val br = process.inputStream.bufferedReader()
                while (true) {
                    val read = br.readLine()
                    if (read == null) break else println(read)
                }
            }

            return process to port
        }

    }

}
