package org.spout.datamap;

import java.io.DataOutputStream;
import java.io.IOException;

public class DoubleData extends BasicData<Double> {

	public DoubleData(Double value) {
		super(value);
	}

	@Override
	public void write(DataOutputStream os) throws IOException {
		os.writeDouble(this.getValue());
	}

}
