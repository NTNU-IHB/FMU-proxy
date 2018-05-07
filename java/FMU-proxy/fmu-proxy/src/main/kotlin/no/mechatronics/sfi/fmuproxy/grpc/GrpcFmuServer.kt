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

package no.mechatronics.sfi.fmuproxy.grpc


import io.grpc.Server
import io.grpc.ServerBuilder
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.grpc.services.GrpcFmuService
import no.mechatronics.sfi.fmuproxy.grpc.services.GrpcFmuServiceImpl
import no.mechatronics.sfi.fmuproxy.net.FmuProxyServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 *
 * @author Lars Ivar Hatledal
 */
class GrpcFmuServer(
        fmu: Fmu
): FmuProxyServer {

    override var port: Int? = null
    override val simpleName = "grpc/http2"

    private var server: Server? = null

    private val services: MutableList<GrpcFmuService>
        = mutableListOf(GrpcFmuServiceImpl(fmu))

    val isRunning: Boolean
        get() = server != null

    fun addService(service: GrpcFmuService) {
        if (isRunning) {
            error("Cannot add service while running!")
        }
        services.add(service)
    }

    override fun start(port: Int) {
        if (!isRunning) {
            this.port = port
            server = ServerBuilder.forPort(port).apply {
                services.forEach { addService(it) }
            }.build().start()

            LOG.info("${javaClass.simpleName} listening for connections on port: $port")
        } else {
            LOG.warn("${javaClass.simpleName} is already running!")
        }
    }

    override fun stop() {
        if (isRunning) {
            server!!.apply {
                shutdownNow()
                awaitTermination()
            }
            server = null
            LOG.info("${javaClass.simpleName} stopped!")
        }
    }

    override fun close() {
        stop()
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



