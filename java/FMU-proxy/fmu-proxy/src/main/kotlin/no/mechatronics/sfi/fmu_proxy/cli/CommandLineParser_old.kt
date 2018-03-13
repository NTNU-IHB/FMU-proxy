package no.mechatronics.sfi.fmu_proxy.cli

import info.laht.yaj_rpc.RpcHandler
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.FmuProxy
import no.mechatronics.sfi.fmu_proxy.ProxyBuilder
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.services.GrpcFmuServiceImpl
import no.mechatronics.sfi.fmu_proxy.json_rpc.*
import no.mechatronics.sfi.fmu_proxy.net.SimpleSocketAddress
import no.mechatronics.sfi.fmu_proxy.thrift.ThriftFmuServer
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import java.io.File

object CommandLineParser_old {

    private const val FMU = "fmu"
    private const val HELP = "help"
    private const val REMOTE = "remote"
    private const val GRPC_PORT = "grpc"
    private const val THRIFT_PORT = "thrift-tcp"
    private const val JSON_RPC_WS_PORT = "jsonrpc-ws"
    private const val JSON_RPC_ZMQ_PORT = "jsonrpc-zmq"
    private const val JSON_RPC_TCP_PORT = "jsonrpc-tcp"
    private const val JSON_RPC_HTTP_PORT = "jsonrpc-http"


    fun parse(args: Array<String>): FmuProxy? {

        val options = Options().apply {

            addOption(Option(HELP, false, "Prints this message"))
            addOption(Option(FMU, true, "The location of the FMU").apply { isRequired = true })
            addOption(Option(REMOTE, true, "Specify the IP address of the remote tracking server. E.g. ${"127.0.0.1:7000"}"))
            addOption(Option(GRPC_PORT, true, "Manually specify the port to use for the gRPC server (optional)"))
            addOption(Option(THRIFT_PORT, true, "Manually specify the port to use for the Thrift server (optional)"))
            addOption(Option(JSON_RPC_WS_PORT, true, "Manually specify the port to use for the JSON-RPC (WebSocket) server (optional)"))
            addOption(Option(JSON_RPC_TCP_PORT, true, "Manually specify the port to use for the JSON-RPC (TCP/IP) server (optional)"))
            addOption(Option(JSON_RPC_HTTP_PORT, true, "Manually specify the port to use for the JSON-RPC (HTTP) server (optional)"))
            addOption(Option(JSON_RPC_ZMQ_PORT, true, "Manually specify the port to use for the JSON-RPC (ZMQ) server (optional)"))

        }

        return DefaultParser().parse(options, args).let { cmd ->
            if (args.isEmpty() || cmd.hasOption(HELP)) {
                HelpFormatter().printHelp("fmu-proxy", options)
                null
            } else {
                println(cmd.getOptionValue(FMU))
                cmd.getOptionValue(FMU)?.let {

                     val fmuFile = FmuFile(File(it))
                    ProxyBuilder(fmuFile).apply {

                        setRemote(cmd.getOptionValue(REMOTE)?.let { parseAddress(it) })

                        GrpcFmuServer(listOf(GrpcFmuServiceImpl(fmuFile))).apply {
                            cmd.getOptionValue(GRPC_PORT)?.toIntOrNull()?.also { port ->
                                addServer(this, port)
                            } ?: addServer(this)
                        }

                        ThriftFmuServer(fmuFile).apply {
                            cmd.getOptionValue(THRIFT_PORT)?.toIntOrNull()?.also { port ->
                                addServer(this, port)
                            } ?: addServer(this)
                        }

                        val handler = RpcHandler(listOf(RpcFmuService(fmuFile)))
                        FmuProxyJsonHttpServer(handler).apply {
                            cmd.getOptionValue(JSON_RPC_HTTP_PORT)?.toIntOrNull()?.also { port ->
                                addServer(this, port)
                            } ?: addServer(this)
                        }

                        FmuProxyJsonWsServer(handler).apply {
                            cmd.getOptionValue(JSON_RPC_WS_PORT)?.toIntOrNull()?.also { port ->
                                addServer(this, port)
                            } ?: addServer(this)
                        }

                        FmuProxyJsonTcpServer(handler).apply {
                            cmd.getOptionValue(JSON_RPC_TCP_PORT)?.toIntOrNull()?.also { port ->
                                addServer(this, port)
                            } ?: addServer(this)
                        }

                        FmuProxyJsonZmqServer(handler).apply {
                            cmd.getOptionValue(JSON_RPC_ZMQ_PORT)?.toIntOrNull()?.also { port ->
                                addServer(this, port)
                            } ?: addServer(this)
                        }


                    }.build()

                }
            }

        }
    }
}

private fun parseAddress(value: String) : SimpleSocketAddress {

    val split = value.split(":")
    if (split.size != 2) {
        error("Wrong address format! Expected 'host:port', was '$value'")
    }

    val host = split[0]
    val port = split[1].toIntOrNull()
            ?: error("Wrong input format! Unable to create port number from input: $value")
    return SimpleSocketAddress(host, port)
}

