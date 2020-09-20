package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.export.fmi2.Fmi2Slave
import no.ntnu.ihb.fmuproxy.thrift.FmuService
import no.ntnu.ihb.fmuproxy.thrift.ModelDescription
import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket
import java.io.Closeable
import java.io.File
import java.nio.ByteBuffer

class FmuWrapper(
    args: Map<String, Any>
) : Fmi2Slave(args) {

    private var client: ThriftFmuClient

    init {
        val (host, port) = parseProxySettings()
        val fmu = getFmuResource("proxy-model.fmu")
        this.client = ThriftFmuClient(fmu, host, port)
    }

    override fun enterInitialisationMode() {
        this.client.enterInitializationMode()
    }

    override fun exitInitialisationMode() {
        this.client.exitInitializationMode()
    }

    override fun setupExperiment(startTime: Double) {
        this.client.setupExperiment(startTime)
    }

    override fun doStep(currentTime: Double, dt: Double) {
        this.client
    }

    override fun terminate() {
        this.client.terminate()
    }

    override fun getInteger(vr: LongArray): IntArray {
        return client.readInteger(vr)
    }

    override fun getReal(vr: LongArray): DoubleArray {
        return client.readReal(vr)
    }

    override fun getBoolean(vr: LongArray): BooleanArray {
        return client.readBoolean(vr)
    }

    override fun getString(vr: LongArray): Array<String> {
        return client.readString(vr)
    }

    override fun setInteger(vr: LongArray, values: IntArray) {
        return client.writeInteger(vr, values)
    }

    override fun setReal(vr: LongArray, values: DoubleArray) {
        return client.writeReal(vr, values)
    }

    override fun setBoolean(vr: LongArray, values: BooleanArray) {
        return client.writeBoolean(vr, values)
    }

    override fun setString(vr: LongArray, values: Array<String>) {
        return client.writeString(vr, values)
    }

    override fun registerVariables() {

        client.modelDescription.modelVariables.forEach { v ->

            val name = v.name
            val attr = v.attribute

            when {
                attr.integerAttribute != null -> {
                    register(integer(name) { 0 })
                }
                attr.realAttribute != null -> {
                    register(real(v.name) { 0.0 })
                }
                attr.booleanAttribute != null -> {
                    register(boolean(v.name) { false })
                }
                attr.stringAttribute != null -> {
                    register(string(v.name) { "" })
                }
            }

        }
    }

    private fun parseProxySettings(): Pair<String, Int> {
        val settings = getFmuResource("proxy-settings.txt")
        val read = settings.readLines().first().split(":")
        return read[0] to read[1].toInt()
    }

}

private class ThriftFmuClient(
    fmuFile: File,
    host: String,
    port: Int
) : Closeable {

    val protocol: TBinaryProtocol
    val client: InternalFmuService.Client
    val modelDescription: ModelDescription

    init {

        val fmuPort = spawn(fmuFile, host, port)

        val transport = TFramedTransport.Factory()
            .getTransport(TSocket(host, fmuPort))
        this.protocol = TBinaryProtocol(transport)
        transport.open()

        this.client = InternalFmuService.Client(protocol)
        this.modelDescription = client.modelDescription
    }

    fun enterInitializationMode() {
        client.enterInitializationMode()
    }

    fun exitInitializationMode() {
        client.exitInitializationMode()
    }

    fun setupExperiment(startTime: Double) {
        client.setupExperiment(startTime, 0.0, 0.0)
    }

    fun readInteger(vr: LongArray): IntArray {
        return client.readInteger(vr.toList()).value.toIntArray()
    }

    fun readReal(vr: LongArray): DoubleArray {
        return client.readReal(vr.toList()).value.toDoubleArray()
    }

    fun readBoolean(vr: LongArray): BooleanArray {
        return client.readBoolean(vr.toList()).value.toBooleanArray()
    }

    fun readString(vr: LongArray): Array<String> {
        return client.readString(vr.toList()).value.toTypedArray()
    }

    fun writeInteger(vr: LongArray, values: IntArray) {
        client.writeInteger(vr.toList(), values.toList())
    }

    fun writeReal(vr: LongArray, values: DoubleArray) {
        client.writeReal(vr.toList(), values.toList())
    }

    fun writeBoolean(vr: LongArray, values: BooleanArray) {
        client.writeBoolean(vr.toList(), values.toList())
    }

    fun writeString(vr: LongArray, values: Array<String>) {
        client.writeString(vr.toList(), values.toList())
    }

    fun terminate() {
        client.terminate()
    }

    override fun close() {
        client.shutdown()
        if (protocol.transport.isOpen) {
            protocol.transport.close()
        }
    }

    private companion object {

        fun spawn(fmuFile: File, host: String, port: Int): Int {
            //with 150 MB max message size
            val transport = TFramedTransport.Factory(150000000)
                .getTransport(TSocket(host, port))
            val protocol = TBinaryProtocol(transport)
            val client = FmuService.Client(protocol)
            transport.open()

            return if (host.isLoopback()) {
                client.loadFromLocalFile(fmuFile.absolutePath)
            } else {
                val data = fmuFile.readBytes().let {
                    ByteBuffer.wrap(it)
                }
                client.loadFromRemoteFile(fmuFile.name, data)
            }
        }

    }

}

private fun String.isLoopback(): Boolean {
    return this == "localhost" || this == "127.0.0.1"
}
