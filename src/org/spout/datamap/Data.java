package org.spout.datamap;

import java.io.IOException;
import java.io.DataOutputStream;

interface Data<T> {

	/**
	 * Get the value of this data
	 * 
	 * @return value
	 */
	public T getValue();

	public void write(DataOutputStream os) throws IOException;

	public DataType getType();
}
