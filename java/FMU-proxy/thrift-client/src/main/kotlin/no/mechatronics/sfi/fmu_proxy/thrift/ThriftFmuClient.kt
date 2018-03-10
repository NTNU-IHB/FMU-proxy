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

package no.mechatronics.sfi.fmu_proxy.thrift

import java.io.Closeable
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport
import org.apache.thrift.protocol.TBinaryProtocol
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal object FmuInstances: ArrayList<FmuInstance>() {
    internal fun terminateAll() {
        forEach{ it.terminate() }
    }
}

class ThriftFmuClient(
        host: String,
        port: Int
): Closeable {

    private val transport: TTransport
    private val client: ThriftFmuService.Client

    init {
        transport = TSocket(host, port)
        transport.open()

        val protocol = TBinaryProtocol(transport)
        client = ThriftFmuService.Client(protocol)

    }

    val modelName: String
        get() = client.modelName

    val guid: String
        get() = client.guid

    @JvmOverloads
    fun createInstance(integrator: Integrator? = null): FmuInstance {
        val fmuId = if (integrator == null) {
            client.createInstanceFromCS()
        } else {
            client.createInstanceFromME(integrator)
        }
        return FmuInstance(client, fmuId).also {
            FmuInstances.add(it)
        }
    }

    fun stop() = close()

    override fun close() {
        LOG.info("Closing..")
        FmuInstances.terminateAll()
        transport.close()
    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ThriftFmuClient::class.java)
    }

}

class FmuInstance(
        private val client: ThriftFmuService.Client,
        private val fmuId: Int
): Closeable {

    val currentTime: Double
        get() = client.getCurrentTime(fmuId)

    val isTerminated: Boolean
        get() = client.isTerminated(fmuId)

    fun init(): Boolean {
        return client.init(fmuId)
    }

    fun step(stepSize: Double): StatusCode {
        return client.step(fmuId, stepSize)
    }

    fun terminate(): Boolean {
        return client.terminate(fmuId).also {
            FmuInstances.remove(this)
        }
    }

    override fun close() {
        terminate()
    }
}
