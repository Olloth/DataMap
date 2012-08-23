package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class ShortData implements Data<Short> {
	
	private final short value;
	
	public ShortData(short value) {
		this.value = value;
	}

	@Override
	public Short getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<Short> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
