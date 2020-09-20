package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.FmuBuilder
import java.io.File
import java.io.FileOutputStream
import java.net.URLClassLoader
import java.nio.file.Files
import java.util.jar.JarOutputStream

object FmuProxify {

    @JvmStatic
    fun main(args: Array<String>) {

        val originalFmu = File(args[0])
        require(originalFmu.exists()) { "No such file: $originalFmu" }
        require(originalFmu.extension == "fmu") { "Invalid extension: ${originalFmu.extension}" }

       /* FmuBuilder.main(
            arrayOf(
                "-m", "no.ntnu.ihb.fmuproxy.FmuWrapper",
                "-f", fmu.absolutePath
            )
        )*/

    }

}
