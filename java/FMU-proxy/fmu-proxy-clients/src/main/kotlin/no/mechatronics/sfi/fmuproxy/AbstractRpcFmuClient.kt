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
import no.mechatronics.sfi.fmi4j.importer.misc.FmuVariableAccessorImpl
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.cs.CoSimulationModelDescription
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

    abstract val supportsModelExchange: Boolean
    abstract val supportsCoSimulation: Boolean

    abstract val modelDescription: ModelDescription
    abstract val coSimulationModelDescription: CoSimulationModelDescription

    protected abstract fun createInstanceFromCS(): String
    protected abstract fun createInstanceFromME(solver: Solver): String

    protected abstract fun init(instanceId: String, start: Double, stop: Double): FmiStatus
    protected abstract fun step(instanceId: String, stepSize: Double): Pair<Double, FmiStatus>
    protected abstract fun reset(instanceId: String): FmiStatus
    protected abstract fun terminate(instanceId: String): FmiStatus

    internal abstract fun readInteger(instanceId: String, vr: List<ValueReference>): FmuIntegerArrayRead
    internal abstract fun readReal(instanceId: String, vr: List<ValueReference>): FmuRealArrayRead
    internal abstract fun readString(instanceId: String, vr: List<ValueReference>): FmuStringArrayRead
    internal abstract fun readBoolean(instanceId: String, vr: List<ValueReference>): FmuBooleanArrayRead

    internal abstract fun writeInteger(instanceId: String, vr: List<ValueReference>, value: List<Int>): FmiStatus
    internal abstract fun writeReal(instanceId: String, vr: List<ValueReference>, value: List<Real>): FmiStatus
    internal abstract fun writeString(instanceId: String, vr: List<ValueReference>, value: List<String>): FmiStatus
    internal abstract fun writeBoolean(instanceId: String, vr: List<ValueReference>, value: List<Boolean>): FmiStatus

    internal abstract fun canGetAndSetFMUstate(instanceId: String): Boolean
    internal abstract fun canSerializeFMUstate(instanceId: String): Boolean

    internal abstract fun getFMUstate(instanceId: String):  Pair<FmuState, FmiStatus>
    internal abstract fun setFMUstate(instanceId: String, state: FmuState): FmiStatus
    internal abstract fun freeFMUstate(instanceId: String, state: FmuState):  FmiStatus

    internal abstract fun serializeFMUstate(instanceId: String, state: FmuState): Pair<ByteArray, FmiStatus>
    internal abstract fun deSerializeFMUstate(instanceId: String, state: ByteArray):  Pair<FmuState, FmiStatus>


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

        internal object FmuInstances: ArrayList<FmuInstance>() {
            internal fun terminateAll() {
                forEach{ it.terminate() }
            }
        }
    }



    inner class FmuInstance(
            private val instanceId: String
    ): FmuSlave  {

        override var isInitialized = false
            private set

        override var isTerminated = false
            private set

        override var simulationTime: Double = 0.0
        override var lastStatus = FmiStatus.NONE

        override val modelDescription
            get() = this@AbstractRpcFmuClient.coSimulationModelDescription

        override val variableAccessor: FmuVariableAccessor by lazy {
            FmuVariableAccessorImpl(RemoteVariableAccessor()) {modelDescription.modelVariables.getByName(it).valueReference}
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

        override fun cancelStep(): Boolean {
            throw UnsupportedOperationException("cancelStep is not supported!")
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

        override fun getFMUstate() = getFMUstate(instanceId).let {
            lastStatus = it.second
            it.first
        }

        override fun setFMUstate(state: FmuState) = setFMUstate(instanceId, state).let {
            lastStatus = it
            it == FmiStatus.OK
        }

        override fun freeFMUstate(state: FmuState) = freeFMUstate(instanceId, state).let {
            lastStatus = it
            it == FmiStatus.OK
        }


        override fun serializeFMUstate(state: FmuState) = serializeFMUstate(instanceId, state).let {
            lastStatus = it.second
            it.first
        }

        override fun deSerializeFMUstate(state: ByteArray) = deSerializeFMUstate(instanceId, state).let {
            lastStatus = it.second
            it.first
        }

        override fun getDirectionalDerivative(
                vUnknownRef: IntArray, vKnownRef: IntArray, dvKnown: RealArray): RealArray {
            TODO("not implemented")
        }

        inner class RemoteVariableAccessor: FmuVariableAccessorLite {

            override fun readInteger(vr: ValueReferences, value: IntArray): FmiStatus {
                return readInteger(instanceId, vr.toList()).let {
                    it.value.forEachIndexed { i, v ->
                        value[i] = v
                    }
                    it.status.also { lastStatus = it }
                }
            }

            override fun readReal(vr: ValueReferences, value: RealArray): FmiStatus {
                return readReal(instanceId, vr.toList()).let {
                    it.value.forEachIndexed { i, v ->
                        value[i] = v
                    }
                    it.status.also { lastStatus = it }
                }
            }

            override fun readString(vr: ValueReferences, value: StringArray): FmiStatus {
                return readString(instanceId, vr.toList()).let {
                    it.value.forEachIndexed { i, v ->
                        value[i] = v
                    }
                    it.status.also { lastStatus = it }
                }
            }

            override fun readBoolean(vr: ValueReferences, value: BooleanArray): FmiStatus {
                return readBoolean(instanceId, vr.toList()).let {
                    it.value.forEachIndexed { i, v ->
                        value[i] = v
                    }
                    it.status.also { lastStatus = it }
                }
            }

            override fun writeBoolean(vr: ValueReferences, value: BooleanArray): FmiStatus {
                return writeBoolean(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
            }

            override fun writeInteger(vr: ValueReferences, value: IntArray): FmiStatus {
                return writeInteger(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
            }

            override fun writeReal(vr: ValueReferences, value: RealArray): FmiStatus {
                return writeReal(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
            }

            override fun writeString(vr: ValueReferences, value: StringArray): FmiStatus {
                return writeString(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
            }
        }

    }

}
