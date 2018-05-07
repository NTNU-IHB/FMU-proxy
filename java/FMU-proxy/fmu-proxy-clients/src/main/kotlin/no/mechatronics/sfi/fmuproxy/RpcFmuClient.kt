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
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable


abstract class RpcFmuClient: Closeable {

    protected companion object {

        val LOG: Logger = LoggerFactory.getLogger(RpcFmuClient::class.java)

        internal object FmuInstances: ArrayList<FmuInstance>() {
            internal fun terminateAll() {
                forEach{ it.terminate() }
            }
        }
    }

    abstract val modelDescriptionXml: String
    abstract val modelDescription: CommonModelDescription

    protected abstract fun getCurrentTime(fmuId: Int): Double
    protected abstract fun isTerminated(fmuId: Int): Boolean
    protected abstract fun init(fmuId: Int, start: Double, stop: Double): FmiStatus
    protected abstract fun terminate(fmuId: Int): FmiStatus
    protected abstract fun step(fmuId: Int, stepSize: Double): FmiStatus
    protected abstract fun reset(fmuId: Int): FmiStatus

    internal abstract fun readInteger(fmuId: Int, vr: ValueReference): FmuIntegerRead
    internal abstract fun bulkReadInteger(fmuId: Int, vr: List<Int>): FmuIntegerArrayRead

    internal abstract fun readReal(fmuId: Int, vr: ValueReference): FmuRealRead
    internal abstract fun bulkReadReal(fmuId: Int, vr: List<Int>): FmuRealArrayRead

    internal abstract fun readString(fmuId: Int, vr: ValueReference): FmuStringRead
    internal abstract fun bulkReadString(fmuId: Int, vr: List<Int>): FmuStringArrayRead

    internal abstract fun readBoolean(fmuId: Int, vr: ValueReference): FmuBooleanRead
    internal abstract fun bulkReadBoolean(fmuId: Int, vr: List<Int>): FmuBooleanArrayRead

    internal abstract fun writeInteger(fmuId: Int, vr: ValueReference, value: Int): FmiStatus
    internal abstract fun bulkWriteInteger(fmuId: Int, vr: List<Int>, value: List<Int>): FmiStatus

    internal abstract fun writeReal(fmuId: Int, vr: ValueReference, value: Real): FmiStatus
    internal abstract fun bulkWriteReal(fmuId: Int, vr: List<Int>, value: List<Real>): FmiStatus

    internal abstract fun writeString(fmuId: Int, vr: ValueReference, value: String): FmiStatus
    internal abstract fun bulkWriteString(fmuId: Int, vr: List<Int>, value: List<String>): FmiStatus

    internal abstract fun writeBoolean(fmuId: Int, vr: ValueReference, value: Boolean): FmiStatus
    internal abstract fun bulkWriteBoolean(fmuId: Int, vr: List<Int>, value: List<Boolean>): FmiStatus

    protected abstract fun createInstanceFromCS(): Int
    protected abstract fun createInstanceFromME(integrator: IntegratorSettings): Int

    @JvmOverloads
    fun newInstance(integrator: IntegratorSettings? = null): FmuInstance {
        val fmuId = if(integrator == null) {
            createInstanceFromCS()
        } else {
            createInstanceFromME(integrator)
        }
        return FmuInstance(fmuId).also {
            FmuInstances.add(it)
        }
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

        val variableAccessor: FmuVariableAccessor
                = VariableAccessorImpl(fmuId, this@RpcFmuClient)

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

    }

}

class VariableAccessorImpl(
        private val fmuId: Int,
        private val client: RpcFmuClient
): FmuVariableAccessor {

    override fun readBoolean(name: String) = client.readBoolean(fmuId, process(name))

    override fun readBoolean(vr: ValueReference) = client.readBoolean(fmuId, vr)

    override fun readBoolean(vr: ValueReferences) = client.bulkReadBoolean(fmuId, vr.toList())

    override fun readBoolean(vr: ValueReferences, value: BooleanArray): FmuBooleanArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readBoolean(vr: ValueReferences, value: IntArray): FmuIntegerArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readInteger(name: String) = client.readInteger(fmuId, process(name))

    override fun readInteger(vr: ValueReference) = client.readInteger(fmuId, vr)

    override fun readInteger(vr: ValueReferences) = client.bulkReadInteger(fmuId, vr.toList())

    override fun readInteger(vr: ValueReferences, value: IntArray): FmuIntegerArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readReal(name: String) = client.readReal(fmuId, process(name))

    override fun readReal(vr: ValueReference) = client.readReal(fmuId, vr)

    override fun readReal(vr: ValueReferences) = client.bulkReadReal(fmuId, vr.toList())

    override fun readReal(vr: ValueReferences, value: RealArray): FmuRealArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readString(name: String) = client.readString(fmuId, process(name))

    override fun readString(vr: ValueReference) = client.readString(fmuId, vr)

    override fun readString(vr: ValueReferences) = client.bulkReadString(fmuId, vr.toList())

    override fun readString(vr: ValueReferences, value: StringArray): FmuStringArrayRead {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeBoolean(name: String, value: Boolean) = client.writeBoolean(fmuId, process(name), value)

    override fun writeBoolean(vr: ValueReference, value: Boolean) = client.writeBoolean(fmuId, vr, value)

    override fun writeBoolean(vr: ValueReferences, value: BooleanArray) = client.bulkWriteBoolean(fmuId, vr.toList(), value.toList())

    override fun writeBoolean(vr: ValueReferences, value: IntArray) = client.bulkWriteBoolean(fmuId, vr.toList(), value.map { it != 0 })

    override fun writeInteger(name: String, value: Int) = client.writeInteger(fmuId, process(name), value)

    override fun writeInteger(vr: ValueReference, value: Int) = client.writeInteger(fmuId, vr, value)

    override fun writeInteger(vr: ValueReferences, value: IntArray) = client.bulkWriteInteger(fmuId, vr.toList(), value.toList())

    override fun writeReal(name: String, value: Real) = client.writeReal(fmuId, process(name), value)

    override fun writeReal(vr: ValueReference, value: Real) = client.writeReal(fmuId, vr, value)

    override fun writeReal(vr: ValueReferences, value: RealArray) = client.bulkWriteReal(fmuId, vr.toList(), value.toList())

    override fun writeString(name: String, value: String) = client.writeString(fmuId, process(name), value)

    override fun writeString(vr: ValueReference, value: String) = client.writeString(fmuId, vr, value)

    override fun writeString(vr: ValueReferences, value: StringArray) = client.bulkWriteString(fmuId, vr.toList(), value.toList())

    private fun process(name: String): Int {
        return NAME_TO_VALUE_REF.getOrPut(name, {
            client.modelDescription.modelVariables.getValueReference(name)
        })
    }

    private companion object {
        val NAME_TO_VALUE_REF = mutableMapOf<String, Int>()
    }

}
