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
public class Order extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3998666663382879581L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Order\",\"namespace\":\"io.confluent.examples.streams.avro\",\"fields\":[{\"name\":\"customer_id\",\"type\":\"long\"},{\"name\":\"product_id\",\"type\":\"long\"},{\"name\":\"time_order_placed_at\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Order> ENCODER =
      new BinaryMessageEncoder<Order>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Order> DECODER =
      new BinaryMessageDecoder<Order>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Order> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Order> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Order> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Order>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Order to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Order from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Order instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Order fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long customer_id;
  @Deprecated public long product_id;
  @Deprecated public long time_order_placed_at;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Order() {}

  /**
   * All-args constructor.
   * @param customer_id The new value for customer_id
   * @param product_id The new value for product_id
   * @param time_order_placed_at The new value for time_order_placed_at
   */
  public Order(java.lang.Long customer_id, java.lang.Long product_id, java.lang.Long time_order_placed_at) {
    this.customer_id = customer_id;
    this.product_id = product_id;
    this.time_order_placed_at = time_order_placed_at;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return customer_id;
    case 1: return product_id;
    case 2: return time_order_placed_at;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: customer_id = (java.lang.Long)value$; break;
    case 1: product_id = (java.lang.Long)value$; break;
    case 2: time_order_placed_at = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'customer_id' field.
   * @return The value of the 'customer_id' field.
   */
  public long getCustomerId() {
    return customer_id;
  }


  /**
   * Sets the value of the 'customer_id' field.
   * @param value the value to set.
   */
  public void setCustomerId(long value) {
    this.customer_id = value;
  }

  /**
   * Gets the value of the 'product_id' field.
   * @return The value of the 'product_id' field.
   */
  public long getProductId() {
    return product_id;
  }


  /**
   * Sets the value of the 'product_id' field.
   * @param value the value to set.
   */
  public void setProductId(long value) {
    this.product_id = value;
  }

  /**
   * Gets the value of the 'time_order_placed_at' field.
   * @return The value of the 'time_order_placed_at' field.
   */
  public long getTimeOrderPlacedAt() {
    return time_order_placed_at;
  }


  /**
   * Sets the value of the 'time_order_placed_at' field.
   * @param value the value to set.
   */
  public void setTimeOrderPlacedAt(long value) {
    this.time_order_placed_at = value;
  }

  /**
   * Creates a new Order RecordBuilder.
   * @return A new Order RecordBuilder
   */
  public static io.confluent.examples.streams.avro.Order.Builder newBuilder() {
    return new io.confluent.examples.streams.avro.Order.Builder();
  }

  /**
   * Creates a new Order RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Order RecordBuilder
   */
  public static io.confluent.examples.streams.avro.Order.Builder newBuilder(io.confluent.examples.streams.avro.Order.Builder other) {
    if (other == null) {
      return new io.confluent.examples.streams.avro.Order.Builder();
    } else {
      return new io.confluent.examples.streams.avro.Order.Builder(other);
    }
  }

  /**
   * Creates a new Order RecordBuilder by copying an existing Order instance.
   * @param other The existing instance to copy.
   * @return A new Order RecordBuilder
   */
  public static io.confluent.examples.streams.avro.Order.Builder newBuilder(io.confluent.examples.streams.avro.Order other) {
    if (other == null) {
      return new io.confluent.examples.streams.avro.Order.Builder();
    } else {
      return new io.confluent.examples.streams.avro.Order.Builder(other);
    }
  }

  /**
   * RecordBuilder for Order instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Order>
    implements org.apache.avro.data.RecordBuilder<Order> {

    private long customer_id;
    private long product_id;
    private long time_order_placed_at;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.confluent.examples.streams.avro.Order.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.customer_id)) {
        this.customer_id = data().deepCopy(fields()[0].schema(), other.customer_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.product_id)) {
        this.product_id = data().deepCopy(fields()[1].schema(), other.product_id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.time_order_placed_at)) {
        this.time_order_placed_at = data().deepCopy(fields()[2].schema(), other.time_order_placed_at);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Order instance
     * @param other The existing instance to copy.
     */
    private Builder(io.confluent.examples.streams.avro.Order other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.customer_id)) {
        this.customer_id = data().deepCopy(fields()[0].schema(), other.customer_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.product_id)) {
        this.product_id = data().deepCopy(fields()[1].schema(), other.product_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.time_order_placed_at)) {
        this.time_order_placed_at = data().deepCopy(fields()[2].schema(), other.time_order_placed_at);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'customer_id' field.
      * @return The value.
      */
    public long getCustomerId() {
      return customer_id;
    }


    /**
      * Sets the value of the 'customer_id' field.
      * @param value The value of 'customer_id'.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.Order.Builder setCustomerId(long value) {
      validate(fields()[0], value);
      this.customer_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'customer_id' field has been set.
      * @return True if the 'customer_id' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'customer_id' field.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.Order.Builder clearCustomerId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'product_id' field.
      * @return The value.
      */
    public long getProductId() {
      return product_id;
    }


    /**
      * Sets the value of the 'product_id' field.
      * @param value The value of 'product_id'.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.Order.Builder setProductId(long value) {
      validate(fields()[1], value);
      this.product_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'product_id' field has been set.
      * @return True if the 'product_id' field has been set, false otherwise.
      */
    public boolean hasProductId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'product_id' field.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.Order.Builder clearProductId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'time_order_placed_at' field.
      * @return The value.
      */
    public long getTimeOrderPlacedAt() {
      return time_order_placed_at;
    }


    /**
      * Sets the value of the 'time_order_placed_at' field.
      * @param value The value of 'time_order_placed_at'.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.Order.Builder setTimeOrderPlacedAt(long value) {
      validate(fields()[2], value);
      this.time_order_placed_at = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'time_order_placed_at' field has been set.
      * @return True if the 'time_order_placed_at' field has been set, false otherwise.
      */
    public boolean hasTimeOrderPlacedAt() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'time_order_placed_at' field.
      * @return This builder.
      */
    public io.confluent.examples.streams.avro.Order.Builder clearTimeOrderPlacedAt() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Order build() {
      try {
        Order record = new Order();
        record.customer_id = fieldSetFlags()[0] ? this.customer_id : (java.lang.Long) defaultValue(fields()[0]);
        record.product_id = fieldSetFlags()[1] ? this.product_id : (java.lang.Long) defaultValue(fields()[1]);
        record.time_order_placed_at = fieldSetFlags()[2] ? this.time_order_placed_at : (java.lang.Long) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Order>
    WRITER$ = (org.apache.avro.io.DatumWriter<Order>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Order>
    READER$ = (org.apache.avro.io.DatumReader<Order>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.customer_id);

    out.writeLong(this.product_id);

    out.writeLong(this.time_order_placed_at);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.customer_id = in.readLong();

      this.product_id = in.readLong();

      this.time_order_placed_at = in.readLong();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.customer_id = in.readLong();
          break;

        case 1:
          this.product_id = in.readLong();
          break;

        case 2:
          this.time_order_placed_at = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










