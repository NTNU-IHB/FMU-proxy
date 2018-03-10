package no.mechatronics.sfi.fmu_proxy.grpc;

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
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: service.proto")
public final class FmuServiceGrpc {

  private FmuServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.fmu_proxy.grpc.FmuService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromCSMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> METHOD_CREATE_INSTANCE_FROM_CS = getCreateInstanceFromCSMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> getCreateInstanceFromCSMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> getCreateInstanceFromCSMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> getCreateInstanceFromCSMethod;
    if ((getCreateInstanceFromCSMethod = FmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceFromCSMethod = FmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
          FmuServiceGrpc.getCreateInstanceFromCSMethod = getCreateInstanceFromCSMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.UIntProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "CreateInstanceFromCS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.UIntProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstanceFromCS"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromCSMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromMEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto,
      no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> METHOD_CREATE_INSTANCE_FROM_ME = getCreateInstanceFromMEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto,
      no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> getCreateInstanceFromMEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto,
      no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> getCreateInstanceFromMEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto, no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> getCreateInstanceFromMEMethod;
    if ((getCreateInstanceFromMEMethod = FmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceFromMEMethod = FmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
          FmuServiceGrpc.getCreateInstanceFromMEMethod = getCreateInstanceFromMEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto, no.mechatronics.sfi.fmu_proxy.grpc.UIntProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "CreateInstanceFromME"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.UIntProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstanceFromME"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromMEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGuidMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> METHOD_GET_GUID = getGetGuidMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetGuidMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetGuidMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetGuidMethod;
    if ((getGetGuidMethod = FmuServiceGrpc.getGetGuidMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetGuidMethod = FmuServiceGrpc.getGetGuidMethod) == null) {
          FmuServiceGrpc.getGetGuidMethod = getGetGuidMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.StrProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetGuid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StrProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetGuid"))
                  .build();
          }
        }
     }
     return getGetGuidMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> METHOD_GET_MODEL_NAME = getGetModelNameMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetModelNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetModelNameMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetModelNameMethod;
    if ((getGetModelNameMethod = FmuServiceGrpc.getGetModelNameMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelNameMethod = FmuServiceGrpc.getGetModelNameMethod) == null) {
          FmuServiceGrpc.getGetModelNameMethod = getGetModelNameMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.StrProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetModelName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StrProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelName"))
                  .build();
          }
        }
     }
     return getGetModelNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelDescriptionXmlMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> METHOD_GET_MODEL_DESCRIPTION_XML = getGetModelDescriptionXmlMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetModelDescriptionXmlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetModelDescriptionXmlMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGetModelDescriptionXmlMethod;
    if ((getGetModelDescriptionXmlMethod = FmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelDescriptionXmlMethod = FmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
          FmuServiceGrpc.getGetModelDescriptionXmlMethod = getGetModelDescriptionXmlMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.StrProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetModelDescriptionXml"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StrProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelDescriptionXml"))
                  .build();
          }
        }
     }
     return getGetModelDescriptionXmlMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelStructureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> METHOD_GET_MODEL_STRUCTURE = getGetModelStructureMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> getGetModelStructureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> getGetModelStructureMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> getGetModelStructureMethod;
    if ((getGetModelStructureMethod = FmuServiceGrpc.getGetModelStructureMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelStructureMethod = FmuServiceGrpc.getGetModelStructureMethod) == null) {
          FmuServiceGrpc.getGetModelStructureMethod = getGetModelStructureMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetModelStructure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelStructure"))
                  .build();
          }
        }
     }
     return getGetModelStructureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelVariablesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> METHOD_GET_MODEL_VARIABLES = getGetModelVariablesMethod();

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> getGetModelVariablesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> getGetModelVariablesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> getGetModelVariablesMethod;
    if ((getGetModelVariablesMethod = FmuServiceGrpc.getGetModelVariablesMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelVariablesMethod = FmuServiceGrpc.getGetModelVariablesMethod) == null) {
          FmuServiceGrpc.getGetModelVariablesMethod = getGetModelVariablesMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetModelVariables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelVariables"))
                  .build();
          }
        }
     }
     return getGetModelVariablesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCurrentTimeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealProto> METHOD_GET_CURRENT_TIME = getGetCurrentTimeMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealProto> getGetCurrentTimeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealProto> getGetCurrentTimeMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.RealProto> getGetCurrentTimeMethod;
    if ((getGetCurrentTimeMethod = FmuServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = FmuServiceGrpc.getGetCurrentTimeMethod) == null) {
          FmuServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.RealProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.UIntProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.RealProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetCurrentTime"))
                  .build();
          }
        }
     }
     return getGetCurrentTimeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsTerminatedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> METHOD_IS_TERMINATED = getIsTerminatedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getIsTerminatedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getIsTerminatedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getIsTerminatedMethod;
    if ((getIsTerminatedMethod = FmuServiceGrpc.getIsTerminatedMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getIsTerminatedMethod = FmuServiceGrpc.getIsTerminatedMethod) == null) {
          FmuServiceGrpc.getIsTerminatedMethod = getIsTerminatedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "IsTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.UIntProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BoolProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("IsTerminated"))
                  .build();
          }
        }
     }
     return getIsTerminatedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> METHOD_INIT = getInitMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getInitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getInitMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getInitMethod;
    if ((getInitMethod = FmuServiceGrpc.getInitMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getInitMethod = FmuServiceGrpc.getInitMethod) == null) {
          FmuServiceGrpc.getInitMethod = getInitMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BoolProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Init"))
                  .build();
          }
        }
     }
     return getInitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStepMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_STEP = getStepMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getStepMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getStepMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getStepMethod;
    if ((getStepMethod = FmuServiceGrpc.getStepMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getStepMethod = FmuServiceGrpc.getStepMethod) == null) {
          FmuServiceGrpc.getStepMethod = getStepMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Step"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Step"))
                  .build();
          }
        }
     }
     return getStepMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTerminateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> METHOD_TERMINATE = getTerminateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getTerminateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getTerminateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> getTerminateMethod;
    if ((getTerminateMethod = FmuServiceGrpc.getTerminateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getTerminateMethod = FmuServiceGrpc.getTerminateMethod) == null) {
          FmuServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.UIntProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BoolProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getResetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_RESET = getResetMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getResetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getResetMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getResetMethod;
    if ((getResetMethod = FmuServiceGrpc.getResetMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getResetMethod = FmuServiceGrpc.getResetMethod) == null) {
          FmuServiceGrpc.getResetMethod = getResetMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "Reset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.UIntProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Reset"))
                  .build();
          }
        }
     }
     return getResetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> METHOD_READ_INTEGER = getReadIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> getReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> getReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> getReadIntegerMethod;
    if ((getReadIntegerMethod = FmuServiceGrpc.getReadIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadIntegerMethod = FmuServiceGrpc.getReadIntegerMethod) == null) {
          FmuServiceGrpc.getReadIntegerMethod = getReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadInteger"))
                  .build();
          }
        }
     }
     return getReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> METHOD_READ_REAL = getReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> getReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> getReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> getReadRealMethod;
    if ((getReadRealMethod = FmuServiceGrpc.getReadRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadRealMethod = FmuServiceGrpc.getReadRealMethod) == null) {
          FmuServiceGrpc.getReadRealMethod = getReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadReal"))
                  .build();
          }
        }
     }
     return getReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> METHOD_READ_STRING = getReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> getReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> getReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> getReadStringMethod;
    if ((getReadStringMethod = FmuServiceGrpc.getReadStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadStringMethod = FmuServiceGrpc.getReadStringMethod) == null) {
          FmuServiceGrpc.getReadStringMethod = getReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadString"))
                  .build();
          }
        }
     }
     return getReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> METHOD_READ_BOOLEAN = getReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> getReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> getReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> getReadBooleanMethod;
    if ((getReadBooleanMethod = FmuServiceGrpc.getReadBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadBooleanMethod = FmuServiceGrpc.getReadBooleanMethod) == null) {
          FmuServiceGrpc.getReadBooleanMethod = getReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "ReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadBoolean"))
                  .build();
          }
        }
     }
     return getReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> METHOD_BULK_READ_INTEGER = getBulkReadIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> getBulkReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> getBulkReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> getBulkReadIntegerMethod;
    if ((getBulkReadIntegerMethod = FmuServiceGrpc.getBulkReadIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadIntegerMethod = FmuServiceGrpc.getBulkReadIntegerMethod) == null) {
          FmuServiceGrpc.getBulkReadIntegerMethod = getBulkReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadInteger"))
                  .build();
          }
        }
     }
     return getBulkReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> METHOD_BULK_READ_REAL = getBulkReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> getBulkReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> getBulkReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> getBulkReadRealMethod;
    if ((getBulkReadRealMethod = FmuServiceGrpc.getBulkReadRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadRealMethod = FmuServiceGrpc.getBulkReadRealMethod) == null) {
          FmuServiceGrpc.getBulkReadRealMethod = getBulkReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadReal"))
                  .build();
          }
        }
     }
     return getBulkReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> METHOD_BULK_READ_STRING = getBulkReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> getBulkReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> getBulkReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> getBulkReadStringMethod;
    if ((getBulkReadStringMethod = FmuServiceGrpc.getBulkReadStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadStringMethod = FmuServiceGrpc.getBulkReadStringMethod) == null) {
          FmuServiceGrpc.getBulkReadStringMethod = getBulkReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadString"))
                  .build();
          }
        }
     }
     return getBulkReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> METHOD_BULK_READ_BOOLEAN = getBulkReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> getBulkReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> getBulkReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> getBulkReadBooleanMethod;
    if ((getBulkReadBooleanMethod = FmuServiceGrpc.getBulkReadBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkReadBooleanMethod = FmuServiceGrpc.getBulkReadBooleanMethod) == null) {
          FmuServiceGrpc.getBulkReadBooleanMethod = getBulkReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkReadBoolean"))
                  .build();
          }
        }
     }
     return getBulkReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_WRITE_INTEGER = getWriteIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteIntegerMethod;
    if ((getWriteIntegerMethod = FmuServiceGrpc.getWriteIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteIntegerMethod = FmuServiceGrpc.getWriteIntegerMethod) == null) {
          FmuServiceGrpc.getWriteIntegerMethod = getWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteInteger"))
                  .build();
          }
        }
     }
     return getWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_WRITE_REAL = getWriteRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteRealMethod;
    if ((getWriteRealMethod = FmuServiceGrpc.getWriteRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteRealMethod = FmuServiceGrpc.getWriteRealMethod) == null) {
          FmuServiceGrpc.getWriteRealMethod = getWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteReal"))
                  .build();
          }
        }
     }
     return getWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_WRITE_STRING = getWriteStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteStringMethod;
    if ((getWriteStringMethod = FmuServiceGrpc.getWriteStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteStringMethod = FmuServiceGrpc.getWriteStringMethod) == null) {
          FmuServiceGrpc.getWriteStringMethod = getWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteString"))
                  .build();
          }
        }
     }
     return getWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_WRITE_BOOLEAN = getWriteBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getWriteBooleanMethod;
    if ((getWriteBooleanMethod = FmuServiceGrpc.getWriteBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteBooleanMethod = FmuServiceGrpc.getWriteBooleanMethod) == null) {
          FmuServiceGrpc.getWriteBooleanMethod = getWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "WriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteBoolean"))
                  .build();
          }
        }
     }
     return getWriteBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_BULK_WRITE_INTEGER = getBulkWriteIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteIntegerMethod;
    if ((getBulkWriteIntegerMethod = FmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteIntegerMethod = FmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
          FmuServiceGrpc.getBulkWriteIntegerMethod = getBulkWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteInteger"))
                  .build();
          }
        }
     }
     return getBulkWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_BULK_WRITE_REAL = getBulkWriteRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteRealMethod;
    if ((getBulkWriteRealMethod = FmuServiceGrpc.getBulkWriteRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteRealMethod = FmuServiceGrpc.getBulkWriteRealMethod) == null) {
          FmuServiceGrpc.getBulkWriteRealMethod = getBulkWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteReal"))
                  .build();
          }
        }
     }
     return getBulkWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_BULK_WRITE_STRING = getBulkWriteStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteStringMethod;
    if ((getBulkWriteStringMethod = FmuServiceGrpc.getBulkWriteStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteStringMethod = FmuServiceGrpc.getBulkWriteStringMethod) == null) {
          FmuServiceGrpc.getBulkWriteStringMethod = getBulkWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("BulkWriteString"))
                  .build();
          }
        }
     }
     return getBulkWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> METHOD_BULK_WRITE_BOOLEAN = getBulkWriteBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto,
      no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> getBulkWriteBooleanMethod;
    if ((getBulkWriteBooleanMethod = FmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getBulkWriteBooleanMethod = FmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
          FmuServiceGrpc.getBulkWriteBooleanMethod = getBulkWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto, no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.FmuService", "BulkWriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.StatusProto.getDefaultInstance()))
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
    public void createInstanceFromCS(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromCSMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromMEMethod(), responseObserver);
    }

    /**
     */
    public void getGuid(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGuidMethod(), responseObserver);
    }

    /**
     */
    public void getModelName(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelNameMethod(), responseObserver);
    }

    /**
     */
    public void getModelDescriptionXml(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionXmlMethod(), responseObserver);
    }

    /**
     */
    public void getModelStructure(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelStructureMethod(), responseObserver);
    }

    /**
     */
    public void getModelVariables(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelVariablesMethod(), responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTimeMethod(), responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> responseObserver) {
      asyncUnimplementedUnaryCall(getIsTerminatedMethod(), responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> responseObserver) {
      asyncUnimplementedUnaryCall(getInitMethod(), responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getStepMethod(), responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> responseObserver) {
      asyncUnimplementedUnaryCall(getTerminateMethod(), responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getResetMethod(), responseObserver);
    }

    /**
     */
    public void readInteger(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRealMethod(), responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStringMethod(), responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadRealMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadStringMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegerMethod(), responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteBooleanMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteIntegerMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteBooleanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateInstanceFromCSMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.UIntProto>(
                  this, METHODID_CREATE_INSTANCE_FROM_CS)))
          .addMethod(
            getCreateInstanceFromMEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto,
                no.mechatronics.sfi.fmu_proxy.grpc.UIntProto>(
                  this, METHODID_CREATE_INSTANCE_FROM_ME)))
          .addMethod(
            getGetGuidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.StrProto>(
                  this, METHODID_GET_GUID)))
          .addMethod(
            getGetModelNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.StrProto>(
                  this, METHODID_GET_MODEL_NAME)))
          .addMethod(
            getGetModelDescriptionXmlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.StrProto>(
                  this, METHODID_GET_MODEL_DESCRIPTION_XML)))
          .addMethod(
            getGetModelStructureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto>(
                  this, METHODID_GET_MODEL_STRUCTURE)))
          .addMethod(
            getGetModelVariablesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto>(
                  this, METHODID_GET_MODEL_VARIABLES)))
          .addMethod(
            getGetCurrentTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
                no.mechatronics.sfi.fmu_proxy.grpc.RealProto>(
                  this, METHODID_GET_CURRENT_TIME)))
          .addMethod(
            getIsTerminatedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
                no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>(
                  this, METHODID_IS_TERMINATED)))
          .addMethod(
            getInitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>(
                  this, METHODID_INIT)))
          .addMethod(
            getStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_STEP)))
          .addMethod(
            getTerminateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
                no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>(
                  this, METHODID_TERMINATE)))
          .addMethod(
            getResetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.UIntProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_RESET)))
          .addMethod(
            getReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto>(
                  this, METHODID_READ_INTEGER)))
          .addMethod(
            getReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto>(
                  this, METHODID_READ_REAL)))
          .addMethod(
            getReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto>(
                  this, METHODID_READ_STRING)))
          .addMethod(
            getReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto>(
                  this, METHODID_READ_BOOLEAN)))
          .addMethod(
            getBulkReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto>(
                  this, METHODID_BULK_READ_INTEGER)))
          .addMethod(
            getBulkReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto>(
                  this, METHODID_BULK_READ_REAL)))
          .addMethod(
            getBulkReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto>(
                  this, METHODID_BULK_READ_STRING)))
          .addMethod(
            getBulkReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto>(
                  this, METHODID_BULK_READ_BOOLEAN)))
          .addMethod(
            getWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_WRITE_INTEGER)))
          .addMethod(
            getWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_WRITE_REAL)))
          .addMethod(
            getWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_WRITE_STRING)))
          .addMethod(
            getWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_WRITE_BOOLEAN)))
          .addMethod(
            getBulkWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_BULK_WRITE_INTEGER)))
          .addMethod(
            getBulkWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_BULK_WRITE_REAL)))
          .addMethod(
            getBulkWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
                  this, METHODID_BULK_WRITE_STRING)))
          .addMethod(
            getBulkWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto,
                no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>(
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
    public void createInstanceFromCS(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGuid(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGuidMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelName(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelDescriptionXml(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelStructure(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelStructureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelVariables(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetModelVariablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsTerminatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInteger(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> responseObserver) {
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
    public no.mechatronics.sfi.fmu_proxy.grpc.UIntProto createInstanceFromCS(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromCSMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.UIntProto createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromMEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StrProto getGuid(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetGuidMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StrProto getModelName(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StrProto getModelDescriptionXml(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionXmlMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto getModelStructure(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelStructureMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto> getModelVariables(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetModelVariablesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.RealProto getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.BoolProto isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return blockingUnaryCall(
          getChannel(), getIsTerminatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.BoolProto init(no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getInitMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto step(no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getStepMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.BoolProto terminate(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return blockingUnaryCall(
          getChannel(), getTerminateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto reset(no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return blockingUnaryCall(
          getChannel(), getResetMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto readInteger(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto readReal(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto readString(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto writeReal(no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto writeString(no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getWriteBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusProto bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto request) {
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> createInstanceFromCS(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto> createInstanceFromME(
        no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getGuid(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGuidMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getModelName(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StrProto> getModelDescriptionXml(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto> getModelStructure(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelStructureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.RealProto> getCurrentTime(
        no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> isTerminated(
        no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return futureUnaryCall(
          getChannel().newCall(getIsTerminatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> init(
        no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> step(
        no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto> terminate(
        no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return futureUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> reset(
        no.mechatronics.sfi.fmu_proxy.grpc.UIntProto request) {
      return futureUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto> readInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto> readReal(
        no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto> readString(
        no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto> readBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto> bulkReadInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto> bulkReadReal(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto> bulkReadString(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto> bulkReadBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> writeInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> writeReal(
        no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> writeString(
        no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> writeBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> bulkWriteInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> bulkWriteReal(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> bulkWriteString(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto> bulkWriteBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE_FROM_CS = 0;
  private static final int METHODID_CREATE_INSTANCE_FROM_ME = 1;
  private static final int METHODID_GET_GUID = 2;
  private static final int METHODID_GET_MODEL_NAME = 3;
  private static final int METHODID_GET_MODEL_DESCRIPTION_XML = 4;
  private static final int METHODID_GET_MODEL_STRUCTURE = 5;
  private static final int METHODID_GET_MODEL_VARIABLES = 6;
  private static final int METHODID_GET_CURRENT_TIME = 7;
  private static final int METHODID_IS_TERMINATED = 8;
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
        case METHODID_CREATE_INSTANCE_FROM_CS:
          serviceImpl.createInstanceFromCS((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_ME:
          serviceImpl.createInstanceFromME((no.mechatronics.sfi.fmu_proxy.grpc.IntegratorProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.UIntProto>) responseObserver);
          break;
        case METHODID_GET_GUID:
          serviceImpl.getGuid((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto>) responseObserver);
          break;
        case METHODID_GET_MODEL_NAME:
          serviceImpl.getModelName((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto>) responseObserver);
          break;
        case METHODID_GET_MODEL_DESCRIPTION_XML:
          serviceImpl.getModelDescriptionXml((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrProto>) responseObserver);
          break;
        case METHODID_GET_MODEL_STRUCTURE:
          serviceImpl.getModelStructure((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.ModelStructureProto>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLES:
          serviceImpl.getModelVariables((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.ScalarVariableProto>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((no.mechatronics.sfi.fmu_proxy.grpc.UIntProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealProto>) responseObserver);
          break;
        case METHODID_IS_TERMINATED:
          serviceImpl.isTerminated((no.mechatronics.sfi.fmu_proxy.grpc.UIntProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>) responseObserver);
          break;
        case METHODID_STEP:
          serviceImpl.step((no.mechatronics.sfi.fmu_proxy.grpc.StepRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_TERMINATE:
          serviceImpl.terminate((no.mechatronics.sfi.fmu_proxy.grpc.UIntProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolProto>) responseObserver);
          break;
        case METHODID_RESET:
          serviceImpl.reset((no.mechatronics.sfi.fmu_proxy.grpc.UIntProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_READ_INTEGER:
          serviceImpl.readInteger((no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.IntReadProto>) responseObserver);
          break;
        case METHODID_READ_REAL:
          serviceImpl.readReal((no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealReadProto>) responseObserver);
          break;
        case METHODID_READ_STRING:
          serviceImpl.readString((no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto>) responseObserver);
          break;
        case METHODID_READ_BOOLEAN:
          serviceImpl.readBoolean((no.mechatronics.sfi.fmu_proxy.grpc.ReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolReadProto>) responseObserver);
          break;
        case METHODID_BULK_READ_INTEGER:
          serviceImpl.bulkReadInteger((no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.IntListReadProto>) responseObserver);
          break;
        case METHODID_BULK_READ_REAL:
          serviceImpl.bulkReadReal((no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.RealListReadProto>) responseObserver);
          break;
        case METHODID_BULK_READ_STRING:
          serviceImpl.bulkReadString((no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StrListReadProto>) responseObserver);
          break;
        case METHODID_BULK_READ_BOOLEAN:
          serviceImpl.bulkReadBoolean((no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.BoolListReadProto>) responseObserver);
          break;
        case METHODID_WRITE_INTEGER:
          serviceImpl.writeInteger((no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_WRITE_REAL:
          serviceImpl.writeReal((no.mechatronics.sfi.fmu_proxy.grpc.WriteRealRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_WRITE_STRING:
          serviceImpl.writeString((no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_WRITE_BOOLEAN:
          serviceImpl.writeBoolean((no.mechatronics.sfi.fmu_proxy.grpc.WriteBooleanRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_BULK_WRITE_INTEGER:
          serviceImpl.bulkWriteInteger((no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteIntegerRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_BULK_WRITE_REAL:
          serviceImpl.bulkWriteReal((no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteRealRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_BULK_WRITE_STRING:
          serviceImpl.bulkWriteString((no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteStringRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
          break;
        case METHODID_BULK_WRITE_BOOLEAN:
          serviceImpl.bulkWriteBoolean((no.mechatronics.sfi.fmu_proxy.grpc.BulkWriteBooleanRequestProto) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.StatusProto>) responseObserver);
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
              .addMethod(getCreateInstanceFromCSMethod())
              .addMethod(getCreateInstanceFromMEMethod())
              .addMethod(getGetGuidMethod())
              .addMethod(getGetModelNameMethod())
              .addMethod(getGetModelDescriptionXmlMethod())
              .addMethod(getGetModelStructureMethod())
              .addMethod(getGetModelVariablesMethod())
              .addMethod(getGetCurrentTimeMethod())
              .addMethod(getIsTerminatedMethod())
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
