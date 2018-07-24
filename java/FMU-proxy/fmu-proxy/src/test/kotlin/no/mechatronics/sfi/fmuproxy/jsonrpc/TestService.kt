package no.mechatronics.sfi.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.RpcParams
import info.laht.yajrpc.RpcRequestOut
import info.laht.yajrpc.RpcResponse
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.common.FmuRealRead
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.RpcFmuService
import no.mechatronics.sfi.fmuproxy.jsonrpc.service.StepResult
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
class TestService {

    private companion object {
       private val LOG: Logger = LoggerFactory.getLogger(TestService::class.java)
    }

    private val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
            "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
    private val handler = RpcHandler(RpcFmuService(fmu))
    
    @Test
    fun testModelName() {

        val modelName = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.getModelName",
            "params": []
        }
        """.let {
            RpcResponse.fromJson(handler.handle(it)!!)
                    .getResult<String>()
        }

        LOG.info("modelName=$modelName")
        Assertions.assertEquals(fmu.modelDescription.modelName, modelName)

    }

    @Test
    fun testGuid() {

        val guid = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.getGuid",
            "params": null
        }
        """.let {
            RpcResponse.fromJson(handler.handle(it)!!).getResult(String::class.java)
        }

        LOG.info("guid=$guid")
        Assertions.assertEquals(fmu.modelDescription.guid, guid)

    }

    @Test
    fun testModelDescriptionXml() {

        val xml = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.getModelDescriptionXml",
            "params": []
        }
        """.let {
            RpcResponse.fromJson(handler.handle(it)!!)
                    .getResult(String::class.java)!!
        }

        val md = ModelDescriptionParser.parse(xml).asCoSimulationModelDescription()
        LOG.debug("$md")

    }

    @Test
    fun testInstance() {

        val fmuId = RpcRequestOut(
                methodName = "FmuService.createInstanceFromCS",
                params = RpcParams.noParams()
        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(Int::class.java)!!

        val init = RpcRequestOut(
                methodName = "FmuService.init",
                params = RpcParams.listParams(fmuId)
        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(FmiStatus::class.java)!!

        Assertions.assertEquals(FmiStatus.OK, init)

        val currentTimeMsg = RpcRequestOut(
                methodName = "FmuService.getSimulationTime",
                params = RpcParams.listParams(fmuId)
        ).toJson()

        fun currentTime() = currentTimeMsg
                .let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(Double::class.java)!!

        val currentTime = currentTime()
        LOG.info("currentTime=$currentTime")
        Assertions.assertEquals(0.0, currentTime)

        val h = RpcRequestOut(
                methodName = "FmuService.readReal",
                params = RpcParams.listParams(fmuId, "0")
        ).toJson().let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(FmuRealRead::class.java)!!

        LOG.info("h=$h")
        Assertions.assertEquals(1.0, h.value)

        val stepMsg = RpcRequestOut(
                methodName = "FmuService.step",
                params = RpcParams.mapParams("fmuId" to fmuId, "stepSize" to  1E-3)
        ).toJson()

        for (i in 0 until 5) {
            val stepResult = stepMsg
                    .let { RpcResponse.fromJson(handler.handle(it)!!) }
                    .getResult(StepResult::class.java)!!
            Assertions.assertEquals(FmiStatus.OK, stepResult.status)

            LOG.info("currentTime=${currentTime()}")

        }

        val terminateMsg = RpcRequestOut(
                methodName = "FmuService.terminate",
                params = RpcParams.listParams(fmuId)
        ).toJson()

        val status = RpcResponse.fromJson(handler.handle(terminateMsg)!!)
                .getResult(FmiStatus::class.java)!!
        Assertions.assertEquals(FmiStatus.OK, status)

    }

}