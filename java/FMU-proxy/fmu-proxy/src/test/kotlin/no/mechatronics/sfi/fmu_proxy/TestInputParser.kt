package no.mechatronics.sfi.fmu_proxy

import no.mechatronics.sfi.fmu_proxy.cli.CommandLineParser_old
import org.junit.Assert
import org.junit.Test
import java.io.File

class TestInputParser {

    @Test
    fun test1() {

        val url = TestInputParser::class.java.classLoader
                .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
        Assert.assertNotNull(url)


        val args = arrayOf(
                "-fmu", "${File(url.file).absolutePath}",
                "-grpc", "8000",
                "-thrift_tcp", "8001",
                "-jsonrpc_http", "8002",
                "-jsonrpc_ws", "8003",
                "-jsonrpc_tcp", "8004"
        )

        CommandLineParser_old.parse(args)?.use {

            it.start()
            println(it.networkInfo)

        }
    }

}