/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology (NTNU)
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

package no.ntnu.ihb.fmuproxy.web.fmu

import no.ntnu.ihb.fmi4j.modeldescription.parser.ModelDescriptionParser
import java.io.Serializable
import java.net.InetAddress
import javax.faces.bean.ManagedBean

/**
 * Represents a remote FMU-proxy
 *
 * @author Lars Ivar Hatledal
 */
@ManagedBean
class RemoteProxy(
        val uuid: String,
        private val ports: Map<String, Int>,
        modelDescriptions: List<String>
): Serializable {

    var host: String? = null
        set(value) {
            field = if (value != "127.0.0.1") {
                value
            } else {
                InetAddress.getLocalHost().hostAddress
            }
        }

    val fmus: List<RemoteFmu> by lazy {
        modelDescriptions.map {
            RemoteFmu(host!!, ports, ModelDescriptionParser.parse(it))
        }
    }

    override fun toString(): String {
        return "RemoteProxy(uuid='$uuid', numFmus='${fmus.size}', host=$host, ports=$ports)"
    }

}