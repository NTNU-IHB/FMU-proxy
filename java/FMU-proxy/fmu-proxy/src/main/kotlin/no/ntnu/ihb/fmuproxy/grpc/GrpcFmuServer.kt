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

package no.ntnu.ihb.fmuproxy.grpc

import io.grpc.Server
import io.grpc.ServerBuilder
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment
import no.ntnu.ihb.fmuproxy.FmuId
import no.ntnu.ihb.fmuproxy.grpc.services.GrpcFmuServiceImpl
import no.ntnu.ihb.fmuproxy.net.FmuProxyServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

/**
 *
 * @author Lars Ivar Hatledal
 */
class GrpcFmuServer(
        private val fmus: MutableMap<String, Fmu> = Collections.synchronizedMap(mutableMapOf())
) : FmuProxyServer {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(GrpcFmuServer::class.java)
    }

    override var port: Int? = null
        private set

    override val simpleName = "grpc/http2"

    private var server: Server? = null
    internal var xcDefaults: Map<FmuId, DefaultExperiment>? = null

    private val isRunning: Boolean
        get() = server != null

    override fun addFmu(fmu: Fmu) {
        synchronized(fmus) {
            fmus[fmu.guid] = fmu
        }
    }

    override fun removeFmu(fmu: Fmu) {
        synchronized(fmus) {
            fmus.remove(fmu.guid)
        }
    }

    override fun start(port: Int) {
        if (!isRunning) {
            this.port = port
            server = ServerBuilder.forPort(port).apply {
                addService(GrpcFmuServiceImpl(fmus))
            }.build().start()

            LOG.info("${javaClass.simpleName} listening for connections on port: $port")
        } else {
            LOG.warn("${javaClass.simpleName} is already running!")
        }
    }

    override fun stop() {
        if (isRunning) {
            server?.also {
                LOG.info("Stopping ${javaClass.simpleName} ...")
                it.shutdownNow()
                it.awaitTermination()
                LOG.info("${javaClass.simpleName} stopped!")
            }
            server = null

        }
    }

    override fun close() {
        stop()
    }

}



