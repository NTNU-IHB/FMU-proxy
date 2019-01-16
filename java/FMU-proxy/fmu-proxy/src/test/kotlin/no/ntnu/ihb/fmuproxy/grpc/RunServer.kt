package no.ntnu.ihb.fmuproxy.grpc

import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.common.currentOS
import no.ntnu.sfi.fmuproxy.TestUtils
import no.ntnu.ihb.fmuproxy.grpc.GrpcFmuServer
import java.io.File
import java.util.*

object RunServer {

    private val fmuPath = File(TestUtils.getTEST_FMUs(),
            "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    @JvmStatic
    fun main(args: Array<String>) {

        Fmu.from(fmuPath).use { fmu ->
            val server = GrpcFmuServer(fmu).apply {
                start(9080)
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