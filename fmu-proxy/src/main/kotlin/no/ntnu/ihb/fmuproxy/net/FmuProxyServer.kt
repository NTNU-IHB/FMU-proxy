/*
 * The MIT License
 *
 * Copyright 2017. Norwegian University of Technology
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

package no.ntnu.ihb.fmuproxy.net

import no.ntnu.ihb.fmi4j.importer.AbstractFmu
import java.io.Closeable
import java.net.ServerSocket


/**
 * @author Lars Ivar Hatledal
 */
interface FmuProxyServer: Closeable {

    val port: Int

    val simpleName: String

    /**
     * Start the server using some available port
     * @return the port used
     */
    @JvmDefault
    fun start(): Int {
        return getAvailablePort().also {
            start(it)
        }
    }

    /**
     * Start the server using the provided port
     * @param port the port to use
     */
    fun start(port: Int)


    /**
     * Stop the server
     */
    fun stop()

    /**
     * Same as stop()
     */
    @JvmDefault
    override fun close() {
        stop()
    }

    fun addFmu(fmu: AbstractFmu)

    fun removeFmu(fmu: AbstractFmu)

    /**
     * Finds and returns an available port
     */
    fun getAvailablePort(): Int {
        return ServerSocket(0).use {
            it.localPort
        }
    }

}
