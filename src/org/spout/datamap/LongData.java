package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class LongData implements Data<Long> {
	
	private final long value;
	
	public LongData(long value) {
		this.value = value;
	}

	@Override
	public Long getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<Long> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
