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

package no.mechatronics.sfi.fmuproxy.grpc.services

import io.grpc.Status
import io.grpc.stub.StreamObserver
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmuproxy.fmu.FmuSlaves
import no.mechatronics.sfi.fmuproxy.grpc.*
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class GrpcFmuServiceImpl(
        private val fmus: Map<String, Fmu>
): FmuServiceGrpc.FmuServiceImplBase() {

    constructor(fmu: Fmu): this(mapOf(fmu.guid to fmu))

    override fun getModelDescription(request: Service.GetModelDescriptionRequest, responseObserver: StreamObserver<Proto.ModelDescription>) {
        val fmuId = request.fmuId
        fmus[fmuId]?.apply {
            responseObserver.onNext(modelDescription.protoType())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)
    }

    override fun getModelDescriptionXml(request: Service.GetModelDescriptionXmlRequest, responseObserver: StreamObserver<Service.ModelDescriptionXml>) {
        val fmuId = request.fmuId
        fmus[fmuId]?.apply {
            val xml = Service.ModelDescriptionXml.newBuilder().setXml(modelDescriptionXml).build()
            responseObserver.onNext(xml)
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)
    }

    override fun readInteger(req: Service.ReadRequest, responseObserver: StreamObserver<Service.IntegerRead>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val builder = Service.IntegerRead.newBuilder()
            val read = variableAccessor.readInteger(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        }?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun readReal(req: Service.ReadRequest, responseObserver: StreamObserver<Service.RealRead>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val builder = Service.RealRead.newBuilder()
            val read = variableAccessor.readReal(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun readString(req: Service.ReadRequest, responseObserver: StreamObserver<Service.StringRead>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val builder = Service.StringRead.newBuilder()
            val read = variableAccessor.readString(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun readBoolean(req: Service.ReadRequest, responseObserver: StreamObserver<Service.BooleanRead>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val builder = Service.BooleanRead.newBuilder()
            val read = variableAccessor.readBoolean(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        } ?: noSuchInstanceReply(instanceId, responseObserver)
       

    }

    override fun writeInteger(req: Service.WriteIntegerRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val status = variableAccessor.writeInteger(req.valueReferencesList.toIntArray(), req.valuesList.toIntArray())
            statusReply(status, responseObserver)
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun writeReal(req: Service.WriteRealRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val status = variableAccessor.writeReal(req.valueReferencesList.toIntArray(), req.valuesList.toDoubleArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeString(req: Service.WriteStringRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves.get(req.instanceId)?.apply {
            val status = variableAccessor.writeString(req.valueReferencesList.toIntArray(), req.valuesList.toTypedArray())
            statusReply(status, responseObserver)
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun writeBoolean(req: Service.WriteBooleanRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val status = variableAccessor.writeBoolean(req.valueReferencesList.toIntArray(), req.valuesList.toBooleanArray())
            statusReply(status, responseObserver)
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun init(req: Service.InitRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            val start = req.start
            val stop = req.stop
            val hasStart = start > 0
            val hasStop = stop > 0 && stop > start
            if (hasStart && hasStop) {
                init(start, stop)
            } else if (hasStart && hasStop) {
                init(start)
            } else {
                init()
            }
            statusReply(lastStatus, responseObserver)
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun step(req: Service.StepRequest, responseObserver: StreamObserver<Service.StepResponse>) {
        
        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            doStep(req.stepSize)
            Service.StepResponse.newBuilder()
                    .setSimulationTime(currentTime)
                    .setStatus(lastStatus.protoType())
                    .build().also {
                        responseObserver.onNext(it)
                        responseObserver.onCompleted()
                    }

        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun terminate(req: Service.TerminateRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves.remove(instanceId)?.apply {
            terminate()
            lastStatus.also { status ->
                LOG.debug("Terminated fmu with status: $status")
                statusReply(status, responseObserver)
            }
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun reset(req: Service.ResetRequest, responseObserver: StreamObserver<Service.StatusResponse>) {

        val instanceId = req.instanceId
        FmuSlaves[instanceId]?.apply {
            reset().also {
                statusReply(lastStatus, responseObserver)
            }
        } ?: noSuchInstanceReply(instanceId, responseObserver)

    }

    override fun createInstanceFromCS(req: Service.CreateInstanceFromCSRequest, responseObserver: StreamObserver<Service.InstanceId>) {

        val fmuId = req.fmuId
        fmus[fmuId]?.apply {

            FmuSlaves.put(asCoSimulationFmu().newInstance()).also { id ->
                Service.InstanceId.newBuilder().setValue(id).build().also {
                    responseObserver.onNext(it)
                    responseObserver.onCompleted()
                }
            }

        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun createInstanceFromME(req: Service.CreateInstanceFromMERequest, responseObserver: StreamObserver<Service.InstanceId>) {

        val fmuId = req.fmuId
        fmus[fmuId]?.apply {

            fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.solvers.Solver {
                val stepSize = modelDescription.defaultExperiment?.stepSize ?: 1E-3
                LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
                return ApacheSolvers.euler(stepSize)
            }

            val solver = parseSolver(req.solver.name, req.solver.settings) ?: selectDefaultIntegrator()
            FmuSlaves.put(asModelExchangeFmu().newInstance(solver)).also { id ->
                Service.InstanceId.newBuilder().setValue(id).build().also {
                    responseObserver.onNext(it)
                    responseObserver.onCompleted()
                }
            }

        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(GrpcFmuServiceImpl::class.java)

        fun statusReply(status: FmiStatus, responseObserver: StreamObserver<Service.StatusResponse>) {
            Service.StatusResponse.newBuilder()
                    .setStatus(status.protoType())
                    .build().also {
                        responseObserver.onNext(it)
                        responseObserver.onCompleted()
                    }
        }

        fun noSuchFmuReply(id: String, responseObserver: StreamObserver<*>) {
            val message = "No FMU with id=$id!"
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .augmentDescription("NoSuchFmuException")
                            .withDescription(message)
                            .asRuntimeException()
            )
        }


        fun noSuchInstanceReply(id: String, responseObserver: StreamObserver<*>) {
            val message = "No instance with id=$id!"
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .augmentDescription("NoSuchInstanceException")
                            .withDescription(message)
                            .asRuntimeException()
            )
        }

    }


//    override fun canGetAndSetFMUstate(req: Service.UInt, responseObserver: StreamObserver<Service.Bool>) {
//        val instanceId = req.value
//        FmuSlaves[instanceId]?.apply {
//            val md = modelDescription
//            val canGetAndSetFMUstate = when (md) {
//                is CoSimulationModelDescription -> md.canGetAndSetFMUstate
//                is ModelExchangeModelDescription -> md.canGetAndSetFMUstate
//                else -> throw AssertionError("ModelDescription is not of type CS or ME?")
//            }
//            responseObserver.onNext(canGetAndSetFMUstate.protoType())
//            responseObserver.onCompleted()
//        } ?: noSuchInstanceReply(instanceId, responseObserver)
//
//    }

}


