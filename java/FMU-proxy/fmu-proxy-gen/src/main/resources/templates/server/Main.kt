/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.fmu_proxy

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.io.File
import java.nio.file.Files
import java.util.Scanner

import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmu_proxy.cli.CommandLineParser
import no.mechatronics.sfi.fmu_proxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmu_proxy.grpc.{{fmuName}}Service


/**
 *
 * @author Lars Ivar Hatledal
 */
object Main {

    private val LOG: Logger = LoggerFactory.getLogger(Main::class.java)

    @JvmStatic
    fun main(args: Array<String>) {

        val url = Main::class.java.classLoader.getResource("{{fmuName}}.fmu")!!

        val temp = Files.createTempDirectory("fmu_proxy").toFile()
        LOG.info("Created temp dir $temp")

        try {

            val fmu = File(temp, "{{fmuName}}.fmu")
            FileUtils.copyURLToFile(url, fmu)

            val args = args + arrayOf("-fmu", fmu.absolutePath)
            CommandLineParser.parse(args)?.also { proxy ->

                proxy.getServer(GrpcFmuServer::class.java)?.addService({{fmuName}}Service())
                proxy.start()

                println("Press any key to exit..")
                if (Scanner(System.`in`).hasNext()) {
                    println("Exiting..")
                }

                proxy.stop()

            }

        } finally {
            if (temp.deleteRecursively()) {
                LOG.info("Deleted $temp")
            }
        }

    }

}