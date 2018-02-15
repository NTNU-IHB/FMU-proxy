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

package no.mechatronics.sfi.grpc_fmu;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import no.mechatronics.sfi.fmi4j.FmiSimulation;
import no.mechatronics.sfi.fmi4j.fmu.FmuBuilder;
import no.mechatronics.sfi.fmi4j.fmu.FmuFile;
import no.mechatronics.sfi.fmi4j.proxy.enums.Fmi2Status;
import no.mechatronics.sfi.fmi4j.modeldescription.*;
import no.mechatronics.sfi.fmi4j.modeldescription.variables.*;

/**
 * Auto-generated class
 *
 * @author Lars Ivar Hatledal
 */
public class {{fmuName}}Server {

    private final static Logger LOG = LoggerFactory.getLogger({{fmuName}}Server.class);

    private Server server;
    private final FmuFile fmuFile;
    private final FmuBuilder builder;
    private final SimpleModelDescription modelDescription;
    private final Map<Integer, FmiSimulation> fmus;

    public {{fmuName}}Server() throws IOException {
        this.fmus = new HashMap<>();
        this.fmuFile = new FmuFile(getClass().getClassLoader().getResource("{{fmuName}}.fmu"));
        this.modelDescription = this.fmuFile.getModelDescription();
        this.builder = new FmuBuilder(this.fmuFile);
    }

    public String getGuid() {
        return modelDescription.getGuid();
    }

    public String getModelDescriptionXml() {
        return fmuFile.getModelDescriptionXml();
    }

    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
            .addService(new GenericServiceImpl())
            .addService(new {{fmuName}}ServiceImpl())
            .build()
            .start();

        LOG.info("FMU listening for connections on port: {}", port);
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
        disposeFmus();
    }

    public void disposeFmus() {
        for (FmiSimulation fmu : fmus.values()) {
            disposeFmu(fmu);
        }
        fmus.clear();
    }

    public void disposeFmu(FmiSimulation fmu) {
        try {
            fmu.terminate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static void statusReply(Fmi2Status status, StreamObserver<FmiDefinitions.Status> responseObserver) {
        statusReply(FmiDefinitions.Status.newBuilder()
            .setCode(status.getCode())
            .setValue(status.name())
            .build(), responseObserver);
    }

    private static void statusReply(FmiDefinitions.Status status, StreamObserver<FmiDefinitions.Status> responseObserver) {
        responseObserver.onNext(status);
        responseObserver.onCompleted();
    }

    private class GenericServiceImpl extends GenericFmuServiceGrpc.GenericFmuServiceImplBase {

        private final AtomicInteger idGenerator = new AtomicInteger(0);

        @Override
        public void createInstance(FmiDefinitions.Empty req, StreamObserver<FmiDefinitions.UInt> responseObserver) {

            int id = idGenerator.incrementAndGet();
            fmus.put(id, builder.asCoSimulationFmu().newInstance());

            FmiDefinitions.UInt reply = FmiDefinitions.UInt.newBuilder().setValue(id).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getGuid(FmiDefinitions.Empty request, StreamObserver<FmiDefinitions.Str> responseObserver) {

            String guid = modelDescription.getGuid();
            FmiDefinitions.Str reply = FmiDefinitions.Str.newBuilder().setValue(guid).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getModelName(FmiDefinitions.Empty req, StreamObserver<FmiDefinitions.Str> responseObserver) {

            String modelName = modelDescription.getModelName();
            FmiDefinitions.Str reply = FmiDefinitions.Str.newBuilder().setValue(modelName).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getCurrentTime(FmiDefinitions.UInt req, StreamObserver<FmiDefinitions.Real> responseObserver) {

            int id = req.getValue();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(fmu.getCurrentTime()).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }

            responseObserver.onCompleted();

        }

        @Override
        public void isTerminated(FmiDefinitions.UInt req, StreamObserver<FmiDefinitions.Bool> responseObserver) {

            int id = req.getValue();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(fmu.isTerminated()).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }

            responseObserver.onCompleted();

        }

        @Override
        public void getModelVariables(FmiDefinitions.Empty req, StreamObserver<FmiDefinitions.ScalarVariable> responseObserver) {

            for (TypedScalarVariable variable : modelDescription.getModelVariables()) {
                FmiDefinitions.ScalarVariable var = FmiDefinitions.ScalarVariable.newBuilder()
                        .setValueReference(variable.getValueReference())
                        .setName(variable.getName())
                        .setDescription(variable.getDescription())
                        .setVariableType(getType(variable))
                        .setCausality(getCausality(variable))
                        .setVariability(getVariability(variable))
                        .setStart(getStart(variable))
                        .build();
                responseObserver.onNext(var);
            }

            responseObserver.onCompleted();

        }

        @Override
        public void readInteger(FmiDefinitions.ReadRequest req, StreamObserver<FmiDefinitions.Int> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                int valueReference = req.getValueReference();
                responseObserver.onNext(FmiDefinitions.Int.newBuilder().setValue(fmu.getVariableAccessor().getInteger(valueReference)).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void bulkReadInteger(FmiDefinitions.BulkReadRequest request, StreamObserver<FmiDefinitions.IntList> responseObserver) {

            int id = request.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                FmiDefinitions.IntList.Builder listBuilder = FmiDefinitions.IntList.newBuilder();
                for (int value : fmu.getVariableAccessor().getInteger(toIntArray(request.getValueReferencesList()))) {
                    listBuilder.addValues(value);
                }
                responseObserver.onNext(listBuilder.build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void readReal(FmiDefinitions.ReadRequest req, StreamObserver<FmiDefinitions.Real> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                int valueReference = req.getValueReference();
                responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(fmu.getVariableAccessor().getReal(valueReference)).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void bulkReadReal(FmiDefinitions.BulkReadRequest request, StreamObserver<FmiDefinitions.RealList> responseObserver) {

            int id = request.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                FmiDefinitions.RealList.Builder listBuilder = FmiDefinitions.RealList.newBuilder();
                for (double value : fmu.getVariableAccessor().getReal(toIntArray(request.getValueReferencesList()))) {
                    listBuilder.addValues(value);
                }
                responseObserver.onNext(listBuilder.build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void readString(FmiDefinitions.ReadRequest req, StreamObserver<FmiDefinitions.Str> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                int valueReference = req.getValueReference();
                responseObserver.onNext(FmiDefinitions.Str.newBuilder().setValue(fmu.getVariableAccessor().getString(valueReference)).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void bulkReadString(FmiDefinitions.BulkReadRequest request, StreamObserver<FmiDefinitions.StrList> responseObserver) {

            int id = request.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                FmiDefinitions.StrList.Builder listBuilder = FmiDefinitions.StrList.newBuilder();
                for (String value : fmu.getVariableAccessor().getString(toIntArray(request.getValueReferencesList()))) {
                    listBuilder.addValues(value);
                }
                responseObserver.onNext(listBuilder.build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void readBoolean(FmiDefinitions.ReadRequest req, StreamObserver<FmiDefinitions.Bool> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                int valueReference = req.getValueReference();
                responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(fmu.getVariableAccessor().getBoolean(valueReference)).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void bulkReadBoolean(FmiDefinitions.BulkReadRequest request, StreamObserver<FmiDefinitions.BoolList> responseObserver) {

            int id = request.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                FmiDefinitions.BoolList.Builder listBuilder = FmiDefinitions.BoolList.newBuilder();
                for (boolean value : fmu.getVariableAccessor().getBoolean(toIntArray(request.getValueReferencesList()))) {
                    listBuilder.addValues(value);
                }
                responseObserver.onNext(listBuilder.build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void writeInteger(FmiDefinitions.WriteIntegerRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                fmu.getVariableAccessor().setInteger(req.getValueReference(), req.getValue());
                statusReply(fmu.getLastStatus(), responseObserver);
            } else {
                LOG.warn("No fmu with id: {}", id);
                statusReply(Fmi2Status.Error, responseObserver);
            }

        }

        @Override
        public void writeReal(FmiDefinitions.WriteRealRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                fmu.getVariableAccessor().setReal(req.getValueReference(), req.getValue());
                statusReply(fmu.getLastStatus(), responseObserver);
            } else {
                LOG.warn("No fmu with id: {}", id);
                statusReply(Fmi2Status.Error, responseObserver);
            }

        }

        @Override
        public void writeString(FmiDefinitions.WriteStringRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                fmu.getVariableAccessor().setString(req.getValueReference(), req.getValue());
                statusReply(fmu.getLastStatus(), responseObserver);
            } else {
                LOG.warn("No fmu with id: {}", id);
                statusReply(Fmi2Status.Error, responseObserver);
            }

        }

        @Override
        public void writeBoolean(FmiDefinitions.WriteBooleanRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                fmu.getVariableAccessor().setBoolean(req.getValueReference(), req.getValue());
                statusReply(fmu.getLastStatus(), responseObserver);
            } else {
                LOG.warn("No fmu with id: {}", id);
                statusReply(Fmi2Status.Error, responseObserver);
            }

        }

        @Override
        public void init(FmiDefinitions.InitRequest req, StreamObserver<FmiDefinitions.Bool> responseObserver) {

            boolean init = false;
            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                double start = req.getStart();
                double stop = req.getStop();
                boolean hasStart = start > 0;
                boolean hasStop = stop > 0 && stop > start;
                if (hasStart && hasStop) {
                    init = fmus.get(id).init(start, stop);
                } else if (hasStart && hasStop) {
                    init = fmus.get(id).init(start);
                } else {
                    init = fmus.get(id).init();
                }
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            FmiDefinitions.Bool reply = FmiDefinitions.Bool.newBuilder().setValue(init).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void step(FmiDefinitions.StepRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getFmuId();
            double dt = req.getDt();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                fmu.doStep(dt);
                statusReply(fmu.getLastStatus(), responseObserver);
            } else {
                LOG.warn("No fmu with id: {}", id);
                statusReply(Fmi2Status.Error, responseObserver);
            }

        }

        @Override
        public void terminate(FmiDefinitions.UInt req, StreamObserver<FmiDefinitions.Bool> responseObserver) {

            boolean flag = false;
            int id = req.getValue();
            FmiSimulation fmu = fmus.remove(id);
            if (fmu != null) {
                LOG.info("Removed fmu instance from list");
                try {
                    flag = fmu.terminate();
                    LOG.info("Terminated fmu with success: {}", flag);
                } catch (java.lang.Exception ex) {
                    ex.printStackTrace();
                } catch (java.lang.Error ex) {
                    ex.printStackTrace();
                }
            } else {
                LOG.warn("No fmu with id: {}", id);
            }

            FmiDefinitions.Bool reply = FmiDefinitions.Bool.newBuilder().setValue(flag).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void reset(FmiDefinitions.UInt req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getValue();
            FmiSimulation fmu = fmus.remove(id);
            if (fmu != null) {
                fmu.reset();
                statusReply(fmu.getLastStatus(), responseObserver);
            } else {
                LOG.warn("No fmu with id: {}", id);
                statusReply(Fmi2Status.Error, responseObserver);
            }

        }

    }

        private static FmiDefinitions.Causality getCausality(TypedScalarVariable variable) {

            switch (variable.getCausality()) {
                case INPUT: return FmiDefinitions.Causality.INPUT;
                case OUTPUT: return FmiDefinitions.Causality.OUTPUT;
                case CALCULATED_PARAMETER: return FmiDefinitions.Causality.CALCULATED_PARAMETER;
                case PARAMETER: return FmiDefinitions.Causality.PARAMETER;
                case LOCAL: return FmiDefinitions.Causality.LOCAL;
                case INDEPENDENT: return FmiDefinitions.Causality.INDEPENDENT;
                default: return FmiDefinitions.Causality.UNDEFINED_CAUSALITY;
            }

        }

        private static FmiDefinitions.Variability getVariability(TypedScalarVariable variable) {

            switch (variable.getVariability()) {
                case CONSTANT: return FmiDefinitions.Variability.CONSTANT;
                case CONTINUOUS: return FmiDefinitions.Variability.CONTINUOUS;
                case DISCRETE: return FmiDefinitions.Variability.DISCRETE;
                case FIXED: return FmiDefinitions.Variability.FIXED;
                case TUNABLE: return FmiDefinitions.Variability.TUNABLE;
                default: return FmiDefinitions.Variability.UNDEFINED_VARIABILITY;
            }

        }

        private static FmiDefinitions.Initial getInitial(TypedScalarVariable variable) {

            switch (variable.getInitial()) {
                case CALCULATED: return FmiDefinitions.Initial.CALCULATED;
                case EXACT: return FmiDefinitions.Initial.EXACT;
                case APPROX: return FmiDefinitions.Initial.APPROX;
                default: return FmiDefinitions.Initial.UNDEFINED_INITIAL;
            }

        }

        private static FmiDefinitions.AnyPrimitive getStart(TypedScalarVariable variable) {

            if (variable.getStart() == null) {
                return FmiDefinitions.AnyPrimitive.getDefaultInstance();
            }

            FmiDefinitions.AnyPrimitive.Builder builder = FmiDefinitions.AnyPrimitive.newBuilder();
            if (variable instanceof IntegerVariable) {
                builder.setIntValue(((IntegerVariable) variable).getStart());
            } else if (variable instanceof RealVariable) {
                builder.setRealValue(((RealVariable) variable).getStart());
            } else if (variable instanceof StringVariable) {
                builder.setStrValue(((StringVariable) variable).getStart());
            } else if (variable instanceof BooleanVariable) {
                builder.setBoolValue(((BooleanVariable) variable).getStart());
            } else {
                throw new UnsupportedOperationException("Variable type not supported: " + variable.getClass().getSimpleName());
            }
            return builder.build();
        }

        private static FmiDefinitions.VariableType getType(TypedScalarVariable variable) {
            String typeName = variable.getTypeName();
            switch (typeName) {
                case "Integer": return (FmiDefinitions.VariableType.INTEGER);
                case "Real": return (FmiDefinitions.VariableType.REAL);
                case "String": return (FmiDefinitions.VariableType.STRING);
                case "Boolean": return (FmiDefinitions.VariableType.BOOLEAN);
                default: throw new UnsupportedOperationException("Variable type not supported: " + typeName);
            }

        }

        private static int[] toIntArray(List<Integer> list) {
             int[] result = new int[list.size()];
             for (int i = 0; i < list.size(); i++) {
                 result[i] = list.get(i);
             }
             return result;
        }


private class {{fmuName}}ServiceImpl extends {{fmuName}}ServiceGrpc.{{fmuName}}ServiceImplBase {

            {{dynamicMethods}}

    }

}