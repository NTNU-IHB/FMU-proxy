package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.importer.fmi2.Fmu
import no.ntnu.ihb.fmi4j.read
import no.ntnu.ihb.fmuproxy.runSlave
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestThriftCS {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestThriftCS::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

    private val modelDescription = fmu.modelDescription
    private val server = ThriftFmuSocketServer().apply { addFmu(fmu) }
    private val client = ThriftFmuClient.socketClient("localhost", server.start()).load(fmu.guid)

    @AfterAll
    fun tearDown() {
        client.close()
        server.stop()
        fmu.close()
    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assertions.assertEquals(modelDescription.guid, guid)
    }

    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assertions.assertEquals(modelDescription.modelName, modelName)
    }

    @Test
    fun testFMUSupportedTypes() {
        Assertions.assertFalse(client.canCreateInstanceFromME)
        Assertions.assertTrue(client.canCreateInstanceFromCS)
    }

    @Test
    fun testInstance() {

        client.newInstance().use { slave ->

            val variableName = "Temperature_Room"
            val variable = slave.modelVariables
                    .getByName(variableName).asRealVariable()

            val stop = 2.0
            val stepSize = 1E-2
            runSlave(slave, stepSize, stop) {
                variable.read(slave)
            }.also {
                LOG.info("Duration: ${it}ms")
            }

        }

    }

}
