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

package no.mechatronics.sfi.fmu_proxy.avro

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.avro.services.AvroFmuServiceImpl
import no.mechatronics.sfi.fmu_proxy.net.FmuProxyServer
import org.apache.avro.ipc.NettyServer
import org.apache.avro.ipc.Server
import org.apache.avro.ipc.specific.SpecificResponder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.InetSocketAddress

/**
 * @author Lars Ivar Hatledal
 */
class AvroFmuServer(
        private val fmuFile: FmuFile
): FmuProxyServer {

    private var server: Server? = null

    override val simpleName = "avro/tcp"

    override var port: Int? = null

    val isRunning: Boolean
        get() = server != null

    override fun start(port: Int) {
        if (!isRunning) {
            val responder = SpecificResponder(AvroFmuService::class.java, AvroFmuServiceImpl(fmuFile))
            server = NettyServer(responder, InetSocketAddress(port))
        }
    }

    override fun stop() {
        if (isRunning) {
            server?.close()
            server = null
        }
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(AvroFmuServer::class.java)
    }

}