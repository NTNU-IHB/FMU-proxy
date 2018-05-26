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
import no.mechatronics.sfi.fmi4j.modeldescription.variables.AbstractTypedScalarVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable


abstract class RpcFmuClient: Closeable {

    protected companion object {

        val LOG: Logger = LoggerFactory.getLogger(RpcFmuClient::class.java)

        val NAME_TO_VALUE_REF = mutableMapOf<String, Int>()

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
    protected abstract fun step(fmuId: Int, stepSize: Double): Pair<Double, FmiStatus>
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
    protected abstract fun createInstanceFromME(solver: Solver): Int

    protected fun process(name: String): Int {
        return NAME_TO_VALUE_REF.getOrPut(name, {
            modelDescription.modelVariables.getValueReference(name)
        })
    }

    @JvmOverloads
    fun newInstance(solver: Solver? = null): FmuInstance {
        val fmuId = if(solver == null) {
            createInstanceFromCS()
        } else {
            createInstanceFromME(solver)
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
    ): FmiSimulation, FmuVariableAccessor {

        override val isTerminated: Boolean
            get() = isTerminated(fmuId)

        override val variableAccessor = this

        override var isInitialized = false
            private set

        override var lastStatus = FmiStatus.NONE
        override var currentTime: Double = 0.0

        override val modelDescription
            get() = this@RpcFmuClient.modelDescription

        init {
            currentTime = getCurrentTime(fmuId)
            modelDescription.modelVariables.forEach { variable ->
                if (variable is AbstractTypedScalarVariable<*>) {
                    variable::class.java.getField("accessor").also { field ->
                        field.set(variable, variableAccessor)
                    }
                }
            }
        }

        override fun init() = init(0.0)
        override fun init(start: Double) = init(start, 0.0)
        override fun init(start: Double, stop: Double) {
            init(fmuId, start, stop).also {
                lastStatus = it
                isInitialized = true
            }
        }

        override fun doStep(stepSize: Double): Boolean {
            val stepResult = step(fmuId, stepSize)
            currentTime = stepResult.first
            lastStatus = stepResult.second
            return lastStatus == FmiStatus.OK
        }

        override fun terminate(): Boolean {
            return try {
                terminate(fmuId).also {
                    lastStatus = it
                } == FmiStatus.OK
            } finally {
                FmuInstances.remove(this)
            }
        }

        override fun reset(): Boolean {
            return reset(fmuId).also {
                lastStatus = it
            } == FmiStatus.OK
        }

        override fun close() {
            terminate()
        }

        override fun readBoolean(name: String)
                = readBoolean(fmuId, process(name)).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReference)
                = readBoolean(fmuId, vr).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReferences)
                = bulkReadBoolean(fmuId, vr.toList()).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReferences, value: BooleanArray)
                = bulkReadBoolean(fmuId, vr.toList()).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReferences, value: IntArray)
                = bulkReadInteger(fmuId, vr.toList()).also { lastStatus = it.status }


        override fun readInteger(name: String)
                = readInteger(fmuId, process(name)).also { lastStatus = it.status }

        override fun readInteger(vr: ValueReference)
                = readInteger(fmuId, vr).also { lastStatus = it.status }

        override fun readInteger(vr: ValueReferences)
                = bulkReadInteger(fmuId, vr.toList()).also { lastStatus = it.status }

        override fun readInteger(vr: ValueReferences, value: IntArray)
                = bulkReadInteger(fmuId, vr.toList()).also { lastStatus = it.status }


        override fun readReal(name: String)
                = readReal(fmuId, process(name)).also { lastStatus = it.status }

        override fun readReal(vr: ValueReference)
                = readReal(fmuId, vr).also { lastStatus = it.status }

        override fun readReal(vr: ValueReferences)
                = bulkReadReal(fmuId, vr.toList()).also { lastStatus = it.status }

        override fun readReal(vr: ValueReferences, value: RealArray)
                = bulkReadReal(fmuId, vr.toList()).also { lastStatus = it.status }


        override fun readString(name: String)
                = readString(fmuId, process(name)).also { lastStatus = it.status }

        override fun readString(vr: ValueReference)
                = readString(fmuId, vr).also { lastStatus = it.status }

        override fun readString(vr: ValueReferences)
                = bulkReadString(fmuId, vr.toList()).also { lastStatus = it.status }

        override fun readString(vr: ValueReferences, value: StringArray)
                = bulkReadString(fmuId, vr.toList()).also { lastStatus = it.status }


        override fun writeBoolean(name: String, value: Boolean)
                = writeBoolean(fmuId, process(name), value).also { lastStatus = it }

        override fun writeBoolean(vr: ValueReference, value: Boolean)
                = writeBoolean(fmuId, vr, value).also { lastStatus = it }

        override fun writeBoolean(vr: ValueReferences, value: BooleanArray)
                = bulkWriteBoolean(fmuId, vr.toList(), value.toList()).also { lastStatus = it }

        override fun writeBoolean(vr: ValueReferences, value: IntArray)
                = bulkWriteBoolean(fmuId, vr.toList(), value.map { it != 0 })


        override fun writeInteger(name: String, value: Int)
                = writeInteger(fmuId, process(name), value).also { lastStatus = it }

        override fun writeInteger(vr: ValueReference, value: Int)
                = writeInteger(fmuId, vr, value).also { lastStatus = it }

        override fun writeInteger(vr: ValueReferences, value: IntArray)
                = bulkWriteInteger(fmuId, vr.toList(), value.toList())


        override fun writeReal(name: String, value: Real)
                = writeReal(fmuId, process(name), value).also { lastStatus = it }

        override fun writeReal(vr: ValueReference, value: Real)
                = writeReal(fmuId, vr, value).also { lastStatus = it }

        override fun writeReal(vr: ValueReferences, value: RealArray)
                = bulkWriteReal(fmuId, vr.toList(), value.toList()).also { lastStatus = it }


        override fun writeString(name: String, value: String)
                = writeString(fmuId, process(name), value).also { lastStatus = it }

        override fun writeString(vr: ValueReference, value: String)
                = writeString(fmuId, vr, value).also { lastStatus = it }

        override fun writeString(vr: ValueReferences, value: StringArray)
                = bulkWriteString(fmuId, vr.toList(), value.toList()).also { lastStatus = it }

    }

}
