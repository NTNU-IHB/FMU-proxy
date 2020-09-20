package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.FmuBuilder
import java.io.File

object FmuProxify {

    @JvmStatic
    fun main(args: Array<String>) {

        val fmu = File(args[0])
        require(fmu.exists()) { "No such file: $fmu" }
        require(fmu.extension == "fmu") { "Invalid extension: ${fmu.extension}" }

        FmuBuilder.main(arrayOf(
            "-m", "no.ntnu.ihb.fmuproxy.FmuWrapper",
            "-f",
        ))


    }

}
