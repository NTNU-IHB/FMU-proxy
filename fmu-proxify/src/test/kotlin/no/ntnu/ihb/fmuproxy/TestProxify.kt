package no.ntnu.ihb.fmuproxy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class TestProxify {

    @Test
    fun test() {

        val fmu = File("../test/fmus/1.0/identity.fmu")

        val proxyFmu = FmuProxifier("localhost", 9090, fmu).build()
        Assertions.assertTrue(proxyFmu.exists())
        Assertions.assertEquals("identity-proxy.fmu", proxyFmu.name)

    }

}
