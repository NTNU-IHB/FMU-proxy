package no.mechatronics.sfi.fmu_proxy.json_rpc

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.RpcParams
import info.laht.yaj_rpc.RpcRequestOut
import info.laht.yaj_rpc.RpcResponse
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.common.FmuRealRead
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmu_proxy.json_rpc.service.RpcFmuService
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class TestService {

   companion object {
       
       val LOG: Logger = LoggerFactory.getLogger(TestService::class.java)

       lateinit var handler: RpcHandler
       lateinit var fmuFile: FmuFile

       @JvmStatic
       @BeforeClass
       fun setup() {
           val url = TestService::class.java.classLoader
                   .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
           Assert.assertNotNull(url)
           fmuFile = FmuFile.from(File(url.file))
           handler = RpcHandler(RpcFmuService(fmuFile))
       }
       
   }

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
                    .getResult(String::class.java)
        }

        LOG.info("modelName=$modelName")
        Assert.assertEquals(fmuFile.modelDescription.modelName, modelName)

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
        Assert.assertEquals(fmuFile.modelDescription.guid, guid)

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
            RpcResponse.fromJson(handler.handle(it)!!).getResult(String::class.java)!!
        }

        ModelDescriptionParser.parse(xml).asCoSimulationModelDescription()

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

        Assert.assertTrue(init == FmiStatus.OK)

        val currentTimeMsg = RpcRequestOut(
                methodName = "FmuService.getCurrentTime",
                params = RpcParams.listParams(fmuId)
        ).toJson()

        fun currentTime() = currentTimeMsg
                .let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(Double::class.java)!!

        var currentTime = currentTime()
        LOG.info("currentTime=$currentTime")
        Assert.assertEquals(0.0, currentTime, 0.0)

        val controller_K = RpcRequestOut(
                methodName = "FmuService.readReal",
                params = RpcParams.listParams(fmuId, "Controller.K")
        ).toJson().let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(FmuRealRead::class.java)!!

        LOG.info("Controller.K=$controller_K")
        Assert.assertEquals(10.0, controller_K.value, 0.0)

        val stepMsg = RpcRequestOut(
                methodName = "FmuService.step",
                params = RpcParams.mapParams("fmuId" to fmuId, "stepSize" to  1E-3)
        ).toJson()

        for (i in 0 until 5) {
            val status = stepMsg
                    .let { RpcResponse.fromJson(handler.handle(it)!!) }
                    .getResult(FmiStatus::class.java)!!
            Assert.assertTrue(status == FmiStatus.OK)

            LOG.info("currentTime=${currentTime()}")

        }

        val terminateMsg = RpcRequestOut(
                methodName = "FmuService.terminate",
                params = RpcParams.listParams(fmuId)
        ).toJson()

        val status = RpcResponse.fromJson(handler.handle(terminateMsg)!!)
                .getResult(FmiStatus::class.java)!!
        Assert.assertTrue(status == FmiStatus.OK)

    }

}