package no.ntnu.ihb.fmuproxy

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.RpcMethod
import info.laht.yajrpc.RpcService
import info.laht.yajrpc.net.RpcServer
import info.laht.yajrpc.net.tcp.RpcTcpServer
import java.io.File
import java.io.FileOutputStream
import java.net.ServerSocket
import java.net.URL
import java.nio.file.Files
import java.util.*


object FmuProxyStarter {

    @JvmStatic
    fun main(args: Array<String>) {

        val port = args[0].toInt()
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

}

private class ProxyService : RpcService {

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

        val proxyBin = File(ProxyService::class.java.classLoader.getResource("fmu-proxy.jar")!!.file)

        fun getAvailablePort(): Int {
            return ServerSocket(0).use {
                it.localPort
            }
        }

        fun startProxy(file: File): Int {

            require(file.exists()) { "No such file: $file" }

            val port = getAvailablePort()
            val cmd = arrayOf(
                    "java", "-jar",
                    proxyBin.absolutePath,
                    "-tcp", "$port",
                    file.absolutePath
            )
            Runtime.getRuntime().exec(cmd)
            return port
        }

    }

}
