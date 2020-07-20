package no.ntnu.ihb.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.RpcMethod
import info.laht.yajrpc.RpcService
import info.laht.yajrpc.net.tcp.RpcTcpServer
import java.io.File
import java.io.FileOutputStream
import java.net.ServerSocket
import java.net.URL
import java.nio.file.Files
import java.util.*


object FmuProxyStarter {

    private fun parsePort(args: Array<String>): Int {
        return if (args.isEmpty()) return 9080 else args[0].toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {

        val port = parsePort(args)
        val handler = RpcHandler(ProxyService())

        val server = RpcTcpServer(handler).apply {
            start(port)
        }

        println("Press any key to exit..")
        if (Scanner(System.`in`).hasNext()) {
            println("Exiting..")
        }
        server.stop()

    }

    internal fun debugMain(args: Array<String>) {

        val port = parsePort(args)
        val handler = RpcHandler(ProxyService())

        RpcTcpServer(handler).apply {
            start(port)
        }

    }

}

class ProxyService : RpcService {

    override val serviceName: String
        get() = "proxy"

    @RpcMethod
    fun createLocalFileProxy(fileName: String): Int {
        return startProxy(File(fileName))
    }

    @RpcMethod
    fun createRemoteFileProxy(base64: String): Int {
        val data = Base64.getDecoder().decode(base64)
        val file = Files.createTempFile("fmu-proxy", ".fmu").toFile().apply {
            FileOutputStream(this).buffered().write(data)
            deleteOnExit()
        }
        return startProxy(file)
    }

    @RpcMethod
    fun createUrlProxy(urlString: String): Int {
        val file = Files.createTempFile("fmu-proxy", ".fmu").toFile().apply {
            FileOutputStream(this).buffered().write(
                URL(urlString).openStream().buffered().use {
                    readBytes()
                }
            )
            deleteOnExit()
        }
        return startProxy(file)
    }

    companion object {

        private val proxyBin = File(
            FmuProxyStarter::class.java.classLoader
                .getResource("fmu-proxy-server.jar")!!.file
        )

        private fun getAvailablePort(): Int {
            return ServerSocket(0).use {
                it.localPort
            }
        }

        fun startProxy(file: File): Int {

            require(file.exists()) { "No such file: $file" }

            val port = getAvailablePort()
            val cmd = arrayOf(
                "cmd", "/c",
                "java", "-jar",
                proxyBin.absolutePath,
                "-tcp", "$port",
                file.absolutePath
            )

            val pb = ProcessBuilder()
            pb.command(*cmd)
            pb.start()

            return port
        }

    }

}
