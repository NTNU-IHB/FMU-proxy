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
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport

class ThriftFmuClient(
        host: String,
        port: Int
): AbstractRpcFmuClient() {

    private val transport: TTransport
    private val client: FmuService.Client

    init {
        transport = TSocket(host, port).also {
            it.open()
        }
        client = FmuService.Client(TBinaryProtocol(transport))
    }

    override val modelDescription: CommonModelDescription by lazy {
        client.modelDescription.convert()
    }

    override val modelDescriptionXml: String by lazy {
        client.modelDescriptionXml
    }

    override fun getSimulationTime(instanceId: Int): Double {
        return client.getSimulationTime(instanceId)
    }

    override fun isTerminated(instanceId: Int): Boolean {
        return client.isTerminated(instanceId)
    }

    override fun init(instanceId: Int, start: Double, stop: Double): FmiStatus {
        return client.init(instanceId, start, stop).convert()
    }

    override fun terminate(instanceId: Int): FmiStatus {
        return client.terminate(instanceId).convert()
    }

    override fun step(instanceId: Int, stepSize: Double): Pair<Double, FmiStatus> {
        return client.step(instanceId, stepSize).let {
            it.simulationTime to it.status.convert()
        }
    }

    override fun reset(instanceId: Int): FmiStatus {
        return client.reset(instanceId).convert()
    }

    override fun createInstanceFromCS(): Int {
        return client.createInstanceFromCS()
    }

    override fun createInstanceFromME(solver: Solver): Int {
        return client.createInstanceFromME(solver.thriftType())
    }

    override fun close() {
        super.close()
        transport.close()
    }
    
    override fun readInteger(instanceId: Int, vr: List<ValueReference>): FmuIntegerArrayRead {
        return client.readInteger(instanceId, vr).convert()
    }
    
    override fun readReal(instanceId: Int, vr: List<ValueReference>): FmuRealArrayRead {
        return client.readReal(instanceId, vr).convert()
    }

    override fun readString(instanceId: Int, vr: List<ValueReference>): FmuStringArrayRead {
        return client.readString(instanceId, vr).convert()
    }
    
    override fun readBoolean(instanceId: Int, vr: List<ValueReference>): FmuBooleanArrayRead {
        return client.readBoolean(instanceId, vr).convert()
    }
    
    override fun writeInteger(instanceId: Int, vr: List<ValueReference>, value: List<Int>): FmiStatus {
        return client.writeInteger(instanceId, vr, value).convert()
    }
    
    override fun writeReal(instanceId: Int, vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return client.writeReal(instanceId, vr, value).convert()
    }

    override fun writeString(instanceId: Int, vr: List<ValueReference>, value: List<String>): FmiStatus {
        return client.writeString(instanceId, vr, value).convert()
    }
    
    override fun writeBoolean(instanceId: Int, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return client.writeBoolean(instanceId, vr, value).convert()
    }

}
