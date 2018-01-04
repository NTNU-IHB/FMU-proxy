package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.grpc_fmu.misc.SocketAddress
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import javax.swing.JOptionPane

object InputParser {

    @JvmStatic
    fun parse(args: Array<String>) : SocketAddress {

        if (args.isEmpty()) {
            return GUIParser.parse()
        } else {
            return ConsoleParser.parse(args)
        }

    }

}

object GUIParser {

    fun parse() : SocketAddress {

        val input = JOptionPane.showInputDialog(null, "Input the address of the remote tracking server. E.g ${"127.0.0.1:7000"}")

        val split = input.split(":")
        if (split.size != 2) {
            error("Wrong input format! Expected the following format: '${"hostAddress:port"}'")
        }

        val address = split[0]

        try {
            val port = split[1].toInt()

            return SocketAddress(address, port)

        } catch (ex: NumberFormatException) {
            error("Wrong input format! Unable to parse port number from input: ${split[1]}")
        }


    }

}

object ConsoleParser {

    private const val REMOTE_PORT = "port"
    private const val REMOTE_ADDRESS = "address"

    fun parse(args: Array<String>) : SocketAddress {

        val options = Options().apply {

            addOption(REMOTE_PORT, true, "Specify the port of the remote tracking server. E.g. 7000")
            addOption(REMOTE_ADDRESS, true, "Specify the address of the remote tracking server. E.g. ${"127.0.0.1"}")

        }

        val parser = DefaultParser()
        val cmd = parser.parse(options, args)

        return cmd.let {

            if (!it.hasOption(REMOTE_PORT)) {
                error("No port given!")
            }

            if (!it.hasOption(REMOTE_ADDRESS)) {
                error("No address given!")
            }

            val address = it.getOptionValue(REMOTE_ADDRESS)!!
            val port: Int? = it.getOptionValue(REMOTE_PORT).let { portString ->
                try {
                    portString.toInt()
                } catch (ex: NumberFormatException) {
                    error("Wrong input format! Unable to parse port number from input: ${portString}")
                }
            }

            SocketAddress(address, port!!)

        }

    }

}