package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DataArray<T> extends ArrayList<Data<T>> implements Data<ArrayList<Data<T>>>{

	private static final long serialVersionUID = -8651980785416461762L;

	private final Class<T> type; 

	public DataArray(Class<T> type) {
		super();
		this.type = type;
	}

	@Override
	public ArrayList<Data<T>> getValue() {
		return this;
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeByte(DataType.valueOf(type.getSimpleName()).getId());

		for (Data<T> data : this.getValue()) {
			data.write(os);
		}
	}

	public Class<T> getType() {
		return type;
	}
}
