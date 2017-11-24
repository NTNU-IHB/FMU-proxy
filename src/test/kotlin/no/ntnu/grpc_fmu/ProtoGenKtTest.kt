package no.ntnu.grpc_fmu

import no.ntnu.fmi4j.CoSimulationFmu
import no.ntnu.fmi4j.modeldescription.ModelDescription
import org.apache.commons.io.IOUtils
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.nio.charset.Charset

class ProtoGenKtTest {

    lateinit var modelDescription: ModelDescription

    @Before
    fun setUp() {

        val url = javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/modelDescription.xml")
        assertNotNull(url)
        modelDescription = ModelDescription.parseModelDescription(IOUtils.toString(url, Charset.forName("UTF-8")))

    }

    @Test
    fun generateProtoString() {

        println(ProtoGen.generateProtoString(modelDescription))

    }

    @Test
    fun compileProto() {

        val file = ProtoGen.generateProtoFile(modelDescription)
        assertNotNull(file)

        ProtoGen.compileProto(file)

        Assert.assertTrue(file.delete())

    }

}