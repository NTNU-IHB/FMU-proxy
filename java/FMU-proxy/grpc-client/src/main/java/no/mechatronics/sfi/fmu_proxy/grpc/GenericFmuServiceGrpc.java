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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: service.proto")
public final class GenericFmuServiceGrpc {

  private GenericFmuServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelDescriptionXmlMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> METHOD_GET_MODEL_DESCRIPTION_XML = getGetModelDescriptionXmlMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelDescriptionXmlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelDescriptionXmlMethod() {
    return getGetModelDescriptionXmlMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelDescriptionXmlMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelDescriptionXmlMethod;
    if ((getGetModelDescriptionXmlMethod = GenericFmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelDescriptionXmlMethod = GenericFmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
          GenericFmuServiceGrpc.getGetModelDescriptionXmlMethod = getGetModelDescriptionXmlMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "GetModelDescriptionXml"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelDescriptionXml"))
                  .build();
          }
        }
     }
     return getGetModelDescriptionXmlMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromCSMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> METHOD_CREATE_INSTANCE_FROM_CS = getCreateInstanceFromCSMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromCSMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromCSMethod() {
    return getCreateInstanceFromCSMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromCSMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromCSMethod;
    if ((getCreateInstanceFromCSMethod = GenericFmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getCreateInstanceFromCSMethod = GenericFmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
          GenericFmuServiceGrpc.getCreateInstanceFromCSMethod = getCreateInstanceFromCSMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "CreateInstanceFromCS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("CreateInstanceFromCS"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromCSMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromMEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> METHOD_CREATE_INSTANCE_FROM_ME = getCreateInstanceFromMEMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromMEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromMEMethod() {
    return getCreateInstanceFromMEMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromMEMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> getCreateInstanceFromMEMethod;
    if ((getCreateInstanceFromMEMethod = GenericFmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getCreateInstanceFromMEMethod = GenericFmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
          GenericFmuServiceGrpc.getCreateInstanceFromMEMethod = getCreateInstanceFromMEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "CreateInstanceFromME"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("CreateInstanceFromME"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromMEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGuidMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> METHOD_GET_GUID = getGetGuidMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetGuidMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetGuidMethod() {
    return getGetGuidMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetGuidMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetGuidMethod;
    if ((getGetGuidMethod = GenericFmuServiceGrpc.getGetGuidMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetGuidMethod = GenericFmuServiceGrpc.getGetGuidMethod) == null) {
          GenericFmuServiceGrpc.getGetGuidMethod = getGetGuidMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "GetGuid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetGuid"))
                  .build();
          }
        }
     }
     return getGetGuidMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> METHOD_GET_MODEL_NAME = getGetModelNameMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelNameMethod() {
    return getGetModelNameMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelNameMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGetModelNameMethod;
    if ((getGetModelNameMethod = GenericFmuServiceGrpc.getGetModelNameMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelNameMethod = GenericFmuServiceGrpc.getGetModelNameMethod) == null) {
          GenericFmuServiceGrpc.getGetModelNameMethod = getGetModelNameMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "GetModelName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelName"))
                  .build();
          }
        }
     }
     return getGetModelNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelVariablesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> METHOD_GET_MODEL_VARIABLES = getGetModelVariablesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> getGetModelVariablesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> getGetModelVariablesMethod() {
    return getGetModelVariablesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> getGetModelVariablesMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> getGetModelVariablesMethod;
    if ((getGetModelVariablesMethod = GenericFmuServiceGrpc.getGetModelVariablesMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelVariablesMethod = GenericFmuServiceGrpc.getGetModelVariablesMethod) == null) {
          GenericFmuServiceGrpc.getGetModelVariablesMethod = getGetModelVariablesMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "GetModelVariables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelVariables"))
                  .build();
          }
        }
     }
     return getGetModelVariablesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelStructureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> METHOD_GET_MODEL_STRUCTURE = getGetModelStructureMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> getGetModelStructureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> getGetModelStructureMethod() {
    return getGetModelStructureMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> getGetModelStructureMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> getGetModelStructureMethod;
    if ((getGetModelStructureMethod = GenericFmuServiceGrpc.getGetModelStructureMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelStructureMethod = GenericFmuServiceGrpc.getGetModelStructureMethod) == null) {
          GenericFmuServiceGrpc.getGetModelStructureMethod = getGetModelStructureMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "GetModelStructure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelStructure"))
                  .build();
          }
        }
     }
     return getGetModelStructureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCurrentTimeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> METHOD_GET_CURRENT_TIME = getGetCurrentTimeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> getGetCurrentTimeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> getGetCurrentTimeMethod() {
    return getGetCurrentTimeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> getGetCurrentTimeMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> getGetCurrentTimeMethod;
    if ((getGetCurrentTimeMethod = GenericFmuServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = GenericFmuServiceGrpc.getGetCurrentTimeMethod) == null) {
          GenericFmuServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetCurrentTime"))
                  .build();
          }
        }
     }
     return getGetCurrentTimeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsTerminatedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> METHOD_IS_TERMINATED = getIsTerminatedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getIsTerminatedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getIsTerminatedMethod() {
    return getIsTerminatedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getIsTerminatedMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getIsTerminatedMethod;
    if ((getIsTerminatedMethod = GenericFmuServiceGrpc.getIsTerminatedMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getIsTerminatedMethod = GenericFmuServiceGrpc.getIsTerminatedMethod) == null) {
          GenericFmuServiceGrpc.getIsTerminatedMethod = getIsTerminatedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "IsTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("IsTerminated"))
                  .build();
          }
        }
     }
     return getIsTerminatedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> METHOD_INIT = getInitMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getInitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getInitMethod() {
    return getInitMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getInitMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getInitMethod;
    if ((getInitMethod = GenericFmuServiceGrpc.getInitMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getInitMethod = GenericFmuServiceGrpc.getInitMethod) == null) {
          GenericFmuServiceGrpc.getInitMethod = getInitMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Init"))
                  .build();
          }
        }
     }
     return getInitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStepMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_STEP = getStepMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getStepMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getStepMethod() {
    return getStepMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getStepMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getStepMethod;
    if ((getStepMethod = GenericFmuServiceGrpc.getStepMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getStepMethod = GenericFmuServiceGrpc.getStepMethod) == null) {
          GenericFmuServiceGrpc.getStepMethod = getStepMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "Step"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Step"))
                  .build();
          }
        }
     }
     return getStepMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTerminateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> METHOD_TERMINATE = getTerminateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getTerminateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getTerminateMethod() {
    return getTerminateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getTerminateMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> getTerminateMethod;
    if ((getTerminateMethod = GenericFmuServiceGrpc.getTerminateMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getTerminateMethod = GenericFmuServiceGrpc.getTerminateMethod) == null) {
          GenericFmuServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getResetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_RESET = getResetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getResetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getResetMethod() {
    return getResetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getResetMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getResetMethod;
    if ((getResetMethod = GenericFmuServiceGrpc.getResetMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getResetMethod = GenericFmuServiceGrpc.getResetMethod) == null) {
          GenericFmuServiceGrpc.getResetMethod = getResetMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "Reset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("Reset"))
                  .build();
          }
        }
     }
     return getResetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> METHOD_READ_INTEGER = getReadIntegerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> getReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> getReadIntegerMethod() {
    return getReadIntegerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> getReadIntegerMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> getReadIntegerMethod;
    if ((getReadIntegerMethod = GenericFmuServiceGrpc.getReadIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadIntegerMethod = GenericFmuServiceGrpc.getReadIntegerMethod) == null) {
          GenericFmuServiceGrpc.getReadIntegerMethod = getReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "ReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadInteger"))
                  .build();
          }
        }
     }
     return getReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> METHOD_READ_REAL = getReadRealMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> getReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> getReadRealMethod() {
    return getReadRealMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> getReadRealMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> getReadRealMethod;
    if ((getReadRealMethod = GenericFmuServiceGrpc.getReadRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadRealMethod = GenericFmuServiceGrpc.getReadRealMethod) == null) {
          GenericFmuServiceGrpc.getReadRealMethod = getReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "ReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadReal"))
                  .build();
          }
        }
     }
     return getReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> METHOD_READ_STRING = getReadStringMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> getReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> getReadStringMethod() {
    return getReadStringMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> getReadStringMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> getReadStringMethod;
    if ((getReadStringMethod = GenericFmuServiceGrpc.getReadStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadStringMethod = GenericFmuServiceGrpc.getReadStringMethod) == null) {
          GenericFmuServiceGrpc.getReadStringMethod = getReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "ReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadString"))
                  .build();
          }
        }
     }
     return getReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> METHOD_READ_BOOLEAN = getReadBooleanMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> getReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> getReadBooleanMethod() {
    return getReadBooleanMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> getReadBooleanMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> getReadBooleanMethod;
    if ((getReadBooleanMethod = GenericFmuServiceGrpc.getReadBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadBooleanMethod = GenericFmuServiceGrpc.getReadBooleanMethod) == null) {
          GenericFmuServiceGrpc.getReadBooleanMethod = getReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "ReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadBoolean"))
                  .build();
          }
        }
     }
     return getReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> METHOD_BULK_READ_INTEGER = getBulkReadIntegerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> getBulkReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> getBulkReadIntegerMethod() {
    return getBulkReadIntegerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> getBulkReadIntegerMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> getBulkReadIntegerMethod;
    if ((getBulkReadIntegerMethod = GenericFmuServiceGrpc.getBulkReadIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadIntegerMethod = GenericFmuServiceGrpc.getBulkReadIntegerMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadIntegerMethod = getBulkReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadInteger"))
                  .build();
          }
        }
     }
     return getBulkReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> METHOD_BULK_READ_REAL = getBulkReadRealMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> getBulkReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> getBulkReadRealMethod() {
    return getBulkReadRealMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> getBulkReadRealMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> getBulkReadRealMethod;
    if ((getBulkReadRealMethod = GenericFmuServiceGrpc.getBulkReadRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadRealMethod = GenericFmuServiceGrpc.getBulkReadRealMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadRealMethod = getBulkReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadReal"))
                  .build();
          }
        }
     }
     return getBulkReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> METHOD_BULK_READ_STRING = getBulkReadStringMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> getBulkReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> getBulkReadStringMethod() {
    return getBulkReadStringMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> getBulkReadStringMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> getBulkReadStringMethod;
    if ((getBulkReadStringMethod = GenericFmuServiceGrpc.getBulkReadStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadStringMethod = GenericFmuServiceGrpc.getBulkReadStringMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadStringMethod = getBulkReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadString"))
                  .build();
          }
        }
     }
     return getBulkReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> METHOD_BULK_READ_BOOLEAN = getBulkReadBooleanMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> getBulkReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> getBulkReadBooleanMethod() {
    return getBulkReadBooleanMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> getBulkReadBooleanMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> getBulkReadBooleanMethod;
    if ((getBulkReadBooleanMethod = GenericFmuServiceGrpc.getBulkReadBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadBooleanMethod = GenericFmuServiceGrpc.getBulkReadBooleanMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadBooleanMethod = getBulkReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadBoolean"))
                  .build();
          }
        }
     }
     return getBulkReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_WRITE_INTEGER = getWriteIntegerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteIntegerMethod() {
    return getWriteIntegerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteIntegerMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteIntegerMethod;
    if ((getWriteIntegerMethod = GenericFmuServiceGrpc.getWriteIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteIntegerMethod = GenericFmuServiceGrpc.getWriteIntegerMethod) == null) {
          GenericFmuServiceGrpc.getWriteIntegerMethod = getWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "WriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteInteger"))
                  .build();
          }
        }
     }
     return getWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_WRITE_REAL = getWriteRealMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteRealMethod() {
    return getWriteRealMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteRealMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteRealMethod;
    if ((getWriteRealMethod = GenericFmuServiceGrpc.getWriteRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteRealMethod = GenericFmuServiceGrpc.getWriteRealMethod) == null) {
          GenericFmuServiceGrpc.getWriteRealMethod = getWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "WriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteReal"))
                  .build();
          }
        }
     }
     return getWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_WRITE_STRING = getWriteStringMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteStringMethod() {
    return getWriteStringMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteStringMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteStringMethod;
    if ((getWriteStringMethod = GenericFmuServiceGrpc.getWriteStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteStringMethod = GenericFmuServiceGrpc.getWriteStringMethod) == null) {
          GenericFmuServiceGrpc.getWriteStringMethod = getWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "WriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteString"))
                  .build();
          }
        }
     }
     return getWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_WRITE_BOOLEAN = getWriteBooleanMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteBooleanMethod() {
    return getWriteBooleanMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteBooleanMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getWriteBooleanMethod;
    if ((getWriteBooleanMethod = GenericFmuServiceGrpc.getWriteBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteBooleanMethod = GenericFmuServiceGrpc.getWriteBooleanMethod) == null) {
          GenericFmuServiceGrpc.getWriteBooleanMethod = getWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "WriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteBoolean"))
                  .build();
          }
        }
     }
     return getWriteBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_BULK_WRITE_INTEGER = getBulkWriteIntegerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteIntegerMethod() {
    return getBulkWriteIntegerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteIntegerMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteIntegerMethod;
    if ((getBulkWriteIntegerMethod = GenericFmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteIntegerMethod = GenericFmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteIntegerMethod = getBulkWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkWriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteInteger"))
                  .build();
          }
        }
     }
     return getBulkWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_BULK_WRITE_REAL = getBulkWriteRealMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteRealMethod() {
    return getBulkWriteRealMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteRealMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteRealMethod;
    if ((getBulkWriteRealMethod = GenericFmuServiceGrpc.getBulkWriteRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteRealMethod = GenericFmuServiceGrpc.getBulkWriteRealMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteRealMethod = getBulkWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkWriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteReal"))
                  .build();
          }
        }
     }
     return getBulkWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_BULK_WRITE_STRING = getBulkWriteStringMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteStringMethod() {
    return getBulkWriteStringMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteStringMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteStringMethod;
    if ((getBulkWriteStringMethod = GenericFmuServiceGrpc.getBulkWriteStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteStringMethod = GenericFmuServiceGrpc.getBulkWriteStringMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteStringMethod = getBulkWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkWriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteString"))
                  .build();
          }
        }
     }
     return getBulkWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> METHOD_BULK_WRITE_BOOLEAN = getBulkWriteBooleanMethodHelper();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteBooleanMethod() {
    return getBulkWriteBooleanMethodHelper();
  }

  private static io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteBooleanMethodHelper() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> getBulkWriteBooleanMethod;
    if ((getBulkWriteBooleanMethod = GenericFmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteBooleanMethod = GenericFmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteBooleanMethod = getBulkWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest, no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuService", "BulkWriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteBoolean"))
                  .build();
          }
        }
     }
     return getBulkWriteBooleanMethod;
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
    public void getModelDescriptionXml(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionXmlMethodHelper(), responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromCSMethodHelper(), responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromMEMethodHelper(), responseObserver);
    }

    /**
     */
    public void getGuid(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGuidMethodHelper(), responseObserver);
    }

    /**
     */
    public void getModelName(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelNameMethodHelper(), responseObserver);
    }

    /**
     */
    public void getModelVariables(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelVariablesMethodHelper(), responseObserver);
    }

    /**
     */
    public void getModelStructure(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelStructureMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTimeMethodHelper(), responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getIsTerminatedMethodHelper(), responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getInitMethodHelper(), responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getStepMethodHelper(), responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getTerminateMethodHelper(), responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getResetMethodHelper(), responseObserver);
    }

    /**
     */
    public void readInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegerMethodHelper(), responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRealMethodHelper(), responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStringMethodHelper(), responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBooleanMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadIntegerMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadRealMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadStringMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadBooleanMethodHelper(), responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegerMethodHelper(), responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRealMethodHelper(), responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteStringMethodHelper(), responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteBooleanMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteIntegerMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteRealMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteStringMethodHelper(), responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteBooleanMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetModelDescriptionXmlMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>(
                  this, METHODID_GET_MODEL_DESCRIPTION_XML)))
          .addMethod(
            getCreateInstanceFromCSMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt>(
                  this, METHODID_CREATE_INSTANCE_FROM_CS)))
          .addMethod(
            getCreateInstanceFromMEMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt>(
                  this, METHODID_CREATE_INSTANCE_FROM_ME)))
          .addMethod(
            getGetGuidMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>(
                  this, METHODID_GET_GUID)))
          .addMethod(
            getGetModelNameMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>(
                  this, METHODID_GET_MODEL_NAME)))
          .addMethod(
            getGetModelVariablesMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable>(
                  this, METHODID_GET_MODEL_VARIABLES)))
          .addMethod(
            getGetModelStructureMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure>(
                  this, METHODID_GET_MODEL_STRUCTURE)))
          .addMethod(
            getGetCurrentTimeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real>(
                  this, METHODID_GET_CURRENT_TIME)))
          .addMethod(
            getIsTerminatedMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>(
                  this, METHODID_IS_TERMINATED)))
          .addMethod(
            getInitMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>(
                  this, METHODID_INIT)))
          .addMethod(
            getStepMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_STEP)))
          .addMethod(
            getTerminateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>(
                  this, METHODID_TERMINATE)))
          .addMethod(
            getResetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_RESET)))
          .addMethod(
            getReadIntegerMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead>(
                  this, METHODID_READ_INTEGER)))
          .addMethod(
            getReadRealMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead>(
                  this, METHODID_READ_REAL)))
          .addMethod(
            getReadStringMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead>(
                  this, METHODID_READ_STRING)))
          .addMethod(
            getReadBooleanMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead>(
                  this, METHODID_READ_BOOLEAN)))
          .addMethod(
            getBulkReadIntegerMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead>(
                  this, METHODID_BULK_READ_INTEGER)))
          .addMethod(
            getBulkReadRealMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead>(
                  this, METHODID_BULK_READ_REAL)))
          .addMethod(
            getBulkReadStringMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead>(
                  this, METHODID_BULK_READ_STRING)))
          .addMethod(
            getBulkReadBooleanMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead>(
                  this, METHODID_BULK_READ_BOOLEAN)))
          .addMethod(
            getWriteIntegerMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INTEGER)))
          .addMethod(
            getWriteRealMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_WRITE_REAL)))
          .addMethod(
            getWriteStringMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_WRITE_STRING)))
          .addMethod(
            getWriteBooleanMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_WRITE_BOOLEAN)))
          .addMethod(
            getBulkWriteIntegerMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_INTEGER)))
          .addMethod(
            getBulkWriteRealMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_REAL)))
          .addMethod(
            getBulkWriteStringMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_STRING)))
          .addMethod(
            getBulkWriteBooleanMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest,
                no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_BOOLEAN)))
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
    public void getModelDescriptionXml(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGuid(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGuidMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelName(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelNameMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelVariables(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetModelVariablesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getModelStructure(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelStructureMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public void getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsTerminatedMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void init(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void step(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStepMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void terminate(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTerminateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reset(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegerMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRealMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStringMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBooleanMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadRealMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadStringMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegerMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRealMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteStringMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteBooleanMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteRealMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteStringMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethodHelper(), getCallOptions()), request, responseObserver);
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
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str getModelDescriptionXml(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionXmlMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt createInstanceFromCS(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromCSMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt createInstanceFromME(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromMEMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str getGuid(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetGuidMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str getModelName(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelNameMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable> getModelVariables(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetModelVariablesMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure getModelStructure(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelStructureMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real getCurrentTime(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTimeMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool isTerminated(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getIsTerminatedMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool init(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest request) {
      return blockingUnaryCall(
          getChannel(), getInitMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status step(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest request) {
      return blockingUnaryCall(
          getChannel(), getStepMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool terminate(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getTerminateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status reset(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getResetMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead readInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegerMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead readReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadRealMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead readString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadStringMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead readBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadBooleanMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead bulkReadInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadIntegerMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead bulkReadReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadRealMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead bulkReadString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadStringMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead bulkReadBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadBooleanMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status writeInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegerMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status writeReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteRealMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status writeString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteStringMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status writeBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteBooleanMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status bulkWriteInteger(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteIntegerMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status bulkWriteReal(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteRealMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status bulkWriteString(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteStringMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status bulkWriteBoolean(no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteBooleanMethodHelper(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getModelDescriptionXml(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> createInstanceFromCS(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt> createInstanceFromME(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getGuid(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGuidMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str> getModelName(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelNameMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure> getModelStructure(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelStructureMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     *instance methods
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real> getCurrentTime(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> isTerminated(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getIsTerminatedMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> init(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInitMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> step(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStepMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool> terminate(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getTerminateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> reset(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getResetMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead> readInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegerMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead> readReal(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRealMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead> readString(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStringMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead> readBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBooleanMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead> bulkReadInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead> bulkReadReal(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadRealMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead> bulkReadString(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadStringMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead> bulkReadBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> writeInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegerMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> writeReal(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRealMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> writeString(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteStringMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> writeBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteBooleanMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> bulkWriteInteger(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> bulkWriteReal(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteRealMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> bulkWriteString(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteStringMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status> bulkWriteBoolean(
        no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MODEL_DESCRIPTION_XML = 0;
  private static final int METHODID_CREATE_INSTANCE_FROM_CS = 1;
  private static final int METHODID_CREATE_INSTANCE_FROM_ME = 2;
  private static final int METHODID_GET_GUID = 3;
  private static final int METHODID_GET_MODEL_NAME = 4;
  private static final int METHODID_GET_MODEL_VARIABLES = 5;
  private static final int METHODID_GET_MODEL_STRUCTURE = 6;
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
        case METHODID_GET_MODEL_DESCRIPTION_XML:
          serviceImpl.getModelDescriptionXml((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_CS:
          serviceImpl.createInstanceFromCS((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_ME:
          serviceImpl.createInstanceFromME((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Integrator) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt>) responseObserver);
          break;
        case METHODID_GET_GUID:
          serviceImpl.getGuid((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_NAME:
          serviceImpl.getModelName((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLES:
          serviceImpl.getModelVariables((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ScalarVariable>) responseObserver);
          break;
        case METHODID_GET_MODEL_STRUCTURE:
          serviceImpl.getModelStructure((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ModelStructure>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_IS_TERMINATED:
          serviceImpl.isTerminated((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.InitRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_STEP:
          serviceImpl.step((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StepRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_TERMINATE:
          serviceImpl.terminate((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Bool>) responseObserver);
          break;
        case METHODID_RESET:
          serviceImpl.reset((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INTEGER:
          serviceImpl.readInteger((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntRead>) responseObserver);
          break;
        case METHODID_READ_REAL:
          serviceImpl.readReal((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_READ_STRING:
          serviceImpl.readString((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrRead>) responseObserver);
          break;
        case METHODID_READ_BOOLEAN:
          serviceImpl.readBoolean((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolRead>) responseObserver);
          break;
        case METHODID_BULK_READ_INTEGER:
          serviceImpl.bulkReadInteger((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.IntListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_REAL:
          serviceImpl.bulkReadReal((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.RealListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_STRING:
          serviceImpl.bulkReadString((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.StrListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_BOOLEAN:
          serviceImpl.bulkReadBoolean((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BoolListRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGER:
          serviceImpl.writeInteger((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteIntegerRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_WRITE_REAL:
          serviceImpl.writeReal((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_WRITE_STRING:
          serviceImpl.writeString((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteStringRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_WRITE_BOOLEAN:
          serviceImpl.writeBoolean((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.WriteBooleanRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_INTEGER:
          serviceImpl.bulkWriteInteger((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteIntegerRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_REAL:
          serviceImpl.bulkWriteReal((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_STRING:
          serviceImpl.bulkWriteString((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteStringRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_BOOLEAN:
          serviceImpl.bulkWriteBoolean((no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.BulkWriteBooleanRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.fmu_proxy.grpc.FmiDefinitions.Status>) responseObserver);
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
      return no.mechatronics.sfi.fmu_proxy.grpc.GenericFmuProto.getDescriptor();
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
              .addMethod(getGetModelDescriptionXmlMethodHelper())
              .addMethod(getCreateInstanceFromCSMethodHelper())
              .addMethod(getCreateInstanceFromMEMethodHelper())
              .addMethod(getGetGuidMethodHelper())
              .addMethod(getGetModelNameMethodHelper())
              .addMethod(getGetModelVariablesMethodHelper())
              .addMethod(getGetModelStructureMethodHelper())
              .addMethod(getGetCurrentTimeMethodHelper())
              .addMethod(getIsTerminatedMethodHelper())
              .addMethod(getInitMethodHelper())
              .addMethod(getStepMethodHelper())
              .addMethod(getTerminateMethodHelper())
              .addMethod(getResetMethodHelper())
              .addMethod(getReadIntegerMethodHelper())
              .addMethod(getReadRealMethodHelper())
              .addMethod(getReadStringMethodHelper())
              .addMethod(getReadBooleanMethodHelper())
              .addMethod(getBulkReadIntegerMethodHelper())
              .addMethod(getBulkReadRealMethodHelper())
              .addMethod(getBulkReadStringMethodHelper())
              .addMethod(getBulkReadBooleanMethodHelper())
              .addMethod(getWriteIntegerMethodHelper())
              .addMethod(getWriteRealMethodHelper())
              .addMethod(getWriteStringMethodHelper())
              .addMethod(getWriteBooleanMethodHelper())
              .addMethod(getBulkWriteIntegerMethodHelper())
              .addMethod(getBulkWriteRealMethodHelper())
              .addMethod(getBulkWriteStringMethodHelper())
              .addMethod(getBulkWriteBooleanMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
