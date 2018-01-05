/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
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

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import no.mechatronics.sfi.fmi4j.FmiSimulation;
import no.mechatronics.sfi.fmi4j.FmuBuilder;
import no.mechatronics.sfi.fmi4j.FmuFile;
import no.mechatronics.sfi.fmi4j.proxy.enums.Fmi2Status;
import no.mechatronics.sfi.fmi4j.modeldescription.ModelVariables;
import no.mechatronics.sfi.fmi4j.modeldescription.ScalarVariable;
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription;

public class {{fmuName}}Server {

    private final static Logger LOG = LoggerFactory.getLogger({{fmuName}}Server.class);

    private Server server;
    private final FmuFile fmuFile;
    private final FmuBuilder builder;
    private final ModelDescription modelDescription;
    private final Map<Integer, FmiSimulation> fmus;

    public {{fmuName}}Server() throws IOException {

        this.fmus = new HashMap<>();
        this.fmuFile = new FmuFile(getClass().getClassLoader().getResource("{{fmuName}}.fmu"));
        this.modelDescription = ModelDescription.parseModelDescription(fmuFile.getModelDescriptionXml());
        this.builder = new FmuBuilder(this.fmuFile);

    }

    public String getGuid() {
        return modelDescription.getGuid();
    }

    public String getModelDescriptionXml() throws IOException {
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
        FmiDefinitions.Status reply = FmiDefinitions.Status.newBuilder()
            .setCode(status.getCode())
            .setValue(status.name())
            .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private static void Read(FmiSimulation fmu, String varName, FmiDefinitions.Var.Builder builder) {

        String typeName = fmu.getModelVariables().get(varName).getTypeName();
        switch(typeName) {
            case "Integer": {
                builder.setIntValue(fmu.read(varName).asInteger());
            }
            break;
            case "Real": {
                builder.setRealValue(fmu.read(varName).asReal());
            }
            break;
            case "String": {
                builder.setStrValue(fmu.read(varName).asString());
            }
            break;
            case "Boolean": {
                builder.setBoolValue(fmu.read(varName).asBoolean());
            }
            break;
        }

    }

    private static Fmi2Status Write(FmiSimulation fmu, FmiDefinitions.VarWrite var) {

        String varName = var.getVarName();
        switch (var.getValueCase()) {
            case INTVALUE: {
                return fmu.write(varName).with(var.getIntValue());
            }
            case REALVALUE: {
                return fmu.write(varName).with(var.getRealValue());
            }
            case STRVALUE: {
                return fmu.write(varName).with(var.getStrValue());
            }
            case BOOLVALUE: {
                return fmu.write(varName).with(var.getBoolValue());
            }
        }

        return null;

    }

    private class GenericServiceImpl extends GenericFmuServiceGrpc.GenericFmuServiceImplBase {

        private final AtomicInteger refGenerator = new AtomicInteger(0);


        @Override
        public void createInstance(FmiDefinitions.Empty req, StreamObserver<FmiDefinitions.ModelReference> responseObserver) {

            int ref = refGenerator.incrementAndGet();
            fmus.put(ref, builder.asCoSimulationFmu().newInstance());

            FmiDefinitions.ModelReference reply = FmiDefinitions.ModelReference.newBuilder().setFmuId(ref).build();
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
        public void getCurrentTime(FmiDefinitions.ModelReference req, StreamObserver<FmiDefinitions.Real> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());

            FmiDefinitions.Real reply = FmiDefinitions.Real.newBuilder().setValue(fmu.getCurrentTime()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void isTerminated(FmiDefinitions.ModelReference req, StreamObserver<FmiDefinitions.Bool> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());

            FmiDefinitions.Bool reply = FmiDefinitions.Bool.newBuilder().setValue(fmu.isTerminated()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void read(FmiDefinitions.VarRead req, StreamObserver<FmiDefinitions.Var> responseObserver) {

            int ref = req.getFmuId();
            String varName = req.getVarName();

            FmiSimulation fmu = fmus.get(ref);
            FmiDefinitions.Var.Builder builder = FmiDefinitions.Var.newBuilder();
            Read(fmu, varName, builder);
            FmiDefinitions.Var reply = builder.build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void write(FmiDefinitions.VarWrite req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());
            statusReply(Write(fmu, req), responseObserver);

        }

        @Override
        public void getModelVariableNames(FmiDefinitions.Empty req, StreamObserver<FmiDefinitions.StrList> responseObserver) {

            List<String> modelVariableNames = modelDescription.getModelVariables().getVariableNames();

            FmiDefinitions.StrList.Builder builder = FmiDefinitions.StrList.newBuilder();
            for (String name : modelVariableNames) {
                 builder.addValues(name);
            }

            FmiDefinitions.StrList reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getModelVariables(FmiDefinitions.Empty req, StreamObserver<FmiDefinitions.ScalarVariables> responseObserver) {

            ModelVariables variables = modelDescription.getModelVariables();

            FmiDefinitions.ScalarVariables.Builder builder = FmiDefinitions.ScalarVariables.newBuilder();
            for (ScalarVariable variable : variables) {
                builder.addValues(FmiDefinitions.ScalarVariable.newBuilder()
                    .setName(variable.getName())
                    .build());
            }

            FmiDefinitions.ScalarVariables reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void init(FmiDefinitions.InitRequest req, StreamObserver<FmiDefinitions.Bool> responseObserver) {

            int ref = req.getFmuId();
            double start = req.getStart();
            boolean init = fmus.get(ref).init();
            FmiDefinitions.Bool reply = FmiDefinitions.Bool.newBuilder().setValue(init).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void step(FmiDefinitions.StepRequest req, StreamObserver<FmiDefinitions.Status> responseObserver) {

            int ref = req.getFmuId();
            double dt = req.getDt();
            FmiSimulation fmu = fmus.get(ref);
            fmu.doStep(dt);
            statusReply(fmu.getLastStatus(), responseObserver);

        }

        @Override
        public void terminate(FmiDefinitions.TerminateRequest req, StreamObserver<FmiDefinitions.Empty> responseObserver) {

            int ref = req.getFmuId();
            FmiSimulation fmu = fmus.remove(ref);
            if (fmu != null) {
                LOG.info("Removed fmu instance from list");
                try {
                    boolean flag = fmu.terminate();
                    LOG.info("Terminated fmu with success: {}", flag);
                } catch (java.lang.Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                LOG.warn("No fmu with ref: {}", ref);
            }

            responseObserver.onNext(FmiDefinitions.Empty.getDefaultInstance());
            responseObserver.onCompleted();

        }

    }

    private class {{fmuName}}ServiceImpl extends {{fmuName}}ServiceGrpc.{{fmuName}}ServiceImplBase {

            {{dynamicMethods}}

    }

}