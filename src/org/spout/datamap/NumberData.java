package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public class NumberData extends BasicData<Number>{
	public NumberData(Number value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		Number value = getValue();
		if (value instanceof Byte) {
			os.writeByte(value.byteValue());
		} else if (value instanceof Short) {
			os.writeShort(value.shortValue());
		} else if (value instanceof Integer) {
			os.writeInt(value.intValue());
		} else if (value instanceof Long) {
			os.writeLong(value.longValue());
		} else if (value instanceof Float) {
			os.writeFloat(value.floatValue());
		} else if (value instanceof Double) {
			os.writeDouble(value.doubleValue());
		} else {
			throw new IllegalStateException("Unknown datatype : " + value);
		}
	}

	@Override
	public DataType getType() {
		Number value = getValue();
		if (value instanceof Byte) {
			return DataType.BYTE;
		} else if (value instanceof Short) {
			return DataType.SHORT;
		} else if (value instanceof Integer) {
			return DataType.INTEGER;
		} else if (value instanceof Long) {
			return DataType.LONG;
		} else if (value instanceof Float) {
			return DataType.FLOAT;
		} else if (value instanceof Double) {
			return DataType.DOUBLE;
		} else {
			throw new IllegalStateException("Unknown datatype : " + value);
		}
	}

	
}
