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

package no.mechatronics.sfi.rmu.grpc


import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.net.ServerSocket

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.BindableService


import no.mechatronics.sfi.rmu.Fmus
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.rmu.grpc.services.FmuService
import no.mechatronics.sfi.rmu.grpc.services.GenericFmuService


/**
 *
 * @author Lars Ivar Hatledal
 */
class FmuServer(
        private val fmuFile: FmuFile
) {

    private var server: Server? = null
    private val services = mutableListOf<BindableService>(GenericFmuService(fmuFile))

    val guid: String
        get() = fmuFile.modelDescription.guid

    val modelDescriptionXml: String
        get() = fmuFile.modelDescriptionXml

    fun addService(service: FmuService) {
        if (server == null) {
            services.add(service)
        } else {
            throw IllegalStateException("Services must be added before")
        }
    }

    fun start(): Int {
        return ServerSocket(0).use { ss -> ss.localPort }.also {
            start(it)
        }
    }

    fun start(port: Int) {
        if (server == null) {
            server = ServerBuilder.forPort(port)
                    .apply {
                        services.forEach { addService(it) }
                    }.build().start()

            LOG.info("FMU listening for connections on port: {}", port);
        }
    }

    fun stop() {
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

        val LOG: Logger = LoggerFactory.getLogger(FmuServer::class.java)

    }

}


