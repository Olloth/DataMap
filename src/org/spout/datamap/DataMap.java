package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class DataMap extends HashMap<String, Data<?>> implements Data<HashMap<String, Data<?>>> {

	private static final long serialVersionUID = 4048354559429223022L;
	
	private final int version;
	
	public DataMap(int version) {
		super();
		this.version = version;
	}

	public DataMap() {
		this(0);
	}

	public HashMap<String, Data<?>> getValue() {
		return this;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<HashMap<String, Data<?>>> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
