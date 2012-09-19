package org.spout.datamap;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestDataSuperObject implements DataHolder {

	private DataMap dataMap = new DataMap();
	private TestDataSubObject testSubObject = new TestDataSubObject(-99, "test string here!");
	private TestDataSubObject testSubObjectTwo = new TestDataSubObject(939, "test string here, again!");

	private float[] arrayFloats = {-13.0f, 203.991f, -0.44f, 103435.3F};
	private DataArray dataArray = new DataArray(DataType.FLOAT);

	public TestDataSuperObject() {
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

	@Override
	public DataMap getData() {
		return dataMap;
	}

	@Test
	public void testStringWrite() {
		System.out.println(new TestDataSuperObject());
	}

	@Test
	public void testBinary() {
		TestDataSuperObject test = new TestDataSuperObject();
		
		DataMap testWrite = test.getData();
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		DataOutputStream os = new DataOutputStream(byteOS);

		try {
			testWrite.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ByteArrayInputStream byteIS = new ByteArrayInputStream(byteOS.toByteArray());
		DataInputStream is = new DataInputStream(byteIS);
		
		try {
			DataMap testRead = DataMap.read(is);
			assertTrue(testWrite.toString().equals(testRead.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
