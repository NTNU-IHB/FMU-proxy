package no.ntnu.ihb.fmuproxy.cli

import no.ntnu.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class TestCliParser {

    private companion object {

        private val fmuPath = File(TestUtils.getTEST_FMUs(),
                "2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    }

    @Test
    fun test() {

        var args = arrayOf("${fmuPath.absolutePath}")
        CommandLineParser.parse(args)?.use { proxy ->
            proxy.start()
        }
    }

}