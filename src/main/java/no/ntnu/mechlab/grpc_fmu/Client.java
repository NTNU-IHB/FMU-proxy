package no.ntnu.mechlab.grpc_fmu;

import com.google.protobuf.ProtocolStringList;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var;
import no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead;
/**
 *
 * @author laht
 */
public class Client {

    private final ManagedChannel channel;
    private final PumpControlledWinchServiceGrpc.PumpControlledWinchServiceBlockingStub blockingStub;

    public Client(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build());
    }

    public Client(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = PumpControlledWinchServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public ModelReference createInstance(Empty request) {
        return blockingStub.createInstance(request);
    }

    public Str getModelName(Empty request) {
        return blockingStub.getModelName(request);
    }

    public StrList getModelVariableNames(Empty request) {
        return blockingStub.getModelVariableNames(request);
    }

    public ScalarVariables getModelVariables(Empty request) {
        return blockingStub.getModelVariables(request);
    }

    public Real getCurrentTime(ModelReference request) {
        return blockingStub.getCurrentTime(request);
    }

    public Bool isTerminated(ModelReference request) {
        return blockingStub.isTerminated(request);
    }

    public Status init(InitRequest request) {
        return blockingStub.init(request);
    }

    public Var read(VarRead request) {
        return blockingStub.read(request);
    }

    public Real readControllerMV(ModelReference request) {
        return blockingStub.readControllerMV(request);
    }

    public Real readControllerOutput(ModelReference request) {
        return blockingStub.readControllerOutput(request);
    }

    public Real readControllerK(ModelReference request) {
        return blockingStub.readControllerK(request);
    }

    public Real readControllerB(ModelReference request) {
        return blockingStub.readControllerB(request);
    }

    public Real readControllerMinimum(ModelReference request) {
        return blockingStub.readControllerMinimum(request);
    }

    public Real readControllerMaximum(ModelReference request) {
        return blockingStub.readControllerMaximum(request);
    }

    public Real readControllerOutputInitial(ModelReference request) {
        return blockingStub.readControllerOutputInitial(request);
    }

    public Real readControllerError(ModelReference request) {
        return blockingStub.readControllerError(request);
    }

    public Status step(StepRequest request) {
        return blockingStub.step(request);
    }

    public Status terminate(TerminateRequest request) {
        return blockingStub.terminate(request);
    }

    public Real readWireV(ModelReference request) {
        return blockingStub.readWireV(request);
    }

    public Status writeSetPoint(RealWrite request) {
        return blockingStub.writeSetPoint(request);
    }
    
    

    public static void main(String[] args) throws InterruptedException {

        Client client = new Client("localhost", 51300);
        try {
            System.out.println(client.getModelName(Empty.getDefaultInstance()));
            ProtocolStringList valuesList = client.getModelVariableNames(Empty.getDefaultInstance()).getValuesList();
            for (String str : valuesList) {
                System.out.println(str);
            }
            
            int ref = client.createInstance(Empty.getDefaultInstance()).getRef();
            
            client.init(InitRequest.newBuilder().setRef(ref).build());
            
            client.writeSetPoint(RealWrite.newBuilder().setRef(ref).setValue(1).build());
            for (int i = 0; i < 10; i++) {
                client.step(StepRequest.newBuilder().setRef(ref).setDt(1d/100).build());
                System.out.println(client.readWireV(ModelReference.newBuilder().setRef(ref).build()).getValue());
            }
            
            client.terminate(TerminateRequest.newBuilder().setRef(ref).build());
            
            
            
        } finally {
            client.shutdown();
        }

    }

}
