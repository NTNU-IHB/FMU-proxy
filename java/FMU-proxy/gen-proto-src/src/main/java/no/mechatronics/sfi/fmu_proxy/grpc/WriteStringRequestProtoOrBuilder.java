// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

public interface WriteStringRequestProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 fmu_id = 1;</code>
   */
  int getFmuId();

  /**
   * <code>uint32 value_reference = 2;</code>
   */
  int getValueReference();

  /**
   * <code>string value = 3;</code>
   */
  java.lang.String getValue();
  /**
   * <code>string value = 3;</code>
   */
  com.google.protobuf.ByteString
      getValueBytes();
}