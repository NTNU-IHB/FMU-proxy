package no.ntnu.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.ProtoGen
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import java.io.File

class ProtoGenKtTest {

    lateinit var modelDescription: ModelDescription

    @Before
    fun setUp() {

        val url = javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
        assertNotNull(url)
        modelDescription = ModelDescription.parseModelDescription(url)

    }

    @Test
    fun generateProtoString() {

        println(ProtoGen.generateProtoString(modelDescription))

    }

    @Test
    fun compileProto() {

        val file = ProtoGen.generateProtoFile(modelDescription, "generated/proto/")
        assertNotNull(file)

        ProtoGen.compileProto(file, "generated/proto/","generated/java/")

        //Assert.assertTrue(file.delete())

    }

}