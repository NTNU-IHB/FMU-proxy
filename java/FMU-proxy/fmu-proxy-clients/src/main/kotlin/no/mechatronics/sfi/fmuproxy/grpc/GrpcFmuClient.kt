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


import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * @author Lars Ivar Hatledal
 */
class GrpcFmuClient(
        host: String,
        port: Int
): AbstractRpcFmuClient() {

    private val channel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .directExecutor()
            .build()

    private val blockingStub: FmuServiceGrpc.FmuServiceBlockingStub
            = FmuServiceGrpc.newBlockingStub(channel)

    override val modelDescription: CommonModelDescription by lazy {
        blockingStub.getModelDescription(VOID).convert()
    }

    override val modelDescriptionXml: String by lazy {
        blockingStub.getModelDescriptionXml(VOID).value
    }
    
    override fun getSimulationTime(instanceId: Int): Double {
        return blockingStub.getSimulationTime(instanceId.asProtoUInt()).value
    }

    override fun isTerminated(instanceId: Int): Boolean {
        return blockingStub.isTerminated(instanceId.asProtoUInt()).value
    }

    override fun init(instanceId: Int, start: Double, stop: Double): FmiStatus {
        return Proto.InitRequest.newBuilder()
                .setInstanceId(instanceId)
                .setStart(start)
                .setStop(stop)
                .build().let {
                    blockingStub.init(it).convert()
                }
    }

    override fun step(instanceId: Int, stepSize: Double): Pair<Double, FmiStatus> {
        return Proto.StepRequest.newBuilder()
                .setInstanceId(instanceId)
                .setStepSize(stepSize)
                .build().let {
                    blockingStub.step(it).let { 
                        it.simulationTime to it.status.convert()
                    }
                }
    }

    override fun reset(instanceId: Int): FmiStatus {
        return blockingStub.reset(instanceId.asProtoUInt()).convert()
    }

    override fun terminate(instanceId: Int): FmiStatus {
        return blockingStub.terminate(instanceId.asProtoUInt()).convert()
    }


    override fun readInteger(instanceId: Int, vr: List<Int>): FmuIntegerArrayRead {
        return blockingStub.readInteger(getReadRequest(instanceId, vr)).convert()
    }


    override fun readReal(instanceId: Int, vr: List<Int>): FmuRealArrayRead {
        return blockingStub.readReal(getReadRequest(instanceId, vr)).convert()
    }

    override fun readString(instanceId: Int, vr: List<Int>): FmuStringArrayRead {
        return blockingStub.readString(getReadRequest(instanceId, vr)).convert()
    }

    override fun readBoolean(instanceId: Int, vr: List<Int>): FmuBooleanArrayRead {
        return blockingStub.readBoolean(getReadRequest(instanceId, vr)).convert()
    }
    
    override fun writeInteger(instanceId: Int, vr: List<Int>, value: List<Int>): FmiStatus {
        return Proto.WriteIntegerRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.writeInteger(it).convert()
                }
    }
    

    override fun writeReal(instanceId: Int, vr: List<Int>, value: List<Real>): FmiStatus {
        return Proto.WriteRealRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.writeReal(it).convert()
                }
    }
    
    override fun writeString(instanceId: Int, vr: List<Int>, value: List<String>): FmiStatus {
        return Proto.WriteStringRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.writeString(it).convert()
                }
    }
    
    override fun writeBoolean(instanceId: Int, vr: List<Int>, value: List<Boolean>): FmiStatus {
        return Proto.WriteBooleanRequest.newBuilder()
                .setInstanceId(instanceId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.writeBoolean(it).convert()
                }
    }

    override fun createInstanceFromCS(): Int {
        return blockingStub.createInstanceFromCS(VOID).value
    }

    override fun createInstanceFromME(solver: Solver): Int {
        return blockingStub.createInstanceFromME(solver.protoType()).value
    }

    override fun close() {
        super.close()
        channel.shutdownNow()
    }


    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(GrpcFmuClient::class.java)

        private val VOID = Proto.Void.getDefaultInstance()

        private fun getReadRequest(instanceId: Int, vr: List<Int>): Proto.ReadRequest {
            return Proto.ReadRequest.newBuilder()
                    .setInstanceId(instanceId)
                    .addAllValueReferences(vr)
                    .build()
        }

    }

}
