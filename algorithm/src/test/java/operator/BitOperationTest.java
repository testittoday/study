package operator;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitOperationTest {

	@Test
	public void test() {
		System.out.println(~3);
		assertTrue((576460752303425540l & 576460752303423488l) > 0);
	}

}
