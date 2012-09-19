package org.spout.datamap;

import java.nio.charset.Charset;

public enum DataType {

	/**
	 * WARNING: It is required that the Enum constant name to be the same as the
	 * class it represents in order for getType to function!
	 */
	BYTE(0), SHORT(1), INTEGER(2), LONG(3), FLOAT(4), DOUBLE(5), STRING(6), MAP(7), ARRAY(8), END(9);

	public static Charset UTF8 = Charset.forName("UTF-8");

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
}
