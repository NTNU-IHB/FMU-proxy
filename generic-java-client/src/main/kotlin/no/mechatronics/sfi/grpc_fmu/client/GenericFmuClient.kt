package no.mechatronics.sfi.grpc_fmu.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.grpc_fmu.FmiDefinitions
import no.mechatronics.sfi.grpc_fmu.GenericFmuServiceGrpc
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable

class GenericFmuClient(
        host: String,
        port: Int
): AutoCloseable {

    private companion object {

        val LOG: Logger = LoggerFactory.getLogger(GenericFmuClient::class.java)
        val EMPTY: FmiDefinitions.Empty = FmiDefinitions.Empty.getDefaultInstance()

    }

    private val channel: ManagedChannel
    private val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub

    private val instances: MutableList<FmuInstance> = ArrayList()

    init {
        channel = ManagedChannelBuilder.forAddress(host, port)
                  .usePlaintext(true)
                  .build()
        blockingStub = GenericFmuServiceGrpc.newBlockingStub(channel)

    }

    fun createInstance() : FmuInstance {
        return FmuInstance(blockingStub.createInstance(EMPTY)).also {
            instances.add(it)
        }
    }

    fun getModelName(): String = blockingStub.getModelName(EMPTY).value

    override fun close() {
        LOG.info("Closing..")

        instances.toList().forEach({
            it.terminate()
        })
        channel.shutdownNow()
    }

    inner class FmuInstance internal constructor(
            val fmuId: Int
    ) : AutoCloseable {

        private val modelRef by lazy {
            FmiDefinitions.ModelReference.newBuilder().setFmuId(fmuId).build()
        }

        val modelVariables
            get() = blockingStub.getModelVariables(EMPTY)

        val modelVariableNames
            get() = blockingStub.getModelVariableNames(EMPTY)

        constructor(ref: FmiDefinitions.ModelReference) : this(ref.fmuId)

        val currentTime: Double
            get() = blockingStub.getCurrentTime(modelRef).value

        fun init() = blockingStub.init(FmiDefinitions.InitRequest.newBuilder()
                .setFmuId(fmuId)
                .build()).value

        fun step(dt: Double) = blockingStub.step(FmiDefinitions.StepRequest.newBuilder()
                .setFmuId(fmuId)
                .setDt(dt)
                .build())

        fun terminate() {
            blockingStub.terminate(FmiDefinitions.TerminateRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build())
            instances.remove(this)
        }

        override fun close() = terminate()

        fun getReader(valueReference: Int) = VariableReader(fmuId, valueReference, blockingStub)

        fun getReader(varName: String)
                = modelVariables.valuesList.firstOrNull { it.varName == varName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $varName")

        fun getWriter(valueReference: Int) = VariableReader(fmuId, valueReference, blockingStub)

        fun getWriter(varName: String)
                = modelVariables.valuesList.firstOrNull { it.varName == varName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $varName")

    }

}

class VariableReader(
        private val fmuId: Int,
        private val valueReference: Int,
        private val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    private val varRead by lazy {
        FmiDefinitions.VarRead.newBuilder()
                .setFmuId(fmuId)
                .setValueReference(valueReference)
                .build()
    }

    fun readInt() =  blockingStub.read(varRead).intValue
    fun readReal() = blockingStub.read(varRead).realValue
    fun readString() = blockingStub.read(varRead).strValue
    fun readBoolean() = blockingStub.read(varRead).boolValue

}

class VariableWriter(
        private val fmuId: Int,
        private val valueReference: Int,
        private val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    fun write(value: Int) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setIntValue(value)
            .build())

    fun write(value: Double) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setRealValue(value)
            .build())

    fun write(value: String) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setStrValue(value)
            .build())

    fun write(value: Boolean) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setBoolValue(value)
            .build())

}


