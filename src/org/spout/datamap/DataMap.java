package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public final class DataMap extends HashMap<String, Data<?>> implements DataHolder {

	private static final long serialVersionUID = 4048354559429223022L;
	
	public DataMap() {
		super();
	}

	@Override
	public DataMap getValue() {
		return this;
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		for (Entry<String, Data<?>> entry : this.entrySet()) {
			os.writeUTF(entry.getKey());
			os.writeByte(DataType.getType(entry.getValue()).getId());
			entry.getValue().write(os);
		}
	}
}
