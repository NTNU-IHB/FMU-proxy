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
import no.ntnu.ihb.fmuproxy.thrift.InternalFmuServiceImpl
import no.ntnu.ihb.fmuproxy.util.JTextAreaOutputStream
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.BorderLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.io.File
import java.io.PrintStream
import java.util.*
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.SwingUtilities
import kotlin.system.exitProcess


object FmuProxy {

    val LOG: Logger = LoggerFactory.getLogger(FmuProxy::class.java)

    private fun createAndShowFrame(title: String, stopSignal: () -> Unit) {

        val textArea = JTextArea(20, 60).apply {
            isEditable = false
        }

        JTextAreaOutputStream(textArea).also { out ->
            System.setOut(PrintStream(out))
            System.setErr(PrintStream(out))
        }

        SwingUtilities.invokeLater {
            JFrame(title).apply {

                defaultCloseOperation = JFrame.EXIT_ON_CLOSE

                contentPane.apply {
                    layout = BorderLayout()
                    add(
                        JScrollPane(
                            textArea,
                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
                        ),
                        BorderLayout.CENTER
                    )
                }

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

    @JvmStatic
    fun main(args: Array<String>) {

        val port = args[0].toInt()
        val fmuFile = File(args[1])
        val fmu = AbstractFmu.from(fmuFile)

        InternalFmuServiceImpl(port, fmu).apply {

            start()

            Thread {
                println("Press any key to exit..")
                if (Scanner(System.`in`).hasNext()) {
                    println("Exiting..")
                    close()
                    exitProcess(0)
                }
            }.apply { start() }

            createAndShowFrame(fmu.modelName) {
                close()
            }

            while (true) {
                if (!stopped.get()) {
                    Thread.sleep(1000)
                } else {
                    break
                }
            }

            exitProcess(0)

        }

    }

}


