package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashTableTest {

	@Test
	public void test() {
		MyHashTable<String, Integer> table = new MyHashTable<String, Integer>(
				10);
		table.put("1", 1);
		assertTrue(1 == table.get("1"));
		table.put("1", 2);
		assertTrue(2 == table.get("1"));
		table.put(null, null);
		assertNull(table.get(null));
		table.put(null, 0);
		assertTrue(0 == table.get(null));
		for (int i = 0; i < 1000; i++) {
			table.put(String.valueOf(i), i);
			assert (i == table.get(String.valueOf(i)));
		}

		for (int i = 0; i < 1000; i++) {
			table.put(String.valueOf(i), i);
			assert (i == table.get(String.valueOf(i)));
			table.remove(String.valueOf(i));
			assert (null == table.get(String.valueOf(i)));
		}
	}

}
