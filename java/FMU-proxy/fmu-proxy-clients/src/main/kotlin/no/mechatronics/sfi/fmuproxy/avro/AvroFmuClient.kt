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
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver
import org.apache.avro.ipc.NettyTransceiver
import org.apache.avro.ipc.specific.SpecificRequestor
import java.net.InetSocketAddress

class AvroFmuClient(
        fmuId: String,
        host: String,
        port: Int
): AbstractRpcFmuClient(fmuId) {

    private val client = NettyTransceiver(InetSocketAddress(host, port))
    private val service = SpecificRequestor.getClient(AvroFmuService::class.java, client)

    override val modelDescription: CommonModelDescription by lazy {
        service.getModelDescription(fmuId).convert()
    }

    override val modelDescriptionXml: String by lazy {
        service.getModelDescriptionXml(fmuId)
    }

    override fun createInstanceFromCS(): String {
        return service.createInstanceFromCS(fmuId)
    }

    override fun createInstanceFromME(solver: Solver): String {
        return service.createInstanceFromME(fmuId, solver.avroType())
    }

    override fun init(instanceId: String, start: Double, stop: Double): FmiStatus {
        return service.init(instanceId, start, stop).convert()
    }

    override fun terminate(instanceId: String): FmiStatus {
        return service.terminate(instanceId).convert()
    }

    override fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus> {
        return service.step(instanceId, stepSize).let {
            it.simulationTime to it.status.convert()
        }
    }

    override fun reset(instanceId: String): FmiStatus {
        return service.reset(instanceId).convert()
    }
    
    override fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead {
        return service.readInteger(instanceId, vr).convert()
    }
    
    override fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead {
        return service.readReal(instanceId, vr).convert()
    }
    
    override fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead {
        return service.readString(instanceId, vr).convert()
    }

    override fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead {
        return service.readBoolean(instanceId, vr).convert()
    }

    override fun writeInteger(instanceId: String, vr: List<Int>, value: List<Int>): FmiStatus {
        return service.writeInteger(instanceId, vr, value).convert()
    }

    override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return service.writeReal(instanceId, vr, value).convert()
    }

    override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
        return service.writeString(instanceId, vr, value).convert()
    }

    override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return service.writeBoolean(instanceId, vr, value).convert()
    }

    override fun close() {
        super.close()
        client.close()
    }

}