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
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> METHOD_CREATE_INSTANCE = getCreateInstanceMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = GenericFmuServiceGrpc.getCreateInstanceMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getCreateInstanceMethod = GenericFmuServiceGrpc.getCreateInstanceMethod) == null) {
          GenericFmuServiceGrpc.getCreateInstanceMethod = getCreateInstanceMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
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
  @java.lang.Deprecated // Use {@link #getGetModelVariablesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> METHOD_GET_MODEL_VARIABLES = getGetModelVariablesMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> getGetModelVariablesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> getGetModelVariablesMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> getGetModelVariablesMethod;
    if ((getGetModelVariablesMethod = GenericFmuServiceGrpc.getGetModelVariablesMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelVariablesMethod = GenericFmuServiceGrpc.getGetModelVariablesMethod) == null) {
          GenericFmuServiceGrpc.getGetModelVariablesMethod = getGetModelVariablesMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetModelVariables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelVariables"))
                  .build();
          }
        }
     }
     return getGetModelVariablesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCurrentTimeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_GET_CURRENT_TIME = getGetCurrentTimeMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getGetCurrentTimeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getGetCurrentTimeMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getGetCurrentTimeMethod;
    if ((getGetCurrentTimeMethod = GenericFmuServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = GenericFmuServiceGrpc.getGetCurrentTimeMethod) == null) {
          GenericFmuServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
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
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> METHOD_IS_TERMINATED = getIsTerminatedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getIsTerminatedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getIsTerminatedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getIsTerminatedMethod;
    if ((getIsTerminatedMethod = GenericFmuServiceGrpc.getIsTerminatedMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getIsTerminatedMethod = GenericFmuServiceGrpc.getIsTerminatedMethod) == null) {
          GenericFmuServiceGrpc.getIsTerminatedMethod = getIsTerminatedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "IsTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
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
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> METHOD_TERMINATE = getTerminateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getTerminateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getTerminateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getTerminateMethod;
    if ((getTerminateMethod = GenericFmuServiceGrpc.getTerminateMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getTerminateMethod = GenericFmuServiceGrpc.getTerminateMethod) == null) {
          GenericFmuServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getResetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_RESET = getResetMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getResetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getResetMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getResetMethod;
    if ((getResetMethod = GenericFmuServiceGrpc.getResetMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getResetMethod = GenericFmuServiceGrpc.getResetMethod) == null) {
          GenericFmuServiceGrpc.getResetMethod = getResetMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "Reset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
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
  @java.lang.Deprecated // Use {@link #getReadIntMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> METHOD_READ_INT = getReadIntMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> getReadIntMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> getReadIntMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> getReadIntMethod;
    if ((getReadIntMethod = GenericFmuServiceGrpc.getReadIntMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadIntMethod = GenericFmuServiceGrpc.getReadIntMethod) == null) {
          GenericFmuServiceGrpc.getReadIntMethod = getReadIntMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadInt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadInt"))
                  .build();
          }
        }
     }
     return getReadIntMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_REAL = getReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadRealMethod;
    if ((getReadRealMethod = GenericFmuServiceGrpc.getReadRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadRealMethod = GenericFmuServiceGrpc.getReadRealMethod) == null) {
          GenericFmuServiceGrpc.getReadRealMethod = getReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadReal"))
                  .build();
          }
        }
     }
     return getReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> METHOD_READ_STRING = getReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getReadStringMethod;
    if ((getReadStringMethod = GenericFmuServiceGrpc.getReadStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadStringMethod = GenericFmuServiceGrpc.getReadStringMethod) == null) {
          GenericFmuServiceGrpc.getReadStringMethod = getReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadString"))
                  .build();
          }
        }
     }
     return getReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> METHOD_READ_BOOLEAN = getReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> getReadBooleanMethod;
    if ((getReadBooleanMethod = GenericFmuServiceGrpc.getReadBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadBooleanMethod = GenericFmuServiceGrpc.getReadBooleanMethod) == null) {
          GenericFmuServiceGrpc.getReadBooleanMethod = getReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadBoolean"))
                  .build();
          }
        }
     }
     return getReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INT = getWriteIntMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteIntMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteIntMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteIntMethod;
    if ((getWriteIntMethod = GenericFmuServiceGrpc.getWriteIntMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteIntMethod = GenericFmuServiceGrpc.getWriteIntMethod) == null) {
          GenericFmuServiceGrpc.getWriteIntMethod = getWriteIntMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "WriteInt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteInt"))
                  .build();
          }
        }
     }
     return getWriteIntMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_REAL = getWriteRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteRealMethod;
    if ((getWriteRealMethod = GenericFmuServiceGrpc.getWriteRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteRealMethod = GenericFmuServiceGrpc.getWriteRealMethod) == null) {
          GenericFmuServiceGrpc.getWriteRealMethod = getWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "WriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteReal"))
                  .build();
          }
        }
     }
     return getWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_STRING = getWriteStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteStringMethod;
    if ((getWriteStringMethod = GenericFmuServiceGrpc.getWriteStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteStringMethod = GenericFmuServiceGrpc.getWriteStringMethod) == null) {
          GenericFmuServiceGrpc.getWriteStringMethod = getWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "WriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteString"))
                  .build();
          }
        }
     }
     return getWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_BOOLEAN = getWriteBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteBooleanMethod;
    if ((getWriteBooleanMethod = GenericFmuServiceGrpc.getWriteBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteBooleanMethod = GenericFmuServiceGrpc.getWriteBooleanMethod) == null) {
          GenericFmuServiceGrpc.getWriteBooleanMethod = getWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "WriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteBoolean"))
                  .build();
          }
        }
     }
     return getWriteBooleanMethod;
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
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> responseObserver) {
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
    public void getModelVariables(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelVariablesMethod(), responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTimeMethod(), responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
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
    public void terminate(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getTerminateMethod(), responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getResetMethod(), responseObserver);
    }

    /**
     */
    public void readInt(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntMethod(), responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRealMethod(), responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStringMethod(), responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void writeInt(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntMethod(), responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteBooleanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateInstanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getGetModelNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>(
                  this, METHODID_GET_MODEL_NAME)))
          .addMethod(
            getGetModelVariablesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable>(
                  this, METHODID_GET_MODEL_VARIABLES)))
          .addMethod(
            getGetCurrentTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_GET_CURRENT_TIME)))
          .addMethod(
            getIsTerminatedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
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
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>(
                  this, METHODID_TERMINATE)))
          .addMethod(
            getResetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_RESET)))
          .addMethod(
            getReadIntMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int>(
                  this, METHODID_READ_INT)))
          .addMethod(
            getReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_REAL)))
          .addMethod(
            getReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>(
                  this, METHODID_READ_STRING)))
          .addMethod(
            getReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>(
                  this, METHODID_READ_BOOLEAN)))
          .addMethod(
            getWriteIntMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INT)))
          .addMethod(
            getWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_REAL)))
          .addMethod(
            getWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_STRING)))
          .addMethod(
            getWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_BOOLEAN)))
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
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> responseObserver) {
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
    public void getModelVariables(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetModelVariablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
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
    public void terminate(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInt(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInt(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request, responseObserver);
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
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt createInstance(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
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
    public java.util.Iterator<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable> getModelVariables(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetModelVariablesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real getCurrentTime(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool isTerminated(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
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
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool terminate(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getTerminateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status reset(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getResetMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int readInt(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadIntMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str readString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool readBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInt(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteBooleanMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> createInstance(
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
     * <pre>
     *instance methods
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getCurrentTime(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> isTerminated(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> terminate(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> reset(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int> readInt(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readReal(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> readString(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool> readBoolean(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInt(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeReal(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeString(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeBoolean(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE = 0;
  private static final int METHODID_GET_MODEL_NAME = 1;
  private static final int METHODID_GET_MODEL_VARIABLES = 2;
  private static final int METHODID_GET_CURRENT_TIME = 3;
  private static final int METHODID_IS_TERMINATED = 4;
  private static final int METHODID_INIT = 5;
  private static final int METHODID_STEP = 6;
  private static final int METHODID_TERMINATE = 7;
  private static final int METHODID_RESET = 8;
  private static final int METHODID_READ_INT = 9;
  private static final int METHODID_READ_REAL = 10;
  private static final int METHODID_READ_STRING = 11;
  private static final int METHODID_READ_BOOLEAN = 12;
  private static final int METHODID_WRITE_INT = 13;
  private static final int METHODID_WRITE_REAL = 14;
  private static final int METHODID_WRITE_STRING = 15;
  private static final int METHODID_WRITE_BOOLEAN = 16;

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
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>) responseObserver);
          break;
        case METHODID_GET_MODEL_NAME:
          serviceImpl.getModelName((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLES:
          serviceImpl.getModelVariables((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_IS_TERMINATED:
          serviceImpl.isTerminated((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
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
          serviceImpl.terminate((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_RESET:
          serviceImpl.reset((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INT:
          serviceImpl.readInt((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Int>) responseObserver);
          break;
        case METHODID_READ_REAL:
          serviceImpl.readReal((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_READ_STRING:
          serviceImpl.readString((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_READ_BOOLEAN:
          serviceImpl.readBoolean((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_WRITE_INT:
          serviceImpl.writeInt((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_WRITE_REAL:
          serviceImpl.writeReal((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_WRITE_STRING:
          serviceImpl.writeString((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteStringRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_WRITE_BOOLEAN:
          serviceImpl.writeBoolean((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteBooleanRequest) request,
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
              .addMethod(getGetModelVariablesMethod())
              .addMethod(getGetCurrentTimeMethod())
              .addMethod(getIsTerminatedMethod())
              .addMethod(getInitMethod())
              .addMethod(getStepMethod())
              .addMethod(getTerminateMethod())
              .addMethod(getResetMethod())
              .addMethod(getReadIntMethod())
              .addMethod(getReadRealMethod())
              .addMethod(getReadStringMethod())
              .addMethod(getReadBooleanMethod())
              .addMethod(getWriteIntMethod())
              .addMethod(getWriteRealMethod())
              .addMethod(getWriteStringMethod())
              .addMethod(getWriteBooleanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
