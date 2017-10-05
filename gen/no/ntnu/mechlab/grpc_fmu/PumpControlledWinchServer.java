package no.ntnu.mechlab.grpc_fmu;

import java.util.Map;
import java.util.HashMap;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import org.javafmi.wrapper.Simulation;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.*;

public class PumpControlledWinchServer {


    public static void main(String args[]) throws IOException, InterruptedException {

        final PumpControlledWinchServer server = new PumpControlledWinchServer();
        server.start(findAvailablePort());

        new Thread(() -> {

            Scanner sc = new Scanner(System.in);
            if (sc.hasNext()) {
                server.stop();
            }

        }).start();

        server.blockUntilShutdown();

    }


    private Server server;
    
    private final Simulation referenceFmu;
    private final Map<Integer, Simulation> fmus;
    
    private PumpControlledWinchServer() {

        this.fmus = new HashMap<>();
        this.referenceFmu = new Simulation("PumpControlledWinch.fmu");

    }

    private void start(int port) throws IOException {

  

        server = ServerBuilder.forPort(port)
                .addService(new ServiceImpl())
                .build()
                .start();

        System.out.println("port: " + port);

    }

    private void stop() {

        if (server != null) {
            server.shutdown();
        }
        disposeFmus();

    }

    private void disposeFmus() {
    
        disposeFmu(referenceFmu);
        for (Simulation fmu : fmus.values()) {
            disposeFmu(fmu);
        }
        fmus.clear();
        
    }

    private void disposeFmu(Simulation fmu) {

        try {
            fmu.terminate();
        } catch (Exception ex) {
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

    private static void statusReply(org.javafmi.proxy.Status status, StreamObserver<Status> responseObserver) {
        Status reply = Status.newBuilder()
                            .setCode(status.getCode())
                            .setValue(status.getValue())
                            .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private static void Read(Simulation fmu, String varName, Var.Builder builder) {

        String typeName = fmu.getModelDescription().getModelVariable(varName).getTypeName();
        switch(typeName) {
            case "Integer": {
                builder.setIntValue(fmu.read(varName).asInteger());
            }
            break;
            case "Real": {
                builder.setRealValue(fmu.read(varName).asDouble());
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

     private static org.javafmi.proxy.Status Write(Simulation fmu, VarWrite var) {
        
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
    
    private class ServiceImpl extends PumpControlledWinchServiceGrpc.AbstractPumpControlledWinchService {

        private final AtomicInteger refGenerator;

        public ServiceImpl() {
            this.refGenerator = new AtomicInteger(0);
        }

        @Override
        public void createInstance(Empty req, StreamObserver<ModelReference> responseObserver) {
            
            int ref = refGenerator.incrementAndGet();
            fmus.put(ref, new Simulation("PumpControlledWinch.fmu"));
            
            ModelReference reply = ModelReference.newBuilder().setRef(ref).build();
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
            
            Simulation fmu = fmus.get(req.getRef());
            
            Real reply = Real.newBuilder().setValue(fmu.getCurrentTime()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override 
        public void isTerminated(ModelReference req, StreamObserver<Bool> responseObserver) {
            
            Simulation fmu = fmus.get(req.getRef());
            
            Bool reply = Bool.newBuilder().setValue(fmu.isTerminated()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override 
        public void read(VarRead req, StreamObserver<Var> responseObserver) {
            
            int ref = req.getRef();
            String varName = req.getVarName();

            Simulation fmu = fmus.get(ref);
            Var.Builder builder = Var.newBuilder();
            Read(fmu, varName, builder);
            Var reply = builder.build();
            
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override 
        public void write(VarWrite req, StreamObserver<Status> responseObserver) {
            
            Simulation fmu = fmus.get(req.getRef());
            statusReply(Write(fmu, req), responseObserver);

        }

        @Override 
        public void getModelVariableNames(Empty req, StreamObserver<StrList> responseObserver) {
            
            String[] modelVariableNames = referenceFmu.getModelDescription().getModelVariablesNames();
            
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
            
            org.javafmi.modeldescription.ScalarVariable[] variables = referenceFmu.getModelDescription().getModelVariables();
            
            ScalarVariables.Builder builder = ScalarVariables.newBuilder();
            for (org.javafmi.modeldescription.ScalarVariable var : variables) {
                builder.addValues(ScalarVariable.newBuilder()
                                    .setName(var.getName())
                                    .build());
            }

            ScalarVariables reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        }

        @Override
        public void init(InitRequest req, StreamObserver<Status> responseObserver) {
            
            int ref = req.getRef();
            double start = req.getStart();
            statusReply(fmus.get(ref).init(start), responseObserver);

        }

        @Override
        public void step(StepRequest req, StreamObserver<Status> responseObserver) {

            int ref = req.getRef();
            double dt = req.getDt();
            statusReply(fmus.get(ref).doStep(dt), responseObserver);

        }

        @Override
        public void terminate(TerminateRequest req, StreamObserver<Status> responseObserver) {
            
            int ref = req.getRef();
            try {
                org.javafmi.proxy.Status status = fmus.get(ref).terminate();
                statusReply(status, responseObserver);
            } catch (java.lang.Error ex) {
                statusReply(org.javafmi.proxy.Status.ERROR, responseObserver);
            } finally {
                fmus.remove(ref);
            }

        }

        

        @Override
        public void readControllerSP(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.SP").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerSP (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.SP").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerMV(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.MV").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerMV (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.MV").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerOutput(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.output").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerOutput (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.output").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerK(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.K").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerK (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.K").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerTi(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.Ti").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerTi (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.Ti").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerB(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.b").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerB (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.b").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerTa(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.Ta").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerTa (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.Ta").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerMinimum(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.minimum").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerMinimum (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.minimum").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerMaximum(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.maximum").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerMaximum (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.maximum").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerOutputInitial(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.output_initial").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerOutputInitial (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.output_initial").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerError(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.error").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerError (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.error").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerPBLow(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.PB_low").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerPBLow (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.PB_low").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerPBHigh(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.PB_high").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerPBHigh (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.PB_high").with(req.getValue()), responseObserver);

        }

        @Override
        public void readDrumP1E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Drum.p1.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeDrumP1E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Drum.p1.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readDrumP1F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Drum.p1.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeDrumP1F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Drum.p1.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readDrumP2E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Drum.p2.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeDrumP2E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Drum.p2.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readDrumP2F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Drum.p2.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeDrumP2F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Drum.p2.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readDrumDrumDiameter(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Drum.DrumDiameter").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeDrumDrumDiameter (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Drum.DrumDiameter").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFlowSensorP1E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("FlowSensor.p1.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFlowSensorP1E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("FlowSensor.p1.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFlowSensorP1F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("FlowSensor.p1.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFlowSensorP1F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("FlowSensor.p1.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFlowSensorP2F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("FlowSensor.p2.F").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFlowSensorP2F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("FlowSensor.p2.F").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFlowSensorP2V(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("FlowSensor.p2.v").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFlowSensorP2V (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("FlowSensor.p2.v").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFlowSensorFlow(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("FlowSensor.flow").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFlowSensorFlow (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("FlowSensor.flow").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFrictionPE(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Friction.p.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFrictionPE (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Friction.p.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFrictionPF(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Friction.p.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFrictionPF (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Friction.p.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFrictionF(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Friction.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFrictionF (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Friction.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readFrictionLoadMass(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Friction.LoadMass").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeFrictionLoadMass (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Friction.LoadMass").with(req.getValue()), responseObserver);

        }

        @Override
        public void readGearP1E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Gear.p1.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeGearP1E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Gear.p1.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readGearP1F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Gear.p1.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeGearP1F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Gear.p1.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readGearP2E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Gear.p2.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeGearP2E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Gear.p2.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readGearP2F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Gear.p2.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeGearP2F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Gear.p2.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readGearGearRatio(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Gear.GearRatio").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeGearGearRatio (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Gear.GearRatio").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaInertia(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.Inertia").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaInertia (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.Inertia").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaDrumSpeed(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.DrumSpeed").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaDrumSpeed (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.DrumSpeed").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaDrumAngleDeg(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.DrumAngleDeg").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaDrumAngleDeg (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.DrumAngleDeg").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorP1E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.p1.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorP1E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.p1.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorP1F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.p1.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorP1F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.p1.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorP2E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.p2.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorP2E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.p2.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorP2F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.p2.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorP2F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.p2.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorMotorDisplacement(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.MotorDisplacement").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorMotorDisplacement (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.MotorDisplacement").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorMotorSpeed(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.MotorSpeed").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorMotorSpeed (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.MotorSpeed").with(req.getValue()), responseObserver);

        }

        @Override
        public void readMotorMotorFlow(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Motor.MotorFlow").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeMotorMotorFlow (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Motor.MotorFlow").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionFlow(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.flow").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionFlow (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.flow").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionP1E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.p1.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionP1E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.p1.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionP2E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.p2.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionP2E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.p2.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionP3E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.p3.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionP3E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.p3.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionP1F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.p1.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionP1F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.p1.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionP2F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.p2.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionP2F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.p2.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunctionP3F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction.p3.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunctionP3F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction.p3.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7Flow(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.flow").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7Flow (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.flow").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P1E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p1.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P1E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p1.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P2E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p2.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P2E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p2.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P3E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p3.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P3E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p3.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P4E(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p4.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P4E (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p4.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P1F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p1.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P1F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p1.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P2F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p2.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P2F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p2.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P3F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p3.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P3F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p3.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOneJunction7P4F(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OneJunction7.p4.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOneJunction7P4F (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OneJunction7.p4.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOpenTankPE(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OpenTank.p.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOpenTankPE (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OpenTank.p.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOpenTankPF(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OpenTank.p.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOpenTankPF (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OpenTank.p.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOpenTankAtomPressure(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OpenTank.AtomPressure").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOpenTankAtomPressure (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OpenTank.AtomPressure").with(req.getValue()), responseObserver);

        }

        @Override
        public void readOpenTankFlow2Tank(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("OpenTank.Flow2Tank").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeOpenTankFlow2Tank (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("OpenTank.Flow2Tank").with(req.getValue()), responseObserver);

        }

        @Override
        public void readPumpPE(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Pump.p.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writePumpPE (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Pump.p.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readPumpPF(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Pump.p.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writePumpPF (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Pump.p.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readPumpGain(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Pump.gain").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writePumpGain (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Pump.gain").with(req.getValue()), responseObserver);

        }

        @Override
        public void readPumpPumpPressureMax(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Pump.PumpPressureMax").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writePumpPumpPressureMax (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Pump.PumpPressureMax").with(req.getValue()), responseObserver);

        }

        @Override
        public void readPumpPumpFlow(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Pump.PumpFlow").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writePumpPumpFlow (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Pump.PumpFlow").with(req.getValue()), responseObserver);

        }

        @Override
        public void readPumpPumpPressure(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Pump.PumpPressure").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writePumpPumpPressure (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Pump.PumpPressure").with(req.getValue()), responseObserver);

        }

        @Override
        public void readWireF(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("wire.F").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeWireF (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("wire.F").with(req.getValue()), responseObserver);

        }

        @Override
        public void readWireV(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("wire.v").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeWireV (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("wire.v").with(req.getValue()), responseObserver);

        }

        @Override
        public void readSetPoint(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("setPoint").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeSetPoint (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("setPoint").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerUIStateDot(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.uI_state_dot").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerUIStateDot (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.uI_state_dot").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerUIState(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.uI_state").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerUIState (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.uI_state").with(req.getValue()), responseObserver);

        }

        @Override
        public void readControllerUIStateInitial(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Controller.uI_state_initial").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeControllerUIStateInitial (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Controller.uI_state_initial").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaPE(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.p.e").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaPE (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.p.e").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaMomentum(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.momentum").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaMomentum (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.momentum").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaMomentumInitial(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.momentum_initial").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaMomentumInitial (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.momentum_initial").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaPF(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.p.f").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaPF (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.p.f").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaDrumAngle(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.DrumAngle").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaDrumAngle (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.DrumAngle").with(req.getValue()), responseObserver);

        }

        @Override
        public void readInertiaDrumAngleInitial(ModelReference req, StreamObserver<Real> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            double read = fmu.read("Inertia.DrumAngle_initial").asDouble();
            Real reply = Real.newBuilder().setValue(read).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } 

        @Override
        public void writeInertiaDrumAngleInitial (RealWrite req, StreamObserver<Status> responseObserver) {

            Simulation fmu = fmus.get(req.getRef());
            statusReply(fmu.write("Inertia.DrumAngle_initial").with(req.getValue()), responseObserver);

        }


    }

}
