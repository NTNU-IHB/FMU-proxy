package no.ntnu.ihb.fmuproxy.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: service.proto")
public final class FmuServiceGrpc {

  private FmuServiceGrpc() {}

  public static final String SERVICE_NAME = "fmuproxy.grpc.FmuService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> getGetModelDescriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelDescription",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> getGetModelDescriptionMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest, no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> getGetModelDescriptionMethod;
    if ((getGetModelDescriptionMethod = FmuServiceGrpc.getGetModelDescriptionMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetModelDescriptionMethod = FmuServiceGrpc.getGetModelDescriptionMethod) == null) {
          FmuServiceGrpc.getGetModelDescriptionMethod = getGetModelDescriptionMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest, no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "GetModelDescription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetModelDescription"))
                  .build();
          }
        }
     }
     return getGetModelDescriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes> getGetCoSimulationAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCoSimulationAttributes",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes> getGetCoSimulationAttributesMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest, no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes> getGetCoSimulationAttributesMethod;
    if ((getGetCoSimulationAttributesMethod = FmuServiceGrpc.getGetCoSimulationAttributesMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetCoSimulationAttributesMethod = FmuServiceGrpc.getGetCoSimulationAttributesMethod) == null) {
          FmuServiceGrpc.getGetCoSimulationAttributesMethod = getGetCoSimulationAttributesMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest, no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "GetCoSimulationAttributes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetCoSimulationAttributes"))
                  .build();
          }
        }
     }
     return getGetCoSimulationAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.Bool> getCanCreateInstanceFromCSMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CanCreateInstanceFromCS",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.Bool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.Bool> getCanCreateInstanceFromCSMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest, no.ntnu.ihb.fmuproxy.grpc.Service.Bool> getCanCreateInstanceFromCSMethod;
    if ((getCanCreateInstanceFromCSMethod = FmuServiceGrpc.getCanCreateInstanceFromCSMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCanCreateInstanceFromCSMethod = FmuServiceGrpc.getCanCreateInstanceFromCSMethod) == null) {
          FmuServiceGrpc.getCanCreateInstanceFromCSMethod = getCanCreateInstanceFromCSMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest, no.ntnu.ihb.fmuproxy.grpc.Service.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "CanCreateInstanceFromCS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CanCreateInstanceFromCS"))
                  .build();
          }
        }
     }
     return getCanCreateInstanceFromCSMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.Bool> getCanCreateInstanceFromMEMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CanCreateInstanceFromME",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.Bool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.Bool> getCanCreateInstanceFromMEMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest, no.ntnu.ihb.fmuproxy.grpc.Service.Bool> getCanCreateInstanceFromMEMethod;
    if ((getCanCreateInstanceFromMEMethod = FmuServiceGrpc.getCanCreateInstanceFromMEMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCanCreateInstanceFromMEMethod = FmuServiceGrpc.getCanCreateInstanceFromMEMethod) == null) {
          FmuServiceGrpc.getCanCreateInstanceFromMEMethod = getCanCreateInstanceFromMEMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest, no.ntnu.ihb.fmuproxy.grpc.Service.Bool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "CanCreateInstanceFromME"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.Bool.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CanCreateInstanceFromME"))
                  .build();
          }
        }
     }
     return getCanCreateInstanceFromMEMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceFromCSMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstanceFromCS",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceFromCSMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest, no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceFromCSMethod;
    if ((getCreateInstanceFromCSMethod = FmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceFromCSMethod = FmuServiceGrpc.getCreateInstanceFromCSMethod) == null) {
          FmuServiceGrpc.getCreateInstanceFromCSMethod = getCreateInstanceFromCSMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest, no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "CreateInstanceFromCS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstanceFromCS"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromCSMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceFromMEMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstanceFromME",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceFromMEMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest, no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceFromMEMethod;
    if ((getCreateInstanceFromMEMethod = FmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceFromMEMethod = FmuServiceGrpc.getCreateInstanceFromMEMethod) == null) {
          FmuServiceGrpc.getCreateInstanceFromMEMethod = getCreateInstanceFromMEMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest, no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "CreateInstanceFromME"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstanceFromME"))
                  .build();
          }
        }
     }
     return getCreateInstanceFromMEMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getSetupExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetupExperiment",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getSetupExperimentMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getSetupExperimentMethod;
    if ((getSetupExperimentMethod = FmuServiceGrpc.getSetupExperimentMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getSetupExperimentMethod = FmuServiceGrpc.getSetupExperimentMethod) == null) {
          FmuServiceGrpc.getSetupExperimentMethod = getSetupExperimentMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "SetupExperiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("SetupExperiment"))
                  .build();
          }
        }
     }
     return getSetupExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getEnterInitializationModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnterInitializationMode",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getEnterInitializationModeMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getEnterInitializationModeMethod;
    if ((getEnterInitializationModeMethod = FmuServiceGrpc.getEnterInitializationModeMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getEnterInitializationModeMethod = FmuServiceGrpc.getEnterInitializationModeMethod) == null) {
          FmuServiceGrpc.getEnterInitializationModeMethod = getEnterInitializationModeMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "EnterInitializationMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("EnterInitializationMode"))
                  .build();
          }
        }
     }
     return getEnterInitializationModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getExitInitializationModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExitInitializationMode",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getExitInitializationModeMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getExitInitializationModeMethod;
    if ((getExitInitializationModeMethod = FmuServiceGrpc.getExitInitializationModeMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getExitInitializationModeMethod = FmuServiceGrpc.getExitInitializationModeMethod) == null) {
          FmuServiceGrpc.getExitInitializationModeMethod = getExitInitializationModeMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "ExitInitializationMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ExitInitializationMode"))
                  .build();
          }
        }
     }
     return getExitInitializationModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse> getStepMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Step",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse> getStepMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse> getStepMethod;
    if ((getStepMethod = FmuServiceGrpc.getStepMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getStepMethod = FmuServiceGrpc.getStepMethod) == null) {
          FmuServiceGrpc.getStepMethod = getStepMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "Step"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Step"))
                  .build();
          }
        }
     }
     return getStepMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getResetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Reset",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getResetMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getResetMethod;
    if ((getResetMethod = FmuServiceGrpc.getResetMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getResetMethod = FmuServiceGrpc.getResetMethod) == null) {
          FmuServiceGrpc.getResetMethod = getResetMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "Reset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Reset"))
                  .build();
          }
        }
     }
     return getResetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getTerminateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Terminate",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getTerminateMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getTerminateMethod;
    if ((getTerminateMethod = FmuServiceGrpc.getTerminateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getTerminateMethod = FmuServiceGrpc.getTerminateMethod) == null) {
          FmuServiceGrpc.getTerminateMethod = getTerminateMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "Terminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("Terminate"))
                  .build();
          }
        }
     }
     return getTerminateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead> getReadIntegerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadInteger",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead> getReadIntegerMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead> getReadIntegerMethod;
    if ((getReadIntegerMethod = FmuServiceGrpc.getReadIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadIntegerMethod = FmuServiceGrpc.getReadIntegerMethod) == null) {
          FmuServiceGrpc.getReadIntegerMethod = getReadIntegerMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "ReadInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadInteger"))
                  .build();
          }
        }
     }
     return getReadIntegerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.RealRead> getReadRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadReal",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.RealRead.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.RealRead> getReadRealMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.RealRead> getReadRealMethod;
    if ((getReadRealMethod = FmuServiceGrpc.getReadRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadRealMethod = FmuServiceGrpc.getReadRealMethod) == null) {
          FmuServiceGrpc.getReadRealMethod = getReadRealMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "ReadReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadReal"))
                  .build();
          }
        }
     }
     return getReadRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StringRead> getReadStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadString",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StringRead.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StringRead> getReadStringMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StringRead> getReadStringMethod;
    if ((getReadStringMethod = FmuServiceGrpc.getReadStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadStringMethod = FmuServiceGrpc.getReadStringMethod) == null) {
          FmuServiceGrpc.getReadStringMethod = getReadStringMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StringRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "ReadString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StringRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadString"))
                  .build();
          }
        }
     }
     return getReadStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead> getReadBooleanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadBoolean",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead> getReadBooleanMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead> getReadBooleanMethod;
    if ((getReadBooleanMethod = FmuServiceGrpc.getReadBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getReadBooleanMethod = FmuServiceGrpc.getReadBooleanMethod) == null) {
          FmuServiceGrpc.getReadBooleanMethod = getReadBooleanMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest, no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "ReadBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("ReadBoolean"))
                  .build();
          }
        }
     }
     return getReadBooleanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteIntegerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteInteger",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteIntegerMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteIntegerMethod;
    if ((getWriteIntegerMethod = FmuServiceGrpc.getWriteIntegerMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteIntegerMethod = FmuServiceGrpc.getWriteIntegerMethod) == null) {
          FmuServiceGrpc.getWriteIntegerMethod = getWriteIntegerMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "WriteInteger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteInteger"))
                  .build();
          }
        }
     }
     return getWriteIntegerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteReal",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteRealMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteRealMethod;
    if ((getWriteRealMethod = FmuServiceGrpc.getWriteRealMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteRealMethod = FmuServiceGrpc.getWriteRealMethod) == null) {
          FmuServiceGrpc.getWriteRealMethod = getWriteRealMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "WriteReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteReal"))
                  .build();
          }
        }
     }
     return getWriteRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteString",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteStringMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteStringMethod;
    if ((getWriteStringMethod = FmuServiceGrpc.getWriteStringMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteStringMethod = FmuServiceGrpc.getWriteStringMethod) == null) {
          FmuServiceGrpc.getWriteStringMethod = getWriteStringMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "WriteString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteString"))
                  .build();
          }
        }
     }
     return getWriteStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteBooleanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteBoolean",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteBooleanMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getWriteBooleanMethod;
    if ((getWriteBooleanMethod = FmuServiceGrpc.getWriteBooleanMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getWriteBooleanMethod = FmuServiceGrpc.getWriteBooleanMethod) == null) {
          FmuServiceGrpc.getWriteBooleanMethod = getWriteBooleanMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "WriteBoolean"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("WriteBoolean"))
                  .build();
          }
        }
     }
     return getWriteBooleanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse> getGetFMUstateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFMUstate",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse> getGetFMUstateMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse> getGetFMUstateMethod;
    if ((getGetFMUstateMethod = FmuServiceGrpc.getGetFMUstateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetFMUstateMethod = FmuServiceGrpc.getGetFMUstateMethod) == null) {
          FmuServiceGrpc.getGetFMUstateMethod = getGetFMUstateMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "GetFMUstate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetFMUstate"))
                  .build();
          }
        }
     }
     return getGetFMUstateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getSetFMUstateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetFMUstate",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getSetFMUstateMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getSetFMUstateMethod;
    if ((getSetFMUstateMethod = FmuServiceGrpc.getSetFMUstateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getSetFMUstateMethod = FmuServiceGrpc.getSetFMUstateMethod) == null) {
          FmuServiceGrpc.getSetFMUstateMethod = getSetFMUstateMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "SetFMUstate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("SetFMUstate"))
                  .build();
          }
        }
     }
     return getSetFMUstateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getFreeFMUstateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FreeFMUstate",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getFreeFMUstateMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> getFreeFMUstateMethod;
    if ((getFreeFMUstateMethod = FmuServiceGrpc.getFreeFMUstateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getFreeFMUstateMethod = FmuServiceGrpc.getFreeFMUstateMethod) == null) {
          FmuServiceGrpc.getFreeFMUstateMethod = getFreeFMUstateMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "FreeFMUstate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("FreeFMUstate"))
                  .build();
          }
        }
     }
     return getFreeFMUstateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse> getSerializeFMUstateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SerializeFMUstate",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse> getSerializeFMUstateMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse> getSerializeFMUstateMethod;
    if ((getSerializeFMUstateMethod = FmuServiceGrpc.getSerializeFMUstateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getSerializeFMUstateMethod = FmuServiceGrpc.getSerializeFMUstateMethod) == null) {
          FmuServiceGrpc.getSerializeFMUstateMethod = getSerializeFMUstateMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "SerializeFMUstate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("SerializeFMUstate"))
                  .build();
          }
        }
     }
     return getSerializeFMUstateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse> getDeSerializeFMUstateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeSerializeFMUstate",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse> getDeSerializeFMUstateMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse> getDeSerializeFMUstateMethod;
    if ((getDeSerializeFMUstateMethod = FmuServiceGrpc.getDeSerializeFMUstateMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getDeSerializeFMUstateMethod = FmuServiceGrpc.getDeSerializeFMUstateMethod) == null) {
          FmuServiceGrpc.getDeSerializeFMUstateMethod = getDeSerializeFMUstateMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest, no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "DeSerializeFMUstate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("DeSerializeFMUstate"))
                  .build();
          }
        }
     }
     return getDeSerializeFMUstateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> getGetDirectionalDerivativeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDirectionalDerivative",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> getGetDirectionalDerivativeMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest, no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> getGetDirectionalDerivativeMethod;
    if ((getGetDirectionalDerivativeMethod = FmuServiceGrpc.getGetDirectionalDerivativeMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getGetDirectionalDerivativeMethod = FmuServiceGrpc.getGetDirectionalDerivativeMethod) == null) {
          FmuServiceGrpc.getGetDirectionalDerivativeMethod = getGetDirectionalDerivativeMethod = 
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest, no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fmuproxy.grpc.FmuService", "GetDirectionalDerivative"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("GetDirectionalDerivative"))
                  .build();
          }
        }
     }
     return getGetDirectionalDerivativeMethod;
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
    public void getModelDescription(no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionMethod(), responseObserver);
    }

    /**
     */
    public void getCoSimulationAttributes(no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCoSimulationAttributesMethod(), responseObserver);
    }

    /**
     */
    public void canCreateInstanceFromCS(no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getCanCreateInstanceFromCSMethod(), responseObserver);
    }

    /**
     */
    public void canCreateInstanceFromME(no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(getCanCreateInstanceFromMEMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromCSMethod(), responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceFromMEMethod(), responseObserver);
    }

    /**
     */
    public void setupExperiment(no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetupExperimentMethod(), responseObserver);
    }

    /**
     */
    public void enterInitializationMode(no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEnterInitializationModeMethod(), responseObserver);
    }

    /**
     */
    public void exitInitializationMode(no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getExitInitializationModeMethod(), responseObserver);
    }

    /**
     */
    public void step(no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStepMethod(), responseObserver);
    }

    /**
     */
    public void reset(no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getResetMethod(), responseObserver);
    }

    /**
     */
    public void terminate(no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTerminateMethod(), responseObserver);
    }

    /**
     */
    public void readInteger(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegerMethod(), responseObserver);
    }

    /**
     */
    public void readReal(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRealMethod(), responseObserver);
    }

    /**
     */
    public void readString(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StringRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStringMethod(), responseObserver);
    }

    /**
     */
    public void readBoolean(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBooleanMethod(), responseObserver);
    }

    /**
     */
    public void writeInteger(no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegerMethod(), responseObserver);
    }

    /**
     */
    public void writeReal(no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRealMethod(), responseObserver);
    }

    /**
     */
    public void writeString(no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteStringMethod(), responseObserver);
    }

    /**
     */
    public void writeBoolean(no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteBooleanMethod(), responseObserver);
    }

    /**
     */
    public void getFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFMUstateMethod(), responseObserver);
    }

    /**
     */
    public void setFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetFMUstateMethod(), responseObserver);
    }

    /**
     */
    public void freeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFreeFMUstateMethod(), responseObserver);
    }

    /**
     */
    public void serializeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSerializeFMUstateMethod(), responseObserver);
    }

    /**
     */
    public void deSerializeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeSerializeFMUstateMethod(), responseObserver);
    }

    /**
     */
    public void getDirectionalDerivative(no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDirectionalDerivativeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetModelDescriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription>(
                  this, METHODID_GET_MODEL_DESCRIPTION)))
          .addMethod(
            getGetCoSimulationAttributesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes>(
                  this, METHODID_GET_CO_SIMULATION_ATTRIBUTES)))
          .addMethod(
            getCanCreateInstanceFromCSMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.Bool>(
                  this, METHODID_CAN_CREATE_INSTANCE_FROM_CS)))
          .addMethod(
            getCanCreateInstanceFromMEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.Bool>(
                  this, METHODID_CAN_CREATE_INSTANCE_FROM_ME)))
          .addMethod(
            getCreateInstanceFromCSMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>(
                  this, METHODID_CREATE_INSTANCE_FROM_CS)))
          .addMethod(
            getCreateInstanceFromMEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>(
                  this, METHODID_CREATE_INSTANCE_FROM_ME)))
          .addMethod(
            getSetupExperimentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_SETUP_EXPERIMENT)))
          .addMethod(
            getEnterInitializationModeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_ENTER_INITIALIZATION_MODE)))
          .addMethod(
            getExitInitializationModeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_EXIT_INITIALIZATION_MODE)))
          .addMethod(
            getStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse>(
                  this, METHODID_STEP)))
          .addMethod(
            getResetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_RESET)))
          .addMethod(
            getTerminateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_TERMINATE)))
          .addMethod(
            getReadIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead>(
                  this, METHODID_READ_INTEGER)))
          .addMethod(
            getReadRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.RealRead>(
                  this, METHODID_READ_REAL)))
          .addMethod(
            getReadStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StringRead>(
                  this, METHODID_READ_STRING)))
          .addMethod(
            getReadBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead>(
                  this, METHODID_READ_BOOLEAN)))
          .addMethod(
            getWriteIntegerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_WRITE_INTEGER)))
          .addMethod(
            getWriteRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_WRITE_REAL)))
          .addMethod(
            getWriteStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_WRITE_STRING)))
          .addMethod(
            getWriteBooleanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_WRITE_BOOLEAN)))
          .addMethod(
            getGetFMUstateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse>(
                  this, METHODID_GET_FMUSTATE)))
          .addMethod(
            getSetFMUstateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_SET_FMUSTATE)))
          .addMethod(
            getFreeFMUstateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>(
                  this, METHODID_FREE_FMUSTATE)))
          .addMethod(
            getSerializeFMUstateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse>(
                  this, METHODID_SERIALIZE_FMUSTATE)))
          .addMethod(
            getDeSerializeFMUstateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse>(
                  this, METHODID_DE_SERIALIZE_FMUSTATE)))
          .addMethod(
            getGetDirectionalDerivativeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse>(
                  this, METHODID_GET_DIRECTIONAL_DERIVATIVE)))
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
    public void getModelDescription(no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetModelDescriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCoSimulationAttributes(no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCoSimulationAttributesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void canCreateInstanceFromCS(no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCanCreateInstanceFromCSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void canCreateInstanceFromME(no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCanCreateInstanceFromMEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromCS(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createInstanceFromME(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setupExperiment(no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetupExperimentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void enterInitializationMode(no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnterInitializationModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void exitInitializationMode(no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExitInitializationModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void step(no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reset(no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void terminate(no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInteger(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readReal(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readString(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StringRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBoolean(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInteger(no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeReal(no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeString(no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeBoolean(no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFMUstateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetFMUstateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void freeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFreeFMUstateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void serializeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSerializeFMUstateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deSerializeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeSerializeFMUstateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDirectionalDerivative(no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDirectionalDerivativeMethod(), getCallOptions()), request, responseObserver);
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
    public no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription getModelDescription(no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes getCoSimulationAttributes(no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCoSimulationAttributesMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.Bool canCreateInstanceFromCS(no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest request) {
      return blockingUnaryCall(
          getChannel(), getCanCreateInstanceFromCSMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.Bool canCreateInstanceFromME(no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest request) {
      return blockingUnaryCall(
          getChannel(), getCanCreateInstanceFromMEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId createInstanceFromCS(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromCSMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId createInstanceFromME(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceFromMEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse setupExperiment(no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetupExperimentMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse enterInitializationMode(no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest request) {
      return blockingUnaryCall(
          getChannel(), getEnterInitializationModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse exitInitializationMode(no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest request) {
      return blockingUnaryCall(
          getChannel(), getExitInitializationModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse step(no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest request) {
      return blockingUnaryCall(
          getChannel(), getStepMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse reset(no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest request) {
      return blockingUnaryCall(
          getChannel(), getResetMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse terminate(no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest request) {
      return blockingUnaryCall(
          getChannel(), getTerminateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead readInteger(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.RealRead readReal(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StringRead readString(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead readBoolean(no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse writeInteger(no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegerMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse writeReal(no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse writeString(no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse writeBoolean(no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteBooleanMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse getFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFMUstateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse setFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetFMUstateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse freeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest request) {
      return blockingUnaryCall(
          getChannel(), getFreeFMUstateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse serializeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest request) {
      return blockingUnaryCall(
          getChannel(), getSerializeFMUstateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse deSerializeFMUstate(no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeSerializeFMUstateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse getDirectionalDerivative(no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDirectionalDerivativeMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> getModelDescription(
        no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetModelDescriptionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes> getCoSimulationAttributes(
        no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCoSimulationAttributesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.Bool> canCreateInstanceFromCS(
        no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCanCreateInstanceFromCSMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.Bool> canCreateInstanceFromME(
        no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCanCreateInstanceFromMEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> createInstanceFromCS(
        no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromCSMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> createInstanceFromME(
        no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceFromMEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> setupExperiment(
        no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetupExperimentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> enterInitializationMode(
        no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEnterInitializationModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> exitInitializationMode(
        no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExitInitializationModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse> step(
        no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStepMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> reset(
        no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getResetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> terminate(
        no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTerminateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead> readInteger(
        no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.RealRead> readReal(
        no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StringRead> readString(
        no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead> readBoolean(
        no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> writeInteger(
        no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> writeReal(
        no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> writeString(
        no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> writeBoolean(
        no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteBooleanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse> getFMUstate(
        no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFMUstateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> setFMUstate(
        no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetFMUstateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse> freeFMUstate(
        no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFreeFMUstateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse> serializeFMUstate(
        no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSerializeFMUstateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse> deSerializeFMUstate(
        no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeSerializeFMUstateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> getDirectionalDerivative(
        no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDirectionalDerivativeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MODEL_DESCRIPTION = 0;
  private static final int METHODID_GET_CO_SIMULATION_ATTRIBUTES = 1;
  private static final int METHODID_CAN_CREATE_INSTANCE_FROM_CS = 2;
  private static final int METHODID_CAN_CREATE_INSTANCE_FROM_ME = 3;
  private static final int METHODID_CREATE_INSTANCE_FROM_CS = 4;
  private static final int METHODID_CREATE_INSTANCE_FROM_ME = 5;
  private static final int METHODID_SETUP_EXPERIMENT = 6;
  private static final int METHODID_ENTER_INITIALIZATION_MODE = 7;
  private static final int METHODID_EXIT_INITIALIZATION_MODE = 8;
  private static final int METHODID_STEP = 9;
  private static final int METHODID_RESET = 10;
  private static final int METHODID_TERMINATE = 11;
  private static final int METHODID_READ_INTEGER = 12;
  private static final int METHODID_READ_REAL = 13;
  private static final int METHODID_READ_STRING = 14;
  private static final int METHODID_READ_BOOLEAN = 15;
  private static final int METHODID_WRITE_INTEGER = 16;
  private static final int METHODID_WRITE_REAL = 17;
  private static final int METHODID_WRITE_STRING = 18;
  private static final int METHODID_WRITE_BOOLEAN = 19;
  private static final int METHODID_GET_FMUSTATE = 20;
  private static final int METHODID_SET_FMUSTATE = 21;
  private static final int METHODID_FREE_FMUSTATE = 22;
  private static final int METHODID_SERIALIZE_FMUSTATE = 23;
  private static final int METHODID_DE_SERIALIZE_FMUSTATE = 24;
  private static final int METHODID_GET_DIRECTIONAL_DERIVATIVE = 25;

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
        case METHODID_GET_MODEL_DESCRIPTION:
          serviceImpl.getModelDescription((no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription>) responseObserver);
          break;
        case METHODID_GET_CO_SIMULATION_ATTRIBUTES:
          serviceImpl.getCoSimulationAttributes((no.ntnu.ihb.fmuproxy.grpc.Service.GetCoSimulationAttributesRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.CoSimulationAttributes>) responseObserver);
          break;
        case METHODID_CAN_CREATE_INSTANCE_FROM_CS:
          serviceImpl.canCreateInstanceFromCS((no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromCSRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.Bool>) responseObserver);
          break;
        case METHODID_CAN_CREATE_INSTANCE_FROM_ME:
          serviceImpl.canCreateInstanceFromME((no.ntnu.ihb.fmuproxy.grpc.Service.CanCreateInstanceFromMERequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.Bool>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_CS:
          serviceImpl.createInstanceFromCS((no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromCSRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE_FROM_ME:
          serviceImpl.createInstanceFromME((no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceFromMERequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>) responseObserver);
          break;
        case METHODID_SETUP_EXPERIMENT:
          serviceImpl.setupExperiment((no.ntnu.ihb.fmuproxy.grpc.Service.SetupExperimentRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_ENTER_INITIALIZATION_MODE:
          serviceImpl.enterInitializationMode((no.ntnu.ihb.fmuproxy.grpc.Service.EnterInitializationModeRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_EXIT_INITIALIZATION_MODE:
          serviceImpl.exitInitializationMode((no.ntnu.ihb.fmuproxy.grpc.Service.ExitInitializationModeRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_STEP:
          serviceImpl.step((no.ntnu.ihb.fmuproxy.grpc.Service.StepRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StepResponse>) responseObserver);
          break;
        case METHODID_RESET:
          serviceImpl.reset((no.ntnu.ihb.fmuproxy.grpc.Service.ResetRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_TERMINATE:
          serviceImpl.terminate((no.ntnu.ihb.fmuproxy.grpc.Service.TerminateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_READ_INTEGER:
          serviceImpl.readInteger((no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.IntegerRead>) responseObserver);
          break;
        case METHODID_READ_REAL:
          serviceImpl.readReal((no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.RealRead>) responseObserver);
          break;
        case METHODID_READ_STRING:
          serviceImpl.readString((no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StringRead>) responseObserver);
          break;
        case METHODID_READ_BOOLEAN:
          serviceImpl.readBoolean((no.ntnu.ihb.fmuproxy.grpc.Service.ReadRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.BooleanRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGER:
          serviceImpl.writeInteger((no.ntnu.ihb.fmuproxy.grpc.Service.WriteIntegerRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_WRITE_REAL:
          serviceImpl.writeReal((no.ntnu.ihb.fmuproxy.grpc.Service.WriteRealRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_WRITE_STRING:
          serviceImpl.writeString((no.ntnu.ihb.fmuproxy.grpc.Service.WriteStringRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_WRITE_BOOLEAN:
          serviceImpl.writeBoolean((no.ntnu.ihb.fmuproxy.grpc.Service.WriteBooleanRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_GET_FMUSTATE:
          serviceImpl.getFMUstate((no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetFMUstateResponse>) responseObserver);
          break;
        case METHODID_SET_FMUSTATE:
          serviceImpl.setFMUstate((no.ntnu.ihb.fmuproxy.grpc.Service.SetFMUstateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_FREE_FMUSTATE:
          serviceImpl.freeFMUstate((no.ntnu.ihb.fmuproxy.grpc.Service.FreeFMUstateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.StatusResponse>) responseObserver);
          break;
        case METHODID_SERIALIZE_FMUSTATE:
          serviceImpl.serializeFMUstate((no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.SerializeFMUstateResponse>) responseObserver);
          break;
        case METHODID_DE_SERIALIZE_FMUSTATE:
          serviceImpl.deSerializeFMUstate((no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.DeSerializeFMUstateResponse>) responseObserver);
          break;
        case METHODID_GET_DIRECTIONAL_DERIVATIVE:
          serviceImpl.getDirectionalDerivative((no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse>) responseObserver);
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
      return no.ntnu.ihb.fmuproxy.grpc.Service.getDescriptor();
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
              .addMethod(getGetModelDescriptionMethod())
              .addMethod(getGetCoSimulationAttributesMethod())
              .addMethod(getCanCreateInstanceFromCSMethod())
              .addMethod(getCanCreateInstanceFromMEMethod())
              .addMethod(getCreateInstanceFromCSMethod())
              .addMethod(getCreateInstanceFromMEMethod())
              .addMethod(getSetupExperimentMethod())
              .addMethod(getEnterInitializationModeMethod())
              .addMethod(getExitInitializationModeMethod())
              .addMethod(getStepMethod())
              .addMethod(getResetMethod())
              .addMethod(getTerminateMethod())
              .addMethod(getReadIntegerMethod())
              .addMethod(getReadRealMethod())
              .addMethod(getReadStringMethod())
              .addMethod(getReadBooleanMethod())
              .addMethod(getWriteIntegerMethod())
              .addMethod(getWriteRealMethod())
              .addMethod(getWriteStringMethod())
              .addMethod(getWriteBooleanMethod())
              .addMethod(getGetFMUstateMethod())
              .addMethod(getSetFMUstateMethod())
              .addMethod(getFreeFMUstateMethod())
              .addMethod(getSerializeFMUstateMethod())
              .addMethod(getDeSerializeFMUstateMethod())
              .addMethod(getGetDirectionalDerivativeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
