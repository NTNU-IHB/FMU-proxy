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

package no.mechatronics.sfi.rmu

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.util.Scanner
import java.io.IOException

import java.net.ServerSocket
import java.net.InetAddress
import java.net.UnknownHostException

import no.mechatronics.sfi.rmu.grpc.FmuServer
import no.mechatronics.sfi.fmi4j.fmu.FmuFile

/**
 *
 * @author Lars Ivar Hatledal
 */
internal object Main {

    private val LOG: Logger = LoggerFactory.getLogger(Main::class.java)

    private val hostAddress: String
        get() {
            return try {
                InetAddress.getLocalHost().hostAddress
            } catch (ex: UnknownHostException) {
                "127.0.0.1"
            }
        }

    @JvmStatic
    fun main(args: Array<String>) {

        InputParser.parse(args) { remoteAddress: SimpleSocketAddress?, localPort: Int? ->

            try {
                val myPort = localPort ?: ServerSocket(0).use { it.localPort }
                val localAddress = SimpleSocketAddress(hostAddress, myPort)

                val fmuFile = FmuFile(Main::class.java.classLoader.getResource("HydraulicCylinder.fmu")!!)
                val server = FmuServer(fmuFile).apply {
                    addService(HydraulicCylinderService())
                    start(localAddress.port)
                }

                var beat: FmuHeartbeat? = remoteAddress?.let {
                    val remoteFmu = RemoteFmu(server.guid, localAddress, server.modelDescriptionXml)
                    FmuHeartbeat(remoteAddress, remoteFmu).apply { start() }
                }

                println("Press any key to stop the application..")
                Scanner(System.`in`).also {
                    if (it.hasNext()) {
                        println("Key pressed, stopping application..")
                        beat?.stop()
                        server.stop()
                    }
                }


            } catch (ex: Exception) {
                ex.printStackTrace()
            }

        }

    }

}