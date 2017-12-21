package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import org.apache.commons.io.IOUtils
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.io.File
import java.io.FileInputStream
import java.net.URL
import java.nio.charset.Charset
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

class GrpcFmuTest {

    lateinit var url: URL
    lateinit var generatedJar: File

    @Before
    fun setUp() {

        url = GrpcFmuTest::class.java.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
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

        Assert.assertTrue(generatedJar.exists())

        Assert.assertTrue(isPresent("modelDescription.xml"))
        Assert.assertTrue(isPresent("protoDefinition.proto"))

    }

    private fun isPresent(path:String): Boolean {

        ZipInputStream(FileInputStream(generatedJar)).use {

            var nextEntry: ZipEntry? = it.nextEntry
            while (nextEntry != null) {

                val name = nextEntry.name
                if (name == path) {
                    return true
                }

                nextEntry = it.nextEntry
            }

        }
        return false

    }

}