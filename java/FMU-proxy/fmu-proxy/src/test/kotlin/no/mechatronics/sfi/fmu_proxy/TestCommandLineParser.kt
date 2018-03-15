package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import no.mechatronics.sfi.fmu_proxy.cli.CommandLineParser
import java.io.File
import java.net.MalformedURLException
import java.net.URL


class TestCommandLineParser {

    private val fmuPath = "jar:file:../../../test/HydraulicCylinder.jar!/HydraulicCylinder.fmu"

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(TestCommandLineParser::class.java)

    }

    @Test
    fun testPath() {

        File(fmuPath).let { file ->

            if (file.exists()) {
                FmuFile.from(file)
            } else {
                try {
                    val url = URL(fmuPath)
                    FmuFile.from(url)
                } catch (ex: MalformedURLException) {
                    LOG.error("Interpreted fmuPath as an URL, but an MalformedURLException was thrown", ex)
                    null
                }
            }

        }?.use {

        }

    }

    @Test
    fun test1() {
        CommandLineParser.parse(arrayOf("-h"))
    }

    @Test
    fun test2() {

        var args = arrayOf(
                "--remote", "127.0.0.1:8888",
                "-grpc", "8000",
                "-thrift", "8001",
                "-jsonrpc/http", "8002",
                "-jsonrpc/ws", "8003",
                "-jsonrpc/tcp", "8004",
                "-jsonrpc/zmq", "8005"
        )

        args += arrayOf("-fmu", "$fmuPath")

        println(args.toList())

        CommandLineParser.parse(args)?.use { proxy ->
            println(proxy.networkInfo)
        }

    }


}