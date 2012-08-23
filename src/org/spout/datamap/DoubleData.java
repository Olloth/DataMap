package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class DoubleData implements Data<Double> {
	
	private final double value;
	
	public DoubleData(double value) {
		this.value = value;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<Double> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
