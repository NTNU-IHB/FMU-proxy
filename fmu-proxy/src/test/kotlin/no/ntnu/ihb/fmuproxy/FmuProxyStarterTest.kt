package no.ntnu.ihb.fmuproxy

import info.laht.yajrpc.RpcParams
import info.laht.yajrpc.net.tcp.RpcTcpClient
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class FmuProxyStarterTest {

    @Test
    fun test() {

        val fmuFile = File(
            "../test/fmus/2.0/cs/20sim/" +
                    "4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"
        )
        assert(fmuFile.exists())

        val port = 9090
        FmuProxyStarter.debugMain(
            arrayOf("$port")
        )

        RpcTcpClient("localhost", port).use { client ->
            val fmuPort = client.write(
                "createLocalFileProxy", RpcParams.listParams(fmuFile.absolutePath), 5000
            ).get().getResult<Int>()!!

            ThriftFmuClient.socketClient("localhost", fmuPort).use {
                Assertions.assertEquals("ControlledTemperature", it.modelDescription.modelName)
                it.newInstance().use { slave ->
                    slave.setupExperiment()
                }
            }

        }

    }

}
