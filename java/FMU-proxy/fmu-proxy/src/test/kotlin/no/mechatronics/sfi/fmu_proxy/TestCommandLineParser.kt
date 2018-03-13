package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmu_proxy.cli.CommandLineParser
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestCommandLineParser {

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(TestCommandLineParser::class.java)

        lateinit var fmuPath: String

        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestCommandLineParser::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)
            fmuPath = url.file

        }

    }

    @Test
    fun test() {

        val args = arrayOf(
                "-fmu", "$fmuPath",
                "--remote", "127.0.0.1:8888",
                "-grpc", "8000",
                "-thrift", "8001",
                "-jsonrpc/http", "8002",
                "-jsonrpc/ws", "8003",
                "-jsonrpc/tcp", "8004",
                "-jsonrpc/zmq", "8005"
        )

        CommandLineParser.parse(args)?.use { proxy ->
            println(proxy.networkInfo)
        }

    }

}