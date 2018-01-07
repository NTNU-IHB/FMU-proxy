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

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(GenericFmuClient::class.java)

        val EMPTY = FmiDefinitions.Empty.getDefaultInstance()

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
            val fmuId: Int)
    {


        val modelVariables
            get() = blockingStub.getModelVariables(EMPTY)

        val modelVariablenames
            get() = blockingStub.getModelVariableNames(EMPTY)


        constructor(ref: FmiDefinitions.ModelReference) : this(ref.fmuId)

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

        fun getReader(valueReference: Int) = VariableReader(fmuId, valueReference, blockingStub)

        fun getReader(varName: String)
                = modelVariables.valuesList.firstOrNull { it.varName!! == varName }!!.valueReference

        fun getWriter(valueReference: Int) = VariableReader(fmuId, valueReference, blockingStub)

        fun getWriter(varName: String)
                = modelVariables.valuesList.firstOrNull { it.varName!! == varName }!!.valueReference

    }


}

class VariableReader(
        val fmuId: Int,
        val valueReference: Int,
        val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    fun asInt() = blockingStub.read(FmiDefinitions.VarRead.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .build()).intValue

    fun asReal() = blockingStub.read(FmiDefinitions.VarRead.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .build()).realValue

    fun asString() = blockingStub.read(FmiDefinitions.VarRead.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .build()).strValue

    fun asBoolean() = blockingStub.read(FmiDefinitions.VarRead.newBuilder()
            .setFmuId(fmuId)
            .setValueReference(valueReference)
            .build()).boolValue

}

class VariableWriter(
        val fmuId: Int,
        val valueReference: Int,
        val blockingStub: GenericFmuServiceGrpc.GenericFmuServiceBlockingStub
) {

    fun with(value: Int) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setIntValue(value)
            .build())

    fun with(value: Double) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setRealValue(value)
            .build())

    fun with(value: String) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setStrValue(value)
            .build())

    fun with(value: Boolean) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
            .setFmuId(fmuId)
            .setBoolValue(value)
            .build())

}


