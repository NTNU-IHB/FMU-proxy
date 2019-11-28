package no.ntnu.ihb.fmuproxy.grpc;

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
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: service.proto")
public final class FmuServiceGrpc {

  private FmuServiceGrpc() {}

  public static final String SERVICE_NAME = "fmuproxy.grpc.FmuService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.Url,
      no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> getLoadFromUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoadFromUrl",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.Url.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.FmuId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.Url,
      no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> getLoadFromUrlMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.Url, no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> getLoadFromUrlMethod;
    if ((getLoadFromUrlMethod = FmuServiceGrpc.getLoadFromUrlMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getLoadFromUrlMethod = FmuServiceGrpc.getLoadFromUrlMethod) == null) {
          FmuServiceGrpc.getLoadFromUrlMethod = getLoadFromUrlMethod =
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.Url, no.ntnu.ihb.fmuproxy.grpc.Service.FmuId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoadFromUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.Url.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.FmuId.getDefaultInstance()))
              .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("LoadFromUrl"))
              .build();
        }
      }
    }
    return getLoadFromUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.File,
      no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> getLoadFromFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoadFromFile",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.File.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.FmuId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.File,
      no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> getLoadFromFileMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.File, no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> getLoadFromFileMethod;
    if ((getLoadFromFileMethod = FmuServiceGrpc.getLoadFromFileMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getLoadFromFileMethod = FmuServiceGrpc.getLoadFromFileMethod) == null) {
          FmuServiceGrpc.getLoadFromFileMethod = getLoadFromFileMethod =
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.File, no.ntnu.ihb.fmuproxy.grpc.Service.FmuId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoadFromFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.File.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.FmuId.getDefaultInstance()))
              .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("LoadFromFile"))
              .build();
        }
      }
    }
    return getLoadFromFileMethod;
  }

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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModelDescription"))
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

  private static volatile io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest.class,
      responseType = no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest,
      no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest, no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = FmuServiceGrpc.getCreateInstanceMethod) == null) {
      synchronized (FmuServiceGrpc.class) {
        if ((getCreateInstanceMethod = FmuServiceGrpc.getCreateInstanceMethod) == null) {
          FmuServiceGrpc.getCreateInstanceMethod = getCreateInstanceMethod =
              io.grpc.MethodDescriptor.<no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest, no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId.getDefaultInstance()))
              .setSchemaDescriptor(new FmuServiceMethodDescriptorSupplier("CreateInstance"))
              .build();
        }
      }
    }
    return getCreateInstanceMethod;
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetupExperiment"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnterInitializationMode"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExitInitializationMode"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Step"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Reset"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Terminate"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadInteger"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadReal"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadString"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadBoolean"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteInteger"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteReal"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteString"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteBoolean"))
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
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDirectionalDerivative"))
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
    public void loadFromUrl(no.ntnu.ihb.fmuproxy.grpc.Service.Url request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> responseObserver) {
      asyncUnimplementedUnaryCall(getLoadFromUrlMethod(), responseObserver);
    }

    /**
     */
    public void loadFromFile(no.ntnu.ihb.fmuproxy.grpc.Service.File request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> responseObserver) {
      asyncUnimplementedUnaryCall(getLoadFromFileMethod(), responseObserver);
    }

    /**
     */
    public void getModelDescription(no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetModelDescriptionMethod(), responseObserver);
    }

    /**
     */
    public void createInstance(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
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
    public void getDirectionalDerivative(no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDirectionalDerivativeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoadFromUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.Url,
                no.ntnu.ihb.fmuproxy.grpc.Service.FmuId>(
                  this, METHODID_LOAD_FROM_URL)))
          .addMethod(
            getLoadFromFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.File,
                no.ntnu.ihb.fmuproxy.grpc.Service.FmuId>(
                  this, METHODID_LOAD_FROM_FILE)))
          .addMethod(
            getGetModelDescriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription>(
                  this, METHODID_GET_MODEL_DESCRIPTION)))
          .addMethod(
            getCreateInstanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest,
                no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId>(
                  this, METHODID_CREATE_INSTANCE)))
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
    public void loadFromUrl(no.ntnu.ihb.fmuproxy.grpc.Service.Url request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoadFromUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loadFromFile(no.ntnu.ihb.fmuproxy.grpc.Service.File request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoadFromFileMethod(), getCallOptions()), request, responseObserver);
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
    public void createInstance(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request, responseObserver);
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
    public no.ntnu.ihb.fmuproxy.grpc.Service.FmuId loadFromUrl(no.ntnu.ihb.fmuproxy.grpc.Service.Url request) {
      return blockingUnaryCall(
          getChannel(), getLoadFromUrlMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.FmuId loadFromFile(no.ntnu.ihb.fmuproxy.grpc.Service.File request) {
      return blockingUnaryCall(
          getChannel(), getLoadFromFileMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription getModelDescription(no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetModelDescriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId createInstance(no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> loadFromUrl(
        no.ntnu.ihb.fmuproxy.grpc.Service.Url request) {
      return futureUnaryCall(
          getChannel().newCall(getLoadFromUrlMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId> loadFromFile(
        no.ntnu.ihb.fmuproxy.grpc.Service.File request) {
      return futureUnaryCall(
          getChannel().newCall(getLoadFromFileMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.InstanceId> createInstance(
        no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeResponse> getDirectionalDerivative(
        no.ntnu.ihb.fmuproxy.grpc.Service.GetDirectionalDerivativeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDirectionalDerivativeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOAD_FROM_URL = 0;
  private static final int METHODID_LOAD_FROM_FILE = 1;
  private static final int METHODID_GET_MODEL_DESCRIPTION = 2;
  private static final int METHODID_CREATE_INSTANCE = 3;
  private static final int METHODID_SETUP_EXPERIMENT = 4;
  private static final int METHODID_ENTER_INITIALIZATION_MODE = 5;
  private static final int METHODID_EXIT_INITIALIZATION_MODE = 6;
  private static final int METHODID_STEP = 7;
  private static final int METHODID_RESET = 8;
  private static final int METHODID_TERMINATE = 9;
  private static final int METHODID_READ_INTEGER = 10;
  private static final int METHODID_READ_REAL = 11;
  private static final int METHODID_READ_STRING = 12;
  private static final int METHODID_READ_BOOLEAN = 13;
  private static final int METHODID_WRITE_INTEGER = 14;
  private static final int METHODID_WRITE_REAL = 15;
  private static final int METHODID_WRITE_STRING = 16;
  private static final int METHODID_WRITE_BOOLEAN = 17;
  private static final int METHODID_GET_DIRECTIONAL_DERIVATIVE = 18;

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
        case METHODID_LOAD_FROM_URL:
          serviceImpl.loadFromUrl((no.ntnu.ihb.fmuproxy.grpc.Service.Url) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId>) responseObserver);
          break;
        case METHODID_LOAD_FROM_FILE:
          serviceImpl.loadFromFile((no.ntnu.ihb.fmuproxy.grpc.Service.File) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.FmuId>) responseObserver);
          break;
        case METHODID_GET_MODEL_DESCRIPTION:
          serviceImpl.getModelDescription((no.ntnu.ihb.fmuproxy.grpc.Service.GetModelDescriptionRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.ihb.fmuproxy.grpc.Service.ModelDescription>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((no.ntnu.ihb.fmuproxy.grpc.Service.CreateInstanceRequest) request,
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
              .addMethod(getLoadFromUrlMethod())
              .addMethod(getLoadFromFileMethod())
              .addMethod(getGetModelDescriptionMethod())
              .addMethod(getCreateInstanceMethod())
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
              .addMethod(getGetDirectionalDerivativeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
