package no.mechatronics.sfi.grpc_fmu;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.8.0)",
    comments = "Source: service.proto")
public final class PipeFlowServiceGrpc {

  private PipeFlowServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.grpc_fmu.PipeFlowService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> METHOD_CREATE_INSTANCE = getCreateInstanceMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> getCreateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = PipeFlowServiceGrpc.getCreateInstanceMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getCreateInstanceMethod = PipeFlowServiceGrpc.getCreateInstanceMethod) == null) {
          PipeFlowServiceGrpc.getCreateInstanceMethod = getCreateInstanceMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("CreateInstance"))
                  .build();
          }
        }
     }
     return getCreateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> METHOD_GET_MODEL_NAME = getGetModelNameMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetModelNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetModelNameMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetModelNameMethod;
    if ((getGetModelNameMethod = PipeFlowServiceGrpc.getGetModelNameMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getGetModelNameMethod = PipeFlowServiceGrpc.getGetModelNameMethod) == null) {
          PipeFlowServiceGrpc.getGetModelNameMethod = getGetModelNameMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "GetModelName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("GetModelName"))
                  .build();
          }
        }
     }
     return getGetModelNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelVariableNamesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> METHOD_GET_MODEL_VARIABLE_NAMES = getGetModelVariableNamesMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> getGetModelVariableNamesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> getGetModelVariableNamesMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> getGetModelVariableNamesMethod;
    if ((getGetModelVariableNamesMethod = PipeFlowServiceGrpc.getGetModelVariableNamesMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getGetModelVariableNamesMethod = PipeFlowServiceGrpc.getGetModelVariableNamesMethod) == null) {
          PipeFlowServiceGrpc.getGetModelVariableNamesMethod = getGetModelVariableNamesMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "GetModelVariableNames"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("GetModelVariableNames"))
                  .build();
          }
        }
     }
     return getGetModelVariableNamesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelVariablesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> METHOD_GET_MODEL_VARIABLES = getGetModelVariablesMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> getGetModelVariablesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> getGetModelVariablesMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> getGetModelVariablesMethod;
    if ((getGetModelVariablesMethod = PipeFlowServiceGrpc.getGetModelVariablesMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getGetModelVariablesMethod = PipeFlowServiceGrpc.getGetModelVariablesMethod) == null) {
          PipeFlowServiceGrpc.getGetModelVariablesMethod = getGetModelVariablesMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "GetModelVariables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("GetModelVariables"))
                  .build();
          }
        }
     }
     return getGetModelVariablesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCurrentTimeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_GET_CURRENT_TIME = getGetCurrentTimeMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getGetCurrentTimeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getGetCurrentTimeMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getGetCurrentTimeMethod;
    if ((getGetCurrentTimeMethod = PipeFlowServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = PipeFlowServiceGrpc.getGetCurrentTimeMethod) == null) {
          PipeFlowServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("GetCurrentTime"))
                  .build();
          }
        }
     }
     return getGetCurrentTimeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsTerminatedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> METHOD_IS_TERMINATED = getIsTerminatedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getIsTerminatedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getIsTerminatedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getIsTerminatedMethod;
    if ((getIsTerminatedMethod = PipeFlowServiceGrpc.getIsTerminatedMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getIsTerminatedMethod = PipeFlowServiceGrpc.getIsTerminatedMethod) == null) {
          PipeFlowServiceGrpc.getIsTerminatedMethod = getIsTerminatedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "IsTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("IsTerminated"))
                  .build();
          }
        }
     }
     return getIsTerminatedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> METHOD_INIT = getInitMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getInitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getInitMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getInitMethod;
    if ((getInitMethod = PipeFlowServiceGrpc.getInitMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getInitMethod = PipeFlowServiceGrpc.getInitMethod) == null) {
          PipeFlowServiceGrpc.getInitMethod = getInitMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("Init"))
                  .build();
          }
        }
     }
     return getInitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStepMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_STEP = getStepMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getStepMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getStepMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getStepMethod;
    if ((getStepMethod = PipeFlowServiceGrpc.getStepMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getStepMethod = PipeFlowServiceGrpc.getStepMethod) == null) {
          PipeFlowServiceGrpc.getStepMethod = getStepMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "Step"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("Step"))
                  .build();
          }
        }
     }
     return getStepMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTerminateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> METHOD_TERMINATE = getTerminateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> getTerminateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> getTerminateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> getTerminateMethod;
    if ((getTerminateMethod = PipeFlowServiceGrpc.getTerminateMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getTerminateMethod = PipeFlowServiceGrpc.getTerminateMethod) == null) {
          PipeFlowServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> METHOD_READ = getReadMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> getReadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> getReadMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> getReadMethod;
    if ((getReadMethod = PipeFlowServiceGrpc.getReadMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getReadMethod = PipeFlowServiceGrpc.getReadMethod) == null) {
          PipeFlowServiceGrpc.getReadMethod = getReadMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("Read"))
                  .build();
          }
        }
     }
     return getReadMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE = getWriteMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMethod;
    if ((getWriteMethod = PipeFlowServiceGrpc.getWriteMethod) == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        if ((getWriteMethod = PipeFlowServiceGrpc.getWriteMethod) == null) {
          PipeFlowServiceGrpc.getWriteMethod = getWriteMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PipeFlowService", "Write"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PipeFlowServiceMethodDescriptorSupplier("Write"))
                  .build();
          }
        }
     }
     return getWriteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PipeFlowServiceStub newStub(io.grpc.Channel channel) {
    return new PipeFlowServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PipeFlowServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PipeFlowServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PipeFlowServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PipeFlowServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PipeFlowServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createInstance(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
    }

    /**
     */
    public void getModelName(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelNameMethod(), responseObserver);
    }

    /**
     */
    public void getModelVariableNames(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelVariableNamesMethod(), responseObserver);
    }

    /**
     */
    public void getModelVariables(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelVariablesMethod(), responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTimeMethod(), responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getIsTerminatedMethod(), responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getInitMethod(), responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getStepMethod(), responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getTerminateMethod(), responseObserver);
    }

    /**
     */
    public void read(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     */
    public void write(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateInstanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getGetModelNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>(
                  this, METHODID_GET_MODEL_NAME)))
          .addMethod(
            getGetModelVariableNamesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList>(
                  this, METHODID_GET_MODEL_VARIABLE_NAMES)))
          .addMethod(
            getGetModelVariablesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables>(
                  this, METHODID_GET_MODEL_VARIABLES)))
          .addMethod(
            getGetCurrentTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_GET_CURRENT_TIME)))
          .addMethod(
            getIsTerminatedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>(
                  this, METHODID_IS_TERMINATED)))
          .addMethod(
            getInitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>(
                  this, METHODID_INIT)))
          .addMethod(
            getStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_STEP)))
          .addMethod(
            getTerminateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty>(
                  this, METHODID_TERMINATE)))
          .addMethod(
            getReadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var>(
                  this, METHODID_READ)))
          .addMethod(
            getWriteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE)))
          .build();
    }
  }

  /**
   */
  public static final class PipeFlowServiceStub extends io.grpc.stub.AbstractStub<PipeFlowServiceStub> {
    private PipeFlowServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PipeFlowServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipeFlowServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PipeFlowServiceStub(channel, callOptions);
    }

    /**
     */
    public void createInstance(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelName(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelVariableNames(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelVariableNamesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelVariables(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelVariablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsTerminatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void write(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PipeFlowServiceBlockingStub extends io.grpc.stub.AbstractStub<PipeFlowServiceBlockingStub> {
    private PipeFlowServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PipeFlowServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipeFlowServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PipeFlowServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference createInstance(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str getModelName(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList getModelVariableNames(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelVariableNamesMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables getModelVariables(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelVariablesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real getCurrentTime(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool isTerminated(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), getIsTerminatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool init(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest request) {
      return blockingUnaryCall(
          getChannel(), getInitMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status step(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest request) {
      return blockingUnaryCall(
          getChannel(), getStepMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty terminate(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest request) {
      return blockingUnaryCall(
          getChannel(), getTerminateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var read(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead request) {
      return blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status write(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PipeFlowServiceFutureStub extends io.grpc.stub.AbstractStub<PipeFlowServiceFutureStub> {
    private PipeFlowServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PipeFlowServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipeFlowServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PipeFlowServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference> createInstance(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getModelName(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList> getModelVariableNames(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelVariableNamesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables> getModelVariables(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelVariablesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getCurrentTime(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> isTerminated(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(getIsTerminatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> init(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> step(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty> terminate(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var> read(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> write(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE = 0;
  private static final int METHODID_GET_MODEL_NAME = 1;
  private static final int METHODID_GET_MODEL_VARIABLE_NAMES = 2;
  private static final int METHODID_GET_MODEL_VARIABLES = 3;
  private static final int METHODID_GET_CURRENT_TIME = 4;
  private static final int METHODID_IS_TERMINATED = 5;
  private static final int METHODID_INIT = 6;
  private static final int METHODID_STEP = 7;
  private static final int METHODID_TERMINATE = 8;
  private static final int METHODID_READ = 9;
  private static final int METHODID_WRITE = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PipeFlowServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PipeFlowServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference>) responseObserver);
          break;
        case METHODID_GET_MODEL_NAME:
          serviceImpl.getModelName((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLE_NAMES:
          serviceImpl.getModelVariableNames((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLES:
          serviceImpl.getModelVariables((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_IS_TERMINATED:
          serviceImpl.isTerminated((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_STEP:
          serviceImpl.step((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_TERMINATE:
          serviceImpl.terminate((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var>) responseObserver);
          break;
        case METHODID_WRITE:
          serviceImpl.write((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PipeFlowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PipeFlowServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return no.mechatronics.sfi.grpc_fmu.PipeFlowProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PipeFlowService");
    }
  }

  private static final class PipeFlowServiceFileDescriptorSupplier
      extends PipeFlowServiceBaseDescriptorSupplier {
    PipeFlowServiceFileDescriptorSupplier() {}
  }

  private static final class PipeFlowServiceMethodDescriptorSupplier
      extends PipeFlowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PipeFlowServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PipeFlowServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PipeFlowServiceFileDescriptorSupplier())
              .addMethod(getCreateInstanceMethod())
              .addMethod(getGetModelNameMethod())
              .addMethod(getGetModelVariableNamesMethod())
              .addMethod(getGetModelVariablesMethod())
              .addMethod(getGetCurrentTimeMethod())
              .addMethod(getIsTerminatedMethod())
              .addMethod(getInitMethod())
              .addMethod(getStepMethod())
              .addMethod(getTerminateMethod())
              .addMethod(getReadMethod())
              .addMethod(getWriteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
