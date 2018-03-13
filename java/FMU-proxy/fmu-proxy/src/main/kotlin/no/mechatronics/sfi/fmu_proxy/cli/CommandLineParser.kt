package no.mechatronics.sfi.fmu_proxy.cli

import info.laht.yaj_rpc.RpcHandler
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.FmuProxy
import no.mechatronics.sfi.fmu_proxy.FmuProxyBuilder
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.services.GrpcFmuServiceImpl
import no.mechatronics.sfi.fmu_proxy.json_rpc.*
import no.mechatronics.sfi.fmu_proxy.net.SimpleSocketAddress
import no.mechatronics.sfi.fmu_proxy.thrift.ThriftFmuServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import picocli.CommandLine
import java.io.File
import java.util.concurrent.Callable

object CommandLineParser {

    fun parse(args: Array<String>): FmuProxy? {
       return CommandLine.call(Args(), System.out, *args)
    }

}


class Args: Callable<FmuProxy> {

    internal class SimpleSocketAddressConverter: CommandLine.ITypeConverter<SimpleSocketAddress> {
        override fun convert(value: String): SimpleSocketAddress {
            return SimpleSocketAddress.parse(value)
        }
    }

    internal class FmuFileConverter: CommandLine.ITypeConverter<FmuFile> {
        override fun convert(value: String): FmuFile {
            return FmuFile(File(value))
        }
    }

    @CommandLine.Option(names = ["-h", "--help"], description = ["Print this help message and quits."], usageHelp = true)
    var showHelp = false

    @CommandLine.Option(names = ["-fmu", "--fmuPath"], description = ["Path to the FMU"], required = true)
    lateinit var fmuPath: String

    @CommandLine.Option(names = ["-r", "--remote"], description = ["Specify an address for the remote tracking server (optional)"], converter = [SimpleSocketAddressConverter::class])
    var remote: SimpleSocketAddress? = null

    @CommandLine.Option(names = ["-grpc"], description = ["Manually specify the grpc port (optional)"])
    var grpcPort: Int? = null

    @CommandLine.Option(names = ["-thrift"], description = ["Manually specify the thrift port (optional)"])
    var thriftPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/http"], description = ["Manually specify the JSON-RPC HTTP port (optional)"])
    var jsonHttpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/ws"], description = ["Manually specify the JSON-RPC WS port (optional)"])
    var jsonWsPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/tcp"], description = ["Manually specify the JSON-RPC TCP/IP port (optional)"])
    var jsonTcpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/zmq"], description = ["Manually specify the JSON-RPC ZMQ port (optional)"])
    var jsonZmqPort: Int? = null

    override fun call(): FmuProxy? {

        val fmuFile = FmuFile(File(fmuPath.replace("\\", "/")))
        return FmuProxyBuilder(fmuFile).apply {

            setRemote(remote)

            GrpcFmuServer(listOf(GrpcFmuServiceImpl(fmuFile))).apply {
                grpcPort?.also { addServer(this, it) } ?: addServer(this)
            }

            ThriftFmuServer(fmuFile).apply {
                thriftPort?.also { addServer(this, it) } ?: addServer(this)
            }

            val handler = RpcHandler(listOf(RpcFmuService(fmuFile)))
            FmuProxyJsonHttpServer(handler).apply {
                jsonHttpPort?.also { addServer(this, it) } ?: addServer(this)
            }

            FmuProxyJsonWsServer(handler).apply {
                jsonWsPort?.also { addServer(this, it) } ?: addServer(this)
            }

            FmuProxyJsonTcpServer(handler).apply {
                jsonTcpPort?.also { addServer(this, it) } ?: addServer(this)
            }

            FmuProxyJsonZmqServer(handler).apply {
                jsonZmqPort?.also { addServer(this, it) } ?: addServer(this)
            }


        }.build()
    }

    override fun toString(): String {
        return "Args(fmuPath='$fmuPath', remote=$remote, grpcPort=$grpcPort, thriftPort=$thriftPort, jsonHttpPort=$jsonHttpPort, jsonWsPort=$jsonWsPort, jsonTcpPort=$jsonTcpPort, jsonZmqPort=$jsonZmqPort)"
    }

}




