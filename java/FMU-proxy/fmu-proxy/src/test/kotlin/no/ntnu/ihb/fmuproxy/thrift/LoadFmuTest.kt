package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Test
import java.io.File

class LoadFmuTest {

    @Test
    fun test() {

        val url = File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/" +
                        "ControlledTemperature.fmu").toURI().toURL()

        ThriftFmuSocketServer().use { server ->
            val port = server.start()
            ThriftFmuClient.socketClient("localhost", port).load(url).use {
                it.newInstance().use { slave ->
                    slave.simpleSetup()
                }
            }

        }

    }

}