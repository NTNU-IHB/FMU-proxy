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

package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmuproxy.RpcFmuClient
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable

internal object FmuInstances: ArrayList<ThriftFmuClient.FmuInstance>() {
    internal fun terminateAll() {
        forEach{ it.terminate() }
    }
}

class ThriftFmuClient(
        host: String,
        port: Int
): RpcFmuClient {

    private val transport: TTransport
    private val client: FmuService.Client

    init {
        transport = TSocket(host, port)
        transport.open()

        val protocol = TBinaryProtocol(transport)
        client = FmuService.Client(protocol)

    }

    val modelDescription: ModelDescription by lazy {
        client.modelDescription
    }

    val modelDescriptionXml: String by lazy {
        client.modelDescriptionXml
    }

    @JvmOverloads
    fun createInstance(integrator: Integrator? = null): FmuInstance {
        val fmuId = if (integrator == null) {
            client.createInstanceFromCS()
        } else {
            client.createInstanceFromME(integrator)
        }
        return FmuInstance(fmuId).also {
            FmuInstances.add(it)
        }
    }

    override fun close() {
        LOG.info("Closing..")
        FmuInstances.terminateAll()
        transport.close()
    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ThriftFmuClient::class.java)
    }


    inner class FmuInstance(
            private val fmuId: Int
    ): Closeable {

        val currentTime: Double
            get() = client.getCurrentTime(fmuId)

        val isTerminated: Boolean
            get() = client.isTerminated(fmuId)

        @JvmOverloads
        fun init(start:Double=0.0, stop:Double=-1.0): StatusCode {
            return client.init(fmuId,start, stop)
        }

        fun step(stepSize: Double): StatusCode {
            return client.step(fmuId, stepSize)
        }

        fun terminate(): StatusCode {
            return try {
                client.terminate(fmuId)
            } finally {
                FmuInstances.remove(this)
            }
        }

        fun reset(): StatusCode {
            return client.reset(fmuId)
        }

        override fun close() {
            terminate()
        }
    }


}
