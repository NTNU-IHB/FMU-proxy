// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

public interface BulkReadRequestProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:no.mechatronics.sfi.fmu_proxy.grpc.BulkReadRequestProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 fmu_id = 1;</code>
   */
  int getFmuId();

  /**
   * <code>repeated uint32 value_references = 2;</code>
   */
  java.util.List<java.lang.Integer> getValueReferencesList();
  /**
   * <code>repeated uint32 value_references = 2;</code>
   */
  int getValueReferencesCount();
  /**
   * <code>repeated uint32 value_references = 2;</code>
   */
  int getValueReferences(int index);
}
