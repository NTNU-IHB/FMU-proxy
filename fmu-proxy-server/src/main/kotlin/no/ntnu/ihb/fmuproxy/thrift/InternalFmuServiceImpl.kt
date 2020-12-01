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

package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmi4j.FmiStatus
import no.ntnu.ihb.fmi4j.SlaveInstance
import no.ntnu.ihb.fmi4j.importer.AbstractFmu
import no.ntnu.ihb.fmi4j.modeldescription.RealArray
import no.ntnu.ihb.fmi4j.modeldescription.StringArray
import no.ntnu.ihb.fmi4j.modeldescription.ValueReference
import no.ntnu.ihb.fmuproxy.FmuProxy
import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.server.TNonblockingServer
import org.apache.thrift.transport.TNonblockingServerSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

class InternalFmuServiceImpl(
    port: Int,
    private val fmu: AbstractFmu
) : InternalFmuService.Iface, Closeable {

    private val server: TNonblockingServer
    private lateinit var slave: SlaveInstance

    private val started = AtomicBoolean(false)
    internal val stopped = AtomicBoolean(false)

    init {
        val transport = TNonblockingServerSocket(port)
        val processor = InternalFmuService.Processor(this)
        this.server = TNonblockingServer(
            TNonblockingServer.Args(transport)
                .processor(processor)
                .protocolFactory(TBinaryProtocol.Factory())
        )
    }

    fun start() {
        if (!started.getAndSet(true)) {
            thread(start = true) {
                server.serve()
            }
        }
    }

    override fun getModelDescription(): ModelDescription {
        return fmu.modelDescription.asCoSimulationModelDescription().thriftType()
    }

    override fun createInstance() {
        if (!fmu.supportsCoSimulation) {
            throw UnsupportedOperationException("FMU does not support Co-simulation!")
        }
        slave = fmu.asCoSimulationFmu().newInstance()
    }

    override fun setupExperiment(start: Double, stop: Double, tolerance: Double): Status {
        slave.setupExperiment(start, stop, tolerance)
        return slave.lastStatus.thriftType()
    }

    override fun enterInitializationMode(): Status {
        slave.enterInitializationMode()
        return slave.lastStatus.thriftType()
    }

    override fun exitInitializationMode(): Status {
        slave.exitInitializationMode()
        return slave.lastStatus.thriftType()
    }

    override fun step(stepSize: Double): StepResult {
        if (!slave.doStep(stepSize)) {
            LOG.error("doStep returned with status: ${slave.lastStatus}")
        }
        return StepResult().apply {
            simulationTime = slave.simulationTime
            status = slave.lastStatus.thriftType()
        }
    }

    override fun reset(): Status {
        slave.reset()
        return slave.lastStatus.thriftType()
    }

    override fun terminate(): Status {
        slave.terminate()
        val status = slave.lastStatus
        LOG.info("Terminated instance of ${slave.modelDescription.modelName} with status $status")
        return status.thriftType()
    }

    override fun shutdown() {
        thread(start = true) {
            Thread.sleep(1000)
            close()
        }
    }

    override fun close() {
        if (started.get() && !stopped.get()) {
            server.stop()
            stopped.set(true)
            LOG.info("FMU-proxy stopped!")
        }
    }

    override fun readInteger(vr: List<ValueReference>): IntegerRead {
        val values = IntArray(vr.size)
        val status = slave.readInteger(vr.toLongArray(), values).thriftType()
        return IntegerRead(values.toList(), status)
    }

    override fun readReal(vr: List<ValueReference>): RealRead {
        val values = RealArray(vr.size)
        val status = slave.readReal(vr.toLongArray(), values).thriftType()
        return RealRead(values.asList(), status)
    }

    override fun readString(vr: List<ValueReference>): StringRead {
        val values = StringArray(vr.size) { "" }
        val status = slave.readString(vr.toLongArray(), values).thriftType()
        return StringRead(values.toList(), status)
    }

    override fun readBoolean(vr: List<ValueReference>): BooleanRead {
        val values = BooleanArray(vr.size)
        val status = slave.readBoolean(vr.toLongArray(), values).thriftType()
        return BooleanRead(values.toList(), status)
    }

    override fun readAll(intVr: MutableList<Long>, realVr: MutableList<Long>, strVr: MutableList<Long>, boolVr: MutableList<Long>): BulkRead {
        val intValues = IntArray(intVr.size)
        val realValues = RealArray(realVr.size)
        val strValues = StringArray(strVr.size) {""}
        val boolValues = BooleanArray(boolVr.size)
        val status = slave.readAll(
                intVr.toLongArray(), intValues,
                realVr.toLongArray(), realValues,
                strVr.toLongArray(), strValues,
                boolVr.toLongArray(), boolValues
        )
        return BulkRead(intValues.toList(), realValues.toList(), strValues.toList(), boolValues.toList(), status.thriftType())
    }

    override fun writeInteger(vr: List<ValueReference>, value: List<Int>): Status {
        return slave.writeInteger(vr.toLongArray(), value.toIntArray()).thriftType()
    }

    override fun writeReal(vr: List<ValueReference>, value: List<Double>): Status {
        return slave.writeReal(vr.toLongArray(), value.toDoubleArray()).thriftType()
    }

    override fun writeString(vr: List<ValueReference>, value: List<String>): Status {
        return slave.writeString(vr.toLongArray(), value.toTypedArray()).thriftType()
    }

    override fun writeBoolean(vr: List<ValueReference>, value: List<Boolean>): Status {
        return slave.writeBoolean(vr.toLongArray(), value.toBooleanArray()).thriftType()
    }

    override fun writeAll(intVr: MutableList<Long>, intValue: MutableList<Int>, realVr: MutableList<Long>, realValue: MutableList<Double>, strVr: MutableList<Long>, strValue: MutableList<String>, boolVr: MutableList<Long>, boolValue: MutableList<Boolean>): Status {
        return slave.writeAll(
                intVr.toLongArray(), intValue.toIntArray(),
                realVr.toLongArray(), realValue.toDoubleArray(),
                strVr.toLongArray(), strValue.toTypedArray(),
                boolVr.toLongArray(), boolValue.toBooleanArray()
        ).thriftType()
    }

    override fun getDirectionalDerivative(
        vUnkownRef: List<Long>,
        vKnownRef: List<Long>,
        dvUnkownRef: List<Double>
    ): DirectionalDerivativeResult {
        if (!slave.modelDescription.attributes.providesDirectionalDerivative) {
            throw UnsupportedOperationException("FMU instance does not provide DirectionalDerivative!")
        }
        val dvUnknown = slave.getDirectionalDerivative(
            vUnkownRef.toLongArray(),
            vKnownRef.toLongArray(),
            dvUnkownRef.toDoubleArray()
        ).toList()
        return DirectionalDerivativeResult(dvUnknown, slave.lastStatus.thriftType())
    }

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(InternalFmuServiceImpl::class.java)
    }

}
