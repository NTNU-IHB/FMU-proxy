// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

public interface AnyPrimitiveProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:no.mechatronics.sfi.fmu_proxy.grpc.AnyPrimitiveProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 int_value = 1;</code>
   */
  int getIntValue();

  /**
   * <code>double real_value = 2;</code>
   */
  double getRealValue();

  /**
   * <code>string str_value = 3;</code>
   */
  java.lang.String getStrValue();
  /**
   * <code>string str_value = 3;</code>
   */
  com.google.protobuf.ByteString
      getStrValueBytes();

  /**
   * <code>bool bool_value = 4;</code>
   */
  boolean getBoolValue();

  /**
   * <code>uint32 enum_value = 5;</code>
   */
  int getEnumValue();

  public no.mechatronics.sfi.fmu_proxy.grpc.AnyPrimitiveProto.ValueCase getValueCase();
}
