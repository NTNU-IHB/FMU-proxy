// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: definitions.proto

package no.mechatronics.sfi.fmu_proxy.grpc;

/**
 * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto}
 */
public  final class InitRequestProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto)
    InitRequestProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InitRequestProto.newBuilder() to construct.
  private InitRequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InitRequestProto() {
    fmuId_ = 0;
    start_ = 0D;
    stop_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private InitRequestProto(
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
          case 17: {

            start_ = input.readDouble();
            break;
          }
          case 25: {

            stop_ = input.readDouble();
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
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_InitRequestProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_InitRequestProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.class, no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.Builder.class);
  }

  public static final int FMU_ID_FIELD_NUMBER = 1;
  private int fmuId_;
  /**
   * <code>uint32 fmu_id = 1;</code>
   */
  public int getFmuId() {
    return fmuId_;
  }

  public static final int START_FIELD_NUMBER = 2;
  private double start_;
  /**
   * <code>double start = 2;</code>
   */
  public double getStart() {
    return start_;
  }

  public static final int STOP_FIELD_NUMBER = 3;
  private double stop_;
  /**
   * <code>double stop = 3;</code>
   */
  public double getStop() {
    return stop_;
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
    if (start_ != 0D) {
      output.writeDouble(2, start_);
    }
    if (stop_ != 0D) {
      output.writeDouble(3, stop_);
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
    if (start_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, start_);
    }
    if (stop_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, stop_);
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
    if (!(obj instanceof no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto)) {
      return super.equals(obj);
    }
    no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto other = (no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto) obj;

    boolean result = true;
    result = result && (getFmuId()
        == other.getFmuId());
    result = result && (
        java.lang.Double.doubleToLongBits(getStart())
        == java.lang.Double.doubleToLongBits(
            other.getStart()));
    result = result && (
        java.lang.Double.doubleToLongBits(getStop())
        == java.lang.Double.doubleToLongBits(
            other.getStop()));
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
    hash = (37 * hash) + START_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getStart()));
    hash = (37 * hash) + STOP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getStop()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parseFrom(
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
  public static Builder newBuilder(no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto prototype) {
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
   * Protobuf type {@code no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto)
      no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_InitRequestProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_InitRequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.class, no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.Builder.class);
    }

    // Construct using no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.newBuilder()
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

      start_ = 0D;

      stop_ = 0D;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.Definitions.internal_static_no_mechatronics_sfi_fmu_proxy_grpc_InitRequestProto_descriptor;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto getDefaultInstanceForType() {
      return no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.getDefaultInstance();
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto build() {
      no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto buildPartial() {
      no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto result = new no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto(this);
      result.fmuId_ = fmuId_;
      result.start_ = start_;
      result.stop_ = stop_;
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
      if (other instanceof no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto) {
        return mergeFrom((no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto other) {
      if (other == no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto.getDefaultInstance()) return this;
      if (other.getFmuId() != 0) {
        setFmuId(other.getFmuId());
      }
      if (other.getStart() != 0D) {
        setStart(other.getStart());
      }
      if (other.getStop() != 0D) {
        setStop(other.getStop());
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
      no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto) e.getUnfinishedMessage();
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

    private double start_ ;
    /**
     * <code>double start = 2;</code>
     */
    public double getStart() {
      return start_;
    }
    /**
     * <code>double start = 2;</code>
     */
    public Builder setStart(double value) {
      
      start_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double start = 2;</code>
     */
    public Builder clearStart() {
      
      start_ = 0D;
      onChanged();
      return this;
    }

    private double stop_ ;
    /**
     * <code>double stop = 3;</code>
     */
    public double getStop() {
      return stop_;
    }
    /**
     * <code>double stop = 3;</code>
     */
    public Builder setStop(double value) {
      
      stop_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double stop = 3;</code>
     */
    public Builder clearStop() {
      
      stop_ = 0D;
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


    // @@protoc_insertion_point(builder_scope:no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto)
  }

  // @@protoc_insertion_point(class_scope:no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto)
  private static final no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto();
  }

  public static no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<InitRequestProto>
      PARSER = new com.google.protobuf.AbstractParser<InitRequestProto>() {
    public InitRequestProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new InitRequestProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<InitRequestProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InitRequestProto> getParserForType() {
    return PARSER;
  }

  public no.mechatronics.sfi.fmu_proxy.grpc.InitRequestProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

