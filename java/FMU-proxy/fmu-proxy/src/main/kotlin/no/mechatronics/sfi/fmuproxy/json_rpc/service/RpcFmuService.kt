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

package no.mechatronics.sfi.fmuproxy.json_rpc.service

import info.laht.yaj_rpc.RpcMethod
import info.laht.yaj_rpc.RpcService
import no.mechatronics.sfi.fmi4j.common.*
import no.mechatronics.sfi.fmi4j.fmu.FmiSimulation
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Lars Ivar Hatledal
 */
class RpcFmuService(
        private val fmu: Fmu
) : RpcService {

    override val name = "FmuService"
    private val modelDescription: CommonModelDescription

    val fmiVersion: String
        @RpcMethod
        get() = modelDescription.fmiVersion

    val guid: String
        @RpcMethod
        get() = modelDescription.guid

    val modelName: String
        @RpcMethod
        get() = modelDescription.modelName

    val modelDescriptionXml: String
        @RpcMethod
        get() = fmu.modelDescriptionXml

    init {
        this.modelDescription = fmu.modelDescription
    }

    private fun getFmu(id: Int): FmiSimulation {
        val fmu = Fmus.get(id)
        if (fmu != null) {
            return fmu
        }
        throw IllegalArgumentException("No fmu with id=$id")
    }

    @RpcMethod
    fun createInstanceFromCS(): Int {
        return Fmus.put(fmu.asCoSimulationFmu().newInstance())
    }

    @RpcMethod
    fun isTerminated(fmuId: Int): Boolean {
        return getFmu(fmuId).isTerminated
    }

    @RpcMethod
    fun getCurrentTime(fmuId: Int): Double {
        return getFmu(fmuId).currentTime
    }

    @RpcMethod
    fun init(fmuId: Int): FmiStatus {
        return getFmu(fmuId).let {
            it.init()
            it.lastStatus
        }
    }

    @RpcMethod
    fun init(fmuId: Int, startTime: Double): FmiStatus {
        return getFmu(fmuId).let {
            it.init(startTime)
            it.lastStatus
        }
    }

    @RpcMethod
    fun init(fmuId: Int, startTime: Double, stopTime: Double): FmiStatus {
        return getFmu(fmuId).let {
            it.init(startTime, stopTime)
            it.lastStatus
        }
    }

    @RpcMethod
    fun step(fmuId: Int, stepSize: Double): FmiStatus {
        return getFmu(fmuId).let {
            it.doStep(stepSize)
            it.lastStatus
        }
    }

    @RpcMethod
    fun terminate(fmuId: Int): FmiStatus {
        return getFmu(fmuId).let {
            it.terminate()
            it.lastStatus
        }
    }

    @RpcMethod
    fun reset(fmuId: Int): FmiStatus {
        return getFmu(fmuId).let {
            it.reset()
            it.lastStatus
        }
    }

    @RpcMethod
    fun readInteger(fmuId: Int, name: String): FmuIntegerRead {
        return getFmu(fmuId).variableAccessor.readInteger(name)
    }

    @RpcMethod
    fun readReal(fmuId: Int, name: String): FmuRealRead {
        return getFmu(fmuId).variableAccessor.readReal(name)
    }

    @RpcMethod
    fun readString(fmuId: Int, name: String): FmuStringRead {
        return getFmu(fmuId).variableAccessor.readString(name)
    }

    @RpcMethod
    fun readBoolean(fmuId: Int, name: String): FmuBooleanRead {
        return getFmu(fmuId).variableAccessor.readBoolean(name)
    }

    @RpcMethod
    fun writeInteger(fmuId: Int, name: String, value: Int): FmiStatus {
        return getFmu(fmuId).variableAccessor.writeInteger(name, value)
    }

    @RpcMethod
    fun writeReal(fmuId: Int, name: String, value: Double): FmiStatus {
        return getFmu(fmuId).variableAccessor.writeReal(name, value)
    }

    @RpcMethod
    fun writeString(fmuId: Int, name: String, value: String): FmiStatus {
        return getFmu(fmuId).variableAccessor.writeString(name, value)
    }

    @RpcMethod
    fun writeBoolean(fmuId: Int, name: String, value: Boolean): FmiStatus {
        return getFmu(fmuId).variableAccessor.writeBoolean(name, value)
    }

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(RpcFmuService::class.java)
    }

}
