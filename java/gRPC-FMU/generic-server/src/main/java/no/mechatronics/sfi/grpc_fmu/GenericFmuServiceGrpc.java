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
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: service.proto")
public final class GenericFmuServiceGrpc {

  private GenericFmuServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.grpc_fmu.GenericFmuService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetModelDescriptionXmlMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> METHOD_GET_MODEL_DESCRIPTION_XML = getGetModelDescriptionXmlMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetModelDescriptionXmlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetModelDescriptionXmlMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetModelDescriptionXmlMethod;
    if ((getGetModelDescriptionXmlMethod = GenericFmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelDescriptionXmlMethod = GenericFmuServiceGrpc.getGetModelDescriptionXmlMethod) == null) {
          GenericFmuServiceGrpc.getGetModelDescriptionXmlMethod = getGetModelDescriptionXmlMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetModelDescriptionXml"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelDescriptionXml"))
                  .build();
          }
        }
     }
     return getGetModelDescriptionXmlMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromCSMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> METHOD_CREATE_INSTANCE_FROM_CS = getCreateInstanceFromCSMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceFromCSMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceFromCSMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceFromCSMethod;
    if ((getCreateInstanceFromCSMethod = GenericFmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getCreateInstanceFromCSMethod = GenericFmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
          GenericFmuServiceGrpc.getCreateInstanceFromCSMethod = getCreateInstanceFromCSMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "CreateInstanceFromCS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("CreateInstanceFromCS"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromCSMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceFromMEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> METHOD_CREATE_INSTANCE_FROM_ME = getCreateInstanceFromMEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceFromMEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceFromMEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> getCreateInstanceFromMEMethod;
    if ((getCreateInstanceFromMEMethod = GenericFmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getCreateInstanceFromMEMethod = GenericFmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
          GenericFmuServiceGrpc.getCreateInstanceFromMEMethod = getCreateInstanceFromMEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "CreateInstanceFromME"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("CreateInstanceFromME"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromMEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGuidMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> METHOD_GET_GUID = getGetGuidMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetGuidMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetGuidMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGetGuidMethod;
    if ((getGetGuidMethod = GenericFmuServiceGrpc.getGetGuidMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetGuidMethod = GenericFmuServiceGrpc.getGetGuidMethod) == null) {
          GenericFmuServiceGrpc.getGetGuidMethod = getGetGuidMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetGuid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetGuid"))
                  .build();
          }
        }
     }
     return getGetGuidMethod;
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
  @java.lang.Deprecated // Use {@link #getGetModelStructureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> METHOD_GET_MODEL_STRUCTURE = getGetModelStructureMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> getGetModelStructureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> getGetModelStructureMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> getGetModelStructureMethod;
    if ((getGetModelStructureMethod = GenericFmuServiceGrpc.getGetModelStructureMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getGetModelStructureMethod = GenericFmuServiceGrpc.getGetModelStructureMethod) == null) {
          GenericFmuServiceGrpc.getGetModelStructureMethod = getGetModelStructureMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "GetModelStructure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("GetModelStructure"))
                  .build();
          }
        }
     }
     return getGetModelStructureMethod;
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
  @java.lang.Deprecated // Use {@link #getReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> METHOD_READ_INTEGER = getReadIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> getReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> getReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> getReadIntegerMethod;
    if ((getReadIntegerMethod = GenericFmuServiceGrpc.getReadIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadIntegerMethod = GenericFmuServiceGrpc.getReadIntegerMethod) == null) {
          GenericFmuServiceGrpc.getReadIntegerMethod = getReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadInteger"))
                  .build();
          }
        }
     }
     return getReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> METHOD_READ_REAL = getReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> getReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> getReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> getReadRealMethod;
    if ((getReadRealMethod = GenericFmuServiceGrpc.getReadRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadRealMethod = GenericFmuServiceGrpc.getReadRealMethod) == null) {
          GenericFmuServiceGrpc.getReadRealMethod = getReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead.getDefaultInstance()))
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
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> METHOD_READ_STRING = getReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> getReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> getReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> getReadStringMethod;
    if ((getReadStringMethod = GenericFmuServiceGrpc.getReadStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadStringMethod = GenericFmuServiceGrpc.getReadStringMethod) == null) {
          GenericFmuServiceGrpc.getReadStringMethod = getReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead.getDefaultInstance()))
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
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> METHOD_READ_BOOLEAN = getReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> getReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> getReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> getReadBooleanMethod;
    if ((getReadBooleanMethod = GenericFmuServiceGrpc.getReadBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getReadBooleanMethod = GenericFmuServiceGrpc.getReadBooleanMethod) == null) {
          GenericFmuServiceGrpc.getReadBooleanMethod = getReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "ReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("ReadBoolean"))
                  .build();
          }
        }
     }
     return getReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> METHOD_BULK_READ_INTEGER = getBulkReadIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> getBulkReadIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> getBulkReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> getBulkReadIntegerMethod;
    if ((getBulkReadIntegerMethod = GenericFmuServiceGrpc.getBulkReadIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadIntegerMethod = GenericFmuServiceGrpc.getBulkReadIntegerMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadIntegerMethod = getBulkReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadInteger"))
                  .build();
          }
        }
     }
     return getBulkReadIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> METHOD_BULK_READ_REAL = getBulkReadRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> getBulkReadRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> getBulkReadRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> getBulkReadRealMethod;
    if ((getBulkReadRealMethod = GenericFmuServiceGrpc.getBulkReadRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadRealMethod = GenericFmuServiceGrpc.getBulkReadRealMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadRealMethod = getBulkReadRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadReal"))
                  .build();
          }
        }
     }
     return getBulkReadRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> METHOD_BULK_READ_STRING = getBulkReadStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> getBulkReadStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> getBulkReadStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> getBulkReadStringMethod;
    if ((getBulkReadStringMethod = GenericFmuServiceGrpc.getBulkReadStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadStringMethod = GenericFmuServiceGrpc.getBulkReadStringMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadStringMethod = getBulkReadStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadString"))
                  .build();
          }
        }
     }
     return getBulkReadStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkReadBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> METHOD_BULK_READ_BOOLEAN = getBulkReadBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> getBulkReadBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> getBulkReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> getBulkReadBooleanMethod;
    if ((getBulkReadBooleanMethod = GenericFmuServiceGrpc.getBulkReadBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkReadBooleanMethod = GenericFmuServiceGrpc.getBulkReadBooleanMethod) == null) {
          GenericFmuServiceGrpc.getBulkReadBooleanMethod = getBulkReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkReadBoolean"))
                  .build();
          }
        }
     }
     return getBulkReadBooleanMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INTEGER = getWriteIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteIntegerMethod;
    if ((getWriteIntegerMethod = GenericFmuServiceGrpc.getWriteIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getWriteIntegerMethod = GenericFmuServiceGrpc.getWriteIntegerMethod) == null) {
          GenericFmuServiceGrpc.getWriteIntegerMethod = getWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "WriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("WriteInteger"))
                  .build();
          }
        }
     }
     return getWriteIntegerMethod;
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
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteIntegerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_BULK_WRITE_INTEGER = getBulkWriteIntegerMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteIntegerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteIntegerMethod;
    if ((getBulkWriteIntegerMethod = GenericFmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteIntegerMethod = GenericFmuServiceGrpc.getBulkWriteIntegerMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteIntegerMethod = getBulkWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkWriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteInteger"))
                  .build();
          }
        }
     }
     return getBulkWriteIntegerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteRealMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_BULK_WRITE_REAL = getBulkWriteRealMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteRealMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteRealMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteRealMethod;
    if ((getBulkWriteRealMethod = GenericFmuServiceGrpc.getBulkWriteRealMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteRealMethod = GenericFmuServiceGrpc.getBulkWriteRealMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteRealMethod = getBulkWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkWriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteReal"))
                  .build();
          }
        }
     }
     return getBulkWriteRealMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteStringMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_BULK_WRITE_STRING = getBulkWriteStringMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteStringMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteStringMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteStringMethod;
    if ((getBulkWriteStringMethod = GenericFmuServiceGrpc.getBulkWriteStringMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteStringMethod = GenericFmuServiceGrpc.getBulkWriteStringMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteStringMethod = getBulkWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkWriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new GenericFmuServiceMethodDescriptorSupplier("BulkWriteString"))
                  .build();
          }
        }
     }
     return getBulkWriteStringMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBulkWriteBooleanMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_BULK_WRITE_BOOLEAN = getBulkWriteBooleanMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteBooleanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getBulkWriteBooleanMethod;
    if ((getBulkWriteBooleanMethod = GenericFmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
      synchronized (GenericFmuServiceGrpc.class) {
        if ((getBulkWriteBooleanMethod = GenericFmuServiceGrpc.getBulkWriteBooleanMethod) == null) {
          GenericFmuServiceGrpc.getBulkWriteBooleanMethod = getBulkWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.GenericFmuService", "BulkWriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
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
    public void getModelDescriptionXml(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionXmlMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromCSMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromMEMethod(), responseObserver);
    }

    /**
     */
    public void getGuid(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGuidMethod(), responseObserver);
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
     */
    public void getModelStructure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelStructureMethod(), responseObserver);
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
    public void readInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRealMethod(), responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStringMethod(), responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadRealMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadStringMethod(), responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegerMethod(), responseObserver);
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

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteIntegerMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getBulkWriteBooleanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetModelDescriptionXmlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>(
                  this, METHODID_GET_MODEL_DESCRIPTION_XML)))
          .addMethod(
            getCreateInstanceFromCSMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>(
                  this, METHODID_CREATE_INSTANCE_FROM_CS)))
          .addMethod(
            getCreateInstanceFromMEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>(
                  this, METHODID_CREATE_INSTANCE_FROM_ME)))
          .addMethod(
            getGetGuidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>(
                  this, METHODID_GET_GUID)))
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
            getGetModelStructureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure>(
                  this, METHODID_GET_MODEL_STRUCTURE)))
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
            getReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead>(
                  this, METHODID_READ_INTEGER)))
          .addMethod(
            getReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_REAL)))
          .addMethod(
            getReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead>(
                  this, METHODID_READ_STRING)))
          .addMethod(
            getReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead>(
                  this, METHODID_READ_BOOLEAN)))
          .addMethod(
            getBulkReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead>(
                  this, METHODID_BULK_READ_INTEGER)))
          .addMethod(
            getBulkReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead>(
                  this, METHODID_BULK_READ_REAL)))
          .addMethod(
            getBulkReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead>(
                  this, METHODID_BULK_READ_STRING)))
          .addMethod(
            getBulkReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead>(
                  this, METHODID_BULK_READ_BOOLEAN)))
          .addMethod(
            getWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INTEGER)))
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
          .addMethod(
            getBulkWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_INTEGER)))
          .addMethod(
            getBulkWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_REAL)))
          .addMethod(
            getBulkWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_BULK_WRITE_STRING)))
          .addMethod(
            getBulkWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
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
    public void getModelDescriptionXml(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGuid(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGuidMethod(), getCallOptions()), request, responseObserver);
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
     */
    public void getModelStructure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelStructureMethod(), getCallOptions()), request, responseObserver);
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
    public void readInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkReadBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public void bulkWriteInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkWriteBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethod(), getCallOptions()), request, responseObserver);
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
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str getModelDescriptionXml(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionXmlMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt createInstanceFromCS(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromCSMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt createInstanceFromME(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromMEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str getGuid(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetGuidMethod(), getCallOptions(), request);
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
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure getModelStructure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetModelStructureMethod(), getCallOptions(), request);
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
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead readInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead readReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead readString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead readBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead bulkReadInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead bulkReadReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead bulkReadString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead bulkReadBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegerMethod(), getCallOptions(), request);
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

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status bulkWriteInteger(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status bulkWriteReal(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status bulkWriteString(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status bulkWriteBoolean(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getBulkWriteBooleanMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getModelDescriptionXml(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelDescriptionXmlMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> createInstanceFromCS(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt> createInstanceFromME(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str> getGuid(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGuidMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure> getModelStructure(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelStructureMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead> readInteger(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead> readReal(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead> readString(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead> readBoolean(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead> bulkReadInteger(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead> bulkReadReal(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead> bulkReadString(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead> bulkReadBoolean(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInteger(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> bulkWriteInteger(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> bulkWriteReal(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> bulkWriteString(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> bulkWriteBoolean(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBulkWriteBooleanMethod(), getCallOptions()), request);
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
          serviceImpl.getModelDescriptionXml((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_CS:
          serviceImpl.createInstanceFromCS((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_ME:
          serviceImpl.createInstanceFromME((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Integrator) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt>) responseObserver);
          break;
        case METHODID_GET_GUID:
          serviceImpl.getGuid((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_NAME:
          serviceImpl.getModelName((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLES:
          serviceImpl.getModelVariables((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ScalarVariable>) responseObserver);
          break;
        case METHODID_GET_MODEL_STRUCTURE:
          serviceImpl.getModelStructure((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Empty) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ModelStructure>) responseObserver);
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
        case METHODID_READ_INTEGER:
          serviceImpl.readInteger((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntRead>) responseObserver);
          break;
        case METHODID_READ_REAL:
          serviceImpl.readReal((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_READ_STRING:
          serviceImpl.readString((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrRead>) responseObserver);
          break;
        case METHODID_READ_BOOLEAN:
          serviceImpl.readBoolean((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolRead>) responseObserver);
          break;
        case METHODID_BULK_READ_INTEGER:
          serviceImpl.bulkReadInteger((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.IntListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_REAL:
          serviceImpl.bulkReadReal((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.RealListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_STRING:
          serviceImpl.bulkReadString((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.StrListRead>) responseObserver);
          break;
        case METHODID_BULK_READ_BOOLEAN:
          serviceImpl.bulkReadBoolean((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkReadRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BoolListRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGER:
          serviceImpl.writeInteger((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.WriteIntegerRequest) request,
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
        case METHODID_BULK_WRITE_INTEGER:
          serviceImpl.bulkWriteInteger((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteIntegerRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_REAL:
          serviceImpl.bulkWriteReal((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_STRING:
          serviceImpl.bulkWriteString((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteStringRequest) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_BULK_WRITE_BOOLEAN:
          serviceImpl.bulkWriteBoolean((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.BulkWriteBooleanRequest) request,
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
              .addMethod(getGetModelDescriptionXmlMethod())
              .addMethod(getCreateInstanceFromCSMethod())
              .addMethod(getCreateInstanceFromMEMethod())
              .addMethod(getGetGuidMethod())
              .addMethod(getGetModelNameMethod())
              .addMethod(getGetModelVariablesMethod())
              .addMethod(getGetModelStructureMethod())
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
