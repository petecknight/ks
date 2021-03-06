/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.confluent.examples.streams.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class UserProfile extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1023001266323107863L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserProfile\",\"namespace\":\"io.confluent.examples.streams.avro\",\"fields\":[{\"name\":\"experience\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"region\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserProfile> ENCODER =
      new BinaryMessageEncoder<UserProfile>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserProfile> DECODER =
      new BinaryMessageDecoder<UserProfile>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<UserProfile> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<UserProfile> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<UserProfile> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<UserProfile>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this UserProfile to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a UserProfile from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a UserProfile instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static UserProfile fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String experience;
  @Deprecated public java.lang.String region;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserProfile() {}

  /**
   * All-args constructor.
   * @param experience The new value for experience
   * @param region The new value for region
   */
  public UserProfile(java.lang.String experience, java.lang.String region) {
    this.experience = experience;
    this.region = region;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return experience;
    case 1: return region;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: experience = (java.lang.String)value$; break;
    case 1: region = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'experience' field.
   * @return The value of the 'experience' field.
   */
  public java.lang.String getExperience() {
    return experience;
  }


  /**
   * Sets the value of the 'experience' field.
   * @param value the value to set.
   */
  public void setExperience(java.lang.String value) {
    this.experience = value;
  }

  /**
   * Gets the value of the 'region' field.
   * @return The value of the 'region' field.
   */
  public java.lang.String getRegion() {
    return region;
  }


  /**
   * Sets the value of the 'region' field.
   * @param value the value to set.
   */
  public void setRegion(java.lang.String value) {
    this.region = value;
  }

  /**
   * Creates a new UserProfile RecordBuilder.
   * @return A new UserProfile RecordBuilder
   */
  public static io.confluent.examples.streams.avro.UserProfile.Builder newBuilder() {
    return new io.confluent.examples.streams.avro.UserProfile.Builder();
  }

  /**
   * Creates a new UserProfile RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserProfile RecordBuilder
   */
  public static io.confluent.examples.streams.avro.UserProfile.Builder newBuilder(io.confluent.examples.streams.avro.UserProfile.Builder other) {
    if (other == null) {
      return new io.confluent.examples.streams.avro.UserProfile.Builder();
    } else {
      return new io.confluent.examples.streams.avro.UserProfile.Builder(other);
    }
  }

  /**
   * Creates a new UserProfile RecordBuilder by copying an existing UserProfile instance.
   * @param other The existing instance to copy.
   * @return A new UserProfile RecordBuilder
   */
  public static io.confluent.examples.streams.avro.UserProfile.Builder newBuilder(io.confluent.examples.streams.avro.UserProfile other) {
    if (other == null) {
      return new io.confluent.examples.streams.avro.UserProfile.Builder();
    } else {
      return new io.confluent.examples.streams.avro.UserProfile.Builder(other);
    }
  }

  /**
   * RecordBuilder for UserProfile instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserProfile>
    implements org.apache.avro.data.RecordBuilder<UserProfile> {

    private java.lang.String experience;
    private java.lang.String region;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.confluent.examples.streams.avro.UserProfile.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.experience)) {
        this.experience = data().deepCopy(fields()[0].schema(), other.experience);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.region)) {
        this.region = data().deepCopy(fields()[1].schema(), other.region);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing UserProfile instance
     * @param other The existing instance to copy.
     */
    private Builder(io.confluent.examples.streams.avro.UserProfile other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.experience)) {
        this.experience = data().deepCopy(fields()[0].schema(), other.experience);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.region)) {
        this.region = data().deepCopy(fields()[1].schema(), other.region);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'experience' field.
      * @return The value.
      */
    public java.lang.String getExperience() {
      return experience;
    }


    /**
      * Sets the value of the 'experience' field.
      * @param value The value of 'experience'.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.UserProfile.Builder setExperience(java.lang.String value) {
      validate(fields()[0], value);
      this.experience = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'experience' field has been set.
      * @return True if the 'experience' field has been set, false otherwise.
      */
    public boolean hasExperience() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'experience' field.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.UserProfile.Builder clearExperience() {
      experience = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'region' field.
      * @return The value.
      */
    public java.lang.String getRegion() {
      return region;
    }


    /**
      * Sets the value of the 'region' field.
      * @param value The value of 'region'.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.UserProfile.Builder setRegion(java.lang.String value) {
      validate(fields()[1], value);
      this.region = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'region' field has been set.
      * @return True if the 'region' field has been set, false otherwise.
      */
    public boolean hasRegion() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'region' field.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.UserProfile.Builder clearRegion() {
      region = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserProfile build() {
      try {
        UserProfile record = new UserProfile();
        record.experience = fieldSetFlags()[0] ? this.experience : (java.lang.String) defaultValue(fields()[0]);
        record.region = fieldSetFlags()[1] ? this.region : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserProfile>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserProfile>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserProfile>
    READER$ = (org.apache.avro.io.DatumReader<UserProfile>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.experience == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.experience);
    }

    out.writeString(this.region);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 0) {
        in.readNull();
        this.experience = null;
      } else {
        this.experience = in.readString();
      }

      this.region = in.readString();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 0) {
            in.readNull();
            this.experience = null;
          } else {
            this.experience = in.readString();
          }
          break;

        case 1:
          this.region = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










