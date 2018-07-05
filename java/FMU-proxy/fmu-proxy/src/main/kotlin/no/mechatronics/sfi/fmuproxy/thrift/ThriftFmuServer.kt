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

package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.net.FmuProxyServer
import no.mechatronics.sfi.fmuproxy.thrift.services.ThriftFmuServiceImpl
import org.apache.thrift.server.TServer
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.transport.TServerSocket
import org.apache.thrift.transport.TServerTransport
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class ThriftFmuServer(
        fmu: Fmu
): FmuProxyServer {

    override var port: Int? = null
    override val simpleName = "thrift/tcp"

    private var server: TServer? = null
    private var serverTransport: TServerTransport? = null

    private val handler = ThriftFmuServiceImpl(fmu)
    private val processor = FmuService.Processor(handler)

    val isRunning: Boolean
        get() = server != null

    override fun start(port: Int) {
        if (!isRunning) {
            serverTransport = TServerSocket(port).also { this.port = port }
            server = TSimpleServer(TServer.Args(serverTransport).processor(processor)).apply {
                Thread { serve() }.start()
            }
            LOG.info("${javaClass.simpleName} listening for connections on port: $port")
        } else {
            LOG.warn("${javaClass.simpleName} has already been started!")
        }
    }

    override fun stop() {
        if (isRunning) {
            server!!.stop()
            server = null
            LOG.info("${javaClass.simpleName} stopped!")
        }
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServer::class.java)
    }

}