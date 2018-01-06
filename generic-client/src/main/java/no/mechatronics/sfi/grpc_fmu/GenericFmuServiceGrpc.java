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
public final class GenericFmuServiceGrpc {

  private GenericFmuServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.grpc_fmu.GenericFmuService";

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
    if ((getCreateInstanceMethod = GenericFmuServiceGrpc.getCreateInstanceMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getCreateInstanceMethod = GenericFmuServiceGrpc.getCreateInstanceMethod) == null) {
          GenericFmuServiceGrpc.getCreateInstanceMethod = getCreateInstanceMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("CreateInstance"))
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
    if ((getGetModelNameMethod = GenericFmuServiceGrpc.getGetModelNameMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelNameMethod = GenericFmuServiceGrpc.getGetModelNameMethod) == null) {
          GenericFmuServiceGrpc.getGetModelNameMethod = getGetModelNameMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetModelName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelName"))
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
    if ((getGetModelVariableNamesMethod = GenericFmuServiceGrpc.getGetModelVariableNamesMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelVariableNamesMethod = GenericFmuServiceGrpc.getGetModelVariableNamesMethod) == null) {
          GenericFmuServiceGrpc.getGetModelVariableNamesMethod = getGetModelVariableNamesMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetModelVariableNames"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrList.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelVariableNames"))
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
    if ((getGetModelVariablesMethod = GenericFmuServiceGrpc.getGetModelVariablesMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelVariablesMethod = GenericFmuServiceGrpc.getGetModelVariablesMethod) == null) {
          GenericFmuServiceGrpc.getGetModelVariablesMethod = getGetModelVariablesMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetModelVariables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariables.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelVariables"))
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
    if ((getGetCurrentTimeMethod = GenericFmuServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = GenericFmuServiceGrpc.getGetCurrentTimeMethod) == null) {
          GenericFmuServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetCurrentTime"))
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
    if ((getIsTerminatedMethod = GenericFmuServiceGrpc.getIsTerminatedMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getIsTerminatedMethod = GenericFmuServiceGrpc.getIsTerminatedMethod) == null) {
          GenericFmuServiceGrpc.getIsTerminatedMethod = getIsTerminatedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "IsTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelReference.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("IsTerminated"))
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
    if ((getInitMethod = GenericFmuServiceGrpc.getInitMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getInitMethod = GenericFmuServiceGrpc.getInitMethod) == null) {
          GenericFmuServiceGrpc.getInitMethod = getInitMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.InitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Init"))
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
    if ((getStepMethod = GenericFmuServiceGrpc.getStepMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getStepMethod = GenericFmuServiceGrpc.getStepMethod) == null) {
          GenericFmuServiceGrpc.getStepMethod = getStepMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Step"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Step"))
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
    if ((getTerminateMethod = GenericFmuServiceGrpc.getTerminateMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getTerminateMethod = GenericFmuServiceGrpc.getTerminateMethod) == null) {
          GenericFmuServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.TerminateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getResetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_RESET = getResetMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getResetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getResetMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getResetMethod;
    if ((getResetMethod = GenericFmuServiceGrpc.getResetMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getResetMethod = GenericFmuServiceGrpc.getResetMethod) == null) {
          GenericFmuServiceGrpc.getResetMethod = getResetMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Reset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Reset"))
                  .build();
          }
        }
     }
     return getResetMethod;
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
    if ((getReadMethod = GenericFmuServiceGrpc.getReadMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadMethod = GenericFmuServiceGrpc.getReadMethod) == null) {
          GenericFmuServiceGrpc.getReadMethod = getReadMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarRead.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Var.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Read"))
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
    if ((getWriteMethod = GenericFmuServiceGrpc.getWriteMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteMethod = GenericFmuServiceGrpc.getWriteMethod) == null) {
          GenericFmuServiceGrpc.getWriteMethod = getWriteMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Write"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.VarWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Write"))
                  .build();
          }
        }
     }
     return getWriteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GenericFmuServiceStub newStub(io.grpc.Channel channel) {
    return new GenericFmuServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GenericFmuServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GenericFmuServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GenericFmuServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GenericFmuServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GenericFmuServiceImplBase implements io.grpc.BindableService {

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
    public void reset(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getResetMethod(), responseObserver);
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
            getResetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_RESET)))
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
  public static final class GenericFmuServiceStub extends io.grpc.stub.AbstractStub<GenericFmuServiceStub> {
    private GenericFmuServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GenericFmuServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenericFmuServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GenericFmuServiceStub(channel, callOptions);
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
    public void reset(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request, responseObserver);
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
  public static final class GenericFmuServiceBlockingStub extends io.grpc.stub.AbstractStub<GenericFmuServiceBlockingStub> {
    private GenericFmuServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GenericFmuServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenericFmuServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GenericFmuServiceBlockingStub(channel, callOptions);
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
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status reset(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest request) {
      return blockingUnaryCall(
          getChannel(), getResetMethod(), getCallOptions(), request);
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
  public static final class GenericFmuServiceFutureStub extends io.grpc.stub.AbstractStub<GenericFmuServiceFutureStub> {
    private GenericFmuServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GenericFmuServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenericFmuServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GenericFmuServiceFutureStub(channel, callOptions);
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> reset(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request);
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
  private static final int METHODID_RESET = 9;
  private static final int METHODID_READ = 10;
  private static final int METHODID_WRITE = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GenericFmuServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GenericFmuServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_RESET:
          serviceImpl.reset((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ResetRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
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

  private static abstract class GenericFmuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GenericFmuServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return no.mechatronics.sfi.grpc_fmu.GenericFmuProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GenericFmuService");
    }
  }

  private static final class GenericFmuServiceFileDescriptorSupplier
      extends GenericFmuServiceBaseDescriptorSupplier {
    GenericFmuServiceFileDescriptorSupplier() {}
  }

  private static final class GenericFmuServiceMethodDescriptorSupplier
      extends GenericFmuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GenericFmuServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GenericFmuServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GenericFmuServiceFileDescriptorSupplier())
              .addMethod(getCreateInstanceMethod())
              .addMethod(getGetModelNameMethod())
              .addMethod(getGetModelVariableNamesMethod())
              .addMethod(getGetModelVariablesMethod())
              .addMethod(getGetCurrentTimeMethod())
              .addMethod(getIsTerminatedMethod())
              .addMethod(getInitMethod())
              .addMethod(getStepMethod())
              .addMethod(getTerminateMethod())
              .addMethod(getResetMethod())
              .addMethod(getReadMethod())
              .addMethod(getWriteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
