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

import com.google.protobuf.Empty
import io.grpc.BindableService
import io.grpc.Status
import io.grpc.stub.StreamObserver
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CoSimulationModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.ModelExchangeModelDescription
import no.mechatronics.sfi.fmuproxy.fmu.Fmus
import no.mechatronics.sfi.fmuproxy.grpc.FmuServiceGrpc
import no.mechatronics.sfi.fmuproxy.grpc.GrpcFmuServer
import no.mechatronics.sfi.fmuproxy.grpc.Proto
import no.mechatronics.sfi.fmuproxy.solver.parseSolver
import no.sfi.mechatronics.fmi4j.me.ApacheSolvers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface GrpcFmuService : BindableService {

    fun statusReply(status: FmiStatus, responseObserver: StreamObserver<Proto.StatusResponse>) {
        Proto.StatusResponse.newBuilder()
                .setStatus(status.protoType())
                .build().also {
                    responseObserver.onNext(it)
                    responseObserver.onCompleted()
                }
    }
    
    fun noSuchFmuReply(id: Int, responseObserver: StreamObserver<*>) {
        val message = "No FMU with id=$id!"
        responseObserver.onError(
                Status.INVALID_ARGUMENT
                        .augmentDescription("FmuNotFoundException")
                        .withDescription(message)
                        .asRuntimeException()
        )
    }

}

class GrpcFmuServiceImpl(
        private val fmu: Fmu
): FmuServiceGrpc.FmuServiceImplBase(), GrpcFmuService {

    private val modelDescription: CommonModelDescription
            = fmu.modelDescription

    override fun getModelDescription(request: Empty, responseObserver: StreamObserver<Proto.ModelDescription>) {
        responseObserver.onNext(modelDescription.protoType())
        responseObserver.onCompleted()
    }

    override fun getModelDescriptionXml(request: Empty, responseObserver: StreamObserver<Proto.Str>) {

        Proto.Str.newBuilder().setValue(fmu.modelDescriptionXml).build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }

    }

    override fun canGetAndSetFMUstate(req: Proto.UInt, responseObserver: StreamObserver<Proto.Bool>) {
        val fmuId = req.value
        Fmus.get(fmuId)?.apply {
            val md = modelDescription
            val canGetAndSetFMUstate = when (md) {
                is CoSimulationModelDescription -> md.canGetAndSetFMUstate
                is ModelExchangeModelDescription -> md.canGetAndSetFMUstate
                else -> throw AssertionError("ModelDescription is not of type CS or ME?")
            }
            responseObserver.onNext(canGetAndSetFMUstate.protoType())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun getCurrentTime(req: Proto.UInt, responseObserver: StreamObserver<Proto.Real>) {

        val fmuId = req.value
        Fmus.get(fmuId)?.apply {
            responseObserver.onNext(currentTime.protoType())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun isTerminated(req: Proto.UInt, responseObserver: StreamObserver<Proto.Bool>) {

        val fmuId = req.value
        Fmus.get(req.value)?.apply {
            responseObserver.onNext(isTerminated.protoType())
            responseObserver.onCompleted()
        }?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun readInteger(req: Proto.ReadRequest, responseObserver: StreamObserver<Proto.IntegerRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val valueReference = req.valueReference
            val read = variableAccessor.readInteger(valueReference)
            responseObserver.onNext(Proto.IntegerRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(read.status.protoType())
                    .build())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun bulkReadInteger(req: Proto.BulkReadRequest, responseObserver: StreamObserver<Proto.BulkIntegerRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val builder = Proto.BulkIntegerRead.newBuilder()
            val read = variableAccessor.readInteger(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        }?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun readReal(req: Proto.ReadRequest, responseObserver: StreamObserver<Proto.RealRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val valueReference = req.valueReference
            val read = variableAccessor.readReal(valueReference)
            responseObserver.onNext(Proto.RealRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(read.status.protoType())
                    .build())
            responseObserver.onCompleted()
        }?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun bulkReadReal(req: Proto.BulkReadRequest, responseObserver: StreamObserver<Proto.BulkRealRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val builder = Proto.BulkRealRead.newBuilder()
            val read = variableAccessor.readReal(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun readString(req: Proto.ReadRequest, responseObserver: StreamObserver<Proto.StringRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val read = variableAccessor.readString(req.valueReference)
            responseObserver.onNext(Proto.StringRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(read.status.protoType())
                    .build())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun bulkReadString(req: Proto.BulkReadRequest, responseObserver: StreamObserver<Proto.BulkStringRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val builder = Proto.BulkStringRead.newBuilder()
            val read = variableAccessor.readString(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun readBoolean(req: Proto.ReadRequest, responseObserver: StreamObserver<Proto.BooleanRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val read = variableAccessor.readBoolean(req.valueReference)
            responseObserver.onNext(Proto.BooleanRead.newBuilder()
                    .setValue(read.value)
                    .setStatus(read.status.protoType())
                    .build())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun bulkReadBoolean(req: Proto.BulkReadRequest, responseObserver: StreamObserver<Proto.BulkBooleanRead>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val builder = Proto.BulkBooleanRead.newBuilder()
            val read = variableAccessor.readBoolean(req.valueReferencesList.toIntArray())
            builder.status = read.status.protoType()
            for (value in read.value) {
                builder.addValues(value)
            }
            responseObserver.onNext(builder.build())
            responseObserver.onCompleted()
        } ?: noSuchFmuReply(fmuId, responseObserver)
       

    }

    override fun writeInteger(req: Proto.WriteIntegerRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeInteger(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun bulkWriteInteger(req: Proto.BulkWriteIntegerRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeInteger(req.valueReferencesList.toIntArray(), req.valuesList.toIntArray())
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun writeReal(req: Proto.WriteRealRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeReal(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)


    }

    override fun bulkWriteReal(req: Proto.BulkWriteRealRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeReal(req.valueReferencesList.toIntArray(), req.valuesList.toDoubleArray())
            statusReply(status, responseObserver)
        } ?: statusReply(FmiStatus.Error, responseObserver)

    }

    override fun writeString(req: Proto.WriteStringRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeString(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)


    }

    override fun bulkWriteString(req: Proto.BulkWriteStringRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(req.fmuId)?.apply {
            val status = variableAccessor.writeString(req.valueReferencesList.toIntArray(), req.valuesList.toTypedArray())
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun writeBoolean(req: Proto.WriteBooleanRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeBoolean(req.valueReference, req.value)
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)


    }

    override fun bulkWriteBoolean(req: Proto.BulkWriteBooleanRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            val status = variableAccessor.writeBoolean(req.valueReferencesList.toIntArray(), req.valuesList.toBooleanArray())
            statusReply(status, responseObserver)
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun init(req: Proto.InitRequest, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
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
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun step(req: Proto.StepRequest, responseObserver: StreamObserver<Proto.StepResult>) {
        
        val fmuId = req.fmuId
        Fmus.get(fmuId)?.apply {
            doStep(req.stepSize)
            Proto.StepResult.newBuilder()
                    .setSimulationTime(currentTime)
                    .setStatus(lastStatus.protoType())
                    .build().also {
                        responseObserver.onNext(it)
                        responseObserver.onCompleted()
                    }

        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun terminate(req: Proto.UInt, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.value
        Fmus.remove(fmuId)?.apply {
            terminate()
            lastStatus.also { status ->
                LOG.debug("Terminated fmu with status: $status")
                statusReply(status, responseObserver)
            }
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }

    override fun reset(req: Proto.UInt, responseObserver: StreamObserver<Proto.StatusResponse>) {

        val fmuId = req.value
        Fmus.get(fmuId)?.apply {
            reset().also {
                statusReply(lastStatus, responseObserver)
            }
        } ?: noSuchFmuReply(fmuId, responseObserver)

    }


    override fun createInstanceFromCS(req: Empty, responseObserver: StreamObserver<Proto.UInt>) {

        Fmus.put(fmu.asCoSimulationFmu().newInstance()).also { id ->
            Proto.UInt.newBuilder().setValue(id).build().also {
                responseObserver.onNext(it)
                responseObserver.onCompleted()
            }
        }

    }

    override fun createInstanceFromME(req: Proto.Solver, responseObserver: StreamObserver<Proto.UInt>) {

        fun selectDefaultIntegrator(): no.mechatronics.sfi.fmi4j.importer.me.Solver {
            val stepSize = fmu.modelDescription.defaultExperiment?.stepSize ?: 1E-3
            LOG.warn("No valid integrator found.. Defaulting to Euler with $stepSize stepSize")
            return ApacheSolvers.euler(stepSize)
        }

        val integrator = parseSolver(req.name, req.settings) ?: selectDefaultIntegrator()
        Fmus.put(fmu.asModelExchangeFmu().newInstance(integrator)).also { id ->
            Proto.UInt.newBuilder().setValue(id).build().also {
                responseObserver.onNext(it)
                responseObserver.onCompleted()
            }
        }

    }

    private companion object {
        private val LOG: Logger = LoggerFactory.getLogger(GrpcFmuServer::class.java)
    }

}


