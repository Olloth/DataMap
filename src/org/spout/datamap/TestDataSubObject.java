package org.spout.datamap;

public class TestDataSubObject implements DataHolder {

	private DataMap dataMap = new DataMap();

	public TestDataSubObject(int intValue, String stringValue) {
		int[] arrayInts = {1, 203, 44, 103435};
		DataArray dataArray = new DataArray(DataType.INTEGER);
		
		for (int i = 0; i < arrayInts.length; i++ ) {
			dataArray.add(new NumberData(arrayInts[i]));
		} //TODO: Make this not required.
	
		dataMap.put("subInt", new NumberData(intValue));
		dataMap.put("subString", new StringData(stringValue));
		dataMap.put("subArrayInts", dataArray);
		
	}

	@Override
	public DataMap getData() {
		return dataMap;
	}

}
