package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class IntData implements Data<Integer> {
	
	private final int value;
	
	public IntData(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<Integer> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
