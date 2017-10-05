package no.ntnu.mechlab.grpc_fmu;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.14.0)",
    comments = "Source: gen/PumpControlledWinch.proto")
public class PumpControlledWinchServiceGrpc {

  private PumpControlledWinchServiceGrpc() {}

  public static final String SERVICE_NAME = "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference> METHOD_CREATE_INSTANCE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "CreateInstance"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str> METHOD_GET_MODEL_NAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "GetModelName"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList> METHOD_GET_MODEL_VARIABLE_NAMES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "GetModelVariableNames"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables> METHOD_GET_MODEL_VARIABLES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "GetModelVariables"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_GET_CURRENT_TIME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "GetCurrentTime"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool> METHOD_IS_TERMINATED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "IsTerminated"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_INIT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Init"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_STEP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Step"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_TERMINATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Terminate"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var> METHOD_READ =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Read"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_SP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_SP"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_SP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_SP"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_MV =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_MV"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_MV =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_MV"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_OUTPUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_output"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_OUTPUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_output"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_K =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_K"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_K =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_K"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_TI =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_Ti"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_TI =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_Ti"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_B =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_b"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_B =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_b"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_TA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_Ta"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_TA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_Ta"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_MINIMUM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_minimum"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_MINIMUM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_minimum"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_MAXIMUM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_maximum"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_MAXIMUM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_maximum"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_OUTPUT_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_output_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_output_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_ERROR =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_error"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_ERROR =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_error"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_PB_LOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_PB_low"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_PB_LOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_PB_low"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_PB_HIGH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_PB_high"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_PB_HIGH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_PB_high"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_DRUM_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadDrum_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_DRUM_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Drum_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_DRUM_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadDrum_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_DRUM_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Drum_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_DRUM_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadDrum_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_DRUM_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Drum_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_DRUM_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadDrum_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_DRUM_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Drum_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_DRUM_DRUM_DIAMETER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadDrum_DrumDiameter"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_DRUM_DRUM_DIAMETER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Drum_DrumDiameter"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FLOW_SENSOR_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFlowSensor_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FLOW_SENSOR_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FLOW_SENSOR_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFlowSensor_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FLOW_SENSOR_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FLOW_SENSOR_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFlowSensor_p2_F"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FLOW_SENSOR_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p2_F"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FLOW_SENSOR_P2_V =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFlowSensor_p2_v"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FLOW_SENSOR_P2_V =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p2_v"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FLOW_SENSOR_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFlowSensor_flow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FLOW_SENSOR_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_flow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FRICTION_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFriction_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FRICTION_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Friction_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FRICTION_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFriction_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FRICTION_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Friction_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FRICTION_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFriction_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FRICTION_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Friction_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_FRICTION_LOAD_MASS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadFriction_LoadMass"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_FRICTION_LOAD_MASS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Friction_LoadMass"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_GEAR_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadGear_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_GEAR_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Gear_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_GEAR_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadGear_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_GEAR_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Gear_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_GEAR_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadGear_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_GEAR_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Gear_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_GEAR_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadGear_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_GEAR_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Gear_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_GEAR_GEAR_RATIO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadGear_GearRatio"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_GEAR_GEAR_RATIO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Gear_GearRatio"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_INERTIA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_Inertia"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_INERTIA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_Inertia"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_DRUM_SPEED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_DrumSpeed"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_DRUM_SPEED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumSpeed"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_DRUM_ANGLE_DEG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_DrumAngleDeg"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumAngleDeg"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_MOTOR_DISPLACEMENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_MotorDisplacement"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_MotorDisplacement"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_MOTOR_SPEED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_MotorSpeed"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_MOTOR_SPEED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_MotorSpeed"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_MOTOR_MOTOR_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadMotor_MotorFlow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_MOTOR_MOTOR_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Motor_MotorFlow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_flow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_flow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_P3_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_p3_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_P3_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p3_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION_P3_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction_p3_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION_P3_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p3_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_flow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_flow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P1_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p1_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P2_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p2_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P3_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p3_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P3_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p3_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P4_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p4_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P4_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p4_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P1_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p1_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P2_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p2_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P3_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p3_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P3_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p3_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_ONE_JUNCTION7_P4_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOneJunction7_p4_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_ONE_JUNCTION7_P4_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p4_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_OPEN_TANK_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOpenTank_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_OPEN_TANK_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_OPEN_TANK_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOpenTank_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_OPEN_TANK_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_OPEN_TANK_ATOM_PRESSURE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOpenTank_AtomPressure"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_AtomPressure"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_OPEN_TANK_FLOW2TANK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadOpenTank_Flow2Tank"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_OPEN_TANK_FLOW2TANK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_Flow2Tank"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_PUMP_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadPump_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_PUMP_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Pump_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_PUMP_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadPump_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_PUMP_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Pump_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_PUMP_GAIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadPump_gain"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_PUMP_GAIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Pump_gain"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_PUMP_PUMP_PRESSURE_MAX =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadPump_PumpPressureMax"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Pump_PumpPressureMax"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_PUMP_PUMP_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadPump_PumpFlow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_PUMP_PUMP_FLOW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Pump_PumpFlow"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_PUMP_PUMP_PRESSURE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadPump_PumpPressure"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_PUMP_PUMP_PRESSURE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Pump_PumpPressure"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_WIRE_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadWire_F"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_WIRE_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Wire_F"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_WIRE_V =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadWire_v"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_WIRE_V =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Wire_v"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_SET_POINT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadSetPoint"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_SET_POINT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_SetPoint"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_U_I_STATE_DOT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_uI_state_dot"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_U_I_STATE_DOT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_uI_state_dot"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_U_I_STATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_uI_state"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_U_I_STATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_uI_state"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_CONTROLLER_U_I_STATE_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadController_uI_state_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Controller_uI_state_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_P_E =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_p_e"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_MOMENTUM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_momentum"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_MOMENTUM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_momentum"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_MOMENTUM_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_momentum_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_MOMENTUM_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_momentum_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_P_F =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_p_f"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_DRUM_ANGLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_DrumAngle"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_DRUM_ANGLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumAngle"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "ReadInertia_DrumAngle_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "no.ntnu.mechlab.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumAngle_initial"),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PumpControlledWinchServiceStub newStub(io.grpc.Channel channel) {
    return new PumpControlledWinchServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PumpControlledWinchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PumpControlledWinchServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static PumpControlledWinchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PumpControlledWinchServiceFutureStub(channel);
  }

  /**
   */
  public static interface PumpControlledWinchService {

    /**
     */
    public void createInstance(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference> responseObserver);

    /**
     */
    public void getModelName(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str> responseObserver);

    /**
     */
    public void getModelVariableNames(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList> responseObserver);

    /**
     */
    public void getModelVariables(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables> responseObserver);

    /**
     * <pre>
     *instance specific
     * </pre>
     */
    public void getCurrentTime(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void isTerminated(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool> responseObserver);

    /**
     */
    public void init(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void step(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void terminate(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void read(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var> responseObserver);

    /**
     */
    public void write(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readPumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writePumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readPumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writePumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readPumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writePumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readPumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writePumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readPumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writePumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readPumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writePumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);

    /**
     */
    public void readInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver);

    /**
     */
    public void writeInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver);
  }

  @io.grpc.ExperimentalApi
  public static abstract class AbstractPumpControlledWinchService implements PumpControlledWinchService, io.grpc.BindableService {

    @java.lang.Override
    public void createInstance(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_INSTANCE, responseObserver);
    }

    @java.lang.Override
    public void getModelName(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_MODEL_NAME, responseObserver);
    }

    @java.lang.Override
    public void getModelVariableNames(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_MODEL_VARIABLE_NAMES, responseObserver);
    }

    @java.lang.Override
    public void getModelVariables(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_MODEL_VARIABLES, responseObserver);
    }

    @java.lang.Override
    public void getCurrentTime(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CURRENT_TIME, responseObserver);
    }

    @java.lang.Override
    public void isTerminated(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_IS_TERMINATED, responseObserver);
    }

    @java.lang.Override
    public void init(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INIT, responseObserver);
    }

    @java.lang.Override
    public void step(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STEP, responseObserver);
    }

    @java.lang.Override
    public void terminate(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_TERMINATE, responseObserver);
    }

    @java.lang.Override
    public void read(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ, responseObserver);
    }

    @java.lang.Override
    public void write(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE, responseObserver);
    }

    @java.lang.Override
    public void readControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_SP, responseObserver);
    }

    @java.lang.Override
    public void writeControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_SP, responseObserver);
    }

    @java.lang.Override
    public void readControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_MV, responseObserver);
    }

    @java.lang.Override
    public void writeControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_MV, responseObserver);
    }

    @java.lang.Override
    public void readControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_OUTPUT, responseObserver);
    }

    @java.lang.Override
    public void writeControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_OUTPUT, responseObserver);
    }

    @java.lang.Override
    public void readControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_K, responseObserver);
    }

    @java.lang.Override
    public void writeControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_K, responseObserver);
    }

    @java.lang.Override
    public void readControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_TI, responseObserver);
    }

    @java.lang.Override
    public void writeControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_TI, responseObserver);
    }

    @java.lang.Override
    public void readControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_B, responseObserver);
    }

    @java.lang.Override
    public void writeControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_B, responseObserver);
    }

    @java.lang.Override
    public void readControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_TA, responseObserver);
    }

    @java.lang.Override
    public void writeControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_TA, responseObserver);
    }

    @java.lang.Override
    public void readControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_MINIMUM, responseObserver);
    }

    @java.lang.Override
    public void writeControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_MINIMUM, responseObserver);
    }

    @java.lang.Override
    public void readControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_MAXIMUM, responseObserver);
    }

    @java.lang.Override
    public void writeControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_MAXIMUM, responseObserver);
    }

    @java.lang.Override
    public void readControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_OUTPUT_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void writeControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void readControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_ERROR, responseObserver);
    }

    @java.lang.Override
    public void writeControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_ERROR, responseObserver);
    }

    @java.lang.Override
    public void readControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_PB_LOW, responseObserver);
    }

    @java.lang.Override
    public void writeControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_PB_LOW, responseObserver);
    }

    @java.lang.Override
    public void readControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_PB_HIGH, responseObserver);
    }

    @java.lang.Override
    public void writeControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_PB_HIGH, responseObserver);
    }

    @java.lang.Override
    public void readDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_DRUM_P1_E, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_DRUM_P1_E, responseObserver);
    }

    @java.lang.Override
    public void readDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_DRUM_P1_F, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_DRUM_P1_F, responseObserver);
    }

    @java.lang.Override
    public void readDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_DRUM_P2_E, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_DRUM_P2_E, responseObserver);
    }

    @java.lang.Override
    public void readDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_DRUM_P2_F, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_DRUM_P2_F, responseObserver);
    }

    @java.lang.Override
    public void readDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_DRUM_DRUM_DIAMETER, responseObserver);
    }

    @java.lang.Override
    public void writeDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_DRUM_DRUM_DIAMETER, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FLOW_SENSOR_P1_E, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FLOW_SENSOR_P1_E, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FLOW_SENSOR_P1_F, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FLOW_SENSOR_P1_F, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FLOW_SENSOR_P2_F, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FLOW_SENSOR_P2_F, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FLOW_SENSOR_P2_V, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FLOW_SENSOR_P2_V, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FLOW_SENSOR_FLOW, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FLOW_SENSOR_FLOW, responseObserver);
    }

    @java.lang.Override
    public void readFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FRICTION_P_E, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FRICTION_P_E, responseObserver);
    }

    @java.lang.Override
    public void readFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FRICTION_P_F, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FRICTION_P_F, responseObserver);
    }

    @java.lang.Override
    public void readFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FRICTION_F, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FRICTION_F, responseObserver);
    }

    @java.lang.Override
    public void readFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_FRICTION_LOAD_MASS, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_FRICTION_LOAD_MASS, responseObserver);
    }

    @java.lang.Override
    public void readGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_GEAR_P1_E, responseObserver);
    }

    @java.lang.Override
    public void writeGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_GEAR_P1_E, responseObserver);
    }

    @java.lang.Override
    public void readGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_GEAR_P1_F, responseObserver);
    }

    @java.lang.Override
    public void writeGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_GEAR_P1_F, responseObserver);
    }

    @java.lang.Override
    public void readGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_GEAR_P2_E, responseObserver);
    }

    @java.lang.Override
    public void writeGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_GEAR_P2_E, responseObserver);
    }

    @java.lang.Override
    public void readGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_GEAR_P2_F, responseObserver);
    }

    @java.lang.Override
    public void writeGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_GEAR_P2_F, responseObserver);
    }

    @java.lang.Override
    public void readGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_GEAR_GEAR_RATIO, responseObserver);
    }

    @java.lang.Override
    public void writeGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_GEAR_GEAR_RATIO, responseObserver);
    }

    @java.lang.Override
    public void readInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_INERTIA, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_INERTIA, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_DRUM_SPEED, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_DRUM_SPEED, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_DRUM_ANGLE_DEG, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG, responseObserver);
    }

    @java.lang.Override
    public void readMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_P1_E, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_P1_E, responseObserver);
    }

    @java.lang.Override
    public void readMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_P1_F, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_P1_F, responseObserver);
    }

    @java.lang.Override
    public void readMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_P2_E, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_P2_E, responseObserver);
    }

    @java.lang.Override
    public void readMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_P2_F, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_P2_F, responseObserver);
    }

    @java.lang.Override
    public void readMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_MOTOR_DISPLACEMENT, responseObserver);
    }

    @java.lang.Override
    public void writeMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT, responseObserver);
    }

    @java.lang.Override
    public void readMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_MOTOR_SPEED, responseObserver);
    }

    @java.lang.Override
    public void writeMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_MOTOR_SPEED, responseObserver);
    }

    @java.lang.Override
    public void readMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_MOTOR_MOTOR_FLOW, responseObserver);
    }

    @java.lang.Override
    public void writeMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_MOTOR_MOTOR_FLOW, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_FLOW, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_FLOW, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_P1_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_P1_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_P2_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_P2_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_P3_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_P3_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_P1_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_P1_F, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_P2_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_P2_F, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION_P3_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION_P3_F, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_FLOW, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_FLOW, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P1_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P1_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P2_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P2_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P3_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P3_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P4_E, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P4_E, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P1_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P1_F, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P2_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P2_F, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P3_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P3_F, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ONE_JUNCTION7_P4_F, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_ONE_JUNCTION7_P4_F, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_OPEN_TANK_P_E, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_OPEN_TANK_P_E, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_OPEN_TANK_P_F, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_OPEN_TANK_P_F, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_OPEN_TANK_ATOM_PRESSURE, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_OPEN_TANK_FLOW2TANK, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_OPEN_TANK_FLOW2TANK, responseObserver);
    }

    @java.lang.Override
    public void readPumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_PUMP_P_E, responseObserver);
    }

    @java.lang.Override
    public void writePumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_PUMP_P_E, responseObserver);
    }

    @java.lang.Override
    public void readPumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_PUMP_P_F, responseObserver);
    }

    @java.lang.Override
    public void writePumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_PUMP_P_F, responseObserver);
    }

    @java.lang.Override
    public void readPumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_PUMP_GAIN, responseObserver);
    }

    @java.lang.Override
    public void writePumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_PUMP_GAIN, responseObserver);
    }

    @java.lang.Override
    public void readPumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_PUMP_PUMP_PRESSURE_MAX, responseObserver);
    }

    @java.lang.Override
    public void writePumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX, responseObserver);
    }

    @java.lang.Override
    public void readPumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_PUMP_PUMP_FLOW, responseObserver);
    }

    @java.lang.Override
    public void writePumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_PUMP_PUMP_FLOW, responseObserver);
    }

    @java.lang.Override
    public void readPumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_PUMP_PUMP_PRESSURE, responseObserver);
    }

    @java.lang.Override
    public void writePumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_PUMP_PUMP_PRESSURE, responseObserver);
    }

    @java.lang.Override
    public void readWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_WIRE_F, responseObserver);
    }

    @java.lang.Override
    public void writeWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_WIRE_F, responseObserver);
    }

    @java.lang.Override
    public void readWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_WIRE_V, responseObserver);
    }

    @java.lang.Override
    public void writeWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_WIRE_V, responseObserver);
    }

    @java.lang.Override
    public void readSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_SET_POINT, responseObserver);
    }

    @java.lang.Override
    public void writeSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_SET_POINT, responseObserver);
    }

    @java.lang.Override
    public void readControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_U_I_STATE_DOT, responseObserver);
    }

    @java.lang.Override
    public void writeControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_U_I_STATE_DOT, responseObserver);
    }

    @java.lang.Override
    public void readControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_U_I_STATE, responseObserver);
    }

    @java.lang.Override
    public void writeControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_U_I_STATE, responseObserver);
    }

    @java.lang.Override
    public void readControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_CONTROLLER_U_I_STATE_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void writeControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void readInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_P_E, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_P_E, responseObserver);
    }

    @java.lang.Override
    public void readInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_MOMENTUM, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_MOMENTUM, responseObserver);
    }

    @java.lang.Override
    public void readInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_MOMENTUM_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_MOMENTUM_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void readInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_P_F, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_P_F, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_DRUM_ANGLE, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_DRUM_ANGLE, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return PumpControlledWinchServiceGrpc.bindService(this);
    }
  }

  /**
   */
  public static interface PumpControlledWinchServiceBlockingClient {

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference createInstance(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str getModelName(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList getModelVariableNames(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables getModelVariables(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     * <pre>
     *instance specific
     * </pre>
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real getCurrentTime(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool isTerminated(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status init(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status step(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status terminate(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var read(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status write(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);
  }

  /**
   */
  public static interface PumpControlledWinchServiceFutureClient {

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference> createInstance(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str> getModelName(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList> getModelVariableNames(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables> getModelVariables(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request);

    /**
     * <pre>
     *instance specific
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> getCurrentTime(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool> isTerminated(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> init(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> step(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> terminate(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var> read(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> write(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerSP(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerSP(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerMV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerMV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerOutput(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerOutput(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerK(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerK(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerTi(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerTi(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerB(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerB(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerTa(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerTa(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerMinimum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerMinimum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerMaximum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerMaximum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerOutputInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerOutputInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerError(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerError(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerPBLow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerPBLow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerPBHigh(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerPBHigh(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumDrumDiameter(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumDrumDiameter(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP2V(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP2V(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionLoadMass(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionLoadMass(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearGearRatio(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearGearRatio(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaInertia(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaInertia(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumAngleDeg(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumAngleDeg(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorMotorDisplacement(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorMotorDisplacement(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorMotorSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorMotorSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorMotorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorMotorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7Flow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7Flow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P4E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P4E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P4F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P4F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankAtomPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankAtomPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankFlow2Tank(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankFlow2Tank(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpGain(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpGain(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPumpPressureMax(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPumpPressureMax(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPumpFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPumpFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPumpPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPumpPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readWireF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeWireF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readWireV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeWireV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readSetPoint(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeSetPoint(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerUIStateDot(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerUIStateDot(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerUIState(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerUIState(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerUIStateInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerUIStateInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaMomentum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaMomentum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaMomentumInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaMomentumInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumAngle(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumAngle(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumAngleInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumAngleInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request);
  }

  public static class PumpControlledWinchServiceStub extends io.grpc.stub.AbstractStub<PumpControlledWinchServiceStub>
      implements PumpControlledWinchService {
    private PumpControlledWinchServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PumpControlledWinchServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PumpControlledWinchServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PumpControlledWinchServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void createInstance(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_INSTANCE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getModelName(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MODEL_NAME, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getModelVariableNames(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MODEL_VARIABLE_NAMES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getModelVariables(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MODEL_VARIABLES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getCurrentTime(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CURRENT_TIME, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void isTerminated(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_IS_TERMINATED, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void init(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INIT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void step(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STEP, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void terminate(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_TERMINATE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void read(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void write(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_SP, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_SP, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_MV, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_MV, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_OUTPUT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_OUTPUT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_K, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_K, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_TI, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_TI, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_B, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_B, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_TA, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_TA, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_MINIMUM, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_MINIMUM, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_MAXIMUM, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_MAXIMUM, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_OUTPUT_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_ERROR, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_ERROR, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_PB_LOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_PB_LOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_PB_HIGH, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_PB_HIGH, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_DRUM_DIAMETER, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_DRUM_DIAMETER, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P2_V, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P2_V, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_LOAD_MASS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_LOAD_MASS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_GEAR_RATIO, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_GEAR_RATIO, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_INERTIA, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_INERTIA, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_SPEED, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_SPEED, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_ANGLE_DEG, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_MOTOR_DISPLACEMENT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_MOTOR_SPEED, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_MOTOR_SPEED, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_MOTOR_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_MOTOR_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P3_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P3_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P3_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P3_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P1_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P2_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P3_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P3_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P4_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P4_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P1_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P2_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P3_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P3_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P4_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P4_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_ATOM_PRESSURE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_FLOW2TANK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_FLOW2TANK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readPumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writePumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readPumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writePumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readPumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_GAIN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writePumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_GAIN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readPumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_PUMP_PRESSURE_MAX, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writePumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readPumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_PUMP_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writePumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_PUMP_FLOW, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readPumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_PUMP_PRESSURE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writePumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_PUMP_PRESSURE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_WIRE_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_WIRE_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_WIRE_V, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_WIRE_V, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_SET_POINT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_SET_POINT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_U_I_STATE_DOT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_U_I_STATE_DOT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_U_I_STATE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_U_I_STATE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_U_I_STATE_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_P_E, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_MOMENTUM, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_MOMENTUM, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_MOMENTUM_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_MOMENTUM_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_P_F, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_ANGLE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_ANGLE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL, getCallOptions()), request, responseObserver);
    }
  }

  public static class PumpControlledWinchServiceBlockingStub extends io.grpc.stub.AbstractStub<PumpControlledWinchServiceBlockingStub>
      implements PumpControlledWinchServiceBlockingClient {
    private PumpControlledWinchServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PumpControlledWinchServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PumpControlledWinchServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PumpControlledWinchServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference createInstance(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_INSTANCE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str getModelName(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_MODEL_NAME, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList getModelVariableNames(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_MODEL_VARIABLE_NAMES, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables getModelVariables(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_MODEL_VARIABLES, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real getCurrentTime(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CURRENT_TIME, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool isTerminated(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_IS_TERMINATED, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status init(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INIT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status step(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STEP, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status terminate(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_TERMINATE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var read(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status write(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_SP, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerSP(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_SP, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_MV, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerMV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_MV, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_OUTPUT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerOutput(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_OUTPUT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_K, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerK(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_K, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_TI, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerTi(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_TI, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_B, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerB(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_B, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_TA, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerTa(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_TA, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_MINIMUM, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerMinimum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_MINIMUM, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_MAXIMUM, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerMaximum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_MAXIMUM, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_OUTPUT_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerOutputInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_ERROR, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerError(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_ERROR, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_PB_LOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerPBLow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_PB_LOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_PB_HIGH, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerPBHigh(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_PB_HIGH, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_DRUM_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_DRUM_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_DRUM_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_DRUM_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_DRUM_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_DRUM_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_DRUM_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_DRUM_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_DRUM_DRUM_DIAMETER, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeDrumDrumDiameter(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_DRUM_DRUM_DIAMETER, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FLOW_SENSOR_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FLOW_SENSOR_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FLOW_SENSOR_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FLOW_SENSOR_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FLOW_SENSOR_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FLOW_SENSOR_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FLOW_SENSOR_P2_V, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorP2V(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FLOW_SENSOR_P2_V, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FLOW_SENSOR_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFlowSensorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FLOW_SENSOR_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FRICTION_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FRICTION_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FRICTION_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FRICTION_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FRICTION_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FRICTION_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_FRICTION_LOAD_MASS, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeFrictionLoadMass(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_FRICTION_LOAD_MASS, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_GEAR_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_GEAR_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_GEAR_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_GEAR_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_GEAR_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_GEAR_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_GEAR_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_GEAR_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_GEAR_GEAR_RATIO, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeGearGearRatio(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_GEAR_GEAR_RATIO, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_INERTIA, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaInertia(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_INERTIA, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_DRUM_SPEED, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_DRUM_SPEED, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_DRUM_ANGLE_DEG, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumAngleDeg(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_MOTOR_DISPLACEMENT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorMotorDisplacement(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_MOTOR_SPEED, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorMotorSpeed(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_MOTOR_SPEED, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_MOTOR_MOTOR_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeMotorMotorFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_MOTOR_MOTOR_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_P3_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_P3_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION_P3_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunctionP3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION_P3_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7Flow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P1E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P1_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P2E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P2_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P3_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P3E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P3_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P4_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P4E(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P4_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P1F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P1_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P2F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P2_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P3_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P3F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P3_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ONE_JUNCTION7_P4_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOneJunction7P4F(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_ONE_JUNCTION7_P4_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_OPEN_TANK_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_OPEN_TANK_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_OPEN_TANK_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_OPEN_TANK_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_OPEN_TANK_ATOM_PRESSURE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankAtomPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_OPEN_TANK_FLOW2TANK, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeOpenTankFlow2Tank(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_OPEN_TANK_FLOW2TANK, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_PUMP_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_PUMP_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_PUMP_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_PUMP_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_PUMP_GAIN, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpGain(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_PUMP_GAIN, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_PUMP_PUMP_PRESSURE_MAX, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPumpPressureMax(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_PUMP_PUMP_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPumpFlow(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_PUMP_PUMP_FLOW, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readPumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_PUMP_PUMP_PRESSURE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writePumpPumpPressure(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_PUMP_PUMP_PRESSURE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_WIRE_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeWireF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_WIRE_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_WIRE_V, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeWireV(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_WIRE_V, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_SET_POINT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeSetPoint(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_SET_POINT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_U_I_STATE_DOT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerUIStateDot(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_U_I_STATE_DOT, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_U_I_STATE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerUIState(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_U_I_STATE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_CONTROLLER_U_I_STATE_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeControllerUIStateInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaPE(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_P_E, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_MOMENTUM, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaMomentum(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_MOMENTUM, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_MOMENTUM_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaMomentumInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_MOMENTUM_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaPF(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_P_F, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_DRUM_ANGLE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumAngle(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_DRUM_ANGLE, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real readInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL, getCallOptions(), request);
    }

    @java.lang.Override
    public no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status writeInertiaDrumAngleInitial(no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL, getCallOptions(), request);
    }
  }

  public static class PumpControlledWinchServiceFutureStub extends io.grpc.stub.AbstractStub<PumpControlledWinchServiceFutureStub>
      implements PumpControlledWinchServiceFutureClient {
    private PumpControlledWinchServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PumpControlledWinchServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PumpControlledWinchServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PumpControlledWinchServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference> createInstance(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_INSTANCE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str> getModelName(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MODEL_NAME, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList> getModelVariableNames(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MODEL_VARIABLE_NAMES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables> getModelVariables(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MODEL_VARIABLES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> getCurrentTime(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CURRENT_TIME, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool> isTerminated(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_IS_TERMINATED, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> init(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INIT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> step(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STEP, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> terminate(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_TERMINATE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var> read(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> write(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerSP(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_SP, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerSP(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_SP, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerMV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_MV, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerMV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_MV, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerOutput(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_OUTPUT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerOutput(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_OUTPUT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerK(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_K, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerK(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_K, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerTi(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_TI, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerTi(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_TI, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerB(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_B, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerB(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_B, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerTa(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_TA, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerTa(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_TA, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerMinimum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_MINIMUM, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerMinimum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_MINIMUM, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerMaximum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_MAXIMUM, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerMaximum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_MAXIMUM, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerOutputInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_OUTPUT_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerOutputInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerError(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_ERROR, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerError(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_ERROR, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerPBLow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_PB_LOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerPBLow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_PB_LOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerPBHigh(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_PB_HIGH, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerPBHigh(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_PB_HIGH, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readDrumDrumDiameter(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_DRUM_DRUM_DIAMETER, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeDrumDrumDiameter(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_DRUM_DRUM_DIAMETER, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorP2V(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_P2_V, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorP2V(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_P2_V, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFlowSensorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FLOW_SENSOR_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFlowSensorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FLOW_SENSOR_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readFrictionLoadMass(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_FRICTION_LOAD_MASS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeFrictionLoadMass(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_FRICTION_LOAD_MASS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readGearGearRatio(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_GEAR_GEAR_RATIO, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeGearGearRatio(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_GEAR_GEAR_RATIO, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaInertia(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_INERTIA, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaInertia(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_INERTIA, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_SPEED, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_SPEED, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumAngleDeg(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_ANGLE_DEG, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumAngleDeg(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorMotorDisplacement(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_MOTOR_DISPLACEMENT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorMotorDisplacement(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorMotorSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_MOTOR_SPEED, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorMotorSpeed(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_MOTOR_SPEED, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readMotorMotorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_MOTOR_MOTOR_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeMotorMotorFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_MOTOR_MOTOR_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P3_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P3_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunctionP3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION_P3_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunctionP3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION_P3_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7Flow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7Flow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P1E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P1_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P2E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P2_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P3_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P3E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P3_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P4E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P4_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P4E(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P4_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P1F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P1_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P2F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P2_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P3_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P3F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P3_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOneJunction7P4F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ONE_JUNCTION7_P4_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOneJunction7P4F(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_ONE_JUNCTION7_P4_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankAtomPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_ATOM_PRESSURE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankAtomPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readOpenTankFlow2Tank(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_OPEN_TANK_FLOW2TANK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeOpenTankFlow2Tank(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_OPEN_TANK_FLOW2TANK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpGain(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_GAIN, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpGain(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_GAIN, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPumpPressureMax(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_PUMP_PRESSURE_MAX, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPumpPressureMax(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPumpFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_PUMP_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPumpFlow(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_PUMP_FLOW, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readPumpPumpPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_PUMP_PUMP_PRESSURE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writePumpPumpPressure(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_PUMP_PUMP_PRESSURE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readWireF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_WIRE_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeWireF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_WIRE_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readWireV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_WIRE_V, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeWireV(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_WIRE_V, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readSetPoint(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_SET_POINT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeSetPoint(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_SET_POINT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerUIStateDot(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_U_I_STATE_DOT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerUIStateDot(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_U_I_STATE_DOT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerUIState(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_U_I_STATE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerUIState(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_U_I_STATE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readControllerUIStateInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_CONTROLLER_U_I_STATE_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeControllerUIStateInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaPE(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_P_E, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaMomentum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_MOMENTUM, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaMomentum(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_MOMENTUM, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaMomentumInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_MOMENTUM_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaMomentumInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_MOMENTUM_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaPF(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_P_F, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumAngle(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_ANGLE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumAngle(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_ANGLE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real> readInertiaDrumAngleInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status> writeInertiaDrumAngleInitial(
        no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL, getCallOptions()), request);
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
  private static final int METHODID_READ_CONTROLLER_SP = 11;
  private static final int METHODID_WRITE_CONTROLLER_SP = 12;
  private static final int METHODID_READ_CONTROLLER_MV = 13;
  private static final int METHODID_WRITE_CONTROLLER_MV = 14;
  private static final int METHODID_READ_CONTROLLER_OUTPUT = 15;
  private static final int METHODID_WRITE_CONTROLLER_OUTPUT = 16;
  private static final int METHODID_READ_CONTROLLER_K = 17;
  private static final int METHODID_WRITE_CONTROLLER_K = 18;
  private static final int METHODID_READ_CONTROLLER_TI = 19;
  private static final int METHODID_WRITE_CONTROLLER_TI = 20;
  private static final int METHODID_READ_CONTROLLER_B = 21;
  private static final int METHODID_WRITE_CONTROLLER_B = 22;
  private static final int METHODID_READ_CONTROLLER_TA = 23;
  private static final int METHODID_WRITE_CONTROLLER_TA = 24;
  private static final int METHODID_READ_CONTROLLER_MINIMUM = 25;
  private static final int METHODID_WRITE_CONTROLLER_MINIMUM = 26;
  private static final int METHODID_READ_CONTROLLER_MAXIMUM = 27;
  private static final int METHODID_WRITE_CONTROLLER_MAXIMUM = 28;
  private static final int METHODID_READ_CONTROLLER_OUTPUT_INITIAL = 29;
  private static final int METHODID_WRITE_CONTROLLER_OUTPUT_INITIAL = 30;
  private static final int METHODID_READ_CONTROLLER_ERROR = 31;
  private static final int METHODID_WRITE_CONTROLLER_ERROR = 32;
  private static final int METHODID_READ_CONTROLLER_PB_LOW = 33;
  private static final int METHODID_WRITE_CONTROLLER_PB_LOW = 34;
  private static final int METHODID_READ_CONTROLLER_PB_HIGH = 35;
  private static final int METHODID_WRITE_CONTROLLER_PB_HIGH = 36;
  private static final int METHODID_READ_DRUM_P1_E = 37;
  private static final int METHODID_WRITE_DRUM_P1_E = 38;
  private static final int METHODID_READ_DRUM_P1_F = 39;
  private static final int METHODID_WRITE_DRUM_P1_F = 40;
  private static final int METHODID_READ_DRUM_P2_E = 41;
  private static final int METHODID_WRITE_DRUM_P2_E = 42;
  private static final int METHODID_READ_DRUM_P2_F = 43;
  private static final int METHODID_WRITE_DRUM_P2_F = 44;
  private static final int METHODID_READ_DRUM_DRUM_DIAMETER = 45;
  private static final int METHODID_WRITE_DRUM_DRUM_DIAMETER = 46;
  private static final int METHODID_READ_FLOW_SENSOR_P1_E = 47;
  private static final int METHODID_WRITE_FLOW_SENSOR_P1_E = 48;
  private static final int METHODID_READ_FLOW_SENSOR_P1_F = 49;
  private static final int METHODID_WRITE_FLOW_SENSOR_P1_F = 50;
  private static final int METHODID_READ_FLOW_SENSOR_P2_F = 51;
  private static final int METHODID_WRITE_FLOW_SENSOR_P2_F = 52;
  private static final int METHODID_READ_FLOW_SENSOR_P2_V = 53;
  private static final int METHODID_WRITE_FLOW_SENSOR_P2_V = 54;
  private static final int METHODID_READ_FLOW_SENSOR_FLOW = 55;
  private static final int METHODID_WRITE_FLOW_SENSOR_FLOW = 56;
  private static final int METHODID_READ_FRICTION_P_E = 57;
  private static final int METHODID_WRITE_FRICTION_P_E = 58;
  private static final int METHODID_READ_FRICTION_P_F = 59;
  private static final int METHODID_WRITE_FRICTION_P_F = 60;
  private static final int METHODID_READ_FRICTION_F = 61;
  private static final int METHODID_WRITE_FRICTION_F = 62;
  private static final int METHODID_READ_FRICTION_LOAD_MASS = 63;
  private static final int METHODID_WRITE_FRICTION_LOAD_MASS = 64;
  private static final int METHODID_READ_GEAR_P1_E = 65;
  private static final int METHODID_WRITE_GEAR_P1_E = 66;
  private static final int METHODID_READ_GEAR_P1_F = 67;
  private static final int METHODID_WRITE_GEAR_P1_F = 68;
  private static final int METHODID_READ_GEAR_P2_E = 69;
  private static final int METHODID_WRITE_GEAR_P2_E = 70;
  private static final int METHODID_READ_GEAR_P2_F = 71;
  private static final int METHODID_WRITE_GEAR_P2_F = 72;
  private static final int METHODID_READ_GEAR_GEAR_RATIO = 73;
  private static final int METHODID_WRITE_GEAR_GEAR_RATIO = 74;
  private static final int METHODID_READ_INERTIA_INERTIA = 75;
  private static final int METHODID_WRITE_INERTIA_INERTIA = 76;
  private static final int METHODID_READ_INERTIA_DRUM_SPEED = 77;
  private static final int METHODID_WRITE_INERTIA_DRUM_SPEED = 78;
  private static final int METHODID_READ_INERTIA_DRUM_ANGLE_DEG = 79;
  private static final int METHODID_WRITE_INERTIA_DRUM_ANGLE_DEG = 80;
  private static final int METHODID_READ_MOTOR_P1_E = 81;
  private static final int METHODID_WRITE_MOTOR_P1_E = 82;
  private static final int METHODID_READ_MOTOR_P1_F = 83;
  private static final int METHODID_WRITE_MOTOR_P1_F = 84;
  private static final int METHODID_READ_MOTOR_P2_E = 85;
  private static final int METHODID_WRITE_MOTOR_P2_E = 86;
  private static final int METHODID_READ_MOTOR_P2_F = 87;
  private static final int METHODID_WRITE_MOTOR_P2_F = 88;
  private static final int METHODID_READ_MOTOR_MOTOR_DISPLACEMENT = 89;
  private static final int METHODID_WRITE_MOTOR_MOTOR_DISPLACEMENT = 90;
  private static final int METHODID_READ_MOTOR_MOTOR_SPEED = 91;
  private static final int METHODID_WRITE_MOTOR_MOTOR_SPEED = 92;
  private static final int METHODID_READ_MOTOR_MOTOR_FLOW = 93;
  private static final int METHODID_WRITE_MOTOR_MOTOR_FLOW = 94;
  private static final int METHODID_READ_ONE_JUNCTION_FLOW = 95;
  private static final int METHODID_WRITE_ONE_JUNCTION_FLOW = 96;
  private static final int METHODID_READ_ONE_JUNCTION_P1_E = 97;
  private static final int METHODID_WRITE_ONE_JUNCTION_P1_E = 98;
  private static final int METHODID_READ_ONE_JUNCTION_P2_E = 99;
  private static final int METHODID_WRITE_ONE_JUNCTION_P2_E = 100;
  private static final int METHODID_READ_ONE_JUNCTION_P3_E = 101;
  private static final int METHODID_WRITE_ONE_JUNCTION_P3_E = 102;
  private static final int METHODID_READ_ONE_JUNCTION_P1_F = 103;
  private static final int METHODID_WRITE_ONE_JUNCTION_P1_F = 104;
  private static final int METHODID_READ_ONE_JUNCTION_P2_F = 105;
  private static final int METHODID_WRITE_ONE_JUNCTION_P2_F = 106;
  private static final int METHODID_READ_ONE_JUNCTION_P3_F = 107;
  private static final int METHODID_WRITE_ONE_JUNCTION_P3_F = 108;
  private static final int METHODID_READ_ONE_JUNCTION7_FLOW = 109;
  private static final int METHODID_WRITE_ONE_JUNCTION7_FLOW = 110;
  private static final int METHODID_READ_ONE_JUNCTION7_P1_E = 111;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P1_E = 112;
  private static final int METHODID_READ_ONE_JUNCTION7_P2_E = 113;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P2_E = 114;
  private static final int METHODID_READ_ONE_JUNCTION7_P3_E = 115;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P3_E = 116;
  private static final int METHODID_READ_ONE_JUNCTION7_P4_E = 117;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P4_E = 118;
  private static final int METHODID_READ_ONE_JUNCTION7_P1_F = 119;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P1_F = 120;
  private static final int METHODID_READ_ONE_JUNCTION7_P2_F = 121;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P2_F = 122;
  private static final int METHODID_READ_ONE_JUNCTION7_P3_F = 123;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P3_F = 124;
  private static final int METHODID_READ_ONE_JUNCTION7_P4_F = 125;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P4_F = 126;
  private static final int METHODID_READ_OPEN_TANK_P_E = 127;
  private static final int METHODID_WRITE_OPEN_TANK_P_E = 128;
  private static final int METHODID_READ_OPEN_TANK_P_F = 129;
  private static final int METHODID_WRITE_OPEN_TANK_P_F = 130;
  private static final int METHODID_READ_OPEN_TANK_ATOM_PRESSURE = 131;
  private static final int METHODID_WRITE_OPEN_TANK_ATOM_PRESSURE = 132;
  private static final int METHODID_READ_OPEN_TANK_FLOW2TANK = 133;
  private static final int METHODID_WRITE_OPEN_TANK_FLOW2TANK = 134;
  private static final int METHODID_READ_PUMP_P_E = 135;
  private static final int METHODID_WRITE_PUMP_P_E = 136;
  private static final int METHODID_READ_PUMP_P_F = 137;
  private static final int METHODID_WRITE_PUMP_P_F = 138;
  private static final int METHODID_READ_PUMP_GAIN = 139;
  private static final int METHODID_WRITE_PUMP_GAIN = 140;
  private static final int METHODID_READ_PUMP_PUMP_PRESSURE_MAX = 141;
  private static final int METHODID_WRITE_PUMP_PUMP_PRESSURE_MAX = 142;
  private static final int METHODID_READ_PUMP_PUMP_FLOW = 143;
  private static final int METHODID_WRITE_PUMP_PUMP_FLOW = 144;
  private static final int METHODID_READ_PUMP_PUMP_PRESSURE = 145;
  private static final int METHODID_WRITE_PUMP_PUMP_PRESSURE = 146;
  private static final int METHODID_READ_WIRE_F = 147;
  private static final int METHODID_WRITE_WIRE_F = 148;
  private static final int METHODID_READ_WIRE_V = 149;
  private static final int METHODID_WRITE_WIRE_V = 150;
  private static final int METHODID_READ_SET_POINT = 151;
  private static final int METHODID_WRITE_SET_POINT = 152;
  private static final int METHODID_READ_CONTROLLER_U_I_STATE_DOT = 153;
  private static final int METHODID_WRITE_CONTROLLER_U_I_STATE_DOT = 154;
  private static final int METHODID_READ_CONTROLLER_U_I_STATE = 155;
  private static final int METHODID_WRITE_CONTROLLER_U_I_STATE = 156;
  private static final int METHODID_READ_CONTROLLER_U_I_STATE_INITIAL = 157;
  private static final int METHODID_WRITE_CONTROLLER_U_I_STATE_INITIAL = 158;
  private static final int METHODID_READ_INERTIA_P_E = 159;
  private static final int METHODID_WRITE_INERTIA_P_E = 160;
  private static final int METHODID_READ_INERTIA_MOMENTUM = 161;
  private static final int METHODID_WRITE_INERTIA_MOMENTUM = 162;
  private static final int METHODID_READ_INERTIA_MOMENTUM_INITIAL = 163;
  private static final int METHODID_WRITE_INERTIA_MOMENTUM_INITIAL = 164;
  private static final int METHODID_READ_INERTIA_P_F = 165;
  private static final int METHODID_WRITE_INERTIA_P_F = 166;
  private static final int METHODID_READ_INERTIA_DRUM_ANGLE = 167;
  private static final int METHODID_WRITE_INERTIA_DRUM_ANGLE = 168;
  private static final int METHODID_READ_INERTIA_DRUM_ANGLE_INITIAL = 169;
  private static final int METHODID_WRITE_INERTIA_DRUM_ANGLE_INITIAL = 170;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PumpControlledWinchService serviceImpl;
    private final int methodId;

    public MethodHandlers(PumpControlledWinchService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference>) responseObserver);
          break;
        case METHODID_GET_MODEL_NAME:
          serviceImpl.getModelName((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLE_NAMES:
          serviceImpl.getModelVariableNames((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList>) responseObserver);
          break;
        case METHODID_GET_MODEL_VARIABLES:
          serviceImpl.getModelVariables((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_IS_TERMINATED:
          serviceImpl.isTerminated((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_STEP:
          serviceImpl.step((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_TERMINATE:
          serviceImpl.terminate((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var>) responseObserver);
          break;
        case METHODID_WRITE:
          serviceImpl.write((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_SP:
          serviceImpl.readControllerSP((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_SP:
          serviceImpl.writeControllerSP((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_MV:
          serviceImpl.readControllerMV((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_MV:
          serviceImpl.writeControllerMV((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_OUTPUT:
          serviceImpl.readControllerOutput((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_OUTPUT:
          serviceImpl.writeControllerOutput((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_K:
          serviceImpl.readControllerK((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_K:
          serviceImpl.writeControllerK((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_TI:
          serviceImpl.readControllerTi((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_TI:
          serviceImpl.writeControllerTi((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_B:
          serviceImpl.readControllerB((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_B:
          serviceImpl.writeControllerB((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_TA:
          serviceImpl.readControllerTa((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_TA:
          serviceImpl.writeControllerTa((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_MINIMUM:
          serviceImpl.readControllerMinimum((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_MINIMUM:
          serviceImpl.writeControllerMinimum((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_MAXIMUM:
          serviceImpl.readControllerMaximum((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_MAXIMUM:
          serviceImpl.writeControllerMaximum((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_OUTPUT_INITIAL:
          serviceImpl.readControllerOutputInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_OUTPUT_INITIAL:
          serviceImpl.writeControllerOutputInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_ERROR:
          serviceImpl.readControllerError((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_ERROR:
          serviceImpl.writeControllerError((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_PB_LOW:
          serviceImpl.readControllerPBLow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_PB_LOW:
          serviceImpl.writeControllerPBLow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_PB_HIGH:
          serviceImpl.readControllerPBHigh((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_PB_HIGH:
          serviceImpl.writeControllerPBHigh((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P1_E:
          serviceImpl.readDrumP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P1_E:
          serviceImpl.writeDrumP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P1_F:
          serviceImpl.readDrumP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P1_F:
          serviceImpl.writeDrumP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P2_E:
          serviceImpl.readDrumP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P2_E:
          serviceImpl.writeDrumP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P2_F:
          serviceImpl.readDrumP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P2_F:
          serviceImpl.writeDrumP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_DRUM_DIAMETER:
          serviceImpl.readDrumDrumDiameter((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_DRUM_DIAMETER:
          serviceImpl.writeDrumDrumDiameter((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P1_E:
          serviceImpl.readFlowSensorP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P1_E:
          serviceImpl.writeFlowSensorP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P1_F:
          serviceImpl.readFlowSensorP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P1_F:
          serviceImpl.writeFlowSensorP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P2_F:
          serviceImpl.readFlowSensorP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P2_F:
          serviceImpl.writeFlowSensorP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P2_V:
          serviceImpl.readFlowSensorP2V((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P2_V:
          serviceImpl.writeFlowSensorP2V((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_FLOW:
          serviceImpl.readFlowSensorFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_FLOW:
          serviceImpl.writeFlowSensorFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_P_E:
          serviceImpl.readFrictionPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_P_E:
          serviceImpl.writeFrictionPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_P_F:
          serviceImpl.readFrictionPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_P_F:
          serviceImpl.writeFrictionPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_F:
          serviceImpl.readFrictionF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_F:
          serviceImpl.writeFrictionF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_LOAD_MASS:
          serviceImpl.readFrictionLoadMass((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_LOAD_MASS:
          serviceImpl.writeFrictionLoadMass((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P1_E:
          serviceImpl.readGearP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P1_E:
          serviceImpl.writeGearP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P1_F:
          serviceImpl.readGearP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P1_F:
          serviceImpl.writeGearP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P2_E:
          serviceImpl.readGearP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P2_E:
          serviceImpl.writeGearP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P2_F:
          serviceImpl.readGearP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P2_F:
          serviceImpl.writeGearP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_GEAR_RATIO:
          serviceImpl.readGearGearRatio((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_GEAR_RATIO:
          serviceImpl.writeGearGearRatio((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_INERTIA:
          serviceImpl.readInertiaInertia((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_INERTIA:
          serviceImpl.writeInertiaInertia((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_SPEED:
          serviceImpl.readInertiaDrumSpeed((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_SPEED:
          serviceImpl.writeInertiaDrumSpeed((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_ANGLE_DEG:
          serviceImpl.readInertiaDrumAngleDeg((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_ANGLE_DEG:
          serviceImpl.writeInertiaDrumAngleDeg((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P1_E:
          serviceImpl.readMotorP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P1_E:
          serviceImpl.writeMotorP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P1_F:
          serviceImpl.readMotorP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P1_F:
          serviceImpl.writeMotorP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P2_E:
          serviceImpl.readMotorP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P2_E:
          serviceImpl.writeMotorP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P2_F:
          serviceImpl.readMotorP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P2_F:
          serviceImpl.writeMotorP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_MOTOR_DISPLACEMENT:
          serviceImpl.readMotorMotorDisplacement((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_MOTOR_DISPLACEMENT:
          serviceImpl.writeMotorMotorDisplacement((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_MOTOR_SPEED:
          serviceImpl.readMotorMotorSpeed((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_MOTOR_SPEED:
          serviceImpl.writeMotorMotorSpeed((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_MOTOR_FLOW:
          serviceImpl.readMotorMotorFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_MOTOR_FLOW:
          serviceImpl.writeMotorMotorFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_FLOW:
          serviceImpl.readOneJunctionFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_FLOW:
          serviceImpl.writeOneJunctionFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P1_E:
          serviceImpl.readOneJunctionP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P1_E:
          serviceImpl.writeOneJunctionP1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P2_E:
          serviceImpl.readOneJunctionP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P2_E:
          serviceImpl.writeOneJunctionP2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P3_E:
          serviceImpl.readOneJunctionP3E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P3_E:
          serviceImpl.writeOneJunctionP3E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P1_F:
          serviceImpl.readOneJunctionP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P1_F:
          serviceImpl.writeOneJunctionP1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P2_F:
          serviceImpl.readOneJunctionP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P2_F:
          serviceImpl.writeOneJunctionP2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P3_F:
          serviceImpl.readOneJunctionP3F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P3_F:
          serviceImpl.writeOneJunctionP3F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_FLOW:
          serviceImpl.readOneJunction7Flow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_FLOW:
          serviceImpl.writeOneJunction7Flow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P1_E:
          serviceImpl.readOneJunction7P1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P1_E:
          serviceImpl.writeOneJunction7P1E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P2_E:
          serviceImpl.readOneJunction7P2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P2_E:
          serviceImpl.writeOneJunction7P2E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P3_E:
          serviceImpl.readOneJunction7P3E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P3_E:
          serviceImpl.writeOneJunction7P3E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P4_E:
          serviceImpl.readOneJunction7P4E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P4_E:
          serviceImpl.writeOneJunction7P4E((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P1_F:
          serviceImpl.readOneJunction7P1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P1_F:
          serviceImpl.writeOneJunction7P1F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P2_F:
          serviceImpl.readOneJunction7P2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P2_F:
          serviceImpl.writeOneJunction7P2F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P3_F:
          serviceImpl.readOneJunction7P3F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P3_F:
          serviceImpl.writeOneJunction7P3F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P4_F:
          serviceImpl.readOneJunction7P4F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P4_F:
          serviceImpl.writeOneJunction7P4F((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_P_E:
          serviceImpl.readOpenTankPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_P_E:
          serviceImpl.writeOpenTankPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_P_F:
          serviceImpl.readOpenTankPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_P_F:
          serviceImpl.writeOpenTankPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_ATOM_PRESSURE:
          serviceImpl.readOpenTankAtomPressure((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_ATOM_PRESSURE:
          serviceImpl.writeOpenTankAtomPressure((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_FLOW2TANK:
          serviceImpl.readOpenTankFlow2Tank((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_FLOW2TANK:
          serviceImpl.writeOpenTankFlow2Tank((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_P_E:
          serviceImpl.readPumpPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_P_E:
          serviceImpl.writePumpPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_P_F:
          serviceImpl.readPumpPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_P_F:
          serviceImpl.writePumpPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_GAIN:
          serviceImpl.readPumpGain((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_GAIN:
          serviceImpl.writePumpGain((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PUMP_PRESSURE_MAX:
          serviceImpl.readPumpPumpPressureMax((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PUMP_PRESSURE_MAX:
          serviceImpl.writePumpPumpPressureMax((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PUMP_FLOW:
          serviceImpl.readPumpPumpFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PUMP_FLOW:
          serviceImpl.writePumpPumpFlow((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PUMP_PRESSURE:
          serviceImpl.readPumpPumpPressure((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PUMP_PRESSURE:
          serviceImpl.writePumpPumpPressure((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_WIRE_F:
          serviceImpl.readWireF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_WIRE_F:
          serviceImpl.writeWireF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_WIRE_V:
          serviceImpl.readWireV((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_WIRE_V:
          serviceImpl.writeWireV((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_SET_POINT:
          serviceImpl.readSetPoint((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_SET_POINT:
          serviceImpl.writeSetPoint((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_U_I_STATE_DOT:
          serviceImpl.readControllerUIStateDot((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_U_I_STATE_DOT:
          serviceImpl.writeControllerUIStateDot((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_U_I_STATE:
          serviceImpl.readControllerUIState((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_U_I_STATE:
          serviceImpl.writeControllerUIState((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_U_I_STATE_INITIAL:
          serviceImpl.readControllerUIStateInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_U_I_STATE_INITIAL:
          serviceImpl.writeControllerUIStateInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_P_E:
          serviceImpl.readInertiaPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_P_E:
          serviceImpl.writeInertiaPE((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_MOMENTUM:
          serviceImpl.readInertiaMomentum((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_MOMENTUM:
          serviceImpl.writeInertiaMomentum((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_MOMENTUM_INITIAL:
          serviceImpl.readInertiaMomentumInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_MOMENTUM_INITIAL:
          serviceImpl.writeInertiaMomentumInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_P_F:
          serviceImpl.readInertiaPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_P_F:
          serviceImpl.writeInertiaPF((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_ANGLE:
          serviceImpl.readInertiaDrumAngle((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_ANGLE:
          serviceImpl.writeInertiaDrumAngle((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_ANGLE_INITIAL:
          serviceImpl.readInertiaDrumAngleInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_ANGLE_INITIAL:
          serviceImpl.writeInertiaDrumAngleInitial((no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>) responseObserver);
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

  public static io.grpc.ServerServiceDefinition bindService(
      final PumpControlledWinchService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_CREATE_INSTANCE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference>(
                serviceImpl, METHODID_CREATE_INSTANCE)))
        .addMethod(
          METHOD_GET_MODEL_NAME,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Str>(
                serviceImpl, METHODID_GET_MODEL_NAME)))
        .addMethod(
          METHOD_GET_MODEL_VARIABLE_NAMES,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StrList>(
                serviceImpl, METHODID_GET_MODEL_VARIABLE_NAMES)))
        .addMethod(
          METHOD_GET_MODEL_VARIABLES,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Empty,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ScalarVariables>(
                serviceImpl, METHODID_GET_MODEL_VARIABLES)))
        .addMethod(
          METHOD_GET_CURRENT_TIME,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_GET_CURRENT_TIME)))
        .addMethod(
          METHOD_IS_TERMINATED,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Bool>(
                serviceImpl, METHODID_IS_TERMINATED)))
        .addMethod(
          METHOD_INIT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.InitRequest,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_INIT)))
        .addMethod(
          METHOD_STEP,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.StepRequest,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_STEP)))
        .addMethod(
          METHOD_TERMINATE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.TerminateRequest,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_TERMINATE)))
        .addMethod(
          METHOD_READ,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarRead,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Var>(
                serviceImpl, METHODID_READ)))
        .addMethod(
          METHOD_WRITE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.VarWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE)))
        .addMethod(
          METHOD_READ_CONTROLLER_SP,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_SP)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_SP,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_SP)))
        .addMethod(
          METHOD_READ_CONTROLLER_MV,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_MV)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_MV,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_MV)))
        .addMethod(
          METHOD_READ_CONTROLLER_OUTPUT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_OUTPUT)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_OUTPUT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_OUTPUT)))
        .addMethod(
          METHOD_READ_CONTROLLER_K,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_K)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_K,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_K)))
        .addMethod(
          METHOD_READ_CONTROLLER_TI,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_TI)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_TI,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_TI)))
        .addMethod(
          METHOD_READ_CONTROLLER_B,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_B)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_B,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_B)))
        .addMethod(
          METHOD_READ_CONTROLLER_TA,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_TA)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_TA,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_TA)))
        .addMethod(
          METHOD_READ_CONTROLLER_MINIMUM,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_MINIMUM)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_MINIMUM,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_MINIMUM)))
        .addMethod(
          METHOD_READ_CONTROLLER_MAXIMUM,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_MAXIMUM)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_MAXIMUM,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_MAXIMUM)))
        .addMethod(
          METHOD_READ_CONTROLLER_OUTPUT_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_OUTPUT_INITIAL)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_OUTPUT_INITIAL)))
        .addMethod(
          METHOD_READ_CONTROLLER_ERROR,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_ERROR)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_ERROR,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_ERROR)))
        .addMethod(
          METHOD_READ_CONTROLLER_PB_LOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_PB_LOW)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_PB_LOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_PB_LOW)))
        .addMethod(
          METHOD_READ_CONTROLLER_PB_HIGH,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_PB_HIGH)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_PB_HIGH,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_PB_HIGH)))
        .addMethod(
          METHOD_READ_DRUM_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_DRUM_P1_E)))
        .addMethod(
          METHOD_WRITE_DRUM_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_DRUM_P1_E)))
        .addMethod(
          METHOD_READ_DRUM_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_DRUM_P1_F)))
        .addMethod(
          METHOD_WRITE_DRUM_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_DRUM_P1_F)))
        .addMethod(
          METHOD_READ_DRUM_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_DRUM_P2_E)))
        .addMethod(
          METHOD_WRITE_DRUM_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_DRUM_P2_E)))
        .addMethod(
          METHOD_READ_DRUM_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_DRUM_P2_F)))
        .addMethod(
          METHOD_WRITE_DRUM_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_DRUM_P2_F)))
        .addMethod(
          METHOD_READ_DRUM_DRUM_DIAMETER,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_DRUM_DRUM_DIAMETER)))
        .addMethod(
          METHOD_WRITE_DRUM_DRUM_DIAMETER,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_DRUM_DRUM_DIAMETER)))
        .addMethod(
          METHOD_READ_FLOW_SENSOR_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FLOW_SENSOR_P1_E)))
        .addMethod(
          METHOD_WRITE_FLOW_SENSOR_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FLOW_SENSOR_P1_E)))
        .addMethod(
          METHOD_READ_FLOW_SENSOR_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FLOW_SENSOR_P1_F)))
        .addMethod(
          METHOD_WRITE_FLOW_SENSOR_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FLOW_SENSOR_P1_F)))
        .addMethod(
          METHOD_READ_FLOW_SENSOR_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FLOW_SENSOR_P2_F)))
        .addMethod(
          METHOD_WRITE_FLOW_SENSOR_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FLOW_SENSOR_P2_F)))
        .addMethod(
          METHOD_READ_FLOW_SENSOR_P2_V,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FLOW_SENSOR_P2_V)))
        .addMethod(
          METHOD_WRITE_FLOW_SENSOR_P2_V,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FLOW_SENSOR_P2_V)))
        .addMethod(
          METHOD_READ_FLOW_SENSOR_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FLOW_SENSOR_FLOW)))
        .addMethod(
          METHOD_WRITE_FLOW_SENSOR_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FLOW_SENSOR_FLOW)))
        .addMethod(
          METHOD_READ_FRICTION_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FRICTION_P_E)))
        .addMethod(
          METHOD_WRITE_FRICTION_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FRICTION_P_E)))
        .addMethod(
          METHOD_READ_FRICTION_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FRICTION_P_F)))
        .addMethod(
          METHOD_WRITE_FRICTION_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FRICTION_P_F)))
        .addMethod(
          METHOD_READ_FRICTION_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FRICTION_F)))
        .addMethod(
          METHOD_WRITE_FRICTION_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FRICTION_F)))
        .addMethod(
          METHOD_READ_FRICTION_LOAD_MASS,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_FRICTION_LOAD_MASS)))
        .addMethod(
          METHOD_WRITE_FRICTION_LOAD_MASS,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_FRICTION_LOAD_MASS)))
        .addMethod(
          METHOD_READ_GEAR_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_GEAR_P1_E)))
        .addMethod(
          METHOD_WRITE_GEAR_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_GEAR_P1_E)))
        .addMethod(
          METHOD_READ_GEAR_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_GEAR_P1_F)))
        .addMethod(
          METHOD_WRITE_GEAR_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_GEAR_P1_F)))
        .addMethod(
          METHOD_READ_GEAR_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_GEAR_P2_E)))
        .addMethod(
          METHOD_WRITE_GEAR_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_GEAR_P2_E)))
        .addMethod(
          METHOD_READ_GEAR_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_GEAR_P2_F)))
        .addMethod(
          METHOD_WRITE_GEAR_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_GEAR_P2_F)))
        .addMethod(
          METHOD_READ_GEAR_GEAR_RATIO,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_GEAR_GEAR_RATIO)))
        .addMethod(
          METHOD_WRITE_GEAR_GEAR_RATIO,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_GEAR_GEAR_RATIO)))
        .addMethod(
          METHOD_READ_INERTIA_INERTIA,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_INERTIA)))
        .addMethod(
          METHOD_WRITE_INERTIA_INERTIA,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_INERTIA)))
        .addMethod(
          METHOD_READ_INERTIA_DRUM_SPEED,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_DRUM_SPEED)))
        .addMethod(
          METHOD_WRITE_INERTIA_DRUM_SPEED,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_DRUM_SPEED)))
        .addMethod(
          METHOD_READ_INERTIA_DRUM_ANGLE_DEG,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_DRUM_ANGLE_DEG)))
        .addMethod(
          METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_DRUM_ANGLE_DEG)))
        .addMethod(
          METHOD_READ_MOTOR_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_P1_E)))
        .addMethod(
          METHOD_WRITE_MOTOR_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_P1_E)))
        .addMethod(
          METHOD_READ_MOTOR_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_P1_F)))
        .addMethod(
          METHOD_WRITE_MOTOR_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_P1_F)))
        .addMethod(
          METHOD_READ_MOTOR_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_P2_E)))
        .addMethod(
          METHOD_WRITE_MOTOR_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_P2_E)))
        .addMethod(
          METHOD_READ_MOTOR_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_P2_F)))
        .addMethod(
          METHOD_WRITE_MOTOR_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_P2_F)))
        .addMethod(
          METHOD_READ_MOTOR_MOTOR_DISPLACEMENT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_MOTOR_DISPLACEMENT)))
        .addMethod(
          METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_MOTOR_DISPLACEMENT)))
        .addMethod(
          METHOD_READ_MOTOR_MOTOR_SPEED,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_MOTOR_SPEED)))
        .addMethod(
          METHOD_WRITE_MOTOR_MOTOR_SPEED,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_MOTOR_SPEED)))
        .addMethod(
          METHOD_READ_MOTOR_MOTOR_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_MOTOR_MOTOR_FLOW)))
        .addMethod(
          METHOD_WRITE_MOTOR_MOTOR_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_MOTOR_MOTOR_FLOW)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_FLOW)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_FLOW)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_P1_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_P1_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_P2_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_P2_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_P3_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_P3_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_P3_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_P3_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_P1_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_P1_F)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_P2_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_P2_F)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION_P3_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION_P3_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION_P3_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION_P3_F)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_FLOW)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_FLOW)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P1_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P1_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P1_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P2_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P2_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P2_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P3_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P3_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P3_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P3_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P4_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P4_E)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P4_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P4_E)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P1_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P1_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P1_F)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P2_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P2_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P2_F)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P3_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P3_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P3_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P3_F)))
        .addMethod(
          METHOD_READ_ONE_JUNCTION7_P4_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_ONE_JUNCTION7_P4_F)))
        .addMethod(
          METHOD_WRITE_ONE_JUNCTION7_P4_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_ONE_JUNCTION7_P4_F)))
        .addMethod(
          METHOD_READ_OPEN_TANK_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_OPEN_TANK_P_E)))
        .addMethod(
          METHOD_WRITE_OPEN_TANK_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_OPEN_TANK_P_E)))
        .addMethod(
          METHOD_READ_OPEN_TANK_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_OPEN_TANK_P_F)))
        .addMethod(
          METHOD_WRITE_OPEN_TANK_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_OPEN_TANK_P_F)))
        .addMethod(
          METHOD_READ_OPEN_TANK_ATOM_PRESSURE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_OPEN_TANK_ATOM_PRESSURE)))
        .addMethod(
          METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_OPEN_TANK_ATOM_PRESSURE)))
        .addMethod(
          METHOD_READ_OPEN_TANK_FLOW2TANK,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_OPEN_TANK_FLOW2TANK)))
        .addMethod(
          METHOD_WRITE_OPEN_TANK_FLOW2TANK,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_OPEN_TANK_FLOW2TANK)))
        .addMethod(
          METHOD_READ_PUMP_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_PUMP_P_E)))
        .addMethod(
          METHOD_WRITE_PUMP_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_PUMP_P_E)))
        .addMethod(
          METHOD_READ_PUMP_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_PUMP_P_F)))
        .addMethod(
          METHOD_WRITE_PUMP_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_PUMP_P_F)))
        .addMethod(
          METHOD_READ_PUMP_GAIN,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_PUMP_GAIN)))
        .addMethod(
          METHOD_WRITE_PUMP_GAIN,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_PUMP_GAIN)))
        .addMethod(
          METHOD_READ_PUMP_PUMP_PRESSURE_MAX,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_PUMP_PUMP_PRESSURE_MAX)))
        .addMethod(
          METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_PUMP_PUMP_PRESSURE_MAX)))
        .addMethod(
          METHOD_READ_PUMP_PUMP_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_PUMP_PUMP_FLOW)))
        .addMethod(
          METHOD_WRITE_PUMP_PUMP_FLOW,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_PUMP_PUMP_FLOW)))
        .addMethod(
          METHOD_READ_PUMP_PUMP_PRESSURE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_PUMP_PUMP_PRESSURE)))
        .addMethod(
          METHOD_WRITE_PUMP_PUMP_PRESSURE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_PUMP_PUMP_PRESSURE)))
        .addMethod(
          METHOD_READ_WIRE_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_WIRE_F)))
        .addMethod(
          METHOD_WRITE_WIRE_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_WIRE_F)))
        .addMethod(
          METHOD_READ_WIRE_V,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_WIRE_V)))
        .addMethod(
          METHOD_WRITE_WIRE_V,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_WIRE_V)))
        .addMethod(
          METHOD_READ_SET_POINT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_SET_POINT)))
        .addMethod(
          METHOD_WRITE_SET_POINT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_SET_POINT)))
        .addMethod(
          METHOD_READ_CONTROLLER_U_I_STATE_DOT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_U_I_STATE_DOT)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_U_I_STATE_DOT,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_U_I_STATE_DOT)))
        .addMethod(
          METHOD_READ_CONTROLLER_U_I_STATE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_U_I_STATE)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_U_I_STATE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_U_I_STATE)))
        .addMethod(
          METHOD_READ_CONTROLLER_U_I_STATE_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_CONTROLLER_U_I_STATE_INITIAL)))
        .addMethod(
          METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_CONTROLLER_U_I_STATE_INITIAL)))
        .addMethod(
          METHOD_READ_INERTIA_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_P_E)))
        .addMethod(
          METHOD_WRITE_INERTIA_P_E,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_P_E)))
        .addMethod(
          METHOD_READ_INERTIA_MOMENTUM,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_MOMENTUM)))
        .addMethod(
          METHOD_WRITE_INERTIA_MOMENTUM,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_MOMENTUM)))
        .addMethod(
          METHOD_READ_INERTIA_MOMENTUM_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_MOMENTUM_INITIAL)))
        .addMethod(
          METHOD_WRITE_INERTIA_MOMENTUM_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_MOMENTUM_INITIAL)))
        .addMethod(
          METHOD_READ_INERTIA_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_P_F)))
        .addMethod(
          METHOD_WRITE_INERTIA_P_F,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_P_F)))
        .addMethod(
          METHOD_READ_INERTIA_DRUM_ANGLE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_DRUM_ANGLE)))
        .addMethod(
          METHOD_WRITE_INERTIA_DRUM_ANGLE,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_DRUM_ANGLE)))
        .addMethod(
          METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.ModelReference,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Real>(
                serviceImpl, METHODID_READ_INERTIA_DRUM_ANGLE_INITIAL)))
        .addMethod(
          METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL,
          asyncUnaryCall(
            new MethodHandlers<
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.RealWrite,
              no.ntnu.mechlab.grpc_fmu.PumpControlledWinchProto.Status>(
                serviceImpl, METHODID_WRITE_INERTIA_DRUM_ANGLE_INITIAL)))
        .build();
  }
}
