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

import io.grpc.Status
import io.grpc.stub.StreamObserver
import no.ntnu.ihb.fmi4j.FmiStatus
import no.ntnu.ihb.fmi4j.SlaveInstance
import no.ntnu.ihb.fmi4j.importer.AbstractFmu
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionParser
import no.ntnu.ihb.fmi4j.modeldescription.RealArray
import no.ntnu.ihb.fmi4j.modeldescription.StringArray
import no.ntnu.ihb.fmuproxy.FmuId
import no.ntnu.ihb.fmuproxy.InstanceId
import no.ntnu.ihb.fmuproxy.fmu.FmuSlaves
import no.ntnu.ihb.fmuproxy.grpc.FmuServiceGrpc
import no.ntnu.ihb.fmuproxy.grpc.Service
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URL

/**
 *
 * @author Lars Ivar Hatledal
 */
class GrpcFmuServiceImpl(
        private val fmus: MutableMap<FmuId, AbstractFmu>
) : FmuServiceGrpc.FmuServiceImplBase() {

    private inline fun getFmu(fmuId: FmuId, responseObserver: StreamObserver<*>, block: AbstractFmu.() -> Unit) {
        synchronized(fmus) {
            fmus[fmuId]?.apply(block) ?: noSuchFmuReply(fmuId, responseObserver)
        }
    }

    private inline fun getSlave(instanceId: InstanceId, responseObserver: StreamObserver<*>, block: SlaveInstance.() -> Unit) {
        FmuSlaves[instanceId]?.apply(block) ?: noSuchInstanceReply(instanceId, responseObserver)
    }

    override fun loadFromUrl(request: Service.Url, responseObserver: StreamObserver<Service.FmuId>) {
        val url = URL(request.url)
        val md = ModelDescriptionParser.parseModelDescription(url)
        val guid = md.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                val fmu = AbstractFmu.from(url)
                fmus[guid] = fmu
                LOG.info("Loaded new FMU '${fmu.modelDescription.modelName}' with guid=$guid!")
            } else {
                LOG.debug("FMU with guid=$guid already loaded, re-using it!")
            }
            responseObserver.onNext(Service.FmuId.newBuilder()
                    .setValue(guid).build())
            responseObserver.onCompleted()
        }
    }

    override fun loadFromFile(request: Service.File, responseObserver: StreamObserver<Service.FmuId>) {
        val fmu = AbstractFmu.from(request.name, request.data.toByteArray())
        val guid = fmu.guid
        synchronized(fmus) {
            if (guid !in fmus) {
                fmus[guid] = fmu
                LOG.info("Loaded new FMU '${fmu.modelDescription.modelName}' with guid=$guid!")
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
            responseObserver.onNext(modelDescription.asCoSimulationModelDescription().protoType())
            responseObserver.onCompleted()
        }
    }

    override fun createInstance(request: Service.CreateInstanceRequest, responseObserver: StreamObserver<Service.InstanceId>) {

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
        LOG.trace("setupExperiment called")
        getSlave(request.instanceId, responseObserver) {
            setup(request.start, request.stop, request.tolerance)
            statusReply(lastStatus, responseObserver)
        }
    }

    override fun enterInitializationMode(request: Service.EnterInitializationModeRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        LOG.trace("enterInitializationMode called")
        getSlave(request.instanceId, responseObserver) {
            enterInitializationMode()
            statusReply(lastStatus, responseObserver)
        }
    }

    override fun exitInitializationMode(request: Service.ExitInitializationModeRequest, responseObserver: StreamObserver<Service.StatusResponse>) {
        LOG.trace("exitInitializationMode called")
        getSlave(request.instanceId, responseObserver) {
            exitInitializationMode()
            statusReply(lastStatus, responseObserver)
        }
    }

    override fun step(request: Service.StepRequest, responseObserver: StreamObserver<Service.StepResponse>) {
        LOG.trace("step called, with stepSize=${request.stepSize}")
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
        LOG.trace("terminate called")
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
