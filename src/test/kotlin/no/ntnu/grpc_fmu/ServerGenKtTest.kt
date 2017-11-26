package no.ntnu.grpc_fmu

import no.mechatronics.sfi.grpc_fmu.ServerGen
import no.ntnu.fmi4j.modeldescription.ModelDescription
import org.apache.commons.io.IOUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.nio.charset.Charset

class ServerGenKtTest {

    lateinit var modelDescription: ModelDescription

    @Before
    fun setUp() {

        val url = javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/modelDescription.xml")
        Assert.assertNotNull(url)
        modelDescription = ModelDescription.parseModelDescription(IOUtils.toString(url, Charset.forName("UTF-8")))

    }

    @Test
    fun generateServerCode() {

        println(ServerGen.generateServerCode(modelDescription))

    }

    @Test
    fun generateServerCodeFile() {

        val file = ServerGen.generateServerCodeFile(modelDescription)
        Assert.assertNotNull(file)
       // Assert.assertTrue(file.delete())

    }

}