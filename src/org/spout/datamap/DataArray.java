package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DataArray extends ArrayList<Data<?>> implements Data<ArrayList<Data<?>>>{

	private static final long serialVersionUID = -8651980785416461762L;

	public ArrayList<Data<?>> getValue() {
		return this;
	}

	@Override
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Data<ArrayList<Data<?>>> load(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}
}
