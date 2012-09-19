package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public class LongData extends BasicData<Long> {

	public LongData(Long value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeLong(this.getValue());
	}

}
