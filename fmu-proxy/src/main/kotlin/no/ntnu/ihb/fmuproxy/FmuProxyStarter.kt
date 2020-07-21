package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.FmuServiceImpl
import java.util.*


object FmuProxyStarter {

    private fun parsePort(args: Array<String>): Int {
        return if (args.isEmpty()) return 9080 else args[0].toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {

        val port = parsePort(args)

        val server = FmuServiceImpl(port).apply {
            startServer()
        }

        println("Press any key to exit..")
        if (Scanner(System.`in`).hasNext()) {
            println("Exiting..")
        }

        server.close()

    }

    internal fun debugMain(args: Array<String>) {

        val port = parsePort(args)

        FmuServiceImpl(port).apply {
            startServer()
        }

    }

}
