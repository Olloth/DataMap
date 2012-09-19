package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public final class DataMap extends HashMap<String, Data<?>> implements DataHolder {

	private static final long serialVersionUID = 4048354559429223022L;

	/**
	 * Create a new {@link=Data} entry that can hold other data entries in a {@link=Map}.
	 * 
	 * @param value to store
	 */
	public DataMap() {
		super();
	}

	@Override
	public DataMap getValue() {
		return (DataMap) Collections.unmodifiableMap(this);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		for (Entry<String, Data<?>> entry : getValue().entrySet()) {
			os.writeUTF(entry.getKey());
			os.writeByte(entry.getValue().getType().getId());
			entry.getValue().write(os);
		}
		os.writeByte(DataType.END.getId());
	}

	@Override
	public DataType getType() {
		return DataType.MAP;
	}
}
