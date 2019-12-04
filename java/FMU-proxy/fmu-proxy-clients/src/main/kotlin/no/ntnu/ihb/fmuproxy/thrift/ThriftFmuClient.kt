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
import no.ntnu.ihb.fmi4j.modeldescription.*
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult
import no.ntnu.ihb.fmuproxy.InstanceId
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

/**
 *
 * @author Lars Ivar Hatledal
 */
class ThriftFmuClient private constructor(
        private val protocol: TProtocol
): Closeable {

    private val client = FmuService.Client(protocol)

    fun load(fmuId: String): AbstractRpcFmuClient {
        return ThriftFmu(fmuId);
    }

    fun load(url: URL): AbstractRpcFmuClient {
        return client.loadFromUrl(url.toString()).let {
            load(it)
        }
    }

    fun load(file: File): AbstractRpcFmuClient {
        if (!file.name.endsWith(".fmu")) {
            throw IllegalArgumentException("File must be an FMU!")
        }
        val data = FileInputStream(file).use {
            ByteBuffer.wrap(it.readBytes())
        }
        return client.loadFromFile(file.nameWithoutExtension, data).let {
            load(it)
        }
    }

    override fun close() {
        if (protocol.transport.isOpen) {
            protocol.transport.close()
        }
    }

    private inner class ThriftFmu(
            fmuId: String
    ) : AbstractRpcFmuClient(fmuId) {

        override val implementationName: String = "ThriftClient"

        override val modelDescription: CoSimulationModelDescription by lazy {
            client.getModelDescription(fmuId).convert()
        }

        override fun createInstance(): String {
            return client.createInstance(fmuId)
        }

        override fun setup(instanceName: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus {
            return client.setupExperiment(instanceName, start, stop, tolerance).convert()
        }

        override fun enterInitializationMode(instanceName: InstanceId): FmiStatus {
            return client.enterInitializationMode(instanceName).convert()
        }

        override fun exitInitializationMode(instanceName: InstanceId): FmiStatus {
            return client.exitInitializationMode(instanceName).convert()
        }

        override fun terminate(instanceName: String): FmiStatus {
            return client.terminate(instanceName).convert()
        }

        override fun step(instanceName: String, stepSize: Double):  StepResult {
            return client.step(instanceName, stepSize).let {
                StepResult(it.simulationTime, it.status.convert())
            }
        }

        override fun reset(instanceName: String): FmiStatus {
            return client.reset(instanceName).convert()
        }

        override fun close() {
            super.close()
            LOG.debug("$implementationName closed..")
        }

        override fun readInteger(instanceName: String, vr: List<ValueReference>): IntegerArrayRead {
            return client.readInteger(instanceName, vr).convert()
        }

        override fun readReal(instanceName: String, vr: List<ValueReference>): RealArrayRead {
            return client.readReal(instanceName, vr).convert()
        }

        override fun readString(instanceName: String, vr: List<ValueReference>): StringArrayRead {
            return client.readString(instanceName, vr).convert()
        }

        override fun readBoolean(instanceName: String, vr: List<ValueReference>): BooleanArrayRead {
            return client.readBoolean(instanceName, vr).convert()
        }

        override fun writeInteger(instanceName: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
            return client.writeInteger(instanceName, vr, value).convert()
        }

        override fun writeReal(instanceName: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
            return client.writeReal(instanceName, vr, value).convert()
        }

        override fun writeString(instanceName: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
            return client.writeString(instanceName, vr, value).convert()
        }

        override fun writeBoolean(instanceName: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
            return client.writeBoolean(instanceName, vr, value).convert()
        }

        override fun getDirectionalDerivative(instanceName: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult {
            return client.getDirectionalDerivative(instanceName, vUnknownRef, vKnownRef, dvKnownRef).let {
                DirectionalDerivativeResult(it.dvUnknownRef.toDoubleArray(), it.status.convert())
            }
        }

    }


    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(ThriftFmuClient::class.java)

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
