package no.mechatronics.sfi.grpc_fmu.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import no.mechatronics.sfi.grpc_fmu.FmiDefinitions
import no.mechatronics.sfi.grpc_fmu.PipeFlowServiceGrpc
import java.io.Closeable

class GenericFmuClient(
        host: String,
        port: Int
): Closeable {

    private val channel: ManagedChannel
    private val blockingStub: PipeFlowServiceGrpc.PipeFlowServiceBlockingStub

    private val instances: MutableList<FmuInstance> = ArrayList()

    init {
        channel = ManagedChannelBuilder.forAddress(host, port)
                  .usePlaintext(true)
                  .build()
        blockingStub = PipeFlowServiceGrpc.newBlockingStub(channel)

    }

    fun createInstance() : FmuInstance {
        return FmuInstance(blockingStub.createInstance(FmiDefinitions.Empty.getDefaultInstance())).also {
            instances.add(it)
        }
    }

    fun getModelName() = blockingStub.getModelName(FmiDefinitions.Empty.getDefaultInstance()).value

    override fun close() {
        instances.forEach({
            it.terminate()
        })
        channel.shutdownNow()
    }

    inner class FmuInstance internal constructor(
            val fmuId: Int)
    {

        constructor(ref: FmiDefinitions.ModelReference) : this(ref.fmuId)

        fun init() = blockingStub.init(FmiDefinitions.InitRequest.newBuilder()
                .setFmuId(fmuId)
                .build()).value

        fun terminate() {
            blockingStub.terminate(FmiDefinitions.TerminateRequest.getDefaultInstance())
            instances.remove(this)
        }

        fun read(varName: String) = blockingStub.read(FmiDefinitions.VarRead.newBuilder()
                .setFmuId(fmuId)
                .setVarName(varName)
                .build())

        fun write(varName: String, value: Int) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
                .setFmuId(fmuId)
                .setVarName(varName)
                .setIntValue(value)
                .build())

        fun write(varName: String, value: Double) = blockingStub.write(FmiDefinitions.VarWrite.newBuilder()
                .setFmuId(fmuId)
                .setVarName(varName)
                .setRealValue(value)
                .build())

    }

}