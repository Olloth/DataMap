package org.spout.datamap;

import java.io.IOException;
import java.io.DataOutputStream;

public class ByteData extends BasicData<Byte> {

	public ByteData(Byte value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.write(this.getValue());
	}

}
