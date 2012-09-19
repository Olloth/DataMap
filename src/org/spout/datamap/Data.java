package org.spout.datamap;

import java.io.IOException;
import java.io.DataOutputStream;

/**
 * Represents a specific data entry that is intended for persistence and/or synchronization.
 */
interface Data {

	/**
	 * Get the value being held in this data entry
	 * 
	 * @return value held
	 */
	public Object getValue();

	/**
	 * Writes the data entry out to the given DataOutputStream
	 * 
	 * @param os to write out to
	 * @throws IOException if there is an IOException writing to the stream
	 */
	public void write(DataOutputStream os) throws IOException;

	/**
	 * Get the {@link=DataType} associated with this data entry.
	 * This holds the ID information for the given data type.
	 * 
	 * @return DataType associated
	 */
	public DataType getType();
}
