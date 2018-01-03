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

package no.mechatronics.sfi.grpc_fmu.templates

object ServerTemplate {

    class ServerCode(
            val main: String,
            val server: String
    )

    fun generateClass(packageName: String, fmuName: String, dynamicMethods: String) = ServerCode(
            main = MainTemplate.generate(packageName, fmuName),
            server = generateServerClass(packageName, fmuName, dynamicMethods))


    private fun generateServerClass(packageName: String, fmuName: String, dynamicMethods: String): String {

        return """
   
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
            
package ${packageName};

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import no.mechatronics.sfi.fmi4j.FmiSimulation;
import no.mechatronics.sfi.fmi4j.FmuBuilder;
import no.mechatronics.sfi.fmi4j.FmuFile;
import no.mechatronics.sfi.fmi4j.proxy.enums.Fmi2Status;
import no.mechatronics.sfi.fmi4j.modeldescription.ModelVariables;
import no.mechatronics.sfi.fmi4j.modeldescription.ScalarVariable;
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription;
import ${packageName}.${fmuName}Proto.*;

public class ${fmuName}Server {

    private Server server;
    private final FmuFile fmuFile;
    private final FmuBuilder builder;
    private final ModelDescription modelDescription;
    private final Map<Integer, FmiSimulation> fmus;

    public ${fmuName}Server() throws IOException {

        this.fmus = new HashMap<>();
        this.fmuFile = new FmuFile(getClass().getClassLoader().getResource("${fmuName}.fmu"));
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
                .addService(new ServiceImpl())
                .build()
                .start();

        System.out.println("FMU listening for connections on port: " + port);

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

    private static void statusReply(Fmi2Status status, StreamObserver<Status> responseObserver) {
        Status reply = Status.newBuilder()
                            .setCode(status.getCode())
                            .setValue(status.name())
                            .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private static void Read(FmiSimulation fmu, String varName, Var.Builder builder) {

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

     private static Fmi2Status Write(FmiSimulation fmu, VarWrite var) {

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

    private class ServiceImpl extends ${fmuName}ServiceGrpc.Abstract${fmuName}Service {

        private final AtomicInteger refGenerator;

        public ServiceImpl() {
            this.refGenerator = new AtomicInteger(0);
        }

        @Override
        public void createInstance(Empty req, StreamObserver<ModelReference> responseObserver) {

            int ref = refGenerator.incrementAndGet();
            fmus.put(ref, builder.asCoSimulationFmu().newInstance());


            ModelReference reply = ModelReference.newBuilder().setFmuId(ref).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getModelName(Empty req, StreamObserver<Str> responseObserver) {

            String modelName = modelDescription.getModelName();

            Str reply = Str.newBuilder().setValue(modelName).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getCurrentTime(ModelReference req, StreamObserver<Real> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());

            Real reply = Real.newBuilder().setValue(fmu.getCurrentTime()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void isTerminated(ModelReference req, StreamObserver<Bool> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());

            Bool reply = Bool.newBuilder().setValue(fmu.isTerminated()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void read(VarRead req, StreamObserver<Var> responseObserver) {

            int ref = req.getFmuId();
            String varName = req.getVarName();

            FmiSimulation fmu = fmus.get(ref);
            Var.Builder builder = Var.newBuilder();
            Read(fmu, varName, builder);
            Var reply = builder.build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void write(VarWrite req, StreamObserver<Status> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());
            statusReply(Write(fmu, req), responseObserver);

        }

        @Override
        public void getModelVariableNames(Empty req, StreamObserver<StrList> responseObserver) {

            List<String> modelVariableNames = modelDescription.getModelVariables().getVariableNames();

            StrList.Builder builder = StrList.newBuilder();
            for (String name : modelVariableNames) {
                builder.addValues(name);
            }

            StrList reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void getModelVariables(Empty req, StreamObserver<ScalarVariables> responseObserver) {

            ModelVariables variables = modelDescription.getModelVariables();

            ScalarVariables.Builder builder = ScalarVariables.newBuilder();
            for (ScalarVariable variable : variables) {
                builder.addValues(${fmuName}Proto.ScalarVariable.newBuilder()
                                    .setName(variable.getName())
                                    .build());
            }

            ScalarVariables reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void init(InitRequest req, StreamObserver<Bool> responseObserver) {

            int ref = req.getFmuId();
            double start = req.getStart();
            boolean init = fmus.get(ref).init();
            Bool reply = Bool.newBuilder().setValue(init).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void step(StepRequest req, StreamObserver<Status> responseObserver) {

            int ref = req.getFmuId();
            double dt = req.getDt();
            FmiSimulation fmu = fmus.get(ref);
            fmu.doStep(dt);
            statusReply(fmu.getLastStatus(), responseObserver);

        }

        @Override
        public void terminate(TerminateRequest req, StreamObserver<Empty> responseObserver) {

            int ref = req.getFmuId();
            try {
                fmus.get(ref).terminate();
            } catch (java.lang.Exception ex) {
                ex.printStackTrace();
            } finally {
                fmus.remove(ref);
            }

        }

        ${dynamicMethods}

    }

}
            
        """
    }


    fun generateWrite(varName1: String, varName2: String, dataType: String): String {
        return """

        @Override
        public void write${varName2} (${dataType}Write req, StreamObserver<Status> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());
            statusReply(fmu.write("${varName1}").with(req.getValue()), responseObserver);

        }

            """
    }

    fun generateRead(varName1: String, varName2: String, primitive1: String, primitive2: String, returnType: String): String {

        return """

        @Override
        public void read${varName2}(ModelReference req, StreamObserver<${returnType}> responseObserver) {

            FmiSimulation fmu = fmus.get(req.getFmuId());
            ${primitive1} read = fmu.read("${varName1}").as${primitive2}();
            ${returnType} reply = ${returnType}.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

            """

    }

}



