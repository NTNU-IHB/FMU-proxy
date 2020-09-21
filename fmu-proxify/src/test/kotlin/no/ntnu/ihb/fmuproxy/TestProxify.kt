package no.ntnu.ihb.fmuproxy

import org.junit.jupiter.api.Test
import java.io.File

internal class TestProxify {

    @Test
    fun test() {

        val fmu = File("../test/fmus/1.0/identity.fmu")

        FmuProxifier("localhost", 9090, fmu).build()

    }

}
