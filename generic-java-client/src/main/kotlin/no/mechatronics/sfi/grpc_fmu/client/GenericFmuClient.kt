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

import com.sun.org.apache.xpath.internal.operations.Variable
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

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(GenericFmuClient::class.java)
        val EMPTY: FmiDefinitions.Empty = FmiDefinitions.Empty.getDefaultInstance()
    }

    private val channel: ManagedChannel
            = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext(true)
            .build()

    private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
            = GenericFmuServiceGrpc.newBlockingStub(channel)

    private val instances: MutableList<FmuInstance> = ArrayList()

    fun createInstance() : FmuInstance {
        return FmuInstance(stub.createInstance(EMPTY)).also {
            instances.add(it)
        }
    }

    fun getModelName(): String = stub.getModelName(EMPTY).value

    override fun close() {
        LOG.info("Closing..")

        instances.toList().forEach({
            it.terminate()
        })
        channel.shutdownNow()
    }

    inner class FmuInstance internal constructor(
            private val fmuId: Int
    ) : AutoCloseable {

        private val modelRef by lazy {
            FmiDefinitions.Int.newBuilder().setValue(fmuId).build()
        }

        val modelVariables
            get() = stub.getModelVariables(EMPTY)?.valuesList ?: throw AssertionError()

        internal constructor(ref: FmiDefinitions.Int) : this(ref.value)

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
            stub.terminate(FmiDefinitions.TerminateRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build())
            instances.remove(this)
        }

        override fun close() = terminate()

        fun getReader(valueReference: Int): VariableReader
                = VariableReader(fmuId, valueReference, stub)

        fun getReader(varName: String): VariableReader
            = getReader(modelVariables.firstOrNull { it.varName == varName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $varName"))


        fun getWriter(valueReference: Int)
                = VariableWriter(fmuId, valueReference, stub)

        fun getWriter(varName: String): VariableWriter
                = getWriter(modelVariables.firstOrNull { it.varName == varName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $varName"))

    }

}

class VariableReader(
        private val fmuId: Int,
        private val valueReference: Int,
        private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    private val varRead by lazy {
        FmiDefinitions.VarRead.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(valueReference)
                .build()
    }

    fun readInt() =  stub.read(varRead).intValue
    fun readReal() = stub.read(varRead).realValue
    fun readString() = stub.read(varRead).strValue
    fun readBoolean() = stub.read(varRead).boolValue

}

/**
 * @author Lars Ivar Hatledal
 */
class VariableWriter(
        private val fmuId: Int,
        private val valueReference: Int,
        private val stub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    fun write(value: Int): FmiDefinitions.Status = stub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setIntValue(value)
            .build())

    fun write(value: Double): FmiDefinitions.Status = stub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setRealValue(value)
            .build())

    fun write(value: String): FmiDefinitions.Status = stub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setStrValue(value)
            .build())

    fun write(value: Boolean): FmiDefinitions.Status = stub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .setBoolValue(value)
            .build())

}


