package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.importer.misc.currentOS
import no.mechatronics.sfi.fmuproxy.TestUtils
import java.io.File
import java.util.*

object RunServlet {

    private val fmuPath = File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/$currentOS" +
                    "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    @JvmStatic
    fun main(args: Array<String>) {

        Fmu.from(fmuPath).use { fmu ->
            val server = ThriftFmuServlet(fmu).apply {
                start(9091)
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