package org.spout.datamap;

import java.io.DataInputStream;
import java.io.IOException;

public enum DataType {

	BYTE(0),
	SHORT(1),
	INTEGER(2),
	LONG(3),
	FLOAT(4),
	DOUBLE(5),
	STRING(6),
	MAP(7),
	ARRAY(8),
	END(9);

	private final int id;
	private static final DataType[] idLookup = new DataType[10];

	DataType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static DataType getType(int id) {
		if (id < 0 || id > idLookup.length) {
			throw new IllegalArgumentException("Data Type ID out of bounds!");
		}
		return idLookup[id];
	}

	public static Data read(DataInputStream is, DataType type) throws IOException {
		switch (type) {
		case BYTE:
			Byte byteValue = is.readByte();
			return new NumberData(byteValue);
		case SHORT:
			Short shortValue = is.readShort();
			return new NumberData(shortValue);
		case INTEGER:
			Integer intValue = is.readInt();
			return new NumberData(intValue);
		case LONG:
			Long longValue = is.readLong();
			return new NumberData(longValue);
		case FLOAT:
			Float floatValue = is.readFloat();
			return new NumberData(floatValue);
		case DOUBLE:
			Double doubleValue = is.readDouble();
			return new NumberData(doubleValue);
		case STRING:
			String stringValue = is.readUTF();
			return new StringData(stringValue);
		case MAP:
			return DataMap.read(is);
		case ARRAY:
			return DataArray.read(is);
		default:
			return null;
		}
	}
}
