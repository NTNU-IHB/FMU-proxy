/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.ntnu.ihb.fmuproxy.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2020-09-20")
public enum Status implements org.apache.thrift.TEnum {
  OK_STATUS(0),
  WARNING_STATUS(1),
  DISCARD_STATUS(2),
  ERROR_STATUS(3),
  FATAL_STATUS(4),
  PENDING_STATUS(5);

  private final int value;

  private Status(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static Status findByValue(int value) { 
    switch (value) {
      case 0:
        return OK_STATUS;
      case 1:
        return WARNING_STATUS;
      case 2:
        return DISCARD_STATUS;
      case 3:
        return ERROR_STATUS;
      case 4:
        return FATAL_STATUS;
      case 5:
        return PENDING_STATUS;
      default:
        return null;
    }
  }
}
