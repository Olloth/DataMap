package org.spout.datamap;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public final class DataMap extends HashMap<String, Data> implements DataHolder {

	private static final long serialVersionUID = 4048354559429223022L;

	/**
	 * Create a new {@link=Data} entry that can hold other data entries in a
	 * {@link=Map}.
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
		for (Entry<String, Data> entry : getValue().entrySet()) {
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

	public static DataMap read(DataInputStream is) throws IOException {
		DataMap dataMap = new DataMap();
		boolean hasEntries = true;

		while (hasEntries) {
			// ID number for this entry
			int id = is.readByte();
			// Type for this entry
			DataType type = DataType.getType(id);

			// End of this particular DataMap
			if (type.equals(DataType.END)) {
				hasEntries = false;
				break;
			}

			// The key for this DataMap entry
			String key = is.readUTF();

			// The value for this DataMap entry
			Data value = DataType.read(is, type);
			dataMap.put(key, value);
		}

		return dataMap;
	}
}
