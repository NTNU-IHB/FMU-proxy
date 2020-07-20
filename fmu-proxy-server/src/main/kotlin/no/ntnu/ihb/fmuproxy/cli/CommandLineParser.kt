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

import no.ntnu.ihb.fmi4j.importer.AbstractFmu
import no.ntnu.ihb.fmuproxy.FmuProxy
import no.ntnu.ihb.fmuproxy.FmuProxyBuilder
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuServlet
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuSocketServer
import picocli.CommandLine
import java.io.File
import java.util.concurrent.Callable

private const val VERSION = "0.7.0"

object CommandLineParser {

    fun parse(args: Array<String>): FmuProxy? {
        return CommandLine.call(Args(), System.out, *args)
    }

}

@CommandLine.Command(name = "fmu-proxy")
class Args : Callable<FmuProxy> {

    @CommandLine.Option(names = ["-h", "--help"], description = ["Print this message and quits."], usageHelp = true)
    var showHelp = false

    @CommandLine.Option(names = ["-v", "--version"], description = ["Print the version of this application."])
    var showVersion = false

    @CommandLine.Parameters(arity = "1", paramLabel = "FMU", description = ["FMU to load."])
    var fmuFile: File? = null

    @CommandLine.Option(names = ["-tcp"], description = ["Enable Thrift TCP/IP using the specified port (optional)."])
    var thriftTcpPort: Int? = null

    @CommandLine.Option(names = ["-http"], description = ["Enable Thrift HTTP using the specified port (optional)."])
    var thriftHttpPort: Int? = null

    override fun call(): FmuProxy? {

        if (showVersion) {
            println(VERSION)
            return null
        }

        require(fmuFile != null)

        if (thriftTcpPort == null && thriftHttpPort == null) {
            System.err.println("Error! no ports specified. No server(s) will be started. Exiting..")
            return null
        }

        val fmu = AbstractFmu.from(fmuFile!!)
        return FmuProxyBuilder(fmu).apply {

            thriftTcpPort?.also {
                ThriftFmuSocketServer().apply {
                    addServer(this, it)
                }
            }

            thriftHttpPort?.also {
                ThriftFmuServlet().apply {
                    addServer(this, it)
                }
            }

        }.build()

    }

    override fun toString(): String {
        return "Args(showHelp=$showHelp, thriftTcpPort=$thriftTcpPort, thriftHttpPort=$thriftHttpPort)"
    }

}
