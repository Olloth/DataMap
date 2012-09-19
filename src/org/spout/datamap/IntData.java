package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public class IntData extends BasicData<Integer> {

	public IntData(Integer value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeInt(this.getValue());
	}

}
