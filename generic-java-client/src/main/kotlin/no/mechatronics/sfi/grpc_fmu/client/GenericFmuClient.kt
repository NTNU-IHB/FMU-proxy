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

package no.mechatronics.sfi.grpc_fmu.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.grpc_fmu.FmiDefinitions
import no.mechatronics.sfi.grpc_fmu.GenericFmuServiceGrpc
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Lars Ivar Hatledal
 */
class GenericFmuClient(
        host: String,
        port: Int
): AutoCloseable {

    private val channel: ManagedChannel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext(true)
            .build()

    private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
            = GenericFmuServiceGrpc.newBlockingStub(channel)

    fun createInstance(): FmuInstance {
        return FmuInstance(stub)
    }

    fun getModelName(): String = stub.getModelName(FmiDefinitions.Empty.getDefaultInstance()).value

    override fun close() {
        LOG.info("Closing..")
        FmuInstance.terminateAll()
        channel.shutdownNow()
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(GenericFmuClient::class.java)
    }


}

class FmuInstance internal constructor(
        private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) : AutoCloseable {

    private val fmuId: Int
            = stub.createInstance(FmiDefinitions.Empty.getDefaultInstance()).value

    init {
        instances.add(this)
    }

    private val modelRef by lazy {
        FmiDefinitions.UInt.newBuilder().setValue(fmuId).build()
    }

    val modelVariables: List<FmiDefinitions.ScalarVariable> by lazy {
        val list = mutableListOf<FmiDefinitions.ScalarVariable>()
        stub.getModelVariables(FmiDefinitions.Empty.getDefaultInstance()).forEach {list.add(it)}
              list
    }

    val currentTime: Double
        get() = stub.getCurrentTime(modelRef).value

    fun init(): Boolean = stub.init(FmiDefinitions.InitRequest.newBuilder()
            .setFmuId(fmuId)
            .build()).value

    fun step(dt: Double): FmiDefinitions.Status = stub.step(FmiDefinitions.StepRequest.newBuilder()
            .setFmuId(fmuId)
            .setDt(dt)
            .build())

    fun terminate() {
        stub.terminate(FmiDefinitions.UInt.newBuilder()
                .setValue(fmuId)
                .build())
        instances.remove(this)
    }

    override fun close() = terminate()

    fun getReader(valueReference: Int): VariableReader
            = VariableReader(fmuId, valueReference, stub)

    fun getReader(variableName: String): VariableReader
        = getReader(modelVariables.firstOrNull { it.name == variableName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $variableName"))

    fun getWriter(valueReference: Int)
            = VariableWriter(fmuId, valueReference, stub)

    fun getWriter(varName: String): VariableWriter
            = getWriter(modelVariables.firstOrNull { it.name == varName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $varName"))

    companion object {
        internal val instances = mutableListOf<FmuInstance>()
        internal fun terminateAll() {
            instances.toList().forEach({
                it.terminate()
            })
        }
    }

}



class VariableReader(
        private val fmuId: Int,
        private val valueReference: Int,
        private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub

) {

    private val request by lazy {
        FmiDefinitions.ReadRequest.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(valueReference)
                .build()
    }

    fun readInt(): Int = stub.readInt(request).value
    fun readReal(): Double = stub.readReal(request).value
    fun readString(): String = stub.readString(request).value
    fun readBoolean(): Boolean = stub.readBoolean(request).value

}


/**
 * @author Lars Ivar Hatledal
 */
class VariableWriter(
        private val fmuId: Int,
        private val valueReference: Int,
        private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    fun write(value: Int): FmiDefinitions.Status = stub.writeInt(FmiDefinitions.WriteIntRequest.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setValue(value)
            .build())

    fun write(value: Double): FmiDefinitions.Status = stub.writeReal(FmiDefinitions.WriteRealRequest.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setValue(value)
            .build())

    fun write(value: String): FmiDefinitions.Status = stub.writeString(FmiDefinitions.WriteStringRequest.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setValue(value)
            .build())

    fun write(value: Boolean): FmiDefinitions.Status = stub.writeBoolean(FmiDefinitions.WriteBooleanRequest.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setValue(value)
            .build())

}


