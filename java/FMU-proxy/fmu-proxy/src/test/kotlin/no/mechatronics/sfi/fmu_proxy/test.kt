package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import org.junit.Assert
import org.junit.Test
import java.io.File

class Testing {

    @Test
 fun test() {

        val str = "file:\\C:\\Users\\laht\\IdeaProjects\\FMU-proxy\\test\\HydraulicCylinder.jar!\\HydraulicCylinder.fmu"
        val str2 = "\\C:\\Users\\laht\\IdeaProjects\\FMU-proxy\\test\\HydraulicCylinder.jar!\\HydraulicCylinder.fmu"
        println(File(str).exists())
        println(File(str2).exists())


    }

}