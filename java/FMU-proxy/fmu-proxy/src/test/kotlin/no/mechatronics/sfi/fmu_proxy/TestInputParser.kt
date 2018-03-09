package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import org.junit.Assert
import org.junit.Test
import java.io.File

class TestInputParser {

    @Test
    fun test1() {

        val url = javaClass.classLoader.getResource("PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        val fmuFile = FmuFile(File(url.file))

        val args = arrayOf(
                "-grpcPort", "8000",
                "-wsPort", "8001"
        )

        FmuProxy.create(args, fmuFile)

    }

}