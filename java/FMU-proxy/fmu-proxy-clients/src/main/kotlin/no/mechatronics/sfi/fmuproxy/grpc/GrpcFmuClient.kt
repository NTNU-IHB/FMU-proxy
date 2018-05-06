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
import no.mechatronics.sfi.fmuproxy.IntegratorSettings
import no.mechatronics.sfi.fmuproxy.RpcFmuClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable

private val EMPTY = Empty.getDefaultInstance()

/**
 * @author Lars Ivar Hatledal
 */
internal object FmuInstances: ArrayList<GrpcFmuClient.FmuInstance>() {
    internal fun terminateAll() {
        forEach{ it.terminate() }
    }
}

/**
 * @author Lars Ivar Hatledal
 */
class GrpcFmuClient(
        host: String,
        port: Int
): RpcFmuClient() {

    private val channel: ManagedChannel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .directExecutor()
            .build()

    val blockingStub: FmuServiceGrpc.FmuServiceBlockingStub
            = FmuServiceGrpc.newBlockingStub(channel)

    val modelDescription: Proto.ModelDescription by lazy {
        blockingStub.getModelDescription(EMPTY)
    }

    override val modelDescriptionXml: String by lazy {
        blockingStub.getModelDescriptionXml(EMPTY).value
    }

    override fun getCurrentTime(fmuId: Int): Double {
        return blockingStub.getCurrentTime(fmuId.asProtoUInt()).value
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

    override fun step(fmuId: Int, stepSize: Double): FmiStatus {
        return Proto.StepRequest.newBuilder()
                .setFmuId(fmuId)
                .setStepSize(stepSize)
                .build().let {
                    blockingStub.step(it).convert()
                }
    }

    override fun reset(fmuId: Int): FmiStatus {
        return blockingStub.reset(fmuId.asProtoUInt()).convert()
    }

    override fun terminate(fmuId: Int): FmiStatus {
        return blockingStub.terminate(fmuId.asProtoUInt()).convert()
    }


    override fun readInteger(fmuId: Int, name: String): FmuIntegerRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readReal(fmuId: Int, name: String): FmuRealRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readString(fmuId: Int, name: String): FmuStringRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readBoolean(fmuId: Int, name: String): FmuBooleanRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInstanceFromCS(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInstanceFromME(integrator: IntegratorSettings): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @JvmOverloads
    fun createInstance(integrator: Proto.Integrator? = null): FmuInstance {

        val fmuId = if (integrator == null) {
            blockingStub.createInstanceFromCS(EMPTY).value
        } else {
            blockingStub.createInstanceFromME(integrator).value
        }
        return FmuInstance(fmuId).also {
            FmuInstances.add(it)
        }

    }

    override fun close() {
        LOG.debug("Closing..")
        FmuInstances.terminateAll()
        channel.shutdownNow()
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuClient::class.java)
    }


    inner class FmuInstance internal constructor(
            private val fmuId: Int
    ) : Closeable {

        private val modelRef = Proto.UInt.newBuilder()
                .setValue(fmuId).build()

        val currentTime: Double
            get() = blockingStub.getCurrentTime(modelRef).value

        @JvmOverloads
        fun init(start: Double = 0.0, stop: Double = -1.0): Proto.Status {
            return blockingStub.init(
                    Proto.InitRequest.newBuilder()
                            .setFmuId(fmuId)
                            .setStart(start)
                            .setStop(stop)
                            .build())
        }

        fun step(stepSize: Double): Proto.Status = blockingStub.step(Proto.StepRequest.newBuilder()
                .setFmuId(fmuId)
                .setStepSize(stepSize)
                .build())

        fun terminate(): Proto.Status {
            return try {
                blockingStub.terminate(modelRef)
            } finally {
                FmuInstances.remove(this)
            }
        }

        override fun close() {
            terminate()
        }

        fun reset(): Proto.Status {
            return blockingStub.reset(modelRef)
        }

        fun getValueReference(variableName: String)
                = modelDescription.modelVariablesList
                .firstOrNull { it.name == variableName }?.valueReference
                ?: throw IllegalArgumentException("No variable with that name: $variableName")

        fun read(valueReference: Int) = SingleRead(valueReference)
        fun read(valueReferences: IntArray) = BulkRead(valueReferences)

        fun read(variableName: String) = SingleRead(variableName)
        fun read(variableNames: Array<String>) = BulkRead(variableNames)

        fun write(valueReference: Int) = SingleWrite(valueReference)
        fun write(valueReferences: IntArray) = BulkRead(valueReferences)

        inner class SingleRead(
                private val valueReference: Int
        ) {

            constructor(variableName: String): this(getValueReference(variableName))

            fun asInt(): Proto.IntRead {
                return blockingStub.readInteger(Proto.ReadRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .build())
            }

            fun asReal(): Proto.RealRead {
                return blockingStub.readReal(Proto.ReadRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .build())
            }

            fun asString(): Proto.StrRead {
                return blockingStub.readString(Proto.ReadRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .build())
            }

            fun asBoolean(): Proto.BoolRead {
                return blockingStub.readBoolean(Proto.ReadRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .build())
            }

        }

        inner class BulkRead(
                private val valueReferences: IntArray
        ) {

            constructor(variableNames: Array<String>) : this(variableNames.map { getValueReference(it) }.toIntArray())


            fun readInt(): List<Int> {
                val builder = Proto.BulkReadRequest.newBuilder().setFmuId(fmuId)
                valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
                return blockingStub.bulkReadInteger(builder.build()).valuesList
            }

            fun readReal(): List<Double> {
                val builder = Proto.BulkReadRequest.newBuilder().setFmuId(fmuId)
                valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
                return blockingStub.bulkReadReal(builder.build()).valuesList
            }
            fun readString(): List<String> {
                val builder = Proto.BulkReadRequest.newBuilder().setFmuId(fmuId)
                valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
                return blockingStub.bulkReadString(builder.build()).valuesList
            }

            fun readBoolean(): List<Boolean> {
                val builder = Proto.BulkReadRequest.newBuilder().setFmuId(fmuId)
                valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
                return blockingStub.bulkReadBoolean(builder.build()).valuesList
            }

        }

        inner class SingleWrite(
                private val valueReference: Int
        ) {

            fun with(value: Int): Proto.Status {
                return blockingStub.writeInteger(Proto.WriteIntRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .setValue(value)
                        .build())
            }

            fun with(value: Double): Proto.Status {
                return blockingStub.writeReal(Proto.WriteRealRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .setValue(value)
                        .build())
            }

            fun with(value: String): Proto.Status {
                return blockingStub.writeString(Proto.WriteStrRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .setValue(value)
                        .build())
            }

            fun with(value: Boolean): Proto.Status {
                return blockingStub.writeBoolean(Proto.WriteBoolRequest.newBuilder()
                        .setFmuId(fmuId)
                        .setValueReference(valueReference)
                        .setValue(value)
                        .build())
            }

        }

        inner class BulkWrite(
                private val valueReferences: IntArray
        ) {
            constructor(variableNames: Array<String>) : this(variableNames.map { getValueReference(it) }.toIntArray())

            fun with(values: IntArray): Proto.Status {
                val builder = Proto.BulkWriteIntRequest.newBuilder().setFmuId(fmuId)
                values.forEachIndexed{i,v -> builder.setValues(i, v)}
                valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
                return blockingStub.bulkWriteInteger(builder.build())
            }

            fun with(values: DoubleArray): Proto.Status {
                val builder = Proto.BulkWriteRealRequest.newBuilder().setFmuId(fmuId)
                values.forEachIndexed{i,v -> builder.setValues(i, v)}
                valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
                return blockingStub.bulkWriteReal(builder.build())
            }

            fun with(values: Array<String>): Proto.Status {
                val builder = Proto.BulkWriteStrRequest.newBuilder().setFmuId(fmuId)
                values.forEachIndexed{i,v -> builder.setValues(i, v)}
                valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
                return blockingStub.bulkWriteString(builder.build())
            }

            fun with(values: BooleanArray): Proto.Status {
                val builder = Proto.BulkWriteBoolRequest.newBuilder().setFmuId(fmuId)
                values.forEachIndexed{i,v -> builder.setValues(i, v)}
                valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
                return blockingStub.bulkWriteBoolean(builder.build())
            }

        }

    }


}


