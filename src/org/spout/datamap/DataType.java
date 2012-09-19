package org.spout.datamap;

public enum DataType {

	BYTE(NumberData.class, 0),
	SHORT(NumberData.class, 1),
	INTEGER(NumberData.class, 2),
	LONG(NumberData.class, 3),
	FLOAT(NumberData.class, 4),
	DOUBLE(NumberData.class, 5),
	STRING(StringData.class, 6),
	MAP(DataMap.class, 7),
	ARRAY(DataArray.class, 8),
	END(Object.class, 9);

	private final int id;
	private final Class<?> typeClass;
	private static final DataType[] idLookup = new DataType[10];

	DataType(Class<?> typeClass, int id) {
		this.typeClass = typeClass;
		this.id = id;
	}

	public Class<?> getTypeClass() {
		return typeClass;
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
