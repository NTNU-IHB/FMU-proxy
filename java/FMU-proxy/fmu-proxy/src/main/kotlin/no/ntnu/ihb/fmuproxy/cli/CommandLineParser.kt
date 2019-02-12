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

package no.ntnu.ihb.fmuproxy.cli

import info.laht.yajrpc.RpcHandler
import no.ntnu.ihb.fmi4j.common.isLinux
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmuproxy.FmuProxy
import no.ntnu.ihb.fmuproxy.FmuProxyBuilder
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuServer
import no.ntnu.ihb.fmuproxy.jsonrpc.FmuProxyJsonHttpServer
import no.ntnu.ihb.fmuproxy.jsonrpc.FmuProxyJsonTcpServer
import no.ntnu.ihb.fmuproxy.jsonrpc.FmuProxyJsonWsServer
import no.ntnu.ihb.fmuproxy.jsonrpc.FmuProxyJsonZmqServer
import no.ntnu.ihb.fmuproxy.jsonrpc.service.RpcFmuService
import no.ntnu.ihb.fmuproxy.net.SimpleSocketAddress
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServlet
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import picocli.CommandLine
import java.io.File
import java.util.*
import java.util.concurrent.Callable


object CommandLineParser {

    fun parse(args: Array<String>): FmuProxy? {
        return CommandLine.call(Args(), System.out, *args)
    }

}

internal class SimpleSocketAddressConverter : CommandLine.ITypeConverter<SimpleSocketAddress> {
    override fun convert(value: String): SimpleSocketAddress {
        return SimpleSocketAddress.parse(value)
    }
}


@CommandLine.Command(name = "fmu-proxy")
class Args : Callable<FmuProxy> {

    @CommandLine.Option(names = ["-h", "--help"], description = ["Print this message and quits."], usageHelp = true)
    var showHelp = false

    @CommandLine.Parameters(arity = "0..*", paramLabel = "FMUs", description = ["Optional FMU(s) to include."])
    var fmus = mutableListOf<File>()

    @CommandLine.Option(names = ["-r", "--remote"], description = ["Specify an address for the remote tracking server (optional)."], converter = [SimpleSocketAddressConverter::class])
    var remote: SimpleSocketAddress? = null

    @CommandLine.Option(names = ["-grpc"], description = ["Manually specify the gRPC port (optional)."])
    var grpcPort: Int? = null

    @CommandLine.Option(names = ["-thrift/tcp"], description = ["Manually specify the Thrift tcp port (optional)."])
    var thriftTcpPort: Int? = null

    @CommandLine.Option(names = ["-thrift/http"], description = ["Manually specify the Thrift http port (optional)."])
    var thriftHttpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/http"], description = ["Manually specify the JSON-RPC HTTP port (optional)."])
    var jsonHttpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/ws"], description = ["Manually specify the JSON-RPC WS port (optional)."])
    var jsonWsPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/tcp"], description = ["Manually specify the JSON-RPC TCP/IP port (optional)."])
    var jsonTcpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/zmq"], description = ["Manually specify the JSON-RPC ZMQ port (optional)."])
    var jsonZmqPort: Int? = null


    override fun call(): FmuProxy? {

        return fmus.map { Fmu.from(it) }.let { fmus ->
            FmuProxyBuilder(fmus).apply {

                setRemote(remote)

                val map = fmus.associate { it.modelDescription.guid to it }

                GrpcFmuServer(map).apply {
                    addServer(this, grpcPort)
                }

                ThriftFmuSocketServer(map).apply {
                    addServer(this, thriftTcpPort)
                }

                ThriftFmuServlet(map).apply {
                    addServer(this, thriftHttpPort)
                }

                RpcHandler(RpcFmuService(map)).also { handler ->

                    if (!isLinux) {
                        FmuProxyJsonHttpServer(handler).apply {
                            addServer(this, jsonHttpPort)
                        }
                    }

                    FmuProxyJsonWsServer(handler).apply {
                        addServer(this, jsonWsPort)
                    }

                    FmuProxyJsonTcpServer(handler).apply {
                        addServer(this, jsonTcpPort)
                    }

                    FmuProxyJsonZmqServer(handler).apply {
                        addServer(this, jsonZmqPort)
                    }

                }

            }.build()
        }

    }

    override fun toString(): String {
        return "Args(showHelp=$showHelp, fmus=$fmus, remote=$remote, grpcPort=$grpcPort, thriftTcpPort=$thriftTcpPort, thriftHttpPort=$thriftHttpPort, jsonHttpPort=$jsonHttpPort, jsonWsPort=$jsonWsPort, jsonTcpPort=$jsonTcpPort, jsonZmqPort=$jsonZmqPort)"
    }

}
