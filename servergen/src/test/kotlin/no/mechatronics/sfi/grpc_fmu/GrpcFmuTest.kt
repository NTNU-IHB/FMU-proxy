package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.io.File
import java.net.URL

class GrpcFmuTest {

    lateinit var url: URL
    lateinit var generatedJar: File

    @Before
    fun setUp() {

        url = GrpcFmuTest::class.java.classLoader.getResource("fmus.cs/PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        val modelDescription = ModelDescription.parseModelDescription(url)
        generatedJar = File("${modelDescription.modelName}-all.jar")

    }

    @After
    fun tearDown() {
        if (generatedJar.exists()) {
            generatedJar.delete()
        }
    }

    @Test
    fun generate() {

        GrpcFmu.generate(url)

    }
}