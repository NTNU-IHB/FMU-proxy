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

package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.common.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable


abstract class RpcFmuClient: Closeable {

    protected companion object {

        val LOG: Logger = LoggerFactory.getLogger(RpcFmuClient::class.java)

        private val nameToVr = mutableMapOf<String, Int>()

        fun resolveToValueReference(client: RpcFmuClient, name: String): Int {
            return nameToVr.getOrPut(name, {
                client.getValueReference(name) ?: throw IllegalArgumentException("No such variable: $name")
            })
        }

        internal object FmuInstances: ArrayList<FmuInstance>() {
            internal fun terminateAll() {
                forEach{ it.terminate() }
            }
        }
    }

    abstract val modelDescriptionXml: String

    protected abstract fun getValueReference(variableName: String): Int?

    protected abstract fun getCurrentTime(fmuId: Int): Double
    protected abstract fun isTerminated(fmuId: Int): Boolean
    protected abstract fun init(fmuId: Int, start: Double, stop: Double): FmiStatus
    protected abstract fun terminate(fmuId: Int): FmiStatus
    protected abstract fun step(fmuId: Int, stepSize: Double): FmiStatus
    protected abstract fun reset(fmuId: Int): FmiStatus

    protected fun readInteger(fmuId: Int, name: String): FmuIntegerRead  {
        return readInteger(fmuId, resolveToValueReference(this, name))
    }

    protected fun readReal(fmuId: Int, name: String): FmuRealRead {
        return readReal(fmuId, resolveToValueReference(this, name))
    }

    protected fun readString(fmuId: Int, name: String): FmuStringRead {
        return readString(fmuId, resolveToValueReference(this, name))
    }

    protected fun readBoolean(fmuId: Int, name: String): FmuBooleanRead {
        return readBoolean(fmuId, resolveToValueReference(this, name))
    }

    protected abstract fun readInteger(fmuId: Int, vr: Int): FmuIntegerRead
    protected abstract fun bulkReadInteger(fmuId: Int, vr: List<Int>): FmuIntegerArrayRead

    protected abstract fun readReal(fmuId: Int, vr: Int): FmuRealRead
    protected abstract fun bulkReadReal(fmuId: Int, vr: List<Int>): FmuRealArrayRead

    protected abstract fun readString(fmuId: Int, vr: Int): FmuStringRead
    protected abstract fun bulkReadString(fmuId: Int, vr: List<Int>): FmuStringArrayRead

    protected abstract fun readBoolean(fmuId: Int, vr: Int): FmuBooleanRead
    protected abstract fun bulkReadBoolean(fmuId: Int, vr: List<Int>): FmuBooleanArrayRead

    protected abstract fun createInstanceFromCS(): Int
    protected abstract fun createInstanceFromME(integrator: IntegratorSettings): Int

    @JvmOverloads
    fun newInstance(integrator: IntegratorSettings? = null): FmuInstance {
        val fmuId = if(integrator == null) {
            createInstanceFromCS()
        } else {
            createInstanceFromME(integrator)
        }
        return FmuInstance(fmuId)
    }

    fun stop() {
        close()
    }

    override fun close() {
        LOG.info("Closing..")
        FmuInstances.terminateAll()
    }

    inner class FmuInstance(
            private val fmuId: Int
    ): Closeable {

        val currentTime: Double
            get() = getCurrentTime(fmuId)

        val isTerminated: Boolean
            get() = isTerminated(fmuId)

        @JvmOverloads
        fun init(start:Double=0.0, stop:Double=-1.0): FmiStatus {
            return init(fmuId, start, stop)
        }

        fun step(stepSize: Double): FmiStatus {
            return step(fmuId, stepSize)
        }

        fun terminate(): FmiStatus {
            return try {
                terminate(fmuId)
            } finally {
                FmuInstances.remove(this)
            }
        }

        fun reset(): FmiStatus {
            return reset(fmuId)
        }

        override fun close() {
            terminate()
        }

        fun readInteger(name: String): FmuIntegerRead {
            return readInteger(fmuId, name)
        }

        fun readReal(vr: Int): FmuRealRead{
            return readReal(fmuId, vr)
        }

        fun readReal(name: String): FmuRealRead{
            return readReal(fmuId, name)
        }

        fun readString(name: String): FmuStringRead{
            return readString(fmuId, name)
        }

        fun readBoolean(vr: Int): FmuBooleanRead {
            return readBoolean(fmuId, vr)
        }

        fun readBoolean(name: String): FmuBooleanRead {
            return readBoolean(fmuId, name)
        }

    }

}
