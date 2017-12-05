package no.mechatronics.sfi.grpc_fmu.templates

object ServerTemplate {
    
    fun generateWrite(varName1: String, varName2: String, dataType: String): String {
        return """
            
            @Override
            public void write${varName2} (${dataType}Write req, StreamObserver<Status> responseObserver) {

                Fmi2Simulation fmu = fmus.get(req.getFmuId());
                statusReply(fmu.write("${varName1}").with(req.getValue()), responseObserver);

            }

            """
    }

    fun generateRead(varName1: String, varName2: String, primitive1: String, primitive2: String, returnType: String): String {

        return """

            @Override
            public void read${varName2}(ModelReference req, StreamObserver<${returnType}> responseObserver) {
    
                Fmi2Simulation fmu = fmus.get(req.getFmuId());
                ${primitive1} read = fmu.read("${varName1}").as${primitive2}();
                ${returnType} reply = ${returnType}.newBuilder().setValue(read).build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
    
            } 
            
            """
        
    }
    
    fun generateBody(packageName: String, fmuName: String, dynamicMethods: String): String {
        
        return """
            
            package ${packageName};

            import java.util.Map;
            import java.util.HashMap;
            import java.util.List;
            import io.grpc.Server;
            import io.grpc.ServerBuilder;
            import io.grpc.stub.StreamObserver;
            import java.io.IOException;
            import java.net.ServerSocket;
            import java.util.Scanner;
            import java.util.concurrent.atomic.AtomicInteger;
            import no.mechatronics.sfi.fmi4j.Fmi2Simulation;
            import no.mechatronics.sfi.fmi4j.misc.FmuFile;
            import no.mechatronics.sfi.fmi4j.CoSimulationFmu;
            import no.mechatronics.sfi.fmi4j.jna.enums.Fmi2Status;
            import no.mechatronics.sfi.fmi4j.modeldescription.ModelVariables;
            import no.mechatronics.sfi.fmi4j.modeldescription.ScalarVariable;
            import ${packageName}.${fmuName}Proto.*;
            
            public class ${fmuName}Server {
            
            
                public static void main(String args[]) throws IOException, InterruptedException {
            
                    final ${fmuName}Server server = new ${fmuName}Server();
                    server.start(findAvailablePort());
            
                    new Thread(() -> {
            
                        System.out.println("Press any key to stop application");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNext()) {
                            System.out.println("Key pressed, stopping application..");
                            server.stop();
                        }
            
                    }).start();
            
                    server.blockUntilShutdown();
            
                }
            
                private Server server;
                private final FmuFile fmuFile;
                private final Fmi2Simulation referenceFmu;
                private final Map<Integer, Fmi2Simulation> fmus;
                
                private ${fmuName}Server() throws IOException {
            
                    this.fmus = new HashMap<>();
                    this.fmuFile = new FmuFile(${fmuName}Server.class.getClassLoader().getResource("${fmuName}.fmu"));
                    this.referenceFmu = new CoSimulationFmu(this.fmuFile);
            
                }
            
                private void start(int port) throws IOException {
            
                    server = ServerBuilder.forPort(port)
                            .addService(new ServiceImpl())
                            .build()
                            .start();
            
                    System.out.println("Port: " + port);
            
                }
            
                private void stop() {
            
                    if (server != null) {
                        server.shutdown();
                    }
                    disposeFmus();
            
                }
            
                private void disposeFmus() {
                
                    disposeFmu(referenceFmu);
                    for (Fmi2Simulation fmu : fmus.values()) {
                        disposeFmu(fmu);
                    }
                    fmus.clear();
                    
                }
            
                private void disposeFmu(Fmi2Simulation fmu) {
            
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
                private void blockUntilShutdown() throws InterruptedException {
            
                    if (server != null) {
                        server.awaitTermination();
                    }
            
                }
            
                private static int findAvailablePort() throws IOException {
            
                    try (ServerSocket ss = new ServerSocket(0)) {
                        return ss.getLocalPort();
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
            
                private static void Read(Fmi2Simulation fmu, String varName, Var.Builder builder) {
            
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
            
                 private static Fmi2Status Write(Fmi2Simulation fmu, VarWrite var) {
                    
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
                        fmus.put(ref, new CoSimulationFmu(fmuFile));
            
                        
                        ModelReference reply = ModelReference.newBuilder().setFmuId(ref).build();
                        responseObserver.onNext(reply);
                        responseObserver.onCompleted();
            
                    }
            
                    @Override 
                    public void getModelName(Empty req, StreamObserver<Str> responseObserver) {
                        
                        String modelName = referenceFmu.getModelDescription().getModelName();
                        
                        Str reply = Str.newBuilder().setValue(modelName).build();
                        responseObserver.onNext(reply);
                        responseObserver.onCompleted();
            
                    }
            
                    @Override 
                    public void getCurrentTime(ModelReference req, StreamObserver<Real> responseObserver) {
                        
                        Fmi2Simulation fmu = fmus.get(req.getFmuId());
                        
                        Real reply = Real.newBuilder().setValue(fmu.getCurrentTime()).build();
                        responseObserver.onNext(reply);
                        responseObserver.onCompleted();
            
                    }
            
                    @Override 
                    public void isTerminated(ModelReference req, StreamObserver<Bool> responseObserver) {
                        
                        Fmi2Simulation fmu = fmus.get(req.getFmuId());
                        
                        Bool reply = Bool.newBuilder().setValue(fmu.isTerminated()).build();
                        responseObserver.onNext(reply);
                        responseObserver.onCompleted();
            
                    }
            
                    @Override 
                    public void read(VarRead req, StreamObserver<Var> responseObserver) {
                        
                        int ref = req.getFmuId();
                        String varName = req.getVarName();
            
                        Fmi2Simulation fmu = fmus.get(ref);
                        Var.Builder builder = Var.newBuilder();
                        Read(fmu, varName, builder);
                        Var reply = builder.build();
                        
                        responseObserver.onNext(reply);
                        responseObserver.onCompleted();
            
                    }
            
                    @Override 
                    public void write(VarWrite req, StreamObserver<Status> responseObserver) {
                        
                        Fmi2Simulation fmu = fmus.get(req.getFmuId());
                        statusReply(Write(fmu, req), responseObserver);
            
                    }
            
                    @Override 
                    public void getModelVariableNames(Empty req, StreamObserver<StrList> responseObserver) {
                        
                        List<String> modelVariableNames = referenceFmu.getModelVariables().getVariableNames();
                        
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
                        
                        ModelVariables variables = referenceFmu.getModelVariables();
                        
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
                        Fmi2Simulation fmu = fmus.get(ref);
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
    
}