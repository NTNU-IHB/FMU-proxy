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

import no.ntnu.ihb.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.net.FmuProxyServer
import no.mechatronics.sfi.fmuproxy.thrift.services.ThriftFmuServiceImpl
import org.apache.thrift.protocol.TJSONProtocol
import org.apache.thrift.server.TServer
import org.apache.thrift.server.TServlet
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.transport.TServerSocket
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.FilterHolder
import org.eclipse.jetty.servlet.FilterMapping
import org.eclipse.jetty.servlet.ServletHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.servlets.CrossOriginFilter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface IServer {

    fun serve()
    fun stop()

}

abstract class ThriftFmuServer(
        fmus: Map<String, Fmu>
): FmuProxyServer {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuServer::class.java)

        fun socketServer(fmus: Map<String, Fmu>) = ThriftFmuSocketServer(fmus)
        fun servlet(fmus: Map<String, Fmu>) = ThriftFmuServlet(fmus)

    }

    override var port: Int? = null
    private var server: IServer? = null
    private val handler = ThriftFmuServiceImpl(fmus)

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
        fmus: Map<String, Fmu>
): ThriftFmuServer(fmus) {

    constructor(fmu: Fmu): this(mapOf(fmu.guid to fmu))

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
        fmus: Map<String, Fmu>
):  ThriftFmuServer(fmus) {

    constructor(fmu: Fmu): this(mapOf(fmu.guid to fmu))

    override val simpleName = "thrift/http"

    override fun setup(port: Int, processor: FmuService.Processor<ThriftFmuServiceImpl>): IServer {

        val server = Server(port).also {

            val handler = ServletHandler().apply {

                ServletHolder(TServlet(processor, TJSONProtocol.Factory())).also {
                    addServletWithMapping(it, "/thrift")
                }

                FilterHolder(CrossOriginFilter::class.java).apply {
                    name = "cross-origin"
                    setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*")
                    setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*")
                    setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD")
                    setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin")
                }.also { filter ->

                    FilterMapping().apply {
                        filterName = "cross-origin"
                        setPathSpec("*")
                    }.also { mapping ->
                        addFilter(filter, mapping)
                    }

                }

            }

            it.handler = handler
        }

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