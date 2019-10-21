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

package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.*
import no.ntnu.ihb.fmi4j.modeldescription.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

typealias InstanceId = String

abstract class AbstractRpcFmuClient(
        val fmuId: String
) : CoSimulationModel {

    abstract val implementationName: String

    protected abstract fun createInstance(): InstanceId

    protected abstract fun setup(instanceId: InstanceId, start: Double, stop: Double, tolerance: Double): FmiStatus
    protected abstract fun enterInitializationMode(instanceId: InstanceId): FmiStatus
    protected abstract fun exitInitializationMode(instanceId: InstanceId): FmiStatus

    protected abstract fun step(instanceId: InstanceId, stepSize: Double): StepResult
    protected abstract fun reset(instanceId: InstanceId): FmiStatus
    protected abstract fun terminate(instanceId: InstanceId): FmiStatus

    internal abstract fun readInteger(instanceId: InstanceId, vr: List<ValueReference>): IntegerArrayRead
    internal abstract fun readReal(instanceId: InstanceId, vr: List<ValueReference>): RealArrayRead
    internal abstract fun readString(instanceId: InstanceId, vr: List<ValueReference>): StringArrayRead
    internal abstract fun readBoolean(instanceId: InstanceId, vr: List<ValueReference>): BooleanArrayRead

    internal abstract fun writeInteger(instanceId: InstanceId, vr: List<ValueReference>, value: List<Int>): FmiStatus
    internal abstract fun writeReal(instanceId: InstanceId, vr: List<ValueReference>, value: List<Real>): FmiStatus
    internal abstract fun writeString(instanceId: InstanceId, vr: List<ValueReference>, value: List<String>): FmiStatus
    internal abstract fun writeBoolean(instanceId: InstanceId, vr: List<ValueReference>, value: List<Boolean>): FmiStatus

    internal abstract fun getDirectionalDerivative(instanceId: InstanceId, vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): DirectionalDerivativeResult

    private val fmuInstances = mutableListOf<FmuInstance>()

    override fun newInstance(): SlaveInstance {
        return newInstance(createInstance())
    }

    private fun newInstance(instanceId: InstanceId): SlaveInstance {
        return FmuInstance(instanceId).also {
            fmuInstances.add(it)
        }
    }

    override fun close() {
        LOG.debug("Closing '$implementationName' ...")
        fmuInstances.toMutableList().forEach {
            it.close()
        }
        fmuInstances.clear()
    }

    protected companion object {

        private val LOG: Logger = LoggerFactory.getLogger(AbstractRpcFmuClient::class.java)

    }

    inner class FmuInstance internal constructor(
            private val instanceId: String
    ) : SlaveInstance {

        override var isTerminated = false
            private set

        override var simulationTime: Double = 0.0
        override var lastStatus = FmiStatus.NONE
        override val modelDescription: CoSimulationModelDescription by lazy {
            this@AbstractRpcFmuClient.modelDescription
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
            simulationTime = stepResult.simulationTime
            return stepResult.status.let {
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
                    fmuInstances.remove(this)
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

        override fun getDirectionalDerivative(vUnknownRef: ValueReferences, vKnownRef: ValueReferences, dvKnown: RealArray): RealArray {
            return getDirectionalDerivative(instanceId, vKnownRef.toList(), vUnknownRef.toList(), dvKnown.toList()).let {
                lastStatus = it.status
                it.directionalDerivative
            }
        }


        override fun read(vr: ValueReferences, ref: IntArray): FmiStatus {
            return readInteger(instanceId, vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun read(vr: ValueReferences, ref: RealArray): FmiStatus {
            return readReal(instanceId, vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun read(vr: ValueReferences, ref: StringArray): FmiStatus {
            return readString(instanceId, vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun read(vr: ValueReferences, ref: BooleanArray): FmiStatus {
            return readBoolean(instanceId, vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun write(vr: ValueReferences, value: BooleanArray): FmiStatus {
            return writeBoolean(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
        }

        override fun write(vr: ValueReferences, value: IntArray): FmiStatus {
            return writeInteger(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
        }

        override fun write(vr: ValueReferences, value: RealArray): FmiStatus {
            return writeReal(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
        }

        override fun write(vr: ValueReferences, value: StringArray): FmiStatus {
            return writeString(instanceId, vr.toList(), value.toList()).also { lastStatus = it }
        }


        override fun getFMUstate(): FmuState {
            throw UnsupportedOperationException("Not supported yet!")
        }

        override fun setFMUstate(state: FmuState): Boolean {
            throw UnsupportedOperationException("Not supported yet!")
        }

        override fun freeFMUstate(state: FmuState): Boolean {
            throw UnsupportedOperationException("Not supported yet!")
        }

        override fun serializeFMUstate(state: FmuState): ByteArray {
            throw UnsupportedOperationException("Not supported yet!")
        }

        override fun deSerializeFMUstate(state: ByteArray): FmuState {
            throw UnsupportedOperationException("Not supported yet!")
        }

    }

}
