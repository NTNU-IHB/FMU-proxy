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

package no.mechatronics.sfi.fmu_proxy.grpc


import org.slf4j.Logger
import org.slf4j.LoggerFactory

import io.grpc.Server
import io.grpc.ServerBuilder

import no.mechatronics.sfi.fmu_proxy.fmu.Fmus
import no.mechatronics.sfi.fmu_proxy.server.FmuProxyServer
import no.mechatronics.sfi.fmu_proxy.grpc.services.GrpcFmuService


/**
 *
 * @author Lars Ivar Hatledal
 */
class GrpcFmuServer(
         private val services: List<GrpcFmuService>
): FmuProxyServer {

    private var server: Server? = null

    constructor(vararg services: GrpcFmuService): this(services.toList())

    override fun start(port: Int) {
        if (server == null) {
            server = ServerBuilder.forPort(port)
                    .directExecutor()
                    .apply {
                        services.forEach { addService(it) }
                    }.build().start()

            LOG.info("${javaClass.simpleName} listening for connections on port: $port");
        } else {
            LOG.warn("${javaClass.simpleName} has already been started!")
        }
    }

    override fun stop() {
        server?.shutdown()
        Fmus.terminateAll()
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    fun blockUntilShutdown() {
        server?.awaitTermination()
    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuServer::class.java)

    }

}


