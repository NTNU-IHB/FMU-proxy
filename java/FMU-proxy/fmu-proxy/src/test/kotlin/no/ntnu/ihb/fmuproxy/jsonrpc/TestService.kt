package no.ntnu.ihb.fmuproxy.jsonrpc

import info.laht.yajrpc.*
import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.common.FmuRealArrayRead
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.common.currentOS
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionImpl
import no.ntnu.ihb.fmi4j.modeldescription.parser.ModelDescriptionParser
import no.ntnu.sfi.fmuproxy.TestUtils
import no.ntnu.ihb.fmuproxy.jsonrpc.service.RpcFmuService
import no.ntnu.ihb.fmuproxy.jsonrpc.service.StepResult
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
class TestService {

    private companion object {
       private val LOG: Logger = LoggerFactory.getLogger(TestService::class.java)

        private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "2.0/cs/$currentOS/20sim/4.6.4.8004/" +
                        "ControlledTemperature/ControlledTemperature.fmu"))

        private val handler = RpcHandler(RpcFmuService(fmu))

    }

    @AfterAll
    fun tearDown() {
        fmu.close()
    }

    @Test
    fun testModelDescription() {

        val md = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "getModelDescription",
            "params": ["${fmu.guid}"]
        }
        """.let {
            YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!)
                    .getResult<ModelDescriptionImpl>()!!
        }

        Assertions.assertEquals(fmu.guid, md.guid)
        Assertions.assertEquals(fmu.modelName, md.modelName)

    }

    @Test
    fun testInstance() {

        val instanceId = RpcRequestOut(
                methodName = "createInstanceFromCS",
                params = RpcParams.listParams(fmu.guid)
        ).toJson().let { YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!) }
                .getResult<String>()!!

        val setupExperiment = RpcRequestOut(
                methodName = "setupExperiment",
                params = RpcParams.listParams(instanceId)
        ).toJson().let { YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!) }
                .getResult<FmiStatus>()!!

        Assertions.assertEquals(FmiStatus.OK, setupExperiment)

        val enterInitializationMode = RpcRequestOut(
                methodName = "enterInitializationMode",
                params = RpcParams.listParams(instanceId)
        ).toJson().let { YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!) }
                .getResult<FmiStatus>()!!

        Assertions.assertEquals(FmiStatus.OK, enterInitializationMode)

        val exitInitializationMode = RpcRequestOut(
                methodName = "exitInitializationMode",
                params = RpcParams.listParams(instanceId)
        ).toJson().let { YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!) }
                .getResult<FmiStatus>()!!

        Assertions.assertEquals(FmiStatus.OK, exitInitializationMode)

        val h = RpcRequestOut(
                methodName = "readReal",
                params = RpcParams.listParams(instanceId, listOf(0))
        ).toJson().let{ YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!) }
                .getResult<FmuRealArrayRead>()!!

        Assertions.assertEquals(0.1, h.value[0])

        val stepSize = 1.0/100
        val stepMsg = RpcRequestOut(
                methodName = "doStep",
                params = RpcParams.mapParams("instanceId" to instanceId, "stepSize" to  stepSize)
        ).toJson()

        for (i in 0 until 3) {
            val stepResult = stepMsg
                    .let { YAJRPC.fromJson<RpcResponse>(handler.handle(it)!!) }
                    .getResult<StepResult>()!!
            Assertions.assertEquals(FmiStatus.OK, stepResult.status)

            LOG.info("simulationTime=${stepResult.simulationTime}")

        }

        val terminateMsg = RpcRequestOut(
                methodName = "terminate",
                params = RpcParams.listParams(instanceId)
        ).toJson()

        val status = YAJRPC.fromJson<RpcResponse>(handler.handle(terminateMsg)!!)
                .getResult<FmiStatus>()!!
        Assertions.assertEquals(FmiStatus.OK, status)

    }

}