package no.mechatronics.sfi.rmu.json_rpc

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.RpcClient
import info.laht.yaj_rpc.net.http.RpcHttpClient
import info.laht.yaj_rpc.net.tcp.RpcTcpClient
import info.laht.yaj_rpc.net.ws.RpcWebSocketClient
import info.laht.yaj_rpc.net.zmq.RpcZmqClient
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.rmu.Rmu
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class TestJsonRpcClients {

    private val wsPort = 8001
    private val tcpPort = 8002
    private val zmqPort = 8003
    private val httpPort = 8004

    @Before
    fun setup() {

        val url = javaClass.classLoader.getResource("PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)
        val fmuFile = FmuFile(File(url.file))

        val args = arrayOf(
                "-wsPort", "$wsPort",
                "-tcpPort", "$tcpPort",
                "-httpPort", "$httpPort",
                "-zmqPort", "$zmqPort"
        )

        Rmu.create(args, fmuFile)

    }

    private fun invokeGetModelName(client: RpcClient): String {
        return client.write("FmuService.getModelName").getResult(String::class.java)!!
    }

    @Test
    fun testClients() {

        val clients = listOf(
                RpcWebSocketClient("localhost", wsPort),
                RpcTcpClient("localhost", tcpPort),
                RpcHttpClient("localhost", httpPort),
                RpcZmqClient("localhost", zmqPort)
        )

        clients.forEach {
            it.use {
                LOG.info("Testing client of type ${it.javaClass.simpleName}")
                Assert.assertEquals("PumpControlledWinch", invokeGetModelName(it))
            }
        }


    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(TestJsonRpcClients::class.java)
    }

}