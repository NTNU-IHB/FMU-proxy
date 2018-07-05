package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestProxyGen {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ExecutableGenerator::class.java)
    }

    private val fmuPath = File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/${TestUtils.getOs()}/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    private val modelDescription = ModelDescriptionParser.parse(fmuPath)
    private val generatedJar = File("${modelDescription.modelName}.jar")

    @AfterAll
    fun tearDown() {
        if (generatedJar.exists()) {
            if (generatedJar.delete()) {
                LOG.debug("Deleted generated jar '$generatedJar'")
            }
        }
    }

    @Test
    fun generate() {

        Assertions.assertTrue(fmuPath.exists())
        val args = arrayOf(
                "-fmu", fmuPath.absolutePath,
                "-out", File(".").absolutePath
        )
        ApplicationStarter.main(args)

        Assertions.assertTrue(generatedJar.exists())

        Assertions.assertTrue(isPresentInJar("modelDescription.xml"))
        Assertions.assertTrue(isPresentInJar("definitions.proto"))
        Assertions.assertTrue(isPresentInJar("service.proto"))
        Assertions.assertTrue(isPresentInJar("unique_service.proto"))

    }

    private fun isPresentInJar(path: String): Boolean {

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