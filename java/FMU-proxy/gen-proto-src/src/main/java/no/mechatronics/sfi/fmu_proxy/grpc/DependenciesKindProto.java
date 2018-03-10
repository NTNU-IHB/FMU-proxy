// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

/**
 * Protobuf enum {@code no.mechatronics.sfi.fmu_proxy.grpc.DependenciesKindProto}
 */
public enum DependenciesKindProto
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>DEPENDENT_KIND = 0;</code>
   */
  DEPENDENT_KIND(0),
  /**
   * <code>CONSTANT_KIND = 1;</code>
   */
  CONSTANT_KIND(1),
  /**
   * <code>TUNABLE_KIND = 2;</code>
   */
  TUNABLE_KIND(2),
  /**
   * <code>DISCRETE_KIND = 4;</code>
   */
  DISCRETE_KIND(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>DEPENDENT_KIND = 0;</code>
   */
  public static final int DEPENDENT_KIND_VALUE = 0;
  /**
   * <code>CONSTANT_KIND = 1;</code>
   */
  public static final int CONSTANT_KIND_VALUE = 1;
  /**
   * <code>TUNABLE_KIND = 2;</code>
   */
  public static final int TUNABLE_KIND_VALUE = 2;
  /**
   * <code>DISCRETE_KIND = 4;</code>
   */
  public static final int DISCRETE_KIND_VALUE = 4;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static DependenciesKindProto valueOf(int value) {
    return forNumber(value);
  }

  public static DependenciesKindProto forNumber(int value) {
    switch (value) {
      case 0: return DEPENDENT_KIND;
      case 1: return CONSTANT_KIND;
      case 2: return TUNABLE_KIND;
      case 4: return DISCRETE_KIND;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DependenciesKindProto>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      DependenciesKindProto> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<DependenciesKindProto>() {
          public DependenciesKindProto findValueByNumber(int number) {
            return DependenciesKindProto.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.getDescriptor().getEnumTypes().get(5);
  }

  private static final DependenciesKindProto[] VALUES = values();

  public static DependenciesKindProto valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private DependenciesKindProto(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:no.mechatronics.sfi.fmu_proxy.grpc.DependenciesKindProto)
}
