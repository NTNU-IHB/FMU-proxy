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
import org.apache.thrift.protocol.TJSONProtocol
import org.apache.thrift.server.TServer
import org.apache.thrift.server.TServlet
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.transport.TServerSocket
import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.ServletHandler
import org.mortbay.jetty.servlet.ServletHolder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface IServer {

    fun serve()
    fun stop()

}


abstract class ThriftFmuServer(
        fmu: Fmu
): FmuProxyServer {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServer::class.java)

        fun socketServer(fmu: Fmu) = ThriftFmuSocketServer(fmu)
        fun servlet(fmu: Fmu) = ThriftFmuServlet(fmu)

    }

    override var port: Int? = null
    private var server: IServer? = null
    private val handler = ThriftFmuServiceImpl(fmu)

    override fun start(port: Int) {

       if (server == null) {
           this.port = port
           this.server = setup(port, FmuService.Processor(handler)).apply {
               Thread { serve() }.start()
           }

           LOG.info("${javaClass.simpleName} listening for connections on port: $port")
       } else {
           LOG.warn("Server already started!")
       }

    }

    abstract fun setup(port: Int, processor: FmuService.Processor<ThriftFmuServiceImpl>) : IServer

    override fun stop() {
        server?.also {
            LOG.info("Stopping ${javaClass.simpleName} ...")
            it.stop()
            LOG.info("${javaClass.simpleName} stopped!")
        }
    }

}


class ThriftFmuSocketServer(
        fmu: Fmu
): ThriftFmuServer(fmu) {

    override val simpleName = "thrift/tcp"

    override fun setup(port: Int, processor: FmuService.Processor<ThriftFmuServiceImpl>): IServer {
        val transport = TServerSocket(port)
        val server = TSimpleServer(TServer.Args(transport).processor(processor))

        return object: IServer {

            override fun serve() {
                server.serve()
            }

            override fun stop() {
                server.stop()
            }
        }

    }

}

class ThriftFmuServlet(
        fmu: Fmu
):  ThriftFmuServer(fmu) {

    override val simpleName = "thrift/http"

    override fun setup(port: Int, processor: FmuService.Processor<ThriftFmuServiceImpl>): IServer {

        val server = Server(port)
        val handler = ServletHandler()
        val holder = ServletHolder(TServlet(processor, TJSONProtocol.Factory()))
        handler.addServletWithMapping(holder, "/thrift")
        server.handler = handler
        return object: IServer {

            override fun serve() {
                server.start()
            }

            override fun stop() {
                server.stop()
            }
        }


    }

}