package no.mechatronics.sfi.grpc_fmu

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import org.apache.commons.io.IOUtils
import java.nio.charset.Charset

class GrpcFmuTest {

    lateinit var generatedJar: File

    @Before
    fun setUp() {
        val url = javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/modelDescription.xml")
        Assert.assertNotNull(url)
        val xml = IOUtils.toString(url, Charset.forName("UTF-8"))
        val modelDescription = ModelDescriptionParser.parse(xml)
        generatedJar = File("${modelDescription.modelName}.jar")

    }

    @After
    fun tearDown() {
        if (generatedJar.exists()) {
            generatedJar.delete()
        }
    }

    @Test
    fun generate() {

        val file = File(javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu").file)
        Assert.assertTrue(file.exists())
        val args = arrayOf(
                "-fmu",  file.absolutePath
        )
        ApplicationStarter.main(args)

        Assert.assertTrue(generatedJar.exists())

        Assert.assertTrue(isPresentInJar("modelDescription.xml"))
        Assert.assertTrue(isPresentInJar("definitions.proto"))
        Assert.assertTrue(isPresentInJar("service.proto"))

    }

    private fun isPresentInJar(path:String): Boolean {

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