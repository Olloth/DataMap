package org.spout.datamap;

public enum DataType {

	BYTE(0), SHORT(1), INTEGER(2), LONG(3), FLOAT(4), DOUBLE(5), STRING(6), MAP(7), ARRAY(8), END(9);

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
