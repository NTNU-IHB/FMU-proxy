// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

/**
 * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto}
 */
public  final class StrReadProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto)
    StrReadProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StrReadProto.newBuilder() to construct.
  private StrReadProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StrReadProto() {
    value_ = "";
    status_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StrReadProto(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            value_ = s;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            status_ = rawValue;
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
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_StrReadProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_StrReadProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.class, no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.Builder.class);
  }

  public static final int VALUE_FIELD_NUMBER = 1;
  private volatile java.lang.Object value_;
  /**
   * <code>string value = 1;</code>
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
   * <code>string value = 1;</code>
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

  public static final int STATUS_FIELD_NUMBER = 2;
  private int status_;
  /**
   * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
   */
  public no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto getStatus() {
    no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto result = no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto.valueOf(status_);
    return result == null ? no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto.UNRECOGNIZED : result;
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
    if (!getValueBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, value_);
    }
    if (status_ != no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto.OK_STATUS.getNumber()) {
      output.writeEnum(2, status_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getValueBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, value_);
    }
    if (status_ != no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto.OK_STATUS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, status_);
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
    if (!(obj instanceof no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto)) {
      return super.equals(obj);
    }
    no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto other = (no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto) obj;

    boolean result = true;
    result = result && getValue()
        .equals(other.getValue());
    result = result && status_ == other.status_;
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
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parseFrom(
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
  public static Builder newBuilder(no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto prototype) {
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
   * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto)
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_StrReadProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_StrReadProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.class, no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.Builder.class);
    }

    // Construct using no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.newBuilder()
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
      value_ = "";

      status_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_StrReadProto_descriptor;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto getDefaultInstanceForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.getDefaultInstance();
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto build() {
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto buildPartial() {
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto result = new no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto(this);
      result.value_ = value_;
      result.status_ = status_;
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
      if (other instanceof no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto) {
        return mergeFrom((no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto other) {
      if (other == no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto.getDefaultInstance()) return this;
      if (!other.getValue().isEmpty()) {
        value_ = other.value_;
        onChanged();
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
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
      no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object value_ = "";
    /**
     * <code>string value = 1;</code>
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
     * <code>string value = 1;</code>
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
     * <code>string value = 1;</code>
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
     * <code>string value = 1;</code>
     */
    public Builder clearValue() {
      
      value_ = getDefaultInstance().getValue();
      onChanged();
      return this;
    }
    /**
     * <code>string value = 1;</code>
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

    private int status_ = 0;
    /**
     * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
     */
    public no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto getStatus() {
      no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto result = no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto.valueOf(status_);
      return result == null ? no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto.UNRECOGNIZED : result;
    }
    /**
     * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
     */
    public Builder setStatus(no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto status = 2;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
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


    // @@protoc_insertion_point(builder_scope:no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto)
  }

  // @@protoc_insertion_point(class_scope:no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto)
  private static final no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto();
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StrReadProto>
      PARSER = new com.google.protobuf.AbstractParser<StrReadProto>() {
    public StrReadProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StrReadProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StrReadProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StrReadProto> getParserForType() {
    return PARSER;
  }

  public no.mechatronics.sfi.fmu_proxy.grpc.StrReadProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

