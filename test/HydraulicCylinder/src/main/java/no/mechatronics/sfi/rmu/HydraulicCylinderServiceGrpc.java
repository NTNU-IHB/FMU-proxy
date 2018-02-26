package no.mechatronics.sfi.rmu;

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
    comments = "Source: unique_service.proto")
public final class HydraulicCylinderServiceGrpc {

  private HydraulicCylinderServiceGrpc() {}

  public static final String SERVICE_NAME = "no.mechatronics.sfi.rmu.HydraulicCylinderService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrainTankPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_DRAIN_TANK_P_E = getReadDrainTankPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPEMethod;
    if ((getReadDrainTankPEMethod = HydraulicCylinderServiceGrpc.getReadDrainTankPEMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadDrainTankPEMethod = HydraulicCylinderServiceGrpc.getReadDrainTankPEMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadDrainTankPEMethod = getReadDrainTankPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_DrainTank_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_DrainTank_p_e"))
                  .build();
          }
        }
     }
     return getReadDrainTankPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrainTankPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_DRAIN_TANK_P_E = getWriteDrainTankPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPEMethod;
    if ((getWriteDrainTankPEMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankPEMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteDrainTankPEMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankPEMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteDrainTankPEMethod = getWriteDrainTankPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_DrainTank_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_DrainTank_p_e"))
                  .build();
          }
        }
     }
     return getWriteDrainTankPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrainTankPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_DRAIN_TANK_P_F = getReadDrainTankPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPFMethod;
    if ((getReadDrainTankPFMethod = HydraulicCylinderServiceGrpc.getReadDrainTankPFMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadDrainTankPFMethod = HydraulicCylinderServiceGrpc.getReadDrainTankPFMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadDrainTankPFMethod = getReadDrainTankPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_DrainTank_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_DrainTank_p_f"))
                  .build();
          }
        }
     }
     return getReadDrainTankPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrainTankPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_DRAIN_TANK_P_F = getWriteDrainTankPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPFMethod;
    if ((getWriteDrainTankPFMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankPFMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteDrainTankPFMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankPFMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteDrainTankPFMethod = getWriteDrainTankPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_DrainTank_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_DrainTank_p_f"))
                  .build();
          }
        }
     }
     return getWriteDrainTankPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrainTankPressureTankMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_DRAIN_TANK_PRESSURE_TANK = getReadDrainTankPressureTankMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPressureTankMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPressureTankMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankPressureTankMethod;
    if ((getReadDrainTankPressureTankMethod = HydraulicCylinderServiceGrpc.getReadDrainTankPressureTankMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadDrainTankPressureTankMethod = HydraulicCylinderServiceGrpc.getReadDrainTankPressureTankMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadDrainTankPressureTankMethod = getReadDrainTankPressureTankMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_DrainTank_pressureTank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_DrainTank_pressureTank"))
                  .build();
          }
        }
     }
     return getReadDrainTankPressureTankMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrainTankPressureTankMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_DRAIN_TANK_PRESSURE_TANK = getWriteDrainTankPressureTankMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPressureTankMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPressureTankMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankPressureTankMethod;
    if ((getWriteDrainTankPressureTankMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankPressureTankMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteDrainTankPressureTankMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankPressureTankMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteDrainTankPressureTankMethod = getWriteDrainTankPressureTankMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_DrainTank_pressureTank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_DrainTank_pressureTank"))
                  .build();
          }
        }
     }
     return getWriteDrainTankPressureTankMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadDrainTankFlowTankMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_DRAIN_TANK_FLOW_TANK = getReadDrainTankFlowTankMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankFlowTankMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankFlowTankMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadDrainTankFlowTankMethod;
    if ((getReadDrainTankFlowTankMethod = HydraulicCylinderServiceGrpc.getReadDrainTankFlowTankMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadDrainTankFlowTankMethod = HydraulicCylinderServiceGrpc.getReadDrainTankFlowTankMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadDrainTankFlowTankMethod = getReadDrainTankFlowTankMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_DrainTank_flowTank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_DrainTank_flowTank"))
                  .build();
          }
        }
     }
     return getReadDrainTankFlowTankMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteDrainTankFlowTankMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_DRAIN_TANK_FLOW_TANK = getWriteDrainTankFlowTankMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankFlowTankMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankFlowTankMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteDrainTankFlowTankMethod;
    if ((getWriteDrainTankFlowTankMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankFlowTankMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteDrainTankFlowTankMethod = HydraulicCylinderServiceGrpc.getWriteDrainTankFlowTankMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteDrainTankFlowTankMethod = getWriteDrainTankFlowTankMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_DrainTank_flowTank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_DrainTank_flowTank"))
                  .build();
          }
        }
     }
     return getWriteDrainTankFlowTankMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_FLOW = getReadOneJunctionFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionFlowMethod;
    if ((getReadOneJunctionFlowMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionFlowMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionFlowMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionFlowMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionFlowMethod = getReadOneJunctionFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_flow"))
                  .build();
          }
        }
     }
     return getReadOneJunctionFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_FLOW = getWriteOneJunctionFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionFlowMethod;
    if ((getWriteOneJunctionFlowMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionFlowMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionFlowMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionFlowMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionFlowMethod = getWriteOneJunctionFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_flow"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_P1_E = getReadOneJunctionP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP1EMethod;
    if ((getReadOneJunctionP1EMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionP1EMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionP1EMethod = getReadOneJunctionP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_p1_e"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P1_E = getWriteOneJunctionP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP1EMethod;
    if ((getWriteOneJunctionP1EMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionP1EMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionP1EMethod = getWriteOneJunctionP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_p1_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_P2_E = getReadOneJunctionP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP2EMethod;
    if ((getReadOneJunctionP2EMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionP2EMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionP2EMethod = getReadOneJunctionP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_p2_e"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P2_E = getWriteOneJunctionP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP2EMethod;
    if ((getWriteOneJunctionP2EMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionP2EMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionP2EMethod = getWriteOneJunctionP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_p2_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP3EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_P3_E = getReadOneJunctionP3EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP3EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP3EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP3EMethod;
    if ((getReadOneJunctionP3EMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP3EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionP3EMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP3EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionP3EMethod = getReadOneJunctionP3EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_p3_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_p3_e"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP3EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP3EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P3_E = getWriteOneJunctionP3EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP3EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP3EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP3EMethod;
    if ((getWriteOneJunctionP3EMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP3EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionP3EMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP3EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionP3EMethod = getWriteOneJunctionP3EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_p3_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_p3_e"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP3EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_P1_F = getReadOneJunctionP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP1FMethod;
    if ((getReadOneJunctionP1FMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionP1FMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionP1FMethod = getReadOneJunctionP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_p1_f"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P1_F = getWriteOneJunctionP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP1FMethod;
    if ((getWriteOneJunctionP1FMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionP1FMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionP1FMethod = getWriteOneJunctionP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_p1_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_P2_F = getReadOneJunctionP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP2FMethod;
    if ((getReadOneJunctionP2FMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionP2FMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionP2FMethod = getReadOneJunctionP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_p2_f"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P2_F = getWriteOneJunctionP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP2FMethod;
    if ((getWriteOneJunctionP2FMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionP2FMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionP2FMethod = getWriteOneJunctionP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_p2_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadOneJunctionP3FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ONE_JUNCTION_P3_F = getReadOneJunctionP3FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP3FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP3FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadOneJunctionP3FMethod;
    if ((getReadOneJunctionP3FMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP3FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadOneJunctionP3FMethod = HydraulicCylinderServiceGrpc.getReadOneJunctionP3FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadOneJunctionP3FMethod = getReadOneJunctionP3FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_OneJunction_p3_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_OneJunction_p3_f"))
                  .build();
          }
        }
     }
     return getReadOneJunctionP3FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteOneJunctionP3FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ONE_JUNCTION_P3_F = getWriteOneJunctionP3FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP3FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP3FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteOneJunctionP3FMethod;
    if ((getWriteOneJunctionP3FMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP3FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteOneJunctionP3FMethod = HydraulicCylinderServiceGrpc.getWriteOneJunctionP3FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteOneJunctionP3FMethod = getWriteOneJunctionP3FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_OneJunction_p3_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_OneJunction_p3_f"))
                  .build();
          }
        }
     }
     return getWriteOneJunctionP3FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonForcePEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_FORCE_P_E = getReadPistonForcePEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForcePEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForcePEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForcePEMethod;
    if ((getReadPistonForcePEMethod = HydraulicCylinderServiceGrpc.getReadPistonForcePEMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonForcePEMethod = HydraulicCylinderServiceGrpc.getReadPistonForcePEMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonForcePEMethod = getReadPistonForcePEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonForce_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonForce_p_e"))
                  .build();
          }
        }
     }
     return getReadPistonForcePEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonForcePEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_FORCE_P_E = getWritePistonForcePEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForcePEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForcePEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForcePEMethod;
    if ((getWritePistonForcePEMethod = HydraulicCylinderServiceGrpc.getWritePistonForcePEMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonForcePEMethod = HydraulicCylinderServiceGrpc.getWritePistonForcePEMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonForcePEMethod = getWritePistonForcePEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonForce_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonForce_p_e"))
                  .build();
          }
        }
     }
     return getWritePistonForcePEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonForcePFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_FORCE_P_F = getReadPistonForcePFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForcePFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForcePFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForcePFMethod;
    if ((getReadPistonForcePFMethod = HydraulicCylinderServiceGrpc.getReadPistonForcePFMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonForcePFMethod = HydraulicCylinderServiceGrpc.getReadPistonForcePFMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonForcePFMethod = getReadPistonForcePFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonForce_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonForce_p_f"))
                  .build();
          }
        }
     }
     return getReadPistonForcePFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonForcePFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_FORCE_P_F = getWritePistonForcePFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForcePFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForcePFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForcePFMethod;
    if ((getWritePistonForcePFMethod = HydraulicCylinderServiceGrpc.getWritePistonForcePFMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonForcePFMethod = HydraulicCylinderServiceGrpc.getWritePistonForcePFMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonForcePFMethod = getWritePistonForcePFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonForce_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonForce_p_f"))
                  .build();
          }
        }
     }
     return getWritePistonForcePFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonForceEffortMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_FORCE_EFFORT = getReadPistonForceEffortMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForceEffortMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForceEffortMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForceEffortMethod;
    if ((getReadPistonForceEffortMethod = HydraulicCylinderServiceGrpc.getReadPistonForceEffortMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonForceEffortMethod = HydraulicCylinderServiceGrpc.getReadPistonForceEffortMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonForceEffortMethod = getReadPistonForceEffortMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonForce_effort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonForce_effort"))
                  .build();
          }
        }
     }
     return getReadPistonForceEffortMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonForceEffortMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_FORCE_EFFORT = getWritePistonForceEffortMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForceEffortMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForceEffortMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForceEffortMethod;
    if ((getWritePistonForceEffortMethod = HydraulicCylinderServiceGrpc.getWritePistonForceEffortMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonForceEffortMethod = HydraulicCylinderServiceGrpc.getWritePistonForceEffortMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonForceEffortMethod = getWritePistonForceEffortMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonForce_effort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonForce_effort"))
                  .build();
          }
        }
     }
     return getWritePistonForceEffortMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonForceFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_FORCE_FLOW = getReadPistonForceFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForceFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForceFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonForceFlowMethod;
    if ((getReadPistonForceFlowMethod = HydraulicCylinderServiceGrpc.getReadPistonForceFlowMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonForceFlowMethod = HydraulicCylinderServiceGrpc.getReadPistonForceFlowMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonForceFlowMethod = getReadPistonForceFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonForce_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonForce_flow"))
                  .build();
          }
        }
     }
     return getReadPistonForceFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonForceFlowMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_FORCE_FLOW = getWritePistonForceFlowMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForceFlowMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForceFlowMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonForceFlowMethod;
    if ((getWritePistonForceFlowMethod = HydraulicCylinderServiceGrpc.getWritePistonForceFlowMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonForceFlowMethod = HydraulicCylinderServiceGrpc.getWritePistonForceFlowMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonForceFlowMethod = getWritePistonForceFlowMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonForce_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonForce_flow"))
                  .build();
          }
        }
     }
     return getWritePistonForceFlowMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSideP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SIDE_P1_E = getReadPistonSideP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP1EMethod;
    if ((getReadPistonSideP1EMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSideP1EMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSideP1EMethod = getReadPistonSideP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSide_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSide_p1_e"))
                  .build();
          }
        }
     }
     return getReadPistonSideP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSideP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SIDE_P1_E = getWritePistonSideP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP1EMethod;
    if ((getWritePistonSideP1EMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSideP1EMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSideP1EMethod = getWritePistonSideP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSide_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSide_p1_e"))
                  .build();
          }
        }
     }
     return getWritePistonSideP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSideP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SIDE_P1_F = getReadPistonSideP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP1FMethod;
    if ((getReadPistonSideP1FMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSideP1FMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSideP1FMethod = getReadPistonSideP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSide_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSide_p1_f"))
                  .build();
          }
        }
     }
     return getReadPistonSideP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSideP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SIDE_P1_F = getWritePistonSideP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP1FMethod;
    if ((getWritePistonSideP1FMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSideP1FMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSideP1FMethod = getWritePistonSideP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSide_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSide_p1_f"))
                  .build();
          }
        }
     }
     return getWritePistonSideP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSideP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SIDE_P2_E = getReadPistonSideP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP2EMethod;
    if ((getReadPistonSideP2EMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSideP2EMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSideP2EMethod = getReadPistonSideP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSide_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSide_p2_e"))
                  .build();
          }
        }
     }
     return getReadPistonSideP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSideP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SIDE_P2_E = getWritePistonSideP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP2EMethod;
    if ((getWritePistonSideP2EMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSideP2EMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSideP2EMethod = getWritePistonSideP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSide_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSide_p2_e"))
                  .build();
          }
        }
     }
     return getWritePistonSideP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSideP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SIDE_P2_F = getReadPistonSideP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideP2FMethod;
    if ((getReadPistonSideP2FMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSideP2FMethod = HydraulicCylinderServiceGrpc.getReadPistonSideP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSideP2FMethod = getReadPistonSideP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSide_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSide_p2_f"))
                  .build();
          }
        }
     }
     return getReadPistonSideP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSideP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SIDE_P2_F = getWritePistonSideP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideP2FMethod;
    if ((getWritePistonSideP2FMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSideP2FMethod = HydraulicCylinderServiceGrpc.getWritePistonSideP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSideP2FMethod = getWritePistonSideP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSide_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSide_p2_f"))
                  .build();
          }
        }
     }
     return getWritePistonSideP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSideDiameterPistonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SIDE_DIAMETER_PISTON = getReadPistonSideDiameterPistonMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideDiameterPistonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideDiameterPistonMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideDiameterPistonMethod;
    if ((getReadPistonSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getReadPistonSideDiameterPistonMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getReadPistonSideDiameterPistonMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSideDiameterPistonMethod = getReadPistonSideDiameterPistonMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSide_diameterPiston"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSide_diameterPiston"))
                  .build();
          }
        }
     }
     return getReadPistonSideDiameterPistonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSideDiameterPistonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SIDE_DIAMETER_PISTON = getWritePistonSideDiameterPistonMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideDiameterPistonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideDiameterPistonMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideDiameterPistonMethod;
    if ((getWritePistonSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getWritePistonSideDiameterPistonMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getWritePistonSideDiameterPistonMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSideDiameterPistonMethod = getWritePistonSideDiameterPistonMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSide_diameterPiston"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSide_diameterPiston"))
                  .build();
          }
        }
     }
     return getWritePistonSideDiameterPistonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSideAreaPistonSideMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SIDE_AREA_PISTON_SIDE = getReadPistonSideAreaPistonSideMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideAreaPistonSideMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideAreaPistonSideMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSideAreaPistonSideMethod;
    if ((getReadPistonSideAreaPistonSideMethod = HydraulicCylinderServiceGrpc.getReadPistonSideAreaPistonSideMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSideAreaPistonSideMethod = HydraulicCylinderServiceGrpc.getReadPistonSideAreaPistonSideMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSideAreaPistonSideMethod = getReadPistonSideAreaPistonSideMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSide_areaPistonSide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSide_areaPistonSide"))
                  .build();
          }
        }
     }
     return getReadPistonSideAreaPistonSideMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSideAreaPistonSideMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SIDE_AREA_PISTON_SIDE = getWritePistonSideAreaPistonSideMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideAreaPistonSideMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideAreaPistonSideMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSideAreaPistonSideMethod;
    if ((getWritePistonSideAreaPistonSideMethod = HydraulicCylinderServiceGrpc.getWritePistonSideAreaPistonSideMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSideAreaPistonSideMethod = HydraulicCylinderServiceGrpc.getWritePistonSideAreaPistonSideMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSideAreaPistonSideMethod = getWritePistonSideAreaPistonSideMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSide_areaPistonSide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSide_areaPistonSide"))
                  .build();
          }
        }
     }
     return getWritePistonSideAreaPistonSideMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_P_E = getReadPumpPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPEMethod;
    if ((getReadPumpPEMethod = HydraulicCylinderServiceGrpc.getReadPumpPEMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpPEMethod = HydraulicCylinderServiceGrpc.getReadPumpPEMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpPEMethod = getReadPumpPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_p_e"))
                  .build();
          }
        }
     }
     return getReadPumpPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPEMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_P_E = getWritePumpPEMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPEMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPEMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPEMethod;
    if ((getWritePumpPEMethod = HydraulicCylinderServiceGrpc.getWritePumpPEMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpPEMethod = HydraulicCylinderServiceGrpc.getWritePumpPEMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpPEMethod = getWritePumpPEMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_p_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_p_e"))
                  .build();
          }
        }
     }
     return getWritePumpPEMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_P_F = getReadPumpPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPFMethod;
    if ((getReadPumpPFMethod = HydraulicCylinderServiceGrpc.getReadPumpPFMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpPFMethod = HydraulicCylinderServiceGrpc.getReadPumpPFMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpPFMethod = getReadPumpPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_p_f"))
                  .build();
          }
        }
     }
     return getReadPumpPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPFMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_P_F = getWritePumpPFMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPFMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPFMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPFMethod;
    if ((getWritePumpPFMethod = HydraulicCylinderServiceGrpc.getWritePumpPFMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpPFMethod = HydraulicCylinderServiceGrpc.getWritePumpPFMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpPFMethod = getWritePumpPFMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_p_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_p_f"))
                  .build();
          }
        }
     }
     return getWritePumpPFMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpGainMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_GAIN = getReadPumpGainMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpGainMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpGainMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpGainMethod;
    if ((getReadPumpGainMethod = HydraulicCylinderServiceGrpc.getReadPumpGainMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpGainMethod = HydraulicCylinderServiceGrpc.getReadPumpGainMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpGainMethod = getReadPumpGainMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_gain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_gain"))
                  .build();
          }
        }
     }
     return getReadPumpGainMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpGainMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_GAIN = getWritePumpGainMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpGainMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpGainMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpGainMethod;
    if ((getWritePumpGainMethod = HydraulicCylinderServiceGrpc.getWritePumpGainMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpGainMethod = HydraulicCylinderServiceGrpc.getWritePumpGainMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpGainMethod = getWritePumpGainMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_gain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_gain"))
                  .build();
          }
        }
     }
     return getWritePumpGainMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpDisplacementPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_DISPLACEMENT_PUMP = getReadPumpDisplacementPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpDisplacementPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpDisplacementPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpDisplacementPumpMethod;
    if ((getReadPumpDisplacementPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpDisplacementPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpDisplacementPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpDisplacementPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpDisplacementPumpMethod = getReadPumpDisplacementPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_displacementPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_displacementPump"))
                  .build();
          }
        }
     }
     return getReadPumpDisplacementPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpDisplacementPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_DISPLACEMENT_PUMP = getWritePumpDisplacementPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpDisplacementPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpDisplacementPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpDisplacementPumpMethod;
    if ((getWritePumpDisplacementPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpDisplacementPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpDisplacementPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpDisplacementPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpDisplacementPumpMethod = getWritePumpDisplacementPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_displacementPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_displacementPump"))
                  .build();
          }
        }
     }
     return getWritePumpDisplacementPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpRpmPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_RPM_PUMP = getReadPumpRpmPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpRpmPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpRpmPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpRpmPumpMethod;
    if ((getReadPumpRpmPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpRpmPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpRpmPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpRpmPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpRpmPumpMethod = getReadPumpRpmPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_rpmPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_rpmPump"))
                  .build();
          }
        }
     }
     return getReadPumpRpmPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpRpmPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_RPM_PUMP = getWritePumpRpmPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpRpmPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpRpmPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpRpmPumpMethod;
    if ((getWritePumpRpmPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpRpmPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpRpmPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpRpmPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpRpmPumpMethod = getWritePumpRpmPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_rpmPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_rpmPump"))
                  .build();
          }
        }
     }
     return getWritePumpRpmPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpFlowMaxPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_FLOW_MAX_PUMP = getReadPumpFlowMaxPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpFlowMaxPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpFlowMaxPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpFlowMaxPumpMethod;
    if ((getReadPumpFlowMaxPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpFlowMaxPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpFlowMaxPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpFlowMaxPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpFlowMaxPumpMethod = getReadPumpFlowMaxPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_flowMaxPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_flowMaxPump"))
                  .build();
          }
        }
     }
     return getReadPumpFlowMaxPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpFlowMaxPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_FLOW_MAX_PUMP = getWritePumpFlowMaxPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpFlowMaxPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpFlowMaxPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpFlowMaxPumpMethod;
    if ((getWritePumpFlowMaxPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpFlowMaxPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpFlowMaxPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpFlowMaxPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpFlowMaxPumpMethod = getWritePumpFlowMaxPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_flowMaxPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_flowMaxPump"))
                  .build();
          }
        }
     }
     return getWritePumpFlowMaxPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpPressurePumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_PRESSURE_PUMP = getReadPumpPressurePumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPressurePumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPressurePumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpPressurePumpMethod;
    if ((getReadPumpPressurePumpMethod = HydraulicCylinderServiceGrpc.getReadPumpPressurePumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpPressurePumpMethod = HydraulicCylinderServiceGrpc.getReadPumpPressurePumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpPressurePumpMethod = getReadPumpPressurePumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_pressurePump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_pressurePump"))
                  .build();
          }
        }
     }
     return getReadPumpPressurePumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpPressurePumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_PRESSURE_PUMP = getWritePumpPressurePumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPressurePumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPressurePumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpPressurePumpMethod;
    if ((getWritePumpPressurePumpMethod = HydraulicCylinderServiceGrpc.getWritePumpPressurePumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpPressurePumpMethod = HydraulicCylinderServiceGrpc.getWritePumpPressurePumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpPressurePumpMethod = getWritePumpPressurePumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_pressurePump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_pressurePump"))
                  .build();
          }
        }
     }
     return getWritePumpPressurePumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPumpFlowPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PUMP_FLOW_PUMP = getReadPumpFlowPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpFlowPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpFlowPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPumpFlowPumpMethod;
    if ((getReadPumpFlowPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpFlowPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPumpFlowPumpMethod = HydraulicCylinderServiceGrpc.getReadPumpFlowPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPumpFlowPumpMethod = getReadPumpFlowPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Pump_flowPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Pump_flowPump"))
                  .build();
          }
        }
     }
     return getReadPumpFlowPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePumpFlowPumpMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PUMP_FLOW_PUMP = getWritePumpFlowPumpMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpFlowPumpMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpFlowPumpMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePumpFlowPumpMethod;
    if ((getWritePumpFlowPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpFlowPumpMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePumpFlowPumpMethod = HydraulicCylinderServiceGrpc.getWritePumpFlowPumpMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePumpFlowPumpMethod = getWritePumpFlowPumpMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Pump_flowPump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Pump_flowPump"))
                  .build();
          }
        }
     }
     return getWritePumpFlowPumpMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_P1_E = getReadRodSideP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP1EMethod;
    if ((getReadRodSideP1EMethod = HydraulicCylinderServiceGrpc.getReadRodSideP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideP1EMethod = HydraulicCylinderServiceGrpc.getReadRodSideP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideP1EMethod = getReadRodSideP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_p1_e"))
                  .build();
          }
        }
     }
     return getReadRodSideP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_P1_E = getWriteRodSideP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP1EMethod;
    if ((getWriteRodSideP1EMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideP1EMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideP1EMethod = getWriteRodSideP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_p1_e"))
                  .build();
          }
        }
     }
     return getWriteRodSideP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_P1_F = getReadRodSideP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP1FMethod;
    if ((getReadRodSideP1FMethod = HydraulicCylinderServiceGrpc.getReadRodSideP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideP1FMethod = HydraulicCylinderServiceGrpc.getReadRodSideP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideP1FMethod = getReadRodSideP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_p1_f"))
                  .build();
          }
        }
     }
     return getReadRodSideP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_P1_F = getWriteRodSideP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP1FMethod;
    if ((getWriteRodSideP1FMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideP1FMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideP1FMethod = getWriteRodSideP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_p1_f"))
                  .build();
          }
        }
     }
     return getWriteRodSideP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_P2_E = getReadRodSideP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP2EMethod;
    if ((getReadRodSideP2EMethod = HydraulicCylinderServiceGrpc.getReadRodSideP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideP2EMethod = HydraulicCylinderServiceGrpc.getReadRodSideP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideP2EMethod = getReadRodSideP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_p2_e"))
                  .build();
          }
        }
     }
     return getReadRodSideP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_P2_E = getWriteRodSideP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP2EMethod;
    if ((getWriteRodSideP2EMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideP2EMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideP2EMethod = getWriteRodSideP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_p2_e"))
                  .build();
          }
        }
     }
     return getWriteRodSideP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_P2_F = getReadRodSideP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideP2FMethod;
    if ((getReadRodSideP2FMethod = HydraulicCylinderServiceGrpc.getReadRodSideP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideP2FMethod = HydraulicCylinderServiceGrpc.getReadRodSideP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideP2FMethod = getReadRodSideP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_p2_f"))
                  .build();
          }
        }
     }
     return getReadRodSideP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_P2_F = getWriteRodSideP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideP2FMethod;
    if ((getWriteRodSideP2FMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideP2FMethod = HydraulicCylinderServiceGrpc.getWriteRodSideP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideP2FMethod = getWriteRodSideP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_p2_f"))
                  .build();
          }
        }
     }
     return getWriteRodSideP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideDiameterPistonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_DIAMETER_PISTON = getReadRodSideDiameterPistonMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideDiameterPistonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideDiameterPistonMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideDiameterPistonMethod;
    if ((getReadRodSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getReadRodSideDiameterPistonMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getReadRodSideDiameterPistonMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideDiameterPistonMethod = getReadRodSideDiameterPistonMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_diameterPiston"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_diameterPiston"))
                  .build();
          }
        }
     }
     return getReadRodSideDiameterPistonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideDiameterPistonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_DIAMETER_PISTON = getWriteRodSideDiameterPistonMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideDiameterPistonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideDiameterPistonMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideDiameterPistonMethod;
    if ((getWriteRodSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getWriteRodSideDiameterPistonMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideDiameterPistonMethod = HydraulicCylinderServiceGrpc.getWriteRodSideDiameterPistonMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideDiameterPistonMethod = getWriteRodSideDiameterPistonMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_diameterPiston"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_diameterPiston"))
                  .build();
          }
        }
     }
     return getWriteRodSideDiameterPistonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideDiameterRodMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_DIAMETER_ROD = getReadRodSideDiameterRodMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideDiameterRodMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideDiameterRodMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideDiameterRodMethod;
    if ((getReadRodSideDiameterRodMethod = HydraulicCylinderServiceGrpc.getReadRodSideDiameterRodMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideDiameterRodMethod = HydraulicCylinderServiceGrpc.getReadRodSideDiameterRodMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideDiameterRodMethod = getReadRodSideDiameterRodMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_diameterRod"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_diameterRod"))
                  .build();
          }
        }
     }
     return getReadRodSideDiameterRodMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideDiameterRodMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_DIAMETER_ROD = getWriteRodSideDiameterRodMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideDiameterRodMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideDiameterRodMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideDiameterRodMethod;
    if ((getWriteRodSideDiameterRodMethod = HydraulicCylinderServiceGrpc.getWriteRodSideDiameterRodMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideDiameterRodMethod = HydraulicCylinderServiceGrpc.getWriteRodSideDiameterRodMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideDiameterRodMethod = getWriteRodSideDiameterRodMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_diameterRod"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_diameterRod"))
                  .build();
          }
        }
     }
     return getWriteRodSideDiameterRodMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRodSideAreaRodSideMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ROD_SIDE_AREA_ROD_SIDE = getReadRodSideAreaRodSideMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideAreaRodSideMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideAreaRodSideMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadRodSideAreaRodSideMethod;
    if ((getReadRodSideAreaRodSideMethod = HydraulicCylinderServiceGrpc.getReadRodSideAreaRodSideMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadRodSideAreaRodSideMethod = HydraulicCylinderServiceGrpc.getReadRodSideAreaRodSideMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadRodSideAreaRodSideMethod = getReadRodSideAreaRodSideMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_RodSide_areaRodSide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_RodSide_areaRodSide"))
                  .build();
          }
        }
     }
     return getReadRodSideAreaRodSideMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteRodSideAreaRodSideMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ROD_SIDE_AREA_ROD_SIDE = getWriteRodSideAreaRodSideMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideAreaRodSideMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideAreaRodSideMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteRodSideAreaRodSideMethod;
    if ((getWriteRodSideAreaRodSideMethod = HydraulicCylinderServiceGrpc.getWriteRodSideAreaRodSideMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteRodSideAreaRodSideMethod = HydraulicCylinderServiceGrpc.getWriteRodSideAreaRodSideMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteRodSideAreaRodSideMethod = getWriteRodSideAreaRodSideMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_RodSide_areaRodSide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_RodSide_areaRodSide"))
                  .build();
          }
        }
     }
     return getWriteRodSideAreaRodSideMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadSplitter1InputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_SPLITTER1_INPUT = getReadSplitter1InputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1InputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1InputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1InputMethod;
    if ((getReadSplitter1InputMethod = HydraulicCylinderServiceGrpc.getReadSplitter1InputMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadSplitter1InputMethod = HydraulicCylinderServiceGrpc.getReadSplitter1InputMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadSplitter1InputMethod = getReadSplitter1InputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Splitter1_input"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Splitter1_input"))
                  .build();
          }
        }
     }
     return getReadSplitter1InputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteSplitter1InputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_SPLITTER1_INPUT = getWriteSplitter1InputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1InputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1InputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1InputMethod;
    if ((getWriteSplitter1InputMethod = HydraulicCylinderServiceGrpc.getWriteSplitter1InputMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteSplitter1InputMethod = HydraulicCylinderServiceGrpc.getWriteSplitter1InputMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteSplitter1InputMethod = getWriteSplitter1InputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Splitter1_input"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Splitter1_input"))
                  .build();
          }
        }
     }
     return getWriteSplitter1InputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadSplitter1Output1Method()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_SPLITTER1_OUTPUT1 = getReadSplitter1Output1Method();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1Output1Method;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1Output1Method() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1Output1Method;
    if ((getReadSplitter1Output1Method = HydraulicCylinderServiceGrpc.getReadSplitter1Output1Method) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadSplitter1Output1Method = HydraulicCylinderServiceGrpc.getReadSplitter1Output1Method) == null) {
          HydraulicCylinderServiceGrpc.getReadSplitter1Output1Method = getReadSplitter1Output1Method = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Splitter1_output1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Splitter1_output1"))
                  .build();
          }
        }
     }
     return getReadSplitter1Output1Method;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteSplitter1Output1Method()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_SPLITTER1_OUTPUT1 = getWriteSplitter1Output1Method();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1Output1Method;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1Output1Method() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1Output1Method;
    if ((getWriteSplitter1Output1Method = HydraulicCylinderServiceGrpc.getWriteSplitter1Output1Method) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteSplitter1Output1Method = HydraulicCylinderServiceGrpc.getWriteSplitter1Output1Method) == null) {
          HydraulicCylinderServiceGrpc.getWriteSplitter1Output1Method = getWriteSplitter1Output1Method = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Splitter1_output1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Splitter1_output1"))
                  .build();
          }
        }
     }
     return getWriteSplitter1Output1Method;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadSplitter1Output2Method()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_SPLITTER1_OUTPUT2 = getReadSplitter1Output2Method();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1Output2Method;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1Output2Method() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadSplitter1Output2Method;
    if ((getReadSplitter1Output2Method = HydraulicCylinderServiceGrpc.getReadSplitter1Output2Method) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadSplitter1Output2Method = HydraulicCylinderServiceGrpc.getReadSplitter1Output2Method) == null) {
          HydraulicCylinderServiceGrpc.getReadSplitter1Output2Method = getReadSplitter1Output2Method = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Splitter1_output2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Splitter1_output2"))
                  .build();
          }
        }
     }
     return getReadSplitter1Output2Method;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteSplitter1Output2Method()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_SPLITTER1_OUTPUT2 = getWriteSplitter1Output2Method();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1Output2Method;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1Output2Method() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteSplitter1Output2Method;
    if ((getWriteSplitter1Output2Method = HydraulicCylinderServiceGrpc.getWriteSplitter1Output2Method) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteSplitter1Output2Method = HydraulicCylinderServiceGrpc.getWriteSplitter1Output2Method) == null) {
          HydraulicCylinderServiceGrpc.getWriteSplitter1Output2Method = getWriteSplitter1Output2Method = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Splitter1_output2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Splitter1_output2"))
                  .build();
          }
        }
     }
     return getWriteSplitter1Output2Method;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadZeroJunctionEffortMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ZERO_JUNCTION_EFFORT = getReadZeroJunctionEffortMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionEffortMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionEffortMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionEffortMethod;
    if ((getReadZeroJunctionEffortMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionEffortMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadZeroJunctionEffortMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionEffortMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadZeroJunctionEffortMethod = getReadZeroJunctionEffortMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_ZeroJunction_effort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_ZeroJunction_effort"))
                  .build();
          }
        }
     }
     return getReadZeroJunctionEffortMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteZeroJunctionEffortMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ZERO_JUNCTION_EFFORT = getWriteZeroJunctionEffortMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionEffortMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionEffortMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionEffortMethod;
    if ((getWriteZeroJunctionEffortMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionEffortMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteZeroJunctionEffortMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionEffortMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteZeroJunctionEffortMethod = getWriteZeroJunctionEffortMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_ZeroJunction_effort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_ZeroJunction_effort"))
                  .build();
          }
        }
     }
     return getWriteZeroJunctionEffortMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadZeroJunctionP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ZERO_JUNCTION_P1_E = getReadZeroJunctionP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP1EMethod;
    if ((getReadZeroJunctionP1EMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadZeroJunctionP1EMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadZeroJunctionP1EMethod = getReadZeroJunctionP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_ZeroJunction_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_ZeroJunction_p1_e"))
                  .build();
          }
        }
     }
     return getReadZeroJunctionP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteZeroJunctionP1EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ZERO_JUNCTION_P1_E = getWriteZeroJunctionP1EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP1EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP1EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP1EMethod;
    if ((getWriteZeroJunctionP1EMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP1EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteZeroJunctionP1EMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP1EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteZeroJunctionP1EMethod = getWriteZeroJunctionP1EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_ZeroJunction_p1_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_ZeroJunction_p1_e"))
                  .build();
          }
        }
     }
     return getWriteZeroJunctionP1EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadZeroJunctionP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ZERO_JUNCTION_P2_E = getReadZeroJunctionP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP2EMethod;
    if ((getReadZeroJunctionP2EMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadZeroJunctionP2EMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadZeroJunctionP2EMethod = getReadZeroJunctionP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_ZeroJunction_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_ZeroJunction_p2_e"))
                  .build();
          }
        }
     }
     return getReadZeroJunctionP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteZeroJunctionP2EMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ZERO_JUNCTION_P2_E = getWriteZeroJunctionP2EMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP2EMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP2EMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP2EMethod;
    if ((getWriteZeroJunctionP2EMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP2EMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteZeroJunctionP2EMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP2EMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteZeroJunctionP2EMethod = getWriteZeroJunctionP2EMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_ZeroJunction_p2_e"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_ZeroJunction_p2_e"))
                  .build();
          }
        }
     }
     return getWriteZeroJunctionP2EMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadZeroJunctionP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ZERO_JUNCTION_P1_F = getReadZeroJunctionP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP1FMethod;
    if ((getReadZeroJunctionP1FMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadZeroJunctionP1FMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadZeroJunctionP1FMethod = getReadZeroJunctionP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_ZeroJunction_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_ZeroJunction_p1_f"))
                  .build();
          }
        }
     }
     return getReadZeroJunctionP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteZeroJunctionP1FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ZERO_JUNCTION_P1_F = getWriteZeroJunctionP1FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP1FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP1FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP1FMethod;
    if ((getWriteZeroJunctionP1FMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP1FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteZeroJunctionP1FMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP1FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteZeroJunctionP1FMethod = getWriteZeroJunctionP1FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_ZeroJunction_p1_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_ZeroJunction_p1_f"))
                  .build();
          }
        }
     }
     return getWriteZeroJunctionP1FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadZeroJunctionP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_ZERO_JUNCTION_P2_F = getReadZeroJunctionP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadZeroJunctionP2FMethod;
    if ((getReadZeroJunctionP2FMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadZeroJunctionP2FMethod = HydraulicCylinderServiceGrpc.getReadZeroJunctionP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadZeroJunctionP2FMethod = getReadZeroJunctionP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_ZeroJunction_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_ZeroJunction_p2_f"))
                  .build();
          }
        }
     }
     return getReadZeroJunctionP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteZeroJunctionP2FMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_ZERO_JUNCTION_P2_F = getWriteZeroJunctionP2FMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP2FMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP2FMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteZeroJunctionP2FMethod;
    if ((getWriteZeroJunctionP2FMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP2FMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteZeroJunctionP2FMethod = HydraulicCylinderServiceGrpc.getWriteZeroJunctionP2FMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteZeroJunctionP2FMethod = getWriteZeroJunctionP2FMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_ZeroJunction_p2_f"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_ZeroJunction_p2_f"))
                  .build();
          }
        }
     }
     return getWriteZeroJunctionP2FMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadConstraintForceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_CONSTRAINT_FORCE = getReadConstraintForceMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadConstraintForceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadConstraintForceMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadConstraintForceMethod;
    if ((getReadConstraintForceMethod = HydraulicCylinderServiceGrpc.getReadConstraintForceMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadConstraintForceMethod = HydraulicCylinderServiceGrpc.getReadConstraintForceMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadConstraintForceMethod = getReadConstraintForceMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_ConstraintForce"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_ConstraintForce"))
                  .build();
          }
        }
     }
     return getReadConstraintForceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteConstraintForceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_CONSTRAINT_FORCE = getWriteConstraintForceMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteConstraintForceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteConstraintForceMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteConstraintForceMethod;
    if ((getWriteConstraintForceMethod = HydraulicCylinderServiceGrpc.getWriteConstraintForceMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteConstraintForceMethod = HydraulicCylinderServiceGrpc.getWriteConstraintForceMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteConstraintForceMethod = getWriteConstraintForceMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_ConstraintForce"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_ConstraintForce"))
                  .build();
          }
        }
     }
     return getWriteConstraintForceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadFlowGainMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_FLOW_GAIN = getReadFlowGainMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadFlowGainMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadFlowGainMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadFlowGainMethod;
    if ((getReadFlowGainMethod = HydraulicCylinderServiceGrpc.getReadFlowGainMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadFlowGainMethod = HydraulicCylinderServiceGrpc.getReadFlowGainMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadFlowGainMethod = getReadFlowGainMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_FlowGain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_FlowGain"))
                  .build();
          }
        }
     }
     return getReadFlowGainMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteFlowGainMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_FLOW_GAIN = getWriteFlowGainMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteFlowGainMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteFlowGainMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteFlowGainMethod;
    if ((getWriteFlowGainMethod = HydraulicCylinderServiceGrpc.getWriteFlowGainMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteFlowGainMethod = HydraulicCylinderServiceGrpc.getWriteFlowGainMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteFlowGainMethod = getWriteFlowGainMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_FlowGain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_FlowGain"))
                  .build();
          }
        }
     }
     return getWriteFlowGainMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonDisplacementMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_DISPLACEMENT = getReadPistonDisplacementMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonDisplacementMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonDisplacementMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonDisplacementMethod;
    if ((getReadPistonDisplacementMethod = HydraulicCylinderServiceGrpc.getReadPistonDisplacementMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonDisplacementMethod = HydraulicCylinderServiceGrpc.getReadPistonDisplacementMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonDisplacementMethod = getReadPistonDisplacementMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonDisplacement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonDisplacement"))
                  .build();
          }
        }
     }
     return getReadPistonDisplacementMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonDisplacementMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_DISPLACEMENT = getWritePistonDisplacementMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonDisplacementMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonDisplacementMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonDisplacementMethod;
    if ((getWritePistonDisplacementMethod = HydraulicCylinderServiceGrpc.getWritePistonDisplacementMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonDisplacementMethod = HydraulicCylinderServiceGrpc.getWritePistonDisplacementMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonDisplacementMethod = getWritePistonDisplacementMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonDisplacement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonDisplacement"))
                  .build();
          }
        }
     }
     return getWritePistonDisplacementMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadPistonSpeedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_PISTON_SPEED = getReadPistonSpeedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSpeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSpeedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadPistonSpeedMethod;
    if ((getReadPistonSpeedMethod = HydraulicCylinderServiceGrpc.getReadPistonSpeedMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadPistonSpeedMethod = HydraulicCylinderServiceGrpc.getReadPistonSpeedMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadPistonSpeedMethod = getReadPistonSpeedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_PistonSpeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_PistonSpeed"))
                  .build();
          }
        }
     }
     return getReadPistonSpeedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWritePistonSpeedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_PISTON_SPEED = getWritePistonSpeedMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSpeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSpeedMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWritePistonSpeedMethod;
    if ((getWritePistonSpeedMethod = HydraulicCylinderServiceGrpc.getWritePistonSpeedMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWritePistonSpeedMethod = HydraulicCylinderServiceGrpc.getWritePistonSpeedMethod) == null) {
          HydraulicCylinderServiceGrpc.getWritePistonSpeedMethod = getWritePistonSpeedMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_PistonSpeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_PistonSpeed"))
                  .build();
          }
        }
     }
     return getWritePistonSpeedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadIntegrateInputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_INTEGRATE_INPUT = getReadIntegrateInputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateInputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateInputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateInputMethod;
    if ((getReadIntegrateInputMethod = HydraulicCylinderServiceGrpc.getReadIntegrateInputMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadIntegrateInputMethod = HydraulicCylinderServiceGrpc.getReadIntegrateInputMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadIntegrateInputMethod = getReadIntegrateInputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Integrate_input"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Integrate_input"))
                  .build();
          }
        }
     }
     return getReadIntegrateInputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegrateInputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_INTEGRATE_INPUT = getWriteIntegrateInputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateInputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateInputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateInputMethod;
    if ((getWriteIntegrateInputMethod = HydraulicCylinderServiceGrpc.getWriteIntegrateInputMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteIntegrateInputMethod = HydraulicCylinderServiceGrpc.getWriteIntegrateInputMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteIntegrateInputMethod = getWriteIntegrateInputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Integrate_input"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Integrate_input"))
                  .build();
          }
        }
     }
     return getWriteIntegrateInputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadIntegrateOutputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_INTEGRATE_OUTPUT = getReadIntegrateOutputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateOutputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateOutputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateOutputMethod;
    if ((getReadIntegrateOutputMethod = HydraulicCylinderServiceGrpc.getReadIntegrateOutputMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadIntegrateOutputMethod = HydraulicCylinderServiceGrpc.getReadIntegrateOutputMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadIntegrateOutputMethod = getReadIntegrateOutputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Integrate_output"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Integrate_output"))
                  .build();
          }
        }
     }
     return getReadIntegrateOutputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegrateOutputMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_INTEGRATE_OUTPUT = getWriteIntegrateOutputMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateOutputMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateOutputMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateOutputMethod;
    if ((getWriteIntegrateOutputMethod = HydraulicCylinderServiceGrpc.getWriteIntegrateOutputMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteIntegrateOutputMethod = HydraulicCylinderServiceGrpc.getWriteIntegrateOutputMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteIntegrateOutputMethod = getWriteIntegrateOutputMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Integrate_output"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Integrate_output"))
                  .build();
          }
        }
     }
     return getWriteIntegrateOutputMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadIntegrateInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> METHOD_READ_INTEGRATE_INITIAL = getReadIntegrateInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
      no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> getReadIntegrateInitialMethod;
    if ((getReadIntegrateInitialMethod = HydraulicCylinderServiceGrpc.getReadIntegrateInitialMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getReadIntegrateInitialMethod = HydraulicCylinderServiceGrpc.getReadIntegrateInitialMethod) == null) {
          HydraulicCylinderServiceGrpc.getReadIntegrateInitialMethod = getReadIntegrateInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.FmiDefinitions.UInt, no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Read_Integrate_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.UInt.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.RealRead.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Read_Integrate_initial"))
                  .build();
          }
        }
     }
     return getReadIntegrateInitialMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteIntegrateInitialMethod()} instead. 
  public static final io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> METHOD_WRITE_INTEGRATE_INITIAL = getWriteIntegrateInitialMethod();

  private static volatile io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateInitialMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
      no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateInitialMethod() {
    io.grpc.MethodDescriptor<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status> getWriteIntegrateInitialMethod;
    if ((getWriteIntegrateInitialMethod = HydraulicCylinderServiceGrpc.getWriteIntegrateInitialMethod) == null) {
      synchronized (HydraulicCylinderServiceGrpc.class) {
        if ((getWriteIntegrateInitialMethod = HydraulicCylinderServiceGrpc.getWriteIntegrateInitialMethod) == null) {
          HydraulicCylinderServiceGrpc.getWriteIntegrateInitialMethod = getWriteIntegrateInitialMethod = 
              io.grpc.MethodDescriptor.<no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite, no.mechatronics.sfi.rmu.FmiDefinitions.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "no.mechatronics.sfi.rmu.HydraulicCylinderService", "Write_Integrate_initial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  no.mechatronics.sfi.rmu.FmiDefinitions.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new HydraulicCylinderServiceMethodDescriptorSupplier("Write_Integrate_initial"))
                  .build();
          }
        }
     }
     return getWriteIntegrateInitialMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HydraulicCylinderServiceStub newStub(io.grpc.Channel channel) {
    return new HydraulicCylinderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HydraulicCylinderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HydraulicCylinderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HydraulicCylinderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HydraulicCylinderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HydraulicCylinderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void readDrainTankPE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrainTankPEMethod(), responseObserver);
    }

    /**
     */
    public void writeDrainTankPE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrainTankPEMethod(), responseObserver);
    }

    /**
     */
    public void readDrainTankPF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrainTankPFMethod(), responseObserver);
    }

    /**
     */
    public void writeDrainTankPF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrainTankPFMethod(), responseObserver);
    }

    /**
     */
    public void readDrainTankPressureTank(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrainTankPressureTankMethod(), responseObserver);
    }

    /**
     */
    public void writeDrainTankPressureTank(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrainTankPressureTankMethod(), responseObserver);
    }

    /**
     */
    public void readDrainTankFlowTank(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadDrainTankFlowTankMethod(), responseObserver);
    }

    /**
     */
    public void writeDrainTankFlowTank(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteDrainTankFlowTankMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionFlow(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionFlowMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionFlow(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionFlowMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP1EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP2EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP3E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP3EMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP3EMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP1FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP2FMethod(), responseObserver);
    }

    /**
     */
    public void readOneJunctionP3F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadOneJunctionP3FMethod(), responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneJunctionP3FMethod(), responseObserver);
    }

    /**
     */
    public void readPistonForcePE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonForcePEMethod(), responseObserver);
    }

    /**
     */
    public void writePistonForcePE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonForcePEMethod(), responseObserver);
    }

    /**
     */
    public void readPistonForcePF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonForcePFMethod(), responseObserver);
    }

    /**
     */
    public void writePistonForcePF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonForcePFMethod(), responseObserver);
    }

    /**
     */
    public void readPistonForceEffort(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonForceEffortMethod(), responseObserver);
    }

    /**
     */
    public void writePistonForceEffort(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonForceEffortMethod(), responseObserver);
    }

    /**
     */
    public void readPistonForceFlow(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonForceFlowMethod(), responseObserver);
    }

    /**
     */
    public void writePistonForceFlow(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonForceFlowMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSideP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSideP1EMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSideP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSideP1EMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSideP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSideP1FMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSideP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSideP1FMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSideP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSideP2EMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSideP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSideP2EMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSideP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSideP2FMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSideP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSideP2FMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSideDiameterPiston(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSideDiameterPistonMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSideDiameterPiston(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSideDiameterPistonMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSideAreaPistonSide(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSideAreaPistonSideMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSideAreaPistonSide(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSideAreaPistonSideMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPEMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPEMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPFMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPFMethod(), responseObserver);
    }

    /**
     */
    public void readPumpGain(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpGainMethod(), responseObserver);
    }

    /**
     */
    public void writePumpGain(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpGainMethod(), responseObserver);
    }

    /**
     */
    public void readPumpDisplacementPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpDisplacementPumpMethod(), responseObserver);
    }

    /**
     */
    public void writePumpDisplacementPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpDisplacementPumpMethod(), responseObserver);
    }

    /**
     */
    public void readPumpRpmPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpRpmPumpMethod(), responseObserver);
    }

    /**
     */
    public void writePumpRpmPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpRpmPumpMethod(), responseObserver);
    }

    /**
     */
    public void readPumpFlowMaxPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpFlowMaxPumpMethod(), responseObserver);
    }

    /**
     */
    public void writePumpFlowMaxPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpFlowMaxPumpMethod(), responseObserver);
    }

    /**
     */
    public void readPumpPressurePump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpPressurePumpMethod(), responseObserver);
    }

    /**
     */
    public void writePumpPressurePump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpPressurePumpMethod(), responseObserver);
    }

    /**
     */
    public void readPumpFlowPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPumpFlowPumpMethod(), responseObserver);
    }

    /**
     */
    public void writePumpFlowPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePumpFlowPumpMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideP1EMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideP1FMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideP2EMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideP2FMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideDiameterPiston(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideDiameterPistonMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideDiameterPiston(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideDiameterPistonMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideDiameterRod(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideDiameterRodMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideDiameterRod(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideDiameterRodMethod(), responseObserver);
    }

    /**
     */
    public void readRodSideAreaRodSide(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadRodSideAreaRodSideMethod(), responseObserver);
    }

    /**
     */
    public void writeRodSideAreaRodSide(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteRodSideAreaRodSideMethod(), responseObserver);
    }

    /**
     */
    public void readSplitter1Input(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadSplitter1InputMethod(), responseObserver);
    }

    /**
     */
    public void writeSplitter1Input(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteSplitter1InputMethod(), responseObserver);
    }

    /**
     */
    public void readSplitter1Output1(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadSplitter1Output1Method(), responseObserver);
    }

    /**
     */
    public void writeSplitter1Output1(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteSplitter1Output1Method(), responseObserver);
    }

    /**
     */
    public void readSplitter1Output2(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadSplitter1Output2Method(), responseObserver);
    }

    /**
     */
    public void writeSplitter1Output2(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteSplitter1Output2Method(), responseObserver);
    }

    /**
     */
    public void readZeroJunctionEffort(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadZeroJunctionEffortMethod(), responseObserver);
    }

    /**
     */
    public void writeZeroJunctionEffort(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteZeroJunctionEffortMethod(), responseObserver);
    }

    /**
     */
    public void readZeroJunctionP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadZeroJunctionP1EMethod(), responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteZeroJunctionP1EMethod(), responseObserver);
    }

    /**
     */
    public void readZeroJunctionP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadZeroJunctionP2EMethod(), responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteZeroJunctionP2EMethod(), responseObserver);
    }

    /**
     */
    public void readZeroJunctionP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadZeroJunctionP1FMethod(), responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteZeroJunctionP1FMethod(), responseObserver);
    }

    /**
     */
    public void readZeroJunctionP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadZeroJunctionP2FMethod(), responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteZeroJunctionP2FMethod(), responseObserver);
    }

    /**
     */
    public void readConstraintForce(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadConstraintForceMethod(), responseObserver);
    }

    /**
     */
    public void writeConstraintForce(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteConstraintForceMethod(), responseObserver);
    }

    /**
     */
    public void readFlowGain(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadFlowGainMethod(), responseObserver);
    }

    /**
     */
    public void writeFlowGain(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteFlowGainMethod(), responseObserver);
    }

    /**
     */
    public void readPistonDisplacement(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonDisplacementMethod(), responseObserver);
    }

    /**
     */
    public void writePistonDisplacement(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonDisplacementMethod(), responseObserver);
    }

    /**
     */
    public void readPistonSpeed(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadPistonSpeedMethod(), responseObserver);
    }

    /**
     */
    public void writePistonSpeed(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWritePistonSpeedMethod(), responseObserver);
    }

    /**
     */
    public void readIntegrateInput(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegrateInputMethod(), responseObserver);
    }

    /**
     */
    public void writeIntegrateInput(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegrateInputMethod(), responseObserver);
    }

    /**
     */
    public void readIntegrateOutput(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegrateOutputMethod(), responseObserver);
    }

    /**
     */
    public void writeIntegrateOutput(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegrateOutputMethod(), responseObserver);
    }

    /**
     */
    public void readIntegrateInitial(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnimplementedUnaryCall(getReadIntegrateInitialMethod(), responseObserver);
    }

    /**
     */
    public void writeIntegrateInitial(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteIntegrateInitialMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReadDrainTankPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_DRAIN_TANK_P_E)))
          .addMethod(
            getWriteDrainTankPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRAIN_TANK_P_E)))
          .addMethod(
            getReadDrainTankPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_DRAIN_TANK_P_F)))
          .addMethod(
            getWriteDrainTankPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRAIN_TANK_P_F)))
          .addMethod(
            getReadDrainTankPressureTankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_DRAIN_TANK_PRESSURE_TANK)))
          .addMethod(
            getWriteDrainTankPressureTankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRAIN_TANK_PRESSURE_TANK)))
          .addMethod(
            getReadDrainTankFlowTankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_DRAIN_TANK_FLOW_TANK)))
          .addMethod(
            getWriteDrainTankFlowTankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_DRAIN_TANK_FLOW_TANK)))
          .addMethod(
            getReadOneJunctionFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_FLOW)))
          .addMethod(
            getWriteOneJunctionFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_FLOW)))
          .addMethod(
            getReadOneJunctionP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_P1_E)))
          .addMethod(
            getWriteOneJunctionP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P1_E)))
          .addMethod(
            getReadOneJunctionP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_P2_E)))
          .addMethod(
            getWriteOneJunctionP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P2_E)))
          .addMethod(
            getReadOneJunctionP3EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_P3_E)))
          .addMethod(
            getWriteOneJunctionP3EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P3_E)))
          .addMethod(
            getReadOneJunctionP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_P1_F)))
          .addMethod(
            getWriteOneJunctionP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P1_F)))
          .addMethod(
            getReadOneJunctionP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_P2_F)))
          .addMethod(
            getWriteOneJunctionP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P2_F)))
          .addMethod(
            getReadOneJunctionP3FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ONE_JUNCTION_P3_F)))
          .addMethod(
            getWriteOneJunctionP3FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ONE_JUNCTION_P3_F)))
          .addMethod(
            getReadPistonForcePEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_FORCE_P_E)))
          .addMethod(
            getWritePistonForcePEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_FORCE_P_E)))
          .addMethod(
            getReadPistonForcePFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_FORCE_P_F)))
          .addMethod(
            getWritePistonForcePFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_FORCE_P_F)))
          .addMethod(
            getReadPistonForceEffortMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_FORCE_EFFORT)))
          .addMethod(
            getWritePistonForceEffortMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_FORCE_EFFORT)))
          .addMethod(
            getReadPistonForceFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_FORCE_FLOW)))
          .addMethod(
            getWritePistonForceFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_FORCE_FLOW)))
          .addMethod(
            getReadPistonSideP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SIDE_P1_E)))
          .addMethod(
            getWritePistonSideP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SIDE_P1_E)))
          .addMethod(
            getReadPistonSideP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SIDE_P1_F)))
          .addMethod(
            getWritePistonSideP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SIDE_P1_F)))
          .addMethod(
            getReadPistonSideP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SIDE_P2_E)))
          .addMethod(
            getWritePistonSideP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SIDE_P2_E)))
          .addMethod(
            getReadPistonSideP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SIDE_P2_F)))
          .addMethod(
            getWritePistonSideP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SIDE_P2_F)))
          .addMethod(
            getReadPistonSideDiameterPistonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SIDE_DIAMETER_PISTON)))
          .addMethod(
            getWritePistonSideDiameterPistonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SIDE_DIAMETER_PISTON)))
          .addMethod(
            getReadPistonSideAreaPistonSideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SIDE_AREA_PISTON_SIDE)))
          .addMethod(
            getWritePistonSideAreaPistonSideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SIDE_AREA_PISTON_SIDE)))
          .addMethod(
            getReadPumpPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_P_E)))
          .addMethod(
            getWritePumpPEMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_P_E)))
          .addMethod(
            getReadPumpPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_P_F)))
          .addMethod(
            getWritePumpPFMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_P_F)))
          .addMethod(
            getReadPumpGainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_GAIN)))
          .addMethod(
            getWritePumpGainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_GAIN)))
          .addMethod(
            getReadPumpDisplacementPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_DISPLACEMENT_PUMP)))
          .addMethod(
            getWritePumpDisplacementPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_DISPLACEMENT_PUMP)))
          .addMethod(
            getReadPumpRpmPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_RPM_PUMP)))
          .addMethod(
            getWritePumpRpmPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_RPM_PUMP)))
          .addMethod(
            getReadPumpFlowMaxPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_FLOW_MAX_PUMP)))
          .addMethod(
            getWritePumpFlowMaxPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_FLOW_MAX_PUMP)))
          .addMethod(
            getReadPumpPressurePumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_PRESSURE_PUMP)))
          .addMethod(
            getWritePumpPressurePumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_PRESSURE_PUMP)))
          .addMethod(
            getReadPumpFlowPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PUMP_FLOW_PUMP)))
          .addMethod(
            getWritePumpFlowPumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PUMP_FLOW_PUMP)))
          .addMethod(
            getReadRodSideP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_P1_E)))
          .addMethod(
            getWriteRodSideP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_P1_E)))
          .addMethod(
            getReadRodSideP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_P1_F)))
          .addMethod(
            getWriteRodSideP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_P1_F)))
          .addMethod(
            getReadRodSideP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_P2_E)))
          .addMethod(
            getWriteRodSideP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_P2_E)))
          .addMethod(
            getReadRodSideP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_P2_F)))
          .addMethod(
            getWriteRodSideP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_P2_F)))
          .addMethod(
            getReadRodSideDiameterPistonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_DIAMETER_PISTON)))
          .addMethod(
            getWriteRodSideDiameterPistonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_DIAMETER_PISTON)))
          .addMethod(
            getReadRodSideDiameterRodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_DIAMETER_ROD)))
          .addMethod(
            getWriteRodSideDiameterRodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_DIAMETER_ROD)))
          .addMethod(
            getReadRodSideAreaRodSideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ROD_SIDE_AREA_ROD_SIDE)))
          .addMethod(
            getWriteRodSideAreaRodSideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ROD_SIDE_AREA_ROD_SIDE)))
          .addMethod(
            getReadSplitter1InputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_SPLITTER1_INPUT)))
          .addMethod(
            getWriteSplitter1InputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_SPLITTER1_INPUT)))
          .addMethod(
            getReadSplitter1Output1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_SPLITTER1_OUTPUT1)))
          .addMethod(
            getWriteSplitter1Output1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_SPLITTER1_OUTPUT1)))
          .addMethod(
            getReadSplitter1Output2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_SPLITTER1_OUTPUT2)))
          .addMethod(
            getWriteSplitter1Output2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_SPLITTER1_OUTPUT2)))
          .addMethod(
            getReadZeroJunctionEffortMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ZERO_JUNCTION_EFFORT)))
          .addMethod(
            getWriteZeroJunctionEffortMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ZERO_JUNCTION_EFFORT)))
          .addMethod(
            getReadZeroJunctionP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ZERO_JUNCTION_P1_E)))
          .addMethod(
            getWriteZeroJunctionP1EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ZERO_JUNCTION_P1_E)))
          .addMethod(
            getReadZeroJunctionP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ZERO_JUNCTION_P2_E)))
          .addMethod(
            getWriteZeroJunctionP2EMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ZERO_JUNCTION_P2_E)))
          .addMethod(
            getReadZeroJunctionP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ZERO_JUNCTION_P1_F)))
          .addMethod(
            getWriteZeroJunctionP1FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ZERO_JUNCTION_P1_F)))
          .addMethod(
            getReadZeroJunctionP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_ZERO_JUNCTION_P2_F)))
          .addMethod(
            getWriteZeroJunctionP2FMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_ZERO_JUNCTION_P2_F)))
          .addMethod(
            getReadConstraintForceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_CONSTRAINT_FORCE)))
          .addMethod(
            getWriteConstraintForceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_CONSTRAINT_FORCE)))
          .addMethod(
            getReadFlowGainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_FLOW_GAIN)))
          .addMethod(
            getWriteFlowGainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_FLOW_GAIN)))
          .addMethod(
            getReadPistonDisplacementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_DISPLACEMENT)))
          .addMethod(
            getWritePistonDisplacementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_DISPLACEMENT)))
          .addMethod(
            getReadPistonSpeedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_PISTON_SPEED)))
          .addMethod(
            getWritePistonSpeedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_PISTON_SPEED)))
          .addMethod(
            getReadIntegrateInputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_INTEGRATE_INPUT)))
          .addMethod(
            getWriteIntegrateInputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INTEGRATE_INPUT)))
          .addMethod(
            getReadIntegrateOutputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_INTEGRATE_OUTPUT)))
          .addMethod(
            getWriteIntegrateOutputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INTEGRATE_OUTPUT)))
          .addMethod(
            getReadIntegrateInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.FmiDefinitions.UInt,
                no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>(
                  this, METHODID_READ_INTEGRATE_INITIAL)))
          .addMethod(
            getWriteIntegrateInitialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite,
                no.mechatronics.sfi.rmu.FmiDefinitions.Status>(
                  this, METHODID_WRITE_INTEGRATE_INITIAL)))
          .build();
    }
  }

  /**
   */
  public static final class HydraulicCylinderServiceStub extends io.grpc.stub.AbstractStub<HydraulicCylinderServiceStub> {
    private HydraulicCylinderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HydraulicCylinderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HydraulicCylinderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HydraulicCylinderServiceStub(channel, callOptions);
    }

    /**
     */
    public void readDrainTankPE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrainTankPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrainTankPE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrainTankPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrainTankPF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrainTankPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrainTankPF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrainTankPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrainTankPressureTank(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrainTankPressureTankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrainTankPressureTank(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrainTankPressureTankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readDrainTankFlowTank(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadDrainTankFlowTankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeDrainTankFlowTank(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteDrainTankFlowTankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionFlow(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionFlow(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP3E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP3EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOneJunctionP3F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneJunctionP3FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOneJunctionP3F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonForcePE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonForcePEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonForcePE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonForcePEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonForcePF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonForcePFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonForcePF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonForcePFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonForceEffort(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonForceEffortMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonForceEffort(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonForceEffortMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonForceFlow(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonForceFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonForceFlow(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonForceFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSideP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSideP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSideP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSideP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSideP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSideP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSideP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSideP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSideP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSideP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSideP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSideP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSideP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSideP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSideP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSideP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSideDiameterPiston(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSideDiameterPistonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSideDiameterPiston(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSideDiameterPistonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSideAreaPistonSide(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSideAreaPistonSideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSideAreaPistonSide(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSideAreaPistonSideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPEMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPFMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpGain(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpGainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpGain(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpGainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpDisplacementPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpDisplacementPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpDisplacementPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpDisplacementPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpRpmPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpRpmPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpRpmPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpRpmPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpFlowMaxPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpFlowMaxPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpFlowMaxPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpFlowMaxPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpPressurePump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpPressurePumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpPressurePump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpPressurePumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPumpFlowPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPumpFlowPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePumpFlowPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePumpFlowPumpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideDiameterPiston(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideDiameterPistonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideDiameterPiston(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideDiameterPistonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideDiameterRod(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideDiameterRodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideDiameterRod(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideDiameterRodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRodSideAreaRodSide(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadRodSideAreaRodSideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeRodSideAreaRodSide(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteRodSideAreaRodSideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readSplitter1Input(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadSplitter1InputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeSplitter1Input(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteSplitter1InputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readSplitter1Output1(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadSplitter1Output1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeSplitter1Output1(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteSplitter1Output1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readSplitter1Output2(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadSplitter1Output2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeSplitter1Output2(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteSplitter1Output2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readZeroJunctionEffort(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadZeroJunctionEffortMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeZeroJunctionEffort(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteZeroJunctionEffortMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readZeroJunctionP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadZeroJunctionP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP1EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readZeroJunctionP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadZeroJunctionP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP2EMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readZeroJunctionP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadZeroJunctionP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP1FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readZeroJunctionP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadZeroJunctionP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeZeroJunctionP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP2FMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readConstraintForce(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadConstraintForceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeConstraintForce(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteConstraintForceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readFlowGain(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadFlowGainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeFlowGain(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteFlowGainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonDisplacement(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonDisplacementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonDisplacement(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonDisplacementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPistonSpeed(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadPistonSpeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writePistonSpeed(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWritePistonSpeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readIntegrateInput(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegrateInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeIntegrateInput(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegrateInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readIntegrateOutput(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegrateOutputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeIntegrateOutput(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegrateOutputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readIntegrateInitial(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadIntegrateInitialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeIntegrateInitial(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request,
        io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteIntegrateInitialMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HydraulicCylinderServiceBlockingStub extends io.grpc.stub.AbstractStub<HydraulicCylinderServiceBlockingStub> {
    private HydraulicCylinderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HydraulicCylinderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HydraulicCylinderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HydraulicCylinderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readDrainTankPE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrainTankPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeDrainTankPE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrainTankPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readDrainTankPF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrainTankPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeDrainTankPF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrainTankPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readDrainTankPressureTank(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrainTankPressureTankMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeDrainTankPressureTank(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrainTankPressureTankMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readDrainTankFlowTank(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadDrainTankFlowTankMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeDrainTankFlowTank(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteDrainTankFlowTankMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionFlow(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionFlow(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionP3E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP3EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionP3E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP3EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readOneJunctionP3F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadOneJunctionP3FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeOneJunctionP3F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneJunctionP3FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonForcePE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonForcePEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonForcePE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonForcePEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonForcePF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonForcePFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonForcePF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonForcePFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonForceEffort(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonForceEffortMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonForceEffort(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonForceEffortMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonForceFlow(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonForceFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonForceFlow(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonForceFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSideP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSideP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSideP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSideP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSideP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSideP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSideP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSideP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSideP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSideP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSideP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSideP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSideP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSideP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSideP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSideP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSideDiameterPiston(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSideDiameterPistonMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSideDiameterPiston(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSideDiameterPistonMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSideAreaPistonSide(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSideAreaPistonSideMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSideAreaPistonSide(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSideAreaPistonSideMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpPE(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpPE(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPEMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpPF(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpPF(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPFMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpGain(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpGainMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpGain(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpGainMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpDisplacementPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpDisplacementPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpDisplacementPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpDisplacementPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpRpmPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpRpmPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpRpmPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpRpmPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpFlowMaxPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpFlowMaxPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpFlowMaxPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpFlowMaxPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpPressurePump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpPressurePumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpPressurePump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpPressurePumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPumpFlowPump(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPumpFlowPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePumpFlowPump(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePumpFlowPumpMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideDiameterPiston(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideDiameterPistonMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideDiameterPiston(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideDiameterPistonMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideDiameterRod(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideDiameterRodMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideDiameterRod(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideDiameterRodMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readRodSideAreaRodSide(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadRodSideAreaRodSideMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeRodSideAreaRodSide(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteRodSideAreaRodSideMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readSplitter1Input(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadSplitter1InputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeSplitter1Input(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteSplitter1InputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readSplitter1Output1(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadSplitter1Output1Method(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeSplitter1Output1(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteSplitter1Output1Method(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readSplitter1Output2(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadSplitter1Output2Method(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeSplitter1Output2(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteSplitter1Output2Method(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readZeroJunctionEffort(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadZeroJunctionEffortMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeZeroJunctionEffort(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteZeroJunctionEffortMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readZeroJunctionP1E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadZeroJunctionP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeZeroJunctionP1E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteZeroJunctionP1EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readZeroJunctionP2E(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadZeroJunctionP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeZeroJunctionP2E(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteZeroJunctionP2EMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readZeroJunctionP1F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadZeroJunctionP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeZeroJunctionP1F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteZeroJunctionP1FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readZeroJunctionP2F(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadZeroJunctionP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeZeroJunctionP2F(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteZeroJunctionP2FMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readConstraintForce(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadConstraintForceMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeConstraintForce(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteConstraintForceMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readFlowGain(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadFlowGainMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeFlowGain(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteFlowGainMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonDisplacement(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonDisplacementMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonDisplacement(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonDisplacementMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readPistonSpeed(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadPistonSpeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writePistonSpeed(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWritePistonSpeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readIntegrateInput(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegrateInputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeIntegrateInput(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegrateInputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readIntegrateOutput(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegrateOutputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeIntegrateOutput(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegrateOutputMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.RealRead readIntegrateInitial(no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return blockingUnaryCall(
          getChannel(), getReadIntegrateInitialMethod(), getCallOptions(), request);
    }

    /**
     */
    public no.mechatronics.sfi.rmu.FmiDefinitions.Status writeIntegrateInitial(no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return blockingUnaryCall(
          getChannel(), getWriteIntegrateInitialMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HydraulicCylinderServiceFutureStub extends io.grpc.stub.AbstractStub<HydraulicCylinderServiceFutureStub> {
    private HydraulicCylinderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HydraulicCylinderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HydraulicCylinderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HydraulicCylinderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readDrainTankPE(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrainTankPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeDrainTankPE(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrainTankPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readDrainTankPF(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrainTankPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeDrainTankPF(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrainTankPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readDrainTankPressureTank(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrainTankPressureTankMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeDrainTankPressureTank(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrainTankPressureTankMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readDrainTankFlowTank(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadDrainTankFlowTankMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeDrainTankFlowTank(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteDrainTankFlowTankMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionFlow(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionFlow(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionP1E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionP1E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionP2E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionP2E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionP3E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP3EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionP3E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionP1F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionP1F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionP2F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionP2F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readOneJunctionP3F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneJunctionP3FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeOneJunctionP3F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneJunctionP3FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonForcePE(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonForcePEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonForcePE(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonForcePEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonForcePF(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonForcePFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonForcePF(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonForcePFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonForceEffort(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonForceEffortMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonForceEffort(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonForceEffortMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonForceFlow(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonForceFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonForceFlow(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonForceFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSideP1E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSideP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSideP1E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSideP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSideP1F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSideP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSideP1F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSideP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSideP2E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSideP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSideP2E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSideP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSideP2F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSideP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSideP2F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSideP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSideDiameterPiston(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSideDiameterPistonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSideDiameterPiston(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSideDiameterPistonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSideAreaPistonSide(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSideAreaPistonSideMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSideAreaPistonSide(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSideAreaPistonSideMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpPE(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpPE(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPEMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpPF(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpPF(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPFMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpGain(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpGainMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpGain(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpGainMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpDisplacementPump(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpDisplacementPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpDisplacementPump(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpDisplacementPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpRpmPump(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpRpmPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpRpmPump(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpRpmPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpFlowMaxPump(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpFlowMaxPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpFlowMaxPump(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpFlowMaxPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpPressurePump(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpPressurePumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpPressurePump(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpPressurePumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPumpFlowPump(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPumpFlowPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePumpFlowPump(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePumpFlowPumpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideP1E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideP1E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideP1F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideP1F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideP2E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideP2E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideP2F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideP2F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideDiameterPiston(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideDiameterPistonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideDiameterPiston(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideDiameterPistonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideDiameterRod(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideDiameterRodMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideDiameterRod(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideDiameterRodMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readRodSideAreaRodSide(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadRodSideAreaRodSideMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeRodSideAreaRodSide(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteRodSideAreaRodSideMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readSplitter1Input(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadSplitter1InputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeSplitter1Input(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteSplitter1InputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readSplitter1Output1(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadSplitter1Output1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeSplitter1Output1(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteSplitter1Output1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readSplitter1Output2(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadSplitter1Output2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeSplitter1Output2(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteSplitter1Output2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readZeroJunctionEffort(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadZeroJunctionEffortMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeZeroJunctionEffort(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteZeroJunctionEffortMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readZeroJunctionP1E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadZeroJunctionP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeZeroJunctionP1E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP1EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readZeroJunctionP2E(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadZeroJunctionP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeZeroJunctionP2E(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP2EMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readZeroJunctionP1F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadZeroJunctionP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeZeroJunctionP1F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP1FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readZeroJunctionP2F(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadZeroJunctionP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeZeroJunctionP2F(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteZeroJunctionP2FMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readConstraintForce(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadConstraintForceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeConstraintForce(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteConstraintForceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readFlowGain(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadFlowGainMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeFlowGain(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteFlowGainMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonDisplacement(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonDisplacementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonDisplacement(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonDisplacementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readPistonSpeed(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadPistonSpeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writePistonSpeed(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWritePistonSpeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readIntegrateInput(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegrateInputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeIntegrateInput(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegrateInputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readIntegrateOutput(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegrateOutputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeIntegrateOutput(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegrateOutputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead> readIntegrateInitial(
        no.mechatronics.sfi.rmu.FmiDefinitions.UInt request) {
      return futureUnaryCall(
          getChannel().newCall(getReadIntegrateInitialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<no.mechatronics.sfi.rmu.FmiDefinitions.Status> writeIntegrateInitial(
        no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteIntegrateInitialMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_DRAIN_TANK_P_E = 0;
  private static final int METHODID_WRITE_DRAIN_TANK_P_E = 1;
  private static final int METHODID_READ_DRAIN_TANK_P_F = 2;
  private static final int METHODID_WRITE_DRAIN_TANK_P_F = 3;
  private static final int METHODID_READ_DRAIN_TANK_PRESSURE_TANK = 4;
  private static final int METHODID_WRITE_DRAIN_TANK_PRESSURE_TANK = 5;
  private static final int METHODID_READ_DRAIN_TANK_FLOW_TANK = 6;
  private static final int METHODID_WRITE_DRAIN_TANK_FLOW_TANK = 7;
  private static final int METHODID_READ_ONE_JUNCTION_FLOW = 8;
  private static final int METHODID_WRITE_ONE_JUNCTION_FLOW = 9;
  private static final int METHODID_READ_ONE_JUNCTION_P1_E = 10;
  private static final int METHODID_WRITE_ONE_JUNCTION_P1_E = 11;
  private static final int METHODID_READ_ONE_JUNCTION_P2_E = 12;
  private static final int METHODID_WRITE_ONE_JUNCTION_P2_E = 13;
  private static final int METHODID_READ_ONE_JUNCTION_P3_E = 14;
  private static final int METHODID_WRITE_ONE_JUNCTION_P3_E = 15;
  private static final int METHODID_READ_ONE_JUNCTION_P1_F = 16;
  private static final int METHODID_WRITE_ONE_JUNCTION_P1_F = 17;
  private static final int METHODID_READ_ONE_JUNCTION_P2_F = 18;
  private static final int METHODID_WRITE_ONE_JUNCTION_P2_F = 19;
  private static final int METHODID_READ_ONE_JUNCTION_P3_F = 20;
  private static final int METHODID_WRITE_ONE_JUNCTION_P3_F = 21;
  private static final int METHODID_READ_PISTON_FORCE_P_E = 22;
  private static final int METHODID_WRITE_PISTON_FORCE_P_E = 23;
  private static final int METHODID_READ_PISTON_FORCE_P_F = 24;
  private static final int METHODID_WRITE_PISTON_FORCE_P_F = 25;
  private static final int METHODID_READ_PISTON_FORCE_EFFORT = 26;
  private static final int METHODID_WRITE_PISTON_FORCE_EFFORT = 27;
  private static final int METHODID_READ_PISTON_FORCE_FLOW = 28;
  private static final int METHODID_WRITE_PISTON_FORCE_FLOW = 29;
  private static final int METHODID_READ_PISTON_SIDE_P1_E = 30;
  private static final int METHODID_WRITE_PISTON_SIDE_P1_E = 31;
  private static final int METHODID_READ_PISTON_SIDE_P1_F = 32;
  private static final int METHODID_WRITE_PISTON_SIDE_P1_F = 33;
  private static final int METHODID_READ_PISTON_SIDE_P2_E = 34;
  private static final int METHODID_WRITE_PISTON_SIDE_P2_E = 35;
  private static final int METHODID_READ_PISTON_SIDE_P2_F = 36;
  private static final int METHODID_WRITE_PISTON_SIDE_P2_F = 37;
  private static final int METHODID_READ_PISTON_SIDE_DIAMETER_PISTON = 38;
  private static final int METHODID_WRITE_PISTON_SIDE_DIAMETER_PISTON = 39;
  private static final int METHODID_READ_PISTON_SIDE_AREA_PISTON_SIDE = 40;
  private static final int METHODID_WRITE_PISTON_SIDE_AREA_PISTON_SIDE = 41;
  private static final int METHODID_READ_PUMP_P_E = 42;
  private static final int METHODID_WRITE_PUMP_P_E = 43;
  private static final int METHODID_READ_PUMP_P_F = 44;
  private static final int METHODID_WRITE_PUMP_P_F = 45;
  private static final int METHODID_READ_PUMP_GAIN = 46;
  private static final int METHODID_WRITE_PUMP_GAIN = 47;
  private static final int METHODID_READ_PUMP_DISPLACEMENT_PUMP = 48;
  private static final int METHODID_WRITE_PUMP_DISPLACEMENT_PUMP = 49;
  private static final int METHODID_READ_PUMP_RPM_PUMP = 50;
  private static final int METHODID_WRITE_PUMP_RPM_PUMP = 51;
  private static final int METHODID_READ_PUMP_FLOW_MAX_PUMP = 52;
  private static final int METHODID_WRITE_PUMP_FLOW_MAX_PUMP = 53;
  private static final int METHODID_READ_PUMP_PRESSURE_PUMP = 54;
  private static final int METHODID_WRITE_PUMP_PRESSURE_PUMP = 55;
  private static final int METHODID_READ_PUMP_FLOW_PUMP = 56;
  private static final int METHODID_WRITE_PUMP_FLOW_PUMP = 57;
  private static final int METHODID_READ_ROD_SIDE_P1_E = 58;
  private static final int METHODID_WRITE_ROD_SIDE_P1_E = 59;
  private static final int METHODID_READ_ROD_SIDE_P1_F = 60;
  private static final int METHODID_WRITE_ROD_SIDE_P1_F = 61;
  private static final int METHODID_READ_ROD_SIDE_P2_E = 62;
  private static final int METHODID_WRITE_ROD_SIDE_P2_E = 63;
  private static final int METHODID_READ_ROD_SIDE_P2_F = 64;
  private static final int METHODID_WRITE_ROD_SIDE_P2_F = 65;
  private static final int METHODID_READ_ROD_SIDE_DIAMETER_PISTON = 66;
  private static final int METHODID_WRITE_ROD_SIDE_DIAMETER_PISTON = 67;
  private static final int METHODID_READ_ROD_SIDE_DIAMETER_ROD = 68;
  private static final int METHODID_WRITE_ROD_SIDE_DIAMETER_ROD = 69;
  private static final int METHODID_READ_ROD_SIDE_AREA_ROD_SIDE = 70;
  private static final int METHODID_WRITE_ROD_SIDE_AREA_ROD_SIDE = 71;
  private static final int METHODID_READ_SPLITTER1_INPUT = 72;
  private static final int METHODID_WRITE_SPLITTER1_INPUT = 73;
  private static final int METHODID_READ_SPLITTER1_OUTPUT1 = 74;
  private static final int METHODID_WRITE_SPLITTER1_OUTPUT1 = 75;
  private static final int METHODID_READ_SPLITTER1_OUTPUT2 = 76;
  private static final int METHODID_WRITE_SPLITTER1_OUTPUT2 = 77;
  private static final int METHODID_READ_ZERO_JUNCTION_EFFORT = 78;
  private static final int METHODID_WRITE_ZERO_JUNCTION_EFFORT = 79;
  private static final int METHODID_READ_ZERO_JUNCTION_P1_E = 80;
  private static final int METHODID_WRITE_ZERO_JUNCTION_P1_E = 81;
  private static final int METHODID_READ_ZERO_JUNCTION_P2_E = 82;
  private static final int METHODID_WRITE_ZERO_JUNCTION_P2_E = 83;
  private static final int METHODID_READ_ZERO_JUNCTION_P1_F = 84;
  private static final int METHODID_WRITE_ZERO_JUNCTION_P1_F = 85;
  private static final int METHODID_READ_ZERO_JUNCTION_P2_F = 86;
  private static final int METHODID_WRITE_ZERO_JUNCTION_P2_F = 87;
  private static final int METHODID_READ_CONSTRAINT_FORCE = 88;
  private static final int METHODID_WRITE_CONSTRAINT_FORCE = 89;
  private static final int METHODID_READ_FLOW_GAIN = 90;
  private static final int METHODID_WRITE_FLOW_GAIN = 91;
  private static final int METHODID_READ_PISTON_DISPLACEMENT = 92;
  private static final int METHODID_WRITE_PISTON_DISPLACEMENT = 93;
  private static final int METHODID_READ_PISTON_SPEED = 94;
  private static final int METHODID_WRITE_PISTON_SPEED = 95;
  private static final int METHODID_READ_INTEGRATE_INPUT = 96;
  private static final int METHODID_WRITE_INTEGRATE_INPUT = 97;
  private static final int METHODID_READ_INTEGRATE_OUTPUT = 98;
  private static final int METHODID_WRITE_INTEGRATE_OUTPUT = 99;
  private static final int METHODID_READ_INTEGRATE_INITIAL = 100;
  private static final int METHODID_WRITE_INTEGRATE_INITIAL = 101;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HydraulicCylinderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HydraulicCylinderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READ_DRAIN_TANK_P_E:
          serviceImpl.readDrainTankPE((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_DRAIN_TANK_P_E:
          serviceImpl.writeDrainTankPE((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRAIN_TANK_P_F:
          serviceImpl.readDrainTankPF((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_DRAIN_TANK_P_F:
          serviceImpl.writeDrainTankPF((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRAIN_TANK_PRESSURE_TANK:
          serviceImpl.readDrainTankPressureTank((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_DRAIN_TANK_PRESSURE_TANK:
          serviceImpl.writeDrainTankPressureTank((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_DRAIN_TANK_FLOW_TANK:
          serviceImpl.readDrainTankFlowTank((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_DRAIN_TANK_FLOW_TANK:
          serviceImpl.writeDrainTankFlowTank((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_FLOW:
          serviceImpl.readOneJunctionFlow((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_FLOW:
          serviceImpl.writeOneJunctionFlow((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P1_E:
          serviceImpl.readOneJunctionP1E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P1_E:
          serviceImpl.writeOneJunctionP1E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P2_E:
          serviceImpl.readOneJunctionP2E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P2_E:
          serviceImpl.writeOneJunctionP2E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P3_E:
          serviceImpl.readOneJunctionP3E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P3_E:
          serviceImpl.writeOneJunctionP3E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P1_F:
          serviceImpl.readOneJunctionP1F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P1_F:
          serviceImpl.writeOneJunctionP1F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P2_F:
          serviceImpl.readOneJunctionP2F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P2_F:
          serviceImpl.writeOneJunctionP2F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ONE_JUNCTION_P3_F:
          serviceImpl.readOneJunctionP3F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ONE_JUNCTION_P3_F:
          serviceImpl.writeOneJunctionP3F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_FORCE_P_E:
          serviceImpl.readPistonForcePE((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_FORCE_P_E:
          serviceImpl.writePistonForcePE((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_FORCE_P_F:
          serviceImpl.readPistonForcePF((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_FORCE_P_F:
          serviceImpl.writePistonForcePF((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_FORCE_EFFORT:
          serviceImpl.readPistonForceEffort((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_FORCE_EFFORT:
          serviceImpl.writePistonForceEffort((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_FORCE_FLOW:
          serviceImpl.readPistonForceFlow((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_FORCE_FLOW:
          serviceImpl.writePistonForceFlow((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SIDE_P1_E:
          serviceImpl.readPistonSideP1E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SIDE_P1_E:
          serviceImpl.writePistonSideP1E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SIDE_P1_F:
          serviceImpl.readPistonSideP1F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SIDE_P1_F:
          serviceImpl.writePistonSideP1F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SIDE_P2_E:
          serviceImpl.readPistonSideP2E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SIDE_P2_E:
          serviceImpl.writePistonSideP2E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SIDE_P2_F:
          serviceImpl.readPistonSideP2F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SIDE_P2_F:
          serviceImpl.writePistonSideP2F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SIDE_DIAMETER_PISTON:
          serviceImpl.readPistonSideDiameterPiston((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SIDE_DIAMETER_PISTON:
          serviceImpl.writePistonSideDiameterPiston((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SIDE_AREA_PISTON_SIDE:
          serviceImpl.readPistonSideAreaPistonSide((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SIDE_AREA_PISTON_SIDE:
          serviceImpl.writePistonSideAreaPistonSide((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_P_E:
          serviceImpl.readPumpPE((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_P_E:
          serviceImpl.writePumpPE((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_P_F:
          serviceImpl.readPumpPF((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_P_F:
          serviceImpl.writePumpPF((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_GAIN:
          serviceImpl.readPumpGain((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_GAIN:
          serviceImpl.writePumpGain((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_DISPLACEMENT_PUMP:
          serviceImpl.readPumpDisplacementPump((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_DISPLACEMENT_PUMP:
          serviceImpl.writePumpDisplacementPump((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_RPM_PUMP:
          serviceImpl.readPumpRpmPump((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_RPM_PUMP:
          serviceImpl.writePumpRpmPump((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_FLOW_MAX_PUMP:
          serviceImpl.readPumpFlowMaxPump((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_FLOW_MAX_PUMP:
          serviceImpl.writePumpFlowMaxPump((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_PRESSURE_PUMP:
          serviceImpl.readPumpPressurePump((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_PRESSURE_PUMP:
          serviceImpl.writePumpPressurePump((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PUMP_FLOW_PUMP:
          serviceImpl.readPumpFlowPump((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PUMP_FLOW_PUMP:
          serviceImpl.writePumpFlowPump((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_P1_E:
          serviceImpl.readRodSideP1E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_P1_E:
          serviceImpl.writeRodSideP1E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_P1_F:
          serviceImpl.readRodSideP1F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_P1_F:
          serviceImpl.writeRodSideP1F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_P2_E:
          serviceImpl.readRodSideP2E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_P2_E:
          serviceImpl.writeRodSideP2E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_P2_F:
          serviceImpl.readRodSideP2F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_P2_F:
          serviceImpl.writeRodSideP2F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_DIAMETER_PISTON:
          serviceImpl.readRodSideDiameterPiston((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_DIAMETER_PISTON:
          serviceImpl.writeRodSideDiameterPiston((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_DIAMETER_ROD:
          serviceImpl.readRodSideDiameterRod((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_DIAMETER_ROD:
          serviceImpl.writeRodSideDiameterRod((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ROD_SIDE_AREA_ROD_SIDE:
          serviceImpl.readRodSideAreaRodSide((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ROD_SIDE_AREA_ROD_SIDE:
          serviceImpl.writeRodSideAreaRodSide((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_SPLITTER1_INPUT:
          serviceImpl.readSplitter1Input((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_SPLITTER1_INPUT:
          serviceImpl.writeSplitter1Input((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_SPLITTER1_OUTPUT1:
          serviceImpl.readSplitter1Output1((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_SPLITTER1_OUTPUT1:
          serviceImpl.writeSplitter1Output1((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_SPLITTER1_OUTPUT2:
          serviceImpl.readSplitter1Output2((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_SPLITTER1_OUTPUT2:
          serviceImpl.writeSplitter1Output2((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ZERO_JUNCTION_EFFORT:
          serviceImpl.readZeroJunctionEffort((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ZERO_JUNCTION_EFFORT:
          serviceImpl.writeZeroJunctionEffort((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ZERO_JUNCTION_P1_E:
          serviceImpl.readZeroJunctionP1E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ZERO_JUNCTION_P1_E:
          serviceImpl.writeZeroJunctionP1E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ZERO_JUNCTION_P2_E:
          serviceImpl.readZeroJunctionP2E((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ZERO_JUNCTION_P2_E:
          serviceImpl.writeZeroJunctionP2E((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ZERO_JUNCTION_P1_F:
          serviceImpl.readZeroJunctionP1F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ZERO_JUNCTION_P1_F:
          serviceImpl.writeZeroJunctionP1F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_ZERO_JUNCTION_P2_F:
          serviceImpl.readZeroJunctionP2F((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_ZERO_JUNCTION_P2_F:
          serviceImpl.writeZeroJunctionP2F((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_CONSTRAINT_FORCE:
          serviceImpl.readConstraintForce((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_CONSTRAINT_FORCE:
          serviceImpl.writeConstraintForce((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_FLOW_GAIN:
          serviceImpl.readFlowGain((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_FLOW_GAIN:
          serviceImpl.writeFlowGain((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_DISPLACEMENT:
          serviceImpl.readPistonDisplacement((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_DISPLACEMENT:
          serviceImpl.writePistonDisplacement((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_PISTON_SPEED:
          serviceImpl.readPistonSpeed((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_PISTON_SPEED:
          serviceImpl.writePistonSpeed((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INTEGRATE_INPUT:
          serviceImpl.readIntegrateInput((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGRATE_INPUT:
          serviceImpl.writeIntegrateInput((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INTEGRATE_OUTPUT:
          serviceImpl.readIntegrateOutput((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGRATE_OUTPUT:
          serviceImpl.writeIntegrateOutput((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
          break;
        case METHODID_READ_INTEGRATE_INITIAL:
          serviceImpl.readIntegrateInitial((no.mechatronics.sfi.rmu.FmiDefinitions.UInt) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.RealRead>) responseObserver);
          break;
        case METHODID_WRITE_INTEGRATE_INITIAL:
          serviceImpl.writeIntegrateInitial((no.mechatronics.sfi.rmu.HydraulicCylinderProto.RealWrite) request,
              (io.grpc.stub.StreamObserver<no.mechatronics.sfi.rmu.FmiDefinitions.Status>) responseObserver);
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

  private static abstract class HydraulicCylinderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HydraulicCylinderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return no.mechatronics.sfi.rmu.HydraulicCylinderProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HydraulicCylinderService");
    }
  }

  private static final class HydraulicCylinderServiceFileDescriptorSupplier
      extends HydraulicCylinderServiceBaseDescriptorSupplier {
    HydraulicCylinderServiceFileDescriptorSupplier() {}
  }

  private static final class HydraulicCylinderServiceMethodDescriptorSupplier
      extends HydraulicCylinderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HydraulicCylinderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HydraulicCylinderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HydraulicCylinderServiceFileDescriptorSupplier())
              .addMethod(getReadDrainTankPEMethod())
              .addMethod(getWriteDrainTankPEMethod())
              .addMethod(getReadDrainTankPFMethod())
              .addMethod(getWriteDrainTankPFMethod())
              .addMethod(getReadDrainTankPressureTankMethod())
              .addMethod(getWriteDrainTankPressureTankMethod())
              .addMethod(getReadDrainTankFlowTankMethod())
              .addMethod(getWriteDrainTankFlowTankMethod())
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
              .addMethod(getReadPistonForcePEMethod())
              .addMethod(getWritePistonForcePEMethod())
              .addMethod(getReadPistonForcePFMethod())
              .addMethod(getWritePistonForcePFMethod())
              .addMethod(getReadPistonForceEffortMethod())
              .addMethod(getWritePistonForceEffortMethod())
              .addMethod(getReadPistonForceFlowMethod())
              .addMethod(getWritePistonForceFlowMethod())
              .addMethod(getReadPistonSideP1EMethod())
              .addMethod(getWritePistonSideP1EMethod())
              .addMethod(getReadPistonSideP1FMethod())
              .addMethod(getWritePistonSideP1FMethod())
              .addMethod(getReadPistonSideP2EMethod())
              .addMethod(getWritePistonSideP2EMethod())
              .addMethod(getReadPistonSideP2FMethod())
              .addMethod(getWritePistonSideP2FMethod())
              .addMethod(getReadPistonSideDiameterPistonMethod())
              .addMethod(getWritePistonSideDiameterPistonMethod())
              .addMethod(getReadPistonSideAreaPistonSideMethod())
              .addMethod(getWritePistonSideAreaPistonSideMethod())
              .addMethod(getReadPumpPEMethod())
              .addMethod(getWritePumpPEMethod())
              .addMethod(getReadPumpPFMethod())
              .addMethod(getWritePumpPFMethod())
              .addMethod(getReadPumpGainMethod())
              .addMethod(getWritePumpGainMethod())
              .addMethod(getReadPumpDisplacementPumpMethod())
              .addMethod(getWritePumpDisplacementPumpMethod())
              .addMethod(getReadPumpRpmPumpMethod())
              .addMethod(getWritePumpRpmPumpMethod())
              .addMethod(getReadPumpFlowMaxPumpMethod())
              .addMethod(getWritePumpFlowMaxPumpMethod())
              .addMethod(getReadPumpPressurePumpMethod())
              .addMethod(getWritePumpPressurePumpMethod())
              .addMethod(getReadPumpFlowPumpMethod())
              .addMethod(getWritePumpFlowPumpMethod())
              .addMethod(getReadRodSideP1EMethod())
              .addMethod(getWriteRodSideP1EMethod())
              .addMethod(getReadRodSideP1FMethod())
              .addMethod(getWriteRodSideP1FMethod())
              .addMethod(getReadRodSideP2EMethod())
              .addMethod(getWriteRodSideP2EMethod())
              .addMethod(getReadRodSideP2FMethod())
              .addMethod(getWriteRodSideP2FMethod())
              .addMethod(getReadRodSideDiameterPistonMethod())
              .addMethod(getWriteRodSideDiameterPistonMethod())
              .addMethod(getReadRodSideDiameterRodMethod())
              .addMethod(getWriteRodSideDiameterRodMethod())
              .addMethod(getReadRodSideAreaRodSideMethod())
              .addMethod(getWriteRodSideAreaRodSideMethod())
              .addMethod(getReadSplitter1InputMethod())
              .addMethod(getWriteSplitter1InputMethod())
              .addMethod(getReadSplitter1Output1Method())
              .addMethod(getWriteSplitter1Output1Method())
              .addMethod(getReadSplitter1Output2Method())
              .addMethod(getWriteSplitter1Output2Method())
              .addMethod(getReadZeroJunctionEffortMethod())
              .addMethod(getWriteZeroJunctionEffortMethod())
              .addMethod(getReadZeroJunctionP1EMethod())
              .addMethod(getWriteZeroJunctionP1EMethod())
              .addMethod(getReadZeroJunctionP2EMethod())
              .addMethod(getWriteZeroJunctionP2EMethod())
              .addMethod(getReadZeroJunctionP1FMethod())
              .addMethod(getWriteZeroJunctionP1FMethod())
              .addMethod(getReadZeroJunctionP2FMethod())
              .addMethod(getWriteZeroJunctionP2FMethod())
              .addMethod(getReadConstraintForceMethod())
              .addMethod(getWriteConstraintForceMethod())
              .addMethod(getReadFlowGainMethod())
              .addMethod(getWriteFlowGainMethod())
              .addMethod(getReadPistonDisplacementMethod())
              .addMethod(getWritePistonDisplacementMethod())
              .addMethod(getReadPistonSpeedMethod())
              .addMethod(getWritePistonSpeedMethod())
              .addMethod(getReadIntegrateInputMethod())
              .addMethod(getWriteIntegrateInputMethod())
              .addMethod(getReadIntegrateOutputMethod())
              .addMethod(getWriteIntegrateOutputMethod())
              .addMethod(getReadIntegrateInitialMethod())
              .addMethod(getWriteIntegrateInitialMethod())
              .build();
        }
      }
    }
    return result;
  }
}
