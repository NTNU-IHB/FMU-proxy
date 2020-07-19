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

package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.*
import no.ntnu.ihb.fmi4j.modeldescription.CoSimulationModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.Real
import no.ntnu.ihb.fmi4j.modeldescription.ValueReference
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult
import no.ntnu.ihb.fmuproxy.StepResult
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TJSONProtocol
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.THttpClient
import org.apache.thrift.transport.TSocket


class ThriftFmuClient private constructor(
        private val protocol: TProtocol
) : AbstractRpcFmuClient() {

    private val client = FmuService.Client(protocol)

    override val modelDescription: CoSimulationModelDescription by lazy {
        client.modelDescription.convert()
    }

    override fun instantiate() {
        client.instantiate()
    }

    override fun setupExperiment(start: Double, stop: Double, tolerance: Double): FmiStatus {
        return client.setupExperiment(start, stop, tolerance).convert()
    }

    override fun enterInitializationMode(): FmiStatus {
        return client.enterInitializationMode().convert()
    }

    override fun exitInitializationMode(): FmiStatus {
        return client.exitInitializationMode().convert()
    }

    override fun step(stepSize: Double): StepResult {
        return client.step(stepSize).let {
            StepResult(it.simulationTime, it.status.convert())
        }
    }

    override fun reset(): FmiStatus {
        return client.reset().convert()
    }

    override fun terminate(): FmiStatus {
        return client.terminate().convert()
    }

    override fun freeInstance() {
        client.close()
    }

    override fun readInteger(vr: List<ValueReference>): IntegerArrayRead {
        return client.readInteger(vr).convert()
    }

    override fun readReal(vr: List<ValueReference>): RealArrayRead {
        return client.readReal(vr).convert()
    }

    override fun readString(vr: List<ValueReference>): StringArrayRead {
        return client.readString(vr).convert()
    }

    override fun readBoolean(vr: List<ValueReference>): BooleanArrayRead {
        return client.readBoolean(vr).convert()
    }

    override fun writeInteger(vr: List<ValueReference>, value: List<Int>): FmiStatus {
        return client.writeInteger(vr, value).convert()
    }

    override fun writeReal(vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return client.writeReal(vr, value).convert()
    }

    override fun writeString(vr: List<ValueReference>, value: List<String>): FmiStatus {
        return client.writeString(vr, value).convert()
    }

    override fun writeBoolean(vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return client.writeBoolean(vr, value).convert()
    }

    override fun getDirectionalDerivative(vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult {
        return client.getDirectionalDerivative(vUnknownRef, vKnownRef, dvKnownRef).let {
            DirectionalDerivativeResult(it.dvUnknownRef.toDoubleArray(), it.status.convert())
        }
    }

    override fun close() {
        if (protocol.transport.isOpen) {
            protocol.transport.close()
        }
    }

    companion object {

        fun socketClient(host: String, port: Int): ThriftFmuClient {
            val transport = TFramedTransport.Factory().getTransport(TSocket(host, port))
            val protocol = TBinaryProtocol(transport)
            transport.open()
            return ThriftFmuClient(protocol)
        }

        fun servletClient(host: String, port: Int): ThriftFmuClient {
            val client = HttpClientBuilder.create().build()
            val protocol = TJSONProtocol(THttpClient("http://$host:$port/thrift", client)).also {
                it.transport.open()
            }
            return ThriftFmuClient(protocol)
        }

    }

}
