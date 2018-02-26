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

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.rmu.fmu.RemoteFmu
import no.mechatronics.sfi.rmu.grpc.GrpcFmuServer
import no.mechatronics.sfi.rmu.grpc.services.GenericFmuService
import no.mechatronics.sfi.rmu.grpc.services.GrpcFmuService
import no.mechatronics.sfi.rmu.heartbeat.Heartbeat
import no.mechatronics.sfi.rmu.json_rpc.JsonRpcFmuServer
import no.mechatronics.sfi.rmu.misc.SimpleSocketAddress
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Options
import java.net.InetAddress
import java.net.ServerSocket
import java.net.UnknownHostException
import java.util.*


/**
 *
 * @author Lars Ivar Hatledal
 */
object InputParser {

    private const val HELP = "help"
    private const val REMOTE = "remote"
    private const val GRPC_PORT = "grpcPort"
    private const val JSON_RPC_WS_PORT = "wsPort"

    fun parse(args: Array<String>, fmuFile: FmuFile, instanceService: GrpcFmuService? = null)  {

        val options = Options().apply {

            addOption(HELP, false, "Prints this message")
            addOption(REMOTE, true, "Specify the IP address of the remote tracking server. E.g. ${"127.0.0.1:7000"}")
            addOption(GRPC_PORT, true, "Manually specify the port to use for the gRPC server (optional)")
            addOption(JSON_RPC_WS_PORT, true, "Manually specify the port to use for the json-RPC (WebSocket) server (optional)")

        }

        DefaultParser().parse(options, args).also { cmd ->
            if (cmd.hasOption(HELP)) {
                HelpFormatter().printHelp(jarName, options)
            } else {

                val remoteAddress: SimpleSocketAddress? = cmd.getOptionValue(REMOTE).let {
                    it?.let { parseAddress(it) }
                }

                try {
                    val grpcPort = cmd.getOptionValue(GRPC_PORT)?.toIntOrNull() ?: availablePort
                    val grpcAddress = SimpleSocketAddress(hostAddress, grpcPort)
                    val grpcServer = GrpcFmuServer(listOfNotNull(GenericFmuService(fmuFile), instanceService)).apply {
                        start(grpcPort)
                    }

                    val jsonPort = cmd.getOptionValue(JSON_RPC_WS_PORT)?.toIntOrNull() ?: availablePort
                    val jsonAddress = SimpleSocketAddress(hostAddress, jsonPort)
                    val jsonServer = JsonRpcFmuServer(fmuFile).apply {
                        start(jsonPort)
                    }

                    var beat: Heartbeat? = remoteAddress?.let {
                        val guid = fmuFile.modelDescription.guid
                        val xml = fmuFile.modelDescriptionXml
                        val remoteFmu = RemoteFmu(guid, grpcAddress, xml)
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
                            jsonServer.stop()
                        }
                    }


                } catch (ex: Exception) {
                    ex.printStackTrace()
                }

            }

        }

    }

    private val jarName = java.io.File(InputParser::class.java
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

    private fun parseAddress(value: String) : SimpleSocketAddress {

        val split = value.split(":")
        if (split.size != 2) {
            error("Wrong address format!")
        }

        val host = split[0]
        val port = split[1].toIntOrNull() ?: error("Wrong input format! Unable to parse port number from input: $value")
        return SimpleSocketAddress(host, port)
    }


}
