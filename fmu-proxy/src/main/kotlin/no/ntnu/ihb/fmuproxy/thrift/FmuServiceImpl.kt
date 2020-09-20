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
import kotlin.concurrent.thread

class FmuServiceImpl(
    private val port: Int
) : FmuService.Iface, Closeable {

    private val server: TThreadedSelectorServer

    init {

        val transport = TNonblockingServerSocket(port)
        val processor = FmuService.Processor(this)
        this.server = TThreadedSelectorServer(
            TThreadedSelectorServer.Args(transport)
                .processor(processor)
                .protocolFactory(TBinaryProtocol.Factory())
        )
    }

    fun startServer() {
        thread (start=true) {
            server.serve()
        }
        while (!server.isServing) {
            Thread.sleep(100)
        }
        LOG.info("FMU-proxy listening for connections on port: $port")
    }

    override fun loadFromUrl(url: String): Int {
        LOG.info("Loading FMU from URL: '$url'")
        val split = url.split("/")
        val name = split[split.lastIndex].split(".").first()
        val file = Files.createTempFile("${name}_", ".fmu").toFile().apply {
            URL(url).openStream().buffered().use { bis ->
                FileOutputStream(this).buffered().use { fis ->
                    bis.copyTo(fis)
                }

            }
            deleteOnExit()
        }

        return startProxy(file)
    }

    override fun loadFromLocalFile(fileName: String): Int {
        LOG.info("Loading FMU from local file: '$fileName'")
        val file = File(fileName)
        if (!file.exists()) {
            throw NoSuchFileException()
        }

        return startProxy(file)
    }

    override fun loadFromRemoteFile(name: String, data: ByteBuffer): Int {
        LOG.info("Loading FMU from remote file: '$name'")
        val file = Files.createTempFile("${name}_", ".fmu").toFile().apply {
            FileOutputStream(this).buffered().use { fis ->
                fis.write(data.compact().array())
            }
            deleteOnExit()
        }

        return startProxy(file)
    }

    override fun close() {
        LOG.debug("Stopping FMU-proxy ...")
        server.stop()
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

            LOG.info("Spawned new process serving FMU '${file.nameWithoutExtension}'")

            return port
        }

    }

}
