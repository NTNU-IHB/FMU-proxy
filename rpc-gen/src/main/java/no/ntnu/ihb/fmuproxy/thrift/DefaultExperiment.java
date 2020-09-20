/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.ntnu.ihb.fmuproxy.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2020-09-20")
public class DefaultExperiment implements org.apache.thrift.TBase<DefaultExperiment, DefaultExperiment._Fields>, java.io.Serializable, Cloneable, Comparable<DefaultExperiment> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DefaultExperiment");

  private static final org.apache.thrift.protocol.TField START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("startTime", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField STOP_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("stopTime", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField TOLERANCE_FIELD_DESC = new org.apache.thrift.protocol.TField("tolerance", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField STEP_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("stepSize", org.apache.thrift.protocol.TType.DOUBLE, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DefaultExperimentStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DefaultExperimentTupleSchemeFactory();

  private double startTime; // required
  private double stopTime; // required
  private double tolerance; // required
  private double stepSize; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    START_TIME((short)1, "startTime"),
    STOP_TIME((short)2, "stopTime"),
    TOLERANCE((short)3, "tolerance"),
    STEP_SIZE((short)4, "stepSize");

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
        case 1: // START_TIME
          return START_TIME;
        case 2: // STOP_TIME
          return STOP_TIME;
        case 3: // TOLERANCE
          return TOLERANCE;
        case 4: // STEP_SIZE
          return STEP_SIZE;
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
  private static final int __STARTTIME_ISSET_ID = 0;
  private static final int __STOPTIME_ISSET_ID = 1;
  private static final int __TOLERANCE_ISSET_ID = 2;
  private static final int __STEPSIZE_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.START_TIME, new org.apache.thrift.meta_data.FieldMetaData("startTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STOP_TIME, new org.apache.thrift.meta_data.FieldMetaData("stopTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TOLERANCE, new org.apache.thrift.meta_data.FieldMetaData("tolerance", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STEP_SIZE, new org.apache.thrift.meta_data.FieldMetaData("stepSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DefaultExperiment.class, metaDataMap);
  }

  public DefaultExperiment() {
  }

  public DefaultExperiment(
    double startTime,
    double stopTime,
    double tolerance,
    double stepSize)
  {
    this();
    this.startTime = startTime;
    setStartTimeIsSet(true);
    this.stopTime = stopTime;
    setStopTimeIsSet(true);
    this.tolerance = tolerance;
    setToleranceIsSet(true);
    this.stepSize = stepSize;
    setStepSizeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DefaultExperiment(DefaultExperiment other) {
    __isset_bitfield = other.__isset_bitfield;
    this.startTime = other.startTime;
    this.stopTime = other.stopTime;
    this.tolerance = other.tolerance;
    this.stepSize = other.stepSize;
  }

  public DefaultExperiment deepCopy() {
    return new DefaultExperiment(this);
  }

  @Override
  public void clear() {
    setStartTimeIsSet(false);
    this.startTime = 0.0;
    setStopTimeIsSet(false);
    this.stopTime = 0.0;
    setToleranceIsSet(false);
    this.tolerance = 0.0;
    setStepSizeIsSet(false);
    this.stepSize = 0.0;
  }

  public double getStartTime() {
    return this.startTime;
  }

  public DefaultExperiment setStartTime(double startTime) {
    this.startTime = startTime;
    setStartTimeIsSet(true);
    return this;
  }

  public void unsetStartTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STARTTIME_ISSET_ID);
  }

  /** Returns true if field startTime is set (has been assigned a value) and false otherwise */
  public boolean isSetStartTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STARTTIME_ISSET_ID);
  }

  public void setStartTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STARTTIME_ISSET_ID, value);
  }

  public double getStopTime() {
    return this.stopTime;
  }

  public DefaultExperiment setStopTime(double stopTime) {
    this.stopTime = stopTime;
    setStopTimeIsSet(true);
    return this;
  }

  public void unsetStopTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STOPTIME_ISSET_ID);
  }

  /** Returns true if field stopTime is set (has been assigned a value) and false otherwise */
  public boolean isSetStopTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STOPTIME_ISSET_ID);
  }

  public void setStopTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STOPTIME_ISSET_ID, value);
  }

  public double getTolerance() {
    return this.tolerance;
  }

  public DefaultExperiment setTolerance(double tolerance) {
    this.tolerance = tolerance;
    setToleranceIsSet(true);
    return this;
  }

  public void unsetTolerance() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TOLERANCE_ISSET_ID);
  }

  /** Returns true if field tolerance is set (has been assigned a value) and false otherwise */
  public boolean isSetTolerance() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TOLERANCE_ISSET_ID);
  }

  public void setToleranceIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TOLERANCE_ISSET_ID, value);
  }

  public double getStepSize() {
    return this.stepSize;
  }

  public DefaultExperiment setStepSize(double stepSize) {
    this.stepSize = stepSize;
    setStepSizeIsSet(true);
    return this;
  }

  public void unsetStepSize() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STEPSIZE_ISSET_ID);
  }

  /** Returns true if field stepSize is set (has been assigned a value) and false otherwise */
  public boolean isSetStepSize() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STEPSIZE_ISSET_ID);
  }

  public void setStepSizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STEPSIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case START_TIME:
      if (value == null) {
        unsetStartTime();
      } else {
        setStartTime((java.lang.Double)value);
      }
      break;

    case STOP_TIME:
      if (value == null) {
        unsetStopTime();
      } else {
        setStopTime((java.lang.Double)value);
      }
      break;

    case TOLERANCE:
      if (value == null) {
        unsetTolerance();
      } else {
        setTolerance((java.lang.Double)value);
      }
      break;

    case STEP_SIZE:
      if (value == null) {
        unsetStepSize();
      } else {
        setStepSize((java.lang.Double)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case START_TIME:
      return getStartTime();

    case STOP_TIME:
      return getStopTime();

    case TOLERANCE:
      return getTolerance();

    case STEP_SIZE:
      return getStepSize();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case START_TIME:
      return isSetStartTime();
    case STOP_TIME:
      return isSetStopTime();
    case TOLERANCE:
      return isSetTolerance();
    case STEP_SIZE:
      return isSetStepSize();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof DefaultExperiment)
      return this.equals((DefaultExperiment)that);
    return false;
  }

  public boolean equals(DefaultExperiment that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_startTime = true;
    boolean that_present_startTime = true;
    if (this_present_startTime || that_present_startTime) {
      if (!(this_present_startTime && that_present_startTime))
        return false;
      if (this.startTime != that.startTime)
        return false;
    }

    boolean this_present_stopTime = true;
    boolean that_present_stopTime = true;
    if (this_present_stopTime || that_present_stopTime) {
      if (!(this_present_stopTime && that_present_stopTime))
        return false;
      if (this.stopTime != that.stopTime)
        return false;
    }

    boolean this_present_tolerance = true;
    boolean that_present_tolerance = true;
    if (this_present_tolerance || that_present_tolerance) {
      if (!(this_present_tolerance && that_present_tolerance))
        return false;
      if (this.tolerance != that.tolerance)
        return false;
    }

    boolean this_present_stepSize = true;
    boolean that_present_stepSize = true;
    if (this_present_stepSize || that_present_stepSize) {
      if (!(this_present_stepSize && that_present_stepSize))
        return false;
      if (this.stepSize != that.stepSize)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(startTime);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(stopTime);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(tolerance);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(stepSize);

    return hashCode;
  }

  @Override
  public int compareTo(DefaultExperiment other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetStartTime()).compareTo(other.isSetStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startTime, other.startTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetStopTime()).compareTo(other.isSetStopTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStopTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stopTime, other.stopTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTolerance()).compareTo(other.isSetTolerance());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTolerance()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tolerance, other.tolerance);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetStepSize()).compareTo(other.isSetStepSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStepSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stepSize, other.stepSize);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("DefaultExperiment(");
    boolean first = true;

    sb.append("startTime:");
    sb.append(this.startTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("stopTime:");
    sb.append(this.stopTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("tolerance:");
    sb.append(this.tolerance);
    first = false;
    if (!first) sb.append(", ");
    sb.append("stepSize:");
    sb.append(this.stepSize);
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

  private static class DefaultExperimentStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DefaultExperimentStandardScheme getScheme() {
      return new DefaultExperimentStandardScheme();
    }
  }

  private static class DefaultExperimentStandardScheme extends org.apache.thrift.scheme.StandardScheme<DefaultExperiment> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DefaultExperiment struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.startTime = iprot.readDouble();
              struct.setStartTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STOP_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.stopTime = iprot.readDouble();
              struct.setStopTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TOLERANCE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.tolerance = iprot.readDouble();
              struct.setToleranceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STEP_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.stepSize = iprot.readDouble();
              struct.setStepSizeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DefaultExperiment struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(START_TIME_FIELD_DESC);
      oprot.writeDouble(struct.startTime);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STOP_TIME_FIELD_DESC);
      oprot.writeDouble(struct.stopTime);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOLERANCE_FIELD_DESC);
      oprot.writeDouble(struct.tolerance);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STEP_SIZE_FIELD_DESC);
      oprot.writeDouble(struct.stepSize);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DefaultExperimentTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DefaultExperimentTupleScheme getScheme() {
      return new DefaultExperimentTupleScheme();
    }
  }

  private static class DefaultExperimentTupleScheme extends org.apache.thrift.scheme.TupleScheme<DefaultExperiment> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DefaultExperiment struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStartTime()) {
        optionals.set(0);
      }
      if (struct.isSetStopTime()) {
        optionals.set(1);
      }
      if (struct.isSetTolerance()) {
        optionals.set(2);
      }
      if (struct.isSetStepSize()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetStartTime()) {
        oprot.writeDouble(struct.startTime);
      }
      if (struct.isSetStopTime()) {
        oprot.writeDouble(struct.stopTime);
      }
      if (struct.isSetTolerance()) {
        oprot.writeDouble(struct.tolerance);
      }
      if (struct.isSetStepSize()) {
        oprot.writeDouble(struct.stepSize);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DefaultExperiment struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.startTime = iprot.readDouble();
        struct.setStartTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.stopTime = iprot.readDouble();
        struct.setStopTimeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.tolerance = iprot.readDouble();
        struct.setToleranceIsSet(true);
      }
      if (incoming.get(3)) {
        struct.stepSize = iprot.readDouble();
        struct.setStepSizeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

