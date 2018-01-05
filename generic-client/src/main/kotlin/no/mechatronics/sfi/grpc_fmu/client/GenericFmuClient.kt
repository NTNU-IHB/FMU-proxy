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
): Closeable {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(GenericFmuClient::class.java)
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
        return FmuInstance(blockingStub.createInstance(FmiDefinitions.Empty.getDefaultInstance())).also {
            instances.add(it)
        }
    }

    fun getModelName() = blockingStub.getModelName(FmiDefinitions.Empty.getDefaultInstance()).value

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

        constructor(ref: FmiDefinitions.ModelReference) : this(ref.fmuId)

        fun init() = blockingStub.init(FmiDefinitions.InitRequest.newBuilder()
                .setFmuId(fmuId)
                .build()).value

        fun terminate() {
            blockingStub.terminate(FmiDefinitions.TerminateRequest.newBuilder()
                    .setFmuId(fmuId)
                    .build())
            instances.remove(this)
        }

        fun getModelVariables() = blockingStub.getModelVariables(FmiDefinitions.Empty.getDefaultInstance())

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