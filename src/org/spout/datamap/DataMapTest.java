package org.spout.datamap;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DataMapTest {

	private DataMap dataMap;

	private TestDataSubObject testSubObject = new TestDataSubObject(-99, "test string here!");
	private TestDataSubObject testSubObjectTwo = new TestDataSubObject(939, "test string here, again!");

	private float[] arrayFloats = {-13.0f, 203.991f, -0.44f, 103435.3F};
	private DataArray dataArray = new DataArray(DataType.FLOAT);

	@Before
	public void setup() {
		dataMap = new DataMap();
		for (int i = 0; i < arrayFloats.length; i++ ) {
			dataArray.add(new NumberData(arrayFloats[i]));
		}

		dataMap.put("testByte", new NumberData((byte) 11));
		dataMap.put("testShort", new NumberData((short) -3924));
		dataMap.put("testInt", new NumberData(1834854));
		dataMap.put("testLong", new NumberData(1838484838L));
		dataMap.put("testFloat", new NumberData(-1.99F));
		dataMap.put("testDouble", new NumberData(334.2234D));
		dataMap.put("testSubObject1", testSubObject.getData());
		dataMap.put("testSubObject2", testSubObjectTwo.getData());
		dataMap.put("testDataArray", dataArray);
	}

	@Test
	public void testPut() {
		dataMap.put("testPut", new NumberData(39));
		assertTrue(dataMap.containsKey("testPut"));
	}

	@Test
	public void testGet() {
		int testInt = (int) dataMap.get("testInt").getValue();
		assertTrue(testInt == 1834854);
	}

	@Test
	public void testReadWrite() {
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		DataOutputStream os = new DataOutputStream(byteOS);

		try {
			dataMap.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ByteArrayInputStream byteIS = new ByteArrayInputStream(byteOS.toByteArray());
		DataInputStream is = new DataInputStream(byteIS);
		
		try {
			DataMap testRead = DataMap.read(is);
			assertTrue(dataMap.toString().equals(testRead.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class TestDataSubObject implements DataHolder {

		private DataMap dataMap = new DataMap();

		public TestDataSubObject(int intValue, String stringValue) {
			int[] arrayInts = {1, 203, 44};
			DataArray dataArray = new DataArray(DataType.INTEGER);
			
			for (int i = 0; i < arrayInts.length; i++ ) {
				dataArray.add(new NumberData(arrayInts[i]));
			}
		
			dataMap.put("subInt", new NumberData(intValue));
			dataMap.put("subString", new StringData(stringValue));
			dataMap.put("subArrayInts", dataArray);
			
		}

		@Override
		public DataMap getData() {
			return dataMap;
		}

	}

}
