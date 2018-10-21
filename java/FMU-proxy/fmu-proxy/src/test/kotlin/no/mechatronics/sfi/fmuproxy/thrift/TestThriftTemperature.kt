package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.common.currentOS
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.runSlave
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestThriftTemperature {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestThriftTemperature::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/$currentOS/20sim/4.6.4.8004/" +
                    "ControlledTemperature/ControlledTemperature.fmu"))
    private val server = ThriftFmuSocketServer(fmu)
    private val client = ThriftFmuClient.socketClient(fmu.guid, "localhost", server.start())

    @AfterAll
    fun tearDown() {
        client.close()
        server.stop()
        fmu.close()
    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assertions.assertEquals(fmu.modelDescription.guid, guid)
    }

    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assertions.assertEquals(fmu.modelDescription.modelName, modelName)
    }

    @Test
    fun testFMUSupportedTypes() {
        Assertions.assertFalse(client.canCreateInstanceFromME)
        Assertions.assertTrue(client.canCreateInstanceFromCS)
    }

    @Test
    fun testInstance() {

        client.newInstance().use { slave ->

            val temp = client.modelDescription.modelVariables
                    .getByName("Temperature_Room").asRealVariable()

            val stop = 2.0
            val stepSize = 1E-4
            runSlave(slave, stepSize, stop) {
                temp.read(slave)
            }.also {
                LOG.info("Duration: ${it}ms")
            }

        }

    }

}