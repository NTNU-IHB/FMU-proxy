package no.mechatronics.sfi.rmu

import com.google.gson.GsonBuilder
import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.RpcResponseImpl
import no.mechatronics.sfi.fmi4j.common.FmuRealRead
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestService {

    val handler = RpcHandler()
    lateinit var service: FmuService

    val gson = GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()

    @Before
    fun setup() {
        val url = javaClass.classLoader.getResource("PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)

        service = FmuService(FmuFile(url))
        handler.addService(service)

    }

    @After
    fun tearDown() {
        service.terminateAll()
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


    @Test
    fun testInstance() {

        val fmuId = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.createInstanceFromCS",
            "params": []
        }
        """.let {
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(String::class.java)
        }

        val init = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.init",
            "params": [$fmuId]
        }
        """.let {
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(Boolean::class.java)
        }

        Assert.assertTrue(init!!)

        val currentTimeMsg = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.getCurrentTime",
            "params": [$fmuId]
        }
        """

        val currentTime = currentTimeMsg.let {
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(Int::class.java)
        }

        println("currentTime=$currentTime")
        Assert.assertEquals(0, currentTime)

        val controller_K = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.readReal",
            "params": [$fmuId, "Controller.K"]
        }
        """.let {
            gson.fromJson(handler.handle(it), RpcResponseImpl::class.java).getResult(FmuRealRead::class.java)!!
        }

        println("Controller.K=$controller_K")
        Assert.assertEquals(10.0, controller_K.value, 0.0)

        val stepMsg = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.step",
            "params": [$fmuId, "1E-3"]
        }
        """

        for (i in 0 until 5) {
            val status = gson.fromJson(handler.handle(stepMsg), RpcResponseImpl::class.java).getResult(Boolean::class.java)!!
            Assert.assertTrue(status)

            println("currentTime=${gson.fromJson(handler.handle(currentTimeMsg), RpcResponseImpl::class.java).getResult(Double::class.java)!!}")

        }

        val terminateMsg = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "FmuService.terminate",
            "params": [$fmuId]
        }
        """
        val status = gson.fromJson(handler.handle(terminateMsg), RpcResponseImpl::class.java).getResult(Boolean::class.java)!!
        Assert.assertTrue(status)

    }

}