package org.spout.datamap;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class DataMap extends LinkedHashMap<String, Data> implements Data {

	private static final long serialVersionUID = 4048354559429223022L;
	//TODO: Add smarter puts for all the primitive types.
	//TODO: Implement a DefaultedKey system rather than always raw strings.

	/**
	 * Create a new {@link=Data} entry that can hold other data entries in a
	 * {@link=Map}.
	 */
	public DataMap() {
		super();
	}

	@Override
	public Map<String, Data> getValue() {
		return Collections.unmodifiableMap(this);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		for (Entry<String, Data> entry : getValue().entrySet()) {
			os.writeByte(entry.getValue().getType().getId());
			os.writeUTF(entry.getKey());
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
			if(type == null) {
				throw new IOException("Reading halted! " + id);
			}

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

	@Override
	public String toString() {
		String string = "\n{";
		for (Entry<String, Data> entry : this.getValue().entrySet()) {
			string += "id:" + entry.getValue().getType().getId() + " ";
			string += "key:" + entry.getKey() + " ";
			string += "value:{" + entry.getValue().toString() + "}\n";
		}
		string += "END}";
		return string;
	}
}
