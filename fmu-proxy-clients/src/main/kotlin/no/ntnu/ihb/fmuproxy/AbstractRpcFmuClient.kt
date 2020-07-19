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

abstract class AbstractRpcFmuClient : CoSimulationModel {

    protected abstract fun instantiate()

    protected abstract fun setupExperiment(start: Double, stop: Double, tolerance: Double): FmiStatus
    protected abstract fun enterInitializationMode(): FmiStatus
    protected abstract fun exitInitializationMode(): FmiStatus

    protected abstract fun step(stepSize: Double): StepResult
    protected abstract fun reset(): FmiStatus
    protected abstract fun terminate(): FmiStatus
    protected abstract fun freeInstance()

    internal abstract fun readInteger(vr: List<ValueReference>): IntegerArrayRead
    internal abstract fun readReal(vr: List<ValueReference>): RealArrayRead
    internal abstract fun readString(vr: List<ValueReference>): StringArrayRead
    internal abstract fun readBoolean(vr: List<ValueReference>): BooleanArrayRead

    internal abstract fun writeInteger(vr: List<ValueReference>, value: List<Int>): FmiStatus
    internal abstract fun writeReal(vr: List<ValueReference>, value: List<Real>): FmiStatus
    internal abstract fun writeString(vr: List<ValueReference>, value: List<String>): FmiStatus
    internal abstract fun writeBoolean(vr: List<ValueReference>, value: List<Boolean>): FmiStatus

    internal abstract fun getDirectionalDerivative(vUnknownRef: List<ValueReference>, vKnownRef: List<ValueReference>, dvKnownRef: List<Double>): DirectionalDerivativeResult

    override fun newInstance(instanceName: String): SlaveInstance {
        instantiate()
        return FmuInstance(instanceName)
    }

    inner class FmuInstance internal constructor(
            override val instanceName: String
    ) : SlaveInstance {

        override var isTerminated = false
            private set

        override var simulationTime: Double = 0.0
        override var lastStatus = FmiStatus.NONE
        override val modelDescription: CoSimulationModelDescription by lazy {
            this@AbstractRpcFmuClient.modelDescription
        }

        override fun setupExperiment(start: Double, stop: Double, tolerance: Double): Boolean {
            return this@AbstractRpcFmuClient.setupExperiment(start, stop, tolerance).also {
                simulationTime = start
                lastStatus = it
            }.isOK()
        }

        override fun enterInitializationMode(): Boolean {
            return this@AbstractRpcFmuClient.enterInitializationMode().also {
                lastStatus = it
            }.isOK()
        }

        override fun exitInitializationMode(): Boolean {
            return this@AbstractRpcFmuClient.exitInitializationMode().also {
                lastStatus = it
            }.isOK()
        }

        override fun doStep(stepSize: Double): Boolean {
            val stepResult = step(stepSize)
            simulationTime = stepResult.simulationTime
            return stepResult.status.let {
                lastStatus = it
                it == FmiStatus.OK
            }
        }

        override fun terminate(): Boolean {
            if (!isTerminated) {
                return try {
                    this@AbstractRpcFmuClient.terminate().let {
                        lastStatus = it
                        it == FmiStatus.OK
                    }
                } finally {
                    isTerminated = true
                }
            }
            return true
        }

        override fun reset(): Boolean {
            return this@AbstractRpcFmuClient.reset().let {
                lastStatus = it
                it == FmiStatus.OK
            }
        }

        override fun close() {
            this@AbstractRpcFmuClient.terminate()
            this@AbstractRpcFmuClient.freeInstance()
        }

        override fun getDirectionalDerivative(vUnknownRef: ValueReferences, vKnownRef: ValueReferences, dvKnown: RealArray): RealArray {
            return this@AbstractRpcFmuClient.getDirectionalDerivative(vKnownRef.toList(), vUnknownRef.toList(), dvKnown.toList()).let {
                lastStatus = it.status
                it.directionalDerivative
            }
        }

        override fun readInteger(vr: ValueReferences, ref: IntArray): FmiStatus {
            return this@AbstractRpcFmuClient.readInteger(vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun readReal(vr: ValueReferences, ref: RealArray): FmiStatus {
            return this@AbstractRpcFmuClient.readReal(vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun readString(vr: ValueReferences, ref: StringArray): FmiStatus {
            return this@AbstractRpcFmuClient.readString(vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun readBoolean(vr: ValueReferences, ref: BooleanArray): FmiStatus {
            return this@AbstractRpcFmuClient.readBoolean(vr.toList()).let {
                it.value.forEachIndexed { i, v ->
                    ref[i] = v
                }
                it.status.also { lastStatus = it }
            }
        }

        override fun writeInteger(vr: ValueReferences, value: IntArray): FmiStatus {
            return this@AbstractRpcFmuClient.writeInteger(vr.toList(), value.toList()).also { lastStatus = it }
        }

        override fun writeReal(vr: ValueReferences, value: RealArray): FmiStatus {
            return this@AbstractRpcFmuClient.writeReal(vr.toList(), value.toList()).also { lastStatus = it }
        }

        override fun writeString(vr: ValueReferences, value: StringArray): FmiStatus {
            return this@AbstractRpcFmuClient.writeString(vr.toList(), value.toList()).also { lastStatus = it }
        }

        override fun writeBoolean(vr: ValueReferences, value: BooleanArray): FmiStatus {
            return this@AbstractRpcFmuClient.writeBoolean(vr.toList(), value.toList()).also { lastStatus = it }
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
