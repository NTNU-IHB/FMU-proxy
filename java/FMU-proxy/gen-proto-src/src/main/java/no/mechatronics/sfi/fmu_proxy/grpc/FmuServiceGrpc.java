package no.mechatronics.sfi.fmu_proxy.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: service.proto")
public final class FmuServiceGrpc {

  private FmuServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.fmu_proxy.grpc.FmuService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSupportsCoSimulationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> METHOD_SUPPORTS_CO_SIMULATION = getSupportsCoSimulationMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getSupportsCoSimulationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getSupportsCoSimulationMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getSupportsCoSimulationMethod;
    if ((getSupportsCoSimulationMethod = FmuServiceGrpc.getSupportsCoSimulationMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getSupportsCoSimulationMethod = FmuServiceGrpc.getSupportsCoSimulationMethod) == null) {
          FmuServiceGrpc.getSupportsCoSimulationMethod = getSupportsCoSimulationMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "SupportsCoSimulation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("SupportsCoSimulation"))
                  .build();
          }
        }
     }
     return getSupportsCoSimulationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSupportsModelExchangeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> METHOD_SUPPORTS_MODEL_EXCHANGE = getSupportsModelExchangeMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getSupportsModelExchangeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getSupportsModelExchangeMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getSupportsModelExchangeMethod;
    if ((getSupportsModelExchangeMethod = FmuServiceGrpc.getSupportsModelExchangeMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getSupportsModelExchangeMethod = FmuServiceGrpc.getSupportsModelExchangeMethod) == null) {
          FmuServiceGrpc.getSupportsModelExchangeMethod = getSupportsModelExchangeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "SupportsModelExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("SupportsModelExchange"))
                  .build();
          }
        }
     }
     return getSupportsModelExchangeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelDescriptionXmlMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> METHOD_GET_MODEL_DESCRIPTION_XML = getGetModelDescriptionXmlMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> getGetModelDescriptionXmlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> getGetModelDescriptionXmlMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> getGetModelDescriptionXmlMethod;
    if ((getGetModelDescriptionXmlMethod = FmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelDescriptionXmlMethod = FmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
          FmuServiceGrpc.getGetModelDescriptionXmlMethod = getGetModelDescriptionXmlMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetModelDescriptionXml"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelDescriptionXml"))
                  .build();
          }
        }
     }
     return getGetModelDescriptionXmlMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelDescriptionMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> METHOD_GET_MODEL_DESCRIPTION = getGetModelDescriptionMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> getGetModelDescriptionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> getGetModelDescriptionMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> getGetModelDescriptionMethod;
    if ((getGetModelDescriptionMethod = FmuServiceGrpc.getGetModelDescriptionMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelDescriptionMethod = FmuServiceGrpc.getGetModelDescriptionMethod) == null) {
          FmuServiceGrpc.getGetModelDescriptionMethod = getGetModelDescriptionMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetModelDescription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelDescription"))
                  .build();
          }
        }
     }
     return getGetModelDescriptionMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromCSMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> METHOD_CREATE_INSTANCE_FROM_CS = getCreateInstanceFromCSMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> getCreateInstanceFromCSMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> getCreateInstanceFromCSMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> getCreateInstanceFromCSMethod;
    if ((getCreateInstanceFromCSMethod = FmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceFromCSMethod = FmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
          FmuServiceGrpc.getCreateInstanceFromCSMethod = getCreateInstanceFromCSMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "CreateInstanceFromCS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstanceFromCS"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromCSMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromMEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> METHOD_CREATE_INSTANCE_FROM_ME = getCreateInstanceFromMEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> getCreateInstanceFromMEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> getCreateInstanceFromMEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator, no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> getCreateInstanceFromMEMethod;
    if ((getCreateInstanceFromMEMethod = FmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceFromMEMethod = FmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
          FmuServiceGrpc.getCreateInstanceFromMEMethod = getCreateInstanceFromMEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator, no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "CreateInstanceFromME"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstanceFromME"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromMEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCurrentTimeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> METHOD_GET_CURRENT_TIME = getGetCurrentTimeMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> getGetCurrentTimeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> getGetCurrentTimeMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> getGetCurrentTimeMethod;
    if ((getGetCurrentTimeMethod = FmuServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = FmuServiceGrpc.getGetCurrentTimeMethod) == null) {
          FmuServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetCurrentTime"))
                  .build();
          }
        }
     }
     return getGetCurrentTimeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsTerminatedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> METHOD_IS_TERMINATED = getIsTerminatedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getIsTerminatedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getIsTerminatedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getIsTerminatedMethod;
    if ((getIsTerminatedMethod = FmuServiceGrpc.getIsTerminatedMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getIsTerminatedMethod = FmuServiceGrpc.getIsTerminatedMethod) == null) {
          FmuServiceGrpc.getIsTerminatedMethod = getIsTerminatedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "IsTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("IsTerminated"))
                  .build();
          }
        }
     }
     return getIsTerminatedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCanGetAndSetFMUstateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> METHOD_CAN_GET_AND_SET_FMUSTATE = getCanGetAndSetFMUstateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getCanGetAndSetFMUstateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getCanGetAndSetFMUstateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> getCanGetAndSetFMUstateMethod;
    if ((getCanGetAndSetFMUstateMethod = FmuServiceGrpc.getCanGetAndSetFMUstateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCanGetAndSetFMUstateMethod = FmuServiceGrpc.getCanGetAndSetFMUstateMethod) == null) {
          FmuServiceGrpc.getCanGetAndSetFMUstateMethod = getCanGetAndSetFMUstateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "CanGetAndSetFMUstate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CanGetAndSetFMUstate"))
                  .build();
          }
        }
     }
     return getCanGetAndSetFMUstateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_INIT = getInitMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getInitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getInitMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getInitMethod;
    if ((getInitMethod = FmuServiceGrpc.getInitMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getInitMethod = FmuServiceGrpc.getInitMethod) == null) {
          FmuServiceGrpc.getInitMethod = getInitMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Init"))
                  .build();
          }
        }
     }
     return getInitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStepMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_STEP = getStepMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getStepMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getStepMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getStepMethod;
    if ((getStepMethod = FmuServiceGrpc.getStepMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getStepMethod = FmuServiceGrpc.getStepMethod) == null) {
          FmuServiceGrpc.getStepMethod = getStepMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Step"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Step"))
                  .build();
          }
        }
     }
     return getStepMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTerminateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_TERMINATE = getTerminateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getTerminateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getTerminateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getTerminateMethod;
    if ((getTerminateMethod = FmuServiceGrpc.getTerminateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getTerminateMethod = FmuServiceGrpc.getTerminateMethod) == null) {
          FmuServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getResetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_RESET = getResetMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getResetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getResetMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getResetMethod;
    if ((getResetMethod = FmuServiceGrpc.getResetMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getResetMethod = FmuServiceGrpc.getResetMethod) == null) {
          FmuServiceGrpc.getResetMethod = getResetMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Reset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Reset"))
                  .build();
          }
        }
     }
     return getResetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> METHOD_READ_INTEGER = getReadIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> getReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> getReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> getReadIntegerMethod;
    if ((getReadIntegerMethod = FmuServiceGrpc.getReadIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadIntegerMethod = FmuServiceGrpc.getReadIntegerMethod) == null) {
          FmuServiceGrpc.getReadIntegerMethod = getReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadInteger"))
                  .build();
          }
        }
     }
     return getReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> METHOD_READ_REAL = getReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> getReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> getReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> getReadRealMethod;
    if ((getReadRealMethod = FmuServiceGrpc.getReadRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadRealMethod = FmuServiceGrpc.getReadRealMethod) == null) {
          FmuServiceGrpc.getReadRealMethod = getReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadReal"))
                  .build();
          }
        }
     }
     return getReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> METHOD_READ_STRING = getReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> getReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> getReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> getReadStringMethod;
    if ((getReadStringMethod = FmuServiceGrpc.getReadStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadStringMethod = FmuServiceGrpc.getReadStringMethod) == null) {
          FmuServiceGrpc.getReadStringMethod = getReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadString"))
                  .build();
          }
        }
     }
     return getReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> METHOD_READ_BOOLEAN = getReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> getReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> getReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> getReadBooleanMethod;
    if ((getReadBooleanMethod = FmuServiceGrpc.getReadBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadBooleanMethod = FmuServiceGrpc.getReadBooleanMethod) == null) {
          FmuServiceGrpc.getReadBooleanMethod = getReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadBoolean"))
                  .build();
          }
        }
     }
     return getReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> METHOD_BULK_READ_INTEGER = getBulkReadIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> getBulkReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> getBulkReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> getBulkReadIntegerMethod;
    if ((getBulkReadIntegerMethod = FmuServiceGrpc.getBulkReadIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadIntegerMethod = FmuServiceGrpc.getBulkReadIntegerMethod) == null) {
          FmuServiceGrpc.getBulkReadIntegerMethod = getBulkReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadInteger"))
                  .build();
          }
        }
     }
     return getBulkReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> METHOD_BULK_READ_REAL = getBulkReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> getBulkReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> getBulkReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> getBulkReadRealMethod;
    if ((getBulkReadRealMethod = FmuServiceGrpc.getBulkReadRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadRealMethod = FmuServiceGrpc.getBulkReadRealMethod) == null) {
          FmuServiceGrpc.getBulkReadRealMethod = getBulkReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadReal"))
                  .build();
          }
        }
     }
     return getBulkReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> METHOD_BULK_READ_STRING = getBulkReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> getBulkReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> getBulkReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> getBulkReadStringMethod;
    if ((getBulkReadStringMethod = FmuServiceGrpc.getBulkReadStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadStringMethod = FmuServiceGrpc.getBulkReadStringMethod) == null) {
          FmuServiceGrpc.getBulkReadStringMethod = getBulkReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadString"))
                  .build();
          }
        }
     }
     return getBulkReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> METHOD_BULK_READ_BOOLEAN = getBulkReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> getBulkReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> getBulkReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> getBulkReadBooleanMethod;
    if ((getBulkReadBooleanMethod = FmuServiceGrpc.getBulkReadBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadBooleanMethod = FmuServiceGrpc.getBulkReadBooleanMethod) == null) {
          FmuServiceGrpc.getBulkReadBooleanMethod = getBulkReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadBoolean"))
                  .build();
          }
        }
     }
     return getBulkReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_WRITE_INTEGER = getWriteIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteIntegerMethod;
    if ((getWriteIntegerMethod = FmuServiceGrpc.getWriteIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteIntegerMethod = FmuServiceGrpc.getWriteIntegerMethod) == null) {
          FmuServiceGrpc.getWriteIntegerMethod = getWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteInteger"))
                  .build();
          }
        }
     }
     return getWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_WRITE_REAL = getWriteRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteRealMethod;
    if ((getWriteRealMethod = FmuServiceGrpc.getWriteRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteRealMethod = FmuServiceGrpc.getWriteRealMethod) == null) {
          FmuServiceGrpc.getWriteRealMethod = getWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteReal"))
                  .build();
          }
        }
     }
     return getWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_WRITE_STRING = getWriteStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteStringMethod;
    if ((getWriteStringMethod = FmuServiceGrpc.getWriteStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteStringMethod = FmuServiceGrpc.getWriteStringMethod) == null) {
          FmuServiceGrpc.getWriteStringMethod = getWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteString"))
                  .build();
          }
        }
     }
     return getWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_WRITE_BOOLEAN = getWriteBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getWriteBooleanMethod;
    if ((getWriteBooleanMethod = FmuServiceGrpc.getWriteBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteBooleanMethod = FmuServiceGrpc.getWriteBooleanMethod) == null) {
          FmuServiceGrpc.getWriteBooleanMethod = getWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteBoolean"))
                  .build();
          }
        }
     }
     return getWriteBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_BULK_WRITE_INTEGER = getBulkWriteIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteIntegerMethod;
    if ((getBulkWriteIntegerMethod = FmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteIntegerMethod = FmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
          FmuServiceGrpc.getBulkWriteIntegerMethod = getBulkWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteInteger"))
                  .build();
          }
        }
     }
     return getBulkWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_BULK_WRITE_REAL = getBulkWriteRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteRealMethod;
    if ((getBulkWriteRealMethod = FmuServiceGrpc.getBulkWriteRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteRealMethod = FmuServiceGrpc.getBulkWriteRealMethod) == null) {
          FmuServiceGrpc.getBulkWriteRealMethod = getBulkWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteReal"))
                  .build();
          }
        }
     }
     return getBulkWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_BULK_WRITE_STRING = getBulkWriteStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteStringMethod;
    if ((getBulkWriteStringMethod = FmuServiceGrpc.getBulkWriteStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteStringMethod = FmuServiceGrpc.getBulkWriteStringMethod) == null) {
          FmuServiceGrpc.getBulkWriteStringMethod = getBulkWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteString"))
                  .build();
          }
        }
     }
     return getBulkWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> METHOD_BULK_WRITE_BOOLEAN = getBulkWriteBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> getBulkWriteBooleanMethod;
    if ((getBulkWriteBooleanMethod = FmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteBooleanMethod = FmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
          FmuServiceGrpc.getBulkWriteBooleanMethod = getBulkWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest, no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteBoolean"))
                  .build();
          }
        }
     }
     return getBulkWriteBooleanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FmuServiceStub newStub(io.grpc.Channel channel) {
    return new FmuServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FmuServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FmuServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FmuServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FmuServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FmuServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void supportsCoSimulation(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getSupportsCoSimulationMethod(), responseObserver);
    }

    /**
     */
    public void supportsModelExchange(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getSupportsModelExchangeMethod(), responseObserver);
    }

    /**
     */
    public void getModelDescriptionXml(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionXmlMethod(), responseObserver);
    }

    /**
     */
    public void getModelDescription(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromCSMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromMEMethod(), responseObserver);
    }

    /**
     */
    public void getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTimeMethod(), responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getIsTerminatedMethod(), responseObserver);
    }

    /**
     */
    public void canGetAndSetFMUstate(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getCanGetAndSetFMUstateMethod(), responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getInitMethod(), responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getStepMethod(), responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getTerminateMethod(), responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getResetMethod(), responseObserver);
    }

    /**
     */
    public void readInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRealMethod(), responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStringMethod(), responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadRealMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadStringMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegerMethod(), responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteBooleanMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteIntegerMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteBooleanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSupportsCoSimulationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>(
                  this, METHODID_SUPPORTS_CO_SIMULATION)))
          .addMethod(
            getSupportsModelExchangeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>(
                  this, METHODID_SUPPORTS_MODEL_EXCHANGE)))
          .addMethod(
            getGetModelDescriptionXmlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str>(
                  this, METHODID_GET_MODEL_DESCRIPTION_XML)))
          .addMethod(
            getGetModelDescriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription>(
                  this, METHODID_GET_MODEL_DESCRIPTION)))
          .addMethod(
            getCreateInstanceFromCSMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt>(
                  this, METHODID_CREATE_INSTANCE_FROM_CS)))
          .addMethod(
            getCreateInstanceFromMEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt>(
                  this, METHODID_CREATE_INSTANCE_FROM_ME)))
          .addMethod(
            getGetCurrentTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real>(
                  this, METHODID_GET_CURRENT_TIME)))
          .addMethod(
            getIsTerminatedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>(
                  this, METHODID_IS_TERMINATED)))
          .addMethod(
            getCanGetAndSetFMUstateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>(
                  this, METHODID_CAN_GET_AND_SET_FMUSTATE)))
          .addMethod(
            getInitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_INIT)))
          .addMethod(
            getStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_STEP)))
          .addMethod(
            getTerminateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_TERMINATE)))
          .addMethod(
            getResetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_RESET)))
          .addMethod(
            getReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead>(
                  this, METHODID_READ_INTEGER)))
          .addMethod(
            getReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead>(
                  this, METHODID_READ_REAL)))
          .addMethod(
            getReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead>(
                  this, METHODID_READ_STRING)))
          .addMethod(
            getReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead>(
                  this, METHODID_READ_BOOLEAN)))
          .addMethod(
            getBulkReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead>(
                  this, METHODID_BULK_READ_INTEGER)))
          .addMethod(
            getBulkReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead>(
                  this, METHODID_BULK_READ_REAL)))
          .addMethod(
            getBulkReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead>(
                  this, METHODID_BULK_READ_STRING)))
          .addMethod(
            getBulkReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead>(
                  this, METHODID_BULK_READ_BOOLEAN)))
          .addMethod(
            getWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_WRITE_INTEGER)))
          .addMethod(
            getWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_WRITE_REAL)))
          .addMethod(
            getWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_WRITE_STRING)))
          .addMethod(
            getWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_WRITE_BOOLEAN)))
          .addMethod(
            getBulkWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_BULK_WRITE_INTEGER)))
          .addMethod(
            getBulkWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_BULK_WRITE_REAL)))
          .addMethod(
            getBulkWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_BULK_WRITE_STRING)))
          .addMethod(
            getBulkWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>(
                  this, METHODID_BULK_WRITE_BOOLEAN)))
          .build();
    }
  }

  /**
   */
  public static final class FmuServiceStub extends io.grpc.stub.AbstractStub<FmuServiceStub> {
    private FmuServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FmuServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FmuServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FmuServiceStub(channel, callOptions);
    }

    /**
     */
    public void supportsCoSimulation(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSupportsCoSimulationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void supportsModelExchange(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSupportsModelExchangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelDescriptionXml(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelDescription(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelDescriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsTerminatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void canGetAndSetFMUstate(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCanGetAndSetFMUstateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FmuServiceBlockingStub extends io.grpc.stub.AbstractStub<FmuServiceBlockingStub> {
    private FmuServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FmuServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FmuServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FmuServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool supportsCoSimulation(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getSupportsCoSimulationMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool supportsModelExchange(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getSupportsModelExchangeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str getModelDescriptionXml(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionXmlMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription getModelDescription(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt createInstanceFromCS(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromCSMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromMEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getIsTerminatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool canGetAndSetFMUstate(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getCanGetAndSetFMUstateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status init(no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest request) {
      return blockingUnaryCall(
          getChannel(), getInitMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status step(no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest request) {
      return blockingUnaryCall(
          getChannel(), getStepMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status terminate(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getTerminateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status reset(no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return blockingUnaryCall(
          getChannel(), getResetMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead readInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead readReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead readString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status writeReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status writeString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteBooleanMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FmuServiceFutureStub extends io.grpc.stub.AbstractStub<FmuServiceFutureStub> {
    private FmuServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FmuServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FmuServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FmuServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> supportsCoSimulation(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getSupportsCoSimulationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> supportsModelExchange(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getSupportsModelExchangeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str> getModelDescriptionXml(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription> getModelDescription(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelDescriptionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> createInstanceFromCS(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt> createInstanceFromME(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real> getCurrentTime(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> isTerminated(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getIsTerminatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool> canGetAndSetFMUstate(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getCanGetAndSetFMUstateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> init(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> step(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> terminate(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> reset(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead> readInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead> readReal(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead> readString(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead> readBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead> bulkReadInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead> bulkReadReal(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead> bulkReadString(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead> bulkReadBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> writeInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> writeReal(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> writeString(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> writeBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> bulkWriteInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> bulkWriteReal(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> bulkWriteString(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status> bulkWriteBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUPPORTS_CO_SIMULATION = 0;
  private static final int METHODID_SUPPORTS_MODEL_EXCHANGE = 1;
  private static final int METHODID_GET_MODEL_DESCRIPTION_XML = 2;
  private static final int METHODID_GET_MODEL_DESCRIPTION = 3;
  private static final int METHODID_CREATE_INSTANCE_FROM_CS = 4;
  private static final int METHODID_CREATE_INSTANCE_FROM_ME = 5;
  private static final int METHODID_GET_CURRENT_TIME = 6;
  private static final int METHODID_IS_TERMINATED = 7;
  private static final int METHODID_CAN_GET_AND_SET_FMUSTATE = 8;
  private static final int METHODID_INIT = 9;
  private static final int METHODID_STEP = 10;
  private static final int METHODID_TERMINATE = 11;
  private static final int METHODID_RESET = 12;
  private static final int METHODID_READ_INTEGER = 13;
  private static final int METHODID_READ_REAL = 14;
  private static final int METHODID_READ_STRING = 15;
  private static final int METHODID_READ_BOOLEAN = 16;
  private static final int METHODID_BULK_READ_INTEGER = 17;
  private static final int METHODID_BULK_READ_REAL = 18;
  private static final int METHODID_BULK_READ_STRING = 19;
  private static final int METHODID_BULK_READ_BOOLEAN = 20;
  private static final int METHODID_WRITE_INTEGER = 21;
  private static final int METHODID_WRITE_REAL = 22;
  private static final int METHODID_WRITE_STRING = 23;
  private static final int METHODID_WRITE_BOOLEAN = 24;
  private static final int METHODID_BULK_WRITE_INTEGER = 25;
  private static final int METHODID_BULK_WRITE_REAL = 26;
  private static final int METHODID_BULK_WRITE_STRING = 27;
  private static final int METHODID_BULK_WRITE_BOOLEAN = 28;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FmuServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FmuServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUPPORTS_CO_SIMULATION:
          serviceImpl.supportsCoSimulation((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>) responseObserver);
          break;
        case METHODID_SUPPORTS_MODEL_EXCHANGE:
          serviceImpl.supportsModelExchange((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>) responseObserver);
          break;
        case METHODID_GET_MODEL_DESCRIPTION_XML:
          serviceImpl.getModelDescriptionXml((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_DESCRIPTION:
          serviceImpl.getModelDescription((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.ModelDescription>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_CS:
          serviceImpl.createInstanceFromCS((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_ME:
          serviceImpl.createInstanceFromME((no.mechatronics.sfi.fmu_proxy.grpc.Proto.Integrator) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Real>) responseObserver);
          break;
        case METHODID_IS_TERMINATED:
          serviceImpl.isTerminated((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>) responseObserver);
          break;
        case METHODID_CAN_GET_AND_SET_FMUSTATE:
          serviceImpl.canGetAndSetFMUstate((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Bool>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((no.mechatronics.sfi.fmu_proxy.grpc.Proto.InitRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_STEP:
          serviceImpl.step((no.mechatronics.sfi.fmu_proxy.grpc.Proto.StepRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_TERMINATE:
          serviceImpl.terminate((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_RESET:
          serviceImpl.reset((no.mechatronics.sfi.fmu_proxy.grpc.Proto.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_READ_INTEGER:
          serviceImpl.readInteger((no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntRead>) responseObserver);
          break;
        case METHODID_READ_REAL:
          serviceImpl.readReal((no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealRead>) responseObserver);
          break;
        case METHODID_READ_STRING:
          serviceImpl.readString((no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrRead>) responseObserver);
          break;
        case METHODID_READ_BOOLEAN:
          serviceImpl.readBoolean((no.mechatronics.sfi.fmu_proxy.grpc.Proto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolRead>) responseObserver);
          break;
        case METHODID_BULK_READ_INTEGER:
          serviceImpl.bulkReadInteger((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.IntListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_REAL:
          serviceImpl.bulkReadReal((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.RealListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_STRING:
          serviceImpl.bulkReadString((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.StrListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_BOOLEAN:
          serviceImpl.bulkReadBoolean((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.BoolListRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGER:
          serviceImpl.writeInteger((no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteIntRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_WRITE_REAL:
          serviceImpl.writeReal((no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_WRITE_STRING:
          serviceImpl.writeString((no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteStrRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_WRITE_BOOLEAN:
          serviceImpl.writeBoolean((no.mechatronics.sfi.fmu_proxy.grpc.Proto.WriteBoolRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_INTEGER:
          serviceImpl.bulkWriteInteger((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteIntRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_REAL:
          serviceImpl.bulkWriteReal((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_STRING:
          serviceImpl.bulkWriteString((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteStrRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_BOOLEAN:
          serviceImpl.bulkWriteBoolean((no.mechatronics.sfi.fmu_proxy.grpc.Proto.BulkWriteBoolRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.Proto.Status>) responseObserver);
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

  private static abstract class FmuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FmuServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FmuService");
    }
  }

  private static final class FmuServiceFileDescriptorSupplier
      extends FmuServiceBaseDescriptorSupplier {
    FmuServiceFileDescriptorSupplier() {}
  }

  private static final class FmuServiceMethodDescriptorSupplier
      extends FmuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FmuServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FmuServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FmuServiceFileDescriptorSupplier())
              .addMethod(getSupportsCoSimulationMethod())
              .addMethod(getSupportsModelExchangeMethod())
              .addMethod(getGetModelDescriptionXmlMethod())
              .addMethod(getGetModelDescriptionMethod())
              .addMethod(getCreateInstanceFromCSMethod())
              .addMethod(getCreateInstanceFromMEMethod())
              .addMethod(getGetCurrentTimeMethod())
              .addMethod(getIsTerminatedMethod())
              .addMethod(getCanGetAndSetFMUstateMethod())
              .addMethod(getInitMethod())
              .addMethod(getStepMethod())
              .addMethod(getTerminateMethod())
              .addMethod(getResetMethod())
              .addMethod(getReadIntegerMethod())
              .addMethod(getReadRealMethod())
              .addMethod(getReadStringMethod())
              .addMethod(getReadBooleanMethod())
              .addMethod(getBulkReadIntegerMethod())
              .addMethod(getBulkReadRealMethod())
              .addMethod(getBulkReadStringMethod())
              .addMethod(getBulkReadBooleanMethod())
              .addMethod(getWriteIntegerMethod())
              .addMethod(getWriteRealMethod())
              .addMethod(getWriteStringMethod())
              .addMethod(getWriteBooleanMethod())
              .addMethod(getBulkWriteIntegerMethod())
              .addMethod(getBulkWriteRealMethod())
              .addMethod(getBulkWriteStringMethod())
              .addMethod(getBulkWriteBooleanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
