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

package no.mechatronics.sfi.fmuproxy.thrift

import no.mechatronics.sfi.fmi4j.common.ValueReference
import no.mechatronics.sfi.fmuproxy.Solver
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport
import java.io.Closeable

class ThriftTestClient(
        host: String,
        port: Int
): Closeable {

    internal object FmuInstances: ArrayList<FmuInstance>() {
        internal fun terminateAll() {
            forEach{ it.terminate() }
        }
    }

    private val transport: TTransport
    private val client: FmuService.Client

    init {
        transport = TSocket(host, port).apply {
            open()
        }
        client = FmuService.Client(TBinaryProtocol(transport))
    }

    val modelDescriptionXml: String by lazy {
        client.modelDescriptionXml
    }

    fun getCurrentTime(instanceId: Int): Double {
        return client.getSimulationTime(instanceId)
    }

    fun isTerminated(instanceId: Int): Boolean {
        return client.isTerminated(instanceId)
    }

    fun init(instanceId: Int, start: Double, stop: Double): Status {
        return client.init(instanceId, start, stop)
    }

    fun terminate(instanceId: Int): Status {
        return client.terminate(instanceId)
    }

    fun step(instanceId: Int, stepSize: Double): Pair<Double, Status> {
        return client.step(instanceId, stepSize).let {
            it.simulationTime to it.status
        }
    }

    override fun close() {
        transport.close()
        FmuInstances.terminateAll()
    }

    private fun readReal(instanceId: Int, vr: List<ValueReference>): RealRead {
        return client.readReal(instanceId, vr)
    }

    fun newInstance(solver: Solver? = null): FmuInstance {
        val instanceId = if (solver == null) client.createInstanceFromCS() else client.createInstanceFromME(solver.thriftType())
        return FmuInstance(instanceId).also {
            FmuInstances.add(it)
        }
    }

    inner class FmuInstance(
            private val instanceId: Int
    ): Closeable {

       val isTerminated: Boolean
            get() = isTerminated(instanceId)

       var currentTime: Double = 0.0

        init {
            currentTime = getCurrentTime(instanceId)
        }

       fun init(start: Double = 0.0, stop: Double = 0.0) {
            init(instanceId, start, stop)
        }

       fun doStep(stepSize: Double): Boolean {
            val stepResult = step(instanceId, stepSize)
            currentTime = stepResult.first
            return stepResult.second == Status.OK_STATUS
        }

       fun terminate(): Boolean {
            return try {
                terminate(instanceId) == Status.OK_STATUS
            } finally {
                FmuInstances.remove(this)
            }
        }

       override fun close() {
            terminate()
        }

        fun readReal(vr: List<ValueReference>) = readReal(instanceId, vr)

    }


}
