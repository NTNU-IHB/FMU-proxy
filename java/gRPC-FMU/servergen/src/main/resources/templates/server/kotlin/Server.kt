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

package no.mechatronics.sfi.grpc_fmu

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicInteger

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver

import no.mechatronics.sfi.fmi4j.FmiSimulation
import no.mechatronics.sfi.fmi4j.fmu.FmuBuilder
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.proxy.enums.Fmi2Status
import no.mechatronics.sfi.fmi4j.modeldescription.*
import no.mechatronics.sfi.fmi4j.modeldescription.enums.*
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*

class {{fmuName}}Server {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger({{fmuName}}Server::class.java)

        fun statusReply (status: Fmi2Status, responseObserver: StreamObserver<FmiDefinitions.Status> ) {
            statusReply(FmiDefinitions.Status.newBuilder()
                    .setCode(status.code)
                    .setValue(status.name)
                    .build(), responseObserver)
        }

        fun statusReply (status: FmiDefinitions.Status, responseObserver: StreamObserver<FmiDefinitions.Status> ) {
            responseObserver.onNext(status)
            responseObserver.onCompleted()
        }

    }

    private val fmuFile: FmuFile
    private val builder: FmuBuilder
    private val modelDescription: SimpleModelDescription

    private var server: Server? = null
    private val fmus = mutableMapOf<Int, FmiSimulation>()

    init {
        this.fmuFile = FmuFile(javaClass.classLoader.getResource("{{fmuName}}.fmu")!!)
        this.modelDescription = this.fmuFile.modelDescription;
        this.builder = FmuBuilder(this.fmuFile)
    }

    val guid: String
        get() = modelDescription.guid


    val modelDescriptionXml: String
        get() = fmuFile.modelDescriptionXml


    fun start(port: Int) {
        server = ServerBuilder.forPort(port)
                .addService(GenericServiceImpl ())
                .addService({{fmuName}}ServiceImpl())
                .build()
                .start()

        LOG.info("FMU listening for connections on port: {}", port);
    }

    fun stop() {
        server?.shutdown()
        disposeFmus()
    }

    fun disposeFmus() {
        with (fmus) {
            values.forEach{
                disposeFmu(it)
            }
            clear()
        }
    }

    fun disposeFmu(fmu: FmiSimulation) {
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

    inner class GenericServiceImpl : GenericFmuServiceGrpc.GenericFmuServiceImplBase() {

        private val idGenerator = AtomicInteger(0)

        override fun createInstance(req: FmiDefinitions.Empty, responseObserver: StreamObserver<FmiDefinitions.UInt>) {

            val id = idGenerator.incrementAndGet()
            fmus[id] = builder.asCoSimulationFmu().newInstance()

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

        override fun readInteger(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.Int>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val valueReference = req.valueReference
                val value = fmu.variableAccessor.getInteger(valueReference)
                responseObserver.onNext(FmiDefinitions.Int.newBuilder().setValue(value).build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadInteger(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.IntList>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val listBuilder = FmiDefinitions.IntList.newBuilder()
                for (value in fmu.variableAccessor.getInteger(toIntArray(req.valueReferencesList))) {
                    listBuilder.addValues(value)
                }
                responseObserver.onNext(listBuilder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun readReal(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.Real>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val valueReference = req.valueReference
                val value = fmu.variableAccessor.getReal(valueReference)
                responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(value).build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadReal(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.RealList>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val listBuilder = FmiDefinitions.RealList.newBuilder()
                for (value in fmu.variableAccessor.getReal(toIntArray(req.valueReferencesList))) {
                    listBuilder.addValues(value)
                }
                responseObserver.onNext(listBuilder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun readString(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.Str>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val value = fmu.variableAccessor.getString(req.valueReference)
                responseObserver.onNext(FmiDefinitions.Str.newBuilder().setValue(value).build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadString(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.StrList>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val listBuilder = FmiDefinitions.StrList.newBuilder()
                for (value in fmu.variableAccessor.getString(toIntArray(req.valueReferencesList))) {
                    listBuilder.addValues(value)
                }
                responseObserver.onNext(listBuilder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun readBoolean(req: FmiDefinitions.ReadRequest, responseObserver: StreamObserver<FmiDefinitions.Bool>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val value = fmu.variableAccessor.getBoolean(req.valueReference)
                responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(value).build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun bulkReadBoolean(req: FmiDefinitions.BulkReadRequest, responseObserver: StreamObserver<FmiDefinitions.BoolList>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                val listBuilder = FmiDefinitions.BoolList.newBuilder()
                for (value in fmu.variableAccessor.getBoolean(toIntArray(req.valueReferencesList))) {
                    listBuilder.addValues(value)
                }
                responseObserver.onNext(listBuilder.build())
            } else {
                LOG.warn("No fmu with id: {}", id)
            }
            responseObserver.onCompleted()

        }

        override fun writeInteger(req: FmiDefinitions.WriteIntegerRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                fmu.variableAccessor.setInteger(req.valueReference, req.value)
                statusReply(fmu.lastStatus, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(Fmi2Status.Error, responseObserver)
            }

        }

        override fun writeReal(req: FmiDefinitions.WriteRealRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                fmu.variableAccessor.setReal(req.valueReference, req.value)
                statusReply(fmu.lastStatus, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(Fmi2Status.Error, responseObserver)
            }

        }

        override fun writeString(req: FmiDefinitions.WriteStringRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                fmu.variableAccessor.setString(req.valueReference, req.value)
                statusReply(fmu.lastStatus, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(Fmi2Status.Error, responseObserver)
            }

        }

        override fun writeBoolean(req: FmiDefinitions.WriteBooleanRequest, responseObserver: StreamObserver<FmiDefinitions.Status>) {

            val id = req.fmuId
            val fmu = fmus[id]
            if (fmu != null) {
                fmu.variableAccessor.setBoolean(req.valueReference, req.value)
                statusReply(fmu.lastStatus, responseObserver)
            } else {
                LOG.warn("No fmu with id: {}", id)
                statusReply(Fmi2Status.Error, responseObserver)
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
                statusReply(Fmi2Status.Error, responseObserver)
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
                statusReply(Fmi2Status.Error, responseObserver)
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


    inner class {{fmuName}}ServiceImpl: {{fmuName}}ServiceGrpc.{{fmuName}}ServiceImplBase() {

        {{dynamicMethods}}

    }
}

