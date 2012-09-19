package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public class FloatData extends BasicData<Float> {

	public FloatData(Float value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeFloat(this.getValue());
	}

}
