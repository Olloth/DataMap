package org.spout.datamap;

import java.io.InputStream;
import java.io.OutputStream;

interface Data<T> {

	/**
	 * Get the value of this data
	 * 
	 * @return value
	 */
	public T getValue();

	public boolean save(OutputStream stream);

	public Data<T> load(InputStream stream);
}
