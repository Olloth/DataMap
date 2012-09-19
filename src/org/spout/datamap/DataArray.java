package org.spout.datamap;

import java.awt.Window.Type;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataArray extends ArrayList<Data> implements Data {

	private static final long serialVersionUID = -8651980785416461762L;

	private final DataType dataType;

	/**
	 * Create a new {@link=Data} entry that can hold other data entries in a {@link=List}.
	 * 
	 * @param value to store
	 */
	public DataArray(DataType type) {
		super();
		if (type.equals(DataType.END)) {
			throw new IllegalArgumentException("Cannot create a DataArray of DataType.END");
		}
		this.dataType = type;
	}

	@Override
	public List<Data> getValue() {
		return Collections.unmodifiableList(this);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeByte(getEntryType().getId());
		os.writeInt(getValue().size());

		for (Data data : this.getValue()) {
			data.write(os);
		}
	}

	@Override
	public DataType getType() {
		return DataType.ARRAY;
	}

	/**
	 * Gets the {@link=DataType} that represents all the entries stored in this list.
	 * 
	 * @return DataType representing the entries in the list.
	 */
	public DataType getEntryType() {
		return dataType;
	}

	public static DataArray read(DataInputStream is) throws IOException {
		// ID number for this array's type
		int id = is.readByte();
		// Type for this array
		DataType type = DataType.getType(id);

		DataArray dataArray = new DataArray(type);

		// Size of this array
		int size = is.readInt();

		for (int i = 0; i < size; i++) {
			Data value = DataType.read(is, type);
			dataArray.add(value);
		}

		return dataArray;
	}
}
