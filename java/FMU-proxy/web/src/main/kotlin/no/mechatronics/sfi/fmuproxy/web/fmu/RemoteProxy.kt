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

package no.mechatronics.sfi.fmuproxy.web.fmu

import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmi4j.modeldescription.variables.TypedScalarVariable
import java.io.Serializable
import javax.faces.bean.ManagedBean

/**
 * Represents a remote FMU-proxy
 *
 * @author Lars Ivar Hatledal
 */
@ManagedBean
class RemoteProxy(
        val uuid: String,
        val networkInfo: NetworkInfo,
        private val modelDescriptionXmls: List<String>
): Serializable {

    val fmus: List<RemoteFmu> by lazy {
        modelDescriptionXmls.map {
            RemoteFmu(networkInfo, ModelDescriptionParser.parse(it))
        }
    }

    override fun toString(): String {
        return "RemoteFmu(uuid='$uuid', numFmus='${modelDescriptionXmls.size}', networkInfo=$networkInfo)"
    }

}