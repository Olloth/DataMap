package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class FloatData implements Data<Float> {
	
	private final float value;
	
	public FloatData(float value) {
		this.value = value;
	}

	@Override
	public Float getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<Float> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
