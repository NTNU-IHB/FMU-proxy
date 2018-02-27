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

package no.mechatronics.sfi.rmu

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.tcp.RpcTcpServer
import info.laht.yaj_rpc.net.ws.RpcWebSocketServer
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.rmu.grpc.GrpcFmuServer
import no.mechatronics.sfi.rmu.grpc.services.GenericFmuService
import no.mechatronics.sfi.rmu.grpc.services.GrpcFmuService
import no.mechatronics.sfi.rmu.heartbeat.Heartbeat
import no.mechatronics.sfi.rmu.json_rpc.FmuService
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
        val tcpPort: Int
)

/**
 *
 * @author Lars Ivar Hatledal
 */
object Rmu {

    private const val HELP = "help"
    private const val REMOTE = "remote"
    private const val GRPC_PORT = "grpcPort"
    private const val JSON_RPC_WS_PORT = "wsPort"
    private const val JSON_RPC_TCP_PORT = "tcpPort"

    fun create(args: Array<String>, fmuFile: FmuFile, instanceService: GrpcFmuService? = null)  {

        val options = Options().apply {

            addOption(HELP, false, "Prints this message")
            addOption(REMOTE, true, "Specify the IP address of the remote tracking server. E.g. ${"127.0.0.1:7000"}")
            addOption(GRPC_PORT, true, "Manually specify the port to use for the gRPC server (optional)")
            addOption(JSON_RPC_WS_PORT, true, "Manually specify the port to use for the JSON-RPC (WebSocket) server (optional)")
            addOption(JSON_RPC_WS_PORT, true, "Manually specify the port to use for the JSON-RPC (TCP/IP) server (optional)")

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
                    val grpcServer = GrpcFmuServer(listOfNotNull(GenericFmuService(fmuFile), instanceService)).apply {
                        start(grpcPort)
                    }

                    val jsonWsPort = cmd.getOptionValue(JSON_RPC_WS_PORT)?.toIntOrNull() ?: availablePort
                    val jsonWsServer = object: RpcWebSocketServer(RpcHandler(FmuService(fmuFile))), RmuServer{}.apply {
                        start(jsonWsPort)
                    }

                    val jsonTcpPort = cmd.getOptionValue(JSON_RPC_TCP_PORT)?.toIntOrNull() ?: availablePort
                    val jsonTcpServer = object: RpcTcpServer(RpcHandler(FmuService(fmuFile))), RmuServer{}.apply {
                        start(jsonTcpPort)
                    }

                    val networkInfo = NetworkInfo(
                            host = hostAddress,
                            grpcPort = grpcPort,
                            wsPort = jsonWsPort,
                            tcpPort = jsonTcpPort
                    )
                    val remoteFmu = RemoteFmu(
                            guid = fmuFile.modelDescription.guid,
                            networkInfo = networkInfo,
                            modelDescriptionXml = fmuFile.modelDescriptionXml)

                    var beat: Heartbeat? = remoteAddress?.let {
                        Heartbeat(remoteAddress, remoteFmu).apply {
                            start()
                        }
                    }

                    println("Press any key to stop the application..")
                    Scanner(System.`in`).also {
                        if (it.hasNext()) {
                            println("Key pressed, stopping application..")
                            beat?.stop()
                            grpcServer.stop()
                            jsonWsServer.stop()
                            jsonTcpServer.stop()
                        }
                    }

                } catch (ex: Exception) {
                    ex.printStackTrace()
                }

            }

        }

    }

    private val jarName = java.io.File(Rmu::class.java
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
