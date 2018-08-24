package no.mechatronics.sfi.fmuproxy.cli

import no.mechatronics.sfi.fmi4j.common.currentOS
import no.mechatronics.sfi.fmuproxy.TestUtils
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestCliParser {

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestCliParser::class.java)

        private val fmuPath = File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/$currentOS" +
                        "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    }

    @Test
    fun test() {

        var args = arrayOf("${fmuPath.absolutePath}")
        CommandLineParser.parse(args)?.use { proxy ->
            proxy.start()
        }
    }

}