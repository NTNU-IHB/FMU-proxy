package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.runInstance
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
class TestThriftTorsionBar {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestThriftTorsionBar::class.java)
    }

    private val fmu: Fmu
    private val server: ThriftFmuServer
    private val client: ThriftFmuClient
    private val modelDescription: CommonModelDescription

    init {

        fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/${TestUtils.getOs()}/20sim/4.6.4.8004/TorsionBar/TorsionBar.fmu"))
        modelDescription = fmu.modelDescription

        server = ThriftFmuServer(fmu)
        val port = server.start()

        client = ThriftFmuClient("localhost", port)

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
    fun testGetVariable() {
        val motorDiskRev = client.modelDescription.modelVariables
                .getByName("MotorDiskRev").asRealVariable()
        Assertions.assertEquals(105, motorDiskRev.valueReference)
    }

    @Test
    fun testInstance() {

        client.newInstance().use { instance ->
            val dt = 1E-5
            val stop = 0.1
            val motorDiskRev = client.modelDescription.modelVariables
                    .getByName("MotorDiskRev").asRealVariable()
            runInstance(instance, dt, stop) {
                motorDiskRev.read()
            }.also {
                LOG.info("Duration=${it}ms")
            }
        }

    }

}