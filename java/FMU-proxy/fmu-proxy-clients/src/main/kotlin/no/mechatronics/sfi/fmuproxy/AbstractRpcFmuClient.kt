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

import no.ntnu.ihb.fmi4j.common.*
import no.ntnu.ihb.fmi4j.importer.IFmu
import no.ntnu.ihb.fmi4j.importer.misc.FmuVariableAccessorImpl
import no.ntnu.ihb.fmi4j.modeldescription.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

typealias InstanceId = String

abstract class AbstractRpcFmuClient(
        val fmuId: String
): IFmu {

    abstract val implementationName: String

    abstract val canCreateInstanceFromCS: Boolean
    abstract val canCreateInstanceFromME: Boolean

    protected abstract fun createInstanceFromCS(): InstanceId
    protected abstract fun createInstanceFromME(solver: Solver): InstanceId

    protected abstract fun getCoSimulationAttributes(instanceId: InstanceId): CoSimulationAttributes

    protected abstract fun setup(instanceId: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus
    protected abstract fun enterInitializationMode(instanceId: InstanceId): FmiStatus
    protected abstract fun exitInitializationMode(instanceId: InstanceId): FmiStatus

    protected abstract fun step(instanceId: InstanceId, stepSize: Double): Pair<Double, FmiStatus>
    protected abstract fun reset(instanceId: InstanceId): FmiStatus
    protected abstract fun terminate(instanceId: InstanceId): FmiStatus

    internal abstract fun readInteger(instanceId: InstanceId, vr: List<ValueReference>): FmuIntegerArrayRead
    internal abstract fun readReal(instanceId: InstanceId, vr: List<ValueReference>): FmuRealArrayRead
    internal abstract fun readString(instanceId: InstanceId, vr: List<ValueReference>): FmuStringArrayRead
    internal abstract fun readBoolean(instanceId: InstanceId, vr: List<ValueReference>): FmuBooleanArrayRead

    internal abstract fun writeInteger(instanceId: InstanceId, vr: List<ValueReference>, value: List<Int>): FmiStatus
    internal abstract fun writeReal(instanceId: InstanceId, vr: List<ValueReference>, value: List<Real>): FmiStatus
    internal abstract fun writeString(instanceId: InstanceId, vr: List<ValueReference>, value: List<String>): FmiStatus
    internal abstract fun writeBoolean(instanceId: InstanceId, vr: List<ValueReference>, value: List<Boolean>): FmiStatus

    internal abstract fun getFMUstate(instanceId: InstanceId):  Pair<FmuState, FmiStatus>
    internal abstract fun setFMUstate(instanceId: InstanceId, state: FmuState): FmiStatus
    internal abstract fun freeFMUstate(instanceId: InstanceId, state: FmuState):  FmiStatus

    internal abstract fun serializeFMUstate(instanceId: InstanceId, state: FmuState): Pair<ByteArray, FmiStatus>
    internal abstract fun deSerializeFMUstate(instanceId: InstanceId, state: ByteArray):  Pair<FmuState, FmiStatus>

    internal abstract fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): Pair<List<Double>, FmiStatus>

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
        LOG.debug("Closing '$implementationName' ...")
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

        override var isTerminated = false
            private set

        override var simulationTime: Double = 0.0
        override var lastStatus = FmiStatus.NONE

        override val modelDescription by lazy {
            CoSimulationModelDescriptionImpl(
                    this@AbstractRpcFmuClient.modelDescription,
                    getCoSimulationAttributes(instanceId)
            )
        }

        override val variableAccessor: FmuVariableAccessor by lazy {
            FmuVariableAccessorImpl(RemoteVariableAccessor()) {
                modelDescription.getVariableByName(it).valueReference
            }
        }


        override fun setup(start: Double, stop: Double, tolerance: Double): Boolean {
            return setup(instanceId, start, stop, tolerance).also {
                simulationTime = start
                lastStatus = it
            }.isOK()
        }

        override fun enterInitializationMode(): Boolean {
            return enterInitializationMode(instanceId).also {
                lastStatus = it
            }.isOK()
        }

        override fun exitInitializationMode(): Boolean {
            return exitInitializationMode(instanceId).also {
                lastStatus = it
            }.isOK()
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

        override fun getFMUstate(): FmuState {
            return getFMUstate(instanceId).let {
                lastStatus = it.second
                it.first
            }
        }

        override fun setFMUstate(state: FmuState): Boolean {
            return setFMUstate(instanceId, state).let {
                lastStatus = it
                it == FmiStatus.OK
            }
        }

        override fun freeFMUstate(state: FmuState): Boolean {
            return freeFMUstate(instanceId, state).let {
                lastStatus = it
                it == FmiStatus.OK
            }
        }


        override fun serializeFMUstate(state: FmuState): ByteArray {
            return serializeFMUstate(instanceId, state).let {
                lastStatus = it.second
                it.first
            }
        }

        override fun deSerializeFMUstate(state: ByteArray): FmuState {
            return deSerializeFMUstate(instanceId, state).let {
                lastStatus = it.second
                it.first
            }
        }

        override fun getDirectionalDerivative(vUnknownRef: ValueReferences, vKnownRef: ValueReferences, dvKnown: RealArray): RealArray {
            return getDirectionalDerivative(instanceId, vKnownRef.toList(), vUnknownRef.toList(), dvKnown.toList()).let {
                lastStatus = it.second
                it.first.toDoubleArray()
            }
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
