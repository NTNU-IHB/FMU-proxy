/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
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

package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.BootServiceImpl
import java.util.*
import kotlin.concurrent.thread
import kotlin.system.exitProcess

object FmuProxyBooter {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.size != 1) throw IllegalArgumentException("Expected a single input argument: port!")
        val port = args[0].toIntOrNull() ?: throw IllegalArgumentException("Unable to parse port!")

        BootServiceImpl(port).apply {

            start()

            thread(start = true) {
                println("[Booter] Press any key to exit..")
                if (Scanner(System.`in`).hasNext()) {
                    println("[Booter] Exiting..")
                    close()
                    exitProcess(0)
                }
            }

            while (true) {
                if (!stopped.get()) { //wait for shutdown()
                    Thread.sleep(100)
                } else {
                    break
                }
            }

            exitProcess(0)

        }

    }

}
