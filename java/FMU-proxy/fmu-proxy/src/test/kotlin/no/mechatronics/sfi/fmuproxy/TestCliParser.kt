package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmuproxy.cli.CommandLineParser
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.net.MalformedURLException
import java.net.URL

private const val fmuPath = "jar:file:../../../test/HydraulicCylinder.jar!/HydraulicCylinder.fmu"

class TestCliParser {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TestCliParser::class.java)
    }

    @Test
    fun testPath() {

        File(fmuPath).let { file ->

            if (file.exists()) {
                Fmu.from(file)
            } else {
                try {
                    Fmu.from(URL(fmuPath))
                } catch (ex: MalformedURLException) {
                    LOG.error("Interpreted fmuPath as an URL, but an MalformedURLException was thrown", ex)
                    null
                }
            }

        }?.close()

    }

    @Test
    fun test() {

        var args1 = arrayOf(
                "--remote", "127.0.0.1:8888",
                "-grpc", "8000")

        var args2 = arrayOf(
                "--remote", "127.0.0.1:8888",
                "-thrift", "8001",
                "-jsonrpc/http", "8002",
                "-jsonrpc/ws", "8003",
                "-jsonrpc/tcp", "8004",
                "-jsonrpc/zmq", "8005"
        )

        args1 += arrayOf("-fmu", "$fmuPath")
        CommandLineParser.parse(args1)?.use { proxy ->

            proxy.start()
            LOG.info("${proxy.networkInfo}")

        }

        args2 += arrayOf("-fmu", "$fmuPath")
        CommandLineParser.parse(args2)?.use { proxy ->

            proxy.start()
            LOG.info("${proxy.networkInfo}")

        }

    }

}