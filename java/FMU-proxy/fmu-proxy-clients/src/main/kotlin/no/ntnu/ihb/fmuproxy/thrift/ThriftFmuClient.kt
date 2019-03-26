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

import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.Real
import no.ntnu.ihb.fmi4j.modeldescription.ValueReference
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.Solver
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
import java.lang.UnsupportedOperationException
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

    val availableFmus: List<AbstractRpcFmuClient>
        get() {
            return client.availableFmus.map {
                ThriftFmu(it.fmuId)
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

        override val modelDescription: ModelDescription by lazy {
            client.getModelDescription(fmuId).convert()
        }

        override val canCreateInstanceFromCS: Boolean by lazy {
            client.canCreateInstanceFromCs(fmuId)
        }

        override val canCreateInstanceFromME: Boolean by lazy {
            client.canCreateInstanceFromMe(fmuId)
        }

        override fun createInstanceFromCS(): String {
            return client.createInstanceFromCs(fmuId)
        }

        override fun createInstanceFromME(solver: Solver): String {
            return client.createInstanceFromMe(fmuId, solver.thriftType())
        }

        override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
            return client.getCoSimulationAttributes(instanceId).convert();
        }

        override fun setup(instanceId: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus {
            return client.setupExperiment(instanceId, start, stop, tolerance).convert()
        }

        override fun enterInitializationMode(instanceId: InstanceId): FmiStatus {
            return client.enterInitializationMode(instanceId).convert()
        }

        override fun exitInitializationMode(instanceId: InstanceId): FmiStatus {
            return client.exitInitializationMode(instanceId).convert()
        }

        override fun terminate(instanceId: String): FmiStatus {
            return client.terminate(instanceId).convert()
        }

        override fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus> {
            return client.step(instanceId, stepSize).let {
                it.simulationTime to it.status.convert()
            }
        }

        override fun reset(instanceId: String): FmiStatus {
            return client.reset(instanceId).convert()
        }

        override fun close() {
            super.close()
            if (protocol.transport.isOpen) {
                protocol.transport.close()
            }
            LOG.debug("$implementationName closed..")
        }

        override fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead {
            return client.readInteger(instanceId, vr).convert()
        }

        override fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead {
            return client.readReal(instanceId, vr).convert()
        }

        override fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead {
            return client.readString(instanceId, vr).convert()
        }

        override fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead {
            return client.readBoolean(instanceId, vr).convert()
        }

        override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
            return client.writeInteger(instanceId, vr, value).convert()
        }

        override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
            return client.writeReal(instanceId, vr, value).convert()
        }

        override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
            return client.writeString(instanceId, vr, value).convert()
        }

        override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
            return client.writeBoolean(instanceId, vr, value).convert()
        }

        override fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): Pair<List<Double>, FmiStatus> {
            return client.getDirectionalDerivative(instanceId, vUnknownRef, vKnownRef, dvKnownRef).let {
                it.dvUnknownRef to it.status.convert()
            }
        }

        override fun deSerializeFMUstate(instanceId: String, state: ByteArray): Pair<FmuState, FmiStatus> {
            throw UnsupportedOperationException("Not implemented yet!")
//            return client.deSerializeFMUstate(instanceId, ByteBuffer.wrap(state)).let {
//                it.state to it.status.convert()
//            }
        }

        override fun freeFMUstate(instanceId: String, state: FmuState): FmiStatus {
            throw UnsupportedOperationException("Not implemented yet!")
//            return client.freeFMUstate(instanceId, state).convert()

        }

        override fun getFMUstate(instanceId: String): Pair<FmuState, FmiStatus> {
            throw UnsupportedOperationException("Not implemented yet!")
//            return client.getFMUstate(instanceId).let {
//                it.state to it.status.convert()
//            }
        }

        override fun serializeFMUstate(instanceId: String, state: FmuState): Pair<ByteArray, FmiStatus> {
            throw UnsupportedOperationException("Not implemented yet!")
//            return client.serializeFMUstate(instanceId, state).let {
//                it.state.array() to it.status.convert()
//            }
        }

        override fun setFMUstate(instanceId: String, state: FmuState): FmiStatus {
            throw UnsupportedOperationException("Not implemented yet!")
//            return client.setFMUstate(instanceId, state).convert()
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

