package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmuproxy.FmuProxyStarter
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.server.TThreadedSelectorServer
import org.apache.thrift.transport.TNonblockingServerSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.File
import java.io.FileOutputStream
import java.net.ServerSocket
import java.net.URL
import java.nio.ByteBuffer
import java.nio.file.Files
import java.util.concurrent.atomic.AtomicInteger

typealias FmuId = Int
typealias ValuesReferences = List<Long>

class FmuServiceImpl(
    private val port: Int
): FmuService.Iface, Closeable {

    private val fmuIdGen = AtomicInteger()
    private val server: TThreadedSelectorServer
    private val clients: MutableMap<Int, FmuClient> = mutableMapOf()

    init {

        val transport = TNonblockingServerSocket(port)
        val processor = FmuService.Processor(this)
        server = TThreadedSelectorServer(
            TThreadedSelectorServer.Args(transport)
                .processor(processor)
                .protocolFactory(TBinaryProtocol.Factory())
        )
    }

    fun startServer() {
        Thread {
            server.serve()
        }.start()
        LOG.info("FMU-proxy listening for connections on port: $port")
    }

    override fun close() {
        server.stop()
        LOG.debug("Stopping FMU-proxy ...")
    }

    override fun loadFromUrl(url: String): FmuId {
        val file = Files.createTempFile("fmu-proxy", ".fmu").toFile().apply {
            FileOutputStream(this).buffered().write(
                URL(url).openStream().buffered().use {
                    readBytes()
                }
            )
            deleteOnExit()
        }
        val port = startProxy(file)
        val fmuId = fmuIdGen.getAndIncrement()

        val client = FmuClient.create(port)
        clients[fmuId] = client

        return fmuId

    }

    override fun loadFromLocalFile(fileName: String): FmuId {
        val file = File(fileName)
        if (!file.exists()) {
            throw NoSuchFileException()
        }
        val port = startProxy(file)
        val fmuId = fmuIdGen.getAndIncrement()

        val client = FmuClient.create(port)
        clients[fmuId] = client

        return fmuId
    }

    override fun loadFromRemoteFile(name: String, data: ByteBuffer): FmuId {
        val file = Files.createTempFile(name, ".fmu").toFile().apply {
            FileOutputStream(this).buffered().write(data.compact().array())
            deleteOnExit()
        }

        val port = startProxy(file)
        val fmuId = fmuIdGen.getAndIncrement()

        val client = FmuClient.create(port)
        clients[fmuId] = client

        return fmuId
    }

    private fun getClient(fmuId: FmuId): FmuClient {
        return clients[fmuId] ?: throw NoSuchFmuException()
    }

    override fun getModelDescription(fmuId: FmuId): ModelDescription {
        return getClient(fmuId).modelDescription
    }

    override fun instantiate(fmuId: FmuId) {
        getClient(fmuId).instantiate()
    }

    override fun setupExperiment(fmuId: FmuId, start: Double, stop: Double, tolerance: Double): Status {
        return getClient(fmuId).setupExperiment(start, stop, tolerance)
    }

    override fun enterInitializationMode(fmuId: FmuId): Status {
        return getClient(fmuId).enterInitializationMode()
    }

    override fun exitInitializationMode(fmuId: FmuId): Status {
        return getClient(fmuId).exitInitializationMode()
    }

    override fun step(fmuId: FmuId, stepSize: Double): StepResult {
        return getClient(fmuId).step(stepSize)
    }

    override fun reset(fmuId: FmuId): Status {
        return getClient(fmuId).reset()
    }

    override fun terminate(fmuId: FmuId): Status {
        return getClient(fmuId).terminate()
    }

    override fun close(fmuId: FmuId) {
        return getClient(fmuId).close()
    }

    override fun readInteger(fmuId: FmuId, vr: ValuesReferences): IntegerRead {
        return getClient(fmuId).readInteger(vr)
    }

    override fun readReal(fmuId: FmuId, vr: ValuesReferences): RealRead {
        return getClient(fmuId).readReal(vr)
    }

    override fun readString(fmuId: FmuId, vr: ValuesReferences): StringRead {
        return getClient(fmuId).readString(vr)
    }

    override fun readBoolean(fmuId: FmuId, vr: ValuesReferences): BooleanRead {
        return getClient(fmuId).readBoolean(vr)
    }

    override fun writeInteger(fmuId: FmuId, vr: ValuesReferences, value: List<Int>): Status {
        return getClient(fmuId).writeInteger(vr, value)
    }

    override fun writeReal(fmuId: FmuId, vr: ValuesReferences, value: List<Double>): Status {
        return getClient(fmuId).writeReal(vr, value)
    }

    override fun writeString(fmuId: FmuId, vr: ValuesReferences, value: List<String>): Status {
        return getClient(fmuId).writeString(vr, value)
    }

    override fun writeBoolean(fmuId: FmuId, vr: ValuesReferences, value: List<Boolean>): Status {
        return getClient(fmuId).writeBoolean(vr, value)
    }

    override fun getDirectionalDerivative(
        fmuId: FmuId,
        vUnknownRef: List<Long>,
        vKnownRef: List<Long>,
        dvKnownRef: List<Double>
    ): DirectionalDerivativeResult {
        return getClient(fmuId).getDirectionalDerivative(vUnknownRef, vKnownRef, dvKnownRef)
    }

    private companion object {

        private val LOG: Logger = LoggerFactory.getLogger(FmuServiceImpl::class.java)

        private val proxyBin = File(
            FmuProxyStarter::class.java.classLoader
                .getResource("fmu-proxy-server.jar")!!.file
        )

        private fun getAvailablePort(): Int {
            return ServerSocket(0).use {
                it.localPort
            }
        }

        private fun startProxy(file: File): Int {

            require(file.exists()) { "No such file: $file" }

            val port = getAvailablePort()
            val cmd = arrayOf(
                "java", "-jar",
                proxyBin.absolutePath,
                "$port", file.absolutePath
            )

            ProcessBuilder().apply {
                command(*cmd)
                start()
            }

            return port
        }

    }

}
