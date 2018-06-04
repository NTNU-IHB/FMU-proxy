package no.mechatronics.sfi.fmuproxy.avro

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.TEST_FMUs
import no.mechatronics.sfi.fmuproxy.runInstance
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestAvroTorsionBar {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestAvroTorsionBar::class.java)
    }

    private val fmu: Fmu
    private val server: AvroFmuServer
    private val client: AvroFmuClient
    private val modelDescription: CommonModelDescription

    init {

        fmu = Fmu.from(File(TEST_FMUs, "FMI_2.0/CoSimulation/win64/20sim/4.6.4.8004/TorsionBar/TorsionBar.fmu"))
        modelDescription = fmu.modelDescription

        server = AvroFmuServer(fmu)
        val port = server.start()

        client = AvroFmuClient("localhost", port)

    }

    @AfterAll
    fun tearDown() {
        client.close()
        server.close()
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
    fun testInstance() {

        client.newInstance().use { instance ->
            val dt = 1E-3
            val stop = 2.0
            runInstance(instance, dt, stop).also {
                LOG.info("Duration=${it}ms")
            }
        }

    }

}