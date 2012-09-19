package org.spout.datamap;

import java.io.IOException;
import java.io.DataOutputStream;

public class ShortData extends BasicData<Short> {

	public ShortData(Short value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeShort(this.getValue());
	}

}
