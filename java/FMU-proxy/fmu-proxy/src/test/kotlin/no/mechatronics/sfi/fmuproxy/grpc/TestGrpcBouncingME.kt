package no.mechatronics.sfi.fmuproxy.grpc

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.Solver
import no.mechatronics.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@EnabledOnOs(OS.WINDOWS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestGrpcBouncingME {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TestGrpcBouncingME::class.java)
    }

    private val fmu: Fmu
    private val server: GrpcFmuServer
    private val client: GrpcFmuClient
    private val modelDescription: CommonModelDescription

    init {

        fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/ModelExchange/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
        modelDescription = fmu.modelDescription

        server = GrpcFmuServer(fmu)
        val port = server.start()

        client = GrpcFmuClient("127.0.0.1", port)

    }

    @AfterAll
    fun tearDown() {
        server.stop()
        client.stop()
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
    fun testInstance() {

        val solver = Solver("Euler").apply {
            addProperty("step_size", 1E-3)
        }

        client.newInstance(solver).use { instance ->

            instance.init()
            Assertions.assertEquals(FmiStatus.OK, instance.lastStatus)

            val h = instance.getVariableByName("h").asRealVariable()

            h.read().also {
                LOG.info("h=${it.value}")
                Assertions.assertEquals(1.0, it.value)
            }

            val dt = 1.0/100
            while (instance.currentTime < 2) {
                val step = instance.doStep(dt)
                Assertions.assertTrue(step)

                LOG.info("h=${h.read()}")

            }

        }

    }

}