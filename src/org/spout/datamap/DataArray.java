package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataArray<T> extends ArrayList<Data<T>> implements Data<List<Data<T>>>{

	private static final long serialVersionUID = -8651980785416461762L;

	private final DataType dataType;

	/**
	 * Create a new {@link=Data} entry that can hold other data entries in a {@link=List}.
	 * 
	 * @param value to store
	 */
	public DataArray(DataType type) {
		super();
		this.dataType = type;
	}

	@Override
	public List<Data<T>> getValue() {
		return Collections.unmodifiableList(this);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeByte(getEntryType().getId());
		os.writeInt(getValue().size());

		for (Data<T> data : this.getValue()) {
			data.write(os);
		}
	}

	/**
	 * Gets the {@link=DataType} that represents all the entries stored in this list.
	 * 
	 * @return DataType representing the entries in the list.
	 */
	public DataType getEntryType() {
		return dataType;
	}

	@Override
	public DataType getType() {
		return DataType.ARRAY;
	}
}
