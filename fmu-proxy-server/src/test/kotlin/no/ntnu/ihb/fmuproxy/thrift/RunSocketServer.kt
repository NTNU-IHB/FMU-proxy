package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import java.io.File
import java.util.*

object RunSocketServer {

    private val fmuPath = File(
        "test/fmus/2.0/cs/20sim/4.6.4.8004/" +
                "ControlledTemperature/ControlledTemperature.fmu"
    )

    @JvmStatic
    fun main(args: Array<String>) {

        println(fmuPath.absolutePath)

        Fmu.from(fmuPath).use { fmu ->
            val server = ThriftFmuSocketServer().apply {
                start(9090, fmu)
            }

            println("Press any key to quit..")
            Scanner(System.`in`).use {
                if (it.hasNext()) {
                    server.close()
                }
            }
        }

    }

}
