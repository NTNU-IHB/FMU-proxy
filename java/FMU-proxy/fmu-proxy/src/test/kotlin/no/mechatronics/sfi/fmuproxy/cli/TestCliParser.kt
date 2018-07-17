package no.mechatronics.sfi.fmuproxy.cli

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
                "FMI_2.0/CoSimulation/${TestUtils.getOs()}/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu")

    }

    @Test
    fun test1() {

        var args1 = arrayOf(
                "--remote", "127.0.0.1:8888",
                "-grpc", "8000")

        args1 += arrayOf("--fmu", "${fmuPath.absolutePath}")
        CommandLineParser.parse(args1)?.use { proxy ->

            proxy.start()
            LOG.info("${proxy.networkInfo}")

        }
    }

    @Test
    fun test2() {

        var args2 = arrayOf(
                "--remote", "127.0.0.1:8888",
                "-thrift", "8001",
                "-jsonrpc/http", "8002",
                "-jsonrpc/ws", "8003",
                "-jsonrpc/tcp", "8004",
                "-jsonrpc/zmq", "8005"
        )

        args2 += arrayOf("-fmu", "$fmuPath")
        CommandLineParser.parse(args2)?.use { proxy ->

            proxy.start()
            LOG.info("${proxy.networkInfo}")

        }

    }

}