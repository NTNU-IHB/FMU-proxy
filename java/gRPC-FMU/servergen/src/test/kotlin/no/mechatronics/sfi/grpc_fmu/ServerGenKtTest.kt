package no.mechatronics.sfi.grpc_fmu

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import no.mechatronics.sfi.grpc_fmu.codegen.ServerGen
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import java.io.File

class ServerGenKtTest {

    lateinit var modelDescription: SimpleModelDescription

    @Before
    fun setUp() {
        val url = javaClass.classLoader
                .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        modelDescription = ModelDescriptionParser.parse(url)
    }

    @Test
    fun generateServerCodeFile() {
        ServerGen.generateServerCode(modelDescription, File("generated"))
    }

}