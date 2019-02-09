package no.ntnu.ihb.fmuproxy.grpc

import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Test
import java.io.File

class LoadFmuTest {

    @Test
    fun test() {

        val url = File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/" +
                        "ControlledTemperature.fmu").toURI().toURL()

        GrpcFmuServer().use { server ->
            val port = server.start()
            GrpcFmuClient("localhost", port).load(url).use {
                it.newInstance().use { slave ->
                    slave.simpleSetup()
                }

            }

        }

    }

}