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

package no.mechatronics.sfi.fmuproxy.grpc

import com.google.protobuf.ByteString
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationAttributes
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.InstanceId
import no.mechatronics.sfi.fmuproxy.Solver

/**
 * @author Lars Ivar Hatledal
 */
class GrpcFmuClient(
        fmuId: String,
        host: String,
        port: Int
) : AbstractRpcFmuClient(fmuId) {

    private val channel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .directExecutor()
            .build()

    private val blockingStub: FmuServiceGrpc.FmuServiceBlockingStub = FmuServiceGrpc.newBlockingStub(channel)

    override val modelDescription: ModelDescription by lazy {
        Service.GetModelDescriptionRequest.newBuilder()
                .setFmuId(fmuId)
                .build().let {
                    blockingStub.getModelDescription(it).convert()
                }
    }

    override val canCreateInstanceFromCS: Boolean by lazy {
        Service.CanCreateInstanceFromCSRequest.newBuilder()
                .setFmuId(fmuId)
                .build().let {
                    blockingStub.canCreateInstanceFromCS(it).value
                }

    }

    override val canCreateInstanceFromME: Boolean by lazy {
        Service.CanCreateInstanceFromMERequest.newBuilder()
                .setFmuId(fmuId)
                .build().let {
                    blockingStub.canCreateInstanceFromME(it).value
                }
    }

    override fun createInstanceFromCS(): String {
        return Service.CreateInstanceFromCSRequest.newBuilder()
                .setFmuId(fmuId)
                .build().let {
                    blockingStub.createInstanceFromCS(it).value
                }
    }

    override fun createInstanceFromME(solver: Solver): String {
        return Service.CreateInstanceFromMERequest.newBuilder()
                .setFmuId(fmuId)
                .setSolver(solver.protoType())
                .build().let {
                    blockingStub.createInstanceFromME(it).value
                }
    }

    override fun getCoSimulationAttributes(instanceId: String): CoSimulationAttributes {
        return Service.GetCoSimulationAttributesRequest.newBuilder()
                .setInstanceId(instanceId)
                .build().let {
                    blockingStub.getCoSimulationAttributes(it).convert()
                }
    }

    override fun init(instanceId: String, start: Double, stop: Double): FmiStatus {
        return Service.InitRequest.newBuilder()
                .setInstanceId(instanceId)
                .setStart(start)
                .setStop(stop)
                .build().let {
                    blockingStub.init(it).convert()
                }
    }

    override fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus> {
        return Service.StepRequest.newBuilder()
                .setInstanceId(instanceId)
                .setStepSize(stepSize)
                .build().let {
                    blockingStub.step(it).let {
                        it.simulationTime to it.status.convert()
                    }
                }
    }

    override fun reset(instanceId: String): FmiStatus {
        return Service.ResetRequest.newBuilder()
                .setInstanceId(instanceId)
                .build().let {
                    blockingStub.reset(it).status.convert()
                }
    }

    override fun terminate(instanceId: String): FmiStatus {
        return Service.TerminateRequest.newBuilder().setInstanceId(instanceId).build().let {
            blockingStub.terminate(it).status.convert()
        }
    }

    override fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead {
        return blockingStub.readInteger(getReadRequest(instanceId, vr)).convert()
    }

    override fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead {
        return blockingStub.readReal(getReadRequest(instanceId, vr)).convert()
    }

    override fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead {
        return blockingStub.readString(getReadRequest(instanceId, vr)).convert()
    }

    override fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead {
        return blockingStub.readBoolean(getReadRequest(instanceId, vr)).convert()
    }

    override fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus {
        return Service.WriteIntegerRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let { request ->
                    blockingStub.writeInteger(request).convert()
                }
    }


    override fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus {
        return Service.WriteRealRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let { request ->
                    blockingStub.writeReal(request).convert()
                }
    }

    override fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus {
        return Service.WriteStringRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let { request ->
                    blockingStub.writeString(request).convert()
                }
    }

    override fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus {
        return Service.WriteBooleanRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let { request ->
                    blockingStub.writeBoolean(request).convert()
                }
    }

    override fun deSerializeFMUstate(instanceId: String, state: ByteArray): Pair<FmuState, FmiStatus> {
        return Service.DeSerializeFMUstateRequest.newBuilder()
                .setInstanceId(instanceId)
                .setState(ByteString.copyFrom(state))
                .build().let { request ->
                    blockingStub.deSerializeFMUstate(request).let { response ->
                        response.state to response.status.convert()
                    }
                }
    }

    override fun freeFMUstate(instanceId: String, state: FmuState): FmiStatus {
        return Service.FreeFMUstateRequest.newBuilder()
                .setInstanceId(instanceId)
                .setState(state)
                .build().let { request ->
                    blockingStub.freeFMUstate(request).convert()
                }
    }

    override fun getFMUstate(instanceId: String): Pair<FmuState, FmiStatus> {
        return Service.GetFMUstateRequest.newBuilder()
                .setInstanceId(instanceId)
                .build().let {request ->
                    blockingStub.getFMUstate(request).let { response ->
                        response.state to response.status.convert()
                    }
                }
    }

    override fun serializeFMUstate(instanceId: String, state: FmuState): Pair<ByteArray, FmiStatus> {
        return Service.SerializeFMUstateRequest.newBuilder()
                .setInstanceId(instanceId)
                .setState(state)
                .build().let { request ->
                    blockingStub.serializeFMUstate(request).let { response ->
                        response.state.toByteArray() to response.status.convert()
                    }
                }
    }

    override fun setFMUstate(instanceId: String, state: FmuState): FmiStatus {
        return Service.SetFMUstateRequest.newBuilder()
                .setInstanceId(instanceId)
                .setState(state)
                .build().let { request ->
                    blockingStub.setFMUstate(request).convert()
                }
    }

    override fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): Pair<List<Double>, FmiStatus> {
        return Service.GetDirectionalDerivativeRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllVUnknownRef(vUnknownRef)
                .addAllVKnownRef(vKnownRef)
                .addAllDvKnownRef(dvKnownRef).build().let { request ->
                    blockingStub.getDirectionalDerivative(request).let { response ->
                        response.dvKnownRefList.toList() to response.status.convert()
                    }
                }


    }

    override fun close() {
        super.close()
        channel.shutdownNow()
    }


    private companion object {

        private fun getReadRequest(instanceId: String, vr: List<ValueReference>): Service.ReadRequest {
            return Service.ReadRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .build()
        }

    }

}
