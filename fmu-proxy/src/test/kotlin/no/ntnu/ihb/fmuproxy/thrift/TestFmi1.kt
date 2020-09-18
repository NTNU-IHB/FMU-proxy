package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.importer.fmi1.Fmu
import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class TestFmi1 {

    @Test
    fun testFmi1() {
        val fmu = Fmu.from(File(TestUtils.getTEST_FMUs(), "1.0/identity.fmu"))
        val md = fmu.modelDescription
        ThriftFmuSocketServer().apply { addFmu(fmu) }.use { server ->
            ThriftFmuClient.socketClient("localhost", server.start()).load(md.guid).use {

                Assertions.assertEquals(md.modelName, it.modelDescription.modelName)

            }
        }
        fmu.close()
    }

}


