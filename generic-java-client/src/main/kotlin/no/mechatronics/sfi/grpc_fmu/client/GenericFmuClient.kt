package no.mechatronics.sfi.grpc_fmu.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.grpc_fmu.FmiDefinitions
import no.mechatronics.sfi.grpc_fmu.GenericFmuServiceGrpc
import org.slf4j.Logger
import org.slf4j.LoggerFactory

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
            val fmuId: Int
    ) : AutoCloseable {

        private val modelRef by lazy {
            FmiDefinitions.ModelReference.newBuilder().setFmuId(fmuId).build()
        }

        val modelVariables
            get() = stub.getModelVariables(EMPTY)

        val modelVariableNames
            get() = stub.getModelVariableNames(EMPTY)

        internal constructor(ref: FmiDefinitions.ModelReference) : this(ref.fmuId)

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

        fun getReader(valueReference: Int) = VariableReader(fmuId, valueReference, stub)

        fun getReader(varName: String)
                = modelVariables.valuesList.firstOrNull { it.varName == varName }?.valueReference ?: throw IllegalArgumentException("No variable with that name: $varName")

        fun getWriter(valueReference: Int) = VariableReader(fmuId, valueReference, stub)

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


