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

package no.ntnu.ihb.fmuproxy

import java.io.Closeable
import java.net.ServerSocket


/**
 * @author Lars Ivar Hatledal
 */
abstract class FmuProxyServer: Closeable {

    abstract val port: Int
    abstract val simpleName: String

    /**
     * Start the server using some available port
     * @return the port used
     */
    fun start(shutdownSignal: (() -> Unit)? = null): Int {
        return getAvailablePort().also { port ->
            start(port, shutdownSignal)
        }
    }

    /**
     * Start the server using the provided port
     * @param port the port to use
     */
    abstract fun start(port: Int, shutdownSignal: (() -> Unit)? = null)

    /**
     * Stop the server
     */
    abstract fun stop()

    /**
     * Same as stop()
     */
    override fun close() {
        stop()
    }

    /**
     * Finds and returns an available port
     */
    private fun getAvailablePort(): Int {
        return ServerSocket(0).use {
            it.localPort
        }
    }

}
