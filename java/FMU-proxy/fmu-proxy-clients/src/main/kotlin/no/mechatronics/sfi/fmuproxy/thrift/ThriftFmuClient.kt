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

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmuproxy.IntegratorSettings
import no.mechatronics.sfi.fmuproxy.RpcFmuClient
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport


class ThriftFmuClient(
        host: String,
        port: Int
): RpcFmuClient() {

    private val transport: TTransport
    private val client: FmuService.Client

    private val nameToVr = mutableMapOf<String, Int>()

    init {
        transport = TSocket(host, port).also {
            it.open()
        }

        val protocol = TBinaryProtocol(transport)
        client = FmuService.Client(protocol)

    }

    val modelDescription: ModelDescription by lazy {
        client.modelDescription
    }

    override val modelDescriptionXml: String by lazy {
        client.modelDescriptionXml
    }

    override fun getCurrentTime(fmuId: Int): Double {
        return client.getCurrentTime(fmuId)
    }

    override fun isTerminated(fmuId: Int): Boolean {
        return client.isTerminated(fmuId)
    }

    override fun init(fmuId: Int, start: Double, stop: Double): FmiStatus {
        return client.init(fmuId, start, stop).convert()
    }

    override fun terminate(fmuId: Int): FmiStatus {
        return client.terminate(fmuId).convert()
    }

    override fun step(fmuId: Int, stepSize: Double): FmiStatus {
        return client.step(fmuId, stepSize).convert()
    }

    override fun reset(fmuId: Int): FmiStatus {
        return client.reset(fmuId).convert()
    }

    override fun createInstanceFromCS(): Int {
        return client.createInstanceFromCS()
    }

    override fun createInstanceFromME(integrator: IntegratorSettings): Int {
        return client.createInstanceFromME(integrator.thriftType())
    }

    override fun close() {
        super.close()
        transport.close()
    }

    override fun getValueReference(name: String): Int? {
        return modelDescription.model_variables
                .firstOrNull { it.name == name }?.value_reference
    }

    override fun readInteger(fmuId: Int, vr: Int): FmuIntegerRead {
        return client.readInt(fmuId, vr).convert()
    }

    override fun bulkReadInteger(fmuId: Int, vr: List<Int>): FmuIntegerArrayRead {
        return client.bulkReadInt(fmuId, vr).convert()
    }

    override fun readReal(fmuId: Int, vr: Int): FmuRealRead {
        return client.readReal(fmuId, vr).convert()
    }

    override fun bulkReadReal(fmuId: Int, vr: List<Int>): FmuRealArrayRead {
        return client.bulkReadReal(fmuId, vr).convert()
    }

    override fun readString(fmuId: Int, vr: Int): FmuStringRead {
        return client.readString(fmuId, vr).convert()
    }

    override fun bulkReadString(fmuId: Int, vr: List<Int>): FmuStringArrayRead {
        return client.bulkReadString(fmuId, vr).convert()
    }

    override fun readBoolean(fmuId: Int, vr: Int): FmuBooleanRead {
        return client.readBoolean(fmuId, vr).convert()
    }

    override fun bulkReadBoolean(fmuId: Int, vr: List<Int>): FmuBooleanArrayRead {
        return client.bulkReadBoolean(fmuId, vr).convert()
    }

}
