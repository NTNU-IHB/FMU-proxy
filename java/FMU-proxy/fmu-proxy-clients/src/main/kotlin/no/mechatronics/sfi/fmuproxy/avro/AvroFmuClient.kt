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

package no.mechatronics.sfi.fmuproxy.avro

import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmuproxy.IntegratorSettings
import no.mechatronics.sfi.fmuproxy.RpcFmuClient
import org.apache.avro.ipc.NettyTransceiver
import org.apache.avro.ipc.specific.SpecificRequestor
import java.net.InetSocketAddress


class AvroFmuClient(
        host: String,
        port: Int
): RpcFmuClient() {

    private val client = NettyTransceiver(InetSocketAddress(host, port))
    private val service = SpecificRequestor.getClient(AvroFmuService::class.java, client)

    val modelDescription by lazy {
        service.modelDescription
    }

    override val modelDescriptionXml: String by lazy {
        service.modelDescriptionXml
    }

    override fun getCurrentTime(fmuId: Int): Double {
        return service.getCurrentTime(fmuId)
    }

    override fun isTerminated(fmuId: Int): Boolean {
        return service.isTerminated(fmuId)
    }

    override fun init(fmuId: Int, start: Double, stop: Double): FmiStatus {
        return service.init(fmuId, start, stop).convert()
    }

    override fun terminate(fmuId: Int): FmiStatus {
        return service.terminate(fmuId).convert()
    }

    override fun step(fmuId: Int, stepSize: Double): FmiStatus {
        return service.step(fmuId, stepSize).convert()
    }

    override fun reset(fmuId: Int): FmiStatus {
        return service.reset(fmuId).convert()
    }

    override fun readInteger(fmuId: Int, name: String): FmuIntegerRead {
        return modelDescription.modelVariables.find { it.name == name }?.let {
            service.readInt(fmuId, it.valueReference).convert()
        } ?: throw IllegalArgumentException("")
    }

    override fun readReal(fmuId: Int, name: String): FmuRealRead {
        return modelDescription.modelVariables.find { it.name == name }?.let {
            service.readReal(fmuId, it.valueReference).convert()
        } ?: throw IllegalArgumentException("")
    }

    override fun readString(fmuId: Int, name: String): FmuStringRead {
        return modelDescription.modelVariables.find { it.name == name }?.let {
            service.readString(fmuId, it.valueReference).convert()
        } ?: throw IllegalArgumentException("")
    }

    override fun readBoolean(fmuId: Int, name: String): FmuBooleanRead {
        return modelDescription.modelVariables.find { it.name == name }?.let {
            service.readBoolean(fmuId, it.valueReference).convert()
        } ?: throw IllegalArgumentException("")
    }

    override fun createInstanceFromCS(): Int {
        return service.createInstanceFromCS()
    }

    override fun createInstanceFromME(integrator: IntegratorSettings): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun close() {
        super.close()
        client.close()
    }

}