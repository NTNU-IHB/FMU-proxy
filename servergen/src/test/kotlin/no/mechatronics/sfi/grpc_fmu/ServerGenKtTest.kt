package no.mechatronics.sfi.grpc_fmu


import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.File

import no.mechatronics.sfi.grpc_fmu.codegen.ServerGen
import no.mechatronics.sfi.fmi4j.modeldescription.IModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser


class ServerGenKtTest {

    lateinit var modelDescription: IModelDescription

    @Before
    fun setUp() {

        val url = javaClass.classLoader
                .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        modelDescription = ModelDescriptionParser.parse(url)

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