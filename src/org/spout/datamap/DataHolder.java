package org.spout.datamap;

/**
 * Represents an object that has a {@link=DataMap} to store its variables for the purposes of persistence and/or synchronization.
 *
 */
public interface DataHolder {

	/**
	 * Gets the DataMap representing data intended for persistence or synchronization.
	 * 
	 * @return the datamap
	 */
	public DataMap getData();
}
