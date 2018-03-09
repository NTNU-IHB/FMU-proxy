/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.fmu_proxy

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.http.RpcHttpServer
import info.laht.yaj_rpc.net.tcp.RpcTcpServer
import info.laht.yaj_rpc.net.ws.RpcWebSocketServer
import info.laht.yaj_rpc.net.zmq.RpcZmqServer
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.services.GenericFmuServiceImpl
import no.mechatronics.sfi.fmu_proxy.grpc.services.GrpcFmuService
import no.mechatronics.sfi.fmu_proxy.heartbeat.Heartbeat
import no.mechatronics.sfi.fmu_proxy.json_rpc.RpcFmuService
import no.mechatronics.sfi.fmu_proxy.server.FmuProxyServer
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Options
import java.net.InetAddress
import java.net.ServerSocket
import java.net.UnknownHostException
import java.util.*


internal data class RemoteFmu(
        val guid: String,
        val networkInfo: NetworkInfo,
        val modelDescriptionXml: String
)

internal data class NetworkInfo(
        val host: String,
        val grpcPort: Int,
        val wsPort: Int,
        val zmqPort: Int,
        val tcpPort: Int,
        val httpPort: Int
)

/**
 *
 * @author Lars Ivar Hatledal
 */
object FmuProxy {

    private const val HELP = "help"
    private const val REMOTE = "remote"
    private const val GRPC_PORT = "grpcPort"
    private const val JSON_RPC_WS_PORT = "wsPort"
    private const val JSON_RPC_ZMQ_PORT = "zmqPort"
    private const val JSON_RPC_TCP_PORT = "tcpPort"
    private const val JSON_RPC_HTTP_PORT = "httpPort"

    private var beat: Heartbeat? = null
    private val servers = mutableListOf<FmuProxyServer>()

    fun create(args: Array<String>, fmuFile: FmuFile, instanceService: GrpcFmuService? = null)  {

        val options = Options().apply {

            addOption(HELP, false, "Prints this message")
            addOption(REMOTE, true, "Specify the IP address of the remote tracking server. E.g. ${"127.0.0.1:7000"}")
            addOption(GRPC_PORT, true, "Manually specify the port to use for the gRPC server (optional)")
            addOption(JSON_RPC_WS_PORT, true, "Manually specify the port to use for the JSON-RPC (WebSocket) server (optional)")
            addOption(JSON_RPC_TCP_PORT, true, "Manually specify the port to use for the JSON-RPC (TCP/IP) server (optional)")
            addOption(JSON_RPC_HTTP_PORT, true, "Manually specify the port to use for the JSON-RPC (HTTP) server (optional)")
            addOption(JSON_RPC_ZMQ_PORT, true, "Manually specify the port to use for the JSON-RPC (ZMQ) server (optional)")

        }

        DefaultParser().parse(options, args).also { cmd ->
            if (cmd.hasOption(HELP)) {
                HelpFormatter().printHelp(jarName, options)
            } else {

                val remoteAddress: Pair<String, Int>? = cmd.getOptionValue(REMOTE)?.let {
                    parseAddress(it)
                }



                try {
                    val grpcPort = cmd.getOptionValue(GRPC_PORT)?.toIntOrNull() ?: availablePort
                    GrpcFmuServer(listOfNotNull(GenericFmuServiceImpl(fmuFile), instanceService)).apply {
                        start(grpcPort)
                    }.also { servers.add(it) }

                    val rpcHandler = RpcHandler(RpcFmuService(fmuFile))

                    val jsonWsPort = cmd.getOptionValue(JSON_RPC_WS_PORT)?.toIntOrNull() ?: availablePort
                    object: RpcWebSocketServer(rpcHandler), FmuProxyServer {}.apply {
                        start(jsonWsPort)
                    }.also { servers.add(it) }

                    val jsonZmqPort = cmd.getOptionValue(JSON_RPC_ZMQ_PORT)?.toIntOrNull() ?: availablePort
                    object: RpcZmqServer(rpcHandler), FmuProxyServer {}.apply {
                        start(jsonZmqPort)
                    }.also { servers.add(it) }

                    val jsonTcpPort = cmd.getOptionValue(JSON_RPC_TCP_PORT)?.toIntOrNull() ?: availablePort
                    object: RpcTcpServer(rpcHandler), FmuProxyServer {}.apply {
                        start(jsonTcpPort)
                    }.also { servers.add(it) }

                    val jsonHttpPort = cmd.getOptionValue(JSON_RPC_HTTP_PORT)?.toIntOrNull() ?: availablePort
                    object: RpcHttpServer(rpcHandler), FmuProxyServer {}.apply {
                        start(jsonHttpPort)
                    }.also { servers.add(it) }

                    val networkInfo = NetworkInfo(
                            host = hostAddress,
                            grpcPort = grpcPort,
                            wsPort = jsonWsPort,
                            zmqPort = jsonZmqPort,
                            tcpPort = jsonTcpPort,
                            httpPort = jsonHttpPort
                    )
                    val remoteFmu = RemoteFmu(
                            guid = fmuFile.modelDescription.guid,
                            networkInfo = networkInfo,
                            modelDescriptionXml = fmuFile.modelDescriptionXml)

                    beat = remoteAddress?.let {
                        Heartbeat(remoteAddress, remoteFmu).apply {
                            start()
                        }
                    }

                    println("Press any key to stop the application..")
                    Scanner(System.`in`).use {
                        if (it.hasNext()) {
                            println("Key pressed, stopping application..")
                            stopServers()
                        }
                    }

                } catch (ex: Exception) {
                    ex.printStackTrace()
                }

            }

        }

    }

    internal fun stopServers() {
        beat?.stop()
        servers.forEach {
            it.stop()
        }
    }

    private val jarName = java.io.File(FmuProxy::class.java
            .protectionDomain.codeSource.location.path).name


    private val hostAddress: String
        get() {
            return try {
                InetAddress.getLocalHost().hostAddress
            } catch (ex: UnknownHostException) {
                "127.0.0.1"
            }
        }

    private val availablePort: Int
        get() {
            return ServerSocket(0).use { it.localPort }
        }

    private fun parseAddress(value: String) : Pair<String, Int> {

        val split = value.split(":")
        if (split.size != 2) {
            error("Wrong address format!")
        }

        val host = split[0]
        val port = split[1].toIntOrNull() ?: error("Wrong input format! Unable to create port number from input: $value")
        return host to port
    }


}
