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
    comments = "Source: no/mechatronics/sfi/grpc_fmu/unique_service.proto")
public final class PumpControlledWinchServiceGrpc {

  private PumpControlledWinchServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerSPMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_SP = getReadControllerSPMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerSPMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerSPMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerSPMethod;
    if ((getReadControllerSPMethod = PumpControlledWinchServiceGrpc.getReadControllerSPMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerSPMethod = PumpControlledWinchServiceGrpc.getReadControllerSPMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerSPMethod = getReadControllerSPMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_SP"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_SP"))
                  .build();
          }
        }
     }
     return getReadControllerSPMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerSPMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_SP = getWriteControllerSPMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerSPMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerSPMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerSPMethod;
    if ((getWriteControllerSPMethod = PumpControlledWinchServiceGrpc.getWriteControllerSPMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerSPMethod = PumpControlledWinchServiceGrpc.getWriteControllerSPMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerSPMethod = getWriteControllerSPMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_SP"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_SP"))
                  .build();
          }
        }
     }
     return getWriteControllerSPMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerMVMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_MV = getReadControllerMVMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMVMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMVMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMVMethod;
    if ((getReadControllerMVMethod = PumpControlledWinchServiceGrpc.getReadControllerMVMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerMVMethod = PumpControlledWinchServiceGrpc.getReadControllerMVMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerMVMethod = getReadControllerMVMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_MV"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_MV"))
                  .build();
          }
        }
     }
     return getReadControllerMVMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerMVMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_MV = getWriteControllerMVMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMVMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMVMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMVMethod;
    if ((getWriteControllerMVMethod = PumpControlledWinchServiceGrpc.getWriteControllerMVMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerMVMethod = PumpControlledWinchServiceGrpc.getWriteControllerMVMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerMVMethod = getWriteControllerMVMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_MV"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_MV"))
                  .build();
          }
        }
     }
     return getWriteControllerMVMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerOutputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_OUTPUT = getReadControllerOutputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerOutputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerOutputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerOutputMethod;
    if ((getReadControllerOutputMethod = PumpControlledWinchServiceGrpc.getReadControllerOutputMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerOutputMethod = PumpControlledWinchServiceGrpc.getReadControllerOutputMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerOutputMethod = getReadControllerOutputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_output"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_output"))
                  .build();
          }
        }
     }
     return getReadControllerOutputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerOutputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_OUTPUT = getWriteControllerOutputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerOutputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerOutputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerOutputMethod;
    if ((getWriteControllerOutputMethod = PumpControlledWinchServiceGrpc.getWriteControllerOutputMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerOutputMethod = PumpControlledWinchServiceGrpc.getWriteControllerOutputMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerOutputMethod = getWriteControllerOutputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_output"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_output"))
                  .build();
          }
        }
     }
     return getWriteControllerOutputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerKMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_K = getReadControllerKMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerKMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerKMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerKMethod;
    if ((getReadControllerKMethod = PumpControlledWinchServiceGrpc.getReadControllerKMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerKMethod = PumpControlledWinchServiceGrpc.getReadControllerKMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerKMethod = getReadControllerKMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_K"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_K"))
                  .build();
          }
        }
     }
     return getReadControllerKMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerKMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_K = getWriteControllerKMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerKMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerKMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerKMethod;
    if ((getWriteControllerKMethod = PumpControlledWinchServiceGrpc.getWriteControllerKMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerKMethod = PumpControlledWinchServiceGrpc.getWriteControllerKMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerKMethod = getWriteControllerKMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_K"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_K"))
                  .build();
          }
        }
     }
     return getWriteControllerKMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerTiMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_TI = getReadControllerTiMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerTiMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerTiMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerTiMethod;
    if ((getReadControllerTiMethod = PumpControlledWinchServiceGrpc.getReadControllerTiMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerTiMethod = PumpControlledWinchServiceGrpc.getReadControllerTiMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerTiMethod = getReadControllerTiMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_Ti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_Ti"))
                  .build();
          }
        }
     }
     return getReadControllerTiMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerTiMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_TI = getWriteControllerTiMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerTiMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerTiMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerTiMethod;
    if ((getWriteControllerTiMethod = PumpControlledWinchServiceGrpc.getWriteControllerTiMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerTiMethod = PumpControlledWinchServiceGrpc.getWriteControllerTiMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerTiMethod = getWriteControllerTiMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_Ti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_Ti"))
                  .build();
          }
        }
     }
     return getWriteControllerTiMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerBMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_B = getReadControllerBMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerBMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerBMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerBMethod;
    if ((getReadControllerBMethod = PumpControlledWinchServiceGrpc.getReadControllerBMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerBMethod = PumpControlledWinchServiceGrpc.getReadControllerBMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerBMethod = getReadControllerBMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_b"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_b"))
                  .build();
          }
        }
     }
     return getReadControllerBMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerBMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_B = getWriteControllerBMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerBMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerBMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerBMethod;
    if ((getWriteControllerBMethod = PumpControlledWinchServiceGrpc.getWriteControllerBMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerBMethod = PumpControlledWinchServiceGrpc.getWriteControllerBMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerBMethod = getWriteControllerBMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_b"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_b"))
                  .build();
          }
        }
     }
     return getWriteControllerBMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerTaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_TA = getReadControllerTaMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerTaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerTaMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerTaMethod;
    if ((getReadControllerTaMethod = PumpControlledWinchServiceGrpc.getReadControllerTaMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerTaMethod = PumpControlledWinchServiceGrpc.getReadControllerTaMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerTaMethod = getReadControllerTaMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_Ta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_Ta"))
                  .build();
          }
        }
     }
     return getReadControllerTaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerTaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_TA = getWriteControllerTaMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerTaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerTaMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerTaMethod;
    if ((getWriteControllerTaMethod = PumpControlledWinchServiceGrpc.getWriteControllerTaMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerTaMethod = PumpControlledWinchServiceGrpc.getWriteControllerTaMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerTaMethod = getWriteControllerTaMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_Ta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_Ta"))
                  .build();
          }
        }
     }
     return getWriteControllerTaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerMinimumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_MINIMUM = getReadControllerMinimumMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMinimumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMinimumMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMinimumMethod;
    if ((getReadControllerMinimumMethod = PumpControlledWinchServiceGrpc.getReadControllerMinimumMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerMinimumMethod = PumpControlledWinchServiceGrpc.getReadControllerMinimumMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerMinimumMethod = getReadControllerMinimumMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_minimum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_minimum"))
                  .build();
          }
        }
     }
     return getReadControllerMinimumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerMinimumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_MINIMUM = getWriteControllerMinimumMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMinimumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMinimumMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMinimumMethod;
    if ((getWriteControllerMinimumMethod = PumpControlledWinchServiceGrpc.getWriteControllerMinimumMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerMinimumMethod = PumpControlledWinchServiceGrpc.getWriteControllerMinimumMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerMinimumMethod = getWriteControllerMinimumMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_minimum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_minimum"))
                  .build();
          }
        }
     }
     return getWriteControllerMinimumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerMaximumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_MAXIMUM = getReadControllerMaximumMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMaximumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMaximumMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerMaximumMethod;
    if ((getReadControllerMaximumMethod = PumpControlledWinchServiceGrpc.getReadControllerMaximumMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerMaximumMethod = PumpControlledWinchServiceGrpc.getReadControllerMaximumMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerMaximumMethod = getReadControllerMaximumMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_maximum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_maximum"))
                  .build();
          }
        }
     }
     return getReadControllerMaximumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerMaximumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_MAXIMUM = getWriteControllerMaximumMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMaximumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMaximumMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerMaximumMethod;
    if ((getWriteControllerMaximumMethod = PumpControlledWinchServiceGrpc.getWriteControllerMaximumMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerMaximumMethod = PumpControlledWinchServiceGrpc.getWriteControllerMaximumMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerMaximumMethod = getWriteControllerMaximumMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_maximum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_maximum"))
                  .build();
          }
        }
     }
     return getWriteControllerMaximumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerOutputInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_OUTPUT_INITIAL = getReadControllerOutputInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerOutputInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerOutputInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerOutputInitialMethod;
    if ((getReadControllerOutputInitialMethod = PumpControlledWinchServiceGrpc.getReadControllerOutputInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerOutputInitialMethod = PumpControlledWinchServiceGrpc.getReadControllerOutputInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerOutputInitialMethod = getReadControllerOutputInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_output_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_output_initial"))
                  .build();
          }
        }
     }
     return getReadControllerOutputInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerOutputInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_OUTPUT_INITIAL = getWriteControllerOutputInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerOutputInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerOutputInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerOutputInitialMethod;
    if ((getWriteControllerOutputInitialMethod = PumpControlledWinchServiceGrpc.getWriteControllerOutputInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerOutputInitialMethod = PumpControlledWinchServiceGrpc.getWriteControllerOutputInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerOutputInitialMethod = getWriteControllerOutputInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_output_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_output_initial"))
                  .build();
          }
        }
     }
     return getWriteControllerOutputInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerErrorMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_ERROR = getReadControllerErrorMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerErrorMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerErrorMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerErrorMethod;
    if ((getReadControllerErrorMethod = PumpControlledWinchServiceGrpc.getReadControllerErrorMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerErrorMethod = PumpControlledWinchServiceGrpc.getReadControllerErrorMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerErrorMethod = getReadControllerErrorMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_error"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_error"))
                  .build();
          }
        }
     }
     return getReadControllerErrorMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerErrorMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_ERROR = getWriteControllerErrorMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerErrorMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerErrorMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerErrorMethod;
    if ((getWriteControllerErrorMethod = PumpControlledWinchServiceGrpc.getWriteControllerErrorMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerErrorMethod = PumpControlledWinchServiceGrpc.getWriteControllerErrorMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerErrorMethod = getWriteControllerErrorMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_error"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_error"))
                  .build();
          }
        }
     }
     return getWriteControllerErrorMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerPBLowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_PB_LOW = getReadControllerPBLowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerPBLowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerPBLowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerPBLowMethod;
    if ((getReadControllerPBLowMethod = PumpControlledWinchServiceGrpc.getReadControllerPBLowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerPBLowMethod = PumpControlledWinchServiceGrpc.getReadControllerPBLowMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerPBLowMethod = getReadControllerPBLowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_PB_low"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_PB_low"))
                  .build();
          }
        }
     }
     return getReadControllerPBLowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerPBLowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_PB_LOW = getWriteControllerPBLowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerPBLowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerPBLowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerPBLowMethod;
    if ((getWriteControllerPBLowMethod = PumpControlledWinchServiceGrpc.getWriteControllerPBLowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerPBLowMethod = PumpControlledWinchServiceGrpc.getWriteControllerPBLowMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerPBLowMethod = getWriteControllerPBLowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_PB_low"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_PB_low"))
                  .build();
          }
        }
     }
     return getWriteControllerPBLowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerPBHighMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_PB_HIGH = getReadControllerPBHighMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerPBHighMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerPBHighMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerPBHighMethod;
    if ((getReadControllerPBHighMethod = PumpControlledWinchServiceGrpc.getReadControllerPBHighMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerPBHighMethod = PumpControlledWinchServiceGrpc.getReadControllerPBHighMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerPBHighMethod = getReadControllerPBHighMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_PB_high"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_PB_high"))
                  .build();
          }
        }
     }
     return getReadControllerPBHighMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerPBHighMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_PB_HIGH = getWriteControllerPBHighMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerPBHighMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerPBHighMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerPBHighMethod;
    if ((getWriteControllerPBHighMethod = PumpControlledWinchServiceGrpc.getWriteControllerPBHighMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerPBHighMethod = PumpControlledWinchServiceGrpc.getWriteControllerPBHighMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerPBHighMethod = getWriteControllerPBHighMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_PB_high"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_PB_high"))
                  .build();
          }
        }
     }
     return getWriteControllerPBHighMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrumP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_DRUM_P1_E = getReadDrumP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP1EMethod;
    if ((getReadDrumP1EMethod = PumpControlledWinchServiceGrpc.getReadDrumP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadDrumP1EMethod = PumpControlledWinchServiceGrpc.getReadDrumP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadDrumP1EMethod = getReadDrumP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Drum_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Drum_p1_e"))
                  .build();
          }
        }
     }
     return getReadDrumP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrumP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_DRUM_P1_E = getWriteDrumP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP1EMethod;
    if ((getWriteDrumP1EMethod = PumpControlledWinchServiceGrpc.getWriteDrumP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteDrumP1EMethod = PumpControlledWinchServiceGrpc.getWriteDrumP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteDrumP1EMethod = getWriteDrumP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Drum_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Drum_p1_e"))
                  .build();
          }
        }
     }
     return getWriteDrumP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrumP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_DRUM_P1_F = getReadDrumP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP1FMethod;
    if ((getReadDrumP1FMethod = PumpControlledWinchServiceGrpc.getReadDrumP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadDrumP1FMethod = PumpControlledWinchServiceGrpc.getReadDrumP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadDrumP1FMethod = getReadDrumP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Drum_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Drum_p1_f"))
                  .build();
          }
        }
     }
     return getReadDrumP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrumP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_DRUM_P1_F = getWriteDrumP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP1FMethod;
    if ((getWriteDrumP1FMethod = PumpControlledWinchServiceGrpc.getWriteDrumP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteDrumP1FMethod = PumpControlledWinchServiceGrpc.getWriteDrumP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteDrumP1FMethod = getWriteDrumP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Drum_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Drum_p1_f"))
                  .build();
          }
        }
     }
     return getWriteDrumP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrumP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_DRUM_P2_E = getReadDrumP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP2EMethod;
    if ((getReadDrumP2EMethod = PumpControlledWinchServiceGrpc.getReadDrumP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadDrumP2EMethod = PumpControlledWinchServiceGrpc.getReadDrumP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadDrumP2EMethod = getReadDrumP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Drum_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Drum_p2_e"))
                  .build();
          }
        }
     }
     return getReadDrumP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrumP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_DRUM_P2_E = getWriteDrumP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP2EMethod;
    if ((getWriteDrumP2EMethod = PumpControlledWinchServiceGrpc.getWriteDrumP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteDrumP2EMethod = PumpControlledWinchServiceGrpc.getWriteDrumP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteDrumP2EMethod = getWriteDrumP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Drum_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Drum_p2_e"))
                  .build();
          }
        }
     }
     return getWriteDrumP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrumP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_DRUM_P2_F = getReadDrumP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumP2FMethod;
    if ((getReadDrumP2FMethod = PumpControlledWinchServiceGrpc.getReadDrumP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadDrumP2FMethod = PumpControlledWinchServiceGrpc.getReadDrumP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadDrumP2FMethod = getReadDrumP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Drum_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Drum_p2_f"))
                  .build();
          }
        }
     }
     return getReadDrumP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrumP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_DRUM_P2_F = getWriteDrumP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumP2FMethod;
    if ((getWriteDrumP2FMethod = PumpControlledWinchServiceGrpc.getWriteDrumP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteDrumP2FMethod = PumpControlledWinchServiceGrpc.getWriteDrumP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteDrumP2FMethod = getWriteDrumP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Drum_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Drum_p2_f"))
                  .build();
          }
        }
     }
     return getWriteDrumP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrumDrumDiameterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_DRUM_DRUM_DIAMETER = getReadDrumDrumDiameterMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumDrumDiameterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumDrumDiameterMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadDrumDrumDiameterMethod;
    if ((getReadDrumDrumDiameterMethod = PumpControlledWinchServiceGrpc.getReadDrumDrumDiameterMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadDrumDrumDiameterMethod = PumpControlledWinchServiceGrpc.getReadDrumDrumDiameterMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadDrumDrumDiameterMethod = getReadDrumDrumDiameterMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Drum_DrumDiameter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Drum_DrumDiameter"))
                  .build();
          }
        }
     }
     return getReadDrumDrumDiameterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrumDrumDiameterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_DRUM_DRUM_DIAMETER = getWriteDrumDrumDiameterMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumDrumDiameterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumDrumDiameterMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteDrumDrumDiameterMethod;
    if ((getWriteDrumDrumDiameterMethod = PumpControlledWinchServiceGrpc.getWriteDrumDrumDiameterMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteDrumDrumDiameterMethod = PumpControlledWinchServiceGrpc.getWriteDrumDrumDiameterMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteDrumDrumDiameterMethod = getWriteDrumDrumDiameterMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Drum_DrumDiameter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Drum_DrumDiameter"))
                  .build();
          }
        }
     }
     return getWriteDrumDrumDiameterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFlowSensorP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FLOW_SENSOR_P1_E = getReadFlowSensorP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP1EMethod;
    if ((getReadFlowSensorP1EMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFlowSensorP1EMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFlowSensorP1EMethod = getReadFlowSensorP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_FlowSensor_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_FlowSensor_p1_e"))
                  .build();
          }
        }
     }
     return getReadFlowSensorP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFlowSensorP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FLOW_SENSOR_P1_E = getWriteFlowSensorP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP1EMethod;
    if ((getWriteFlowSensorP1EMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFlowSensorP1EMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFlowSensorP1EMethod = getWriteFlowSensorP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_FlowSensor_p1_e"))
                  .build();
          }
        }
     }
     return getWriteFlowSensorP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFlowSensorP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FLOW_SENSOR_P1_F = getReadFlowSensorP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP1FMethod;
    if ((getReadFlowSensorP1FMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFlowSensorP1FMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFlowSensorP1FMethod = getReadFlowSensorP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_FlowSensor_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_FlowSensor_p1_f"))
                  .build();
          }
        }
     }
     return getReadFlowSensorP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFlowSensorP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FLOW_SENSOR_P1_F = getWriteFlowSensorP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP1FMethod;
    if ((getWriteFlowSensorP1FMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFlowSensorP1FMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFlowSensorP1FMethod = getWriteFlowSensorP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_FlowSensor_p1_f"))
                  .build();
          }
        }
     }
     return getWriteFlowSensorP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFlowSensorP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FLOW_SENSOR_P2_F = getReadFlowSensorP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP2FMethod;
    if ((getReadFlowSensorP2FMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFlowSensorP2FMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFlowSensorP2FMethod = getReadFlowSensorP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_FlowSensor_p2_F"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_FlowSensor_p2_F"))
                  .build();
          }
        }
     }
     return getReadFlowSensorP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFlowSensorP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FLOW_SENSOR_P2_F = getWriteFlowSensorP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP2FMethod;
    if ((getWriteFlowSensorP2FMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFlowSensorP2FMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFlowSensorP2FMethod = getWriteFlowSensorP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p2_F"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_FlowSensor_p2_F"))
                  .build();
          }
        }
     }
     return getWriteFlowSensorP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFlowSensorP2VMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FLOW_SENSOR_P2_V = getReadFlowSensorP2VMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP2VMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP2VMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorP2VMethod;
    if ((getReadFlowSensorP2VMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP2VMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFlowSensorP2VMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorP2VMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFlowSensorP2VMethod = getReadFlowSensorP2VMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_FlowSensor_p2_v"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_FlowSensor_p2_v"))
                  .build();
          }
        }
     }
     return getReadFlowSensorP2VMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFlowSensorP2VMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FLOW_SENSOR_P2_V = getWriteFlowSensorP2VMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP2VMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP2VMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorP2VMethod;
    if ((getWriteFlowSensorP2VMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP2VMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFlowSensorP2VMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorP2VMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFlowSensorP2VMethod = getWriteFlowSensorP2VMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_p2_v"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_FlowSensor_p2_v"))
                  .build();
          }
        }
     }
     return getWriteFlowSensorP2VMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFlowSensorFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FLOW_SENSOR_FLOW = getReadFlowSensorFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFlowSensorFlowMethod;
    if ((getReadFlowSensorFlowMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFlowSensorFlowMethod = PumpControlledWinchServiceGrpc.getReadFlowSensorFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFlowSensorFlowMethod = getReadFlowSensorFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_FlowSensor_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_FlowSensor_flow"))
                  .build();
          }
        }
     }
     return getReadFlowSensorFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFlowSensorFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FLOW_SENSOR_FLOW = getWriteFlowSensorFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFlowSensorFlowMethod;
    if ((getWriteFlowSensorFlowMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFlowSensorFlowMethod = PumpControlledWinchServiceGrpc.getWriteFlowSensorFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFlowSensorFlowMethod = getWriteFlowSensorFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_FlowSensor_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_FlowSensor_flow"))
                  .build();
          }
        }
     }
     return getWriteFlowSensorFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFrictionPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FRICTION_P_E = getReadFrictionPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionPEMethod;
    if ((getReadFrictionPEMethod = PumpControlledWinchServiceGrpc.getReadFrictionPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFrictionPEMethod = PumpControlledWinchServiceGrpc.getReadFrictionPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFrictionPEMethod = getReadFrictionPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Friction_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Friction_p_e"))
                  .build();
          }
        }
     }
     return getReadFrictionPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFrictionPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FRICTION_P_E = getWriteFrictionPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionPEMethod;
    if ((getWriteFrictionPEMethod = PumpControlledWinchServiceGrpc.getWriteFrictionPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFrictionPEMethod = PumpControlledWinchServiceGrpc.getWriteFrictionPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFrictionPEMethod = getWriteFrictionPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Friction_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Friction_p_e"))
                  .build();
          }
        }
     }
     return getWriteFrictionPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFrictionPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FRICTION_P_F = getReadFrictionPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionPFMethod;
    if ((getReadFrictionPFMethod = PumpControlledWinchServiceGrpc.getReadFrictionPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFrictionPFMethod = PumpControlledWinchServiceGrpc.getReadFrictionPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFrictionPFMethod = getReadFrictionPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Friction_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Friction_p_f"))
                  .build();
          }
        }
     }
     return getReadFrictionPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFrictionPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FRICTION_P_F = getWriteFrictionPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionPFMethod;
    if ((getWriteFrictionPFMethod = PumpControlledWinchServiceGrpc.getWriteFrictionPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFrictionPFMethod = PumpControlledWinchServiceGrpc.getWriteFrictionPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFrictionPFMethod = getWriteFrictionPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Friction_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Friction_p_f"))
                  .build();
          }
        }
     }
     return getWriteFrictionPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFrictionFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FRICTION_F = getReadFrictionFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionFMethod;
    if ((getReadFrictionFMethod = PumpControlledWinchServiceGrpc.getReadFrictionFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFrictionFMethod = PumpControlledWinchServiceGrpc.getReadFrictionFMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFrictionFMethod = getReadFrictionFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Friction_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Friction_f"))
                  .build();
          }
        }
     }
     return getReadFrictionFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFrictionFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FRICTION_F = getWriteFrictionFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionFMethod;
    if ((getWriteFrictionFMethod = PumpControlledWinchServiceGrpc.getWriteFrictionFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFrictionFMethod = PumpControlledWinchServiceGrpc.getWriteFrictionFMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFrictionFMethod = getWriteFrictionFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Friction_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Friction_f"))
                  .build();
          }
        }
     }
     return getWriteFrictionFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFrictionLoadMassMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_FRICTION_LOAD_MASS = getReadFrictionLoadMassMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionLoadMassMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionLoadMassMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadFrictionLoadMassMethod;
    if ((getReadFrictionLoadMassMethod = PumpControlledWinchServiceGrpc.getReadFrictionLoadMassMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadFrictionLoadMassMethod = PumpControlledWinchServiceGrpc.getReadFrictionLoadMassMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadFrictionLoadMassMethod = getReadFrictionLoadMassMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Friction_LoadMass"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Friction_LoadMass"))
                  .build();
          }
        }
     }
     return getReadFrictionLoadMassMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFrictionLoadMassMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_FRICTION_LOAD_MASS = getWriteFrictionLoadMassMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionLoadMassMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionLoadMassMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteFrictionLoadMassMethod;
    if ((getWriteFrictionLoadMassMethod = PumpControlledWinchServiceGrpc.getWriteFrictionLoadMassMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteFrictionLoadMassMethod = PumpControlledWinchServiceGrpc.getWriteFrictionLoadMassMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteFrictionLoadMassMethod = getWriteFrictionLoadMassMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Friction_LoadMass"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Friction_LoadMass"))
                  .build();
          }
        }
     }
     return getWriteFrictionLoadMassMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadGearP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_GEAR_P1_E = getReadGearP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP1EMethod;
    if ((getReadGearP1EMethod = PumpControlledWinchServiceGrpc.getReadGearP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadGearP1EMethod = PumpControlledWinchServiceGrpc.getReadGearP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadGearP1EMethod = getReadGearP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Gear_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Gear_p1_e"))
                  .build();
          }
        }
     }
     return getReadGearP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteGearP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_GEAR_P1_E = getWriteGearP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP1EMethod;
    if ((getWriteGearP1EMethod = PumpControlledWinchServiceGrpc.getWriteGearP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteGearP1EMethod = PumpControlledWinchServiceGrpc.getWriteGearP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteGearP1EMethod = getWriteGearP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Gear_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Gear_p1_e"))
                  .build();
          }
        }
     }
     return getWriteGearP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadGearP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_GEAR_P1_F = getReadGearP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP1FMethod;
    if ((getReadGearP1FMethod = PumpControlledWinchServiceGrpc.getReadGearP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadGearP1FMethod = PumpControlledWinchServiceGrpc.getReadGearP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadGearP1FMethod = getReadGearP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Gear_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Gear_p1_f"))
                  .build();
          }
        }
     }
     return getReadGearP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteGearP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_GEAR_P1_F = getWriteGearP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP1FMethod;
    if ((getWriteGearP1FMethod = PumpControlledWinchServiceGrpc.getWriteGearP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteGearP1FMethod = PumpControlledWinchServiceGrpc.getWriteGearP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteGearP1FMethod = getWriteGearP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Gear_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Gear_p1_f"))
                  .build();
          }
        }
     }
     return getWriteGearP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadGearP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_GEAR_P2_E = getReadGearP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP2EMethod;
    if ((getReadGearP2EMethod = PumpControlledWinchServiceGrpc.getReadGearP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadGearP2EMethod = PumpControlledWinchServiceGrpc.getReadGearP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadGearP2EMethod = getReadGearP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Gear_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Gear_p2_e"))
                  .build();
          }
        }
     }
     return getReadGearP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteGearP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_GEAR_P2_E = getWriteGearP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP2EMethod;
    if ((getWriteGearP2EMethod = PumpControlledWinchServiceGrpc.getWriteGearP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteGearP2EMethod = PumpControlledWinchServiceGrpc.getWriteGearP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteGearP2EMethod = getWriteGearP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Gear_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Gear_p2_e"))
                  .build();
          }
        }
     }
     return getWriteGearP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadGearP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_GEAR_P2_F = getReadGearP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearP2FMethod;
    if ((getReadGearP2FMethod = PumpControlledWinchServiceGrpc.getReadGearP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadGearP2FMethod = PumpControlledWinchServiceGrpc.getReadGearP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadGearP2FMethod = getReadGearP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Gear_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Gear_p2_f"))
                  .build();
          }
        }
     }
     return getReadGearP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteGearP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_GEAR_P2_F = getWriteGearP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearP2FMethod;
    if ((getWriteGearP2FMethod = PumpControlledWinchServiceGrpc.getWriteGearP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteGearP2FMethod = PumpControlledWinchServiceGrpc.getWriteGearP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteGearP2FMethod = getWriteGearP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Gear_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Gear_p2_f"))
                  .build();
          }
        }
     }
     return getWriteGearP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadGearGearRatioMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_GEAR_GEAR_RATIO = getReadGearGearRatioMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearGearRatioMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearGearRatioMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadGearGearRatioMethod;
    if ((getReadGearGearRatioMethod = PumpControlledWinchServiceGrpc.getReadGearGearRatioMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadGearGearRatioMethod = PumpControlledWinchServiceGrpc.getReadGearGearRatioMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadGearGearRatioMethod = getReadGearGearRatioMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Gear_GearRatio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Gear_GearRatio"))
                  .build();
          }
        }
     }
     return getReadGearGearRatioMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteGearGearRatioMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_GEAR_GEAR_RATIO = getWriteGearGearRatioMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearGearRatioMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearGearRatioMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteGearGearRatioMethod;
    if ((getWriteGearGearRatioMethod = PumpControlledWinchServiceGrpc.getWriteGearGearRatioMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteGearGearRatioMethod = PumpControlledWinchServiceGrpc.getWriteGearGearRatioMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteGearGearRatioMethod = getWriteGearGearRatioMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Gear_GearRatio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Gear_GearRatio"))
                  .build();
          }
        }
     }
     return getWriteGearGearRatioMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaInertiaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_INERTIA = getReadInertiaInertiaMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaInertiaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaInertiaMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaInertiaMethod;
    if ((getReadInertiaInertiaMethod = PumpControlledWinchServiceGrpc.getReadInertiaInertiaMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaInertiaMethod = PumpControlledWinchServiceGrpc.getReadInertiaInertiaMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaInertiaMethod = getReadInertiaInertiaMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_Inertia"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_Inertia"))
                  .build();
          }
        }
     }
     return getReadInertiaInertiaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaInertiaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_INERTIA = getWriteInertiaInertiaMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaInertiaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaInertiaMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaInertiaMethod;
    if ((getWriteInertiaInertiaMethod = PumpControlledWinchServiceGrpc.getWriteInertiaInertiaMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaInertiaMethod = PumpControlledWinchServiceGrpc.getWriteInertiaInertiaMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaInertiaMethod = getWriteInertiaInertiaMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_Inertia"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_Inertia"))
                  .build();
          }
        }
     }
     return getWriteInertiaInertiaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaDrumSpeedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_DRUM_SPEED = getReadInertiaDrumSpeedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumSpeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumSpeedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumSpeedMethod;
    if ((getReadInertiaDrumSpeedMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumSpeedMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaDrumSpeedMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumSpeedMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaDrumSpeedMethod = getReadInertiaDrumSpeedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_DrumSpeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_DrumSpeed"))
                  .build();
          }
        }
     }
     return getReadInertiaDrumSpeedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaDrumSpeedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_DRUM_SPEED = getWriteInertiaDrumSpeedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumSpeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumSpeedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumSpeedMethod;
    if ((getWriteInertiaDrumSpeedMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumSpeedMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaDrumSpeedMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumSpeedMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaDrumSpeedMethod = getWriteInertiaDrumSpeedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumSpeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_DrumSpeed"))
                  .build();
          }
        }
     }
     return getWriteInertiaDrumSpeedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaDrumAngleDegMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_DRUM_ANGLE_DEG = getReadInertiaDrumAngleDegMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleDegMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleDegMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleDegMethod;
    if ((getReadInertiaDrumAngleDegMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleDegMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaDrumAngleDegMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleDegMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleDegMethod = getReadInertiaDrumAngleDegMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_DrumAngleDeg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_DrumAngleDeg"))
                  .build();
          }
        }
     }
     return getReadInertiaDrumAngleDegMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaDrumAngleDegMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_DRUM_ANGLE_DEG = getWriteInertiaDrumAngleDegMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleDegMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleDegMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleDegMethod;
    if ((getWriteInertiaDrumAngleDegMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleDegMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaDrumAngleDegMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleDegMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleDegMethod = getWriteInertiaDrumAngleDegMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumAngleDeg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_DrumAngleDeg"))
                  .build();
          }
        }
     }
     return getWriteInertiaDrumAngleDegMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_P1_E = getReadMotorP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP1EMethod;
    if ((getReadMotorP1EMethod = PumpControlledWinchServiceGrpc.getReadMotorP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorP1EMethod = PumpControlledWinchServiceGrpc.getReadMotorP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorP1EMethod = getReadMotorP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_p1_e"))
                  .build();
          }
        }
     }
     return getReadMotorP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_P1_E = getWriteMotorP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP1EMethod;
    if ((getWriteMotorP1EMethod = PumpControlledWinchServiceGrpc.getWriteMotorP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorP1EMethod = PumpControlledWinchServiceGrpc.getWriteMotorP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorP1EMethod = getWriteMotorP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_p1_e"))
                  .build();
          }
        }
     }
     return getWriteMotorP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_P1_F = getReadMotorP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP1FMethod;
    if ((getReadMotorP1FMethod = PumpControlledWinchServiceGrpc.getReadMotorP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorP1FMethod = PumpControlledWinchServiceGrpc.getReadMotorP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorP1FMethod = getReadMotorP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_p1_f"))
                  .build();
          }
        }
     }
     return getReadMotorP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_P1_F = getWriteMotorP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP1FMethod;
    if ((getWriteMotorP1FMethod = PumpControlledWinchServiceGrpc.getWriteMotorP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorP1FMethod = PumpControlledWinchServiceGrpc.getWriteMotorP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorP1FMethod = getWriteMotorP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_p1_f"))
                  .build();
          }
        }
     }
     return getWriteMotorP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_P2_E = getReadMotorP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP2EMethod;
    if ((getReadMotorP2EMethod = PumpControlledWinchServiceGrpc.getReadMotorP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorP2EMethod = PumpControlledWinchServiceGrpc.getReadMotorP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorP2EMethod = getReadMotorP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_p2_e"))
                  .build();
          }
        }
     }
     return getReadMotorP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_P2_E = getWriteMotorP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP2EMethod;
    if ((getWriteMotorP2EMethod = PumpControlledWinchServiceGrpc.getWriteMotorP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorP2EMethod = PumpControlledWinchServiceGrpc.getWriteMotorP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorP2EMethod = getWriteMotorP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_p2_e"))
                  .build();
          }
        }
     }
     return getWriteMotorP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_P2_F = getReadMotorP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorP2FMethod;
    if ((getReadMotorP2FMethod = PumpControlledWinchServiceGrpc.getReadMotorP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorP2FMethod = PumpControlledWinchServiceGrpc.getReadMotorP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorP2FMethod = getReadMotorP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_p2_f"))
                  .build();
          }
        }
     }
     return getReadMotorP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_P2_F = getWriteMotorP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorP2FMethod;
    if ((getWriteMotorP2FMethod = PumpControlledWinchServiceGrpc.getWriteMotorP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorP2FMethod = PumpControlledWinchServiceGrpc.getWriteMotorP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorP2FMethod = getWriteMotorP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_p2_f"))
                  .build();
          }
        }
     }
     return getWriteMotorP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorMotorDisplacementMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_MOTOR_DISPLACEMENT = getReadMotorMotorDisplacementMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorDisplacementMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorDisplacementMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorDisplacementMethod;
    if ((getReadMotorMotorDisplacementMethod = PumpControlledWinchServiceGrpc.getReadMotorMotorDisplacementMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorMotorDisplacementMethod = PumpControlledWinchServiceGrpc.getReadMotorMotorDisplacementMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorMotorDisplacementMethod = getReadMotorMotorDisplacementMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_MotorDisplacement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_MotorDisplacement"))
                  .build();
          }
        }
     }
     return getReadMotorMotorDisplacementMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorMotorDisplacementMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_MOTOR_DISPLACEMENT = getWriteMotorMotorDisplacementMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorDisplacementMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorDisplacementMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorDisplacementMethod;
    if ((getWriteMotorMotorDisplacementMethod = PumpControlledWinchServiceGrpc.getWriteMotorMotorDisplacementMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorMotorDisplacementMethod = PumpControlledWinchServiceGrpc.getWriteMotorMotorDisplacementMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorMotorDisplacementMethod = getWriteMotorMotorDisplacementMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_MotorDisplacement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_MotorDisplacement"))
                  .build();
          }
        }
     }
     return getWriteMotorMotorDisplacementMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorMotorSpeedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_MOTOR_SPEED = getReadMotorMotorSpeedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorSpeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorSpeedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorSpeedMethod;
    if ((getReadMotorMotorSpeedMethod = PumpControlledWinchServiceGrpc.getReadMotorMotorSpeedMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorMotorSpeedMethod = PumpControlledWinchServiceGrpc.getReadMotorMotorSpeedMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorMotorSpeedMethod = getReadMotorMotorSpeedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_MotorSpeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_MotorSpeed"))
                  .build();
          }
        }
     }
     return getReadMotorMotorSpeedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorMotorSpeedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_MOTOR_SPEED = getWriteMotorMotorSpeedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorSpeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorSpeedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorSpeedMethod;
    if ((getWriteMotorMotorSpeedMethod = PumpControlledWinchServiceGrpc.getWriteMotorMotorSpeedMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorMotorSpeedMethod = PumpControlledWinchServiceGrpc.getWriteMotorMotorSpeedMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorMotorSpeedMethod = getWriteMotorMotorSpeedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_MotorSpeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_MotorSpeed"))
                  .build();
          }
        }
     }
     return getWriteMotorMotorSpeedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMotorMotorFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_MOTOR_MOTOR_FLOW = getReadMotorMotorFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadMotorMotorFlowMethod;
    if ((getReadMotorMotorFlowMethod = PumpControlledWinchServiceGrpc.getReadMotorMotorFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadMotorMotorFlowMethod = PumpControlledWinchServiceGrpc.getReadMotorMotorFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadMotorMotorFlowMethod = getReadMotorMotorFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Motor_MotorFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Motor_MotorFlow"))
                  .build();
          }
        }
     }
     return getReadMotorMotorFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMotorMotorFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_MOTOR_MOTOR_FLOW = getWriteMotorMotorFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteMotorMotorFlowMethod;
    if ((getWriteMotorMotorFlowMethod = PumpControlledWinchServiceGrpc.getWriteMotorMotorFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteMotorMotorFlowMethod = PumpControlledWinchServiceGrpc.getWriteMotorMotorFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteMotorMotorFlowMethod = getWriteMotorMotorFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Motor_MotorFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Motor_MotorFlow"))
                  .build();
          }
        }
     }
     return getWriteMotorMotorFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_FLOW = getReadOneJunctionFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionFlowMethod;
    if ((getReadOneJunctionFlowMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionFlowMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionFlowMethod = getReadOneJunctionFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_flow"))
                  .build();
          }
        }
     }
     return getReadOneJunctionFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_FLOW = getWriteOneJunctionFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionFlowMethod;
    if ((getWriteOneJunctionFlowMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionFlowMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionFlowMethod = getWriteOneJunctionFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_flow"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_P1_E = getReadOneJunctionP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP1EMethod;
    if ((getReadOneJunctionP1EMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionP1EMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionP1EMethod = getReadOneJunctionP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_p1_e"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P1_E = getWriteOneJunctionP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP1EMethod;
    if ((getWriteOneJunctionP1EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionP1EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionP1EMethod = getWriteOneJunctionP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_p1_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_P2_E = getReadOneJunctionP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP2EMethod;
    if ((getReadOneJunctionP2EMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionP2EMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionP2EMethod = getReadOneJunctionP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_p2_e"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P2_E = getWriteOneJunctionP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP2EMethod;
    if ((getWriteOneJunctionP2EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionP2EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionP2EMethod = getWriteOneJunctionP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_p2_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP3EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_P3_E = getReadOneJunctionP3EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP3EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP3EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP3EMethod;
    if ((getReadOneJunctionP3EMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP3EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionP3EMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP3EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionP3EMethod = getReadOneJunctionP3EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_p3_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_p3_e"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP3EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP3EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P3_E = getWriteOneJunctionP3EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP3EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP3EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP3EMethod;
    if ((getWriteOneJunctionP3EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP3EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionP3EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP3EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionP3EMethod = getWriteOneJunctionP3EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p3_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_p3_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP3EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_P1_F = getReadOneJunctionP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP1FMethod;
    if ((getReadOneJunctionP1FMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionP1FMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionP1FMethod = getReadOneJunctionP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_p1_f"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P1_F = getWriteOneJunctionP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP1FMethod;
    if ((getWriteOneJunctionP1FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionP1FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionP1FMethod = getWriteOneJunctionP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_p1_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_P2_F = getReadOneJunctionP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP2FMethod;
    if ((getReadOneJunctionP2FMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionP2FMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionP2FMethod = getReadOneJunctionP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_p2_f"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P2_F = getWriteOneJunctionP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP2FMethod;
    if ((getWriteOneJunctionP2FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionP2FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionP2FMethod = getWriteOneJunctionP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_p2_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP3FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION_P3_F = getReadOneJunctionP3FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP3FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP3FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunctionP3FMethod;
    if ((getReadOneJunctionP3FMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP3FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunctionP3FMethod = PumpControlledWinchServiceGrpc.getReadOneJunctionP3FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunctionP3FMethod = getReadOneJunctionP3FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction_p3_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction_p3_f"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP3FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP3FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P3_F = getWriteOneJunctionP3FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP3FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP3FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunctionP3FMethod;
    if ((getWriteOneJunctionP3FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP3FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunctionP3FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunctionP3FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunctionP3FMethod = getWriteOneJunctionP3FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction_p3_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction_p3_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP3FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7FlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_FLOW = getReadOneJunction7FlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7FlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7FlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7FlowMethod;
    if ((getReadOneJunction7FlowMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7FlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7FlowMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7FlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7FlowMethod = getReadOneJunction7FlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_flow"))
                  .build();
          }
        }
     }
     return getReadOneJunction7FlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7FlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_FLOW = getWriteOneJunction7FlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7FlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7FlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7FlowMethod;
    if ((getWriteOneJunction7FlowMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7FlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7FlowMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7FlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7FlowMethod = getWriteOneJunction7FlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_flow"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7FlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P1_E = getReadOneJunction7P1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P1EMethod;
    if ((getReadOneJunction7P1EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P1EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P1EMethod = getReadOneJunction7P1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p1_e"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P1_E = getWriteOneJunction7P1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P1EMethod;
    if ((getWriteOneJunction7P1EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P1EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P1EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P1EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P1EMethod = getWriteOneJunction7P1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p1_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P2_E = getReadOneJunction7P2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P2EMethod;
    if ((getReadOneJunction7P2EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P2EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P2EMethod = getReadOneJunction7P2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p2_e"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P2_E = getWriteOneJunction7P2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P2EMethod;
    if ((getWriteOneJunction7P2EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P2EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P2EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P2EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P2EMethod = getWriteOneJunction7P2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p2_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P3EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P3_E = getReadOneJunction7P3EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P3EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P3EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P3EMethod;
    if ((getReadOneJunction7P3EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P3EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P3EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P3EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P3EMethod = getReadOneJunction7P3EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p3_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p3_e"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P3EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P3EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P3_E = getWriteOneJunction7P3EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P3EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P3EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P3EMethod;
    if ((getWriteOneJunction7P3EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P3EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P3EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P3EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P3EMethod = getWriteOneJunction7P3EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p3_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p3_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P3EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P4EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P4_E = getReadOneJunction7P4EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P4EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P4EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P4EMethod;
    if ((getReadOneJunction7P4EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P4EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P4EMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P4EMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P4EMethod = getReadOneJunction7P4EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p4_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p4_e"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P4EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P4EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P4_E = getWriteOneJunction7P4EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P4EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P4EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P4EMethod;
    if ((getWriteOneJunction7P4EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P4EMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P4EMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P4EMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P4EMethod = getWriteOneJunction7P4EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p4_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p4_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P4EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P1_F = getReadOneJunction7P1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P1FMethod;
    if ((getReadOneJunction7P1FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P1FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P1FMethod = getReadOneJunction7P1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p1_f"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P1_F = getWriteOneJunction7P1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P1FMethod;
    if ((getWriteOneJunction7P1FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P1FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P1FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P1FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P1FMethod = getWriteOneJunction7P1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p1_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P2_F = getReadOneJunction7P2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P2FMethod;
    if ((getReadOneJunction7P2FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P2FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P2FMethod = getReadOneJunction7P2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p2_f"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P2_F = getWriteOneJunction7P2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P2FMethod;
    if ((getWriteOneJunction7P2FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P2FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P2FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P2FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P2FMethod = getWriteOneJunction7P2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p2_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P3FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P3_F = getReadOneJunction7P3FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P3FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P3FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P3FMethod;
    if ((getReadOneJunction7P3FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P3FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P3FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P3FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P3FMethod = getReadOneJunction7P3FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p3_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p3_f"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P3FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P3FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P3_F = getWriteOneJunction7P3FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P3FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P3FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P3FMethod;
    if ((getWriteOneJunction7P3FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P3FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P3FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P3FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P3FMethod = getWriteOneJunction7P3FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p3_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p3_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P3FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunction7P4FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_ONE_JUNCTION7_P4_F = getReadOneJunction7P4FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P4FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P4FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOneJunction7P4FMethod;
    if ((getReadOneJunction7P4FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P4FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOneJunction7P4FMethod = PumpControlledWinchServiceGrpc.getReadOneJunction7P4FMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOneJunction7P4FMethod = getReadOneJunction7P4FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OneJunction7_p4_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OneJunction7_p4_f"))
                  .build();
          }
        }
     }
     return getReadOneJunction7P4FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunction7P4FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION7_P4_F = getWriteOneJunction7P4FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P4FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P4FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOneJunction7P4FMethod;
    if ((getWriteOneJunction7P4FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P4FMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOneJunction7P4FMethod = PumpControlledWinchServiceGrpc.getWriteOneJunction7P4FMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOneJunction7P4FMethod = getWriteOneJunction7P4FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OneJunction7_p4_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OneJunction7_p4_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunction7P4FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOpenTankPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_OPEN_TANK_P_E = getReadOpenTankPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankPEMethod;
    if ((getReadOpenTankPEMethod = PumpControlledWinchServiceGrpc.getReadOpenTankPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOpenTankPEMethod = PumpControlledWinchServiceGrpc.getReadOpenTankPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOpenTankPEMethod = getReadOpenTankPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OpenTank_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OpenTank_p_e"))
                  .build();
          }
        }
     }
     return getReadOpenTankPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOpenTankPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_OPEN_TANK_P_E = getWriteOpenTankPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankPEMethod;
    if ((getWriteOpenTankPEMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOpenTankPEMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOpenTankPEMethod = getWriteOpenTankPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OpenTank_p_e"))
                  .build();
          }
        }
     }
     return getWriteOpenTankPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOpenTankPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_OPEN_TANK_P_F = getReadOpenTankPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankPFMethod;
    if ((getReadOpenTankPFMethod = PumpControlledWinchServiceGrpc.getReadOpenTankPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOpenTankPFMethod = PumpControlledWinchServiceGrpc.getReadOpenTankPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOpenTankPFMethod = getReadOpenTankPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OpenTank_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OpenTank_p_f"))
                  .build();
          }
        }
     }
     return getReadOpenTankPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOpenTankPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_OPEN_TANK_P_F = getWriteOpenTankPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankPFMethod;
    if ((getWriteOpenTankPFMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOpenTankPFMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOpenTankPFMethod = getWriteOpenTankPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OpenTank_p_f"))
                  .build();
          }
        }
     }
     return getWriteOpenTankPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOpenTankAtomPressureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_OPEN_TANK_ATOM_PRESSURE = getReadOpenTankAtomPressureMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankAtomPressureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankAtomPressureMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankAtomPressureMethod;
    if ((getReadOpenTankAtomPressureMethod = PumpControlledWinchServiceGrpc.getReadOpenTankAtomPressureMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOpenTankAtomPressureMethod = PumpControlledWinchServiceGrpc.getReadOpenTankAtomPressureMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOpenTankAtomPressureMethod = getReadOpenTankAtomPressureMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OpenTank_AtomPressure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OpenTank_AtomPressure"))
                  .build();
          }
        }
     }
     return getReadOpenTankAtomPressureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOpenTankAtomPressureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_OPEN_TANK_ATOM_PRESSURE = getWriteOpenTankAtomPressureMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankAtomPressureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankAtomPressureMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankAtomPressureMethod;
    if ((getWriteOpenTankAtomPressureMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankAtomPressureMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOpenTankAtomPressureMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankAtomPressureMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOpenTankAtomPressureMethod = getWriteOpenTankAtomPressureMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_AtomPressure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OpenTank_AtomPressure"))
                  .build();
          }
        }
     }
     return getWriteOpenTankAtomPressureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOpenTankFlow2TankMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_OPEN_TANK_FLOW2TANK = getReadOpenTankFlow2TankMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankFlow2TankMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankFlow2TankMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadOpenTankFlow2TankMethod;
    if ((getReadOpenTankFlow2TankMethod = PumpControlledWinchServiceGrpc.getReadOpenTankFlow2TankMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadOpenTankFlow2TankMethod = PumpControlledWinchServiceGrpc.getReadOpenTankFlow2TankMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadOpenTankFlow2TankMethod = getReadOpenTankFlow2TankMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_OpenTank_Flow2Tank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_OpenTank_Flow2Tank"))
                  .build();
          }
        }
     }
     return getReadOpenTankFlow2TankMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOpenTankFlow2TankMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_OPEN_TANK_FLOW2TANK = getWriteOpenTankFlow2TankMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankFlow2TankMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankFlow2TankMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteOpenTankFlow2TankMethod;
    if ((getWriteOpenTankFlow2TankMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankFlow2TankMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteOpenTankFlow2TankMethod = PumpControlledWinchServiceGrpc.getWriteOpenTankFlow2TankMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteOpenTankFlow2TankMethod = getWriteOpenTankFlow2TankMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_OpenTank_Flow2Tank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_OpenTank_Flow2Tank"))
                  .build();
          }
        }
     }
     return getWriteOpenTankFlow2TankMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_PUMP_P_E = getReadPumpPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPEMethod;
    if ((getReadPumpPEMethod = PumpControlledWinchServiceGrpc.getReadPumpPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadPumpPEMethod = PumpControlledWinchServiceGrpc.getReadPumpPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadPumpPEMethod = getReadPumpPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Pump_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Pump_p_e"))
                  .build();
          }
        }
     }
     return getReadPumpPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_P_E = getWritePumpPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPEMethod;
    if ((getWritePumpPEMethod = PumpControlledWinchServiceGrpc.getWritePumpPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWritePumpPEMethod = PumpControlledWinchServiceGrpc.getWritePumpPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getWritePumpPEMethod = getWritePumpPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Pump_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Pump_p_e"))
                  .build();
          }
        }
     }
     return getWritePumpPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_PUMP_P_F = getReadPumpPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPFMethod;
    if ((getReadPumpPFMethod = PumpControlledWinchServiceGrpc.getReadPumpPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadPumpPFMethod = PumpControlledWinchServiceGrpc.getReadPumpPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadPumpPFMethod = getReadPumpPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Pump_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Pump_p_f"))
                  .build();
          }
        }
     }
     return getReadPumpPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_P_F = getWritePumpPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPFMethod;
    if ((getWritePumpPFMethod = PumpControlledWinchServiceGrpc.getWritePumpPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWritePumpPFMethod = PumpControlledWinchServiceGrpc.getWritePumpPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getWritePumpPFMethod = getWritePumpPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Pump_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Pump_p_f"))
                  .build();
          }
        }
     }
     return getWritePumpPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpGainMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_PUMP_GAIN = getReadPumpGainMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpGainMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpGainMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpGainMethod;
    if ((getReadPumpGainMethod = PumpControlledWinchServiceGrpc.getReadPumpGainMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadPumpGainMethod = PumpControlledWinchServiceGrpc.getReadPumpGainMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadPumpGainMethod = getReadPumpGainMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Pump_gain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Pump_gain"))
                  .build();
          }
        }
     }
     return getReadPumpGainMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpGainMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_GAIN = getWritePumpGainMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpGainMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpGainMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpGainMethod;
    if ((getWritePumpGainMethod = PumpControlledWinchServiceGrpc.getWritePumpGainMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWritePumpGainMethod = PumpControlledWinchServiceGrpc.getWritePumpGainMethod) == null) {
          PumpControlledWinchServiceGrpc.getWritePumpGainMethod = getWritePumpGainMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Pump_gain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Pump_gain"))
                  .build();
          }
        }
     }
     return getWritePumpGainMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPumpPressureMaxMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_PUMP_PUMP_PRESSURE_MAX = getReadPumpPumpPressureMaxMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpPressureMaxMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpPressureMaxMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpPressureMaxMethod;
    if ((getReadPumpPumpPressureMaxMethod = PumpControlledWinchServiceGrpc.getReadPumpPumpPressureMaxMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadPumpPumpPressureMaxMethod = PumpControlledWinchServiceGrpc.getReadPumpPumpPressureMaxMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadPumpPumpPressureMaxMethod = getReadPumpPumpPressureMaxMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Pump_PumpPressureMax"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Pump_PumpPressureMax"))
                  .build();
          }
        }
     }
     return getReadPumpPumpPressureMaxMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPumpPressureMaxMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_PUMP_PRESSURE_MAX = getWritePumpPumpPressureMaxMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpPressureMaxMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpPressureMaxMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpPressureMaxMethod;
    if ((getWritePumpPumpPressureMaxMethod = PumpControlledWinchServiceGrpc.getWritePumpPumpPressureMaxMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWritePumpPumpPressureMaxMethod = PumpControlledWinchServiceGrpc.getWritePumpPumpPressureMaxMethod) == null) {
          PumpControlledWinchServiceGrpc.getWritePumpPumpPressureMaxMethod = getWritePumpPumpPressureMaxMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Pump_PumpPressureMax"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Pump_PumpPressureMax"))
                  .build();
          }
        }
     }
     return getWritePumpPumpPressureMaxMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPumpFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_PUMP_PUMP_FLOW = getReadPumpPumpFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpFlowMethod;
    if ((getReadPumpPumpFlowMethod = PumpControlledWinchServiceGrpc.getReadPumpPumpFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadPumpPumpFlowMethod = PumpControlledWinchServiceGrpc.getReadPumpPumpFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadPumpPumpFlowMethod = getReadPumpPumpFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Pump_PumpFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Pump_PumpFlow"))
                  .build();
          }
        }
     }
     return getReadPumpPumpFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPumpFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_PUMP_FLOW = getWritePumpPumpFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpFlowMethod;
    if ((getWritePumpPumpFlowMethod = PumpControlledWinchServiceGrpc.getWritePumpPumpFlowMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWritePumpPumpFlowMethod = PumpControlledWinchServiceGrpc.getWritePumpPumpFlowMethod) == null) {
          PumpControlledWinchServiceGrpc.getWritePumpPumpFlowMethod = getWritePumpPumpFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Pump_PumpFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Pump_PumpFlow"))
                  .build();
          }
        }
     }
     return getWritePumpPumpFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPumpPressureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_PUMP_PUMP_PRESSURE = getReadPumpPumpPressureMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpPressureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpPressureMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadPumpPumpPressureMethod;
    if ((getReadPumpPumpPressureMethod = PumpControlledWinchServiceGrpc.getReadPumpPumpPressureMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadPumpPumpPressureMethod = PumpControlledWinchServiceGrpc.getReadPumpPumpPressureMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadPumpPumpPressureMethod = getReadPumpPumpPressureMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Pump_PumpPressure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Pump_PumpPressure"))
                  .build();
          }
        }
     }
     return getReadPumpPumpPressureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPumpPressureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_PUMP_PRESSURE = getWritePumpPumpPressureMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpPressureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpPressureMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWritePumpPumpPressureMethod;
    if ((getWritePumpPumpPressureMethod = PumpControlledWinchServiceGrpc.getWritePumpPumpPressureMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWritePumpPumpPressureMethod = PumpControlledWinchServiceGrpc.getWritePumpPumpPressureMethod) == null) {
          PumpControlledWinchServiceGrpc.getWritePumpPumpPressureMethod = getWritePumpPumpPressureMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Pump_PumpPressure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Pump_PumpPressure"))
                  .build();
          }
        }
     }
     return getWritePumpPumpPressureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadWireFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_WIRE_F = getReadWireFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadWireFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadWireFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadWireFMethod;
    if ((getReadWireFMethod = PumpControlledWinchServiceGrpc.getReadWireFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadWireFMethod = PumpControlledWinchServiceGrpc.getReadWireFMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadWireFMethod = getReadWireFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Wire_F"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Wire_F"))
                  .build();
          }
        }
     }
     return getReadWireFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteWireFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_WIRE_F = getWriteWireFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteWireFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteWireFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteWireFMethod;
    if ((getWriteWireFMethod = PumpControlledWinchServiceGrpc.getWriteWireFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteWireFMethod = PumpControlledWinchServiceGrpc.getWriteWireFMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteWireFMethod = getWriteWireFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Wire_F"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Wire_F"))
                  .build();
          }
        }
     }
     return getWriteWireFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadWireVMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_WIRE_V = getReadWireVMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadWireVMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadWireVMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadWireVMethod;
    if ((getReadWireVMethod = PumpControlledWinchServiceGrpc.getReadWireVMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadWireVMethod = PumpControlledWinchServiceGrpc.getReadWireVMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadWireVMethod = getReadWireVMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Wire_v"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Wire_v"))
                  .build();
          }
        }
     }
     return getReadWireVMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteWireVMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_WIRE_V = getWriteWireVMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteWireVMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteWireVMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteWireVMethod;
    if ((getWriteWireVMethod = PumpControlledWinchServiceGrpc.getWriteWireVMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteWireVMethod = PumpControlledWinchServiceGrpc.getWriteWireVMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteWireVMethod = getWriteWireVMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Wire_v"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Wire_v"))
                  .build();
          }
        }
     }
     return getWriteWireVMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadSetPointMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_SET_POINT = getReadSetPointMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadSetPointMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadSetPointMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadSetPointMethod;
    if ((getReadSetPointMethod = PumpControlledWinchServiceGrpc.getReadSetPointMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadSetPointMethod = PumpControlledWinchServiceGrpc.getReadSetPointMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadSetPointMethod = getReadSetPointMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_SetPoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_SetPoint"))
                  .build();
          }
        }
     }
     return getReadSetPointMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteSetPointMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_SET_POINT = getWriteSetPointMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteSetPointMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteSetPointMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteSetPointMethod;
    if ((getWriteSetPointMethod = PumpControlledWinchServiceGrpc.getWriteSetPointMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteSetPointMethod = PumpControlledWinchServiceGrpc.getWriteSetPointMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteSetPointMethod = getWriteSetPointMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_SetPoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_SetPoint"))
                  .build();
          }
        }
     }
     return getWriteSetPointMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerUIStateDotMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_U_I_STATE_DOT = getReadControllerUIStateDotMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateDotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateDotMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateDotMethod;
    if ((getReadControllerUIStateDotMethod = PumpControlledWinchServiceGrpc.getReadControllerUIStateDotMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerUIStateDotMethod = PumpControlledWinchServiceGrpc.getReadControllerUIStateDotMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerUIStateDotMethod = getReadControllerUIStateDotMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_uI_state_dot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_uI_state_dot"))
                  .build();
          }
        }
     }
     return getReadControllerUIStateDotMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerUIStateDotMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_U_I_STATE_DOT = getWriteControllerUIStateDotMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateDotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateDotMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateDotMethod;
    if ((getWriteControllerUIStateDotMethod = PumpControlledWinchServiceGrpc.getWriteControllerUIStateDotMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerUIStateDotMethod = PumpControlledWinchServiceGrpc.getWriteControllerUIStateDotMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerUIStateDotMethod = getWriteControllerUIStateDotMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_uI_state_dot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_uI_state_dot"))
                  .build();
          }
        }
     }
     return getWriteControllerUIStateDotMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerUIStateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_U_I_STATE = getReadControllerUIStateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateMethod;
    if ((getReadControllerUIStateMethod = PumpControlledWinchServiceGrpc.getReadControllerUIStateMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerUIStateMethod = PumpControlledWinchServiceGrpc.getReadControllerUIStateMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerUIStateMethod = getReadControllerUIStateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_uI_state"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_uI_state"))
                  .build();
          }
        }
     }
     return getReadControllerUIStateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerUIStateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_U_I_STATE = getWriteControllerUIStateMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateMethod;
    if ((getWriteControllerUIStateMethod = PumpControlledWinchServiceGrpc.getWriteControllerUIStateMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerUIStateMethod = PumpControlledWinchServiceGrpc.getWriteControllerUIStateMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerUIStateMethod = getWriteControllerUIStateMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_uI_state"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_uI_state"))
                  .build();
          }
        }
     }
     return getWriteControllerUIStateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadControllerUIStateInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_CONTROLLER_U_I_STATE_INITIAL = getReadControllerUIStateInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadControllerUIStateInitialMethod;
    if ((getReadControllerUIStateInitialMethod = PumpControlledWinchServiceGrpc.getReadControllerUIStateInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadControllerUIStateInitialMethod = PumpControlledWinchServiceGrpc.getReadControllerUIStateInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadControllerUIStateInitialMethod = getReadControllerUIStateInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Controller_uI_state_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Controller_uI_state_initial"))
                  .build();
          }
        }
     }
     return getReadControllerUIStateInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteControllerUIStateInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_CONTROLLER_U_I_STATE_INITIAL = getWriteControllerUIStateInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteControllerUIStateInitialMethod;
    if ((getWriteControllerUIStateInitialMethod = PumpControlledWinchServiceGrpc.getWriteControllerUIStateInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteControllerUIStateInitialMethod = PumpControlledWinchServiceGrpc.getWriteControllerUIStateInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteControllerUIStateInitialMethod = getWriteControllerUIStateInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Controller_uI_state_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Controller_uI_state_initial"))
                  .build();
          }
        }
     }
     return getWriteControllerUIStateInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_P_E = getReadInertiaPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaPEMethod;
    if ((getReadInertiaPEMethod = PumpControlledWinchServiceGrpc.getReadInertiaPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaPEMethod = PumpControlledWinchServiceGrpc.getReadInertiaPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaPEMethod = getReadInertiaPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_p_e"))
                  .build();
          }
        }
     }
     return getReadInertiaPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_P_E = getWriteInertiaPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaPEMethod;
    if ((getWriteInertiaPEMethod = PumpControlledWinchServiceGrpc.getWriteInertiaPEMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaPEMethod = PumpControlledWinchServiceGrpc.getWriteInertiaPEMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaPEMethod = getWriteInertiaPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_p_e"))
                  .build();
          }
        }
     }
     return getWriteInertiaPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaMomentumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_MOMENTUM = getReadInertiaMomentumMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaMomentumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaMomentumMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaMomentumMethod;
    if ((getReadInertiaMomentumMethod = PumpControlledWinchServiceGrpc.getReadInertiaMomentumMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaMomentumMethod = PumpControlledWinchServiceGrpc.getReadInertiaMomentumMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaMomentumMethod = getReadInertiaMomentumMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_momentum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_momentum"))
                  .build();
          }
        }
     }
     return getReadInertiaMomentumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaMomentumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_MOMENTUM = getWriteInertiaMomentumMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaMomentumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaMomentumMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaMomentumMethod;
    if ((getWriteInertiaMomentumMethod = PumpControlledWinchServiceGrpc.getWriteInertiaMomentumMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaMomentumMethod = PumpControlledWinchServiceGrpc.getWriteInertiaMomentumMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaMomentumMethod = getWriteInertiaMomentumMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_momentum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_momentum"))
                  .build();
          }
        }
     }
     return getWriteInertiaMomentumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaMomentumInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_MOMENTUM_INITIAL = getReadInertiaMomentumInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaMomentumInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaMomentumInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaMomentumInitialMethod;
    if ((getReadInertiaMomentumInitialMethod = PumpControlledWinchServiceGrpc.getReadInertiaMomentumInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaMomentumInitialMethod = PumpControlledWinchServiceGrpc.getReadInertiaMomentumInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaMomentumInitialMethod = getReadInertiaMomentumInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_momentum_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_momentum_initial"))
                  .build();
          }
        }
     }
     return getReadInertiaMomentumInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaMomentumInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_MOMENTUM_INITIAL = getWriteInertiaMomentumInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaMomentumInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaMomentumInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaMomentumInitialMethod;
    if ((getWriteInertiaMomentumInitialMethod = PumpControlledWinchServiceGrpc.getWriteInertiaMomentumInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaMomentumInitialMethod = PumpControlledWinchServiceGrpc.getWriteInertiaMomentumInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaMomentumInitialMethod = getWriteInertiaMomentumInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_momentum_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_momentum_initial"))
                  .build();
          }
        }
     }
     return getWriteInertiaMomentumInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_P_F = getReadInertiaPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaPFMethod;
    if ((getReadInertiaPFMethod = PumpControlledWinchServiceGrpc.getReadInertiaPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaPFMethod = PumpControlledWinchServiceGrpc.getReadInertiaPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaPFMethod = getReadInertiaPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_p_f"))
                  .build();
          }
        }
     }
     return getReadInertiaPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_P_F = getWriteInertiaPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaPFMethod;
    if ((getWriteInertiaPFMethod = PumpControlledWinchServiceGrpc.getWriteInertiaPFMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaPFMethod = PumpControlledWinchServiceGrpc.getWriteInertiaPFMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaPFMethod = getWriteInertiaPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_p_f"))
                  .build();
          }
        }
     }
     return getWriteInertiaPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaDrumAngleMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_DRUM_ANGLE = getReadInertiaDrumAngleMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleMethod;
    if ((getReadInertiaDrumAngleMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaDrumAngleMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleMethod = getReadInertiaDrumAngleMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_DrumAngle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_DrumAngle"))
                  .build();
          }
        }
     }
     return getReadInertiaDrumAngleMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaDrumAngleMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_DRUM_ANGLE = getWriteInertiaDrumAngleMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleMethod;
    if ((getWriteInertiaDrumAngleMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaDrumAngleMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleMethod = getWriteInertiaDrumAngleMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumAngle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_DrumAngle"))
                  .build();
          }
        }
     }
     return getWriteInertiaDrumAngleMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadInertiaDrumAngleInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> METHOD_READ_INERTIA_DRUM_ANGLE_INITIAL = getReadInertiaDrumAngleInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> getReadInertiaDrumAngleInitialMethod;
    if ((getReadInertiaDrumAngleInitialMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getReadInertiaDrumAngleInitialMethod = PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getReadInertiaDrumAngleInitialMethod = getReadInertiaDrumAngleInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Read_Inertia_DrumAngle_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Read_Inertia_DrumAngle_initial"))
                  .build();
          }
        }
     }
     return getReadInertiaDrumAngleInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteInertiaDrumAngleInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> METHOD_WRITE_INERTIA_DRUM_ANGLE_INITIAL = getWriteInertiaDrumAngleInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
      no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> getWriteInertiaDrumAngleInitialMethod;
    if ((getWriteInertiaDrumAngleInitialMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleInitialMethod) == null) {
      synchronized (PumpControlledWinchServiceGrpc.class) {
        if ((getWriteInertiaDrumAngleInitialMethod = PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleInitialMethod) == null) {
          PumpControlledWinchServiceGrpc.getWriteInertiaDrumAngleInitialMethod = getWriteInertiaDrumAngleInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite, no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.grpc_fmu.PumpControlledWinchService", "Write_Inertia_DrumAngle_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new PumpControlledWinchServiceMethodDescriptorSupplier("Write_Inertia_DrumAngle_initial"))
                  .build();
          }
        }
     }
     return getWriteInertiaDrumAngleInitialMethod;
  }

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
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PumpControlledWinchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PumpControlledWinchServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PumpControlledWinchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void readControllerSP(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerSPMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerSP(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerSPMethod(), responseObserver);
    }

    /**
     */
    public void readControllerMV(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerMVMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerMV(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerMVMethod(), responseObserver);
    }

    /**
     */
    public void readControllerOutput(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerOutputMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerOutput(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerOutputMethod(), responseObserver);
    }

    /**
     */
    public void readControllerK(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerKMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerK(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerKMethod(), responseObserver);
    }

    /**
     */
    public void readControllerTi(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerTiMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerTi(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerTiMethod(), responseObserver);
    }

    /**
     */
    public void readControllerB(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerBMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerB(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerBMethod(), responseObserver);
    }

    /**
     */
    public void readControllerTa(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerTaMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerTa(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerTaMethod(), responseObserver);
    }

    /**
     */
    public void readControllerMinimum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerMinimumMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerMinimum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerMinimumMethod(), responseObserver);
    }

    /**
     */
    public void readControllerMaximum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerMaximumMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerMaximum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerMaximumMethod(), responseObserver);
    }

    /**
     */
    public void readControllerOutputInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerOutputInitialMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerOutputInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerOutputInitialMethod(), responseObserver);
    }

    /**
     */
    public void readControllerError(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerErrorMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerError(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerErrorMethod(), responseObserver);
    }

    /**
     */
    public void readControllerPBLow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerPBLowMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerPBLow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerPBLowMethod(), responseObserver);
    }

    /**
     */
    public void readControllerPBHigh(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerPBHighMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerPBHigh(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerPBHighMethod(), responseObserver);
    }

    /**
     */
    public void readDrumP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrumP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeDrumP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrumP1EMethod(), responseObserver);
    }

    /**
     */
    public void readDrumP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrumP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeDrumP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrumP1FMethod(), responseObserver);
    }

    /**
     */
    public void readDrumP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrumP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeDrumP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrumP2EMethod(), responseObserver);
    }

    /**
     */
    public void readDrumP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrumP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeDrumP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrumP2FMethod(), responseObserver);
    }

    /**
     */
    public void readDrumDrumDiameter(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrumDrumDiameterMethod(), responseObserver);
    }

    /**
     */
    public void writeDrumDrumDiameter(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrumDrumDiameterMethod(), responseObserver);
    }

    /**
     */
    public void readFlowSensorP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFlowSensorP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeFlowSensorP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFlowSensorP1EMethod(), responseObserver);
    }

    /**
     */
    public void readFlowSensorP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFlowSensorP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeFlowSensorP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFlowSensorP1FMethod(), responseObserver);
    }

    /**
     */
    public void readFlowSensorP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFlowSensorP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeFlowSensorP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFlowSensorP2FMethod(), responseObserver);
    }

    /**
     */
    public void readFlowSensorP2V(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFlowSensorP2VMethod(), responseObserver);
    }

    /**
     */
    public void writeFlowSensorP2V(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFlowSensorP2VMethod(), responseObserver);
    }

    /**
     */
    public void readFlowSensorFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFlowSensorFlowMethod(), responseObserver);
    }

    /**
     */
    public void writeFlowSensorFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFlowSensorFlowMethod(), responseObserver);
    }

    /**
     */
    public void readFrictionPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFrictionPEMethod(), responseObserver);
    }

    /**
     */
    public void writeFrictionPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFrictionPEMethod(), responseObserver);
    }

    /**
     */
    public void readFrictionPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFrictionPFMethod(), responseObserver);
    }

    /**
     */
    public void writeFrictionPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFrictionPFMethod(), responseObserver);
    }

    /**
     */
    public void readFrictionF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFrictionFMethod(), responseObserver);
    }

    /**
     */
    public void writeFrictionF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFrictionFMethod(), responseObserver);
    }

    /**
     */
    public void readFrictionLoadMass(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFrictionLoadMassMethod(), responseObserver);
    }

    /**
     */
    public void writeFrictionLoadMass(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFrictionLoadMassMethod(), responseObserver);
    }

    /**
     */
    public void readGearP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadGearP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeGearP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteGearP1EMethod(), responseObserver);
    }

    /**
     */
    public void readGearP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadGearP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeGearP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteGearP1FMethod(), responseObserver);
    }

    /**
     */
    public void readGearP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadGearP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeGearP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteGearP2EMethod(), responseObserver);
    }

    /**
     */
    public void readGearP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadGearP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeGearP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteGearP2FMethod(), responseObserver);
    }

    /**
     */
    public void readGearGearRatio(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadGearGearRatioMethod(), responseObserver);
    }

    /**
     */
    public void writeGearGearRatio(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteGearGearRatioMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaInertia(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaInertiaMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaInertia(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaInertiaMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaDrumSpeed(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaDrumSpeedMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaDrumSpeed(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaDrumSpeedMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaDrumAngleDeg(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaDrumAngleDegMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaDrumAngleDeg(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaDrumAngleDegMethod(), responseObserver);
    }

    /**
     */
    public void readMotorP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorP1EMethod(), responseObserver);
    }

    /**
     */
    public void readMotorP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorP1FMethod(), responseObserver);
    }

    /**
     */
    public void readMotorP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorP2EMethod(), responseObserver);
    }

    /**
     */
    public void readMotorP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorP2FMethod(), responseObserver);
    }

    /**
     */
    public void readMotorMotorDisplacement(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorMotorDisplacementMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorMotorDisplacement(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorMotorDisplacementMethod(), responseObserver);
    }

    /**
     */
    public void readMotorMotorSpeed(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorMotorSpeedMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorMotorSpeed(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorMotorSpeedMethod(), responseObserver);
    }

    /**
     */
    public void readMotorMotorFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMotorMotorFlowMethod(), responseObserver);
    }

    /**
     */
    public void writeMotorMotorFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMotorMotorFlowMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionFlowMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionFlowMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP1EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP2EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP3E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP3EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP3EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP1FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP2FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP3F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP3FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP3FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7Flow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7FlowMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7Flow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7FlowMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P1EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P1EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P2EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P2EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P3E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P3EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P3E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P3EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P4E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P4EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P4E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P4EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P1FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P1FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P2FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P2FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P3F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P3FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P3F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P3FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunction7P4F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunction7P4FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunction7P4F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunction7P4FMethod(), responseObserver);
    }

    /**
     */
    public void readOpenTankPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOpenTankPEMethod(), responseObserver);
    }

    /**
     */
    public void writeOpenTankPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOpenTankPEMethod(), responseObserver);
    }

    /**
     */
    public void readOpenTankPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOpenTankPFMethod(), responseObserver);
    }

    /**
     */
    public void writeOpenTankPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOpenTankPFMethod(), responseObserver);
    }

    /**
     */
    public void readOpenTankAtomPressure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOpenTankAtomPressureMethod(), responseObserver);
    }

    /**
     */
    public void writeOpenTankAtomPressure(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOpenTankAtomPressureMethod(), responseObserver);
    }

    /**
     */
    public void readOpenTankFlow2Tank(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOpenTankFlow2TankMethod(), responseObserver);
    }

    /**
     */
    public void writeOpenTankFlow2Tank(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOpenTankFlow2TankMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPEMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPEMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPFMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPFMethod(), responseObserver);
    }

    /**
     */
    public void readPumpGain(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpGainMethod(), responseObserver);
    }

    /**
     */
    public void writePumpGain(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpGainMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPumpPressureMax(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPumpPressureMaxMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPumpPressureMax(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPumpPressureMaxMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPumpFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPumpFlowMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPumpFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPumpFlowMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPumpPressure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPumpPressureMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPumpPressure(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPumpPressureMethod(), responseObserver);
    }

    /**
     */
    public void readWireF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadWireFMethod(), responseObserver);
    }

    /**
     */
    public void writeWireF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteWireFMethod(), responseObserver);
    }

    /**
     */
    public void readWireV(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadWireVMethod(), responseObserver);
    }

    /**
     */
    public void writeWireV(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteWireVMethod(), responseObserver);
    }

    /**
     */
    public void readSetPoint(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadSetPointMethod(), responseObserver);
    }

    /**
     */
    public void writeSetPoint(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteSetPointMethod(), responseObserver);
    }

    /**
     */
    public void readControllerUIStateDot(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerUIStateDotMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerUIStateDot(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerUIStateDotMethod(), responseObserver);
    }

    /**
     */
    public void readControllerUIState(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerUIStateMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerUIState(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerUIStateMethod(), responseObserver);
    }

    /**
     */
    public void readControllerUIStateInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadControllerUIStateInitialMethod(), responseObserver);
    }

    /**
     */
    public void writeControllerUIStateInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteControllerUIStateInitialMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaPEMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaPEMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaMomentum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaMomentumMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaMomentum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaMomentumMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaMomentumInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaMomentumInitialMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaMomentumInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaMomentumInitialMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaPFMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaPFMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaDrumAngle(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaDrumAngleMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaDrumAngle(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaDrumAngleMethod(), responseObserver);
    }

    /**
     */
    public void readInertiaDrumAngleInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnimplementedUnaryCall(getReadInertiaDrumAngleInitialMethod(), responseObserver);
    }

    /**
     */
    public void writeInertiaDrumAngleInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteInertiaDrumAngleInitialMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReadControllerSPMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_SP)))
          .addMethod(
            getWriteControllerSPMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_SP)))
          .addMethod(
            getReadControllerMVMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_MV)))
          .addMethod(
            getWriteControllerMVMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_MV)))
          .addMethod(
            getReadControllerOutputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_OUTPUT)))
          .addMethod(
            getWriteControllerOutputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_OUTPUT)))
          .addMethod(
            getReadControllerKMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_K)))
          .addMethod(
            getWriteControllerKMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_K)))
          .addMethod(
            getReadControllerTiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_TI)))
          .addMethod(
            getWriteControllerTiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_TI)))
          .addMethod(
            getReadControllerBMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_B)))
          .addMethod(
            getWriteControllerBMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_B)))
          .addMethod(
            getReadControllerTaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_TA)))
          .addMethod(
            getWriteControllerTaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_TA)))
          .addMethod(
            getReadControllerMinimumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_MINIMUM)))
          .addMethod(
            getWriteControllerMinimumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_MINIMUM)))
          .addMethod(
            getReadControllerMaximumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_MAXIMUM)))
          .addMethod(
            getWriteControllerMaximumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_MAXIMUM)))
          .addMethod(
            getReadControllerOutputInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_OUTPUT_INITIAL)))
          .addMethod(
            getWriteControllerOutputInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_OUTPUT_INITIAL)))
          .addMethod(
            getReadControllerErrorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_ERROR)))
          .addMethod(
            getWriteControllerErrorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_ERROR)))
          .addMethod(
            getReadControllerPBLowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_PB_LOW)))
          .addMethod(
            getWriteControllerPBLowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_PB_LOW)))
          .addMethod(
            getReadControllerPBHighMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_PB_HIGH)))
          .addMethod(
            getWriteControllerPBHighMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_PB_HIGH)))
          .addMethod(
            getReadDrumP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_DRUM_P1_E)))
          .addMethod(
            getWriteDrumP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRUM_P1_E)))
          .addMethod(
            getReadDrumP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_DRUM_P1_F)))
          .addMethod(
            getWriteDrumP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRUM_P1_F)))
          .addMethod(
            getReadDrumP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_DRUM_P2_E)))
          .addMethod(
            getWriteDrumP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRUM_P2_E)))
          .addMethod(
            getReadDrumP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_DRUM_P2_F)))
          .addMethod(
            getWriteDrumP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRUM_P2_F)))
          .addMethod(
            getReadDrumDrumDiameterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_DRUM_DRUM_DIAMETER)))
          .addMethod(
            getWriteDrumDrumDiameterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRUM_DRUM_DIAMETER)))
          .addMethod(
            getReadFlowSensorP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FLOW_SENSOR_P1_E)))
          .addMethod(
            getWriteFlowSensorP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FLOW_SENSOR_P1_E)))
          .addMethod(
            getReadFlowSensorP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FLOW_SENSOR_P1_F)))
          .addMethod(
            getWriteFlowSensorP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FLOW_SENSOR_P1_F)))
          .addMethod(
            getReadFlowSensorP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FLOW_SENSOR_P2_F)))
          .addMethod(
            getWriteFlowSensorP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FLOW_SENSOR_P2_F)))
          .addMethod(
            getReadFlowSensorP2VMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FLOW_SENSOR_P2_V)))
          .addMethod(
            getWriteFlowSensorP2VMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FLOW_SENSOR_P2_V)))
          .addMethod(
            getReadFlowSensorFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FLOW_SENSOR_FLOW)))
          .addMethod(
            getWriteFlowSensorFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FLOW_SENSOR_FLOW)))
          .addMethod(
            getReadFrictionPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FRICTION_P_E)))
          .addMethod(
            getWriteFrictionPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FRICTION_P_E)))
          .addMethod(
            getReadFrictionPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FRICTION_P_F)))
          .addMethod(
            getWriteFrictionPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FRICTION_P_F)))
          .addMethod(
            getReadFrictionFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FRICTION_F)))
          .addMethod(
            getWriteFrictionFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FRICTION_F)))
          .addMethod(
            getReadFrictionLoadMassMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_FRICTION_LOAD_MASS)))
          .addMethod(
            getWriteFrictionLoadMassMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FRICTION_LOAD_MASS)))
          .addMethod(
            getReadGearP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_GEAR_P1_E)))
          .addMethod(
            getWriteGearP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_GEAR_P1_E)))
          .addMethod(
            getReadGearP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_GEAR_P1_F)))
          .addMethod(
            getWriteGearP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_GEAR_P1_F)))
          .addMethod(
            getReadGearP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_GEAR_P2_E)))
          .addMethod(
            getWriteGearP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_GEAR_P2_E)))
          .addMethod(
            getReadGearP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_GEAR_P2_F)))
          .addMethod(
            getWriteGearP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_GEAR_P2_F)))
          .addMethod(
            getReadGearGearRatioMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_GEAR_GEAR_RATIO)))
          .addMethod(
            getWriteGearGearRatioMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_GEAR_GEAR_RATIO)))
          .addMethod(
            getReadInertiaInertiaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_INERTIA)))
          .addMethod(
            getWriteInertiaInertiaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_INERTIA)))
          .addMethod(
            getReadInertiaDrumSpeedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_DRUM_SPEED)))
          .addMethod(
            getWriteInertiaDrumSpeedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_DRUM_SPEED)))
          .addMethod(
            getReadInertiaDrumAngleDegMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_DRUM_ANGLE_DEG)))
          .addMethod(
            getWriteInertiaDrumAngleDegMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_DRUM_ANGLE_DEG)))
          .addMethod(
            getReadMotorP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_P1_E)))
          .addMethod(
            getWriteMotorP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_P1_E)))
          .addMethod(
            getReadMotorP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_P1_F)))
          .addMethod(
            getWriteMotorP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_P1_F)))
          .addMethod(
            getReadMotorP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_P2_E)))
          .addMethod(
            getWriteMotorP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_P2_E)))
          .addMethod(
            getReadMotorP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_P2_F)))
          .addMethod(
            getWriteMotorP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_P2_F)))
          .addMethod(
            getReadMotorMotorDisplacementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_MOTOR_DISPLACEMENT)))
          .addMethod(
            getWriteMotorMotorDisplacementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_MOTOR_DISPLACEMENT)))
          .addMethod(
            getReadMotorMotorSpeedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_MOTOR_SPEED)))
          .addMethod(
            getWriteMotorMotorSpeedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_MOTOR_SPEED)))
          .addMethod(
            getReadMotorMotorFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_MOTOR_MOTOR_FLOW)))
          .addMethod(
            getWriteMotorMotorFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_MOTOR_MOTOR_FLOW)))
          .addMethod(
            getReadOneJunctionFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_FLOW)))
          .addMethod(
            getWriteOneJunctionFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_FLOW)))
          .addMethod(
            getReadOneJunctionP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_P1_E)))
          .addMethod(
            getWriteOneJunctionP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P1_E)))
          .addMethod(
            getReadOneJunctionP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_P2_E)))
          .addMethod(
            getWriteOneJunctionP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P2_E)))
          .addMethod(
            getReadOneJunctionP3EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_P3_E)))
          .addMethod(
            getWriteOneJunctionP3EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P3_E)))
          .addMethod(
            getReadOneJunctionP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_P1_F)))
          .addMethod(
            getWriteOneJunctionP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P1_F)))
          .addMethod(
            getReadOneJunctionP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_P2_F)))
          .addMethod(
            getWriteOneJunctionP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P2_F)))
          .addMethod(
            getReadOneJunctionP3FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION_P3_F)))
          .addMethod(
            getWriteOneJunctionP3FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P3_F)))
          .addMethod(
            getReadOneJunction7FlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_FLOW)))
          .addMethod(
            getWriteOneJunction7FlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_FLOW)))
          .addMethod(
            getReadOneJunction7P1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P1_E)))
          .addMethod(
            getWriteOneJunction7P1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P1_E)))
          .addMethod(
            getReadOneJunction7P2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P2_E)))
          .addMethod(
            getWriteOneJunction7P2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P2_E)))
          .addMethod(
            getReadOneJunction7P3EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P3_E)))
          .addMethod(
            getWriteOneJunction7P3EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P3_E)))
          .addMethod(
            getReadOneJunction7P4EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P4_E)))
          .addMethod(
            getWriteOneJunction7P4EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P4_E)))
          .addMethod(
            getReadOneJunction7P1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P1_F)))
          .addMethod(
            getWriteOneJunction7P1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P1_F)))
          .addMethod(
            getReadOneJunction7P2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P2_F)))
          .addMethod(
            getWriteOneJunction7P2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P2_F)))
          .addMethod(
            getReadOneJunction7P3FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P3_F)))
          .addMethod(
            getWriteOneJunction7P3FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P3_F)))
          .addMethod(
            getReadOneJunction7P4FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_ONE_JUNCTION7_P4_F)))
          .addMethod(
            getWriteOneJunction7P4FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION7_P4_F)))
          .addMethod(
            getReadOpenTankPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_OPEN_TANK_P_E)))
          .addMethod(
            getWriteOpenTankPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_OPEN_TANK_P_E)))
          .addMethod(
            getReadOpenTankPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_OPEN_TANK_P_F)))
          .addMethod(
            getWriteOpenTankPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_OPEN_TANK_P_F)))
          .addMethod(
            getReadOpenTankAtomPressureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_OPEN_TANK_ATOM_PRESSURE)))
          .addMethod(
            getWriteOpenTankAtomPressureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_OPEN_TANK_ATOM_PRESSURE)))
          .addMethod(
            getReadOpenTankFlow2TankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_OPEN_TANK_FLOW2TANK)))
          .addMethod(
            getWriteOpenTankFlow2TankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_OPEN_TANK_FLOW2TANK)))
          .addMethod(
            getReadPumpPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_PUMP_P_E)))
          .addMethod(
            getWritePumpPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_P_E)))
          .addMethod(
            getReadPumpPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_PUMP_P_F)))
          .addMethod(
            getWritePumpPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_P_F)))
          .addMethod(
            getReadPumpGainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_PUMP_GAIN)))
          .addMethod(
            getWritePumpGainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_GAIN)))
          .addMethod(
            getReadPumpPumpPressureMaxMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_PUMP_PUMP_PRESSURE_MAX)))
          .addMethod(
            getWritePumpPumpPressureMaxMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_PUMP_PRESSURE_MAX)))
          .addMethod(
            getReadPumpPumpFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_PUMP_PUMP_FLOW)))
          .addMethod(
            getWritePumpPumpFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_PUMP_FLOW)))
          .addMethod(
            getReadPumpPumpPressureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_PUMP_PUMP_PRESSURE)))
          .addMethod(
            getWritePumpPumpPressureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_PUMP_PRESSURE)))
          .addMethod(
            getReadWireFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_WIRE_F)))
          .addMethod(
            getWriteWireFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_WIRE_F)))
          .addMethod(
            getReadWireVMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_WIRE_V)))
          .addMethod(
            getWriteWireVMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_WIRE_V)))
          .addMethod(
            getReadSetPointMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_SET_POINT)))
          .addMethod(
            getWriteSetPointMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_SET_POINT)))
          .addMethod(
            getReadControllerUIStateDotMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_U_I_STATE_DOT)))
          .addMethod(
            getWriteControllerUIStateDotMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_U_I_STATE_DOT)))
          .addMethod(
            getReadControllerUIStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_U_I_STATE)))
          .addMethod(
            getWriteControllerUIStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_U_I_STATE)))
          .addMethod(
            getReadControllerUIStateInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_CONTROLLER_U_I_STATE_INITIAL)))
          .addMethod(
            getWriteControllerUIStateInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONTROLLER_U_I_STATE_INITIAL)))
          .addMethod(
            getReadInertiaPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_P_E)))
          .addMethod(
            getWriteInertiaPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_P_E)))
          .addMethod(
            getReadInertiaMomentumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_MOMENTUM)))
          .addMethod(
            getWriteInertiaMomentumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_MOMENTUM)))
          .addMethod(
            getReadInertiaMomentumInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_MOMENTUM_INITIAL)))
          .addMethod(
            getWriteInertiaMomentumInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_MOMENTUM_INITIAL)))
          .addMethod(
            getReadInertiaPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_P_F)))
          .addMethod(
            getWriteInertiaPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_P_F)))
          .addMethod(
            getReadInertiaDrumAngleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_DRUM_ANGLE)))
          .addMethod(
            getWriteInertiaDrumAngleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_DRUM_ANGLE)))
          .addMethod(
            getReadInertiaDrumAngleInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>(
                  this, METHODID_READ_INERTIA_DRUM_ANGLE_INITIAL)))
          .addMethod(
            getWriteInertiaDrumAngleInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite,
                no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INERTIA_DRUM_ANGLE_INITIAL)))
          .build();
    }
  }

  /**
   */
  public static final class PumpControlledWinchServiceStub extends io.grpc.stub.AbstractStub<PumpControlledWinchServiceStub> {
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

    /**
     */
    public void readControllerSP(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerSPMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerSP(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerSPMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerMV(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerMVMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerMV(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerMVMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerOutput(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerOutputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerOutput(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerOutputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerK(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerKMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerK(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerKMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerTi(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerTiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerTi(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerTiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerB(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerBMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerB(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerBMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerTa(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerTaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerTa(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerTaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerMinimum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerMinimumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerMinimum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerMinimumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerMaximum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerMaximumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerMaximum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerMaximumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerOutputInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerOutputInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerOutputInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerOutputInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerError(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerErrorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerError(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerErrorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerPBLow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerPBLowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerPBLow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerPBLowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerPBHigh(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerPBHighMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerPBHigh(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerPBHighMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrumP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrumP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrumP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrumP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrumP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrumP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrumP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrumP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrumP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrumP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrumP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrumP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrumP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrumP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrumP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrumP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrumDrumDiameter(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrumDrumDiameterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrumDrumDiameter(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrumDrumDiameterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFlowSensorP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFlowSensorP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFlowSensorP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFlowSensorP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFlowSensorP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFlowSensorP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFlowSensorP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFlowSensorP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFlowSensorP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFlowSensorP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFlowSensorP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFlowSensorP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFlowSensorP2V(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFlowSensorP2VMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFlowSensorP2V(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFlowSensorP2VMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFlowSensorFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFlowSensorFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFlowSensorFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFlowSensorFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFrictionPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFrictionPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFrictionPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFrictionPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFrictionPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFrictionPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFrictionPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFrictionPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFrictionF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFrictionFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFrictionF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFrictionFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFrictionLoadMass(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFrictionLoadMassMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFrictionLoadMass(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFrictionLoadMassMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readGearP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadGearP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeGearP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteGearP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readGearP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadGearP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeGearP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteGearP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readGearP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadGearP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeGearP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteGearP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readGearP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadGearP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeGearP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteGearP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readGearGearRatio(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadGearGearRatioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeGearGearRatio(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteGearGearRatioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaInertia(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaInertiaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaInertia(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaInertiaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaDrumSpeed(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaDrumSpeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaDrumSpeed(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaDrumSpeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaDrumAngleDeg(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaDrumAngleDegMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaDrumAngleDeg(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaDrumAngleDegMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorMotorDisplacement(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorMotorDisplacementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorMotorDisplacement(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorMotorDisplacementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorMotorSpeed(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorMotorSpeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorMotorSpeed(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorMotorSpeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMotorMotorFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMotorMotorFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMotorMotorFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMotorMotorFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP3E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP3EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP3F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP3FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7Flow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7FlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7Flow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7FlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P3E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P3EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P3E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P3EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P4E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P4EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P4E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P4EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P3F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P3FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P3F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P3FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunction7P4F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunction7P4FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunction7P4F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunction7P4FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOpenTankPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOpenTankPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOpenTankPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOpenTankPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOpenTankPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOpenTankPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOpenTankPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOpenTankPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOpenTankAtomPressure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOpenTankAtomPressureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOpenTankAtomPressure(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOpenTankAtomPressureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOpenTankFlow2Tank(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOpenTankFlow2TankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOpenTankFlow2Tank(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOpenTankFlow2TankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpGain(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpGainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpGain(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpGainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPumpPressureMax(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPumpPressureMaxMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPumpPressureMax(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPumpPressureMaxMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPumpFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPumpFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPumpFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPumpFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPumpPressure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPumpPressureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPumpPressure(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPumpPressureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readWireF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadWireFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeWireF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteWireFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readWireV(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadWireVMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeWireV(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteWireVMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readSetPoint(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadSetPointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeSetPoint(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteSetPointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerUIStateDot(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerUIStateDotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerUIStateDot(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerUIStateDotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerUIState(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerUIStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerUIState(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerUIStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readControllerUIStateInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadControllerUIStateInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeControllerUIStateInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteControllerUIStateInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaMomentum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaMomentumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaMomentum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaMomentumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaMomentumInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaMomentumInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaMomentumInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaMomentumInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaDrumAngle(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaDrumAngleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaDrumAngle(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaDrumAngleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readInertiaDrumAngleInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadInertiaDrumAngleInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeInertiaDrumAngleInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteInertiaDrumAngleInitialMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PumpControlledWinchServiceBlockingStub extends io.grpc.stub.AbstractStub<PumpControlledWinchServiceBlockingStub> {
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

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerSP(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerSPMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerSP(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerSPMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerMV(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerMVMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerMV(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerMVMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerOutput(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerOutputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerOutput(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerOutputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerK(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerKMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerK(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerKMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerTi(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerTiMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerTi(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerTiMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerB(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerBMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerB(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerBMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerTa(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerTaMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerTa(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerTaMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerMinimum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerMinimumMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerMinimum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerMinimumMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerMaximum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerMaximumMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerMaximum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerMaximumMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerOutputInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerOutputInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerOutputInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerOutputInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerError(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerErrorMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerError(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerErrorMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerPBLow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerPBLowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerPBLow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerPBLowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerPBHigh(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerPBHighMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerPBHigh(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerPBHighMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readDrumP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrumP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeDrumP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrumP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readDrumP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrumP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeDrumP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrumP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readDrumP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrumP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeDrumP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrumP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readDrumP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrumP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeDrumP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrumP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readDrumDrumDiameter(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrumDrumDiameterMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeDrumDrumDiameter(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrumDrumDiameterMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFlowSensorP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFlowSensorP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFlowSensorP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFlowSensorP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFlowSensorP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFlowSensorP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFlowSensorP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFlowSensorP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFlowSensorP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFlowSensorP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFlowSensorP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFlowSensorP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFlowSensorP2V(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFlowSensorP2VMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFlowSensorP2V(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFlowSensorP2VMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFlowSensorFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFlowSensorFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFlowSensorFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFlowSensorFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFrictionPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFrictionPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFrictionPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFrictionPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFrictionPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFrictionPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFrictionPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFrictionPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFrictionF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFrictionFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFrictionF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFrictionFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readFrictionLoadMass(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFrictionLoadMassMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeFrictionLoadMass(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFrictionLoadMassMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readGearP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadGearP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeGearP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteGearP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readGearP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadGearP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeGearP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteGearP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readGearP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadGearP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeGearP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteGearP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readGearP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadGearP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeGearP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteGearP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readGearGearRatio(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadGearGearRatioMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeGearGearRatio(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteGearGearRatioMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaInertia(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaInertiaMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaInertia(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaInertiaMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaDrumSpeed(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaDrumSpeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaDrumSpeed(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaDrumSpeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaDrumAngleDeg(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaDrumAngleDegMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaDrumAngleDeg(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaDrumAngleDegMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorMotorDisplacement(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorMotorDisplacementMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorMotorDisplacement(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorMotorDisplacementMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorMotorSpeed(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorMotorSpeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorMotorSpeed(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorMotorSpeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readMotorMotorFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadMotorMotorFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeMotorMotorFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteMotorMotorFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionP1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionP1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionP2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionP2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionP3E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP3EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionP3E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP3EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionP1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionP1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionP2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionP2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunctionP3F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP3FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunctionP3F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP3FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7Flow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7FlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7Flow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7FlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P1E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P1E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P2E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P2E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P3E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P3EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P3E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P3EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P4E(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P4EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P4E(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P4EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P1F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P1F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P2F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P2F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P3F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P3FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P3F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P3FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOneJunction7P4F(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunction7P4FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOneJunction7P4F(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunction7P4FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOpenTankPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOpenTankPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOpenTankPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOpenTankPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOpenTankPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOpenTankPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOpenTankPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOpenTankPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOpenTankAtomPressure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOpenTankAtomPressureMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOpenTankAtomPressure(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOpenTankAtomPressureMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readOpenTankFlow2Tank(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOpenTankFlow2TankMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeOpenTankFlow2Tank(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOpenTankFlow2TankMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readPumpPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writePumpPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readPumpPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writePumpPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readPumpGain(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpGainMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writePumpGain(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpGainMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readPumpPumpPressureMax(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPumpPressureMaxMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writePumpPumpPressureMax(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPumpPressureMaxMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readPumpPumpFlow(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPumpFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writePumpPumpFlow(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPumpFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readPumpPumpPressure(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPumpPressureMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writePumpPumpPressure(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPumpPressureMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readWireF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadWireFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeWireF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteWireFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readWireV(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadWireVMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeWireV(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteWireVMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readSetPoint(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadSetPointMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeSetPoint(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteSetPointMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerUIStateDot(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerUIStateDotMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerUIStateDot(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerUIStateDotMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerUIState(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerUIStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerUIState(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerUIStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readControllerUIStateInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadControllerUIStateInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeControllerUIStateInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteControllerUIStateInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaPE(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaPE(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaMomentum(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaMomentumMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaMomentum(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaMomentumMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaMomentumInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaMomentumInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaMomentumInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaMomentumInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaPF(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaPF(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaDrumAngle(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaDrumAngleMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaDrumAngle(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaDrumAngleMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real readInertiaDrumAngleInitial(no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadInertiaDrumAngleInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status writeInertiaDrumAngleInitial(no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteInertiaDrumAngleInitialMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PumpControlledWinchServiceFutureStub extends io.grpc.stub.AbstractStub<PumpControlledWinchServiceFutureStub> {
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerSP(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerSPMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerSP(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerSPMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerMV(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerMVMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerMV(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerMVMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerOutput(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerOutputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerOutput(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerOutputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerK(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerKMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerK(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerKMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerTi(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerTiMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerTi(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerTiMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerB(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerBMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerB(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerBMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerTa(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerTaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerTa(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerTaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerMinimum(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerMinimumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerMinimum(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerMinimumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerMaximum(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerMaximumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerMaximum(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerMaximumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerOutputInitial(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerOutputInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerOutputInitial(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerOutputInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerError(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerErrorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerError(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerErrorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerPBLow(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerPBLowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerPBLow(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerPBLowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerPBHigh(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerPBHighMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerPBHigh(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerPBHighMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readDrumP1E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrumP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeDrumP1E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrumP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readDrumP1F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrumP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeDrumP1F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrumP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readDrumP2E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrumP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeDrumP2E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrumP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readDrumP2F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrumP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeDrumP2F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrumP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readDrumDrumDiameter(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrumDrumDiameterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeDrumDrumDiameter(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrumDrumDiameterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFlowSensorP1E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFlowSensorP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFlowSensorP1E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFlowSensorP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFlowSensorP1F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFlowSensorP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFlowSensorP1F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFlowSensorP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFlowSensorP2F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFlowSensorP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFlowSensorP2F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFlowSensorP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFlowSensorP2V(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFlowSensorP2VMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFlowSensorP2V(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFlowSensorP2VMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFlowSensorFlow(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFlowSensorFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFlowSensorFlow(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFlowSensorFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFrictionPE(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFrictionPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFrictionPE(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFrictionPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFrictionPF(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFrictionPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFrictionPF(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFrictionPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFrictionF(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFrictionFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFrictionF(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFrictionFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readFrictionLoadMass(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFrictionLoadMassMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeFrictionLoadMass(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFrictionLoadMassMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readGearP1E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadGearP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeGearP1E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteGearP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readGearP1F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadGearP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeGearP1F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteGearP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readGearP2E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadGearP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeGearP2E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteGearP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readGearP2F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadGearP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeGearP2F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteGearP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readGearGearRatio(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadGearGearRatioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeGearGearRatio(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteGearGearRatioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaInertia(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaInertiaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaInertia(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaInertiaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaDrumSpeed(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaDrumSpeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaDrumSpeed(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaDrumSpeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaDrumAngleDeg(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaDrumAngleDegMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaDrumAngleDeg(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaDrumAngleDegMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorP1E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorP1E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorP1F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorP1F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorP2E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorP2E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorP2F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorP2F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorMotorDisplacement(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorMotorDisplacementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorMotorDisplacement(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorMotorDisplacementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorMotorSpeed(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorMotorSpeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorMotorSpeed(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorMotorSpeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readMotorMotorFlow(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMotorMotorFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeMotorMotorFlow(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMotorMotorFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionFlow(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionFlow(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionP1E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionP1E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionP2E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionP2E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionP3E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP3EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionP3E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionP1F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionP1F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionP2F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionP2F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunctionP3F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP3FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunctionP3F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7Flow(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7FlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7Flow(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7FlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P1E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P1E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P2E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P2E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P3E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P3EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P3E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P3EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P4E(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P4EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P4E(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P4EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P1F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P1F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P2F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P2F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P3F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P3FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P3F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P3FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOneJunction7P4F(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunction7P4FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOneJunction7P4F(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunction7P4FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOpenTankPE(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOpenTankPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOpenTankPE(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOpenTankPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOpenTankPF(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOpenTankPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOpenTankPF(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOpenTankPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOpenTankAtomPressure(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOpenTankAtomPressureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOpenTankAtomPressure(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOpenTankAtomPressureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readOpenTankFlow2Tank(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOpenTankFlow2TankMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeOpenTankFlow2Tank(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOpenTankFlow2TankMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readPumpPE(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writePumpPE(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readPumpPF(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writePumpPF(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readPumpGain(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpGainMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writePumpGain(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpGainMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readPumpPumpPressureMax(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPumpPressureMaxMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writePumpPumpPressureMax(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPumpPressureMaxMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readPumpPumpFlow(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPumpFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writePumpPumpFlow(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPumpFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readPumpPumpPressure(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPumpPressureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writePumpPumpPressure(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPumpPressureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readWireF(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadWireFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeWireF(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteWireFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readWireV(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadWireVMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeWireV(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteWireVMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readSetPoint(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadSetPointMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeSetPoint(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteSetPointMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerUIStateDot(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerUIStateDotMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerUIStateDot(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerUIStateDotMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerUIState(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerUIStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerUIState(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerUIStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readControllerUIStateInitial(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadControllerUIStateInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeControllerUIStateInitial(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteControllerUIStateInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaPE(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaPE(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaMomentum(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaMomentumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaMomentum(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaMomentumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaMomentumInitial(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaMomentumInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaMomentumInitial(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaMomentumInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaPF(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaPF(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaDrumAngle(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaDrumAngleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaDrumAngle(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaDrumAngleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real> readInertiaDrumAngleInitial(
        no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadInertiaDrumAngleInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status> writeInertiaDrumAngleInitial(
        no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteInertiaDrumAngleInitialMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_CONTROLLER_SP = 0;
  private static final int METHODID_WRITE_CONTROLLER_SP = 1;
  private static final int METHODID_READ_CONTROLLER_MV = 2;
  private static final int METHODID_WRITE_CONTROLLER_MV = 3;
  private static final int METHODID_READ_CONTROLLER_OUTPUT = 4;
  private static final int METHODID_WRITE_CONTROLLER_OUTPUT = 5;
  private static final int METHODID_READ_CONTROLLER_K = 6;
  private static final int METHODID_WRITE_CONTROLLER_K = 7;
  private static final int METHODID_READ_CONTROLLER_TI = 8;
  private static final int METHODID_WRITE_CONTROLLER_TI = 9;
  private static final int METHODID_READ_CONTROLLER_B = 10;
  private static final int METHODID_WRITE_CONTROLLER_B = 11;
  private static final int METHODID_READ_CONTROLLER_TA = 12;
  private static final int METHODID_WRITE_CONTROLLER_TA = 13;
  private static final int METHODID_READ_CONTROLLER_MINIMUM = 14;
  private static final int METHODID_WRITE_CONTROLLER_MINIMUM = 15;
  private static final int METHODID_READ_CONTROLLER_MAXIMUM = 16;
  private static final int METHODID_WRITE_CONTROLLER_MAXIMUM = 17;
  private static final int METHODID_READ_CONTROLLER_OUTPUT_INITIAL = 18;
  private static final int METHODID_WRITE_CONTROLLER_OUTPUT_INITIAL = 19;
  private static final int METHODID_READ_CONTROLLER_ERROR = 20;
  private static final int METHODID_WRITE_CONTROLLER_ERROR = 21;
  private static final int METHODID_READ_CONTROLLER_PB_LOW = 22;
  private static final int METHODID_WRITE_CONTROLLER_PB_LOW = 23;
  private static final int METHODID_READ_CONTROLLER_PB_HIGH = 24;
  private static final int METHODID_WRITE_CONTROLLER_PB_HIGH = 25;
  private static final int METHODID_READ_DRUM_P1_E = 26;
  private static final int METHODID_WRITE_DRUM_P1_E = 27;
  private static final int METHODID_READ_DRUM_P1_F = 28;
  private static final int METHODID_WRITE_DRUM_P1_F = 29;
  private static final int METHODID_READ_DRUM_P2_E = 30;
  private static final int METHODID_WRITE_DRUM_P2_E = 31;
  private static final int METHODID_READ_DRUM_P2_F = 32;
  private static final int METHODID_WRITE_DRUM_P2_F = 33;
  private static final int METHODID_READ_DRUM_DRUM_DIAMETER = 34;
  private static final int METHODID_WRITE_DRUM_DRUM_DIAMETER = 35;
  private static final int METHODID_READ_FLOW_SENSOR_P1_E = 36;
  private static final int METHODID_WRITE_FLOW_SENSOR_P1_E = 37;
  private static final int METHODID_READ_FLOW_SENSOR_P1_F = 38;
  private static final int METHODID_WRITE_FLOW_SENSOR_P1_F = 39;
  private static final int METHODID_READ_FLOW_SENSOR_P2_F = 40;
  private static final int METHODID_WRITE_FLOW_SENSOR_P2_F = 41;
  private static final int METHODID_READ_FLOW_SENSOR_P2_V = 42;
  private static final int METHODID_WRITE_FLOW_SENSOR_P2_V = 43;
  private static final int METHODID_READ_FLOW_SENSOR_FLOW = 44;
  private static final int METHODID_WRITE_FLOW_SENSOR_FLOW = 45;
  private static final int METHODID_READ_FRICTION_P_E = 46;
  private static final int METHODID_WRITE_FRICTION_P_E = 47;
  private static final int METHODID_READ_FRICTION_P_F = 48;
  private static final int METHODID_WRITE_FRICTION_P_F = 49;
  private static final int METHODID_READ_FRICTION_F = 50;
  private static final int METHODID_WRITE_FRICTION_F = 51;
  private static final int METHODID_READ_FRICTION_LOAD_MASS = 52;
  private static final int METHODID_WRITE_FRICTION_LOAD_MASS = 53;
  private static final int METHODID_READ_GEAR_P1_E = 54;
  private static final int METHODID_WRITE_GEAR_P1_E = 55;
  private static final int METHODID_READ_GEAR_P1_F = 56;
  private static final int METHODID_WRITE_GEAR_P1_F = 57;
  private static final int METHODID_READ_GEAR_P2_E = 58;
  private static final int METHODID_WRITE_GEAR_P2_E = 59;
  private static final int METHODID_READ_GEAR_P2_F = 60;
  private static final int METHODID_WRITE_GEAR_P2_F = 61;
  private static final int METHODID_READ_GEAR_GEAR_RATIO = 62;
  private static final int METHODID_WRITE_GEAR_GEAR_RATIO = 63;
  private static final int METHODID_READ_INERTIA_INERTIA = 64;
  private static final int METHODID_WRITE_INERTIA_INERTIA = 65;
  private static final int METHODID_READ_INERTIA_DRUM_SPEED = 66;
  private static final int METHODID_WRITE_INERTIA_DRUM_SPEED = 67;
  private static final int METHODID_READ_INERTIA_DRUM_ANGLE_DEG = 68;
  private static final int METHODID_WRITE_INERTIA_DRUM_ANGLE_DEG = 69;
  private static final int METHODID_READ_MOTOR_P1_E = 70;
  private static final int METHODID_WRITE_MOTOR_P1_E = 71;
  private static final int METHODID_READ_MOTOR_P1_F = 72;
  private static final int METHODID_WRITE_MOTOR_P1_F = 73;
  private static final int METHODID_READ_MOTOR_P2_E = 74;
  private static final int METHODID_WRITE_MOTOR_P2_E = 75;
  private static final int METHODID_READ_MOTOR_P2_F = 76;
  private static final int METHODID_WRITE_MOTOR_P2_F = 77;
  private static final int METHODID_READ_MOTOR_MOTOR_DISPLACEMENT = 78;
  private static final int METHODID_WRITE_MOTOR_MOTOR_DISPLACEMENT = 79;
  private static final int METHODID_READ_MOTOR_MOTOR_SPEED = 80;
  private static final int METHODID_WRITE_MOTOR_MOTOR_SPEED = 81;
  private static final int METHODID_READ_MOTOR_MOTOR_FLOW = 82;
  private static final int METHODID_WRITE_MOTOR_MOTOR_FLOW = 83;
  private static final int METHODID_READ_ONE_JUNCTION_FLOW = 84;
  private static final int METHODID_WRITE_ONE_JUNCTION_FLOW = 85;
  private static final int METHODID_READ_ONE_JUNCTION_P1_E = 86;
  private static final int METHODID_WRITE_ONE_JUNCTION_P1_E = 87;
  private static final int METHODID_READ_ONE_JUNCTION_P2_E = 88;
  private static final int METHODID_WRITE_ONE_JUNCTION_P2_E = 89;
  private static final int METHODID_READ_ONE_JUNCTION_P3_E = 90;
  private static final int METHODID_WRITE_ONE_JUNCTION_P3_E = 91;
  private static final int METHODID_READ_ONE_JUNCTION_P1_F = 92;
  private static final int METHODID_WRITE_ONE_JUNCTION_P1_F = 93;
  private static final int METHODID_READ_ONE_JUNCTION_P2_F = 94;
  private static final int METHODID_WRITE_ONE_JUNCTION_P2_F = 95;
  private static final int METHODID_READ_ONE_JUNCTION_P3_F = 96;
  private static final int METHODID_WRITE_ONE_JUNCTION_P3_F = 97;
  private static final int METHODID_READ_ONE_JUNCTION7_FLOW = 98;
  private static final int METHODID_WRITE_ONE_JUNCTION7_FLOW = 99;
  private static final int METHODID_READ_ONE_JUNCTION7_P1_E = 100;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P1_E = 101;
  private static final int METHODID_READ_ONE_JUNCTION7_P2_E = 102;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P2_E = 103;
  private static final int METHODID_READ_ONE_JUNCTION7_P3_E = 104;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P3_E = 105;
  private static final int METHODID_READ_ONE_JUNCTION7_P4_E = 106;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P4_E = 107;
  private static final int METHODID_READ_ONE_JUNCTION7_P1_F = 108;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P1_F = 109;
  private static final int METHODID_READ_ONE_JUNCTION7_P2_F = 110;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P2_F = 111;
  private static final int METHODID_READ_ONE_JUNCTION7_P3_F = 112;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P3_F = 113;
  private static final int METHODID_READ_ONE_JUNCTION7_P4_F = 114;
  private static final int METHODID_WRITE_ONE_JUNCTION7_P4_F = 115;
  private static final int METHODID_READ_OPEN_TANK_P_E = 116;
  private static final int METHODID_WRITE_OPEN_TANK_P_E = 117;
  private static final int METHODID_READ_OPEN_TANK_P_F = 118;
  private static final int METHODID_WRITE_OPEN_TANK_P_F = 119;
  private static final int METHODID_READ_OPEN_TANK_ATOM_PRESSURE = 120;
  private static final int METHODID_WRITE_OPEN_TANK_ATOM_PRESSURE = 121;
  private static final int METHODID_READ_OPEN_TANK_FLOW2TANK = 122;
  private static final int METHODID_WRITE_OPEN_TANK_FLOW2TANK = 123;
  private static final int METHODID_READ_PUMP_P_E = 124;
  private static final int METHODID_WRITE_PUMP_P_E = 125;
  private static final int METHODID_READ_PUMP_P_F = 126;
  private static final int METHODID_WRITE_PUMP_P_F = 127;
  private static final int METHODID_READ_PUMP_GAIN = 128;
  private static final int METHODID_WRITE_PUMP_GAIN = 129;
  private static final int METHODID_READ_PUMP_PUMP_PRESSURE_MAX = 130;
  private static final int METHODID_WRITE_PUMP_PUMP_PRESSURE_MAX = 131;
  private static final int METHODID_READ_PUMP_PUMP_FLOW = 132;
  private static final int METHODID_WRITE_PUMP_PUMP_FLOW = 133;
  private static final int METHODID_READ_PUMP_PUMP_PRESSURE = 134;
  private static final int METHODID_WRITE_PUMP_PUMP_PRESSURE = 135;
  private static final int METHODID_READ_WIRE_F = 136;
  private static final int METHODID_WRITE_WIRE_F = 137;
  private static final int METHODID_READ_WIRE_V = 138;
  private static final int METHODID_WRITE_WIRE_V = 139;
  private static final int METHODID_READ_SET_POINT = 140;
  private static final int METHODID_WRITE_SET_POINT = 141;
  private static final int METHODID_READ_CONTROLLER_U_I_STATE_DOT = 142;
  private static final int METHODID_WRITE_CONTROLLER_U_I_STATE_DOT = 143;
  private static final int METHODID_READ_CONTROLLER_U_I_STATE = 144;
  private static final int METHODID_WRITE_CONTROLLER_U_I_STATE = 145;
  private static final int METHODID_READ_CONTROLLER_U_I_STATE_INITIAL = 146;
  private static final int METHODID_WRITE_CONTROLLER_U_I_STATE_INITIAL = 147;
  private static final int METHODID_READ_INERTIA_P_E = 148;
  private static final int METHODID_WRITE_INERTIA_P_E = 149;
  private static final int METHODID_READ_INERTIA_MOMENTUM = 150;
  private static final int METHODID_WRITE_INERTIA_MOMENTUM = 151;
  private static final int METHODID_READ_INERTIA_MOMENTUM_INITIAL = 152;
  private static final int METHODID_WRITE_INERTIA_MOMENTUM_INITIAL = 153;
  private static final int METHODID_READ_INERTIA_P_F = 154;
  private static final int METHODID_WRITE_INERTIA_P_F = 155;
  private static final int METHODID_READ_INERTIA_DRUM_ANGLE = 156;
  private static final int METHODID_WRITE_INERTIA_DRUM_ANGLE = 157;
  private static final int METHODID_READ_INERTIA_DRUM_ANGLE_INITIAL = 158;
  private static final int METHODID_WRITE_INERTIA_DRUM_ANGLE_INITIAL = 159;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PumpControlledWinchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PumpControlledWinchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READ_CONTROLLER_SP:
          serviceImpl.readControllerSP((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_SP:
          serviceImpl.writeControllerSP((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_MV:
          serviceImpl.readControllerMV((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_MV:
          serviceImpl.writeControllerMV((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_OUTPUT:
          serviceImpl.readControllerOutput((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_OUTPUT:
          serviceImpl.writeControllerOutput((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_K:
          serviceImpl.readControllerK((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_K:
          serviceImpl.writeControllerK((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_TI:
          serviceImpl.readControllerTi((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_TI:
          serviceImpl.writeControllerTi((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_B:
          serviceImpl.readControllerB((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_B:
          serviceImpl.writeControllerB((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_TA:
          serviceImpl.readControllerTa((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_TA:
          serviceImpl.writeControllerTa((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_MINIMUM:
          serviceImpl.readControllerMinimum((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_MINIMUM:
          serviceImpl.writeControllerMinimum((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_MAXIMUM:
          serviceImpl.readControllerMaximum((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_MAXIMUM:
          serviceImpl.writeControllerMaximum((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_OUTPUT_INITIAL:
          serviceImpl.readControllerOutputInitial((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_OUTPUT_INITIAL:
          serviceImpl.writeControllerOutputInitial((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_ERROR:
          serviceImpl.readControllerError((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_ERROR:
          serviceImpl.writeControllerError((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_PB_LOW:
          serviceImpl.readControllerPBLow((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_PB_LOW:
          serviceImpl.writeControllerPBLow((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_PB_HIGH:
          serviceImpl.readControllerPBHigh((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_PB_HIGH:
          serviceImpl.writeControllerPBHigh((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P1_E:
          serviceImpl.readDrumP1E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P1_E:
          serviceImpl.writeDrumP1E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P1_F:
          serviceImpl.readDrumP1F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P1_F:
          serviceImpl.writeDrumP1F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P2_E:
          serviceImpl.readDrumP2E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P2_E:
          serviceImpl.writeDrumP2E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_P2_F:
          serviceImpl.readDrumP2F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_P2_F:
          serviceImpl.writeDrumP2F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRUM_DRUM_DIAMETER:
          serviceImpl.readDrumDrumDiameter((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_DRUM_DRUM_DIAMETER:
          serviceImpl.writeDrumDrumDiameter((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P1_E:
          serviceImpl.readFlowSensorP1E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P1_E:
          serviceImpl.writeFlowSensorP1E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P1_F:
          serviceImpl.readFlowSensorP1F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P1_F:
          serviceImpl.writeFlowSensorP1F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P2_F:
          serviceImpl.readFlowSensorP2F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P2_F:
          serviceImpl.writeFlowSensorP2F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_P2_V:
          serviceImpl.readFlowSensorP2V((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_P2_V:
          serviceImpl.writeFlowSensorP2V((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_SENSOR_FLOW:
          serviceImpl.readFlowSensorFlow((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_SENSOR_FLOW:
          serviceImpl.writeFlowSensorFlow((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_P_E:
          serviceImpl.readFrictionPE((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_P_E:
          serviceImpl.writeFrictionPE((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_P_F:
          serviceImpl.readFrictionPF((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_P_F:
          serviceImpl.writeFrictionPF((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_F:
          serviceImpl.readFrictionF((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_F:
          serviceImpl.writeFrictionF((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FRICTION_LOAD_MASS:
          serviceImpl.readFrictionLoadMass((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_FRICTION_LOAD_MASS:
          serviceImpl.writeFrictionLoadMass((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P1_E:
          serviceImpl.readGearP1E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P1_E:
          serviceImpl.writeGearP1E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P1_F:
          serviceImpl.readGearP1F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P1_F:
          serviceImpl.writeGearP1F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P2_E:
          serviceImpl.readGearP2E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P2_E:
          serviceImpl.writeGearP2E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_P2_F:
          serviceImpl.readGearP2F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_P2_F:
          serviceImpl.writeGearP2F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_GEAR_GEAR_RATIO:
          serviceImpl.readGearGearRatio((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_GEAR_GEAR_RATIO:
          serviceImpl.writeGearGearRatio((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_INERTIA:
          serviceImpl.readInertiaInertia((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_INERTIA:
          serviceImpl.writeInertiaInertia((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_SPEED:
          serviceImpl.readInertiaDrumSpeed((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_SPEED:
          serviceImpl.writeInertiaDrumSpeed((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_ANGLE_DEG:
          serviceImpl.readInertiaDrumAngleDeg((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_ANGLE_DEG:
          serviceImpl.writeInertiaDrumAngleDeg((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P1_E:
          serviceImpl.readMotorP1E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P1_E:
          serviceImpl.writeMotorP1E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P1_F:
          serviceImpl.readMotorP1F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P1_F:
          serviceImpl.writeMotorP1F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P2_E:
          serviceImpl.readMotorP2E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P2_E:
          serviceImpl.writeMotorP2E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_P2_F:
          serviceImpl.readMotorP2F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_P2_F:
          serviceImpl.writeMotorP2F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_MOTOR_DISPLACEMENT:
          serviceImpl.readMotorMotorDisplacement((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_MOTOR_DISPLACEMENT:
          serviceImpl.writeMotorMotorDisplacement((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_MOTOR_SPEED:
          serviceImpl.readMotorMotorSpeed((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_MOTOR_SPEED:
          serviceImpl.writeMotorMotorSpeed((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_MOTOR_MOTOR_FLOW:
          serviceImpl.readMotorMotorFlow((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_MOTOR_MOTOR_FLOW:
          serviceImpl.writeMotorMotorFlow((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_FLOW:
          serviceImpl.readOneJunctionFlow((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_FLOW:
          serviceImpl.writeOneJunctionFlow((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P1_E:
          serviceImpl.readOneJunctionP1E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P1_E:
          serviceImpl.writeOneJunctionP1E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P2_E:
          serviceImpl.readOneJunctionP2E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P2_E:
          serviceImpl.writeOneJunctionP2E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P3_E:
          serviceImpl.readOneJunctionP3E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P3_E:
          serviceImpl.writeOneJunctionP3E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P1_F:
          serviceImpl.readOneJunctionP1F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P1_F:
          serviceImpl.writeOneJunctionP1F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P2_F:
          serviceImpl.readOneJunctionP2F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P2_F:
          serviceImpl.writeOneJunctionP2F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P3_F:
          serviceImpl.readOneJunctionP3F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P3_F:
          serviceImpl.writeOneJunctionP3F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_FLOW:
          serviceImpl.readOneJunction7Flow((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_FLOW:
          serviceImpl.writeOneJunction7Flow((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P1_E:
          serviceImpl.readOneJunction7P1E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P1_E:
          serviceImpl.writeOneJunction7P1E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P2_E:
          serviceImpl.readOneJunction7P2E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P2_E:
          serviceImpl.writeOneJunction7P2E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P3_E:
          serviceImpl.readOneJunction7P3E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P3_E:
          serviceImpl.writeOneJunction7P3E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P4_E:
          serviceImpl.readOneJunction7P4E((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P4_E:
          serviceImpl.writeOneJunction7P4E((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P1_F:
          serviceImpl.readOneJunction7P1F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P1_F:
          serviceImpl.writeOneJunction7P1F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P2_F:
          serviceImpl.readOneJunction7P2F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P2_F:
          serviceImpl.writeOneJunction7P2F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P3_F:
          serviceImpl.readOneJunction7P3F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P3_F:
          serviceImpl.writeOneJunction7P3F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION7_P4_F:
          serviceImpl.readOneJunction7P4F((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION7_P4_F:
          serviceImpl.writeOneJunction7P4F((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_P_E:
          serviceImpl.readOpenTankPE((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_P_E:
          serviceImpl.writeOpenTankPE((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_P_F:
          serviceImpl.readOpenTankPF((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_P_F:
          serviceImpl.writeOpenTankPF((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_ATOM_PRESSURE:
          serviceImpl.readOpenTankAtomPressure((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_ATOM_PRESSURE:
          serviceImpl.writeOpenTankAtomPressure((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_OPEN_TANK_FLOW2TANK:
          serviceImpl.readOpenTankFlow2Tank((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_OPEN_TANK_FLOW2TANK:
          serviceImpl.writeOpenTankFlow2Tank((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_P_E:
          serviceImpl.readPumpPE((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_P_E:
          serviceImpl.writePumpPE((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_P_F:
          serviceImpl.readPumpPF((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_P_F:
          serviceImpl.writePumpPF((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_GAIN:
          serviceImpl.readPumpGain((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_GAIN:
          serviceImpl.writePumpGain((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PUMP_PRESSURE_MAX:
          serviceImpl.readPumpPumpPressureMax((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PUMP_PRESSURE_MAX:
          serviceImpl.writePumpPumpPressureMax((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PUMP_FLOW:
          serviceImpl.readPumpPumpFlow((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PUMP_FLOW:
          serviceImpl.writePumpPumpFlow((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PUMP_PRESSURE:
          serviceImpl.readPumpPumpPressure((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PUMP_PRESSURE:
          serviceImpl.writePumpPumpPressure((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_WIRE_F:
          serviceImpl.readWireF((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_WIRE_F:
          serviceImpl.writeWireF((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_WIRE_V:
          serviceImpl.readWireV((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_WIRE_V:
          serviceImpl.writeWireV((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_SET_POINT:
          serviceImpl.readSetPoint((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_SET_POINT:
          serviceImpl.writeSetPoint((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_U_I_STATE_DOT:
          serviceImpl.readControllerUIStateDot((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_U_I_STATE_DOT:
          serviceImpl.writeControllerUIStateDot((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_U_I_STATE:
          serviceImpl.readControllerUIState((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_U_I_STATE:
          serviceImpl.writeControllerUIState((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONTROLLER_U_I_STATE_INITIAL:
          serviceImpl.readControllerUIStateInitial((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_CONTROLLER_U_I_STATE_INITIAL:
          serviceImpl.writeControllerUIStateInitial((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_P_E:
          serviceImpl.readInertiaPE((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_P_E:
          serviceImpl.writeInertiaPE((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_MOMENTUM:
          serviceImpl.readInertiaMomentum((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_MOMENTUM:
          serviceImpl.writeInertiaMomentum((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_MOMENTUM_INITIAL:
          serviceImpl.readInertiaMomentumInitial((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_MOMENTUM_INITIAL:
          serviceImpl.writeInertiaMomentumInitial((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_P_F:
          serviceImpl.readInertiaPF((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_P_F:
          serviceImpl.writeInertiaPF((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_ANGLE:
          serviceImpl.readInertiaDrumAngle((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_ANGLE:
          serviceImpl.writeInertiaDrumAngle((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INERTIA_DRUM_ANGLE_INITIAL:
          serviceImpl.readInertiaDrumAngleInitial((no.mechatronics.sfi.grpc_fmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.grpc_fmu.FmiDefinitions.Real>) responseObserver);
          break;
        case METHODID_WRITE_INERTIA_DRUM_ANGLE_INITIAL:
          serviceImpl.writeInertiaDrumAngleInitial((no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.RealWrite) request,
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

  private static abstract class PumpControlledWinchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PumpControlledWinchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return no.mechatronics.sfi.grpc_fmu.PumpControlledWinchProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PumpControlledWinchService");
    }
  }

  private static final class PumpControlledWinchServiceFileDescriptorSupplier
      extends PumpControlledWinchServiceBaseDescriptorSupplier {
    PumpControlledWinchServiceFileDescriptorSupplier() {}
  }

  private static final class PumpControlledWinchServiceMethodDescriptorSupplier
      extends PumpControlledWinchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PumpControlledWinchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PumpControlledWinchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PumpControlledWinchServiceFileDescriptorSupplier())
              .addMethod(getReadControllerSPMethod())
              .addMethod(getWriteControllerSPMethod())
              .addMethod(getReadControllerMVMethod())
              .addMethod(getWriteControllerMVMethod())
              .addMethod(getReadControllerOutputMethod())
              .addMethod(getWriteControllerOutputMethod())
              .addMethod(getReadControllerKMethod())
              .addMethod(getWriteControllerKMethod())
              .addMethod(getReadControllerTiMethod())
              .addMethod(getWriteControllerTiMethod())
              .addMethod(getReadControllerBMethod())
              .addMethod(getWriteControllerBMethod())
              .addMethod(getReadControllerTaMethod())
              .addMethod(getWriteControllerTaMethod())
              .addMethod(getReadControllerMinimumMethod())
              .addMethod(getWriteControllerMinimumMethod())
              .addMethod(getReadControllerMaximumMethod())
              .addMethod(getWriteControllerMaximumMethod())
              .addMethod(getReadControllerOutputInitialMethod())
              .addMethod(getWriteControllerOutputInitialMethod())
              .addMethod(getReadControllerErrorMethod())
              .addMethod(getWriteControllerErrorMethod())
              .addMethod(getReadControllerPBLowMethod())
              .addMethod(getWriteControllerPBLowMethod())
              .addMethod(getReadControllerPBHighMethod())
              .addMethod(getWriteControllerPBHighMethod())
              .addMethod(getReadDrumP1EMethod())
              .addMethod(getWriteDrumP1EMethod())
              .addMethod(getReadDrumP1FMethod())
              .addMethod(getWriteDrumP1FMethod())
              .addMethod(getReadDrumP2EMethod())
              .addMethod(getWriteDrumP2EMethod())
              .addMethod(getReadDrumP2FMethod())
              .addMethod(getWriteDrumP2FMethod())
              .addMethod(getReadDrumDrumDiameterMethod())
              .addMethod(getWriteDrumDrumDiameterMethod())
              .addMethod(getReadFlowSensorP1EMethod())
              .addMethod(getWriteFlowSensorP1EMethod())
              .addMethod(getReadFlowSensorP1FMethod())
              .addMethod(getWriteFlowSensorP1FMethod())
              .addMethod(getReadFlowSensorP2FMethod())
              .addMethod(getWriteFlowSensorP2FMethod())
              .addMethod(getReadFlowSensorP2VMethod())
              .addMethod(getWriteFlowSensorP2VMethod())
              .addMethod(getReadFlowSensorFlowMethod())
              .addMethod(getWriteFlowSensorFlowMethod())
              .addMethod(getReadFrictionPEMethod())
              .addMethod(getWriteFrictionPEMethod())
              .addMethod(getReadFrictionPFMethod())
              .addMethod(getWriteFrictionPFMethod())
              .addMethod(getReadFrictionFMethod())
              .addMethod(getWriteFrictionFMethod())
              .addMethod(getReadFrictionLoadMassMethod())
              .addMethod(getWriteFrictionLoadMassMethod())
              .addMethod(getReadGearP1EMethod())
              .addMethod(getWriteGearP1EMethod())
              .addMethod(getReadGearP1FMethod())
              .addMethod(getWriteGearP1FMethod())
              .addMethod(getReadGearP2EMethod())
              .addMethod(getWriteGearP2EMethod())
              .addMethod(getReadGearP2FMethod())
              .addMethod(getWriteGearP2FMethod())
              .addMethod(getReadGearGearRatioMethod())
              .addMethod(getWriteGearGearRatioMethod())
              .addMethod(getReadInertiaInertiaMethod())
              .addMethod(getWriteInertiaInertiaMethod())
              .addMethod(getReadInertiaDrumSpeedMethod())
              .addMethod(getWriteInertiaDrumSpeedMethod())
              .addMethod(getReadInertiaDrumAngleDegMethod())
              .addMethod(getWriteInertiaDrumAngleDegMethod())
              .addMethod(getReadMotorP1EMethod())
              .addMethod(getWriteMotorP1EMethod())
              .addMethod(getReadMotorP1FMethod())
              .addMethod(getWriteMotorP1FMethod())
              .addMethod(getReadMotorP2EMethod())
              .addMethod(getWriteMotorP2EMethod())
              .addMethod(getReadMotorP2FMethod())
              .addMethod(getWriteMotorP2FMethod())
              .addMethod(getReadMotorMotorDisplacementMethod())
              .addMethod(getWriteMotorMotorDisplacementMethod())
              .addMethod(getReadMotorMotorSpeedMethod())
              .addMethod(getWriteMotorMotorSpeedMethod())
              .addMethod(getReadMotorMotorFlowMethod())
              .addMethod(getWriteMotorMotorFlowMethod())
              .addMethod(getReadOneJunctionFlowMethod())
              .addMethod(getWriteOneJunctionFlowMethod())
              .addMethod(getReadOneJunctionP1EMethod())
              .addMethod(getWriteOneJunctionP1EMethod())
              .addMethod(getReadOneJunctionP2EMethod())
              .addMethod(getWriteOneJunctionP2EMethod())
              .addMethod(getReadOneJunctionP3EMethod())
              .addMethod(getWriteOneJunctionP3EMethod())
              .addMethod(getReadOneJunctionP1FMethod())
              .addMethod(getWriteOneJunctionP1FMethod())
              .addMethod(getReadOneJunctionP2FMethod())
              .addMethod(getWriteOneJunctionP2FMethod())
              .addMethod(getReadOneJunctionP3FMethod())
              .addMethod(getWriteOneJunctionP3FMethod())
              .addMethod(getReadOneJunction7FlowMethod())
              .addMethod(getWriteOneJunction7FlowMethod())
              .addMethod(getReadOneJunction7P1EMethod())
              .addMethod(getWriteOneJunction7P1EMethod())
              .addMethod(getReadOneJunction7P2EMethod())
              .addMethod(getWriteOneJunction7P2EMethod())
              .addMethod(getReadOneJunction7P3EMethod())
              .addMethod(getWriteOneJunction7P3EMethod())
              .addMethod(getReadOneJunction7P4EMethod())
              .addMethod(getWriteOneJunction7P4EMethod())
              .addMethod(getReadOneJunction7P1FMethod())
              .addMethod(getWriteOneJunction7P1FMethod())
              .addMethod(getReadOneJunction7P2FMethod())
              .addMethod(getWriteOneJunction7P2FMethod())
              .addMethod(getReadOneJunction7P3FMethod())
              .addMethod(getWriteOneJunction7P3FMethod())
              .addMethod(getReadOneJunction7P4FMethod())
              .addMethod(getWriteOneJunction7P4FMethod())
              .addMethod(getReadOpenTankPEMethod())
              .addMethod(getWriteOpenTankPEMethod())
              .addMethod(getReadOpenTankPFMethod())
              .addMethod(getWriteOpenTankPFMethod())
              .addMethod(getReadOpenTankAtomPressureMethod())
              .addMethod(getWriteOpenTankAtomPressureMethod())
              .addMethod(getReadOpenTankFlow2TankMethod())
              .addMethod(getWriteOpenTankFlow2TankMethod())
              .addMethod(getReadPumpPEMethod())
              .addMethod(getWritePumpPEMethod())
              .addMethod(getReadPumpPFMethod())
              .addMethod(getWritePumpPFMethod())
              .addMethod(getReadPumpGainMethod())
              .addMethod(getWritePumpGainMethod())
              .addMethod(getReadPumpPumpPressureMaxMethod())
              .addMethod(getWritePumpPumpPressureMaxMethod())
              .addMethod(getReadPumpPumpFlowMethod())
              .addMethod(getWritePumpPumpFlowMethod())
              .addMethod(getReadPumpPumpPressureMethod())
              .addMethod(getWritePumpPumpPressureMethod())
              .addMethod(getReadWireFMethod())
              .addMethod(getWriteWireFMethod())
              .addMethod(getReadWireVMethod())
              .addMethod(getWriteWireVMethod())
              .addMethod(getReadSetPointMethod())
              .addMethod(getWriteSetPointMethod())
              .addMethod(getReadControllerUIStateDotMethod())
              .addMethod(getWriteControllerUIStateDotMethod())
              .addMethod(getReadControllerUIStateMethod())
              .addMethod(getWriteControllerUIStateMethod())
              .addMethod(getReadControllerUIStateInitialMethod())
              .addMethod(getWriteControllerUIStateInitialMethod())
              .addMethod(getReadInertiaPEMethod())
              .addMethod(getWriteInertiaPEMethod())
              .addMethod(getReadInertiaMomentumMethod())
              .addMethod(getWriteInertiaMomentumMethod())
              .addMethod(getReadInertiaMomentumInitialMethod())
              .addMethod(getWriteInertiaMomentumInitialMethod())
              .addMethod(getReadInertiaPFMethod())
              .addMethod(getWriteInertiaPFMethod())
              .addMethod(getReadInertiaDrumAngleMethod())
              .addMethod(getWriteInertiaDrumAngleMethod())
              .addMethod(getReadInertiaDrumAngleInitialMethod())
              .addMethod(getWriteInertiaDrumAngleInitialMethod())
              .build();
        }
      }
    }
    return result;
  }
}
