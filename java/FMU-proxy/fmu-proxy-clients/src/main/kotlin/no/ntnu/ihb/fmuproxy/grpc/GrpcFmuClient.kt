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

package no.ntnu.ihb.fmuproxy.grpc

import com.google.protobuf.ByteString
import io.grpc.ManagedChannelBuilder
import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.modeldescription.*
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.Solver
import no.ntnu.ihb.fmuproxy.jsonrpc.StepResult
import no.ntnu.ihb.fmuproxy.thrift.DirectionalDerivativeResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.File
import java.io.FileInputStream
import java.net.URL
import java.util.concurrent.TimeUnit

/**
 * @author Lars Ivar Hatledal
 */
class GrpcFmuClient(
        host: String,
        port: Int
) : Closeable {

    private val channel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .build()

    private val stub = FmuServiceGrpc.newBlockingStub(channel)

    fun load(fmuId: String): AbstractRpcFmuClient {
        return GrpcFmu(fmuId);
    }

    fun load(url: URL): AbstractRpcFmuClient {
        return Service.Url.newBuilder()
                .setUrl(url.toString())
                .build().let {
                    load(stub.loadFromUrl(it).value)
                }
    }

    fun load(file: File): AbstractRpcFmuClient {
        if (!file.name.endsWith(".fmu")) {
            throw IllegalArgumentException("File must be an FMU!")
        }
        val data = FileInputStream(file).use {
            ByteString.copyFrom(it.readBytes())
        }
        return Service.File.newBuilder()
                .setName(file.nameWithoutExtension)
                .setData(data)
                .build().let {
                    load(stub.loadFromFile(it).value)
                }
    }

    override fun close() {
        channel.shutdownNow()
        channel.awaitTermination(500, TimeUnit.MILLISECONDS)
    }

    private inner class GrpcFmu(
            fmuId: String
    ) : AbstractRpcFmuClient(fmuId) {

        override val implementationName: String = "GrpcClient"

        override val modelDescription: ModelDescription by lazy {
            Service.GetModelDescriptionRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build().let {
                        stub.getModelDescription(it).convert()
                    }
        }

        override val canCreateInstanceFromCS: Boolean by lazy {
            Service.CanCreateInstanceFromCSRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build().let {
                        stub.canCreateInstanceFromCS(it).value
                    }

        }

        override val canCreateInstanceFromME: Boolean by lazy {
            Service.CanCreateInstanceFromMERequest.newBuilder()
                    .setFmuId(fmuId)
                    .build().let {
                        stub.canCreateInstanceFromME(it).value
                    }
        }

        override fun createInstanceFromCS(): String {
            return Service.CreateInstanceFromCSRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build().let {
                        stub.createInstanceFromCS(it).value
                    }
        }

        override fun createInstanceFromME(solver: Solver): String {
            return Service.CreateInstanceFromMERequest.newBuilder()
                    .setFmuId(fmuId)
                    .setSolver(solver.protoType())
                    .build().let {
                        stub.createInstanceFromME(it).value
                    }
        }

        override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
            return Service.GetCoSimulationAttributesRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .build().let {
                        stub.getCoSimulationAttributes(it).convert()
                    }
        }

        override fun setup(instanceId: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus {
            return Service.SetupExperimentRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .setStart(start)
                    .setStop(stop)
                    .setTolerance(tolerance)
                    .build().let {
                        stub.setupExperiment(it).convert()
                    }
        }

        override fun enterInitializationMode(instanceId: InstanceId): FmiStatus {
            return Service.EnterInitializationModeRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .build().let {
                        stub.enterInitializationMode(it).convert()
                    }
        }

        override fun exitInitializationMode(instanceId: InstanceId): FmiStatus {
            return Service.ExitInitializationModeRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .build().let {
                        stub.exitInitializationMode(it).convert()
                    }
        }

        override fun step(instanceId: String, stepSize: Double): StepResult {
            return Service.StepRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .setStepSize(stepSize)
                    .build().let {
                        stub.step(it).let {
                            StepResult(it.simulationTime, it.status.convert())
                        }
                    }
        }

        override fun reset(instanceId: String): FmiStatus {
            return Service.ResetRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .build().let {
                        stub.reset(it).status.convert()
                    }
        }

        override fun terminate(instanceId: String): FmiStatus {
            return Service.TerminateRequest.newBuilder().setInstanceId(instanceId).build().let {
                stub.terminate(it).status.convert()
            }
        }

        override fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead {
            return stub.readInteger(getReadRequest(instanceId, vr)).convert()
        }

        override fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead {
            return stub.readReal(getReadRequest(instanceId, vr)).convert()
        }

        override fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead {
            return stub.readString(getReadRequest(instanceId, vr)).convert()
        }

        override fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead {
            return stub.readBoolean(getReadRequest(instanceId, vr)).convert()
        }

        override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
            return Service.WriteIntegerRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeInteger(request).convert()
                    }
        }


        override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
            return Service.WriteRealRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeReal(request).convert()
                    }
        }

        override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
            return Service.WriteStringRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeString(request).convert()
                    }
        }

        override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
            return Service.WriteBooleanRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeBoolean(request).convert()
                    }
        }

        override fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): no.ntnu.ihb.fmuproxy.jsonrpc.DirectionalDerivativeResult {
            return Service.GetDirectionalDerivativeRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllVUnknownRef(vUnknownRef)
                    .addAllVKnownRef(vKnownRef)
                    .addAllDvKnownRef(dvKnownRef).build().let { request ->
                        stub.getDirectionalDerivative(request).let { response ->
                            no.ntnu.ihb.fmuproxy.jsonrpc.DirectionalDerivativeResult(response.dvUnknownRefList.toDoubleArray(), response.status.convert())
                        }
                    }


        }

        override fun close() {
            super.close()
            LOG.debug("$implementationName closed..")
        }

    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuClient::class.java)

        private fun getReadRequest(instanceId: String, vr: List<ValueReference>): Service.ReadRequest {
            return Service.ReadRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .build()
        }

    }

}
