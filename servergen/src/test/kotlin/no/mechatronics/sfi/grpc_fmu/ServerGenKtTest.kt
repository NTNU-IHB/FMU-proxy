package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.codegen.ServerGen
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.File

class ServerGenKtTest {

    lateinit var modelDescription: ModelDescription

    @Before
    fun setUp() {

        val url = javaClass.classLoader
                .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        modelDescription = ModelDescription.parseModelDescription(url)

    }

    @Test
    fun generateServerCode() {
        println(ServerGen.generateServerCode(modelDescription))
    }

    @Test
    fun generateServerCodeFile() {

        val out =  File("generated/java/" + GrpcFmu.PACKAGE_NAME.replace(".", "//"))
        ServerGen.generateServerCode(modelDescription).writeToDirectory(out)
       // Assert.assertTrue(file.delete())

    }

}