package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.importer.Fmu
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
class TestThriftTemperature {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestThriftTemperature::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"))

    private val server = ThriftFmuSocketServer(fmu)
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