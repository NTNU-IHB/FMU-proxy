package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.export.fmi2.Fmi2Slave
import no.ntnu.ihb.fmi4j.modeldescription.fmi1.FmiModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2ModelDescription
import no.ntnu.ihb.fmuproxy.misc.*
import no.ntnu.ihb.fmuproxy.thrift.FmuService
import no.ntnu.ihb.fmuproxy.thrift.ModelDescription
import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket
import java.io.Closeable
import java.io.File
import java.io.FileInputStream
import java.io.StringReader
import java.nio.ByteBuffer
import javax.xml.bind.JAXB


class FmuWrapper(
    args: Map<String, Any>
) : Fmi2Slave(args) {

    private val fmu: File
    private val client: ThriftFmuClient?

    override val automaticallyAssignStartValues = false

    init {
        val settings = parseSettings(getFmuResource("proxy-settings.txt"))
        this.fmu = getFmuResource(settings.fmuName)
        if (instanceName == "dummyInstance") {
            this.client = null
        } else {
            val remote = settings.remote
            if (remote == null) {
                val server = getFmuResource("fmu-proxy-server.jar")
                val port = startProxy(server, fmu)
                this.client = ThriftFmuClient("localhost", port)
            } else {
                val port = spawn(this.fmu, remote.host, remote.port)
                this.client = ThriftFmuClient(remote.host, port)
            }
        }
    }

    override fun enterInitialisationMode() {
        this.client?.enterInitializationMode()
    }

    override fun exitInitialisationMode() {
        this.client?.exitInitializationMode()
    }

    override fun setupExperiment(startTime: Double, stopTime: Double, tolerance: Double) {
        this.client?.setupExperiment(startTime, stopTime, tolerance)
    }

    override fun doStep(currentTime: Double, dt: Double) {
        this.client?.doStep(dt)
    }

    override fun terminate() {
        this.client?.terminate()
    }

    override fun close() {
        client?.close()
    }

    override fun getInteger(vr: LongArray): IntArray {
        return client?.readInteger(vr) ?: throw IllegalStateException()
    }

    override fun getReal(vr: LongArray): DoubleArray {
        return client?.readReal(vr) ?: throw IllegalStateException()
    }

    override fun getBoolean(vr: LongArray): BooleanArray {
        return client?.readBoolean(vr) ?: throw IllegalStateException()
    }

    override fun getString(vr: LongArray): Array<String> {
        return client?.readString(vr) ?: throw IllegalStateException()
    }

    override fun setInteger(vr: LongArray, values: IntArray) {
        return client?.writeInteger(vr, values) ?: throw IllegalStateException()
    }

    override fun setReal(vr: LongArray, values: DoubleArray) {
        return client?.writeReal(vr, values) ?: throw IllegalStateException()
    }

    override fun setBoolean(vr: LongArray, values: BooleanArray) {
        return client?.writeBoolean(vr, values) ?: throw IllegalStateException()
    }

    override fun setString(vr: LongArray, values: Array<String>) {
        return client?.writeString(vr, values) ?: throw IllegalStateException()
    }

    override fun registerVariables() {

        val xml = extractModelDescriptionXml(FileInputStream(fmu))
        when (val version = extractFmiVersion(xml)) {
            "1.0" -> processFmi1ModelDescription(JAXB.unmarshal(StringReader(xml), FmiModelDescription::class.java))
            "2.0" -> processFmi2ModelDescription(JAXB.unmarshal(StringReader(xml), Fmi2ModelDescription::class.java))
            else -> throw IllegalArgumentException("Unknown FMI version: $version")
        }

        modelDescription.coSimulation.isCanBeInstantiatedOnlyOncePerProcess = false

    }

    private fun processFmi1ModelDescription(md: FmiModelDescription) {

        modelDescription.modelName = "${md.modelName}-proxy"
        modelDescription.coSimulation.modelIdentifier = "${md.modelIdentifier}-proxy"

        modelDescription.description = md.description
        modelDescription.defaultExperiment = md.defaultExperiment.fmi2Type()

        md.modelVariables.scalarVariable.forEach { v ->

            val name = v.name

            when {
                v.integer != null -> {
                    register(integer(name) { 0 }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality.fmi2Type(v.variability))
                        variability(v.variability.fmi2Type())
                        min(v.integer.min)
                        max(v.integer.max)
                        start(v.integer.start)
                    })
                }
                v.real != null -> {
                    register(real(v.name) { 0.0 }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality.fmi2Type(v.variability))
                        variability(v.variability.fmi2Type())
                        min(v.real.min)
                        max(v.real.max)
                        unit(v.real.unit)
                        start(v.real.start)
                    })
                }
                v.boolean != null -> {
                    register(boolean(v.name) { false }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality.fmi2Type(v.variability))
                        variability(v.variability.fmi2Type())
                        start(v.boolean.isStart)
                    })
                }
                v.string != null -> {
                    register(string(v.name) { "" }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality.fmi2Type(v.variability))
                        variability(v.variability.fmi2Type())
                        start(v.string.start)
                    })
                }
            }
        }

    }

    private fun processFmi2ModelDescription(md: Fmi2ModelDescription) {

        modelDescription.modelName = "${md.modelName}-proxy"
        modelDescription.coSimulation.modelIdentifier = "${md.coSimulation.modelIdentifier}-proxy"

        modelDescription.description = md.description
        modelDescription.defaultExperiment = md.defaultExperiment

        md.modelVariables.scalarVariable.forEach { v ->

            val name = v.name

            when {
                v.integer != null -> {
                    register(integer(name) { 0 }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality)
                        variability(v.variability)
                        initial(v.initial)
                    })
                }
                v.real != null -> {
                    register(real(v.name) { 0.0 }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality)
                        variability(v.variability)
                        initial(v.initial)
                        start(v.real.start)
                    })
                }
                v.boolean != null -> {
                    register(boolean(v.name) { false }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality)
                        variability(v.variability)
                        initial(v.initial)
                    })
                }
                v.string != null -> {
                    register(string(v.name) { "" }.apply {
                        __overrideValueReference = v.valueReference
                        description(v.description)
                        causality(v.causality)
                        variability(v.variability)
                        initial(v.initial)
                    })
                }
            }
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

private class ThriftFmuClient(
    host: String,
    port: Int
) : Closeable {

    val protocol: TBinaryProtocol
    val client: InternalFmuService.Client
    val modelDescription: ModelDescription

    init {

        val transport = TFramedTransport.Factory()
            .getTransport(TSocket(host, port))
        this.protocol = TBinaryProtocol(transport)
        transport.open()

        this.client = InternalFmuService.Client(protocol)
        this.modelDescription = client.modelDescription
        this.client.createInstance()
    }

    fun setupExperiment(startTime: Double, stopTime: Double, tolerance: Double) {
        client.setupExperiment(startTime, stopTime, tolerance)
    }

    fun enterInitializationMode() {
        client.enterInitializationMode()
    }

    fun exitInitializationMode() {
        client.exitInitializationMode()
    }

    fun doStep(dt: Double) {
        client.step(dt)
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

    fun reset() {
        client.reset()
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

}
