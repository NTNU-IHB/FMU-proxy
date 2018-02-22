/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
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

package no.mechatronics.sfi.grpc_fmu


import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.net.ServerSocket
import java.util.concurrent.atomic.AtomicInteger

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.BindableService
import io.grpc.stub.StreamObserver

import no.mechatronics.sfi.fmi4j.FmiSimulation
import no.mechatronics.sfi.fmi4j.fmu.FmuBuilder
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.modeldescription.*
import no.mechatronics.sfi.fmi4j.modeldescription.enums.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator
import org.apache.commons.math3.ode.nonstiff.GillIntegrator
import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator


/**
 *
 * @author Lars Ivar Hatledal
 */
open class GenericFmuServer(
        private val fmuFile: FmuFile
) {

    private val builder: FmuBuilder
    protected val modelDescription: SimpleModelDescription

    private var server: Server? = null
    protected val fmus = mutableMapOf<Int, FmiSimulation>()

    init {
        this.modelDescription = this.fmuFile.modelDescription;
        this.builder = FmuBuilder(this.fmuFile)
    }

    val guid: String
        get() = modelDescription.guid

    val modelDescriptionXml: String
        get() = fmuFile.modelDescriptionXml

    protected open fun getServices(): List<BindableService> {
        return listOf(GenericServiceImpl())
    }

    fun start(): Int {
        return ServerSocket(0).use { ss -> ss.localPort }.also {
            start(it)
        }
    }

    fun start(port: Int) {
        server = ServerBuilder.forPort(port)
                .apply {
                    getServices().forEach{addService(it)}
                }.build().start()

        LOG.info("FMU listening for connections on port: {}", port);
    }

    fun stop() {
        server?.shutdown()
        disposeFmus()
    }

    private fun disposeFmus() {
        with(fmus) {
            values.forEach {
                disposeFmu(it)
            }
            clear()
        }
    }

    private fun disposeFmu(fmu: FmiSimulation) {
        try {
            fmu.terminate()
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        } catch (ex: java.lang.Error) {
            ex.printStackTrace()
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    fun blockUntilShutdown() {
        server?.awaitTermination()
    }

    protected companion object {

        val LOG: Logger = LoggerFactory.getLogger(GenericFmuServer::class.java)

        fun convert(status: FmiStatus): FmiDefinitions.StatusCode {
            return when (status) {
                FmiStatus.OK -> FmiDefinitions.StatusCode.OK
                FmiStatus.Warning -> FmiDefinitions.StatusCode.WARNING
                FmiStatus.Discard -> FmiDefinitions.StatusCode.DISCARD
                FmiStatus.Error -> FmiDefinitions.StatusCode.ERROR
                FmiStatus.Fatal -> FmiDefinitions.StatusCode.FATAL
                FmiStatus.Pending -> FmiDefinitions.StatusCode.PENDING
                FmiStatus.NONE -> FmiDefinitions.StatusCode.UNRECOGNIZED
            }
        }

        fun statusReply(status: FmiStatus, responseObserver: StreamObserver<FmiDefinitions.Status>) {
            statusReply(FmiDefinitions.Status.newBuilder()
                    .setCode(convert(status))
                    .build(), responseObserver)
        }

        fun statusReply(status: FmiDefinitions.Status, responseObserver: StreamObserver<FmiDefinitions.Status>) {
            responseObserver.onNext(status)
            responseObserver.onCompleted()
        }

    }

    private inner class GenericServiceImpl : GenericFmuServiceGrpc.GenericFmuServiceImplBase() {

        private val idGenerator = AtomicInteger(0)

        override fun createInstanceFromCS(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

            val id = idGenerator.incrementAndGet()
            fmus[id] = builder.asCoSimulationFmu().newInstance()

            val reply = FmiDefinitions.UInt.newBuilder().setValue(id).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()

        }

        override fun createInstanceFromME(req: FmiDefinitions.Integrator, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

            val integrator = when (req.integratorsCase) {
                FmiDefinitions.Integrator.IntegratorsCase.EULER -> EulerIntegrator(req.euler.stepSize)
                FmiDefinitions.Integrator.IntegratorsCase.RUNGE_KUTTA -> ClassicalRungeKuttaIntegrator(req.rungeKutta.stepSize)
                FmiDefinitions.Integrator.IntegratorsCase.GILL -> GillIntegrator(req.gill.stepSize)
                FmiDefinitions.Integrator.IntegratorsCase.MID_POINT -> MidpointIntegrator(req.midPoint.stepSize)
                FmiDefinitions.Integrator.IntegratorsCase.INTEGRATORS_NOT_SET  -> {
                    LOG.warn("No integrator specified.. Defaulting to Euler with 1E-3 stepsize")
                    EulerIntegrator(1E-3)
                }
            }

            val id = idGenerator.incrementAndGet()
            fmus[id] = builder.asModelExchangeFmu().newInstance(integrator)

            val reply = FmiDefinitions.UInt.newBuilder().setValue(id).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()

        }

        override fun getGuid(request: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.Str>) {

            val reply = FmiDefinitions.Str.newBuilder().setValue(guid).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()

        }

        override fun getModelName(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.Str>) {

            val modelName = modelDescription.modelName
            val reply = FmiDefinitions.Str.newBuilder().setValue(modelName).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()

        }

        override fun getCurrentTime(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Real>) {

            val id = req.value
            val fmu = fmus[id]
            if (fmu != null) {
                responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(fmu.currentTime).build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }

            responseObserver.onCompleted()

        }

        override fun isTerminated(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

            val id = req.value
            val fmu = fmus[id]
            if (fmu != null) {
                responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(fmu.isTerminated).build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }

            responseObserver.onCompleted()

        }

        override fun getModelVariables(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.ScalarVariable>) {

            for (variable in modelDescription.modelVariables) {
                responseObserver.onNext(FmiDefinitions.ScalarVariable.newBuilder()
                        .setValueReference(variable.valueReference)
                        .setName(variable.name)
                        .setDescription(variable.description)
                        .setVariableType(getType(variable))
                        .setCausality(getCausality(variable))
                        .setVariability(getVariability(variable))
                        .setStart(getStart(variable))
                        .build())
            }

            responseObserver.onCompleted()

        }

        override fun readInteger(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.IntRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val valueReference = req.valueReference
                val read = fmu.variableAccessor.readInteger(valueReference)
                responseObserver.onNext(FmiDefinitions.IntRead.newBuilder()
                        .setValue(read.value)
                        .setStatus(convert(read.status))
                        .build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadInteger(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.IntListRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val builder = FmiDefinitions.IntListRead.newBuilder()
                val read = fmu.variableAccessor.readInteger(toIntArray(req.valueReferencesList))
                builder.status = convert(read.status)
                for (value in read.value) {
                    builder.addValues(value)
                }
                responseObserver.onNext(builder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun readReal(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val valueReference = req.valueReference
                val read = fmu.variableAccessor.readReal(valueReference)
                responseObserver.onNext(FmiDefinitions.RealRead.newBuilder()
                        .setValue(read.value)
                        .setStatus(convert(read.status))
                        .build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadReal(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealListRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val builder = FmiDefinitions.RealListRead.newBuilder()
                val read = fmu.variableAccessor.readReal(toIntArray(req.valueReferencesList))
                builder.status = convert(read.status)
                for (value in read.value) {
                    builder.addValues(value)
                }
                responseObserver.onNext(builder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun readString(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val read = fmu.variableAccessor.readString(req.valueReference)
                responseObserver.onNext(FmiDefinitions.StrRead.newBuilder()
                        .setValue(read.value)
                        .setStatus(convert(read.status))
                        .build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadString(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrListRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val builder = FmiDefinitions.StrListRead.newBuilder()
                val read = fmu.variableAccessor.readString(toIntArray(req.valueReferencesList))
                builder.status = convert(read.status)
                for (value in read.value) {
                    builder.addValues(value)
                }
                responseObserver.onNext(builder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun readBoolean(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val read = fmu.variableAccessor.readBoolean(req.valueReference)
                responseObserver.onNext(FmiDefinitions.BoolRead.newBuilder()
                        .setValue(read.value)
                        .setStatus(convert(read.status))
                        .build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadBoolean(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolListRead>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val builder = FmiDefinitions.BoolListRead.newBuilder()
                val read = fmu.variableAccessor.readBoolean(toIntArray(req.valueReferencesList))
                builder.status = convert(read.status)
                for (value in read.value) {
                    builder.addValues(value)
                }
                responseObserver.onNext(builder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun writeInteger(req: FmiDefinitions.WriteIntegerRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val status = fmu.variableAccessor.writeInteger(req.valueReference, req.value)
                statusReply(status, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(FmiStatus.Error, responseObserver)
            }

        }

        override fun writeReal(req: FmiDefinitions.WriteRealRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val status = fmu.variableAccessor.writeReal(req.valueReference, req.value)
                statusReply(status, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(FmiStatus.Error, responseObserver)
            }

        }

        override fun writeString(req: FmiDefinitions.WriteStringRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val status = fmu.variableAccessor.writeString(req.valueReference, req.value)
                statusReply(status, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(FmiStatus.Error, responseObserver)
            }

        }

        override fun writeBoolean(req: FmiDefinitions.WriteBooleanRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val status = fmu.variableAccessor.writeBoolean(req.valueReference, req.value)
                statusReply(status, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(FmiStatus.Error, responseObserver)
            }

        }

        override fun init(req: FmiDefinitions.InitRequest, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

            var init = false
            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val start = req.start
                val stop = req.stop
                val hasStart = start > 0
                val hasStop = stop > 0 && stop > start
                if (hasStart && hasStop) {
                    init = fmu.init(start, stop)
                } else if (hasStart && hasStop) {
                    init = fmu.init(start)
                } else {
                    init = fmu.init()
                }
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            val reply = FmiDefinitions.Bool.newBuilder().setValue(init).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()
        }

        override fun step(req: FmiDefinitions.StepRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val dt = req.dt
            val fmu = fmus[id]
            if (fmu != null) {
                fmu.doStep(dt)
                statusReply(fmu.lastStatus, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(FmiStatus.Error, responseObserver)
            }

        }

        override fun terminate(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

            var flag = false
            val id = req.value
            val fmu = fmus.remove(id)
            if (fmu != null) {
                LOG.info("Removed fmu instance from list")
                try {
                    flag = fmu.terminate()
                    LOG.info("Terminated fmu with success: {}", flag)
                } catch (ex: java.lang.Exception) {
                    ex.printStackTrace()
                } catch (ex: java.lang.Error) {
                    ex.printStackTrace()
                }

            } else {
                LOG.warn("No fmu with id: {}", id)
            }

            val reply = FmiDefinitions.Bool.newBuilder().setValue(flag).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()

        }

        override fun reset(req: FmiDefinitions.UInt, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.value
            val fmu = fmus.remove(id)
            if (fmu != null) {
                fmu.reset()
                statusReply(fmu.lastStatus, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(FmiStatus.Error, responseObserver)
            }

        }

        private fun getCausality(variable: TypedScalarVariable<*>): FmiDefinitions.Causality {

            return when (variable.causality) {
                Causality.INPUT -> FmiDefinitions.Causality.INPUT
                Causality.OUTPUT -> FmiDefinitions.Causality.OUTPUT
                Causality.CALCULATED_PARAMETER -> FmiDefinitions.Causality.CALCULATED_PARAMETER
                Causality.PARAMETER -> FmiDefinitions.Causality.PARAMETER
                Causality.LOCAL -> FmiDefinitions.Causality.LOCAL
                Causality.INDEPENDENT -> FmiDefinitions.Causality.INDEPENDENT
                else -> FmiDefinitions.Causality.UNDEFINED_CAUSALITY
            }

        }

        private fun getVariability(variable: TypedScalarVariable<*>): FmiDefinitions.Variability {

            return when (variable.variability) {
                Variability.CONSTANT -> FmiDefinitions.Variability.CONSTANT
                Variability.CONTINUOUS -> FmiDefinitions.Variability.CONTINUOUS
                Variability.DISCRETE -> FmiDefinitions.Variability.DISCRETE
                Variability.FIXED -> FmiDefinitions.Variability.FIXED
                Variability.TUNABLE -> FmiDefinitions.Variability.TUNABLE
                else -> FmiDefinitions.Variability.UNDEFINED_VARIABILITY
            }

        }

        private fun getInitial(variable: TypedScalarVariable<*>): FmiDefinitions.Initial {

            return when (variable.initial) {
                Initial.CALCULATED -> FmiDefinitions.Initial.CALCULATED
                Initial.EXACT -> FmiDefinitions.Initial.EXACT
                Initial.APPROX -> FmiDefinitions.Initial.APPROX
                else -> FmiDefinitions.Initial.UNDEFINED_INITIAL
            }

        }

        private fun getStart(variable: TypedScalarVariable<*>): FmiDefinitions.AnyPrimitive {

            if (variable.start == null) {
                return FmiDefinitions.AnyPrimitive.getDefaultInstance()
            }

            return FmiDefinitions.AnyPrimitive.newBuilder().apply {
                if (variable is IntegerVariable) {
                    intValue = (variable.start!!)
                } else if (variable is RealVariable) {
                    realValue = (variable.start!!)
                } else if (variable is StringVariable) {
                    strValue = (variable.start)
                } else if (variable is BooleanVariable) {
                    boolValue = (variable.start!!)
                } else {
                    throw UnsupportedOperationException("Variable type not supported: " + variable.javaClass.simpleName)
                }
            }.build()

        }

        private fun getType(variable: TypedScalarVariable<*>): FmiDefinitions.VariableType {
            return when (variable.typeName) {
                "Integer" -> FmiDefinitions.VariableType.INTEGER
                "Real" -> FmiDefinitions.VariableType.REAL
                "String" -> FmiDefinitions.VariableType.STRING
                "Boolean" -> FmiDefinitions.VariableType.BOOLEAN
                else -> throw UnsupportedOperationException("Variable type not supported: " + variable.typeName)
            }

        }

        private fun toIntArray(list: List<Int>): IntArray {
            val result = IntArray(list.size)
            for (i in list.indices) {
                result[i] = list[i]
            }
            return result
        }

    }

}