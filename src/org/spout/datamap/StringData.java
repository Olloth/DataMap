package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public final class StringData extends BasicData<String> {

	/**
	 * Create a new {@link=Data} entry with the given {@link=String} value.
	 * 
	 * @param value to store
	 */
	public StringData(String value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeUTF(this.getValue());
	}

	@Override
	public DataType getType() {
		return DataType.STRING;
	}

}
