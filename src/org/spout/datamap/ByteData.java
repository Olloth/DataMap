package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class ByteData implements Data<Byte> {
	
	private final byte value;
	
	public ByteData(byte value) {
		this.value = value;
	}

	@Override
	public Byte getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<Byte> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
