package no.mechatronics.sfi.fmu_proxy.grpc

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmu_proxy.ApplicationStarter
import no.mechatronics.sfi.fmu_proxy.ExecutableGenerator
import org.apache.commons.io.IOUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.charset.Charset

class Test {

    lateinit var generatedJar: File

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ExecutableGenerator::class.java)
    }

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
            if (generatedJar.delete()) {
                LOG.debug("Deleted generated jar '$generatedJar'")
            }
        }
    }

    @Test
    fun generate() {

        val file = File(javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu").file)
        Assert.assertTrue(file.exists())
        val args = arrayOf(
                "-fmu", file.absolutePath,
                "-out", File(".").absolutePath
        )
        ApplicationStarter.main(args)

        Assert.assertTrue(generatedJar.exists())

        Assert.assertTrue(isPresentInJar("modelDescription.xml"))
        Assert.assertTrue(isPresentInJar("definitions.proto"))
        Assert.assertTrue(isPresentInJar("service.proto"))
        Assert.assertTrue(isPresentInJar("unique_service.proto"))

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