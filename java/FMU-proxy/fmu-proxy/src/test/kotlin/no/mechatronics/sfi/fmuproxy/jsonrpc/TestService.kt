package no.mechatronics.sfi.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.RpcParams
import info.laht.yajrpc.RpcRequestOut
import info.laht.yajrpc.RpcResponse
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.common.FmuRealArrayRead
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.common.currentOS
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionImpl
import no.mechatronics.sfi.fmi4j.modeldescription.parser.ModelDescriptionParser
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.StepResult
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestService {

    private companion object {
       private val LOG: Logger = LoggerFactory.getLogger(TestService::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "2.0/cs/$currentOS/20sim/4.6.4.8004/" +
                    "ControlledTemperature/ControlledTemperature.fmu"))

    private val handler = RpcHandler(RpcFmuService(fmu))

    @AfterAll
    fun tearDown() {
        fmu.close()
    }

//    @Test
//    fun testModelDescriptionXml() {
//
//        val xml = """
//        {
//            "jsonrpc": "2.0",
//            "id": 1,
//            "method": "FmuService.getModelDescriptionXml",
//            "params": ["${fmu.guid}"]
//        }
//        """.let {
//            RpcResponse.fromJson(handler.handle(it)!!)
//                    .getResult<String>()!!
//        }
//
//        ModelDescriptionParser.parse(xml).asCoSimulationModelDescription().also {
//            LOG.debug("$it")
//        }
//
//    }

    @Test
    fun testModelDescription() {

        val md = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.getModelDescription",
            "params": ["${fmu.guid}"]
        }
        """.let {
            RpcResponse.fromJson(handler.handle(it)!!)
                    .getResult<ModelDescriptionImpl>()!!
        }

        Assertions.assertEquals(fmu.guid, md.guid)
        Assertions.assertEquals(fmu.modelName, md.modelName)

    }

    @Test
    fun testInstance() {

        val instanceId = RpcRequestOut(
                methodName = "FmuService.createInstanceFromCS",
                params = RpcParams.listParams(fmu.guid)
        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult<String>()!!

        val setupExperiment = RpcRequestOut(
                methodName = "FmuService.setupExperiment",
                params = RpcParams.listParams(instanceId)
        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult<FmiStatus>()!!

        Assertions.assertEquals(FmiStatus.OK, setupExperiment)

        val enterInitializationMode = RpcRequestOut(
                methodName = "FmuService.enterInitializationMode",
                params = RpcParams.listParams(instanceId)
        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult<FmiStatus>()!!

        Assertions.assertEquals(FmiStatus.OK, enterInitializationMode)

        val exitInitializationMode = RpcRequestOut(
                methodName = "FmuService.exitInitializationMode",
                params = RpcParams.listParams(instanceId)
        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult<FmiStatus>()!!

        Assertions.assertEquals(FmiStatus.OK, exitInitializationMode)

        val h = RpcRequestOut(
                methodName = "FmuService.readReal",
                params = RpcParams.listParams(instanceId, listOf(0))
        ).toJson().let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult<FmuRealArrayRead>()!!

        Assertions.assertEquals(0.1, h.value[0])

        val stepMsg = RpcRequestOut(
                methodName = "FmuService.step",
                params = RpcParams.mapParams("instanceId" to instanceId, "stepSize" to  1.0/100)
        ).toJson()

        for (i in 0 until 3) {
            val stepResult = stepMsg
                    .let { RpcResponse.fromJson(handler.handle(it)!!) }
                    .getResult<StepResult>()!!
            Assertions.assertEquals(FmiStatus.OK, stepResult.status)

            LOG.info("simulationTime=${stepResult.simulationTime}")

        }

        val terminateMsg = RpcRequestOut(
                methodName = "FmuService.terminate",
                params = RpcParams.listParams(instanceId)
        ).toJson()

        val status = RpcResponse.fromJson(handler.handle(terminateMsg)!!)
                .getResult<FmiStatus>()!!
        Assertions.assertEquals(FmiStatus.OK, status)

    }

}