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
import no.mechatronics.sfi.fmuproxy.IntegratorSettings
import no.mechatronics.sfi.fmuproxy.RpcFmuClient


class JsonRpcFmuClient(
        val client: RpcClient
): RpcFmuClient() {

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

    override val modelDescriptionXml: String by lazy {
        client.write("FmuService.getModelDescriptionXml")
                .getResult(String::class.java)!!
    }

    /**
     * Terminates the FMU and closes the client connection
     */
    override fun close() {
        super.close()
        client.close()
    }

    override fun isTerminated(fmuId: Int): Boolean {
        return client.write("FmuService.getGuid", RpcParams.listParams(fmuId))
                .getResult(Boolean::class.java)!!
    }

    override fun createInstanceFromCS(): Int {
        return client.write("FmuService.createInstanceFromCS")
                .getResult(Int::class.java)!!
    }

    override fun createInstanceFromME(integrator: IntegratorSettings): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentTime(fmuId: Int): Double {
        return client.write("FmuService.getCurrentTime", RpcParams.listParams(fmuId))
                .getResult(Double::class.java)!!
    }

    override fun init(fmuId: Int, start: Double, stop: Double): FmiStatus {
        return client.write("FmuService.init", RpcParams.listParams(fmuId, start))
                .getResult(FmiStatus::class.java)!!
    }

    override fun step(fmuId: Int, stepSize: Double): FmiStatus {
        return client.write("FmuService.step", RpcParams.listParams(fmuId, stepSize))
                .getResult(FmiStatus::class.java)!!
    }

    /**
     * Resets the FMU
     */
    override fun reset(fmuId: Int): FmiStatus {
        return client.write("FmuService.reset", RpcParams.listParams(fmuId))
                .getResult(FmiStatus::class.java)!!
    }

    /**
     * Terminates the FMU
     */
    override fun terminate(fmuId: Int): FmiStatus {
        return client.write("FmuService.terminate", RpcParams.listParams(fmuId))
                .getResult(FmiStatus::class.java)!!
    }

    override fun readInteger(fmuId: Int, name: String): FmuIntegerRead {
        return client.write("FmuService.readInteger", RpcParams.listParams(fmuId, name))
                .getResult(FmuIntegerRead::class.java)!!
    }

    override fun readReal(fmuId: Int, name: String): FmuRealRead {
        return client.write("FmuService.readReal", RpcParams.listParams(fmuId, name))
                .getResult(FmuRealRead::class.java)!!
    }

    override fun readString(fmuId: Int, name: String): FmuStringRead {
        return client.write("FmuService.readString", RpcParams.listParams(fmuId, name))
                .getResult(FmuStringRead::class.java)!!
    }

    override fun readBoolean(fmuId: Int, name: String): FmuBooleanRead {
        return client.write("FmuService.readBoolean", RpcParams.listParams(fmuId, name))
                .getResult(FmuBooleanRead::class.java)!!
    }

}