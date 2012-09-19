package org.spout.datamap;

import java.nio.charset.Charset;

public enum DataType {

	/**
	 * WARNING: It is required that the Enum constant name to be the same as the
	 * class it represents in order for getType to function!
	 */
	ByteData(0), ShortData(1), IntegerData(2), LongData(3), FloatData(4), DoubleData(5), StringData(6), DataMap(7), DataArray(8);

	public static Charset UTF8 = Charset.forName("UTF-8");

	private final int id;
	private static final DataType[] idLookup = new DataType[9];

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

	public static DataType getType(Data<?> data) {
		return valueOf(data.getClass().getSimpleName());
	}
}
