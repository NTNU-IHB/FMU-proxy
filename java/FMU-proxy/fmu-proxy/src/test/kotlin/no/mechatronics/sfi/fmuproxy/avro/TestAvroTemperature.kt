package no.mechatronics.sfi.fmuproxy.avro

import no.mechatronics.sfi.fmi4j.common.currentOS
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.runInstance
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestAvroTemperature {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestAvroTemperature::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/$currentOS/20sim/4.6.4.8004/" +
                    "ControlledTemperature/ControlledTemperature.fmu"))
    private val server: AvroFmuServer = AvroFmuServer(fmu)
    private val client: AvroFmuClient = AvroFmuClient(fmu.guid,"localhost", server.start())

    @AfterAll
    fun tearDown() {
        client.close()
        server.close()
        fmu.close()
    }

    @Test
    fun testGuid() {
        val guid = client.guid.also { LOG.info("guid=$it") }
        Assertions.assertEquals(fmu.guid, guid)
    }

    @Test
    fun testModelName() {
        val modelName = client.modelName.also { LOG.info("modelName=$it") }
        Assertions.assertEquals(fmu.modelName, modelName)
    }

    @Test
    fun testFMUSupportedTypes() {
        Assertions.assertFalse(client.supportsModelExchange)
        Assertions.assertTrue(client.supportsCoSimulation)
    }

    @Test
    fun testInstance() {

        client.newInstance().use { instance ->

            val temp = client.modelDescription.modelVariables
                    .getByName("Temperature_Room").asRealVariable()

            val stop = 2.0
            val stepSize = 1E-4
            runInstance(instance, stepSize, stop) {
                temp.read()
            }.also {
                LOG.info("Duration=${it}ms")
            }
        }

    }

}