package no.mechatronics.sfi.fmu_proxy.cli

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.FmuProxy
import no.mechatronics.sfi.fmu_proxy.ProxyBuilder
import no.mechatronics.sfi.fmu_proxy.SimpleSocketAddress
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import java.io.File
import java.net.ServerSocket

data class ParseResult(
        val fmuFile: FmuFile
) {
    var remote: SimpleSocketAddress? = null
    var grpcPort: Int? = null
    var thriftPort: Int? = null
    var jsonHttpPort: Int? = null
    var jsonWsPort: Int? = null
    var jsonTcpPort: Int? = null
    var jsonZmqPort: Int? = null
}

object CommandLineParser {

    private const val HELP = "help"
    private const val FMU = "fmu"
    private const val REMOTE = "remote"
    private const val GRPC = "grpc"
    private const val GRPC_PORT = "grpcPort"
    private const val THRIFT = "thrift"
    private const val THRIFT_PORT = "thriftPort"
    private const val JSON_RPC = "JSON_RPC"
    private const val JSON_RPC_WS_PORT = "wsPort"
    private const val JSON_RPC_ZMQ_PORT = "zmqPort"
    private const val JSON_RPC_TCP_PORT = "tcpPort"
    private const val JSON_RPC_HTTP_PORT = "httpPort"


    fun parse(args: Array<String>): ParseResult? {

        val options = Options().apply {

            addOption(Option(HELP, false, "Prints this message"))
            addOption(Option(FMU, false, "The location of the FMU"))
            addOption(Option(REMOTE, true, "Specify the IP address of the remote tracking server. E.g. ${"127.0.0.1:7000"}"))
            addOption(Option(GRPC, true, "Enable grpc server"))
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
                cmd.getOptionValue(FMU)?.let {

                     val fmuFile = FmuFile(File(it))

                 ParseResult(fmuFile).apply {

                        remote = cmd.getOptionValue(REMOTE)?.let { parseAddress(it) }
                        if (cmd.hasOption(GRPC)) {
                            grpcPort = cmd.getOptionValue(GRPC_PORT)?.let { it.toIntOrNull() }
                        }
                        if (cmd.hasOption(THRIFT)) {
                            thriftPort = cmd.getOptionValue(THRIFT_PORT)?.let { it.toIntOrNull() }
                        }
                        if (cmd.hasOption(JSON_RPC)) {
                            jsonHttpPort = cmd.getOptionValue(JSON_RPC_HTTP_PORT)?.let { it.toIntOrNull() }
                        }

                    }

                } ?: null
            }

        }
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
    val port = split[1].toIntOrNull()
            ?: error("Wrong input format! Unable to create port number from input: $value")
    return SimpleSocketAddress(host, port)
}

