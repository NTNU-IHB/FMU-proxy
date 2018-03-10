// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

/**
 * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto}
 */
public  final class WriteIntegerRequestProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto)
    WriteIntegerRequestProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WriteIntegerRequestProto.newBuilder() to construct.
  private WriteIntegerRequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WriteIntegerRequestProto() {
    fmuId_ = 0;
    valueReference_ = 0;
    value_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WriteIntegerRequestProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            fmuId_ = input.readUInt32();
            break;
          }
          case 16: {

            valueReference_ = input.readUInt32();
            break;
          }
          case 24: {

            value_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteIntegerRequestProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteIntegerRequestProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.class, no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.Builder.class);
  }

  public static final int FMU_ID_FIELD_NUMBER = 1;
  private int fmuId_;
  /**
   * <code>uint32 fmu_id = 1;</code>
   */
  public int getFmuId() {
    return fmuId_;
  }

  public static final int VALUE_REFERENCE_FIELD_NUMBER = 2;
  private int valueReference_;
  /**
   * <code>uint32 value_reference = 2;</code>
   */
  public int getValueReference() {
    return valueReference_;
  }

  public static final int VALUE_FIELD_NUMBER = 3;
  private int value_;
  /**
   * <code>int32 value = 3;</code>
   */
  public int getValue() {
    return value_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (fmuId_ != 0) {
      output.writeUInt32(1, fmuId_);
    }
    if (valueReference_ != 0) {
      output.writeUInt32(2, valueReference_);
    }
    if (value_ != 0) {
      output.writeInt32(3, value_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (fmuId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, fmuId_);
    }
    if (valueReference_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, valueReference_);
    }
    if (value_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, value_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto)) {
      return super.equals(obj);
    }
    no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto other = (no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto) obj;

    boolean result = true;
    result = result && (getFmuId()
        == other.getFmuId());
    result = result && (getValueReference()
        == other.getValueReference());
    result = result && (getValue()
        == other.getValue());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FMU_ID_FIELD_NUMBER;
    hash = (53 * hash) + getFmuId();
    hash = (37 * hash) + VALUE_REFERENCE_FIELD_NUMBER;
    hash = (53 * hash) + getValueReference();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto)
      no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteIntegerRequestProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteIntegerRequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.class, no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.Builder.class);
    }

    // Construct using no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      fmuId_ = 0;

      valueReference_ = 0;

      value_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteIntegerRequestProto_descriptor;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto getDefaultInstanceForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.getDefaultInstance();
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto build() {
      no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto buildPartial() {
      no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto result = new no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto(this);
      result.fmuId_ = fmuId_;
      result.valueReference_ = valueReference_;
      result.value_ = value_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto) {
        return mergeFrom((no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto other) {
      if (other == no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto.getDefaultInstance()) return this;
      if (other.getFmuId() != 0) {
        setFmuId(other.getFmuId());
      }
      if (other.getValueReference() != 0) {
        setValueReference(other.getValueReference());
      }
      if (other.getValue() != 0) {
        setValue(other.getValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int fmuId_ ;
    /**
     * <code>uint32 fmu_id = 1;</code>
     */
    public int getFmuId() {
      return fmuId_;
    }
    /**
     * <code>uint32 fmu_id = 1;</code>
     */
    public Builder setFmuId(int value) {
      
      fmuId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 fmu_id = 1;</code>
     */
    public Builder clearFmuId() {
      
      fmuId_ = 0;
      onChanged();
      return this;
    }

    private int valueReference_ ;
    /**
     * <code>uint32 value_reference = 2;</code>
     */
    public int getValueReference() {
      return valueReference_;
    }
    /**
     * <code>uint32 value_reference = 2;</code>
     */
    public Builder setValueReference(int value) {
      
      valueReference_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 value_reference = 2;</code>
     */
    public Builder clearValueReference() {
      
      valueReference_ = 0;
      onChanged();
      return this;
    }

    private int value_ ;
    /**
     * <code>int32 value = 3;</code>
     */
    public int getValue() {
      return value_;
    }
    /**
     * <code>int32 value = 3;</code>
     */
    public Builder setValue(int value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 value = 3;</code>
     */
    public Builder clearValue() {
      
      value_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto)
  }

  // @@protoc_insertion_point(class_scope:no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto)
  private static final no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto();
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WriteIntegerRequestProto>
      PARSER = new com.google.protobuf.AbstractParser<WriteIntegerRequestProto>() {
    public WriteIntegerRequestProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WriteIntegerRequestProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WriteIntegerRequestProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WriteIntegerRequestProto> getParserForType() {
    return PARSER;
  }

  public no.mechatronics.sfi.fmu_proxy.grpc.WriteIntegerRequestProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
