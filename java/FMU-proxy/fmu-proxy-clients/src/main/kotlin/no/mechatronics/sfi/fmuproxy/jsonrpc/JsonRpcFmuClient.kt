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

package no.mechatronics.sfi.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcParams
import info.laht.yajrpc.net.RpcClient
import no.mechatronics.sfi.fmi4j.common.*
import java.io.Closeable

class JsonRpcFmuClient(
        val client: RpcClient
): Closeable {

    private var terminateSent = false

    private val fmuId: Int
            = client.write("FmuService.createInstanceFromCS")
            .getResult(Int::class.java)!!

    val fmiVersion: String by lazy {
        client.write("FmuService.getFmiVersion")
                .getResult(String::class.java)!!
    }

    val modelName: String by lazy {
        client.write("FmuService.getModelName")
                .getResult(String::class.java)!!
    }

    val guid: String by lazy {
        client.write("FmuService.getGuid")
                .getResult(String::class.java)!!
    }

    val currentTime: Double
        get() = client.write("FmuService.getCurrentTime", RpcParams.listParams(fmuId))
                .getResult(Double::class.java)!!


    fun init(): FmiStatus {
        return client.write("FmuService.init", RpcParams.listParams(fmuId))
                .getResult(FmiStatus::class.java)!!
    }

    fun init(start: Double): FmiStatus {
        return client.write("FmuService.init", RpcParams.listParams(fmuId, start))
                .getResult(FmiStatus::class.java)!!
    }

    fun step(stepSize: Double): FmiStatus {
        return client.write("FmuService.step", RpcParams.listParams(fmuId, stepSize))
                .getResult(FmiStatus::class.java)!!
    }

    /**
     * Resets the FMU
     */
    fun reset(): FmiStatus {
        return client.write("FmuService.reset", RpcParams.listParams(fmuId))
                .getResult(FmiStatus::class.java)!!
    }

    /**
     * Terminates the FMU
     */
    fun terminate(): FmiStatus? {
        if (!terminateSent) {
            terminateSent = true
            return client.write("FmuService.terminate", RpcParams.listParams(fmuId))
                    .getResult(FmiStatus::class.java)!!
        }
        return null
    }

    fun readInteger(name: String): FmuIntegerRead {
        return client.write("FmuService.readInteger", RpcParams.listParams(fmuId, name))
                .getResult(FmuIntegerRead::class.java)!!
    }

    fun readReal(name: String): FmuRealRead {
        return client.write("FmuService.readReal", RpcParams.listParams(fmuId, name))
                .getResult(FmuRealRead::class.java)!!
    }

    fun readString(name: String): FmuStringRead {
        return client.write("FmuService.readString", RpcParams.listParams(fmuId, name))
                .getResult(FmuStringRead::class.java)!!
    }

    fun readBoolean(name: String): FmuBooleanRead {
        return client.write("FmuService.readBoolean", RpcParams.listParams(fmuId, name))
                .getResult(FmuBooleanRead::class.java)!!
    }


    /**
     * Terminates the FMU and closes the client connection
     */
    override fun close() {
        terminate()
        client.close()
    }

}