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

package no.mechatronics.sfi.grpc_fmu.avro

import no.mechatronics.sfi.fmu_proxy.avro.AvroFmuService
import no.mechatronics.sfi.fmu_proxy.avro.Integrator
import no.mechatronics.sfi.fmu_proxy.avro.StatusCode
import org.apache.avro.ipc.NettyTransceiver
import org.apache.avro.ipc.Transceiver
import org.apache.avro.ipc.specific.SpecificRequestor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.net.InetSocketAddress

internal object FmuInstances: ArrayList<AvroFmuClient.FmuInstance>() {
    internal fun terminateAll() {
        forEach{ it.terminate() }
    }
}

class AvroFmuClient(
        host: String,
        port: Int
): Closeable {

    private val client: Transceiver
    private val service: AvroFmuService

    init {
        client = NettyTransceiver(InetSocketAddress(host, port))
        service = SpecificRequestor.getClient(AvroFmuService::class.java, client)
    }

    val modelDescription by lazy {
        service.modelDescription
    }

    val modelDescriptionXml: String by lazy {
        service.modelDescriptionXml
    }

    @JvmOverloads
    fun createInstance(integrator: Integrator? = null): FmuInstance {
        val fmuId = if (integrator == null) {
            service.createInstanceFromCS()
        } else {
            service.createInstanceFromME(integrator)
        }
        return FmuInstance(fmuId).also {
            FmuInstances.add(it)
        }
    }

    fun stop() {
        close()
    }

    override fun close() {
        LOG.info("Closing..")
        FmuInstances.terminateAll()
        client.close()
    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(AvroFmuClient::class.java)
    }

    inner class FmuInstance(
            private val fmuId: Int
    ): Closeable {

        val currentTime: Double
            get() = service.getCurrentTime(fmuId)

        val isTerminated: Boolean
            get() = service.isTerminated(fmuId)

        @JvmOverloads
        fun init(start:Double=0.0, stop:Double=-1.0): Boolean {
            return service.init(fmuId,start, stop)
        }

        fun step(stepSize: Double): StatusCode {
            return service.step(fmuId, stepSize)
        }

        fun terminate(): Boolean {
            return service.terminate(fmuId).also {
                FmuInstances.remove(this)
            }
        }

        fun reset(): Boolean {
            return service.reset(fmuId)
        }

        override fun close() {
            terminate()
        }

    }

}