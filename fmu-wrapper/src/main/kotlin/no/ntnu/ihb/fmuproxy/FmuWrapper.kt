package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.export.BulkRead
import no.ntnu.ihb.fmi4j.export.fmi2.Fmi2Slave
import no.ntnu.ihb.fmi4j.modeldescription.fmi1.FmiModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.util.FmiModelDescriptionUtil
import no.ntnu.ihb.fmuproxy.misc.*
import no.ntnu.ihb.fmuproxy.thrift.ModelDescription
import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket
import java.io.*
import java.util.concurrent.TimeUnit


class FmuWrapper(
        args: Map<String, Any>
) : Fmi2Slave(args) {

    private val fmuFile: File
    private val client: ThriftFmuClient?
    private var localProcess: Process? = null

    override val automaticallyAssignStartValues = false

    init {
        val settings = parseSettings(getFmuResource("proxy-settings.txt"))
        this.fmuFile = getFmuResource(settings.fmuName)
        if (instanceName == "dummyInstance") {
            this.client = null
        } else {
            val remote = settings.remote
            if (remote == null) {
                val server = getFmuResource("fmu-proxy-server.jar")
                val (process, port) = startLocalProxy(server, fmuFile)
                this.localProcess = process
                Thread.sleep(1000)
                this.client = ThriftFmuClient("localhost", port)
            } else {
                val port = startRemoteProxy(this.fmuFile, remote.host, remote.port)
                Thread.sleep(1000)
                this.client = ThriftFmuClient(remote.host, port)
            }
        }
    }

    override fun setupExperiment(startTime: Double, stopTime: Double, tolerance: Double) {
        this.client?.setupExperiment(startTime, stopTime, tolerance)
    }

    override fun enterInitialisationMode() {
        this.client?.enterInitializationMode()
    }

    override fun exitInitialisationMode() {
        this.client?.exitInitializationMode()
    }

    override fun doStep(currentTime: Double, dt: Double) {
        this.client?.doStep(dt)
    }

    override fun terminate() {
        this.client?.terminate()
    }

    override fun close() {
        client?.close()

        localProcess?.apply {
            waitFor(2000, TimeUnit.MILLISECONDS)
        }
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

    override fun getAll(intVr: LongArray, realVr: LongArray, boolVr: LongArray, strVr: LongArray): BulkRead {
        return client?.readAll(intVr, realVr, boolVr, strVr) ?: throw IllegalStateException()
    }

    override fun setAll(
        intVr: LongArray, intValues: IntArray,
        realVr: LongArray, realValues: DoubleArray,
        boolVr: LongArray, boolValues: BooleanArray,
        strVr: LongArray, strValues: Array<String>
    ) {
        client?.writeAll(intVr, intValues, realVr, realValues, boolVr, boolValues, strVr, strValues)
    }

    override fun registerVariables() {

        val xml = FmiModelDescriptionUtil.extractModelDescriptionXml(FileInputStream(fmuFile))
        when (val version = FmiModelDescriptionUtil.extractVersion(xml)) {
            "1.0" -> processFmi1ModelDescription(FmiModelDescription.fromXml(xml))
            "2.0" -> processFmi2ModelDescription(Fmi2ModelDescription.fromXml(xml))
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
}

private class ThriftFmuClient(
        host: String,
        port: Int
) : Closeable {

    private val transport = TFramedTransport.Factory()
        .getTransport(TSocket(host, port))
    private val protocol = TBinaryProtocol(transport)

    private val client: InternalFmuService.Client by lazy {
        transport.open()
        InternalFmuService.Client(protocol).apply {
            createInstance()
        }
    }

    val modelDescription: ModelDescription by lazy {
        client.modelDescription
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

    fun readAll(intVr: LongArray, realVr: LongArray, boolVr: LongArray, strVr: LongArray): BulkRead {
        val response = client.readAll(intVr.toList(), realVr.toList(), boolVr.toList(), strVr.toList())
        return BulkRead(
            response.intValue.toIntArray(),
            response.realValue.toDoubleArray(),
            response.booleanValue.toBooleanArray(),
            response.stringValue.toTypedArray()
        )
    }

    fun writeAll(
        intVr: LongArray, intValues: IntArray,
        realVr: LongArray, realValues: DoubleArray,
        boolVr: LongArray, boolValues: BooleanArray,
        strVr: LongArray, strValues: Array<String>
    ) {
        client.writeAll(
            intVr.toList(), intValues.toList(),
            realVr.toList(), realValues.toList(),
            boolVr.toList(), boolValues.toList(),
            strVr.toList(), strValues.toList()
        )
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
