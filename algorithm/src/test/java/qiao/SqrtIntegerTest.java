package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class SqrtIntegerTest {

	@Test
	public void testSqrt() {
		assertTrue(SqrtInteger.sqrt(4) == 2);
		assertTrue(SqrtInteger.sqrt(2147483647) == 46340);
	}

}
