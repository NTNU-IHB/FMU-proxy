package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.importer.fmi1.Fmu
import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TestFmi1 {

    private val port = 9090
    private val fmuFile = File(TestUtils.getTEST_FMUs(), "1.0/identity.fmu")
    private val md = Fmu.from(fmuFile).use {
        it.modelDescription
    }

    init {
        FmuProxyStarter.debugMain(arrayOf("$port"))
    }

    @Test
    fun testFmi1() {
        ThriftFmuClient("localhost", port).use { client ->
            client.loadFromLocalFile(fmuFile).use { fmu ->
                Assertions.assertEquals(md.modelName, fmu.modelDescription.modelName)
                fmu.newInstance().use { }
            }
        }
    }

}


