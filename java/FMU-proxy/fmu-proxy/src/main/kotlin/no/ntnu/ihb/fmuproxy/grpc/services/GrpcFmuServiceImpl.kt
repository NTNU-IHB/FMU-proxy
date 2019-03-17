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

package no.ntnu.ihb.fmuproxy.grpc.services

import com.google.protobuf.ByteString
import io.grpc.Status
import io.grpc.stub.StreamObserver
import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.common.FmuSlave
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmi4j.modeldescription.CoSimulationAttributes
import no.ntnu.ihb.fmi4j.modeldescription.RealArray
import no.ntnu.ihb.fmi4j.modeldescription.StringArray
import no.ntnu.ihb.fmi4j.modeldescription.jacskon.JacksonModelDescriptionParser
import no.ntnu.ihb.fmi4j.solvers.apache.ApacheSolvers
import no.ntnu.ihb.fmuproxy.fmu.FmuSlaves
import no.ntnu.ihb.fmuproxy.grpc.FmuServiceGrpc
import no.ntnu.ihb.fmuproxy.grpc.Service
import no.ntnu.ihb.fmuproxy.solver.parseSolver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URL
import java.nio.file.Files

/**
 *
 * @author Lars Ivar Hatledal
 */
class GrpcFmuServiceImpl(
        private val fmus: MutableMap<String, Fmu>
) : FmuServiceGrpc.FmuServiceImplBase() {

    private inline fun getFmu(fmuId: String, responseObserver: StreamObserver<*>, block: Fmu.() -> Unit) {
        synchronized(fmus) {
            fmus[fmuId]?.apply(block) ?: noSuchFmuReply(fmuId, responseObserver)
        }
    }

    private inline fun getSlave(instanceId: String, responseObserver: StreamObserver<*>, block: FmuSlave.() -> Unit) {
        FmuSlaves[instanceId]?.apply(block) ?: noSuchInstanceReply(instanceId, responseObserver)
    }

    override fun loadFromUrl(request: Service.Url, responseObserver: StreamObserver<Service.FmuId>) {
        val url = URL(request.url)
        val md = JacksonModelDescriptionParser.parse(url)
        val guid = md.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                val fmu = Fmu.from(url)
                fmus[guid] = fmu
                LOG.info("Loaded new FMU with guid=$guid!")
            } else {
                LOG.debug("FMU with guid=$guid already loaded, re-using it!")
            }
            responseObserver.onNext(Service.FmuId.newBuilder()
                    .setValue(guid).build())
            responseObserver.onCompleted()
        }
    }

    override fun loadFromFile(request: Service.File, responseObserver: StreamObserver<Service.FmuId>) {
        val fmu = Fmu.from(request.name, request.data.toByteArray())
        val guid = fmu.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                fmus[guid] = fmu
                LOG.info("Loaded new FMU with guid=$guid!")
            } else {
                fmu.close()
                LOG.debug("FMU with guid=$guid already loaded, re-using it!")
            }
            responseObserver.onNext(Service.FmuId.newBuilder()
                    .setValue(guid).build())
            responseObserver.onCompleted()
        }
    }

    override fun getModelDescription(request: Service.GetModelDescriptionRequest, responseObserver: StreamObserver<Service.ModelDescription>) {
        getFmu(request.fmuId, responseObserver) {
            responseObserver.onNext(modelDescription.protoType())
            responseObserver.onCompleted()
        }
    }

    override fun canCreateInstanceFromCS(request: Service.CanCreateInstanceFromCSRequest, responseObserver: StreamObserver<Service.Bool>) {
        getFmu(request.fmuId, responseObserver) {
            responseObserver.onNext(supportsCoSimulation.protoType())
            responseObserver.onCompleted()
        }
    }

    override fun canCreateInstanceFromME(request: Service.CanCreateInstanceFromMERequest, responseObserver: StreamObserver<Service.Bool>) {
        getFmu(request.fmuId, responseObserver) {
            responseObserver.onNext(supportsModelExchange.protoType())
            responseObserver.onCompleted()
        }
    }

    override fun createInstanceFromCS(request: Service.CreateInstanceFromCSRequest, responseObserver: StreamObserver<Service.InstanceId>) {

        getFmu(request.fmuId, responseObserver) {
            if (!supportsCoSimulation) {
                unSupportedOperationException(responseObserver, "FMU does not support Co-simulation!")
            } else {
                FmuSlaves.put(asCoSimulationFmu().newInstance()).also { id ->
                    Service.InstanceId.newBuilder().setValue(id).also {
                        responseObserver.onNext(it.build())
                        responseObserver.onCompleted()
                    }
                }
            }
        }
    }

    override fun createInstanceFromME(request: Service.CreateInstanceFromMERequest, responseObserver: StreamObserver<Service.InstanceId>) {

        getFmu(request.fmuId, responseObserver) {
            if (!supportsModelExchange) {
                unSupportedOperationException(responseObserver, "FMU does not support Model Exchange!")
            } else {
                fun selectDefaultIntegrator(): no.ntnu.ihb.fmi4j.solvers.Solver {
                    val stepSize = modelDescription.defaultExperiment?.stepSize ?: 1E-3
                    LOG.warn("No valid solver found.. Defaulting to Euler with $stepSize stepSize")
                    return ApacheSolvers.euler(stepSize)
                }

                (parseSolver(request.solver.name, request.solver.settings) ?: selectDefaultIntegrator()).let {
                    FmuSlaves.put(asModelExchangeFmu().newInstance(it)).also { id ->
                        Service.InstanceId.newBuilder().setValue(id).also {
                            responseObserver.onNext(it.build())
                            responseObserver.onCompleted()
                        }
                    }
                }

            }
        }
    }

    override fun getCoSimulationAttributes(request: Service.GetCoSimulationAttributesRequest, responseObserver: StreamObserver<Service.CoSimulationAttributes>) {
        getSlave(request.instanceId, responseObserver) {
            responseObserver.onNext((modelDescription as CoSimulationAttributes).protoType())
            responseObserver.onCompleted()
        }
    }

    override fun readInteger(request: Service.ReadRequest, responseObserver: StreamObserver<Service.IntegerRead>) {

        getSlave(request.instanceId, responseObserver) {
            val vr = request.valueReferencesList.toLongArray()
            val values = IntArray(vr.size)
            val status = read(vr, values)
            Service.IntegerRead.newBuilder().setStatus(status.protoType()).apply {
                values.forEach { addValues(it) }
                responseObserver.onNext(build())
                responseObserver.onCompleted()
            }
        }
    }

    override fun readReal(request: Service.ReadRequest, responseObserver: StreamObserver<Service.RealRead>) {
        getSlave(request.instanceId, responseObserver) {
            val vr = request.valueReferencesList.toLongArray()
            val values = RealArray(vr.size)
            val status = read(vr, values)
            Service.RealRead.newBuilder().setStatus(status.protoType()).apply {
                values.forEach { addValues(it) }
                responseObserver.onNext(build())
                responseObserver.onCompleted()
            }
        }
    }

    override fun readString(request: Service.ReadRequest, responseObserver: StreamObserver<Service.StringRead>) {
        getSlave(request.instanceId, responseObserver) {
            val vr = request.valueReferencesList.toLongArray()
            val values = StringArray(vr.size) { "" }
            val status = read(vr, values)
            Service.StringRead.newBuilder().setStatus(status.protoType()).apply {
                values.forEach { addValues(it) }
                responseObserver.onNext(build())
                responseObserver.onCompleted()
            }
        }
    }

    override fun readBoolean(request: Service.ReadRequest, responseObserver: StreamObserver<Service.BooleanRead>) {
        getSlave(request.instanceId, responseObserver) {
            val vr = request.valueReferencesList.toLongArray()
            val values = BooleanArray(vr.size)
            val status = read(vr, values)
            Service.BooleanRead.newBuilder().setStatus(status.protoType()).apply {
                values.forEach { addValues(it) }
                responseObserver.onNext(build())
                responseObserver.onCompleted()
            }
        }
    }

    override fun writeInteger(request: Service.WriteIntegerRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            val status = write(request.valueReferencesList.toLongArray(), request.valuesList.toIntArray())
            statusReply(status, responseObserver)
        }
    }

    override fun writeReal(request: Service.WriteRealRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            val status = write(request.valueReferencesList.toLongArray(), request.valuesList.toDoubleArray())
            statusReply(status, responseObserver)
        }
    }

    override fun writeString(request: Service.WriteStringRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            val status = write(request.valueReferencesList.toLongArray(), request.valuesList.toTypedArray())
            statusReply(status, responseObserver)
        }
    }

    override fun writeBoolean(request: Service.WriteBooleanRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            val status = write(request.valueReferencesList.toLongArray(), request.valuesList.toBooleanArray())
            statusReply(status, responseObserver)
        }
    }


    override fun setupExperiment(request: Service.SetupExperimentRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            setup(request.start, request.stop, request.tolerance)
            statusReply(lastStatus, responseObserver)
        }
    }

    override fun enterInitializationMode(request: Service.EnterInitializationModeRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            enterInitializationMode()
            statusReply(lastStatus, responseObserver)
        }
    }

    override fun exitInitializationMode(request: Service.ExitInitializationModeRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            exitInitializationMode()
            statusReply(lastStatus, responseObserver)
        }
    }

    override fun step(request: Service.StepRequest, responseObserver: StreamObserver<Service.StepResponse>) {
        getSlave(request.instanceId, responseObserver) {
            doStep(request.stepSize)
            Service.StepResponse.newBuilder()
                    .setSimulationTime(simulationTime)
                    .setStatus(lastStatus.protoType()).also {
                        responseObserver.onNext(it.build())
                        responseObserver.onCompleted()
                    }

        }
    }

    override fun terminate(request: Service.TerminateRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            terminate()
            lastStatus.also { status ->
                LOG.debug("Terminated fmu with status: $status")
                statusReply(status, responseObserver)
            }
        }
    }

    override fun reset(request: Service.ResetRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            reset().also {
                statusReply(lastStatus, responseObserver)
            }
        }
    }

    override fun getFMUstate(request: Service.GetFMUstateRequest, responseObserver: StreamObserver<Service.GetFMUstateResponse>) {
        getSlave(request.instanceId, responseObserver) {
            if (!modelDescription.attributes.canGetAndSetFMUstate) {
                unSupportedOperationException(responseObserver, "FMU does not have capability 'canGetAndSetFMUstate'!")
            } else {

                Service.GetFMUstateResponse.newBuilder()
                        .setState(getFMUstate())
                        .setStatus(lastStatus.protoType()).also {
                            responseObserver.onNext(it.build())
                            responseObserver.onCompleted()
                        }

            }
        }
    }

    override fun setFMUstate(request: Service.SetFMUstateRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            if (!modelDescription.attributes.canGetAndSetFMUstate) {
                unSupportedOperationException(responseObserver, "FMU does not have capability 'canGetAndSetFMUstate'!")
            } else {

                setFMUstate(request.state)
                statusReply(lastStatus, responseObserver)

            }
        }
    }

    override fun freeFMUstate(request: Service.FreeFMUstateRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        getSlave(request.instanceId, responseObserver) {
            if (!modelDescription.attributes.canGetAndSetFMUstate) {
                unSupportedOperationException(responseObserver, "FMU does not have capability 'canGetAndSetFMUstate'!")
            } else {

                freeFMUstate(request.state)
                statusReply(lastStatus, responseObserver)

            }
        }
    }

    override fun serializeFMUstate(request: Service.SerializeFMUstateRequest, responseObserver: StreamObserver<Service.SerializeFMUstateResponse>) {
        getSlave(request.instanceId, responseObserver) {
            if (!modelDescription.attributes.canSerializeFMUstate) {
                unSupportedOperationException(responseObserver, "FMU does not have capability 'canSerializeFMUstate'!")
            } else {

                Service.SerializeFMUstateResponse.newBuilder()
                        .setState(ByteString.copyFrom(serializeFMUstate(request.state)))
                        .setStatus(lastStatus.protoType()).also {
                            responseObserver.onNext(it.build())
                            responseObserver.onCompleted()
                        }

            }
        }
    }

    override fun deSerializeFMUstate(request: Service.DeSerializeFMUstateRequest, responseObserver: StreamObserver<Service.DeSerializeFMUstateResponse>) {
        getSlave(request.instanceId, responseObserver) {

            if (!modelDescription.attributes.canSerializeFMUstate) {
                unSupportedOperationException(responseObserver, "FMU does not have capability 'canSerializeFMUstate'!")
            } else {

                Service.DeSerializeFMUstateResponse.newBuilder()
                        .setState(getFMUstate())
                        .setStatus(lastStatus.protoType()).also {
                            responseObserver.onNext(it.build())
                            responseObserver.onCompleted()
                        }
            }
        }
    }

    override fun getDirectionalDerivative(request: Service.GetDirectionalDerivativeRequest, responseObserver: StreamObserver<Service.GetDirectionalDerivativeResponse>) {
        getSlave(request.instanceId, responseObserver) {

            if (!modelDescription.attributes.providesDirectionalDerivative) {
                unSupportedOperationException(responseObserver, "FMU does not provide directional derivatives!")
            } else {

                val vUnknownRef = request.vUnknownRefList.toLongArray()
                val vKnownRef = request.vKnownRefList.toLongArray()
                val dvKnownRef = request.dvKnownRefList.toDoubleArray()
                val dvUnknownRef = getDirectionalDerivative(vUnknownRef, vKnownRef, dvKnownRef)

                Service.GetDirectionalDerivativeResponse.newBuilder().apply {
                    status = lastStatus.protoType()
                    dvUnknownRef.forEach {
                        addDvUnknownRef(it)
                    }
                }.also {
                    responseObserver.onNext(it.build())
                    responseObserver.onCompleted()
                }

            }
        }
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
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .augmentDescription("NoSuchFmuException")
                    .withDescription("No FMU with id=$id!")
                    .asRuntimeException()
            )
        }


        fun noSuchInstanceReply(id: String, responseObserver: StreamObserver<*>) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .augmentDescription("NoSuchInstanceException")
                    .withDescription("No instance with id=$id!")
                    .asRuntimeException()
            )
        }

        fun unSupportedOperationException(responseObserver: StreamObserver<*>, description: String) {
            responseObserver.onError(Status.UNAVAILABLE
                    .augmentDescription("UnsupportedOperationException")
                    .withDescription(description)
                    .asRuntimeException())
        }


    }

}


