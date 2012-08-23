package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

public class StringData implements Data<String> {
	
	private final String value;
	
	public StringData(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<String> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
