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

package no.mechatronics.sfi.fmu_proxy.grpc

import java.io.Closeable

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder


import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val EMPTY = FmiDefinitions.Empty.getDefaultInstance()

/**
 * @author Lars Ivar Hatledal
 */
internal object FmuInstances: ArrayList<FmuInstance>() {
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
): Closeable {

    private val channel: ManagedChannel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext(true)
            .directExecutor()
            .build()

    private val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
            = GenericFmuServiceGrpc.newBlockingStub(channel)

    val guid: String by lazy {
        blockingStub.getGuid(FmiDefinitions.Empty.getDefaultInstance()).value
    }

    val modelName: String by lazy {
        blockingStub.getModelName(FmiDefinitions.Empty.getDefaultInstance()).value
    }

    val modelStructure: FmiDefinitions.ModelStructure by lazy {
        blockingStub.getModelStructure(EMPTY)
    }

    @JvmOverloads
    fun createInstance(integrator: FmiDefinitions.Integrator? = null): FmuInstance {

        val fmuId = if (integrator == null) {
            blockingStub.createInstanceFromCS(EMPTY).value
        } else {
            blockingStub.createInstanceFromME(integrator).value
        }
        return FmuInstance(blockingStub, fmuId).also {
            FmuInstances.add(it)
        }

    }

    fun stop() = close()

    override fun close() {
        LOG.debug("Closing..")
        FmuInstances.terminateAll()
        channel.shutdownNow()
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuClient::class.java)
    }

}

class FmuInstance internal constructor(
        private val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub,
        private val fmuId: Int
) : Closeable {

    private val modelRef = FmiDefinitions.UInt.newBuilder().setValue(fmuId).build()

    val modelVariables: List<FmiDefinitions.ScalarVariable> by lazy {
        mutableListOf<FmiDefinitions.ScalarVariable>().apply {
            blockingStub.getModelVariables(EMPTY).forEach {add(it)}
        }
    }

    val currentTime: Double
        get() = blockingStub.getCurrentTime(modelRef).value

    fun init(): Boolean = blockingStub.init(FmiDefinitions.InitRequest.newBuilder()
            .setFmuId(fmuId)
            .build()).value

    fun step(stepSize: Double): FmiDefinitions.Status = blockingStub.step(FmiDefinitions.StepRequest.newBuilder()
            .setFmuId(fmuId)
            .setStepSize(stepSize)
            .build())

    fun terminate() {
        try {
            blockingStub.terminate(FmiDefinitions.UInt.newBuilder()
                    .setValue(fmuId)
                    .build())
        } finally {
            FmuInstances.remove(this)
        }
    }

    override fun close() = terminate()

    fun getValueReference(variableName: String)
            = modelVariables.firstOrNull { it.name == variableName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $variableName")

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

        fun asInt(): FmiDefinitions.IntRead {
            return blockingStub.readInteger(FmiDefinitions.ReadRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(valueReference)
                    .build())
        }

        fun asReal(): FmiDefinitions.RealRead {
            return blockingStub.readReal(FmiDefinitions.ReadRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(valueReference)
                    .build())
        }

        fun asString(): FmiDefinitions.StrRead {
            return blockingStub.readString(FmiDefinitions.ReadRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(valueReference)
                    .build())
        }

        fun asBoolean(): FmiDefinitions.BoolRead {
            return blockingStub.readBoolean(FmiDefinitions.ReadRequest.newBuilder()
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
            val builder = FmiDefinitions.BulkReadRequest.newBuilder().setFmuId(fmuId)
            valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
            return blockingStub.bulkReadInteger(builder.build()).valuesList
        }

        fun readReal(): List<Double> {
            val builder = FmiDefinitions.BulkReadRequest.newBuilder().setFmuId(fmuId)
            valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
            return blockingStub.bulkReadReal(builder.build()).valuesList
        }
        fun readString(): List<String> {
            val builder = FmiDefinitions.BulkReadRequest.newBuilder().setFmuId(fmuId)
            valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
            return blockingStub.bulkReadString(builder.build()).valuesList
        }

        fun readBoolean(): List<Boolean> {
            val builder = FmiDefinitions.BulkReadRequest.newBuilder().setFmuId(fmuId)
            valueReferences.forEachIndexed{ i, v -> builder.setValueReferences(i, v)}
            return blockingStub.bulkReadBoolean(builder.build()).valuesList
        }

    }

    inner class SingleWrite(
            private val valueReference: Int
    ) {

        fun with(value: Int): FmiDefinitions.Status {
            return blockingStub.writeInteger(FmiDefinitions.WriteIntegerRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(valueReference)
                    .setValue(value)
                    .build())
        }

        fun with(value: Double): FmiDefinitions.Status {
            return blockingStub.writeReal(FmiDefinitions.WriteRealRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(valueReference)
                    .setValue(value)
                    .build())
        }

        fun with(value: String): FmiDefinitions.Status {
            return blockingStub.writeString(FmiDefinitions.WriteStringRequest.newBuilder()
                    .setFmuId(fmuId)
                    .setValueReference(valueReference)
                    .setValue(value)
                    .build())
        }

        fun with(value: Boolean): FmiDefinitions.Status {
            return blockingStub.writeBoolean(FmiDefinitions.WriteBooleanRequest.newBuilder()
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

        fun with(values: IntArray):FmiDefinitions.Status {
            val builder = FmiDefinitions.BulkWriteIntegerRequest.newBuilder().setFmuId(fmuId)
            values.forEachIndexed{i,v -> builder.setValues(i, v)}
            valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
            return blockingStub.bulkWriteInteger(builder.build())
        }

        fun with(values: DoubleArray):FmiDefinitions.Status {
            val builder = FmiDefinitions.BulkWriteRealRequest.newBuilder().setFmuId(fmuId)
            values.forEachIndexed{i,v -> builder.setValues(i, v)}
            valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
            return blockingStub.bulkWriteReal(builder.build())
        }

        fun with(values: Array<String>):FmiDefinitions.Status {
            val builder = FmiDefinitions.BulkWriteStringRequest.newBuilder().setFmuId(fmuId)
            values.forEachIndexed{i,v -> builder.setValues(i, v)}
            valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
            return blockingStub.bulkWriteString(builder.build())
        }

        fun with(values: BooleanArray):FmiDefinitions.Status {
            val builder = FmiDefinitions.BulkWriteBooleanRequest.newBuilder().setFmuId(fmuId)
            values.forEachIndexed{i,v -> builder.setValues(i, v)}
            valueReferences.forEachIndexed { i, v ->  builder.setValueReferences(i, v)}
            return blockingStub.bulkWriteBoolean(builder.build())
        }

    }

}


//fun main(args: Array<String>) {
//
//    GrpcFmuClient("localhost", 8000).use {
//
//        it.createInstance().use { fmu ->
//            fmu.init()
//            val dt = 1.0/1000
//            val start = Instant.now()
//            while (fmu.currentTime < 10) {
//                fmu.step(dt)
//            }
//            val end = Instant.now()
//            println("${Duration.between(start, end).toMillis()}ms")
//        }
//
//    }
//
//}



