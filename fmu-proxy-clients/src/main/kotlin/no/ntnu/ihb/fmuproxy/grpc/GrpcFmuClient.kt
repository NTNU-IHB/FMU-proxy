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
import no.ntnu.ihb.fmi4j.*
import no.ntnu.ihb.fmi4j.modeldescription.*
import no.ntnu.ihb.fmuproxy.AbstractRpcFmuClient
import no.ntnu.ihb.fmuproxy.DirectionalDerivativeResult
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.StepResult
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

        override val modelDescription: CoSimulationModelDescription by lazy {
            Service.GetModelDescriptionRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build().let {
                        stub.getModelDescription(it).convert()
                    }
        }

        override fun createInstance(): String {
            return Service.CreateInstanceRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build().let {
                        stub.createInstance(it).value
                    }
        }

        override fun setupExperiment(instanceName: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus {
            return Service.SetupExperimentRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .setStart(start)
                    .setStop(stop)
                    .setTolerance(tolerance)
                    .build().let {
                        stub.setupExperiment(it).convert()
                    }
        }

        override fun enterInitializationMode(instanceName: InstanceId): FmiStatus {
            return Service.EnterInitializationModeRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .build().let {
                        stub.enterInitializationMode(it).convert()
                    }
        }

        override fun exitInitializationMode(instanceName: InstanceId): FmiStatus {
            return Service.ExitInitializationModeRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .build().let {
                        stub.exitInitializationMode(it).convert()
                    }
        }

        override fun step(instanceName: String, stepSize: Double): StepResult {
            return Service.StepRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .setStepSize(stepSize)
                    .build().let { req ->
                        stub.step(req).let { response ->
                            StepResult(response.simulationTime, response.status.convert())
                        }
                    }
        }

        override fun reset(instanceName: String): FmiStatus {
            return Service.ResetRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .build().let {
                        stub.reset(it).status.convert()
                    }
        }

        override fun terminate(instanceName: String): FmiStatus {
            return Service.TerminateRequest.newBuilder().setInstanceId(instanceName).build().let {
                stub.terminate(it).status.convert()
            }
        }

        override fun freeInstance(instanceName: InstanceId) {
            return Service.FreeRequest.newBuilder().setInstanceId(instanceName).build().let {
                stub.freeInstance(it)
            }
        }

        override fun readInteger(instanceName: String, vr: List<ValueReference>): IntegerArrayRead {
            return stub.readInteger(getReadRequest(instanceName, vr)).convert()
        }

        override fun readReal(instanceName: String, vr: List<ValueReference>): RealArrayRead {
            return stub.readReal(getReadRequest(instanceName, vr)).convert()
        }

        override fun readString(instanceName: String, vr: List<ValueReference>): StringArrayRead {
            return stub.readString(getReadRequest(instanceName, vr)).convert()
        }

        override fun readBoolean(instanceName: String, vr: List<ValueReference>): BooleanArrayRead {
            return stub.readBoolean(getReadRequest(instanceName, vr)).convert()
        }

        override fun writeInteger(instanceName: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
            return Service.WriteIntegerRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeInteger(request).convert()
                    }
        }


        override fun writeReal(instanceName: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
            return Service.WriteRealRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeReal(request).convert()
                    }
        }

        override fun writeString(instanceName: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
            return Service.WriteStringRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeString(request).convert()
                    }
        }

        override fun writeBoolean(instanceName: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
            return Service.WriteBooleanRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .addAllValueReferences(vr)
                    .addAllValues(value)
                    .build().let { request ->
                        stub.writeBoolean(request).convert()
                    }
        }

        override fun getDirectionalDerivative(instanceName: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): DirectionalDerivativeResult {
            return Service.GetDirectionalDerivativeRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .addAllVUnknownRef(vUnknownRef)
                    .addAllVKnownRef(vKnownRef)
                    .addAllDvKnownRef(dvKnownRef).build().let { request ->
                        stub.getDirectionalDerivative(request).let { response ->
                            DirectionalDerivativeResult(response.dvUnknownRefList.toDoubleArray(), response.status.convert())
                        }
                    }
        }

    }

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuClient::class.java)

        private fun getReadRequest(instanceName: String, vr: List<ValueReference>): Service.ReadRequest {
            return Service.ReadRequest.newBuilder()
                    .setInstanceId(instanceName)
                    .addAllValueReferences(vr)
                    .build()
        }

    }

}
