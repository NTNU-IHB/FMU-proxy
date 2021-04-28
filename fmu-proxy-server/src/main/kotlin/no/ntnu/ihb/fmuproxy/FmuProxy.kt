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

import no.ntnu.ihb.fmi4j.importer.AbstractFmu
import no.ntnu.ihb.fmuproxy.thrift.FmuServiceImpl
import java.awt.GraphicsEnvironment
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.io.File
import java.util.*
import javax.swing.JFrame
import javax.swing.SwingUtilities
import kotlin.concurrent.thread
import kotlin.system.exitProcess

object FmuProxy {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.size != 2) throw IllegalArgumentException("Expected two input arguments: port fmuPath!")
        val port = args[0].toIntOrNull() ?: throw IllegalArgumentException("Unable to parse port!")
        val fmuFile = File(args[1])

        if (!fmuFile.exists()) throw IllegalArgumentException("No such file: '${fmuFile.absolutePath}'!")
        val fmu = AbstractFmu.from(fmuFile)

        FmuServiceImpl(port, fmu).apply {

            start()

            thread(start = true) {
                println("Press any key to exit..")
                if (Scanner(System.`in`).hasNext()) {
                    println("Exiting..")
                    close()
                    exitProcess(0)
                }
            }

            if (!GraphicsEnvironment.isHeadless()) {
                createAndShowFrame(fmu.modelName) {
                    close()
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

    private fun createAndShowFrame(title: String, stopSignal: () -> Unit) {

        SwingUtilities.invokeLater {
            JFrame(title).apply {

                defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                setSize(250, 0)

                addWindowListener(object : WindowAdapter() {
                    override fun windowClosed(e: WindowEvent) {
                        println("Exiting..")
                        stopSignal.invoke()
                    }
                })

                pack()
                isVisible = true

            }
        }
    }

}
