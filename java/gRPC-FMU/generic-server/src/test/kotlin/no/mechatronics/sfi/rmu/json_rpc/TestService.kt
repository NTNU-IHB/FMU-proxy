package no.mechatronics.sfi.rmu.json_rpc

import com.google.gson.GsonBuilder
import info.laht.yaj_rpc.*
import no.mechatronics.sfi.fmi4j.common.FmuRealRead
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionImpl
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestService {

    lateinit var handler: RpcHandler
    lateinit var service: FmuService

    private val gson = GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()

    @Before
    fun setup() {
        val url = javaClass.classLoader.getResource("PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)

        service = FmuService(FmuFile(url))
        handler = RpcHandler(service)

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
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(String::class.java)
        }

        println("modelName=$modelName")
        Assert.assertEquals(service.fmuFile.modelDescription.modelName, modelName)

    }

    @Test
    fun testGuid() {

        val guid = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.getGuid",
            "params": []
        }
        """.let {
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(String::class.java)
        }

        println("guid=$guid")
        Assert.assertEquals(service.fmuFile.modelDescription.guid, guid)

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
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(String::class.java)!!
        }

        ModelDescriptionParser.parse(xml).asCoSimulationModelDescription()
        
    }
//
//    @Test
//    fun testModelDescription() {
//
//        val md: SimpleModelDescription = RpcRequestOut(
//                methodName = "FmuService.getModelDescription",
//                params = RpcParams.listParams()
//        ).toJson().let { RpcResponse.fromJson(handler.handle(it)!!) }
//                .getResult(ModelDescriptionImpl::class.java)!!
//
//    }

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
                .getResult(Boolean::class.java)!!

        Assert.assertTrue(init)

        val currentTimeMsg = RpcRequestOut(
                methodName = "FmuService.getCurrentTime",
                params = RpcParams.listParams(fmuId)
        ).toJson()

        fun currentTime() = currentTimeMsg
                .let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(Double::class.java)!!

        var currentTime = currentTime()
        println("currentTime=$currentTime")
        Assert.assertEquals(0.0, currentTime, 0.0)

        val controller_K = RpcRequestOut(
                methodName = "FmuService.readReal",
                params = RpcParams.listParams(fmuId, "Controller.K")
        ).toJson().let{ RpcResponse.fromJson(handler.handle(it)!!) }
                .getResult(FmuRealRead::class.java)!!

        println("Controller.K=$controller_K")
        Assert.assertEquals(10.0, controller_K.value, 0.0)

        val stepMsg = RpcRequestOut(
                methodName = "FmuService.step",
                params = RpcParams.listParams(fmuId, 1E-3)
        ).toJson()

        for (i in 0 until 5) {
            val status = stepMsg
                    .let { RpcResponse.fromJson(handler.handle(it)!!) }
                    .getResult(Boolean::class.java)!!
            Assert.assertTrue(status)

            println("currentTime=${currentTime()}")

        }

        val terminateMsg = RpcRequestOut(
                methodName = "FmuService.terminate",
                params = RpcParams.listParams(fmuId)
        ).toJson()

        val status = RpcResponse.fromJson(handler.handle(terminateMsg)!!).getResult(Boolean::class.java)!!
        Assert.assertTrue(status)

    }

}