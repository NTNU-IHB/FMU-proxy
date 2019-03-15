package no.ntnu.ihb.fmuproxy.grpc

import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmuproxy.Solver
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@EnabledOnOs(OS.WINDOWS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestGrpcME {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestGrpcME::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "2.0/me/FMUSDK/2.0.4/vanDerPol/vanDerPol.fmu"))

    private val modelDescription = fmu.modelDescription
    private val server = GrpcFmuServer().apply { addFmu(fmu) }
    private val client = GrpcFmuClient("localhost", server.start()).load(fmu.guid)

    @AfterAll
    fun tearDown() {
        client.close()
        server.stop()
        fmu.close()
    }

    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assertions.assertEquals(modelDescription.modelName, modelName)
    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assertions.assertEquals(modelDescription.guid, guid)
    }

    @Test
    fun testFMUSupportedTypes() {
        Assertions.assertTrue(client.canCreateInstanceFromME)
        Assertions.assertFalse(client.canCreateInstanceFromCS)
    }

    @Test
    fun testInstance() {

        val solver = Solver("Euler").apply {
            addProperty("step_size", modelDescription.defaultExperiment?.stepSize ?: 1E-3)
        }

        client.newInstance(solver).use { slave ->

            slave.simpleSetup()
            Assertions.assertEquals(FmiStatus.OK, slave.lastStatus)

            val variableName = "x0"
            val variable = slave.modelDescription
                    .getVariableByName(variableName).asRealVariable()

            variable.read(slave).also {
                LOG.info("$variableName=${it.value}")
                Assertions.assertEquals(2.0, it.value)
            }

            val stop = 2.0
            val stepSize = 1E-2
            while (slave.simulationTime <= stop) {
                Assertions.assertTrue(slave.doStep(stepSize))
                LOG.info("$variableName=${variable.read(slave)}")
            }

        }

    }

}