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


package no.mechatronics.sfi.fmu_proxy.net

/**
 * @author Lars Ivar Hatledal
 */
data class SimpleSocketAddress(
        val host: String,
        val port: Int
) {

    companion object {

        @JvmStatic
        fun parse(value: String): SimpleSocketAddress {
            val split = value.split(":")
            if (split.size != 2) {
                error("Wrong address format! Expected 'host:port', was '$value'")
            }

            val host = split[0]
            val port = split[1].toIntOrNull()
                    ?: error("Wrong input format! Unable to create port number from input: $value")
            return SimpleSocketAddress(host, port)
        }

    }

}