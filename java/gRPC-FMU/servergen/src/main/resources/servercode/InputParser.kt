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

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Options


/**
 *
 * @author Lars Ivar Hatledal
 */
object InputParser {

    private const val HELP = "help"

    private const val REMOTE = "remote"
    private const val LOCAL_PORT = "localPort"

    @JvmStatic
    fun parse(args: Array<String>, action: (SimpleSocketAddress?, Int?) -> Unit)  {

        val options = Options().apply {

            addOption(HELP, false, "Prints this message")
            addOption(REMOTE, true, "Specify the IP address of the remote tracking server. E.g. ${"127.0.0.1:7000"}")
            addOption(LOCAL_PORT, true, "Manually specify the local port to use. E.g. 7777 (optional)")

        }

        val jarName = java.io.File(InputParser::class.java
                .protectionDomain.codeSource.location.path).name

        DefaultParser().parse(options, args).also { cmd ->
            if (cmd.hasOption(HELP)) {
                HelpFormatter().printHelp(jarName, options)
            } else {

                var localPort: Int? = null
                if (cmd.hasOption(LOCAL_PORT)) {
                    localPort = parseInt(cmd.getOptionValue(LOCAL_PORT))
                }

                val remote: SimpleSocketAddress? = cmd.getOptionValue(REMOTE).let {
                    if (it != null) {
                        parseAddress(it)
                    } else {
                        null
                    }
                }

                action.invoke(remote, localPort)

            }

        }

    }

    private fun parseAddress(value: String) : SimpleSocketAddress {

        val split = value.split(":")
        if (split.size != 2) {
            error("Wrong address format!")
        }

        val host = split[0]
        val port = parseInt(split[1])
        return SimpleSocketAddress(host, port)
    }

    private fun parseInt(value: String) : Int {
        try {
            return value.toInt()
        } catch (ex: NumberFormatException) {
            error("Wrong input format! Unable to parse port number from input: ${value}")
        }
    }

}

object ConsoleParser {

    private const val REMOTE_PORT = "port"
    private const val REMOTE_ADDRESS = "host"

    private const val LOCAL_PORT = "localPort"

    private const val HELP = "help"

    fun parse(args: Array<String>) : SimpleSocketAddress? {

        val options = Options().apply {

            addOption(HELP, false, "Prints this message")

            addOption(REMOTE_PORT, true, "Specify the port of the remote tracking server. E.g. 7000")
            addOption(REMOTE_ADDRESS, true, "Specify the host name of the remote tracking server. E.g. ${"127.0.0.1"}")

            addOption(LOCAL_PORT, true, "Specify the local port to use. E.g. 7777")

        }

        val cmd = DefaultParser().parse(options, args)

        if (cmd.hasOption(HELP)) {
            HelpFormatter().printHelp("", options)
            return null
        }

        if (!cmd.hasOption(REMOTE_PORT)) {
            error("No port given!")
        }

        if (!cmd.hasOption(REMOTE_ADDRESS)) {
            error("No host given!")
        }

        val address = cmd.getOptionValue(REMOTE_ADDRESS)!!
        val port: Int? = cmd.getOptionValue(REMOTE_PORT).let { portString ->
            try {
                portString.toInt()
            } catch (ex: NumberFormatException) {
                error("Wrong input format! Unable to parse port number from input: ${portString}")
            }
        }

        return SimpleSocketAddress(address, port!!)


    }

}