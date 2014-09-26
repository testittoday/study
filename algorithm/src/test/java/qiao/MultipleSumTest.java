package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultipleSumTest {

	@Test
	public void test() {
		int result = MultipleSum.sumOfMultiples(10, new int[] { 3, 5 });
		assertTrue("result: " + result, 23 == result);
		System.out
				.println(MultipleSum.sumOfMultiples(1000, new int[] { 3, 5 }));
	}

}
