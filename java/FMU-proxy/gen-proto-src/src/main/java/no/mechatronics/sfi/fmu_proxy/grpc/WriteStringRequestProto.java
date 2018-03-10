// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

/**
 * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto}
 */
public  final class WriteStringRequestProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)
    WriteStringRequestProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WriteStringRequestProto.newBuilder() to construct.
  private WriteStringRequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WriteStringRequestProto() {
    fmuId_ = 0;
    valueReference_ = 0;
    value_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WriteStringRequestProto(
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
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            value_ = s;
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
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteStringRequestProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteStringRequestProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.class, no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.Builder.class);
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
  private volatile java.lang.Object value_;
  /**
   * <code>string value = 3;</code>
   */
  public java.lang.String getValue() {
    java.lang.Object ref = value_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      value_ = s;
      return s;
    }
  }
  /**
   * <code>string value = 3;</code>
   */
  public com.google.protobuf.ByteString
      getValueBytes() {
    java.lang.Object ref = value_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      value_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getValueBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, value_);
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
    if (!getValueBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, value_);
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
    if (!(obj instanceof no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)) {
      return super.equals(obj);
    }
    no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto other = (no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto) obj;

    boolean result = true;
    result = result && (getFmuId()
        == other.getFmuId());
    result = result && (getValueReference()
        == other.getValueReference());
    result = result && getValue()
        .equals(other.getValue());
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
    hash = (53 * hash) + getValue().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parseFrom(
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
  public static Builder newBuilder(no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto prototype) {
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
   * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)
      no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteStringRequestProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteStringRequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.class, no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.Builder.class);
    }

    // Construct using no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.newBuilder()
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

      value_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_WriteStringRequestProto_descriptor;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto getDefaultInstanceForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.getDefaultInstance();
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto build() {
      no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto buildPartial() {
      no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto result = new no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto(this);
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
      if (other instanceof no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto) {
        return mergeFrom((no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto other) {
      if (other == no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto.getDefaultInstance()) return this;
      if (other.getFmuId() != 0) {
        setFmuId(other.getFmuId());
      }
      if (other.getValueReference() != 0) {
        setValueReference(other.getValueReference());
      }
      if (!other.getValue().isEmpty()) {
        value_ = other.value_;
        onChanged();
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
      no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto) e.getUnfinishedMessage();
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

    private java.lang.Object value_ = "";
    /**
     * <code>string value = 3;</code>
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string value = 3;</code>
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string value = 3;</code>
     */
    public Builder setValue(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string value = 3;</code>
     */
    public Builder clearValue() {
      
      value_ = getDefaultInstance().getValue();
      onChanged();
      return this;
    }
    /**
     * <code>string value = 3;</code>
     */
    public Builder setValueBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      value_ = value;
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


    // @@protoc_insertion_point(builder_scope:no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)
  }

  // @@protoc_insertion_point(class_scope:no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto)
  private static final no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto();
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WriteStringRequestProto>
      PARSER = new com.google.protobuf.AbstractParser<WriteStringRequestProto>() {
    public WriteStringRequestProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WriteStringRequestProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WriteStringRequestProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WriteStringRequestProto> getParserForType() {
    return PARSER;
  }

  public no.mechatronics.sfi.fmu_proxy.grpc.WriteStringRequestProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

