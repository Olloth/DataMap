package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public class NumberData extends BasicData<Number>{
	public NumberData(Byte value) {
		super(value);
	}

	public NumberData(Short value) {
		super(value);
	}

	public NumberData(Integer value) {
		super(value);
	}

	public NumberData(Long value) {
		super(value);
	}

	public NumberData(Float value) {
		super(value);
	}

	public NumberData(Double value) {
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

}
