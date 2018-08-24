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


abstract class AbstractRpcFmuClient(
        val fmuId: String
): Closeable {

    val fmiVersion: String
        get() = modelDescription.fmiVersion

    val guid: String
        get() = modelDescription.guid

    val modelName: String
        get() = modelDescription.modelName

    val supportsModelExchange: Boolean
        get() = modelDescription.supportsModelExchange

    val supportsCoSimulation: Boolean
        get() = modelDescription.supportsCoSimulation

    abstract val modelDescriptionXml: String
    abstract val modelDescription: CommonModelDescription

    protected abstract fun createInstanceFromCS(): String
    protected abstract fun createInstanceFromME(solver: Solver): String

    protected abstract fun init(instanceId: String, start: Double, stop: Double): FmiStatus
    protected abstract fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus>
    protected abstract fun reset(instanceId: String): FmiStatus
    protected abstract fun terminate(instanceId: String): FmiStatus

    internal fun readInteger(instanceId: String, vr: ValueReference): FmuIntegerRead {
        return readInteger(instanceId, listOf(vr)).let { 
            FmuIntegerRead(it.value[0], it.status)
        }
    }
    internal abstract fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead

    internal fun readReal(instanceId: String, vr: ValueReference): FmuRealRead {
        return readReal(instanceId, listOf(vr)).let {
            FmuRealRead(it.value[0], it.status)
        }
    }
    internal abstract fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead

    internal fun readString(instanceId: String, vr: ValueReference): FmuStringRead {
        return readString(instanceId, listOf(vr)).let {
            FmuStringRead(it.value[0], it.status)
        }
    }
    internal abstract fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead

    internal fun readBoolean(instanceId: String, vr: ValueReference): FmuBooleanRead {
        return readBoolean(instanceId, listOf(vr)).let {
            FmuBooleanRead(it.value[0], it.status)
        }
    }
    internal abstract fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead

    internal fun writeInteger(instanceId: String, vr: ValueReference, value: Int): FmiStatus {
        return writeInteger(instanceId, listOf(vr), listOf(value))
    }
    internal abstract fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus

    internal fun writeReal(instanceId: String, vr: ValueReference, value: Real): FmiStatus {
        return writeReal(instanceId, listOf(vr), listOf(value))
    }
    internal abstract fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus

    internal fun writeString(instanceId: String, vr: ValueReference, value: String): FmiStatus {
        return writeString(instanceId, listOf(vr), listOf(value))
    }
    internal abstract fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus

    internal fun writeBoolean(instanceId: String, vr: ValueReference, value: Boolean): FmiStatus {
        return writeBoolean(instanceId, listOf(vr), listOf(value))
    }
    internal abstract fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus


    internal abstract fun canGetAndSetFMUstate(instanceId: String): Boolean

    internal abstract fun canSerializeFMUstate(instanceId: String): Boolean

    internal abstract fun deSerializeFMUstate(instanceId: String, state: ByteArray):  Pair<FmuState, FmiStatus>

    internal abstract fun freeFMUstate(instanceId: String, state: FmuState):  FmiStatus

    internal abstract fun getFMUstate(instanceId: String):  Pair<FmuState, FmiStatus>

    internal abstract fun serializeFMUstate(instanceId: String, state: FmuState): Pair<ByteArray, FmiStatus>

    internal abstract fun setFMUstate(instanceId: String, state: FmuState): FmiStatus


    protected fun process(name: String): Int {
        return NAME_TO_VALUE_REF.getOrPut(name) {
            modelDescription.modelVariables.getValueReference(name)
        }
    }

    @JvmOverloads
    fun newInstance(solver: Solver? = null): FmuInstance {
        val instanceId = if(solver == null) {
            createInstanceFromCS()
        } else {
            createInstanceFromME(solver)
        }
        return FmuInstance(instanceId).also {
            FmuInstances.add(it)
        }
    }

    override fun close() {
        LOG.debug("Closing..")
        FmuInstances.terminateAll()
    }

    protected companion object {

        private val LOG: Logger = LoggerFactory.getLogger(AbstractRpcFmuClient::class.java)

        private val NAME_TO_VALUE_REF = mutableMapOf<String, Int>()

        internal object FmuInstances: ArrayList<FmuInstance>() {
            internal fun terminateAll() {
                forEach{ it.terminate() }
            }
        }
    }


    inner class FmuInstance(
            private val instanceId: String
    ): FmuSlave, FmuVariableAccessor {

        override var isInitialized = false
            private set

        override var isTerminated = false
            private set

        override var simulationTime: Double = 0.0
        override var lastStatus = FmiStatus.NONE
        override val variableAccessor = this

        override val modelDescription
            get() = this@AbstractRpcFmuClient.modelDescription

        init {

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
            init(instanceId, start, stop).also {
                lastStatus = it
                simulationTime = start
                isInitialized = true
            }
        }

        override fun doStep(stepSize: Double): Boolean {
            val stepResult = step(instanceId, stepSize)
            simulationTime = stepResult.first
            return stepResult.second.let {
                lastStatus = it
                it == FmiStatus.OK
            }
        }

        override fun terminate(): Boolean {
            
            if (!isTerminated) {
                return try {
                    terminate(instanceId).let {
                        lastStatus = it
                        it == FmiStatus.OK
                    }
                } finally {
                    isTerminated = true
                    FmuInstances.remove(this)
                }
            }
            return true
            
        }

        override fun reset(): Boolean {
            return reset(instanceId).let {
                lastStatus = it
                it == FmiStatus.OK
            }
        }

        override fun close() {
            terminate()
        }

        override fun readBoolean(name: String)
                = readBoolean(instanceId, process(name)).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReference)
                = readBoolean(instanceId, vr).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReferences)
                = readBoolean(instanceId, vr.toList()).also { lastStatus = it.status }

        override fun readBoolean(vr: ValueReferences, value: BooleanArray)
                = readBoolean(instanceId, vr.toList()).also { lastStatus = it.status }


        override fun readInteger(name: String)
                = readInteger(instanceId, process(name)).also { lastStatus = it.status }

        override fun readInteger(vr: ValueReference)
                = readInteger(instanceId, vr).also { lastStatus = it.status }

        override fun readInteger(vr: ValueReferences)
                = readInteger(instanceId, vr.toList()).also { lastStatus = it.status }

        override fun readInteger(vr: ValueReferences, value: IntArray)
                = readInteger(instanceId, vr.toList()).also { lastStatus = it.status }


        override fun readReal(name: String)
                = readReal(instanceId, process(name)).also { lastStatus = it.status }

        override fun readReal(vr: ValueReference)
                = readReal(instanceId, vr).also { lastStatus = it.status }

        override fun readReal(vr: ValueReferences)
                = readReal(instanceId, vr.toList()).also { lastStatus = it.status }

        override fun readReal(vr: ValueReferences, value: RealArray)
                = readReal(instanceId, vr.toList()).also { lastStatus = it.status }


        override fun readString(name: String)
                = readString(instanceId, process(name)).also { lastStatus = it.status }

        override fun readString(vr: ValueReference)
                = readString(instanceId, vr).also { lastStatus = it.status }

        override fun readString(vr: ValueReferences)
                = readString(instanceId, vr.toList()).also { lastStatus = it.status }

        override fun readString(vr: ValueReferences, value: StringArray)
                = readString(instanceId, vr.toList()).also { lastStatus = it.status }


        override fun writeBoolean(name: String, value: Boolean)
                = writeBoolean(instanceId, process(name), value).also { lastStatus = it }

        override fun writeBoolean(vr: ValueReference, value: Boolean)
                = writeBoolean(instanceId, vr, value).also { lastStatus = it }

        override fun writeBoolean(vr: ValueReferences, value: BooleanArray)
                = writeBoolean(instanceId, vr.toList(), value.toList()).also { lastStatus = it }


        override fun writeInteger(name: String, value: Int)
                = writeInteger(instanceId, process(name), value).also { lastStatus = it }

        override fun writeInteger(vr: ValueReference, value: Int)
                = writeInteger(instanceId, vr, value).also { lastStatus = it }

        override fun writeInteger(vr: ValueReferences, value: IntArray)
                = writeInteger(instanceId, vr.toList(), value.toList())


        override fun writeReal(name: String, value: Real)
                = writeReal(instanceId, process(name), value).also { lastStatus = it }

        override fun writeReal(vr: ValueReference, value: Real)
                = writeReal(instanceId, vr, value).also { lastStatus = it }

        override fun writeReal(vr: ValueReferences, value: RealArray)
                = writeReal(instanceId, vr.toList(), value.toList()).also { lastStatus = it }


        override fun writeString(name: String, value: String)
                = writeString(instanceId, process(name), value).also { lastStatus = it }

        override fun writeString(vr: ValueReference, value: String)
                = writeString(instanceId, vr, value).also { lastStatus = it }

        override fun writeString(vr: ValueReferences, value: StringArray)
                = writeString(instanceId, vr.toList(), value.toList()).also { lastStatus = it }

        override val canGetAndSetFMUstate: Boolean
            get() = canGetAndSetFMUstate(instanceId)

        override val canSerializeFMUstate: Boolean
            get() = canSerializeFMUstate(instanceId)

        override fun deSerializeFMUstate(state: ByteArray) = deSerializeFMUstate(instanceId, state).let {
            lastStatus = it.second
            it.first
        }

        override fun freeFMUstate(state: FmuState) = freeFMUstate(instanceId, state).let {
            lastStatus = it
            it == FmiStatus.OK
        }

        override fun getFMUstate() = getFMUstate(instanceId).let {
            lastStatus = it.second
            it.first
        }

        override fun serializeFMUstate(state: FmuState) = serializeFMUstate(instanceId, state).let {
            lastStatus = it.second
            it.first
        }

        override fun setFMUstate(state: FmuState) = setFMUstate(instanceId, state).let {
            lastStatus = it
            it == FmiStatus.OK
        }
    }

}
