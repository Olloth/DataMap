package org.spout.datamap;

import java.io.IOException;
import java.io.DataOutputStream;

/**
 * Represents a specific data entry that can be sent out via {@link=DataOutputStream},
 * and read to memory via {@link=DataInputStream}.
 * 
 * Can be used to for disk I/O or network I/O.
 *
 * @param <T> Type for the data being stored.
 */
interface Data<T> {

	/**
	 * Get the value being held in this data entry
	 * 
	 * @return value held
	 */
	public T getValue();

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
