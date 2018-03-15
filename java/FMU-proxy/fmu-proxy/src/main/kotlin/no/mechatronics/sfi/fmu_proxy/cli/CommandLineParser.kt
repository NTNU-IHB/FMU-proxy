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

package no.mechatronics.sfi.fmu_proxy.cli

import info.laht.yaj_rpc.RpcHandler
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.FmuProxy
import no.mechatronics.sfi.fmu_proxy.FmuProxyBuilder
import no.mechatronics.sfi.fmu_proxy.avro.AvroFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.services.GrpcFmuServiceImpl
import no.mechatronics.sfi.fmu_proxy.json_rpc.*
import no.mechatronics.sfi.fmu_proxy.net.SimpleSocketAddress
import no.mechatronics.sfi.fmu_proxy.thrift.ThriftFmuServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import picocli.CommandLine
import java.io.File
import java.net.MalformedURLException
import java.net.URI
import java.net.URL
import java.util.concurrent.Callable

val LOG: Logger = LoggerFactory.getLogger(CommandLineParser::class.java)

object CommandLineParser {

    fun parse(args: Array<String>): FmuProxy? {
       return CommandLine.call(Args(), System.out, *args)
    }

}

@CommandLine.Command(name = "fmu-proxy")
class Args: Callable<FmuProxy> {

    internal class SimpleSocketAddressConverter: CommandLine.ITypeConverter<SimpleSocketAddress> {
        override fun convert(value: String): SimpleSocketAddress {
            return SimpleSocketAddress.parse(value)
        }
    }

    @CommandLine.Option(names = ["-h", "--help"], description = ["Print this help message and quits."], usageHelp = true)
    var showHelp = false

    @CommandLine.Option(names = ["-fmu", "--fmuPath"], description = ["Path to the FMU"], required = true)
    lateinit var fmuPath: String

    @CommandLine.Option(names = ["-r", "--remote"], description = ["Specify an address for the remote tracking server (optional)"], converter = [SimpleSocketAddressConverter::class])
    var remote: SimpleSocketAddress? = null

    @CommandLine.Option(names = ["-grpc"], description = ["Manually specify the gRPC port (optional)"])
    var grpcPort: Int? = null

    @CommandLine.Option(names = ["-thrift"], description = ["Manually specify the Thrift port (optional)"])
    var thriftPort: Int? = null

    @CommandLine.Option(names = ["-avro"], description = ["Manually specify the Avro port (optional)"])
    var avroPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/http"], description = ["Manually specify the JSON-RPC HTTP port (optional)"])
    var jsonHttpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/ws"], description = ["Manually specify the JSON-RPC WS port (optional)"])
    var jsonWsPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/tcp"], description = ["Manually specify the JSON-RPC TCP/IP port (optional)"])
    var jsonTcpPort: Int? = null

    @CommandLine.Option(names = ["-jsonrpc/zmq"], description = ["Manually specify the JSON-RPC ZMQ port (optional)"])
    var jsonZmqPort: Int? = null


    override fun call(): FmuProxy? {

        LOG.debug("FmuPath=$fmuPath")

        val fmuFile = File(fmuPath).let {file ->

            if (file.exists()) {
                FmuFile.from(file)
            } else {
                try {
                    val url = URL(fmuPath)
                    FmuFile.from(url)
                } catch (ex: MalformedURLException) {
                    LOG.error("Interpreted fmuPath as an URL, but an MalformedURLException was thrown", ex)
                    null
                }
            }

        }

       fmuFile ?: return null

        return FmuProxyBuilder(fmuFile).apply {

            setRemote(remote)

            GrpcFmuServer(fmuFile).apply {
                addServer(this, grpcPort)
            }

            ThriftFmuServer(fmuFile).apply {
                addServer(this, thriftPort)
            }

            AvroFmuServer(fmuFile).apply {
                addServer(this, avroPort)
            }

            val handler = RpcHandler(RpcFmuService(fmuFile))
            FmuProxyJsonHttpServer(handler).apply {
                addServer(this, jsonHttpPort)
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

        }.build()
    }

    override fun toString(): String {
        return "Args(fmuPath='$fmuPath', remote=$remote, grpcPort=$grpcPort, thriftPort=$thriftPort, avroPort=$avroPort, jsonHttpPort=$jsonHttpPort, jsonWsPort=$jsonWsPort, jsonTcpPort=$jsonTcpPort, jsonZmqPort=$jsonZmqPort)"
    }


}




