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
import no.ntnu.ihb.fmuproxy.AbstractFmuClient
import no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult
import no.ntnu.ihb.fmuproxy.FmuId
import no.ntnu.ihb.fmuproxy.StepResult
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TJSONProtocol
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.THttpClient
import org.apache.thrift.transport.TSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.File
import java.io.FileInputStream
import java.net.URL
import java.nio.ByteBuffer

class ThriftFmuClient(
        host: String,
        port: Int
): Closeable {

    private val protocol: TProtocol
    private val client: FmuService.Client

    init {
        val transport = TFramedTransport.Factory().getTransport(TSocket(host, port))
        protocol = TBinaryProtocol(transport)
        client = FmuService.Client(protocol)
        transport.open()
    }

    fun loadFromUrl(url: URL): AbstractFmuClient {
        return ThriftFmu(client.loadFromUrl(url.toString()))
    }

    fun loadFromLocalFile(file: File): AbstractFmuClient {
        require(file.exists()) { "No such file: ${file.absolutePath}" }
        require(file.name.endsWith(".fmu")) { "File must be an FMU!" }
        return ThriftFmu(client.loadFromLocalFile(file.absolutePath))
    }

    fun loadFromRemoteFile(file: File): AbstractFmuClient {
        require(file.exists()) { "No such file: ${file.absolutePath}" }
        require(file.name.endsWith(".fmu")) { "File must be an FMU!" }

        val data = FileInputStream(file).buffered().use { fis ->
            ByteBuffer.wrap(fis.readBytes())
        }
        return ThriftFmu(client.loadFromRemoteFile(file.nameWithoutExtension, data))
    }

    override fun close() {
        if (protocol.transport.isOpen) {
            protocol.transport.close()
        }
    }

    private inner class ThriftFmu(
        fmuId: FmuId
    ) : AbstractFmuClient(fmuId) {

        override val implementationName: String = "ThriftClient"

        override val modelDescription: CoSimulationModelDescription by lazy {
            client.getModelDescription(fmuId).convert()
        }

        override fun createInstance() {
            client.createInstance(fmuId)
        }

        override fun setupExperiment(start: Double, stop: Double, tolerance: Double): FmiStatus {
            return client.setupExperiment(fmuId, start, stop, tolerance).convert()
        }

        override fun enterInitializationMode(): FmiStatus {
            return client.enterInitializationMode(fmuId).convert()
        }

        override fun exitInitializationMode(): FmiStatus {
            return client.exitInitializationMode(fmuId).convert()
        }

        override fun step(stepSize: Double):  StepResult {
            return client.step(fmuId, stepSize).let {
                StepResult(it.simulationTime, it.status.convert())
            }
        }

        override fun reset(): FmiStatus {
            return client.reset(fmuId).convert()
        }

        override fun terminate(): FmiStatus {
            return client.terminate(fmuId).convert()
        }

        override fun freeInstance() {
            client.shutdown(fmuId)
        }

        override fun readInteger(vr: List<ValueReference>): IntegerArrayRead {
            return client.readInteger(fmuId, vr).convert()
        }

        override fun readReal(vr: List<ValueReference>): RealArrayRead {
            return client.readReal(fmuId, vr).convert()
        }

        override fun readString(vr: List<ValueReference>): StringArrayRead {
            return client.readString(fmuId, vr).convert()
        }

        override fun readBoolean(vr: List<ValueReference>): BooleanArrayRead {
            return client.readBoolean(fmuId, vr).convert()
        }

        override fun writeInteger(vr: List<ValueReference>, value: List<Int>): FmiStatus {
            return client.writeInteger(fmuId, vr, value).convert()
        }

        override fun writeReal(vr: List<ValueReference>, value: List<Real>): FmiStatus {
            return client.writeReal(fmuId, vr, value).convert()
        }

        override fun writeString(vr: List<ValueReference>, value: List<String>): FmiStatus {
            return client.writeString(fmuId, vr, value).convert()
        }

        override fun writeBoolean(vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
            return client.writeBoolean(fmuId, vr, value).convert()
        }

        override fun getDirectionalDerivative(vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult {
            return client.getDirectionalDerivative(fmuId, vUnknownRef, vKnownRef, dvKnownRef).let {
                DirectionalDerivativeResult(it.dvUnknownRef.toDoubleArray(), it.status.convert())
            }
        }

    }

}
