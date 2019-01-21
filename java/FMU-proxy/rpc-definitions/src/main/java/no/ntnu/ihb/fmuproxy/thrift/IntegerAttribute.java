/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.ntnu.ihb.fmuproxy.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-01-21")
public class IntegerAttribute implements org.apache.thrift.TBase<IntegerAttribute, IntegerAttribute._Fields>, java.io.Serializable, Cloneable, Comparable<IntegerAttribute> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IntegerAttribute");

  private static final org.apache.thrift.protocol.TField MIN_FIELD_DESC = new org.apache.thrift.protocol.TField("min", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MAX_FIELD_DESC = new org.apache.thrift.protocol.TField("max", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField START_FIELD_DESC = new org.apache.thrift.protocol.TField("start", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField QUANTITY_FIELD_DESC = new org.apache.thrift.protocol.TField("quantity", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new IntegerAttributeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new IntegerAttributeTupleSchemeFactory();

  public int min; // required
  public int max; // required
  public int start; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String quantity; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MIN((short)1, "min"),
    MAX((short)2, "max"),
    START((short)3, "start"),
    QUANTITY((short)4, "quantity");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MIN
          return MIN;
        case 2: // MAX
          return MAX;
        case 3: // START
          return START;
        case 4: // QUANTITY
          return QUANTITY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __MIN_ISSET_ID = 0;
  private static final int __MAX_ISSET_ID = 1;
  private static final int __START_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MIN, new org.apache.thrift.meta_data.FieldMetaData("min", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MAX, new org.apache.thrift.meta_data.FieldMetaData("max", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.START, new org.apache.thrift.meta_data.FieldMetaData("start", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.QUANTITY, new org.apache.thrift.meta_data.FieldMetaData("quantity", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IntegerAttribute.class, metaDataMap);
  }

  public IntegerAttribute() {
  }

  public IntegerAttribute(
    int min,
    int max,
    int start,
    java.lang.String quantity)
  {
    this();
    this.min = min;
    setMinIsSet(true);
    this.max = max;
    setMaxIsSet(true);
    this.start = start;
    setStartIsSet(true);
    this.quantity = quantity;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IntegerAttribute(IntegerAttribute other) {
    __isset_bitfield = other.__isset_bitfield;
    this.min = other.min;
    this.max = other.max;
    this.start = other.start;
    if (other.isSetQuantity()) {
      this.quantity = other.quantity;
    }
  }

  public IntegerAttribute deepCopy() {
    return new IntegerAttribute(this);
  }

  @Override
  public void clear() {
    setMinIsSet(false);
    this.min = 0;
    setMaxIsSet(false);
    this.max = 0;
    setStartIsSet(false);
    this.start = 0;
    this.quantity = null;
  }

  public int getMin() {
    return this.min;
  }

  public IntegerAttribute setMin(int min) {
    this.min = min;
    setMinIsSet(true);
    return this;
  }

  public void unsetMin() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MIN_ISSET_ID);
  }

  /** Returns true if field min is set (has been assigned a value) and false otherwise */
  public boolean isSetMin() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MIN_ISSET_ID);
  }

  public void setMinIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MIN_ISSET_ID, value);
  }

  public int getMax() {
    return this.max;
  }

  public IntegerAttribute setMax(int max) {
    this.max = max;
    setMaxIsSet(true);
    return this;
  }

  public void unsetMax() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAX_ISSET_ID);
  }

  /** Returns true if field max is set (has been assigned a value) and false otherwise */
  public boolean isSetMax() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAX_ISSET_ID);
  }

  public void setMaxIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAX_ISSET_ID, value);
  }

  public int getStart() {
    return this.start;
  }

  public IntegerAttribute setStart(int start) {
    this.start = start;
    setStartIsSet(true);
    return this;
  }

  public void unsetStart() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __START_ISSET_ID);
  }

  /** Returns true if field start is set (has been assigned a value) and false otherwise */
  public boolean isSetStart() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __START_ISSET_ID);
  }

  public void setStartIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __START_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getQuantity() {
    return this.quantity;
  }

  public IntegerAttribute setQuantity(@org.apache.thrift.annotation.Nullable java.lang.String quantity) {
    this.quantity = quantity;
    return this;
  }

  public void unsetQuantity() {
    this.quantity = null;
  }

  /** Returns true if field quantity is set (has been assigned a value) and false otherwise */
  public boolean isSetQuantity() {
    return this.quantity != null;
  }

  public void setQuantityIsSet(boolean value) {
    if (!value) {
      this.quantity = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case MIN:
      if (value == null) {
        unsetMin();
      } else {
        setMin((java.lang.Integer)value);
      }
      break;

    case MAX:
      if (value == null) {
        unsetMax();
      } else {
        setMax((java.lang.Integer)value);
      }
      break;

    case START:
      if (value == null) {
        unsetStart();
      } else {
        setStart((java.lang.Integer)value);
      }
      break;

    case QUANTITY:
      if (value == null) {
        unsetQuantity();
      } else {
        setQuantity((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MIN:
      return getMin();

    case MAX:
      return getMax();

    case START:
      return getStart();

    case QUANTITY:
      return getQuantity();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MIN:
      return isSetMin();
    case MAX:
      return isSetMax();
    case START:
      return isSetStart();
    case QUANTITY:
      return isSetQuantity();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof IntegerAttribute)
      return this.equals((IntegerAttribute)that);
    return false;
  }

  public boolean equals(IntegerAttribute that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_min = true;
    boolean that_present_min = true;
    if (this_present_min || that_present_min) {
      if (!(this_present_min && that_present_min))
        return false;
      if (this.min != that.min)
        return false;
    }

    boolean this_present_max = true;
    boolean that_present_max = true;
    if (this_present_max || that_present_max) {
      if (!(this_present_max && that_present_max))
        return false;
      if (this.max != that.max)
        return false;
    }

    boolean this_present_start = true;
    boolean that_present_start = true;
    if (this_present_start || that_present_start) {
      if (!(this_present_start && that_present_start))
        return false;
      if (this.start != that.start)
        return false;
    }

    boolean this_present_quantity = true && this.isSetQuantity();
    boolean that_present_quantity = true && that.isSetQuantity();
    if (this_present_quantity || that_present_quantity) {
      if (!(this_present_quantity && that_present_quantity))
        return false;
      if (!this.quantity.equals(that.quantity))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + min;

    hashCode = hashCode * 8191 + max;

    hashCode = hashCode * 8191 + start;

    hashCode = hashCode * 8191 + ((isSetQuantity()) ? 131071 : 524287);
    if (isSetQuantity())
      hashCode = hashCode * 8191 + quantity.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(IntegerAttribute other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetMin()).compareTo(other.isSetMin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.min, other.min);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMax()).compareTo(other.isSetMax());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMax()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max, other.max);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetStart()).compareTo(other.isSetStart());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStart()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.start, other.start);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetQuantity()).compareTo(other.isSetQuantity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuantity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quantity, other.quantity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("IntegerAttribute(");
    boolean first = true;

    sb.append("min:");
    sb.append(this.min);
    first = false;
    if (!first) sb.append(", ");
    sb.append("max:");
    sb.append(this.max);
    first = false;
    if (!first) sb.append(", ");
    sb.append("start:");
    sb.append(this.start);
    first = false;
    if (!first) sb.append(", ");
    sb.append("quantity:");
    if (this.quantity == null) {
      sb.append("null");
    } else {
      sb.append(this.quantity);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class IntegerAttributeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IntegerAttributeStandardScheme getScheme() {
      return new IntegerAttributeStandardScheme();
    }
  }

  private static class IntegerAttributeStandardScheme extends org.apache.thrift.scheme.StandardScheme<IntegerAttribute> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IntegerAttribute struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MIN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.min = iprot.readI32();
              struct.setMinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MAX
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.max = iprot.readI32();
              struct.setMaxIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // START
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.start = iprot.readI32();
              struct.setStartIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // QUANTITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.quantity = iprot.readString();
              struct.setQuantityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, IntegerAttribute struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(MIN_FIELD_DESC);
      oprot.writeI32(struct.min);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MAX_FIELD_DESC);
      oprot.writeI32(struct.max);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(START_FIELD_DESC);
      oprot.writeI32(struct.start);
      oprot.writeFieldEnd();
      if (struct.quantity != null) {
        oprot.writeFieldBegin(QUANTITY_FIELD_DESC);
        oprot.writeString(struct.quantity);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IntegerAttributeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IntegerAttributeTupleScheme getScheme() {
      return new IntegerAttributeTupleScheme();
    }
  }

  private static class IntegerAttributeTupleScheme extends org.apache.thrift.scheme.TupleScheme<IntegerAttribute> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IntegerAttribute struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMin()) {
        optionals.set(0);
      }
      if (struct.isSetMax()) {
        optionals.set(1);
      }
      if (struct.isSetStart()) {
        optionals.set(2);
      }
      if (struct.isSetQuantity()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetMin()) {
        oprot.writeI32(struct.min);
      }
      if (struct.isSetMax()) {
        oprot.writeI32(struct.max);
      }
      if (struct.isSetStart()) {
        oprot.writeI32(struct.start);
      }
      if (struct.isSetQuantity()) {
        oprot.writeString(struct.quantity);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IntegerAttribute struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.min = iprot.readI32();
        struct.setMinIsSet(true);
      }
      if (incoming.get(1)) {
        struct.max = iprot.readI32();
        struct.setMaxIsSet(true);
      }
      if (incoming.get(2)) {
        struct.start = iprot.readI32();
        struct.setStartIsSet(true);
      }
      if (incoming.get(3)) {
        struct.quantity = iprot.readString();
        struct.setQuantityIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

