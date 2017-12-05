package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.codegen.ServerGen
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ServerGenKtTest {

    lateinit var modelDescription: ModelDescription

    @Before
    fun setUp() {

        val url = ServerGenKtTest::class.java.classLoader.getResource("fmus.cs/PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        modelDescription = ModelDescription.parseModelDescription(url)

    }

    @Test
    fun generateServerCode() {

        println(ServerGen.generateServerCode(modelDescription))

    }

    @Test
    fun generateServerCodeFile() {

        val file = ServerGen.generateServerCodeFile(modelDescription, "generated/java/")
        Assert.assertNotNull(file)
       // Assert.assertTrue(file.delete())

    }

}