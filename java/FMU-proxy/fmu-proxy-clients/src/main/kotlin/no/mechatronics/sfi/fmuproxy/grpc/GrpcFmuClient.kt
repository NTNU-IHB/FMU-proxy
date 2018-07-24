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


import com.google.protobuf.Empty
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.AbstractRpcFmuClient
import no.mechatronics.sfi.fmuproxy.Solver
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val EMPTY = Empty.getDefaultInstance()


/**
 * @author Lars Ivar Hatledal
 */
class GrpcFmuClient(
        host: String,
        port: Int
): AbstractRpcFmuClient() {

    private val channel: ManagedChannel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .directExecutor()
            .build()

    private val blockingStub: FmuServiceGrpc.FmuServiceBlockingStub = FmuServiceGrpc.newBlockingStub(channel)

    override val modelDescription: CommonModelDescription by lazy {
        blockingStub.getModelDescription(EMPTY).convert()
    }

    override val modelDescriptionXml: String by lazy {
        blockingStub.getModelDescriptionXml(EMPTY).value
    }
    
    override fun getCurrentTime(fmuId: Int): Double {
        return blockingStub.getSimulationTime(fmuId.asProtoUInt()).value
    }

    override fun isTerminated(fmuId: Int): Boolean {
        return blockingStub.isTerminated(fmuId.asProtoUInt()).value
    }

    override fun init(fmuId: Int, start: Double, stop: Double): FmiStatus {
        return Proto.InitRequest.newBuilder()
                .setFmuId(fmuId)
                .setStart(start)
                .setStop(stop)
                .build().let {
                    blockingStub.init(it).convert()
                }
    }

    override fun step(fmuId: Int, stepSize: Double): Pair<Double, FmiStatus> {
        return Proto.StepRequest.newBuilder()
                .setFmuId(fmuId)
                .setStepSize(stepSize)
                .build().let {
                    blockingStub.step(it).let { 
                        it.simulationTime to it.status.convert()
                    }
                }
    }

    override fun reset(fmuId: Int): FmiStatus {
        return blockingStub.reset(fmuId.asProtoUInt()).convert()
    }

    override fun terminate(fmuId: Int): FmiStatus {
        return blockingStub.terminate(fmuId.asProtoUInt()).convert()
    }

    override fun readInteger(fmuId: Int, vr: Int): FmuIntegerRead {
        return blockingStub.readInteger(getReadRequest(fmuId, vr)).convert()
    }

    override fun bulkReadInteger(fmuId: Int, vr: List<Int>): FmuIntegerArrayRead {
        return blockingStub.bulkReadInteger(getReadRequest(fmuId, vr)).convert()
    }

    override fun readReal(fmuId: Int, vr: Int): FmuRealRead {
        return blockingStub.readReal(getReadRequest(fmuId, vr)).convert()
    }

    override fun bulkReadReal(fmuId: Int, vr: List<Int>): FmuRealArrayRead {
        return blockingStub.bulkReadReal(getReadRequest(fmuId, vr)).convert()
    }

    override fun readString(fmuId: Int, vr: Int): FmuStringRead {
        return blockingStub.readString(getReadRequest(fmuId, vr)).convert()
    }

    override fun bulkReadString(fmuId: Int, vr: List<Int>): FmuStringArrayRead {
        return blockingStub.bulkReadString(getReadRequest(fmuId, vr)).convert()
    }

    override fun readBoolean(fmuId: Int, vr: Int): FmuBooleanRead {
        return blockingStub.readBoolean(getReadRequest(fmuId, vr)).convert()
    }

    override fun bulkReadBoolean(fmuId: Int, vr: List<Int>): FmuBooleanArrayRead {
        return blockingStub.bulkReadBoolean(getReadRequest(fmuId, vr)).convert()
    }

    override fun writeInteger(fmuId: Int, vr: ValueReference, value: Int): FmiStatus {
        return Proto.WriteIntegerRequest.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(vr)
                .setValue(value)
                .build().let {
                    blockingStub.writeInteger(it).convert()
                }
    }

    override fun bulkWriteInteger(fmuId: Int, vr: List<Int>, value: List<Int>): FmiStatus {
        return Proto.BulkWriteIntegerRequest.newBuilder()
                .setFmuId(fmuId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.bulkWriteInteger(it).convert()
                }
    }

    override fun writeReal(fmuId: Int, vr: ValueReference, value: Real): FmiStatus {
        return Proto.WriteRealRequest.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(vr)
                .setValue(value)
                .build().let {
                    blockingStub.writeReal(it).convert()
                }
    }

    override fun bulkWriteReal(fmuId: Int, vr: List<Int>, value: List<Real>): FmiStatus {
        return Proto.BulkWriteRealRequest.newBuilder()
                .setFmuId(fmuId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.bulkWriteReal(it).convert()
                }
    }

    override fun writeString(fmuId: Int, vr: ValueReference, value: String): FmiStatus {
        return Proto.WriteStringRequest.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(vr)
                .setValue(value)
                .build().let {
                    blockingStub.writeString(it).convert()
                }
    }

    override fun bulkWriteString(fmuId: Int, vr: List<Int>, value: List<String>): FmiStatus {
        return Proto.BulkWriteStringRequest.newBuilder()
                .setFmuId(fmuId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.bulkWriteString(it).convert()
                }
    }

    override fun writeBoolean(fmuId: Int, vr: ValueReference, value: Boolean): FmiStatus {
        return Proto.WriteBooleanRequest.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(vr)
                .setValue(value)
                .build().let {
                    blockingStub.writeBoolean(it).convert()
                }
    }

    override fun bulkWriteBoolean(fmuId: Int, vr: List<Int>, value: List<Boolean>): FmiStatus {
        return Proto.BulkWriteBooleanRequest.newBuilder()
                .setFmuId(fmuId)
                .addAllValueReferences(vr)
                .addAllValues(value)
                .build().let {
                    blockingStub.bulkWriteBoolean(it).convert()
                }
    }

    override fun createInstanceFromCS(): Int {
        return blockingStub.createInstanceFromCS(EMPTY).value
    }

    override fun createInstanceFromME(solver: Solver): Int {
        return blockingStub.createInstanceFromME(solver.protoType()).value
    }

    override fun close() {
        super.close()
        channel.shutdownNow()
    }


    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuClient::class.java)

        private fun getReadRequest(fmuId: Int, vr: Int): Proto.ReadRequest {
            return Proto.ReadRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(vr)
                    .build()
        }

        private fun getReadRequest(fmuId: Int, vr: List<Int>): Proto.BulkReadRequest {
            return Proto.BulkReadRequest.newBuilder()
                    .setFmuId(fmuId)
                    .addAllValueReferences(vr)
                    .build()
        }

    }

}
