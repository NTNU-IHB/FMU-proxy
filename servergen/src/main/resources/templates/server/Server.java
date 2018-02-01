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

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import no.mechatronics.sfi.fmi4j.FmiSimulation;
import no.mechatronics.sfi.fmi4j.fmu.FmuBuilder;
import no.mechatronics.sfi.fmi4j.fmu.FmuFile;
import no.mechatronics.sfi.fmi4j.proxy.enums.Fmi2Status;
import no.mechatronics.sfi.fmi4j.modeldescription.*;
import no.mechatronics.sfi.fmi4j.misc.*;

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
        this.modelDescription = ModelDescriptionParser.parse(fmuFile.getModelDescriptionXml());
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

            for (ScalarVariable variable : modelDescription.getModelVariables()) {
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
        public void readInt(FmiDefinitions.ReadRequest req, StreamObserver<FmiDefinitions.Int> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                IntReader reader = fmu.getReader(req.getValueReference()).asIntReader();
                responseObserver.onNext(FmiDefinitions.Int.newBuilder().setValue(reader.read()).build());
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
                RealReader reader = fmu.getReader(req.getValueReference()).asRealReader();
                responseObserver.onNext(FmiDefinitions.Real.newBuilder().setValue(reader.read()).build());
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
                StringReader reader = fmu.getReader(req.getValueReference()).asStringReader();
                responseObserver.onNext(FmiDefinitions.Str.newBuilder().setValue(reader.read()).build());
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
                BooleanReader reader = fmu.getReader(req.getValueReference()).asBooleanReader();
                responseObserver.onNext(FmiDefinitions.Bool.newBuilder().setValue(reader.read()).build());
            } else {
                LOG.warn("No fmu with id: {}", id);
            }
            responseObserver.onCompleted();

        }

        @Override
        public void writeInt(FmiDefinitions.WriteIntRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int id = req.getFmuId();
            FmiSimulation fmu = fmus.get(id);
            if (fmu != null) {
                int valueReference = req.getValueReference();
                Fmi2Status status = fmu.getWriter(valueReference).asIntWriter().write(req.getValue());
                statusReply(status, responseObserver);
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
                int valueReference = req.getValueReference();
                Fmi2Status status = fmu.getWriter(valueReference).asRealWriter().write(req.getValue());
                statusReply(status, responseObserver);
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
                int valueReference = req.getValueReference();
                Fmi2Status status = fmu.getWriter(valueReference).asStringWriter().write(req.getValue());
                statusReply(status, responseObserver);
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
                int valueReference = req.getValueReference();
                Fmi2Status status = fmu.getWriter(valueReference).asBooleanWriter().write(req.getValue());
                statusReply(status, responseObserver);
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

        private FmiDefinitions.Causality getCausality(ScalarVariable variable) {

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

        private FmiDefinitions.Variability getVariability(ScalarVariable variable) {

            switch (variable.getVariability()) {
                case CONSTANT: return FmiDefinitions.Variability.CONSTANT;
                case CONTINUOUS: return FmiDefinitions.Variability.CONTINUOUS;
                case DISCRETE: return FmiDefinitions.Variability.DISCRETE;
                case FIXED: return FmiDefinitions.Variability.FIXED;
                case TUNABLE: return FmiDefinitions.Variability.TUNABLE;
                default: return FmiDefinitions.Variability.UNDEFINED_VARIABILITY;
            }

        }

        private FmiDefinitions.Initial getInitial(ScalarVariable variable) {

            switch (variable.getInitial()) {
                case CALCULATED: return FmiDefinitions.Initial.CALCULATED;
                case EXACT: return FmiDefinitions.Initial.EXACT;
                case APPROX: return FmiDefinitions.Initial.APPROX;
                default: return FmiDefinitions.Initial.UNDEFINED_INITIAL;
            }

        }

        private FmiDefinitions.AnyPrimitive getStart(ScalarVariable variable) {

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

        private FmiDefinitions.VariableType getType(ScalarVariable variable) {
            String typeName = ScalarVariable.Companion.getTypeName(variable);
            switch (typeName) {
                case "Integer": return (FmiDefinitions.VariableType.INTEGER);
                case "Real": return (FmiDefinitions.VariableType.REAL);
                case "String": return (FmiDefinitions.VariableType.STRING);
                case "Boolean": return (FmiDefinitions.VariableType.BOOLEAN);
                default: throw new UnsupportedOperationException("Variable type not supported: " + typeName);
            }

        }


private class {{fmuName}}ServiceImpl extends {{fmuName}}ServiceGrpc.{{fmuName}}ServiceImplBase {

            {{dynamicMethods}}

    }

}